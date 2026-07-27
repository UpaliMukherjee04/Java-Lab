public class Strings {
    public static void main(String args[]){
        //string reversal
        String str=new String("Upali");
        System.out.println("String:"+str);
        String rev="";
        for (int i=str.length()-1;i>=0;i--){
            char ch=str.charAt(i);
            rev+=ch;
        }
        System.out.println("Reversed string:"+rev);


        StringBuilder s= new StringBuilder();
        //string reversal using inbuilt methods
        s.append("Pune");
        System.out.println(s);
        s.reverse();
        System.out.println(s);
    }
}
