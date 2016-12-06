package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroPessoas extends JFrame {

	private static final long serialVersionUID = 3268668334928219168L;
	private JPanel contentPane;
	private JTable table;
	private JTextField getId;
	private JTextField getNome;
	private Manager homePage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroPessoas frame = new CadastroPessoas();
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
	public CadastroPessoas() {
		setTitle("Cadastro de Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(170, 100, 1024, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton home = new JButton("");
		home.setIcon(new ImageIcon(CadastroPessoas.class.getResource("/img/homeicon.png")));
		home.setBackground(Color.WHITE);
		
		JButton back = new JButton("");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				if (homePage==null){
					homePage = new Manager();
					homePage.setVisible(true);
					homePage.getContentPane().getComponent(0).setVisible(false);
					homePage.getContentPane().getComponent(1).setVisible(true);
					
				}
			}
		});
		back.setIcon(new ImageIcon(CadastroPessoas.class.getResource("/img/backicon.png")));
		back.setBackground(Color.WHITE);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JTextPane procurarPessoa = new JTextPane();
		procurarPessoa.setText("Procurar por pessoa");
		procurarPessoa.setEditable(false);
		procurarPessoa.setBackground(Color.LIGHT_GRAY);
		
		JTextPane id = new JTextPane();
		id.setText("ID:");
		id.setEditable(false);
		id.setBackground(Color.LIGHT_GRAY);
		
		JTextPane nome = new JTextPane();
		nome.setText("Nome:");
		nome.setEditable(false);
		nome.setBackground(Color.LIGHT_GRAY);
		
		getId = new JTextField();
		getId.setColumns(10);
		
		getNome = new JTextField();
		getNome.setColumns(10);
		
		JButton editar = new JButton("editar");
		editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		editar.setIcon(new ImageIcon(CadastroPessoas.class.getResource("/img/edit.png")));
		
		JButton excluir = new JButton("excluir");
		excluir.setIcon(new ImageIcon(CadastroPessoas.class.getResource("/img/delete.png")));
		
		JButton novaPessoa = new JButton("Nova Pessoa");
		novaPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		novaPessoa.setIcon(new ImageIcon(CadastroPessoas.class.getResource("/img/newPerson.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(home, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(back, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 990, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(procurarPessoa, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(id, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(getId, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(nome, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(getNome, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)))
							.addGap(47)
							.addComponent(editar, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
							.addGap(34)
							.addComponent(excluir, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addGap(36)
							.addComponent(novaPessoa, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(home, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(back, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(procurarPessoa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(getId, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(nome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(getNome, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(71)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(editar, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(excluir, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(71)
							.addComponent(novaPessoa, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(180, Short.MAX_VALUE))
		);
		gl_contentPane.linkSize(SwingConstants.HORIZONTAL, new Component[] {editar, excluir});
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"CPF", "RG", "Nome", "E-mail", "Telefone", "Idade"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = -8470242235190746188L;
			Class[] columnTypes = new Class[] {
				Long.class, Long.class, String.class, String.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}
