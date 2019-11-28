package com.airplane;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class creditcard {

	private JFrame frame;
	private JTextField ccnum;
	private JTextField cvv;
	private JTextField expm;
	private JTextField expy;
	private JTextField snum;
	private JTextField sname;
	private JTextField apnum;
	private JTextField city;
	private JTextField state;
	private JTextField zcode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					creditcard window = new creditcard();
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
	public creditcard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1100, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblccnum = new JLabel("Enter Your Card Number:");
		lblccnum.setBounds(21, 60, 214, 16);
		frame.getContentPane().add(lblccnum);
		
		JLabel lblcvv = new JLabel("Enter the CVV:");
		lblcvv.setBounds(21, 98, 214, 16);
		frame.getContentPane().add(lblcvv);
		
		JLabel lblemon = new JLabel("Enter the Expiration Month (in Numeric XX):");
		lblemon.setBounds(21, 137, 305, 16);
		frame.getContentPane().add(lblemon);
		
		JLabel lbleyear = new JLabel("Enter The Expiration Year (XXXX):");
		lbleyear.setBounds(21, 176, 214, 16);
		frame.getContentPane().add(lbleyear);
		
		JLabel lblCCDets = new JLabel("Add/Delete Card Details");
		lblCCDets.setBounds(224, 16, 306, 30);
		lblCCDets.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		frame.getContentPane().add(lblCCDets);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(21, 221, 709, 12);
		frame.getContentPane().add(separator);
		
		JLabel lblBillingAddress = new JLabel("Billing Address:");
		lblBillingAddress.setBounds(21, 245, 182, 30);
		lblBillingAddress.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		frame.getContentPane().add(lblBillingAddress);
		
		JLabel lblsnum = new JLabel("Enter Street Number:");
		lblsnum.setBounds(21, 295, 194, 16);
		frame.getContentPane().add(lblsnum);
		
		JLabel lblsname = new JLabel("Enter Street Name:");
		lblsname.setBounds(21, 336, 194, 16);
		frame.getContentPane().add(lblsname);
		
		JLabel lblEnterAptNum = new JLabel("Enter Apt. Num (If Any):");
		lblEnterAptNum.setBounds(21, 377, 194, 16);
		frame.getContentPane().add(lblEnterAptNum);
		
		JLabel lblEnterCity = new JLabel("Enter City:");
		lblEnterCity.setBounds(21, 420, 194, 16);
		frame.getContentPane().add(lblEnterCity);
		
		JLabel lblEnterState = new JLabel("Enter State:");
		lblEnterState.setBounds(21, 457, 194, 16);
		frame.getContentPane().add(lblEnterState);
		
		JLabel lblEnterZipcode = new JLabel("Enter Zipcode:");
		lblEnterZipcode.setBounds(21, 491, 194, 16);
		frame.getContentPane().add(lblEnterZipcode);
		
		ccnum = new JTextField();
		ccnum.setBounds(491, 55, 130, 26);
		frame.getContentPane().add(ccnum);
		ccnum.setColumns(10);
		
		cvv = new JTextField();
		cvv.setBounds(491, 93, 130, 26);
		cvv.setColumns(10);
		frame.getContentPane().add(cvv);
		
		expm = new JTextField();
		expm.setBounds(491, 132, 130, 26);
		expm.setColumns(10);
		frame.getContentPane().add(expm);
		
		expy = new JTextField();
		expy.setBounds(491, 171, 130, 26);
		expy.setColumns(10);
		frame.getContentPane().add(expy);
		
		snum = new JTextField();
		snum.setBounds(491, 290, 130, 26);
		snum.setColumns(10);
		frame.getContentPane().add(snum);
		
		sname = new JTextField();
		sname.setBounds(491, 331, 130, 26);
		sname.setColumns(10);
		frame.getContentPane().add(sname);
		
		apnum = new JTextField();
		apnum.setBounds(491, 372, 130, 26);
		apnum.setColumns(10);
		frame.getContentPane().add(apnum);
		
		city = new JTextField();
		city.setBounds(491, 415, 130, 26);
		city.setColumns(10);
		frame.getContentPane().add(city);
		
		state = new JTextField();
		state.setBounds(491, 452, 130, 26);
		state.setColumns(10);
		frame.getContentPane().add(state);
		
		zcode = new JTextField();
		zcode.setBounds(491, 486, 130, 26);
		zcode.setColumns(10);
		frame.getContentPane().add(zcode);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(0, 765, 117, 29);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				address a6 = new address();
				a6.NewScreen();
			}
		});
		frame.getContentPane().add(btnBack);
		
		JButton btnModifyCard = new JButton("Modify Card");
		btnModifyCard.setBounds(163, 765, 117, 29);
		btnModifyCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modifycc mc1 = new modifycc();
				mc1.NewScreen();
			}
		});
		frame.getContentPane().add(btnModifyCard);
		
		JButton btnAddCc = new JButton("Add Card");
		btnAddCc.setBounds(363, 765, 117, 29);
		btnAddCc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long a = Long.parseLong(ccnum.getText());
				int b = Integer.parseInt(cvv.getText());
				int c = Integer.parseInt(expm.getText());
				int d = Integer.parseInt(expy.getText());
				lrun.addCredit(a, b, c, d, StartApp.uname.getText(), snum.getText(), sname.getText(), apnum.getText(), city.getText(), state.getText(), zcode.getText());
			}
		});
		frame.getContentPane().add(btnAddCc);
		
		JButton btnDeleteCard = new JButton("Delete Card");
		btnDeleteCard.setBounds(576, 765, 117, 29);
		btnDeleteCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long f = Long.parseLong(ccnum.getText());
				lrun.remCC(f);
				
				JOptionPane.showMessageDialog(null,  "Card has been deleted! Click View My Cards to Check. " ,"Delete", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		frame.getContentPane().add(btnDeleteCard);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.setBounds(766, 765, 117, 29);
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIApp hp2 = new GUIApp();
				hp2.NewScreen();
			}
		});
		frame.getContentPane().add(btnFinish);
		
		JTextArea cctarea = new JTextArea();
		cctarea.setBounds(21, 556, 773, 197);
		cctarea.setEditable(false);
		frame.getContentPane().add(cctarea);
		
		JButton btnViewMyCards = new JButton("View My Cards");
		btnViewMyCards.setBounds(878, 612, 163, 30);
		btnViewMyCards.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cctarea.setText(lrun.listCCinfo(StartApp.uname.getText()));
			}
		});
		frame.getContentPane().add(btnViewMyCards);
		
		JLabel lblNewLabel = new JLabel("CCNumber                        Billing Address");
		lblNewLabel.setBounds(21, 519, 773, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 1100, 794);
		frame.getContentPane().add(label);
	}
	
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					creditcard window = new creditcard();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	});
	}

}