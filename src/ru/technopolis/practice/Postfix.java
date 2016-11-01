package ru.technopolis.practice;

import java.util.*;
import java.io.*;

public class Postfix {
    public class LinkedStack<Item> {

    private Node<Item> head;
    private int size;

    public LinkedStack() {
    }

    public LinkedStack(Node<Item> head) {
        this.head = head;
    }

    public void push(Item item) {
        Node<Item> tmp = head;
        head = new Node<Item>(item, tmp);
        size++;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        Item item = head.item;
        head = head.next;
        size--;
        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
    }

    private static class Node<Item> {
        Item item;
        Node<Item> next;

        public Node(Item item, Node<Item> next) {
            this.item = item;
            this.next = next;
        }
    }

    Scanner in;
    PrintWriter out;

    public void solve() throws IOException {
        final String OPERATIONS = "+-*";
        LinkedStack<Long> stack = new LinkedStack<Long>();
        while (in.hasNext()) {
            String str = in.next();
            if (OPERATIONS.contains(str)) {
                Long a = stack.pop();
                Long b = stack.pop();
                if (str.equals("+")) {
                    stack.push(a + b);
                } else if (str.equals("-")) {
                    stack.push(a - b);
                } else if (str.equals("*")) {
                    stack.push(a * b);
                }
            } else {
                stack.push(Long.parseLong(str));
            }
        }
        out.append(stack.pop() + "");
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
        new Postfix().run();
    }
}