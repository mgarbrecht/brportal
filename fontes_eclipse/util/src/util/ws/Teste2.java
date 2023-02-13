package util.ws;

import java.io.OutputStreamWriter;


public class Teste2 {
	
	private String id;
	
	public Teste2(String id){
		this.id = id;
	}

	public void consultar(){

		java.net.URL url;
		java.net.HttpURLConnection connection = null;
		try {

			//teste
			//url = new java.net.URL("https://qasecommerce.cielo.com.br/servicos/ecommwsec.do");
			 
			//produção
			url = new java.net.URL("https://ecommerce.cbmp.com.br/servicos/ecommwsec.do");
			

			connection = (java.net.HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true); 

			StringBuilder sb = new StringBuilder();
			sb.append("mensagem=<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>");
			sb.append("<requisicao-consulta versao=\"1.2.0\" id=\"6560a94c-663b-4aec-9a45-e45f278e00b4\" xmlns=\"http://ecommerce.cbmp.com.br\">");
			sb.append("<tid>"+this.id+"</tid>");
			sb.append("	<dados-ec>");
			sb.append("<numero>1032141350</numero>");
			sb.append("<chave>d96e40b7e0cfa035e400da1a1bd9ad8dfc6c53ca52265083873d7b8ff3b508bd</chave>");
			sb.append("</dados-ec>");
			sb.append("</requisicao-consulta>");


			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "ISO-8859-1");
			out.write(sb.toString());
			out.close();
			

			java.io.InputStream is = connection.getInputStream();
			java.io.BufferedReader rd = new java.io.BufferedReader(new java.io.InputStreamReader(is));
			String line;
			StringBuffer response = new StringBuffer();
			
			System.out.println("");
			System.out.println("CONSULTA : ");
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
