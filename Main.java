package CourseWork;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JFrame;
public class Main {
	public static void main(String[] args) {
		//FOR PART 3
		String file="account.csv";
		ReadAccounts readAccounts=new ReadAccounts(file);
		LinkedList<Account> accounts=new LinkedList<>();
		LinkedList<String> firstNames=new LinkedList<>();
		LinkedList<String> lastNames=new LinkedList<>();
		LinkedList<Integer> accountList=new LinkedList<>();
		LinkedList<Integer> balanceList=new LinkedList<>();
		try {
			firstNames=readAccounts.getFirstNames();
			lastNames=readAccounts.getLastNames();
			accountList=readAccounts.getAccounts();
			balanceList=readAccounts.getBalances();
			for(int i=0;i<firstNames.size();i++) {
				//making Account class objects and passing values to Account constructor
				accounts.add(new Account(firstNames.get(i),lastNames.get(i),accountList.get(i),balanceList.get(i)));
			}
			GUI gui=new GUI(accounts);
			gui.setVisible(true);
			gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}catch(IOException e) {
			e.printStackTrace();
		}
		/*FOR PART 1!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		Account account1=new Account("Jeffrey","Ting",1,2000);
		Account account2=new Account("Hiran","Patel",2,1000);
		System.out.println("Balance of account1: "+account1.getBalance());
		System.out.println("Balance of account2: "+account2.getBalance());
		account1.deposit(250);
		System.out.println("After depositiong in account1: "+account1.getBalance());
		account2.withdraw(500);
		System.out.println("After withdrawing from account2: "+account2.getBalance());
		Transaction t=new Transaction();
		t.Transfer(account1, account2, 250);
		System.out.println("Final Balance after Transaction: ");
		System.out.println("Account1: "+account1.getBalance());
		System.out.println("Account2: "+account2.getBalance());
		*/
		/*FOR PART 2!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		//The file is placed in inside OOP but outside bin and src 
		String file="account.csv";
		ReadAccounts readAccounts=new ReadAccounts(file);
		Transaction transfer=new Transaction();
		LinkedList<Account> accounts=new LinkedList<>();
		LinkedList<String> firstNames=new LinkedList<>();
		LinkedList<String> lastNames=new LinkedList<>();
		LinkedList<Integer> accountList=new LinkedList<>();
		LinkedList<Integer> balanceList=new LinkedList<>();
		try {
			firstNames=readAccounts.getFirstNames();
			lastNames=readAccounts.getLastNames();
			accountList=readAccounts.getAccounts();
			balanceList=readAccounts.getBalances();
			for(int i=0;i<firstNames.size();i++) {
				//making Account class objects and passing values to Account constructor
				accounts.add(new Account(firstNames.get(i),lastNames.get(i),accountList.get(i),balanceList.get(i)));
			}
			System.out.println("Initial amount in "+accounts.get(0).getFirstName()+": "+accounts.get(0).getBalance());
			System.out.println("Initial amount in "+accounts.get(1).getFirstName()+": "+accounts.get(1).getBalance());
			System.out.println("After Transaction:");
			transfer.Transfer(accounts.get(0), accounts.get(1), 100);
			System.out.println("Final amount in "+accounts.get(0).getFirstName()+": "+accounts.get(0).getBalance());
			System.out.println("Final amount in "+accounts.get(1).getFirstName()+": "+accounts.get(1).getBalance());
		}catch(IOException e) {
			e.printStackTrace();
		}
		*/
	}
}
