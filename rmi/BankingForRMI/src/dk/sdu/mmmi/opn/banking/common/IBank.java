package dk.sdu.mmmi.opn.banking.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Bank which has a number of customers
 * @author ups
 */
public interface IBank extends Remote {
	/**
	 * Check if the bank is open
	 */
	boolean isOpen() throws RemoteException;
	/**
	 * Given customer name and corresponding ID, give access to that customer
	 */
	ICustomer login(ICredential who) throws BankException, RemoteException;
	/**
	 * Add new customer with the given name and ID
	 */
	ICredential addCustomer(String name) throws RemoteException;
	/**
	 * Accrue interest on all accounts
	 */
	void accrueInterest() throws RemoteException;
}
