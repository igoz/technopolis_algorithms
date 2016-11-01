package ru.technopolis.practice;

import java.util.*;
import java.io.*;

public class Mutants {
    FastScanner in;
    PrintWriter out;

    public void solve() throws IOException {
        Integer quantity = in.nextInt();
        Integer[] colorArray = new Integer[quantity];
        for (int i = 0; i < quantity; i++) {
            colorArray[i] = in.nextInt();
        }
        int numberOfQueries = in.nextInt();
//        long[] keys = new long[numberOfQueries];
//        long[] values = new long[numberOfQueries];  //or just use LinkedHashMap, it preserve insertion order
//        for (int i = 0; i < numberOfQueries; i++) {
//            keys[i] = in.nextInt();
//            values[i] = 0;
//        }
//        for (int i = 0; i < quantity; i++) {
//            for (int j = 0; j < numberOfQueries; j++) {
//                if (colorArray[i] == keys[j]) {
//                    values[j]++;
//                    break;
//                }
//            }
//        }

        LinkedHashMap<Integer, Integer> colorMap = new LinkedHashMap<>();
        for (int i = 0; i < numberOfQueries; i++) {
            colorMap.put(in.nextInt(), 0);
        }
        for (int i = 0; i < quantity; i++) {
            if (colorMap.containsKey(colorArray[i])) {
                colorMap.put(colorArray[i], colorMap.get(colorArray[i]) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry: colorMap.entrySet()) {
            out.append(entry.getValue() + "\n");
        }


    }

    public void run() {
        try {
            in = new FastScanner(new File("/home/igoz/IdeaProjects/technopolis_algorithms/src/ru/technopolis/practice/input.txt"));
            out = new PrintWriter(new File("/home/igoz/IdeaProjects/technopolis_algorithms/src/ru/technopolis/practice/output.txt"));

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
        new Mutants().run();
    }
}
