import javax.swing.JPanel;

import java.sql.*;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.awt.SystemColor;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class LoginPanel extends JPanel {
	public JTextField tfUsername;
	public JPasswordField pfPassword;
	public JButton btnCancel;
	public JButton btnLogin;
	java.sql.Connection conn;
	PreparedStatement ps;
	ResultSet result;

	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		setBackground(Color.PINK);
		setBounds(100,100,650,500);
		setLayout(null);
		setVisible(false);
		
		JLabel jlUsername = new JLabel("Username:");
		jlUsername.setForeground(Color.RED);
		jlUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
		jlUsername.setBounds(376, 135, 97, 26);
		add(jlUsername);
		
		JLabel jlPassword = new JLabel("Password:");
		jlPassword.setForeground(Color.RED);
		jlPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		jlPassword.setBounds(376, 219, 97, 28);
		add(jlPassword);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(376, 181, 210, 27);
		add(tfUsername);
		tfUsername.setColumns(10);
		
		pfPassword = new JPasswordField();
		pfPassword.setBounds(376, 258, 210, 28);
		add(pfPassword);
		
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnLogin.setBackground(new Color(30, 144, 255));
		btnLogin.setForeground(Color.RED);
		btnLogin.setBounds(166, 364, 132, 39);
		add(btnLogin);
		
		btnCancel = new JButton("Reset");
		btnCancel.setForeground(Color.RED);
		btnCancel.setBackground(new Color(30, 144, 255));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnCancel.setBounds(412, 364, 138, 39);
		add(btnCancel);
		
		JLabel loginPic = new JLabel("");
		loginPic.setIcon(new ImageIcon("C:\\Users\\Satyam\\Desktop\\icons\\Picture44.png"));
		loginPic.setBounds(20, 0, 346, 375);
		add(loginPic);

	}
	/*this function is going to check whether entered credentials matches with the database credentials or not*/
	public boolean checkLogin()
	{
		/*boolean flag = false;
		try{
			String driver = "com.mysql.jdbc.Driver";

	        Class.forName(driver);
	        java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldb", "root", "password");
			ps = (PreparedStatement) conn.prepareStatement("SELECT username,password FROM login WHERE username=? AND password=?");
			ps.setString(1,tfUsername.getText() );
			ps.setString(2,String.valueOf(pfPassword.getPassword()));
			result = ps.executeQuery();
			if(result.next())
			{
				    flag = true;
			}
			else{
				flag = false;
			}
			tfUsername.setText("");
			pfPassword.setText("");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Network Connection Problem");
			JOptionPane.showMessageDialog(null,"Network Connection Problem");
		}
		return flag;*/
		return true; // forHalchal - is line ko delete kr dena and upr apne database ka naam daal dena jahan /hoteldb h wahan
	}
	public void cancelAction(){
		tfUsername.setText("");
		pfPassword.setText("");
	}
}
