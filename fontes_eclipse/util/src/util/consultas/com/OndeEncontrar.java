package util.consultas.com;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class OndeEncontrar {
		
	public String geraExcel ( String query ) throws Exception {
		
		HSSFWorkbook wb=new HSSFWorkbook();
	    org.apache.poi.hssf.usermodel.HSSFRow trow;
	    org.apache.poi.hssf.usermodel.HSSFCell tcell;
	    org.apache.poi.hssf.usermodel.HSSFCellStyle style;
	    org.apache.poi.hssf.usermodel.HSSFCellStyle stylecenterborda;
	    org.apache.poi.hssf.usermodel.HSSFCellStyle stylecenter;
	    org.apache.poi.hssf.usermodel.HSSFCellStyle styleright;
	    org.apache.poi.hssf.usermodel.HSSFCellStyle styleGrade;
	    java.sql.PreparedStatement pstm = null;
	    java.sql.ResultSet rset = null;
		com.egen.util.jdbc.JdbcUtil j = null;
		StringBuilder nomeArquivo = new StringBuilder();
		int rowcount = 0;
		boolean novaPlanilha = true;
		String retorno = "";
        int planilha = 0;
		boolean gerou = false;
		util.consultas.Parametros parametros = new util.consultas.Parametros();		
	    try {
	    	HSSFSheet testsheet = null;
	    	nomeArquivo.append("ondeencontrar").append(util.rand.Palavra.geraPalavra()).append(".xls");	    	
	        style = wb.createCellStyle();
	        stylecenter = wb.createCellStyle();
	        styleright = wb.createCellStyle();
	        stylecenterborda = wb.createCellStyle();
	        styleGrade = wb.createCellStyle();
	        styleGrade.setBorderLeft((short)1);
	        styleGrade.setBorderRight((short)1);
	        styleGrade.setBorderTop((short)1);
	        styleGrade.setBorderBottom((short)1);
	        styleGrade.setAlignment((short)2);
	        style.setBorderBottom((short)1);
	        style.setAlignment((short)1);
	        stylecenterborda.setBorderBottom((short)1);
	        stylecenterborda.setAlignment((short)2);
	        stylecenter.setAlignment((short)2);
	        styleright.setAlignment((short)4);
	        FileOutputStream fos=new FileOutputStream(parametros.retornaParametro("diretorio_pdf")+nomeArquivo.toString());
		    j = new com.egen.util.jdbc.JdbcUtil();
		    pstm = j.getConn().prepareStatement(query);
		    rset = pstm.executeQuery();
		    while (rset.next()) {
		    	gerou = true;
		    	if(rowcount > 65000){
		    		novaPlanilha = true;
		    		rowcount = 0;
		    	}
		    	
//--------- Cabecalho ------------------------
		    	if(novaPlanilha){
					testsheet = wb.createSheet("ondeencontrar"+ ++planilha);		    	
			        trow = testsheet.createRow(rowcount);
			        tcell = trow.createCell(0);
			        tcell.setCellValue("Marca");
			        tcell.setCellStyle(stylecenterborda);
			        tcell = trow.createCell(1);
			        tcell.setCellValue("Descrição");
			        tcell.setCellStyle(stylecenterborda);
			        tcell = trow.createCell(2);
			        tcell.setCellValue("Cliente");
			        tcell.setCellStyle(stylecenterborda);
			        tcell = trow.createCell(3);
			        tcell.setCellValue("Seq.");
			        tcell.setCellStyle(stylecenterborda);
			        tcell = trow.createCell(4);
			        tcell.setCellValue("Nome");
			        tcell.setCellStyle(stylecenterborda);	        
			        tcell = trow.createCell(5);
			        tcell.setCellValue("Razão Social");
			        tcell.setCellStyle(stylecenterborda);
			        tcell = trow.createCell(6);
			        tcell.setCellValue("UF");
			        tcell.setCellStyle(stylecenterborda);
			        tcell = trow.createCell(7);
			        tcell.setCellValue("Cidade");
			        tcell.setCellStyle(stylecenterborda);
			        tcell = trow.createCell(8);
			        tcell.setCellValue("Bairro");
			        tcell.setCellStyle(stylecenterborda);
			        tcell = trow.createCell(9);
			        tcell.setCellValue("Logradouro");
			        tcell.setCellStyle(stylecenterborda);
			        tcell = trow.createCell(10); 
			        tcell.setCellValue("Complemento");
			        tcell.setCellStyle(stylecenterborda);  
			        tcell = trow.createCell(11);
			        tcell.setCellValue("CEP");
			        tcell.setCellStyle(stylecenterborda);  		  
			        tcell = trow.createCell(12);
			        tcell.setCellValue("Fone");
			        tcell.setCellStyle(stylecenterborda);  			  
			        novaPlanilha = false;
		    	}

//--------------------------------------------		    	
		    	++rowcount;
		    	trow = testsheet.createRow(rowcount);
		    	tcell = trow.createCell(0);
		    	tcell.setCellValue(rset.getString(1));
		    	tcell.setCellStyle(stylecenter);
		    	tcell = trow.createCell(1);
		    	tcell.setCellValue(rset.getString(2));
		    	tcell.setCellStyle(stylecenter);
		    	tcell = trow.createCell(2);
		    	tcell.setCellValue(rset.getString(3));
		    	tcell.setCellStyle(stylecenter);
		    	tcell = trow.createCell(3); 
		    	tcell.setCellValue(rset.getString(4));
		    	tcell.setCellStyle(stylecenter);
		    	tcell = trow.createCell(4); 
		    	tcell.setCellValue(rset.getString(5));
		    	tcell = trow.createCell(5); 
		    	tcell.setCellValue(rset.getString(6));		    	
		    	tcell = trow.createCell(6);
		    	tcell.setCellValue(rset.getString(7));
		    	tcell.setCellStyle(stylecenter);
		    	tcell = trow.createCell(7);
		    	tcell.setCellValue(rset.getString(8));
		    	tcell = trow.createCell(8);
		    	tcell.setCellValue(rset.getString(9));	    	
		    	tcell = trow.createCell(9);
		    	tcell.setCellValue(rset.getString(10)); 
		    	tcell = trow.createCell(10);
		    	tcell.setCellValue(rset.getString(11)); 
		    	tcell.setCellStyle(stylecenter);
		    	tcell = trow.createCell(11);
		    	tcell.setCellValue(rset.getString(12));
		    	tcell.setCellStyle(stylecenter);		
		    	tcell = trow.createCell(12);
		    	tcell.setCellValue(rset.getString(13));
		    	tcell.setCellStyle(stylecenter);
		    }
	    	wb.write(fos); 
	    	fos.close(); 
		} catch(IOException ioe) {
		} finally {
		      if (rset != null) {
		          try {
		            rset.close();
		          } catch (java.sql.SQLException e) {}
		        }
		        if (pstm != null) {
		          try {
		            pstm.close();
		          } catch (java.sql.SQLException e) {}
		        } 
		        if (j != null) {
		          j.close();
		          j = null;
		        }
		      }
		if(gerou){
			retorno = parametros.retornaParametro("diretorio_link_pdf")+nomeArquivo.toString();
		} else {
			retorno = "";
		}
		return retorno;
	}
}