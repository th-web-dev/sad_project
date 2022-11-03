package org.example;

import org.example.elements.Element;
import org.example.elements.Plunger;
import org.example.elements.Ramp;
import org.example.elements.TargetGroup;

//Singleton Pattern: Singleton
public class Ball {
    private static final Ball ball = new Ball();

    private Ball (){}

    public static Ball getInstance() {
        return ball;
    }

    public boolean hitSomething(FlipperField field){
        int i = 1;
        int elementId = (int) (Math.random() * (field.childFieldElements.size() - 1)) + 1;
        for(Element e : field.childFieldElements){
            if(i == elementId){
                if (e instanceof Ramp && !((Ramp) e).isOpen){
                    return true;
                }

                if (e instanceof TargetGroup && ((TargetGroup) e).allTargetsActive()){
                    return true;
                }

                if (e instanceof Plunger && !((Plunger) e).isOpen){
                    return true;
                }
                e.hit();
                return false;
            }
            i++;
        }
        return false;
    }
}
