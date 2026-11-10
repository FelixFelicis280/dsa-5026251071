import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("parcels.txt"));

        // Read input
        int parcelCount = sc.nextInt();
        int[] parcels = new int[parcelCount];
        for (int i = 0; i < parcelCount; i++) {
            parcels[i] = sc.nextInt();
        }

        int targetCount = sc.nextInt();
        int[] targets = new int[targetCount];
        for (int i = 0; i < targetCount; i++) {
            targets[i] = sc.nextInt();
        }
        sc.close();

        // Descending bubble sort
        int[] parcels2Passes = new int[parcelCount];
        for (int i = 0; i < parcelCount - 1; i++) {
            if(i == 2){
                for (int j = 0; j < parcelCount; j++) {
                    parcels2Passes[j] = parcels[j];
                }
            }

            for(int j = 0; j < parcelCount - i - 1; j++){
                if(parcels[j] < parcels[j + 1]){
                    int temp = parcels[j];
                    parcels[j] = parcels[j + 1];
                    parcels[j + 1] = temp;
                }
            }
        }

        // Output
        System.out.println("=== After 2 Passes ===");
        for (int parcel : parcels2Passes) {
            System.out.print(parcel + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println("=== Fully Sorted ===");
        for (int parcel : parcels) {
            System.out.print(parcel + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println("=== Search Results ===");
        for (int target : targets) {
            int[] searchResult = binarySearch(parcels, target);
            String status;
            if(searchResult[0] == -1){
                System.out.println(target + ": " + "NOT FOUND" + " (steps: " + searchResult[1] + ")");
            }else{
                System.out.println(target + ": " + "FOUND" + " at index " + searchResult[0] + " (steps: " + searchResult[1] + ")");
            }
        }
    }

    public static int[] binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int index = -1;
        int steps = 0;

        while (low <= high) {
            steps++;
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                index = mid;
                break;
            } else if (arr[mid] < target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{index, steps};
    }
}