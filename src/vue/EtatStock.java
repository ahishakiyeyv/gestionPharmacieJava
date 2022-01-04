package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextPane;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.ScrollPane;

public class EtatStock {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EtatStock window = new EtatStock();
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
	public EtatStock() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 740, 484);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEtatStock = new JLabel("Etat Stock");
		lblEtatStock.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblEtatStock.setBounds(281, 11, 143, 25);
		frame.getContentPane().add(lblEtatStock);
		
		JButton btnajouter = new JButton("Ajouter");
		btnajouter.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnajouter.setForeground(Color.WHITE);
		btnajouter.setBackground(Color.GREEN);
		btnajouter.setBounds(76, 278, 89, 23);
		frame.getContentPane().add(btnajouter);
		
		JButton btnModifer = new JButton("Modifier");
		btnModifer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnModifer.setBackground(Color.BLUE);
		btnModifer.setForeground(Color.WHITE);
		btnModifer.setBounds(311, 278, 89, 23);
		frame.getContentPane().add(btnModifer);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSupprimer.setBackground(Color.RED);
		btnSupprimer.setForeground(Color.WHITE);
		btnSupprimer.setBounds(532, 278, 101, 23);
		frame.getContentPane().add(btnSupprimer);
		
		table = new JTable();
		table.setToolTipText("");
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Id", "Quantite Stock", "Seuil", "IdSortieStock", "IdEntreeStock", "IdUtilisateur", "CodeProduit"
			}
		));
		table.setBounds(35, 74, 640, 191);
		frame.getContentPane().add(table);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.setBounds(625, 11, 89, 23);
		frame.getContentPane().add(btnRetour);
	}
}
