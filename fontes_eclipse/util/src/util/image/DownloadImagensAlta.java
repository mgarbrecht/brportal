package util.image;

import java.io.*;
import java.net.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.apache.commons.io.FileUtils;

public class DownloadImagensAlta {

	private String chave;
	private String diretorioDestino;
	private CountDownLatch executionCompleted;

	public DownloadImagensAlta() {
	}

	public List<String> verificaImagensInexistentes(List<String> listaImagens) {
		List<String> listaImagensInexistentes = new ArrayList<String>();
		try {
			for (String imagem : listaImagens) {
				if(!imagemExiste(imagem.replaceAll(".gif", ".jpg"))) {
					listaImagensInexistentes.add(imagem.replaceAll(".gif", ".jpg"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return listaImagensInexistentes;
	}
	
	public String processar(List<String> listaImagens) {
		String retorno = null;

		List<List<String>> listaImagensGeral = new ArrayList();
		int contadorQuebras = 0;
		List<String> listaInterna = new ArrayList<String>();
		for (String imagem : listaImagens) {
			if (contadorQuebras == 0) {
				listaInterna = new ArrayList<String>();
			}
			contadorQuebras++;
			listaInterna.add(imagem);
			if (contadorQuebras == 20) {
				listaImagensGeral.add(listaInterna);
				contadorQuebras = 0;
			}
		}
		if (contadorQuebras > 0) {
			listaImagensGeral.add(listaInterna);
		}
		this.diretorioDestino = "/home/loja_brportal/imagens/alta/";
		this.chave = util.rand.Palavra.geraPalavra();
		File f = new File(this.diretorioDestino + chave + "/");
		f.mkdir();
		try {
			for (List<String> listaImagensQuebra : listaImagensGeral) {
				this.executionCompleted = new CountDownLatch(listaImagensQuebra.size());
				for (String imagem : listaImagensQuebra) {
					DownloadThread downloadThread = new DownloadThread(chave, imagem.replaceAll(".gif", ".jpg"));
					downloadThread.start();
				}
				try {
					this.executionCompleted.await();
				} catch (Exception e) {
				}
			}
			retorno = chave;
		} catch (Exception e) {
		}
		return retorno;
	}

	private boolean imagemExiste(String imagem) {
		try {
			HttpURLConnection.setFollowRedirects(false);
			HttpURLConnection con = (HttpURLConnection) new URL(
					"http://s3.sa-east-1.amazonaws.com/imagens.catalogobeirario.com.br/alta/" + imagem)
						.openConnection();
			con.setRequestMethod("HEAD");
			return (con.getResponseCode() == HttpURLConnection.HTTP_OK);
		} catch (Exception e) {
			return false;

		}
	}

	public class DownloadThread implements Runnable {
		private Thread thread;
		private String chave;
		private String imagem;

		DownloadThread(String chave, String imagem) {
			this.chave = chave;
			this.imagem = imagem;
		}

		public void run() {
			try {
				FileUtils.copyURLToFile(
						new URL("http://s3-sa-east-1.amazonaws.com/imagens.catalogobeirario.com.br/alta/"
								+ this.imagem),
						new File("/home/loja_brportal/imagens/alta/" + this.chave + "/" + this.imagem));
			} catch (Exception e) {
				File fileExcluir = new File("/home/loja_brportal/imagens/alta/" + this.chave + "/" + this.imagem);
				if (fileExcluir.exists()) {
					fileExcluir.delete();
				}
			} finally {
				executionCompleted.countDown();
			}
		}

		public void start() {
			if (thread == null) {
				thread = new Thread(this, this.imagem);
				thread.start();
			}
		}
	}
}
