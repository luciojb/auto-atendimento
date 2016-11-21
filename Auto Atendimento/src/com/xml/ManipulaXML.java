package com.xml;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.io.File;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;
import com.classes.*;
import com.util.*;



public class ManipulaXML {
	final static String LOCALHOSTCOMPRAS = "src/xml.compras/";
	final static String LOCALHOSTCADASTROS = "src/xml.cadastros/";
	
	public static boolean gravarXMLCompra(Compra compra){
		// Elemento root do estabelecimento
		Element raiz = new Element("Compra");

		//Defie raiz como root
		Document documento = new Document(raiz);

		Element titulo = new Element("titulo");
		titulo.setText("Informacoes Auto Atendimento");

		Element dataAtendimentoIn = new Element("data_inicio_atendimento");
		dataAtendimentoIn.setText(Datas.DataHoraForStringPadraoH(compra.getDataAtendimentoIn()));
		
		Element dataAtendimentoFim = new Element("data_fim_atendimento");
		dataAtendimentoFim.setText(Datas.DataHoraForStringPadraoH(compra.getDataAtendimentoFim()));
		
		raiz.addContent(titulo);
		raiz.addContent(dataAtendimentoIn);
		raiz.addContent(dataAtendimentoFim);
		
		Element infoCompra = new Element("infoCompra");
		infoCompra.setAttribute("codigo", String.valueOf(compra.getCodigo()));

		
		Element pessoa = new Element("pessoa");
		pessoa.setAttribute("id", String.valueOf(lerXMLUltimoIdCliente()));
		
		if (!retornaCadastro(compra.getCliente().getCpf())){
			Element nome = new Element("nome");
			nome.setText(compra.getCliente().getNome());
			
			Element email = new Element("email");
			email.setText(compra.getCliente().getEmail());
			
			pessoa.addContent(nome);
			pessoa.addContent(email);
			
		} else {
			Element nome = new Element("nome");
			nome.setText(compra.getCliente().getNome());
	
			Element endereco = new Element("endereco");
			endereco.setText(String.valueOf(compra.getCliente().getEndereco()));
			
			Element email = new Element("email");
			email.setText(compra.getCliente().getEmail());
	
			Element cpf = new Element("cpf");
			cpf.setText(String.valueOf(compra.getCliente().getCpf()));
			
			Element rg = new Element("rg");
			rg.setText(String.valueOf(compra.getCliente().getRg()));
			
			pessoa.addContent(nome);
			pessoa.addContent(cpf);
			pessoa.addContent(endereco);
			pessoa.addContent(email);
			pessoa.addContent(rg);
		}
		
		Element produtos = new Element("produtos");
		
		for (Produto p: compra.getListaProdutos()){
			Element produto = new Element("produto");
			
			produto.setAttribute("id", String.valueOf(p.getId()));

			Element codBarra = new Element("codigo_barra");
			codBarra.setText(String.valueOf(p.getCodigoBarras()));
			
			Element descricao = new Element("descricao");
			descricao.setText(p.getDescricao());

			Element quantidade = new Element("quantidade");
			quantidade.setText(String.valueOf(p.getQuantidade()));
			
			Element valorUnit = new Element("valor_unitario");
			valorUnit.setText(String.valueOf(p.getValor()));
			
			Element valorTtl = new Element("valor_total");
			valorTtl.setText(String.valueOf(p.getValor()*p.getQuantidade()));
						
			produto.addContent(codBarra);
			produto.addContent(descricao);
			produto.addContent(quantidade);
			produto.addContent(valorUnit);
			produto.addContent(valorTtl);
			produtos.addContent(produto);
			
		}
		
		Element pagamento = new Element("pagamento");
		
		Element conta = new Element("numero_da_conta");
		conta.setText(String.valueOf(compra.getCliente().getCartao().getNumeroContaBancaria()));
		
		Element agencia = new Element("numero_da_agencia");
		conta.setText(String.valueOf(compra.getCliente().getCartao().getAgencia()));
		
		Element valorPago= new Element("valor_pago");
		conta.setText(String.valueOf(compra.calculaTotal(compra.getListaProdutos())));
		
		pagamento.addContent(conta);
		pagamento.addContent(agencia);
		pagamento.addContent(valorPago);
		
		
		infoCompra.addContent(pessoa);
		infoCompra.addContent(produtos);
		infoCompra.addContent(pagamento);
		
		raiz.addContent(infoCompra);

		//Classe responsável por criar / gerar o xml
		XMLOutputter xout = new XMLOutputter();	
		try {
			//criando o cupom da compra que estão na fila
			BufferedWriter cupom = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(LOCALHOSTCOMPRAS +  compra.getCodigo() + ".xml"),"UTF-8"));
			//imprimindo o xml no arquivo das pessoas
			xout.output(documento, cupom);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean realizaCadastro(Pessoa pessoa){
		
		return false;
	}
	
