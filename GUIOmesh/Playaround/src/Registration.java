import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;

public class Registration {

	private JFrame frame;
	static JTextField e_uname;
	private JTextField e_pwd;
	private JTextField e_age;
	private JTextField e_fname;
	private JTextField e_mname;
	private JTextField e_lname;
	private JButton btnDone;
	private JButton btnCancel;
	private JLabel lblNewLabel;
	private JLabel lblr5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 750, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbluname1 = new JLabel("Enter Your Choice of Username:");
		lbluname1.setBounds(23, 33, 216, 16);
		frame.getContentPane().add(lbluname1);
		
		JLabel lblpswd1 = new JLabel("Enter Your Choice of Password:");
		lblpswd1.setBounds(23, 84, 216, 16);
		frame.getContentPane().add(lblpswd1);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(23, 135, 216, 16);
		frame.getContentPane().add(lblAge);
		
		JLabel lblfname = new JLabel("Enter Your First Name:");
		lblfname.setBounds(23, 183, 216, 16);
		frame.getContentPane().add(lblfname);
		
		JLabel lblmname = new JLabel("Enter Your Middle Name:");
		lblmname.setBounds(23, 222, 216, 16);
		frame.getContentPane().add(lblmname);
		
		JLabel lbllname = new JLabel("Enter Your Last Name:");
		lbllname.setBounds(23, 262, 216, 16);
		frame.getContentPane().add(lbllname);
		
		e_uname = new JTextField();
		e_uname.setBounds(309, 28, 262, 26);
		frame.getContentPane().add(e_uname);
		e_uname.setColumns(10);
		
		e_pwd = new JTextField();
		e_pwd.setBounds(309, 79, 262, 26);
		e_pwd.setColumns(10);
		frame.getContentPane().add(e_pwd);
		
		e_age = new JTextField();
		e_age.setBounds(309, 130, 262, 26);
		e_age.setColumns(10);
		frame.getContentPane().add(e_age);
		
		e_fname = new JTextField();
		e_fname.setBounds(309, 178, 262, 26);
		e_fname.setColumns(10);
		frame.getContentPane().add(e_fname);
		
		e_mname = new JTextField();
		e_mname.setBounds(309, 217, 262, 26);
		e_mname.setColumns(10);
		frame.getContentPane().add(e_mname);
		
		e_lname = new JTextField();
		e_lname.setBounds(309, 257, 262, 26);
		e_lname.setColumns(10);
		frame.getContentPane().add(e_lname);
		
		btnDone = new JButton("Done");
		btnDone.setBounds(405, 351, 117, 29);
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = Integer.parseInt(e_age.getText());
				lrun.addcustomer(e_uname.getText(), e_pwd.getText(), a, e_fname.getText(), e_mname.getText(), e_lname.getText());
				supage sp2 = new supage();
				sp2.NewScreen();
			}
		});
		frame.getContentPane().add(btnDone);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(160, 351, 117, 29);
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setBackground(SystemColor.desktop);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				supage sp3 = new supage();
				sp3.NewScreen();
			}
		});
		frame.getContentPane().add(btnCancel);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 750, 578);
		lblNewLabel.setBackground(SystemColor.windowText);
		lblNewLabel.setIcon(new ImageIcon("/Users/Omesh/Downloads/flight.jpg"));
		frame.getContentPane().add(lblNewLabel);
		
		lblr5 = new JLabel("Gone With The Wind");
		lblr5.setBackground(Color.BLACK);
		lblr5.setForeground(Color.BLACK);
		lblr5.setFont(new Font("Bodoni 72 Oldstyle", Font.PLAIN, 46));
		lblr5.setBounds(187, 466, 394, 61);
		frame.getContentPane().add(lblr5);
		
		
		
		
		
		
		
	}
	
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	});
	}
}
