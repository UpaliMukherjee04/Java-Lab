class Animal {
    String name;
    Animal(String name) {
        this.name=name;
    }
    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
    String name;
    Dog(String name) {
        this.name=name;
        super("bird");
    }
    void display() {
        System.out.println("Parent Name: " + super.name);
        System.out.println("Child Name: " + name);
        super.sound();
    }
}

public class SuperKeyword {
    public static void main(String[] args) {
        Dog d = new Dog("Dog");
        d.display();
    }
}