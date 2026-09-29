import java.util.*;

public class Main {
    public static void main(String[] args) {
        LinkedList<String[]> orders = new LinkedList<>();
        LinkedList<String[]> foodStock = new LinkedList<>();
        LinkedList<String[]> drinkStock = new LinkedList<>();
        LinkedList<String[]> successOrders = new LinkedList<>();
        Queue<String[]> orderQueue = new LinkedList<>();
        Stack<String[]> failOrder = new Stack<>();

        Scanner sc = new Scanner(Main.class.getResourceAsStream("orders.txt"));

        // Store orders in LinkedList
        while(sc.hasNext()){
            String name = sc.next();
            String food = sc.next();
            String drink = sc.next();
            String table = sc.next();
            
            String[] data = {name, food, drink, table};
            orders.add(data);
        }

        // Fill stock
        foodStock.add(new String[] {"Bakso", "2"});
        foodStock.add(new String[] {"Sate", "1"});
        foodStock.add(new String[] {"Soto", "2"});
        
        drinkStock.add(new String[] {"EsTeh", "4"});
        drinkStock.add(new String[] {"EsJeruk", "2"});

        // Fill queue with items in LinkedList orders
        for(String[] item : orders){
            orderQueue.add(item);
        }

        // Process order queue
        while(!orderQueue.isEmpty()){
            String[] item = orderQueue.poll();
            String food = item[1];
            String drink = item[2];
            boolean available = true;

            System.out.println(item[0]); // debug

            // Check stock is available
            if(!food.equals("-")){
                for(String[] stock : foodStock){
                    if(stock[0].equals(food)){
                        System.out.println(stock[0] + " : " + Integer.parseInt(stock[1])); // debug
                        if(Integer.parseInt(stock[1]) <= 0){    
                            available = false;
                        }
                    }
                }
            }
            if(!drink.equals("-")){
                for(String[] stock : drinkStock){
                    if(stock[0].equals(drink)){
                        System.out.println(stock[0] + " : " + Integer.parseInt(stock[1])); // debug
                        if(Integer.parseInt(stock[1]) <= 0){    
                            available = false;
                        }
                    }
                }
            }

            // Deduct stock if available
            if(available){
                if(!food.equals("-")){
                    for(String[] stock : foodStock){
                        if(stock[0].equals(food)){
                            int stockInt = Integer.parseInt(stock[1]);
                            stockInt -= 1;
                            stock[1] = stockInt + "";
                        }
                    }
                }
                if(!drink.equals("-")){
                    for(String[] stock : drinkStock){
                        if(stock[0].equals(drink)){
                            int stockInt = Integer.parseInt(stock[1]);
                            stockInt -= 1;
                            stock[1] = stockInt + "";
                        }
                    }
                }

                successOrders.add(item);
            }else{
                failOrder.add(item);
            }
        }

        System.out.println("=== Successfully Processed Orders ===");
        for(String[] item : successOrders){
            System.out.println(item[0] + " " + item[1] + " " + item[2] + " " + item[3] + " ");
        }
        
        System.out.println("\n=== Remaining Food Stock ===");
        for(String[] item : foodStock){
            System.out.println(item[0] + " : " + item[1]);
        }
        
        System.out.println("\n=== Remaining Drink Stock ===");
        for(String[] item : drinkStock){
            System.out.println(item[0] + " : " + item[1]);
        }
        
        System.out.println("\n=== Failed Orders ===");
        Stack<String[]> placeholder = new Stack<>(); // To preserve the existing stack
        while(!failOrder.isEmpty()){
            String[] failedItem = failOrder.pop();
            System.out.println(failedItem[0] + " " + failedItem[1] + " " + failedItem[2] + " " + failedItem[3] + " ");

            placeholder.add(failedItem);
        }
        for(String[] item : placeholder){
            failOrder.add(item);
        }
    }
}
