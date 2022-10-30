package org.example;

import org.example.abstract_factory.BulbheadPrinter;
import org.example.abstract_factory.FontStyle;
import org.example.abstract_factory.GrafitiPrinter;
import org.example.abstract_factory.Printer;
import org.example.elements.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        UserInterface ui = new UserInterface();
        ui.initializeFlipper();



        /*Scanner scanner = new Scanner(System.in);
        int selectedFont = 0;

        FlipperField field = new FlipperField();
        field.addElement(new Plunger());
        field.addElement(new Slingshot());
        field.addElement(new Bumper());
        field.addElement(new Hole());
        field.addElement(new TargetGroup(5));

        for(ElementActions action : field.childFieldElements){
            action.hit();
        }

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

        Printer printer = new GrafitiPrinter();

        if(selectedFont == 1){
            printer = new BulbheadPrinter();
        }

        FontStyle writeFont = printer.createFontStyle();

        writeFont.printStart();*/


    }
}