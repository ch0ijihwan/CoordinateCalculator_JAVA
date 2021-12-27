package view;

import java.util.Scanner;

public class Input {
    private static final Scanner SCANNER = new Scanner(System.in);

    private Input() {
    }

    public static String input(){
        return SCANNER.next();
    }
}
