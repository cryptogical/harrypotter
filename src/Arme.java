public abstract class Arme {
    private String nom;
    private int force;

    public String getNom() {   return nom;    }
    public void setNom(String n) {  this.nom = n;  }

    public int getForce() {  return force;    }
    public void setForce(int f) { this.force = f;    }

    public Arme(){
        this.nom="";
        this.force=0;
    }
    public Arme(String n, int f) {
        this.nom = n;
        this.force = f;
    }

    @Override
    public abstract String toString();     
    
}
