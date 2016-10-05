package dk.sdu.mmmi.opn.banking.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAccount extends Remote {

	public abstract float getBalance() throws RemoteException;

	public abstract String getName() throws RemoteException;

	public abstract void deposit(float amount) throws RemoteException;

	public abstract void withdraw(float amount) throws RemoteException;

	public abstract int getNumber() throws RemoteException;

	public abstract void accrueInterest() throws RemoteException;

}