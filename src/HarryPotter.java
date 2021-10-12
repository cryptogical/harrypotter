
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.DefaultListModel;
import javax.swing.JButton;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
*TODO*

OPTIMISATION IA COMBAT SORT ET POTIONS - done
Optimisation du code de base - en cours 
sinon projet finit

*ENDTODO*
*/



/**
 *
 * @author ap952080
 */
public class HarryPotter extends javax.swing.JFrame{

    /**
     * Creates new form ex2
     */

    private LesLieux ll;
    private Personnage lj[];
    private Personnage p1;
    private Personnage p2;
    private LesArmes la = new LesArmes();
    private Personnage pc;
    private Image img;
    private Image couverture = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Images/couverture.jpg"));
    private int MaxExp = 250;
    private BoutonImage bImg;
    
    public HarryPotter() 
    {   
        bImg = new BoutonImage(couverture);
        repaint();
        initComponents();
        initArmes();
        initPersonnageJoueursTP(la);
        initPersonnagesNonJoueursTP(la);
        initCollection();
        initCombo();
        initInfo(false);
        Action.setVisible(false);
        p1 = null;
        p2 = null;
        Combattre.setVisible(false);
        Apprendre.setVisible(false); 
        
    } 

    
    
    private LesArmes initArmes()
    {    la = new LesArmes();

        // les potions
         String []ing1={"Valériane", "Baies de gui", "Eau du fleuve Léthé"};
         la.ajoutArme(new Potion("Amnésie",50, ing1));
         String [] ing2={"Oeuf de Serpencendre", "Poudres rouge, bleue, jaune, verte"};
         la.ajoutArme(new Potion("Amortentia",40, ing2));
         String [] ing3={"Plume de Jobarville"};
         la.ajoutArme(new Potion("Veritaserum",70, ing3));
         String [] ing4={"Sangsues", "Peau de serpent d'arbre du Cap", "Corne de bicorne"};
         la.ajoutArme(new Potion("Polynectar",60, ing4));
         String [] ing5={"Hydromel", "Menthe poivrée", "Mandragore cuite", "Sirop d'érable"};
         la.ajoutArme(new Potion("Volubilis",20, ing5));
         String [] ing6={"Scarabées", "Chou mordeur de Chine", "Yeux de poisson hérisson"};
         la.ajoutArme(new Potion("Poussos",40, ing6));
         
         // les sorts
         la.ajoutArme(new Sort("Expelliarmus",10, "désarmer son adversaire"));
         la.ajoutArme(new Sort("Stupefix",10, "faire entrer la cible dans un état proche du coma"));
         la.ajoutArme(new Sort("Reducto",20, "briser des objets solides"));
         la.ajoutArme(new Sort("Avada kedavra",50, "tuer la personne visée"));
         la.ajoutArme(new Sort("Endoloris",40, "torturer"));
         la.ajoutArme(new Sort("Impero",30, "soumettre à un contrôle total du sorcier qui le lance")); 
         return la;
    } 
    
    
    
    public void paint(Graphics g) 
    { 
    super.paint(g);
    if(img != null)
        {
            Graphics gg= ImageLieu.getGraphics(); 
            gg.drawImage(img, 0, 0, ImageLieu.getWidth(), ImageLieu.getHeight(), this); 
        } 
    }

    
    
