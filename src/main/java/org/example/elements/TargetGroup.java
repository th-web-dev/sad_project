package org.example.elements;

import org.example.visitors.Visitor;

import java.util.ArrayList;
import java.util.List;

// Composite Pattern: Head/Leaf Class
public class TargetGroup extends Element {
    private List<Target> targets;
    public int points;

    public TargetGroup(int amountOfTargets, ElementMediator mediator, String name){
        super(mediator, name);
        targets = new ArrayList<>();
        for (int i = 0; i < amountOfTargets; i++){
            targets.add(new Target(mediator, name));
        }
    }

    public boolean allTargetsActive(){
        int i = 0;
        for(Target t : targets){
            if(t.state == "active") i++;
        }
        return i == targets.size();
    }

    public void resetTargets(){
        for(Target t : targets){
            t.state = "inactive";
        }
    }

    @Override
    public int generatePoints() {
        targets.forEach(e -> points += e.generatePoints());
        return points;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitTargetGroup(this);
    }

    //Command Pattern
    @Override
    public void hit() {
        for (Target t : targets){
            if(t.state == "inactive"){
                t.hit();
                return;
            }
        }
    }
}
