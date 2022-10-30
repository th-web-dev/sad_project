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
        System.out.println("\n" +
                "___________                        _________                      __  .__    .__                 \n" +
                "\\__    ___/__.__.______   ____    /   _____/ ____   _____   _____/  |_|  |__ |__| ____    ____   \n" +
                "  |    | <   |  |\\____ \\_/ __ \\   \\_____  \\ /  _ \\ /     \\_/ __ \\   __\\  |  \\|  |/    \\  / ___\\  \n" +
                "  |    |  \\___  ||  |_> >  ___/   /        (  <_> )  Y Y  \\  ___/|  | |   Y  \\  |   |  \\/ /_/  > \n" +
                "  |____|  / ____||   __/ \\___  > /_______  /\\____/|__|_|  /\\___  >__| |___|  /__|___|  /\\___  /  \n" +
                "          \\/     |__|        \\/          \\/             \\/     \\/          \\/        \\//_____/   \n");


    }
}