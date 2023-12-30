package hms;

import java.awt.EventQueue;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import javax.swing.SwingConstants;
import java.text.ParseException;

import java.sql.ResultSet;
import java.sql.Statement;

public class SignUpPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUserName;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtPhoneNum;
	private JTextField txtPassword;
	private JTextField txtDOB;

	public SignUpPage() {
		setTitle("SignU Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUserName = new JLabel("User Name: ");
		lblUserName.setBackground(new Color(0, 0, 0));
		lblUserName.setForeground(new Color(0, 0, 0));
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblUserName.setBounds(10, 26, 131, 43);
		contentPane.add(lblUserName);

		txtUserName = new JTextField();
		txtUserName.setHorizontalAlignment(SwingConstants.CENTER);
		txtUserName.setText("name surname");
		txtUserName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtUserName.setBounds(206, 34, 173, 33);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);

		JLabel lblUserPassword = new JLabel("User Password:");
		lblUserPassword.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblUserPassword.setBounds(10, 84, 145, 33);
		contentPane.add(lblUserPassword);

		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setText("password");
		txtPassword.setColumns(10);
		txtPassword.setBounds(206, 84, 173, 33);
		contentPane.add(txtPassword);
		
		JLabel lblUserGender = new JLabel("Gender:");
		lblUserGender.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblUserGender.setBounds(10, 127, 131, 31);
		contentPane.add(lblUserGender);

		JRadioButton rbMale = new JRadioButton("male");
		rbMale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonGroup.add(rbMale);
		rbMale.setBounds(203, 129, 83, 28);
		contentPane.add(rbMale);

		JRadioButton rbFemale = new JRadioButton("female");
		rbFemale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonGroup.add(rbFemale);
		rbFemale.setBounds(288, 129, 91, 28);
		contentPane.add(rbFemale);

		
		JLabel lblDateOfBirth = new JLabel("Date of Birth:");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDateOfBirth.setBounds(10, 176, 145, 31);
		
		txtDOB = new JTextField();
		txtDOB.setHorizontalAlignment(SwingConstants.CENTER);
		txtDOB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDOB.setText("yyyy-mm-dd");
		txtDOB.setBounds(206, 176, 173, 29);
		contentPane.add(txtDOB);
		txtDOB.setColumns(10);
		

		contentPane.add(lblDateOfBirth);

		JLabel lblNewLabel = new JLabel("Phone Number:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(10, 227, 145, 33);
		contentPane.add(lblNewLabel);

		txtPhoneNum = new JTextField();
		txtPhoneNum.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPhoneNum.setText("0..........");
		txtPhoneNum.setHorizontalAlignment(SwingConstants.CENTER);
		txtPhoneNum.setColumns(10);
		txtPhoneNum.setBounds(206, 227, 173, 33);
		contentPane.add(txtPhoneNum);

		JButton btnEnter = new JButton("Sign Up");
		btnEnter.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/hospital","root","Sn3648...*");
			
					String userQuery = "insert into user values(?,?)";
					PreparedStatement uQ=con.prepareStatement(userQuery);
					
					uQ.setString(1, txtUserName.getText());
					uQ.setString(2, txtPassword.getText());
					
					
		            String sqlQuery = "SELECT MAX(patient_id) AS max_id FROM patient;";
		            Statement statement = con.createStatement();
		            ResultSet  resultSet = statement.executeQuery(sqlQuery);
		            int maxPatientId = 0;
		            if (resultSet.next()) {
		                maxPatientId = resultSet.getInt("max_id");
		            }        
		            int newPatientId = maxPatientId + 1;
		
					String patientQuery = "insert into patient values(?,?,?,?,?)";
					PreparedStatement pQ=con.prepareStatement(patientQuery);
					pQ.setInt(1, newPatientId);
					Date dateOfBirth = Date.valueOf(txtDOB.getText());
					pQ.setDate(2, dateOfBirth);
					pQ.setString(3, txtUserName.getText());
					if(rbMale.isSelected()) {
						pQ.setString(4, rbMale.getText());
					}else {
						pQ.setString(4, rbFemale.getText());
					}
					pQ.setString(5, txtPhoneNum.getText());
			
					
					
					int i= uQ.executeUpdate();
					 i+= pQ.executeUpdate();
					JOptionPane.showMessageDialog(btnEnter, i +  " record added");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEnter.setBounds(22, 289, 137, 43);
		contentPane.add(btnEnter);

		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUserName.setText("");
			}
		});
		btnReset.setBounds(248, 289, 131, 43);
		contentPane.add(btnReset);
		
		JLabel lblNewUser = new JLabel("do not have an accont?");
		lblNewUser.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewUser.setBounds(150, 357, 120, 13);
		contentPane.add(lblNewUser);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogInPage logInPageFrame = new LogInPage();
				logInPageFrame.setVisible(true);
				setVisible(false);
			}
		});
		btnLogIn.setBounds(160, 380, 85, 21);
		contentPane.add(btnLogIn);
		
		
		
		

		





	}
}
