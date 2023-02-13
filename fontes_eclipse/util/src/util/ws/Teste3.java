package util.ws;

import java.io.OutputStreamWriter;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class Teste3 {

	private String id;

	public Teste3(String id) {
		this.id = id;
	}

	public String cancelar() {
		boolean efetuouCancelamento = false;
		String retorno = "";
		java.net.URL url;
		java.net.HttpURLConnection connection = null;
		try {
			url = new java.net.URL(
					"https://ecommerce.cbmp.com.br/servicos/ecommwsec.do");
			connection = (java.net.HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);

			StringBuilder sb = new StringBuilder();
			sb.append("mensagem=<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>");
			sb.append("<requisicao-cancelamento versao=\"1.2.0\" id=\"6560a94c-663b-4aec-9a45-e45f278e00b4\" xmlns=\"http://ecommerce.cbmp.com.br\">");
			sb.append("<tid>" + this.id + "</tid>");
			sb.append("	<dados-ec>");
			sb.append("		<numero>1032141350</numero>");
			sb.append("		<chave>d96e40b7e0cfa035e400da1a1bd9ad8dfc6c53ca52265083873d7b8ff3b508bd</chave>");
			sb.append("	</dados-ec>");
			sb.append("	<valor>00</valor>");
			sb.append("</requisicao-cancelamento>");

			OutputStreamWriter out = new OutputStreamWriter(
					connection.getOutputStream(), "ISO-8859-1");
			out.write(sb.toString());
			out.close();

			java.io.InputStream is = connection.getInputStream();
			java.io.BufferedReader rd = new java.io.BufferedReader(
					new java.io.InputStreamReader(is));
			String line;
			StringBuffer response = new StringBuffer();

			while ((line = rd.readLine()) != null) {
				System.out.println(line);
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
				efetuouCancelamento = true;
				System.out.println(efetuouCancelamento);
			}
			System.out.println(efetuouCancelamento);
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

	public static String getCharacterDataFromElement(Element e) {
		Node child = e.getFirstChild();
		if (child instanceof CharacterData) {
			CharacterData cd = (CharacterData) child;
			return cd.getData();
		}
		return "?";
	}

}
