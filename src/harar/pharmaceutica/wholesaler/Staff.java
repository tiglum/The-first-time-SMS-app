package harar.pharmaceutica.wholesaler;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.jdbc.PreparedStatement;

public class Staff {

	private JFrame frame;     
	private JTextField txtid;
	private JTextField txtname;
	private JTextField txtmobile;
	private JTextField txtareaofwork;
	private JButton btncanncel;
	private JComboBox cmbreligion;      
                       
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Staff window = new Staff();
					window.frame.setVisible(true);
					//window.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Staff() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBackground(new Color(128, 128, 128));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 336, 443);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblStafAddress = new JLabel("STAFF ADDRESS");                
		lblStafAddress.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblStafAddress.setBounds(77, 30, 157, 32);
		frame.getContentPane().add(lblStafAddress);
		                                               
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblId.setBounds(24, 100, 46, 14);
		frame.getContentPane().add(lblId);
		
		txtid = new JTextField();
		txtid.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtid.setBounds(133, 99, 133, 20);
		frame.getContentPane().add(txtid);
		txtid.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(24, 144, 46, 14);
		frame.getContentPane().add(lblName);
		
		txtname = new JTextField();
		txtname.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtname.setBounds(133, 143, 133, 20);
		frame.getContentPane().add(txtname);
		txtname.setColumns(10);
		
		JLabel lblSex = new JLabel("Sex");
		lblSex.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSex.setBounds(24, 183, 46, 14);
		frame.getContentPane().add(lblSex);
		
		final JComboBox cmbsex = new JComboBox();
		cmbsex.setFont(new Font("Tahoma", Font.BOLD, 12));
		cmbsex.setModel(new DefaultComboBoxModel(new String[] {"", "Male", "Female"}));
		cmbsex.setBounds(133, 174, 133, 20);
		frame.getContentPane().add(cmbsex);
		
		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMobile.setBounds(24, 221, 46, 14);
		frame.getContentPane().add(lblMobile);
		
		txtmobile = new JTextField();
		txtmobile.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtmobile.setText("+251");
		txtmobile.setBounds(133, 220, 133, 20);
		frame.getContentPane().add(txtmobile);
		txtmobile.setColumns(10);
		
		JLabel lblAreaOfWork = new JLabel("Area of work");
		lblAreaOfWork.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAreaOfWork.setBounds(24, 280, 99, 26);
		frame.getContentPane().add(lblAreaOfWork);
		
		txtareaofwork = new JTextField();
		txtareaofwork.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtareaofwork.setBounds(133, 285, 133, 20);
		frame.getContentPane().add(txtareaofwork);
		txtareaofwork.setColumns(10);
		
		JButton btnsave = new JButton("SAVE");
		btnsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtid.getText().length()==0)
					JOptionPane.showMessageDialog(null, "Staff id is empty");
				else if(txtname.getText().length()==0)
					JOptionPane.showMessageDialog(null, "staff name is empty");
				else if(cmbsex.getSelectedItem().equals(0))
					JOptionPane.showMessageDialog(null, "sex not selected");
				else if(cmbreligion.getSelectedItem().equals(0))
					JOptionPane.showMessageDialog(null, "religion not selected");
				else if(txtmobile.getText().length()==0)
					JOptionPane.showMessageDialog(null, "mobile number is empty");
				else if(txtmobile.getText().length()!= 13)
					JOptionPane.showMessageDialog(null, "mobile number is not 13 figure");
					
					
				
				else
				{
					
					String id = txtid.getText();         
				 	String name = txtname.getText();
					String sex = (String) cmbsex.getSelectedItem();
					String mobile = txtmobile.getText();
					String areaofwork = txtareaofwork.getText();
					String religion = (String) cmbreligion.getSelectedItem();
					
						
				
				
				try
				{
				
					Connection cont = Connect.getConnect();
					PreparedStatement pst = (PreparedStatement) cont.prepareStatement("INSERT INTO HarardrugDatabase.staffaddress(staffId, staffName, staffSex, religion, stafmobileNumber, staffAreaOfWork) VALUES(?,?,?,?,?,?)");
					pst.setString(1, id);
					pst.setString(2, name);
					pst.setString(3, sex);
					pst.setString(4, religion);
					pst.setString(5, mobile);
					pst.setString(6, areaofwork);
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Staff data is inserted");
					txtid.setText("");
					txtname.setText("");
					cmbreligion.setSelectedItem("");
					txtmobile.setText("");
					cmbsex.setSelectedItem("");
					txtareaofwork.setText("");
					
					
					
					
				}
				catch(Exception e){
				
					JOptionPane.showMessageDialog(null, "Error to create customer"+e);
					
				}
				
			}}
		});
		btnsave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnsave.setBounds(66, 349, 89, 23);
		frame.getContentPane().add(btnsave);
		
		btncanncel = new JButton("CANCEL");
		btncanncel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btncanncel.setForeground(new Color(0, 0, 0));
		btncanncel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btncanncel.setBounds(184, 348, 97, 23);
		frame.getContentPane().add(btncanncel);
		
		JLabel lblReligion = new JLabel("Religion");
		lblReligion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblReligion.setBounds(24, 254, 60, 14);
		frame.getContentPane().add(lblReligion);
		
		cmbreligion = new JComboBox();
		cmbreligion.setFont(new Font("Tahoma", Font.BOLD, 12));
		cmbreligion.setModel(new DefaultComboBoxModel(new String[] {"", "Muslim", "Christian"}));
		cmbreligion.setBounds(133, 254, 133, 20);
		frame.getContentPane().add(cmbreligion);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(b);
	}

}     
