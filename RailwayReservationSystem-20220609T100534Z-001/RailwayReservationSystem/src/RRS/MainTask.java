package RRS;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MainTask extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static MainTask frame;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MainTask();
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
	public MainTask() {
		setTitle("MainTask");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel LabelHeading = new JLabel("Indian Railway Online Reservation");
		LabelHeading.setBackground(SystemColor.desktop);
		LabelHeading.setFont(new Font("Dialog", Font.BOLD, 20));
		LabelHeading.setHorizontalAlignment(SwingConstants.CENTER);
		LabelHeading.setBounds(12, 0, 683, 27);
		contentPane.add(LabelHeading);

		JLabel imageLabel = new JLabel(
				new ImageIcon(new ImageIcon("Train2.jpg").getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT)));
		imageLabel.setBounds(5, 25, 700, 130);
		contentPane.add(imageLabel);

		JPanel panel = new JPanel();
		panel.setBounds(12, 167, 706, 91);
		contentPane.add(panel);

		JRadioButton bookTicket = new JRadioButton("Book Ticket");
		panel.add(bookTicket);

		JRadioButton checkTrainSchedule = new JRadioButton("Check Train Schedule");
		panel.add(checkTrainSchedule);

		JRadioButton cancelTicket = new JRadioButton("Cancel Ticket");
		panel.add(cancelTicket);

		JRadioButton checkAvailability = new JRadioButton("Check Availability");
		checkAvailability.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(checkAvailability);

		JRadioButton checkTicket = new JRadioButton("Check Ticket");
		panel.add(checkTicket);

		ButtonGroup bg = new ButtonGroup();
		bg.add(bookTicket);
		bg.add(checkTrainSchedule);
		bg.add(cancelTicket);
		bg.add(checkAvailability);
		bg.add(checkTicket);
		JButton exitButton = new JButton("Exit ");
		exitButton.setMnemonic('E');
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (bookTicket.isSelected()) {
					BookTicket bt = new BookTicket();
					bt.setVisible(true);
					frame.setVisible(false);
				} else if (checkTrainSchedule.isSelected()) {
					CheckTrainSchedule ck = new CheckTrainSchedule();
					ck.setVisible(true);
					setVisible(false);
				} else if (cancelTicket.isSelected()) {
					Cancel_Ticket ct = new Cancel_Ticket();
					ct.setVisible(true);
					setVisible(false);
				} else if (checkAvailability.isSelected()) {
					CheckSeat cs = new CheckSeat();
					cs.setVisible(true);
					setVisible(false);
				} else {
					CheckingTicket ct = new CheckingTicket();
					ct.setVisible(true);
					setVisible(false);
				}
			}
		});
		panel.add(submitButton);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main main = new Main();
				main.setVisible(true);
				setVisible(false);
			}
		});
		panel.add(btnBack);
		panel.add(exitButton);

	}
}
