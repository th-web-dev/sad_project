package org.example;

import org.example.elements.Element;
import java.util.ArrayList;
import java.util.List;

public class FlipperField {
    public List<Element> childFieldElements;
    public int score;

    public FlipperField(){
        childFieldElements = new ArrayList<>();
    }


    public int generatePoints() {
        score = 0;
        childFieldElements.forEach(e -> score += e.generatePoints());
        return score;
    }

    public void addElement(Element element){
        childFieldElements.add(element);
    }

    public void removeElement(Element element){
        childFieldElements.remove(element);
    }

}
