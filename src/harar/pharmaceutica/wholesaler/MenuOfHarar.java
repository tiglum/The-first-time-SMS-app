package harar.pharmaceutica.wholesaler;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;                  
import java.awt.event.ActionListener;          
import java.awt.event.ActionEvent;

public class MenuOfHarar {                                

	private JFrame frame;                       
                                                                                         
	/**
	 * Launch the application.        
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {                                           
				try {                          
					MenuOfHarar window = new MenuOfHarar();
					window.frame.setVisible(true);
					//window.frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}      
			}
		});             
	}

	/**           
	 * Create the application.
	 */
	public MenuOfHarar() {
		//frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 420, 269);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");                   
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(0, 0, 401, 108);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("WHOLESALE P.L.C");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(129, 157, 195, 28);
		frame.getContentPane().add(lblNewLabel_1);
		                      
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Tiglu\\workspace\\hararpharma1\\src\\20160218090109.jpg"));
		lblNewLabel_2.setBounds(35, 156, 366, 28);  
		frame.getContentPane().add(lblNewLabel_2);
		            
		JLabel lblNewLabel_3 = new JLabel("HARAR PHARMA/MED/SUP/EQUIP/");          
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_3.setBounds(66, 115, 347, 41);
		frame.getContentPane().add(lblNewLabel_3);
		                       
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnCustomer = new JMenu("REGISTRATION");
		mnCustomer.setForeground(Color.BLACK);
		mnCustomer.setFont(new Font("Times New Roman", Font.BOLD, 12));
		menuBar.add(mnCustomer);        
		
		JMenuItem mntmCustomer = new JMenuItem("Customer");
		mntmCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Contact custcont = new Contact();
				custcont.setVisible(true);
			}
		});                 
		mnCustomer.add(mntmCustomer);
		
		JMenuItem mntmStaff = new JMenuItem("Staff");
		mntmStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Staff sta = new Staff();
				sta.setVisible(true);
			}
		});
		mnCustomer.add(mntmStaff);
		
		JMenu mnNewMenu_3 = new JMenu("Search");
		mnCustomer.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Customer");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CustomerInfoSearch custsearch = new CustomerInfoSearch();
				custsearch.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Staff");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Staffsearch stafsea = new  Staffsearch();
				         stafsea.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu = new JMenu("MESSAGE");
		mnNewMenu.setForeground(Color.BLACK);
		mnNewMenu.setFont(new Font("Times New Roman", Font.BOLD, 12));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmIndividual = new JMenuItem("Individual");
		mntmIndividual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Individualsms isms = new Individualsms();
				    isms.setVisible(true);
			}
		});
		mnNewMenu.add(mntmIndividual);
		
		JMenuItem mntmAll = new JMenuItem("All");
		mntmAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Allsms allsms = new Allsms();
				allsms.setVisible(true);
			}
		});
		mnNewMenu.add(mntmAll);
		
		JMenuItem mntmPharmacy = new JMenuItem("Pharmacy");
		mntmPharmacy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pharmasms phsms = new Pharmasms();
				phsms.setVisibile(true);
			}
		});
		mnNewMenu.add(mntmPharmacy);
		
		JMenuItem mntmDrugShop = new JMenuItem("Drug Shop");
		mntmDrugShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Drugshopsms dssms = new Drugshopsms();
				dssms.setVesibile(true);
			}
		});
		mnNewMenu.add(mntmDrugShop);
		
		JMenuItem mntmClinics = new JMenuItem("Clinics");
		mntmClinics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Clinicsms cl = new Clinicsms();
				cl.setVisible(true);
			}
		});
		mnNewMenu.add(mntmClinics);
		
		JMenuItem mntmDrugVendor = new JMenuItem("Drug Vendor");
		mntmDrugVendor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Drugvendorsms drvsms = new Drugvendorsms();
				drvsms.setVisible(true);
			}
		});
		mnNewMenu.add(mntmDrugVendor);
		
		JMenuItem mntmMuslims = new JMenuItem("Muslims");
		mntmMuslims.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Muslimsms msms = new Muslimsms();
				msms.setVisible(true);
			}
		});
		mnNewMenu.add(mntmMuslims);
		
		JMenuItem mntmChristians = new JMenuItem("Christians");
		mntmChristians.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Christiansms chsms = new Christiansms();
				chsms.setVisibile(true);
			}         
		});
		mnNewMenu.add(mntmChristians);
		
		JMenuItem mntmHospitals = new JMenuItem("Hospitals");
		mntmHospitals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Hospitalsms hsms = new Hospitalsms();
				hsms.setVisible(true);
			}
		});
		mnNewMenu.add(mntmHospitals);
		
		JMenuItem mntmOthers = new JMenuItem("Others");
		mntmOthers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Othersms osms = new Othersms();
				osms.setVisible(true);
			}
		});
		mnNewMenu.add(mntmOthers);
		
		JMenu mnStaffs = new JMenu("Staffs");
		mnNewMenu.add(mnStaffs);
		
		JMenuItem mntmAll_1 = new JMenuItem("All");
		mntmAll_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Staffsms stasms = new Staffsms();
				stasms.setVisible(true);
			}
		});
		mnStaffs.add(mntmAll_1);
		                       
		JMenuItem mntmMuslims_1 = new JMenuItem("Muslims");
		mntmMuslims_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Muslimstaffsms mss = new Muslimstaffsms();
				mss.setVisible(true);
				
			}
		});
		mnStaffs.add(mntmMuslims_1);
		
		JMenuItem mntmChristians_1 = new JMenuItem("Christians");
		mntmChristians_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Christianstaffsms chsta = new Christianstaffsms();
				chsta.setVisible(true);
			}
		});
		mnStaffs.add(mntmChristians_1);
		
		JMenu mnNewMenu_1 = new JMenu("INCOMING SMS");
		mnNewMenu_1.setForeground(Color.BLACK);
		mnNewMenu_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmDeliveredSms = new JMenuItem("Delivered SMS");
		mntmDeliveredSms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Inboxsms indsms = new Inboxsms();
				indsms.setVisible(true);
				 
			}            
		});
		mnNewMenu_1.add(mntmDeliveredSms);
		
		JMenu mnNewMenu_2 = new JMenu("");
		menuBar.add(mnNewMenu_2);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(b);
		
	}
}
