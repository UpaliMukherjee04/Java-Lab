class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(double amount) {
        System.out.println("\n[DEPOSIT] Processing deposit of Rs." + amount + "...");
        balance += amount;
        System.out.println("[DEPOSIT SUCCESS] New Balance: Rs." + balance);
    }

    public synchronized void withdraw(double amount) {
        System.out.println("\n[WITHDRAWAL] Processing withdrawal of Rs." + amount + "...");
        if (balance >= amount) {
            balance -= amount;
            System.out.println("[WITHDRAWAL SUCCESS] Remaining Balance: Rs." + balance);
        } else {
            System.out.println("[WITHDRAWAL FAILED] Insufficient funds! Current Balance: Rs." + balance);
        }
    }

    public double getBalance() {
        return balance;
    }
}

class DepositThread extends Thread {
    private final BankAccount account;
    private final double[] amounts;

    public DepositThread(BankAccount account, double[] amounts) {
        this.account = account;
        this.amounts = amounts;
    }

    @Override
    public void run() {
        for (double amt : amounts) {
            account.deposit(amt);
            try {
                Thread.sleep(600); 
            } catch (InterruptedException e) {
                System.out.println("Deposit Thread Interrupted");
            }
        }
    }
}

class WithdrawalThread extends Thread {
    private final BankAccount account;
    private final double[] amounts;

    public WithdrawalThread(BankAccount account, double[] amounts) {
        this.account = account;
        this.amounts = amounts;
    }

    @Override
    public void run() {
        for (double amt : amounts) {
            account.withdraw(amt);
            try {
                Thread.sleep(800); // Simulate network delay
            } catch (InterruptedException e) {
                System.out.println("Withdrawal Thread Interrupted");
            }
        }
    }
}

public class BankTransactions {
    public static void main(String[] args) {
        BankAccount sharedAccount = new BankAccount(1000.0);

        double[] deposits = {200.0, 500.0, 150.0};
        double[] withdrawals = {300.0, 700.0, 1000.0};

        DepositThread depositTask = new DepositThread(sharedAccount, deposits);
        WithdrawalThread withdrawTask = new WithdrawalThread(sharedAccount, withdrawals);

        System.out.println("Initial Balance: Rs." + sharedAccount.getBalance());
        System.out.println("Starting concurrent bank transactions...\n");

        
        depositTask.start();
        withdrawTask.start();

        // Wait for both tasks to finalize
        try {
            depositTask.join();
            withdrawTask.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("\nAll transactions completed.");
        System.out.println("Final Account Balance: Rs." + sharedAccount.getBalance());
    }
}