package org.example;

public class Ball {
    private static final org.example.Ball Ball = new Ball();

    public static org.example.Ball getInstance() {
        return Ball;
    }
}
