import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.jdbc.PreparedStatement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class CheckPanel extends JPanel {
	
	public JButton btnOk;
	public JLabel jlBlock;
	public JLabel jlNameResult;
	public JLabel jlIDResult;
	public JLabel jlContactResult;
	private JTextField tfBlock;
	private JTextField tfRoom;
	private JLabel jlInfo;
	JPanel panel;
	java.sql.Connection conn;
	PreparedStatement ps;
	ResultSet result;
	/**
	 * Create the panel.
	 */
	public CheckPanel() {
		setBackground(Color.BLACK);
		setBounds(100,100,650,500);
		setLayout(null);
		setVisible(false);
		
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(10, 185, 630, 204);
		//panel.setLayout(null);
		add(panel);
		
		JLabel jlRoomNo = new JLabel("Room No.:");
		jlRoomNo.setForeground(Color.WHITE);
		jlRoomNo.setFont(new Font("Tahoma", Font.BOLD, 18));
		jlRoomNo.setBounds(228, 98, 104, 22);
		add(jlRoomNo);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(Color.GREEN);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblName.setBounds(228, 54, 60, 22);
		panel.add(lblName);
		
		JLabel jlContact = new JLabel("Contact:");
		jlContact.setForeground(Color.GREEN);
		jlContact.setFont(new Font("Tahoma", Font.BOLD, 18));
		jlContact.setBounds(211, 139, 77, 22);
		panel.add(jlContact);
		
		jlBlock = new JLabel("Block:");
		jlBlock.setFont(new Font("Tahoma", Font.BOLD, 18));
		jlBlock.setForeground(Color.WHITE);
		jlBlock.setBounds(266, 53, 61, 22);
		add(jlBlock);
		
		jlIDResult = new JLabel(".............");
		jlIDResult.setFont(new Font("Tahoma", Font.BOLD, 18));
		jlIDResult.setForeground(Color.GREEN);
		jlIDResult.setBounds(312, 95, 141, 22);
		panel.add(jlIDResult);
		
		btnOk = new JButton("GO BACK");
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnOk.setForeground(Color.RED);
		btnOk.setBounds(465, 416, 162, 31);
		add(btnOk);
		
		jlNameResult = new JLabel(".............");
		jlNameResult.setFont(new Font("Tahoma", Font.BOLD, 18));
		jlNameResult.setForeground(Color.GREEN);
		jlNameResult.setBounds(312, 54, 141, 22);
		panel.add(jlNameResult);
		
		jlContactResult = new JLabel(".............");
		jlContactResult.setForeground(Color.GREEN);
		jlContactResult.setFont(new Font("Tahoma", Font.BOLD, 18));
		jlContactResult.setBounds(312, 139, 141, 22);
		panel.add(jlContactResult);
		
		tfBlock = new JTextField();
		tfBlock.setText("A,B\r\n");
		tfBlock.setBounds(334, 57, 86, 20);
		add(tfBlock);
		tfBlock.setColumns(10);
		
		tfRoom = new JTextField();
		tfRoom.setText("1 to 5");
		tfRoom.setBounds(334, 102, 86, 20);
		add(tfRoom);
		tfRoom.setColumns(10);
		
		JButton btnCheck = new JButton("CHECK");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				getInfo();
			}
		});
		btnCheck.setBounds(294, 151, 89, 23);
		add(btnCheck);
		
		
		
		JLabel jlId = new JLabel("ID:");
		jlId.setBounds(253, 95, 30, 22);
		panel.add(jlId);
		jlId.setForeground(Color.GREEN);
		jlId.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		jlInfo = new JLabel("INFORMATION");
		jlInfo.setFont(new Font("Tahoma", Font.BOLD, 26));
		jlInfo.setForeground(Color.GREEN);
		jlInfo.setBounds(211, 11, 225, 22);
		panel.add(jlInfo);
		
		panel.setVisible(false);
		
		
		
	}
	public void removePanel()
	{
		panel.setVisible(false);
		tfBlock.setText("");
		tfRoom.setText("");
	}
	public void getInfo() {
		// TODO Auto-generated method stub
		try{
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldb","root","password");
			if(tfBlock.getText().equalsIgnoreCase("a")){
				ps = (PreparedStatement) conn.prepareStatement("SELECT * FROM a WHERE roomno = ?");
			}
			if(tfBlock.getText().equalsIgnoreCase("b")){
				ps = (PreparedStatement) conn.prepareStatement("SELECT * FROM b WHERE roomno = ?");
			}
			ps.setString(1,tfRoom.getText());
			result = ps.executeQuery();
			if(result.next())
			{
				if(result.getInt(5)==1)
				{	
					jlNameResult.setText(result.getString(2));
					jlIDResult.setText(result.getString(3));
					jlContactResult.setText(result.getString(4));
					panel.setVisible(true);
				}
				else{
					panel.setVisible(false);
					JOptionPane.showMessageDialog(null,"Room is not booked and available for booking");
				}
			}
			else{
				JOptionPane.showMessageDialog(null,"Invalid Room or Block");
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Network error in CheckPanel");
			JOptionPane.showMessageDialog(null,"Network Connection  Error");
		}
	}

}
