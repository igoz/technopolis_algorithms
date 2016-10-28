package ru.technopolis.seminar1.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
    }

    @Override
    public void push(Item item) {
        Node<Item> tmp = head;
        head = new Node<Item>(item, tmp);
        size++;
    }

    @Override
    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        Item item = head.item;
        head = head.next;
        size--;
        return item;
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
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Stack is empty");
            }
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
