package harar.pharmaceutica.wholesaler;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Sendsms {        

	private JFrame frame;
	private JTextField txtmobile;
	private JTextArea txtsms;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {       
					Sendsms window = new Sendsms();
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
	public Sendsms() {
		initialize();
	}

	/**   
	 * Initialize the contents of the frame.
	 */ 
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtmobile = new JTextField();
		txtmobile.setBounds(137, 43, 179, 20);
		frame.getContentPane().add(txtmobile);
		txtmobile.setColumns(10);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String mobile = txtmobile.getText();
				String msg = txtsms.getText();
			    Sender se = new Sender(mobile, msg);
				try {
					se.send();   
				} catch (Exception e) {  
					// TODO Auto-generated catch block   
					e.printStackTrace();
				}  
			}
		});
		btnNewButton.setBounds(137, 202, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		 txtsms = new JTextArea();
		txtsms.setBounds(132, 93, 184, 75);
		frame.getContentPane().add(txtsms);
		
		JButton Cancel = new JButton("Cancel");
		Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		Cancel.setBounds(273, 202, 89, 23);
		frame.getContentPane().add(Cancel);
		
		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setBounds(60, 46, 46, 14);
		frame.getContentPane().add(lblMobile);
		
		JLabel lblMessage = new JLabel("Message");
		lblMessage.setBounds(48, 98, 46, 14);
		frame.getContentPane().add(lblMessage);
	}
}
