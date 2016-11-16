package ru.technopolis.lab2;

import java.util.*;
import java.io.*;

public class HeapSort {
    FastScanner in;
    PrintWriter out;

    public class ArrayHeap {
        long[] array = new long[10];
        int size = 0;

        int getParentIndex(int nodeIndex) {
            return (int)Math.floor((nodeIndex - 1) / 2);
        }

        void siftUp(int nodeIndex) {
            int parentIndex, tmp;
            if (nodeIndex != 0) {
                parentIndex = getParentIndex(nodeIndex);
                if (array[parentIndex] > array[nodeIndex]) {
                    swap(array, parentIndex, nodeIndex);
                    siftUp(parentIndex);
                }
            }
        }

        void increaseCapacity() {
            long[] tmp = new long[array.length * 2];
            for (int i = 0; i < size; i++) {
                tmp[i] = array[i];
            }
            array = tmp;
        }

        void insert(long value) {
            if (size >= array.length) {
                increaseCapacity();
            }
            size++;
            array[size - 1] = value;
            siftUp(size - 1);
        }

        void remove(int nodeIndex) {
            if (nodeIndex < size) {
                array[nodeIndex] = array[size - 1];
                size--;
                siftDown(nodeIndex);
            }
        }

        void siftDown(int nodeIndex) {
            while (2 * nodeIndex + 1 < size) {
                int left, right;
                left = 2 * nodeIndex + 1;
                right = 2 * nodeIndex + 2;
                int j = left;
                if (right < size && array[right] < array[left]) {
                    j = right;
                }
                if (array[nodeIndex] < array[j]) {
                    break;
                }
                swap(array, nodeIndex, j);
                nodeIndex = j;
            }
        }

        long getMin() {
            long tmp = array[0];
            remove(0);
            return tmp;
        }

        public void printHeap() {
            for (int i = 0; i < size; i++) {
                System.out.print(array[i] + " ");
            }
        }
    }

    public void swap(long[] array, int i, int j) {
        long tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public void solve() throws IOException {
        ArrayHeap heap = new ArrayHeap();

        while (in.hasNextInt()) {
            heap.insert(in.nextLong());
        }

        //heap.printHeap();

        int size = heap.size;
//        System.out.println(heap.size);
//        heap.printHeap();
//        System.out.println("\n");
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                out.append(heap.getMin() + "");
            } else {
                out.append(heap.getMin() + " ");
//                System.out.println(heap.size);
//                heap.printHeap();
//                System.out.println("\n");
            }
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
        new HeapSort().run();
    }
}