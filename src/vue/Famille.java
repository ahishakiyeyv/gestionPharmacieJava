package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.Factory;
import modele.Familllepro;


import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Famille {
	Familllepro famPro1 = null;
    private final DefaultTableModel df;

	private JFrame frame;
	private JTextField codeFamille;
	private JTextField nomFamille;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Famille window = new Famille();
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
	public Famille() {
		initialize();
		// initComponents();
	        this.df=new DefaultTableModel();
	        df.addColumn("Code Famille");
	        df.addColumn("Nom Famille");
	        
	        Actualiser();
	}
    public void  Actualiser(){
    	   
        try{
          df.setRowCount(0);
         ArrayList<Familllepro> famPro1=new ArrayList();
         famPro1=Factory.getFamilllepro();


         for(Familllepro f: famPro1){
           df.addRow(new Object []{
             f.getCodeFam(),
             f.getNomFam()
          
             
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
		frame.setBounds(100, 100, 650, 340);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFamilleProduit = new JLabel("Famille Produit");
		lblFamilleProduit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblFamilleProduit.setBounds(221, 11, 218, 31);
		frame.getContentPane().add(lblFamilleProduit);
		
		JLabel lblNewLabel = new JLabel("Code Famille:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 66, 86, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nom Famille:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 122, 86, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		codeFamille = new JTextField();
		codeFamille.setEditable(false);
		codeFamille.setBounds(10, 91, 135, 20);
		frame.getContentPane().add(codeFamille);
		codeFamille.setColumns(10);
		
		nomFamille = new JTextField();
		nomFamille.setBounds(10, 147, 135, 20);
		frame.getContentPane().add(nomFamille);
		nomFamille.setColumns(10);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(nomFamille.getText().equals("")){
					JOptionPane.showMessageDialog(btnAjouter, "Please Enter all Data");
				}else{
					Familllepro famille= new Familllepro(1,nomFamille.getText());
					famille.setNomFam(nomFamille.getText());
					try {
						Factory.inSertFamilllepro(famille);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 Actualiser();
			           // codeFamille.setText("");
			            nomFamille.setText("");
				}
				String data [] ={codeFamille.getText(),nomFamille.getText()};
			            DefaultTableModel tablem = (DefaultTableModel) table.getModel();
			            //add string array data
			            tablem.addRow(data);// row added
			            //successful added message
			            JOptionPane.showMessageDialog(btnAjouter, this,"Add Data Successfully....! ", 0);
			            //clear textfield for new entry...
			            codeFamille.setText("");
			            nomFamille.setText("");
			}
		});
		btnAjouter.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAjouter.setBackground(Color.GREEN);
		btnAjouter.setForeground(Color.WHITE);
		btnAjouter.setBounds(24, 202, 89, 23);
		frame.getContentPane().add(btnAjouter);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
				 if(table.getSelectedRowCount()==1){
					 String id = codeFamille.getText();
			            String nom = nomFamille.getText();
			            Familllepro fam = new Familllepro();
			            try {
							Factory.modifierFamilllepro(fam);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			            Actualiser();
			            JOptionPane.showMessageDialog(btnModifier, this," Update Successuf...", 0);
				 }else{
					 if(table.getRowCount()==0){
						 JOptionPane.showMessageDialog(btnModifier," Table is Empty...");
					 }else{
						 JOptionPane.showMessageDialog(btnModifier," Please select Single Row for Update...");
					 }
					 }
				 }
			}
		);
		btnModifier.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnModifier.setBackground(Color.BLUE);
		btnModifier.setForeground(Color.WHITE);
		btnModifier.setBounds(151, 202, 89, 23);
		frame.getContentPane().add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Familllepro famPro1;
				 famPro1 = new Familllepro();
				 DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
				 if(table.getSelectedRowCount() == 1){
					 tblModel.removeRow(table.getSelectedRow());
					 try {
						Factory.supprimerFamilllepro(famPro1);
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
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSupprimer.setBackground(Color.RED);
		btnSupprimer.setForeground(Color.WHITE);
		btnSupprimer.setBounds(72, 251, 120, 23);
		frame.getContentPane().add(btnSupprimer);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tableauBord.main(null); 
			}
		});
		btnRetour.setBounds(535, 32, 89, 23);
		frame.getContentPane().add(btnRetour);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				  DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
				  String codefa = tblModel.getValueAt(table.getSelectedRow(), 0).toString();
			        String nomfa = tblModel.getValueAt(table.getSelectedRow(), 1).toString();
			        codeFamille.setText(codefa);
			        nomFamille.setText(nomfa);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Code Famille", "Nom Famille"
			}
		));
		table.setBounds(294, 77, 278, 175);
		frame.getContentPane().add(table);
	}

}
