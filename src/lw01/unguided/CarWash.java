public class CarWash extends WashService {
    public CarWash(String id, int days, int units){
        super(id, days, units);
    }

    @Override 
    public int calculateCharge(){
        if(super.getDays() <= 3){
            return (35000 * super.getDays()) + 15000;
        }else{
            return (35000 * 3) + ((super.getDays()-3) * 25000) + 15000;
        }
    }

    public String label(){
        return "Car";
    }
}
