public abstract class Activite {
    Personnage p;     
    private Lieu lieu;          
    private String descriptif;
    
    /**
     *  methode abstraite qui realise le traitement relatif a l'action
     *  un combat ou un apprentissage
     **/
    public abstract boolean execute(); 

    /**
     * constructeur de la classe
     * @param lib type d'activité (APPRENTISSAGE ou COMBAT)
     * @param jc joueur qui demande cette activité
     * @param l  lieu où se déroule l'activité
     */
    public Activite(Personnage jc, Lieu l) {
        this.p=jc;
        this.lieu = l;
        descriptif="";
    }

    /**
     * accesseur en lecture du joueur
     * @return 
     **/
    public Personnage getJoueur() { return p;  }
    
    /**
     * modificateur du joueur
     * @param pers nouveau joueur
     */
    public void setjoueur(Personnage pers) {  this.p = pers;   }

    /**
     * accesseur en lecture du type d'activité
     * @return descriptif de l'activité sous forme d'une chaîne
     */
    //public String getLibelle() {  return libelle;  }
  
    /**
     * accesseur en lecture du lieu où se déroule l'activité
     * @return 
     **/
    public Lieu getLieu() {    return lieu;    }
    
    /**
     * modificateur du lieu
     * @param l nouveau lieu où se déroule l'activité
     */
    public void setLieu(Lieu l) {  this.lieu = l;   }

    public String getDescriptif() {  return descriptif;    }
    public void setDescriptif(String d) { this.descriptif = d;    }

    public Personnage getPersonnage() {  return p;    }   
    
    public String toString()
    {  
       return p.getNom()+ " dans "+lieu + "\nRésultat : "+descriptif; 
    }
}
