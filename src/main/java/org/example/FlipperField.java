package org.example;

import org.example.elements.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Composite Pattern: Head Class
// Mediator Pattern: Mediator
public class FlipperField implements ElementMediator {
    public List<Element> childFieldElements;
    public int score;

    public FlipperField(){
        childFieldElements = new ArrayList<>();
    }

    public void addElement(Element element){
        childFieldElements.add(element);
    }

    public void removeElement(Element element){
        childFieldElements.remove(element);
    }


    //    MEDIATOR CONTROLS
    // OPEN RAMP IF ALL TARGETS OF A GROUP ARE ACTIVE && RESET ALL TARGETS IF TRUE
    @Override
    public void checkTargetGroup(String name) {
        boolean result = false;
        TargetGroup thisGroup = null;
        for(Element e : childFieldElements){
            if(Objects.equals(e.name, name) && e instanceof TargetGroup){
                thisGroup = (TargetGroup)e;
                result = thisGroup.allTargetsActive();
            }
        }

        if(result){
            thisGroup.resetTargets();
            for(Element e : childFieldElements){
                if(Objects.equals(e.name, name) && e instanceof Ramp){
                    System.out.println(e.name + " Ramp open!");
                    ((Ramp)e).open();
                }
            }
        }
    }

    // IF ALL BUMPER ARE IN ACTIVE STATE ALL hitValues ARE GETTING DOUBLED
    public void checkBumper(){
        int i = 0, b = 0;
        for(Element e : childFieldElements){
            if( e instanceof Bumper) {
                b++;
                if (Objects.equals(((Bumper) e).state, "active")) i++;
            }
        }

        if(i == b) {
            System.out.println("All points are being doubled!");
            for(Element e : childFieldElements){
                e.hitValue = e.hitValue * 2;
            }
        }
    }

    // IF A HOLE IS HIT THE ACCORDING PLUNGER OPENS
    public void checkPlunger(String name){
        for(Element e : childFieldElements){
            if( e instanceof Plunger && Objects.equals(e.name, name)) {
                if(!((Plunger) e).isOpen){
                    System.out.println(name + " Plunger opened!");
                    ((Plunger) e).isOpen = true;
                }
            }
        }
    }

}
