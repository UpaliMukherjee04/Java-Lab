public class App {
    
    //default constructor
    int prn=210;
    String name;
    App()
    {
    }

    //paramterized constructor
    App(int p,String n){
        name=n;
        prn=p;
    }
   
    App( String n){
        name=n;
        
    }
    //copy constructor
    App(App a){
        prn=a.prn;
        name=a.name;
    }

    void print(){
        System.out.println("Name:"+name);
        System.out.println("PRN:"+prn);

    }
    public static void main(String[] args){
        
        App obj = new App();  //create an object--new keyword allocates memory
        obj.print();
        App obj1 = new App(1,"Upali");
        obj1.print();
        App obj2 = new App("Upali");
        obj2.print();
        App obj3 = new App(obj1);
        obj3.print();

    }
}
