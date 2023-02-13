package util.consultas.com;

import java.io.IOException;
import java.sql.SQLException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import util.image.DownloadImagensExternas;
import util.rand.Palavra;

public class DownloadImagens {

	private String tamanho;

	@SuppressWarnings("unchecked")
	public String processar(HttpServletRequest req) {
		boolean processou = false;
		util.consultas.Parametros parametros = new util.consultas.Parametros();
		String retorno = null;
		String arquivoZip = null;
		List<String> listaImagens = new ArrayList<String>();
		List<String> listaImagensInexistentes = new ArrayList<String>();
		if (req.getSession().getAttribute("download_imagens_tamanho_imagem") != null) {
			this.tamanho = (String) req.getSession().getAttribute("download_imagens_tamanho_imagem");
		} else {
			this.tamanho = "G";
		}
		if (req.getSession().getAttribute("listaImagens") != null) {
			listaImagens = (List<String>) req.getSession().getAttribute("listaImagens");
		}
		for (String i : listaImagens) {
			i.replace(".gif", ".jpg");
		}
		if (!listaImagens.isEmpty()) {
			if (this.tamanho.equalsIgnoreCase("A")) {
				if (req.getSession().getAttribute("desconsiderar_lista_imagens_inexistentes") == null) {
					try {
						DownloadImagensExternas downloadImagensExternas = new DownloadImagensExternas(this.tamanho);
						listaImagensInexistentes = downloadImagensExternas.verificaImagensInexistentes(listaImagens);
					} catch (Exception e) {
					}
				} else {
					req.getSession().removeAttribute("desconsiderar_lista_imagens_inexistentes");
				}
			}
			if (listaImagensInexistentes != null && !listaImagensInexistentes.isEmpty()) {
				req.getSession().setAttribute("lista_imagens_inexistentes", listaImagensInexistentes);
			} else {
				req.getSession().removeAttribute("lista_imagens_inexistentes");
				arquivoZip = zipa(listaImagens);
				processou = true;
			}
		}
		if (processou) {
			try {
				retorno = parametros.retornaParametro("diretorio_link_pdf") + arquivoZip;
			} catch (SQLException e) {
			}
		}
		return retorno;
	}

