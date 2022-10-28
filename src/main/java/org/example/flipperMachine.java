package org.example;

public class flipperMachine {
    public String state= "No Credit";
    public int credit;

    public void insertCoin (int coin){
        this.credit += coin;

        if(credit > 1){
            this.state = "Ready";
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
                System.out.println("Game started! Let's rock!");
                break;
        }
    }

}