     private Personnage[] initPersonnagesNonJoueursTP(LesArmes la)
    {   Personnage p;
        Personnage [] lst= new Personnage[6];
        
        Image img1 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Images/ron.jpg"));
        Image img2 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Images/mcgonagall.jpg"));
        Image img3 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Images/crab.jpg"));
        Image img4 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Images/lavande.jpg"));
        Image img5 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Images/flitwick.jpg"));
        Image img6 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Images/lupin.jpg"));
        
        
        //maitre de salle de cours
        p=new Personnage("McGonagall",400);
        p.getArmes().ajoutArme(la.getSorts().getArme(0));
        p.getArmes().ajoutArme(la.getSorts().getArme(1));
        p.getArmes().ajoutArme(la.getSorts().getArme(4));
        p.getArmes().ajoutArme(la.getSorts().getArme(5));
        p.setPhoto(img1);
        lst[0]=p;
        
        //combattants de salles de combat
        p=new Personnage("Ron",350);
        p.getArmes().ajoutArme(la.getPotions().getArme(1));
        p.getArmes().ajoutArme(la.getPotions().getArme(4));
        p.getArmes().ajoutArme(la.getSorts().getArme(0));
        p.getArmes().ajoutArme(la.getSorts().getArme(1));
        p.getArmes().ajoutArme(la.getSorts().getArme(2));
        p.getArmes().ajoutArme(la.getSorts().getArme(5));
        p.setPhoto(img2);
        lst[1]=p;
        
        //combattant
        p=new Personnage("Crab",250);
        p.getArmes().ajoutArme(la.getPotions().getArme(5));
        p.getArmes().ajoutArme(la.getPotions().getArme(2));
        p.getArmes().ajoutArme(la.getPotions().getArme(1));
        p.getArmes().ajoutArme(la.getSorts().getArme(3));
        p.getArmes().ajoutArme(la.getSorts().getArme(5));
        p.getArmes().ajoutArme(la.getSorts().getArme(1));
        p.setPhoto(img3);
        lst[2]=p;
        
        //combatant
        p=new Personnage("Lavande",200);
        p.getArmes().ajoutArme(la.getPotions().getArme(2));
        p.getArmes().ajoutArme(la.getPotions().getArme(0));
        p.getArmes().ajoutArme(la.getPotions().getArme(3));
        p.getArmes().ajoutArme(la.getSorts().getArme(4));
        p.getArmes().ajoutArme(la.getSorts().getArme(2));
        p.setPhoto(img4);
        lst[3]=p;
        
        //salle de cours
        p=new Personnage("Fliwick",300);
        p.getArmes().ajoutArme(la.getSorts().getArme(4));
        p.getArmes().ajoutArme(la.getSorts().getArme(0));
        p.getArmes().ajoutArme(la.getSorts().getArme(5));
        p.getArmes().ajoutArme(la.getSorts().getArme(1));
        p.setPhoto(img5);
        repaint();
        lst[4]=p;
        
        //salle de cours
        p=new Personnage("Lupin",350);
        p.getArmes().ajoutArme(la.getSorts().getArme(3));
        p.getArmes().ajoutArme(la.getSorts().getArme(0));
        p.getArmes().ajoutArme(la.getSorts().getArme(2));
        p.setPhoto(img6);
        repaint();
        lst[5]=p;
        
        return lst;
    }

     
     
    
    // affiche les caract du joueur à droite
    private void afficheJoueur(int i, Personnage j)
    {
        initInfo(true); // on affiche les caractéristiques
            if(i==1)
            {
            actionnomj1.setText(j.getNom());
            actionxpj1.setText(""+j.getExperience());
            actionsortj1.setText(j.getArmes().getSorts().toString());
            actionpotionj1.setText(j.getArmes().getPotions().toString());
            }

            if(i==2)
            {
            actionnomj2.setText(j.getNom());
            actionxpj2.setText(""+j.getExperience());
            actionsortj2.setText(j.getArmes().getSorts().toString());
            actionpotionj2.setText(j.getArmes().getPotions().toString());   
            }

      
    }
    
    
    
    // joueur courrant
    public Personnage getJoueur(int i){
        if (i == 1)
            return p1;
        else
            return p2;
    }
    
    
    
     public void initPersonnageJoueursTP(LesArmes la)
    {
        lj = new Personnage[6]; 
        LesArmes HP = new LesArmes();
        HP.ajoutArme(la.getPotions().getArme(0));
        HP.ajoutArme(la.getPotions().getArme(5));
        HP.ajoutArme(la.getPotions().getArme(4));
        HP.ajoutArme(la.getSorts().getArme(0));
        HP.ajoutArme(la.getSorts().getArme(4));
        
        LesArmes HE = new LesArmes();
        HE.ajoutArme(la.getPotions().getArme(2));
        HE.ajoutArme(la.getSorts().getArme(4));
        HE.ajoutArme(la.getSorts().getArme(5));
        HE.ajoutArme(la.getSorts().getArme(2));
        
        LesArmes DR = new LesArmes();
        DR.ajoutArme(la.getPotions().getArme(3));
        DR.ajoutArme(la.getPotions().getArme(4));
        DR.ajoutArme(la.getSorts().getArme(3));
        DR.ajoutArme(la.getSorts().getArme(5));
                
        LesArmes CH = new LesArmes();
        CH.ajoutArme(la.getPotions().getArme(1));
        CH.ajoutArme(la.getPotions().getArme(3));
        CH.ajoutArme(la.getSorts().getArme(1));
        CH.ajoutArme(la.getSorts().getArme(2));
        CH.ajoutArme(la.getSorts().getArme(5));
        
        LesArmes LU = new LesArmes();
        LU.ajoutArme(la.getPotions().getArme(0));
        LU.ajoutArme(la.getPotions().getArme(1));
        LU.ajoutArme(la.getPotions().getArme(5));
        LU.ajoutArme(la.getSorts().getArme(0));
        LU.ajoutArme(la.getSorts().getArme(2));
        
        LesArmes CE = new LesArmes();
        CE.ajoutArme(la.getPotions().getArme(3));
        CE.ajoutArme(la.getPotions().getArme(1));
        CE.ajoutArme(la.getSorts().getArme(3));
        CE.ajoutArme(la.getSorts().getArme(1));
              
        
        lj[0] = new Personnage("Harry Potter", 200, HP);
        lj[1] = new Personnage("Hermione", 200, HE);      
        lj[2] = new Personnage("Drago", 200, DR);
        lj[3] = new Personnage("Cho", 200, CH);
        lj[4] = new Personnage("Luna", 200, LU);
        lj[5] = new Personnage("Cedric", 200, CE);
        
    }
    
     
     
