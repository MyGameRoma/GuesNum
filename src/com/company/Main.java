package com.company;

import com.sun.security.jgss.GSSUtil;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static Random rand = new Random();
    static ArrayList<GameResult> users = new ArrayList<>();

    public static void main(String[] args) {
        String answer;
        LoadResults();

        do {

            System.out.println("What you name");
            String name =scan.next();
            long t1 =System.currentTimeMillis();
            int myNum = rand.nextInt(100) + 1;
            System.out.println(myNum);
            boolean userwon = false;

            for (int i = 1; i < 11; i++) {

                int userNum = askint("Enter you number from 1 to 100", 1, 100);

                if (userNum == myNum) {
                    System.out.println(name +" Molodec Ti ugodal s " + i + " popitki");
                    userwon = true;
                    long t2= System.currentTimeMillis();
                    GameResult r = new GameResult();
                    r.setName(name);
                    r.setTrisCount(i);
                    r.setTime(t2 - t1);
                    users.add(r);
                    break;

                } else if (userNum > myNum) {
                    System.out.println("NEt chutj menjshe");
                } else if (userNum < myNum) {
                    System.out.println("Net chutj boljshe");
                }
            }
            if (!userwon) {
                System.out.println("loozer");
            }

        } while (askWord("Do you ready for next round? yes or no"));

        showResults2();


        System.out.println("goodbaiii");

        File file = new File ("myfile.txt");
        try (PrintWriter out = new PrintWriter(file)){
            for (GameResult result : users) {
                    out.printf("%s %d %d\n",
                            result.getName(),
                            result.getTrisCount(),
                            result.getTime());
                }

        } catch(IOException e){
            System.out.println("Someting go wrong!");

        }

    }

    private static void LoadResults() {
        File file = new File ("myfile.txt");
        try (Scanner in = new Scanner(file)){
            while (in.hasNext()){
                GameResult r =new GameResult();
                String name = in.next();
                int trisCound = in.nextInt();
                long time = in.nextLong();
                r.setName(name);
                r.setTrisCount(trisCound);
                r.setTime(time);

                users.add(r);
            }

        }catch (IOException e) {
            System.out.println("NO NO no load");
        }

    }


    private static void showResults() {
        users.sort(Comparator
                            .comparing (GameResult::getTrisCount)
                            .thenComparing(GameResult::getTime));

        for (GameResult result : users) {
            System.out.printf("%s \t\t\t %d \t\t\t %d\n" ,
                        result.getName(),
                        result.getTrisCount(),
                        result.getTime()/1000);
        }
    }

    private static void showResults2() {
        users.stream()
                .sorted(Comparator
                        .comparing (GameResult::getTrisCount)
                        .thenComparing(GameResult::getTime))
                .limit(2)
                .forEach(r -> System.out.printf("%s \t\t\t %d \t\t\t %d\n" ,
                        r.getName(),
                        r.getTrisCount(),
                        r.getTime()/1000));
    }




    static int askint(String msg, int min, int max) {
        while (true) {
            try {
                System.out.println(msg);
                int answer = scan.nextInt();
                if (answer >= min && answer <= max) {
                    return answer;
                }
            } catch (InputMismatchException ex){
                System.out.println("Its not a NUMBER");
                scan.next();
            }
            System.out.printf("please enter currekt from %d to %d\n", min, max);

        }

    }


    static boolean askWord (String msg) {
        while (true) {
            System.out.println(msg);
            String answer = scan.next();
            boolean isy = answer.equalsIgnoreCase("yes");
            boolean isn = answer.equalsIgnoreCase("no");

            if (isy || isn) {
                return isy;
            }
            System.out.println("Write yes or no");
        }
    }


}