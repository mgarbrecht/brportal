package util.cielo;

import util.consultas.Parametros;
import util.consultas.Query;
import util.email.EmailUtil;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;
import org.w3c.dom.CharacterData;
import org.xml.sax.InputSource;

/**
 *
 * @author mateus_garbrecht
 */
public class CartaoCredito {

	private String estabelecimento = "1032141350";
	private String chave = "d96e40b7e0cfa035e400da1a1bd9ad8dfc6c53ca52265083873d7b8ff3b508bd";
	private final String IDIOMA = "PT";
	private final int MOEDA = 986;
	private final int AUTORIZAR = 3;
	private final boolean CAPTURAR = true;
	private String usuario;
	private String numeroNegociacao;
	private String bandeira;
	private String nomeTitular;
	private String numeroCartao;
	private String mesValidade;
	private String anoValidade;
	private String codigoSeguranca;
	private String condicaoPagamento;
	private Double valor;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getCondicaoPagamento() {
		return condicaoPagamento;
	}

	public void setCondicaoPagamento(String condicaoPagamento) {
		this.condicaoPagamento = condicaoPagamento;
	}

	public String getNumeroNegociacao() {
		return numeroNegociacao;
	}

	public void setNumeroNegociacao(String numeroNegociacao) {
		this.numeroNegociacao = numeroNegociacao;
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getMesValidade() {
		return mesValidade;
	}

	public void setMesValidade(String mesValidade) {
		this.mesValidade = mesValidade;
	}

	public String getAnoValidade() {
		return anoValidade;
	}

	public void setAnoValidade(String anoValidade) {
		this.anoValidade = anoValidade;
	}

	public String getCodigoSeguranca() {
		return codigoSeguranca;
	}

	public void setCodigoSeguranca(String codigoSeguranca) {
		this.codigoSeguranca = codigoSeguranca;
	}

	public String processaTransacao() {
		Query query = new Query();
		StringBuilder sbEmail = new StringBuilder();
		String retorno = "";
		String codigoAutorizacao = "";
		String codigoCaptura = "";
		int numeroParcelas = 1;
		int produto = 1;
		java.net.URL url;
		java.net.HttpURLConnection connection = null;
		try {
			if (this.condicaoPagamento.equalsIgnoreCase("1")) {
				numeroParcelas = 1;
				produto = 1;
			} else if (this.condicaoPagamento.equals("2")) {
				numeroParcelas = 2;
				produto = 2;
			} else if (this.condicaoPagamento.equalsIgnoreCase("3")) {
				numeroParcelas = 3;
				produto = 2;
			}
			url = new java.net.URL("https://ecommerce.cbmp.com.br/servicos/ecommwsec.do");
			connection = (java.net.HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			String dataHora = query.retorna("select to_char(sysdate,'yyyy-mm-dd HH24:mi:ss') from dual").replace(" ","T");
			StringBuilder sbXML = new StringBuilder();
			sbXML.append("mensagem=<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>");
			sbXML.append("<requisicao-transacao id=\"1\" versao=\"1.2.0\">");
			sbXML.append("   <dados-ec>");
			sbXML.append("      <numero>").append(estabelecimento).append("</numero>");
			sbXML.append("      <chave>").append(chave).append("</chave>");
			sbXML.append("   </dados-ec>");
			sbXML.append("   <dados-portador>");
			sbXML.append("      <numero>").append(this.numeroCartao.replace("-", "")).append("</numero>");
			sbXML.append("	     <validade>").append(this.anoValidade).append(this.mesValidade).append("</validade>");
			sbXML.append("	     <indicador>1</indicador>");
			sbXML.append("	     <codigo-seguranca>").append(this.codigoSeguranca).append("</codigo-seguranca>");
			sbXML.append("      <nome-portador>").append(this.nomeTitular.toUpperCase()).append("</nome-portador>");
			sbXML.append("   </dados-portador>");
			sbXML.append("   <dados-pedido>");
			sbXML.append("      <numero>").append(numeroNegociacao).append("</numero>");
			sbXML.append("	     <valor>").append(valorSemFormato(this.valor)).append("</valor>");
			sbXML.append("	     <moeda>").append(MOEDA).append("</moeda>");
			sbXML.append("	     <data-hora>").append(dataHora).append("</data-hora>");
			sbXML.append("	     <descricao>Negociacao ").append(numeroNegociacao).append(". Origem: BR Portal Beira Rio. Usuario: ").append(usuario).append("</descricao>");
			sbXML.append("	     <idioma>").append(IDIOMA).append("</idioma>");
			sbXML.append("	     <soft-descriptor></soft-descriptor>");
			sbXML.append("   </dados-pedido>");
			sbXML.append("   <forma-pagamento>");
			sbXML.append("      <bandeira>").append(bandeira).append("</bandeira>");
			sbXML.append("	     <produto>").append(produto).append("</produto>");
			sbXML.append("	     <parcelas>").append(numeroParcelas).append("</parcelas>");
			sbXML.append("   </forma-pagamento>");
			sbXML.append("   <url-retorno>null</url-retorno>");
			sbXML.append("   <autorizar>").append(AUTORIZAR).append("</autorizar>");
			sbXML.append("   <capturar>").append(CAPTURAR).append("</capturar>");
			sbXML.append("</requisicao-transacao>");
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "ISO-8859-1");
			out.write(sbXML.toString());
			out.close();
			String id = "";
			StringBuilder response = new StringBuilder();
			StringBuilder sbResposta = new StringBuilder();
			java.io.InputStream is = connection.getInputStream();
			java.io.BufferedReader rd = new java.io.BufferedReader(new java.io.InputStreamReader(is));
			String line;
			List<String> res = new ArrayList<String>();
			while ((line = rd.readLine()) != null) {
				sbResposta.append(line);
				res.add(line);
				sbEmail.append(line.replace("<", "&lt;").replace(">", "&gt;")).append("<br>");
				response.append(line);
				response.append('\r');
			}
			rd.close();
			gravaArquivoXml(res, this.numeroNegociacao);
			enviaEmail(sbEmail, this.numeroNegociacao);
			try {
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder db = dbf.newDocumentBuilder();
				InputSource isXml = new InputSource();
				isXml.setCharacterStream(new StringReader(sbResposta.toString()));
				Document doc = db.parse(isXml);
				NodeList nTid = doc.getElementsByTagName("tid");
				for (int i = 0; i < nTid.getLength(); i++) {
					Node n = nTid.item(0);
					id = n.getTextContent();
				}
				NodeList nodes = doc.getElementsByTagName("captura");
				for (int i = 0; i < nodes.getLength(); i++) {
					Element element = (Element) nodes.item(i);
					NodeList name = element.getElementsByTagName("codigo");
					Element line2 = (Element) name.item(0);
					codigoCaptura = getCharacterDataFromElement(line2);
				}
				NodeList nodeAutorizacao = doc.getElementsByTagName("autorizacao");
				for (int i = 0; i < nodeAutorizacao.getLength(); i++) {
					Element element = (Element) nodeAutorizacao.item(i);
					NodeList name = element.getElementsByTagName("codigo");
					Element line2 = (Element) name.item(0);
					codigoAutorizacao = getCharacterDataFromElement(line2);
				}
				if (codigoAutorizacao.equals("6") && codigoCaptura.equals("6")) {
					retorno = id;
				}
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
		return retorno;
	}

	public String cancelaTransacao(String tid) {
		String retorno = "";
		java.net.URL url;
		java.net.HttpURLConnection connection = null;
		try {
			url = new java.net.URL("https://ecommerce.cbmp.com.br/servicos/ecommwsec.do");
			connection = (java.net.HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			StringBuilder sb = new StringBuilder();
			sb.append("mensagem=<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>");
			sb.append("<requisicao-cancelamento versao=\"1.2.0\" id=\"6560a94c-663b-4aec-9a45-e45f278e00b4\" xmlns=\"http://ecommerce.cbmp.com.br\">");
			sb.append("<tid>").append(tid).append("</tid>");
			sb.append("	<dados-ec>");
			sb.append("		<numero>1032141350</numero>");
			sb.append("		<chave>d96e40b7e0cfa035e400da1a1bd9ad8dfc6c53ca52265083873d7b8ff3b508bd</chave>");
			sb.append("	</dados-ec>");
			sb.append("	<valor>00</valor>");
			sb.append("</requisicao-cancelamento>");
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "ISO-8859-1");
			out.write(sb.toString());
			out.close();
			java.io.InputStream is = connection.getInputStream();
			java.io.BufferedReader rd = new java.io.BufferedReader(new java.io.InputStreamReader(is));
			String line;
			StringBuffer response = new StringBuffer();
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\r');
			}
			rd.close();
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			InputSource isXml = new InputSource();
			isXml.setCharacterStream(new StringReader(response.toString()));
			Document doc = db.parse(isXml);
			NodeList nodeAutorizacao = doc.getElementsByTagName("cancelamento");
			for (int i = 0; i < nodeAutorizacao.getLength(); i++) {
				Element element = (Element) nodeAutorizacao.item(i);
				NodeList name = element.getElementsByTagName("codigo");
				Element line2 = (Element) name.item(0);
				NodeList title = element.getElementsByTagName("mensagem");
				line2 = (Element) title.item(0);
				retorno = getCharacterDataFromElement(line2);
			}
			if (retorno.indexOf("sucesso") != -1) {
				retorno = "sucesso";
			}
		} catch (Exception e) {
			retorno = e.getMessage();
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
		return retorno;
	}

	public String getCharacterDataFromElement(Element e) {
		Node child = e.getFirstChild();
		if (child instanceof CharacterData) {
			CharacterData cd = (CharacterData) child;
			return cd.getData();
		}
		return "?";
	}

	public String valorSemFormato(double valor) {
		String retorno;
		DecimalFormat df = new DecimalFormat("##.00");
		String valorFormatado = df.format(valor);
		retorno = (valorFormatado.replace(".", "")).replace(",", "");
		return retorno;
	}

	private void gravaArquivoXml(List<String> lista, String numeroNegociacao) {
		Parametros parametros = new Parametros();
		try {
			String diretorioXml = parametros.retornaParametro("diretorio_arquivos_xml");
			if (diretorioXml.equals("") || diretorioXml == null) {
				diretorioXml = "/home/loja_brportal/xml/brportal";
			}
			File f = new File(diretorioXml + "/" + numeroNegociacao + ".xml");
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			for (String s : lista) {
				bw.write(s);
				bw.newLine();
			}
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	private void enviaEmail(StringBuilder sbEmail, String numeroNegociacao) {
		EmailUtil emailUtil = new EmailUtil();
		java.sql.PreparedStatement pstm = null;
		java.sql.ResultSet rset = null;
		com.egen.util.jdbc.JdbcUtil j = null;
		try {
			j = new com.egen.util.jdbc.JdbcUtil();
			StringBuilder sbQuery = new StringBuilder();
			sbQuery.append(" SELECT valor ");
			sbQuery.append("   FROM wbrio.parametros ");
			sbQuery.append("  WHERE par_sist_codigo = 'BRNET' ");
			sbQuery.append("    AND nome = 'email_envio_xml_cielo' ");
			emailUtil.inicializa();
			emailUtil.setRemetente("BR Portal");
			pstm = j.getConn().prepareStatement(sbQuery.toString());
			rset = pstm.executeQuery();
			int contador = 0;
			while (rset.next()) {
				contador++;
				if (contador == 1) {
					emailUtil.setEmailDestinatario(rset.getString("valor"));
				} else {
					emailUtil.adicionaCC(rset.getString("valor"));
				}
			}
			emailUtil.setAssunto("BR Portal - Pagamento com cartao de credito. Negociacao: " + numeroNegociacao);
			emailUtil.adicionaLinha(sbEmail.toString());
			emailUtil.enviarEmail();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (j != null) {
				j.close();
				j = null;
			}
		}
	}
}
