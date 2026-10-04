import java.util.*;

public class Main{
    public void main(String[] args){
        // Problem 1
        List<String> playlist = new ArrayList<>();

        Scanner sc = new Scanner(Main.class.getResourceAsStream("playlist.txt"));

        while(sc.hasNext()){
            String type = sc.next();
            int index = 0;
            if(type.equals("INSERT")){
                index = sc.nextInt();
            }
            String song = sc.nextLine();

            if(type.equals("ADD")){
                playlist.add(song);
            }else if(type.equals("INSERT")){
                playlist.add(index, song);
            }else{
                for(int i = 0; i < playlist.size(); i++){
                    if(song.equals(playlist.get(i))){
                        playlist.remove(i);
                        break;
                    }
                }
            }
        }

        System.out.println("===== Problem 1 =====");
        System.out.println("Total songs: " + playlist.size());
        for(int i = 0; i < playlist.size(); i++){
            System.out.println((i + 1) + ": " + playlist.get(i));
        }


        // Problem 2
        LinkedHashSet<String> participants = new LinkedHashSet<>();
        int dupe = 0;

        sc = new Scanner(Main.class.getResourceAsStream("participants.txt"));
        
        while(sc.hasNext()){
            String participant = sc.next();
            if(participants.contains(participant)){
                dupe++;
            }
            participants.add(participant);
        }

        System.out.println("\n===== Problem 2 =====");
        System.out.println("Unique participants: " + participants.size());

        int participantIndex = 1;
        for (String participant : participants) {
            System.out.println(participantIndex + ". " + participant);
            participantIndex++;
        }
        System.out.println("Duplicate registrations: " + dupe);


        // Problem 3
        LinkedHashMap<String, Integer> inventory = new LinkedHashMap<>();
        int failedTransaction = 0;

        sc = new Scanner(Main.class.getResourceAsStream("inventory.txt"));

        while(sc.hasNext()){
            String type = sc.next();
            String item = sc.next();
            int count = sc.nextInt();

            if(type.equals("ADD")){
                if(inventory.containsKey(item)){
                    for(Map.Entry<String, Integer> elem : inventory.entrySet()){
                        if(elem.getKey().equals(item)){
                            int storage = elem.getValue();
                            inventory.replace(elem.getKey(), elem.getValue() + count);
                        }
                    }
                }else{
                    inventory.put(item, count);
                }
            }
            else{
                for(Map.Entry<String, Integer> elem : inventory.entrySet()){
                    if(elem.getKey().equals(item)){
                        int storage = elem.getValue();
                        if(elem.getValue() >= count){
                            inventory.replace(elem.getKey(), elem.getValue() - count);
                        }else{
                            failedTransaction++;
                        }
                    }
                }
                if(!inventory.containsKey(item)){
                    failedTransaction++;
                }
            }
        }

        System.out.println("\n==== Problem 3 ====");
        List<String> keys = new ArrayList<>();
        List<Integer> values = new ArrayList<>();

        for(String key : inventory.keySet()){
            keys.add(key);
        }
        for(Integer value : inventory.values()){
            values.add(value);
        }

        for(int i = 0; i < keys.size(); i++){
            System.out.println(keys.get(i) + ": " + values.get(i));
        }
        System.out.println("Failed sales: " + failedTransaction);
    }
}