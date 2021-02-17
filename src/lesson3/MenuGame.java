package lesson3;

import java.io.IOException;

import static lesson3.GuessWord.guessWord;
import static lesson3.GuessWord.inputUnswer;
import static lesson3.GuessNumber.guessNumber;

public class MenuGame {
    public static void main(String[] args) throws IOException {
        boolean ex = true;
        while (ex)
        {
            System.out.println("В нашем заведении вы можете поиграть в такие игры как:\n№1 - Угадай число\n№2 - Угадай слово\nЕсли вы устали введите 0");
            int number = Integer.parseInt(inputUnswer());

            switch (number){
                case 1:
                    System.out.println("Приятной вам игры в Угадай число");
                    System.out.println("Попробуй угадай число от 0 до 9");
                    guessNumber();
                    break;
                case 2:
                    System.out.println("Приятной вам игры в Угадай слово");
                    System.out.println("Попробуй угадай слово");
                    guessWord();
                    break;
                case 0:
                    System.out.println("Будем рады снова вас видеть");
                    ex = false;
                    break;
                default:
                    System.out.println("Нет такой игры");
            }
        }
    }
}
