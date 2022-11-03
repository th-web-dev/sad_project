package org.example.elements;

import org.example.visitors.Visitor;

// Composite Pattern: Leaf Class
public class Ramp extends Element {
    public boolean isOpen;
    public int runs;

    public Ramp(ElementMediator mediator, String name) {
        super(mediator, name);
        this.points = 0;
        this.isOpen = false;
        this.runs = 0;
        this.hitValue = 50;
    }

    public void open() {
        this.isOpen = true;
    }

    public void close() { this.isOpen = false; }

    @Override
    public int generatePoints() {
        this.points = this.hitValue;
        return this.points;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitRamp(this);
    }

    //Command Pattern
    @Override
    public void hit() {
        System.out.println("Ramp " + name + " hit!");
        close();
        increasePoints();
    }
}
