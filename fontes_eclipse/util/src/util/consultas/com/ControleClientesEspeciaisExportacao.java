package util.consultas.com;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControleClientesEspeciaisExportacao {
	
	private String empresaFatura;
	private String anoFatura;
	private String numeroFatura;
	private String etiquetas;
	private String dtRecEtiquetaFilial;
	private String dtEntregaEtiqueta;
	private String dtInspecao;
	private String DataEmbarqueCargovision;
	
	private List<FaturaFilialStatus> listaFaturaFilialStatus;
	
	public String getDtEntregaEtiqueta() {
		return dtEntregaEtiqueta;
	}

	public void setDtEntregaEtiqueta(String dtEntregaEtiqueta) {
		this.dtEntregaEtiqueta = dtEntregaEtiqueta;
	}

	private com.egen.util.jdbc.JdbcUtil conexao;
	
	public String getEmpresaFatura() {
		return empresaFatura;
	}

	public void setEmpresaFatura(String empresaFatura) {
		this.empresaFatura = empresaFatura;
	}

	public String getAnoFatura() {
		return anoFatura;
	}

	public void setAnoFatura(String anoFatura) {
		this.anoFatura = anoFatura;
	}

	public String getNumeroFatura() {
		return numeroFatura;
	}

	public void setNumeroFatura(String numeroFatura) {
		this.numeroFatura = numeroFatura;
	}

	public void setEtiquetas(String etiquetas) {
		this.etiquetas = etiquetas;
	}

	public void setDtRecEtiquetaFilial(String dtRecEtiquetaFilial) {
		this.dtRecEtiquetaFilial = dtRecEtiquetaFilial;
	}

	public com.egen.util.jdbc.JdbcUtil getConexao() {
		return conexao;
	}

	public void setConexao(com.egen.util.jdbc.JdbcUtil conexao) {
		this.conexao = conexao;
	}

	public ControleClientesEspeciaisExportacao(com.egen.util.jdbc.JdbcUtil j){
		this.conexao = j;
	}
	
	public String getEtiquetas() {
		return etiquetas;
	}

	public String getDtRecEtiquetaFilial() {
		return dtRecEtiquetaFilial;
	}

	public List<FaturaFilialStatus> getListaFaturaFilialStatus() {
		return listaFaturaFilialStatus;
	}

	public void setListaFaturaFilialStatus(List<FaturaFilialStatus> listaFaturaFilialStatus) {
		this.listaFaturaFilialStatus = listaFaturaFilialStatus;
	}
	
	public String getDtInspecao() {
		return dtInspecao;
	}

	public void setDtInspecao(String dtInspecao) {
		this.dtInspecao = dtInspecao;
	}

	public String getDataEmbarqueCargovision() {
		return DataEmbarqueCargovision;
	}

	public void setDataEmbarqueCargovision(String dataEmbarqueCargovision) {
		DataEmbarqueCargovision = dataEmbarqueCargovision;
	}

	public void buscarDadosFatura() {
		java.sql.PreparedStatement pstm = null;
		java.sql.ResultSet rset = null;
		try {
			this.listaFaturaFilialStatus = new ArrayList<FaturaFilialStatus>();
			List<String> lst = new ArrayList<String>();
			boolean possuiItemNaoCadastrado = false;
			boolean possuiEtiquetaInexistente = false;
			boolean possuiDtRecEtiquetaFilialInexistente = false;
			boolean possuiDtEntregaEtiquetaInexistente = false;
			//boolean possuiDtInspecaoInexistente = false;
			//boolean possuiDataEmbarqueCargovisionInexistente = false;
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT /*+ all_rows */ DISTINCT ");
			sb.append("        ped_nmro ");
			sb.append("      , etiquetas ");
			sb.append("      , dt_rec_etiqueta_filial ");
			sb.append("      , dt_entrega_etiqueta ");
		    sb.append("      , dt_inspecao ");
		    sb.append("      , data_embarque_cargovision ");
		    sb.append("      , max_dt_inspecao ");
		    sb.append("      , max_data_embarque_cargovision ");
			sb.append("      , max_dt_rec_etiqueta_filial ");
			sb.append("      , max_dt_entrega_etiqueta ");
			sb.append("      , max_etiquetas ");
    	  //sb.append("      , min_situacao_ite ");
			sb.append("      , existe ");
			sb.append("      , fct_retorna_fil_producao(ped_nmro, ite_seqn) fil_filial_producao  ");
			sb.append("      , todo_empenhado_filial ");
			sb.append("      , (SELECT MIN(ite_situ) ");
			sb.append("           FROM ite ");
			sb.append("          WHERE ite.ped_nmro = qry.ped_nmro) min_ite_situ ");
			sb.append("      , (SELECT CASE WHEN COUNT(itei.ite_seqn) > 0 THEN 'N' ELSE 'S' END ");
			sb.append("      	  FROM ite itei ");
			sb.append("      	 WHERE itei.ped_nmro = qry.ped_nmro ");
			sb.append("      	   AND NOT EXISTS (SELECT 1 ");
			sb.append("      	                     FROM (SELECT i.ped_nmro ");
			sb.append("      	                                , i.ite_seqn ");
			sb.append("      	                             FROM requisicoes_ite            i ");
			sb.append("      	                                , notas_fiscais_saida_requis nr "); 
			sb.append("                                         , nf_saida                   n ");
			sb.append("      	                                , naturezas_operacoes        nat ");
			sb.append("      	                            WHERE i.reqnf_numero = nr.reqnf_numero ");
			sb.append("      	                              AND nr.nfs_nmro = n.nfs_nmro ");
			sb.append("      	                              AND nr.nfs_serie = n.nfs_serie ");
			sb.append("      	                              AND nr.emp_empresa = n.emp_empresa ");
			sb.append("      	                              AND nr.fil_filial = n.fil_filial ");
			sb.append("      	                              AND n.natoper_codigo = nat.codigo ");
			sb.append("      	                              AND NVL(nat.tipo_destinatario, NULL) = 'T' ");
			sb.append("      	                              AND NVL(n.stat_codigo, NULL) = 4 ");
			sb.append("                                     UNION ");
			sb.append("      	                           SELECT ite.ped_nmro ");
			sb.append("      	                                , ite.ite_seqn ");
			sb.append("      	                             FROM ped ");
			sb.append("      	                                , ite ");
			sb.append("      	                                , compromete_pedido cp ");
			sb.append("      	                                , dom_local_estoque dl ");
			sb.append("      	                            WHERE ped.ped_nmro = ite.ped_nmro ");
			sb.append("      	                              AND ite.ped_nmro = cp.ped_nmro ");
			sb.append("      	                              AND ite.ite_seqn = cp.ite_seqn ");
			sb.append("      	                              AND cp.les_codigo = dl.codigo ");
			sb.append("      	                              AND NVL(dl.fil_filial, NULL) = '17' ");
			sb.append("      	                              AND NVL(ite.ite_situ, NULL) >= 5) qt ");
			sb.append("      	                     	    WHERE qt.ped_nmro = itei.ped_nmro ");
			sb.append("      	                          	  AND qt.ite_seqn = itei.ite_seqn)) transferido_completo ");		
			sb.append("      , pck_pedidos.get_status(ped_nmro) status ");
			sb.append("   FROM (SELECT DISTINCT i.ped_nmro ");
			sb.append("                       , pi.etiquetas ");
			sb.append("                       , to_char(pi.dt_rec_etiqueta_filial, 'dd/mm/yyyy') dt_rec_etiqueta_filial ");
			sb.append("                       , to_char(pi.dt_entrega_etiqueta, 'dd/mm/yyyy') dt_entrega_etiqueta ");
            sb.append("                       , to_char(pi.dt_inspecao, 'dd/mm/yyyy') dt_inspecao "); 
            sb.append("                       , to_char(pi.data_embarque_cargovision, 'dd/mm/yyyy') data_embarque_cargovision ");
            sb.append("                       , to_char(MAX(dt_inspecao),'dd/mm/yyyy') max_dt_inspecao "); 
            sb.append("                       , to_char(MAX(data_embarque_cargovision),'dd/mm/yyyy') max_data_embarque_cargovision "); 
			sb.append("                       , MAX(dt_rec_etiqueta_filial) max_dt_rec_etiqueta_filial ");
			sb.append("                       , MAX(etiquetas) max_etiquetas ");
            sb.append("                       , MAX(dt_entrega_etiqueta) max_dt_entrega_etiqueta ");
			sb.append("                       , CASE WHEN pi.ped_nmro IS NULL THEN 'N' ELSE 'S' END existe ");
			sb.append("                       , (SELECT CASE WHEN COUNT(1) = 0 THEN 'S' ELSE 'N' END ");
	        sb.append("                            FROM ite ii ");
	        sb.append("                           WHERE ii.ped_nmro = i.ped_nmro ");
	        sb.append("                             AND ii.ite_seqn = i.ite_seqn ");
	        sb.append("                             AND NOT EXISTS (SELECT NULL ");
	        sb.append("                                               FROM compromete_pedido c ");
	        sb.append("                                              WHERE ii.ped_nmro = c.ped_nmro ");
	        sb.append("                                                AND ii.ite_seqn = c.ite_seqn)) todo_empenhado_filial ");
	        sb.append("                       , i.ite_seqn ");
			sb.append("                       , i.ite_situ ");
			sb.append("           FROM faturas_proformas  fp ");
			sb.append("              , ite                i ");
			sb.append("              , ped_inf_adicionais pi ");
			sb.append("          WHERE fp.empresa_fatura_proforma = '").append(this.empresaFatura).append("' ");
			sb.append("            AND fp.ano_fatura_proforma = ").append(this.anoFatura);
			sb.append("            AND fp.numero_fatura_proforma = ").append(this.numeroFatura);
			sb.append("            AND fp.empresa_fatura_proforma = i.empresa_fatura_proforma ");
			sb.append("            AND fp.ano_fatura_proforma = i.ano_fatura_proforma ");
			sb.append("            AND fp.numero_fatura_proforma = i.numero_fatura_proforma ");
			sb.append("            AND pi.ped_nmro(+) = i.ped_nmro ");
			sb.append("          GROUP BY pi.etiquetas ");
			sb.append("                 , i.ped_nmro ");
			sb.append("                 , i.ite_seqn ");
			sb.append("                 , i.ite_situ ");
			sb.append("                 , pi.dt_rec_etiqueta_filial ");
			sb.append("                 , pi.dt_entrega_etiqueta ");
            sb.append("                 , pi.dt_inspecao ");
            sb.append("                 , pi.data_embarque_cargovision ");
			sb.append("                 , CASE WHEN pi.ped_nmro IS NULL THEN 'N' ELSE 'S' END ) qry ");
			pstm = this.getConexao().getConn().prepareStatement(sb.toString());
			rset = pstm.executeQuery();
			int contador = 0;
			while (rset.next()) {
				contador++;
				if (!lst.contains(rset.getString("fil_filial_producao"))) {
					lst.add(rset.getString("fil_filial_producao"));
				}
				if (contador == 1) {
					setEtiquetas(rset.getString("max_etiquetas"));
					setDtRecEtiquetaFilial(rset.getString("max_dt_rec_etiqueta_filial"));
					setDtEntregaEtiqueta(rset.getString("max_dt_entrega_etiqueta"));
					setDtInspecao(rset.getString("max_dt_inspecao"));
					setDataEmbarqueCargovision(rset.getString("max_data_embarque_cargovision"));
				}
				if (rset.getString("existe").equalsIgnoreCase("N")) {
					possuiItemNaoCadastrado = true;
				}
				if (rset.getString("etiquetas") == null) {
					possuiEtiquetaInexistente = true;
				}
				if (rset.getString("dt_rec_etiqueta_filial") == null) {
					possuiDtRecEtiquetaFilialInexistente = true;
				}
				if (rset.getString("dt_rec_etiqueta_filial") == null) {
					possuiDtEntregaEtiquetaInexistente = true;
				}
				if (rset.getString("max_dt_inspecao")!=null){
					setDtInspecao(rset.getString("max_dt_inspecao"));
				}
				if(rset.getString("max_data_embarque_cargovision")!=null){
					setDataEmbarqueCargovision(rset.getString("max_data_embarque_cargovision"));
				}
				setarSituacaoFaturaFilial(rset);
			}
			if(possuiItemNaoCadastrado || possuiEtiquetaInexistente || possuiDtRecEtiquetaFilialInexistente) {
				setEtiquetas("");
				setDtRecEtiquetaFilial("");
			}
			if(possuiItemNaoCadastrado || possuiEtiquetaInexistente || possuiDtEntregaEtiquetaInexistente){
				setEtiquetas("");
				setDtEntregaEtiqueta("");
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstm != null) {
				try {
					pstm.close();
				} catch (java.sql.SQLException e) {
				}
			}
		}
	}
 
	private void setarSituacaoFaturaFilial(java.sql.ResultSet r) throws SQLException {
		boolean existe = false;
		for (FaturaFilialStatus f : this.getListaFaturaFilialStatus()) {
			if (f.getFilial().equalsIgnoreCase(r.getString("fil_filial_producao"))) {
				existe = true;
				if (f.getStatus().equalsIgnoreCase("F")) {
					if (!r.getString("status").equalsIgnoreCase("F")) {
						f.setStatus("__");
					}
				} else if (f.getStatus().equalsIgnoreCase("L")) {
					if (!r.getString("status").equalsIgnoreCase("L")) {
						f.setStatus("__");
					}
				} else if (f.getStatus().equalsIgnoreCase("T")) {
					if (r.getString("transferido_completo").equalsIgnoreCase("N")) {
						f.setStatus("__");
					}
				} else if (f.getStatus().equalsIgnoreCase("E")) {
					if (r.getString("todo_empenhado_filial").equalsIgnoreCase("N")) {
						if (r.getString("status").equalsIgnoreCase("A") && r.getString("min_ite_situ").equals("4")) {
							f.setStatus("P");
						} else {
							f.setStatus("__");
						}
					}
				} else if (f.getStatus().equalsIgnoreCase("P")) {
					if (!(r.getString("status").equalsIgnoreCase("A") && r.getString("min_ite_situ").equals("4"))) {
						if (r.getString("todo_empenhado_filial").equals("N")) {
							f.setStatus("__");
						}
					}
				} else if (f.getStatus().equalsIgnoreCase("A")) {
					if (!(r.getString("status").equalsIgnoreCase("A") && (r.getString("min_ite_situ").equals("3") || r.getString("min_ite_situ").equals("2") || r.getString("min_ite_situ").equals("1")))) {
						f.setStatus("__");
					}
				} else if (f.getStatus().equalsIgnoreCase("B")) {
					if (!(r.getString("status").equalsIgnoreCase("B") || r.getString("status").equalsIgnoreCase("P"))) {
						f.setStatus("__");
					}
				}
			}
		}
		if (!existe && r.getString("fil_filial_producao") != null) {
			FaturaFilialStatus fatura = new FaturaFilialStatus();
			fatura.setEmpresaFatura(this.empresaFatura);
			fatura.setAnoFatura(this.anoFatura);
			fatura.setNumeroFatura(this.numeroFatura);
			fatura.setFilial(r.getString("fil_filial_producao"));
			if (r.getString("status").equalsIgnoreCase("F")) {
				fatura.setStatus("F");
			} else if (r.getString("status").equalsIgnoreCase("L")) {
				fatura.setStatus("L");
			} else if (r.getString("transferido_completo").equalsIgnoreCase("S")) {
				fatura.setStatus("T");
			} else if (r.getString("todo_empenhado_filial").equals("S")) {
				fatura.setStatus("E");
			} else if (r.getString("status").equalsIgnoreCase("A")) {
				if (r.getString("min_ite_situ").equals("4")) {
					fatura.setStatus("P");
				} else if (r.getString("min_ite_situ").equalsIgnoreCase("3") || r.getString("min_ite_situ").equalsIgnoreCase("2") || r.getString("min_ite_situ").equalsIgnoreCase("1")) {
					fatura.setStatus("A");
				}
			} else if (r.getString("status").equalsIgnoreCase("B") || r.getString("status").equalsIgnoreCase("P")) {
				fatura.setStatus("B");
			} else {
				fatura.setStatus("__");
			}
			this.getListaFaturaFilialStatus().add(fatura);
		}
	}
	
	public class FaturaFilialStatus {
		private String empresaFatura;
		private String anoFatura;
		private String numeroFatura;
		private String filial;
		private String status;

		public String getEmpresaFatura() {
			return empresaFatura;
		}

		public void setEmpresaFatura(String empresaFatura) {
			this.empresaFatura = empresaFatura;
		}

		public String getAnoFatura() {
			return anoFatura;
		}

		public void setAnoFatura(String anoFatura) {
			this.anoFatura = anoFatura;
		}

		public String getNumeroFatura() {
			return numeroFatura;
		}

		public void setNumeroFatura(String numeroFatura) {
			this.numeroFatura = numeroFatura;
		}

		public String getFilial() {
			return filial;
		}

		public void setFilial(String filial) {
			this.filial = filial;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
	}
	
}