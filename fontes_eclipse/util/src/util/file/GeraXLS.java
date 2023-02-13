package util.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;

import javax.servlet.http.HttpServletRequest;

public class GeraXLS {

	private Map<String, Object> parametrosJasper = new HashMap<String, Object>();
	private String relatorio = null;
	private HttpServletRequest request;

	public GeraXLS(HttpServletRequest req) {
		this.request = req;
	}

	public void setRelatorio(String rel) {
		try {
			if (rel.toUpperCase().indexOf(".JASPER") != -1) {
				this.relatorio = rel.replace(".jasper", "");
			}
		} catch (Exception e) {
		}
	}

	public void setParametro(String parametro, String valor) {
		this.parametrosJasper.put(parametro, valor);
	}

	public void setParametro(String parametro, java.sql.Date valor) {
		this.parametrosJasper.put(parametro, valor);
	}

	public void setParametro(String parametro, java.util.Date valor) {
		this.parametrosJasper.put(parametro, valor);
	}

	public void setParametro(String parametro, java.lang.Double valor) {
		this.parametrosJasper.put(parametro, valor);
	}
	
	public void setParametro(String parametro, java.lang.Integer valor) {
		this.parametrosJasper.put(parametro, valor);
	}
	
	public void setParametro(String parametro, java.math.BigDecimal valor) {
		this.parametrosJasper.put(parametro, valor);
	}		

	public void gerar() {
		String arquivo = null;
		try {
			arquivo = geraRelatorioXls();
		} catch (Exception e) {
		}
		this.request.setAttribute("arquivo", arquivo);
	}

	public void gerarDireto(String nomeRelatorio) throws IOException {
		String arquivo = null;
		try {
			arquivo = geraRelatorioXls(nomeRelatorio);
		} catch (Exception e) {
		}
		this.request.setAttribute("arquivo", arquivo);
	}

	public String gerarArquivo() {
		String arquivo = null;
		try {
			arquivo = geraRelatorioXls();
		} catch (Exception e) {
		}
		return arquivo;
	}

	private String geraRelatorioXls() {
		StringBuilder nomeArquivo = new StringBuilder();
		String arquivo = null;
		com.egen.util.jdbc.JdbcUtil jXls = null;
		try {
			util.consultas.Parametros parametros = new util.consultas.Parametros();
			jXls = new com.egen.util.jdbc.JdbcUtil();
			acesso.Usuario u = new acesso.Usuario();
			u = (acesso.Usuario) request.getSession().getAttribute("User");
			setParametro("P_USUARIO", u.getUsuario());
			nomeArquivo.append(this.relatorio).append(util.rand.Palavra.geraPalavra()).append("_").append(((Integer) u.getId()).toString()).append(".xls");
			String file_jasper = parametros.retornaParametro("diretorio_jasper")+ this.relatorio+ ".jasper";
			String file_dest = parametros.retornaParametro("diretorio_pdf")+ nomeArquivo;
			JasperPrint jp = JasperFillManager.fillReport(file_jasper, parametrosJasper, jXls.getConn());
            try {
                 OutputStream output = new FileOutputStream(new File(file_dest));
                 JRXlsExporter exporterXLS = new JRXlsExporter();
                 exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, jp);
                 exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, output);
                 exporterXLS.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
                 exporterXLS.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
                 exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
                 exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
                 exporterXLS.exportReport();
             } catch (FileNotFoundException e) {
             } catch (JRException je){
             }
			arquivo = parametros.retornaParametro("diretorio_link_pdf")+ nomeArquivo.toString();
		} catch (Exception e) {
		} finally {
			if (jXls != null) {
				jXls.close();
				jXls = null;
			}
		}
		return arquivo;
	}

	private String geraRelatorioXls(String nome) {
		javax.servlet.ServletContext context = this.request.getSession().getServletContext();
		System.setProperty("realpathbrportal", context.getRealPath(""));
		StringBuilder nomeArquivo = new StringBuilder();
		String arquivo = null;
		com.egen.util.jdbc.JdbcUtil jXls = null;
		try {
			util.consultas.Parametros parametros = new util.consultas.Parametros();
			jXls = new com.egen.util.jdbc.JdbcUtil();
			nomeArquivo.append(nome).append(".xls");
			String file_jasper = parametros.retornaParametro("diretorio_jasper")+ this.relatorio+ ".jasper";
			String file_dest = parametros.retornaParametro("diretorio_pdf")	+ nomeArquivo;
	        JasperPrint jp = JasperFillManager.fillReport(file_jasper, parametrosJasper, jXls.getConn());
             try {
                 OutputStream output = new FileOutputStream(new File(file_dest));
                 JRXlsExporter exporterXLS = new JRXlsExporter();
                 exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, jp);
                 exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, output);
                 exporterXLS.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
                 exporterXLS.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
                 exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
                 exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
                 exporterXLS.exportReport();
             } catch (FileNotFoundException e) {
             } catch (JRException je){
             }
			arquivo = "/temp/" + nomeArquivo.toString();
		} catch (Exception e) {
		} finally {
			if (jXls != null) {
				jXls.close();
				jXls = null;
			}
		}
		return arquivo;
	}
}
