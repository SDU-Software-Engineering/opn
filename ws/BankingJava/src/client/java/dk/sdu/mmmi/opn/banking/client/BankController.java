package dk.sdu.mmmi.opn.banking.client;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import dk.sdu.mmmi.opn.banking.client.FriendlyCustomerInteraction;
import dk.sdu.mmmi.opn.swaggerbank.ApiClient;
import dk.sdu.mmmi.opn.swaggerbank.ApiException;
import dk.sdu.mmmi.opn.swaggerbank.model.Account;
import dk.sdu.mmmi.opn.swaggerbank.model.AccountDTO;
import dk.sdu.mmmi.opn.swaggerbank.model.Credential;
import dk.sdu.mmmi.opn.swaggerbank.model.CredentialAndAccount;
import dk.sdu.mmmi.opn.swaggerbank.model.CustomerDTO;
import dk.sdu.mmmi.opn.swaggerbank.model.DepositOrWithdrawDTO;
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
			return customer.getCredential().getId();
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
	 * @throws ApiException 
	 * @throws RemoteException 
	 */
	public void loginAction(String name, String number, JLabel status) throws ApiException {
		try {
			Credential credential = new Credential().name(name).id(Integer.parseInt(number));
			customer = bank.apiBankLoginPost(credential);
			status.setText("Login OK");
			FriendlyCustomerInteraction.open(customer);
		} catch (NumberFormatException e) {
			status.setText("Illegal number");
		}
	}

	/**
	 * Create an account for the given user
	 * @param current 
	 * @param customer the user
	 * @param name the name of the account
	 * @param positiveInterest the interest to accrue when the balance is positive
	 * @param negativeInterest the interest to subtract when the balance in negative 
	 * @throws ApiException 
	 * @throws RemoteException 
	 */
	public CustomerDTO createAccountAction(CustomerDTO current, String name, float positiveInterest, float negativeInterest) throws ApiException {
		CredentialAndAccount caa = new CredentialAndAccount();
		Credential credential = current.getCredential();
		caa.setCredential(credential);
		Account account = new Account().name(name).positiveInterest(positiveInterest).negativeInterest(negativeInterest);
		caa.setAccount(account);
		return bank.apiBankCreateAccountPost(caa);
	}

	/**
	 * Display all accounts of the given customer in the given text area
	 * @param current 
	 * @param customer the customer
	 * @param area the text area
	 * @throws RemoteException 
	 */
	public void refreshAccountsAction(CustomerDTO current, JTextArea area) {
		StringBuffer text = new StringBuffer();
		for(AccountDTO account: current.getAccounts())
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
	public CustomerDTO withdrawAction(CustomerDTO current, String accountID, String amount) throws ApiException {
		int accountNo = Integer.parseInt(accountID);
		float amountVal = Float.parseFloat(amount);
		for(AccountDTO account: current.getAccounts()) {
			if(account.getNumber()==accountNo) {
				DepositOrWithdrawDTO withdraw = new DepositOrWithdrawDTO().accountId(accountNo).amount(amountVal).credential(current.getCredential());
				return bank.apiBankWithdrawPost(withdraw);
			}
		}
		JOptionPane.showMessageDialog(null, "Illegal account number "+accountNo);
		return current;
	}

	public CustomerDTO depositAction(CustomerDTO current, String accountID, String amount) throws ApiException {
		int accountNo = Integer.parseInt(accountID);
		float amountVal = Float.parseFloat(amount);
		for(AccountDTO account: current.getAccounts()) {
			if(account.getNumber()==accountNo) {
				DepositOrWithdrawDTO withdraw = new DepositOrWithdrawDTO().accountId(accountNo).amount(amountVal).credential(current.getCredential());
				return bank.apiBankDepositPost(withdraw);
			}
		}
		JOptionPane.showMessageDialog(null, "Illegal account number "+accountNo);
		return current;
	}
	/**
	 * Deposit money on the given account of the given customer
	 * @param customer the customer to whom the account belonds
	 * @param accountID the ID of the account as text (must be an integer)
	 * @param amount the amount of monday to deposit as text (must be a float)
	 * @throws RemoteException 
	 */
	public CustomerDTO ZdepositAction(CustomerDTO current, String accountID, String amount) throws ApiException {
		int accountNo = Integer.parseInt(accountID);
		float amountVal = Float.parseFloat(amount);
		for(AccountDTO account: current.getAccounts()) {
			if(account.getNumber()==accountNo) {
				DepositOrWithdrawDTO deposit = new DepositOrWithdrawDTO().accountId(accountNo).amount(amountVal).credential(current.getCredential());
				return bank.apiBankDepositPost(deposit);
			}
		}
		JOptionPane.showMessageDialog(null, "Illegal account number "+accountNo);
		return current;
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
