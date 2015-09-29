package screens;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import server.ServerComms;

public class LoginGui extends JFrame{
	String username = "-1";
	String password = "-1";
	boolean logout = false;
	public LoginGui(){
		JPanel panel = new JPanel(new BorderLayout(5, 5));
	    JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));
	    JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
	    
	    panel.add(label, BorderLayout.WEST);
	    label.add(new JLabel("E-Mail", SwingConstants.RIGHT));
	    label.add(new JLabel("Password", SwingConstants.RIGHT));
	    JTextField usernameInput = new JTextField();
	    controls.add(usernameInput);
	    JPasswordField passwordInput = new JPasswordField();
	    controls.add(passwordInput);
	    panel.add(controls, BorderLayout.CENTER);
	    JOptionPane.showMessageDialog(this, panel, "login", JOptionPane.QUESTION_MESSAGE);
	    username = usernameInput.getText();
	    password = passwordInput.getText();
		if(username.length() < 4){
			JOptionPane.showMessageDialog(null, "Username must be at least 3 characters Long!/n"
					+"/n You have been logged out!");
			this.logout = true;
			username = "-1";
			password = "-1";
		}else if(username.length() > 9){
			JOptionPane.showMessageDialog(null, "/n Username must be less then 9 characters Long!/n"
					+ "/n You have been logged out!");
			this.logout = true;
			username = "-1";
			password = "-1";
		}
		else if(password.length() < 5){
			JOptionPane.showMessageDialog(null, "Password must be at least 5 characters Long!/n"
					+"/n You have been logged out!");
			this.logout = true;
			username = "-1";
			password = "-1";
		}else if(password.length() > 15){
			JOptionPane.showMessageDialog(null, "/n Password must be less then 16 characters Long!/n/n You have been logged out!");
			this.logout = true;
			username = "-1";
			password = "-1";
		}
	}
	public boolean hasHappened() {
		if(username.equals("-1")){
			return false;
		}else if(password.equals("-1")){
			return false;
		}
		return true;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isLogout() {
		return logout;
	}
	public void setLogout(boolean logout) {
		this.logout = logout;
	}
	
	

}
