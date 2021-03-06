
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ap952080
 */
public class CombattreDlg extends javax.swing.JDialog {

    /**
     * Creates new form CombattreDlg
     */
    
    private Personnage pc;
    private LesArmes laC;
    private Lieu lieu;
    private CombatPotions cp;
    private CombatSort cs;
    private Sort js;
    private boolean ok;
    private Image img;
    private PanneauImage panImage;
    private Arme envoie;
    
    public CombattreDlg(java.awt.Frame parent, boolean modal, LesArmes la, Personnage p, Lieu l1) {
        super(parent, modal);
        initComponents();
        pc=p;
        laC=la;
        lieu=l1;
        sortPNJ.setText(lieu.getOccupant().getArmes().toString());
        img=lieu.getOccupant().getPhoto();
        panImage = new PanneauImage(img);
        repaint();
        nomPNJ.setText(lieu.getOccupant().getNom());
        this.setSize(530,450);
        this.setTitle("Combattre");
        this.setVisible(true);
        this.setLocation(600,200);          
    }
    
    
    
    public void paint(Graphics g) 
    { 
    super.paint(g);
    if(img != null)
        {
            Graphics gg= Panneau.getGraphics(); 
            gg.drawImage(img, 0, 0, Panneau.getWidth(), Panneau.getHeight(), this); 
        } 
    }

    
    
    
   private void initListe(){
        if(Sorts.isSelected())
      {   
          DefaultListModel lst = new DefaultListModel();
          for(int i=0; i<pc.getArmes().getSorts().getNbArme();i++)
          { 
            {
            lst.addElement(pc.getArmes().getSorts().getArme(i));
            }
            sortCombattre.setModel(lst); 
          }
      }
      
      if(Potions.isSelected())
      {
          DefaultListModel lst = new DefaultListModel();
          for(int i=0; i<pc.getArmes().getPotions().getNbArme();i++)
          {
            {
            lst.addElement(pc.getArmes().getPotions().getArme(i));
            }
            sortCombattre.setModel(lst); 
          }   
      }
                
    }
   
   
   
   public boolean cOk() {
        return ok;  
    }
   
 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        nomPNJ = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Panneau = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        sortPNJ = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        info = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        Sorts = new javax.swing.JRadioButton();
        Potions = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        sortCombattre = new javax.swing.JList<>();
        Combattre = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Resultat = new javax.swing.JTextArea();
        Fermer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(530, 450));

        nomPNJ.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel1.add(nomPNJ);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setLayout(new java.awt.GridLayout(2, 1));
        jPanel2.add(Panneau);

        sortPNJ.setColumns(20);
        sortPNJ.setRows(5);
        sortPNJ.setText("\n");
        jScrollPane2.setViewportView(sortPNJ);

        jPanel2.add(jScrollPane2);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.GridLayout(7, 1));

        info.setText("Type de combat :");
        jPanel3.add(info);

        jPanel4.setLayout(new java.awt.GridLayout(1, 2));

        buttonGroup1.add(Sorts);
        Sorts.setText("Sorts");
        Sorts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SortsActionPerformed(evt);
            }
        });
        jPanel4.add(Sorts);

        buttonGroup1.add(Potions);
        Potions.setText("Potions");
        Potions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PotionsActionPerformed(evt);
            }
        });
        jPanel4.add(Potions);

        jPanel3.add(jPanel4);

        jLabel2.setText("Choississez votre arme :                              ");
        jPanel3.add(jLabel2);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jScrollPane4.setViewportView(sortCombattre);

        jPanel5.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel5);

        Combattre.setText("Combattre");
        Combattre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CombattreActionPerformed(evt);
            }
        });
        jPanel3.add(Combattre);

        Resultat.setColumns(20);
        Resultat.setRows(5);
        jScrollPane1.setViewportView(Resultat);

        jPanel3.add(jScrollPane1);

        Fermer.setText("Fermer");
        Fermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FermerActionPerformed(evt);
            }
        });
        jPanel3.add(Fermer);

        getContentPane().add(jPanel3, java.awt.BorderLayout.EAST);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CombattreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CombattreActionPerformed
       
       
        if(Potions.isSelected())  
        {
            if(Potions.isSelected() && sortCombattre.getSelectedIndex() == -1)
           {
               info.setText("Choisissez une potion !");
           }
            else 
            {
           cp = new CombatPotions(pc, lieu);
           for(int j : sortCombattre.getSelectedIndices())
           {
               envoie =  pc.getArmes().getPotions().getArme(sortCombattre.getSelectedIndex());
               cp.ajoutPotion((Potion) pc.getArmes().getPotions().getArme(j));
           }
           cp.setArmeU(envoie);
           cp.execute();
           ok = true;
           Resultat.setText(cp.getDescriptif());
           Combattre.setEnabled(false);
            }
        }
       
        
        
        else if(Sorts.isSelected())
       { 
           if(Sorts.isSelected() && sortCombattre.getSelectedIndex() == -1)
           {
               info.setText("Choisissez un sort !");
           }
           
           else 
           {
           js = (Sort) pc.getArmes().getSorts().getArme(sortCombattre.getSelectedIndex());
           cs = new CombatSort(js, pc, lieu);;
           cs.execute();
           ok = true;
           Resultat.setText(cs.getDescriptif());
           Combattre.setEnabled(false);
           }
       }
        
    }//GEN-LAST:event_CombattreActionPerformed

    private void FermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FermerActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_FermerActionPerformed

    private void SortsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SortsActionPerformed
        initListe();
    }//GEN-LAST:event_SortsActionPerformed

    private void PotionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PotionsActionPerformed
        initListe();
        if(this.pc.getArmes().getPotions().getNbArme() == 0)
        {
            info.setText("Vous n'avez plus de potions !");
        }
    }//GEN-LAST:event_PotionsActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Combattre;
    private javax.swing.JButton Fermer;
    private javax.swing.JPanel Panneau;
    private javax.swing.JRadioButton Potions;
    private javax.swing.JTextArea Resultat;
    private javax.swing.JRadioButton Sorts;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel info;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel nomPNJ;
    private javax.swing.JList<String> sortCombattre;
    private javax.swing.JTextArea sortPNJ;
    // End of variables declaration//GEN-END:variables
}
