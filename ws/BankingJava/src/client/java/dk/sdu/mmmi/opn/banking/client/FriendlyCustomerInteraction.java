package dk.sdu.mmmi.opn.banking.client;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dk.sdu.mmmi.opn.swaggerbank.ApiException;
import dk.sdu.mmmi.opn.swaggerbank.model.CustomerDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

/**
 * Dialog window for interaction regarding a given customer
 * @author ups
 */
public class FriendlyCustomerInteraction extends JDialog {

	/**
	 * Internal panel for the GUI
	 */
	private final JPanel contentPanel = new JPanel();
	/**
	 * The account number, if any
	 */
	private JTextField txtNumber;
	/**
	 * The account name, if any
	 */
	private JTextField txtName;
	/**
	 * The text area used to display information about all accounts
	 */
	private JTextArea txtrAccounts;
	/**
	 * The controller layer
	 */
	private BankController controller = BankController.getInstance();
	/**
	 * The customer who this dialog manipulates
	 */
	private CustomerDTO customer;
	/**
	 * The amount of money to use for a given operation
	 */
	private JTextField txtAmount;

	/**
	 * Launch the dialog.
	 */
	public static void open(CustomerDTO customer) {
		try {
			FriendlyCustomerInteraction dialog = new FriendlyCustomerInteraction(customer);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @param customer 
	 * @throws RemoteException 
	 */
	public FriendlyCustomerInteraction(CustomerDTO customer) throws RemoteException {
		this.customer = customer;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblCustomerName = new JLabel(customer.getCredential().getName());
			lblCustomerName.setBounds(6, 6, 137, 16);
			contentPanel.add(lblCustomerName);
		}
		{
			JLabel lblCustomerNumber = new JLabel(Integer.toString(customer.getCredential().getId()));
			lblCustomerNumber.setBounds(187, 8, 58, 16);
			contentPanel.add(lblCustomerNumber);
		}
		{
			JLabel lblAccountNumber = new JLabel("Account number:");
			lblAccountNumber.setBounds(6, 139, 137, 16);
			contentPanel.add(lblAccountNumber);
		}
		
		JSeparator separator = new JSeparator();
		separator.setBounds(16, 22, 239, 12);
		contentPanel.add(separator);
		
		txtNumber = new JTextField();
		txtNumber.setText("number");
		txtNumber.setBounds(115, 133, 139, 28);
		contentPanel.add(txtNumber);
		txtNumber.setColumns(10);
		
		JLabel lblAccountName = new JLabel("Account name:");
		lblAccountName.setBounds(6, 37, 122, 16);
		contentPanel.add(lblAccountName);
		
		JLabel lblInterest = new JLabel("Interest (+/-):");
		lblInterest.setBounds(6, 67, 122, 16);
		contentPanel.add(lblInterest);
		
		txtName = new JTextField();
		txtName.setText("name");
		txtName.setBounds(121, 31, 134, 28);
		contentPanel.add(txtName);
		txtName.setColumns(10);
		
		final JTextField interestPos = new JTextField();
		interestPos.setText("1%");
		interestPos.setBounds(121, 62, 50, 28);
		contentPanel.add(interestPos);
		interestPos.setColumns(10);
		
		final JTextField interestNeg = new JTextField();
		interestNeg.setText("10%");
		interestNeg.setBounds(181, 62, 50, 28);
		contentPanel.add(interestNeg);
		interestNeg.setColumns(10);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float positive = BankController.percentage2float(interestPos.getText());
				float negative = BankController.percentage2float(interestNeg.getText());
				try {
					FriendlyCustomerInteraction.this.customer = controller.createAccountAction(FriendlyCustomerInteraction.this.customer,txtName.getText(),positive,negative);
					controller.refreshAccountsAction(FriendlyCustomerInteraction.this.customer,txtrAccounts);
				} catch (ApiException exn) {
					System.err.println("Network error: "+exn);
					exn.printStackTrace();
					JOptionPane.showMessageDialog(null, "Network error!");
				}
			}
		});
		btnCreate.setBounds(61, 91, 117, 29);
		contentPanel.add(btnCreate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(259, 6, 185, 227);
		contentPanel.add(scrollPane);
		
		txtrAccounts = new JTextArea();
		txtrAccounts.setText("Accounts");
		scrollPane.setViewportView(txtrAccounts);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						FriendlyCustomerInteraction.this.dispose();
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		controller.refreshAccountsAction(FriendlyCustomerInteraction.this.customer,txtrAccounts);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//controller.depositAction(FriendlyCustomerInteraction.this.customer,txtNumber.getText(),txtAmount.getText());
				//controller.refreshAccountsAction(FriendlyCustomerInteraction.this.customer,txtrAccounts);
			}
		});
		btnDeposit.setBounds(36, 170, 85, 29);
		contentPanel.add(btnDeposit);
		
		JButton Withdraw = new JButton("Withdraw");
		Withdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//controller.withdrawAction(FriendlyCustomerInteraction.this.customer,txtNumber.getText(),txtAmount.getText());
				//controller.refreshAccountsAction(FriendlyCustomerInteraction.this.customer,txtrAccounts);
			}
		});
		Withdraw.setBounds(133, 170, 90, 29);
		contentPanel.add(Withdraw);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setBounds(10, 211, 61, 16);
		contentPanel.add(lblAmount);
		
		txtAmount = new JTextField();
		txtAmount.setText("number");
		txtAmount.setBounds(115, 205, 134, 28);
		contentPanel.add(txtAmount);
		txtAmount.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(6, 116, 239, 12);
		contentPanel.add(separator_1);
	}
}
