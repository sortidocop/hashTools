import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DashBoard extends JFrame {

	private JTextField login;
	private JTextField password;
	private JButton bouton = new JButton("run");
	private JTextArea hashResult;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DashBoard() {
		this.setSize(450, 200);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Hash Me");

		bouton.addActionListener(new HashProcess(this));

		this.login = new JTextField(10);
		this.password = new JTextField(10);
		this.hashResult = new JTextArea();

		hashResult.setEditable(false);

		this.setVisible(true);
		this.setLocationRelativeTo(null);

		JLabel labelLogin = new JLabel("Login: ");
		JLabel labelPass = new JLabel("PassWord: ");

		// On crée un conteneur avec gestion horizontale
		Box b1 = Box.createHorizontalBox();
		b1.add(labelLogin);
		b1.add(this.login);
		// Idem
		Box b2 = Box.createHorizontalBox();
		b2.add(labelPass);
		b2.add(this.password);
		// Idem
		Box b3 = Box.createHorizontalBox();
		b3.add(this.bouton);

		Box b4 = Box.createHorizontalBox();
		b4.add(this.hashResult);

		// On crée un conteneur avec gestion verticale
		Box b6 = Box.createVerticalBox();
		b6.add(b1);
		b6.add(b2);
		b6.add(b3);
		b6.add(b4);

		this.getContentPane().add(b6);

		// this.pack();
		this.setVisible(true);
	}

	public String loginText() {
		return this.login.getText();
	}

	public String passText() {
		return this.password.getText();
	}

	public void afficher(String result) {
		this.hashResult.setText(result);
	}

}
