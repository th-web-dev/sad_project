package org.example.elements;

import org.example.visitors.Visitor;

import java.util.ArrayList;
import java.util.List;

// Composite Pattern: Head/Leaf Class
public class TargetGroup extends Element {
    private List<Target> targets;
    public int points;

    public TargetGroup(int amountOfTargets){
        targets = new ArrayList<>();

        for (int i = 0; i < amountOfTargets; i++){
            targets.add(new Target());
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

    @Override
    public void hit() {

    }
}
