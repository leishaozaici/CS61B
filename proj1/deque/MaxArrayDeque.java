package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> cm;

    public MaxArrayDeque(Comparator<T> c) {
        cm = c;
    }

    public T max() {
        return max(cm);
    }

    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        }
        T tmax = get(0);
        for (int i = 0; i < size(); i++) {
            if (c.compare(get(i), tmax) > 0) {
                tmax = get(i);
            }
        }
        return tmax;
    }
}
