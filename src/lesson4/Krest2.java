package lesson4;

import java.util.Random;
import java.util.Scanner;

public class Krest2 {

    public static char[][] map;
    public static final int SIZE = 4;
    public static final char DOTS_EMPTY = '*';
    public static final char DOTS_O = 'O';
    public static final char DOTS_X = 'X';
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();
    public static final int WIN_COMBINATION = 3;

    public static void main(String[] args) {


        initMap();
        printMap();
        while (true){
            humanTurn();
            printMap();
            if (checkWin(DOTS_X, WIN_COMBINATION))
            {
                System.out.println("Вы выиграли");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }

            aiTurn();
            printMap();
             if (checkWin(DOTS_O, WIN_COMBINATION))
             {
                 System.out.println("Вы выиграли");
                 break;
             }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");

    }

    public static void initMap(){
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOTS_EMPTY;
            }
        }
    }

    public static void printMap(){
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void humanTurn(){
        int x,y;
        System.out.println("Введите пожалуйста свой ход в формате x и y через пробел");
        do {

            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;

        }
        while (!isValidate(x,y));
        map[y][x] = DOTS_X;
    }

    public static void aiTurn(){
        int x = 0, y = 0;
        do
        {
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map.length; j++) {
                    if (ckeckLine(i,j, WIN_COMBINATION - 1, 1, 0, DOTS_X)) {
                        x = i;
                        y = j;
                    }
                    else if (ckeckLine(i, j, WIN_COMBINATION - 1, 0, 1, DOTS_X)){
                        x = i;
                        y = j;
                    }
                    else if (ckeckLine(i, j, WIN_COMBINATION - 1, 1, 1, DOTS_X)) {
                        x = i;
                        y = j;
                    }
                    else if (ckeckLine(i, j, WIN_COMBINATION - 1 , 1, -1, DOTS_X)) {
                        x = i;
                        y = j;
                    }
                    else
                    {
                        x = random.nextInt(SIZE);
                        y = random.nextInt(SIZE);
                    }
                }
            }

        }
        while (!isValidate(x,y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOTS_O;
    }

    public static boolean isValidate(int x, int y){
        if(x < 0 || x >= SIZE || y < 0 || y >= SIZE) return  false;
        if(map[y][x] == DOTS_EMPTY) return true;
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOTS_EMPTY)
                    return false;
            }
        }
        return true;
    }

    public static boolean checkWin(char symb, int winCombimation){

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (ckeckLine(i, j, winCombimation, 1, 0, symb)) return true;
                if (ckeckLine(i, j, winCombimation, 1, 1, symb)) return true;
                if (ckeckLine(i, j, winCombimation, 0, 1, symb)) return true;
                if (ckeckLine(i, j, winCombimation, 1, -1, symb)) return true;
            }

        }
        return false;
    }

    public static boolean ckeckLine(int x, int y, int win, int maxX, int maxY, char symb){
        // маскимальное поле
        int fieldX = x + (win) * maxX;
        int filedY = y + (win) * maxY;
        //выходим за рамки
        if (!isValidate(fieldX, filedY)) return false;

        for (int i = 0; i < win; i++) {
            if (map[x + i * maxX][y + i * maxY] != symb) return false;
        }
        return true;
    }

}
