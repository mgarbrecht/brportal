package util.consultas.com;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.io.*;
import util.consultas.Query;
import util.rand.Palavra;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import com.egen.util.struts.DynaActionForm;

public class InterfaceArqCompra {

	private List<File> listaArquivos;

	public InterfaceArqCompra() {
		this.listaArquivos = new ArrayList<File>();
	}

	public void gerarOC(String ocoNumero, String fornecedor, String arquivo, HttpServletRequest req) {
		req.removeAttribute("arquivo");
		com.egen.util.jdbc.JdbcUtil j = null;
		try {
			j = new com.egen.util.jdbc.JdbcUtil();
			geraArquivoOC(j, ocoNumero, fornecedor, arquivo);
			zipa(req, arquivo);
			excluiArquivos();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			if (j != null) {
				j.close();
				j = null;
			}
		}
	}
	
	public void gerarOC(ActionForm form, HttpServletRequest req) {
		req.removeAttribute("arquivo");
		DynaActionForm _ge_grid = (DynaActionForm) form;
		portalbr.com.ArquivosOrdemCompra_rActionForm[] _ge_grid_array = (portalbr.com.ArquivosOrdemCompra_rActionForm[]) _ge_grid.get("bl_form_Jw_arquivos_ordem_compra_lines");
		portalbr.com.ArquivosOrdemCompra_rActionForm f = _ge_grid_array[0];
		com.egen.util.jdbc.JdbcUtil j = null;
		try {
			String fornecedor = null;
			List<String> listaOrdensCompra = new ArrayList<String>();
			j = new com.egen.util.jdbc.JdbcUtil();
			for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
				f = _ge_grid_array[_ge_grid_array_index];
				if (f.getGridCheckField()) {
					if(fornecedor == null){
						fornecedor = f.getForn_codigo();
					}
					listaOrdensCompra.add(f.getOco_numero());
				}
			}
			geraArquivoOC(j, listaOrdensCompra, fornecedor);
			zipa(req, f.getArquivo_edi());
			excluiArquivos();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			if (j != null) {
				j.close();
				j = null;
			}
		}
	}
	
	public void gerarTalao(String fornecedor, String ordemCompra, String arquivo, HttpServletRequest req) {
		req.removeAttribute("arquivo");
		com.egen.util.jdbc.JdbcUtil j = null;
		try {
			j = new com.egen.util.jdbc.JdbcUtil();
			geraArquivoTalao(j, fornecedor, ordemCompra, arquivo);
			zipa(req, arquivo);
			excluiArquivos();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			if (j != null) {
				j.close();
				j = null; 
			}
		}
	}
	
	public void gerarTalao(ActionForm form, HttpServletRequest req) {
		req.removeAttribute("arquivo");
		DynaActionForm _ge_grid = (DynaActionForm) form;
		portalbr.com.ArquivosTalao_rActionForm[] _ge_grid_array = (portalbr.com.ArquivosTalao_rActionForm[]) _ge_grid.get("bl_form_Jw_arquivos_talao_lines");
		portalbr.com.ArquivosTalao_rActionForm f = _ge_grid_array[0];
		com.egen.util.jdbc.JdbcUtil j = null;
		try {
			String fornecedor = null;
			List<String> listaOrdensCompra = new ArrayList<String>();
			j = new com.egen.util.jdbc.JdbcUtil();
			for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
				f = _ge_grid_array[_ge_grid_array_index];
				if (f.getGridCheckField()) {
					if(fornecedor == null){
						fornecedor = f.getForn_codigo();
					}
					listaOrdensCompra.add(f.getOco_numero());
				}
			}
			geraArquivoTalao(j, listaOrdensCompra, fornecedor);					
			zipa(req, f.getArquivo_edi());
			excluiArquivos();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			if (j != null) {
				j.close();
				j = null;
			}
		}
	}
	
		
	private void geraArquivoOC(com.egen.util.jdbc.JdbcUtil j, List<String> listaOrdens, String fornecedor) throws SQLException {
		util.consultas.Parametros parametros = new util.consultas.Parametros();
		java.sql.CallableStatement call = null;
		File file = null;
		StringBuilder sb = new StringBuilder();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		com.egen.util.jdbc.JdbcUtil j2 = null;
		String diretorioTemporario = parametros.retornaParametro("diretorio_pdf");
		try {
			j2 = new com.egen.util.jdbc.JdbcUtil();
			j2.setAutoCommit(false);
			StringBuilder sbComando = new StringBuilder();
			sbComando.append("BEGIN ");
			sbComando.append("    wbrio.pck_interface_compra_edi.set_fornecedor(").append(fornecedor).append("); ");
			for(String ordem : listaOrdens){
	           sbComando.append(" wbrio.pck_interface_compra_edi.add_ordem(").append(ordem).append(", 1); ");
			}
			sbComando.append("END;");
			call = j2.getConn().prepareCall(sbComando.toString());
			call.execute();
			pstm = j2.getConn().prepareStatement("SELECT column_value coluna FROM TABLE(edi.pck_interface_compra.formata_arquivo_texto_oc()) ");
			rset = pstm.executeQuery();
			while (rset.next()) {
				sb.append(rset.getString("coluna")).append("\r\n");
			}
			Query query = new Query();
			StringBuilder sbNome = new StringBuilder();
			sbNome.append(" SELECT '").append(fornecedor).append("_'||to_char(sysdate, 'ddmmyyyyhh24miss') ||'.BRO' arquivo ");
			sbNome.append("   FROM dual ");
			String arquivo = query.retorna(j, sbNome.toString());
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(diretorioTemporario + arquivo), "Windows-1252"));
			try {
				out.write(sb.toString());
			} finally {
				out.close();
			}
			file = new File(diretorioTemporario + arquivo);
			this.listaArquivos.add(file);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				rset.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			if(call !=null){
				call.close();
			}
			if(j2 != null){
				j2.close();
			}
		}
	}
	
	private void geraArquivoOC(com.egen.util.jdbc.JdbcUtil j, String ocoNumero, String fornecedor, String arquivo) throws SQLException {
		util.consultas.Parametros parametros = new util.consultas.Parametros();
		File file = null;
		java.sql.CallableStatement call = null;
		StringBuilder sb = new StringBuilder();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		String diretorioTemporario = parametros.retornaParametro("diretorio_pdf");
		com.egen.util.jdbc.JdbcUtil j2 = null;
		try {
			j2 = new com.egen.util.jdbc.JdbcUtil();
			j2.setAutoCommit(false);
			StringBuilder sbComando = new StringBuilder();
			sbComando.append("BEGIN ");
			sbComando.append("    wbrio.pck_interface_compra_edi.set_fornecedor(").append(fornecedor).append("); ");
            sbComando.append("    wbrio.pck_interface_compra_edi.add_ordem(").append(ocoNumero).append(", 1); ");
			sbComando.append("END;");
			call = j2.getConn().prepareCall(sbComando.toString());
			call.execute();
			pstm = j2.getConn().prepareStatement("SELECT column_value coluna FROM TABLE(edi.pck_interface_compra.formata_arquivo_texto_oc()) ");
			rset = pstm.executeQuery();
			while (rset.next()) {
				sb.append(rset.getString("coluna")).append("\r\n");
			}			
			String arquivo2 = "OC"+ocoNumero+".BRO";
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(diretorioTemporario + arquivo2), "Windows-1252"));
			try {
				out.write(sb.toString());
			} finally {
				out.close();
			}
			file = new File(diretorioTemporario + arquivo2);
			this.listaArquivos.add(file);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(call !=null){
				call.close();
			}
			if(rset!=null){
				rset.close();
			}
			if(pstm != null){
				pstm.close();
			}
			if(j2 != null){
				j2.close();
			}			
		}			
	}
	
