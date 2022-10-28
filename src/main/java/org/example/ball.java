package org.example;

public class ball {
    private static final ball Ball = new ball();

    public static ball getInstance() {
        return Ball;
    }
}
