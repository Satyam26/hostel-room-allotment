import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;


public class WlcmPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public JButton thanks;
	public WlcmPanel() {
		setBackground(Color.DARK_GRAY);
		setBounds(100,100,650,500);
		setLayout(null);
		
		JLabel jlWelcomemsg = new JLabel("   Welcome to Hotel Management Project");
		jlWelcomemsg.setForeground(Color.CYAN);
		jlWelcomemsg.setFont(new Font("Tahoma", Font.BOLD, 28));
		jlWelcomemsg.setBounds(10, 11, 579, 68);
		add(jlWelcomemsg);
		
		JLabel jlIcon = new JLabel("New label");
		jlIcon.setIcon(new ImageIcon("C:\\Users\\Satyam\\Pictures\\Hotel3.png"));// forHalchal - yahan kisi hostel ke pic ka location daal dena
		jlIcon.setBounds(93, 113, 463, 269);
		add(jlIcon);
		
		thanks = new JButton("Welcome");
		thanks.setBounds(122, 400, 422, 33);
		thanks.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(thanks);
		
		JLabel jlnames = new JLabel("By SATYAM GAURAV (14BCS046) and  CHITRANSHU YADAV(14BCS015)");
		jlnames.setFont(new Font("Tahoma", Font.BOLD, 16));
		jlnames.setForeground(new Color(124, 252, 0));
		jlnames.setBounds(31, 427, 609, 33);
		add(jlnames);

	}
	

}
