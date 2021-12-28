package com.prem;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.Runtime.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Start");

        //Load units
        Units units = new Units();

        //Display units
        units.DisplayUnits();
/* xxxx
        do {
            String opt=Menu();
            if (opt)
        } while (opt.equals(9))
*/

    }

    static String Menu() {
        System.out.println("Menu");
        System.out.println("0 - Display");
        System.out.println("1 - Repeat");
        System.out.println("2 - Learn");
        System.out.println("3 - Add");
        System.out.println("9 - Exit");

        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
        System.out.print("Choose an option: ");
        String str= sc.nextLine(); //reads string.
        return str;
    }
}
