class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Synchronized to handle concurrent access safely
    public synchronized void deposit(double amount) {
        System.out.println("\n[DEPOSIT] Processing Rs." + amount + "...");
        balance += amount;
        System.out.println("[DEPOSIT SUCCESS] Updated Balance: Rs." + balance);
    }

    public synchronized void withdraw(double amount) {
        System.out.println("\n[WITHDRAWAL] Processing Rs." + amount + "...");
        if (balance >= amount) {
            balance -= amount;
            System.out.println("[WITHDRAWAL SUCCESS] Remaining Balance: Rs." + balance);
        } else {
            System.out.println("[WITHDRAWAL FAILED] Insufficient balance! Current: Rs." + balance);
        }
    }

    public double getBalance() {
        return balance;
    }
}

// Deposit Task implementing Runnable
class DepositTask implements Runnable {
    private final BankAccount account;
    private final double[] amounts;

    public DepositTask(BankAccount account, double[] amounts) {
        this.account = account;
        this.amounts = amounts;
    }

    @Override
    public void run() {
        for (double amt : amounts) {
            account.deposit(amt);
            try {
                Thread.sleep(600); // Simulate operation delay
            } catch (InterruptedException e) {
                System.out.println("Deposit Task Interrupted");
            }
        }
    }
}

// Withdrawal Task implementing Runnable
class WithdrawalTask implements Runnable {
    private final BankAccount account;
    private final double[] amounts;

    public WithdrawalTask(BankAccount account, double[] amounts) {
        this.account = account;
        this.amounts = amounts;
    }

    @Override
    public void run() {
        for (double amt : amounts) {
            account.withdraw(amt);
            try {
                Thread.sleep(800); // Simulate operation delay
            } catch (InterruptedException e) {
                System.out.println("Withdrawal Task Interrupted");
            }
        }
    }
}

public class BankOp {
    public static void main(String[] args) {
        BankAccount sharedAccount = new BankAccount(1000.0); 
        double[] deposits = {200.0, 500.0, 150.0};
        double[] withdrawals = {300.0, 700.0, 1000.0};

        // Pass Runnable tasks to Thread constructors
        Thread depositThread = new Thread(new DepositTask(sharedAccount, deposits), "Deposit-Thread");
        Thread withdrawThread = new Thread(new WithdrawalTask(sharedAccount, withdrawals), "Withdrawal-Thread");

        System.out.println("Initial Account Balance: Rs." + sharedAccount.getBalance());
        System.out.println("Starting concurrent transactions...");

        depositThread.start();
        withdrawThread.start();

        try {
            depositThread.join();
            withdrawThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("\nAll transactions finished.");
        System.out.println("Final Account Balance: Rs." + sharedAccount.getBalance());
    }
}