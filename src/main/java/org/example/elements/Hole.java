package org.example.elements;

public class Hole extends Element {

    public Hole (){
        this.points = 0;
        this.hitValue = 30;
    }


    @Override
    public int generatePoints() {
        this.points=this.hitValue;

        return this.points;
    }

    @Override
    public void execute() {

    }
}
