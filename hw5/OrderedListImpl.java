package Midterm;

import java.util.LinkedList;
import java.util.Objects;

public class OrderedListImpl implements OrderedList{
    ListNode head;
    private int maxSize;
    private int size;
    public OrderedListImpl(int maxSize) throws IllegalArgumentException{
        if (maxSize <= 0) {
            throw new IllegalArgumentException("capcity cannot be negative");
        }
        this.maxSize = maxSize;
        this.head = null;
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
    public OrderedList merge(OrderedList o) {
        OrderedListImpl other = (OrderedListImpl) o;
        int newSize = this.maxSize + other.maxSize;
        OrderedList result = new OrderedListImpl(newSize);

        ListNode one = this.head;
        ListNode two = other.head;
        while(one != null && two != null) {
            if(one.value >= two.value) {
                result.add(one.value);
                one = one.next;
            } else {
                result.add(two.value);
                two = two.next;
            }
        }
        //post processing rest of list
        while (one != null) {
            //if there are still numers in one
            //link the rest
            result.add(one.value);
            one = one.next;
        }

        while(two != null) {
            result.add(two.value);
            two = two.next;
        }

        return result;
    }


   @Override. //correction to remove
    public void remove(int val) {
        ListNode prev = null;
        ListNode traversePointer = head;
        while (traversePointer != null && val != traversePointer.value) {
            prev = traversePointer;
            traversePointer = traversePointer.next;

        }
        if(prev == null) {
            head = head.next;
        }
        else {
            prev.next = traversePointer.next;
        }
        size--;
    }

    @Override
    public void removeAll(int v) {
        if (head.value == v) {
            head = null;
            this.size = 0;
            return;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode traversePointer = head;
        //check for case if v == head
        while (traversePointer != null && traversePointer.value != v) {
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
    public OrderedList intersection(OrderedList o) {
        OrderedListImpl other = (OrderedListImpl) o;
        //capacity has to be the largest of the 2, in case both list are completely the same, capacity will still be ok
        int newSize = Math.max(this.maxSize,other.maxSize);
        OrderedList result = new OrderedListImpl(newSize);

        ListNode one = this.head;
        ListNode two = other.head;
        //stop condition one == null || two == null
        while(one != null && two != null) {
            if(one.value == two.value) {
                result.add(one.value);
                one = one.next;
                two = two.next;
            } else if (one.value < two.value){
                one = one.next;
            } else { //one.value > two.value
                two = two.next;
            }
        }
        return result;
    }


    static OrderedList sort(LinkedList<Integer> other) {
        OrderedList result = new OrderedListImpl(other.size());
        OrderedListImpl newList = (OrderedListImpl) result;
        while(!other.isEmpty()) {
            newList.add(other.pollFirst());
        }
        return newList;
    }

    @Override
    public int size() {
        return size;
    }

  @Override //correction toString
    public String toString() {
        String result = "[";
        ListNode traverserPointer = head;
        while (traverserPointer != null) {
            result = result + Integer.toString(traverserPointer.value) + " ";
            traverserPointer = traverserPointer.next;
        }
        String questionMarks = "? ".repeat(this.maxSize - this.size);
        return (result + questionMarks).trim() + "]";
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
