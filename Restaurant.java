package ratatuee;

/**
 * This Class keep the restaurants's information and behavior
 */
public class Restaurant extends User{
    Menu menu;
    /**
     * Create a restaurant and initialize it's field
     * @param restaurantName restaurant's name
     * @param restaurantPhoneNo restaurant's phone number
     * @param restaurantRegion restaurant's region
     */
    public Restaurant(String restaurantName, String restaurantPhoneNo, String restaurantRegion){
        super(restaurantName, restaurantPhoneNo, restaurantRegion);
        menu = new Menu();
    }

    /**
     * Get the restaurant's name
     * @return String restaurantName
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Get the restaurant's phone number
     * @return String restaurantPhoneNo
     */
    @Override
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * Get the restaurant's region
     * @return String restaurantRegion
     */
    @Override
    public String getRegion() {
        return region;
    }

    /**
     * Set the restaurant's name
     * @param name restaurantName
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the restaurant's phone number
     * @param phoneNo restaurant phone
     */
    @Override
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     * Set the restaurant's region
     * @param region restaurantRegion
     */
    @Override
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Get the restaurant's menu
     * @return Menu restaurant's menu
     */
    public Menu getMenu() {
        return menu;
    }

    /**
     * Set the restaurant's menu
     * @param menu
     */
    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    /**
     * This method prints the restaurant's information
     */
    public void printRestaurant(){
        System.out.println(getName() + " " + getPhoneNo() + " " + getRegion());
    }

    /**
     * this method checks if the entered region is the same as the restaurant's or not
     * @param region entered region
     * @return return true if they are the same
     */
    public boolean checkRestaurantRegion(String region){
        if(getRegion().equals(region))
            return true;
        return false;
    }

    /**
     * prints the food's information and it is used when the customer enters list near
     */
    public void printFood(String type){
        for (Food food : getMenu().getFoods()){
            if(food.getFoodType().equals(type))
                System.out.println(food.getFoodCode() + " " + food.getFoodName() + " " + food.getFoodType() +
                        " " + food.getFoodPrice() + " " + getName() + " " + getRegion());
        }
    }

    /**
     * this method searches a food base on it's code in a restaurant
     * @param foodCode food's code to be found
     * @return the food if it is found and returns null if the food is not found
     */
    public Food searchFood(String foodCode){
        for(Food food: getMenu().getFoods()){
            if(food.getFoodCode().equals(foodCode))
                return food;
        }
        return null;
    }
}
