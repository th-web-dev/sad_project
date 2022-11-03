package org.example;

import org.example.visitors.PunkteVisitor;

import java.util.Scanner;

//Vermittler Pattern: Vermittler
public class Game {
    public UserInterface ui;
    public FlipperField field;
    public Ball ball;
    public int lifes;
    public int score;
    public String state;

    public Game(UserInterface ui, FlipperField field){
        this.ui = ui;
        this.field = field;
        this.ball = Ball.getInstance();
        this.lifes = 3;
        this.score = 0;
        this.state = "running";
    }

    public void launchBall(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("The Ball is in the Plunger! Type a number from 1 to 10 to launch the ball onto the field:");
        scanner.nextInt();
        this.state = "launched";
    }

    public boolean initiateRoundv2(){
        boolean running;
        int randomNumber = generateRandomNumber(1,10);
        for (int i = 0; i < randomNumber; i++) {
            running = true;
            while (running){
                running = this.ball.hitSomething(this.field);
            }
        }

        int chanceOfLoss = generateRandomNumber(1,3);

        PunkteVisitor punkteVisitor = new PunkteVisitor();
        this.score = punkteVisitor.sumElements(field.childFieldElements);

        return chanceOfLoss != 3;
    }

    public int generateRandomNumber(int min, int max){
        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }


}