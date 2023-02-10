package harar.pharmaceutica.wholesaler;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;

public class CustomerInfoSearch {

	private JFrame frame;
	private JTextField txtownername;
	private JTextField txtreligion;
	private JTextField txttypeoforganization;
	Connection con;
    Statement pst;                   
	ResultSet rs;
	private JTextField txtid;
    private JComboBox cmborgname;
    private JTextField txtmobile;
    private JTextField txtcity;
/**
 * Launch the application.
 */
	public void fillproductcombobox()
	{
		//JComboBox cmb = cmborganization;     
		
		try
		{
			Connection cont = Connect.getConnect();
			PreparedStatement pst = (PreparedStatement) cont.prepareStatement("Select * From HarardrugDatabase.customer");
			
			
			ResultSet rs = pst.executeQuery();
			//if(rs.next())
				//return true;
			while(rs.next())
			{
				cmborgname.addItem(rs.getString("customerName"));
				//String c = rs.getString("customerName");
				//cmb.addItem(c);
			}
			                    
			
			//else
			//{                      
				
		                            
				//return false;
			
			//}
		}
		catch(Exception e){
			e.printStackTrace();
	     	//return false;
		}
		                  
	}
	
	 public void DoConnect()
	    {
	    	try
			{
	    		String url = "jdbc:mysql://localhost:3306/drugDatabase";
				 String username= "root";
				 String password = "root";
				 DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				 con = DriverManager.getConnection(url, username, password);
				pst = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				String sql = "select * from HarardrugDatabase.customer";
				 rs = pst.executeQuery(sql);
				//if(rs.next())
					//return true;
				// DisplayResult(rs);
				// update();
				   rs.next();
				
				//	int id =rs.getInt("id");
					//String idstr = Integer.toString(id);
					//String customer = rs.getString("customerName");
					//String tinnumber =rs.getString("tinNumber");
					//String owner = rs.getString("ownerName");
					//String licence = rs.getString("licenceNumber");
					//String allowedcredit = rs.getString("allowedTotalCredit");
				//	String typeoforg = rs.getString("typeofOrganization");
					//extracted(txtamsg).setText(msg1);
					//txttime.setText(receivetime);
				   
					//rs.close();
					//cmb.addItem(c);
				}
				
				
				//else
				//{
					
			
					//return false;
				
				//}
			
			catch(Exception e){
				e.printStackTrace();
		     	//return false;
			}
	    }
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerInfoSearch window = new CustomerInfoSearch();
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
	public CustomerInfoSearch() {
		initialize();
		DoConnect();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 39, 407, 353);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCustomerSearch = new JLabel("CUSTOMER SEARCH");
		lblCustomerSearch.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblCustomerSearch.setBounds(80, 22, 224, 14);
		frame.getContentPane().add(lblCustomerSearch);
		
