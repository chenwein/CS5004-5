package practice;

public class Person {
    // ---------------------
    // member variables or member fields or fields
    private int yob; // year of birth
    //private String firstName;
    private String firstName;
    private String lastName;
    private String origFirstName;

    // constructor: special method
    // doesn't have return value
    // Purpose of constructor: initialize those member variables
    public Person(int yob, String firstName, String lastName) {
        this.yob = yob;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // methods: what you can do with the member variables
    // accessor/getter methods
    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    // mutator/setter methods
    public void setFirstName(String newFirstName) {
        // 1. check the caller's identify

        // 2. remember the original name before changing it
        origFirstName = this.firstName;
        this.firstName = newFirstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getYearOfBirth() {
        return this.yob;
    }


    // accessor/getter method
    public String getOrigFirstName() {
        String s = "" + firstName.charAt(0) + lastName.charAt(0);
        return s;
    }

}

