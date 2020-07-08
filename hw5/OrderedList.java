package Midterm;

import java.util.LinkedList;

public interface OrderedList {
    default int getMin() throws IllegalStateException {
        return 0;
    }

    default int getMax() throws IllegalStateException {
        return 0;
    }

    default double getMedian() throws IllegalStateException {
        return 0;
    }

    default void add(int val) {
        return;
    }

    default OrderedList merge(OrderedList other) {
        return null;
    }

    default void remove(int val) {
        return;
    }

    default void removeAll(int v) {
        return;
    }

    default boolean isEmpty() {
        return false;
    }

    default OrderedList intersection(OrderedList other) {
        return null;
    }

    // It gets complicated to override a static method defined in interface.
    // So I have sort() commented out. But you still need to implement it in your class,
    // with the same method signature.
    // static OrderedList sort(LinkedList<Integer> other);

    default int size() {
        return 0;
    }
}
