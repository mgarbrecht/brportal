package util.consultas.ind;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import portalbr.dbobj.view.Jw_verif_caixas_corrugados;

public class VerifCaixasIndCorrugados {

	/*
	 * Exemplo rótulo: R008871790001040833
	 * Exemplo caixa : 2946338250619
	 * 
	 */

	public VerifCaixasIndCorrugados(HttpServletRequest req) {
		this.request = req;
	}

	private HttpServletRequest request;
	private String tipo;
	private String codigoBarra;
	private int contaQtd;
	private boolean rotulo;
	private String produto;
	private String remNro;
	private String seqRotulo;

	public void populaBloco() {
		if (abreCodigo()) {
			if (this.rotulo) {
				leRotulo();
			} else {
				leCaixaInd();
			}
		}
	}

	public boolean abreCodigo() {
		boolean valido = false;
		this.tipo = codigoBarra.substring(0,1);
		if(this.tipo.equalsIgnoreCase("A")){
			request.setAttribute("mensagem", "Item do pedido já empenhado!");
		} else {
			try {
				if(this.tipo.equalsIgnoreCase("R") || this.tipo.equalsIgnoreCase("P")){
					if(abreRotulo()){
						valido = true;
					}
				} else {
					valido = true;
					abreCaixaInd();
				} 
			} catch (Exception e){
				valido = false;
				request.setAttribute("mensagem", "Erro na leitura do código de barras!");	
			}
		}
		return valido;
	}

	private void abreCaixaInd() throws Exception {
		this.rotulo = false;
		this.produto = this.codigoBarra.substring(0, 12);
	}

	private boolean abreRotulo() throws Exception {
		boolean valido = false;
		this.tipo = this.codigoBarra.substring(0, 1);
		if (this.codigoBarra.length() == 18 || this.codigoBarra.length() == 12) {
			this.tipo = this.codigoBarra.substring(0, 1);
			this.remNro = this.codigoBarra.substring(1, 8);
			this.seqRotulo = this.codigoBarra.substring(8, 12);
			valido = true;
		} else if (this.codigoBarra.length() == 19 || this.codigoBarra.length() == 13) {
			this.tipo = this.codigoBarra.substring(0, 1);
			this.remNro = this.codigoBarra.substring(1, 9);
			this.seqRotulo = this.codigoBarra.substring(9, 13);
			valido = true;
		}
		this.rotulo = true;
		return valido;
	}