	public static boolean gravarXMLCadastro(Pessoa cliente){
		// Elemento root do estabelecimento
		Element raiz = new Element("Cadastro");

		//Defie raiz como root
		Document documento = new Document(raiz);

		Element titulo = new Element("titulo");
		titulo.setText("Cadastro Pessoal");

		Element data = new Element("data");
		data.setText(Datas.DataHoraForStringPadraoH(new Date()));
		
		raiz.addContent(titulo);
		raiz.addContent(data);
		
		Element pessoa = new Element("pessoa");
		
		Element nome = new Element("nome");
		nome.setText(cliente.getNome());

		Element endereco = new Element("endereco");
		
		Element pais = new Element("pais");
		pais.setText(String.valueOf(cliente.getEndereco().getPais()));
		
		Element estado = new Element("estado");
		estado.setText(String.valueOf(cliente.getEndereco().getEstado()));
				
		Element cidade = new Element("cidade");
		cidade.setText(String.valueOf(cliente.getEndereco().getCidade()));
		
		Element bairro = new Element("bairro");
		bairro.setText(String.valueOf(cliente.getEndereco().getBairro()));
				
		Element rua = new Element("rua");
		rua.setText(String.valueOf(cliente.getEndereco().getRua()));
		
		Element numeroCasa = new Element("numero_casa");
		numeroCasa.setText(String.valueOf(cliente.getEndereco().getNumeroCasa()));
				
		Element cep = new Element("cep");
		cep.setText(String.valueOf(cliente.getEndereco().getCep()));
		
		endereco.addContent(pais);
		endereco.addContent(estado);
		endereco.addContent(cidade);
		endereco.addContent(bairro);
		endereco.addContent(rua);
		endereco.addContent(numeroCasa);
		endereco.addContent(cep);
		
		
		Element idade = new Element("idade");
		idade.setText(String.valueOf(cliente.getIdade()));
		
		Element email = new Element("email");
		email.setText(cliente.getEmail());

		Element cpf = new Element("cpf");
		cpf.setText(String.valueOf(cliente.getCpf()));
		
		Element dataNascimento = new Element("data_nascimento");
		dataNascimento.setText(Datas.DataHoraForStringPadraoH(cliente.getDataNascimento()));
		
//POSTERIORMENTE CRIAR UM CARTÃO DA LOJA.
		
		pessoa.addContent(nome);
		pessoa.addContent(cpf);
		pessoa.addContent(idade);
		pessoa.addContent(dataNascimento);
		pessoa.addContent(endereco);
		pessoa.addContent(email);
		
		raiz.addContent(pessoa);

		//Classe responsável por criar / gerar o xml
		XMLOutputter xout = new XMLOutputter();	
		try {
			//criando o arquivo de saida do cadastro que estão na fila
			BufferedWriter cadastro = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(LOCALHOSTCADASTROS +  cliente.getId() + ".xml"),"UTF-8"));
			//imprimindo o xml no arquivo das pessoas
			xout.output(documento, cadastro);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean gravarXMLUltimoIdCliente(long id){
		// Elemento root do estabelecimento
		Element raiz = new Element("Ultimo_Id");

		//Defie raiz como root
		Document documento = new Document(raiz);

		Element titulo = new Element("titulo");
		titulo.setText("Último id registrado");

		Element data = new Element("data");
		data.setText(Datas.DataHoraForStringPadraoH(new Date()));
		
		raiz.addContent(titulo);
		raiz.addContent(data);
		
		Element idCliente = new Element("id");
		idCliente.setAttribute("id", String.valueOf(id));
		
		raiz.addContent(idCliente);

		//Classe responsável por criar / gerar o xml
		XMLOutputter xout = new XMLOutputter();	
		try {
			//criando o arquivo de saida do cadastro que estão na fila
			BufferedWriter ultimoId = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(LOCALHOSTCADASTROS + "lastId.xml"),"UTF-8"));
			//imprimindo o xml no arquivo das pessoas
			xout.output(documento, ultimoId);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static Boolean retornaCadastro(String cpf){
		List<Pessoa> cadastros = lerXMLCadastros();
		for (Pessoa p: cadastros){
			if (cpf == p.getCpf()){
				cadastros.clear();
				return true;
			}
		}
		cadastros.clear();
		return false;
	}
	
	public static List<Pessoa> lerXMLCadastros(){
		List<Pessoa> cadastros = new ArrayList<>();
		Document documento = null;
		SAXBuilder construtor = new SAXBuilder();	
		
		File pastaCadastros = new File(LOCALHOSTCADASTROS);
		File[] listaCadastros = pastaCadastros.listFiles();
		
		for (File file : listaCadastros) {
	    	try { 
				documento = construtor.build(LOCALHOSTCADASTROS + file);
			} catch (Exception e) {
				e.printStackTrace();       
		    }
		
			Element element = documento.getRootElement();
				
			Pessoa pes = new Pessoa();
			pes.setId(Long.parseLong(element.getAttributeValue("id")));
			pes.setCpf(element.getChildText("cpf"));
			pes.setRg(element.getChildText("rg"));
			pes.setIdade(Integer.parseInt(element.getChildText("idade")));
			pes.setNome(element.getChildText("nome"));
			Endereco address = new Endereco();
			address.setPais(element.getChild("endereco").getChildText("pais"));
			address.setEstado(element.getChild("endereco").getChildText("estado"));
			address.setCidade(element.getChild("endereco").getChildText("cidade"));
			address.setBairro(element.getChild("endereco").getChildText("bairro"));
			address.setRua(element.getChild("endereco").getChildText("rua"));
			address.setNumeroCasa(Integer.parseInt(element.getChild("endereco").getChildText("numero_casa")));
			address.setCep(Integer.parseInt(element.getChild("endereco").getChildText("cep")));
			pes.setEndereco(address);
			pes.setEmail(element.getChildText("email"));
			try{
				pes.setDataNascimento(Datas.StringParaDataHora(element.getChildText("data_nascimento")));
			} catch(ParseException pE){
				pE.printStackTrace();
			}
			cadastros.add(pes);
		}
		return cadastros;
	}
	
	public static long lerXMLUltimoIdCliente(){
		long id=0;
		
		return id;
	}
	
}
