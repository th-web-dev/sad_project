package org.example;

import org.example.abstract_factory.FontStyle;

public class FlipperMachine {
    public String state= "No Credit";
    public int credit;
    FontStyle writeFont;

    public FlipperMachine(FontStyle writeFont){
        this.writeFont = writeFont;
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
            case "NoCredit":
                System.out.println("No credit! Please insert some coin!");
                break;
            case "Playing":
                System.out.println("Created by Tobias Haag and Markus Maierhofer!");
                break;
            case "Ready":
                this.state = "Playing";
                writeFont.printStart();
                break;
        }
    }

}
