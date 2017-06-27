import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

import com.mysql.jdbc.PreparedStatement;

import java.sql.*;

public class BookingPanel extends JPanel {
	public JTextField tfName;
	public JTextField tfId;
	public JTextField tfContact;
	JComboBox cbBlock;
	public JComboBox cbRoomAvailable;
	JLabel jlName;
	JLabel jlID;
	JLabel jlContact;
	public JButton btnOk;
	public JButton btnGoBack;
	java.sql.Connection conn;
	PreparedStatement ps;
	JLabel jlbackground;
	ResultSet result;

	/**
	 * Create the panel.
	 */
	public BookingPanel() {
		setBackground(Color.BLACK);
		setBounds(100,100,650,500);
		setLayout(null);
		setVisible(false);
		
		JLabel jlBlock = new JLabel("Block:");
		jlBlock.setForeground(new Color(255, 255, 255));
		jlBlock.setFont(new Font("Tahoma", Font.BOLD, 20));
		jlBlock.setBounds(89, 80, 73, 25);
		add(jlBlock);
		
		cbBlock = new JComboBox();
		cbBlock.setBounds(156, 84, 96, 25);
		add(cbBlock);
		cbBlock.addItem("A");
		cbBlock.addItem("B");
		cbBlock.setEditable(true);
		
		JLabel jlRoomAvailable = new JLabel("Room Available:");
		jlRoomAvailable.setForeground(new Color(255, 255, 255));
		jlRoomAvailable.setFont(new Font("Tahoma", Font.BOLD, 20));
		jlRoomAvailable.setBounds(307, 89, 171, 17);
		add(jlRoomAvailable);
		
		cbRoomAvailable = new JComboBox();
		cbRoomAvailable.setBounds(488, 86, 96, 25);
		add(cbRoomAvailable);
		cbRoomAvailable.setEditable(true);
		cbRoomAvailable.addItem("1");
		cbRoomAvailable.addItem("2");
		cbRoomAvailable.addItem("3");
		cbRoomAvailable.addItem("4");
		cbRoomAvailable.addItem("5");
		
		jlName = new JLabel("Name:");
		jlName.setForeground(new Color(255, 255, 255));
		jlName.setFont(new Font("Tahoma", Font.BOLD, 20));
		jlName.setBounds(89, 152, 65, 38);
		add(jlName);
		
		jlID = new JLabel("ID:");
		jlID.setForeground(new Color(255, 255, 255));
		jlID.setFont(new Font("Tahoma", Font.BOLD, 20));
		jlID.setBounds(121, 196, 46, 27);
		add(jlID);
		
		jlContact = new JLabel("Contact:");
		jlContact.setForeground(new Color(255, 255, 255));
		jlContact.setFont(new Font("Tahoma", Font.BOLD, 20));
		jlContact.setBounds(72, 234, 89, 25);
		add(jlContact);
		
		btnOk = new JButton("BOOK");
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnOk.setBounds(156, 341, 165, 33);
		btnOk.setVisible(false);
		add(btnOk);
		
		btnGoBack = new JButton("GO BACK");
		btnGoBack.setBackground(Color.WHITE);
		btnGoBack.setForeground(Color.RED);
		btnGoBack.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnGoBack.setBounds(395, 341, 165, 33);
		add(btnGoBack);
		
		tfName = new JTextField();
		tfName.setFont(new Font("Tahoma", Font.BOLD, 15));
		tfName.setBounds(166, 160, 223, 25);
		add(tfName);
		tfName.setColumns(10);
		
		tfId = new JTextField();
		tfId.setFont(new Font("Tahoma", Font.BOLD, 15));
		tfId.setBounds(166, 198, 223, 25);
		add(tfId);
		tfId.setColumns(10);
		
		tfContact = new JTextField();
		tfContact.setFont(new Font("Tahoma", Font.BOLD, 15));
		tfContact.setBounds(166, 234, 223, 26);
		add(tfContact);
		tfContact.setColumns(10);
		
		jlbackground = new JLabel("");
		jlbackground.setIcon(new ImageIcon("C:\\Users\\Satyam\\Pictures\\bookbc1.png"));
		jlbackground.setBounds(10, 0, 630, 489);
		add(jlbackground);

	}
	public boolean checkAvailability()
	{
		boolean flag = false;
		try{
			String driver = "com.mysql.jdbc.Driver";

	        Class.forName(driver);
	        java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldb", "root", "password");
	        if(cbBlock.getSelectedIndex()==0)
	        {
	        	ps = (PreparedStatement) conn.prepareStatement("SELECT available FROM a WHERE roomno = ?");
	        }
	        if(cbBlock.getSelectedIndex()==1){
	        	ps = (PreparedStatement) conn.prepareStatement("SELECT available FROM b WHERE roomno = ?");
	        }
	        ps.setString(1,(String)cbRoomAvailable.getSelectedItem());
	        result = ps.executeQuery();
	        if(result.next()){
	        	if(result.getInt("available")==0){
	        	flag=true;
	        	}
	        	else{	
		        	flag=false;
				 }
	        }
	        
	        
			
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("network error in BookingPanel");
		}
		return flag;
		
	}
	public boolean checkFields()
	{
		boolean flagContact = false;
		boolean flagName = false;
		boolean flagId = false;
		String msg="Invalid Field";
		
		
		if(tfName.getText().isEmpty()==false){
			tfName.setBackground(Color.white);
			flagName= true;
		}

		else{
			flagName=false;	
			tfName.setBackground(Color.red);
		}
		if(tfId.getText().isEmpty()==false){
			tfId.setBackground(Color.white);
			flagId=true;
		}
		else{
			flagId=false;
			tfId.setBackground(Color.red);
		}
		try {
			if (tfContact.getText() != null) {
				long contactValue = Long.parseLong(tfContact.getText());
				if (contactValue >= Long.parseLong("7000000000")&& contactValue <= Long.parseLong("9999999999")) {
					tfContact.setBackground(Color.white);
					flagContact = true;
				} 
				else {
					flagContact = false;
					tfContact.setBackground(Color.red);
				}
			}

			else {
				flagContact = false;
				
			}
		} catch (NumberFormatException e) {
			tfContact.setBackground(Color.red);
			msg="Invalid Field";
		}
		if(flagId&&flagName&&flagContact){
			return true;
		}

		else{ 
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(jlbackground, msg);
			return false;
		}
			
	}
	public void initialise(){
		//btnOk.setVisible(false);
		//cbRoomAvailable.setSelectedIndex(0);
		tfName.setBackground(Color.white);
		tfId.setBackground(Color.white);
		tfContact.setBackground(Color.white);
		tfName.setText("");
		tfId.setText("");
		tfContact.setText("");
	}
	public void insertData()
	{
		try{
			String driver = "com.mysql.jdbc.Driver";

	        Class.forName(driver);
	        java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldb", "root", "password");
	        String name = "\""+tfName.getText()+"\"";
	        String id = "\""+tfId.getText()+"\"";
	        String contact = "\""+tfContact.getText()+"\"";
	        if(cbBlock.getSelectedIndex()==0)
	        {
	        	ps = (PreparedStatement) conn.prepareStatement("UPDATE a SET name="+ name +",id="+ id +",contact="+ contact +", available=1 WHERE roomno = ?");
	        }
	        if(cbBlock.getSelectedIndex()==1){
	        	ps = (PreparedStatement) conn.prepareStatement("UPDATE b SET name="+ name +",id="+ id +",contact="+ contact +", available=1 WHERE roomno = ?");
	        }
	        ps.setString(1,(String)cbRoomAvailable.getSelectedItem());
	        int i = ps.executeUpdate();
	        if(i!=0)
	        {	
	        	initialise();
	        	JOptionPane.showMessageDialog(jlbackground,"Room Booked Successfully");
	        }
	        else{
	        	Toolkit.getDefaultToolkit().beep();
	        	JOptionPane.showMessageDialog(jlbackground,"ERROR");
	        }
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("network error in BookingPanel");
			//JOptionPane.showMessageDialog(null, "Network error in Bp");
		}
		
	}
	
}
