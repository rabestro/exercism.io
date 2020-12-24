public final class BankAccount {
    private static final BankAccountActionInvalidException ACCOUNT_CLOSED =
            new BankAccountActionInvalidException("Account closed");
    private static final BankAccountActionInvalidException NEGATIVE_AMOUNT =
            new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");

    private volatile int balance;
    private volatile boolean isOpen;

    public void open() {
        balance = 0;
        isOpen = true;
    }

    public int getBalance() throws BankAccountActionInvalidException {
        if (!isOpen) {
            throw ACCOUNT_CLOSED;
        }
        return balance;
    }

    public synchronized void deposit(int money) throws BankAccountActionInvalidException {
        if (!isOpen) {
            throw ACCOUNT_CLOSED;
        }
        if (money < 0) {
            throw NEGATIVE_AMOUNT;
        }
        balance += money;
    }

    public synchronized void withdraw(int money) throws BankAccountActionInvalidException {
        if (!isOpen) {
            throw ACCOUNT_CLOSED;
        }
        if (money < 0) {
            throw NEGATIVE_AMOUNT;
        }
        if (balance == 0) {
            throw new BankAccountActionInvalidException("Cannot withdraw money from an empty account");
        }
        if (money > balance) {
            throw new BankAccountActionInvalidException("Cannot withdraw more money than is currently in the account");
        }
        balance -= money;
    }

    public void close() {
        isOpen = false;
    }
}