
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Librarian_LogIn extends JFrame {

	private JPanel contentPane;
	private JTextField librarianUsernameTextField;
	private JPasswordField librarianPasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Librarian_LogIn frame = new Librarian_LogIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Librarian_LogIn() {
		setResizable(false);
		setTitle("Librarian Log-in");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel librarianTitleLabel = new JLabel("Librarian Log-in");
		librarianTitleLabel.setFont(new Font("Century Gothic", Font.BOLD, 30));
		librarianTitleLabel.setBounds(100, 37, 247, 37);
		panel.add(librarianTitleLabel);
		
		JLabel librarianUsernameLabel = new JLabel("Username:");
		librarianUsernameLabel.setBounds(74, 105, 75, 14);
		panel.add(librarianUsernameLabel);
		
		JLabel librarianPasswordLabel = new JLabel("Password:");
		librarianPasswordLabel.setBounds(74, 141, 75, 14);
		panel.add(librarianPasswordLabel);
		
		librarianUsernameTextField = new JTextField();
		librarianUsernameTextField.setText("");
		librarianUsernameTextField.setBounds(147, 102, 213, 20);
		panel.add(librarianUsernameTextField);
		librarianUsernameTextField.setColumns(10);
		
		librarianPasswordField = new JPasswordField();
		librarianPasswordField.setEchoChar('*');
		librarianPasswordField.setBounds(147, 138, 213, 20);
		panel.add(librarianPasswordField);
		
		JCheckBox librarianShowPasswordCheckBox = new JCheckBox("Show password");
		librarianShowPasswordCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(librarianShowPasswordCheckBox.isSelected()) {
					librarianPasswordField.setEchoChar((char)0);
				}
				else {
					librarianPasswordField.setEchoChar('*');
				}
			}
		});
		librarianShowPasswordCheckBox.setBounds(145, 166, 120, 23);
		panel.add(librarianShowPasswordCheckBox);
		
		JButton librarianBackButton = new JButton("Back");
		librarianBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogIn LogIn = new LogIn();
				LogIn.setVisible(true);
				dispose();
			}
		});
		librarianBackButton.setBounds(88, 209, 89, 23);
		panel.add(librarianBackButton);
		
		JButton librarianLogInButton = new JButton("Log-in");
		librarianLogInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String libUsername = librarianUsernameTextField.getText();
				@SuppressWarnings("deprecation")
				String libPassword = librarianPasswordField.getText();
				
				if(libUsername.equals("Librarian_01") && libPassword.equals("LibOne") ||
			       libUsername.equals("Librarian_02") && libPassword.equals("LibTwo") ||
			       libUsername.equals("Librarian_03") && libPassword.equals("LibThree")) 
				{
					
						int success = JOptionPane.showConfirmDialog(null,"Login Successful!","", JOptionPane.CLOSED_OPTION);
						if(success == JOptionPane.OK_OPTION) {
							BooksList bookList = new BooksList();
							bookList.setVisible(true);
							dispose();
						}		
						
				}
				else if(!(libUsername.equals("Librarian_01")) && libPassword.equals("LibOne") ||
					    !(libUsername.equals("Librarian_02")) && libPassword.equals("LibTwo") ||
					    !(libUsername.equals("Librarian_03")) && libPassword.equals("LibThree")) 
				{
					    
							int Incorrect = JOptionPane.showConfirmDialog(null,"USERNAME INCORRECT","", JOptionPane.CLOSED_OPTION);
							if(Incorrect == JOptionPane.OK_OPTION) {
								Librarian_LogIn libLogIn = new Librarian_LogIn();
								libLogIn.setVisible(true);
								dispose();
							}
				}
				else if(libUsername.equals("Librarian_01") && !(libPassword.equals("LibOne")) ||
						libUsername.equals("Librarian_02") && !(libPassword.equals("LibTwo")) ||
					    libUsername.equals("Librarian_03") && !(libPassword.equals("LibThree"))) 
				{	
					
							int Incorrect = JOptionPane.showConfirmDialog(null,"PASSWORD INCORRECT","", JOptionPane.CLOSED_OPTION);
								if(Incorrect == JOptionPane.OK_OPTION) {
									Librarian_LogIn libLogIn = new Librarian_LogIn();
									libLogIn.setVisible(true);
									dispose();
						}
					
				}
				else if(!(libUsername.equals("Librarian_01")) && !(libPassword.equals("LibOne")) ||
						!(libUsername.equals("Librarian_02")) && !(libPassword.equals("LibTwo")) ||
					    !(libUsername.equals("Librarian_03")) && !(libPassword.equals("LibThree"))) 
				{
					int Incorrect = JOptionPane.showConfirmDialog(null,"USERNAME AND PASSWORD INCORRECT","", JOptionPane.CLOSED_OPTION);
					if(Incorrect == JOptionPane.OK_OPTION) {
						Librarian_LogIn LibLogIn = new Librarian_LogIn();
						LibLogIn.setVisible(true);
						dispose();
					}
				}
			
			}		
		});
		librarianLogInButton.setBounds(245, 209, 89, 23);
		panel.add(librarianLogInButton);
	}
}
