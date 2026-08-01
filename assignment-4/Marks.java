import java.util.*;
public class Marks {
    public static void main(String args[]){
        
        int total;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter marks a:");
        Integer a= sc.nextInt();
        System.out.println("Enter marks b:");
        Integer b=sc.nextInt();
        System.out.println("Enter marks c:");
        Integer c=sc.nextInt();
        total=a+b+c;
        System.out.println("Total="+total);
        sc.close();

        // String s="2";
        // int a=Integer.parseInt(s);
        // System.out.println(s);
 
    }
}
