public class CombatSort extends Activite
{   
    private Sort js;    // sort choisi par le joueur
    
    public Sort getSort() {  return js;  }
    public void setSort(Sort s) {this.js=s;}
    
    public CombatSort(Sort s, Personnage p, Lieu l) {
      super(p,l);
      this.js=s;
    }   
    
    // execute le combat 
    public boolean execute()  
    {   boolean res = false;      // savoir si le combat a eu lieu
        String result="";         // description de l'activite
        Sort s = ((Sort)getLieu().getOccupant().getArmes().getSorts().getArme((int)(Math.random()*getLieu().getOccupant().getArmes().getSorts().getNbArme())));   
        boolean gagne = this.js.getForce()>=s.getForce();   
        if(js!=null)
            {          
                   if(gagne == true)
                   {    getJoueur().getArmes().ajoutArme(s);
                        getJoueur().setExperience(getJoueur().getExperience()+s.getForce());
                        result = "Victoire ! Force de votre sort : "+this.js.getForce()+"\nForce du sort du combattant :"+s.getForce()+"\n"; 
                        result+= "Sort obtenu : "+s+" \nainsi que :"+s.getForce()+" exp";   
                   }  
                   else       
                   {
                        getJoueur().setExperience(getJoueur().getExperience()-this.js.getForce());
                        result = "Defaite ! Force de votre sort  : "+this.js.getForce()+"\nForce du sort du combattant :"+s.getForce()+"\n"; 
                        result+= "Vous perdez :"+this.js.getForce()+" exp";   
                   }        
                   this.setDescriptif(result);  
                res = true;
            }
        return res;
    }
                     
                   
    public String toString() {
        String res= super.toString()+"\n";
        res+= getJoueur().getNom() + " a combattu contre "+ getLieu().getOccupant().getNom()+" avec le sort "+js.getNom()+"\n";
        return res;
    }   
}
