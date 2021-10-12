import java.awt.Image;
import javax.swing.ImageIcon;

public class Personnage {
    private String nom;
    private int experience;
    private LesArmes armes;
    private Image photo;

    public Personnage(String nom, int experience, LesArmes ar, Image img) {
        this.nom = nom;
        this.experience = experience;
        this.armes = ar;
        this.photo = img;
    }
    
    public Personnage(String nom, int experience)
    {   this(nom, experience, new LesArmes(), null);    }
    public Personnage(String nom, int experience, LesArmes la)
    {   this(nom, experience, la, null);    }
    
    public Personnage()
    { this("", 0);}

    public String getNom() {   return nom;    }
    public void setNom(String nom) {        this.nom = nom;    }    

    public int getExperience() {        return experience;    }
    public void setExperience(int experience) { this.experience = experience; }

    public LesArmes getArmes() {  return armes;   }
    public void setArmes(LesArmes ar) { this.armes = ar; }
    
    public Image getPhoto() { return photo;    }
    public void setPhoto(Image p) { this.photo = p;   }

    public boolean equals(Personnage autre)
    { return this.nom.equals(autre.nom);}
    
    @Override
    public String toString() {
        return nom +""+"Experience :" + experience +"\n"+
                "Armes : " + armes +"\n";
    }
    

}
