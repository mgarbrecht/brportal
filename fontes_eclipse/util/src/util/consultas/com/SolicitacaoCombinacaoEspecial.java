package util.consultas.com;

import java.io.*;
import java.net.*;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.apache.commons.io.FileUtils;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import com.egen.util.struts.DynaActionForm;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;
import util.consultas.Query;

public class SolicitacaoCombinacaoEspecial {

	private String tamanho;
	private String chave;
	private String diretorioDestino;
	private CountDownLatch executionCompleted;
	private List<Imagem> listaImagens;

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getDiretorioDestino() {
		return diretorioDestino;
	}

	public void setDiretorioDestino(String diretorioDestino) {
		this.diretorioDestino = diretorioDestino;
	}

	public CountDownLatch getExecutionCompleted() {
		return executionCompleted;
	}

	public void setExecutionCompleted(CountDownLatch executionCompleted) {
		this.executionCompleted = executionCompleted;
	}

	public List<Imagem> getListaImagens() {
		return listaImagens;
	}

	public void setListaImagens(List<Imagem> listaImagens) {
		this.listaImagens = listaImagens;
	}

	public void enviarEmail(ActionForm form, HttpServletRequest req, String idSolicitacao, String situacao) {

	
		Query query = new Query();
		try {
			boolean processar = false;
			String emailDestinatario = null;
			String emailDestinatarioCC = null;
			String listaIds = null;
			String descricaoSituacao = null;
			if (req.getSession().getAttribute("situacao") != null) {
				if (idSolicitacao == null) {
					situacao = (String) req.getSession().getAttribute("situacao");
				}
			}
			if (situacao.equalsIgnoreCase("L")) {
				String[] emails = query.retorna("SELECT valor FROM wbrio.parametros WHERE par_sist_codigo = 'BRNET' AND nome = 'email_solicitacao_combinacoes_especiais_situacao_aprovada'").split(";");
				emailDestinatario = emails[0];
				try {
				emailDestinatarioCC = emails[1];
				} catch (Exception e) {
					
				}
				descricaoSituacao = "MANIPULADA";
				processar = true;
				
			} else if (situacao.equalsIgnoreCase("S")) {
				emailDestinatario = query.retorna("SELECT valor FROM wbrio.parametros WHERE par_sist_codigo = 'BRNET' AND nome = 'email_solicitacao_combinacoes_especiais_situacao_pendente_ficha_pre_custo'");
				descricaoSituacao = "PENDENTE FICHA PRE CUSTO";
				processar = true;
			} else if (situacao.equalsIgnoreCase("U")) {
				emailDestinatario = query.retorna("SELECT valor FROM wbrio.parametros WHERE par_sist_codigo = 'BRNET' AND nome = 'email_solicitacao_combinacoes_especiais_situacao_pendente_custo'");
				descricaoSituacao = "PENDENTE CUSTO";
				processar = true;
			}

			if (processar) {

				if (idSolicitacao != null) {
					listaIds = idSolicitacao;
				} else {
					DynaActionForm _ge_grid = (DynaActionForm) form;
					portalbr.com.SolicitacaoCombinacaoEspecial_rActionForm[] _ge_grid_array = (portalbr.com.SolicitacaoCombinacaoEspecial_rActionForm[]) _ge_grid.get("bl_form_Jw_ref_combinacao_especial_lines");
					portalbr.com.SolicitacaoCombinacaoEspecial_rActionForm f = _ge_grid_array[0];
					for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
						f = _ge_grid_array[_ge_grid_array_index];

						if (f.getGridCheckField()) {
							if (listaIds != null) {
								listaIds += "," + f.getId_solicitacao();
							} else {
								listaIds = f.getId_solicitacao();
							}
						}
					}
				}
				util.file.GeraPDF g = new util.file.GeraPDF(req);
				g.setRelatorio("SolicitacaoEspecial.jasper");
				g.setParametro("P_ID_SOLICITACAO", listaIds);
				g.setParametro("P_TIPO_IMAGEM", "M");
				g.gerar();

				montaListaImagens(listaIds);
				baixarImagens();

				StringBuilder sbAssunto = new StringBuilder();
				sbAssunto.append(" SELECT 'LINHA: ' || rowtocol('select distinct r.lin_cdgo from ref_combinacao_especial r where id_solicitacao in (").append(listaIds).append(")') || ");
				sbAssunto.append("        ' - ID: ").append(listaIds).append(" - ' ||  ");
				sbAssunto.append("        rowtocol('select distinct decode(rce.gre_grupo,null ");
				sbAssunto.append("                                        ,(pck_cliente.get_nome(rce.cli_cdgo)) ");
				sbAssunto.append("                                        ,pck_grupo_economico.get_nome(rce.gre_grupo)) ");
				sbAssunto.append("                             from ref_combinacao_especial rce ");
				sbAssunto.append("                            where rce.id_solicitacao in (").append(listaIds).append(")') || ' - ' || '").append(descricaoSituacao).append("' ");
				sbAssunto.append("   FROM dual ");
				String assunto = query.retorna(sbAssunto.toString());
				String arquivo = (String) req.getAttribute("arquivo");
				arquivo = arquivo.replace("../temp/", "/opt/tomcat/webapps/brportal/temp/");
				HtmlEmail he = new HtmlEmail();
				EmailAttachment attachment = new EmailAttachment();
				String nomeArquivo = arquivo;

				attachment.setPath(arquivo);
				attachment.setDisposition(org.apache.commons.mail.EmailAttachment.ATTACHMENT);
				attachment.setDescription("solicitacoes");
				attachment.setName(nomeArquivo);
				he.setHostName("10.0.1.189");
				he.setSmtpPort(25);

				he.addTo(emailDestinatario, emailDestinatario);
				if (emailDestinatarioCC != null) {
					he.addCc(emailDestinatarioCC, emailDestinatarioCC);
				}
				he.setFrom("no-reply@beirario.com.br", "Solicitacao de combinacoes especiais");
				he.setSubject(assunto);
				if (situacao.equalsIgnoreCase("L")) {
					he.setMsg(retornaCustos(listaIds));
				}
				he.attach(attachment);
				for (Imagem imagem : this.listaImagens) {
					if (imagem.existe) {
						EmailAttachment attachmentOrc = new EmailAttachment();
						attachmentOrc.setPath("/opt/tomcat/webapps/brportal/temp/" + this.chave + "_" + imagem.getImagem());
						attachmentOrc.setDisposition(org.apache.commons.mail.EmailAttachment.ATTACHMENT);
						attachmentOrc.setDescription(imagem.getImagem());
						attachmentOrc.setName(imagem.getImagem());
						he.attach(attachmentOrc);
					}
				}
				he.setAuthentication("estategicos", "beirario*123");
				he.send();
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void baixarImagens() {
		List<List<String>> listaImagensGeral = new ArrayList();
		int contadorQuebras = 0;
		List<String> listaInterna = new ArrayList<String>();
		for (Imagem imagem : this.listaImagens) {
			if (contadorQuebras == 0) {
				listaInterna = new ArrayList<String>();
			}
			contadorQuebras++;
			listaInterna.add(imagem.getImagem());
			if (contadorQuebras == 20) {
				listaImagensGeral.add(listaInterna);
				contadorQuebras = 0;
			}
		}
		if (contadorQuebras > 0) {
			listaImagensGeral.add(listaInterna);
		}
		this.chave = util.rand.Palavra.geraPalavra();
		try {
			for (List<String> listaImagensQuebra : listaImagensGeral) {
				this.executionCompleted = new CountDownLatch(listaImagensQuebra.size());
				for (String imagem : listaImagensQuebra) {
					DownloadThread downloadThread = new DownloadThread(this.chave, imagem);
					downloadThread.start();
				}
				try {
					this.executionCompleted.await();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}

	private boolean imagemExiste(String imagem) {
		try {
			HttpURLConnection.setFollowRedirects(false);
			HttpURLConnection con = (HttpURLConnection) new URL("http://s3.sa-east-1.amazonaws.com/imagens.catalogobeirario.com.br/orcamentos/" + imagem).openConnection();
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
				FileUtils.copyURLToFile(new URL("http://s3.sa-east-1.amazonaws.com/imagens.catalogobeirario.com.br/orcamentos/"+ this.imagem),
						                new File("/opt/tomcat/webapps/brportal/temp/" + this.chave + "_" + this.imagem));
			} catch (Exception e) {
				e.printStackTrace(System.err);
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

	private String retornaCustos(String ids) {
		StringBuilder sbCustos = new StringBuilder();
		com.egen.util.jdbc.JdbcUtil j = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			j = new com.egen.util.jdbc.JdbcUtil();
			sbCustos.append("<table border=1>");
			sbCustos.append("<tr style='background-color: lightblue; font-weight: bold'>");
			sbCustos.append("<td style='text-align: center'>Solicitação</td>");
			sbCustos.append("<td style='width: 100px; text-align: center'>CTF</td>");
			sbCustos.append("<td style='width: 100px; text-align: center'>PV - MI</td>");
			sbCustos.append("</tr>");
			
			
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT id_solicitacao ");
			sb.append("      , valor_fabricacao ");
			sb.append("      , r.preco_vendor ");
			sb.append("   FROM ref_combinacao_especial r ");
			sb.append("  WHERE id_solicitacao in (").append(ids).append(") ");
			sb.append("  ORDER BY id_solicitacao ");

			pstm = j.getConn().prepareStatement(sb.toString());
			rset = pstm.executeQuery();

			while (rset.next()) {
				sbCustos.append("<tr>");
				sbCustos.append("<td style='text-align: center'>").append(rset.getInt("id_solicitacao")).append("</td>");
				sbCustos.append("<td style='text-align: center'>").append(rset.getDouble("valor_fabricacao")).append("</td>");
				sbCustos.append("<td style='text-align: center'>").append(rset.getDouble("preco_vendor")).append("</td>");
				sbCustos.append("</tr>");
			}
			sbCustos.append("</table>");
		} catch (Exception e) {
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
			} catch (Exception e) {
			}
			try {
				if (pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
			}
			if (j != null) {
				j.close();
			}
		}
		return sbCustos.toString();
	}

	private void montaListaImagens(String listaIds) {
		String[] lista = listaIds.split(",");
		this.listaImagens = new ArrayList<Imagem>();
		for (String img : lista) {
			img += ".gif";
			Imagem imagem = new Imagem(img, imagemExiste(img));
			this.listaImagens.add(imagem);
		}
	}

	class Imagem {

		private String imagem;
		private boolean existe;

		public Imagem(String imagem, boolean existe) {
			this.imagem = imagem;
			this.existe = existe;
		}

		public String getImagem() {
			return imagem;
		}

		public void setImagem(String imagem) {
			this.imagem = imagem;
		}

		public boolean isExiste() {
			return existe;
		}

		public void setExiste(boolean existe) {
			this.existe = existe;
		}

	}
}
