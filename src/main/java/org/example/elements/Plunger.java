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

    public void open() {
        this.isOpen = true;
    }

    public void close() { this.isOpen = false; }

    //Command Pattern
    @Override
    public void hit() {
        System.out.println("Plunger " + name + " hit!");
        increasePoints();
    }
}
