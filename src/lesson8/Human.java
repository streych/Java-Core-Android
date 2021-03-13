package lesson8;

public class Human implements RunGo{
    String name;
    public Human(String name) {
        this.name = name;
    }



    @Override
    public void run() {
        System.out.println(name + " бежит");
    }

    @Override
    public void go() {
        System.out.println(name +  " прыгает");
    }
}
