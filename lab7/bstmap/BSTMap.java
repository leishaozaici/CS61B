package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    private Entry root;
    private int size = 0;

    private Entry clear(Entry entry) {
        if (entry == null) {
            return null;
        }
        entry.left = clear(entry.left);
        entry.right = clear(entry.right);
        return null;
    }

    @Override
    public void clear() {
        root = clear(root);
        size = 0;
    }

    @Override
    public boolean containsKey(K key) {
        if (key == null) {
            return false;
        }
        return get(root, key) != null;
    }

    private Entry get(Entry bst, K key) {
        if (bst == null) {
            return null;
        }
        int cmp = key.compareTo(bst.key);
        if (cmp < 0) {
            return get(bst.left, key);
        } else if (cmp > 0) {
            return get(bst.right, key);
        } else {
            return bst;
        }
    }

    @Override
    public V get(K key) {
        if (root == null) {
            return null;
        }
        Entry bst = get(root, key);
        if (bst == null) {
            return null;
        } else {
            return bst.val;
        }
    }

    @Override
    public int size() {
        return size;
    }

    private Entry put(Entry entry, K k, V v) {
        if (entry == null) {
            size++;
            return new Entry(k, v);
        }
        int cmp = k.compareTo(entry.key);
        if (cmp > 0) {
            entry.right = put(entry.right, k, v);
        }
        if (cmp < 0) {
            entry.left = put(entry.left, k, v);
        } else {
            entry.val = v;
        }
        return entry;
    }

    @Override
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private class Entry {

        public Entry(K k, V v) {
            this.key = k;
            this.val = v;
        }


        K key;
        V val;
        Entry left;
        Entry right;
    }


    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }

    public void printInOrder() {
        throw new UnsupportedOperationException();
    }
}
