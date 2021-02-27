package ratatuee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Bill {
    HashMap<Food, Integer> order;
    public Bill(HashMap<Food, Integer> order){
        this.order = order;
    }


    /**
     * This method check if the all ordered food are from the same restaurant or not
     * @return
     */
    public boolean checkFoodCode(){
        /**
         * HashSet does not keep the same value twice
         */
        HashSet<String> check = new HashSet<>();
        String str = "";
        /**
         * to compare the 8 right digits (restaurant's phone number)
         */
        for(Food food : order.keySet()){
            for(int i = 0; i < 9; i++)
                str = str.concat(Character.toString(food.getFoodCode().charAt(i)));
            for(int j = 0 ; j < check.size(); j++){
                if(!check.contains(str))
                    check.add(str);
            }
        }
        if (check.size() > 1)
            return true;
        else return false;
    }


    /**
     * Calculate the order's total price
     * @return int bill
     */
    public int calculateBill(){
        int bill = 0;
        for (Food food : order.keySet()){
            bill += food.getFoodPrice()*order.get(food);
        }
        if(bill < 100000 || checkFoodCode())
            return bill + 5000;

        return bill;
    }

    /**
     * This method check if there is any delivery cost or not
     * @return true if there is delivery cost
     */
    public boolean deliveryCost(){
        int temp = 0;
        for (Food food : order.keySet()){
            temp += food.getFoodPrice()*order.get(food);
        }
        if(calculateBill() != temp)
            return true;
        return false;
    }
}
