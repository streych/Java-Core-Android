package lesson9;
//Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
// При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
//Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
// Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
// должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
//В методе main() вызвать полученный метод,
// обработать возможные исключения MyArraySizeException и MyArrayDataException и вывести результат расчета.


public class MyException {

    public static void main(String[] args){
        final int size = 4;
        String[][] arr = new String[size][size];

        //заполнить массив
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = "1";
            }
        }
        //arr[2][3] = "f"; //искусственная ошибка
        arrayMy(arr);
    }

    //Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
    public static void arrayMy(String[][] arr){
        int sum = 0;
        //При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
        if (arr.length > 4){
            throw new MyArraySizeException();
        }
        //Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                // Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),

                try{
                    sum += Integer.parseInt(arr[i][j]);
                }
                catch (NumberFormatException e){
                    // должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
                    throw new MyArrayDataException(i , j, arr[i][j]);
                }
            }
        }
        System.out.println(sum);
    }
}

class MyArraySizeException extends ArrayIndexOutOfBoundsException{
    @Override
    public String toString() {
        return "Вы вышли за пределы массива";
    }
}

class MyArrayDataException extends NumberFormatException {

    int i, j;
    String s;

    public MyArrayDataException(int i, int j, String s) {
        this.i = i;
        this.j = j;
        this.s = s;
    }

    @Override
    public String toString() {
        return "В ячейке двумерного массива с координатами " + i + ", " + j + " .Элемент не является числом. Элемент = " + s;
    }
}
