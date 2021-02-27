package ratatuee;

import java.util.ArrayList;

public class Customer extends User{

    ArrayList<Order> orders = new ArrayList<>();
    /**
     * Create a customer and initialize it's fields
     * @param customerName customer's name
     * @param customerPhoneNO customer's phone number
     * @param customerRegion customer's region
     */
    public Customer(String customerName, String customerPhoneNO, String customerRegion){
        super(customerName, customerPhoneNO, customerRegion);
    }

    /**
     * Get the customer's name
     * @return String Name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Get the customer's phone number
     * @return String PhoneNo
     */
    @Override
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * Get the customer's region
     * @return String Region
     */
    @Override
    public String getRegion() {
        return region;
    }

    /**
     * Set the customer's name
     * @param name Name
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the customer's phone number
     * @param phoneNo phone
     */
    @Override
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     * Set the customer's region
     * @param region customerRegion
     */
    @Override
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Get the customer's order
     * @return ArrayList orders
     */
    public ArrayList<Order> getOrders() {
        return orders;
    }

    /**
     * This method adds an order for the customer
     * @param order
     */
    public void addOrder(Order order){
        orders.add(order);
    }

    /**
     * This method prints the customer's information
     */
    public void printCustomerInfo(){
        System.out.println(getName() + " " + getPhoneNo());
    }

    /**
     * prints customer's information with specific phone number
     * @param phone
     */
    public void printSpecificCustomer(String phone){
        if(getPhoneNo().equals(phone))
            System.out.print(getName() + " " + getPhoneNo() + " ");
    }

    /**
     * find a customer with it's phone number
     * @param phone customer's phone
     * @return return true if the customer's phone is correct
     */
    public boolean checkCustomer(String phone){
        if(getPhoneNo().equals(phone))
            return true;
        return false;
    }
}
