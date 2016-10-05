package dk.sdu.mmmi.opn.banking.client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JSeparator;

/**
 * Simple GUI for the banking example 
 * @author ups
 *
 */
public class ClientNiceAndFriendlyGUI {

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
					ClientNiceAndFriendlyGUI window = new ClientNiceAndFriendlyGUI();
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
	public ClientNiceAndFriendlyGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		String hostname = JOptionPane.showInputDialog("Server name?","localhost");
		try {
			controller.connect(hostname);
		} catch (RemoteException | NotBoundException error) {
			System.err.println("Network error: "+error);
			JOptionPane.showMessageDialog(null, "Could not connect");
			throw new Error("Program terminated");
		}
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
				} catch (RemoteException error) {
					System.err.println("Network error: "+error);
					JOptionPane.showMessageDialog(null, "Network error!");
				}
			}
		});
		btnLogin.setBounds(84, 138, 117, 29);
		frame.getContentPane().add(btnLogin);
		
		JButton btnCreateUser = new JButton("Create user");
		btnCreateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controller.createAction(txtUsername.getText(),txtUsernumber,lblStatus);
				} catch (RemoteException error) {
					System.err.println("Network error: "+error);
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
				} catch (RemoteException error) {
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
