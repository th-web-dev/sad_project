package org.example.visitors;

import org.example.elements.*;

//Visitor Pattern: Interface
public interface Visitor {

    void visitRamp(Ramp ramp);
    void visitHole(Hole hole);
    void visitPlunger(Plunger plunger);
    void visitSlingshot(Slingshot slingshot);
    void visitBumper(Bumper bumper);
    void visitTargetGroup( TargetGroup targetGroup);
    void visitTarget(Target target);
}
