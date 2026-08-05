//1. Create a Vehicle and CarInsurance program where CarInsurance accesses Vehicle details
//using super keyword.

class Vehicle{
    String vehicleNumber;
    String model;
    int manufactureYear;

    Vehicle(String vehicleNumber, String model, int manufactureYear){
        this.vehicleNumber = vehicleNumber;
        this.model = model;
        this.manufactureYear = manufactureYear;
    }
    void displayVehicle(String vehicleNumber, String model, int manufactureYear){
        System.out.println("Vehicle Number:"+vehicleNumber);
        System.out.println("Model:"+model);
        System.out.println("Manufacture Year:"+manufactureYear);
    }
}
class CarInsurance extends Vehicle{
    String policyNumber;
    float premiumAmount;

    CarInsurance(String vehicleNumber, String model, int manufactureYear, float premiumAmount){
        super(vehicleNumber, model, manufactureYear);
        this.policyNumber = "POL-DEFAULT";
        this.premiumAmount = 00000;
    }
    CarInsurance(String vehicleNumber, String model, int manufactureYear, float premiumAmount, String policyNumber){
        super(vehicleNumber, model, manufactureYear);
        this.policyNumber = policyNumber;
        this.premiumAmount = premiumAmount;
    }
    void display(){

        System.out.println("\n---Insurance Details---\n");
        System.out.println("Vehicle Number:"+vehicleNumber);
        System.out.println("Model:"+model);
        System.out.println("Manufacture Year:"+manufactureYear);
        System.out.println("Policy Number:"+policyNumber);
        System.out.println("Premium Amount:"+premiumAmount);
    }
}
public class VehicleInsurance {
    public static void main(String args[]){
        CarInsurance c = new CarInsurance("MH12AB1234", "Honda City", 2021, 15000, "POL-9987");
        c.display();
    }
}