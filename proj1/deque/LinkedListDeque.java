package deque;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListDeque<T> implements Iterable<T>, Deque<T> {
    private int n;
    private Node sentienel;

    private class Node {
        private T t;
        private Node pre, next;

        Node(T item, Node prev, Node next) {
            this.t = item;
            this.pre = prev;
            this.next = next;
        }
    }


    // construct an empty LinkedListDeque
    public LinkedListDeque() {
        n = 0;
        sentienel = new Node(null, null, null);
        sentienel.pre = sentienel;
        sentienel.next = sentienel;
    }

    // return the number of items on the LinkedListDeque
    public int size() {
        return n;
    }

    // add the t to the front
    public void addFirst(T t) {
        if (t == null) {
            throw new IllegalArgumentException();
        }
        Node prevFirstNode = sentienel.next;
        Node newFirstNode = new Node(t, sentienel, prevFirstNode);
        prevFirstNode.pre = newFirstNode;
        sentienel.next = newFirstNode;
        n++;
    }

    // add the t to the back
    public void addLast(T t) {
        if (t == null) {
            throw new IllegalArgumentException();
        }

        Node oldLastNode = sentienel.pre;
        Node newLastNode = new Node(t, oldLastNode, sentienel);
        oldLastNode.next = newLastNode;
        sentienel.pre = newLastNode;
        n++;
    }

    // remove and return the t from the front
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node oldFirstNode = sentienel.next;
        Node newFirstNode = oldFirstNode.next;
        sentienel.next = newFirstNode;
        newFirstNode.pre = sentienel;
        n--;
        return oldFirstNode.t;
    }

    // remove and return the T from the back
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        Node oldLastNode = sentienel.pre;
        Node newLastNode = oldLastNode.pre;
        sentienel.pre = newLastNode;
        newLastNode.next = sentienel;
        n--;
        return oldLastNode.t;
    }

    public void printDeque() {
        for (int i = 0; i < n; i++) {
            StdOut.print(get(i) + " ");
        }
        StdOut.println();
    }

    public T get(int index) {
        int i = 0;
        T t1 = null;
        for (T t : this) {
            if (i == index) {
                t1 = t;
                break;
            }
            i++;
        }
        return t1;
    }

    public T getRecursive(int index) {
        if (index < 0 || index > n - 1) {
            return null;
        }

        return getRecursive(index, sentienel.next);
    }

    // recursive helper method
    private T getRecursive(int index, Node node) {
        if (index == 0) {
            return node.t;
        }
        return getRecursive(index - 1, node.next);
    }

    // return an iterator over items in order from front to back
    public Iterator<T> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<T> {
        private Node current = sentienel.next;

        public boolean hasNext() {
            return current != sentienel;
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t = current.t;
            current = current.next;
            return t;

        }
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof Deque)) {
            return false;
        }
        Deque<T> ol = (Deque<T>) o;
        if (ol.size() != this.size()) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (!(ol.get(i).equals(this.get(i)))) {
                return false;
            }
        }
        return true;
    }
}


