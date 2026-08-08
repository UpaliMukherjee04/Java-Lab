// Write a Java program to demonstrate the use of the final keyword with variables, methods, and classes.

// final class College {
//     final int COLLEGE_ID = 101;
//     final void display() {
//         System.out.println("College ID: " + COLLEGE_ID);
//     }
// }

// public class FinalDemo {
//     public static void main(String[] args) {
//         College c = new College();
//         c.display();
//         c.COLLEGE_ID = 200;
//     }
// }

final class BankAccount{
    final long  accountNumber;
    String name;
    BankAccount(int accountNumber, String name){
        this.accountNumber=accountNumber;
        this.name=name;
    }
    void display(){
        System.out.println("Name:"+name);
        System.out.println("Account Name:"+accountNumber);
    }

}
public class FinalDemo{
    public static void main(String args[]){
        BankAccount b = new BankAccount(123456789, "Ajay Mishra");
        b.display();
    }
}