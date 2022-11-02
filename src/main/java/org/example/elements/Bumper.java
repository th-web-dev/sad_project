package org.example.elements;

import org.example.visitors.Visitor;

// Composite Pattern: Leaf Class
public class Bumper extends Element{

    public String state;

    public Bumper(ElementMediator mediator, String name){
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
        visitor.visitBumper(this);
    }

    //Command Pattern
    @Override
    public void hit() {
        this.state = toggleActive(this.state);
        mediator.checkBumper();
    }
}
