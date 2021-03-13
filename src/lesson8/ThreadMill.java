package lesson8;

public class ThreadMill implements RunGo{

    @Override
    public void run() {
        System.out.println("успешно пробежал");
    }

    @Override
    public void go() {
        System.out.println("Прошелся успешно");
    }
}
