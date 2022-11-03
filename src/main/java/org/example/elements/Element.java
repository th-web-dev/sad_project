package org.example.elements;

import org.example.visitors.Visitor;

//Command Pattern: Request Class & Implement interface in all Elements
//Visitor Pattern: Implement "accept" Visitor method
public abstract class Element implements ElementActions {
    public int points;
    public int hitValue;
    public ElementMediator mediator;
    public String name;

    public Element(ElementMediator mediator, String name){
        this.mediator = mediator;
        this.name = name;
    }

    public void blinkingLED(){
        System.out.println("LEDs are blinking!");
    }

    public void soundPlaying(){
        System.out.println("Möp Möp Möp!");
    }

    public String toggleActive(String state){
        if(state == "inactive") {
            state = "active";
        } else {
            state = "inactive";
        }
        return state;
    }

    public void increasePoints() {
        this.points += hitValue;
    }

    public void launchBall() { }

    public void bounceBall() { }

    public void activate() { }

    public abstract int generatePoints();

    public abstract void accept(Visitor visitor);
}
