package harar.pharmaceutica.wholesaler;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import javax.swing.DefaultComboBoxModel;

import com.mysql.jdbc.PreparedStatement;
import java.awt.Color;

public class Signup {

	private JFrame frame;
	private JTextField txtuname;
	private JTextField txtpass;

	/**
	 * Launch the application.    
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup window = new Signup();
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
	public Signup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(69, 64, 111, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SIGN UP");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(148, 22, 123, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(69, 113, 111, 18);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtuname = new JTextField();
		txtuname.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtuname.setBounds(197, 71, 148, 20);
		frame.getContentPane().add(txtuname);
		txtuname.setColumns(10);
		
		txtpass = new JTextField();
		txtpass.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtpass.setBounds(197, 111, 148, 20);
		frame.getContentPane().add(txtpass);
		txtpass.setColumns(10);
		
		final JComboBox combstatus = new JComboBox();
		combstatus.setFont(new Font("Tahoma", Font.BOLD, 14));
		combstatus.setModel(new DefaultComboBoxModel(new String[] {"Admn", "User"}));
		combstatus.setBounds(197, 142, 86, 26);
		frame.getContentPane().add(combstatus);
		
		JButton btnsignup = new JButton("SIGN UP");
		btnsignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtuname.getText().length()==0)
					JOptionPane.showMessageDialog(null, "User name is empty");
				else if(txtpass.getText().length()==0)
					JOptionPane.showMessageDialog(null, "password is empty");
				else
				{
					String user = txtuname.getText();
					String stat = (String) combstatus.getSelectedItem();
					
					String pass = txtpass.getText();
					
					validate_logup(user,pass,stat);
				}
			}
		});
		btnsignup.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnsignup.setBounds(126, 200, 111, 33);
		frame.getContentPane().add(btnsignup);
		
		JButton btncancel = new JButton("CANCEL");
		btncancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btncancel.setFont(new Font("Tahoma", Font.BOLD, 18));
		btncancel.setBounds(268, 200, 111, 33);
		frame.getContentPane().add(btncancel);
		
		
		
		JLabel lblNewLabel_3 = new JLabel("Status");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(69, 141, 95, 26);
		frame.getContentPane().add(lblNewLabel_3);
	}

	private void validate_logup(String username, String password, String status){
		
		 
		 
		try
		{      
			Connection cont = Connect.getConnect();
			PreparedStatement pst = (PreparedStatement) cont.prepareStatement("INSERT INTO HarardrugDatabase.login(uname, password, status) VALUES(?,?,?)");
			pst.setString(1, username);
			pst.setString(2, password);
			pst.setString(3, status);
			
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "User created");
			
			
		}
		catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error to create user");
			
		}
		
	}

	public void setVisible(boolean b) {
	      frame.setVisible(b);
		// TODO Auto-generated method stub
		
	}

	
}
