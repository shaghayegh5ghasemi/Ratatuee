package ratatuee;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class keeps the order's information
 */
public class Order {
    /**
     * this hashMap keep the order's food az a key and the food's number az a value
     */
    HashMap<Food, Integer> order = new HashMap<>();
    HashMap<Food, String> explanation = new HashMap<>();
    Bill bill = new Bill(order);
    /**
     * Get the order
     * @return HashMap order
     */
    public HashMap<Food, Integer> getOrder() {
        return order;
    }

    /**
     * Get the order's explanation
     * @return
     */
    public HashMap<Food, String> getExplanation() {
        return explanation;
    }

    /**
     * Get the order's bill
     * @return Bill bill
     */
    public Bill getBill() {
        return bill;
    }

    /**
     * add an ordered food with it's quantity
     * @param food the food to be added
     * @param number food's quantity
     */
    public void addFood(Food food, int number){
        if(food != null)
            order.put(food, number);
        else
            System.out.println("System does not have a food with this code!");
    }

    /**
     * add an ordered food with it's explanation
     * @param food the food to be added
     * @param explain the food's explanation
     */
    public void addExplanation(Food food, String explain){
        if(food != null)
            explanation.put(food, explain);
        else
            System.out.println("System does not have a food with this code!");
    }

    /**
     * make an order with the information
     * @param food
     * @param number
     * @param exp
     */
    public void makeOrder(Food food, Integer number, String exp){
        order.put(food, number);
        explanation.put(food, exp);
    }

    /**
     * returns the number of the foods in the order
     * @return
     */
    public int orderSize(){
        return order.size();
    }
}
