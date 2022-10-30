package org.example.elements;

import org.example.visitors.Visitor;

public abstract class Element {
    public int points;
    public int hitValue;

    public abstract int generatePoints();

    public abstract void execute();

    public abstract void accept(Visitor visitor);
}
