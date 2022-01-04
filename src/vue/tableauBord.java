package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class tableauBord {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tableauBord window = new tableauBord();
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
	public tableauBord() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 643, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTableauDeBord = new JLabel("Tableau de Bord");
		lblTableauDeBord.setBackground(Color.BLUE);
		lblTableauDeBord.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblTableauDeBord.setBounds(201, 11, 211, 42);
		frame.getContentPane().add(lblTableauDeBord);
		
		JButton btnClient = new JButton("Produit");
		btnClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Produit.main(null);
			}
		});
		btnClient.setBackground(Color.LIGHT_GRAY);
		btnClient.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnClient.setBounds(152, 116, 103, 65);
		frame.getContentPane().add(btnClient);
		
		JButton btnEntree = new JButton("Entree");
		btnEntree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Entree.main(null);
			}
		});
		btnEntree.setBackground(Color.LIGHT_GRAY);
		btnEntree.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEntree.setBounds(388, 116, 103, 65);
		frame.getContentPane().add(btnEntree);
		
		JButton btnSortie = new JButton("Sortie");
		btnSortie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sortie.main(null);
			}
		});
		btnSortie.setBackground(Color.LIGHT_GRAY);
		btnSortie.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSortie.setBounds(152, 234, 103, 65);
		frame.getContentPane().add(btnSortie);
		
		JButton btnFamille = new JButton("Famille");
		btnFamille.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Famille.main(null);
			}
		});
		btnFamille.setBackground(Color.LIGHT_GRAY);
		btnFamille.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnFamille.setBounds(388, 234, 102, 65);
		frame.getContentPane().add(btnFamille);
		
		JButton btnDeconnexion = new JButton("Deconnexion");
		btnDeconnexion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnDeconnexion.setBackground(Color.LIGHT_GRAY);
		btnDeconnexion.setBounds(503, 41, 114, 23);
		frame.getContentPane().add(btnDeconnexion);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(124, 51, 367, 2);
		frame.getContentPane().add(separator);
		
		JButton btnUtilisateur = new JButton("Utilisateur");
		btnUtilisateur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Utilisateur.main(null);
			}
		});
		btnUtilisateur.setBackground(Color.LIGHT_GRAY);
		btnUtilisateur.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUtilisateur.setBounds(265, 326, 147, 52);
		frame.getContentPane().add(btnUtilisateur);
	}
}
