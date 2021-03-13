package lesson6;
/*
Создать классы Собака и Кот с наследованием от класса Животное.
Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия. Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
* Добавить подсчет созданных котов, собак и животных.

 */

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Барсик");
        cat.run(10);
        cat.run(300);
        cat.sweam(10);
        cat.sweam(0);

        Dog dog = new Dog("Пушистик");
        dog.run(10);
        dog.run(600);
        dog.sweam(20);
        dog.sweam(5);

        System.out.println("Количество животных " + Animal.animalCount);
        System.out.println("Количество котов " + Cat.catCount);
        System.out.println("Количество собак " + Dog.dogCount);
    }
}
