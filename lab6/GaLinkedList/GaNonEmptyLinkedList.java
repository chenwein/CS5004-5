package GaLinkedList;

public class GaNonEmptyLinkedList<T> implements GaLinkedList<T>{
    T value;
    GaLinkedList<T> rest; //sublist

    //constructor
    //takes one value generic type
    //sublist
    public GaNonEmptyLinkedList(T val, GaLinkedList<T> rest){
        this.value = val;
        this.rest = rest;
    }

    //constructor when only value is passed, the REST sublist is empty
    public GaNonEmptyLinkedList(T val) {
        this.value = val;
        this.rest = new GaEmptyLinkedList<T>();
    }

    //getter ==================================================
    @Override
    //value of current list (regarded as node) |1| -> 3 -> 4
    public T getValue() {
        return this.value;
    }

    @Override
    //gets the rest of the list, by looking at this current list (node)
    public GaLinkedList<T> getRest() {
        return this.rest;
    }
    // =================================================================

    @Override
    //return size of myself and my subproblem
    public int size() {
        return 1 + getRest().size();
    }

    @Override
    //add to front, which is before current list. rest of list is now myself
    public GaLinkedList<T> addFront(T val) {
        return new GaNonEmptyLinkedList<T>(val, this); //why not?
    }

    @Override
    // current list is not empty
    public boolean isEmpty() {
        return false;
    }

    @Override
    //get node at this index. 0
    public T get(int index) {
        //check corner cases
        if (index < 0 || index > this.size()) {
            //return -1
            throw new IndexOutOfBoundsException("Out of bounds");
        }
        //base case
        if (index == 0) {
            this.getValue();
        }
        //recursive call
        return getRest().get(index - 1);
    }

    @Override
    //this is not the end, pass it down
    //returns me a list, assign to current rest
    public GaLinkedList<T> addBack(T val) {
        this.rest = getRest().addBack(val);
        return this; //-> return head of list
    }

    @Override
    //travesre linked list, needs to update position, starting with 0, which is this current list (node)
    //return index position of list Value (node)
    public int find(T val) {
        //pass to helper current linkedlist (node), value of this list, and idxposition
        return findHelper(this,val, 0);
    }

    public int findHelper(GaLinkedList<T> list, T val, int idx) {
        // if this current list's sublist is empty, return -1.
        //can't go down sublist anymore
        if (list.getRest().isEmpty()) {
            return -1;
        }
        if (list.getRest().equals(val)) {
            return idx; //if this list.value == value, return this list's (node) position
        }
        //recursive rule
        return findHelper(list.getRest(), val, idx + 1);
    }

    @Override
    public GaLinkedList<T> remove(int index) throws IndexOutOfBoundsException {
        //if the index you given is not within bound
        if (index < 0 || index > this.size()) {
            //return -1
            throw new IndexOutOfBoundsException("Out of bounds");
        }
        //if only one node, singleton list, and trying to just remove it
        //size == 1, and we want to remove that node. set value = null and Rest = null
        if (index == 0) {
            return new GaEmptyLinkedList<T>(); //both fields are null by default
        }
        //stopping at one, because we know the next node is the node we want
        //have to connect next.next
        if (index == 1) {
            this.rest = this.getRest().getRest();
            return this;
        }
        //recursive rule 0 if none of the case, keep traversing down
        return this.rest.remove(index - 1);
    }

    @Override
    public GaLinkedList<T> reverse() {
        //assuming list has at least one value, and not addressing deep copies
        System.out.println(this.value); //check what this current 'head' is
        GaNonEmptyLinkedList<T> temp = new GaNonEmptyLinkedList<T>(this.getValue());
        //creating pointer to head, LIstNode curr = head;
        revCopyHelper(temp, this.getRest());
        return temp;
    }

    private void revCopyHelper(GaNonEmptyLinkedList<T> temp, GaLinkedList<T> tail) {
        //GaEmptyLinkedList.isEmpty
        if (tail.isEmpty()) {
            return;
        }
        //if not, do something to this current level
        //remember, temp is the "head" of this current pointed to list,
        //we append to the front whatever 'next' sublist is (next node)
        // 1->2 becomes 2->1
        temp.addFront(tail.getValue());
        //recursive call
        temp.revCopyHelper(temp, tail.getRest());
    }

}
