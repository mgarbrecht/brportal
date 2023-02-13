package util.consultas.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.io.*;
import javax.servlet.http.HttpServletRequest;
//import net.sf.jasperreports.engine.JasperRunManager;
import org.apache.struts.action.ActionForm;
import portalbr.dbobj.view.Jw_geracao_romaneio;
//import portalbr.dbobj.view.Jw_geracao_romaneio_filtro;
import util.rand.Palavra;
import com.egen.util.struts.DynaActionForm;

public class GeracaoRomaneio {

	private List<File> listaArquivos;

	public GeracaoRomaneio() {
		this.listaArquivos = new ArrayList<File>();
	}

	public void gerar(ActionForm form, HttpServletRequest req, String tipoGeracao) {
		req.removeAttribute("arquivo");
		DynaActionForm _ge_grid = (DynaActionForm) form;
		portalbr.com.GeracaoRomaneio_rActionForm[] ge_grid_array = (portalbr.com.GeracaoRomaneio_rActionForm[]) _ge_grid.get("bl_form_Jw_geracao_romaneio_filtro_lines");
		portalbr.com.GeracaoRomaneio_rActionForm f = ge_grid_array[0];
		com.egen.util.jdbc.JdbcUtil j = null;
		try {
			j = new com.egen.util.jdbc.JdbcUtil();
			for (int index = 0; index < ge_grid_array.length; index++) {
				f = ge_grid_array[index];
				if (f.getGridCheckField()) {
					geraArquivoCSV(j, f, tipoGeracao);
				}
			}
			zipa(req);
			excluiArquivos();
		} catch (Exception e) {
			e.printStackTrace(System.err);
		} finally {
			if (j != null) {
				j.close();
				j = null;
			}
		}
	}

	private void geraArquivoCSV(com.egen.util.jdbc.JdbcUtil j, portalbr.com.GeracaoRomaneio_rActionForm f, String tipoGeracao) {
		util.consultas.Parametros parametros = new util.consultas.Parametros();
		File file = null;
		StringBuilder sb = new StringBuilder();
		try {
			String diretorioTemporario = parametros.retornaParametro("diretorio_pdf");
			Jw_geracao_romaneio table = new Jw_geracao_romaneio();
			String[][] select = null;
			Object[][] where = { 
					{ "emp_empresa", "like", f.getEmp_empresa() },
					{ "fil_filial", "like", f.getFil_filial() },
					{ "nfs_nmro", "=", com.egen.util.text.FormatNumber.toInteger(f.getNfs_nmro()) },
					{ "nfs_serie", "like", f.getNfs_serie() },
					{ "tipo_geracao", "like", tipoGeracao.toUpperCase() } };
			Vector<?> res_Jw_geracao_romaneio = j.select(table, select, where, null, null, null);
			if (res_Jw_geracao_romaneio != null && res_Jw_geracao_romaneio.size() > 0) {
				portalbr.dbobj.view.Jw_geracao_romaneio r = (portalbr.dbobj.view.Jw_geracao_romaneio) res_Jw_geracao_romaneio.elementAt(0);
				file = new File(diretorioTemporario + r.getNome_arquivo());
				sb.append(r.getLinha1()).append("\r\n");
				sb.append(r.getLinha2()).append("\r\n");
				sb.append(r.getLinha3()).append("\r\n");
				sb.append(r.getLinha4()).append("\r\n");
				sb.append(r.getLinha5()).append("\r\n");
				sb.append(r.getLinha6()).append("\r\n");
				sb.append(r.getLinha7()).append("\r\n");
				sb.append(r.getLinha8()).append("\r\n");

				for (int x = 0; x < res_Jw_geracao_romaneio.size(); x++) {
					r = (portalbr.dbobj.view.Jw_geracao_romaneio) res_Jw_geracao_romaneio.elementAt(x);
					String linha = "";
					if (f.getPreco_final_liquido().equals("S")) {
						linha = r.getLinha9();
					} else {
						linha = r.getLinha10();
					}
					sb.append("\"").append(linha).append("\"").append("\r\n");
				}
			}
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(sb.toString());
			bw.close();
			this.listaArquivos.add(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void zipa(HttpServletRequest req) {
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
