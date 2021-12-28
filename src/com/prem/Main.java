package com.prem;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean shouldContinue=true;

        System.out.println("Start");

        //Load units
        Units units = new Units();

        //Display units
        units.DisplayUnits();

        while(shouldContinue) {
            int userChoice = ShowMenu();
            switch (userChoice){
                case 0 -> units.DisplayUnits();
                case 1 -> System.out.println("Wybrano opcję 1");
                case 2 -> System.out.println("Wybrano opcję 2");
                case 3 -> System.out.println("Wybrano opcję 3");

                case 9 -> shouldContinue=false;
             }
        }
    }

    private static int ShowMenu() {

        System.out.println("Menu");
        System.out.println("0 - Display");
        System.out.println("1 - Repeat");
        System.out.println("2 - Learn");
        System.out.println("3 - Add");
        System.out.println("9 - Exit");

        Scanner scanner= new Scanner(System.in); //System.in is a standard input stream.
        System.out.print("Choose an option: ");


        return scanner.nextInt();
    }
}
