package org.example.elements;

import org.example.visitors.Visitor;

// Composite Pattern: Leaf Class
public class Hole extends Element {

    public Hole (ElementMediator mediator, String name){
        super(mediator, name);
        this.points = 0;
        this.hitValue = 30;
    }


    @Override
    public int generatePoints() {
        this.points=this.hitValue;

        return this.points;
    }


    @Override
    public void accept(Visitor visitor) {

    }

    //Command Pattern
    @Override
    public void hit() {

    }
}
