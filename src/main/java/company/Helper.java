package company;

import java.io.IOException;
import java.util.Map;

public class Helper {
    private static int BEST_SUM = -1;

    public static char[][] getField(String field) throws IOException{
        char[] charArray = field.toCharArray(); //этот метод вернет нам игровое поле в виде матрицы
        char[][] newField = new char[4][4];
        if (field.length()!=16) {
            throw new IOException("Неверный размер игрового поля!");
        }
        for (int i=0; i<field.length();i++) {
            if (field.charAt(i)!='S' || field.charAt(i)!='T' || field.charAt(i)!='W' || field.charAt(i)!='P') {
                throw new IOException("Неверная кодировка игрового поля!");
            }
        }
        int n = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                newField[i][j] = charArray[n];
                n++;
            }
        }
        return newField;
    }

    public static int[][] getCostFromMap(String race, char[][] field) throws RaceException {
        int[][] intField = new int[4][4];
        Map<Character, Integer> raceInfo = InfoReader.INFO.get(race);
        if (raceInfo == null) {
            throw new RaceException("Wrong race!");
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                intField[i][j] = raceInfo.get(field[i][j]);
            }
        }
        return intField;
    }


    public static int recursive(int[][] mas, int x, int y, int sum) {

        if ((x == 3) && (y == 3)) {
            if ((BEST_SUM < 0) || (sum < BEST_SUM)) {
                BEST_SUM = sum;
            }
        } else {
            if (x < 3) {
                recursive(mas, x + 1, y, sum + mas[x + 1][y]);
            }
            if (y < 3) {
                recursive(mas, x, y + 1, sum + mas[x][y + 1]);
            }
        }
        return BEST_SUM;
    }
/*-----------------преобразование чарового массива в интовый для версии без считывания из файла--------------
    public static int[][] fieldCostForRace(String race, char[][] field) throws RaceException {
        int[][] intField = new int[4][4];
        if (race.equals("Human")) { // заполняем интовый массив если раса человек
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (field[i][j] == 'W') {
                        intField[i][j] = 2;
                    } else if (field[i][j] == 'S') {
                        intField[i][j] = 5;
                    } else if (field[i][j] == 'T') {
                        intField[i][j] = 3;
                    } else if (field[i][j] == 'P') {
                        intField[i][j] = 1;
                    }
                }
            }
        } else if (race.equals("Woodman")) { // заполняем интовый массив если раса леший
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (field[i][j] == 'W') {
                        intField[i][j] = 3;
                    } else if (field[i][j] == 'S') {
                        intField[i][j] = 3;
                    } else if (field[i][j] == 'T') {
                        intField[i][j] = 2;
                    } else if (field[i][j] == 'P') {
                        intField[i][j] = 2;
                    }
                }
            }
        } else if (race.equals("Swamper")) { // заполняем интовый массив если раса водяной
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (field[i][j] == 'W') {
                        intField[i][j] = 2;
                    } else if (field[i][j] == 'S') {
                        intField[i][j] = 2;
                    } else if (field[i][j] == 'T') {
                        intField[i][j] = 5;
                    } else if (field[i][j] == 'P') {
                        intField[i][j] = 2;
                    }
                }
            }
        } else {
            throw new RaceException("Wrong race!");
        }
        return intField;
    }*/



}

