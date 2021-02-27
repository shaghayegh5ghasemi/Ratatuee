package ratatuee;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class id the center of whole program
 */
public class Ratatuee {
    ArrayList<Restaurant> restaurants = new ArrayList<>();
    ArrayList<Customer> customers = new ArrayList<>();
    ExtractingInfo info = new ExtractingInfo();

    /**
     * read the information from files eith the help of ExtractingInfo class
     */
    public Ratatuee(){
        restaurants = info.extractRestaurantList();
        customers = info.extractCustomerList();
    }

    /**
     * This method works when the user enters menu <restaurant_phoneNo> and prints the restaurant's menu
     * @param phone restaurant's phone
     */
    public void menuRestaurantPhone(String phone){
        for(Restaurant restaurant : restaurants){
            if (restaurant.getPhoneNo().equals(phone))
                restaurant.getMenu().printMenu();
        }
    }

    /**
     * This method works when the user enters restaurants and prints the whole restaurants involved in the system
     */
    public void restaurantsList(){
        for(Restaurant restaurant : restaurants)
            restaurant.printRestaurant();
    }

    /**
     * This method works when the user enters restaurants near <customer_phoneNo> and prints near restaurant's details
     * @param phone
     */
    public void  restaurantNearList(String phone){
        String reg = "";
        for(Customer customer : customers){
            if(customer.getPhoneNo().equals(phone));
                reg = customer.region;
        }
        for (Restaurant restaurant : restaurants){
            if (restaurant.checkRestaurantRegion(reg))
                restaurant.printRestaurant();
        }
    }

    /**
     * This method works when the user enters list near </customer_phoneNo> and prints list of near restaurant's food
     * @param phone customer's phone
     */
    public void foodNearList(String phone){
        String reg = "";
        for(Customer customer : customers){
            if(customer.getPhoneNo().equals(phone));
            reg = customer.region;
        }
        for (Restaurant restaurant : restaurants){
            if (restaurant.checkRestaurantRegion(reg))
                restaurant.getMenu().printMenu();
        }
    }

    /**
     * This method works when the user enters list type and prints all foods with thw same type as entered type
     * @param type
     */
    public void foodTypeList(String type){
        for (Restaurant restaurant : restaurants)
            restaurant.printFood(type);
    }

    /**
     * this method search a food with it's code and adds it to the order
     * @param str
     * @param order
     */
    public void searchFood(String str, Order order){
        String[] array = str.split(" ");
        for(int i = 0; i < restaurants.size(); i++){
            for(Food food : restaurants.get(i).getMenu().getFoods()){
                if(food.getFoodCode().equals(array[0])){
                    if(array.length == 2){
                        order.addFood(food, Integer.parseInt(array[1]));
                    }
                    if (array.length > 2){
                        String exp = " ";
                        for( int j = 2; j < array.length; j++){
                            exp = exp.concat(" " + array[j]);
                        }
                        order.addFood(food, Integer.parseInt(array[1]));
                        order.addExplanation(food, exp);
                    }
                }
            }
        }
    }

    /**
     * This method register a new order
     * @param phone customer's phone
     * @return Order
     */
    public Order registerOrder(String phone){
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Order order = new Order();
        for (Customer customer : customers){
            if (customer.checkCustomer(phone))
            {
                while(!line.equals("$")){
                    searchFood(line, order);
                    line = scanner.nextLine();
                }
            }
        }
        return order;
        }



    /**
     * This method get a new order from th customer and calculate the bill
     * @param phone customer's phone
     */
    public void calculateOrder(String phone){
        Order order = registerOrder(phone);
        for(Customer customer : customers)
            customer.printSpecificCustomer(phone);
        System.out.println(order.getBill().calculateBill());
        /**
         * add the new order to the customer's order list
         */
        for(Customer customer : customers)
            if (customer.checkCustomer(phone))
                customer.addOrder(order);
    }

    /**
     * This method prints the customer's bill's information
     * @param phone customer's phone
     * @param index which bill to be printed
     */
    public void printBill(String phone ,int index){
        for(Customer customer : customers){
            if(customer.checkCustomer(phone)){
                for(Food food : customer.getOrders().get(index).getOrder().keySet()){
                    System.out.println(food.getFoodName() + " " + customer.getOrders().get(index).getOrder().get(food) + " "
                    + food.getFoodPrice() + " " + customer.getOrders().get(index).getOrder().get(food)*food.getFoodPrice() + " "
                            + customer.getOrders().get(index).getExplanation().get(food));
                }

                if(customer.getOrders().get(index).getBill().deliveryCost())
                    System.out.println("Delivery cost: " + "5000");
                else
                    System.out.println("Delivery cost: " + "0");

                System.out.println("Total cost: " + customer.getOrders().get(index).getBill().calculateBill());
            }
        }
    }

    /**
     * Print all customer's bill
     * @param phone customer's bill
     */
    public void printAllBills(String phone){
        for (Customer customer : customers){
            if(customer.checkCustomer(phone)){
                customer.printSpecificCustomer(phone);
                System.out.printf("\n");
                for(int i = 0; i < customer.getOrders().size(); i++){
                    printBill(phone, i);
                    System.out.println("#");
                }
            }
        }
    }

    /**
     * this method perform the main tasks in the System base on the input thas user enters
     * @param str
     */
    public void task(String str){
        String[] array = str.split(" ");
        if (array.length == 1){
            if(array[0].equals("restaurants"))
                restaurantsList();
        }
        if(array.length == 2){
            if(array[0].equals("menu"))
                menuRestaurantPhone(array[1]);
            if(array[0].equals("order")){
                calculateOrder(array[1]);
            }
            if(array[0].equals("bill")){
                for (Customer customer: customers)
                    customer.printSpecificCustomer(array[1]);
                System.out.printf("\n");
                for (Customer customer: customers){
                    if (customer.checkCustomer(array[1]))
                        printBill(array[1], customer.getOrders().size() - 1);
                }
            }
        }

        if(array.length == 3){
            if (array[0].equals("restaurants") && array[1].equals("near"))
                restaurantNearList(array[2]);
            if(array[0].equals("list") && array[1].equals("near"))
                foodNearList(array[2]);
            if(array[0].equals("list") && array[1].equals("type"))
                foodTypeList(array[2]);
            if(array[0].equals("bill") && array[1].equals("all"))
                printAllBills(array[2]);
        }

    }

}
