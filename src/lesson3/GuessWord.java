package lesson3;

import java.io.*;
import java.util.Locale;

public class GuessWord {
    /*
    * Создать массив из слов
String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}.
При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя, сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
apple – загаданное
apricot - ответ игрока
ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
Для сравнения двух слов посимвольно можно пользоваться:
String str = "apple";
char a = str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
Играем до тех пор, пока игрок не отгадает слово.
Используем только маленькие буквы.
     */


    public static void guessWord() throws IOException {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi",
                "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String word = randomWord(words); //слово из списка
        int count = 2;

        while (true){
            String unwer = inputUnswer().toLowerCase(Locale.ROOT);//ввод пользователя

            if(word.equals(unwer)) { //проверка на правильный ответ
                System.out.println("Вы угадали " + word);
                break;
            }
            else {
                System.out.println("Вы не угадали");
                wordSimbole(word, count);// сделай переменную с поличеством симмволов на показ!!!!!!!!!!!
                count++;
            }
        }

    }

    public static String inputUnswer() throws IOException {
        InputStream input = System.in;
        Reader inputStream = new InputStreamReader(input);
        BufferedReader reader = new BufferedReader(inputStream);
        return reader.readLine();
    }

    public static String randomWord(String[] words) {
        return words[(int)(Math.random() * words.length)];
    }

    public static void wordSimbole(String word, int coutSimbol) {
        String sym = "*";
        //Проверка на привышение длины слова
        if(coutSimbol > word.length() ) {
            coutSimbol = word.length();
        }
        //Выводим символы из слова(Подсказка)
        StringBuilder answer= new StringBuilder();
        for (int i = 0; i < coutSimbol; i++) {
            char a = word.charAt(i);
            answer.append(a);
        }
        //добавляем к слову сивол *
        for (int i = 0; i < 15 - coutSimbol; i++) {
            answer.append(sym);
        }
        System.out.println(answer);
    }
}
