package dk.sdu.mmmi.opn.banking.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.atomic.AtomicInteger;

import dk.sdu.mmmi.opn.banking.common.IAccount;

/**
 * Account with balance, name, and number 
 * @author ups
  */
public class Account extends UnicastRemoteObject implements IAccount {
	private float balance;
	private String name;
	private int number;
	private float positiveInterest, negativeInterest;
	
	public Account(String name, float positiveInterest, float negativeInterest) throws RemoteException {
		super();
		this.name = name;
		this.positiveInterest = positiveInterest/100;
		this.negativeInterest = negativeInterest/100;
		this.number = newAccountNumber();
	}
	
	/* (non-Javadoc)
	 * @see dk.sdu.mmmi.opn.banking.model.IAccount#getBalance()
	 */
	@Override
	public float getBalance() {
		return balance;
	}

	/* (non-Javadoc)
	 * @see dk.sdu.mmmi.opn.banking.model.IAccount#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see dk.sdu.mmmi.opn.banking.model.IAccount#deposit(float)
	 */
	@Override
	public void deposit(float amount) {
		balance += amount;
	}

	/* (non-Javadoc)
	 * @see dk.sdu.mmmi.opn.banking.model.IAccount#withdraw(float)
	 */
	@Override
	public void withdraw(float amount) {
		balance -= amount;
	}

	/* (non-Javadoc)
	 * @see dk.sdu.mmmi.opn.banking.model.IAccount#getNumber()
	 */
	@Override
	public int getNumber() {
		return number;
	}
	
	/* (non-Javadoc)
	 * @see dk.sdu.mmmi.opn.banking.model.IAccount#accrueInterest()
	 */
	@Override
	public void accrueInterest() {
		if(balance>=0)
			balance *= (1+positiveInterest);
		else
			balance *= (1-negativeInterest);
	}
	
	/**
	 * Return a new, unique account number
	 */
	private static int newAccountNumber() {
		return nextAccountNumber.incrementAndGet();
	}

	/**
	 * Counter for account numbers
	 */
	private static AtomicInteger nextAccountNumber = new AtomicInteger(1000);

	private static final long serialVersionUID = 5131215546456581132L;
}
