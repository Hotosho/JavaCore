package lesson10.polyExample;

public class Demo {
    public static void main(String[] args) {

        Human human = new Human("HumanTest");
        run(human);

        System.out.println("=========");

        User user = new User("UserTest");
        run(user);

    }

    private static void run(Human human){
        human.run();
    }
}
