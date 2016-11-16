package ru.technopolis.lab2;

import java.util.*;
import java.io.*;

public class InsertSort {
    FastScanner in;
    PrintWriter out;

    public void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public void insertSort(int[] array) {
        int size = array.length;
        boolean wasSwapped = false;

        for (int i = 1; i < size; i++) {
            for (int j = i; j > 0 && array[j] < array[j - 1]; j--) {
                swap(array, j, j - 1);
                wasSwapped = true;
            }
            if (wasSwapped) {
                for (int j = 0; j < size; j++) {
                    out.append(array[j] + " ");
                }
                out.append("\n");
            }
            wasSwapped = false;
        }
    }

    public void solve() throws IOException {
        int cnt = 0;
        int size = in.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }

        insertSort(array);
    }

    public void run() {
        try {
            in = new FastScanner(new File("D:\\Programming\\Java\\Technopolis\\technopolis_algorithms\\src\\ru\\technopolis\\lab2\\input.txt"));
            out = new PrintWriter(new File("D:\\Programming\\Java\\Technopolis\\technopolis_algorithms\\src\\ru\\technopolis\\lab2\\output.txt"));


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
    }

    public static void main(String[] arg) {
        new InsertSort().run();
    }
}