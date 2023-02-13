package util.ws;

import java.io.OutputStreamWriter;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;


public class Teste {

	public static void main(String args[]) throws java.io.IOException {
		String codigoAutorizacao = "";
		String mensagemAutorizacao = "";
		String codigoCaptura = "";
		String mensagemCaptura = "";
		String id = "";
		java.net.URL url;
		java.net.HttpURLConnection connection = null;
		try {

			//---teste
			//url = new java.net.URL("https://qasecommerce.cielo.com.br/servicos/ecommwsec.do");
			
			//--- producao
			url = new java.net.URL("https://ecommerce.cbmp.com.br/servicos/ecommwsec.do");
			
			connection = (java.net.HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);

			java.text.SimpleDateFormat sd = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dataHora = sd.format(new java.util.Date()).replace(" ", "T");
			System.out.println("Aguarde, efetuando transacao...");
			StringBuilder sb = new StringBuilder();
			sb.append("mensagem=<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>");
			sb.append("<requisicao-transacao id=\"1\" versao=\"1.2.0\">");
			sb.append("  <dados-ec>");
			
			/* Empresa 02 
			sb.append("	   <numero>1036334764</numero>");
			sb.append("	     <chave>ecc271099437889452c96c6810a8f7cc5c0016300855f1455d82762e7416c2ef</chave>");
			*/

			/* Empresa 01 */
			sb.append("	   <numero>1032141350</numero>");
			sb.append("	   <chave>d96e40b7e0cfa035e400da1a1bd9ad8dfc6c53ca52265083873d7b8ff3b508bd</chave>");			
			
			sb.append("	 </dados-ec>");
			sb.append("	 <dados-portador>");
			
			//---Meu cartao ---
			sb.append("	   <numero>4411749003666820</numero>");
			sb.append("	   <validade>201606</validade>");
			sb.append("	   <indicador>1</indicador>");
			sb.append("	   <codigo-seguranca>818</codigo-seguranca>");
			sb.append("    <nome-portador>MARIA C K FORELL</nome-portador>");
			sb.append("	 </dados-portador>");
			sb.append("	 <dados-pedido>");
			sb.append("	   <numero>9999</numero>");
			sb.append("	   <valor>100</valor>");
			sb.append("	   <moeda>986</moeda>");
			sb.append("	   <data-hora>").append(dataHora).append("</data-hora>");
			sb.append("	   <descricao>[origem:10.50.54.156]</descricao>");
			sb.append("	   <idioma>PT</idioma>");
			sb.append("	   <soft-descriptor></soft-descriptor>");
			sb.append("	 </dados-pedido>");
			sb.append("	 <forma-pagamento>");
			sb.append("	   <bandeira>visa</bandeira>");
			sb.append("	   <produto>1</produto>");  
			//
			// produto: 1=credito a vista   2=parcelado loja   3=parcelado administradora
			//
			//
			sb.append("	   <parcelas>1</parcelas>");
			sb.append("	 </forma-pagamento>");
			sb.append("	 <url-retorno>null</url-retorno>");
			sb.append("	 <autorizar>3</autorizar>");
			sb.append("	 <capturar>true</capturar>");
			sb.append("</requisicao-transacao>");

			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "ISO-8859-1");
			out.write(sb.toString());
			out.close();

			java.io.InputStream is = connection.getInputStream();
			java.io.BufferedReader rd = new java.io.BufferedReader(new java.io.InputStreamReader(is));
			String line;
			StringBuffer response = new StringBuffer();
			StringBuilder sbResposta = new StringBuilder();
			while ((line = rd.readLine()) != null) {
				sbResposta.append(line);
				System.out.println(line);
				response.append(line);
				response.append('\r');
			}
			rd.close();

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
					NodeList title = element.getElementsByTagName("mensagem");
					line2 = (Element) title.item(0);
					mensagemCaptura = getCharacterDataFromElement(line2);
				}
				// 6= autorizada
				
				NodeList nodeAutorizacao = doc.getElementsByTagName("autorizacao");
				for (int i = 0; i < nodeAutorizacao.getLength(); i++) {
					Element element = (Element) nodeAutorizacao.item(i);
					NodeList name = element.getElementsByTagName("codigo");
					Element line2 = (Element) name.item(0);
					codigoAutorizacao = getCharacterDataFromElement(line2);
					NodeList title = element.getElementsByTagName("mensagem");
					line2 = (Element) title.item(0);
					mensagemAutorizacao = getCharacterDataFromElement(line2);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}


		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(codigoAutorizacao);
			System.out.println(mensagemAutorizacao);
			System.out.println(codigoCaptura);
			System.out.println(mensagemCaptura);
			System.out.println(id);
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

	public static String getCharacterDataFromElement(Element e) {
		Node child = e.getFirstChild();
		if (child instanceof CharacterData) {
			CharacterData cd = (CharacterData) child;
			return cd.getData();
		}
		return "?";
	}

}
