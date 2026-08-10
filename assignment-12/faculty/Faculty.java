package faculty;

public class Faculty {
    int id;
    String name;

    public Faculty(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void display() {
        System.out.println("Faculty ID: " + id);
        System.out.println("Faculty Name: " + name);
    }
}
