import java.util.Scanner;

public class Main {
    public void main(String[] args){
        Scanner sc = new Scanner(Main.class.getResourceAsStream("branches.txt"));

        // Read input
        int branchCount = sc.nextInt();
        int[] stabilityValues = new int[branchCount];
        for(int i = 0; i < branchCount; i++){
            stabilityValues[i] = sc.nextInt();
        }
        
        int targetCount = sc.nextInt();
        int[] targetValues = new int[targetCount];
        for(int i = 0; i < targetCount; i++){
            targetValues[i] = sc.nextInt();
        }
        
        int[] targetIndex = new int[targetCount];
        for (int i = 0; i < targetCount; i++){
            targetIndex[i] = -1;
        }
        

        // Perform insertion sort
        int passes = 0;
        for(int i = 1; i < branchCount-1 && passes < 3; i++){
            passes++;
            
            int key = stabilityValues[i];
            int j = i-1;
            while(j >= 0 && stabilityValues[j] < key){
                stabilityValues[j+1] = stabilityValues[j];
                j--;
            }

            stabilityValues[j+1] = key;
        }

        // Search for target
        for(int i = 0; i < targetCount; i++){
            for(int j = 0; j < branchCount; j++){
                if(targetValues[i] == stabilityValues[j]){
                    targetIndex[i] = j;
                }
            }
        }

        // Display array
        for(int i : stabilityValues){
            System.out.print(i + " ");
        }
        System.out.println();

        // Display search result
        for(int i = 0; i < targetCount; i++){
            if(targetIndex[i] == -1){
                System.out.println(targetValues[i] + ": NOT FOUND");
            }else{
                System.out.println(targetValues[i] + ": FOUND at index " + targetIndex[i]);
            }
        }
    }
}
