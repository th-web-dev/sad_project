package org.example.elements;

import org.example.visitors.Visitor;

// Composite Pattern: Leaf Class
public class Ramp extends Element{
    public boolean isOpen;
    public int runs;

    public Ramp(){
        this.points = 0;
        this.isOpen = false;
        this.runs = 0;
        this.hitValue = 50;
    }

    public void setOpen(){
        this.isOpen = true;
    }

    @Override
    public int generatePoints() {
        this.points=this.hitValue;
        return this.points;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitRamp(this);
    }

    //Command Pattern
    @Override
    public void hit() {

    }
}
