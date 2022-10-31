package org.example.elements;

import org.example.visitors.Visitor;

// Composite Pattern: Leaf Class
public class Target extends Element {

    public Target(){
        this.points = 0;
        this.hitValue = 10;
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

    }
}
