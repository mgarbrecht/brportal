package util.consultas.com;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class RegistroExportacao {

	@SuppressWarnings("rawtypes")
	public String geraExcel(java.util.Vector res_Jw_registros_exportacao) throws Exception {
		List<Registro> dados = geraDados(res_Jw_registros_exportacao);
		HSSFWorkbook wb = new HSSFWorkbook();
		org.apache.poi.hssf.usermodel.HSSFRow trow;
		org.apache.poi.hssf.usermodel.HSSFCell tcell;
		org.apache.poi.hssf.usermodel.HSSFCellStyle styleCenterBorda;
		StringBuilder nomeArquivo = new StringBuilder();
		int rowcount = 0;
		String retorno = "";
		boolean gerou = false;
		util.consultas.Parametros parametros = new util.consultas.Parametros();
		try {
			List<ComponenteConsumo> rCabecalho = null;
			for (Registro tCabecalho : dados) {
				rCabecalho = tCabecalho.getListaComponenteConsumo();
				break;
			}
			HSSFSheet sheet = null;
			nomeArquivo.append("exp_").append(util.rand.Palavra.geraPalavra()).append(".xls");
			styleCenterBorda = wb.createCellStyle();
			styleCenterBorda.setBorderBottom((short) 1);
			styleCenterBorda.setAlignment((short) 2);
			FileOutputStream fos = new FileOutputStream(parametros.retornaParametro("diretorio_pdf") + nomeArquivo.toString());
			int indice = 0;
			sheet = wb.createSheet("exp");
			trow = sheet.createRow(rowcount);
			tcell = trow.createCell(indice++);
			tcell.setCellValue("Nr. Re.");
			tcell.setCellStyle(styleCenterBorda);
			tcell = trow.createCell(indice++);
			tcell.setCellValue("Nr. Drawback");
			tcell.setCellStyle(styleCenterBorda);
			tcell = trow.createCell(indice++);
			tcell.setCellValue("Dt. Embarque");
			tcell.setCellStyle(styleCenterBorda);
			tcell = trow.createCell(indice++);
			tcell.setCellValue("Dt. Averbação");
			tcell.setCellStyle(styleCenterBorda);
			tcell = trow.createCell(indice++);
			tcell.setCellValue("Fatura");
			tcell.setCellStyle(styleCenterBorda);
			tcell = trow.createCell(indice++);
			tcell.setCellValue("NCM");
			tcell.setCellStyle(styleCenterBorda);
			tcell = trow.createCell(indice++);
			tcell.setCellValue("Pares");
			tcell.setCellStyle(styleCenterBorda);
			tcell = trow.createCell(indice++);
			tcell.setCellValue("Perc. Comissão");
			tcell.setCellStyle(styleCenterBorda);
			tcell = trow.createCell(indice++);
			tcell.setCellValue("Fob");
			tcell.setCellStyle(styleCenterBorda);
			tcell = trow.createCell(indice++);
			tcell.setCellValue("Vlr. Comissão");
			tcell.setCellStyle(styleCenterBorda);
			tcell = trow.createCell(indice++);
			tcell.setCellValue("Fob Líq.");
			tcell.setCellStyle(styleCenterBorda);
			tcell = trow.createCell(indice++);
			tcell.setCellValue("Filial");
			tcell.setCellStyle(styleCenterBorda);
			tcell = trow.createCell(indice++);
			tcell.setCellValue("Despachante");
			tcell.setCellStyle(styleCenterBorda);
			tcell = trow.createCell(indice++);
			tcell.setCellValue("Vlr. Unit.");
			tcell.setCellStyle(styleCenterBorda);
			tcell = trow.createCell(indice++);
			tcell.setCellValue("DDE");
			tcell.setCellStyle(styleCenterBorda);
			tcell = trow.createCell(indice++);
			tcell.setCellValue("Descrição Produto");
			tcell.setCellStyle(styleCenterBorda);
			tcell = trow.createCell(indice++);
			tcell.setCellValue("Produto");
			tcell.setCellStyle(styleCenterBorda);
			int index = indice;
			for (ComponenteConsumo consumo : rCabecalho) {
				tcell = trow.createCell(++index);
				tcell.setCellValue(consumo.getComponente());
				tcell.setCellStyle(styleCenterBorda);
			}
			for (Registro t_jw_registros_exportacao : dados) {
				++rowcount;
				indice = 0;
				trow = sheet.createRow(rowcount);
				tcell = trow.createCell(indice++);
				tcell.setCellValue(t_jw_registros_exportacao.getNumeroRe() == null ? "" : t_jw_registros_exportacao.getNumeroRe());
				tcell = trow.createCell(indice++);
				tcell.setCellValue(t_jw_registros_exportacao.getNumeroDrawback() == null ? "" : t_jw_registros_exportacao.getNumeroDrawback());
				tcell = trow.createCell(indice++);
				tcell.setCellValue(com.egen.util.text.FormatDate.format(((java.sql.Date) t_jw_registros_exportacao.getDataEmbarque()), "dd/MM/yyyy"));
				tcell = trow.createCell(indice++);
				tcell.setCellValue(com.egen.util.text.FormatDate.format(((java.sql.Date) t_jw_registros_exportacao.getDataAverbacao()), "dd/MM/yyyy"));
				tcell = trow.createCell(indice++);
				tcell.setCellValue(((t_jw_registros_exportacao.getAnoFatura()) + "/" + (t_jw_registros_exportacao.getNumeroFatura())));
				tcell = trow.createCell(indice++);
				tcell.setCellValue((t_jw_registros_exportacao.getNcm() == null ? "" : t_jw_registros_exportacao.getNcm()));
				tcell = trow.createCell(indice++);
				tcell.setCellValue(t_jw_registros_exportacao.getPares());
				tcell = trow.createCell(indice++);
				tcell.setCellValue(t_jw_registros_exportacao.getPercComissao());
				tcell = trow.createCell(indice++);
				tcell.setCellValue(t_jw_registros_exportacao.getFob());
				tcell = trow.createCell(indice++);
				tcell.setCellValue(t_jw_registros_exportacao.getValorComissao());
				tcell = trow.createCell(indice++);
				tcell.setCellValue(t_jw_registros_exportacao.getFobLiquido());
				tcell = trow.createCell(indice++);
				tcell.setCellValue(t_jw_registros_exportacao.getFilFilial());
				tcell = trow.createCell(indice++);
				tcell.setCellValue(t_jw_registros_exportacao.getNomeDespachante());
				tcell = trow.createCell(indice++);
				tcell.setCellValue(t_jw_registros_exportacao.getValorUnitario());
				tcell = trow.createCell(indice++);
				tcell.setCellValue(t_jw_registros_exportacao.getDde());
				tcell = trow.createCell(indice++);
				tcell.setCellValue(t_jw_registros_exportacao.getDescricaoProduto());
				tcell = trow.createCell(indice++);
				tcell.setCellValue(t_jw_registros_exportacao.getProduto());
				int indexConsumo = indice;
				for (ComponenteConsumo consumo : t_jw_registros_exportacao.getListaComponenteConsumo()) {
					tcell = trow.createCell(++indexConsumo);
					tcell.setCellValue(com.egen.util.text.FormatNumber.format(consumo.getConsumo(), "##,##0.000000"));
				}
			}
			wb.write(fos);
			fos.close();
			gerou = true;
		} catch (IOException ioe) {
			ioe.printStackTrace(System.err);
		} finally {
		}
		if (gerou) {
			retorno = parametros.retornaParametro("diretorio_link_pdf") + nomeArquivo.toString();
		} else {
			retorno = "";
		}
		return retorno;
	}

	public List<Registro> geraDados(Vector<?> res_Jw_registros_exportacao) {
		List<Registro> listaRegistroExportacao = new ArrayList<Registro>();
		int indice = 0;
		while (indice < res_Jw_registros_exportacao.size()) {
			portalbr.dbobj.view.Jw_registros_exportacao t_jw_registros_exportacao = (portalbr.dbobj.view.Jw_registros_exportacao) res_Jw_registros_exportacao.elementAt(indice);
			Registro registro = new Registro(
					(t_jw_registros_exportacao.getNumero_re() == null ? "" : t_jw_registros_exportacao.getNumero_re()),
					((java.sql.Date) t_jw_registros_exportacao.getData_embarque()),
					((java.sql.Date) t_jw_registros_exportacao.getData_averbacao()),
					(t_jw_registros_exportacao.getEmp_empresa() == null ? "" : t_jw_registros_exportacao.getEmp_empresa()),
					(t_jw_registros_exportacao.getAno_fatura() == null ? "" : t_jw_registros_exportacao.getAno_fatura()),
					(t_jw_registros_exportacao.getNumero_fatura() == null ? "" : t_jw_registros_exportacao.getNumero_fatura()),
					(t_jw_registros_exportacao.getNcm() == null ? "" : t_jw_registros_exportacao.getNcm()),
					(t_jw_registros_exportacao.getPares()),
					(t_jw_registros_exportacao.getPerc_comissao() == null ? null : t_jw_registros_exportacao.getPerc_comissao()),
					(t_jw_registros_exportacao.getFob()), (t_jw_registros_exportacao.getValor_comissao()),
					(t_jw_registros_exportacao.getFob_liquido()),
					(t_jw_registros_exportacao.getNome_despachante() == null ? "" : t_jw_registros_exportacao.getNome_despachante()),
					(t_jw_registros_exportacao.getValor_unitario()),
					(t_jw_registros_exportacao.getDde() == null ? "" : t_jw_registros_exportacao.getDde()),
					(t_jw_registros_exportacao.getDescricao_produto() == null ? "" : t_jw_registros_exportacao.getDescricao_produto()),
					(t_jw_registros_exportacao.getProduto() == null ? "" : t_jw_registros_exportacao.getProduto()),
					(t_jw_registros_exportacao.getNumero_drawback() == null ? "" : t_jw_registros_exportacao.getNumero_drawback()),
					(t_jw_registros_exportacao.getComponente() == null ? "" : t_jw_registros_exportacao.getComponente()),
					(t_jw_registros_exportacao.getConsumo()),
					(t_jw_registros_exportacao.getFil_filial() == null ? "" : t_jw_registros_exportacao.getFil_filial())

			);
			if (!listaRegistroExportacao.contains(registro)) {
				registro.setListaComponenteConsumo(new ArrayList<ComponenteConsumo>());
				listaRegistroExportacao.add(registro);
			}
			indice++;
		}
		for (Registro registro : listaRegistroExportacao) {
			indice = 0;
			while (indice < res_Jw_registros_exportacao.size()) {
				portalbr.dbobj.view.Jw_registros_exportacao t_jw_registros_exportacao = (portalbr.dbobj.view.Jw_registros_exportacao) res_Jw_registros_exportacao.elementAt(indice);
				ComponenteConsumo componenteConsumo = new ComponenteConsumo(
						(t_jw_registros_exportacao.getComponente() == null ? "" : t_jw_registros_exportacao.getComponente()),
						(t_jw_registros_exportacao.getConsumo()));

				Registro novoRegistro = new Registro(
						(t_jw_registros_exportacao.getNumero_re() == null ? "" : t_jw_registros_exportacao.getNumero_re()),
						((java.sql.Date) t_jw_registros_exportacao.getData_embarque()),
						((java.sql.Date) t_jw_registros_exportacao.getData_averbacao()),
						(t_jw_registros_exportacao.getEmp_empresa() == null ? "" : t_jw_registros_exportacao.getEmp_empresa()),
						(t_jw_registros_exportacao.getAno_fatura() == null ? "" : t_jw_registros_exportacao.getAno_fatura()),
						(t_jw_registros_exportacao.getNumero_fatura() == null ? "" : t_jw_registros_exportacao.getNumero_fatura()),
						(t_jw_registros_exportacao.getNcm() == null ? "" : t_jw_registros_exportacao.getNcm()),
						(t_jw_registros_exportacao.getPares()),
						(t_jw_registros_exportacao.getPerc_comissao() == null ? null : t_jw_registros_exportacao.getPerc_comissao()),
						(t_jw_registros_exportacao.getFob()), (t_jw_registros_exportacao.getValor_comissao()),
						(t_jw_registros_exportacao.getFob_liquido()),
						(t_jw_registros_exportacao.getNome_despachante() == null ? "" : t_jw_registros_exportacao.getNome_despachante()),
						(t_jw_registros_exportacao.getValor_unitario()),
						(t_jw_registros_exportacao.getDde() == null ? "" : t_jw_registros_exportacao.getDde()),
						(t_jw_registros_exportacao.getDescricao_produto() == null ? "" : t_jw_registros_exportacao.getDescricao_produto()),
						(t_jw_registros_exportacao.getProduto() == null ? "" : t_jw_registros_exportacao.getProduto()),
						(t_jw_registros_exportacao.getNumero_drawback() == null ? "" : t_jw_registros_exportacao.getNumero_drawback()),
						(t_jw_registros_exportacao.getComponente() == null ? "" : t_jw_registros_exportacao.getComponente()),
						(t_jw_registros_exportacao.getConsumo()),
						(t_jw_registros_exportacao.getFil_filial() == null ? "" : t_jw_registros_exportacao.getFil_filial())
				);
				if (novoRegistro.equals(registro)) {
					if (!registro.getListaComponenteConsumo().contains(componenteConsumo)) {
						registro.getListaComponenteConsumo().add(componenteConsumo);
					}
				}
				indice++;
			}
		}

		return listaRegistroExportacao;
	}

	public class Registro {
		private String numeroRe;
		private java.sql.Date dataEmbarque;
		private java.sql.Date dataAverbacao;
		private String empEmpresa;
		private String anoFatura;
		private String numeroFatura;
		private String ncm;
		private Integer pares;
		private Double percComissao;
		private Double fob;
		private Double valorComissao;
		private Double fobLiquido;
		private String nomeDespachante;
		private Double valorUnitario;
		private String dde;
		private String produto;
		private String descricaoProduto;
		private String numeroDrawback;
		private String componente;
		private Double consumo;
		private String filFilial;
		private List<ComponenteConsumo> listaComponenteConsumo;

		public Registro() {
		}

		public Registro(String numeroRe, java.sql.Date dataEmbarque, java.sql.Date dataAverbacao, String empEmpresa,
				String anoFatura, String numeroFatura, String ncm, Integer pares, Double percComissao, Double fob,
				Double valorComissao, Double fobLiquido, String nomeDespachante, Double valorUnitario, String dde,
				String produto, String descricaoProduto, String numeroDrawback, String componente, Double consumo, String filFilial) {
			super();
			this.numeroRe = numeroRe;
			this.dataEmbarque = dataEmbarque;
			this.dataAverbacao = dataAverbacao;
			this.empEmpresa = empEmpresa;
			this.anoFatura = anoFatura;
			this.numeroFatura = numeroFatura;
			this.ncm = ncm;
			this.pares = pares;
			this.percComissao = percComissao;
			this.fob = fob;
			this.valorComissao = valorComissao;
			this.fobLiquido = fobLiquido;
			this.nomeDespachante = nomeDespachante;
			this.valorUnitario = valorUnitario;
			this.dde = dde;
			this.produto = produto;
			this.descricaoProduto = descricaoProduto;
			this.numeroDrawback = numeroDrawback;
			this.componente = componente;
			this.consumo = consumo;
			this.filFilial = filFilial;
		}

		public String getNumeroRe() {
			return numeroRe;
		}

		public void setNumeroRe(String numeroRe) {
			this.numeroRe = numeroRe;
		}

		public java.sql.Date getDataEmbarque() {
			return dataEmbarque;
		}

		public void setDataEmbarque(java.sql.Date dataEmbarque) {
			this.dataEmbarque = dataEmbarque;
		}

		public java.sql.Date getDataAverbacao() {
			return dataAverbacao;
		}

		public void setDataAverbacao(java.sql.Date dataAverbacao) {
			this.dataAverbacao = dataAverbacao;
		}

		public String getEmpEmpresa() {
			return empEmpresa;
		}

		public void setEmpEmpresa(String empEmpresa) {
			this.empEmpresa = empEmpresa;
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

		public String getNcm() {
			return ncm;
		}

		public void setNcm(String ncm) {
			this.ncm = ncm;
		}

		public Integer getPares() {
			return pares;
		}

		public void setPares(Integer pares) {
			this.pares = pares;
		}

		public Double getPercComissao() {
			return percComissao;
		}

		public void setPercComissao(Double percComissao) {
			this.percComissao = percComissao;
		}

		public Double getFob() {
			return fob;
		}

		public void setFob(Double fob) {
			this.fob = fob;
		}

		public Double getValorComissao() {
			return valorComissao;
		}

		public void setValorComissao(Double valorComissao) {
			this.valorComissao = valorComissao;
		}

		public Double getFobLiquido() {
			return fobLiquido;
		}

		public void setFobLiquido(Double fobLiquido) {
			this.fobLiquido = fobLiquido;
		}

		public String getNomeDespachante() {
			return nomeDespachante;
		}

		public void setNomeDespachante(String nomeDespachante) {
			this.nomeDespachante = nomeDespachante;
		}

		public Double getValorUnitario() {
			return valorUnitario;
		}

		public void setValorUnitario(Double valorUnitario) {
			this.valorUnitario = valorUnitario;
		}

		public String getDde() {
			return dde;
		}

		public void setDde(String dde) {
			this.dde = dde;
		}

		public String getProduto() {
			return produto;
		}

		public void setProduto(String produto) {
			this.produto = produto;
		}

		public String getDescricaoProduto() {
			return descricaoProduto;
		}

		public void setDescricaoProduto(String descricaoProduto) {
			this.descricaoProduto = descricaoProduto;
		}

		public String getNumeroDrawback() {
			return numeroDrawback;
		}

		public void setNumeroDrawback(String numeroDrawback) {
			this.numeroDrawback = numeroDrawback;
		}

		public String getComponente() {
			return componente;
		}

		public void setComponente(String componente) {
			this.componente = componente;
		}

		public Double getConsumo() {
			return consumo;
		}

		public void setConsumo(Double consumo) {
			this.consumo = consumo;
		}

		public String getFilFilial() {
			return filFilial;
		}

		public void setFilFilial(String filFilial) {
			this.filFilial = filFilial;
		}

		public List<ComponenteConsumo> getListaComponenteConsumo() {
			return listaComponenteConsumo;
		}

		public void setListaComponenteConsumo(List<ComponenteConsumo> listaComponenteConsumo) {
			this.listaComponenteConsumo = listaComponenteConsumo;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((anoFatura == null) ? 0 : anoFatura.hashCode());
			result = prime * result + ((dataAverbacao == null) ? 0 : dataAverbacao.hashCode());
			result = prime * result + ((dataEmbarque == null) ? 0 : dataEmbarque.hashCode());
			result = prime * result + ((dde == null) ? 0 : dde.hashCode());
			result = prime * result + ((descricaoProduto == null) ? 0 : descricaoProduto.hashCode());
			result = prime * result + ((empEmpresa == null) ? 0 : empEmpresa.hashCode());
			result = prime * result + ((fob == null) ? 0 : fob.hashCode());
			result = prime * result + ((fobLiquido == null) ? 0 : fobLiquido.hashCode());
			result = prime * result + ((ncm == null) ? 0 : ncm.hashCode());
			result = prime * result + ((nomeDespachante == null) ? 0 : nomeDespachante.hashCode());
			result = prime * result + ((numeroDrawback == null) ? 0 : numeroDrawback.hashCode());
			result = prime * result + ((numeroFatura == null) ? 0 : numeroFatura.hashCode());
			result = prime * result + ((numeroRe == null) ? 0 : numeroRe.hashCode());
			result = prime * result + ((pares == null) ? 0 : pares.hashCode());
			result = prime * result + ((percComissao == null) ? 0 : percComissao.hashCode());
			result = prime * result + ((produto == null) ? 0 : produto.hashCode());
			result = prime * result + ((valorComissao == null) ? 0 : valorComissao.hashCode());
			result = prime * result + ((valorUnitario == null) ? 0 : valorUnitario.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Registro other = (Registro) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (anoFatura == null) {
				if (other.anoFatura != null)
					return false;
			} else if (!anoFatura.equals(other.anoFatura))
				return false;
			if (dataAverbacao == null) {
				if (other.dataAverbacao != null)
					return false;
			} else if (!dataAverbacao.equals(other.dataAverbacao))
				return false;
			if (dataEmbarque == null) {
				if (other.dataEmbarque != null)
					return false;
			} else if (!dataEmbarque.equals(other.dataEmbarque))
				return false;
			if (dde == null) {
				if (other.dde != null)
					return false;
			} else if (!dde.equals(other.dde))
				return false;
			if (descricaoProduto == null) {
				if (other.descricaoProduto != null)
					return false;
			} else if (!descricaoProduto.equals(other.descricaoProduto))
				return false;
			if (empEmpresa == null) {
				if (other.empEmpresa != null)
					return false;
			} else if (!empEmpresa.equals(other.empEmpresa))
				return false;
			if (fob == null) {
				if (other.fob != null)
					return false;
			} else if (!fob.equals(other.fob))
				return false;
			if (fobLiquido == null) {
				if (other.fobLiquido != null)
					return false;
			} else if (!fobLiquido.equals(other.fobLiquido))
				return false;
			if (ncm == null) {
				if (other.ncm != null)
					return false;
			} else if (!ncm.equals(other.ncm))
				return false;
			if (nomeDespachante == null) {
				if (other.nomeDespachante != null)
					return false;
			} else if (!nomeDespachante.equals(other.nomeDespachante))
				return false;
			if (numeroDrawback == null) {
				if (other.numeroDrawback != null)
					return false;
			} else if (!numeroDrawback.equals(other.numeroDrawback))
				return false;
			if (numeroFatura == null) {
				if (other.numeroFatura != null)
					return false;
			} else if (!numeroFatura.equals(other.numeroFatura))
				return false;
			if (numeroRe == null) {
				if (other.numeroRe != null)
					return false;
			} else if (!numeroRe.equals(other.numeroRe))
				return false;
			if (pares == null) {
				if (other.pares != null)
					return false;
			} else if (!pares.equals(other.pares))
				return false;
			if (percComissao == null) {
				if (other.percComissao != null)
					return false;
			} else if (!percComissao.equals(other.percComissao))
				return false;
			if (produto == null) {
				if (other.produto != null)
					return false;
			} else if (!produto.equals(other.produto))
				return false;
			if (valorComissao == null) {
				if (other.valorComissao != null)
					return false;
			} else if (!valorComissao.equals(other.valorComissao))
				return false;
			if (valorUnitario == null) {
				if (other.valorUnitario != null)
					return false;
			} else if (!valorUnitario.equals(other.valorUnitario))
				return false;
			return true;
		}

		private RegistroExportacao getOuterType() {
			return RegistroExportacao.this;
		}

	}

	public class ComponenteConsumo {
		private String componente;
		private Double consumo;

		public ComponenteConsumo(String componente, Double consumo) {
			super();
			this.componente = componente;
			this.consumo = consumo;
		}

		public String getComponente() {
			return componente;
		}

		public void setComponente(String componente) {
			this.componente = componente;
		}

		public Double getConsumo() {
			return consumo;
		}

		public void setConsumo(Double consumo) {
			this.consumo = consumo;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((componente == null) ? 0 : componente.hashCode());
			result = prime * result + ((consumo == null) ? 0 : consumo.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ComponenteConsumo other = (ComponenteConsumo) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (componente == null) {
				if (other.componente != null)
					return false;
			} else if (!componente.equals(other.componente))
				return false;
			if (consumo == null) {
				if (other.consumo != null)
					return false;
			} else if (!consumo.equals(other.consumo))
				return false;
			return true;
		}

		private RegistroExportacao getOuterType() {
			return RegistroExportacao.this;
		}

	}
}