package org.example;

import org.example.elements.*;

public class Main {
    public static void main(String[] args) {
        FlipperField field = new FlipperField();
        field.addElement(new Plunger());
        field.addElement(new Slingshot());
        field.addElement(new Bumper());
        field.addElement(new Hole());
        field.addElement(new TargetGroup(5));

        for(ElementActions action : field.childFieldElements){
            action.hit();
        }

        System.out.println(field.generatePoints());
    }
}