
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
public class Admin_LogIn extends JFrame {

	private JPanel contentPane;
	private JTextField usernameTextField;
	private JPasswordField adminPasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_LogIn adminLogInFrame = new Admin_LogIn();
					adminLogInFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Admin_LogIn() {
		setResizable(false);
		setTitle("Admin Log-in");
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
		
		JLabel adminLogInTitleLabel = new JLabel("Admin Log-in");
		adminLogInTitleLabel.setFont(new Font("Arial", Font.BOLD, 30));
		adminLogInTitleLabel.setBounds(115, 31, 210, 48);
		panel.add(adminLogInTitleLabel);
		
		JLabel adminUsernameLabel = new JLabel("Username:");
		adminUsernameLabel.setBounds(75, 106, 68, 14);
		panel.add(adminUsernameLabel);
		
		JLabel adminPasswordLabel_1 = new JLabel("Password:");
		adminPasswordLabel_1.setBounds(75, 133, 68, 14);
		panel.add(adminPasswordLabel_1);
		
		usernameTextField = new JTextField();
		usernameTextField.setText("");
		usernameTextField.setBounds(139, 103, 215, 20);
		panel.add(usernameTextField);
		usernameTextField.setColumns(10);
		
		adminPasswordField = new JPasswordField();
		adminPasswordField.setEchoChar('*');
		adminPasswordField.setBounds(139, 131, 215, 20);
		panel.add(adminPasswordField);
		
		JCheckBox adminShowPasswordCheckBox = new JCheckBox("Show password");
		adminShowPasswordCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(adminShowPasswordCheckBox.isSelected()) {
					adminPasswordField.setEchoChar((char)0);
				}
				else {
					adminPasswordField.setEchoChar('*');
				}
			}
		});
		adminShowPasswordCheckBox.setBounds(139, 158, 125, 23);
		panel.add(adminShowPasswordCheckBox);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogIn LogIn = new LogIn();
				LogIn.setVisible(true);
				dispose();
			}
		});
		backButton.setBounds(100, 204, 89, 23);
		panel.add(backButton);
		
		JButton logInButton = new JButton("Log-in");
		logInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String adminUser = usernameTextField.getText();
				@SuppressWarnings("deprecation")
				String adminPassword = adminPasswordField.getText();
				
				if(adminUser.equals("Admin_01") && adminPassword.equals("AdminOne") || 
				   adminUser.equals("Admin_02") && adminPassword.equals("AdminTwo") || 
				   adminUser.equals("Admin_03") && adminPassword.equals("AdminThree")) 
				{
					
					int success = JOptionPane.showConfirmDialog(null,"Login Successful!","", JOptionPane.CLOSED_OPTION);
					if(success == JOptionPane.OK_OPTION) {
						WelcomeLibrary welcomeMessage = new WelcomeLibrary();
						welcomeMessage.setVisible(true);
						dispose();
					}
				}
				else if(!(adminUser.equals("Admin_01")) && adminPassword.equals("AdminOne") ||
						!(adminUser.equals("Admin_02")) && adminPassword.equals("AdminTwo") ||
						!(adminUser.equals("Admin_03")) && adminPassword.equals("AdminThree")) 
				{
					int Incorrect = JOptionPane.showConfirmDialog(null,"Incorrect Username","", JOptionPane.CLOSED_OPTION);
					if(Incorrect == JOptionPane.OK_OPTION) {
						Admin_LogIn AdLogIn = new Admin_LogIn(); 
						AdLogIn.setVisible(true);
						dispose();
					}
				}
				else if(adminUser.equals("Admin_01") && !(adminPassword.equals("AdminOne")) ||
						adminUser.equals("Admin_02") && !(adminPassword.equals("AdminTwo")) ||
						adminUser.equals("Admin_03") && !(adminPassword.equals("AdminThree"))) 
				{
					int Incorrect = JOptionPane.showConfirmDialog(null,"Incorrect Password","", JOptionPane.CLOSED_OPTION);
					if(Incorrect == JOptionPane.OK_OPTION) {
						Admin_LogIn AdLogIn = new Admin_LogIn(); 
						AdLogIn.setVisible(true);
						dispose();
					}
				}
				else if(!(adminUser.equals("Admin_01")) && !(adminPassword.equals("AdminOne")) ||
						!(adminUser.equals("Admin_02")) && !(adminPassword.equals("AdminTwo")) ||
						!(adminUser.equals("Admin_03")) && !(adminPassword.equals("AdminThree"))) 
				{
					int Incorrect = JOptionPane.showConfirmDialog(null,"Incorrect Username & Password!","", JOptionPane.CLOSED_OPTION);
					if(Incorrect == JOptionPane.OK_OPTION) {
						Admin_LogIn AdLogIn = new Admin_LogIn(); 
						AdLogIn.setVisible(true);
						dispose();
					}
				}
				
			}
		});
		logInButton.setBounds(236, 204, 89, 23);
		panel.add(logInButton);
	}
}

