package inheritance;

public class CSuiteManager extends Manager{
    private int stockOptions;
    private float strikePrice;
    private String title;

    //constructor
    public CSuiteManager(int yob, String firstName, String lastName, int salary, int numOfSubordinates) {
        super(yob, firstName, lastName, salary, numOfSubordinates);
        this.stockOptions = stockOptions;
        this.strikePrice = strikePrice;
        this.title = title;
    }

    //getter
    public int getStockOptions() {
        return stockOptions;
    }

    public float getStrikePrice() {
        return strikePrice;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return getName() + " Title: " + getTitle() + " stock options: " + getStockOptions() + " strike price: " + getStrikePrice();
    }

    //compare Csuite object
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CSuiteManager) {
            //if object is an instance of Csuitemanager
            //type case
            CSuiteManager other = (CSuiteManager) obj;
            //compare name && specialty
            if (this.getName().equals(other.getName())
                    && getTitle().equals(other.getTitle()) &&
                    getStockOptions() == other.getStockOptions() &&
                    getStrikePrice() == other.getStrikePrice()) {
                return true;
            } else {
                return false;
            }
        } else {
            //return false if the compared object is not instance of CsuiteManager
            return false;
        }
    }
}
