public class Sort extends Arme{
  private String effet;
  
    public Sort(String n, int f, String e) {
        super(n, f);
        effet=e;
    }

    public Sort(String n, int f){
        this(n, f, "aucun");
    }
    
    public String getEffet() {   return effet;   }

    public void setEffet(String e) {  this.effet = e;   }

    @Override
    public String toString() {
        return "Sort :" + getNom()+ " (" + getForce() +")"+"\n";
    }   
}
