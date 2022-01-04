package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.Factory;
import modele.Entreestock;
import modele.Familllepro;
import modele.Sortiestock;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;


public class Entree {
	Entreestock entreStoc1 = null;
    private final DefaultTableModel df;
	private JFrame frame;
	private JTextField idEntree;
	private JTextField Quantite;
	private JTextField prixAchat;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Entree window = new Entree();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Entree() {
		initialize();
		 this.df=new DefaultTableModel();
	        df.addColumn("Id Entree");
	        df.addColumn("Prix Achat");
	        df.addColumn("Quantite Entree");
	        df.addColumn("Code Produit");
	        Actualiser();
	}
    public void  Actualiser(){
  	   
        try{
          df.setRowCount(0);
         ArrayList<Entreestock> entreStoc1=new ArrayList();
         entreStoc1=Factory.getEntreestock();


         for(Entreestock s: entreStoc1){
           df.addRow(new Object []{
             s.getIdEntree(),
             s.getPrixAchat(),
             s.getQteEntree(),
             s.getCodePro(),
            
             
         });
         }
         table.setModel(df);
         } 
         catch(Exception ex){ ex.printStackTrace();}
   
   
    }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 690, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEntreeEnStock = new JLabel("Entree en Stock");
		lblEntreeEnStock.setBackground(Color.BLUE);
		lblEntreeEnStock.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblEntreeEnStock.setBounds(243, 11, 205, 41);
		frame.getContentPane().add(lblEntreeEnStock);
		
		JLabel lblcodeproduit = new JLabel("Code Produit :");
		lblcodeproduit.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblcodeproduit.setBounds(31, 269, 100, 17);
		frame.getContentPane().add(lblcodeproduit);
		
		JLabel lblfamille = new JLabel("Id");
		lblfamille.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblfamille.setBounds(31, 121, 100, 17);
		frame.getContentPane().add(lblfamille);
		
		JLabel lblStockInv = new JLabel("Quantite Entree:");
		lblStockInv.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStockInv.setBounds(31, 219, 124, 18);
		frame.getContentPane().add(lblStockInv);
		
		JLabel lblPrixUni = new JLabel("Prix Achat :");
		lblPrixUni.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrixUni.setBounds(31, 170, 100, 18);
		frame.getContentPane().add(lblPrixUni);
		
		idEntree = new JTextField();
		idEntree.setEditable(false);
		idEntree.setBounds(31, 139, 38, 20);
		frame.getContentPane().add(idEntree);
		idEntree.setColumns(10);
		
		Quantite = new JTextField();
		Quantite.setBounds(31, 238, 124, 20);
		frame.getContentPane().add(Quantite);
		Quantite.setColumns(10);
		
		prixAchat = new JTextField();
		prixAchat.setBounds(31, 188, 124, 20);
		frame.getContentPane().add(prixAchat);
		prixAchat.setColumns(10);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

//				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
//				String date = sdf.format(DateSort.getDate());
				/*if(NumFact.getText().equals("")  NomCl.getText().equals("")|| date || QteSort.getText().equals("") || CodePro.getSelectedItem()){
						
					JOptionPane.showMessageDialog(btnAjouter, "Please Enter all Data");
				}else{
				*/
					Entreestock entreStoc1= new Entreestock();
					//1 ,Integer.valueOf(NumFact.getText()) ,2,NomCl.getText(),3,date,4,QteSort.getText(),
				//	5,CodePro.getSelectedItem(),0
					
					entreStoc1.setIdEntree(1);
					entreStoc1.setPrixAchat(Integer.valueOf(prixAchat.getText()));
					entreStoc1.setQteEntree(Integer.valueOf(Quantite.getText()));
					//entreStoc1.setCodePro(Integer.valueOf(CodePro.getSelectedItem()));
					try {
						Factory.inSertEntreestock(entreStoc1);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 Actualiser();
			           // codeFamille.setText("");
			          //  Numfact.setText("");
			//	}
			//	String data [] ={IdSort.getText(),NumFact.getText(),NomCl.getText( ),date,QteSort.getText(),CodePro.};
			            DefaultTableModel tablem = (DefaultTableModel) table.getModel();
			            //add string array data
			            //tablem.addRow(data);// row added
			            //successful added message
			            JOptionPane.showMessageDialog(btnAjouter, this,"Add Data Successfully....! ", 0);
			            //clear textfield for new entry...
			            idEntree.setText("");
			            prixAchat.setText("");
			            Quantite.setText("");
			            //CodePro.setText("");;
			}
		});
		btnAjouter.setForeground(Color.WHITE);
		btnAjouter.setBackground(Color.GREEN);
		btnAjouter.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAjouter.setBounds(31, 378, 89, 23);
		frame.getContentPane().add(btnAjouter);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnModifier.setForeground(Color.WHITE);
		btnModifier.setBackground(Color.LIGHT_GRAY);
		btnModifier.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnModifier.setBounds(143, 378, 89, 23);
		frame.getContentPane().add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Entreestock entreStoc1;
				entreStoc1 = new Entreestock();
				 DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
				 if(table.getSelectedRowCount() == 1){
					 tblModel.removeRow(table.getSelectedRow());
					 try {
						Factory.supprimerEntreestock(entreStoc1);
						 Actualiser();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 }else{
					 if(table.getRowCount()==0){
						 JOptionPane.showMessageDialog(btnSupprimer," Table is Empty...");
					 }else{
						  JOptionPane.showMessageDialog(btnSupprimer," Please select Single Row for Delete...");
					 }
				 }
			}
		});
		btnSupprimer.setForeground(Color.WHITE);
		btnSupprimer.setBackground(Color.RED);
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSupprimer.setBounds(91, 412, 111, 23);
		frame.getContentPane().add(btnSupprimer);
		
		JComboBox CodePro = new JComboBox();
		CodePro.setBounds(31, 295, 89, 20);
		frame.getContentPane().add(CodePro);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.setBounds(575, 39, 89, 23);
		frame.getContentPane().add(btnRetour);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Id Entree", "Quantite Entree", "Prix Achat", "Code Produit"
			}
		));
		table.setBounds(243, 95, 386, 104);
		frame.getContentPane().add(table);
	}
}
