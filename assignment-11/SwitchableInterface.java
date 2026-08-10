interface Switchable{
    void turnOn();
}

class Light implements Switchable{
    public void turnOn(){
        System.out.println("Light is turned ON. Glowing brightly!");
    }
}

class Fan implements Switchable{
    public void turnOn(){
        System.out.println("Fan is turned ON. Rotating at full speed!");
    }
}

public class SwitchableInterface {
    public static void main(String args[]){
        Light l = new Light();
        System.out.println("\nLight Status:");
        l.turnOn();

        Fan f = new Fan();
        System.out.println("\nFan Status:");
        f.turnOn();
    }
}