     // initialisation combobox lieu
    private void initCombo()
    {
        CBLieu.removeAllItems();
        CBLieu.addItem("Remplir dynamiquement");
        for(int i=0;i<ll.getNbl();i++)
         { 
          CBLieu.addItem(ll.getLieu(i).getTypeLieu());   
         }
        repaint();
    }
    
    
    
    
    // initialisation des collections perso non joueurs
    private void  initCollection()
    {         
        
        Image img1 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Images/ron.jpg"));
        Image img2 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Images/mcgonagall.jpg"));
        Image img3 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Images/crab.jpg"));
        Image img4 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Images/lavande.jpg"));
        Image img5 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Images/flitwick.jpg"));
        Image img6 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Images/lupin.jpg"));
        Image img7 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Images/chemin.png"));
        Image img8 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Images/astro.png"));
        Image img9 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Images/duel.jpg"));
        Image img10 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Images/foret.jpg"));
        Image img11 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Images/potions.jpg"));
        Image img12 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Images/pre.jpg"));
        
        
        Lieu Lieu1 = new Lieu();
        Personnage ron = new Personnage("Ron", 350);
        ron.getArmes().ajoutArme(la.getPotions().getArme(1));
        ron.getArmes().ajoutArme(la.getPotions().getArme(4));
        ron.getArmes().ajoutArme(la.getSorts().getArme(0));
        ron.getArmes().ajoutArme(la.getSorts().getArme(1));
        ron.getArmes().ajoutArme(la.getSorts().getArme(2));
        ron.getArmes().ajoutArme(la.getSorts().getArme(5));
        ron.setPhoto(img1);
        Lieu1.setTypeLieu("Arène n°1");
        Lieu1.setOccupant(ron);
        Lieu1.setDescription(Lieu1.toString());
        Lieu1.setPhoto(img7);
        
        
        Lieu Lieu2 = new Lieu();
        Personnage mcg = new Personnage("McGonagall", 300);
        mcg.getArmes().ajoutArme(la.getSorts().getArme(0));
        mcg.getArmes().ajoutArme(la.getSorts().getArme(1));
        mcg.getArmes().ajoutArme(la.getSorts().getArme(4));
        mcg.getArmes().ajoutArme(la.getSorts().getArme(5));
        mcg.setPhoto(img2);
        Lieu2.setTypeLieu("Salle de Cours n°1");
        Lieu2.setOccupant(mcg);
        Lieu2.setDescription(Lieu2.toString());
        Lieu2.setPhoto(img8);
        
        
        Lieu Lieu3 = new Lieu();
        Personnage crab = new Personnage("Crab", 350);
        crab.getArmes().ajoutArme(la.getPotions().getArme(5));
        crab.getArmes().ajoutArme(la.getPotions().getArme(2));
        crab.getArmes().ajoutArme(la.getPotions().getArme(1));
        crab.getArmes().ajoutArme(la.getSorts().getArme(3));
        crab.getArmes().ajoutArme(la.getSorts().getArme(5));
        crab.getArmes().ajoutArme(la.getSorts().getArme(1));
        crab.setPhoto(img3);
        Lieu3.setTypeLieu("Arène n°2");
        Lieu3.setOccupant(crab);
        Lieu3.setDescription(Lieu3.toString());
        Lieu3.setPhoto(img9);
        
        
        Lieu Lieu4 = new Lieu();
        Personnage lavande =new Personnage("Lavande",200);
        lavande.getArmes().ajoutArme(la.getPotions().getArme(2));
        lavande.getArmes().ajoutArme(la.getPotions().getArme(0));
        lavande.getArmes().ajoutArme(la.getPotions().getArme(3));
        lavande.getArmes().ajoutArme(la.getSorts().getArme(4));
        lavande.getArmes().ajoutArme(la.getSorts().getArme(2));
        lavande.setPhoto(img4);
        Lieu4.setTypeLieu("Arène n°3");
        Lieu4.setOccupant(lavande);
        Lieu4.setDescription(Lieu4.toString());
        Lieu4.setPhoto(img10);
        
        
        Lieu Lieu5 = new Lieu();
        Personnage fli =new Personnage("Fliwick",300);
        fli.getArmes().ajoutArme(la.getSorts().getArme(4));
        fli.getArmes().ajoutArme(la.getSorts().getArme(0));
        fli.getArmes().ajoutArme(la.getSorts().getArme(5));
        fli.getArmes().ajoutArme(la.getSorts().getArme(1));
        fli.setPhoto(img5);
        Lieu5.setTypeLieu("Salle de Cours n°2");
        Lieu5.setOccupant(fli);
        Lieu5.setDescription(Lieu5.toString());
        Lieu5.setPhoto(img11);
            
        
        Lieu Lieu6 = new Lieu();
        Personnage lupin = new Personnage("Prof Lupin", 350);
        lupin.getArmes().ajoutArme(la.getSorts().getArme(3));
        lupin.getArmes().ajoutArme(la.getSorts().getArme(0));
        lupin.getArmes().ajoutArme(la.getSorts().getArme(2));
        lupin.setPhoto(img6);
        Lieu6.setTypeLieu("Salle de Cours n°3");
        Lieu6.setOccupant(lupin); 
        Lieu6.setDescription(Lieu6.toString());
        Lieu6.setPhoto(img12);
        
        
        ll = new LesLieux();
        ll.ajoutLieu(Lieu1);
        ll.ajoutLieu(Lieu2);
        ll.ajoutLieu(Lieu3);
        ll.ajoutLieu(Lieu4);
        ll.ajoutLieu(Lieu5);
        ll.ajoutLieu(Lieu6);
    }
    
    
    public void Refresh(){
        
        CBLieu.revalidate();
        ImageLieu.repaint();
    }
    
