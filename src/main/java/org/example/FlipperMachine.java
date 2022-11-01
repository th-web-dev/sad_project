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

    public FlipperMachine(FontStyle writeFont, UserInterface ui){
        this.writeFont = writeFont;
        this.credit = 0;
        this.ui = ui;
        this.state = "No Credit";
    }

    public void insertCoin (int coin){
        this.credit += coin;

        if(credit > 1){
            this.state = "Ready";
            writeFont.printReady();
        }
    }

    public void pressStart(){
        switch(this.state){
            case "No Credit":
                System.out.println("No credit! Please insert some coin!");
                ui.initializeFlipper();
                break;
            case "Playing":
                System.out.println("Created by Tobias Haag and Markus Maierhofer!");
                break;
            case "Ready":
                this.state = "Playing";
                writeFont.printStart();
                startGame();
                break;
        }
    }

    public void startGame(){
        boolean result;
        this.credit--;
        this.field = createField();
        this.game = new Game(this.ui, this.field);
        int action = ui.gameControl();

        handleControl(action);

    }

    public FlipperField createField(){
        FlipperField field = new FlipperField();

        field.addElement(new Bumper());
        field.addElement(new Bumper());
        field.addElement(new Bumper());
        field.addElement(new Slingshot());
        field.addElement(new Slingshot());
        field.addElement(new TargetGroup(5));
        field.addElement(new TargetGroup(5));
        field.addElement(new Hole());
        field.addElement(new Hole());
        field.addElement(new Ramp());
        field.addElement(new Ramp());
        field.addElement(new Plunger());
        field.addElement(new Plunger());

        return field;

    }

    public void mediateControl(){

        boolean result = game.initiateRound();

        if(result){
            System.out.println("Hit left or right Flipper!");
            //TODO: Add points to score
            handleControl(ui.gameControl());
        } else {
            //TODO: Reset board
            printBall(this.game.lifes);
        }
    }

    private void printBall(int lifes) {
        switch(lifes){
            case 1 -> { writeFont.printBall3(); handleControl(ui.gameControl()); }
            case 2 -> { writeFont.printBall2(); handleControl(ui.gameControl()); }
            case 3 -> { writeFont.printBall1(); handleControl(ui.gameControl()); }
            case 0 -> { writeFont.printGameOver();}
        }
    }

    public void handleControl(int input){
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
