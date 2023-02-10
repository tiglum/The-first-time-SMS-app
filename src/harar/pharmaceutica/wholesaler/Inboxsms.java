package harar.pharmaceutica.wholesaler;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import com.mysql.jdbc.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class Inboxsms {

	private JFrame frame;
	private JTextField txtid;                    
	private JTextField txtmob;
	private JTextField txttime;
	private JTextArea txtasms;
	private JButton btnFirst;             
	private JButton btnNext;
	private JButton btnPrevious;
	private JButton btnlast;
	 Connection con;
	    Statement pst;                          
		ResultSet rs;                       
		private JLabel lblNewLabel_1;
		private JTextField txtcustomer;
	    
	/**
	 * Launch the application.
	 */
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
					String sql = "select id, customerName, sender, msg, receivedtime from HarardrugDatabase.ozekimessagein, HarardrugDatabase.customer";
					 rs = pst.executeQuery(sql);
					//if(rs.next())
						//return true;
					// DisplayResult(rs);
					// update();
					   rs.next();
					
						int id =rs.getInt("id");
						String idstr = Integer.toString(id);
						String sendermob = rs.getString("sender");
						String customer = rs.getString("customerName");
						String msg1 =rs.getString("msg");
					
						String receivetime = rs.getString("receivedtime");
						
						
						txtid.setText(idstr);
						txtmob.setText(sendermob);
						txtcustomer.setText(customer);
						 txtasms.setText(msg1);
						//JTextArea txtamsg2 = extracted(txtamsg);
						//extracted(txtamsg).setText(msg1);
						txttime.setText(receivetime);
					   
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
		 
		 public void Conclose()               
		 {
			 try
			 {   
				 rs.close();
				 con.close();
				 
			 }
			 catch(SQLException er){
				 JOptionPane.showMessageDialog(null,"cannot close the connection"+er);
				 
				
				 
				 
			 }
		 }
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inboxsms window = new Inboxsms();
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
	public Inboxsms() {
		initialize();           
		DoConnect();
	}           

	/**                                              
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 14));
		frame.setBounds(100, 100, 575, 483);             
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSmsId = new JLabel("SMS ID");
		lblSmsId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSmsId.setBounds(31, 65, 60, 14);
		frame.getContentPane().add(lblSmsId);
		        
		txtid = new JTextField();
		txtid.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtid.setBounds(91, 62, 86, 20);
		frame.getContentPane().add(txtid);         
		txtid.setColumns(10);
		
		JLabel lblMobile = new JLabel("Mobile ");
		lblMobile.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMobile.setBounds(260, 65, 79, 14);
		frame.getContentPane().add(lblMobile);
		
		txtmob = new JTextField();
		txtmob.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtmob.setBounds(354, 63, 159, 20);
		frame.getContentPane().add(txtmob);
		txtmob.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Time");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(31, 101, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		txttime = new JTextField();
		txttime.setFont(new Font("Tahoma", Font.BOLD, 12));
		txttime.setBounds(91, 98, 159, 20);
		frame.getContentPane().add(txttime);
		txttime.setColumns(10);
		
		JLabel lblMessage = new JLabel("Message");
		lblMessage.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMessage.setBounds(31, 146, 86, 14);
		frame.getContentPane().add(lblMessage);
		
		txtasms = new JTextArea();
		txtasms.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtasms.setBounds(81, 160, 414, 179);
		frame.getContentPane().add(txtasms);
		
		btnFirst = new JButton("FIRST");
		btnFirst.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					rs.first();
					int id_col = rs.getInt("id");
					String id = Integer.toString(id_col);
					String sender = rs.getString("sender");
					String cust = rs.getString("customerName");
					String rtime = rs.getString("receivedtime");
					String msg = rs.getString("msg");
					
					txtid.setText(id);
					txtmob.setText(sender);
					txtcustomer.setText(cust);
					txttime.setText(rtime);
					txtasms.setText(msg);
					
					
				}
				catch(SQLException ex){
				      JOptionPane.showMessageDialog(null, "Unable to be on first sms"+ ex);
				}
			}
		});
		btnFirst.setBounds(31, 350, 89, 23);
		frame.getContentPane().add(btnFirst);
		
		btnNext = new JButton("NEXT");
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
				if(rs.next())
					{
					int id =rs.getInt("id");
					String idstr = Integer.toString(id);
					String sendermob = rs.getString("sender");
					String cust = rs.getString("customerName");
					String msg1 = rs.getString("msg");
					String receivetime=rs.getString("receivedtime");
					
					
					
					txtid.setText(idstr);
					txtmob.setText(sendermob);
					txtcustomer.setText(cust);
					txtasms.setText(msg1);
					txttime.setText(receivetime);
					
					
					}
				else
				
					//rs.previous();
				JOptionPane.showMessageDialog(null, "end of file");
			}
				catch(Exception e){
					e.printStackTrace();
			     	//return false;
				}
				
			}
		});
		btnNext.setBounds(130, 350, 89, 23);
		frame.getContentPane().add(btnNext);  
		
		btnPrevious = new JButton("PREVIOUS");
		btnPrevious.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
				if(rs.previous())
					{
					int id =rs.getInt("id");
					String idstr = Integer.toString(id);
					String sendermob = rs.getString("sender");
					String cust = rs.getString("customerName");
					
					String msg1 = rs.getString("msg");
					String receivetime=rs.getString("receivedtime");
					
					
					
					txtid.setText(idstr);
					txtmob.setText(sendermob);
					txtcustomer.setText(cust);
					txtasms.setText(msg1);
					txtasms.setText(msg1);
					txttime.setText(receivetime);
					
					
					
					}
				                      
			}
				catch(Exception e){
					e.printStackTrace();  
			     	//return false;
				}
				
			}
		});
		btnPrevious.setBounds(231, 350, 114, 23);
		frame.getContentPane().add(btnPrevious);
		
		btnlast = new JButton("LAST");           
		btnlast.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnlast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					rs.last();
					int idcol = rs.getInt("id");
					String id = Integer.toString(idcol);
					String sender= rs.getString("sender");
					String cust = rs.getString("customerName");
					String rtime = rs.getString("receivedtime");
					String msg = rs.getString("msg");
					
					txtid.setText(id);
					txtmob.setText(sender);
					txtcustomer.setText(cust);         
					txttime.setText(rtime);
					txtasms.setText(msg);
					
				}
				catch(SQLException ex)
				{
					JOptionPane.showMessageDialog(null,"unable to go last message"+ ex);
					
				}
			}
		});
		btnlast.setBounds(355, 350, 89, 23);
		frame.getContentPane().add(btnlast);
		
		JButton btnClose = new JButton("CLOSE");
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Inboxsms wind = new Inboxsms();
				//wind.Conclose();
				//System.exit(0);
				 frame.dispose();
				
			}
		});
		btnClose.setBounds(446, 350, 89, 23);
		frame.getContentPane().add(btnClose);
		
		JLabel lblIncomingMessage = new JLabel("INCOMING MESSAGE");
		lblIncomingMessage.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblIncomingMessage.setBounds(161, 26, 222, 14);
		frame.getContentPane().add(lblIncomingMessage);
		
		JButton btnrefresh = new JButton("REFERESH");
		btnrefresh.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnrefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				      rs.refreshRow();
				      pst.close();
				      rs.close();
				      pst = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				      String SQL = "select id, sender, customerName, receivedtime, msg from HarardrugDatabase.ozekimessagein, HarardrugDatabase.customer";
				      rs=pst.executeQuery(SQL);
				      rs.afterLast();
				      
				       int idcol = rs.getInt("id");
						String id = Integer.toString(idcol);
						String sender= rs.getString("sender");
						String cust = rs.getString("customerName");
						String rtime = rs.getString("receivedtime");
						String msg = rs.getString("msg");
						
						txtid.setText(id);
						txtmob.setText(sender);
						txtcustomer.setText(cust);
						txttime.setText(rtime);
						txtasms.setText(msg);
						
				    	  //JOptionPane.showMessageDialog(null, "Recored refreshed");
				      
					}catch(SQLException e)
					{
						JOptionPane.showMessageDialog(null,"No new record Inserted");
						}
				}
		});
		btnrefresh.setBounds(161, 399, 116, 23);
		frame.getContentPane().add(btnrefresh);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				      rs.deleteRow();
				      pst.close();
				      rs.close();
				      pst = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				      String SQL = "select * from HarardrugDatabase.ozekimessagein";
				      rs=pst.executeQuery(SQL);
				      rs.next();                 
				      
				       int idcol = rs.getInt("id");
						String id = Integer.toString(idcol);                     
						String sender= rs.getString("sender");
						String cust = rs.getString("customerName");
						String rtime = rs.getString("receivedtime");
						String msg = rs.getString("msg");
						
						txtid.setText(id);
						txtmob.setText(sender);
						txtcustomer.setText(cust);
						txttime.setText(rtime);
						txtasms.setText(msg);
						
				    	  JOptionPane.showMessageDialog(null, "Recored Deleted");
				      
					}catch(SQLException e)
					{
						JOptionPane.showMessageDialog(null,e.getMessage());
						}
			}
		});
		btnDelete.setBounds(336, 399, 108, 23);
		frame.getContentPane().add(btnDelete);
		
		lblNewLabel_1 = new JLabel("Customer");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));                  
		lblNewLabel_1.setBounds(260, 103, 73, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtcustomer = new JTextField();
		txtcustomer.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtcustomer.setBounds(354, 100, 159, 20);
		frame.getContentPane().add(txtcustomer);
		txtcustomer.setColumns(10);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
		// TODO Auto-generated method stub
		
	}
}
