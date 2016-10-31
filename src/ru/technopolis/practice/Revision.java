package ru.technopolis.practice;

import java.util.*;
import java.io.*;

public class Revision {
    FastScanner in;
    PrintWriter out;

    public void solve(long[] data) throws IOException {
        long min1, min2;
        if (data[0] < data[1]) {
            min1 = data[0];
            min2 = data[1];
        } else {
            min1 = data[1];
            min2 = data[0];
        }
        for (int i = 2; i < data.length; i++) {
            if (data[i] < min1) {
                min2 = min1;
                min1 = data[i];
            } else if (data[i] < min2) {
                min2 = data[i];
            }
        }

        out.append(min1 + " " + min2);
    }

    public void run() {
        try {
            in = new Revision.FastScanner(new File("input.txt"));
            out = new PrintWriter(new File("output.txt"));

            solve(in.nextLongArray());

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

        long[] nextLongArray() {
            int size = in.nextInt();
            long[] tmpArr = new long[size];
            for (int i = 0; i < size; i++) {
                tmpArr[i] = nextLong();
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
        new Revision().run();
    }
}