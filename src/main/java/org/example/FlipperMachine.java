package org.example;

import org.example.abstract_factory.FontStyle;
import org.example.elements.*;

import java.util.Scanner;

public class FlipperMachine {
    public String state;
    public int credit;
    public FontStyle writeFont;
    public UserInterface ui;
    public FlipperField field;
    public Game game;

    public FlipperMachine(FontStyle writeFont, UserInterface ui) {
        this.writeFont = writeFont;
        this.credit = 0;
        this.ui = ui;
        this.state = "No Credit";
    }

    public void insertCoin(int coin) {
        this.credit += coin;

        if (credit >= 1) {
            this.state = "Ready";
            writeFont.printReady();
        }
    }

    public void pressStart() {
        switch (this.state) {
            case "No Credit" -> {
                System.out.println("No credit! Please insert some coin!");
                ui.initializeFlipper();
            }
            case "Playing" -> System.out.println("Created by Tobias Haag and Markus Maierhofer!");
            case "Ready" -> {
                this.state = "Playing";
                writeFont.printStart();
                startGame();
            }
        }
    }

    public void startGame() {
        this.credit--;
        this.field = createField();
        this.game = new Game(this.ui, this.field);
        int action = ui.gameControl();
        handleControl(action);
    }

    public FlipperField createField() {
        FlipperField field = new FlipperField();

        field.addElement(new Bumper(field, "GALAXY1"));
        field.addElement(new Bumper(field, "GALAXY2"));
        field.addElement(new Bumper(field, "GALAXY3"));
        field.addElement(new Slingshot(field, "LIGHTNING1"));
        field.addElement(new Slingshot(field, "LIGHTNING2"));
        field.addElement(new TargetGroup(5, field, "555"));
        field.addElement(new TargetGroup(5, field, "5FINGERS"));
        field.addElement(new Hole(field, "WORM"));
        field.addElement(new Hole(field, "BLACK"));
        field.addElement(new Ramp(field, "555"));
        field.addElement(new Ramp(field, "5FINGERS"));
        field.addElement(new Plunger(field, "LEFT"));
        field.addElement(new Plunger(field, "RIGHT"));

        return field;
    }

    public void mediateControl() {

        boolean result = game.initiateRoundv2();

        if (result) {
            System.out.println("Hit left or right Flipper!");
            //TODO: Add points to score
            handleControl(ui.gameControl());
        } else {
            //TODO: Reset board
            printBall(this.game.lifes);
        }
    }

    private void printBall(int lifes) {
        switch (lifes) {
            case 1 -> {
                writeFont.printBall3();
                handleControl(ui.gameControl());
            }
            case 2 -> {
                writeFont.printBall2();
                handleControl(ui.gameControl());
            }
            case 3 -> {
                writeFont.printBall1();
                handleControl(ui.gameControl());
            }
            case 0 -> {
                writeFont.printGameOver();
                gameOverGamble();
            }
        }
    }

    private void gameOverGamble() {
        int gamble = game.generateRandomNumber(0, 1);
        if (gamble == 1) {
            System.out.println("Congratulations! You won a free Game!");
            insertCoin(1);
            startGame();
        }
    }

    public void handleControl(int input) {
        Scanner scanner = new Scanner(System.in);
        switch (input) {
            case 1, 2 -> mediateControl();
            case 3 -> {
                game.launchBall();
                mediateControl();
            }
            case 4 -> {
                pressStart();
                handleControl(ui.gameControl());
            }
            case 5 -> {
                System.out.println("How many coins do you want to insert: ");
                insertCoin(scanner.nextInt());
                handleControl(ui.gameControl());
            }
            case 6 -> {
                this.writeFont = ui.selectFont();
                handleControl(ui.gameControl());
            }
            case 7 -> {
                this.game.difficulty = ui.selectDifficutly();
                handleControl(ui.gameControl());
            }
            case 8 -> {
                ui.showHelp();
                handleControl(ui.gameControl());
            }
        }
    }

}
