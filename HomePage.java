package hms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public HomePage() {
		setTitle("Home Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCekmekoy = new JLabel("Çekmeköy");
		lblCekmekoy.setHorizontalAlignment(SwingConstants.CENTER);
		lblCekmekoy.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCekmekoy.setBounds(10, 22, 416, 36);
		contentPane.add(lblCekmekoy);
		
		JLabel lblDevletHastanesi = new JLabel("Devlet Hastanesi");
		lblDevletHastanesi.setHorizontalAlignment(SwingConstants.CENTER);
		lblDevletHastanesi.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblDevletHastanesi.setBounds(10, 67, 416, 36);
		contentPane.add(lblDevletHastanesi);
		
		JLabel lblPatient = new JLabel("Have an account?");
		lblPatient.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPatient.setBounds(10, 151, 168, 59);
		contentPane.add(lblPatient);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUpPage signUpPageFrame = new SignUpPage();
				signUpPageFrame.setVisible(true);
				setVisible(false);
			}
		});
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSignUp.setBounds(238, 250, 154, 30);
		contentPane.add(btnSignUp);
		
		JLabel lblNewPatient = new JLabel("New Patient?");
		lblNewPatient.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewPatient.setBounds(10, 236, 168, 59);
		contentPane.add(lblNewPatient);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogInPage logInPageFrame = new LogInPage();
				logInPageFrame.setVisible(true);
				setVisible(false);
			}
		});
		
		JLabel lblLine1 = new JLabel("_____________________________________________________");
		lblLine1.setBounds(0, 299, 327, 13);
		contentPane.add(lblLine1);
		
		JLabel lblLine2 = new JLabel("_____________________________________________________");
		lblLine2.setBounds(238, 299, 327, 13);
		contentPane.add(lblLine2);
		
		btnLogIn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogIn.setBounds(238, 165, 154, 30);
		contentPane.add(btnLogIn);
		
		JLabel lblAdress = new JLabel("Address:");
		lblAdress.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAdress.setBounds(10, 322, 97, 13);
		contentPane.add(lblAdress);
		
		JLabel lblAddressExp = new JLabel("Emek Mahallesi, Namık Kemal Cad. No:54, 34785 Sancaktepe / İstanbul");
		lblAddressExp.setBounds(10, 337, 327, 13);
		contentPane.add(lblAddressExp);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPhone.setBounds(10, 360, 97, 13);
		contentPane.add(lblPhone);
		
		JLabel lblPhoneExp = new JLabel("(0216) 606 33 00");
		lblPhoneExp.setBounds(10, 380, 88, 13);
		contentPane.add(lblPhoneExp);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(179, 360, 97, 13);
		contentPane.add(lblEmail);
		
		JLabel lblEmailExp = new JLabel("istanbuleah35.bsh@saglik.gov.tr");
		lblEmailExp.setBounds(179, 380, 154, 13);
		contentPane.add(lblEmailExp);
		
	
	}

}
