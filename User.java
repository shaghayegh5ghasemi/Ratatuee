package ratatuee;

/**
 * This class keep ratatuee user's information (Restaurants and costumers)
 */

public abstract class User {
    String name;
    String phoneNo;
    String region;

    /**
     * Create a restaurant or a customer with the information read from file
     * @param name user's name
     * @param phoneNo user's phone number
     * @param region user's region
     */
    public User(String name, String phoneNo, String region){
        this.name = name;
        this.phoneNo = phoneNo;
        this.region = region;
    }

    public abstract String getName();

    public abstract String getPhoneNo();

    public abstract String getRegion();

    public abstract void setName(String name);

    public abstract void setPhoneNo(String phoneNo);

    public abstract void setRegion(String region);
}
