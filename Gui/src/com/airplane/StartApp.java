package com.airplane;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class StartApp {

	private JFrame frame;
	static JTextField uname;
	private JTextField pswd1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartApp window = new StartApp();
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
	public StartApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lbluname = new JLabel("Username");
		lbluname.setBounds(464, 6, 117, 21);
		lbluname.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lbluname.setForeground(new Color(0, 0, 0));
		frame.getContentPane().add(lbluname);
		
		JLabel lblPswd = new JLabel("Password");
		lblPswd.setBounds(636, 1, 114, 26);
		lblPswd.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		frame.getContentPane().add(lblPswd);
		
		uname = new JTextField();
		uname.setBounds(451, 39, 130, 26);
		frame.getContentPane().add(uname);
		uname.setColumns(10);
		
		pswd1 = new JTextField();
		pswd1.setBounds(620, 39, 130, 26);
		frame.getContentPane().add(pswd1);
		pswd1.setColumns(10);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.setBounds(563, 77, 117, 29);
		btnSignIn.setBackground(new Color(255, 215, 0));
		btnSignIn.setForeground(Color.BLACK);
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Boolean accessed = false;
				
				accessed = lrun.signin(uname.getText(), pswd1.getText());
				if(accessed == true) {
					GUIApp hp = new GUIApp();
					hp.NewScreen();
				} else {
					JOptionPane.showMessageDialog(frame, "No account found");
				}
			}
		});
		frame.getContentPane().add(btnSignIn);
		
		JLabel r1lbl = new JLabel("Don't Have An Account?");
		r1lbl.setBounds(268, 497, 182, 16);
		r1lbl.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		frame.getContentPane().add(r1lbl);
		
		JButton sgnup = new JButton("Sign Up");
		sgnup.setBounds(291, 529, 117, 29);
		sgnup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registration R1 = new Registration();
				R1.NewScreen();
			}
		});
		frame.getContentPane().add(sgnup);
		
		JLabel lblGoneWithThe = new JLabel("Gone With The Wind");
		lblGoneWithThe.setBounds(170, 434, 394, 61);
		lblGoneWithThe.setFont(new Font("Bodoni 72 Oldstyle", Font.PLAIN, 46));
		frame.getContentPane().add(lblGoneWithThe);
		
		JLabel SignIn = new JLabel("New label");
		SignIn.setBounds(0, 1, 750, 572);
		SignIn.setIcon(new ImageIcon("/Users/Omesh/Downloads/flight.jpg"));
		frame.getContentPane().add(SignIn);
		
	}
	

	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartApp window = new StartApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	});
	}
	}