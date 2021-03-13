package lesson6;

public class Dog extends Animal{
    static int dogCount = 0;
    public Dog(String name) {
        super(name);
        dogCount++;
    }


    @Override
    public void run(int width) {
        if (width > 500){
            System.out.println("Собака не может пробежать " + width);
        }
        else super.run(width);
    }

    @Override
    public void sweam(int width) {
        if (width > 10){
            System.out.println("Собака не может проплыть " + width);
        }
        else super.sweam(width);
    }
}
