import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        LinkedList<String[]> transactionList = new LinkedList<>();
        LinkedList<String[]> custData = new LinkedList<>();
        Queue<String[]> transactionQueue = new LinkedList<>();
        Stack<String[]> transactionFail = new Stack<>();

        Scanner sc = new Scanner(Main.class.getResourceAsStream("transactions.txt"));
        while(sc.hasNext()){
            String nama = sc.next();
            String type = sc.next();
            String amount = sc.next();

            // Populate all transaction data in LinkedList
            String[] data = {nama, type, amount};
            transactionList.add(data);

            // Check if input is new customer
            boolean isNewCust = true;
            for (String[] elem : custData) {
                if(elem[0].equals(nama)){
                    isNewCust = false;
                }
            }
            if(isNewCust){
                String[] newCust = {nama, "0"};
                custData.add(newCust);
            }
        }
        
        // Move transaction list from LinkedList to queue
        for(String[] elem : transactionList){
            transactionQueue.add(elem);
        }
        
        // Process each queue of customer data
        while(!transactionQueue.isEmpty()){
            String[] data = transactionQueue.poll();
            String nama = data[0];
            String type = data[1];
            int amount = Integer.parseInt(data[2]);
            
            for (String[] elem : custData) {
                if(nama.equals(elem[0])){
                    int balance = Integer.parseInt(elem[1]);
                    if(type.equals("DEPOSIT")){
                        balance += amount;
                        elem[1] = balance + "";
                    }else{
                        balance -= amount;
                        if(balance >= 0){
                            elem[1] = balance + "";
                        }else{
                            transactionFail.push(data);
                        }
                    }
                }
            }
        }

        System.out.println("=== Final Balances ===");
        for (String[] elem : custData) {
            System.out.println(elem[0] + " : " + elem[1]);
        }
        System.out.println();
        System.out.println("=== Failed Transactions ===");
        for (String[] elem : transactionFail) {
            System.out.println(elem[0] + " " + elem[1] + " " + elem[2]);
        }
    }
}
