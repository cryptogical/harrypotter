public class Apprentissage extends Activite {
    private Sort js; 

    public Sort getSort() {    return js;    }
    public void setSort(Sort s) {    this.js = s;    }

    public Apprentissage(Sort s, Personnage acteur, Lieu l) {
        super(acteur, l);
        this.js = s;
    }
    
    public Apprentissage(Personnage acteur, Lieu l) {
        super(acteur, l);
        this.js = null;
    } 
    
    @Override
    public boolean execute()
    {  Personnage oc = getLieu().getOccupant();
       int n=(int)(Math.random()*200);
       // int n=(int)(Math.random()*150);
       boolean gagne=getJoueur().getExperience()+n>=oc.getExperience();
       if (gagne) 
       {  // le joueur gagne le sort
           getJoueur().getArmes().ajoutArme(js); 
           // le joueur augmente son expérience de la force du sort gagné
           getJoueur().setExperience(getJoueur().getExperience()+js.getForce()); 
           // mise à jour du descriptif
           this.setDescriptif("Vous avez appris le sort "+js.getNom());
        }
       else
           this.setDescriptif("Vous n'avez pas appris le sort "+js.getNom());
        // l'action a toujours lieu
        return true;
    }
    @Override
    public String toString() {
        Personnage oc = getLieu().getOccupant();
        return super.toString()+"\n du sort "+js.getNom()+" par le maitre "+oc.getNom();
    }
    

    
}
