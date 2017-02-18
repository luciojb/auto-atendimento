package gui;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import DAO.ProdutoDAO;
import DTO.ProdutoDTO;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarProduto extends JFrame {

	private static final long serialVersionUID = 2867355572470306748L;
	private JPanel contentPane;
	private JTextField getCodigo;
	private JTextField getDesc;
	private JTextField getValor;
	private JTextField getQuantidade;
	private ProdutoDTO prdt;
	private ProdutoDAO prdao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarProduto frame = new EditarProduto();
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
	public EditarProduto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setVisible(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTextPane codigo = new JTextPane();
		codigo.setEditable(false);
		codigo.setText("Código:");
		
		JTextPane descricao = new JTextPane();
		descricao.setEditable(false);
		descricao.setText("Descrição:");
		
		JTextPane valor = new JTextPane();
		valor.setEditable(false);
		valor.setText("Valor R$");
		
		getCodigo = new JTextField();
		getCodigo.setColumns(10);
		addWindowListener(new WindowAdapter(){ 
			  public void windowOpened( WindowEvent e){ 
			    getCodigo.requestFocus();
			  } 
			});
		
		getDesc = new JTextField();
		getDesc.setColumns(10);
		
		getValor = new JTextField();
		getValor.setColumns(10);
		
		JButton salvar = new JButton("Salvar");
		salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getCodigo.getText().length()>1 && getDesc.getText().length()>1 && Integer.parseInt(getQuantidade.getText())>0 && Double.valueOf(getValor.getText())>0){
					try{
						prdt = new ProdutoDTO();
						prdt.setCodigoBarras(Long.parseLong(getCodigo.getText()));
						prdt.setDescricao(getDesc.getText());
						prdt.setQuantidade(Integer.parseInt(getQuantidade.getText()));
						prdt.setValor(Double.valueOf(getValor.getText()));
					} catch (Exception ex){
						System.err.println(ex);
					}
					
					if (prdt!=null){
						prdao = new ProdutoDAO();
						prdao.insert(prdt);
						dispose();
						CadastroProdutos cpr = new CadastroProdutos();
						cpr.setVisible(true);
					} else {
						JTextPane preenchaTodosOsCampos = new JTextPane();
						preenchaTodosOsCampos.setVisible(true);
					}
				}
			}
		});
		salvar.setIcon(new ImageIcon(EditarProduto.class.getResource("/img/save.png")));
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.setIcon(new ImageIcon(EditarProduto.class.getResource("/img/cancel.png")));
		
		JTextPane quantidade = new JTextPane();
		quantidade.setEditable(false);
		quantidade.setText("Quantidade: ");
		
		getQuantidade = new JTextField();
		getQuantidade.setColumns(10);
		
		JTextPane preenchaTodosOsCampos = new JTextPane();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		preenchaTodosOsCampos.setParagraphAttributes(center, false);
		preenchaTodosOsCampos.setForeground(Color.RED);
		preenchaTodosOsCampos.setCaretColor(Color.RED);
		preenchaTodosOsCampos.setBackground(Color.LIGHT_GRAY);
		preenchaTodosOsCampos.setEditable(false);
		preenchaTodosOsCampos.setText("Preencha todos os campos!");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(65, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(codigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(descricao, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
									.addGap(12)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(getDesc, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
										.addComponent(getCodigo, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(valor, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(getValor, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(quantidade, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(getQuantidade, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)))
							.addGap(55))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(salvar, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
							.addGap(47)
							.addComponent(cancelar, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addGap(70))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(preenchaTodosOsCampos, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
							.addGap(109))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(getCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(codigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(descricao, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(getDesc, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(getValor, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(valor, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(quantidade, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(getQuantidade, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(salvar, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(cancelar, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
					.addComponent(preenchaTodosOsCampos, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
