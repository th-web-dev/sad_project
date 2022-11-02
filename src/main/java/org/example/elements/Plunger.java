package org.example.elements;

import org.example.visitors.Visitor;

// Composite Pattern: Leaf Class
public class Plunger extends Element {
    public boolean isOpen;

    public Plunger(ElementMediator mediator, String name){
        super(mediator, name);
        this.points = 0;
        this.isOpen = false;
        this.hitValue = 10;
    }

    @Override
    public int generatePoints() {
        this.points=this.hitValue;
        return this.points;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitPlunger(this);
    }

    //Command Pattern
    @Override
    public void hit() {

    }
}
