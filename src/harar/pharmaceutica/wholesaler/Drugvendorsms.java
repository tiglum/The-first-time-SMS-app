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

public class Drugvendorsms {

	private JFrame framedv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Drugvendorsms window = new Drugvendorsms();
					window.framedv.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Drugvendorsms() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		framedv = new JFrame();
		framedv.getContentPane().setBackground(Color.LIGHT_GRAY);
		framedv.setBounds(100, 100, 450, 300);
		framedv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		framedv.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MESSAGE FOR DRUG VENDOR");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(79, 22, 315, 24);
		framedv.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Message:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(30, 76, 109, 15);
		framedv.getContentPane().add(lblNewLabel_1);
		
		final JTextArea txtdrugvendor = new JTextArea();
		txtdrugvendor.setText("HARAR PHARMA/MEDICAL WHOLESALE P.L.C");
		txtdrugvendor.setBounds(114, 76, 246, 126);
		txtdrugvendor.setLineWrap(true);
		txtdrugvendor.setWrapStyleWord(true);
		framedv.getContentPane().add(txtdrugvendor);
		
		JButton btnsend = new JButton("SEND");
		btnsend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtdrugvendor.getText().length()==0)
					JOptionPane.showMessageDialog(null, "the message is empty");
				else
				{
				   // String  receiver = null;
					String msg = txtdrugvendor.getText();
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
							pst1=(PreparedStatement) cont.prepareStatement("Insert into HarardrugDatabase.ozekimessageout(receiver, msg, status) values((select customer.mobileNumber from HarardrugDatabase.customer where typeofOrganization='Drug vendor' AND id ="+i+"),?,?)");
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
				         framedv.setVisible(false);
						
						
					}
					catch(Exception e){
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "There is error to send"+e);
				     	
					}
			}	
			}
		});
		btnsend.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnsend.setBounds(100, 213, 109, 37);
		framedv.getContentPane().add(btnsend);
		
		JButton btncancel = new JButton("CANCEL");
		btncancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				framedv.dispose();
				
			}
		});
		btncancel.setFont(new Font("Tahoma", Font.BOLD, 18));
		btncancel.setBounds(271, 213, 109, 36);
		framedv.getContentPane().add(btncancel);
	}

	public void setVisible(boolean b) {
	      framedv.setVisible(b);
		// TODO Auto-generated method stub
		
	}

}
