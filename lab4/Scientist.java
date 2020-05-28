package inheritance;

public class Scientist extends Employee{

    private String specialty;

    public Scientist(int yob, String firstName, String lastName,
                    int salary, String specialty) {
        // init the parent class
        super(yob, firstName, lastName, salary);
        this.specialty = specialty;
    }


    //get
    public String getSpecialty() {
        return this.specialty;
    }

    @Override
    public String toString() {
        return getName() + " " + getSpecialty();
    }

    //compare scientist object
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Scientist) {
            //if object is an instance of Scientist class
            //type case
            Scientist other = (Scientist) obj;
            //compare name && specialty
            if (this.getName().equals(other.getName())
                    && getSpecialty().equals(other.getSpecialty())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
