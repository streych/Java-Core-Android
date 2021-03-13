package lesson6;

public class Cat extends Animal{
    static int catCount = 0;

    public Cat(String name) {
        super(name);
        catCount++;
    }


    @Override
    public void run(int width) {
        if (width > 200){
            System.out.println("Кот не может пробежать " + width);
        }
        else super.run(width);
    }

    @Override
    public void sweam(int width) {
        if (width > 0){
            System.out.println("Кот не может проплыть " + width);
        }
        else super.sweam(width);
    }
}
