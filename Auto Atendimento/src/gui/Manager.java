package gui;

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
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextPane;
import java.awt.Font;

public class Manager extends JFrame {

	private static final long serialVersionUID = -8370871434955550347L;
	private JPanel contentPane;
	private Login login;
	private Atendimento atender;
	private JPanel cadastros;
	private JPanel home;
	private CadastroPessoas cpes;
	private CadastroProdutos cprod;

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
		addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                dispose();
                login = new Login();
                login.setVisible(true);
            }
        });
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("Auto Atendimento");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		home = new JPanel();
		contentPane.add(home, "Home");

		cadastros = new JPanel();
		contentPane.add(cadastros, "Cadastros");
		
		JButton btnAtendimento = new JButton("Atendimento");
		btnAtendimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				atender = new Atendimento();
				atender.setVisible(true);
			}
		});
		btnAtendimento.setIcon(new ImageIcon(Manager.class.getResource("/img/startShopping.png")));
		
		JButton btnCadastros = new JButton("Cadastros");
		btnCadastros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home.setVisible(false);
				cadastros.setVisible(true);
				
			}
		});
		btnCadastros.setIcon(new ImageIcon(Manager.class.getResource("/img/addCadastro.png")));
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login login = new Login();
				login.setVisible(true);
			}
		});
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
					.addComponent(btnCadastros)
					.addGap(35))
		);
		gl_home.setVerticalGroup(
			gl_home.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_home.createSequentialGroup()
					.addGap(48)
					.addGroup(gl_home.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAtendimento, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCadastros, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(58)
					.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(72, Short.MAX_VALUE))
		);
		gl_home.linkSize(SwingConstants.VERTICAL, new Component[] {btnAtendimento, btnCadastros});
		gl_home.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnAtendimento, btnCadastros});
		home.setLayout(gl_home);
		
		
		JButton btnPessoas = new JButton("Pessoas");
		btnPessoas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				if (cpes == null){
					cpes = new CadastroPessoas();
				}
				cpes.setVisible(true);
			}
		});
		
		JButton btnProdutos = new JButton("Produtos");
		btnProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				if (cprod == null){
					cprod = new CadastroProdutos();
				}
				cprod.setVisible(true);
			}
		});
		
		JButton btnHome = new JButton("");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastros.setVisible(false);
				home.setVisible(true);
			}
		});
		btnHome.setBackground(Color.WHITE);
		btnHome.setIcon(new ImageIcon(Manager.class.getResource("/img/homeicon.png")));
		
		JTextPane txtpnSelecioneOTipo = new JTextPane();
		txtpnSelecioneOTipo.setBackground(Color.LIGHT_GRAY);
		txtpnSelecioneOTipo.setEditable(false);
		txtpnSelecioneOTipo.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtpnSelecioneOTipo.setText("Selecione o tipo de cadastro");
		GroupLayout gl_cadastros = new GroupLayout(cadastros);
		gl_cadastros.setHorizontalGroup(
			gl_cadastros.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cadastros.createSequentialGroup()
					.addGroup(gl_cadastros.createParallelGroup(Alignment.LEADING)
						.addComponent(btnHome, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_cadastros.createSequentialGroup()
							.addGap(49)
							.addComponent(btnPessoas, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
							.addGap(70)
							.addComponent(btnProdutos))
						.addGroup(gl_cadastros.createSequentialGroup()
							.addGap(119)
							.addComponent(txtpnSelecioneOTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(49, Short.MAX_VALUE))
		);
		gl_cadastros.setVerticalGroup(
			gl_cadastros.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cadastros.createSequentialGroup()
					.addComponent(btnHome, GroupLayout.PREFERRED_SIZE, 34, Short.MAX_VALUE)
					.addGap(23)
					.addComponent(txtpnSelecioneOTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addGroup(gl_cadastros.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPessoas, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnProdutos))
					.addGap(112))
		);
		gl_cadastros.linkSize(SwingConstants.VERTICAL, new Component[] {btnPessoas, btnProdutos});
		gl_cadastros.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnPessoas, btnProdutos});
		cadastros.setLayout(gl_cadastros);
		home.setVisible(true);
		
	}
}
