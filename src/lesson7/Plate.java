package lesson7;

import java.util.Scanner;

public class Plate {
    int food;

    public Plate(int food) {
        this.food = food;
    }


    public void info()
    {
        System.out.println("plate: " + food);
    }

    public void decreaseFood(int n){
        //Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
        // (например, в миске 10 еды, а кот пытается покушать 15-20).
        //Считаем, что если коту мало еды в тарелке, то он её просто не трогает,
        // то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
        if((food - n) <= 0  ||  food < n){
            System.out.println("Еды мало");
        }
        else if (n < 0){
            System.out.println("Кот в долгах");
        }

        else {
            food -= n;
        }
    }

    //Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
    public void addEat(){
        Scanner scanner = new Scanner(System.in);
        food += scanner.nextInt();
    }
}
