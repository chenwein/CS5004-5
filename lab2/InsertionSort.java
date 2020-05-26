package practice;

public class InsertionSort {
    public static void main(String[] args) {
        //person for authors
        Person person1 = new Person(1989, "fom", "Cheng");
        Person person2 = new Person(2000, "eom", "Cheng1");
        Person person3 = new Person(2001, "dom", "Cheng2");
        Person person4 = new Person(1988, "com", "Cheng3");
        Person person5 = new Person(1989, "bom", "Cheng4");
        Person person6 = new Person(1989, "aom", "Cheng5");

        //create books
        Book book1 = new Book("A", person1, 1.5f);
        Book book2 = new Book("B", person2, 1.2f);
        Book book3 = new Book("C", person3, 1.3f);
        Book book4 = new Book("D", person4, 1.4f);
        Book book5 = new Book("E", person5, 1.5f);
        Book book6 = new Book("F", person6, 1.6f);

        Book arrToSort[] = {book1, book2, book3, book4, book5, book6};
        insertionSort(arrToSort);
        for (int k = 0; k < arrToSort.length; k++) {
            System.out.println(arrToSort[k].getAuthor().getFirstName());
        }
    }

    // this method inserts `from`'th elm to `to`'th elm in the given array
    static void insert(Book[] arr, int from, int to) {
        // 1. before we overwrite from'th elm, write it down
        Book val = arr[from];

        // 2. shift the position of elms in the range of [to, from-1] to right by 1
        for (int i = from; i > to; i--) {
            arr[i] = arr[i-1]; // move (i-1)'th to i'th index
        }

        // 3. insert `val` to `to`'th index
        arr[to] = val;
    }

    // insertion sort: simply sort the given array; doesn't return anything
    static void insertionSort(Book[] arr) {

        for (int i = 1; i < arr.length; i++) {
//             for each elm E, check all the numbers on its left until:
//             1. we reach the head of the array, then insert the elm to the head
//             2. we reach an elm E' smaller than E, then insert E after E'

            int j;

            for (j = i-1; j >= 0; j--) {
                int var1;
                if (helper(arr[j]) < helper(arr[i])) {
                    //using compareTo method for string is wwaaaaaayyy easier
                    //if (arr[j].getAuthor().getFirstName().compareTo(arr[i].getAuthor().getFirstName()))
                    // found a smaller elm, insert arr[i] after arr[j]
                    insert(arr, i, j+1);

                    // after insertion, we're done, terminate the loop
                    break;
                }
            }

            if (j == -1) {
                // we know that we've reached the head of array
                insert(arr, i, 0);
            }
        }
    }

    //helper method converts book author name to an integer value based on ascii
    static int helper(Book bookObject) {
        //build each object into a string of ascii first, then it will be allowed to compare
        StringBuilder sb = new StringBuilder();
        String s = bookObject.getAuthor().getFirstName();
        char[] letter = s.toCharArray();
        for (char ch : letter) {
            sb.append((byte) ch);
        }
        int result = Integer.parseInt(sb.toString());
        return result;
    }

}

