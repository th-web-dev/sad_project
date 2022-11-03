package org.example.visitors;

import org.example.Game;
import org.example.elements.*;

import java.util.List;

//Visitor Pattern: Specific Visitor
public class PunkteVisitor implements Visitor{

    int score = 0;

    public int sumElements(List<Element> elements){
        for(Element element : elements){
            element.accept(this);
        }
        return score;
    }

    @Override
    public void visitRamp(Ramp ramp) {
        addPointsToScore(ramp);
    }

    @Override
    public void visitHole(Hole hole) {
        addPointsToScore(hole);
    }

    @Override
    public void visitPlunger(Plunger plunger) {
        addPointsToScore(plunger);
    }

    @Override
    public void visitSlingshot(Slingshot slingshot) {
        addPointsToScore(slingshot);
    }

    @Override
    public void visitBumper(Bumper bumper) {
        addPointsToScore(bumper);
    }

    @Override
    public void visitTargetGroup(TargetGroup targetGroup) {

    }

    @Override
    public void visitTarget(Target target) {
        addPointsToScore(target);

    }

    public void addPointsToScore(Element element){
        this.score += element.points;
    }

}
