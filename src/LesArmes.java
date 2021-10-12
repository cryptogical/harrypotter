
import java.util.*;

public class LesArmes {
private List<Arme> lstArme;

    public LesArmes() {   lstArme = new ArrayList<Arme>();  }

    public List<Arme> getLstArmes() { return lstArme;    }
    public void setLstArmes(List<Arme> lst){this.lstArme = lst;}       
    
    public Arme getArme(int i) { return lstArme.get(i);}    
    public int getNbArme() { return lstArme.size();}
    
    public LesArmes getPotions()
    {  LesArmes res=new LesArmes();
       int l = this.getNbArme();
       for (int i=0; i<l; i++)
          if (this.getArme(i) instanceof Potion)    
                res.ajoutArme(this.getArme(i));
       return res; 
    }

    public LesArmes getSorts()
    {  LesArmes res=new LesArmes();
       int l = this.getNbArme();
       for (int i=0; i<l; i++)
          if (this.getArme(i) instanceof Sort)    
                res.ajoutArme(this.getArme(i));
       return res; 
    }
    
    // renvoie la position de Arme passée en parametre dans la collection
    public int rechArme(Arme p)
    { int i=0;
      while(i<lstArme.size() 
                && !lstArme.get(i).getNom().equals(p.getNom())) 
          i++;
      return i;
    }
    
    // renvoie vrai si la Arme passée en parametre est dans la collection
    public boolean estDans(Arme p){ return rechArme(p) != lstArme.size();}
    
    // supprime de la collection Arme dont le nom est passe en parametre
    public void supprArme(Arme p)   {   lstArme.remove(p);    }
    
    // renvoie Arme dont le nom est passe en parametre
    public Arme rechArme(String nom)
    {   int l = lstArme.size();
        for (int i=0; i<l; i++)
            if (lstArme.get(i).getNom().equals(nom))
                return lstArme.get(i);
        return null;
    }

    // ajoute une Arme passée en parametre a la collection
    public void ajoutArme(Arme p)   {     lstArme.add(p);   }
    
    
    @Override
    public String toString() {
        String s = "";
        int l = this.getSorts().getNbArme();
        if (l>0) s+=" >> ";
        for (int i=0; i<l; i++)
            s+=this.getSorts().getArme(i)+"   ";
        l = this.getPotions().getNbArme();
        if (l>0) s+="\n >> ";
        for (int i=0; i<l; i++)
            s+=this.getPotions().getArme(i)+"   ";
        return s;
    }

    void ajoutPotion(Potion p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
