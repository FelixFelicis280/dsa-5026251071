public class ColourPrint extends PrintJob{
    public ColourPrint(String id, int pages){
        super(id, pages);
    }

    @Override 
    public int calculateCharge(){
        int toCharge = super.getPages();
        int cost = 0;

        if(toCharge > 10){
            cost = 15000 + ((toCharge-10) * 1000);
        }else{
            cost = toCharge * 1500;
        }

        return cost + 2000;
    }

    @Override 
    public String label(){
        return "Colour";
    }
}