public class Potion extends Arme{
    private String [] tabIng;
    private int nbi;
    
    public Potion(String n, int f, String[] ing)
    {
        super(n, f);
        tabIng=ing;
        nbi=0;
    }
    
    public Potion(String n, int f)
    {  this(n, f, null);nbi=0;    }

    public String[] getIngredients() {  return tabIng;    }
    public void setIngredients(String[] ing) {  this.tabIng = ing;    }
    
    public int getNbIng(){ return nbi;}
    
    public boolean ajoutIngredient(String ing)
    {  boolean ok=true;
       if (nbi<tabIng.length)
           tabIng[nbi++]=ing;
       else ok=false;
       return ok;        
    }
    
    @Override
    public String toString() {
        return  "Potion "+getNom() + " (" + getForce()+")";
    } 
}
