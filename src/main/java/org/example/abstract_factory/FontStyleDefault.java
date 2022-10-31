package org.example.abstract_factory;

public class FontStyleDefault implements FontStyle{
    @Override
    public void printStart() {
        System.out.println("START!");
    }

    @Override
    public void printGameOver() {
        System.out.println("GAME OVER!");
    }

    @Override
    public void printBall1() {
        System.out.println("BALL 1!");
    }

    @Override
    public void printBall2() {
        System.out.println("BALL 2!");
    }

    @Override
    public void printBall3() {
        System.out.println("BALL 3!");
    }

    @Override
    public void printReady() {
        System.out.println("READY!");
    }

    @Override
    public void printFont() {
        System.out.println("FONT SAMPLE!");
    }
}
