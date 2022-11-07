package org.example;

import org.example.abstract_factory.*;

import java.util.Scanner;

public class UserInterface {
    FlipperMachine flipper;
    public UserInterface(){
        this.flipper = new FlipperMachine(new FontStyleDefault(), this);
    }

    public void initializeFlipper(){
        Scanner scanner = new Scanner(System.in);
        int input = 0;

        System.out.println("============================");
        System.out.println("|     MENU SELECTION       |");
        System.out.println("============================");
        System.out.printf("| Credit: %03d              |\n", flipper.credit);
        System.out.println("|                          |");
        System.out.println("| Options:                 |");
        System.out.println("|     1. Press Start       |");
        System.out.println("|     2. Insert Coin       |");
        System.out.println("|     3. Set/Change Font   |");
        System.out.println("|     4. Help              |");
        System.out.println("============================");

        System.out.println("Select Option: ");
        input = scanner.nextInt();
        input = validateInput(input, 1, 4);

        switch (input) {
            case 1 -> flipper.pressStart();
            case 2 -> {
                System.out.println("How many coins do you want to insert: ");
                input = scanner.nextInt();
                flipper.insertCoin(input);
                initializeFlipper();
            }
            case 3 -> {
                flipper.writeFont = selectFont();
                initializeFlipper();
            }
            case 4 -> {
                showHelp();
                initializeFlipper();
            }
        }

    }

    public int validateInput(int input, int from, int to){
        Scanner scanner = new Scanner(System.in);

        while((input < from || input > to )){
            System.out.println("Option does not exist! Please select a valid option: ");
            input = scanner.nextInt();
        }
        return input;
    }

    public FontStyle selectFont(){
        Scanner scanner = new Scanner(System.in);
        int selectedFont = 0;
        Printer printer = new DefaultPrinter();

        System.out.println("============================");
        System.out.println("|     FONT SELECTION       |");
        System.out.println("============================");
        System.out.println("| Options:                 |");
        System.out.println("|        1. Bulbhead       |");
        System.out.println("|        2. Grafiti        |");
        System.out.println("|        3. Default        |");
        System.out.println("============================");
        System.out.println("Select Option: ");
        selectedFont = scanner.nextInt();

        selectedFont = validateInput(selectedFont, 1, 3);
        System.out.println("Font Style selected!");

        if(selectedFont == 1){
            printer = new BulbheadPrinter();
        } else if(selectedFont == 2){
            printer = new GrafitiPrinter();
        }
        FontStyle writeFont = printer.createFontStyle();
        writeFont.printFont();

        return writeFont;
    }

    public void showHelp(){
        System.out.println("Some instructions.... Here is how you play!");
    }

    public int gameControl(){
        Scanner scanner = new Scanner(System.in);
        int input = 0;

        System.out.println("============================");
        System.out.printf("| Credit: %03d              |\n", flipper.credit);
        System.out.printf("| Lifes:  %d                |\n", flipper.game.lifes);
        System.out.printf("| Score:  %010d       |\n", flipper.game.score);
        System.out.println("|                          |");
        System.out.println("| Options:                 |");
        System.out.println("|     1. Left Flipper      |");
        System.out.println("|     2. Right Flipper     |");
        System.out.println("|     3. Launch Ball       |");
        System.out.println("|                          |");
        System.out.println("|     4. Press Start       |");
        System.out.println("|     5. Insert Coin       |");
        System.out.println("|     6. Set/Change Font   |");
        System.out.println("|     7. Help              |");
        System.out.println("|     8. Scoreboard        |");
        System.out.println("============================");

        System.out.println("Select Option: ");
        input = scanner.nextInt();
        input = validateInput(input, 1, 8);

        return input;
    }

    public void showScoreboard(ScoreBoard scoreBoard){
        Scanner scanner = new Scanner(System.in);
        int placement = 1, input = 0;

        System.out.println("================================");

        if(scoreBoard.scoreList.size() == 0){
            System.out.println("|        No Highscores         |");
        } else {
            for(Score score : scoreBoard.scoreList){
                System.out.printf("== %d. %-10s  %010d ==\n",placement, score.name, score.score);
                placement ++;
            }
        }
        System.out.println("================================");
        System.out.println("|     Press 0 to Exit          |");
        System.out.println("================================");

        System.out.println("Select Option: ");
        input = scanner.nextInt();

    }


}
