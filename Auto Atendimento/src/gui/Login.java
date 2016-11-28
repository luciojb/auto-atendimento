package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Login extends JFrame {

	private static final long serialVersionUID = 2863534982188441208L;
	private JPanel loginPanel;
	private JTextField loginGet;
	private JTextField PasswordGet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setVisible(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/login icon.png")));
		setTitle("Login Screen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(470, 300);
		setLocation(433, 234);
		loginPanel = new JPanel();
		loginPanel.setBackground(Color.LIGHT_GRAY);
		loginPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(loginPanel);
		
		JPanel welcomeMessage = new JPanel();
		
		JLabel loginIcon = new JLabel("");
		Image welcomeImage = new ImageIcon(this.getClass().getResource("/img/login icon.png")).getImage();
		loginIcon.setIcon(new ImageIcon(welcomeImage));
		loginIcon.setBackground(new Color(245, 245, 220));
		
		JTextPane loginWelcomeText = new JTextPane();
		loginWelcomeText.setFont(new Font("Century Schoolbook L", Font.PLAIN, 13));
		loginWelcomeText.setEditable(false);
		loginWelcomeText.setBackground(SystemColor.window);
		loginWelcomeText.setText("Bem-vindo à tela de login do sistema de Auto-Atendimento. O login somente é efetivado por pessoas devidamente creditadas.");
		GroupLayout gl_welcomeMessage = new GroupLayout(welcomeMessage);
		gl_welcomeMessage.setHorizontalGroup(
			gl_welcomeMessage.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_welcomeMessage.createSequentialGroup()
					.addGroup(gl_welcomeMessage.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_welcomeMessage.createSequentialGroup()
							.addGap(40)
							.addComponent(loginIcon, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_welcomeMessage.createSequentialGroup()
							.addGap(11)
							.addComponent(loginWelcomeText, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_welcomeMessage.setVerticalGroup(
			gl_welcomeMessage.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_welcomeMessage.createSequentialGroup()
					.addGap(24)
					.addComponent(loginIcon, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(loginWelcomeText, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
		);
		welcomeMessage.setLayout(gl_welcomeMessage);
		
		JPanel loginForms = new JPanel();
		loginForms.setBackground(Color.LIGHT_GRAY);
		GroupLayout gl_loginPanel = new GroupLayout(loginPanel);
		gl_loginPanel.setHorizontalGroup(
			gl_loginPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_loginPanel.createSequentialGroup()
					.addComponent(welcomeMessage, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(loginForms, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		gl_loginPanel.setVerticalGroup(
			gl_loginPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_loginPanel.createSequentialGroup()
					.addGroup(gl_loginPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(welcomeMessage, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
						.addComponent(loginForms, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		JTextPane loginText = new JTextPane();
		loginText.setEditable(false);
		loginText.setFont(new Font("Dialog", Font.BOLD, 13));
		loginText.setBackground(Color.LIGHT_GRAY);
		loginText.setText("Login");
		
		loginGet = new JTextField();
		loginGet.setColumns(10);
		
		JTextPane passwordText = new JTextPane();
		passwordText.setEditable(false);
		passwordText.setText("Password");
		passwordText.setFont(new Font("Dialog", Font.BOLD, 13));
		passwordText.setBackground(Color.LIGHT_GRAY);
		
		PasswordGet = new JTextField();
		PasswordGet.setColumns(10);
		
		JButton botaoEntrar = new JButton("Entrar");
		botaoEntrar.setIcon(new ImageIcon(Login.class.getResource("/img/loginOk.png")));
		botaoEntrar.setHorizontalTextPosition(SwingConstants.LEFT);
		
		JButton botaoCancelar = new JButton("Cancelar");
		botaoCancelar.setHorizontalTextPosition(SwingConstants.LEADING);
		botaoCancelar.setIcon(new ImageIcon(Login.class.getResource("/img/loginCancel.png")));
		GroupLayout gl_loginForms = new GroupLayout(loginForms);
		gl_loginForms.setHorizontalGroup(
			gl_loginForms.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_loginForms.createSequentialGroup()
					.addGroup(gl_loginForms.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_loginForms.createSequentialGroup()
							.addComponent(loginText, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(loginGet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_loginForms.createSequentialGroup()
							.addGroup(gl_loginForms.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_loginForms.createSequentialGroup()
									.addContainerGap()
									.addComponent(botaoEntrar, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
								.addComponent(passwordText, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_loginForms.createParallelGroup(Alignment.LEADING)
								.addComponent(PasswordGet, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(botaoCancelar, Alignment.TRAILING))))
					.addContainerGap())
		);
		gl_loginForms.setVerticalGroup(
			gl_loginForms.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_loginForms.createSequentialGroup()
					.addGap(43)
					.addGroup(gl_loginForms.createParallelGroup(Alignment.LEADING)
						.addComponent(loginText, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
						.addComponent(loginGet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(2)
					.addGroup(gl_loginForms.createParallelGroup(Alignment.TRAILING)
						.addComponent(PasswordGet, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordText, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(70)
					.addGroup(gl_loginForms.createParallelGroup(Alignment.BASELINE)
						.addComponent(botaoCancelar)
						.addComponent(botaoEntrar))
					.addGap(78))
		);
		loginForms.setLayout(gl_loginForms);
		loginPanel.setLayout(gl_loginPanel);
		
		
	}
}
