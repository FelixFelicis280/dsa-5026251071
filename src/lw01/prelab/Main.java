import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(Main.class.getResourceAsStream("jobs.txt"));

        sc.next();
        MonoPrint p01 = new MonoPrint(sc.next(), sc.nextInt());
        sc.next();
        ColourPrint p02 = new ColourPrint(sc.next(), sc.nextInt());
        sc.next();
        ColourPrint p10 = new ColourPrint(sc.next(), sc.nextInt());
        sc.next();
        ColourPrint p11 = new ColourPrint(sc.next(), sc.nextInt());
        sc.next();
        MonoPrint p12 = new MonoPrint(sc.next(), sc.nextInt());

        PrintJob[] jobs = {p01, p02, p10, p11, p12};

        for(int i=0; i < 5; i++){
            System.out.println(jobs[i].summary());
        }
    }
}