    public boolean finJeu() {
        boolean gagne;
           
        
            if(p1.getExperience() >= MaxExp && p2.getExperience() <= MaxExp) {
            Edition.setText("Le joueur "+p1.getNom()+" a gagné !");
            Message.setText("Terminé !");
            Combattre.setVisible(false);
            Apprendre.setVisible(false);
            CBLieu.setEnabled(false);
            return gagne = true;
            }
            
            
            
            else if(p2.getExperience() >= MaxExp && p1.getExperience() <= MaxExp) {
            Edition.setText("Le joueur "+p2.getNom()+" a gagné !");
            Message.setText("Terminé !");
            Combattre.setVisible(false);
            Apprendre.setVisible(false);
            CBLieu.setEnabled(false);
            return gagne = true;
            }
            
            
            
            if(p1.getArmes().getNbArme()<1) {
            Edition.setText("Le joueur "+p2.getNom()+" a gagné car le joueur "+p1.getNom()+" n'a plus d'arme !");
            Message.setText("Terminé !");
            Combattre.setVisible(false);
            Apprendre.setVisible(false);
            CBLieu.setEnabled(false);
            return gagne = true;
            }
            
            
            
            if(p2.getArmes().getNbArme()<1) {
            Edition.setText("Le joueur "+p1.getNom()+" a gagné car le joueur "+p2.getNom()+" n'a plus d'arme !");
            Message.setText("Terminé !");
            Combattre.setVisible(false);
            Apprendre.setVisible(false);
            CBLieu.setEnabled(false);
            return gagne = true;
             }
            
        return gagne = false;
}
    
    
    
    
    private void initInfo(boolean b)
    {
        if(b == true)
        {
            jPanel4.setVisible(true);
        }
        
        else
        {
            jPanel4.setVisible(false);
        }
        
    }
    
    
    public void changementTour()
     {         
         if (p1 == pc) 
        {  
            afficheJoueur(1,p1);
            Message.setText("Au tour de : "+p2.getNom());
            pc=p2;
        }
         else if (p2 == pc) 
         {
             afficheJoueur(2,p2);
             Message.setText("Au tour de : "+p1.getNom());
             pc=p1;
         }
      finJeu();
     }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        labelj1 = new javax.swing.JLabel();
        labelj12 = new javax.swing.JLabel();
        NOM1 = new javax.swing.JLabel();
        actionnomj1 = new javax.swing.JLabel();
        XP1 = new javax.swing.JLabel();
        actionxpj1 = new javax.swing.JLabel();
        S1 = new javax.swing.JLabel();
        actionsortj1 = new javax.swing.JLabel();
        P1 = new javax.swing.JLabel();
        actionpotionj1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        labelj3 = new javax.swing.JLabel();
        labelj14 = new javax.swing.JLabel();
        NOM2 = new javax.swing.JLabel();
        actionnomj2 = new javax.swing.JLabel();
        XP2 = new javax.swing.JLabel();
        actionxpj2 = new javax.swing.JLabel();
        S2 = new javax.swing.JLabel();
        actionsortj2 = new javax.swing.JLabel();
        P2 = new javax.swing.JLabel();
        actionpotionj2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        CBLieu = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        ImageLieu = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Edition = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        Combattre = new javax.swing.JButton();
        Apprendre = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        tour = new javax.swing.JLabel();
        Message = new javax.swing.JLabel();
        Action = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        Ajouter = new javax.swing.JMenu();
        J1 = new javax.swing.JMenuItem();
        J2 = new javax.swing.JMenuItem();
        ReglesMenu = new javax.swing.JMenu();
        Consulter = new javax.swing.JMenuItem();
        Gestion = new javax.swing.JMenu();
        ajoutLieu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setLayout(new java.awt.GridLayout(2, 1));

