package ru.technopolis.lab2;

import java.util.*;
import java.io.*;

public class CountingSort {
    FastScanner in;
    PrintWriter out;

    public int[] countingSort(int[] array, int k) {
        int tmp[] = new int[k];
        for (int i = 0; i < array.length; i++)
            tmp[array[i]]++;
        for (int i = 1; i < k; i++)
            tmp[i] += tmp[i-1];
        int result[] = new int[array.length];
        for (int i = array.length-1; i >= 0; i--)
            result[--tmp[array[i]]] = array[i];

        return result;
    }

    public int findMax(int[] array) {
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            if (result < array[i]) {
                result = array[i];
            }
        }

        return result;
    }

    public void solve() throws IOException {
        int size = in.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }

        int[] result = countingSort(array, findMax(array) + 1);

        for (int i = 0; i < size; i++) {
            out.append(result[i] + " ");
        }

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
        new CountingSort().run();
    }
}