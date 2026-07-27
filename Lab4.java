import java.util.*;
public class Lab4{
    
    public static void main(String args[]){
        //int a=0;
        Integer c=8;   //class-Integer object-c

//Integer, Float, String are wrapper class (parent class of all datatypes): converts datatypes using name of the class

        System.out.println(c);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter num:");
        int str=sc.nextInt(2);  //binary to decimal conversion--give base value of input 
        System.out.println(str);
        sc.close();
    }
}