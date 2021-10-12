
import java.awt.Image;

public class Lieu {
    private String typeLieu;
    private String description;
    private Personnage occupant;
    private Image photo;

    public Image getPhoto() {
        return photo;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }
    
    public Lieu () 
    { typeLieu=""; 
      description = "";
      occupant = new Personnage();
    }    
    public Lieu (String t, String d, Personnage p) 
    { typeLieu=t; description = d;occupant=p;}

    public String getDescription() { return description;    }
    public String getTypeLieu() {  return typeLieu;    }

    public void setTypeLieu(String t) {  this.typeLieu=t;    }
    public void setDescription(String d) {  this.description = d;   }

    public Personnage getOccupant() {  return occupant;  }

    public void setOccupant(Personnage oc) { this.occupant = oc; }

    @Override
    public String toString() {
        String res="("+typeLieu+") \n"+description;
        if (typeLieu.equals("Arène"))
            res+="avec pour combattant : \n" +occupant +"\n";
        else // salle de cours
            res+="avec pour maitre : "+ occupant +"\n";
        return  res;
    }
}
