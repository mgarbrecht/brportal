package util.boleto;

import util.consultas.Query;

public class CodigoBarraCaixa {

	
	public String getLinhaDigitavelByTitulo(com.egen.util.jdbc.JdbcUtil j, String titulo) {
		Query query = new Query();
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT fct_ctr_gera_linha_digitavel(fct_ctr_cod_barra_caixa_bol(t.emp_empresa, t.fil_filial, t.tip_codigo, t.tit_codigo)) "); 
			sb.append("   FROM titulos t ");
			sb.append("  WHERE tit_codigo = '").append(titulo).append("'");
			String linhaDigitavel = query.retorna(j, sb.toString());
			return linhaDigitavel;
		} catch (Exception e) {
			return null;
		}
	}
	
	public String getLinhaDigitavelByTitulo(String titulo) {
		Query query = new Query();
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT fct_ctr_gera_linha_digitavel(fct_ctr_cod_barra_caixa_bol(t.emp_empresa, t.fil_filial, t.tip_codigo, t.tit_codigo)) "); 
			sb.append("   FROM titulos t ");
			sb.append("  WHERE tit_codigo = '").append(titulo).append("'");
			String linhaDigitavel = query.retorna(sb.toString());
			return linhaDigitavel;
		} catch (Exception e) {
			return null;
		}
	}

}