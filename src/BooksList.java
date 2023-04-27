
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class BooksList extends JFrame {

	private JPanel contentPane;
	private JTextField inputTextField;
	static int book1Copy = 2;
	static int book2Copy = 3;
	static int book3Copy = 4;

	static JLabel bookOneCopy = new JLabel();
	static JLabel bookTwoCopy = new JLabel();
	static JLabel bookThreeCopy = new JLabel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BooksList frame = new BooksList();
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
	public BooksList() {
		setTitle("List of Books");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 302);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 662, 261);
		contentPane.add(panel);
		panel.setLayout(null);

		bookOneCopy.setText(Integer.toString(book1Copy));
		bookOneCopy.setBounds(515, 97, 46, 14);
		bookOneCopy.setVisible(true);
		panel.add(bookOneCopy);

		bookTwoCopy.setText(Integer.toString(book2Copy));
		bookTwoCopy.setBounds(515, 122, 46, 14);
		bookTwoCopy.setVisible(true);
		panel.add(bookTwoCopy);

		bookThreeCopy.setText(Integer.toString(book3Copy));
		bookThreeCopy.setBounds(515, 147, 46, 14);
		bookThreeCopy.setVisible(true);
		panel.add(bookThreeCopy);

		JLabel listOfBooksTitleLabel = new JLabel("List of Books");
		listOfBooksTitleLabel.setFont(new Font("Century Gothic", Font.BOLD, 30));
		listOfBooksTitleLabel.setBounds(235, 21, 202, 43);
		panel.add(listOfBooksTitleLabel);

		JLabel book1Label = new JLabel("[1] : System Analysis (2012) by Gary B. Shelly");
		book1Label.setBounds(41, 97, 268, 14);
		panel.add(book1Label);

		JLabel chooseLabel = new JLabel("Please choose number to rent a book");
		chooseLabel.setBounds(41, 75, 251, 14);
		panel.add(chooseLabel);

		JLabel book2Label = new JLabel("[2] : Android Application (2014) by Corine Hoisington");
		book2Label.setBounds(41, 122, 329, 14);
		panel.add(book2Label);

		JLabel book3Label = new JLabel("[3] : Programming Concepts and Logic Formulation (2015) by Rosauro E. Manuel");
		book3Label.setBounds(41, 147, 484, 14);
		panel.add(book3Label);

		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Librarian_LogIn LibLogIn = new Librarian_LogIn();
				LibLogIn.setVisible(true);
				dispose();
			}
		});
		backButton.setBounds(202, 216, 89, 23);
		panel.add(backButton);

		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ArrayList<DifferentBooks> book = new ArrayList<>();

				DifferentBooks bookNum1 = new DifferentBooks();
				bookNum1.title = "System Analysis (2012)";
				bookNum1.author = "Gary B. Shelly";

				DifferentBooks bookNum2 = new DifferentBooks();
				bookNum2.title = "Android Application (2014)";
				bookNum2.author = "Corine Hoisington";

				DifferentBooks bookNum3 = new DifferentBooks();
				bookNum3.title = "Programming Concepts and Logic Formulation (2015)";
				bookNum3.author = "Rosauro E. Manuel";

				book.add(bookNum1);
				book.add(bookNum2);
				book.add(bookNum3);

				try {
					int choice = Integer.parseInt(inputTextField.getText());
					choice -=1;
					@SuppressWarnings("unused")
					DifferentBooks theBook = book.get(choice);

					if (choice == 0 && book1Copy < 1) {
						JOptionPane.showConfirmDialog(null, "No copies available.", "", JOptionPane.CLOSED_OPTION);
					} else if (choice == 1 && book2Copy < 1) {
						JOptionPane.showConfirmDialog(null, "No copies available.", "", JOptionPane.CLOSED_OPTION);
					} else if (choice == 2 && book3Copy < 1) {
						JOptionPane.showConfirmDialog(null, "No copies available.", "", JOptionPane.CLOSED_OPTION);
					}

					if (choice == 0 && book1Copy >= 1) {
						int chooseOkay = JOptionPane.showConfirmDialog(null,"You choose: " + book.get(choice).getTitle(), "", JOptionPane.CLOSED_OPTION);
						// Minus the books code
						book1Copy -= 1;
						bookOneCopy.setText(Integer.toString(book1Copy));
						if (chooseOkay == JOptionPane.OK_OPTION) {
							int ask = JOptionPane.showConfirmDialog(null, "Do you want to rent again?", "Ask",JOptionPane.YES_NO_OPTION);
							if (ask == JOptionPane.YES_OPTION) {
								setVisible(true);
							} else {
								dispose();
								LogIn logIn = new LogIn();
								logIn.setVisible(true);
							}
						}
					} else if (choice == 1 && book2Copy >= 1) {

						int chooseOkay = JOptionPane.showConfirmDialog(null,"You choose: " + book.get(choice).getTitle(), "", JOptionPane.CLOSED_OPTION);
						book2Copy -= 1;
						bookTwoCopy.setText(Integer.toString(book2Copy));
						if (chooseOkay == JOptionPane.OK_OPTION) {
							int ask = JOptionPane.showConfirmDialog(null, "Do you want to rent again?", "Ask",JOptionPane.YES_NO_OPTION);
							if (ask == JOptionPane.YES_OPTION) {
								setVisible(true);
							} else {
								dispose();
								LogIn logIn = new LogIn();
								logIn.setVisible(true);
							}
						}
					} else if (choice == 2 && book3Copy >= 1) {

						int chooseOkay = JOptionPane.showConfirmDialog(null,"You choose: " + book.get(choice).getTitle(), "", JOptionPane.CLOSED_OPTION);

						book3Copy -= 1;
						bookThreeCopy.setText(Integer.toString(book3Copy));

						if (chooseOkay == JOptionPane.OK_OPTION) {
							int ask = JOptionPane.showConfirmDialog(null, "Do you want to rent again?", "Ask",
									JOptionPane.YES_NO_OPTION);
							if (ask == JOptionPane.YES_OPTION) {
								setVisible(true);
							} else {
								dispose();
								LogIn logIn = new LogIn();
								logIn.setVisible(true);
							}
						}
					}

				} catch (NumberFormatException ex) {
					int choice = JOptionPane.showConfirmDialog(null, "Input must be in the choices. Please try again!", "", JOptionPane.CLOSED_OPTION);
					if (choice == JOptionPane.OK_OPTION) {
						dispose();
						BooksList booksList = new BooksList();
						booksList.setVisible(true);
					}
				} catch (IndexOutOfBoundsException ex) {
					int choice = JOptionPane.showConfirmDialog(null, "Index does not exist. Please try again!", "", JOptionPane.CLOSED_OPTION);
					if (choice == JOptionPane.OK_OPTION) {
						dispose();
						BooksList booksList = new BooksList();
						booksList.setVisible(true);
					}
				}
			}

		});
		submitButton.setBounds(381, 216, 89, 23);
		panel.add(submitButton);

		inputTextField = new JTextField();
		inputTextField.setText("");
		inputTextField.setBounds(202, 172, 268, 20);
		panel.add(inputTextField);
		inputTextField.setColumns(10);

		JLabel CopiesLabel = new JLabel("Available copies:");
		CopiesLabel.setBounds(480, 75, 103, 14);
		panel.add(CopiesLabel);
	}
}
