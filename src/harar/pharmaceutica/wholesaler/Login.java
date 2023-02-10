package harar.pharmaceutica.wholesaler;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.jdbc.PreparedStatement;
public class Login {

	private JFrame frame;
	private JTextField txtusername;
	private JPasswordField paslogin;
	
	
	/**
	 * Launch the application.                 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 388, 292);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(68, 48, 106, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(68, 103, 106, 31);
		frame.getContentPane().add(lblNewLabel_1);
		
		final JComboBox comstatus = new JComboBox();
		comstatus.setFont(new Font("Tahoma", Font.BOLD, 14));
		comstatus.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
			}
		});
		comstatus.setModel(new DefaultComboBoxModel(new String[] {"Admn", "User"}));
		comstatus.setBounds(181, 149, 97, 20);
		frame.getContentPane().add(comstatus);
	   
	
		
		txtusername = new JTextField();
		txtusername.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtusername.setBounds(181, 55, 138, 20);
		frame.getContentPane().add(txtusername);
		txtusername.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Status");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(68, 142, 82, 31);
		frame.getContentPane().add(lblNewLabel_2);
		          
		JButton btnlogin = new JButton("LOGIN");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(txtusername.getText().length()==0)
					JOptionPane.showMessageDialog(null, "Empty Field Detected !please fill all fields");
				else if(paslogin.getPassword().length==0)
					JOptionPane.showMessageDialog(null, "Empty Field Detected !please fill all fields");
				else if(comstatus.getSelectedItem().equals(""))
					 JOptionPane.showMessageDialog(null, "not selecte the status");
		   
					
				else {
					String user = txtusername.getText();
			  		String stat = (String) comstatus.getSelectedItem();
					
					char[] pass = paslogin.getPassword();
					String pwd = String.copyValueOf(pass);
					
					if(validate_login(user, pwd, stat)){
						if(stat=="Admn"){
							frame.dispose();
							Signup frmup = new Signup();
							frmup.setVisible(true);
							
							            
						}else if(stat =="User"){
							frame.dispose();
							MenuOfHarar mafra = new MenuOfHarar();
							mafra.setVisible(true);
						}
					}        
				    else 
					
						JOptionPane.showMessageDialog(null,"incorrect credientioal");
					
					
				}
			
				
			
				
			}
		});
		btnlogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnlogin.setBounds(68, 202, 110, 24);
		frame.getContentPane().add(btnlogin);
		
		JButton btncancel = new JButton("CANCEL");
		btncancel.setFont(new Font("Tahoma", Font.BOLD, 18));
		btncancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				System.exit(0);
			}
		});
		btncancel.setBounds(188, 203, 106, 23);
		frame.getContentPane().add(btncancel);
		
		paslogin = new JPasswordField();
		paslogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		paslogin.setBounds(181, 109, 138, 20);
		frame.getContentPane().add(paslogin);
		
		JLabel lblLogIn = new JLabel("LOG IN");
		lblLogIn.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLogIn.setBounds(142, 11, 97, 26);
		frame.getContentPane().add(lblLogIn);
	}
	
	private boolean validate_login(String username, String password, String status){
		
		 
			 
	try
	{
		Connection cont = Connect.getConnect();
		PreparedStatement pst = (PreparedStatement) cont.prepareStatement("Select * From HarardrugDatabase.login where uname= ? and password=? and status=?");
		pst.setString(1, username);
		pst.setString(2, password);
		pst.setString(3, status);
		
		ResultSet rs = pst.executeQuery();
		if(rs.next())
			return true;
		
		                        
		else
			return false;
		
		
	}
	catch(Exception e){
		e.printStackTrace();
     	return false;
	}
	
}
}