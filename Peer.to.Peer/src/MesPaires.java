
import java.awt.Button;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.List;
import java.awt.Panel;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;
import net.jxta.exception.PeerGroupException;
import net.jxta.id.IDFactory;
import net.jxta.peer.PeerID;
import net.jxta.peergroup.PeerGroup;
import net.jxta.peergroup.PeerGroupFactory;
import net.jxta.peergroup.PeerGroupID;
import net.jxta.share.CMS;
import net.jxta.share.Content;
import net.jxta.share.ContentAdvertisement;
import net.jxta.share.SearchListener;
import net.jxta.share.client.GetContentRequest;
import net.jxta.share.client.ListContentRequest;
import net.jxta.share.metadata.MetadataQuery;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class MesPaires extends Thread implements Runnable{

    static Object getGraphe() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  public  PeerGroup groupe = null;  //groupe de pairs d'appartenance
  private Client client = null;  //envoie des messages
  private Serveur serveur = null;  //reception des messages
  public Decouverte decouverte = null;  //recherche des pairs

    public Decouverte getDecouverte() {
        return decouverte;
    }
   public static  PeertoPeer graphe = null;  //interface graphique du pair
   private String monNom = null;  //nom du pair dans le groupe
    //fenetre d'affichage des documents
  private Vector documentsConnus = new Vector();  //liste des documents connus sur le reseau
 
  //exploration des fichiers locaux


  /**
   * Constructeur de la classe MesPairs
   */
  public MesPaires() throws PeerGroupException, IOException {

    try {
        
     groupe = PeerGroupFactory.newNetPeerGroup();  //cree un nouveau groupe general
    } catch (Exception e) {System.err.println("MesPairs() : Erreur de creation du groupe");}

    //instanciation des services de decouverte et de communications
   decouverte = new Decouverte(this,groupe);
   client = new Client("PropagatePipeAdv.xml",groupe);
    serveur = new Serveur(this,"PropagatePipeAdv.xml",groupe);

    //recuperation du nom du pair dans le groupe general
     monNom = groupe.getPeerName().toString();
     
 
    //instanciation de l'interface graphique
   graphe = new PeertoPeer(monNom,this);
	new SearchDemo();
       
      new ShareDemo();
    //creation du module d'exploration des documents locaux
 

    //creation de la fenetre secondaire pour les documents
   // secondaire = new FenetreSecondaire();
  }
  @SuppressWarnings("unchecked")
  public void aff(){
   
   
   graphe.affiche("Hello from JXTA group " + groupe.getPeerGroupName()+"\n");
    graphe.affiche("Group ID = " + groupe.getPeerGroupID().toString()+"\n");
     graphe.affiche("Peer name = " + groupe.getPeerName()+"\n");
      graphe.affiche("Peer ID = " + groupe.getPeerID().toString()+"\n");
    
  }
    
 
   


  /**
   * Methode de lancement de la classe MesPairs
   * lance le client, le serveur, la decouverte, l'interface graphique et la fenetre secondaire
   */
  public void run() {
      graphe.run();
    // decouverte.run();
    client.start();
    aff();
    
    serveur.start();
    
    
   // secondaire.run();
   
  }
  
  


   public void affichedec(String dec){
   
   graphe.affich(dec);
   }
   public void rune(){
   travail();
   }
    public void ru(){
   finir();
   }
  


  /**
   * Oblige le pair à effectuer une recherche de pairs
   * dans le réseau toutes les 5 secondes
   */
  public void travail() {
    while (true) {
      decouverte.rechercher();  //recherche des pairs dans le reseau
      try {
           
          Thread .sleep(5000);   graphe.bontonactive();graphe.bontoactive();
          break;//endormissement du thread
   
      } catch (Exception e) {System.err.println("MesPairs.travail() : Impossible de dormir");}
    }
  }
   public  PeerID createPeerID(PeerGroupID pgID, String peerName) {
        String seed = peerName;
        return IDFactory.newPeerID(pgID, hash(seed.toLowerCase()));
    }
 private static byte[] hash(final String expression) {
        byte[] result;
        MessageDigest digest;

        if (expression == null) {
            throw new IllegalArgumentException("Invalid null expression");
        }

        try {
            digest = MessageDigest.getInstance("SHA1");
        } catch (NoSuchAlgorithmException failed) {
            failed.printStackTrace(System.err);
            RuntimeException failure = new IllegalStateException("Could not get SHA-1 Message");
            failure.initCause(failed);
            throw failure;
        }

        try {
            byte[] expressionBytes = expression.getBytes("UTF-8");
            result = digest.digest(expressionBytes);
        } catch (UnsupportedEncodingException impossible) {
            RuntimeException failure = new IllegalStateException("Could not encode expression as UTF8");

            failure.initCause(impossible);
            throw failure;
        }
        return result;
    }

 
  public void finir() {
    while (true) {
      //recherche des pairs dans le reseau
      try {
         
          decouverte.interrupt();
          break;//endormissement du thread
      } catch (Exception e) {System.err.println("MesPairs.travail() : Impossible de dormir");}
    }
     
    }

   public void sendMessage(String message) {
    //envoi d'un message a l'ensemble des pairs
    client.sendMessage(message);
  }
    public void afficheMessage(String message) {
    graphe.affichee(message);
  }
    
    



 
public class ShareDemo implements ActionListener {

    private PeerGroup netPeerGroup  = null;
    private CMS cms = null;

    
    public ShareDemo() {
        startJxta();
 graphe.getPartager().addActionListener(this);
 graphe.getjButton10().addActionListener(this);
 
	//adds a search listener that monitors incoming list requests
	cms.addSearchListener(new MySearchListener());

        
    }

    /**
     * initializes NetPeerGroup and the CMS
     */
    private void startJxta() {
	try {
	   
	    cms = new CMS();
	    cms.init(groupe, null, null);
	    
	    
	    String homedir = System.getProperty("JXTA_HOME");
	    homedir = (homedir != null) ? homedir + "ShareDemo" : "ShareDemo";
	    	    
	   
	    if(cms.startApp(new File(homedir)) == -1) {
		System.out.println("CMS initialization failed");
		System.exit(-1);
	    }
	    
	} catch ( PeerGroupException e) {
	    // could not instanciate the group, print the stack and exit
	    System.out.println("fatal error : group creation failure");
	    e.printStackTrace();
	    System.exit(1);
	} 
    }

       

    /**
     * A simple implementation of a SearchListener.
     */
    class MySearchListener implements SearchListener {

	
	public void queryReceived(String queryString) {
	    System.out.println("List request with query \"" + queryString
			       + "\" received.");
	}
    }

    /**
     * Inner class that defines the ShareDemo GUI
     */JFileChooser fc = new JFileChooser(new File("."));
	
        Button shareButton;
       
        JTable fileList = graphe.getjTable1();

     
    @Override
	public void actionPerformed(ActionEvent e) {
	    System.out.println(e.getActionCommand());
	    
	    //handle the event of the "Share" button being clicked
	    if (e.getSource().equals(graphe.getPartager())) {
		//prompt the user to choose a file to share
		int returnVal = fc.showOpenDialog(graphe);
		
		if (returnVal == JFileChooser.APPROVE_OPTION) {
		    File file = fc.getSelectedFile();
		  
		    //this is where a real application would open the file.
		    System.out.println("Sharing: " + file.getName() + ".");
		    try {
			
			cms.getContentManager().share(file);
			
			//update the list of shared content
			
			
		    } catch (IOException ex) {
			System.out.println("Share command failed.");
		    }		    		    
		} else {
		    System.out.println("Share command cancelled by user.");
		}
	    } if (e.getSource().equals(graphe.getjButton10())) {
            
            updateLocalFiles();
            }
	}
    
	/**
	 * Refreshes the list of shared content
	 */
        private void updateLocalFiles() {
          DefaultTableModel  tabl=(DefaultTableModel) graphe.getjTable1().getModel();          
           int n=graphe.getjTable1().getRowCount()-1;
                
                for(int i=n;i>=0;--i){
                
                    tabl.removeRow(i);
                
                }
	  
            Content[] content = cms.getContentManager().getContent();
	    
	  
         
      DefaultTableModel  TableModell ;
    TableModell=(DefaultTableModel) fileList.getModel();
       
            for (int i=0; i<content.length; i++) {
                     
                 Object[] line ={content[i].getContentAdvertisement().getName(), content[i].getContentAdvertisement().getLength()};
       
        TableModell.addRow(line);
               
            }  
        
    }

    
    }


public class SearchDemo implements ActionListener{

    private PeerGroup netPeerGroup  = null;
    
   
    

    public SearchDemo() {
	graphe.getjButton1().addActionListener( this);
         graphe.getjButton8().addActionListener(this);
         graphe.getjButton14().addActionListener(this);
        graphe.getjButton15().addActionListener(this);
 graphe.getjButton10().addActionListener(this);
    }

    /**
     * initializes NetPeerGroup and the CMS
     */
    private void startJxta() {
	try {
	    // create, and Start the default jxta NetPeerGroup
	    netPeerGroup = PeerGroupFactory.newNetPeerGroup();
	    
	    //uncomment the following line if you want to start the app defined
	    // the NetPeerGroup Advertisement (by default it's the shell)
	    // in this case we want use jxta directly.
	    
	    // netPeerGroup.startApp(null);
			
	} catch (PeerGroupException e) {
	    // could not instanciate the group, print the stack and exit
	    System.out.println("fatal error : group creation failure");
	    e.printStackTrace();
	    System.exit(-1);
	}
    }

    /**
     * SearchWindow serves as the GUI for MetadataSearchDemo
     */
    ListModel resultList = graphe.getList3().getModel();
       DefaultListModel dlm = new DefaultListModel();
	
	MetadataQuery descQuery;
	MetadataQuery keywdQuery;
	
	//A ListContentRequest is needed to query other peers for
	//ContentAdvertisements
	ListContentRequest request = null;
        File savePath=null;
        String filename = null;
	
	//an array is needed to store ContentAdvertisements returned by the
	//ListContentRequest
	ContentAdvertisement[] results = null;

   String searchString=null;
	public void actionPerformed(ActionEvent e) {
	    System.out.println(e.getActionCommand());
            
	    //handle the event caused by the "Search" button being clicked
	    if (e.getSource().equals(graphe.getjButton1())) {
                 results = null;
                graphe.getjButton9().setEnabled(true);
		if (request != null) {
		    request.cancel();
		}

		//prompt the user for a search string
		searchString = JOptionPane
		    .showInputDialog(this, "Enter a string to search for:");
	       
		//if the user doesn't enter anything, make the saerch string
		//empty.  This will cause peers to return all the
		//ContentAdvertisements that they are sharing.
		if(searchString == null)
		    searchString = "";
		
		//Initialize a ListContentRequest containing the search string
		// that was entered.
                request = null;
                
		request = new MyListRequest(groupe, searchString, this);
		
		//send the list request and wait for results to be returned
		request.activateRequest();
               
	    }
             if (e.getSource().equals(graphe.getjButton10())) {
                 request = new MyListRequest(groupe,"", this);
		
		//send the list request and wait for results to be returned
		request.activateRequest();
                
             }
              if (e.getSource().equals(graphe.getjButton9())) {
              
              request.cancel();
                 graphe.getjButton9().setEnabled(false);
              } if (e.getSource().equals(graphe.getjButton8())) {
            
		//figure out which content advertisement is selected
		int selectedIndex = graphe.getList3().getSelectedIndex();
		if((results != null) && (selectedIndex != -1)
		  ){
		    
		    JFileChooser saveDialog = new JFileChooser();
                    
		    saveDialog.setLocation(300, 200);

		    //set the default save path to the name of the content
		    File savePath
			= new File(results[selectedIndex].getName());
		    
		    saveDialog.setSelectedFile(savePath);
		    int returnVal = saveDialog.showSaveDialog(graphe);
		    if (returnVal == JFileChooser.APPROVE_OPTION) {
			savePath = saveDialog.getSelectedFile();
                      

				
				 
			filename = savePath.getName();
			//start up a GetContentRequest for the selected content
			//advertisement.
			new SearchDemo.VisibleContentRequest(graphe.getjFrame1(), results[selectedIndex]
						   ,savePath);
		    } else {
			System.out.println("save canceled");
		    }
		
	}}
               ContentAdvertisement c1=null;
	    System.out.println(e.getActionCommand());
	   if (e.getSource().equals(graphe.getjButton14())) {

		//figure out which content advertisement is selected
		String selectedIndex = graphe.getjTextField3().getText();
		if((results != null) && (selectedIndex != null)) {
		    
		    JFileChooser saveDialog = new JFileChooser();
		    saveDialog.setLocation(300, 200);

		    //set the default save path to the name of the content
		    savePath
			= new File(selectedIndex);
		    
		    saveDialog.setSelectedFile(savePath);
		    int returnVal = saveDialog.showSaveDialog(graphe);
		    if (returnVal == JFileChooser.APPROVE_OPTION) {
			savePath = saveDialog.getSelectedFile();
			  
                        for(int i=0;i<results.length;i++){
                        if(   results[i].getName().equals(graphe.getjTextField3().getText())){
                      c1 = results[i];
                      
                        }
                        }
			//start up a GetContentRequest for the selected content
			//advertisement.
			new SearchDemo.VsibleContentRequest(graphe.getjFrame1(), c1
						   ,savePath);
		    } else {
			System.out.println("save canceled");
		    }
		}
	    }
              
        }
          class VsibleContentRequest extends GetContentRequest
	implements ActionListener{
	
	JDialog dialog;
	JProgressBar statusBar = graphe.getjProgressBar1();
                
	JButton cancelButton = new JButton("Stop");

	/**
	 * Create, start, and display a new VisibleContentRequest as a child of
	 * a given Frame.
	 *
	 *@param parent the parent Frame object
	 *@param source an advertisement of the content to be downloaded.
	 *@param destination a file pointer to save the content to.
	 */
	public VsibleContentRequest(Frame parent,ContentAdvertisement source
				, File destination){
	    super(groupe, source, destination);
	    
	    dialog = new JDialog(parent, "Downloading "+destination.getName());
	    
	    dialog.setSize(240, 50);
	    dialog.setLocation(400,400);

	    statusBar.setStringPainted(true);
    
	    dialog.getContentPane()
		.setLayout(new FlowLayout(FlowLayout.CENTER));
	   // dialog.getContentPane().add(statusBar);
	    
	   graphe.getjButton15().addActionListener(this);
	    dialog.getContentPane().add(cancelButton);
	    dialog.setVisible(false);
	}

	public void actionPerformed(ActionEvent ae) {
	    //handle the event caused by the "Stop" button being clicked
	    if(ae.getSource() == graphe.getjButton15()) {
		cancel();
		System.out.println("download of " + getFile()
				   + " cancelled by user.");
		dialog.dispose();
		dialog = null;
	    }
	}

	/** File savePath
	 * This method is called when the download is complete.
	 */
	public void notifyDone() { 
            System.out.println("download of "+getFile()+" done.");
             
             
            dialog = null;
            JOptionPane.showMessageDialog(null, "reception termin\351e ");
					

			if(statusBar.getValue()==100){
	   statusBar.setValue(0);
	    }
           
                        
	  
              
	}

	/**
	 * This method is called if the download fails.
	 */
	public void notifyFailure() {
	    System.out.println("download of "+getFile()+" failed.");
	}

	/**
	 * This method as called as more of the file has been downloaded.
	 *
	 * @param percentage the percentage of the file that has been
	 * downloaded so far.
	 */
	public void notifyUpdate(int percentage) {
	    statusBar.setValue(percentage);
	}
    }

        
	
	/**
	 * This method filters through advertisements returned by other peers
	 * and then displays the matches in the list.
	 */
	protected void updateResults(ContentAdvertisement[] results) {
	    this.results = results;
	    
	    //erase all of the old results
	    graphe.getList3().removeAll();
	    
	    //insert the updated results into the list
	    for (int i=0; i<results.length; i++) {
                
                
                
                
                dlm.addElement(results[i].getName());
		
	    }
            graphe.getList3().setModel(dlm);
             graphe.getList3().setSelectedValue(searchString, true);
            
	}
    class VisibleContentRequest extends GetContentRequest
	implements ActionListener{
	
	JDialog dialog;
	JProgressBar statusBar = new JProgressBar();
	JButton cancelButton = new JButton("Stop");

	/**
	 * Create, start, and display a new VisibleContentRequest as a child of
	 * a given Frame.
	 *
	 *@param parent the parent Frame object
	 *@param source an advertisement of the content to be downloaded.
	 *@param destination a file pointer to save the content to.
	 */
	public VisibleContentRequest(Frame parent,ContentAdvertisement source
				, File destination){
	    super(groupe, source, destination);
	    
	    dialog = new JDialog(parent, "Downloading "+destination.getName());
	    
	  

	    statusBar.setStringPainted(true);
                    dialog.setSize(250, 200);
                   dialog.setLocationRelativeTo(null);
	    dialog.getContentPane()
		.setLayout(new FlowLayout(FlowLayout.CENTER));
	    dialog.getContentPane().add(statusBar);
	    
	    cancelButton.addActionListener(this);
	    dialog.getContentPane().add(cancelButton);
	    dialog.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
	    //handle the event caused by the "Stop" button being clicked
	    if(ae.getSource() == cancelButton) {
		cancel();
		System.out.println("download of " + getFile()
				   + " cancelled by user.");
		dialog.dispose();
		dialog = null;
	    }
	}

	/**
	 * This method is called when the download is complete.
	 */
	public void notifyDone() {
	    System.out.println("download of "+getFile()+" done.");
	    dialog.dispose();
	    dialog = null;
	}

	/**
	 * This method is called if the download fails.
	 */
	public void notifyFailure() {
	    System.out.println("download of "+getFile()+" failed.");
	}

	/**
	 * This method as called as more of the file has been downloaded.
	 *
	 * @param percentage the percentage of the file that has been
	 * downloaded so far.
	 */
	public void notifyUpdate(int percentage) {
	    statusBar.setValue(percentage);
	}
    }
    
   
    class MyListRequest extends ListContentRequest {
	SearchDemo searchWindow = null;
	
	
	public MyListRequest(PeerGroup group, String inSubStr
			     ,SearchDemo searchWindow) {
	    super(group, inSubStr);
	    this.searchWindow = searchWindow;
	}

	/**
	 * This function is called each time more results are received.
	 */
	public void notifyMoreResults() {
	    if (searchWindow != null) {
		
		searchWindow.updateResults(getResults());
                
	    }
	}
    }

    class WindowMonitor extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
	    Window w = e.getWindow();
	    w.setVisible(false);
	    w.dispose();
	    System.exit(0);
	}
    }
    }

}
       
