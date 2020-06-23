package Midterm;

import java.util.Objects;

public class OrderedListImpl implements OrderedList{
    private ListNode head;
    private int maxSize;
    private int size;
    public OrderedListImpl(int maxSize, ListNode head) {
        this.maxSize = maxSize;
        this.head = head;
        size = 0;
    }
    public OrderedListImpl(ListNode head) {
        this.head = head;
        size = 0;
    }

    @Override
    public int getMin() throws IllegalStateException {
        if(head == null) {
            throw new IllegalStateException("empty");
        }
        else {
            return head.value;
        }
    }

    @Override
    public int getMax() throws IllegalStateException {
        ListNode traversePointer = head;
        if(traversePointer == null) {
            throw new IllegalStateException("empty");
        }

        while (traversePointer.next != null) {
            traversePointer = traversePointer.next;
        }
        return traversePointer.value;
    }

    @Override
    public double getMedian() throws IllegalStateException {
        ListNode traversePointer = head;
        if(traversePointer == null) {
            throw new IllegalStateException("empty");
        }
        else  {
            int mid = this.size()/2;
            while(mid > 0) {
                traversePointer = traversePointer.next;
                mid--;
            }
            if (this.size()%2 == 1) {
                return (double) traversePointer.value;
            }
            else {
                return (traversePointer.value + traversePointer.next.value) / 2.0;
            }
        }
    }

    @Override
    public void add(int val) {
          if (size == maxSize) {
            //1 3 4 6 add(5)
            if (val > head.value) {
                head = head.next;
                this.size--;
                //5 > 1 , so we remove 1, and then proceed to add 5
            } else {
                return;
            }
        }
        //add 5 here
        ListNode newNode = new ListNode(val);
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode traversePointer = head;
        while (traversePointer != null && val > traversePointer.value) {
            traversePointer = traversePointer.next;
            prev = prev.next;
        }
        prev.next = newNode;
        newNode.next = traversePointer;
        head = dummy.next;
        size++;
    }

    @Override
    public OrderedListImpl merge(OrderedListImpl other) {
        ListNode one = this.head;
        ListNode two = other.head;
        ListNode dummyHead = new ListNode(-1);
        ListNode newNode = dummyHead;
        while (one != null && two != null) {
            if (one.value <= two.value) {
                newNode.next = one;
                one = one.next;
            } else { //one > two
                newNode.next = two;
                two = two.next;
            }
            newNode = newNode.next;
        }
        //post processing, add remaining nodes
        //L1 = null, L2 = 1 -> 2 -> null, merge L1 and L2 to 1 -> 2 -> null. also takes care of this.
        if (one == null ) {
            newNode.next = two;
        } else { //two == null
            newNode.next = one;
        }
        return new OrderedListImpl(dummyHead.next);
    }


    @Override
    public void remove(int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode traversePointer = head;
        while (traversePointer != null && val != traversePointer.value) {
            traversePointer = traversePointer.next;
            prev = prev.next;
        }
        if(traversePointer == null) {
            return;
        }
        else {
            prev.next = traversePointer.next;
        }
        size--;
    }

    @Override
    public void removeAll(int v) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode traversePointer = head;
        while (traversePointer != null && v != traversePointer.value) {
            traversePointer = traversePointer.next;
            prev = prev.next;
        }
        if(traversePointer == null) {
            return;
        }
        else {
            prev.next = null;
        }
        ListNode newTraverse = head;
        int counter = 1;
        while (newTraverse != null) {
            newTraverse = newTraverse.next;
            counter++;
        }
        this.size = counter;
    }

    @Override
    public boolean isEmpty() {
        if(this.size() == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public OrderedListImpl intersection(OrderedListImpl other) {
        return other; //no time
    }

    @Override
    public int size() {
        return size;
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
        if (!(o instanceof OrderedListImpl)) {
            return false;
        }
        OrderedListImpl other = (OrderedListImpl) o;
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
