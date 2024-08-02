package org.example.vo;

import java.util.*;

public class Batter {

    private List<String[]> battings;
    private int chance;
    private Pitcher pitcher;

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    public Batter(Pitcher pitcher, int chance) {
        this.pitcher = pitcher;
        this.battings = new ArrayList<>();
        this.chance = chance;
    }

    public List<String[]> getBattings() {
        return battings;
    }

    public String getPitchScore(){
        return this.pitcher.getScore();
    }

    /**
     * # 기능 정리 #
     * 1. 기회 cnt 감소
     * 2. 스코어 카운트 계산
     * 3. 스코어 pitches에 저장
     * 4. 스코어 리턴
     */

    public String[] checkScore(String battingScore){
//        battingScore = validateScore(battingScore);
        int strikeCount = 0, ballCount = 0;
        String pitchScore = this.pitcher.getScore();

        for(int i=0;i<battingScore.length();i++){
            char number = battingScore.charAt(i);

            if(pitchScore.indexOf(number) < 0) continue;

            if(pitchScore.charAt(i) == number) strikeCount++;
            else ballCount++;
        }
        String[] thisBatting = {battingScore, String.valueOf(strikeCount), String.valueOf(ballCount)};
        this.battings.add(thisBatting);
        chance--;
        return thisBatting;
    }

    private String validateScore(String score){
        Scanner scanner = new Scanner(System.in);
        score = score.trim();
        // 자리수 체크
        if(score.length() != 4){
            System.out.print("\n잘못 입력하셨습니다. 4자리 숫자를 입력해주세요.\n\n숫자입력 : ");
            return scanner.nextLine();
        }

        // 숫자인지 체크
        if(score.chars().allMatch(Character::isDigit)){
            System.out.print("잘못 입력하셨습니다. \n4자리 숫자를 입력해주세요.\n숫자입력 : ");
            return scanner.nextLine();
        }

        return score;
    }


}
