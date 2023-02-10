package harar.pharmaceutica.wholesaler;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;

import com.mysql.jdbc.PreparedStatement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.Color;

public class Christiansms {

	private JFrame frame;

	/**
	 * Launch the application.     
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Christiansms window = new Christiansms();
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
	public Christiansms() {
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
		lblNewLabel.setBounds(45, 70, 100, 22);
		frame.getContentPane().add(lblNewLabel);
		
		final JTextArea txtchristian = new JTextArea();
		txtchristian.setText("HARAR PHARMA MEDICAL WHOLESALE P.L.C ");
		txtchristian.setBounds(137, 75, 234, 114);
		txtchristian.setLineWrap(true);
		txtchristian.setWrapStyleWord(true);
		
		frame.getContentPane().add(txtchristian);
		
		JButton btnchristian = new JButton("SEND");
		btnchristian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtchristian.getText().length()==0)
					JOptionPane.showMessageDialog(null, "the messageis empty");
				else
				{
				   // String  receiver = null;
					String msg = txtchristian.getText();
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
							pst1=(PreparedStatement) cont.prepareStatement("Insert into HarardrugDatabase.ozekimessageout(receiver, msg, status) values((select customer.mobile from HarardrugDatabase.customer where religion='Christian' AND id ="+i+"),?,?)");
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
		btnchristian.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnchristian.setBounds(122, 212, 108, 38);
		frame.getContentPane().add(btnchristian);
		
		JButton btncancel = new JButton("CANCEL");
		btncancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				
			}
		});
		btncancel.setFont(new Font("Tahoma", Font.BOLD, 18));
		btncancel.setBounds(269, 212, 118, 38);
		frame.getContentPane().add(btncancel);
		
		JLabel lblNewLabel_1 = new JLabel("MESSAGE FOR CHRISTIAN ");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(77, 11, 282, 31);
		frame.getContentPane().add(lblNewLabel_1);
	}

	public void setVisibile(boolean b) {
		frame.setVisible(b);
		
		// TODO Auto-generated method stub
		
	}

	

}
