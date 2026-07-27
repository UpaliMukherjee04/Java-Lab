
public class CharCount {
    public static void main(String args[]){
        int count=0;
        
        StringBuffer str= new StringBuffer();
        str.append("It is raining in Pune today");
        
        String s = str.toString().trim().toLowerCase();

        for (int i=0;i<s.length();i++){
            char ch= s.charAt(i);
            if (s.indexOf(ch)==i && ch != ' '){
            for (int j=0;j<s.length();j++){
                
                if (s.charAt(j) == ch){
                    count+=1;
                }
            }
            System.out.println(ch+" occurs "+count+" times in the string");
            count=0;
            }
             
        }
      
    }
    
}

/*
int arr[]= new int[26];
for (int i=0;i<str.length();i++){
    char ch =str.charAt(i);
    int chi= (int)ch;
    if (chi<=122 && chi>=97){
    arr[chi-97]+=1;
}
}
for (int i=0;i<26;i++){
if (arr[i]==0){
continue;

}
else{
    System.out.println((char)(97+i)+":"arr[i]);
}}


*/
