import java.awt.*;
import javax.swing.*;

public class BoutonImage extends JButton{
  private Image img;
    
    public BoutonImage()
    {
        super();
        this.img=null;
    }
    
    public BoutonImage(Image i)
    {   super();
        this.img=i;
    }
    
    public Image getImage () { return img;}
    public void setImage (Image i) { this.img=i;    }

    public void paint(Graphics g) {
        super.paint(g); 
        if (img != null)
        {
         Image imgB = img.getScaledInstance(this.getWidth(),this.getHeight(), Image.SCALE_DEFAULT);
         this.setIcon(new ImageIcon(imgB));
        }
        
      
    }   
}
