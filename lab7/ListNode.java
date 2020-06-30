package doubleLinkedList;

public class ListNode {
    int value;
    ListNode prev;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
        this.prev = null;
        this.next = null;
    }

    //copy constructor for node
    public ListNode(ListNode other) {
        this.value = other.value;
        this.setPrev( new ListNode(other.getPrev()));
        this.setNext( new ListNode(other.getNext()));
    }

    //getter

    public int getValue() {
        return value;
    }

    public ListNode getPrev() {
        return prev;
    }

    public ListNode getNext() {
        return next;
    }

    //setter for next and prev. We don't want to public to be able to
    //change any of the internal information of our listNode
    //if they do, we might risk losing the linkedlist in its entirety

    public void setPrev(ListNode prev) {
        this.prev = prev;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public String toString(){
        return String.format("%d", this.value);
    }
}
