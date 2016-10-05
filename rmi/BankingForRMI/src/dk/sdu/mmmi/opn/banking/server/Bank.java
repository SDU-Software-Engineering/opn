package dk.sdu.mmmi.opn.banking.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

import dk.sdu.mmmi.opn.banking.common.BankException;
import dk.sdu.mmmi.opn.banking.common.IAccount;
import dk.sdu.mmmi.opn.banking.common.IBank;
import dk.sdu.mmmi.opn.banking.common.ICredential;
import dk.sdu.mmmi.opn.banking.common.ICustomer;

/**
 * Bank which has a number of customers
 * @author ups
 */
public class Bank extends UnicastRemoteObject implements IBank {

	/**
	 * Customers of the bank
	 */
	Map<ICredential,Customer> customers = new HashMap<ICredential,Customer>();
	
	public Bank() throws RemoteException {
		super();
	}
	
	/**
	 * Given customer name and corresponding ID, give access to that customer
	 */
	@Override
	public ICustomer login(ICredential who) throws BankException {
		Customer customer = customers.get(who);
		if(customer==null) throw new BankException("Unknown customer");
		return customer;
	}

	/**
	 * Add new customer with the given name and ID
	 * @throws RemoteException 
	 */
	@Override
	public ICredential addCustomer(String name) throws RemoteException {
		Customer customer = new Customer(name);
		customers.put(customer.getCredential(),customer);
		return customer.getCredential();
	}

	@Override
	public boolean isOpen() {
		return true;
	}

	@Override
	public void accrueInterest() throws RemoteException {
		for(Customer c: customers.values())
			for(IAccount a: c.getAccounts())
				a.accrueInterest();
	}

	private static final long serialVersionUID = 3970923276356185598L;
}
