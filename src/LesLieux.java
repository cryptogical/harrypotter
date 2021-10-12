/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ap952080
 */
public class LesLieux {
    
    Lieu[] tab;
    int MAXL=10;
    int nbl = 0;
    int compteur = 0;
    boolean test = false;
    
     public LesLieux() //constructeur par défaut
        {
            tab = new Lieu[MAXL];
        }
        
        public int getNbl(){return nbl;}
        public int getMaxl(){return MAXL;}
        
        
        public Lieu getLieu(int i)
        {
            if(i>=0 && i<nbl)
                return tab[i];
           else
                return null;
        }
        
        
        public Lieu rechLieu(String d)
        {
            for(int i=0;i<nbl;i++)
            {if(tab[i].getDescription() == d)
                return tab[i];
                }
            return null;
        }
        
        public boolean ajoutLieu(Lieu nv) 
        {
            if(nbl<MAXL)   
            {
                tab[nbl]=nv;
                nbl++;
                return test = true;
            }         
            else
                return test = false;
                
        }
        
        public String toString()
        {
            String s="";
            for(int i=0;i<nbl;i++)
            {s+=tab[i].toString();}
            return s;
        }
    
    
}
