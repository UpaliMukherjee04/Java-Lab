
public class CharCount1 {
    public static void main(String args[]){
        int count=0;
        
        StringBuffer str= new StringBuffer();
        str.append("It is raining in Pune today");
        
        String s = str.toString().trim().toLowerCase();

        for (char c ='a';c<'z';c++){
            
            for (int j=0;j<s.length();j++){
                
                if (s.charAt(j) == c){
                    count+=1;
                }
            }
            if (count!=0){
            System.out.println(c+" occurs "+count+" times in the string");
            count=0;
            }
            else{
                count=0;
            }
            
            }
             
        }
      
    }
    

