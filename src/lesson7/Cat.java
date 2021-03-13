package lesson7;

public class Cat {
    String name;
    int appetite;
    //Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
    boolean hungry;

    public Cat(String name, int appetite){
        this.name = name;
        this.appetite = appetite;
        this.hungry = false;
    }

    public void eat(Plate p){
        if (p.food <= appetite){
            System.out.println("Добавите еды!!!");
            p.addEat();
        }
        //Если коту удалось покушать (хватило еды), сытость = true.
        if (p.food > appetite) {
            hungry = true;
            p.decreaseFood(appetite);
            appetite = 0;
        }
        //Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки
        // и потом вывести информацию о сытости котов в консоль.
        if (appetite == 0){
            System.out.println(name + " Поел: сытость " + appetite);
        }
        else {
            System.out.println(name + " Не поел: сытость " + appetite);
        }

    }
}
