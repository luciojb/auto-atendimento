package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
		removerProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					produtoDto = produtoDao.findByField("codigo_barras", codigo.getText());
					compraDto.setDataAtendimentoIn(new Date());
					compraDto.removeProduto(produtoDto);
					JOptionPane.showMessageDialog(null, "Produto removido com sucesso!");
				} catch (Exception ex) {
					productNotFound.setVisible(true);
				}
				
				codigo.setText("");
				codigo.requestFocus();
			}
		});
		removerProduto.setIcon(new ImageIcon(Atendimento.class.getResource("/img/removePr.png")));
		
		JButton btnCancelaCompra = new JButton("Cancela Compra");
		btnCancelaCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				compraDto = new CompraDTO();
				JOptionPane.showMessageDialog(null, "A compra do autoatendimento foi zerada!!");
			}
		});
		
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
		addWindowListener(new WindowAdapter(){ 
			  public void windowOpened( WindowEvent e){ 
			    codigo.requestFocus();
			  } 
			}); 
		
		productNotFound.setVisible(false);
		productNotFound.setFont(new Font("Dialog", Font.PLAIN, 15));
		productNotFound.setForeground(Color.RED);
		productNotFound.setEditable(false);
		productNotFound.setText("Produto não encontrado.");
		
		JTextPane txtpnTotal = new JTextPane();
		txtpnTotal.setFont(new Font("Monospaced", Font.BOLD, 23));
		txtpnTotal.setEditable(false);
		txtpnTotal.setText("TOTAL R$");
		txtpnTotal.setParagraphAttributes(center, false);
		
		JTextPane txtpnRte = new JTextPane();
		txtpnRte.setFont(new Font("Monospaced", Font.PLAIN, 23));
		txtpnRte.setForeground(Color.RED);
		txtpnRte.setText("0,00");
		txtpnRte.setEditable(false);
		txtpnRte.setParagraphAttributes(center, false);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(sair, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(painelProdutos, GroupLayout.PREFERRED_SIZE, 774, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(codigo, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
								.addComponent(productNotFound, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnCancelaCompra, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(removerProduto, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(77)
									.addComponent(realizarPagamento, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(29)
									.addComponent(txtpnTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(txtpnRte, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))
							.addGap(95))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(welcomeMessage, Alignment.LEADING)
							.addComponent(prodCompraText, Alignment.LEADING)
							.addComponent(textoPassarLeitor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(sair, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
						.addComponent(welcomeMessage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(textoPassarLeitor, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(prodCompraText, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(painelProdutos, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(codigo, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
								.addComponent(removerProduto))
							.addGap(24))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtpnRte, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtpnTotal, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnCancelaCompra, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addComponent(realizarPagamento, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
						.addComponent(productNotFound, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(37))
		);
		gl_contentPane.linkSize(SwingConstants.VERTICAL, new Component[] {realizarPagamento, btnCancelaCompra});
		gl_contentPane.linkSize(SwingConstants.VERTICAL, new Component[] {txtpnTotal, txtpnRte});
		
		DefaultTableModel model = new DefaultTableModel(
				new Object[][] {
					
				},
				new String[] {
					"Item N\u00BA", "Id", "C\u00F3digo", "Descri\u00E7\u00E3o", "Valor R$"
				}
			) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 3964191088995738892L;
				Class[] columnTypes = new Class[] {
					Integer.class, Long.class, Long.class, String.class, String.class
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
			};


		
		productTable = new JTable(model);
		productTable.setRowHeight(20);
		productTable.getColumnModel().getColumn(0).setPreferredWidth(73);
		productTable.getColumnModel().getColumn(1).setPreferredWidth(90);
		productTable.getColumnModel().getColumn(2).setPreferredWidth(112);
		productTable.getColumnModel().getColumn(3).setPreferredWidth(321);
		productTable.getColumnModel().getColumn(4).setPreferredWidth(112);
		for (ProdutoDTO p : compraDto.getListaProdutos()){
			model.addRow(new Object[]{compraDto.getListaProdutos().indexOf(p), p.getId(), p.getCodigoBarras(), p.getDescricao(), p.getValor()});
		}
		painelProdutos.setViewportView(productTable);
		contentPane.setLayout(gl_contentPane);
	}
}
