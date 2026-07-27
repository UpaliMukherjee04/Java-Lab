import java.util.*;
public class Registration {
    public static void main(String args[]){
        int choice=0;
        Scanner sc=new Scanner(System.in);
        ArrayList<String> register = new ArrayList<String>();
        
        while (choice!=4){
        System.out.println("\n1. Add course\n2.Remove course\n3.View all courses\n4.Exit\nChoose activity:");
        choice = sc.nextInt();

        switch(choice){
            case 1: 
            System.out.println("Enter course name:");
            String course=sc.next();
            register.add(course);
            System.out.println("New course "+course+" added");
            
            break;

            case 2:
            System.out.println("Enter course name to delete:");
            String deleteCourse=sc.next();
            register.remove(deleteCourse);
            System.out.println("Removed element:"+deleteCourse);
            
            break;

            case 3:
            System.out.println("Courses:");
            for (int i=0;i<register.size();i++){
            StringBuffer s= new StringBuffer();
            s.append(register.get(i));
            System.out.println("Course"+(i+1)+":"+s);
            }
            break;

            case 4: 
            System.out.println("Exiting the program");
            break;
        } 
    }
    sc.close();

        }


    }

