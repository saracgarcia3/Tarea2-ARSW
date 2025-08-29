package com.sara.arsw.collections;

import java.util.*;


public class DoublyLinkedList<E> extends AbstractSequentialList<E> {

    private static final class Node<E> {
        E item;
        Node<E> prev, next;
        Node(E item, Node<E> prev, Node<E> next) {
            this.item = item; this.prev = prev; this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    @Override public int size() { return size; }

    @Override
    public ListIterator<E> listIterator(int index) {
        checkPositionIndex(index);
        return new DLLIterator(index);
    }

    private final class DLLIterator implements ListIterator<E> {
        private Node<E> next;
        private Node<E> lastReturned;
        private int nextIndex;

        DLLIterator(int index) {
            if (index == size) {
                next = null;
                nextIndex = size;
            } else {
                next = node(index);
                nextIndex = index;
            }
        }

        @Override public boolean hasNext() { return nextIndex < size; }
        @Override public boolean hasPrevious() { return nextIndex > 0; }
        @Override public int nextIndex() { return nextIndex; }
        @Override public int previousIndex() { return nextIndex - 1; }

        @Override public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.item;
        }

        @Override public E previous() {
            if (!hasPrevious()) throw new NoSuchElementException();
            if (next == null) next = tail;
            else next = next.prev;
            lastReturned = next;
            nextIndex--;
            return lastReturned.item;
        }

        @Override public void remove() {
            if (lastReturned == null) throw new IllegalStateException();
            Node<E> lastNext = lastReturned.next;
            unlink(lastReturned);
            if (next == lastReturned) next = lastNext;
            else nextIndex--;
            lastReturned = null;
        }

        @Override public void set(E e) {
            if (lastReturned == null) throw new IllegalStateException();
            lastReturned.item = Objects.requireNonNull(e);
        }

        @Override public void add(E e) {
            linkAt(nextIndex, Objects.requireNonNull(e));
            nextIndex++;
            lastReturned = null;
        }
    }

    private void linkAt(int index, E e) {
        if (index == size) {
            Node<E> newNode = new Node<>(e, tail, null);
            if (tail == null) { head = tail = newNode; }
            else { tail.next = newNode; tail = newNode; }
        } else {
            Node<E> succ = node(index);
            Node<E> pred = succ.prev;
            Node<E> newNode = new Node<>(e, pred, succ);
            succ.prev = newNode;
            if (pred == null) head = newNode;
            else pred.next = newNode;
        }
        size++;
        modCount++;
    }

    private E unlink(Node<E> x) {
        E element = x.item;
        Node<E> prev = x.prev, next = x.next;
        if (prev == null) head = next;
        else { prev.next = next; x.prev = null; }
        if (next == null) tail = prev;
        else { next.prev = prev; x.next = null; }
        x.item = null;
        size--;
        modCount++;
        return element;
    }

    private Node<E> node(int index) {
        if (index < (size >> 1)) {
            Node<E> x = head;
            for (int i = 0; i < index; i++) x = x.next;
            return x;
        } else {
            Node<E> x = tail;
            for (int i = size - 1; i > index; i--) x = x.prev;
            return x;
        }
    }

    private void checkPositionIndex(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
}
