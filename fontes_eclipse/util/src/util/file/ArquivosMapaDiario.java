package util.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class ArquivosMapaDiario {

	public String copiar(int codigo_regional, String data) {
		StringBuilder nomeArquivo = new StringBuilder();
		String siglaRegional = null;
		String retorno = null;
		String arquivoDestino = null;
		String diretorioOrigem = null;
		String diretorioDestino = null;
		try {
			util.consultas.Parametros parametros = new util.consultas.Parametros();
			util.consultas.Query query = new util.consultas.Query();
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT sigla_regional ");
			sb.append("   FROM regionais_vendas ");
			sb.append("  WHERE codigo_regional = ").append(codigo_regional);
			siglaRegional = query.retorna(sb.toString());
			nomeArquivo.append("MapaDiario_");
			nomeArquivo.append(data.replaceAll("/", ""));
			nomeArquivo.append("_COM_");
			nomeArquivo.append(siglaRegional);
			nomeArquivo.append(".pdf");
			diretorioOrigem = parametros.retornaParametro("diretorio_arquivos_mapa_diario");
			diretorioDestino = parametros.retornaParametro("diretorio_pdf");
			File fonte = new File(diretorioOrigem + nomeArquivo.toString());
			arquivoDestino = util.rand.Palavra.geraPalavra() + ".pdf";
			File outputFile = new File(diretorioDestino + arquivoDestino);
			InputStream in = new FileInputStream(fonte);
			OutputStream out = new FileOutputStream(outputFile);
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			in.close();
			out.close();
			retorno = arquivoDestino;
		} catch (Exception e) {
			retorno = null;
			e.printStackTrace();
		}
		return retorno;
	}

	public String copiar(String data) {
		StringBuilder nomeArquivo = new StringBuilder();
		String retorno = null;
		String arquivoDestino = null;
		String diretorioOrigem = null;
		String diretorioDestino = null;
		try {
			util.consultas.Parametros parametros = new util.consultas.Parametros();
			nomeArquivo.append("MapaDiario_");
			nomeArquivo.append(data.replaceAll("/", ""));
			nomeArquivo.append(".pdf");
			diretorioOrigem = parametros.retornaParametro("diretorio_arquivos_mapa_diario");
			diretorioDestino = parametros.retornaParametro("diretorio_pdf");
			File fonte = new File(diretorioOrigem + nomeArquivo.toString());
			arquivoDestino = util.rand.Palavra.geraPalavra() + ".pdf";
			File outputFile = new File(diretorioDestino + arquivoDestino);
			InputStream in = new FileInputStream(fonte);
			OutputStream out = new FileOutputStream(outputFile);
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			in.close();
			out.close();
			retorno = arquivoDestino;
		} catch (Exception e) {
			retorno = null;
			e.printStackTrace();
		}
		return retorno;
	}
	
	
}
