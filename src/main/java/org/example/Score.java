package org.example;

public class Score implements Comparable {
    public String name;
    public int score;

    public Score(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Object o) {
        int compareScore = ((Score) o).getScore();
        return compareScore - this.score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}


