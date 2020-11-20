public final class BankAccount {
    private int balance;

    public void open() {
        balance = 0;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int money) throws BankAccountActionInvalidException {
        balance += money;
    }

    public void withdraw(int money) throws BankAccountActionInvalidException {
        balance -= money;
    }

    public void close() {

    }
}