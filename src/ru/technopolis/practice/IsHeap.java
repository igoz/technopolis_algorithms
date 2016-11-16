package ru.technopolis.practice;

import java.util.*;
import java.io.*;

public class IsHeap {
    FastScanner in;
    PrintWriter out;

    public void solve(long[] array) throws IOException {
        boolean fl = true;
        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] > array[2 * i] && array[i] > array[2 * i + 1]) {
                fl = false;
                break;
            }
        }
        if (fl) {
            out.print("YES");
        } else {
            out.print("NO");
        }
    }

    public void run() {
        try {
            in = new FastScanner(new File("D:\\Programming\\Java\\Technopolis\\technopolis_algorithms\\src\\ru\\technopolis\\practice\\input.txt"));
            out = new PrintWriter(new File("D:\\Programming\\Java\\Technopolis\\technopolis_algorithms\\src\\ru\\technopolis\\practice\\output.txt"));

            long[] array = new long[in.nextInt()];
            for (int i = 0; i < array.length; i++) {
                array[i] = in.nextLong();
            }
            solve(array);

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
        new IsHeap().run();
    }
}