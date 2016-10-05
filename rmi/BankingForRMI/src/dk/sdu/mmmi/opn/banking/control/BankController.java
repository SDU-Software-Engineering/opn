package dk.sdu.mmmi.opn.banking.control;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dk.sdu.mmmi.opn.banking.server.Bank;
import dk.sdu.mmmi.opn.banking.server.BankException;
import dk.sdu.mmmi.opn.banking.server.BankServer;
import dk.sdu.mmmi.opn.banking.server.Credential;
import dk.sdu.mmmi.opn.banking.server.IAccount;
import dk.sdu.mmmi.opn.banking.server.IBank;
import dk.sdu.mmmi.opn.banking.server.ICredential;
import dk.sdu.mmmi.opn.banking.server.ICustomer;
import dk.sdu.mmmi.opn.banking.view.FriendlyCustomerInteraction;

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
	 * The bank model instance on which operations are made
	 */
	private IBank bank;
	
	/**
	 * Default: create own bank instance
	 * @throws RemoteException 
	 * @throws NotBoundException 
	 */
	public void connect(String server) throws RemoteException, NotBoundException {
		Registry r = LocateRegistry.getRegistry(server, BankServer.PORT);
		bank = (IBank)r.lookup(BankServer.NAME);
	}

	/**
	 * Create a new user
	 * @param name the name of of the user
	 * @param number the ID of the user as a text-string (must be an integer)
	 * @param status JLabel in which feedback can be displayed
	 * @throws RemoteException 
	 * @throws NumberFormatException 
	 */
	public void createAction(String name, JTextField number, JLabel status) throws NumberFormatException, RemoteException {
		ICredential credential = bank.addCustomer(name);
		status.setText("User added");
		number.setText(Integer.toString(credential.getID()));
	}

	/**
	 * Login to the system with the given user
	 * @param name the name of of the user
	 * @param number the ID of the user as a text-string (must be an integer)
	 * @param status JLabel in which feedback can be displayed
	 * @throws RemoteException 
	 */
	public void loginAction(String name, String number, JLabel status) throws RemoteException {
		try {
			ICustomer customer = bank.login(new Credential(name, Integer.parseInt(number)));
			status.setText("Login OK");
			FriendlyCustomerInteraction.open(customer);
		} catch (NumberFormatException e) {
			status.setText("Illegal number");
		} catch (BankException e) {
			status.setText("Could not log in");
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
	public void createAccountAction(ICustomer customer, String name, float positiveInterest, float negativeInterest) throws RemoteException {
		customer.addAccount(name,positiveInterest,negativeInterest);
	}

	/**
	 * Display all accounts of the given customer in the given text area
	 * @param customer the customer
	 * @param area the text area
	 * @throws RemoteException 
	 */
	public void refreshAccountsAction(ICustomer customer, JTextArea area) throws RemoteException {
		StringBuffer text = new StringBuffer();
		for(IAccount account: customer.getAccounts())
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
	public void withdrawAction(ICustomer customer, String accountID, String amount) throws RemoteException {
		int accountNo = Integer.parseInt(accountID);
		float amountVal = Float.parseFloat(amount);
		for(IAccount account: customer.getAccounts()) {
			if(account.getNumber()==accountNo) {
				account.withdraw(amountVal);
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
	public void depositAction(ICustomer customer, String accountID, String amount) throws RemoteException {
		int accountNo = Integer.parseInt(accountID);
		float amountVal = Float.parseFloat(amount);
		for(IAccount account: customer.getAccounts()) {
			if(account.getNumber()==accountNo) {
				account.deposit(amountVal);
				return;
			}
		}
	}

	/**
	 * Placeholder for the action that is invoked when you ask to accrue interest
	 * Functionality: for every account, add positive or negative interest to
	 * the balance of the account.
	 * @throws RemoteException 
	 */
	public void accrueInterest() throws RemoteException {
		bank.accrueInterest();
	}

	public static float percentage2float(String text) {
		if(!text.endsWith("%")) throw new Error("Illegal percentage, must end with %");
		String numberText = text.substring(0,text.length()-1);
		return Float.parseFloat(numberText);
	}

}
