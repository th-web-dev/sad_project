package org.example.visitors;

import org.example.elements.*;

import java.util.List;

//Visitor Pattern: Specific Visitor
public class ResetVisitor implements Visitor{

    public void resetElements(List<Element> elements){
        for(Element element : elements){
            element.accept(this);
        }
    }


    @Override
    public void visitRamp(Ramp ramp) {
        ramp.hitValue = 50;
        ramp.close();
    }

    @Override
    public void visitHole(Hole hole) {
        hole.hitValue = 30;
    }

    @Override
    public void visitPlunger(Plunger plunger) {
        plunger.isOpen = false;
        plunger.hitValue = 80;
    }

    @Override
    public void visitSlingshot(Slingshot slingshot) {
        slingshot.hitValue = 20;
    }

    @Override
    public void visitBumper(Bumper bumper) {
        bumper.state = "inactive";
        bumper.hitValue = 20;
    }

    @Override
    public void visitTargetGroup(TargetGroup targetGroup) {
        targetGroup.resetTargets();
    }

    @Override
    public void visitTarget(Target target) {
        target.state = "inactive";
        target.hitValue = 20;
    }


}
