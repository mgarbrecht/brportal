package util.ws;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Rest {
	
	public void buscaArquivo(String conhec, String arquivo) throws IOException {
		String filial = null;
		String dataEmissao = null;
		String conhecimento = null;
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
		    pstm.setString(1, conhec);
            rset = pstm.executeQuery();
            if(rset.next()) {
            	conhecimento = rset.getString("numero");
            	conhecimento = (conhecimento.substring(((conhecimento.length())-6),conhecimento.length()));
            	filial = rset.getString("etr_cgc");
            	filial = (filial.substring(((filial.length())-5),(filial.length())-2));            	
            	dataEmissao = rset.getString("data_emissao");
            }
//    		URL url = new URL("http://ws.tntbrasil.com.br/services/rs/WorkImageService/getImagemConhecimento?cdFilial="+filial+"&nrConhecimento="+conhecimento+"&dtEmissao="+dataEmissao+"&usuario=rafael_silva@beirario.com.br&senha=logistica2");
            URL url = new URL("http://ws.tntbrasil.com.br/services/rs/WorkImageService/getImagemConhecimento?cdFilial="+filial+"&nrConhecimento="+conhecimento+"&dtEmissao="+dataEmissao+"&usuario=debora_engelmann@beirario.com.br&senha=logistica2");
    		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    		connection.setRequestMethod("POST");
    		
    		byte buffer[] = new byte[8192];
    		int read = 0;
    		connection.connect();
    		InputStream responseBodyStream = connection.getInputStream();
    	    FileOutputStream os = new FileOutputStream("/opt/tomcat/webapps/brportal/temp/"+arquivo);
    		while ((read = responseBodyStream.read(buffer)) != -1) {
    			os.write(buffer, 0, read);
    		}
    		connection.disconnect();
    		responseBodyStream.close();
    		os.close();
    		os.flush();
    		File f = new File("/opt/tomcat/webapps/brportal/temp/"+arquivo);
    		if(f.length()==0){
    			Runtime run = Runtime.getRuntime();
    			Process task = run.exec("cp /opt/tomcat/webapps/brportal/system/semConhecimento.pdf /opt/tomcat/webapps/brportal/temp/" + arquivo);
    			task.waitFor();
    			task.destroy();
    		}
		} catch (Exception e){
			e.printStackTrace();
		}finally {
			if(j!=null){
				j.close();
			}
		}
	}
}
