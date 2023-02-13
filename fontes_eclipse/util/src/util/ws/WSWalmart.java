package util.ws;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.net.ssl.HttpsURLConnection;
//import com.thoughtworks.xstream.XStream;

public class WSWalmart {

	public void processar(){
		try {
			buscaXml();	
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	private void buscaXml() throws Exception {
		PreparedStatement pstm = null;
		ResultSet rset = null;
		com.egen.util.jdbc.JdbcUtil j = null;
		try {
			j = new com.egen.util.jdbc.JdbcUtil();
			StringBuilder query = new StringBuilder();
			query.append(" SELECT cf.numero ");
			query.append("      , e.etr_cgc ");
			query.append("      , to_char(cf.data_emissao,'yyyymmdd') data_emissao ");
			query.append("  FROM conhecimentos_fretes cf ");
			query.append("     , tra t ");
			query.append("     , etr e ");
			query.append(" WHERE numero = ? ");
			query.append("   AND t.for_codigo = cf.fen_for_codigo ");
			query.append("   AND e.tra_cdgo = t.tra_cdgo ");
			query.append("   AND e.etr_seqn = TO_CHAR(cf.fen_seq) ");
		    pstm = j.getConn().prepareStatement(query.toString());
            rset = pstm.executeQuery();
            while(rset.next()) {
            	gravaArquivo(rset.getString("arquivo"));
            	enviaXml("0","0");
            }		
            
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if(rset != null){
				rset.close();
			}
			if(pstm != null){
				pstm.close();
			}
			if(j != null){
				j.close();
			}			
		}	
	}
	
	private void gravaArquivo(String arquivo) throws Exception {
	  //URL url = new URL("http://10.0.0.44:9999/xml/br_fil16/notas_xml/2010-12-28/43101288379771001669550010000611061000611060-procNFe.xml");
		URL url = new URL("http://10.0.0.44:9999/xml/"+arquivo);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		
		byte buffer[] = new byte[8192];
		int read = 0;
		connection.connect();
		InputStream responseBodyStream = connection.getInputStream();
	    FileOutputStream os = new FileOutputStream("/home/loja_brportal/xml/" + arquivo.substring(arquivo.lastIndexOf("/")+1,arquivo.length()));
		while ((read = responseBodyStream.read(buffer)) != -1) {
			os.write(buffer, 0, read);
		}
		connection.disconnect();
		responseBodyStream.close();
		os.close();
		os.flush();
	}
	
	private void enviaXml (String cdUsua, String xml) throws Exception {
		final String TIPO = "J";
		FileInputStream stream = new FileInputStream(xml);
		InputStreamReader streamReader = new InputStreamReader(stream);
		BufferedReader reader = new BufferedReader(streamReader);
		StringBuilder sbXml = new StringBuilder();
		try {
			//XStream xstream = new XStream();
			//xstream.alias("SqlExecutionRetn", NotaFiscal.class);
			
			String line = null;
			while ((line = reader.readLine()) != null) {
				sbXml.append(line.trim());
			}

			String parametros = URLEncoder.encode("pa_tp_cd_usua", "UTF-8") + "=" + URLEncoder.encode(TIPO, "UTF-8"); 
			parametros+= "&" + URLEncoder.encode("pa_cd_usua", "UTF-8") + "=" + URLEncoder.encode(cdUsua, "UTF-8");
			parametros+= "&" + URLEncoder.encode("pa_ds_xml_nfe", "UTF-8") + "=" + URLEncoder.encode(sbXml.toString(), "UTF-8");
			
			URL url = new URL("https://portalnfe.walmart.com.br/GNFe_Port_ws/cls_403_nfe_xml.asmx/fu_upld?"+parametros);
			HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			//---------------------
			InputStream responseBodyStream = connection.getInputStream();
			//NotaFiscal testenf;//= (NotaFiscal) xstream.fromXML(responseBodyStream);
			connection.disconnect(); 
			responseBodyStream.close();
			//---------------------
			//System.out.println(testenf.getReturn_code()+" - "+testenf.getReturn_chav());
			//---------------------
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			reader.close();
			streamReader.close();
			stream.close();
		}	
	}
	
		
	
}
