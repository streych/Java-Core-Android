package lesson4;

import java.util.Random;
import java.util.Scanner;

public class KrestZero {

    public static char[][] map;
    public static final int SIZE = 5;
    public static final char DOTS_EMPTY = '*';
    public static final char DOTS_O = 'O';
    public static final char DOTS_X = 'X';
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();
    public static final int WIN_COMBINATION = 4;
    private static int ss = SIZE;

    public static void main(String[] args) {
        initMap();
        printMap();
         while (true){
            humanTurn();
            printMap();
            /*if (checkWin(DOTS_X, WIN_COMBINATION))
            {
                System.out.println("Вы выиграли");
                break;
            }*/
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }

            aiTurn();
            printMap();
             /*if (checkWin(DOTS_O, WIN_COMBINATION))
             {
                 System.out.println("Вы выиграли");
                 break;
             }*/
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
        do {
            int count = 0;
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE - 1; j++) {
                    if (map[i][j] == DOTS_O && map[i][j + 1] == DOTS_O) {
                        if (count == WIN_COMBINATION - 1) {
                            x = i;
                            y = j + 1;
                        }
                        count++;
                    } else {
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
        int k = 1;
        int horizontal = 0;
        int vertikal = 0;
        int deoganal = 0; int deoganal2 = 0; int deoganal3 = 0; int deoganal4 = 0; int deoganal5 = 0;

        for (int i = 0, y = i + 1; i < map.length; i++) {
            k++;

            if(map[i][i] == symb) {
                deoganal++;
            }
            else deoganal = 0;

            if(map[i][map.length - i - 1] == symb) {
                deoganal2++;
            }
            else deoganal2 = 0;

            for (int j = 0, x = j + 1; j < map.length; j++) {
                if (winCombimation == horizontal || winCombimation == vertikal || winCombimation == deoganal ||
                        winCombimation == deoganal2 || winCombimation == deoganal3 || 
                        winCombimation == deoganal4 || winCombimation == deoganal5) {
                    return true;
                }
                if (map[j][i] == symb && map[x][i] == symb){
                    vertikal++;
                }
                else vertikal = 0;

                if(symb == map[i][j] && map[i][x] == symb) {
                    horizontal++;
                }
                else horizontal = 0;

            }

            for (int p = 0; p < map.length; p++) {
                for (int l = 0; l < map.length-1; l++) {
                    if(map[p][l] ==  map[p][l + 1]) {
                        deoganal3++;
                    }
                    else deoganal3 = 0;
                    if(map[l][p] ==  map[l + 1][p]) {
                        deoganal4++;
                    }
                    else deoganal4 = 0;
                }
            }
        // не работает. Не могу понять почему. диагональ снизу вверх
            /*for (int ii = 0; ii < ss; ii++) {
                for (int jj = ss - 1; jj > 0 ; jj--) {
                    if(map[ii][jj] ==  map[ii + 1][jj - 1]) {
                        deoganal5++;
                    }
                    else deoganal5 = 0;
                }
            }*/
        }
        return false;
    }




}
