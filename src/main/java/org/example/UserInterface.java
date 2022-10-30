package org.example;

import org.example.abstract_factory.BulbheadPrinter;
import org.example.abstract_factory.FontStyle;
import org.example.abstract_factory.GrafitiPrinter;
import org.example.abstract_factory.Printer;

import java.util.Scanner;

public class UserInterface {

    public void initializeFlipper(){
        Scanner scanner = new Scanner(System.in);
        int selectedFont = 0, coins = 0, input = 0;

        System.out.println("============================");
        System.out.println("|     FONT SELECTION       |");
        System.out.println("============================");
        System.out.println("| Options:                 |");
        System.out.println("|        1. Bulbhead       |");
        System.out.println("|        2. Grafiti        |");
        System.out.println("============================");
        System.out.println("Select Option: ");

        while(selectedFont == 0) {
            selectedFont = scanner.nextInt();
            if(!(selectedFont == 1 || selectedFont == 2)){
                System.out.println("Invalid selection! Please choose  number from the menu:");
                selectedFont = 0;
            }
        }
        System.out.println("Font Style selected!");

        Printer printer = new GrafitiPrinter();

        if(selectedFont == 1){
            printer = new BulbheadPrinter();
        }
        FontStyle writeFont = printer.createFontStyle();

        System.out.println("============================");
        System.out.println("|     MENU SELECTION       |");
        System.out.println("============================");
        System.out.println("| Options:                 |");
        System.out.println("|        1. Press Start    |");
        System.out.println("|        2. Insert Coin    |");
        System.out.println("============================");
        System.out.println("Select Option: ");
        input = scanner.nextInt();
        FlipperMachine flipper = new FlipperMachine(writeFont);

        switch(input){
            case 1:
                flipper.pressStart();
                break;
            case 2:
                System.out.println("How many coins do you want to insert: ");
                coins = scanner.nextInt();
                flipper.insertCoin(coins);
                break;
        }
    }
}
