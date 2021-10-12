public class CombatPotions extends Activite
{
    private LesArmes lp; // potions sélectionnées dans la liste des potions
    private Arme utiliser;
    
    public CombatPotions(Personnage p, Lieu l) {
    super(p,l);
    this.lp = new LesArmes();
    lp = p.getArmes().getPotions();
    
    
    }    
    
    public void setArmeU(Arme u){
        utiliser=u;
    }
    
    public void ajoutPotion(Potion p){
        this.lp.ajoutArme(p);  
    }

    // execute le combat 
    @Override
    public boolean execute()  
    {   String result="";      // description de l'activité
        int s = 0;             // somme des forces des potions
        boolean res = false;   // savoir si le combat a eu lieu
        Potion potion = ((Potion)getLieu()
                .getOccupant().getArmes().getPotions()
                .getArme((int)(Math.random()*getLieu()
                .getOccupant().getArmes()
                .getPotions().getNbArme())));   
        if(this.lp.getNbArme()!=0)
        {
            for(Arme ar: lp.getLstArmes().subList(0, lp.getNbArme()-1))  // supprime les doublon des potions
            {
                s += ((Potion)ar).getForce(); // additionne les forces des potions   
            }
            getJoueur().getArmes().supprArme(utiliser);  // supprime la potion utilisée
            
        boolean gagne = s>=potion.getForce();
                if(gagne)
                {
                    getJoueur().getArmes().ajoutArme(potion);
                    getJoueur().setExperience(getJoueur().getExperience()+potion.getForce());
                    result = "Victoire ! Force de vos Potions : "+s+"\n"+"Force de la potion de l'adversaire : "+potion.getForce()+"\n Vous gagnez la potion:"+potion+" et "+potion.getForce()+" exp";
                }         
                    else
                    {
                        getJoueur().setExperience(getJoueur().getExperience()-s);
                        result = "Défaite ! Force de vos Potion : "+s+"\n"+"Force de la potion de l'adversaire : "+potion.getForce()+"\n Vous perdez : "+s+" exp";
                    }
                this.setDescriptif(result);
            res = true;
        }
        return res;
    }
    
     @Override
    public String toString() {
        String res=super.toString()+"\n";
        res+= getJoueur().getNom() + " a combattu contre "
                 + getLieu().getOccupant().getNom()+" avec des potions \n"
                 + lp+"\n";
        return res;
    }   
}
