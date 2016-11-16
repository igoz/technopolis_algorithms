package ru.technopolis.practice;

import java.util.*;
import java.io.*;

public class Mutants {
    FastScanner in;
    PrintWriter out;

    int binarySearch(int[] array, int key) {
        int left = -1;
        int right = array.length;
        while (left < right - 1) {
            int mid = (left + right) / 2;
            if (array[mid] < key) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (right > array.length - 1) {
            return -1;
        }
        return right;
    }

    public void solve() throws IOException {
        int quantity = in.nextInt();
        int[] mutantsArray = new int[quantity];
        for (int i = 0; i < quantity; i++) {
            mutantsArray[i] = in.nextInt();
        }
        int numberOfQueries = in.nextInt();
        for (int i = 0; i < numberOfQueries; i++) {
            int key = in.nextInt();
            int tmp = binarySearch(mutantsArray, key);
            if (tmp != -1) {
                int cnt = 0;
                for (int j = tmp; j < mutantsArray.length; j++) {
                    if (mutantsArray[j] == key) {
                        cnt++;
                    } else {
                        break;
                    }
                }
                out.append(cnt + "\n");
            } else {
                out.append(0 + "\n");
            }
        }
    }

    public void run() {
        try {
            in = new FastScanner(new File("input.txt"));
            out = new PrintWriter(new File("output.txt"));

            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    public static void main(String[] arg) {
        new Mutants().run();
    }
}
