package dk.sdu.mmmi.opn.banking.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class BankServer {

	public static final int PORT = 8000;
	public static final String NAME = "bank";

	public static void main(String[] args) {
		try {
			Bank b = new Bank();
			Registry r = LocateRegistry.createRegistry(PORT);
			r.bind(NAME, b);
			System.out.println("Server running on port "+PORT);
		} catch (RemoteException e) {
			System.err.println("Network error: "+e);
			throw new Error("Server terminated");
		} catch (AlreadyBoundException e) {
			System.err.println("Internal error: "+e);
			throw new Error("Server terminated");
		}

	}

}
