package doubleLinkedList;

import java.util.HashSet;
import java.util.Set;

public class setLinkedList {
    ListNode head;
    int size;


    //empty constructor
    public setLinkedList(){
        head = null;
        size = 0;
    }

    public setLinkedList(int value) {
        head.value = value;
        size = 1;
    }

    public int getVal() {
        return head.value;
    }

    public setLinkedList getNext() {
        ListNode newHead = head.next;
        setLinkedList subList = new setLinkedList(newHead.value);
        return subList;

    }

    public boolean addInt(int val) {
        ListNode newListNode = new ListNode(val);
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode traversePointer = head;
        while (traversePointer != null && val > traversePointer.value) {
            traversePointer = traversePointer.next;
            prev = prev.next;
        }
        prev.next = newListNode;
        newListNode.next = traversePointer;
        head = dummy.next;
        size++;

        removeRep(head);
        return true;
    }

    public boolean containsInt(int e) {
        ListNode curr = head;
        while (curr.next!= null && curr.value != e ) {
            curr = curr.next;
        }
        if (curr.value != e) {
            return false;
        }
        return true;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean removeInt(int e) {
        if (this.containsInt(e) == true) {
            ListNode curr = head;
            ListNode prev = null;
            while (curr.value != e) {
                prev = curr;
                curr = curr.next;
            }
            //stops when curr.value == e
            prev.next = curr.next;
            size--;
            return true;
        } else {
            //not in linkedlist, nothing removed
            return false;
        }
    }


    public void removeRep(ListNode head){
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while (cur != null) {
            pre = cur;
            next = cur.next;
            while (next != null) {
                if (cur.value == next.value) {
                    pre.next = next.next;
                    size--;
                } else {
                    pre = next;
                }
                next = next.next;
            }
            cur = cur.next;
        }
    }

    public int size() {
        return this.size;
    }

    public setLinkedList intersection(setLinkedList other) {
        //create new empty linkedlist with 1's head as head
        //combine new empty linkedlist with 2
        //then run remove repetition on this newlyt created linked list
        setLinkedList result = new setLinkedList();
        result.head = this.head;
        ListNode traversePointer = result.head;
        while(traversePointer.next != null) {
            //stops when at the last node
            traversePointer = traversePointer.next;
        }
        traversePointer.next = other.head;
        return result;
    }

    @Override
    public String toString() {
        String result = "";
        ListNode traverserPointer = head;
        while (traverserPointer != null) {
            result = result + Integer.toString(traverserPointer.value) + " ";
            traverserPointer = traverserPointer.next;
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof setLinkedList)) {
            return false;
        }
        setLinkedList other = (setLinkedList) o;
        //traverse both list
        ListNode myHead = this.head;
        ListNode otherHead = other.head;
        while (myHead != null && otherHead != null) {
            if (myHead.value != otherHead.value) {
                return false;
            }
            myHead = myHead.next;
            otherHead = otherHead.next;
        }

        return myHead == null && otherHead == null;
    }


}
