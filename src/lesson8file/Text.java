package lesson8file;
//1. Создать 2 текстовых файла, примерно по 50-100 символов в каждом(особого значения не имеет);
//2. Написать метод, «склеивающий» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
//3.* Написать метод, который проверяет присутствует ли указанное пользователем слово в файле (работаем только с латиницей).
//4.** Написать метод, проверяющий, есть ли указанное слово в папке

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class Text {
    public static void main(String[] args) throws IOException {
        //stickFile("C:\\Users\\roboc\\IdeaProjects\\Java-Core-Android\\src\\lesson8file\\file1.txt");//Первый файл
        //stickFile("C:\\Users\\roboc\\IdeaProjects\\Java-Core-Android\\src\\lesson8file\\file2.txt");//Второй файл и тд

        //searchWord("C:\\Users\\roboc\\IdeaProjects\\Java-Core-Android\\src\\lesson8file\\file1.txt", "есть");

        searchFolder("C:\\Users\\roboc\\IdeaProjects\\Java-Core-Android\\src\\lesson8file" , "есть");

    }

    //Написать метод, проверяющий, есть ли указанное слово в папке
    public static void searchFolder(String path, String sWord) throws IOException {
        File root = new File( path );//создаем обьект файла для каталога path
        File[] list = root.listFiles(); // Массив файлов

        if (list == null) return; //Проверяем на путой массив

        for ( File f : list ) { //побежали по массиву
            if ( f.isDirectory() ) { //если папка
                searchFolder( f.getAbsolutePath(), sWord); //падаем глубже
                //System.out.println( "Dir:" + f.getAbsoluteFile() );
            }
            else {
                //System.out.println( "File:" + f.getAbsoluteFile() );
                searchWord(String.valueOf(f.getAbsoluteFile()), sWord);//проверяем есть ли слово в тексте
            }
        }

    }

    //Написать метод, который проверяет присутствует ли указанное пользователем слово в файле (работаем только с латиницей).
    public static void searchWord(String file, String sWord) throws IOException {
        String separators = "[ ,.!?;:]";
        Path path = Paths.get(file);
        Scanner scanner = new Scanner(path);
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            String[] word = line.split(separators);
            for (String w: word) {
                if(w.equals(sWord)){
                    System.out.println("Слово " + sWord + " присутствует в Файле");
                }
            }
        }
    }

    //Написать метод, «склеивающий» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
    public static void stickFile(String file){

        //Написать метод, «склеивающий» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
        try (FileReader fileReader = new FileReader(file)){ //читаем
            FileWriter fileWriter = new FileWriter(
                    "C:\\Users\\roboc\\IdeaProjects\\Java-Core-Android\\src\\lesson8file\\result.txt", true);
            //Включаем функцию дозаписи
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            int c;
            while ((c = fileReader.read()) != -1)
            {
                bufferedWriter.write(c);//Пишем по символьно
            }
            bufferedWriter.write("\n");//Перводим картеку
            bufferedWriter.close();//Закрыли поток
        }
        catch (IOException ex){
            System.out.println("Error");
        }
    }
}
