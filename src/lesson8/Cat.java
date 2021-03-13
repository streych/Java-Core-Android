package lesson8;

public class Cat implements RunGo{
    String name;
    public Cat(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println("Кот бежит");
    }

    @Override
    public void go() {
        System.out.println("Кот идет");
    }
}
