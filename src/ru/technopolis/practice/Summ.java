package ru.technopolis.practice;

import java.util.*;
import java.io.*;

public class Summ {
    FastScanner in;
    PrintWriter out;

    public void solve(int a, int b) throws IOException {


        boolean fl = true;
        for (int i = 2; i * i < a; i++) {
            if (a % 2 == 0) {
                fl = false;
            } else {
                fl = true;
            }
        }
        if (fl) {
            out.append("True");
        } else {
            out.append("False");
        }
    }

    public void run() {
        try {
            in = new FastScanner(new File("/home/igoz/IdeaProjects/technopolis_algorithms/src/ru/technopolis/practice/input.txt"));
            out = new PrintWriter(new File("/home/igoz/IdeaProjects/technopolis_algorithms/src/ru/technopolis/practice/output.txt"));

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