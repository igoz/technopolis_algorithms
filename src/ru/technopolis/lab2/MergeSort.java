package ru.technopolis.lab2;

import java.util.*;
import java.io.*;

public class MergeSort {
    FastScanner in;
    PrintWriter out;

    public void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public void merge(int[] array, int[] checkArray, int left, int mid, int right) {
        int it1 = 0;
        int it2 = 0;
        int[] result = new int[right - left];
        int[] checkResult = new int[right - left];


        while ((left + it1 < mid) && (mid + it2 < right)) {
            if (array[left + it1] <= array[mid + it2]) {
                result[it1 + it2] = array[left + it1];
                checkResult[it1 + it2] = checkArray[left + it1];
                it1++;
            } else {
                result[it1 + it2] = array[mid + it2];
                checkResult[it1 + it2] = checkArray[mid + it2];
                it2++;
            }
        }

        while (left + it1 < mid) {
            result[it1 + it2] = array[left + it1];
            checkResult[it1 + it2] = checkArray[left + it1];
            it1++;
        }

        while (mid + it2 < right) {
            result[it1 + it2] = array[mid + it2];
            checkResult[it1 + it2] = checkArray[mid + it2];
            it2++;
        }

        for (int i = 0; i < it1 + it2; i++) {
            array[left + i] = result[i];
            checkArray[left + i] = checkResult[i];
        }
    }

    public void mergeSortIterative(int[] array, int[] checkArray) {
        int size = array.length;
        for (int i = 1; i < size; i *= 2) {
            for (int j = 0; j < size - i; j += 2 * i) {
                merge(array, checkArray, j, j + i, Math.min(j + 2 * i, size));
            }
        }
    }

    public void solve() throws IOException {
        int size = in.nextInt();
        int[] array = new int[size];
        int[] checkArray = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = in.nextInt();
            checkArray[i] = in.nextInt();
        }

        mergeSortIterative(array, checkArray);

        for (int i = 0; i < size; i++) {
            out.append(array[i] + " " + checkArray[i] + "\n");
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
        new MergeSort().run();
    }
}