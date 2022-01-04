package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.Factory;
import modele.Sortiestock;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Utilisateur {
	Utilisateur util1 = null;
    private final DefaultTableModel df;
	private JFrame frame;
	private JTextField NomComplet;
	private JTextField Adresse;
	private JTextField telephone;
	private JTextField Login;
	private JPasswordField Password;
	private JTextField idUt;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Utilisateur window = new Utilisateur();
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
	public Utilisateur() {
		initialize();
		 this.df=new DefaultTableModel();
	        df.addColumn("Id Utilisateur");
	        df.addColumn("Nom");
	        df.addColumn("Addresse");
	        df.addColumn("Telephone");
	        df.addColumn("Login");
	        df.addColumn("Password");
	        df.addColumn("Id Stock");
	        Actualiser();
	}
	   public void  Actualiser(){
	 	   
	        try{
	          df.setRowCount(0);
	         ArrayList<modele.Utilisateur> util1=new ArrayList();
	         util1=Factory.getUtilisateur();


	         for(modele.Utilisateur u: util1){
	           df.addRow(new Object []{
	             u.getIdUti(),
	             u.getNomUti(),
	             u.getAdrUti(),
	             u.getTelUti(),
	             u.getLoginUti(),
	             u.getPswdUti(),
	             u.getEtatstock_idstock()
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
		frame.setBounds(100, 100, 730, 507);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUtilisateur = new JLabel("Utilisateur");
		lblUtilisateur.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblUtilisateur.setBounds(282, 0, 161, 31);
		frame.getContentPane().add(lblUtilisateur);
		
		JLabel lblNewLabel = new JLabel("Nom Utilisateur:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(21, 75, 98, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Telephone:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(20, 178, 86, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Addresse:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(20, 122, 86, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Login:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(21, 223, 86, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Password:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(21, 269, 86, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Id Stock:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(21, 317, 57, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		NomComplet = new JTextField();
		NomComplet.setBounds(20, 91, 141, 20);
		frame.getContentPane().add(NomComplet);
		NomComplet.setColumns(10);
		
		Adresse = new JTextField();
		Adresse.setBounds(20, 137, 141, 20);
		frame.getContentPane().add(Adresse);
		Adresse.setColumns(10);
		
		telephone = new JTextField();
		telephone.setBounds(20, 192, 141, 20);
		frame.getContentPane().add(telephone);
		telephone.setColumns(10);
		
		Login = new JTextField();
		Login.setBounds(21, 238, 141, 20);
		frame.getContentPane().add(Login);
		Login.setColumns(10);
		
		Password = new JPasswordField();
		Password.setBounds(21, 286, 141, 20);
		frame.getContentPane().add(Password);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

//				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
//				String date = sdf.format(DateSort.getDate());
				/*if(NumFact.getText().equals("")  NomCl.getText().equals("")|| date || QteSort.getText().equals("") || CodePro.getSelectedItem()){
						
					JOptionPane.showMessageDialog(btnAjouter, "Please Enter all Data");
				}else{
				*/
					modele.Utilisateur util= new modele.Utilisateur();
					//1 ,Integer.valueOf(NumFact.getText()) ,2,NomCl.getText(),3,date,4,QteSort.getText(),
				//	5,CodePro.getSelectedItem(),0
					
					util.setIdUti(1);
					util.setNomUti(NomComplet.getText());
					util.setAdrUti(Adresse.getText());
					util.setTelUti(Integer.valueOf(telephone.getText()));
					util.setLoginUti(Login.getText());
					util.setPswdUti(Password.getText());
					//util.setEtatstock_idstock(Integer.valueOf(IdSort.getSelectedItem()));
					try {
						Factory.inSertUtilisateur(util);
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
			            idUt.setText("");
			            NomComplet.setText("");
			            Adresse.setText("");
			            telephone.setText("");;
			            Login.setText("");
			            Password.setText("");
			          //  IdStock.setSelectedItem("");;
			
			}
		});
		btnAjouter.setForeground(Color.WHITE);
		btnAjouter.setBackground(Color.GREEN);
		btnAjouter.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAjouter.setBounds(30, 400, 89, 23);
		frame.getContentPane().add(btnAjouter);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setForeground(Color.WHITE);
		btnModifier.setBackground(Color.BLUE);
		btnModifier.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnModifier.setBounds(165, 400, 89, 23);
		frame.getContentPane().add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modele.Utilisateur util;
				util = new modele.Utilisateur();
				 DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
				 if(table.getSelectedRowCount() == 1){
					 tblModel.removeRow(table.getSelectedRow());
					 try {
						Factory.supprimerUtilisateur(util);
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
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSupprimer.setBounds(94, 434, 111, 23);
		frame.getContentPane().add(btnSupprimer);
		
		JLabel lblIdUtilisateur = new JLabel("Id Utilisateur:");
		lblIdUtilisateur.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIdUtilisateur.setBounds(21, 25, 98, 14);
		frame.getContentPane().add(lblIdUtilisateur);
		
		idUt = new JTextField();
		idUt.setEditable(false);
		idUt.setBounds(21, 44, 57, 20);
		frame.getContentPane().add(idUt);
		idUt.setColumns(10);
		
		JComboBox IdStock = new JComboBox();
		IdStock.setBounds(21, 332, 62, 20);
		frame.getContentPane().add(IdStock);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.setBounds(615, 22, 89, 23);
		frame.getContentPane().add(btnRetour);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Id utilisateur", "Nom Utilisateur", "Addresse", "Type Utilisateur", "Telephone", "Login", "Password", "Id Stock"
			}
		));
		table.setBounds(202, 76, 447, 116);
		frame.getContentPane().add(table);
	}
}
