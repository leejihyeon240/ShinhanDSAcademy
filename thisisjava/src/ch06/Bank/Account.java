package ch06.Bank;

public class Account {
	
	private String account;
	private String name;
	private int money;
	
	public Account(String account, String name, int money) {
		this.account = account;
		this.name = name;
		this.money = money;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	@Override
	public String toString() {
	    return account + "   " + name + "   " + money;
	}
	
}
