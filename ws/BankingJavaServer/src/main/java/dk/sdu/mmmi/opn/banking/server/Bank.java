package dk.sdu.mmmi.opn.banking.server;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import dk.sdu.mmmi.opn.swaggerbank.model.Account;
import dk.sdu.mmmi.opn.swaggerbank.model.AccountDTO;
import dk.sdu.mmmi.opn.swaggerbank.model.Credential;
import dk.sdu.mmmi.opn.swaggerbank.model.CredentialAndAccount;
import dk.sdu.mmmi.opn.swaggerbank.model.CustomerDTO;
import dk.sdu.mmmi.opn.swaggerbank.model.DepositOrWithdrawDTO;

public class Bank {
	private Map<Credential,CustomerDTO> customers = new HashMap<>();
	private Map<AccountDTO,Float> positiveInterests = new HashMap<>();
	private Map<AccountDTO,Float> negativeInterests = new HashMap<>();
	private AtomicInteger idCustomer = new AtomicInteger();
	private AtomicInteger idAccount = new AtomicInteger();

	public static Bank getInstance() {
		return singleton;
	}
	private static final Bank singleton = new Bank();

	public CustomerDTO createCustomer(String name) {
		// Hack: name has quotes, serialization problem apparently...
		if(name.startsWith("\"") && name.endsWith("\"")) {
			name = name.substring(1, name.length()-1);
			System.out.println("Warning: removing quotes to get "+name);
		}
		Credential credential = new Credential().name(name).id(idCustomer.incrementAndGet());
		CustomerDTO customer = new CustomerDTO().credential(credential);
		customers.put(credential, customer);
		return customer;
	}

	public CustomerDTO login(Credential credential) {
		CustomerDTO customer = customers.get(credential);
		if(customer==null) {
			System.out.println("Warning: unknown customer "+credential);
			System.out.println("Current customers:");
			for(Credential c: customers.keySet()) System.out.println(c);
		}
		return customer;
	}

	public CustomerDTO createAccount(CredentialAndAccount caa) {
		CustomerDTO customer = customers.get(caa.getCredential());
		Account info = caa.getAccount();
		AccountDTO account = new AccountDTO().name(info.getName()).balance(0f).number(idAccount.incrementAndGet());
		positiveInterests.put(account, info.getPositiveInterest());
		negativeInterests.put(account, info.getNegativeInterest());
		customer.addAccountsItem(account);
		return customer;
	}

	public CustomerDTO deposit(DepositOrWithdrawDTO deposit) {
		CustomerDTO customer = customers.get(deposit.getCredential());
		for(AccountDTO account: customer.getAccounts()) {
			if(account.getNumber()==deposit.getAccountId()) {
				account.balance(account.getBalance()+deposit.getAmount());
			}
		}
		return customer;
	}

	public CustomerDTO withdraw(DepositOrWithdrawDTO withdraw) {
		CustomerDTO customer = customers.get(withdraw.getCredential());
		for(AccountDTO account: customer.getAccounts()) {
			if(account.getNumber()==withdraw.getAccountId()) {
				account.balance(account.getBalance()-withdraw.getAmount());
			}
		}
		return customer;
	}
	
}
