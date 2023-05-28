package RRS;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class CheckTrainSchedule extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model;
	JScrollPane scrollPane;
	Connection con;
	String column[] = { "ID", "NAME", "SALARY", "Tr" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckTrainSchedule frame = new CheckTrainSchedule();
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
	public CheckTrainSchedule() {
		setTitle("Check Train Schedule");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 784, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Check For Train Schedule");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(50, 0, 722, 27);
		contentPane.add(lblNewLabel);

		JLabel lblTrainName = new JLabel("Departure");
		lblTrainName.setBounds(50, 59, 92, 27);
		contentPane.add(lblTrainName);

		/*
		 * Vector<String> dep = new Vector<String>(); dep.add("-Select-");
		 * dep.add("Delhi"); dep.add("Agra"); dep.add("Jaipur");
		 */
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(150, 60, 166, 24);
		contentPane.add(comboBox);

		JLabel lblArrival = new JLabel("Arrival");
		lblArrival.setBounds(50, 138, 70, 15);
		contentPane.add(lblArrival);

		// String arrival[] = {"-Select-","Delhi","Agra","Jaipur","Banglore"};

		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setSelectedItem("-Select-");
		comboBox_1.setBounds(150, 133, 166, 24);
		contentPane.add(comboBox_1);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railway?autoReconnect=true&useSSL=false",
					"root", "system");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from trainbtw;");
			comboBox.addItem("-Select-");
			comboBox_1.addItem("-Select-");
			while (rs.next()) {
				comboBox.addItem(rs.getString("source"));
				comboBox_1.addItem(rs.getString("des"));
			}

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1);
		}

		JButton btnCheckSchedule = new JButton("Check Schedule");
		btnCheckSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String start = (String) comboBox.getSelectedItem();
				String fin = (String) comboBox_1.getSelectedItem();
				if (start.equals("-Select-")) {
					JOptionPane.showMessageDialog(null, "Select Departure Option.", "Arrival Station Missing", 1);
				}
				if (fin.equals("-Select-")) {
					JOptionPane.showMessageDialog(null, "Select Arrival Option", "Destination Station Missing", 1);
				} else {
					table.repaint();
					model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
					model.setColumnIdentifiers(column);
					table.getColumnModel().getColumn(0).setHeaderValue("Train No");
					table.getColumnModel().getColumn(1).setHeaderValue("Train Name");
					table.getColumnModel().getColumn(2).setHeaderValue("Departure");
					table.getColumnModel().getColumn(3).setHeaderValue("Arrival");
					table.getTableHeader().repaint();
					scrollPane.setViewportView(table);
					Connection con = null;
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						con = DriverManager.getConnection(
								"jdbc:mysql://localhost:3306/railway?autoReconnect=true&useSSL=false", "root",
								"system");
						if (con != null) {
							Statement stmt = con.createStatement();
							ResultSet rs = stmt.executeQuery(
									"SELECT * from trainbtw where (source = '" + start + "' and des = '" + fin + "');");
							int i = 0;
							while (rs.next()) {
								int tn = rs.getInt("tno");
								String tname = rs.getString("tname");
								String strt = rs.getString("source");
								String fnl = rs.getString("des");
								model.addRow(new Object[] { tn, tname, strt, fnl });
								System.out.println(tn + " " + tname + " " + strt + " " + fnl);
								i++;
							}
							System.out.println(i);
							if (i < 1) {
								JOptionPane.showMessageDialog(null, "No Record Found", "Error",
										JOptionPane.ERROR_MESSAGE);
							}
							if (i == 1) {
								JOptionPane.showMessageDialog(null, i + " Record Found");
							} else {
								JOptionPane.showMessageDialog(null, i + " Records Found");
							}
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1);
					}
				}
			}
		});
		btnCheckSchedule.setBounds(28, 223, 145, 25);
		contentPane.add(btnCheckSchedule);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainTask mt = new MainTask();
				mt.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(203, 223, 117, 25);
		contentPane.add(btnBack);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(334, 59, 410, 382);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		model.setColumnIdentifiers(column);
		table.getColumnModel().getColumn(0).setHeaderValue("Train No");
		table.getColumnModel().getColumn(1).setHeaderValue("Train Name");
		table.getColumnModel().getColumn(2).setHeaderValue("Departure");
		table.getColumnModel().getColumn(3).setHeaderValue("Arrival");
		table.getTableHeader().repaint();
		scrollPane.setViewportView(table);
	}
}
