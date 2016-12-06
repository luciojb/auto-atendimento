package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Pagamento extends JFrame {

	private JPanel contentPane;
	private JTextField getAgencia;
	private JTextField getNumeroConta;
	private JPasswordField getSenha;
	private JButton pagar;
	private JButton cancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pagamento frame = new Pagamento();
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
	public Pagamento() {
		setTitle("Pagamento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTextPane numeroConta = new JTextPane();
		numeroConta.setEditable(false);
		numeroConta.setText("Número da conta");
		
		JTextPane agencia = new JTextPane();
		agencia.setEditable(false);
		agencia.setText("Agência");
		
		JTextPane senha = new JTextPane();
		senha.setEditable(false);
		senha.setText("Senha");
		
		getAgencia = new JTextField();
		getAgencia.setColumns(10);
		
		getNumeroConta = new JTextField();
		getNumeroConta.setColumns(10);
		
		getSenha = new JPasswordField();
		
		pagar = new JButton("Pagar");
		
		cancelar = new JButton("Cancelar");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(56)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(senha, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(getSenha, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(agencia, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(getAgencia, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(numeroConta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(getNumeroConta, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(76, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(129, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(cancelar, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
						.addComponent(pagar, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
					.addGap(119))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(numeroConta, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(getNumeroConta, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(agencia, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(getAgencia, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(getSenha)
						.addComponent(senha, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(pagar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(cancelar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(58, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
