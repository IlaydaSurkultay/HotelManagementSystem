package hms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class LogInPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNameSurname;
	private JTextField txtPassword;

	
	public LogInPage() {
		setTitle("LogIn Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUserName.setBounds(10, 83, 123, 37);
		contentPane.add(lblUserName);
		
		txtNameSurname = new JTextField();
		txtNameSurname.setHorizontalAlignment(SwingConstants.CENTER);
		txtNameSurname.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtNameSurname.setText("name surname");
		txtNameSurname.setBounds(213, 83, 170, 31);
		contentPane.add(txtNameSurname);
		txtNameSurname.setColumns(10);
		
		JLabel lblUserPassword = new JLabel("User Password:");
		lblUserPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUserPassword.setBounds(10, 159, 136, 37);
		contentPane.add(lblUserPassword);
		
		txtPassword = new JTextField();
		txtPassword.setText("******");
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtPassword.setColumns(10);
		txtPassword.setBounds(213, 165, 170, 31);
		contentPane.add(txtPassword);
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/hospital","root","Sn3648...*");
			
					String sqlQuery = "SELECT * FROM user WHERE user_name='" + txtNameSurname.getText() + "' and user_password='" + txtPassword.getText() + "'";

			         Statement statement = con.createStatement();
			         ResultSet rs= statement.executeQuery(sqlQuery);
			         if(rs.next()) {
			        	 JOptionPane.showMessageDialog(null, "Login Sucessfully");
			         }else {
			        	 JOptionPane.showMessageDialog(null, "Incorrect username or password");
			         }
			         con.close();
				}catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(143, 244, 150, 31);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("do not have an account");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel.setBounds(160, 339, 115, 13);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("sign up");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUpPage signUpFrame = new SignUpPage();
				signUpFrame.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(170, 362, 85, 21);
		contentPane.add(btnNewButton_1);
	}
}
