package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.ProdutoDAO;
import DTO.ProdutoDTO;

import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Component;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroProdutos extends JFrame {

	private static final long serialVersionUID = -6402606639279933943L;
	private JPanel contentPane;
	private JTable table;
	private JTextPane codigoProduto;
	private JTextField produtoCodigo;
	private JButton btnExcluir;
	private JButton btnNovoProduto;
	private JTextPane nome;
	private JTextField getNome;
	private JTextPane procuraProduto;
	private Manager homePage;
	private EditarProduto editaProduto;
	private JTextField procuraProduto_1;
	private ProdutoDTO pdto;
	private ProdutoDAO pdao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroProdutos frame = new CadastroProdutos();
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
	public CadastroProdutos() {
		setTitle("Cadastro de Produtos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(170, 100, 1024, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		codigoProduto = new JTextPane();
		codigoProduto.setEditable(false);
		codigoProduto.setBackground(Color.LIGHT_GRAY);
		codigoProduto.setText("ID:");
		
		produtoCodigo = new JTextField();
		produtoCodigo.setColumns(10);
		
		JButton editarProduto = new JButton("editar");
		editarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				editaProduto = new EditarProduto();
				editaProduto.setVisible(true);
			}
		});
		editarProduto.setIcon(new ImageIcon(CadastroProdutos.class.getResource("/img/edit.png")));
		
		btnExcluir = new JButton("excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pdao = new ProdutoDAO();
				try{
					pdto = pdao.findById(Long.parseLong(produtoCodigo.getText()));
					if(pdto!=null){
						pdao.remove(pdto);
					}
				} catch (Exception ex) {
					System.err.print(ex);				
				}
				
				
			}
		});
		btnExcluir.setIcon(new ImageIcon(CadastroProdutos.class.getResource("/img/delete.png")));
		
		btnNovoProduto = new JButton("Novo Produto");
		btnNovoProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				editaProduto = new EditarProduto();
				editaProduto.setVisible(true);
			
			}
		});
		btnNovoProduto.setIcon(new ImageIcon(CadastroProdutos.class.getResource("/img/newProduct.png")));
		
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
		back.setIcon(new ImageIcon(CadastroProdutos.class.getResource("/img/backicon.png")));
		back.setBackground(Color.WHITE);
		
		JButton home = new JButton("");
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				if (homePage==null){
					homePage = new Manager();
				}
				homePage.setVisible(true);
			}
		});
		
		home.setIcon(new ImageIcon(CadastroProdutos.class.getResource("/img/homeicon.png")));
		home.setBackground(Color.WHITE);
		
		nome = new JTextPane();
		nome.setText("Nome:");
		nome.setEditable(false);
		nome.setBackground(Color.LIGHT_GRAY);
		
		getNome = new JTextField();
		getNome.setColumns(10);
		
		procuraProduto = new JTextPane();
		procuraProduto.setText("Procurar por produto");
		procuraProduto.setEditable(false);
		procuraProduto.setBackground(Color.LIGHT_GRAY);
		
		JButton pesquisar = new JButton("Pesquisar");
		
		procuraProduto_1 = new JTextField();
		procuraProduto_1.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 990, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(home, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(back, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(142)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(nome, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(getNome, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(codigoProduto, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(produtoCodigo, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)))
									.addGap(69)
									.addComponent(editarProduto)
									.addGap(31)
									.addComponent(btnExcluir)
									.addGap(36)
									.addComponent(btnNovoProduto, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(procuraProduto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(procuraProduto_1, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(pesquisar)))
							.addGap(75)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(home, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(back, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(48)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(procuraProduto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(procuraProduto_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(pesquisar)))
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(codigoProduto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(produtoCodigo, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(getNome, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(nome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(15)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(editarProduto)
								.addComponent(btnExcluir)
								.addComponent(btnNovoProduto, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(124, Short.MAX_VALUE))
		);
		gl_contentPane.linkSize(SwingConstants.VERTICAL, new Component[] {btnExcluir, btnNovoProduto});
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Id", "C\u00F3digo", "Descri\u00E7\u00E3o", "Quantidade", "Valor R$"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 8754967476230445053L;
			Class[] columnTypes = new Class[] {
				Long.class, Long.class, String.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(123);
		table.getColumnModel().getColumn(2).setPreferredWidth(190);
		table.getColumnModel().getColumn(3).setPreferredWidth(102);
		table.getColumnModel().getColumn(4).setPreferredWidth(107);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}
