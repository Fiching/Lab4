
public class BankAccount {

	private static String name;
	private int accountNumber;
	private int pin;
	private double balance;
	private double transferAmount;
	private double amount;
	private Object toBankAccount;
	
	
	public BankAccount() { }
	
	public BankAccount(String name) {
		this.name = name;
	}
	
	public BankAccount(int accountNumber, int pin) {
		this.accountNumber = accountNumber;
		this.pin = pin;
	}
	
	public BankAccount(int pin, boolean b ) {
		this.pin = pin;	
	}
	
	public BankAccount(double balance) {
		this.balance = balance;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String value) {
		name = value;	
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(int value) {
		accountNumber = value;
	}
	
	public int getPin() {
		return pin;
	}
	
	public void setPin(int value) {
		pin = value;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double value) {
		balance = value;
	}
	
	public double withdraw(double amount) {
	
		if (balance - amount < 0) {
			System.out.println("You don't have enough funds to withdraw that amount");
		}
		else {
			balance = balance - amount;
		}
	
	return balance;
	}
	
	public double deposit(double amount) {
		if (amount < 0) {
			System.out.println("You can't deposit a negative number");
		}
		else {
			balance = balance +amount;
			
		}
		return balance;
	}
	
	public String toString() 
    { 
        return "Name:" + name + " id:" + accountNumber + " pin:" + pin + " balance:$" + balance; 
    }

	
	}
	



