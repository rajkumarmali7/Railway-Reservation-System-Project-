package RRS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userName;
	private JPasswordField password;
	static JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Log in");
		lblLogin.setBackground(Color.DARK_GRAY);
		lblLogin.setFont(new Font("Dialog", Font.BOLD, 24));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(22, 12, 398, 44);
		contentPane.add(lblLogin);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(22, 70, 98, 26);
		contentPane.add(lblUserName);
		
		userName = new JTextField();
		userName.setBounds(22, 92, 216, 32);
		contentPane.add(userName);
		userName.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(25, 136, 70, 15);
		contentPane.add(lblPassword);
		
		password = new JPasswordField();
		password.setBounds(22, 163, 216, 32);
		contentPane.add(password);
		
		JButton loginButton = new JButton("Log in");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uname=userName.getText();
				char pass[] =password.getPassword();
				String pass1= String.valueOf(pass);
				if(uname.equals("RRS")&& pass1.equals("RRS")) {
					JOptionPane.showMessageDialog(null, "Login Success", "Welcome "+uname, 1);
				//	MainTask obj= new MainTask();
					MainTask.main();
					frame.setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Login is not Success", uname, 1);
				}
			}
		});
		loginButton.setBounds(282, 92, 117, 25);
		contentPane.add(loginButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		cancelButton.setBounds(292, 166, 117, 25);
		contentPane.add(cancelButton);
	}
}
