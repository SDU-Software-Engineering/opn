package dk.sdu.mmmi.opn.banking.client;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import dk.sdu.mmmi.opn.banking.client.FriendlyCustomerInteraction;
import dk.sdu.mmmi.opn.swaggerbank.ApiClient;
import dk.sdu.mmmi.opn.swaggerbank.ApiException;
import dk.sdu.mmmi.opn.swaggerbank.model.AccountDTO;
import dk.sdu.mmmi.opn.swaggerbank.model.CustomerDTO;
import io.swagger.client.api.BankApi;

/**
 * Controller for the banking application: one method for each functionality,
 * implemented in terms of operations on the underlying model.
 * Implemented as a singleton class
 * @author ups
 */
public class BankController {

	/**
	 * Singleton pattern
	 */
	private static BankController instance = new BankController();
	
	public static BankController getInstance() {
		return instance;
	}

	/**
	 * The bank server reference
	 */
	private BankApi bank;
	
	/**
	 * Logged in user, if any
	 */
	private CustomerDTO customer;
	
	/**
	 * Default: create own bank instance
	 * @throws RemoteException 
	 * @throws NotBoundException 
	 */
	public void connect(String server) {
		ApiClient connection = new ApiClient();
		connection.setBasePath(server);
		bank = new BankApi(connection);
	}

	/**
	 * Create a new user
	 * @param name the name of of the user
	 * @param number the ID of the user as a text-string (must be an integer)
	 * @param status JLabel in which feedback can be displayed
	 * @throws RemoteException 
	 * @throws NumberFormatException 
	 */
	public int createAction(String name, String number, JLabel status) {
		try {
			customer = bank.apiBankCreatePost(name);
			return customer.getId();
		} catch (ApiException e) {
			e.printStackTrace();
			return -1;
		}
	}

	/**
	 * Login to the system with the given user
	 * @param name the name of of the user
	 * @param number the ID of the user as a text-string (must be an integer)
	 * @param status JLabel in which feedback can be displayed
	 * @throws RemoteException 
	 */
	public void loginAction(String name, String number, JLabel status) {
		try {
			//Credential c = bank.apiBankLo
			//customer = null; //bank.login(new Credential(name, Integer.parseInt(number)));
			status.setText("Login OK");
			FriendlyCustomerInteraction.open(customer);
		} catch (NumberFormatException e) {
			status.setText("Illegal number");
		}
	}

	/**
	 * Create an account for the given user
	 * @param customer the user
	 * @param name the name of the account
	 * @param positiveInterest the interest to accrue when the balance is positive
	 * @param negativeInterest the interest to subtract when the balance in negative 
	 * @throws RemoteException 
	 */
	public void createAccountAction(String name, float positiveInterest, float negativeInterest) {
		//customer.addAccount(name,positiveInterest,negativeInterest);
	}

	/**
	 * Display all accounts of the given customer in the given text area
	 * @param customer the customer
	 * @param area the text area
	 * @throws RemoteException 
	 */
	public void refreshAccountsAction(JTextArea area) {
		StringBuffer text = new StringBuffer();
		for(AccountDTO account: customer.getAccounts())
			text.append(account.getNumber()+" "+account.getName()+": "+account.getBalance()+"\n");
		area.setText(text.toString());
	}

	/**
	 * Withdraw money from the given account of the given customer
	 * @param customer the customer to whom the account belonds
	 * @param accountID the ID of the account as text (must be an integer)
	 * @param amount the amount of monday to withdraw as text (must be a float)
	 * @throws RemoteException 
	 */
	public void withdrawAction(String accountID, String amount) throws ApiException {
		int accountNo = Integer.parseInt(accountID);
		float amountVal = Float.parseFloat(amount);
		for(AccountDTO account: customer.getAccounts()) {
			if(account.getNumber()==accountNo) {
				//account.withdraw(amountVal);
				return;
			}
		}
	}

	/**
	 * Deposit money on the given account of the given customer
	 * @param customer the customer to whom the account belonds
	 * @param accountID the ID of the account as text (must be an integer)
	 * @param amount the amount of monday to deposit as text (must be a float)
	 * @throws RemoteException 
	 */
	public void depositAction(String accountID, String amount) throws ApiException {
		int accountNo = Integer.parseInt(accountID);
		float amountVal = Float.parseFloat(amount);
		for(AccountDTO account: customer.getAccounts()) {
			if(account.getNumber()==accountNo) {
				//account.deposit(amountVal);
				return;
			}
		}
	}

	/**
	 * Placeholder for the action that is invoked when you ask to accrue interest
	 * Functionality: for every account, add positive or negative interest to
	 * the balance of the account.
	 * @throws ApiException 
	 * @throws RemoteException 
	 */
	public void accrueInterest() throws ApiException {
		bank.apiBankAccrueInterestPost();
	}

	public static float percentage2float(String text) {
		if(!text.endsWith("%")) throw new Error("Illegal percentage, must end with %");
		String numberText = text.substring(0,text.length()-1);
		return Float.parseFloat(numberText);
	}

}
