package lesson2;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.Arrays;

public class task2 {
    public static void main(String[] args) throws IOException {
        boolean ex = true;
        InputStream input = System.in;
        Reader inputStream = new InputStreamReader(input);
        BufferedReader reader = new BufferedReader(inputStream);

        while (ex)
        {
            String stroka = reader.readLine();
            int numberWork = Integer.parseInt(stroka);

            switch (numberWork)
            {
                case 1:
                    //Task2.1
                    int[] element1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
                    element(element1);
                    System.out.println();
                    break;
                case 2:
                    //Task2.2
                    array8();
                    System.out.println();
                    break;
                case 3:
                    //Task2.3
                    arrMinSix();
                    System.out.println();
                    break;
                case 4:
                    //Task2.4
                    arraySque();
                    System.out.println();
                    break;
                case 5:
                    //Task2.5
                    int[] arr = {2,-3,5,8,9,4,-7,2,6,5,-4,1};
                    maxMinArray(arr);
                    System.out.println();
                    break;
                case 6:
                    //Task2.6
                    int[] arr2 = {1,1,1,2,1};
                    int[] arr3 = {2, 2, 2, 1, 2, 2, 10, 1};
                    int[] arr4 = {5, 2, 2, 1, 2, 2, 10, 1};
                    int[] arr5 = {};
                    sumStoron(arr2);
                    sumStoron(arr3);
                    sumStoron(arr4);
                    sumStoron(arr5);
                    System.out.println();
                    break;
                case 7:
                    //Task 2.7
                    int[] arr7 = {1,2,3};
                    arraNum(arr7, -1);
                    int[] arr6 = {3,5,6,1};
                    arraNum(arr6, -2);
                    System.out.println();
                    break;
                case 0:
                    System.out.println("Спасибо. Возвращайтесь к нам снова");
                    ex = false;
                    System.out.println();
                    break;
                default:
                    System.out.println("Такого задания нет");
            }
        }

    }
    //Функция вывода массива.
     public static void arrayOut(int[] arr){
         for (int j : arr) {
             System.out.print(j + " ");
         }
     }
    //region task2.1
    // Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    // С помощью цикла и условия заменить 0 на 1, 1 на 0.
    public static void element (int @NotNull [] el){
        System.out.println("Изначальный массив = ");
        arrayOut(el);
        for (int i = 0; i < el.length; i++) {
            if(el[i] == 0) { el[i] = 1; }
            else el[i] = 0;
        }
        System.out.println("\nПосле перемотра массив = ");
        arrayOut(el);
    }



    //endregion

    //region task2.2
    // Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21.
        public static void array8(){
            int[] arr = new int[8];
            arr[0] = 0;
            for (int i = 1; i < arr.length; i++) {
                arr[i] = arr[i-1] + 3;
            }
            System.out.println("\nМассив +3 = ");
            arrayOut(arr);
        }
    //endregion

    //region task2.3
    // Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], пройти по нему циклом и числа меньшие 6 умножить на 2.
    public static void arrMinSix()
    {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("\nИзначалный массив = "); arrayOut(arr);
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < 6) arr[i] *= 2;
        }
        System.out.println("\nПосле проверки массив равен = "); arrayOut(arr);
    }

    //endregion

    //region task2.4
    // Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое) и
    // с помощью цикла (-ов) заполнить его диагональные элементы единицами.
    public static void arraySque()
    {
        int[][] arr = new int[4][4];
        for (int[] ints : arr) {
            Arrays.fill(ints, 0);
            System.out.println(Arrays.toString(ints));
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(i == j || (i+(j+1)) == arr[i].length)
                {
                    arr[i][j] = 1;
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }


    }
    //endregion

    //region task2.5
    // ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    public static void maxMinArray(int[] arr)
    {
        int min = arr[0]; int max = 0;
        for (int i: arr) {
            if(i <= min)
            {
                min = i;
            }
            else if (i >= max)
            {
                max = i;
            }
        }
        System.out.println("Массив: ");
        arrayOut(arr);
        System.out.println("\nМинимальное число: " + min);
        System.out.println("Маскимальное число: " + max);
    }
    //endregion

    //region task2.6
    // ** Написать метод, в который передается не пустой одномерный целочисленный массив,
    // метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
    // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||,
    // эти символы в массив не входят.
    public static void sumStoron(int[] arr)
    {
        if(arr.length == 0)
        {
            System.out.println("Массив не имеет элементов.");
        }
        int sumL = 0; int sumR = 0;
        int e = 1;
        for (int k : arr) {
            sumL += k;

            for (int j = e; j < arr.length; j++) {
                sumR += arr[j];
            }
            if(sumL == sumR)
            {
                System.out.println("true\nесть место, в котором сумма левой и правой части массива равны");
                break;
            }
            e++; sumR = 0;
        }
    }
    //endregion

    //region task2.7
    // **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
    // при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично.
    // Для усложнения задачи нельзя пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ]
    // при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
    // При каком n в какую сторону сдвиг можете выбирать сами.
    public static void arraNum(int[] arr, int num)
    {
        for (int i = num; i < 0; i++) {
            int temp1 = arr[arr.length -1];
            System.out.println("Изначальный массив: ");
            arrayOut(arr);
            System.out.println();
            for (int j = arr.length; j > 1; j--) {
                arr[j-1] = arr[j - 2];
            }
            arr[0] = temp1;
        }
        System.out.println("После смещения: ");
        arrayOut(arr);
        System.out.println();
    }
    //endregion
}
