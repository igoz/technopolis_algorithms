package ru.technopolis.practice;

import java.util.*;
import java.io.*;

public class Columns {    FastScanner in;
    PrintWriter out;

    public void solve() throws IOException {
        long number = in.nextLong();
        int size = in.nextInt();
        boolean fl = false;
        long[][] array = new long[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array[j][i] = in.nextLong();
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (array[i][j] == number && !fl) {
                    out.append("YES\n");
                    fl = true;
                } else if (j == size - 1 && !fl) {
                    out.append("NO\n");
                }
            }
            fl = false;
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
        new Columns().run();
    }
}
