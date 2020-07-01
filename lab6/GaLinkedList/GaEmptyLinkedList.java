package GaLinkedList;

//class implements GaLinkedList interface, override methods
public class GaEmptyLinkedList<T> implements GaLinkedList<T> {

    // getter ===============================================================
    @Override
    public T getValue() {
        return null;
    }

    @Override
    //at the end, so there is no rest
    public GaLinkedList<T> getRest() {
        return null;
    }

    // ===================================================================

    @Override
    //size of empty is 0
    public int size() {
        return 0;
    }

    @Override
    //compiler replaces unbound T with Object - no specification with GaLinkedList "<T>", would assume obj
    //already empty, so create new sublinkedlist and add the value
    public GaLinkedList<T> addFront(T val) {
        //non empty linkedlist
        // int value
        // Linkedlist rest
        //takes
        return new GaNonEmptyLinkedList<T>(val, this);
    }

    @Override
    //empty Linkedlist, is empty
    public boolean isEmpty() {
        return true;
    }

    @Override
    //the list is empty - value of type TT
    public T get(int index) {
        return null;
    }

    @Override
    //this is the end, so append here and add new emptylist after
    public GaLinkedList<T> addBack(T val) {
        return new GaNonEmptyLinkedList<T>(val, this);
    }

    @Override
    public int find(Object val) {
        return 0;
    }

    @Override

    public GaLinkedList<T> remove(int index) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public GaLinkedList<T> reverse() {
        return null;
    }

    @Override
    public String toString() {
        return "{}";
    }
}
