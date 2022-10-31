package org.example;

//Singleton Pattern: Singleton
public class Ball {
    private static final Ball ball = new Ball();

    private Ball (){}

    public static Ball getInstance() {
        return ball;
    }
}
