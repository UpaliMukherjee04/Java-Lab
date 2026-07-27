import java.util.*;

public class WordCount {
    public static void main(String args[]){
        int count=1;
        System.out.println("Enter String:");
        Scanner sc= new Scanner(System.in);
        String str= sc.nextLine();
        StringBuffer s= new StringBuffer();
        s.append(str);
        for (int i=0;i<s.length();i++){
            if (s.charAt(i) == ' '){
                count+=1;
            }
            else{
                continue;
            }
        }
        System.out.println("No. of words in given string="+count);
        sc.close();
    }
    }
    

