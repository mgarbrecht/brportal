package util.ws;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
//import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

public class Cielo {

	public static void main(String args[]) throws Exception {
		try {
			URL url = new URL("https://ecommerce.cbmp.com.br/servicos/ecommwsec.do");

			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			connection.setRequestProperty("Content-Type","text/xml; charset=\"utf-8\"");
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
		
			StringBuilder sb = new StringBuilder();
			sb.append("<?xml version='1.0' encoding='ISO-8859-1'?><requisicao-autorizacao-portador id='7' versao='1.1.0'>");
			sb.append("<tid>1</tid><dados-ec><numero>1</numero><chave>1</chave></dados-ec><dados-cartao><numero>1</numero>");
			sb.append("<validade>1</validade><indicador>1</indicador><codigo-seguranca>1</codigo-seguranca><nome-portador>1</nome-portador>");
			sb.append("</dados-cartao><dados-pedido><numero>1</numero><valor>1</valor>");
			sb.append("<moeda>986</moeda><data-hora>1</data-hora><idioma>PT</idioma></dados-pedido>");
			sb.append("<forma-pagamento><bandeira>1</bandeira><produto>1</produto><parcelas>1</parcelas>");
			sb.append("</forma-pagamento><capturar-automaticamente>1</capturar-automaticamente></requisicao-autorizacao-portador>");

			writer.write(sb.toString());
			writer.flush();
			writer.close();

			// reading the response

			InputStreamReader reader = new InputStreamReader(
					connection.getInputStream());

			StringBuilder buf = new StringBuilder();
			char[] cbuf = new char[2048];
			int num;
			while (-1 != (num = reader.read(cbuf))) {
				buf.append(cbuf, 0, num);
			}
			String result = buf.toString();
			System.out.println(result);
			// ---------------------
			InputStream responseBodyStream = connection.getInputStream();
			connection.disconnect();
			responseBodyStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//reader.close();
		}
	}

}
