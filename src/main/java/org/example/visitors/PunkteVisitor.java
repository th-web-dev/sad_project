package org.example.visitors;

import org.example.elements.*;

import java.util.List;

//Visitor Pattern: Specific Visitor
public class PunkteVisitor implements Visitor{

    public void sumElements(List<Element> elements){
        for(Element element : elements){
            element.accept(this);
        }
    }

    @Override
    public void visitRamp(Ramp ramp) {

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

    }

    @Override
    public void visitTarget(Target target) {

    }
}
