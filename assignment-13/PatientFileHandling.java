import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PatientFileHandling {
    static File f0 = new File("D:\\BTECH SIT CSE\\3rd sem\\java project\\Java_project\\src\\assignment-13\\patient.txt");

    public static void main(String args[]) {
        PatientFileHandling.filecreator();
        PatientFileHandling.filewriter();
        PatientFileHandling.filereader();
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
            fwrite.write("Patient ID: 2001\n");
            fwrite.write("Name: Anita Verma\n");
            fwrite.write("Age: 34\n");
            fwrite.write("Diagnosis: Viral Fever\n");
            fwrite.close();
            System.out.println("Patient details written to the file successfully.");
        } catch (IOException e) {
            System.out.println("Unexpected error occurred while writing.");
            e.printStackTrace();
        }
    }

    static void filereader() {
        try {
            Scanner dataReader = new Scanner(f0);
            System.out.println("\n--- Patient Details ---");
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