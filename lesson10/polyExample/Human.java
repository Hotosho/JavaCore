package lesson10.polyExample;

public class Human {
    private String name;

    public Human(String name) {
        this.name = name;
    }

    void run(){
        System.out.println("Human class cold is called...");
        System.out.println(name + " is running");
    }
}