	private String zipa(List<String> listaImagens) {
		String diretorioAlta = null;
		boolean baixouImagensAlta = false;
		util.consultas.Parametros parametros = new util.consultas.Parametros();
		String zipFile;
		String arquivoZip = Palavra.geraPalavra() + ".zip";
		int indice = 3;
		try {
			if (this.tamanho.equalsIgnoreCase("N")) {
				indice = 5;
			} else if (this.tamanho.equalsIgnoreCase("A")) {
				indice = 4;
			} else if (this.tamanho.equalsIgnoreCase("G")) {
				indice = 3;
			} else if (this.tamanho.equalsIgnoreCase("M")) {
				indice = 2;
			} else if (this.tamanho.equalsIgnoreCase("P")) {
				indice = 1;
			}
			// String diretorioImagensGrandes =
			// parametros.retornaParametro("diretorio_imagens_catalogo");
			String diretorioImagensGrandes = "/home/loja_brportal/imagens/catalogo/";
			// String diretorioImagensGrandes =
			// "c:/home/loja_brportal/imagens/catalogo/";
			// String diretorioImagensPequenas =
			// parametros.retornaParametro("diretorio_imagens_pequenas");
			String diretorioImagensPequenas = "/home/loja_brportal/imagens/pequenas/";
			// String diretorioImagensPequenas =
			// "c:/home/loja_brportal/imagens/pequenas/";
			// String diretorioImagensMedias =
			// parametros.retornaParametro("diretorio_imagens_grandes");
			String diretorioImagensMedias = "/home/loja_brportal/imagens/grandes/";
			// String diretorioImagensMedias =
			// "c:/home/loja_brportal/imagens/grandes/";
			String diretorioTemporario = parametros.retornaParametro("diretorio_pdf");
			// String diretorioTemporario = "c:/temp/";
			zipFile = diretorioTemporario + arquivoZip;
			if (this.tamanho.equalsIgnoreCase("A")||this.tamanho.equalsIgnoreCase("N")) {
				DownloadImagensExternas downloadImagensExternas = new DownloadImagensExternas(this.tamanho);
				diretorioAlta = downloadImagensExternas.processar(listaImagens);
				if (diretorioAlta != null) {
					baixouImagensAlta = true;
				}
			}
			FileOutputStream fout = new FileOutputStream(zipFile);
			ZipOutputStream zout = new ZipOutputStream(fout);
			for (String img : listaImagens) {
				if (img.replaceAll(".gif", ".jpg").contains(".jpg")) {
					try {
						byte[] buffer = new byte[1024];
						FileInputStream fin = null;
						File fArquivoImagemAlta = null;
						if (this.tamanho.equalsIgnoreCase("A")||this.tamanho.equalsIgnoreCase("N")) {
							fArquivoImagemAlta = new File("/home/loja_brportal/imagens/alta/" + diretorioAlta + "/"	+ img.replaceAll(".gif", ".jpg"));
						}
						File fArquivoImagemGrande = new File(diretorioImagensGrandes + img.replaceAll(".gif", ".jpg"));
						File fArquivoImagemMedia = new File(diretorioImagensMedias + img.replaceAll(".gif", ".jpg"));
						File fArquivoImagemPequena = new File(diretorioImagensPequenas + img);
						if (fArquivoImagemAlta != null && fArquivoImagemAlta.exists() && indice == 5) {
							fin = new FileInputStream("/home/loja_brportal/imagens/alta/" + diretorioAlta + "/"	+ img.replaceAll(".gif", ".jpg"));
							zout.putNextEntry(new ZipEntry(img.replaceAll(".gif", ".jpg")));
						} else if (fArquivoImagemAlta != null && fArquivoImagemAlta.exists() && indice >= 4) {
							fin = new FileInputStream("/home/loja_brportal/imagens/alta/" + diretorioAlta + "/"	+ img.replaceAll(".gif", ".jpg"));
							zout.putNextEntry(new ZipEntry(img.replaceAll(".gif", ".jpg")));
						} else if (fArquivoImagemGrande.exists() && indice >= 3) {
							fin = new FileInputStream(diretorioImagensGrandes + img.replaceAll(".gif", ".jpg"));
							zout.putNextEntry(new ZipEntry(img.replaceAll(".gif", ".jpg")));
						} else if (fArquivoImagemMedia.exists() && indice >= 2) {
							fin = new FileInputStream(diretorioImagensMedias + img.replaceAll(".gif", ".jpg"));
							zout.putNextEntry(new ZipEntry(img.replaceAll(".gif", ".jpg")));
						} else if (fArquivoImagemPequena.exists() && indice >= 1) {
							fin = new FileInputStream(diretorioImagensPequenas + img);
							zout.putNextEntry(new ZipEntry(img.replaceAll(".gif", ".gif")));
						}
						int length;
						while ((length = fin.read(buffer)) > 0) {
							zout.write(buffer, 0, length);
						}
						zout.closeEntry();
						fin.close();
					} catch (IOException ioe) {
					}
				}
			}
			zout.close();
			fout.close();
			if (baixouImagensAlta) {
				for (String arquivoApagar : listaImagens) {
					File file = new File("/home/loja_brportal/imagens/alta/" + diretorioAlta + "/"
							+ arquivoApagar.replaceAll(".gif", ".jpg"));
					try {
						FileUtils.forceDelete(file);
					} catch (IOException e) {
					}
				}
				File fDiretorio = new File("/home/loja_brportal/imagens/alta/" + diretorioAlta);
				if (fDiretorio.isDirectory()) {
					fDiretorio.delete();
				}
			}
		} catch (Exception e) {
		}
		return arquivoZip;
	}

}