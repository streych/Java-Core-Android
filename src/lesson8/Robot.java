package lesson8;

public class Robot implements RunGo{
    String name;
    public Robot(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println("Робот бежит");
    }

    @Override
    public void go() {
        System.out.println("Робот идет");
    }
}
