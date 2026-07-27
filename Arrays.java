import java.util.*;
public class Arrays {

    public static void main(String args[]){
        int arr[]= new int[10]; //40 bytes continuous memory allocation
        for (int i=0;i<10;i++){
            arr[i]=i+1; //store 1-10
        }
        for (int i:arr){  //for each style (only when not assigning values)
            System.out.println(i);
        }
        ArrayList<Integer> arr1= new ArrayList<Integer>();   //array of dynamic memory allocation
        arr1.add(1);
        arr1.add(2);
        arr1.add(3);
        arr1.add(4);
        arr1.add(5);
        arr1.add(2,6);
        System.out.println(arr1);
        arr1.addFirst(0);
        arr1.addLast(10);
        System.out.println(arr1);
        System.out.println(arr1.contains(5));
        arr1.remove(3); //based on index
        System.out.println(arr1);

    }
    
}
