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
        ramp.close();
    }

    @Override
    public void visitHole(Hole hole) {

    }

    @Override
    public void visitPlunger(Plunger plunger) {

    }

    @Override
    public void visitSlingshot(Slingshot slingshot) {

    }

    @Override
    public void visitBumper(Bumper bumper) {

    }

    @Override
    public void visitTargetGroup(TargetGroup targetGroup) {
        targetGroup.resetTargets();
    }

    @Override
    public void visitTarget(Target target) {
        target.state = "inactive";
    }


}
