


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Vector;
import javax.swing.JFrame;
import net.jxta.exception.PeerGroupException;
import net.jxta.peergroup.PeerGroup;
import net.jxta.peergroup.PeerGroupFactory;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableRowSorter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class PeertoPeer  extends JFrame implements Runnable,ActionListener {
      public  String br ="documents";
   public  static ExplorationLocale exploration=null;

    static Object getGraphe() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
  private MesPaires pair = null;  //Pair maitre de l'interface graphique

    /**
     * Creates new form PeertoPeer
     */
    public PeertoPeer(String nom,MesPaires mp) {
    super(nom); 
      
        initComponents();
        this.setSize(660, 400);
        this.setLocationRelativeTo(null);
         
        jTextArea1.setEditable(false);
       pair=mp;
        jButton11.addActionListener(this);
      jButton9.setEnabled(false);
      
    }

    public static ExplorationLocale getExploration() {
        return exploration;
    }

   
    
    
    public void  affiche(String affichi){ 
    jTextArea1.append(affichi);
    }
    
   public void run() {
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               setVisible(true);
            }
        });
    
  }  public String getBr() {
        return br;
    }

    
    public String btnChoixDossier(ActionEvent evt)
{
    JFileChooser choix = new JFileChooser();
    choix.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    int retour = choix.showOpenDialog(new JFrame());
    if(retour == JFileChooser.APPROVE_OPTION) {
       // un fichier a été choisi ( sortie par OK)
       // jButton17.setEnabled(true);
      return choix.getSelectedFile().getAbsolutePath();// chemin absolu du dossier choisi
    } else {
      return "Le dossier n'a pas été choisi!"; }
}

  

   public void actionPerformed(ActionEvent evt) {

    //activation du bouton "valider"
    if (evt.getSource()==jButton11) {
      pair.sendMessage(jTextField2.getText());
      jTextField2.setText("");
    } 
    
   }
    public void affichee(String chaine) {
    jTextArea2.append(chaine+"\n");
  }
     public void affich(String chaine) {
    jTextArea3.append(chaine+"\n");
  }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        panelparent = new javax.swing.JPanel();
        panelconnection = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        panelpartage = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        JButton10 = new javax.swing.JButton();
        partager = new javax.swing.JButton();
        panelrecherche = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        list3 = new javax.swing.JList<>();
        paneltelechargement = new javax.swing.JPanel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jTextField3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        panelliste = new javax.swing.JPanel();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        panelchat = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();

        jFrame1.setMinimumSize(new java.awt.Dimension(2515221, 2512221));

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 625, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 446, Short.MAX_VALUE)
        );

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        jPanel3.setPreferredSize(new java.awt.Dimension(650, 61));
        jPanel3.setLayout(null);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Connection");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);
        jButton2.setBounds(10, 19, 103, 25);

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("Partage");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3);
        jButton3.setBounds(119, 19, 79, 25);

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setText("Recherche");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4);
        jButton4.setBounds(204, 19, 97, 25);

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton5.setText("Telechargement");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5);
        jButton5.setBounds(307, 19, 131, 25);

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton6.setText("Liste des Paires");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton6);
        jButton6.setBounds(444, 19, 123, 25);

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton7.setText("Chat");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton7);
        jButton7.setBounds(573, 19, 61, 25);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 640, 61);

        panelparent.setPreferredSize(new java.awt.Dimension(650, 200));
        panelparent.setLayout(new java.awt.CardLayout());

        panelconnection.setBackground(new java.awt.Color(153, 153, 153));
        panelconnection.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(51, 51, 51), null));
        panelconnection.setLayout(null);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        panelconnection.add(jScrollPane2);
        jScrollPane2.setBounds(20, 28, 600, 227);

        panelparent.add(panelconnection, "card3");

        panelpartage.setBackground(new java.awt.Color(153, 153, 153));
        panelpartage.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        panelpartage.setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "File Name", "Size Bytes"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        panelpartage.add(jScrollPane1);
        jScrollPane1.setBounds(50, 40, 510, 170);
        panelpartage.add(jSeparator1);
        jSeparator1.setBounds(0, 220, 640, 10);

        JButton10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JButton10.setText("Reload");
        JButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButton10ActionPerformed(evt);
            }
        });
        panelpartage.add(JButton10);
        JButton10.setBounds(300, 240, 260, 25);

        partager.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        partager.setText("Partager");
        partager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partagerActionPerformed(evt);
            }
        });
        panelpartage.add(partager);
        partager.setBounds(50, 240, 240, 25);

        panelparent.add(panelpartage, "card2");

        panelrecherche.setBackground(new java.awt.Color(153, 153, 153));
        panelrecherche.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        panelrecherche.setLayout(null);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Recherche");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelrecherche.add(jButton1);
        jButton1.setBounds(30, 280, 100, 30);

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton8.setText("Telechargement");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        panelrecherche.add(jButton8);
        jButton8.setBounds(190, 280, 140, 30);

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton9.setText("Stop");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        panelrecherche.add(jButton9);
        jButton9.setBounds(380, 280, 90, 30);

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton10.setText("Recharger...");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        panelrecherche.add(jButton10);
        jButton10.setBounds(0, 0, 110, 30);

        jScrollPane6.setViewportView(list3);

        panelrecherche.add(jScrollPane6);
        jScrollPane6.setBounds(30, 80, 440, 170);

        panelparent.add(panelrecherche, "card4");

        paneltelechargement.setBackground(new java.awt.Color(153, 153, 153));
        paneltelechargement.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        paneltelechargement.setLayout(null);
        paneltelechargement.add(jProgressBar1);
        jProgressBar1.setBounds(140, 166, 297, 25);
        paneltelechargement.add(jTextField3);
        jTextField3.setBounds(140, 36, 297, 28);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("File Name:");
        paneltelechargement.add(jLabel2);
        jLabel2.setBounds(35, 40, 62, 17);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Computed");
        paneltelechargement.add(jLabel3);
        jLabel3.setBounds(35, 173, 65, 17);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Status:");
        paneltelechargement.add(jLabel4);
        jLabel4.setBounds(35, 108, 44, 17);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Telechargement.....");
        paneltelechargement.add(jLabel5);
        jLabel5.setBounds(140, 108, 118, 17);

        jButton14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton14.setText("Verity");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        paneltelechargement.add(jButton14);
        jButton14.setBounds(485, 36, 84, 25);

        jButton15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton15.setText("Cancel");
        paneltelechargement.add(jButton15);
        jButton15.setBounds(479, 166, 90, 25);

        panelparent.add(paneltelechargement, "card7");

        panelliste.setBackground(new java.awt.Color(153, 153, 153));
        panelliste.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        panelliste.setLayout(null);

        jButton12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton12.setText("Find");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        panelliste.add(jButton12);
        jButton12.setBounds(260, 20, 57, 25);

        jButton13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton13.setText("Stop");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        panelliste.add(jButton13);
        jButton13.setBounds(250, 240, 61, 25);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Peers Name :"));

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane5.setViewportView(jTextArea3);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
        );

        panelliste.add(jPanel2);
        jPanel2.setBounds(10, 10, 220, 260);

        panelparent.add(panelliste, "card5");

        panelchat.setBackground(new java.awt.Color(153, 153, 153));
        panelchat.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        panelchat.setLayout(null);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane4.setViewportView(jTextArea2);

        panelchat.add(jScrollPane4);
        jScrollPane4.setBounds(53, 21, 527, 172);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("With message");
        panelchat.add(jLabel1);
        jLabel1.setBounds(60, 220, 86, 17);
        panelchat.add(jTextField2);
        jTextField2.setBounds(190, 220, 270, 30);

        jButton11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton11.setText("Send");
        panelchat.add(jButton11);
        jButton11.setBounds(490, 220, 63, 30);

        panelparent.add(panelchat, "card6");

        getContentPane().add(panelparent);
        panelparent.setBounds(0, 60, 640, 280);

        jMenu4.setText("Fichier");
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Connect");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Deconnect");
        jMenu4.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem3.setText("Quitter");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        jMenuBar2.add(jMenu4);

        jMenu5.setText("Affichage");
        jMenuBar2.add(jMenu5);

        jMenu6.setText("Aide");
        jMenuBar2.add(jMenu6);

        setJMenuBar(jMenuBar2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        panelparent.removeAll();
        panelparent.add(panelconnection);
        panelparent.repaint();
        panelparent.revalidate();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        panelparent.removeAll();
        panelparent.add(panelpartage);
        panelparent.repaint();
        panelparent.revalidate();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        panelparent.removeAll();
        panelparent.add(panelrecherche);
        panelparent.repaint();
        panelparent.revalidate();
    }//GEN-LAST:event_jButton4ActionPerformed

    public void setjButton1(JButton jButton1) {
        this.jButton1 = jButton1;
    }

    public void setjButton10(JButton jButton10) {
        this.JButton10 = jButton10;
    }

    public void setjButton11(JButton jButton11) {
        this.jButton11 = jButton11;
    }

    public void setjButton12(JButton jButton12) {
        this.jButton12 = jButton12;
    }

    public void setjButton13(JButton jButton13) {
        this.jButton13 = jButton13;
    }

    public void setjButton14(JButton jButton14) {
        this.jButton14 = jButton14;
    }

    public void setjButton15(JButton jButton15) {
        this.jButton15 = jButton15;
    }

    public void setjButton2(JButton jButton2) {
        this.jButton2 = jButton2;
    }

    public void setjButton3(JButton jButton3) {
        this.jButton3 = jButton3;
    }

    public void setjButton4(JButton jButton4) {
        this.jButton4 = jButton4;
    }

    public void setjButton5(JButton jButton5) {
        this.jButton5 = jButton5;
    }

    public void setjButton6(JButton jButton6) {
        this.jButton6 = jButton6;
    }

    public void setjButton7(JButton jButton7) {
        this.jButton7 = jButton7;
    }

    public void setjButton8(JButton jButton8) {
        this.jButton8 = jButton8;
    }

    public void setjButton9(JButton jButton9) {
        this.jButton9 = jButton9;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public void setjMenu4(JMenu jMenu4) {
        this.jMenu4 = jMenu4;
    }

    public void setjMenu5(JMenu jMenu5) {
        this.jMenu5 = jMenu5;
    }

    public void setjMenu6(JMenu jMenu6) {
        this.jMenu6 = jMenu6;
    }

    public void setjMenuBar2(JMenuBar jMenuBar2) {
        this.jMenuBar2 = jMenuBar2;
    }

    public void setjMenuItem1(JMenuItem jMenuItem1) {
        this.jMenuItem1 = jMenuItem1;
    }

    public void setjMenuItem2(JMenuItem jMenuItem2) {
        this.jMenuItem2 = jMenuItem2;
    }

    public void setjMenuItem3(JMenuItem jMenuItem3) {
        this.jMenuItem3 = jMenuItem3;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public void setjPanel3(JPanel jPanel3) {
        this.jPanel3 = jPanel3;
    }

    public void setjProgressBar1(JProgressBar jProgressBar1) {
        this.jProgressBar1 = jProgressBar1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

   

    public void setjScrollPane4(JScrollPane jScrollPane4) {
        this.jScrollPane4 = jScrollPane4;
    }

  

    public void setjSeparator1(JSeparator jSeparator1) {
        this.jSeparator1 = jSeparator1;
    }

    public void setjTable1(JTable jTable1) {
        this.jTable1 = jTable1;
    }
List List1;
    public JList getjList1() {
          
        return list3;
    }

  

    public void setjTextArea1(JTextArea jTextArea1) {
        this.jTextArea1 = jTextArea1;
    }

    public void setjTextArea2(JTextArea jTextArea2) {
        this.jTextArea2 = jTextArea2;
    }

    

    public void setjTextField2(JTextField jTextField2) {
        this.jTextField2 = jTextField2;
    }

    public void setjTextField3(JTextField jTextField3) {
        this.jTextField3 = jTextField3;
    }

   

    public void setPanelchat(JPanel panelchat) {
        this.panelchat = panelchat;
    }

    public void setPanelconnection(JPanel panelconnection) {
        this.panelconnection = panelconnection;
    }

    public void setPanelliste(JPanel panelliste) {
        this.panelliste = panelliste;
    }

    public void setPanelparent(JPanel panelparent) {
        this.panelparent = panelparent;
    }

    public void setPanelpartage(JPanel panelpartage) {
        this.panelpartage = panelpartage;
    }

    public void setPanelrecherche(JPanel panelrecherche) {
        this.panelrecherche = panelrecherche;
    }

    public void setPaneltelechargement(JPanel paneltelechargement) {
        this.paneltelechargement = paneltelechargement;
    }

    public JButton getjButton1() {
        return jButton1;
    }

    public JButton getjButton10() {
        return jButton10;
    }

    public JButton getjButton11() {
        return jButton11;
    }

    public JButton getjButton12() {
        return jButton12;
    }

    public JButton getjButton13() {
        return jButton13;
    }

    public JButton getjButton14() {
        return jButton14;
    }

    public JButton getjButton15() {
        return jButton15;
    }

    public JButton getjButton2() {
        return jButton2;
    }

    public JButton getjButton3() {
        return jButton3;
    }

    public JButton getjButton4() {
        return jButton4;
    }
      public JTextArea getjTex3() {
        return jTextArea3;
    }

    public JButton getjButton5() {
        return jButton5;
    }

    public JButton getjButton6() {
        return jButton6;
    }

    public JButton getjButton7() {
        return jButton7;
    }

    public JButton getjButton8() {
        return jButton8;
    }

    public JButton getjButton9() {
        return jButton9;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public JMenu getjMenu4() {
        return jMenu4;
    }

    public JMenu getjMenu5() {
        return jMenu5;
    }

    public JMenu getjMenu6() {
        return jMenu6;
    }

    public JMenuBar getjMenuBar2() {
        return jMenuBar2;
    }

    public JMenuItem getjMenuItem1() {
        return jMenuItem1;
    }

    public JMenuItem getjMenuItem2() {
        return jMenuItem2;
    }

    public JMenuItem getjMenuItem3() {
        return jMenuItem3;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public JPanel getjPanel3() {
        return jPanel3;
    }

    public JProgressBar getjProgressBar1() {
        return jProgressBar1;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

  

    public JScrollPane getjScrollPane4() {
        return jScrollPane4;
    }

  

    public JSeparator getjSeparator1() {
        return jSeparator1;
    }

    public JTable getjTable1() {
        return jTable1;
    }

  

    public JTextArea getjTextArea1() {
        return jTextArea1;
    }

    public JTextArea getjTextArea2() {
        return jTextArea2;
    }

   

    public JTextField getjTextField2() {
        return jTextField2;
    }

    public JTextField getjTextField3() {
        return jTextField3;
    }

   

    public JPanel getPanelchat() {
        return panelchat;
    }

    public JPanel getPanelconnection() {
        return panelconnection;
    }

    public JPanel getPanelliste() {
        return panelliste;
    }

    public JPanel getPanelparent() {
        return panelparent;
    }

    public JPanel getPanelpartage() {
        return panelpartage;
    }

    public JPanel getPanelrecherche() {
        return panelrecherche;
    }

    public JPanel getPaneltelechargement() {
        return paneltelechargement;
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        panelparent.removeAll();
        panelparent.add(paneltelechargement);
        panelparent.repaint();
        panelparent.revalidate();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        panelparent.removeAll();
        panelparent.add(panelliste);
        panelparent.repaint();
        panelparent.revalidate();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        panelparent.removeAll();
        panelparent.add(panelchat);
        panelparent.repaint();
        panelparent.revalidate();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void JButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButton10ActionPerformed

    }//GEN-LAST:event_JButton10ActionPerformed
 public void bontonactive(){
 jButton13.setEnabled(true);
 }
  public void bontoactive(){
 jButton12.setEnabled(true);
 }
    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
 pair.rune();   
jButton12.setEnabled(true);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
       pair.ru();
    }//GEN-LAST:event_jButton13ActionPerformed

   
    public JList getList3() {
        return list3;
    }

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        
       
    }//GEN-LAST:event_jButton9ActionPerformed
public boolean activer(){
    
Boolean b1= true;
jButton9.setEnabled(b1);
    
    return b1;
}


    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
     
    }//GEN-LAST:event_jButton14ActionPerformed

    private void partagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partagerActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_partagerActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

    }//GEN-LAST:event_jButton10ActionPerformed

    public JButton getJButton10() {
        return JButton10;
    }

    

    public JButton getPartager() {
        return partager;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws PeerGroupException, IOException {
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
            java.util.logging.Logger.getLogger(PeertoPeer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PeertoPeer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PeertoPeer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PeertoPeer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
 MesPaires pair = new MesPaires();
      
       pair.run();
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButton10;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JList<String> list3;
    private javax.swing.JPanel panelchat;
    private javax.swing.JPanel panelconnection;
    private javax.swing.JPanel panelliste;
    private javax.swing.JPanel panelparent;
    private javax.swing.JPanel panelpartage;
    private javax.swing.JPanel panelrecherche;
    private javax.swing.JPanel paneltelechargement;
    private javax.swing.JButton partager;
    // End of variables declaration//GEN-END:variables
public class ExplorationLocale {

  private File repertoire = null;  //repertoire contenant les documents

  /**
   * Constructeur de la classe ExplorationLocale
   */
  public ExplorationLocale(String nom) {
    repertoire = new File(nom);
  }
   DefaultTableModel tabl;
    
     

  /**
   * Retourne la liste des documents du repertoire sous forme de chaine
   */
  public void lister() {
    String liste = "";
    
    String[] table = repertoire.list();

    for (int i=0;i<table.length;i++) {
      //creation de la chaine a retourner
      liste += table[i];
    long bytes = liste.length();
       String b = String.valueOf(bytes);
  
        System.out.println(bytes);
      ligne("",liste,b,"");
    
    liste = "";
   
    }
       
    }
 
  /**
   * Accede au fichier dont le nom est donne en parametre
   * Retourne un tableau de byte contenant le fichier
   */
  public byte[] recupererFichier(String nom_fichier) {

    byte[] table = null;
    RandomAccessFile lire = null;  //flux de lecture sur le fichier

    try {
      lire = new RandomAccessFile("documents/"+nom_fichier, "r");
      int taille = (int) lire.length();
      table = new byte[taille];  //creation du tableau a la bonne taille
    } catch (IOException ioe) {System.err.println("Erreur dans ExplorationLocale.recupererFichier()_1"); ioe.printStackTrace();}

    try {
      lire.readFully(table);  //stockage du fichier sous forme de bytes dans le tableau
    } catch (IOException ioe) {System.err.println("Erreur dans ExplorationLocale.recupererFichier()_2"); ioe.printStackTrace();}

    return table;

  }


}
           
   DefaultTableModel tabl;
    
       public void ligne(String f1, String f2, String f3, String f4){
         tabl=(DefaultTableModel) jTable1.getModel();
        String[] line ={f1,f2, f3, f4};
       
        tabl.addRow(line);
       }

    public JFrame getjFrame1() {
        return jFrame1;
    }
   public void    affichage(String f1){
   jTextArea3.append(f1);
   }
   public void Recherche(String fichier_recherche){
        
       TableRowSorter<DefaultTableModel> search=new TableRowSorter<DefaultTableModel>(tabl);
       this.jTable1.setRowSorter(search);
       search.setRowFilter(RowFilter.regexFilter(fichier_recherche)); 
   }
}
