package blackrock;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class BankAccounts {
	private static final String TEXT =  "I am a {0} account with {1,number,#} units of {2} currency";

    public static void main(String args[] ) throws Exception {

        List<BankAccount> accounts = new ArrayList<BankAccount>();
        accounts.add(new SavingsAccount("USD",3));//Savings
        accounts.add(new SavingsAccount("EUR",2));//Savings
        accounts.add(new CheckingAccount("HUF",100));//Checking
        accounts.add(new CheckingAccount("COP",10000));//Checking
        accounts.add(new BrokerageAccount("GBP",2));//Brokerage
        accounts.add(new BrokerageAccount("INR",600));//Brokerage
        
        accounts.stream().forEach(account -> System.out.println(
        		MessageFormat.format(TEXT,
        				new Object[]{
        						account.getAccountType().getName(),//make this work
        						account.getUnits(),//make this work
        						account.getCurrency()//make this work
        		})));
    }
}

enum AccountType { 
	Savings("Savings"), Checking("Checking"), Brokerage("Brokerage");

	String name;    	
	AccountType(String name) { this.name = name; }
	
	String getName() { return name; }
}
abstract class BankAccount {
	String currency;
	int units;
	AccountType accountType;
	
	BankAccount() {}
	BankAccount(String currency, int units) {
		this.currency = currency;
		this.units = units;
	}
	
	public int getUnits() {
		return units;
	}
	public String getCurrency() { return currency; }
	public AccountType getAccountType() { return accountType; }
}

class SavingsAccount extends BankAccount {
	SavingsAccount(String currency, int units) {
		super(currency, units);
		this.accountType = AccountType.Savings;
	}
}

class CheckingAccount extends BankAccount {
	CheckingAccount(String currency, int units) {
		super(currency, units);
		this.accountType = AccountType.Checking;
	}
}

class BrokerageAccount extends BankAccount {
	BrokerageAccount(String currency, int units) {
		super(currency, units);
		this.accountType = AccountType.Brokerage;
	}
}   