		JLabel lblNewLabel = new JLabel("Organization Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(20, 85, 152, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblOwnerName = new JLabel("Owner Name");
		lblOwnerName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOwnerName.setBounds(20, 113, 99, 14);
		frame.getContentPane().add(lblOwnerName);
		
		txtownername = new JTextField();
		txtownername.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtownername.setBounds(202, 107, 179, 20);
		frame.getContentPane().add(txtownername);
		txtownername.setColumns(10);
		
		JLabel lblLicenceNumber = new JLabel("Religion");
		lblLicenceNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLicenceNumber.setBounds(20, 169, 112, 14);
		frame.getContentPane().add(lblLicenceNumber);
		
		txtreligion = new JTextField();
		txtreligion.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtreligion.setBounds(199, 163, 179, 20);
		frame.getContentPane().add(txtreligion);
		txtreligion.setColumns(10);
		
		JLabel lblTypeOfOrganization = new JLabel("Type Of Organization");
		lblTypeOfOrganization.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTypeOfOrganization.setBounds(20, 194, 170, 14);
		frame.getContentPane().add(lblTypeOfOrganization);
		
		txttypeoforganization = new JTextField();
		txttypeoforganization.setFont(new Font("Tahoma", Font.BOLD, 12));
		txttypeoforganization.setBounds(200, 188, 178, 20);
		frame.getContentPane().add(txttypeoforganization);
		txttypeoforganization.setColumns(10);
		
		JButton btnsearch = new JButton("SEARCH");
		btnsearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
					if(cmborgname.getSelectedItem().equals(""))
						JOptionPane.showMessageDialog(null, "customer name not selected");
					else{
						String orgname= (String) cmborgname.getSelectedItem();
					
						try
						{
							Connection cont = Connect.getConnect();
							PreparedStatement pst = (PreparedStatement) cont.prepareStatement("Select * From HarardrugDatabase.customer where customerName=?");
							pst.setString(1, orgname);
							
							rs = pst.executeQuery();
						    while(rs.next()){
							int id =rs.getInt("id");
							String idstr = Integer.toString(id);
					//String customer = rs.getString("customerName");
				          String city =rs.getString("city");             
							String owner = rs.getString("ownerName");
							String religion = rs.getString("religion");
					//String allowedcredit = rs.getString("allowedTotalCredit");
							String typeoforg = rs.getString("typeofOrganization");
							String mobile = rs.getString("mobileNumber");
	
							txtid.setText(idstr);
					 // txtcustomername.setText(customer);
							txtcity.setText(city);
							txtownername.setText(owner);
							txtreligion.setText(religion);
					 //  txttotalcredit.setText(allowedcredit);
							txttypeoforganization.setText(typeoforg);
							txtmobile.setText(mobile);
						    }
				}
				catch(SQLException ex){
				      JOptionPane.showMessageDialog(null, "Unable to get the data"+ ex);
				}
			}
					}
					
			
		});
		btnsearch.setBounds(44, 246, 112, 23);
		frame.getContentPane().add(btnsearch);
		
		JButton btndelet = new JButton("DELETE");
		btndelet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				      //rs.deleteRow();
				      //pst.close();
				      //rs.close();
				      pst = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				      String SQL = "delete from HarardrugDatabase.customer where id="+txtid.getText();
				      
				      pst.executeUpdate(SQL);
				      JOptionPane.showMessageDialog(null, "Recored Deleted");
				                                  
				      ((ResultSet) pst).next();
				      
				      int id =((ResultSet) pst).getInt("id");
						String idstr = Integer.toString(id);
				//String customer = rs.getString("customerName");
			          String city =((ResultSet) pst).getString("city");
						String owner = ((ResultSet) pst).getString("ownerName");
						String religion = ((ResultSet) pst).getString("religion");
				//String allowedcredit = rs.getString("allowedTotalCredit");
						String typeoforg = ((ResultSet) pst).getString("typeofOrganization");
						String mobile = ((ResultSet) pst).getString("mobileNumber");

						txtid.setText(idstr);
				 // txtcustomername.setText(customer);
				       txtcity.setText(city);
						txtownername.setText(owner);
						txtreligion.setText(religion);
				 //  txttotalcredit.setText(allowedcredit);
						txttypeoforganization.setText(typeoforg);
						txtmobile.setText(mobile);
						
				    	  
				      
					}catch(SQLException e)
					{
						JOptionPane.showMessageDialog(null,e.getMessage());
						}
			}
				
			
		});
		btndelet.setFont(new Font("Tahoma", Font.BOLD, 14));
		btndelet.setBounds(239, 246, 99, 23);
		frame.getContentPane().add(btndelet);
		
		JButton btnupdate = new JButton("UPDATE");
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String ID= txtid.getText();
			String customer = (String) cmborgname.getSelectedItem();
			String mobile=  txtmobile.getText();
			String owner= txtownername.getText();
			String city = txtcity.getText();
			
			String licence=   txtreligion.getText();
			//String credit = txttotalcredit.getText();
			String typeorg =   txttypeoforganization.getText();
			int nid = Integer.parseInt(ID);
				try {
					rs.updateInt("id", nid);
					rs.updateString("customerName", customer);
					rs.updateString("mobileNumber", mobile);
					rs.updateString("city", city);
					rs.updateString("ownerName", owner);
					rs.updateString("licenceNumber", licence);
					//rs.updateString("allowedTotalCredit", credit);
					rs.updateString("typeofOrganization", typeorg);
					
				JOptionPane.showMessageDialog(null, "the data become updated");
						
				}
				catch(SQLException ex)
				{
					JOptionPane.showMessageDialog(null, "unable to update"+ex);
				}
			}
		});
		btnupdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnupdate.setBounds(44, 280, 112, 23);
		frame.getContentPane().add(btnupdate);
		
		JButton btncancel = new JButton("CANCEL");
		btncancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btncancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btncancel.setBounds(239, 280, 99, 23);
		frame.getContentPane().add(btncancel);
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblId.setBounds(25, 56, 58, 14);
		frame.getContentPane().add(lblId);
		
		txtid = new JTextField();
		txtid.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtid.setBounds(204, 54, 86, 20);
		frame.getContentPane().add(txtid);
		txtid.setColumns(10);
		
		cmborgname = new JComboBox();
		cmborgname.setEditable(true);
		cmborgname.setModel(new DefaultComboBoxModel(new String[] {""}));
		cmborgname.setFont(new Font("Tahoma", Font.BOLD, 12));
		cmborgname.setBounds(202, 78, 179, 20);
		fillproductcombobox();
		frame.getContentPane().add(cmborgname);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number");
		lblMobileNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMobileNumber.setBounds(20, 218, 146, 14);
		frame.getContentPane().add(lblMobileNumber);
		
		txtmobile = new JTextField();
		txtmobile.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtmobile.setBounds(199, 215, 179, 20);
		frame.getContentPane().add(txtmobile);
		txtmobile.setColumns(10);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCity.setBounds(20, 138, 99, 14);
		frame.getContentPane().add(lblCity);
		
		txtcity = new JTextField();
		txtcity.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtcity.setBounds(202, 138, 179, 20);
		frame.getContentPane().add(txtcity);
		txtcity.setColumns(10);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(b);
		
	}
}
