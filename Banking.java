import java.util.*;

import javax.swing.*;

public class Banking {

	public static void main(String[] args) {
		
		final String[] buttons = {"New Account", "Balance", "Deposit", "Withdraw", "Transfer", "Quit"};
		final int NEWACCOUNT_SELECTION = 0;
		final int BALANCE_SELECTION = 1;
		final int DEPOSIT_SELECTION = 2;
		final int WITHDRAW_SELECTION = 3;
		final int TRANSFER_SELECTION = 4;
		final int QUIT_SELECTION = 5;
		final int X_SELECTION = -1;
		//int value should align with appropriate buttons[] index
		
		boolean exitAppFlag = true;//While true, run program
		int selection = X_SELECTION;
		
		ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
		
		int accountIndex1 = -1;
		int accountIndex2 = -1;
		int accountNumber1 = -1;
		int accountNumber2 = -1;
		
		
		while(exitAppFlag){
			selection = JOptionPane.showOptionDialog(null, "Select an option.", "Banking", 
				 				 JOptionPane.DEFAULT_OPTION, 
				 				 JOptionPane.PLAIN_MESSAGE, 
				 				 null, buttons, X_SELECTION);
			
			/*
			A method for looking up BankAccount objects via account number
			If searching by name is desired, a method is needed to display all accounts in the case of one name matching
				more than one account
			*/
		
			switch(selection){
				case NEWACCOUNT_SELECTION:
					displayString("You chose New Account.","Selection");
					accounts.add(createBankAccount(accounts));
					/*
					TODO
					Prompt for info
					Loop until valid info is provided, or until user cancels
					Call createBankAccount
					*/
					break;
				case BALANCE_SELECTION:
					displayString("You chose Balance.","Selection");
					
					while(accountIndex1 == -1){
						accountNumber1 = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter account number","Enter account number",JOptionPane.QUESTION_MESSAGE));
						if(findAccount(accounts, accountNumber1) == -1){
							JOptionPane.showMessageDialog(
									null, "Unable to locate account.",
									"Error", JOptionPane.ERROR_MESSAGE);
						}
						accountIndex1 = findAccount(accounts, accountNumber1);
					}
					
					
					JOptionPane.showMessageDialog(null, "Your Balance is: " + accounts.get(accountIndex1).getBalance(), "Balance", JOptionPane.QUESTION_MESSAGE);
					
					/*
					TODO
					
					Prompt for account
					Loop until a valid account is provided, or until user cancels
					Call displayString with getBalance
					*/
					break;
				case DEPOSIT_SELECTION:
					displayString("You chose Deposit.","Selection");
					
					accountIndex1 = -1;
					accountNumber1 = -1;
					
					while(accountIndex1 == -1){
						accountNumber1 = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter account number","Enter account number",JOptionPane.QUESTION_MESSAGE));
						if(findAccount(accounts, accountNumber1) == -1){
							JOptionPane.showMessageDialog(
									null, "Unable to locate account.",
									"Error", JOptionPane.ERROR_MESSAGE);
						}
						accountIndex1 = findAccount(accounts, accountNumber1);
					}
					
					double depositAmount = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter amount to deposit","Deposit",JOptionPane.QUESTION_MESSAGE));
					while(depositAmount < 0){
						depositAmount = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter amount to deposit","Deposit",JOptionPane.QUESTION_MESSAGE));
					}
					accounts.get(accountIndex1).deposit(depositAmount);
					/*
					TODO
					Prompt for account
					Loop until a valid account is provided, or until user cancels
					Prompt for amount
					Loop until a valid amount is provided, or until user cancels
					Call deposit
					Call displayString with getBalance
					*/
					break;
				case WITHDRAW_SELECTION:
					displayString("You chose Withdraw.","Selection");
					
					accountIndex1 = -1;
					accountNumber1 = -1;
					
					while(accountIndex1 == -1){
						accountNumber1 = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter account number","Enter account number",JOptionPane.QUESTION_MESSAGE));
						if(findAccount(accounts, accountNumber1) == -1){
							JOptionPane.showMessageDialog(
									null, "Unable to locate account.",
									"Error", JOptionPane.ERROR_MESSAGE);
						}
						accountIndex1 = findAccount(accounts, accountNumber1);
					}
					
					double withdrawAmount = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter amount to withdraw","Withdraw",JOptionPane.QUESTION_MESSAGE));
					while(withdrawAmount < 0){
						depositAmount = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter amount to Withdraw","Withdraw",JOptionPane.QUESTION_MESSAGE));
					}
					accounts.get(accountIndex1).withdraw(withdrawAmount);
					
					
					/*
					TODO
					Prompt for account
					Loop until a valid account is provided, or until user cancels
					Prompt for amount
					Loop until a valid amount is provided, or until user cancels
					Call withdraw
					Call displayString with getBalance
					*/
					/*JOptionPane.showMessageDialog(
							null, "Unable to locate account.",
							"Error", JOptionPane.ERROR_MESSAGE);
							*/
					break;
				case TRANSFER_SELECTION:
					displayString("You chose Transfer.","Selection");
					
					accountIndex1 = -1;
					accountNumber1 = -1;
					
					while(accountIndex1 == -1){
						accountNumber1 = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter account number","Enter account number",JOptionPane.QUESTION_MESSAGE));
						if(findAccount(accounts, accountNumber1) == -1){
							JOptionPane.showMessageDialog(
									null, "Unable to locate account.",
									"Error", JOptionPane.ERROR_MESSAGE);
						}
						accountIndex1 = findAccount(accounts, accountNumber1);
					}
					
					accountIndex2 = -1;
					accountNumber2 = -1;
					
					while(accountIndex1 == -1){
						accountNumber2 = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter account number","Enter account number",JOptionPane.QUESTION_MESSAGE));
						if(findAccount(accounts, accountNumber2) == -1){
							JOptionPane.showMessageDialog(
									null, "Unable to locate account.",
									"Error", JOptionPane.ERROR_MESSAGE);
						}
						accountIndex2 = findAccount(accounts, accountNumber2);
					}
					
					accounts.get(accountIndex1).transfer(Double.parseDouble(JOptionPane.showInputDialog(null,"Enter transfer amount: ","Transfer",JOptionPane.QUESTION_MESSAGE)) , accounts.get(accountIndex2));
					/*
					TODO
					Prompt for account 1
					Loop until a valid account is provided, or until user cancels
					Prompt for amount
					Loop until a valid amount is provided, or until user cancels
					Prompt for account 2
					Loop until a valid account is provided, or until user cancels
					Call transfer
					Call displayString with getBalance for account 1
					Call displayString with getBalance for account 2
					*/
					break;
				case QUIT_SELECTION:
					displayString("You chose Quit.","Selection");
					exitAppFlag = false;
					break;
				case X_SELECTION:
					displayString("You chose X.","Selection");
					exitAppFlag = false;
					break;
			}
		
		}

	}
	
