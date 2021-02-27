package ratatuee;

/**
 * This class keep food's information
 */
public class Food {
    String foodCode;
    String foodName;
    String foodType;
    int foodPrice;

    /**
     * Create a kind of food
     * @param foodCode food's code
     * @param foodName food's name
     * @param foodType food's type
     * @param foodPrice food's price
     */
    public Food(String foodCode, String foodName, String foodType, int foodPrice){
        this.foodCode = foodCode;
        this.foodName = foodName;
        this.foodType = foodType;
        this.foodPrice = foodPrice;
    }

    /**
     * Get the food's code
     * @return  int foodCode
     */
    public String getFoodCode() {
        return foodCode;
    }

    /**
     * Get the food's name
     * @return String foodName
     */
    public String getFoodName() {
        return foodName;
    }

    /**
     * Get the food's type
     * @return String foodType
     */
    public String getFoodType() {
        return foodType;
    }

    /**
     * Get the food's price
     * @return int foodPrice
     */
    public int getFoodPrice() {
        return foodPrice;
    }

    /**
     * This method prints food's information and it is used when the customer enters list type
     */
    public void printFood(){
        System.out.println(getFoodCode() + " " + getFoodName() + " " + getFoodType() + " " + getFoodPrice());
    }

}
