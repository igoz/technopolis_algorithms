package ru.technopolis.practice;

import java.util.*;
import java.io.*;

public class Summ {
    FastScanner in;
    PrintWriter out;

    public void solve(int a, int b) throws IOException {
        Integer tmp = new Integer(a + b);
        out.append(tmp.toString() + '\n');
    }

    public void run() {
        try {
            in = new FastScanner(new File("input.txt"));
            out = new PrintWriter(new File("output.txt"));

            int numberOfTests = in.nextInt();
            for (int i = 0; i < numberOfTests; i++) {
                solve(in.nextInt(), in.nextInt());
            }

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
    }

    public static void main(String[] arg) {
        new Summ().run();
    }
}