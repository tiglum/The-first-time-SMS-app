package harar.pharmaceutica.wholesaler;
                
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;           
import javax.swing.JTextArea;
import javax.swing.JButton;

import com.mysql.jdbc.PreparedStatement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.awt.Color;

public class Individualsms {

	private JFrame frame;  
	private JTextField txtmobile;
           
	/**                                           
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Individualsms window = new Individualsms();
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
	public Individualsms() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 450, 329);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mobile Phone");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(43, 65, 154, 28);
		frame.getContentPane().add(lblNewLabel);
		
		txtmobile = new JTextField();
		txtmobile.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtmobile.setText("+251");
		txtmobile.setBounds(207, 71, 167, 20);
		frame.getContentPane().add(txtmobile);
		txtmobile.setColumns(10);
		
		final JTextArea txtmessage = new JTextArea();
		txtmessage.setText("HARAR PHARMA/MEDICAL WHOLESALE P.L.C");
		txtmessage.setColumns(1);
		txtmessage.setBounds(135, 99, 267, 130);
		txtmessage.setLineWrap(true);
		txtmessage.setWrapStyleWord(true);
		
		frame.getContentPane().add(txtmessage);
		
		JLabel lblNewLabel_1 = new JLabel("Message");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(53, 104, 144, 28);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnsend = new JButton("SEND");
		btnsend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				if(txtmobile.getText().length()==0)
					JOptionPane.showMessageDialog(null, "insert mobile phone");
				else if (txtmessage.getText().length()==0)
					JOptionPane.showMessageDialog(null, "insert the message");
				else
				{
				     String addres = txtmobile.getText();
				     String msg = txtmessage.getText();
				     String stat = "send";
				     send_message(addres,msg,stat);
				}
			}
		});
		btnsend.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnsend.setBounds(123, 240, 116, 39);
		frame.getContentPane().add(btnsend);
		
		JButton btncancel = new JButton("CANCEL");
		btncancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			 //System.exit(0);
				frame.dispose();
			 
			}
		});
		btncancel.setFont(new Font("Tahoma", Font.BOLD, 18));
		btncancel.setBounds(296, 240, 106, 39);
		frame.getContentPane().add(btncancel);
		
		JLabel lblNewLabel_2 = new JLabel("INDIVIDUAL MESSAGING");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(81, 11, 293, 35);
		frame.getContentPane().add(lblNewLabel_2);
	}
	private void send_message(String receiver, String msg, String status){
		
	try
		{
			Connection cont = Connect.getConnect();
			PreparedStatement pst = (PreparedStatement) cont.prepareStatement("Insert into HarardrugDatabase.ozekimessageout(receiver, msg, status) values(?,?,?)");
			pst.setString(1, receiver);
			pst.setString(2, msg);        
			pst.setString(3, status);
			
			pst.executeUpdate();
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

	public void setVisible(boolean b) {
		
		frame.setVisible(b);
		
		// TODO Auto-generated method stub
		
	}
}