//-----------------------------------------------------------
	private void geraArquivoTalao(com.egen.util.jdbc.JdbcUtil j, List<String> listaOrdens, String fornecedor) throws SQLException {
		util.consultas.Parametros parametros = new util.consultas.Parametros();
		File file = null;
		java.sql.CallableStatement call = null;
		com.egen.util.jdbc.JdbcUtil j2 = null;
		StringBuilder sb = new StringBuilder();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		String diretorioTemporario = parametros.retornaParametro("diretorio_pdf");
		try {
			j2 = new com.egen.util.jdbc.JdbcUtil();
			j2.setAutoCommit(false);
			StringBuilder sbComando = new StringBuilder();
			sbComando.append("BEGIN ");
			sbComando.append("    wbrio.pck_interface_compra_edi.set_fornecedor(").append(fornecedor).append("); ");
			for(String ordem : listaOrdens){
	           sbComando.append(" wbrio.pck_interface_compra_edi.add_ordem(").append(ordem).append(", 1); ");
			}
			sbComando.append("END;");
			call = j2.getConn().prepareCall(sbComando.toString());
			call.execute();
			pstm = j2.getConn().prepareStatement("SELECT column_value coluna FROM TABLE(edi.pck_interface_compra.formata_arquivo_texto_talao()) ");
			rset = pstm.executeQuery();
			while (rset.next()) {
				sb.append(rset.getString("coluna")).append("\r\n");
			}
			Query query = new Query();
			StringBuilder sbNome = new StringBuilder();
			sbNome.append(" SELECT '").append(fornecedor).append("_'||to_char(sysdate, 'ddmmyyyyhh24miss') ||'.BRO' arquivo ");
			sbNome.append("   FROM dual ");
			String arquivo = query.retorna(j, sbNome.toString());
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(diretorioTemporario + arquivo), "Windows-1252"));
			try {
				out.write(sb.toString());
			} finally {
				out.close();
			}
			file = new File(diretorioTemporario + arquivo);
			this.listaArquivos.add(file);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				rset.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			if(call !=null){
				call.close();
			}
			if(j2 != null){
				j2.close();
			}
		}		
	}

	
	private void geraArquivoTalao(com.egen.util.jdbc.JdbcUtil j, String fornecedor, String ocoNumero, String arquivo) throws SQLException {
		util.consultas.Parametros parametros = new util.consultas.Parametros();
		File file = null;
		java.sql.CallableStatement call = null;
		StringBuilder sb = new StringBuilder();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		com.egen.util.jdbc.JdbcUtil j2 = null;
		String diretorioTemporario = parametros.retornaParametro("diretorio_pdf");
		try {
			j2 = new com.egen.util.jdbc.JdbcUtil();
			j2.setAutoCommit(false);
			StringBuilder sbComando = new StringBuilder();
			sbComando.append("BEGIN ");
			sbComando.append("    wbrio.pck_interface_compra_edi.set_fornecedor(").append(fornecedor).append("); ");
            sbComando.append("    wbrio.pck_interface_compra_edi.add_ordem(").append(ocoNumero).append(", 1); ");
			sbComando.append("END;");
			call = j2.getConn().prepareCall(sbComando.toString());
			call.execute();
			pstm = j2.getConn().prepareStatement("SELECT column_value coluna FROM TABLE(edi.pck_interface_compra.formata_arquivo_texto_talao()) ");
			rset = pstm.executeQuery();
			while (rset.next()) {
				sb.append(rset.getString("coluna")).append("\r\n");
			}			
			String arquivo2 = "Talao"+ocoNumero+".BRO";
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(diretorioTemporario + arquivo2), "Windows-1252"));
			try {
				out.write(sb.toString());
			} finally {
				out.close();
			}
			file = new File(diretorioTemporario + arquivo2);
			this.listaArquivos.add(file);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(call != null){
				call.close();
			}
			if(rset!=null){
				rset.close();
			}
			if(pstm != null){
				pstm.close();
			}
			if(j2 != null){
				j2.close();
			}
		}			
	}	
	
