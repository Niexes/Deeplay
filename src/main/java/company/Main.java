package company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            InfoReader.setInfo("C:\\Users\\Maria\\IdeaProjects\\deepplay\\src\\main\\resources\\TestFile");
            try {
                System.out.println(Solution.getResult(sc.nextLine(), sc.nextLine()));
            } catch (RaceException e) {
                System.out.println(e.getMessage());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
