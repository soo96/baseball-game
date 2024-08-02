package org.example.vo;

import java.util.Random;

public class Pitcher {
    private String score;


    public String getScore() {
        return score;
    }

    public Pitcher() {
        makeScore();
    }

    private void makeScore() {
        Random random = new Random();
        String score = "";
        while (score.length()<4){
            String num = random.nextInt(10)+"";
            if(score.indexOf(num) == -1) score += num;
        }
        this.score = score;
    }


}
