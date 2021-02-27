package ratatuee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * This class only is in charge of extracting information from files and return the lists after processing
 */
public class ExtractingInfo {
    ReadingFromFile readingFromFile = new ReadingFromFile();
    String restaurantInfo = readingFromFile.readAllRestaurantContents();
    String customerInfo = readingFromFile.readAllCustomerContents();
    String temp;
    /**
     * This method read the string line by line and process it
     *
     * @return
     */
    public ArrayList<Restaurant> extractRestaurantList() {
        Scanner scanner = new Scanner(restaurantInfo);
        Menu menu = new Menu();
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (!line.isEmpty()) {
                if (Character.isAlphabetic(line.charAt(0))) {
                    restaurants.add(extractRestaurant(line));
                } else {
                    menu.addFood(extractFood(line));
                    if(!scanner.hasNextLine()){
                        restaurants.get(restaurants.size() - 1).setMenu(menu);
                        break;
                    }
                }
            } else {
                if (restaurants.size() != 0){
                    restaurants.get(restaurants.size() - 1).setMenu(menu);
                }
                menu = new Menu();
            }
        }
        return restaurants;
        }


    /**
     * extract restaurant's information in a specific line
     * @param myStr specific line
     * @return restaurant
     */
    public Restaurant extractRestaurant (String myStr){
        String[] array = myStr.split(",");
        Restaurant restaurant = new Restaurant(array[0], array[1], array[2]);
        temp = array[1];
        return restaurant;
    }

    /**
     * extract food's information in a specific line
     * @param myStr specific line
     * @return food
     */
    public Food extractFood (String myStr){
        String[] array = myStr.split(",");
        Food food = new Food(temp.concat(array[0]), array[1], array[2], Integer.parseInt(array[3]));
        return food;
    }

    public ArrayList<Customer> extractCustomerList() {
        Scanner scanner = new Scanner(customerInfo);
        ArrayList<Customer> customers = new ArrayList<>();
        Order order = new Order();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (!line.isEmpty()) {
                if (Character.isAlphabetic(line.charAt(0))) {
                    customers.add(extractCustomer(line));
                } else {
                    if (line.charAt(0) != '#') {
                        String[] array = line.split(",");
                        Food f = null;
                        for (int i = 0; i < extractRestaurantList().size(); i++) {
                            for (Food food : extractRestaurantList().get(i).getMenu().getFoods()) {
                                if (food.getFoodCode().equals(array[0]))
                                    f = food;
                            }
                        }
                        order.makeOrder(f, Integer.parseInt(array[1]), array[2]);
                    }
                    else {
                        if(customers.size() != 0)
                            customers.get(customers.size() - 1).addOrder(order);
                        order = new Order();
                    }
                }
            }
            else {
                order = new Order();
            }
        }
            return customers;
    }

    /**
     * extract food's information in a specific line
     * @param myStr specific line
     * @return customer
     */
    public Customer extractCustomer(String myStr){
        String[] array = myStr.split(",");
        Customer customer = new Customer(array[0], array[1], array[2]);
        return customer;
    }

    /**
     * this method reads a line to get the special order food
     * @param myStr specific line
     * @return
     */
}