package org.example.elements;

import org.example.visitors.Visitor;

public class Plunger extends Element {
    public boolean isOpen;

    public Plunger(){
        this.points = 0;
        this.isOpen = false;
        this.hitValue = 10;
    }

    public void hit(){

    }

    @Override
    public int generatePoints() {
        this.points=this.hitValue;
        return this.points;
    }

    @Override
    public void execute() {

    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitPlunger(this);
    }
}