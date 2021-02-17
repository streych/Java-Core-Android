package lesson3;

import java.io.*;

public class GuessNumber {
    /*
    Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это число.
     При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число, чем загаданное, или меньше.
     После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
     */
    public static void guessNumber() throws IOException {

        int random = (int) (Math.random() * 10);//случайное число
        int userTryMax = 3; //попытки пользователя
        int userTry = 1;

        while (true) {
            int number = inputNumber();
            //int number = 0;
            if(number == random) {
                System.out.println("Вы выиграли");
                break;
            }
            else if (userTry == userTryMax) {
                System.out.println("Вы проиграли.\nОсталось попыток 0");
                System.out.println("Правильный ответ " + random);
                System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
                number = inputNumber();
                if(number == 1) {
                    userTry = 1;
                }
                else break;
            }
            else {
                tryUserUnswer(userTryMax, userTry);
                userTry++;
            }
        }
    }

    public static int inputNumber() throws IOException {
        InputStream input = System.in;
        Reader inputStream = new InputStreamReader(input);
        BufferedReader reader = new BufferedReader(inputStream);
        String stork = reader.readLine();
        return Integer.parseInt(stork);
    }

    public static void tryUserUnswer(int a, int b) {
        if(a > b)
        {
            System.out.println("Ваше число больше ответа");
            System.out.println("Попробуйте еще.\nОсталось попыток " + (a - b));
        }
        else
        {
            System.out.println("Ваше число меньше ответа");
            System.out.println("Попробуйте еще.\nОсталось попыток " + (a - b));
        }
    }
}