//-----------------------------------------------------------	
	
	private void zipa(HttpServletRequest req, String nomeArquivo) {
		util.consultas.Parametros parametros = new util.consultas.Parametros();
		String zipFile;
		String arquivo = Palavra.geraPalavra() + ".zip";
		try {
			String diretorioTemporario = parametros.retornaParametro("diretorio_pdf");
			String link = parametros.retornaParametro("diretorio_link_pdf");
			zipFile = diretorioTemporario + arquivo;
			FileOutputStream fout = new FileOutputStream(zipFile);
			ZipOutputStream zout = new ZipOutputStream(fout);

			for (File f : this.listaArquivos) {
				try {
					byte[] buffer = new byte[1024];
					FileInputStream fin = new FileInputStream(f);
					zout.putNextEntry(new ZipEntry(f.getName()));
					int length;
					while ((length = fin.read(buffer)) > 0) {
						zout.write(buffer, 0, length);
					}
					zout.closeEntry();
					fin.close();
				} catch (IOException ioe) {
					ioe.printStackTrace(System.out);
				}
			}
			zout.close();
			req.setAttribute("arquivo", link + arquivo);
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	private void excluiArquivos() {
		for (File f : this.listaArquivos) {
			if (f.isFile()) {
				f.delete();
			}
		}
	}

}
//windows-1252			