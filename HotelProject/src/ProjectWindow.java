import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class ProjectWindow {

	private JFrame frame;
	static WlcmPanel wlcmPanel;
	static ProjectWindow window;
	static LoginPanel lp;
	static BookingPanel bp;
	static MainPanel mp;
	static DeBookPanel dp;
	static CheckPanel cp;
	/**
	 * Launch the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new ProjectWindow();
					window.frame.setVisible(true);
					window.frame.setBounds(100,100,650,500);
					wlcmPanel = new WlcmPanel();
					window.frame.add(wlcmPanel);
					wlcmPanel.thanks.addActionListener(new ActionListener() {
										@Override
										public void actionPerformed(ActionEvent ae) {							
													openLogin();
												}
										});
										lp = new LoginPanel();
										mp = new MainPanel();
										bp = new BookingPanel();
										dp = new DeBookPanel();
										cp = new CheckPanel();
										lp.btnLogin.addActionListener(new ActionListener(){

											@Override
											public void actionPerformed(ActionEvent arg0) {
												boolean loginSuccesful = lp.checkLogin();
												if(loginSuccesful == true){
													
													openMainPanel();
												}
												else{
													lp.cancelAction();
													Toolkit.getDefaultToolkit().beep();
													JOptionPane.showMessageDialog(lp,"Invalid Username or Password");
												}
											}
										});
										lp.btnCancel.addActionListener(new ActionListener(){

											@Override
											public void actionPerformed(
													ActionEvent arg0) {
												// TODO Auto-generated method stub
												lp.cancelAction();
											}
											
										});
										mp.btnBook.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent arg0) {
												openBookingPanel();
											}

											
										});
										mp.btnDebook.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent arg0) {
												openDeBookPanel();
											}

											
										});
										mp.btnCheck.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent arg0) {
												openCheckPanel();
											}

											
										});
										
										bp.cbRoomAvailable.addItemListener(new ItemListener()
										{

											@Override
											public void itemStateChanged(
													ItemEvent arg0) {
												bp.initialise();
												boolean available = bp.checkAvailability();
												if(available==false)
												{
													
													bp.btnOk.setVisible(true);
													bp.btnOk.setText("UPDATE");
													showBooked();
													
												}
													
												else
												{
													bp.btnOk.setVisible(true);
													bp.btnOk.setText("BOOK");
												}
											}
											
										});
										bp.btnOk.addActionListener(new ActionListener(){

											@Override
											public void actionPerformed(
													ActionEvent arg0) {
												if(bp.checkFields()==true)
												{
													bp.insertData();
												}
											}
											
										});
										bp.btnGoBack.addActionListener(new ActionListener(){

											@Override
											public void actionPerformed(
													ActionEvent arg0) {
												openMainPanelFrom();
												bp.setVisible(false);
											}
											
										});
										dp.btnOk.addActionListener(new ActionListener(){

											@Override
											public void actionPerformed(
													ActionEvent arg0) {
												dp.deleteData();
											}
											
										});
										dp.btnGoBack.addActionListener(new ActionListener(){

											@Override
											public void actionPerformed(
													ActionEvent arg0) {
												openMainPanelFrom();
												dp.setVisible(false);
											}
											
										});
										mp.btnLogOut.addActionListener(new ActionListener(){

											@Override
											public void actionPerformed(
													ActionEvent arg0) {
												openLoginPanelFrom();
												mp.setVisible(false);
											}
											
										});
										cp.btnOk.addActionListener(new ActionListener(){

											@Override
											public void actionPerformed(
													ActionEvent arg0) {
												openMainPanelFrom();
												cp.removePanel();
												cp.setVisible(false);
											}
											
										});
										
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
	}
	private static void showBooked(){
		JOptionPane.showMessageDialog(bp,"Sorry ,Room is already BOOKED");
	}
	private static void openBookingPanel() {
		// TODO Auto-generated method stub
		
		window.frame.add(bp);
		bp.btnOk.setVisible(false);
		bp.cbRoomAvailable.setSelectedIndex(0);
		bp.initialise();
		bp.setVisible(true);
		mp.setVisible(false);
	}
	private static void openDeBookPanel() {
		// TODO Auto-generated method stub
		
		window.frame.add(dp);
		dp.tfBlock.setText("");
		dp.tfRoomno.setText("");
		dp.setVisible(true);
		mp.setVisible(false);
	}
	private static void openCheckPanel() {
		// TODO Auto-generated method stub

		window.frame.add(cp);
		cp.setVisible(true);
		mp.setVisible(false);
	}
	private static void openMainPanel() {
		
		window.frame.add(mp);
		mp.setVisible(true);
		lp.setVisible(false);
	}
	private static void openLoginPanelFrom() {
		lp.setVisible(true);
		}
	private static void openMainPanelFrom() {
		mp.setVisible(true);
		}

	public static void openLogin(){
		
		window.frame.add(lp);
		lp.setVisible(true);
		wlcmPanel.setVisible(false);
		
	}

	/**
	 * Create the application.
	 */
	public ProjectWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void windowOpened(WindowEvent e)
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
