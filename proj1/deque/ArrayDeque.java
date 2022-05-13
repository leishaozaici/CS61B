package deque;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayDeque<T> implements Iterable<T>, Deque<T> {
    private T[] a;
    private int n;
    private int nextFirst;
    private int nextLast;

    // construct an empty randomized queue
    public ArrayDeque() {
        a = (T[]) new Object[8];
        n = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    // return the number of items on the randomized queue
    public int size() {
        return n;
    }

    private void resize(int newsize) {
        T[] temp = (T[]) new Object[newsize];
        int first = addOne(nextFirst);
        int last = minusOne(nextLast);
        if (first < last) {
            System.arraycopy(a, first, temp, 0, n);
        } else {
            if (first <= a.length - 1) {
                System.arraycopy(a, first, temp, 0, a.length - first);
            }
            if (last >= 0) {
                System.arraycopy(a, 0, temp, a.length - first, last + 1);
            }
        }
        a = temp;
        nextFirst = a.length - 1;
        nextLast = n;
    }

    // computed the index immediately “before” a given index
    private int minusOne(int index) {
        return (index + a.length - 1) % a.length;
    }

    // computed the index immediately “after” a given index
    private int addOne(int index) {
        return (index + 1) % a.length;
    }

    public void addFirst(T item) {
        if (n == a.length) {
            resize(a.length * 2);
        }
        a[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        n++;
    }

    public void addLast(T item) {
        if (n == a.length) {
            resize(a.length * 2);
        }
        a[nextLast] = item;
        nextLast = addOne(nextLast);
        n++;
    }

    public T removeFirst() {
        if (n == 0) {
            return null;
        }
        nextFirst = addOne(nextFirst);
        T item = a[nextFirst];
        a[nextFirst] = null;
        n--;
        if ((n < a.length / 4 + 1) && (a.length > 16)) {
            resize(a.length / 2);
        }
        return item;
    }

    public T removeLast() {
        if (n == 0) {
            return null;
        }
        nextLast = minusOne(nextLast);
        T item = a[nextLast];
        a[nextLast] = null;
        n--;
        if ((n < a.length / 4 + 1) && (a.length > 16)) {
            resize(a.length / 2);
        }
        return item;
    }

    public T get(int index) {
        return a[(index + 1 + nextFirst) % a.length];
    }

    public void printDeque() {
        for (int i = 0; i < n; i++) {
            StdOut.print(get(i) + " ");
        }
        StdOut.println();
    }

    // return an independent iterator over items in random order
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<T> {
        private int m;

        private ArrayDequeIterator() {
            m = 0;
        }

        public boolean hasNext() {
            return m < n;
        }

        public T next() {
            if (m >= n) {
                throw new NoSuchElementException("No next element");
            }
            return get(m++);
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
