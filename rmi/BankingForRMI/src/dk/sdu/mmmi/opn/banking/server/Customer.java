package dk.sdu.mmmi.opn.banking.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import dk.sdu.mmmi.opn.banking.common.Credential;
import dk.sdu.mmmi.opn.banking.common.ICredential;
import dk.sdu.mmmi.opn.banking.common.ICustomer;

/**
 * Customer who has a name, and ID, and a number of accounts
 * @author ups
 */
public class Customer extends UnicastRemoteObject implements ICustomer {

	private ICredential who;
	private List<Account> accounts = new ArrayList<Account>();

	public Customer(String name) throws RemoteException {
		super();
		this.who = new Credential(name, uniqueId.incrementAndGet());
	}

	@Override
	public ICredential getCredential() {
		return who;
	}

	@Override
	public List<Account> getAccounts() {
		return Collections.unmodifiableList(accounts);
	}

	@Override
	public void addAccount(String name, float positiveInterest, float negativeInterest) throws RemoteException {
		accounts.add(new Account(name, positiveInterest, negativeInterest));
	}

	private static final AtomicInteger uniqueId = new AtomicInteger();
}
