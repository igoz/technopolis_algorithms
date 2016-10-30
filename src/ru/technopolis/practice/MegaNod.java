package ru.technopolis.practice;

import java.util.*;
import java.io.*;

public class MegaNod {
    FastScanner in;
    PrintWriter out;

    private static int gcd(int a, int b) {
        while (a != 0 && b != 0) {
            if (a > b) {
                a %= b;
            } else {
                b %= a;
            }
        }

        return a + b;
    }

    public void solve(int[] data) throws IOException {
        int currentNod = data[0];
        for (int i = 1; i < data.length; i++) {
            int a = data[i];
            currentNod = gcd(currentNod, a);
        }

        out.append("" + currentNod);
    }

    public void run() {
        try {
            in = new MegaNod.FastScanner(new File("input.txt"));
            out = new PrintWriter(new File("output.txt"));

            solve(in.nextIntArray());

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

        int[] nextIntArray() {
            if (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            int[] tmpArr = new int[st.countTokens()];
            int cnt = st.countTokens();
            for (int i = 0; i < cnt; i++) {
                try {
                    tmpArr[i] = Integer.parseInt(st.nextToken());
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                }
            }

            return tmpArr;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    public static void main(String[] arg) {
        new MegaNod().run();
    }
}