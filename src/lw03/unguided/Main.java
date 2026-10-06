import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(Main.class.getResourceAsStream("registrations.txt"));
        
        LinkedHashMap<String, Boolean> registrations = new LinkedHashMap<>();
        
        while(sc.hasNext()){
            registrations.put(sc.next(), false);
        }

        sc.close();
        sc = new Scanner(Main.class.getResourceAsStream("checkins.txt"));

        List<String> checkIns = new ArrayList<>();

        while(sc.hasNext()){
            checkIns.add(sc.next());
        }

        List<String[]> status = new ArrayList<>();
        int success = 0;
        int rejected = 0;
        int absent;

        for(String checkIn : checkIns){
            boolean registered = false;
            
            for(String registration : registrations.keySet()){
                if(registration.equals(checkIn)){
                    registered = true;
                }
            }

            if(!registered){
                status.add(new String[] {checkIn, "Rejected (not registered)"});
                rejected++;
            }else if(registrations.get(checkIn)){
                status.add(new String[] {checkIn, "Rejected (already checked in)"});
                rejected++;
            }else{
                status.add(new String[] {checkIn, "Checked in"});
                registrations.put(checkIn, true);
                success++;
            }
        }
        absent = registrations.size() - success;

        System.out.println("==== Event Check-In Results ====");
        for(String[] item : status){
            System.out.println(item[0] + ": " + item[1]);
        }
        
        System.out.println("\n==== Final Event Summary ====");
        System.out.println("Registered students: " + registrations.size());
        System.out.println("Successful check-ins: " + success);
        System.out.println("Absent students: " + absent);
        System.out.println("Rejected attempts: " + rejected);
    }
}
