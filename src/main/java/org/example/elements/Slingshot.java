package org.example.elements;

import org.example.visitors.Visitor;

// Composite Pattern: Leaf Class
public class Slingshot extends Element{

    public Slingshot(ElementMediator mediator, String name){
        super(mediator, name);
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
        visitor.visitSlingshot(this);
    }

    //Command Pattern
    @Override
    public void hit() {
        System.out.println("Slingshot " + name + " hit!");
        increasePoints();
    }
}
