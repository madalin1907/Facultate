package org.jsxm.examples.Bank;

public class Account {

	private int balance = 0;
	private boolean isOpen = false;
	private boolean isClosed = false;

	public void open() {
		if (!isClosed && !isOpen) { // if foo is true
			isOpen = true;
		} else { // if foo is true
			throw new RuntimeException();
		}

	}

	public void close() {
		if (!isClosed && isOpen && balance == 0) {
			isOpen = false;
			isClosed = true;
		} else
			throw new RuntimeException();
	}

	public void deposit(int x) {
		if (isOpen) {
			balance += x;
		} else
			throw new RuntimeException();
	}

	public void withdraw(int x) {
		if (isOpen && balance != 0 && balance >= x) {
			balance -= x;
		} else
			throw new RuntimeException();
	}

	public int getBalance() {
		if (isOpen) {
			return balance;
		} else
			throw new RuntimeException();
	}
}
