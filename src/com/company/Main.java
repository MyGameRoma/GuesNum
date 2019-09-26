package com.company;

import com.sun.security.jgss.GSSUtil;

import javax.sound.midi.Soundbank;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static Random rand = new Random();


    public static void main(String[] args) {
        String answer;
            do {

                int myNum = rand.nextInt(100) + 1;
                System.out.println(myNum);
                boolean userwon = false;

                for (int i = 0; i < 10; i++) {

                    System.out.println("Enter you number from 1 to 100");

                    int userNum = scan.nextInt();
                    if (userNum == myNum) {
                        System.out.println("molodec");
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
                System.out.println("Do you ready for next round? yes or no");
                answer = scan.next();
            } while (answer.equalsIgnoreCase("yes"));
    }
}
