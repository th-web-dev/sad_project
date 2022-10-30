package org.example.elements;

import org.example.visitors.Visitor;

public class Slingshot extends Element {

    public Slingshot(){
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

    @Override
    public void accept(Visitor visitor) {
        visitor.visitSlingshot(this);
    }
}