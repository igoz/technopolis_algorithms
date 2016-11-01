package ru.technopolis.practice;

import java.util.*;
import java.io.*;

public class Queue {
    static class LinkedQueue<T> {
        private class Node<T> {
            private Node<T> prev;
            private Node<T> next;
            T data;

            public Node(T data) {
                this.data = data;
            }
        }

        private Node<T> start;
        private Node<T> end;
        private int size = 0;

        void push(T data) {
            Node element = new Node(data);
            if (size == 0) {
                start = element;
                end = element;
            } else {
                end.next = element;
                element.prev = end;
                end = element;
            }
            size++;
        }

        T pop() {
            if (size > 0) {
                Node<T> tmp = start;
                size--;
                start = start.next;
                if (size > 0) {
                    start.prev = null;
                }
                return tmp.data;
            } else {
                return null;
            }
        }

        T front() {
            if (size > 0) {
                return start.data;
            } else {
                return null;
            }
        }

        int size() {
            return size;
        }

        void clear() {
            start = null;
            end = null;
            size = 0;
        }
    }

    Scanner in;
    PrintWriter out;

    public void solve() throws IOException {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        while (in.hasNext()) {
            switch (in.next()) {
                case "push" :
                    queue.push(in.nextInt());
                    out.append("ok\n");
                    break;
                case "pop" :
                    out.append(queue.pop() + "\n");
                    break;
                case "front" :
                    out.append(queue.front() + "\n");
                    break;
                case "size" :
                    out.append(queue.size() + "\n");
                    break;
                case "clear" :
                    queue.clear();
                    out.append("ok\n");
                    break;
                case "exit":
                    out.append("bye");
                    return;

            }
        }
    }

    public void run() {
        try {
            in = new Scanner(new File("/home/igoz/IdeaProjects/technopolis_algorithms/src/ru/technopolis/practice/input.txt"));
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
    }

    public static void main(String[] arg) {
        new Queue().run();
    }
}