package ru.technopolis.practice;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
import java.io.*;

public class Heap {
    Scanner in;
    PrintWriter out;

    static class ArrayHeap {
        int[] data = new int[10];
        int size = 0;

        int getParentIndex(int nodeIndex) {
            return (int)Math.floor((nodeIndex - 1) / 2);
        }

        void siftUp(int nodeIndex) {
            int parentIndex, tmp;
            if (nodeIndex != 0) {
                parentIndex = getParentIndex(nodeIndex);
                if (data[parentIndex] < data[nodeIndex]) {
                    tmp = data[parentIndex];
                    data[parentIndex] = data[nodeIndex];
                    data[nodeIndex] = tmp;
                    siftUp(parentIndex);
                }
            }
        }

        void increaseCapacity() {
            int[] tmp = new int[data.length * 2];
            for (int i = 0; i < size; i++) {
                tmp[i] = data[i];
            }
            data = tmp;
        }

        void insert(int value) {
            if (size >= data.length) {
                increaseCapacity();
            }
            size++;
            data[size - 1] = value;
            siftUp(size - 1);
        }

        void remove(int nodeIndex) {
            if (nodeIndex < size) {
                data[nodeIndex] = data[size - 1];
                size--;
                siftDown(nodeIndex);
            }
        }

        void siftDown(int nodeIndex) {
            while (2 * nodeIndex + 1 < size) {
                int left, right;
//                if (nodeIndex == 0) {
//                    left = 1;
//                    right = 2;
//                } else {
                    left = 2 * nodeIndex + 1;
                    right = 2 * nodeIndex + 2;
//                }
                int j = left;
                if (right < size && data[right] > data[left]) {
                    j = right;
                }
                if (data[nodeIndex] > data[j]) {
                    break;
                }
                int tmp = data[nodeIndex];
                data[nodeIndex] = data[j];
                data[j] = tmp;
                nodeIndex = j;
            }
        }

        int getMax() {
            int tmp = data[0];
            remove(0);
            return tmp;
        }
    }

    public void solve() throws IOException {
        ArrayHeap heap = new ArrayHeap();
        int numberOfCommands = in.nextInt();
        for (int i = 0; i < numberOfCommands; i++) {
            if (in.nextInt() == 1){
                out.append(heap.getMax() + "\n");
            } else {
                heap.insert(in.nextInt());
            }
        }
    }

    public void run() {
        try {
            in = new Scanner(new File("D:\\Programming\\Java\\Technopolis\\technopolis_algorithms\\src\\ru\\technopolis\\practice\\input.txt"));
            out = new PrintWriter(new File("D:\\Programming\\Java\\Technopolis\\technopolis_algorithms\\src\\ru\\technopolis\\practice\\output.txt"));

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
        new Heap().run();
    }
}