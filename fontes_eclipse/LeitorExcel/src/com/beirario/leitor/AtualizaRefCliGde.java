package com.beirario.leitor;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.beirario.excel.ArquivoExcel;

public class AtualizaRefCliGde {

	public static void atualiza(ArquivoExcel arq, String filialFaturamento, String ordemCompra) throws Exception {
		Connection conexao = buscaConexao();
		CallableStatement call = null;
		try {
			verificaInconsistencias(arq, conexao, ordemCompra);
			for (int i = 0; i <= arq.getLinhas().size() - 1; i++) {
				String ean = arq.getLinhas().get(i).getEan();
				String material = arq.getLinhas().get(i).getMaterial();
				call = conexao.prepareCall("{ call brio.pck_ref_cli_gde.insere_prod_por_ean(?,?,?,?) }");
				call.setString(1, ean);
				call.setString(2, material);
				call.setString(3, ordemCompra);
				call.setString(4, filialFaturamento);
				call.execute();
			}
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		} finally {
			if (call != null && !call.isClosed()) {
				call.close();
			}
			if (conexao != null && !conexao.isClosed()) {
				conexao.close();
			}
		}
	}

	private static void verificaInconsistencias(ArquivoExcel arq, Connection con, String ordemCompra) throws Exception {
		List<String> inconsistencias = new ArrayList<String>();
		CallableStatement call = null;
		for (int i = 0; i <= arq.getLinhas().size() - 1; i++) {
			try {
				String ean = arq.getLinhas().get(i).getEan();
				String material = arq.getLinhas().get(i).getMaterial();
				call = con.prepareCall("{ ? = call brio.pck_ref_cli_gde.verifica_existe_ean_oc(?,?,?) }");
				call.registerOutParameter(1, Types.INTEGER);
				call.setString(2, ordemCompra);
				call.setString(3, ean);
				call.setString(4, material);
				call.execute();
				int retorno = call.getInt(1);
				if (retorno <= 0) {
					inconsistencias.add(ean);
				}
			} catch (Exception e) {
			} finally {
				if (call != null && !call.isClosed()) {
					call.close();
				}
			}
		}

		if (inconsistencias.size() > 0) {
			throw new Exception("Os seguintes códigos de barras não foram encontrados para nenhum pedido referente à OC informada:\n " + inconsistencias.toString().replace(",", "\n").replace("[", "").replace("]", "").replace(" ", "") + "\n Importação não realizada.");
		}

	}

	private static Connection buscaConexao() throws Exception {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@dbm0-scan1.beirario.intranet:1521/orabrio", "wbrio", "wbrio");
		} catch (Exception ex) {
			throw ex;
		}
		return con;
	}
}
