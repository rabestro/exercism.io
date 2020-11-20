public final class BankAccount {
    private int balance;
    private boolean isOpen;

    public void open() {
        balance = 0;
        isOpen = true;
    }

    public int getBalance() throws BankAccountActionInvalidException {
        if (!isOpen) throw new BankAccountActionInvalidException("Account closed");

        return balance;
    }

    public void deposit(int money) throws BankAccountActionInvalidException {
        if (!isOpen) throw new BankAccountActionInvalidException("Account closed");
        if (money < 0) throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");

        balance += money;
    }

    public void withdraw(int money) throws BankAccountActionInvalidException {
        if (!isOpen) throw new BankAccountActionInvalidException("Account closed");
        if (money < 0)
            throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        if (balance == 0)
            throw new BankAccountActionInvalidException("Cannot withdraw money from an empty account");
        if (money > balance)
            throw new BankAccountActionInvalidException("Cannot withdraw more money than is currently in the account");

        balance -= money;
    }

    public void close() {
        isOpen = false;
    }
}