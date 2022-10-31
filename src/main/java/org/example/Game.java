package org.example;

//Vermittler Pattern: Vermittler
public class Game {
    public UserInterface ui;
    public FlipperField field;
    public Ball ball;

    public Game(UserInterface ui, FlipperField field){
        this.ui = ui;
        this.field = field;
        this.ball = Ball.getInstance();
    }



}