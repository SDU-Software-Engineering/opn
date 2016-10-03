package dk.sdu.mmmi.opn.banking.client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dk.sdu.mmmi.opn.swaggerbank.ApiException;

/**
 * Simple GUI for the banking example 
 * @author ups
 *
 */
public class NiceAndFriendlyGUI {
	
	/**
	 * Default server proposed to user
	 */
	public static final String SERVER_DEFAULT = "http://dotnetcore.ws.nbo.codes";

	/**
	 * Frame for starting window
	 */
	private JFrame frame;
	/**
	 * The user name, for login and create
	 */
	private JTextField txtUsername;
	/**
	 * The user ID number, for login and create
	 */
	private JTextField txtUsernumber;
	/**
	 * The controller layer
	 */
	private BankController controller = BankController.getInstance();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NiceAndFriendlyGUI window = new NiceAndFriendlyGUI();
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
	public NiceAndFriendlyGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		String hostname = JOptionPane.showInputDialog("Server name?",SERVER_DEFAULT);
		controller.connect(hostname);
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the nice and user-friendly bank system");
		lblWelcomeToThe.setBounds(6, 6, 438, 33);
		frame.getContentPane().add(lblWelcomeToThe);
		
		JLabel lblCustomerNumber = new JLabel("Customer number:");
		lblCustomerNumber.setBounds(16, 92, 145, 16);
		frame.getContentPane().add(lblCustomerNumber);
		
		JLabel lblCustomerName = new JLabel("Customer name:");
		lblCustomerName.setBounds(16, 50, 149, 16);
		frame.getContentPane().add(lblCustomerName);
		
		txtUsername = new JTextField();
		txtUsername.setText("username");
		txtUsername.setBounds(150, 44, 134, 28);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtUsernumber = new JTextField();
		txtUsernumber.setText("usernumber");
		txtUsernumber.setBounds(150, 86, 134, 28);
		frame.getContentPane().add(txtUsernumber);
		txtUsernumber.setColumns(10);
		
		final JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(6, 256, 438, 16);
		frame.getContentPane().add(lblStatus);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controller.loginAction(txtUsername.getText(),txtUsernumber.getText(),lblStatus);
				} catch (ApiException exn) {
					System.err.println("Network error: "+exn);
					exn.printStackTrace();
					JOptionPane.showMessageDialog(null, "Network error!");
				}
			}
		});
		btnLogin.setBounds(84, 138, 117, 29);
		frame.getContentPane().add(btnLogin);
		
		JButton btnCreateUser = new JButton("Create user");
		btnCreateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = controller.createAction(txtUsername.getText(),txtUsernumber.getText(),lblStatus);
				txtUsernumber.setText(Integer.toString(id));
				if(id<0) {
					JOptionPane.showMessageDialog(null, "Network error!");
				}
			}
		});
		btnCreateUser.setBounds(234, 138, 117, 29);
		frame.getContentPane().add(btnCreateUser);
						
		JButton btnInterest = new JButton("Accrue interest");
		btnInterest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controller.accrueInterest();
				} catch (ApiException error) {
					System.err.println("Network error: "+error);
					JOptionPane.showMessageDialog(null, "Network error!");
				}
			}
		});
		btnInterest.setBounds(54, 200, 147, 29);
		frame.getContentPane().add(btnInterest);

		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnQuit.setBounds(234, 200, 147, 29);
		frame.getContentPane().add(btnQuit);

	}
}
