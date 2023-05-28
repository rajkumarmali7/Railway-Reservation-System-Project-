package RRS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Cancel_Ticket extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pnrtxt;
	Connection con = null;
	static Cancel_Ticket frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Cancel_Ticket();
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
	public Cancel_Ticket() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCancelYourTicket = new JLabel("Cancel Your Ticket");
		lblCancelYourTicket.setFont(new Font("Dialog", Font.BOLD, 25));
		lblCancelYourTicket.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancelYourTicket.setBounds(65, 12, 310, 22);
		contentPane.add(lblCancelYourTicket);

		JLabel lblPnr = new JLabel("PNR");
		lblPnr.setBounds(65, 73, 70, 15);
		contentPane.add(lblPnr);

		pnrtxt = new JTextField();
		pnrtxt.setBounds(175, 66, 150, 22);
		contentPane.add(pnrtxt);
		pnrtxt.setColumns(10);

		JButton Cancel = new JButton("Cancel Ticket");
		Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=0;
				try {
					int con_pnr = Integer.parseInt(pnrtxt.getText());
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/railway?autoReconnect=true&useSSL=false", "root", "system");
					if (con != null) {
						Statement stmt = con.createStatement();
					    i= stmt.executeUpdate("delete from bookticket where pnr='" + con_pnr + "'");
					}
					if (i < 1) {
						JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else if (i == 1) {
						JOptionPane.showMessageDialog(null, i + " Record Deleted");
					} else {
						JOptionPane.showMessageDialog(null, i + " Records Deleted");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		Cancel.setBounds(65, 120, 144, 25);
		contentPane.add(Cancel);

		JButton btnHome = new JButton("Back");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainTask mt = new MainTask();
				mt.setVisible(true);
				setVisible(false);
			}
		});
		btnHome.setBounds(221, 120, 117, 25);
		contentPane.add(btnHome);
	}

}
