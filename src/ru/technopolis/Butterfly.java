package ru.technopolis;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Игорь on 04.10.2016.
 */
public class Butterfly {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double haveN = sc.nextDouble();
        String haveNumbers = sc.nextLine();
        double haventN = sc.nextDouble();
        String haventNumbers = sc.nextLine();

        ArrayList<Long> have = new ArrayList<Long>();
        ArrayList<Long> checkList = new ArrayList<Long>();

        for (String s : haveNumbers.split(" ")) {
            have.add(Long.parseLong(s));
        }
        for (String s : haventNumbers.split(" ")) {
            checkList.add(Long.parseLong(s));
        }
    }

    static int binarySearch(ArrayList<Long> a, long key) {
        int left = -1;
        int right = a.size();
        while(left < right - 1) {
            int mid = (left + right) / 2;
            if (a.get(mid) < key) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (right == a.size() || a.get(right) != key) {
            return -1;
        }
        return right;
    }
}
