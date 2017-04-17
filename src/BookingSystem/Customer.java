package BookingSystem;

/**
 * Created by Dennis on 11.04.2017.
 */
public class Customer {

    private String customerName;
    private int customerPhnNumber;

    public Customer(){}

    public Customer(String name, int number) {
        this.customerName = name;
        this.customerPhnNumber = number;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerPhnNumber() {
        return customerPhnNumber;
    }

    public void setCustomerPhnNumber(int customerPhnNumber) {
        this.customerPhnNumber = customerPhnNumber;
    }
}
