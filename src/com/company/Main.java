package com.company;

import com.sun.security.jgss.GSSUtil;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static Random rand = new Random();


    public static void main(String[] args) {
        String answer;
        do {
            System.out.println("What you name");
            String Name =scan.next();

            int myNum = rand.nextInt(100) + 1;
            System.out.println(myNum);
            boolean userwon = false;

            for (int i = 1; i < 11; i++) {
                int userNum = askint("Enter you number from 1 to 100", 1, 100);

                if (userNum == myNum) {
                    System.out.println(Name +" Molodec Ti ugodal s " + i + " popitki");
                    userwon = true;
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

        System.out.println("goodbaiii");
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