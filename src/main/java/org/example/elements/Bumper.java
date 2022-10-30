package org.example.elements;

import org.example.visitors.Visitor;

public class Bumper extends Element{

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
    public void accept(Visitor visitor) {
        visitor.visitBumper(this);
    }

    @Override
    public void hit() {
        this.soundPlaying();
    }
}
