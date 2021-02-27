package ratatuee;

/**
 * This class keeps the restaurant's menu
 */

import java.util.ArrayList;

public class Menu {
    ArrayList<Food> foods = new ArrayList<>();

    /**
     * Get the restaurant's menu
     * @return ArrayList
     */
    public ArrayList<Food> getFoods() {
        return foods;
    }

    /**
     * This method adds a food to the menu
     * @param food
     */
    public void addFood(Food food){
        foods.add(food);
    }

    /**
     * This method removes a food from the menu
     * @param food
     */
    public void removeFood(Food food){foods.remove(food);}
    /**
     * This method prints the menu
     */
    public void printMenu(){
        for (Food food : foods){
            System.out.println(food.getFoodCode() + " " + food.getFoodName() + " " +
                    food.foodType + " " + food.foodPrice);
        }
    }

}
