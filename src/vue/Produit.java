package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import controller.Factory;
import modele.*;


import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class Produit {
	Produit pro1 = null;
    private final DefaultTableModel df;

	private JFrame frame;
	private JTextField CodePro;
	private JTextField nomPro;
	private JTextField prixV;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Produit window = new Produit();
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
	public Produit() {
		initialize();
		//initComponents();
        this.df=new DefaultTableModel();
        df.addColumn("Code Produit");
        df.addColumn("Nom Produit");
        df.addColumn("Date Fabrication");
        df.addColumn("Date Peremption");
        df.addColumn("Prix vente");
        df.addColumn("Code Famille");
        Actualiser();
	}

	  public void  Actualiser(){
		   
	       try{
	         df.setRowCount(0);
	        ArrayList<modele.Produit> pro1=new ArrayList();
	        Factory factory = new Factory();
	        
	        pro1=factory.getProduit();


	        for(modele.Produit p: pro1){
	          df.addRow(new Object []{
	            p.getCodePro(),
	            p.getNomPro(),
	            p.getDateFabPro(),
	            p.getDatePerPro(),
	            p.getPrixVentePro(),
	            p.getCodeFam()
	         
	            
	        });
	        }
	       }
	        
	       
	        catch(Exception ex){ ex.printStackTrace();
	        }
	       table.setModel(df);
	  }
	  

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 740, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblProduit = new JLabel("Produit");
		lblProduit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblProduit.setBounds(312, 11, 111, 37);
		frame.getContentPane().add(lblProduit);
		
		JLabel lblNewLabel = new JLabel("Code Produit:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(35, 68, 89, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nom Produit:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(35, 107, 98, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Date Fabrication:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(35, 151, 111, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Date Peremption:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(35, 193, 111, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Prix De Vente:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(35, 235, 98, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Code Famille:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(35, 278, 98, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JButton btnajouter = new JButton("Ajouter");
		btnajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
				String date1 = sdf.format(dateF.getDate());
				String date2 = sdf.format(dateP.getDate());
				if(nomPro.getText().equals("") || date1
			               || date2 || prixV.getText().equals("") || codeFa.getText()){
					JOptionPane.showMessageDialog(btnajouter,"Please Enter All Data  !");
				
		    }else{
		    	 Produit prod=new Produit();
		    	 String cod=CodePro.getText();
		    	 String nom=nomPro.getText();
		    	 String dat=date1;
		    	 String dat1=date2;
		    	 String prix=prixV.getText();
		    	 String codf=CodeFa.getText();
		    	 Factory.inSertProduit(prod);
		    	   Actualiser();
		            CodePro.setText("");
		            nomPro.setText("");
		            dat.setDate("");
		            dat1.setDate("");
		            prixV.setText("");
		            codf.setText("");
			
		});
		btnajouter.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnajouter.setBackground(Color.GREEN);
		btnajouter.setForeground(Color.WHITE);
		btnajouter.setBounds(44, 329, 89, 23);
		frame.getContentPane().add(btnajouter);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnModifier.setBackground(Color.BLUE);
		btnModifier.setForeground(Color.WHITE);
		btnModifier.setBounds(200, 329, 89, 23);
		frame.getContentPane().add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSupprimer.setBackground(Color.RED);
		btnSupprimer.setForeground(Color.WHITE);
		btnSupprimer.setBounds(111, 363, 121, 23);
		frame.getContentPane().add(btnSupprimer);
		
		CodePro = new JTextField();
		CodePro.setBounds(146, 65, 86, 20);
		frame.getContentPane().add(CodePro);
		CodePro.setColumns(10);
		
		nomPro = new JTextField();
		nomPro.setBounds(146, 104, 86, 20);
		frame.getContentPane().add(nomPro);
		nomPro.setColumns(10);
		
		prixV = new JTextField();
		prixV.setBounds(146, 232, 86, 20);
		frame.getContentPane().add(prixV);
		prixV.setColumns(10);
		
		JDateChooser dateF = new JDateChooser();
		dateF.setBounds(146, 145, 91, 20);
		frame.getContentPane().add(dateF);
		
		JDateChooser dateP = new JDateChooser();
		dateP.setBounds(146, 187, 91, 20);
		frame.getContentPane().add(dateP);
		
		JComboBox CodeFa = new JComboBox();
		CodeFa.setBounds(150, 276, 66, 20);
		frame.getContentPane().add(CodeFa);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.setBounds(625, 24, 89, 23);
		frame.getContentPane().add(btnRetour);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Code Produit", "Nom Produit", "Date Fabrication", "Date Peremption", "Prix de Vente", "Code Famille"
			}
		));
		table.setBounds(299, 69, 415, 132);
		frame.getContentPane().add(table);
	}
		}
