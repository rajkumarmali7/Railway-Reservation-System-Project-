package RRS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class CheckingTicket extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pnr;
	private JTable table;
	Connection con = null;
	JScrollPane scrollPane;
	String column[] = { "PNR", "TrainName", "TrainNo", "From", "To", "Category", "Name", "Phone", "Age", "Sex",
			"Date" };
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckingTicket frame = new CheckingTicket();
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
	public CheckingTicket() {
		setTitle("Checking Ticket");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCheckYourAvailability = new JLabel("Check Your Availability");
		lblCheckYourAvailability.setFont(new Font("Dialog", Font.BOLD, 25));
		lblCheckYourAvailability.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckYourAvailability.setBounds(79, 12, 517, 30);
		contentPane.add(lblCheckYourAvailability);

		JLabel lblPnr = new JLabel("PNR");
		lblPnr.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPnr.setBounds(28, 51, 56, 28);
		contentPane.add(lblPnr);

		pnr = new JTextField();
		pnr.setBounds(89, 52, 140, 28);
		contentPane.add(pnr);
		pnr.setColumns(10);

		JButton btnCheck = new JButton("Check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					int con_pnr = Integer.parseInt(pnr.getText());
					
					table.repaint();
					model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
					model.setColumnIdentifiers(column);
					table.getTableHeader().repaint();
					scrollPane.setViewportView(table);
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/railway?autoReconnect=true&useSSL=false", "root",
							"system");
					if (con != null) {
						Statement stmt = con.createStatement();
						ResultSet rs = stmt.executeQuery("SELECT * from bookticket where pnr='" + con_pnr + "'");
						int i = 0;
						while (rs.next()) {
							int PNR = rs.getInt("pnr");
							String TrainName = rs.getString("train_name");
							String TrainNo = rs.getString("train_no");
							String From = rs.getString("t_from");
							String To = rs.getString("t_to");
							String Category = rs.getString("t_categery");
							String Name = rs.getString("p_name");
							String Phone = rs.getString("p_phone");
							String Age = rs.getString("age");
							String Sex = rs.getString("sex");
							String Date = rs.getString("travling_date");

							model.addRow(new Object[] { PNR, TrainName, TrainNo, From, To, Category, Name, Phone, Age,
									Sex, Date });
									System.out.println(PNR+" "+TrainName);
							 i++;
						}
						
						if (i < 1) {
							JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
						}
						else if (i == 1) {
							JOptionPane.showMessageDialog(null, i + " Record Found");
						} else {
							JOptionPane.showMessageDialog(null, i + " Records Found");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Conectin is not  Establish");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnCheck.setBounds(28, 92, 76, 25);
		contentPane.add(btnCheck);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainTask mt = new MainTask();
				mt.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(153, 92, 76, 25);
		contentPane.add(btnBack);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 140, 815, 118);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		model.setColumnIdentifiers(column);

		table.getTableHeader().repaint();
		scrollPane.setViewportView(table);
	}
}
