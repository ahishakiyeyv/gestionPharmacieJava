package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import controller.Factory;
import modele.Entreestock;
import modele.Familllepro;
import modele.Sortiestock;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Sortie {
	Sortiestock stocSor1 = null;
    private final DefaultTableModel df;
	private JFrame frame;
	private JTextField NumFact;
	private JTextField NomCl;
	private JTextField QteSort;
	private JTextField IdSort;
	private JComboBox CodePro;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sortie window = new Sortie();
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
	public Sortie() {
		initialize();
		  this.df=new DefaultTableModel();
	        df.addColumn("Id Sortie");
	        df.addColumn("Nom Facture");
	        df.addColumn("Nom Client");
	        df.addColumn("Date Sortie");
	        df.addColumn("Quantite Sortie");
	        df.addColumn("Code Produit");
	        Actualiser();
	}
    public void  Actualiser(){
 	   
        try{
          df.setRowCount(0);
         ArrayList<Sortiestock> stocSor1=new ArrayList();
         stocSor1=Factory.getSortiestock();


         for(Sortiestock s: stocSor1){
           df.addRow(new Object []{
             s.getIdSortie(),
             s.getNumFacture(),
             s.getNomClient(),
             s.getDateSortie(),
             s.getQteSortie(),
             s.getCodePro()
             
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
		frame.setBounds(100, 100, 730, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSortie = new JLabel("Sortie");
		lblSortie.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblSortie.setBounds(293, 11, 100, 31);
		frame.getContentPane().add(lblSortie);
		
		JLabel lblNewLabel = new JLabel("Numero Facture:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(29, 89, 114, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nom Client:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(29, 123, 100, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Date Sortie:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(29, 159, 100, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Quantite Sortie:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(29, 197, 100, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		NumFact = new JTextField();
		NumFact.setBounds(178, 87, 142, 20);
		frame.getContentPane().add(NumFact);
		NumFact.setColumns(10);
		
		NomCl = new JTextField();
		NomCl.setBounds(178, 121, 142, 20);
		frame.getContentPane().add(NomCl);
		NomCl.setColumns(10);
		
		QteSort = new JTextField();
		QteSort.setBounds(178, 195, 142, 20);
		frame.getContentPane().add(QteSort);
		QteSort.setColumns(10);
		
		JDateChooser DateSort = new JDateChooser();
		DateSort.setBounds(178, 159, 142, 20);
		frame.getContentPane().add(DateSort);
		
		JLabel lblCodeProduit = new JLabel("Code Produit:");
		lblCodeProduit.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCodeProduit.setBounds(30, 233, 106, 14);
		frame.getContentPane().add(lblCodeProduit);
		
		JLabel lblIdSortie = new JLabel("Id Sortie:");
		lblIdSortie.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIdSortie.setBounds(34, 56, 79, 14);
		frame.getContentPane().add(lblIdSortie);
		
		IdSort = new JTextField();
		IdSort.setBounds(178, 54, 86, 20);
		frame.getContentPane().add(IdSort);
		IdSort.setColumns(10);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
				String date = sdf.format(DateSort.getDate());
				/*if(NumFact.getText().equals("")  NomCl.getText().equals("")|| date || QteSort.getText().equals("") || CodePro.getSelectedItem()){
						
					JOptionPane.showMessageDialog(btnAjouter, "Please Enter all Data");
				}else{
				*/
					Sortiestock stock= new Sortiestock();
					//1 ,Integer.valueOf(NumFact.getText()) ,2,NomCl.getText(),3,date,4,QteSort.getText(),
				//	5,CodePro.getSelectedItem(),0
					
					stock.setIdSortie(Integer.valueOf(IdSort.getText()));
					stock.setNumFacture(Integer.valueOf(NumFact.getText()));
					stock.setNomClient(NomCl.getText());
					stock.setDateSortie(date);
					stock.setQteSortie(Integer.valueOf(QteSort.getText()));
					//stock.setCodePro(Integer.valueOf(CodePro.getSelectedItem()));
					try {
						Factory.inSertSortiestock(stock);
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
			            IdSort.setText("");
			            NumFact.setText("");
			            NomCl.setText("");
			            date.isEmpty();
			            QteSort.setText("");
			           // CodePro.setSelectedItem("");;
			}
		});
		btnAjouter.setForeground(Color.WHITE);
		btnAjouter.setBackground(Color.GREEN);
		btnAjouter.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAjouter.setBounds(54, 278, 89, 23);
		frame.getContentPane().add(btnAjouter);
		
		JButton btnModifer = new JButton("Modifier");
		btnModifer.setForeground(Color.WHITE);
		btnModifer.setBackground(Color.BLUE);
		btnModifer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnModifer.setBounds(175, 278, 89, 23);
		frame.getContentPane().add(btnModifer);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sortiestock stock;
				stock = new Sortiestock();
				 DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
				 if(table.getSelectedRowCount() == 1){
					 tblModel.removeRow(table.getSelectedRow());
					 try {
						Factory.supprimerSortiestock(stock);
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
		btnSupprimer.setBounds(113, 312, 114, 23);
		frame.getContentPane().add(btnSupprimer);
		
		JComboBox CodePro = new JComboBox();
		CodePro.setBounds(178, 231, 79, 20);
		frame.getContentPane().add(CodePro);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.setBounds(615, 21, 89, 23);
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
				"Id Sortie", "Numero Facture", "Nom Client", "Date Sortie", "Quantite Sortie", "Code Produit"
			}
		));
		table.setBounds(350, 53, 354, 113);
		frame.getContentPane().add(table);
	}
}
