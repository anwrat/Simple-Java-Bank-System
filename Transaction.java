package CourseWork;

class Transaction{
	public void Transfer(Account A,Account B,int amount) {
		A.withdraw(amount);
		B.deposit(amount);
	}
}
