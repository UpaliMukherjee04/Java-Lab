import java.util.*;
public class Bank {
    float balance;

    void checkBalance(String name, int accountNum)
    {
        System.out.println("Customer Name:"+name);
        System.out.println("Account Number:"+accountNum);
        System.out.println("Current balance="+balance);
    }

    void deposit(float amount, int accountNum){
        balance += amount;
        System.out.println("Deposited " + amount + " to account " + accountNum);
    }

    void withdraw(float amount, int accountNum){
        if (amount > balance){
            System.out.println("Insufficient Balance");
        } else {
            balance -= amount;
            System.out.println("Withdrawn " + amount + " from account " + accountNum);
        }
    }

    public static void main(String args[]){
        Bank bank = new Bank();
        int choice=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of Account Holder:");
        String name = sc.nextLine();
        System.out.println("Enter Account Number:");
        int accountNum = sc.nextInt();

        while(choice != 4){
            System.out.println("Select an option:\n1. Check balance\n2. Deposit\n3. Withdraw\n4. Exit ");
            choice = sc.nextInt();

            switch (choice){
                case 1:

                    bank.checkBalance(name, accountNum);
                    break;
                case 2:
                   
                   
                    System.out.println("Enter deposit amount:");
                    float depositAmount = sc.nextFloat();
                    bank.deposit(depositAmount, accountNum);
                    break;
                case 3:
                    System.out.println("Enter withdrawal amount:");
                    float withdrawalAmount = sc.nextFloat();
                    bank.withdraw(withdrawalAmount, accountNum);
                    break;
                case 4:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
