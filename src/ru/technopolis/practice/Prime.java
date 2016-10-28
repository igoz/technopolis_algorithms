package ru.technopolis.practice;

import java.util.*;
import java.io.*;

public class Prime {
    FastScanner in;
    PrintWriter out;

    public void solve(long a) throws IOException {
        if (a < 2) {
            out.append("False");
            return;
        }
        for (long i = 2; i * i <= a; i++) {
            if (a % i == 0) {
                out.append("False");
                return;
            }
        }
        out.append("True");
    }

    public void run() {
        try {
            in = new FastScanner(new File("input.txt"));
            out = new PrintWriter(new File("output.txt"));

            solve(in.nextLong());

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
        new Prime().run();
    }
}