package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoreBoard {
    List<Score> scoreList;

    public ScoreBoard(){
        scoreList = new ArrayList<>();
    }

    public void addScore (Score score){
        scoreList.add(score);
        Collections.sort(scoreList);
    }
}
