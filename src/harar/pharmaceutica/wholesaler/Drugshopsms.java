package harar.pharmaceutica.wholesaler;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;

import com.mysql.jdbc.PreparedStatement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;

public class Drugshopsms {

	private JFrame framed;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Drugshopsms window = new Drugshopsms();
					window.framed.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Drugshopsms() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		framed = new JFrame();
		framed.getContentPane().setBackground(Color.LIGHT_GRAY);
		framed.setBounds(100, 100, 450, 300);
		framed.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		framed.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Message:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 62, 126, 29);
		framed.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("MESSAGE FOR DRUG SHOP");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(66, 11, 313, 29);
		framed.getContentPane().add(lblNewLabel_1);
		
		final JTextArea txtdrugshop = new JTextArea();
		txtdrugshop.setText("HARAR PHARMA/MEDICAL WHOLESALE P.L.C");
		txtdrugshop.setBounds(124, 62, 255, 122);
		txtdrugshop.setLineWrap(true);
		txtdrugshop.setWrapStyleWord(true);
		
		
		framed.getContentPane().add(txtdrugshop);
		
		JButton btnsend = new JButton("SEND");
		btnsend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtdrugshop.getText().length()==0)
					JOptionPane.showMessageDialog(null, "the message is empty");
				else
				{
				   // String  receiver = null;
					String msg = txtdrugshop.getText();
					//String status = "send";
				                  
					try
					{
					int numrow = 0;
					int i = 1;
						Connection cont = Connect.getConnect();
						PreparedStatement pst = null ;
						PreparedStatement pst1= null;
						String que=  "select * from HarardrugDatabase.customer";
						//String query = "Insert into hararph.ozekimessageout(receiver, msg, status) values(?,?,?)";
						pst= (PreparedStatement) cont.prepareStatement(que);
								//(PreparedStatement) cont.prepareStatement
				        //cont.setAutoCommit(false);
					 	//String[] query = {}; 
						ResultSet rs = pst.executeQuery();
						while(rs.next()){
							
							 numrow = rs.getRow();
							 }
						//JOptionPane.showMessageDialog(null, numrow);
						while(numrow>=i)
						{
							pst1=(PreparedStatement) cont.prepareStatement("Insert into HarardrugDatabase.ozekimessageout(receiver, msg, status) values((select customer.mobileNumber from HarardrugDatabase.customer where typeofOrganization='Drug shope' AND id ="+i+"),?,?)");
							pst1.setString(1, msg);
							pst1.setString(2, "send");
							pst1.addBatch(); 
							pst1.executeBatch();
							i++;
						}
						//for(int i= 1; i<=numrow; i++)  {
							
				        	//pst1.setString(1, msg);
				        	//pst1.setString(2, "send");
				        	//pst1.addBatch();          
				       // } 
						//values((select cont2.mobile from   hararph.cont2 ON DUPLICATE KEY UPDATE msg = $msg ),? ,'send')");
						//PreparedStatement pst1 = (PreparedStatement) cont.prepareStatement("Insert into hararph.ozekimessageout(receiver) select cont.mobile from hararph.cont");
						//pst.setString(1, receiver);
						
					//	pst.setString(3, status);
						                                        
						pst1.executeBatch();
						//pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "The message is already Sent");
				         pst.close();
				         cont.close();
				         framed.setVisible(false);
						
						
					}
					catch(Exception e){
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "There is error to send"+e);
				     	
					}
			}	
			}
		});
		btnsend.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnsend.setBounds(112, 214, 104, 36);
		framed.getContentPane().add(btnsend);
		
		JButton btnNewButton_1 = new JButton("CANCEL");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				framed.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBounds(247, 214, 120, 36);
		framed.getContentPane().add(btnNewButton_1);
	}

	public void setVesibile(boolean b) {
		framed.setVisible(b);
		// TODO Auto-generated method stub
		
	}

}
