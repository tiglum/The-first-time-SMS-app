package harar.pharmaceutica.wholesaler;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;

import com.mysql.jdbc.PreparedStatement;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;

public class Pharmasms {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pharmasms window = new Pharmasms();
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
	public Pharmasms() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Message:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(20, 68, 122, 22);
		frame.getContentPane().add(lblNewLabel);
		
		final JTextArea txtphsms = new JTextArea();
		txtphsms.setText("HARAR PHARMA/MEDICAL WHOLESALE P.L.C   ");
		txtphsms.setBounds(120, 77, 280, 120);
		frame.getContentPane().add(txtphsms);
		txtphsms.setLineWrap(true);
		txtphsms.setWrapStyleWord(true);
		
		JButton btnphsms = new JButton("SEND");
		btnphsms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtphsms.getText().length()==0)
					JOptionPane.showMessageDialog(null, "the message is empty");
				else
				{
				   // String  receiver = null;
					String msg = txtphsms.getText();
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
							pst1=(PreparedStatement) cont.prepareStatement("Insert into HarardrugDatabase.ozekimessageout(receiver, msg, status) values((select customer.mobileNumber from HarardrugDatabase.customer where typeofOrganization='Pharmacy' AND id ="+i+"),?,?)");
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
				         frame.setVisible(false);
						
						
					}
					catch(Exception e){
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "There is error to send"+e);
				     	
					}
			}	
			}
		});
		btnphsms.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnphsms.setBounds(120, 208, 105, 42);
		frame.getContentPane().add(btnphsms);
		
		JButton btncancel = new JButton("CANCEL");
		btncancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btncancel.setFont(new Font("Tahoma", Font.BOLD, 18));
		btncancel.setForeground(Color.BLACK);
		btncancel.setBounds(267, 208, 122, 42);
		frame.getContentPane().add(btncancel);
		
		JLabel lblNewLabel_1 = new JLabel("MESSAGE FOR PHARMACY");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(88, 11, 280, 32);
		frame.getContentPane().add(lblNewLabel_1);
	}

	public void setVisibile(boolean b) {
		frame.setVisible(b);
		
		// TODO Auto-generated method stub
		
	}

}
