package RRS;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class CheckSeat extends JFrame {
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField trainNo;
	private JTable table;
	JScrollPane scrollPane;
	DefaultTableModel model;
	Connection con=null;
	String column[]={"TrainNo","TrainName","FirstAC","SecondAC","ThirdAC","Sleeper"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckSeat frame = new CheckSeat();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CheckSeat() {
		setTitle("Check Sheet Availability");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,  984, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTrainName = new JLabel("Train Name ");
		lblTrainName.setBounds(44, 12, 84, 25);
		contentPane.add(lblTrainName);
		
		JComboBox<String> trainName = new JComboBox<String>();
		trainName.setBounds(134, 12, 194, 24);
		contentPane.add(trainName);
		
		JLabel lblTrainNo = new JLabel("Train No");
		lblTrainNo.setBounds(44, 53, 70, 15);
		contentPane.add(lblTrainNo);
		
		trainNo = new JTextField();
		trainNo.setBounds(134, 48, 197, 25);
		contentPane.add(trainNo);
		trainNo.setColumns(10);
		
		JButton btnCheckForAvailability = new JButton("Check For Availability");
		btnCheckForAvailability.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tno=trainNo.getText();
				String tn1=(String) trainName.getSelectedItem();
				model=(DefaultTableModel) table.getModel();
				model.setRowCount(0);
				model.setColumnIdentifiers(column);

				/*table.getColumnModel().getColumn(0).setHeaderValue("Train No");
				table.getColumnModel().getColumn(1).setHeaderValue("Train Name");
				table.getColumnModel().getColumn(2).setHeaderValue("FirstAC");
				table.getColumnModel().getColumn(3).setHeaderValue("SecondAC");
				table.getColumnModel().getColumn(4).setHeaderValue("ThirdAC");
				table.getColumnModel().getColumn(5).setHeaderValue("Sleeper");
				table.getTableHeader().repaint();*/
				scrollPane.setViewportView(table);
				
				
				try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/railway?autoReconnect=true&useSSL=false","root","system");
				Statement stmt=con.createStatement();
				//String query="select * from avail where TableNo='"+tno+"' ;";
				ResultSet rs=stmt.executeQuery("select * from trainbtw where tno='"+tno+"' or tname='"+tn1+"' ;");
				while(rs.next()){
				                                                              String tn=rs.getString("tno");
				String tname=rs.getString("tname");
				String fac=rs.getString("FirstAC");
				String sac=rs.getString("SecondAC");
				String tac=rs.getString("ThirdAC");
				String sle=rs.getString("Sleeper");
				model.addRow(new Object[]{tn,tname,fac,sac,tac,sle});
				}
				}catch (Exception e1) {JOptionPane.showMessageDialog(null, e1);}
				
			}
		});
		btnCheckForAvailability.setBounds(44, 107, 184, 25);
		contentPane.add(btnCheckForAvailability);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(new ImageIcon("Sheets.png").getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT)));
		lblNewLabel.setBounds(427, 12, 534, 236);
		contentPane.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 260, 917, 163);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table); 
		
		model=(DefaultTableModel) table.getModel();
		model.setRowCount(0);
		model.setColumnIdentifiers(column);

		table.getColumnModel().getColumn(0).setHeaderValue("Train No");
		table.getColumnModel().getColumn(1).setHeaderValue("Train Name");
		table.getColumnModel().getColumn(2).setHeaderValue("FirstAC");
		table.getColumnModel().getColumn(3).setHeaderValue("SecondAC");
		table.getColumnModel().getColumn(4).setHeaderValue("ThirdAC");
		table.getColumnModel().getColumn(5).setHeaderValue("Sleeper");
		table.getTableHeader().repaint();
		scrollPane.setViewportView(table);
		
		

		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/railway?autoReconnect=true&useSSL=false","root","system");
		Statement stmt=con.createStatement();
		//String query="select * from avail where TableNo='"+tno+"' ;";
		ResultSet rs=stmt.executeQuery("select tname from trainbtw;");
		trainName.addItem("-Select-");
		while(rs.next()){
			trainName.addItem(rs.getString("tname"));
		
		}
		
		}catch (Exception e1) {JOptionPane.showMessageDialog(null, e1);}
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainTask mt = new MainTask();
				mt.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(240, 107, 117, 25);
		contentPane.add(btnBack);
		
		JButton btnBuyTicket = new JButton("Buy Ticket");
		btnBuyTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTicket bt = new BookTicket();
				bt.setVisible(true);
				setVisible(false);
			}
		});
		btnBuyTicket.setBounds(44, 223, 117, 25);
		contentPane.add(btnBuyTicket);
	}
}
