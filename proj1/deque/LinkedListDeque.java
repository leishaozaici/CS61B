package deque;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListDeque<T> implements Iterable<T>, Deque<T> {
    private Node first;
    private Node last;
    private int n;
    
    private class Node {
        private T t;
        private Node pre, next;
    }

    // construct an empty LinkedListDeque
    public LinkedListDeque() {
        n = 0;
        first = null;
        last = null;
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
        Node oldfirst = first;
        first = new Node();
        first.t = t;
        first.pre = null;
        if (n != 0) {
            first.next = oldfirst;
            oldfirst.pre = first;
        } else {
            last = first;
        }
        n++;
    }

    // add the t to the back
    public void addLast(T t) {
        if (t == null) {
            throw new IllegalArgumentException();
        }
        Node oldlast = last;
        last = new Node();
        last.t = t;
        last.pre = oldlast;
        if (n != 0) {
            oldlast.next = last;
        } else {
            first = last;
        }
        n++;
    }

    // remove and return the t from the front
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T t = first.t;
        first = first.next;
        n--;
        if (n == 0) {
            last = null;
        } else {
            first.pre = null;
        }
        return t;
    }

    // remove and return the T from the back
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T t = last.t;
        last = last.pre;
        n--;
        if (n == 0) {
            first = null;
        } else {
            last.next = null;
        }
        return t;
    }

    public void printDeque() {
        for (int i = 0; i < n; i++) {
            StdOut.print(get(i) + " ");
        }
        StdOut.println();
    }

    public T get(int index) {
        int i = 0;
        T t1 = first.t;
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
        /*int i = 0;
        T t = first.t;
        if (i == index) {
            return t;
        } else {
            first = first.next;
            i++;
            getRecursive(index);
        }
        return t;*/
       /* if (first.t != get(index) && first != null) {
            first = first.next;
            getRecursive(index);
        }
        if (first.t == get(index)) {
            first = first.next;
            return get(index);
        }
        return null;*/
        if (index < 0 || index > n - 1) {
            return null;
        }
        return getRecursiveHelper(index, first.next);
    }

    private T getRecursiveHelper(int index, Node currentNode) {
        if (index == 0) {
            return currentNode.t;
        }
        return getRecursiveHelper(index - 1, currentNode.next);
    }

    // return an iterator over items in order from front to back
    public Iterator<T> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<T> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
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


