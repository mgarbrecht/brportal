package util.consultas.com;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdministradorPedidos {

	public double getQuantidadeDisponivel(com.egen.util.jdbc.JdbcUtil j, int ano, int mes, int periodo, int linha) throws Exception {
		double retorno = 0;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			StringBuilder query = new StringBuilder();
			query.append(" SELECT disponivel ");
 			query.append("   FROM (SELECT t.lin_codigo linha ");
 			query.append("              , ano ");
 			query.append("              , t.periodo ");
 			query.append("              , SUM(capacidade_pares) capacidade ");
 			query.append("              , SUM(venda_pares) vendas ");
 			query.append("              , SUM(capacidade_pares) - SUM(venda_pares) disponivel ");
 			query.append("           FROM toneis t ");
 			query.append("          GROUP BY t.lin_codigo ");
 			query.append("                 , t.periodo ");
 			query.append("                 , ano) ");
 			query.append("  WHERE ano = ").append(ano);
			query.append("    AND linha = ").append(linha);
			query.append("    AND periodo = ").append(periodo);
			
			pstm = j.getConn().prepareStatement(query.toString());
			rset = pstm.executeQuery();
			if (rset.next()) {
				retorno = rset.getDouble(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				rset.close();
			}
			if (pstm != null) {
				pstm.close();
			}

		}
		return retorno;
	}
}
