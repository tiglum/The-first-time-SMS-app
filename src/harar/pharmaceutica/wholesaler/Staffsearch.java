package harar.pharmaceutica.wholesaler;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Staffsearch {

	private JFrame frame;
	private JTextField txtid;
	private JTextField txtsex;
	private JTextField txtmobile;
	private JTextField txtareaofwork;
	private JComboBox cmbname;
	Connection con;
    Statement pst;                   
	ResultSet rs;

	/**
	 * Launch the application.
	 */
	public void fillproductcombobox()
	{
		//JComboBox cmb = cmborganization;     
		
		try
		{
			Connection cont = Connect.getConnect();
			PreparedStatement pst = (PreparedStatement) cont.prepareStatement("Select * From HarardrugDatabase.staffaddress");
			
			
			ResultSet rs = pst.executeQuery();
			//if(rs.next())
				//return true;
			while(rs.next())
			{
				cmbname.addItem(rs.getString("staffName"));
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
	    		String url = "jdbc:mysql://localhost:3306/HarardrugDatabase";
				 String username= "root";
				 String password = "root";
				 DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				 con = DriverManager.getConnection(url, username, password);
				pst = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				String sql = "select * from HarardrugDatabase.staffaddress";
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
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {        
			public void run() {
				try {
					Staffsearch window = new Staffsearch();
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
	public Staffsearch() {
		initialize();
		
		
	
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 386, 323);
		//MenuOfHarar mh =new MenuOfHarar();
	     // mh.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().setLayout(null);
		
		JLabel lblStaffSearch = new JLabel("STAFF SEARCH");
		lblStaffSearch.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblStaffSearch.setBounds(104, 34, 153, 14);
		frame.getContentPane().add(lblStaffSearch);
		
		JLabel lblId = new JLabel("ID");            
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblId.setBounds(39, 74, 46, 14);
		frame.getContentPane().add(lblId);
		
		txtid = new JTextField();
		txtid.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtid.setBounds(141, 72, 133, 20);
		frame.getContentPane().add(txtid);
		txtid.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(39, 109, 46, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblSex = new JLabel("Sex");
		lblSex.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSex.setBounds(39, 139, 46, 14);
		frame.getContentPane().add(lblSex);
		
		txtsex = new JTextField();
		txtsex.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtsex.setBounds(141, 137, 68, 20);
		frame.getContentPane().add(txtsex);
		txtsex.setColumns(10);
		
		JLabel lblMobile = new JLabel("Mobile ");
		lblMobile.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMobile.setBounds(39, 177, 92, 14);
		frame.getContentPane().add(lblMobile);
		
		txtmobile = new JTextField();
		txtmobile.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtmobile.setBounds(141, 168, 111, 20);
		frame.getContentPane().add(txtmobile);
		txtmobile.setColumns(10);
		
		JLabel lblAreaOfWork = new JLabel("Area of Work");
		lblAreaOfWork.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAreaOfWork.setBounds(39, 204, 100, 14);
		frame.getContentPane().add(lblAreaOfWork);
		
		txtareaofwork = new JTextField();
		txtareaofwork.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtareaofwork.setBounds(141, 199, 117, 20);
		frame.getContentPane().add(txtareaofwork);
		txtareaofwork.setColumns(10);
		
		cmbname = new JComboBox();
		cmbname.setFont(new Font("Tahoma", Font.BOLD, 12));
		cmbname.setBounds(141, 107, 133, 20);
		fillproductcombobox(); 
		frame.getContentPane().add(cmbname);
		
		JButton btnsearch = new JButton("SEARCH");
		btnsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(cmbname.getSelectedItem().equals(""))
					JOptionPane.showMessageDialog(null, "Staff name not selected");
				else{
					String orgname= (String) cmbname.getSelectedItem();
				                 
					try
					{
						Connection cont = Connect.getConnect();
						PreparedStatement pst = (PreparedStatement) cont.prepareStatement("Select * From HarardrugDatabase.staffaddress where staffName=?");
						pst.setString(1, orgname);
						
						rs = pst.executeQuery();
					    while(rs.next()){
					    String idst= rs.getString("staffId");
						//int id =rs.getInt("idsta");
						//String idstr = Integer.toString(id);
				//String customer = rs.getString("customerName");
			            String sex =rs.getString("staffSex");             
						String mobil = rs.getString("stafmobileNumber");
						//String religion = rs.getString("religion");
				//String allowedcredit = rs.getString("allowedTotalCredit");
						String typeoforg = rs.getString("staffAreaofWork");
						//String mobile = rs.getString("mobileNumber");

						txtid.setText(idst);
						
						//txt.setText(customer);
						txtsex.setText(sex);
						//txtmoblie.setText(owner);
					//txtreligion.setText(religion);
				 //  txttotalcredit.setText(allowedcredit);
						txtareaofwork.setText(typeoforg);
						txtmobile.setText(mobil);
					    }
			}
			catch(SQLException ex){
			      JOptionPane.showMessageDialog(null, "Unable to get the data"+ ex);
			}
		}
			}
		});
		btnsearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnsearch.setBounds(28, 240, 100, 23);
		frame.getContentPane().add(btnsearch);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ID= txtid.getText();
				String staffomer = (String) cmbname.getSelectedItem();
				String mobile=  txtmobile.getText();
				String sex= txtsex.getText();
				String aow = txtareaofwork.getText();
				
				//String licence=   txtreligion.getText();
				//String credit = txttotalcredit.getText();
				//String typeorg =   txttypeoforganization.getText();
				int nid = Integer.parseInt(ID);
					try {
						rs.updateInt("staffId", nid);
						rs.updateString("staffName", staffomer);
						rs.updateString("stafmobileNumber", mobile);
						rs.updateString("sex", sex);
						//rs.updateString("ownerName", owner);
						//rs.updateString("licenceNumber", licence);
						//rs.updateString("allowedTotalCredit", credit);
						rs.updateString("staffAreaOfWork", aow);
						
					JOptionPane.showMessageDialog(null, "the data become updated");
							
					}
					catch(SQLException ex)
					{
						JOptionPane.showMessageDialog(null, "unable to update"+ex);
					}
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(141, 240, 108, 23);
		frame.getContentPane().add(btnUpdate);
		
		JButton btncancel = new JButton("CANCEL");
		btncancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btncancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btncancel.setBounds(259, 240, 101, 23);
		frame.getContentPane().add(btncancel);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(b);
		
	}
}
