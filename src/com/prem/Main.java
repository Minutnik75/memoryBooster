package com.prem;


import java.util.Scanner;

public class Main {
    // Declaring ANSI_RESET so that we can reset the color
    public static final String ANSI_RESET = "\u001B[0m";

    // Declaring the color
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";


    public static void main(String[] args) {
        boolean shouldContinue=true;

        System.out.println("Start");

        //Load units
        Units units = new Units();

        //Display units
        //units.displayUnits();

        while(shouldContinue) {
            int userChoice = ShowMenu();
            switch (userChoice){
                case 0 -> units.displayUnits();
                case 1 -> units.repeatUnits();
                case 2 -> units.Learn();
                case 3 -> System.out.println("Wybrano opcję 3");
                case 7 -> units.Load();
                case 8 -> units.Save();

                case 9 -> shouldContinue=false;
             }
        }

        units.Exit();
    }

    private static int ShowMenu() {

        System.out.println("==================================================");
        System.out.println(ANSI_GREEN+"Menu"+ANSI_RESET);
        System.out.println("0 - Display");
        System.out.println("1 - Repeat");
        System.out.println("2 - Learn");
        System.out.println("3 - Add");
        System.out.println("7 - Load");
        System.out.println("8 - Save");
        System.out.println("9 - Exit");

        Scanner scanner= new Scanner(System.in); //System.in is a standard input stream.
        System.out.print("Choose an option: ");

        return scanner.nextInt();
    }
}
