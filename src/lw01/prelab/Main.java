import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(Main.class.getResourceAsStream("jobs.txt"));

        List<PrintJob> jobs = new ArrayList<>();

        while(sc.hasNext()){
            String type = sc.next();
            String id = sc.next();
            int pages = sc.nextInt();

            PrintJob job;

            if(type.equals("MONO")){
                job = new MonoPrint(id, pages);
            }else{
                job = new ColourPrint(id, pages);
            }

            jobs.add(job);
        }

        for(PrintJob job:jobs){
            System.out.println(job.summary());
        }
    }
}
