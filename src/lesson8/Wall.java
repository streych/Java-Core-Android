package lesson8;

public class Wall implements RunGo{
    @Override
    public void run() {
        System.out.println("не смог пробежать");
    }

    @Override
    public void go() {
        System.out.println("не смог пройти");
    }
}
