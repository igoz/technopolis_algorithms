package ru.technopolis.lab2;

import java.util.*;
import java.io.*;

public class BubbleSort {
    FastScanner in;
    PrintWriter out;

    public void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public int bubbleSortWithCount(int[] array, int cnt) {
        int i = 0;
        int size = array.length;
        boolean wasSwap = true;

        while (wasSwap) {
            wasSwap = false;
            for (int j = 0; j < size - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    cnt++;
                    wasSwap = true;
                }
            }
            i++;
        }

        return cnt;
    }

    public void solve() throws IOException {
        int cnt = 0;
        int size = in.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }

        out.append(bubbleSortWithCount(array, cnt) + "");
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
        new BubbleSort().run();
    }
}