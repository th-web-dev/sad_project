package org.example;

import org.example.abstract_factory.FontStyle;
import org.example.elements.*;

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
        game.launchBall();

        while(game.lifes > 0){
            result = game.initiateRound();
        }


        //ui.gameControl();
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


}
