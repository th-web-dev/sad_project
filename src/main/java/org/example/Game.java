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
    public int difficulty;

    public Game(UserInterface ui, FlipperField field){
        this.ui = ui;
        this.field = field;
        this.ball = Ball.getInstance();
        this.lifes = 3;
        this.score = 0;
        this.difficulty = 1;
    }

    public void launchBall(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("The Ball is in the Plunger! Type a number from 1 to 10 to launch the ball onto the field:");
        scanner.nextInt();
    }

    public boolean initiateRound(){
        Scanner scanner = new Scanner(System.in);
        int randomNumber = generateRandomNumber(1,100);
        int guess, tries = convertDifficultyToTries(), lastGuess = 0;
        boolean isLower = false, running = true;
        System.out.println("Guess the number between 1 and 100! You have "+tries+" guesses: ");

        for(int i=1; i<=tries; i++){
            guess = scanner.nextInt();

            if((isLower && lastGuess < guess) || (!isLower && lastGuess > guess)){
                System.out.println("Ball lost!");
                this.lifes --;
                return false;
            }

            if(guess > randomNumber && i != tries){
                running = true;
                System.out.println("Number is lower than your guess! Next: ");
                lastGuess = guess;
                isLower = true;
                while (running){
                    running = this.ball.hitSomething(this.field);
                }

            } else if( guess < randomNumber && i != tries){
                running = true;
                System.out.println("Number is higher than your guess! Next: ");
                lastGuess = guess;
                isLower = false;
                while (running){
                    running = this.ball.hitSomething(this.field);
                }

            } else if (guess == randomNumber) {
                System.out.println("Your are right! The number is: " + randomNumber);
                PunkteVisitor punkteVisitor = new PunkteVisitor();
                this.score = punkteVisitor.sumElements(field.childFieldElements);
                System.out.println(score);
                return true;
            }
        }

        System.out.println("Ball lost!");
        this.lifes --;
        return false;
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

        PunkteVisitor punkteVisitor = new PunkteVisitor();
        this.score = punkteVisitor.sumElements(field.childFieldElements);

        return true;
    }

    public int generateRandomNumber(int min, int max){
        return (int) (Math.random() * (max - min)) + min;
    }

    public int convertDifficultyToTries(){
        return switch (difficulty) {
            case 2 -> 7;
            case 3 -> 5;
            default -> 10;
        };
    }

}