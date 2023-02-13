package util.ws;

import java.io.OutputStreamWriter;

public class Teste5RequisicaoAutorizacaoTid {
	
	private String id;
	
	public Teste5RequisicaoAutorizacaoTid(String id){
		this.id = id;
	}

	public void cancelar(){

		java.net.URL url;
		java.net.HttpURLConnection connection = null;
		try {
			//

			// url = new
			// java.net.URL("https://ecommerce.cbmp.com.br/servicos/ecommwsec.do");
			// teste

			//url = new java.net.URL("https://qasecommerce.cielo.com.br/servicos/ecommwsec.do");
			url = new java.net.URL("https://ecommerce.cbmp.com.br/servicos/ecommwsec.do");
			connection = (java.net.HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true); 

			StringBuilder sb = new StringBuilder();
			sb.append("mensagem=<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>");
			sb.append("<requisicao-autorizacao-tid versao=\"1.2.0\" id=\"1\" xmlns=\"http://ecommerce.cbmp.com.br\">");
			sb.append("<tid>"+this.id+"</tid>");
			sb.append("	<dados-ec>");
			sb.append("		<numero>1036334764</numero>");
			sb.append("		<chave>ecc271099437889452c96c6810a8f7cc5c0016300855f1455d82762e7416c2ef</chave>");
			sb.append("	</dados-ec>");
			sb.append("</requisicao-autorizacao-tid>");


			// Send request
			// java.io.DataOutputStream wr = new
			// java.io.DataOutputStream(connection.getOutputStream());
			// wr.writeBytes(sb.toString());
			// wr.flush();
			// wr.close();

			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "ISO-8859-1");
			out.write(sb.toString());
			out.close();
			

			java.io.InputStream is = connection.getInputStream();
			java.io.BufferedReader rd = new java.io.BufferedReader(new java.io.InputStreamReader(is));
			String line;
			StringBuffer response = new StringBuffer();
			
			System.out.println("");
			System.out.println("CANCELAMENTO : ");
			System.out.println("");			
			while ((line = rd.readLine()) != null) {
				System.out.println(line);
				response.append(line);
				response.append('\r');
			}
			rd.close();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}

	}
}
