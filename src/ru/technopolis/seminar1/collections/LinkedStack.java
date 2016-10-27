package ru.technopolis.seminar1.collections;

import java.util.Iterator;

public class LinkedStack<Item> implements IStack<Item> {

    public static void main(String[] args) {
        LinkedStack<Integer> stack = new LinkedStack<Integer>();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        Iterator<Integer> iter = stack.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    private Node<Item> head;
    private int size;

    public LinkedStack() {
    }

    public LinkedStack(Node<Item> head) {
        this.head = head;
        size = 0;
    }

    @Override
    public void push(Item item) {
        /* TODO: implement it */
        head = new Node<Item>(item, head);
        size++;
    }

    @Override
    public Item pop() {
        /* TODO: implement it */
        if (size > 0) {
            Item tmp = head.item;
            if (head.next != null) {
                head = new Node<Item>(head.next.item, head.next.next);
            }
            size--;
            return tmp;
        } else {
            head.item = null;
            return head.item;
        }

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedStackIterator();
    }

    private class LinkedStackIterator implements Iterator<Item> {

        Node<Item> current = head;

        @Override
        public boolean hasNext() {
            /* TODO: implement it */
            return current != null;
        }

        @Override
        public Item next() {
            /* TODO: implement it */
            Item item = current.item;
            current = current.next;
            return item;
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
}
