import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import com.mysql.jdbc.PreparedStatement;


public class DeBookPanel extends JPanel {
	public JTextField tfBlock;
	public JTextField tfRoomno;
	public JButton btnOk ;
	public JButton btnGoBack;
	JLabel jlbackground ;
	java.sql.Connection conn;
	PreparedStatement ps;
	ResultSet result;
	/**
	 * Create the panel.
	 */
	public DeBookPanel() {
		setBackground(Color.BLACK);
		setBounds(100,100,650,500);
		setLayout(null);
		
		JLabel jlBlock = new JLabel("BLOCK:");
		jlBlock.setForeground(Color.WHITE);
		jlBlock.setFont(new Font("Tahoma", Font.BOLD, 18));
		jlBlock.setBounds(104, 123, 73, 27);
		add(jlBlock);
		
		JLabel jlRoomno = new JLabel("ROOM NO.:");
		jlRoomno.setForeground(Color.WHITE);
		jlRoomno.setFont(new Font("Tahoma", Font.BOLD, 18));
		jlRoomno.setBounds(340, 127, 108, 18);
		add(jlRoomno);
		
		tfBlock = new JTextField();
		tfBlock.setBounds(187, 129, 86, 20);
		add(tfBlock);
		tfBlock.setColumns(10);
		
		tfRoomno = new JTextField();
		tfRoomno.setBounds(458, 129, 86, 20);
		add(tfRoomno);
		tfRoomno.setColumns(10);
		
		btnOk = new JButton("REMOVE");
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnOk.setBounds(150, 282, 123, 33);
		add(btnOk);
		
		btnGoBack = new JButton("GO BACK");
		btnGoBack.setForeground(Color.RED);
		btnGoBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnGoBack.setBounds(350, 282, 123, 33);
		add(btnGoBack);
		
		jlbackground = new JLabel("");
		jlbackground.setIcon(new ImageIcon("C:\\Users\\Satyam\\Desktop\\icons\\1.jpg"));
		jlbackground.setBounds(10, 0, 617, 500);
		add(jlbackground);

	}

	public void deleteData(){
		Toolkit.getDefaultToolkit().beep();
		int del = JOptionPane.showConfirmDialog(jlbackground,"Do You really want to debook room", "Debook Room",JOptionPane.YES_NO_OPTION);
		if (del == 0) {
			try {
				String s = null;
				String driver = "com.mysql.jdbc.Driver";
				Class.forName(driver);
				java.sql.Connection conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/hoteldb", "root",
						"password");
				if (tfBlock.getText().equalsIgnoreCase("a")) {
					ps = (PreparedStatement) conn
							.prepareStatement("UPDATE a SET name = " + s
									+ ",id=" + s + ",contact=" + s
									+ ",available=0 WHERE roomno = ?");
				}
				if (tfBlock.getText().equalsIgnoreCase("b")) {
					ps = (PreparedStatement) conn
							.prepareStatement("UPDATE b SET name = " + s
									+ ",id=" + s + ",contact=" + s
									+ ",available=0 WHERE roomno = ?");
				}
				ps.setString(1, tfRoomno.getText());
				int i = ps.executeUpdate();
				if (i != 0) {
					JOptionPane.showMessageDialog(jlbackground,"Room Data is succesfully reset");
				} else {
					JOptionPane.showMessageDialog(jlbackground, "ERROR");
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Network error in Debookpanel");
				tfRoomno.setText("");
				tfBlock.setText("");
				JOptionPane.showMessageDialog(jlbackground, "Invalid entries");
			}
		}
	}
}
