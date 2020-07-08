package doubleLinkedList;

import java.util.Objects;

public class DLL {
    ListNode head;
    ListNode tail;
    int size;

    public DLL() {
        head = null;
        tail = null;
        size = 0;
    }

    public DLL(ListNode head) {
        head = head;
        tail = null;
        size = 1;
    }

    public DLL(DLL other) {
        this.head = new ListNode(other.head);
        this.tail = new ListNode(other.tail);
        this.size = other.size;
    }

    public boolean isEmpty() {
        if (head == null || size == 0) {
            return true;
        }
        return false;
    }

    /**\
     * appends node to the front of linkedlist
     * @param value to be inserted into DLL
     */
    public void addHead(int value) {
        //create head pointer
        ListNode newHead = new ListNode(value);
        newHead.next = this.head;
        newHead.prev = null;
        this.head = newHead;
        size++;
    }

    /**
     * append a node to the end of the linkedlist
     * @param value of the node to be inserted
     */
    public void addTail(int value) {
        ListNode newNode = new ListNode(value);
        //if there is no head, the new tail is the head
        if (head == null) {
            head = newNode;
            newNode.prev = null;
            return;
        }
        //newNode is last node
        newNode.next = null;
        ListNode pointer = head;
        while(head.next != null) {
            pointer = pointer.next;
        }
        //stops when we are at the last node before null (tail)
        pointer.next = newNode;
        newNode.prev = pointer;
        tail = newNode;
        size++;
    }

    /**
     * get the value of the node on the specified index location
     * @param index position
     * @return value of the node retrieved
     */
    public int get(int index) {
        //not found
        if (index < 0 || index >= size) {
            return -1;
        }
        //index number will stop at 0
        ListNode pointer = head;
        while (index != 0) {
            pointer = pointer.next;
            index--;
        }
        return pointer == null? null:pointer.value;
    }

    /**
     * finds the index position of the given node
     * @param value of the node we want to look for
     * @return index position
     */
    public int find(int value) {
        //returns index position
        int index = 0;
        ListNode pointer = head;
        //while loop stops when pointer is at the value node we want
        while (pointer.value != value) {
            pointer = pointer.next;
            index++;
        }
        return index;
    }

    /**
     * remove the node at the given index
     * @param index of the node to be deleted
     * @throws IndexOutOfBoundsException
     */
    public void remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            return;
        }

        ListNode pointer = head;
        //stop before the actual node to be deleted
        while (index != 1) {
            pointer = pointer.next;
            index--;
        }
        //stops at the node before
        pointer.next = pointer.next.next;
        size--;
    }

    /**
     * given the head of the current list, return a reversed copy
     * @param head of the current list
     * @return a linkedlist that is reverse
     */
    public DLL reversedCopy(ListNode head) {
        //copy the current list to a new list
        //copy list  head is the tail of the original
        ListNode dummy = new ListNode(-1);
        ListNode pointer = dummy;
        ListNode pointerOriginal = tail;
        while (pointerOriginal != null) {
           pointer.next = pointerOriginal.prev;
           pointerOriginal = pointerOriginal.prev;
           pointer = pointer.next;
        }
        return new DLL(dummy.next);
    }

    /**
     * to string method for printing linkedlist
     * @return string
     */
    public String toString(){
        String result = "";
        ListNode pointer = head;
        while (pointer != null) {
            result += String.format(" %d-> ", pointer.value);
            pointer = pointer.next;
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (! (o instanceof DLL)) {
            return false;
        }
        DLL other = (DLL) o;
        //if head == other.head
        //tail == other.tail
        //size == other.size
        return head.equals(other.head) && size == other.size && tail.equals(other.tail);
    }
}
