package util.file;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.ooxml.JRPptxExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import com.sun.xml.messaging.saaj.util.ByteOutputStream;

import javax.servlet.http.HttpServletRequest;

public class GeraPPTX {

	private Map<String, Object> parametrosJasper = new HashMap<String, Object>();
	private String relatorio = null;
	private HttpServletRequest request;

	public GeraPPTX(HttpServletRequest req) {
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
			arquivo = geraRelatorioPptx();
		} catch (Exception e) {
		}
		this.request.setAttribute("arquivo", arquivo);
	}

	public String gerarArquivo() {
		String arquivo = null;
		try {
			arquivo = geraRelatorioPptx();
		} catch (Exception e) {
		}
		return arquivo;
	}

	private String geraRelatorioPptx() {
		StringBuilder nomeArquivo = new StringBuilder();
		String arquivo = null;
		com.egen.util.jdbc.JdbcUtil jPptx = null;
		try {
			util.consultas.Parametros parametros = new util.consultas.Parametros();
			jPptx = new com.egen.util.jdbc.JdbcUtil();
			acesso.Usuario u = new acesso.Usuario();
			u = (acesso.Usuario) request.getSession().getAttribute("User");
			setParametro("P_USUARIO", u.getUsuario());
			nomeArquivo.append(this.relatorio).append(util.rand.Palavra.geraPalavra()).append("_").append(((Integer) u.getId()).toString()).append(".pptx");
			String file_jasper = parametros.retornaParametro("diretorio_jasper") + this.relatorio + ".jasper";
			String file_dest = parametros.retornaParametro("diretorio_pdf") + nomeArquivo;
			JasperPrint jasperPrint = JasperFillManager.fillReport(file_jasper, parametrosJasper, jPptx.getConn());
			JRPptxExporter exporterPPTX = new JRPptxExporter();
			exporterPPTX.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporterPPTX.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, file_dest.toString());
			exporterPPTX.exportReport();
			exporterPPTX = new JRPptxExporter();
			exporterPPTX.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporterPPTX.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, file_dest);
			ByteOutputStream bos = new ByteOutputStream();
			exporterPPTX.setParameter(JRExporterParameter.OUTPUT_STREAM, bos);
			exporterPPTX.exportReport();
			try {
				bos.flush();
			} catch (IOException ex) {

			}
			arquivo = parametros.retornaParametro("diretorio_link_pdf") + nomeArquivo.toString();
		} catch (Exception e) {
		} finally {
			if (jPptx != null) {
				jPptx.close();
				jPptx = null;
			}
		}
		return arquivo;
	}

}
