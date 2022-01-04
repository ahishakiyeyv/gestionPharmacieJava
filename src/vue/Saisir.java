package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JComboBox;

public class Saisir {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Saisir window = new Saisir();
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
	public Saisir() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 740, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSaisir = new JLabel("Saisir");
		lblSaisir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblSaisir.setBounds(284, 11, 121, 31);
		frame.getContentPane().add(lblSaisir);
		
		JLabel lblNewLabel = new JLabel("Id Utilisateur:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(53, 81, 105, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id Entree:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(53, 142, 105, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBackground(Color.GREEN);
		btnAjouter.setForeground(Color.WHITE);
		btnAjouter.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAjouter.setBounds(88, 210, 89, 23);
		frame.getContentPane().add(btnAjouter);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnModifier.setBackground(Color.BLUE);
		btnModifier.setForeground(Color.WHITE);
		btnModifier.setBounds(187, 210, 89, 23);
		frame.getContentPane().add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSupprimer.setBackground(Color.RED);
		btnSupprimer.setForeground(Color.WHITE);
		btnSupprimer.setBounds(129, 244, 114, 23);
		frame.getContentPane().add(btnSupprimer);
		
		JComboBox IdUti = new JComboBox();
		IdUti.setBounds(168, 79, 75, 20);
		frame.getContentPane().add(IdUti);
		
		JComboBox IdEnt = new JComboBox();
		IdEnt.setBounds(168, 140, 75, 20);
		frame.getContentPane().add(IdEnt);
	}

}
