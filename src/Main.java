import FindMinMaxTwoThreads.FindMinMaxTwoThreads;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("getErrorNum() = " + getErrorNum());

    }

    public static int getErrorNum() {
        try {
            throw new IllegalAccessException();
        } catch (IllegalAccessException e) {
            System.out.println("catch");
            return 1;
        } finally {
            System.out.println("finally");
            return 2;
        }
    }
}
