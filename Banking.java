import java.util.*;

public class Banking {

	public static void main(String[] args) {
		
		boolean exitAppFlag = true;
		int menuOption =0;
		
		Scanner keyboardInput = new Scanner(System.in);
		
		
		while(exitAppFlag) {
			
			
				
				System.out.println("Welcome to the Banking App!");
				System.out.println("Press 1 to create a new bank account.");
				System.out.println("Press 2 to check a bank account's balance.");
				System.out.println("Press 3 to deposit into a bank account.");
				System.out.println("Press 4 to withdraw from a bank account.");
				System.out.println("Press 5 to transfer funds to another account.");
				System.out.println("Press 6 to exit the application");
				
				
				
			switch (keyboardInput.nextInt()) {	
				
			
			case 1: 
				String name = "";
				int bankAccountNumber;
				int pin;
				long initialAmount;
				
				System.out.println("Enter the name for the Account");
				name = keyboardInput.next();
				System.out.println("Enter the bank account number for the Account");
				bankAccountNumber = keyboardInput.nextInt();
				System.out.println("Enter the pin for the Account");
				pin = keyboardInput.nextInt();
				System.out.println("Enter the initial amount for the Account");
				initialAmount = keyboardInput.nextInt();
				
				createBankAccount(name, bankAccountNumber, pin, initialAmount);
				
				
				
				break;
			case 2: 
				break;
			case 3: 
				break;
			case 4: 
				break;
			case 5: 
				break;
			case 6:
				exitAppFlag = false;
				break;
				
				
			
			
				
				
				
			}
			
		}

	}




			public static void createBankAccount(String name, int bankAccountNumber, int pin , double initialAmount) {
				BankAccount myAccount = new BankAccount();
				myAccount.setName(name);
				myAccount.setAccountNumber(bankAccountNumber);
				myAccount.setPin(pin);
				myAccount.setBalance(initialAmount);
				System.out.println(myAccount.getName());
				System.out.println(myAccount.getAccountNumber());
				System.out.println(myAccount.getPin());
				System.out.println(myAccount.getBalance());
				
						
						
						
			}
}