        jPanel2.setToolTipText("");
        jPanel2.setLayout(new java.awt.GridLayout(5, 2));

        labelj1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelj1.setText("Information sur le personnage 1");
        jPanel2.add(labelj1);

        labelj12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel2.add(labelj12);

        NOM1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        NOM1.setText("Nom :");
        jPanel2.add(NOM1);

        actionnomj1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        actionnomj1.setText("  nom à remplir");
        actionnomj1.setToolTipText("");
        jPanel2.add(actionnomj1);

        XP1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        XP1.setText("Expérience :");
        jPanel2.add(XP1);

        actionxpj1.setText("  expérience à mettre ici");
        jPanel2.add(actionxpj1);

        S1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        S1.setText("Sorts :");
        jPanel2.add(S1);

        actionsortj1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        actionsortj1.setText("  Sorts du joueur 1 à mettre ici");
        jPanel2.add(actionsortj1);

        P1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        P1.setText("Potions :");
        jPanel2.add(P1);

        actionpotionj1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        actionpotionj1.setText("  Potions du joueur 1 à mettre ici");
        jPanel2.add(actionpotionj1);

        jPanel4.add(jPanel2);

        jPanel7.setToolTipText("");
        jPanel7.setLayout(new java.awt.GridLayout(5, 2));

        labelj3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelj3.setText("Information sur le personnage 2");
        jPanel7.add(labelj3);

        labelj14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel7.add(labelj14);

        NOM2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        NOM2.setText("Nom :");
        jPanel7.add(NOM2);

        actionnomj2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        actionnomj2.setText("  nom à remplir");
        actionnomj2.setToolTipText("");
        jPanel7.add(actionnomj2);

        XP2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        XP2.setText("Expérience :");
        jPanel7.add(XP2);

        actionxpj2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        actionxpj2.setText("  expérience à mettre ici");
        jPanel7.add(actionxpj2);

        S2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        S2.setText("Sorts :");
        jPanel7.add(S2);

        actionsortj2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        actionsortj2.setText("  Sorts du joueur 1 à mettre ici");
        jPanel7.add(actionsortj2);

        P2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        P2.setText("Potions :");
        jPanel7.add(P2);

        actionpotionj2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        actionpotionj2.setText("  Potions du joueur 1 à mettre ici");
        jPanel7.add(actionpotionj2);

        jPanel4.add(jPanel7);

        getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel9.setLayout(new java.awt.GridLayout(2, 1));

        jLabel3.setText("Sélectionner le lieu ou vous voulez vous rendre");
        jPanel9.add(jLabel3);

        CBLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Remplir dynamiquement" }));
        CBLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBLieuActionPerformed(evt);
            }
        });
        jPanel9.add(CBLieu);

        jPanel6.add(jPanel9, java.awt.BorderLayout.NORTH);

        jPanel8.setLayout(new java.awt.GridLayout(2, 1));
        jPanel8.add(ImageLieu);

        Edition.setColumns(20);
        Edition.setRows(5);
        jScrollPane2.setViewportView(Edition);

        jPanel8.add(jScrollPane2);

        jPanel6.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.GridLayout(1, 2));

        Combattre.setText("Combattre");
        Combattre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CombattreActionPerformed(evt);
            }
        });
        jPanel1.add(Combattre);

        Apprendre.setText("Apprendre");
        Apprendre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApprendreActionPerformed(evt);
            }
        });
        jPanel1.add(Apprendre);

        jPanel6.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel5.add(jPanel6, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel5, java.awt.BorderLayout.WEST);

        jPanel3.setLayout(new java.awt.GridLayout(1, 3));

        tour.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        tour.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tour.setText("A qui le tour ?");
        tour.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel3.add(tour);

        Message.setFont(new java.awt.Font("Dialog", 2, 24)); // NOI18N
        Message.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Message.setText("Ajouter les Joueurs");
        jPanel3.add(Message);

        Action.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Action.setText("Démarrer");
        Action.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Action.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionActionPerformed(evt);
            }
        });
        jPanel3.add(Action);

        getContentPane().add(jPanel3, java.awt.BorderLayout.NORTH);

        Ajouter.setText("Ajouter");

        J1.setText("Joueur 1");
        J1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                J1ActionPerformed(evt);
            }
        });
        Ajouter.add(J1);

        J2.setText("Joueur 2");
        J2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                J2ActionPerformed(evt);
            }
        });
        Ajouter.add(J2);

        jMenuBar1.add(Ajouter);

        ReglesMenu.setText("Règles du Jeu");

        Consulter.setText("Consulter");
        Consulter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsulterActionPerformed(evt);
            }
        });
        ReglesMenu.add(Consulter);

        jMenuBar1.add(ReglesMenu);

        Gestion.setText("Gestion");

        ajoutLieu.setText("Ajouter un lieu");
        ajoutLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajoutLieuActionPerformed(evt);
            }
        });
        Gestion.add(ajoutLieu);

        jMenuBar1.add(Gestion);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CBLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBLieuActionPerformed
        int i=CBLieu.getSelectedIndex();

        switch(i)
        {
            case 0: {
                img=couverture;
                repaint();
                Combattre.setVisible(false);
                Apprendre.setVisible(false);
                Edition.setText(""); 
                    break;}
            
            case 1: {
                img=ll.getLieu(0).getPhoto();
                repaint();
                Combattre.setVisible(true);
                Apprendre.setVisible(false);
                Edition.setText(ll.getLieu(0).getDescription()); 
                    break;}
            
            case 2: {
                img=ll.getLieu(1).getPhoto();
                repaint();
                Combattre.setVisible(false);
                Apprendre.setVisible(true);
                Edition.setText(ll.getLieu(1).getDescription());
                    break;}
            
            case 3: {
                img=ll.getLieu(2).getPhoto();
                repaint();
                Combattre.setVisible(true);
                Apprendre.setVisible(false);
                Edition.setText(ll.getLieu(2).getDescription());
                    break;}
            
            
            case 4: {
                img=ll.getLieu(3).getPhoto();
                repaint();
                Combattre.setVisible(true);
                Apprendre.setVisible(false);
                Edition.setText(ll.getLieu(3).getDescription());
                    break;}
            
            
            case 5: {
                img=ll.getLieu(4).getPhoto();
                repaint();
                Combattre.setVisible(false);
                Apprendre.setVisible(true);
                Edition.setText(ll.getLieu(4).getDescription());
                    break;}
            
            
            case 6: {
                img=ll.getLieu(5).getPhoto();
                repaint();
                Combattre.setVisible(false);
                Apprendre.setVisible(true);
                Edition.setText(ll.getLieu(5).getDescription());
                    break;}
        
        case 7: {
                img=ll.getLieu(6).getPhoto();
                repaint();
                if(ll.getLieu(6).getOccupant().getNom().equalsIgnoreCase("McGonagall"))
                    {
                        Combattre.setVisible(false);
                        Apprendre.setVisible(true);
                    }
                
                if(ll.getLieu(6).getOccupant().getNom().equalsIgnoreCase("Ron"))
                    {
                        Combattre.setVisible(true);
                        Apprendre.setVisible(false);
                    }
                
                if(ll.getLieu(6).getOccupant().getNom().equalsIgnoreCase("Crab"))
                    {
                        Combattre.setVisible(true);
                        Apprendre.setVisible(false);
                    }
                
                
                if(ll.getLieu(6).getOccupant().getNom().equalsIgnoreCase("Lavande"))
                    {
                        Combattre.setVisible(true);
                        Apprendre.setVisible(false);
                    }
                
                if(ll.getLieu(6).getOccupant().getNom().equalsIgnoreCase("McGonagall"))
                    {
                        Combattre.setVisible(false);
                        Apprendre.setVisible(true);
                    }
                
                if(ll.getLieu(6).getOccupant().getNom().equalsIgnoreCase("Fliwick"))
                    {
                        Combattre.setVisible(false);
                        Apprendre.setVisible(true);
                    }
                
                if(ll.getLieu(6).getOccupant().getNom().equalsIgnoreCase("Lupin"))
                    {
                        Combattre.setVisible(false);
                        Apprendre.setVisible(true);
                    }
                
                Edition.setText(ll.getLieu(6).getDescription());
                    break;}
        
        case 8: {
                img=ll.getLieu(7).getPhoto();
                repaint();
                if(ll.getLieu(7).getOccupant().getNom().equalsIgnoreCase("McGonagall"))
                    {
                        Combattre.setVisible(false);
                        Apprendre.setVisible(true);
                    }
                
                if(ll.getLieu(7).getOccupant().getNom().equalsIgnoreCase("Ron"))
                    {
                        Combattre.setVisible(true);
                        Apprendre.setVisible(false);
                    }
                
                if(ll.getLieu(7).getOccupant().getNom().equalsIgnoreCase("Crab"))
                    {
                        Combattre.setVisible(true);
                        Apprendre.setVisible(false);
                    }
                
                
                if(ll.getLieu(7).getOccupant().getNom().equalsIgnoreCase("Lavande"))
                    {
                        Combattre.setVisible(true);
                        Apprendre.setVisible(false);
                    }
                
                if(ll.getLieu(7).getOccupant().getNom().equalsIgnoreCase("McGonagall"))
                    {
                        Combattre.setVisible(false);
                        Apprendre.setVisible(true);
                    }
                
                if(ll.getLieu(7).getOccupant().getNom().equalsIgnoreCase("Fliwick"))
                    {
                        Combattre.setVisible(false);
                        Apprendre.setVisible(true);
                    }
                
                if(ll.getLieu(7).getOccupant().getNom().equalsIgnoreCase("Lupin"))
                    {
                        Combattre.setVisible(false);
                        Apprendre.setVisible(true);
                    }
                Edition.setText(ll.getLieu(7).getDescription());
                    break;}
        case 9: {
                img=ll.getLieu(8).getPhoto();
                repaint();
                if(ll.getLieu(8).getOccupant().getNom().equalsIgnoreCase("McGonagall"))
                    {
                        Combattre.setVisible(false);
                        Apprendre.setVisible(true);
                    }
                
                if(ll.getLieu(8).getOccupant().getNom().equalsIgnoreCase("Ron"))
                    {
                        Combattre.setVisible(true);
                        Apprendre.setVisible(false);
                    }
                
                if(ll.getLieu(8).getOccupant().getNom().equalsIgnoreCase("Crab"))
                    {
                        Combattre.setVisible(true);
                        Apprendre.setVisible(false);
                    }
                
                
                if(ll.getLieu(8).getOccupant().getNom().equalsIgnoreCase("Lavande"))
                    {
                        Combattre.setVisible(true);
                        Apprendre.setVisible(false);
                    }
                
                if(ll.getLieu(8).getOccupant().getNom().equalsIgnoreCase("McGonagall"))
                    {
                        Combattre.setVisible(false);
                        Apprendre.setVisible(true);
                    }
                
                if(ll.getLieu(8).getOccupant().getNom().equalsIgnoreCase("Fliwick"))
                    {
                        Combattre.setVisible(false);
                        Apprendre.setVisible(true);
                    }
                
                if(ll.getLieu(8).getOccupant().getNom().equalsIgnoreCase("Lupin"))
                    {
                        Combattre.setVisible(false);
                        Apprendre.setVisible(true);
                    }
                Edition.setText(ll.getLieu(8).getDescription());
                    break;}
        
        }
        
        
    }//GEN-LAST:event_CBLieuActionPerformed

    private void ConsulterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsulterActionPerformed
      ReglesDlg regles = new ReglesDlg(this, true); 
    }//GEN-LAST:event_ConsulterActionPerformed

    private void J1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_J1ActionPerformed

            ChoixDlg choix = new ChoixDlg(this, true, lj); 
            p1=choix.getJoueur();   
            afficheJoueur(1, p1);
            Action.setVisible(true);
     
    }//GEN-LAST:event_J1ActionPerformed

    private void J2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_J2ActionPerformed

        if(p1 == null)
        {
            Message.setText("Ajouter le J1 d'abord");
            
        }
        else 
        {
            ChoixDlg choix = new ChoixDlg(this, true, lj); 
            p2=choix.getJoueur();
            if(p2.getNom().equalsIgnoreCase(p1.getNom()))
                Message.setText("Impossible");
            else
            {   Message.setText("Cliquer sur démarrer");
                afficheJoueur(2, p2);
                Action.setVisible(true);
            }
        }
    }//GEN-LAST:event_J2ActionPerformed

    private void ActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActionActionPerformed

        
        if(Action.getText().equals("Démarrer"))
        {
        tour.setText("");
        Message.setText("Au tour de : "+getJoueur(1).getNom());
        initCombo();
        Action.setText("Arrêter");
        pc = p1;
        }
        
        else if(Action.getText().equals("Arrêter"))
        {
           System.exit(0); 
        }
    }//GEN-LAST:event_ActionActionPerformed

    private void ApprendreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApprendreActionPerformed

        ApprendreDlg apprendre = new ApprendreDlg(this, true, pc, ll.getLieu(CBLieu.getSelectedIndex()-1));
        if (apprendre.cOk()) {                 
                        changementTour();
                        afficheJoueur(1,p1);
                        afficheJoueur(2,p2);
        }
    }//GEN-LAST:event_ApprendreActionPerformed

    private void CombattreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CombattreActionPerformed
        CombattreDlg combat = new CombattreDlg(this, true, la, pc, ll.getLieu(CBLieu.getSelectedIndex()-1));
        if (combat.cOk()) {                 
                        changementTour();
                        afficheJoueur(1,p1);
                        afficheJoueur(2,p2);
}
    }//GEN-LAST:event_CombattreActionPerformed

    private void ajoutLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajoutLieuActionPerformed
       AjoutLieuDlg ajout = new AjoutLieuDlg(this, true, lj, ll);
       int i = ll.getNbl();
       initCombo();
       img=ll.getLieu(i-1).getPhoto();
       Edition.setText(ll.getLieu(i-1).getDescription());
       
    }//GEN-LAST:event_ajoutLieuActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HarryPotter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HarryPotter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HarryPotter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HarryPotter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HarryPotter hp = new HarryPotter();
                hp.setSize(1000,600);
                hp.setTitle("HarryPotterInfo");
                hp.setVisible(true);
                hp.setLocation(600,200);
                hp.setSize(900,900);
                LesLieux ll = new LesLieux();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Action;
    private javax.swing.JMenu Ajouter;
    private javax.swing.JButton Apprendre;
    private javax.swing.JComboBox<String> CBLieu;
    private javax.swing.JButton Combattre;
    private javax.swing.JMenuItem Consulter;
    private javax.swing.JTextArea Edition;
    private javax.swing.JMenu Gestion;
    private javax.swing.JPanel ImageLieu;
    private javax.swing.JMenuItem J1;
    private javax.swing.JMenuItem J2;
    private javax.swing.JLabel Message;
    private javax.swing.JLabel NOM1;
    private javax.swing.JLabel NOM2;
    private javax.swing.JLabel P1;
    private javax.swing.JLabel P2;
    private javax.swing.JMenu ReglesMenu;
    private javax.swing.JLabel S1;
    private javax.swing.JLabel S2;
    private javax.swing.JLabel XP1;
    private javax.swing.JLabel XP2;
    private javax.swing.JLabel actionnomj1;
    private javax.swing.JLabel actionnomj2;
    private javax.swing.JLabel actionpotionj1;
    private javax.swing.JLabel actionpotionj2;
    private javax.swing.JLabel actionsortj1;
    private javax.swing.JLabel actionsortj2;
    private javax.swing.JLabel actionxpj1;
    private javax.swing.JLabel actionxpj2;
    private javax.swing.JMenuItem ajoutLieu;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelj1;
    private javax.swing.JLabel labelj12;
    private javax.swing.JLabel labelj14;
    private javax.swing.JLabel labelj3;
    private javax.swing.JLabel tour;
    // End of variables declaration//GEN-END:variables
}
