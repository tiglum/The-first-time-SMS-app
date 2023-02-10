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

public class Clinicsms {

	private JFrame framec;  

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clinicsms window = new Clinicsms();
					window.framec.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Clinicsms() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		framec = new JFrame();
		framec.getContentPane().setBackground(Color.LIGHT_GRAY);
		framec.setBounds(100, 100, 450, 300);
		framec.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		framec.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MESSAGE FOR CLINICS");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(105, 25, 242, 24);
		framec.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Message:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 77, 109, 24);
		framec.getContentPane().add(lblNewLabel_1);
		
		final JTextArea txtclinic = new JTextArea();
		txtclinic.setText("HARAR PHARMA/MEDICAL WHOLESALE P.L.C   ");
		txtclinic.setBounds(105, 77, 276, 131);
		txtclinic.setLineWrap(true);
		txtclinic.setWrapStyleWord(true);
		
		framec.getContentPane().add(txtclinic);
		
		JButton btnsend = new JButton("SEND");
		btnsend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtclinic.getText().length()==0)
					JOptionPane.showMessageDialog(null, "the message is empty");
				else
				{
				   // String  receiver = null;
					String msg = txtclinic.getText();
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
							pst1=(PreparedStatement) cont.prepareStatement("Insert into HarardrugDatabase.ozekimessageout(receiver, msg, status) values((select customer.mobile from HarardrugDatabase.customer where typeofOrganization='Clinic' AND id ="+i+"),?,?)");
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
						framec.setVisible(false);
						
					}
					catch(Exception e){
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "There is error to send"+e);
				     	
					}
			}	
			}
		});
		btnsend.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnsend.setBounds(105, 219, 117, 31);
		framec.getContentPane().add(btnsend);
		
		JButton btncancel = new JButton("CANCEL");
		btncancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				framec.dispose();
				
			}
		});
		btncancel.setFont(new Font("Tahoma", Font.BOLD, 18));
		btncancel.setBounds(267, 219, 109, 31);
		framec.getContentPane().add(btncancel);
	}

	public void setVisible(boolean b) {
		framec.setVisible(b);
		// TODO Auto-generated method stub
		
	}

}
