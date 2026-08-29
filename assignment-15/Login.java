
import java.util.*;
public class Login{
    static void checkDetails(String username, String password) throws Exception{
        String user= "Upali";
        String pass="abc123";
        if (user!=username || pass!=password){
            throw new Exception("Invlid username or password");
        }
        else{
            System.out.println("Welcome to your profile!");
        }
    }
    public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in);
        try{
        System.out.println("Enter username:");
        String username = sc.nextLine();
        System.out.println("Enter password:");
        String password = sc.next();

        checkDetails(username, password);
        }
        catch (Exception e){
            System.out.println("Exception found: "+e.getMessage());
        }
        finally{
            System.out.println("Program executed...");
        }

        
    }
}