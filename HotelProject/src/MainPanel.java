import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MainPanel extends JPanel {
	
	public JButton btnBook;
	public JButton btnDebook;
	public JButton btnCheck;
	public JButton btnLogOut;
	/**
	 * Create the panel.
	 */
	public MainPanel() {
		setBackground(Color.BLACK);
		setBounds(100,100,650,500);
		setLayout(null);
		setVisible(false);
		
		btnBook = new JButton("Book");
		btnBook.setFont(new Font("Castellar", Font.BOLD, 25));
		btnBook.setForeground(new Color(0, 0, 0));
		btnBook.setBounds(71, 108, 143, 43);
		add(btnBook);
		
		btnDebook = new JButton("Debook");
		btnDebook.setFont(new Font("Castellar", Font.BOLD, 25));
		btnDebook.setForeground(new Color(0, 0, 0));
		btnDebook.setBounds(430, 108, 170, 43);
		add(btnDebook);
		
		btnCheck = new JButton("Check Details");
		btnCheck.setFont(new Font("Castellar", Font.BOLD, 25));
		btnCheck.setForeground(new Color(0, 0, 0));
		btnCheck.setBounds(184, 220, 287, 53);
		add(btnCheck);
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.setFont(new Font("Castellar", Font.BOLD, 25));
		btnLogOut.setForeground(Color.RED);
		btnLogOut.setBounds(184, 321, 287, 53);
		add(btnLogOut);
		
		JLabel jlbackground = new JLabel("New label");
		jlbackground.setBackground(Color.BLACK);
		jlbackground.setIcon(new ImageIcon("C:\\Users\\Satyam\\Desktop\\icons\\1.jpg"));
		jlbackground.setBounds(10, 0, 616, 500);
		add(jlbackground);

	}

}
