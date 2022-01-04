package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;



import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	protected JFrame frmloginSystem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
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
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 449, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAuthentification = new JLabel("Authentification");
		lblAuthentification.setForeground(Color.BLUE);
		lblAuthentification.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblAuthentification.setBounds(107, 21, 152, 19);
		frame.getContentPane().add(lblAuthentification);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(67, 91, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(67, 129, 65, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(164, 89, 188, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String login=textField.getText();
				String password=passwordField.getText();
				
				if(login.contains("ahishakiye")&& password.contains("12345")){
					textField.setText(null);
					passwordField.setText(null);
					
					
					tableauBord.main(null);
				}
				else{
					JOptionPane.showMessageDialog(null,"Donnee saisie est incorrect","Login Error",JOptionPane.ERROR_MESSAGE);
					textField.setText(null);
					passwordField.setText(null);
				}
				
				
			}
		});
		btnConnexion.setForeground(Color.WHITE);
		btnConnexion.setFont(new Font("Arial", Font.BOLD, 11));
		btnConnexion.setBackground(Color.GREEN);
		btnConnexion.setBounds(65, 199, 118, 23);
		frame.getContentPane().add(btnConnexion);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setForeground(Color.WHITE);
		btnQuitter.setFont(new Font("Arial", Font.BOLD, 11));
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmloginSystem= new JFrame("Quitter");
				if(JOptionPane.showConfirmDialog(frmloginSystem, "Voulez-vous vraiment quitter?","Login System",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
					System.exit(0);
				}
			}
		});
		btnQuitter.setBackground(Color.RED);
		btnQuitter.setBounds(263, 199, 89, 23);
		frame.getContentPane().add(btnQuitter);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(164, 127, 188, 20);
		frame.getContentPane().add(passwordField);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(63, 62, 309, -3);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(119, 169, 233, 2);
		frame.getContentPane().add(separator_1);
	}
}
