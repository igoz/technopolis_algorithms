package ru.technopolis.lab2;

import javax.jnlp.IntegrationService;
import java.util.*;
import java.io.*;

public class QuickSort {
    FastScanner in;
    PrintWriter out;


    public void swap(Integer[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public int partition(Integer[] array, int l, int r) {
        int v = array[(l + r) / 2];
        int i = l;
        int j = r;
        while (i <= j) {
            while (array[i] < v) {
                i++;
            }
            while (array[j] > v) {
                j--;
            }
            if (i <= j) {
                swap(array, i++, j--);
            }
        }

        return i;
    }

    public void quickSort(Integer[] array, int l, int r) {
        if (l < r) {
            int q = partition(array, l, r);
            if (l < q - 1) {
                quickSort(array, l, q - 1);
            }
            if (q < r) {
                quickSort(array, q, r);
            }
        }
    }


    public void solve() throws IOException {
        List<Integer> list = new ArrayList<>();
        while (in.hasNextInt()) {
            list.add(in.nextInt());
        }
        Integer[] array = list.toArray(new Integer[list.size()]);

        quickSort(array, 0, array.length - 1);

        for (int i = 0; i < array.length; i++) {
            out.append(array[i] + " ");
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

        boolean hasNextInt() {
            if (st != null && st.hasMoreTokens()) {
                return true;
            } else {
                try {
                    String tmp = br.readLine();
                    if (tmp == null) {
                        return false;
                    } else {
                        st = new StringTokenizer(tmp);
                        return true;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return false;
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] arg) {
        new QuickSort().run();
    }
}