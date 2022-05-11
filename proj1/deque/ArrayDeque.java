package deque;

import edu.princeton.cs.algs4.StdOut;

public class ArrayDeque<T> /*implements Iterable<T>*/ {
    private T[] a;
    private int n;
    private int nextFirst;
    private int nextLast;

    // construct an empty randomized queue
    public ArrayDeque() {
        a = (T[]) new Object[8];
        n = 0;
        nextFirst = 0;
        nextLast = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return n == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return n;
    }

    private void resize(int newsize) {
        T[] temp = (T[]) new Object[newsize];
        for (int i = 0; i < n; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public void addFirst(T item) {
        if (n == a.length - 2) {
            resize(a.length * 2);
        }
        a[nextFirst] = item;
        nextFirst = (nextFirst + a.length - 1) % a.length;
        n++;
    }

    public void addLast(T item) {
        if (n == a.length - 2) {
            resize(a.length * 2);
        }
        a[nextLast] = item;
        nextLast = (nextLast + 1) % a.length;
        n++;
    }

    public T removeFirst() {
        if (n == 0) {
            return null;
        }
        /*T item;
        if (nextFirst != 0) {
            int temp = (nextFirst + 1) % a.length;
            item = a[nextFirst];
            a[nextFirst] = null;
            nextFirst = temp;
        } else {
            item = a[nextFirst];
            a[nextFirst] = null;
            nextFirst = (nextFirst + 1) % a.length;
        }*/
        nextFirst = (nextFirst + 1) % a.length;
        T item = a[nextFirst];
        a[nextFirst] = null;
        n--;
        if (n > 8 && n == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    public T removeLast() {
        if (n == 0) {
            return null;
        }
        nextLast = (nextLast + a.length - 1) % a.length;
        T item = a[nextLast];
        a[nextLast] = null;
        n--;
        if (n > 8 && n == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    public T get(int index) {
        return a[index];
    }

    public void printDeque() {
        for (int i = 0; i < n; i++) {
            StdOut.print(get(i) + " ");
        }
        StdOut.println();
    }

    // return an independent iterator over items in random order
   /* public Iterator<T> iterator() {
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
    }*/
}