	public static void displayString(String message, String title){
		JOptionPane.showMessageDialog(
				null, message,
				title, JOptionPane.PLAIN_MESSAGE);
	}

	public static BankAccount createBankAccount(ArrayList<BankAccount> accounts) {
		BankAccount myAccount = new BankAccount();
		int newAccountNumber = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter account number","Enter account number",JOptionPane.QUESTION_MESSAGE));
		while(findAccount(accounts,newAccountNumber) != -1){//while new account number does not already exist
			JOptionPane.showMessageDialog(
					null, "Account number already in use.",
					"Error", JOptionPane.ERROR_MESSAGE);
			newAccountNumber = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter account number","Enter account number",JOptionPane.QUESTION_MESSAGE));
		}
		myAccount.setAccountNumber(newAccountNumber);
		myAccount.setName(JOptionPane.showInputDialog(null,"Enter name","Enter name",JOptionPane.QUESTION_MESSAGE));
		myAccount.setBalance(0.0);
		myAccount.setPin(Integer.parseInt(JOptionPane.showInputDialog(null,"Enter PIN","Enter PIN",JOptionPane.QUESTION_MESSAGE)));
		return myAccount;
	}
	
	//Returns the index of BankAccount with matching accountNumber
	//Returns -1 if no matches are found
	public static int findAccount(ArrayList<BankAccount> accounts, int accountNumber){
		for(int i = 0; i < accounts.size(); i++){
			if(accounts.get(i).getAccountNumber() == accountNumber){
				return i;
			}
		}
		return -1;
	}
	
}