package BookingSystem;

/**
 * Created by Dennis on 11.04.2017.
 */
public class Customer {

    private String customerName;
    private long customerPhnNumber;

    public Customer(String name, long number) {
        this.customerName = name;
        this.customerPhnNumber = number;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public long getCustomerPhnNumber() {
        return customerPhnNumber;
    }

    public void setCustomerPhnNumber(long customerPhnNumber) {
        this.customerPhnNumber = customerPhnNumber;
    }
}