	public String leRotulo() {
		com.egen.util.jdbc.JdbcUtil j = null;
		try {
			j = new com.egen.util.jdbc.JdbcUtil();
			Jw_verif_caixas_corrugados table = new Jw_verif_caixas_corrugados();
			StringBuilder sb = new StringBuilder();
			sb.append("  SELECT rr.rem_nro ");
			sb.append("       , rr.seq_rotulo ");
			sb.append("       , rr.ped_nmro ");
			sb.append("       , i.lin_cdgo ");
			sb.append("       , i.ref_cdgo ");
			sb.append("       , i.cab_cdgo ");
			sb.append("       , i.cor_cdgo ");
			sb.append("       , qrr.qtt_nume ");
			sb.append("       , brio.fct_retorna_ean13(i.lin_cdgo, i.ref_cdgo, i.cab_cdgo, i.cor_cdgo, qrr.qtt_nume, p.cli_cdgo) produto ");
			sb.append("       , SUM(qrr.qtt_pars) qtt_pars ");
			sb.append("       , 'N' processou ");
			sb.append("    FROM rotulos_remessa rr ");
			sb.append("       , qtd_rotulos_remessa qrr ");
			sb.append("       , ite i ");
			sb.append("       , ped p ");
			sb.append("   WHERE rr.tipo_geracao = '").append(this.tipo).append("'");
			if (this.tipo.equalsIgnoreCase("P")) {
				sb.append(" AND rr.ped_nmro = p_rem_nro ");
				sb.append(" AND rr.seq_rotulo_ped = p_seq_rotulo ");
			} else {
				sb.append(" AND rr.rem_nro = ").append(this.remNro);
				sb.append(" AND rr.seq_rotulo = ").append(this.seqRotulo);
			}
			sb.append("     AND rr.rem_nro = qrr.rem_nro ");
			sb.append("     AND rr.rotulo = qrr.rotulo ");
			sb.append("     AND rr.ped_nmro = qrr.ped_nmro ");
			sb.append("     AND rr.ite_seqn = qrr.ite_seqn ");
			sb.append("     AND rr.ped_nmro = i.ped_nmro ");
			sb.append("     AND rr.ite_seqn = i.ite_seqn ");
			sb.append("     AND i.ped_nmro = p.ped_nmro ");
			sb.append("   GROUP BY rr.rem_nro ");
			sb.append("          , rr.seq_rotulo ");
			sb.append("          , rr.ped_nmro ");
			sb.append("          , i.lin_cdgo ");
			sb.append("          , i.ref_cdgo ");
			sb.append("          , i.cab_cdgo ");
			sb.append("          , i.cor_cdgo ");
			sb.append("          , qrr.qtt_nume ");
			sb.append("          , brio.fct_retorna_ean13(i.lin_cdgo, i.ref_cdgo, i.cab_cdgo, i.cor_cdgo, qrr.qtt_nume, p.cli_cdgo) ");
			sb.append("	  ORDER BY rr.rem_nro  ");
			sb.append("			 , rr.seq_rotulo  ");
			sb.append("			 , rr.ped_nmro  ");
			sb.append("			 , i.lin_cdgo  ");
			sb.append("			 , i.ref_cdgo  ");
			sb.append("			 , i.cab_cdgo  ");
			sb.append("			 , i.cor_cdgo  ");
			sb.append("			 , qrr.qtt_nume ");
			sb.append("			 , brio.fct_retorna_ean13(i.lin_cdgo, i.ref_cdgo, i.cab_cdgo, i.cor_cdgo, qrr.qtt_nume, p.cli_cdgo) ");
			Vector<?> res_Jw_verif_caixas_corrugados = j.select(table, sb.toString(), null);
			request.getSession().setAttribute("res_Jw_verif_caixas_corrugados", res_Jw_verif_caixas_corrugados);
			if (res_Jw_verif_caixas_corrugados != null && res_Jw_verif_caixas_corrugados.size() == 0) {
				request.setAttribute("mensagem", "Rótulo inexistente!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (j != null) {
				j.close();
				j = null;
			}
		}
		return null;
	}

	public void leCaixaInd() {
		boolean caixaValida = false;
		java.util.Vector<?> res_Jw_verif_caixas_corrugados = null;
		if (request.getSession().getAttribute("res_Jw_verif_caixas_corrugados") != null) {
			res_Jw_verif_caixas_corrugados = (java.util.Vector<?>) request.getSession().getAttribute("res_Jw_verif_caixas_corrugados");
			int i_count = 0;
			while (i_count < res_Jw_verif_caixas_corrugados.size()) {
				portalbr.dbobj.view.Jw_verif_caixas_corrugados t_jw_verif_caixas_corrugados = (portalbr.dbobj.view.Jw_verif_caixas_corrugados) res_Jw_verif_caixas_corrugados.elementAt(i_count);
				if (t_jw_verif_caixas_corrugados.getProduto().equalsIgnoreCase(this.produto)) {
					if (t_jw_verif_caixas_corrugados.getQtt_pars() == 0) {
						request.setAttribute("mensagem",
								"Linha: " + t_jw_verif_caixas_corrugados.getLin_cdgo() + " Ref.: "
										+ t_jw_verif_caixas_corrugados.getRef_cdgo() + " Cabedal: "
										+ t_jw_verif_caixas_corrugados.getCab_cdgo() + " Cor: "
										+ t_jw_verif_caixas_corrugados.getCor_cdgo() + " Tamanho: "
										+ t_jw_verif_caixas_corrugados.getQtt_nume() + " já lido!");
					} else {
						t_jw_verif_caixas_corrugados.setQtt_pars(t_jw_verif_caixas_corrugados.getQtt_pars() - 1);
						t_jw_verif_caixas_corrugados.setProcessou("S");
					}
					caixaValida = true;
					break;
				} 
				i_count++;
			}
		}
		if(caixaValida){
			verificaQuantidadeLidos();
		} else {
			if(res_Jw_verif_caixas_corrugados!=null && res_Jw_verif_caixas_corrugados.size()>0){
				request.setAttribute("mensagem", "O código de barras não pertence ao corrugado!");	
			} else {
				request.setAttribute("mensagem", "Erro na leitura do código de barras!");
			}
		}
	}

	public void executa(String codigoBarra) {
		request.setAttribute("mensagem", "");
		this.codigoBarra = codigoBarra;
		populaBloco();
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public int getContaQtd() {
		return contaQtd;
	}

	public void setContaQtd(int contaQtd) {
		this.contaQtd = contaQtd;
	}

	public boolean isRotulo() {
		return rotulo;
	}

	public void setRotulo(boolean rotulo) {
		this.rotulo = rotulo;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getRemNro() {
		return remNro;
	}

	public void setRemNro(String remNro) {
		this.remNro = remNro;
	}

	public String getSeqRotulo() {
		return seqRotulo;
	}

	public void setSeqRotulo(String seqRotulo) {
		this.seqRotulo = seqRotulo;
	}

	private void verificaQuantidadeLidos() {
		java.util.Vector<?> res_Jw_verif_caixas_corrugados = null;
		if (request.getSession().getAttribute("res_Jw_verif_caixas_corrugados") != null) {
			res_Jw_verif_caixas_corrugados = (java.util.Vector<?>) request.getSession()
					.getAttribute("res_Jw_verif_caixas_corrugados");
			int count = 0;
			while (count < res_Jw_verif_caixas_corrugados.size()) {
				portalbr.dbobj.view.Jw_verif_caixas_corrugados t_jw_verif_caixas_corrugados = (portalbr.dbobj.view.Jw_verif_caixas_corrugados) res_Jw_verif_caixas_corrugados
						.elementAt(count);
				count++;
				this.contaQtd += t_jw_verif_caixas_corrugados.getQtt_pars();
			}
			if (this.contaQtd == 0) {
				request.setAttribute("mensagem", "Caixa OK!");
			}
		}
	}

}
