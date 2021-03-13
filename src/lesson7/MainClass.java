package lesson7;

public class MainClass {



    public static void main(String[] args) {
        Cat[] cats = new Cat[3];
        Plate plate = new Plate(11);
        cats[0] = new Cat("Барс", 10);
        cats[1] = new Cat("Бар", 5);
        cats[2] = new Cat("Ба", 3);
        plate.info();
        for (Cat cat: cats) {
            cat.eat(plate);//кот c кушает
            plate.info();
        }
    }
}
