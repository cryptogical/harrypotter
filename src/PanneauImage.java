import java.awt.*;
import java.io.File;
import javax.swing.JPanel;

public class PanneauImage extends JPanel
{
    private Image img;
    
    public PanneauImage()
    {   super(); 
        String repertoire;
        repertoire=System.getProperty("user.dir").toString()+"\\src\\Images\\";
        img=Toolkit.getDefaultToolkit().getImage(repertoire+"inconnu.png");
    }
  
    public PanneauImage(Image i)
    {   super();
        img=i;  
    }

    PanneauImage(File fileChoisi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
    public Image getImage()    { return img;}
    
    public void setImage(Image i) 
    {   img=i;  //this.repaint(); 
    
    }
     
    /*
    * USELESS à cause de la methode paint dans ApprendreDlg
    */
    /*public void paint(Graphics g) 
   { super.paint(g);
     if (img!=null)
        g.drawImage(img,0,0,this.getWidth(), this.getHeight(),this);
     else
           System.out.println("pas d'image dans paint de PanneauImage");
   }*/
}
