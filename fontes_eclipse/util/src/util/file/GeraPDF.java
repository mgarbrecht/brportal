package util.file;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public class GeraPDF {

	private classificadorTipo tipoRelatorio;
	private StringBuilder parametrosReport = new StringBuilder();
	private Map<String, Object> parametrosJasper = new HashMap<String, Object>();
	private String relatorio = null;
	private String usuarioSenha = null;
    private HttpServletRequest request;
    
    private enum classificadorTipo {
    	JASPER_REPORT,
    	ORACLE_REPORT
    }

	public GeraPDF(HttpServletRequest req){
		this.request = req;
	}

	
	public String getUsuarioSenha() {
		return usuarioSenha;
	}


	public void setUsuarioSenha(String usuarioSenha) {
		this.usuarioSenha = usuarioSenha;
	}


	public void setRelatorio(String rel) {
		try {
			if (rel.toUpperCase().indexOf(".JASPER") != -1) {
				this.relatorio = rel.replace(".jasper", "");
				this.tipoRelatorio = classificadorTipo.JASPER_REPORT;
			} else if (rel.toUpperCase().indexOf(".RDF") != -1) {
				this.relatorio = rel.replace(".rdf", "");
				this.tipoRelatorio = classificadorTipo.ORACLE_REPORT;
			}
		} catch (Exception e) {
		}
	}
    
	public void setParametro(String parametro, String valor) {
		if (isClassificadorTipo(classificadorTipo.JASPER_REPORT)) {
			this.parametrosJasper.put(parametro, valor);
		} else if (isClassificadorTipo(classificadorTipo.ORACLE_REPORT)) {
			parametrosReport.append(" ").append(parametro).append("=").append(valor);
		}
	}
    
	public void setParametro(String parametro, java.sql.Date valor) {
		if (isClassificadorTipo(classificadorTipo.JASPER_REPORT)) {
			this.parametrosJasper.put(parametro, valor);
		} else if (isClassificadorTipo(classificadorTipo.ORACLE_REPORT)) {
			parametrosReport.append(" ").append(parametro).append("=").append(valor);
		}
	}

	public void setParametro(String parametro, java.util.Date valor) {
		if (isClassificadorTipo(classificadorTipo.JASPER_REPORT)) {
			this.parametrosJasper.put(parametro, valor);
		} else if (isClassificadorTipo(classificadorTipo.ORACLE_REPORT)) {
			parametrosReport.append(" ").append(parametro).append("=").append(valor);
		}
	}

	public void setParametro(String parametro, java.lang.Double valor) {
		if (isClassificadorTipo(classificadorTipo.JASPER_REPORT)) {
			this.parametrosJasper.put(parametro, valor);
		} else if (isClassificadorTipo(classificadorTipo.ORACLE_REPORT)) {
			parametrosReport.append(" ").append(parametro).append("=").append(valor);
		}
	}

	public void setParametro(String parametro, java.lang.Integer valor) {
		if (isClassificadorTipo(classificadorTipo.JASPER_REPORT)) {
			this.parametrosJasper.put(parametro, valor);
		} else if (isClassificadorTipo(classificadorTipo.ORACLE_REPORT)) {
			parametrosReport.append(" ").append(parametro).append("=").append(valor);
		}
	}
	
	public void setParametro(String parametro, java.math.BigDecimal valor) {
		if (isClassificadorTipo(classificadorTipo.JASPER_REPORT)) {
			this.parametrosJasper.put(parametro, valor);
		} else if (isClassificadorTipo(classificadorTipo.ORACLE_REPORT)) {
			parametrosReport.append(" ").append(parametro).append("=").append(valor);
		}
	}
	
	public void setParametro(String parametro, boolean valor) {
		if (isClassificadorTipo(classificadorTipo.JASPER_REPORT)) {
			this.parametrosJasper.put(parametro, valor);
		} else if (isClassificadorTipo(classificadorTipo.ORACLE_REPORT)) {
			parametrosReport.append(" ").append(parametro).append("=").append(valor);
		}
	}

	public void gerar() {
		String arquivo = null;
		try {
			if (isClassificadorTipo(classificadorTipo.JASPER_REPORT)) {
				arquivo = geraRelatorioJasper();
			} else if (isClassificadorTipo(classificadorTipo.ORACLE_REPORT)) {
				arquivo = geraRelatorioReport();
			}
		} catch (Exception e) {
		}
		this.request.setAttribute("arquivo", arquivo);
	}

	public void gerar(Connection conn) {
		String arquivo = null;
		try {
			if (isClassificadorTipo(classificadorTipo.JASPER_REPORT)) {
				arquivo = geraRelatorioJasper(conn);
			} else if (isClassificadorTipo(classificadorTipo.ORACLE_REPORT)) {
				arquivo = geraRelatorioReport();
			}
		} catch (Exception e) {
		}
		this.request.setAttribute("arquivo", arquivo);
	}

	public void gerarDireto(String nomeRelatorio) throws IOException {
		String arquivo = null;
		try {
			if (isClassificadorTipo(classificadorTipo.JASPER_REPORT)) {
				arquivo = geraRelatorioJasper(nomeRelatorio);
			} else if (isClassificadorTipo(classificadorTipo.ORACLE_REPORT)) {
				arquivo = geraRelatorioReport(nomeRelatorio);
			}
		} catch (Exception e) {
		}
		this.request.setAttribute("arquivo", arquivo);
	}
    
    public String gerarArquivo(){
    	String arquivo = null;
    	try {
    		if(isClassificadorTipo(classificadorTipo.JASPER_REPORT)){
    			arquivo = geraRelatorioJasper();
            } else if (isClassificadorTipo(classificadorTipo.ORACLE_REPORT)){
    			arquivo = geraRelatorioReport();
    		}
    	} catch (Exception e){}
    	return arquivo;
	}    

    private boolean isClassificadorTipo(classificadorTipo tipo) {
		return (this.tipoRelatorio == tipo);
	}

	private String geraRelatorioJasper()  {
		StringBuilder nomeArquivo = new StringBuilder();
		String arquivo = null;
	    com.egen.util.jdbc.JdbcUtil jPDF = null;
		try {
			util.consultas.Parametros parametros = new util.consultas.Parametros();
			jPDF = new com.egen.util.jdbc.JdbcUtil();	
		    acesso.Usuario u = new acesso.Usuario();
		    u = (acesso.Usuario)request.getSession().getAttribute("User");	
		    setParametro("P_USUARIO", u.getUsuario());
			nomeArquivo.append(this.relatorio).append(util.rand.Palavra.geraPalavra()).append("_").append(((Integer)u.getId()).toString()).append(".pdf");
			String file_jasper = parametros.retornaParametro("diretorio_jasper") + this.relatorio + ".jasper";
			String file_dest = parametros.retornaParametro("diretorio_pdf") + nomeArquivo;
			JasperRunManager.runReportToPdfFile(file_jasper, file_dest, parametrosJasper, jPDF.getConn());
			arquivo = parametros.retornaParametro("diretorio_link_pdf") + nomeArquivo.toString();
		} catch (Exception e ){
		} finally {
			  if (jPDF!=null){
				  jPDF.close();
				  jPDF = null;
			  }
		  }
		return arquivo;
	}
	
	private String geraRelatorioJasper(Connection conn) {
		StringBuilder nomeArquivo = new StringBuilder();
		String arquivo = null;
		try {
			util.consultas.Parametros parametros = new util.consultas.Parametros();
			acesso.Usuario u = new acesso.Usuario();
			u = (acesso.Usuario) request.getSession().getAttribute("User");
			setParametro("P_USUARIO", u.getUsuario());
			nomeArquivo.append(this.relatorio).append(util.rand.Palavra.geraPalavra()).append("_").append(((Integer) u.getId()).toString()).append(".pdf");
			String file_jasper = parametros.retornaParametro("diretorio_jasper") + this.relatorio + ".jasper";
			String file_dest = parametros.retornaParametro("diretorio_pdf") + nomeArquivo;
			JasperRunManager.runReportToPdfFile(file_jasper, file_dest, parametrosJasper, conn);
			arquivo = parametros.retornaParametro("diretorio_link_pdf") + nomeArquivo.toString();
		} catch (Exception e) {
		} finally {
		}
		return arquivo;
	}	
	
	private String geraRelatorioJasper(String nome)  {
		javax.servlet.ServletContext context = this.request.getSession().getServletContext();
		System.setProperty("realpathbrportal", context.getRealPath(""));
		StringBuilder nomeArquivo = new StringBuilder();
		String arquivo = null;
	    com.egen.util.jdbc.JdbcUtil jPDF = null;
		try {
			util.consultas.Parametros parametros = new util.consultas.Parametros();
			jPDF = new com.egen.util.jdbc.JdbcUtil();	
			nomeArquivo.append(nome).append(".pdf");
			String file_jasper = parametros.retornaParametro("diretorio_jasper") + this.relatorio + ".jasper";
			String file_dest = parametros.retornaParametro("diretorio_pdf") + nomeArquivo;
			JasperRunManager.runReportToPdfFile(file_jasper, file_dest, parametrosJasper, jPDF.getConn());
			arquivo = "/temp/" + nomeArquivo.toString();
		} catch (Exception e ){
			e.printStackTrace();
		} finally {
			  if (jPDF!=null){
				  jPDF.close();
				  jPDF = null; 
			  }
		  }
		return arquivo;
	}	


	private String geraRelatorioReport() throws Exception {
    	String arquivo = null;
		StringBuilder nomeArquivo = new StringBuilder();
		Process task = null;
		try {
			util.consultas.Parametros parametros = new util.consultas.Parametros();
			StringBuilder sbComando = new StringBuilder();
		    Runtime run = Runtime.getRuntime();
		    acesso.Usuario u = new acesso.Usuario();
		    u = (acesso.Usuario)request.getSession().getAttribute("User");
    		nomeArquivo.append(this.relatorio).append(util.rand.Palavra.geraPalavra()).append("_").append(((Integer)u.getId()).toString()).append(".pdf");
    		if(getRealPath().indexOf("opt")!=-1){
    			sbComando.append(parametros.retornaParametro("diretorio_rwrun"));
    		} else {
    			sbComando.append("c:/orant/bin/");
    		}
    		sbComando.append("rwrun.sh " +  parametros.retornaParametro("diretorio_report"));
    		sbComando.append(this.relatorio);
    		sbComando.append(".rdf ").append(this.usuarioSenha != null ? this.usuarioSenha : "acesso/acesso").append(" paramform=no batch=yes destype=file desformat=pdf desname=");
    		sbComando.append(parametros.retornaParametro("diretorio_pdf"));
    		sbComando.append(nomeArquivo.toString()+" "+parametrosReport.toString());
    		sbComando.append("");
    		sbComando.append("");
       	 // --- Imprime o comando -------------------------------------	
       	    System.out.println(sbComando.toString());		
    		task = run.exec(sbComando.toString());
		    task.waitFor();
		    task.destroy();
		    arquivo = parametros.retornaParametro("diretorio_link_pdf")+nomeArquivo.toString();
		} catch (Exception e){
			task.destroy();
		} finally {
			task.destroy();
		} 
		return arquivo;
	}
	
	
	private String geraRelatorioReport(String nome) throws Exception {
    	String arquivo = null;
		StringBuilder nomeArquivo = new StringBuilder();
		Process task = null;
		try {
			util.consultas.Parametros parametros = new util.consultas.Parametros();
		    Runtime run = Runtime.getRuntime();
    		nomeArquivo.append(nome).append(".pdf");
    		StringBuilder sbComando = new StringBuilder();
    		if(getRealPath().indexOf("opt")!=-1){
    			sbComando.append(parametros.retornaParametro("diretorio_rwrun"));
    		} else {
    			sbComando.append("c:/orant/bin/");
    		}
    		sbComando.append("rwrun.sh " +  parametros.retornaParametro("diretorio_report"));
    		sbComando.append(this.relatorio);
    		sbComando.append(".rdf acesso/acesso paramform=no batch=yes destype=file desformat=pdf desname=");
    		sbComando.append(parametros.retornaParametro("diretorio_pdf"));
    		sbComando.append(nomeArquivo.toString()+" "+parametrosReport.toString());
      	 // --- Imprime o comando -------------------------------------	
      	    System.out.println(sbComando.toString());

    		task = run.exec(sbComando.toString());
		    task.waitFor();
		    task.destroy();
		    arquivo = parametros.retornaParametro("diretorio_link_pdf")+nomeArquivo.toString();
		} catch (Exception e){
			task.destroy();
		} finally {
			task.destroy();
		} 
		return arquivo;
	}	
	
	
	
	
	private String getRealPath(){
		ServletContext servletContext = request.getSession().getServletContext();
		String realPath = servletContext.getRealPath("");
		return realPath;
	}
	
}

 