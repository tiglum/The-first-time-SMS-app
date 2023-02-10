package harar.pharmaceutica.wholesaler;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
   
import com.mysql.jdbc.PreparedStatement;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Contact {

	private JFrame frame11;
	private JTextField txtcity;
	private JTextField txtmobile;
	//private JComboBox cmborganization;
	//private JComboBox cmbcustomer;
	 private JComboBox cmbtypeoforg;
	 private JTextField txtorganization;
	 private JTextField txtownername;
	 private JComboBox cmbreligion;
	   
	/**
	 * Launch the application.                                
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Contact window = new Contact();
					window.frame11.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
public void fillcombobox()
{                        
	
	try                                                        
	{
		Connection cont = Connect.getConnect();
		PreparedStatement pst = (PreparedStatement) cont.prepareStatement("Select * From harardrugdatabase.ozekimessagein");
		
		
		ResultSet rs = pst.executeQuery();
		//if(rs.next())
			//return true;
		while(rs.next())                                 
		{
		cmbtypeoforg.addItem(rs.getString("msg"));
			//String c = rs.getString("customerName");
			//cmb.addItem(c);
		}
		                    
		//rs.close();
		//cont.close();
		
	}                  
	catch(Exception e){
		e.printStackTrace();
     	//return false;
	}
	                  
}
	/**
	 * Create the application.
	 */
	public Contact() {
		initialize();
		 //fillcombobox();
		
	}       

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame11 = new JFrame();
		frame11.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame11.setBounds(100, 100, 407, 361);
		frame11.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame11.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Address");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(99, 22, 168, 31);
		frame11.getContentPane().add(lblNewLabel);
		
	                 
		JLabel lblOrganization = new JLabel("Organization Name");
		lblOrganization.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOrganization.setBounds(47, 79, 143, 20);
		frame11.getContentPane().add(lblOrganization);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCity.setBounds(47, 110, 46, 14);
		frame11.getContentPane().add(lblCity);
		
		txtcity = new JTextField();
		txtcity.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtcity.setBounds(198, 108, 138, 20);
		frame11.getContentPane().add(txtcity);
		txtcity.setColumns(10);
		
		JLabel lblWebsite = new JLabel("Mobile Number");                 
		lblWebsite.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWebsite.setBounds(46, 146, 110, 14);
		frame11.getContentPane().add(lblWebsite);
		
		txtmobile = new JTextField();
		txtmobile.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtmobile.setText("+251");
		txtmobile.setBounds(198, 140, 138, 20);
		frame11.getContentPane().add(txtmobile);
		txtmobile.setColumns(10);
		
		JLabel lblReligion = new JLabel("Religion");
		lblReligion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblReligion.setBounds(47, 213, 65, 14);
		frame11.getContentPane().add(lblReligion);
		
		cmbreligion = new JComboBox();
		cmbreligion.setFont(new Font("Tahoma", Font.BOLD, 12));
		cmbreligion.setModel(new DefaultComboBoxModel(new String[] {"", "Muslim", "Christian"}));
		cmbreligion.setBounds(198, 211, 69, 20);
		frame11.getContentPane().add(cmbreligion);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtorganization.getText().length()==0)
					JOptionPane.showMessageDialog(null, "Name of organization is  empty");
				else if(txtcity.getText().length()==0)
					JOptionPane.showMessageDialog(null, "city name is empty is empty");
				else if(txtownername.getText().length()==0)
					JOptionPane.showMessageDialog(null, "owner name is empty is empty");
				else if(cmbtypeoforg.getSelectedItem().equals(0))
					JOptionPane.showMessageDialog(null, "Type of organization  not selected");
				else if(cmbreligion.getSelectedItem().equals(0))
					JOptionPane.showMessageDialog(null, "religion not selected");
				else if(txtmobile.getText().length()==0)
					JOptionPane.showMessageDialog(null, "mobile number is empty");
				else if(txtmobile.getText().length()!= 13)
					JOptionPane.showMessageDialog(null, "mobile number is not 13 figure");
					
					
				
				else
				{
					
					String orgname = txtorganization.getText();         
				 	String city = txtcity.getText();
					String typeoforg = (String) cmbtypeoforg.getSelectedItem();
					String mobile = txtmobile.getText();
					String ownername = txtownername.getText();
					String religion = (String) cmbreligion.getSelectedItem();
					
						
				
				
				try
				{
				
					Connection cont = Connect.getConnect();
					PreparedStatement pst = (PreparedStatement) cont.prepareStatement("INSERT INTO HarardrugDatabase.customer(customerName, city, typeofOrganization, religion, mobileNumber, ownerName) VALUES(?,?,?,?,?,?)");
					pst.setString(1, orgname);
					pst.setString(2, city);
					pst.setString(3, typeoforg);
					pst.setString(4, religion);
					pst.setString(5, mobile);
					pst.setString(6, ownername);
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Customer data inserted");
					txtorganization.setText("");
					txtcity.setText("");
					txtmobile.setText("");
					txtownername.setText("");
					cmbreligion.setSelectedItem("");
					cmbtypeoforg.setSelectedItem("");
					
					
					
				}
				catch(Exception e){
				
					JOptionPane.showMessageDialog(null, "Error to create customer"+e);
					
				}
				
			}}
		});
		
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(60, 288, 101, 23);
		frame11.getContentPane().add(btnNewButton);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//System.exit(0);
		         frame11.dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancel.setBounds(178, 288, 110, 23);
		frame11.getContentPane().add(btnCancel);
		
		//JComboBox cmbcustomer = new JComboBox();
	    cmbtypeoforg = new JComboBox();
	    cmbtypeoforg.setFont(new Font("Tahoma", Font.BOLD, 12));
	    cmbtypeoforg.setModel(new DefaultComboBoxModel(new String[] {"", "Hospital", "Clinics", "Pharmacy", "Drug shope", "Drug vendor", "Others"}));
		cmbtypeoforg.setBounds(198, 245, 138, 20);
		frame11.getContentPane().add(cmbtypeoforg);
		
		JLabel label = new JLabel("Type Of Organization");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(47, 247, 154, 14);
		frame11.getContentPane().add(label);
		
		txtorganization = new JTextField();
		txtorganization.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtorganization.setColumns(10);
		txtorganization.setBounds(199, 80, 137, 20);
		frame11.getContentPane().add(txtorganization);
		
		JLabel lblNewLabel_1 = new JLabel("Owner Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(47, 182, 109, 20);
		frame11.getContentPane().add(lblNewLabel_1);
		
		txtownername = new JTextField();
		txtownername.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtownername.setBounds(198, 180, 138, 20);
		frame11.getContentPane().add(txtownername);
		txtownername.setColumns(10);
		fillcombobox();

		
		
		
		
	}
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
		frame11.setVisible(b);
	}
}
