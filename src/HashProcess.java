import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;

public class HashProcess implements ActionListener {

	private DashBoard dash;

	public HashProcess(DashBoard dash) {
		this.dash = dash;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		final String login = dash.loginText();
		final String password = dash.passText();

		try {
			dash.afficher(HashAndSaltUtils.hashMe(login, password));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

	}

}
