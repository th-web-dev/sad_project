package org.example.elements;

import org.example.visitors.Visitor;

// Composite Pattern: Leaf Class
public class Plunger extends Element {
    public boolean isOpen;

    public Plunger(ElementMediator mediator, String name){
        super(mediator, name);
        this.points = 0;
        this.isOpen = false;
        this.hitValue = 80;
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
        System.out.println(name + " Plunger hit!");
        increasePoints();
        isOpen = false;
    }
}
