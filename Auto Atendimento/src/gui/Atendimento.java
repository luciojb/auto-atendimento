package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import DAO.CompraDAO;
import DAO.ProdutoDAO;
import DTO.CompraDTO;
import DTO.ProdutoDTO;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Atendimento extends JFrame {

	private static final long serialVersionUID = 1974021803494165336L;
	private JPanel contentPane;
	private JTable productTable;
	private JTextField codigo;
	private CompraDAO compraDao;
	private CompraDTO compraDto;
	private ProdutoDTO produtoDto;
	private ProdutoDAO produtoDao;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Atendimento frame = new Atendimento();
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
	public Atendimento() {
		compraDao = new CompraDAO();
		compraDto = new CompraDTO();
		setTitle("Atendimento");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(170, 100, 860, 560);
		contentPane = new JPanel();
		contentPane.setVisible(false);
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JTextPane productNotFound = new JTextPane();
		
		JButton sair = new JButton("");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Manager man = new Manager();
				man.setVisible(true);
			}
		});
		sair.setIcon(new ImageIcon(Atendimento.class.getResource("/img/exitAt.png")));
		sair.setBackground(Color.WHITE);
		
		JTextPane welcomeMessage = new JTextPane();
		welcomeMessage.setFont(new Font("Dialog", Font.PLAIN, 12));
		welcomeMessage.setEditable(false);
		welcomeMessage.setText("Bem-Vindo ao Auto-Atendimento.");
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		welcomeMessage.setParagraphAttributes(center, false);
		
		JScrollPane painelProdutos = new JScrollPane();
		
		JTextPane prodCompraText = new JTextPane();
		prodCompraText.setText("Produtos da Compra Atual");
		prodCompraText.setParagraphAttributes(center, false);
		
		JTextPane textoPassarLeitor = new JTextPane();
		textoPassarLeitor.setText("Passe o leitor no código de barras do próximo produto!");
		textoPassarLeitor.setFont(new Font("Dialog", Font.PLAIN, 12));
		textoPassarLeitor.setEditable(false);
		textoPassarLeitor.setParagraphAttributes(center, false);
		
		JButton realizarPagamento = new JButton("Pagamento");
		realizarPagamento.setIcon(new ImageIcon(Atendimento.class.getResource("/img/payment.png")));
		
		JButton removerProduto = new JButton("Remover");
		removerProduto.setIcon(new ImageIcon(Atendimento.class.getResource("/img/removePr.png")));
		
		JButton btnCancelaCompra = new JButton("Cancela Compra");
		
		codigo = new JTextField();
		codigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					try{
						produtoDto = produtoDao.findByField("codigo_barras", codigo.getText());
						compraDto.setDataAtendimentoIn(new Date());
						compraDto.adicionaProduto(produtoDto);
					} catch (Exception ex) {
						productNotFound.setVisible(true);
					}
					
					codigo.setText("");
					codigo.requestFocus();
				}
			}
		});
		codigo.setColumns(10);
		
		
		productNotFound.setVisible(false);
		productNotFound.setFont(new Font("Dialog", Font.PLAIN, 15));
		productNotFound.setForeground(Color.RED);
		productNotFound.setEditable(false);
		productNotFound.setText("Produto não encontrado.");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(sair, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(productNotFound, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(codigo, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(112)
										.addComponent(realizarPagamento, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)))
								.addGap(132)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(removerProduto, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnCancelaCompra, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
								.addGap(88))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(painelProdutos, GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
									.addComponent(prodCompraText, GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
									.addComponent(textoPassarLeitor, GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
									.addComponent(welcomeMessage, GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE))
								.addGap(50)))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(welcomeMessage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(textoPassarLeitor, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(prodCompraText, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(painelProdutos, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
						.addComponent(sair, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(codigo, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(removerProduto))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(productNotFound, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelaCompra, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
						.addComponent(realizarPagamento, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.linkSize(SwingConstants.VERTICAL, new Component[] {realizarPagamento, btnCancelaCompra});
		
		productTable = new JTable();
		productTable.setRowHeight(20);
		productTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Item N\u00BA", "Id", "C\u00F3digo", "Descri\u00E7\u00E3o", "Valor R$"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, Long.class, String.class, String.class
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
		productTable.getColumnModel().getColumn(0).setPreferredWidth(73);
		productTable.getColumnModel().getColumn(1).setPreferredWidth(90);
		productTable.getColumnModel().getColumn(2).setPreferredWidth(112);
		productTable.getColumnModel().getColumn(3).setPreferredWidth(321);
		productTable.getColumnModel().getColumn(4).setPreferredWidth(112);
		painelProdutos.setViewportView(productTable);
		contentPane.setLayout(gl_contentPane);
	}
}
