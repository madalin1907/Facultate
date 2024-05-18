package jsxm.testAdapters;
import org.jsxm.examples.Bank.Account;

public class AccountAdapter {

	Account account = new Account();

	public String open() {
		try {
			account.open();
		} catch (Exception e) {
			return "open_Error";
		}
		return "openOut";
	}

	public String close() {
		try {
			account.close();
		} catch (Exception e) {
			return "close_Error";
		}
		return "closeOut";
	}

	public String deposit(int x) {
		try {
			account.deposit(x);
		} catch (Exception e) {
			return "deposit_Error";
		}
		return "depositOut_" + x;
	}

	public String withdraw(int x) {
		try {
			account.withdraw(x);
		} catch (Exception e) {
			return "withdraw_Error";
		}
		return "withdrawOut_" + x;
	}

	public String getBalance() {
		int balance;
		try {
			balance = account.getBalance();
		} catch (Exception e) {
			return "getBalance_Error";
		}
		return "getBalanceOut_" + balance;
	}
}
