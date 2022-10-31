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

    }
}