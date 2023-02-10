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

public class Othersms {

	private JFrame frame;
	private JTextArea txtother ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Othersms window = new Othersms();
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
	public Othersms() {
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
		
		JLabel lblSmsForOthers = new JLabel("SMS FOR OTHERS");
		lblSmsForOthers.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSmsForOthers.setBounds(156, 30, 202, 14);
		frame.getContentPane().add(lblSmsForOthers);
		
		JLabel lblMessage = new JLabel("Message:");
		lblMessage.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMessage.setBounds(37, 75, 98, 31);
		frame.getContentPane().add(lblMessage);
		
		txtother = new JTextArea();
		txtother.setText("HARAR PHARMA/MEDICAL WHOLESALE P.L.C  ");
		txtother.setBounds(128, 81, 263, 130);
		txtother.setLineWrap(true);
		txtother.setWrapStyleWord(true);
		frame.getContentPane().add(txtother);
		
		JButton btnSend = new JButton("SEND");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtother.getText().length()==0)
					JOptionPane.showMessageDialog(null, "the message is empty");
				else
				{
				   // String  receiver = null;
					String msg = txtother.getText();
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
							pst1=(PreparedStatement) cont.prepareStatement("Insert into HarardrugDatabase.ozekimessageout(receiver, msg, status) values((select customer.mobileNumber from HarardrugDatabase.customer where typeofOrganization='Others' AND id ="+i+"),?,?)");
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
		btnSend.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSend.setBounds(105, 222, 98, 23);
		frame.getContentPane().add(btnSend);
		
		JButton btncancel = new JButton("CANCEL");
		btncancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btncancel.setFont(new Font("Tahoma", Font.BOLD, 18));
		btncancel.setBounds(270, 227, 103, 23);
		frame.getContentPane().add(btncancel);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
		// TODO Auto-generated method stub
		
	}
}
