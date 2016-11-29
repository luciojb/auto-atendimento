package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;

public class Manager extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager frame = new Manager();
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
	public Manager() {
		setTitle("Auto Atendimento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel home = new JPanel();
		contentPane.add(home, "Home");
		
		JButton btnAtendimento = new JButton("Atendimento");
		btnAtendimento.setIcon(new ImageIcon(Manager.class.getResource("/img/startShopping.png")));
		
		JButton btnCadatsros = new JButton("Cadastros");
		btnCadatsros.setIcon(new ImageIcon(Manager.class.getResource("/img/addCadastro.png")));
		
		JButton btnSair = new JButton("Sair");
		btnSair.setIcon(new ImageIcon(Manager.class.getResource("/img/exit.png")));
		GroupLayout gl_home = new GroupLayout(home);
		gl_home.setHorizontalGroup(
			gl_home.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_home.createSequentialGroup()
					.addGap(171)
					.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(170, Short.MAX_VALUE))
				.addGroup(gl_home.createSequentialGroup()
					.addGap(36)
					.addComponent(btnAtendimento)
					.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
					.addComponent(btnCadatsros)
					.addGap(35))
		);
		gl_home.setVerticalGroup(
			gl_home.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_home.createSequentialGroup()
					.addGap(48)
					.addGroup(gl_home.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAtendimento, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCadatsros, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(58)
					.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(72, Short.MAX_VALUE))
		);
		gl_home.linkSize(SwingConstants.VERTICAL, new Component[] {btnAtendimento, btnCadatsros});
		gl_home.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnAtendimento, btnCadatsros});
		home.setLayout(gl_home);
		
		JPanel atendimento = new JPanel();
		contentPane.add(atendimento, "Atendimento");
		GroupLayout gl_atendimento = new GroupLayout(atendimento);
		gl_atendimento.setHorizontalGroup(
			gl_atendimento.createParallelGroup(Alignment.LEADING)
				.addGap(0, 440, Short.MAX_VALUE)
		);
		gl_atendimento.setVerticalGroup(
			gl_atendimento.createParallelGroup(Alignment.LEADING)
				.addGap(0, 290, Short.MAX_VALUE)
		);
		atendimento.setLayout(gl_atendimento);
		
		JPanel cadastros = new JPanel();
		contentPane.add(cadastros, "Cadastros");
		
		JButton btnClientes = new JButton("Clientes");
		
		JButton btnProdutos = new JButton("Produtos");
		
		JButton btnHome = new JButton("");
		btnHome.setBackground(Color.WHITE);
		btnHome.setIcon(new ImageIcon(Manager.class.getResource("/img/homeicon.png")));
		
		JButton btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon(Manager.class.getResource("/img/backicon.png")));
		btnBack.setBackground(Color.WHITE);
		GroupLayout gl_cadastros = new GroupLayout(cadastros);
		gl_cadastros.setHorizontalGroup(
			gl_cadastros.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cadastros.createSequentialGroup()
					.addGroup(gl_cadastros.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_cadastros.createSequentialGroup()
							.addGap(47)
							.addComponent(btnClientes, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
							.addGap(70)
							.addComponent(btnProdutos))
						.addGroup(gl_cadastros.createSequentialGroup()
							.addComponent(btnHome, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		gl_cadastros.setVerticalGroup(
			gl_cadastros.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cadastros.createSequentialGroup()
					.addComponent(btnBack)
					.addGap(43)
					.addGroup(gl_cadastros.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnClientes, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnProdutos))
					.addContainerGap(166, Short.MAX_VALUE))
				.addGroup(gl_cadastros.createSequentialGroup()
					.addComponent(btnHome, GroupLayout.PREFERRED_SIZE, 28, Short.MAX_VALUE)
					.addGap(262))
		);
		gl_cadastros.linkSize(SwingConstants.VERTICAL, new Component[] {btnHome, btnBack});
		gl_cadastros.linkSize(SwingConstants.VERTICAL, new Component[] {btnClientes, btnProdutos});
		gl_cadastros.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnHome, btnBack});
		gl_cadastros.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnClientes, btnProdutos});
		cadastros.setLayout(gl_cadastros);
	}
}
