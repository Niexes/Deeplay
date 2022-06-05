package company;


import java.io.IOException;

public class Solution {


    public static int getResult(String field, String race) throws RaceException, IOException {


        char[][] newCharField = Helper.getField(field); //данный метод вернет нам поле из чаров char[][]
        int [][] newIntField = Helper.getCostFromMap(race, newCharField);
        return (Helper.recursive(newIntField,0,0,0));


    }
}
