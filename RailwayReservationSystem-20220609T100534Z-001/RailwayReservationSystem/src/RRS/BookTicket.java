package RRS;

//import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.HTMLDocument.Iterator;

public class BookTicket extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	DefaultTableModel model;
	Connection con = null;
	private JTextField trainNo;
	private JTextField p_name;
	private JTextField p_phone;
	private JTextField p_age;
	private JTextField traveling_date;
	private JTable table;
	String column[] = { "PNR", "TrainName", "TrainNo","From", "To", "Category","Name", "Phone", "Age", "Sex",
			"Date" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTicket frame = new BookTicket();
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
	public BookTicket() {
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1084, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Book Ticket");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(48, 12, 712, 26);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Provide Train Info");
		lblNewLabel_1.setBounds(48, 64, 179, 15);
		contentPane.add(lblNewLabel_1);

		JLabel lblTrainName = new JLabel("Train Name");
		lblTrainName.setBounds(48, 101, 95, 15);
		contentPane.add(lblTrainName);

		JComboBox<String> trainName = new JComboBox<String>();

		trainName.setBounds(150, 96, 162, 24);
		contentPane.add(trainName);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railway?autoReconnect=true&useSSL=false",
					"root", "system");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select Tname from trainbtw;");
			trainName.addItem("-Select-");
			while (rs.next()) {
				trainName.addItem(rs.getString("Tname"));
			}

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1);
		}

		JLabel lblTrainNo = new JLabel("Train No");
		lblTrainNo.setBounds(48, 128, 70, 29);
		contentPane.add(lblTrainNo);

		trainNo = new JTextField();
		trainNo.setBounds(150, 132, 162, 26);
		contentPane.add(trainNo);
		trainNo.setColumns(10);

		JLabel lblFrom = new JLabel("From");
		lblFrom.setBounds(48, 179, 80, 15);
		contentPane.add(lblFrom);

		JComboBox<String> comboBox_From = new JComboBox<String>();
		comboBox_From.setBounds(150, 170, 162, 24);
		contentPane.add(comboBox_From);

		JLabel lblTo = new JLabel("To");
		lblTo.setBounds(48, 211, 70, 15);
		contentPane.add(lblTo);

		JComboBox<String> comboBox_To = new JComboBox<String>();
		comboBox_To.setBounds(150, 206, 162, 24);
		contentPane.add(comboBox_To);

		JLabel lblCategrie = new JLabel("Categere");
		lblCategrie.setBounds(48, 252, 70, 15);
		contentPane.add(lblCategrie);

		JComboBox<String> comboBox_cat = new JComboBox<String>();
		comboBox_cat.setBounds(150, 247, 162, 24);
		contentPane.add(comboBox_cat);
		comboBox_cat.addItem("-Select-");
		comboBox_cat.addItem("FirstAC");
		comboBox_cat.addItem("SecondAC");
		comboBox_cat.addItem("ThirdAC");
		comboBox_cat.addItem("Sleeper");
		comboBox_cat.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				try {
					if (e.getStateChange() == ItemEvent.SELECTED) {
						Object item = e.getItem();
						if (comboBox_cat.getSelectedItem().equals("-Select-")) {
							JOptionPane.showMessageDialog(null, "Select Valid Category","Message", 3);

						} else {

							Class.forName("com.mysql.cj.jdbc.Driver");
							con = DriverManager.getConnection(
									"jdbc:mysql://localhost:3306/railway?autoReconnect=true&useSSL=false", "root",
									"system");
							Statement stmt1 = con.createStatement();
							// String query="select * from avail where TableNo='"+tno+"' ;";
							ResultSet rs1 = stmt1.executeQuery(
									"select distance_Travlled from stations where Tname='" + item.toString() + "';");
                           rs1.next();
						}
					}

				} catch (Exception e2) { JOptionPane.showMessageDialog(null, e2, "Exception", 1);	}
			}
		});
	

		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setBounds(48, 292, 70, 15);
		contentPane.add(lblNewLabel_2);

		p_name = new JTextField();
		p_name.setBounds(150, 290, 162, 26);
		contentPane.add(p_name);
		p_name.setColumns(10);

		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(48, 329, 70, 15);
		contentPane.add(lblPhone);

		p_phone = new JTextField();
		p_phone.setBounds(150, 327, 162, 26);
		contentPane.add(p_phone);
		p_phone.setColumns(10);

		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(48, 370, 70, 15);
		contentPane.add(lblAge);

		p_age = new JTextField();
		p_age.setBounds(150, 365, 162, 26);
		contentPane.add(p_age);
		p_age.setColumns(10);

		JLabel lblSex = new JLabel("Sex");
		lblSex.setBounds(48, 397, 70, 15);
		contentPane.add(lblSex);

		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(146, 393, 70, 23);
		contentPane.add(rdbtnMale);

		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(219, 393, 99, 23);
		contentPane.add(rdbtnFemale);
 
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnMale);
		group.add(rdbtnFemale);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(48, 423, 70, 26);
		contentPane.add(lblDate);

		traveling_date = new JTextField();
		traveling_date.setBounds(150, 424, 162, 26);
		contentPane.add(traveling_date);
		traveling_date.setColumns(10);

		JButton btnBookTicket = new JButton("Book Ticket");
		btnBookTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String  train_name1 =(String) trainName.getSelectedItem();
				String  train_no1 =(String) trainNo.getText();
				String  from =(String) comboBox_From.getSelectedItem();
				String  to   =(String) comboBox_To.getSelectedItem();
				String  cat  =(String) comboBox_cat.getSelectedItem();
				String  p_name1 = p_name.getText();
				String  p_phone1= p_phone.getText();
				String  p_age1 = p_age.getText();
				String  p_sex =  getSelectedButtonText(group);
				String  t_date = traveling_date.getText();
				
				int i=0;
				try
				{
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/railway?autoReconnect=true&useSSL=false", "root",
						"system");
				Statement stmt1 = con.createStatement();
				String sql= "insert into bookticket (train_name,train_no,t_from,t_to,t_categery,p_name,p_phone,age,sex,travling_date) values ('"+train_name1+"','"+train_no1+"','"+from+"','"+to+"','"+cat+"','"+p_name1+"','"+p_phone1+"','"+p_age1+"','"+p_sex+"','"+t_date+"')";
				i=stmt1.executeUpdate(sql);
				if(i>0)
				{
					JOptionPane.showMessageDialog(null, i+" Record update.", "Confirmation About Database", 1);
				}
				else
				{
					JOptionPane.showMessageDialog(null, i+" Record update.", "Confirmation About Database", 3);
				}
				
				
				ResultSet rs2 = stmt1
						.executeQuery("select * from bookticket order by pnr desc");
				rs2.next();
				JOptionPane.showMessageDialog(null,"Your PNR IS "+rs2.getInt(1) , "PNR", 1);
				rs2.beforeFirst();
				while (rs2.next())
				{
				model.addRow(new Object[]{rs2.getString(1), rs2.getString(2), rs2.getString(3),rs2.getString(4),rs2.getString(5),rs2.getString(6),rs2.getString(7),rs2.getString(8),rs2.getString(9),rs2.getString(10),rs2.getString(11)});
				}
				
				}catch(Exception e3) {
					JOptionPane.showMessageDialog(null, e3, "Exception", 1);
				}
			}
		});
		
		
		
		btnBookTicket.setBounds(44, 482, 115, 25);
		contentPane.add(btnBookTicket);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainTask mt = new MainTask();
				mt.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(209, 482, 73, 25);
		contentPane.add(btnBack);

		JLabel lblNewLabel_3 = new JLabel(new ImageIcon(
				new ImageIcon("Train_Ticket.jpeg").getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT)));
		lblNewLabel_3.setBounds(418, 75, 642, 230);
		contentPane.add(lblNewLabel_3);

		JLabel lblBookedTicket = new JLabel("Booked Ticket");
		lblBookedTicket.setBounds(349, 64, 99, 15);
		contentPane.add(lblBookedTicket);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(326, 317, 733, 190);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setRowHeaderView(table);
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		model.setColumnIdentifiers(column);

		table.getTableHeader().repaint();
		scrollPane.setViewportView(table);
		
		JLabel lblTrainFare = new JLabel("Train Fare");
		lblTrainFare.setBounds(321, 211, 85, 15);
		contentPane.add(lblTrainFare);
		
		JLabel lblWait = new JLabel("Wait..");
		lblWait.setBounds(323, 252, 70, 15);
		contentPane.add(lblWait);

		trainName.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				try {

					if (e.getStateChange() == ItemEvent.SELECTED) {
						Object item = e.getItem();

						if (trainName.getSelectedItem().equals("-Select-")) {
							JOptionPane.showMessageDialog(null, "Select valid Train", "Train Selection", 2);
							comboBox_From.removeAllItems();
							comboBox_To.removeAllItems();
							comboBox_From.addItem("-Select-");
							comboBox_To.addItem("-Select-");
						} else {
							Class.forName("com.mysql.cj.jdbc.Driver");
							con = DriverManager.getConnection(
									"jdbc:mysql://localhost:3306/railway?autoReconnect=true&useSSL=false", "root",
									"system");
							// JOptionPane.showMessageDialog(null,item.toString());
							Statement stmt1 = con.createStatement();
							// String query="select * from avail where TableNo='"+tno+"' ;";
							ResultSet rs1 = stmt1
									.executeQuery("select tno from trainbtw where Tname='" + item.toString() + "';");
							Statement stmt2 = con.createStatement();
							ResultSet rs2 = stmt2
									.executeQuery("select * from stations where Tname='" + item.toString() + "';");

							rs1.next();
							trainNo.setText(rs1.getString("tno"));
							comboBox_From.removeAllItems();
							comboBox_To.removeAllItems();
							comboBox_From.addItem("-Select-");
							comboBox_To.addItem("-Select-");
							while (rs2.next()) {

								comboBox_From.addItem(rs2.getString(2));
								comboBox_To.addItem(rs2.getString(2));

							}
						}
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1, "Exception", 1);
				}

			}
		});
		
		
	}
	public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
}
