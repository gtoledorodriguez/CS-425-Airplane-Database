import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class modifycc {

	private JFrame frame;
	static JTextField occnum;
	static JTextField ocvv;
	static JTextField oexpm;
	static JTextField oexpy;
	static JTextField osnum;
	static JTextField osname;
	static JTextField oapnum;
	static JTextField ocity;
	static JTextField ostate;
	static JTextField ozcode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modifycc window = new modifycc();
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
	public modifycc() {
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
		
		JLabel lblPreviousCardDetails = new JLabel("Previous Card Details:");
		lblPreviousCardDetails.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblPreviousCardDetails.setBounds(249, 6, 287, 43);
		frame.getContentPane().add(lblPreviousCardDetails);
		
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
		
		JSeparator separator = new JSeparator();
		separator.setBounds(21, 221, 709, 12);
		frame.getContentPane().add(separator);
		
		JLabel lblBillingAddress = new JLabel("Billing Address:");
		lblBillingAddress.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblBillingAddress.setBounds(21, 245, 182, 30);
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
		
		occnum = new JTextField();
		occnum.setBounds(496, 61, 130, 26);
		frame.getContentPane().add(occnum);
		occnum.setColumns(10);
		
		ocvv = new JTextField();
		ocvv.setColumns(10);
		ocvv.setBounds(496, 93, 130, 26);
		frame.getContentPane().add(ocvv);
		
		oexpm = new JTextField();
		oexpm.setColumns(10);
		oexpm.setBounds(496, 132, 130, 26);
		frame.getContentPane().add(oexpm);
		
		oexpy = new JTextField();
		oexpy.setColumns(10);
		oexpy.setBounds(496, 171, 130, 26);
		frame.getContentPane().add(oexpy);
		
		osnum = new JTextField();
		osnum.setColumns(10);
		osnum.setBounds(496, 290, 130, 26);
		frame.getContentPane().add(osnum);
		
		osname = new JTextField();
		osname.setColumns(10);
		osname.setBounds(496, 331, 130, 26);
		frame.getContentPane().add(osname);
		
		oapnum = new JTextField();
		oapnum.setColumns(10);
		oapnum.setBounds(496, 372, 130, 26);
		frame.getContentPane().add(oapnum);
		
		ocity = new JTextField();
		ocity.setColumns(10);
		ocity.setBounds(496, 415, 130, 26);
		frame.getContentPane().add(ocity);
		
		ostate = new JTextField();
		ostate.setColumns(10);
		ostate.setBounds(496, 452, 130, 26);
		frame.getContentPane().add(ostate);
		
		ozcode = new JTextField();
		ozcode.setColumns(10);
		ozcode.setBounds(496, 486, 130, 26);
		frame.getContentPane().add(ozcode);
		
		JButton btnNewCardDetails = new JButton("New Card Details >>");
		btnNewCardDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modifyccnew mcn1 = new modifyccnew();
				mcn1.NewScreen();
			}
		});
		btnNewCardDetails.setBounds(278, 532, 182, 29);
		frame.getContentPane().add(btnNewCardDetails);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/Omesh/Downloads/flight.jpg"));
		lblNewLabel.setBounds(0, 0, 750, 578);
		frame.getContentPane().add(lblNewLabel);
		
		
	}
	
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modifycc window = new modifycc();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	});
	}

}
