import java.io.*;
import java.util.*;
public class EmployeeFileHandling {
    static File f0 = new File("D:\\BTECH SIT CSE\\3rd sem\\java project\\Java_project\\src\\assignment-13\\employee.txt");

    public static void main(String args[]) {
        EmployeeFileHandling.filecreator();
        EmployeeFileHandling.filewriter();
        EmployeeFileHandling.filereader();
    }

    static void filecreator() {
        try {
            if (f0.createNewFile()) {
                System.out.println("File " + f0.getName() + " is created successfully.");
            } else {
                System.out.println("File already exists in the directory.");
            }
        } catch (IOException exception) {
            System.out.println("An unexpected error occurred.");
            exception.printStackTrace();
        }
    }

    static void filewriter() {
        try {
            FileWriter fwrite = new FileWriter(f0);
            fwrite.write("Employee ID: 101\n");
            fwrite.write("Name: Rahul Sharma\n");
            fwrite.write("Department: Computer Science\n");
            fwrite.write("Salary: 55000\n");
            fwrite.close();
            System.out.println("Employee details written to the file successfully.");
        } catch (IOException e) {
            System.out.println("Unexpected error occurred while writing.");
            e.printStackTrace();
        }
    }

    static void filereader() {
        try {
            Scanner dataReader = new Scanner(f0);
            System.out.println("\n--- Employee Details ---");
            while (dataReader.hasNextLine()) {
                String fileData = dataReader.nextLine();
                System.out.println(fileData);
            }
            dataReader.close();
        } catch (FileNotFoundException exception) {
            System.out.println("File not found!");
            exception.printStackTrace();
        }
    }
}