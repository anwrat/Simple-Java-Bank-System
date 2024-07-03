package CourseWork;

class Account extends Customer{
	private int balance;
	private int accountNumber;
	public Account(String FName,String LName,int accnum,int accBal) {
		setFirstName(FName);
		setLastName(LName);
		accountNumber=accnum;
		balance=accBal;
	}
	public int getBalance() {
		return balance;
	}
	public int getAccountNum() {
		return accountNumber;
	}
	public void deposit(int amount) {
		balance+=amount;
	}
	public void withdraw(int amount) {
		if(amount<=balance) {
			balance-=amount;
		}
	}
}
