package org.example;

import org.example.abstract_factory.FontStyle;

public class FlipperMachine {
    public String state;
    public int credit;
    public FontStyle writeFont;
    public UserInterface ui;
    public FlipperField field;
    public Ball ball;

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

    }

}
