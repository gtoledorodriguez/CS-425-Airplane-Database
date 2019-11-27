import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class changeaddr {

	private JFrame frame;
	private JTextField osnum;
	private JTextField osname;
	private JTextField oapnum;
	private JTextField ocity;
	private JTextField ostate;
	private JTextField ozcode;
	private JTextField nsnum;
	private JTextField nsname;
	private JTextField napnum;
	private JTextField ncity;
	private JTextField nstate;
	private JTextField nzipp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					changeaddr window = new changeaddr();
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
	public changeaddr() {
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
		
		JLabel lblosnum = new JLabel("Enter your Old Street Number:");
		lblosnum.setBounds(16, 18, 199, 16);
		frame.getContentPane().add(lblosnum);
		
		JLabel lblosname = new JLabel("Enter your Old Street Name:");
		lblosname.setBounds(16, 58, 199, 16);
		frame.getContentPane().add(lblosname);
		
		JLabel lbloapnum = new JLabel("Enter your Old Apt Number(if any):");
		lbloapnum.setBounds(16, 99, 229, 16);
		frame.getContentPane().add(lbloapnum);
		
		JLabel lblocity = new JLabel("Enter your Old City:");
		lblocity.setBounds(16, 138, 199, 16);
		frame.getContentPane().add(lblocity);
		
		JLabel lblostate = new JLabel("Enter your Old State:");
		lblostate.setBounds(16, 176, 199, 16);
		frame.getContentPane().add(lblostate);
		
		JLabel lblozip = new JLabel("Enter your Old Zipcode:");
		lblozip.setBounds(16, 216, 199, 16);
		frame.getContentPane().add(lblozip);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(17, 260, 705, 12);
		frame.getContentPane().add(separator);
		
		JLabel lblnsnum = new JLabel("Enter your New Street Number:");
		lblnsnum.setBounds(16, 284, 199, 16);
		frame.getContentPane().add(lblnsnum);
		
		JLabel lblnsname = new JLabel("Enter your New Street Name:");
		lblnsname.setBounds(16, 317, 199, 16);
		frame.getContentPane().add(lblnsname);
		
		JLabel lblnapnum = new JLabel("Enter your New Apt Number(if any):");
		lblnapnum.setBounds(16, 356, 229, 16);
		frame.getContentPane().add(lblnapnum);
		
		JLabel lblncity = new JLabel("Enter your New City:");
		lblncity.setBounds(16, 398, 199, 16);
		frame.getContentPane().add(lblncity);
		
		JLabel lblnstate = new JLabel("Enter your New State:");
		lblnstate.setBounds(16, 438, 199, 16);
		frame.getContentPane().add(lblnstate);
		
		JLabel lblnzipp = new JLabel("Enter your New Zipcode:");
		lblnzipp.setBounds(16, 477, 199, 16);
		frame.getContentPane().add(lblnzipp);
		
		osnum = new JTextField();
		osnum.setBounds(433, 13, 130, 26);
		frame.getContentPane().add(osnum);
		osnum.setColumns(10);
		
		osname = new JTextField();
		osname.setColumns(10);
		osname.setBounds(433, 53, 130, 26);
		frame.getContentPane().add(osname);
		
		oapnum = new JTextField();
		oapnum.setColumns(10);
		oapnum.setBounds(433, 94, 130, 26);
		frame.getContentPane().add(oapnum);
		
		ocity = new JTextField();
		ocity.setColumns(10);
		ocity.setBounds(433, 133, 130, 26);
		frame.getContentPane().add(ocity);
		
		ostate = new JTextField();
		ostate.setColumns(10);
		ostate.setBounds(433, 171, 130, 26);
		frame.getContentPane().add(ostate);
		
		ozcode = new JTextField();
		ozcode.setColumns(10);
		ozcode.setBounds(433, 211, 130, 26);
		frame.getContentPane().add(ozcode);
		
		nsnum = new JTextField();
		nsnum.setColumns(10);
		nsnum.setBounds(433, 279, 130, 26);
		frame.getContentPane().add(nsnum);
		
		nsname = new JTextField();
		nsname.setColumns(10);
		nsname.setBounds(433, 312, 130, 26);
		frame.getContentPane().add(nsname);
		
		napnum = new JTextField();
		napnum.setColumns(10);
		napnum.setBounds(433, 351, 130, 26);
		frame.getContentPane().add(napnum);
		
		ncity = new JTextField();
		ncity.setColumns(10);
		ncity.setBounds(433, 393, 130, 26);
		frame.getContentPane().add(ncity);
		
		nstate = new JTextField();
		nstate.setColumns(10);
		nstate.setBounds(433, 433, 130, 26);
		frame.getContentPane().add(nstate);
		
		nzipp = new JTextField();
		nzipp.setColumns(10);
		nzipp.setBounds(433, 472, 130, 26);
		frame.getContentPane().add(nzipp);
		
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lrun.changeaddress(address.auname.getText(), osnum.getText(), osname.getText(), oapnum.getText(), ocity.getText(), ostate.getText(), ozcode.getText(), nsnum.getText(), nsname.getText(), napnum.getText(), ncity.getText(), nstate.getText(), nzipp.getText());
				address a2 = new address();
				a2.NewScreen();
			}
		});
		btnDone.setBounds(315, 527, 117, 29);
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
					changeaddr window = new changeaddr();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	});
	}
}
