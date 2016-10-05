package dk.sdu.mmmi.opn.banking.common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import dk.sdu.mmmi.opn.banking.server.Account;

/**
 * Customer who has a name, and ID, and a number of accounts
 * @author ups
 */
public interface ICustomer extends Remote {
	/**
	 * Get the credential of the customer
	 */
	ICredential getCredential() throws RemoteException;
	/**
	 * Get all account associated with the customer 
	 */
	List<Account> getAccounts() throws RemoteException;
	/**
	 * Add a new account for this customer with the given name (account number is automatically generated)
	 * @param positiveInterest the interest to accrue when the balance is positive 
	 * @param negativeInterest the interest to subtract when the balance in negative  
	 * @throws RemoteException 
	 */
	void addAccount(String name, float positiveInterest, float negativeInterest) throws RemoteException;
}
