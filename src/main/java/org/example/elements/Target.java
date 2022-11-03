package org.example.elements;

import org.example.visitors.Visitor;

// Composite Pattern: Leaf Class
public class Target extends Element {
    public String state;

    public Target(ElementMediator mediator, String name){
        super(mediator, name);
        this.points = 0;
        this.hitValue = 20;
        this.state = "inactive";
    }


    @Override
    public int generatePoints() {
        this.points=this.hitValue;
        return points;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitTarget(this);
    }

    //Command Pattern
    @Override
    public void hit() {
        System.out.println("Target " + name + " hit!");
        increasePoints();
        this.state = "active";
        mediator.checkTargetGroup(name);
    }
}
