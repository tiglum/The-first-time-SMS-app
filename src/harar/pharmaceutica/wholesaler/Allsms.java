package harar.pharmaceutica.wholesaler;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import com.mysql.jdbc.PreparedStatement;

public class Allsms {

	private JFrame frame1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Allsms window = new Allsms();
					window.frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Allsms() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame1 = new JFrame();
		frame1.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame1.getContentPane().setEnabled(false);
		frame1.setBounds(100, 100, 450, 300);
		frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame1.getContentPane().setLayout(null);
		
		final JTextArea txtmsg = new JTextArea();
		txtmsg.setText("HARAR PHARMA/MEDICAL WHOLESALE P.L.C   ");
		txtmsg.setBackground(Color.WHITE);
		txtmsg.setLineWrap(true);
		txtmsg.setWrapStyleWord(true);
		
		txtmsg.setBounds(120, 73, 251, 106);
		frame1.getContentPane().add(txtmsg);
		
		JLabel lblNewLabel = new JLabel("Message:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 78, 100, 22);
		frame1.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("SEND");
		btnNewButton.addActionListener(new ActionListener() {
			//private int numrow;

			public void actionPerformed(ActionEvent arg0) {
				if(txtmsg.getText().length()==0)
					JOptionPane.showMessageDialog(null, "the messageis empty");
				else
				{
				   // String  receiver = null;
					String msg = txtmsg.getText();
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
							pst1=(PreparedStatement) cont.prepareStatement("Insert into HarardrugDatabase.ozekimessageout(receiver, msg, status) values((select customer.mobileNumber from HarardrugDatabase.customer where id ="+i+ "),?,?)");
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
				         frame1.setVisible(false);
						
						
					}
					catch(Exception e){
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "There is error to send"+e);
				     	
					}
			}	
				
				}
				
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(107, 190, 115, 35);
		frame1.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CANCEL");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			     frame1.dispose();
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBounds(269, 190, 115, 35);
		frame1.getContentPane().add(btnNewButton_1);
		
		JLabel lblMessageForAll = new JLabel("MESSAGE FOR ALL");
		lblMessageForAll.setForeground(Color.BLACK);
		lblMessageForAll.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMessageForAll.setBounds(120, 28, 238, 22);
		frame1.getContentPane().add(lblMessageForAll);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame1.setVisible(b);
		
	}

	

	
	             
		
		
}
