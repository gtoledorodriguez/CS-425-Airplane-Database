import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class modifyccnew {

	private JFrame frame;
	private JTextField nccnum;
	private JTextField ncvv;
	private JTextField nexpm;
	private JTextField nexpy;
	private JTextField nsnum;
	private JTextField nsname;
	private JTextField napnum;
	private JTextField ncity;
	private JTextField nstate;
	private JTextField nzip;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modifyccnew window = new modifyccnew();
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
	public modifyccnew() {
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
		lblEnterZipcode.setBounds(21, 494, 108, 30);
		frame.getContentPane().add(lblEnterZipcode);
		
		nccnum = new JTextField();
		nccnum.setBounds(510, 55, 130, 26);
		frame.getContentPane().add(nccnum);
		nccnum.setColumns(10);
		
		ncvv = new JTextField();
		ncvv.setColumns(10);
		ncvv.setBounds(510, 88, 130, 26);
		frame.getContentPane().add(ncvv);
		
		nexpm = new JTextField();
		nexpm.setColumns(10);
		nexpm.setBounds(510, 132, 130, 26);
		frame.getContentPane().add(nexpm);
		
		nexpy = new JTextField();
		nexpy.setColumns(10);
		nexpy.setBounds(510, 171, 130, 26);
		frame.getContentPane().add(nexpy);
		
		nsnum = new JTextField();
		nsnum.setColumns(10);
		nsnum.setBounds(510, 290, 130, 26);
		frame.getContentPane().add(nsnum);
		
		nsname = new JTextField();
		nsname.setColumns(10);
		nsname.setBounds(510, 331, 130, 26);
		frame.getContentPane().add(nsname);
		
		napnum = new JTextField();
		napnum.setColumns(10);
		napnum.setBounds(510, 372, 130, 26);
		frame.getContentPane().add(napnum);
		
		ncity = new JTextField();
		ncity.setColumns(10);
		ncity.setBounds(510, 415, 130, 26);
		frame.getContentPane().add(ncity);
		
		nstate = new JTextField();
		nstate.setColumns(10);
		nstate.setBounds(510, 452, 130, 26);
		frame.getContentPane().add(nstate);
		
		nzip = new JTextField();
		nzip.setColumns(10);
		nzip.setBounds(510, 496, 130, 26);
		frame.getContentPane().add(nzip);
		
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long g = Long.parseLong(modifycc.occnum.getText());
				int h = Integer.parseInt(modifycc.ocvv.getText());
				int i = Integer.parseInt(modifycc.oexpm.getText());
				int j = Integer.parseInt(modifycc.oexpy.getText());
				long k = Long.parseLong(nccnum.getText());
				int l = Integer.parseInt(ncvv.getText());
				int m = Integer.parseInt(nexpm.getText());
				int n = Integer.parseInt(nexpy.getText());
				lrun.changecredit(supage.uname.getText(), g, h, i, j, modifycc.osnum.getText(), modifycc.osname.getText(), modifycc.oapnum.getText(), modifycc.ocity.getText(), modifycc.ostate.getText(), modifycc.ozcode.getText(), k, l, m, n, nsnum.getText(), nsname.getText(), napnum.getText(), ncity.getText(), nstate.getText(), nzip.getText());
				creditcard cc3 = new creditcard();
				cc3.NewScreen();
			}
		});
		btnDone.setBounds(297, 531, 117, 29);
		frame.getContentPane().add(btnDone);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/Omesh/Downloads/flight.jpg"));
		lblNewLabel.setBounds(0, 0, 750, 578);
		frame.getContentPane().add(lblNewLabel);
	}
	
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modifyccnew window = new modifyccnew();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	});
	}

}
