package lesson6;

public class Animal {
    private String name;
    static int animalCount = 0;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public void run(int width){
        System.out.println(name + " пробежал " + width);
    }

    public void sweam(int width){
        System.out.println(name + " проплыл " + width);
    }
}
