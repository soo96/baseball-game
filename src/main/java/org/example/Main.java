package org.example;

import org.example.vo.Batter;
import org.example.vo.Pitcher;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Boolean isHomerun = false;
        Scanner scanner = new Scanner(System.in);
        String format1 = "%s -> %s STRIKES, %s BALLS";
        String format2 = "@        %s -> %s STRIKES, %s BALLS       @";

        System.out.println("\n\n############  재밌는 숫자야구  #############");
        System.out.println("난이도를 선택해주세요.");
        System.out.println("1.EASY 2.STANDARD 3.HARD 4.EXTREME");
        System.out.print("선택 : ");
        int chance = setLevel(scanner.nextInt());
        scanner.nextLine();
        Batter batter = new Batter(new Pitcher(), chance);

        System.out.println("############  PLAY BALL!   #############\n\n");

        for (int i=1;i<=chance;i++){
            System.out.print(String.format("%s번째 시도 : ", i));
            String[] thisBatting = batter.checkScore(scanner.nextLine());

            System.out.println("결과 : " + String.format(format1, thisBatting[0], thisBatting[1], thisBatting[2]));

            if( Integer.parseInt(thisBatting[1]) == 4) {
                isHomerun = true;
                break;
            }

            System.out.println("\n@@@@@@@@@@@@@   SCORE BOARD  @@@@@@@@@@@@@@");
            System.out.println("@                                         @");
            batter.getBattings().iterator().forEachRemaining(e -> System.out.println(String.format(format2,e[0],e[1],e[2])));
            System.out.println("@                                         @");
            System.out.println("@        남은 회수 : "+batter.getChance()+"                      @");
            System.out.println("@                                         @");
            System.out.println("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
        }


        System.out.println("\n\n\n");

        if(isHomerun){
            System.out.println("정답입니다!!!!!");
            System.out.println("HOME RUN !!!");
        }else{
            System.out.println("아쉽지만 다음 기회에... ㅠㅠ");
            System.out.println("정답 : "+batter.getPitchScore());
        }

    }


    public static int setLevel(int choice){
        return Level.findChance(choice);
    }

}