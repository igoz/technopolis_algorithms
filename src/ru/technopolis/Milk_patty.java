package ru.technopolis;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Игорь on 04.10.2016.
 */
public class Milk_patty {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (sc.nextDouble() > 30) {
                count++;
            }
        }
        System.out.println((int)Math.ceil((double)(2 * count) / 9)
        + " " + count);
    }

}
