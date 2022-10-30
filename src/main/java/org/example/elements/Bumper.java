package org.example.elements;

public class Bumper extends Element {

    public Bumper(){
        this.points = 0;
        this.hitValue = 20;
    }

    @Override
    public int generatePoints() {
        this.points=this.hitValue;
        return points;
    }

    @Override
    public void execute() {

    }
}
