package practice;

public class Test {
    public static void main(String[] args) {
        int a = 1;
        int b = 5;

        // create an object/instance out of class
        // instantiate a class
        Person person1 = new Person(1989, "fom", "Cheng");

        /*
        System.out.println(person1.yob);
        System.out.println(person2.yob);

        person1.yob = 1920;
        System.out.println(person1.yob);
         */

        System.out.println(person1.getName());

        person1.setFirstName("Jack");

        System.out.println(person1.getName());
        System.out.println(person1.getOrigFirstName());





    }
}
