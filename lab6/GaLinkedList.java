package GaLinkedList;

public interface GaLinkedList<T> {
    //no body methods

    //get value of current linkedlist..(since defined recursively)
    T getValue();

    //returns the rest of linkedlist
    GaLinkedList<T> getRest();

    //returns size of the linkedlist
    int size();

    //adds a node with given value to the head of Linkedlist, @ index 0
    GaLinkedList<T> addFront(T val);

    //check whether linkedlist is empty. returns boolean value
    boolean isEmpty();

    //get the element at index
    T get(int index);

    //appends element to end of linkedlist, returns a linkedlist
    GaLinkedList<T> addBack(T val);

    //finds the element idx with given value in linkedlist
    int find (T val);

    //remove node at given index, throws exception
    GaLinkedList<T> remove(int index) throws IndexOutOfBoundsException;

    //reverse the linkelist recursively
    GaLinkedList<T> reverse();

    //to string method
    String toString();
}
