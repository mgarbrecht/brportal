package brportal.ind;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.servlet.http.HttpServletRequest;

public class Pse0050 {

	private Integer remessa = null;
	private Integer talao = null;
	private String linha = null;
	private String referencia = null;
	private String cabedal = null;
	private String cor = null;
	private Double pares = null; 
	private String fornecedor = null;
	private String processo = null;

	public String processaPreEnvio( String codigoBarra
            , String fornecedor
            , String processo
            , HttpServletRequest req ) throws Exception {
		return null;
	}

	/*public String processaPreEnvio( String codigoBarra
								  , String fornecedor
								  , String processo) {

		this.fornecedor = fornecedor;
		this.processo = processo;
		com.egen.util.jdbc.JdbcUtil j = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			if(!abreCodigoTalaoMestre(codigoBarra)){
				return "Erro na leitura do código de barras!";		
			}
			j = new com.egen.util.jdbc.JdbcUtil();
			pstm = j.getConn().prepareStatement(
					new StringBuilder(" SELECT rem.lin_cdgo ")
							  .append("      , tal.ref_cdgo ")
							  .append("      , cab.cab_cdgo ")
							  .append("      , cor.cor_desc ")
							  .append(" 	 , tal.tal_pares ")
							  .append("   FROM talao tal ")
							  .append("      , remessa rem ")
							  .append("      , cabedal cab ")
							  .append("      , cor ")
							  .append("  WHERE cor.cor_cdgo = tal.cor_cdgo ")
							  .append("    AND cab.cab_cdgo = tal.cab_cdgo ")
							  .append("    AND rem.rem_nro  = tal.rem_nro ")
							  .append("    AND tal.tal_nro  = ").append(this.talao)
							  .append("    AND tal.rem_nro  = ").append(this.remessa).toString());		

			rset = pstm.executeQuery();

			if(rset.next()) {
				this.linha = rset.getString(1);
				this.referencia = rset.getString(2);
				this.cabedal = rset.getString(3);
				this.cor = rset.getString(4);
				this.pares = rset.getDouble(5);
			}

			if(this.linha == null){
				return "Talão Inexistente!";
			}

			pstm = j.getConn().prepareStatement(
					new StringBuilder(" SELECT 'A' ")
							  .append("   FROM atelier_pre_envio  ")
							  .append("  WHERE for_codigo = ").append(this.fornecedor)
							  .append("    AND fen_seq    = 1 ")
							  .append("    AND rem_nro    = ").append(this.remessa)
							  .append("    AND tal_nro    = ").append(this.talao)
							  .append("    AND pro_numero = ").append(this.processo)
							  .append("    AND status IS NULL ")
							  .append("    AND ROWNUM = 1 ")
							  .append("  UNION ")
							  .append(" SELECT 'E' ")
							  .append("   FROM atelier_rem_taloes_oc a ")
							  .append("  WHERE a.aroc_rem_nro = ").append(this.remessa)
							  .append("    AND a.tal_nro      = ").append(this.talao)
							  .append("    AND a.pro_numero   = ").append(this.processo)
							  .append("    AND ROWNUM         = 1 ").toString());    				

			rset = pstm.executeQuery();

			if(rset.next()) {
				if(rset.getString(1).equals("A")){
					return "Talão já lido!";
				} else if (rset.getString(1).equals("E")){
					return "Talão já enviado!";
				}
			}


			pstm = j.getConn().prepareStatement(
					new StringBuilder(" SELECT 1 ")
							  .append("   FROM talao ")
							  .append("  WHERE rem_nro    = ? ")
							  .append("    AND tal_nro    = ? ")
							  .append("    AND tal_status = 'C' ").toString());		

			pstm.setInt(1, this.remessa);
			pstm.setInt(2, this.talao);
			rset = pstm.executeQuery();
			if(rset.next()) {
				return "Talão já encerrado!";
			}       


			pstm = j.getConn().prepareStatement(
					new StringBuilder(" INSERT INTO atelier_pre_envio ")
						      .append("    ( emp_empresa ")
						      .append("    , fil_filial ")
						      .append("    , for_codigo ")
						      .append("    , fen_seq ")
						      .append("    , ref_cdgo ")
						      .append("    , lin_cdgo ")
						      .append("    , pro_numero ")
						      .append("    , tal_pares ")
						      .append("    , rem_nro ")
						      .append("    , tal_nro ")
						      .append("    , data_pre_envio) ")
						      .append(" VALUES ")
						      .append("    ( '01' ")
						      .append("    , pck_remessa.get_filial(?) ")
						      .append("    , ? ")
						      .append("    , 1 ") 
						      .append("    , ? ")
						      .append("    , ? ")
						      .append("    , ? ")
						      .append("    , ? ")
						      .append("    , ? ")
						      .append("    , ? ")
						      .append("    , SYSDATE ) ").toString());		

			pstm.setInt(1, this.remessa);
			pstm.setString(2, this.fornecedor);
			pstm.setString(3, this.referencia);
			pstm.setString(4, this.linha);
			pstm.setString(5, this.processo);
			pstm.setDouble(6, this.pares);
			pstm.setInt(7, this.remessa);
			pstm.setInt(8, this.talao);

			pstm.executeUpdate();

		} catch (Exception e){
		} finally {
			if (rset != null)
				try {
					rset.close();
				} catch (SQLException e) {
				}
				if (pstm != null)
					try {
						pstm.close();
					} catch (SQLException e) {
					}
					if (j != null){
						j.close();		
					}
		}

		return new StringBuilder("ok ->")
	                   	 .append(" forn:").append(this.fornecedor)
		                 .append(" proc:").append(this.processo)
		                 .append(" rem:").append(this.remessa)
		                 .append(" tal:").append(this.talao)
		                 .append(" lin:").append(this.linha)
		                 .append(" ref:").append(this.referencia)
		                 .append(" cab:").append(this.cabedal)
		                 .append(" cor:").append(this.cor)
		                 .append(" qtd:").append(this.pares).toString();
	}
	*/

	public String processaPreRetorno( String codigoBarra
			                        , String fornecedor
			                        , String processo
			                        , HttpServletRequest req ) throws Exception {

		if (!abreCodigoTalaoMestre(codigoBarra)) {
			return "Erro na leitura do código de barras!";
		}
		
		this.fornecedor = fornecedor;
		this.processo = processo;
		com.egen.util.jdbc.JdbcUtil j = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		java.sql.Connection conexao = null; 
		try {
			j = new com.egen.util.jdbc.JdbcUtil();
			conexao = j.getConn();
			CallableStatement call = conexao.prepareCall("{ ? = call brio.fct_valida_processos_atelier(?,?,?,?) }");
			call.registerOutParameter(1, Types.INTEGER);
			call.registerOutParameter(5, Types.VARCHAR);
			call.setInt(2, this.remessa);
			call.setInt(3, this.talao);
			call.setString(4, this.processo);
			call.execute();
			int executouSucesso = call.getInt(1);
			String erros = null;
			if(executouSucesso == 0) {
				erros = call.getString(5);
			}
			if (call != null) {
				call.close();
			}
			if(executouSucesso == 0) {
				return erros;
			}
			
			pstm = conexao.prepareStatement(
					new StringBuilder(" SELECT rem.lin_cdgo ")
							  .append("      , tal.ref_cdgo ")
							  .append("      , cab.cab_cdgo ")
							  .append("      , cor.cor_desc ")
							  .append("      , tal.tal_pares ")
							  .append("   FROM talao tal ")
							  .append("      , remessa rem ")
							  .append("      , cabedal cab ")
							  .append("      , cor ")
							  .append("      , atelier_rem_taloes_oc a ")
							  .append("  WHERE cor.cor_cdgo   = tal.cor_cdgo ")
							  .append("    AND cab.cab_cdgo   = tal.cab_cdgo ")
							  .append("    AND rem.rem_nro    = tal.rem_nro ")
							  .append("    AND tal.tal_nro    = ").append(this.talao)
							  .append("    AND tal.rem_nro    = ").append(this.remessa)
							  .append("    AND a.for_codigo   = ").append(this.fornecedor)
							  .append("    AND a.pro_numero   = ").append(this.processo)
							  .append("    AND a.aroc_rem_nro = tal.rem_nro ")
							  .append("    AND a.tal_nro      = tal.tal_nro ")
							  .append("    AND a.status       = 'E' ").toString());

			rset = pstm.executeQuery();
			if (rset.next()) {
				this.linha = rset.getString(1);
				this.referencia = rset.getString(2);
				this.cabedal = rset.getString(3);
				this.cor = rset.getString(4);
				this.pares = rset.getDouble(5);
			}
			
			fecharConexoes(rset, pstm);

			if(this.linha == null){
				return "Talão inexistente!";
			}
			
			pstm = conexao.prepareStatement(
					new StringBuilder(" SELECT 'L' ")
							  .append("   FROM atelier_pre_envio a ")
							  .append("      , for_endere f ")
							  .append("  WHERE a.for_codigo     = ").append(this.fornecedor)
							  .append("    AND a.rem_nro        = ").append(this.remessa)
							  .append("    AND a.tal_nro        = ").append(this.talao)
							  .append("    AND a.pro_numero     = ").append(this.processo)							  
						 	  .append("    AND f.fen_ativo      = 'S' ")
						 	  .append("    AND f.for_codigo     = a.for_codigo ")
						 	  .append("    AND f.fen_seq        = a.fen_seq ")
							  .append("    AND a.status_consiste_atelier = 'C' ")
							  .append("    AND ROWNUM         = 1 ")
							  .append("  UNION ")
							  .append(" SELECT 'R' ")
							  .append("   FROM atelier_rem_taloes_oc a ")
							  .append("  WHERE a.aroc_rem_nro = ").append(this.remessa)
							  .append("    AND a.tal_nro      = ").append(this.talao)
							  .append("    AND a.pro_numero   = ").append(this.processo)
							  .append("    AND a.status       = 'R' ")
							  .append("    AND ROWNUM         = 1 ").toString());

			rset = pstm.executeQuery();
			
			if(rset.next()) {
				if(rset.getString(1).equals("L")){
					verificaUltimoTalao(conexao, req);
					return "Talão já lido!";
				} else if (rset.getString(1).equals("R")){
					return "Talão já retornou!";
				}
			}
			fecharConexoes(rset, pstm);
			
			if (this.processo.equals("1")) {
				pstm = conexao.prepareStatement(
						new StringBuilder(" SELECT COUNT(*) ")
								  .append("   FROM talao_fase ")
								  .append("  WHERE tlf_status = 'E' ")
								  .append("    AND NVL(set_cdgo, NULL) LIKE 'CORT%' ")
								  .append("    AND tal_nro = ").append(this.talao)
								  .append("    AND rem_nro = ").append(this.remessa).toString());		

				rset = pstm.executeQuery();
				if(rset.next()) {
					if(rset.getString(1).equals("0")){
						return "Talão " + this.remessa + "/" + this.talao + " não apontado no CORTE!";
					}
				}
				fecharConexoes(rset, pstm);
			}
			

			pstm = conexao.prepareStatement(
					new StringBuilder(" SELECT a.fen_seq ")
						 	  .append("   FROM atelier_pre_envio a ")
						 	  .append("      , for_endere f ")
						 	  .append("  WHERE a.for_codigo = ").append(this.fornecedor)
						 	  .append("    AND f.fen_ativo  = 'S' ")
						 	  .append("    AND f.for_codigo = a.for_codigo ")
						 	  .append("    AND f.fen_seq    = a.fen_seq ")
						 	  .append("    AND a.rem_nro    = ").append(this.remessa)
						 	  .append("    AND a.tal_nro    = ").append(this.talao)
						 	  .append("    AND a.pro_numero = ").append(this.processo)
						 	  .append("    AND a.status     = 'E' ")
						 	  .append("    AND ROWNUM       = 1 ").toString());		

			rset = pstm.executeQuery();
			
			if(rset.next()) {
				pstm = conexao.prepareStatement(
						new StringBuilder(" UPDATE atelier_pre_envio ")
								  .append("    SET status_consiste_atelier = 'C' ")
								  .append("      , status = 'E' ")
								  .append("      , consiste_atelier = 'S' ")
								  .append("      , data_pre_envio = SYSDATE ")
								  .append("  WHERE rem_nro     = ? ")
								  .append("    AND tal_nro     = ? ")
								  .append("    AND for_codigo  = ? ")
								  .append("    AND pro_numero  = ? ")
								  .append("    AND emp_empresa = '01' ")
								  .append("    AND fil_filial  = pck_remessa.get_filial(?) ")
								  .append("    AND fen_seq     = ").append(rset.getInt("fen_seq")).toString());
				pstm.setInt(1, this.remessa);
				pstm.setInt(2, this.talao);
				pstm.setString(3, this.fornecedor);
				pstm.setString(4, this.processo);
				pstm.setInt(5, this.remessa);
				pstm.executeUpdate();
				fecharConexoes(rset, pstm);

			} else {
				
					pstm = conexao.prepareStatement(
						new StringBuilder(" INSERT INTO atelier_pre_envio ")
							      .append("   ( emp_empresa ")
							      .append("   , fil_filial ")
							      .append("   , for_codigo ")
							      .append("   , fen_seq ")
							      .append("   , ref_cdgo ")
							      .append("   , lin_cdgo ")
							      .append("   , pro_numero ")
							      .append("   , tal_pares ")
							      .append("   , data_pre_envio ")
							      .append("   , rem_nro ")
							      .append("   , tal_nro ")
							      .append("   , status ")
							      .append("   , status_consiste_atelier ")
							      .append("   , consiste_atelier )  ")
							      .append(" VALUES ")
							      .append("   ( '01' ")
							      .append("   , pck_remessa.get_filial(?) ")
							      .append("   , ? ")
							      .append("   ,(SELECT fen_seq FROM for_endere f WHERE f.fen_ativo = 'S' AND for_codigo = ").append(this.fornecedor).append(" AND ROWNUM = ?) ")
							      .append("   , ? ")
							      .append("   , ? ")
							      .append("   , ? ")
							      .append("   , ? ")
							      .append("   , SYSDATE ")
							      .append("   , ? ")
							      .append("   , ? ")
							      .append("   , 'E' ")
							      .append("   , 'C' ")
							      .append("   , 'S' ) ").toString());
							      
				pstm.setInt(1, this.remessa);
				pstm.setString(2, this.fornecedor);
				pstm.setString(3, "1");
				pstm.setString(4, this.referencia);
				pstm.setString(5, this.linha);
				pstm.setString(6, this.processo);
				pstm.setDouble(7, this.pares);
				pstm.setInt(8, this.remessa);
				pstm.setInt(9, this.talao);
				pstm.executeUpdate();
				fecharConexoes(rset, pstm);
			}
			verificaUltimoTalao(conexao, req);
			
		} catch (Exception e) {
			e.printStackTrace(System.err);
		} finally {
			fecharConexoes(rset, pstm);
			if (conexao != null && !conexao.isClosed()) {
				conexao.close();
			}
			if (j != null) {
				j.close();		
			}
		}
		//----------
		return new StringBuilder("ok ->")
		                 .append(" forn:").append(this.fornecedor)
		                 .append(" proc:").append(this.processo)
		                 .append(" rem:").append(this.remessa)
		                 .append(" tal:").append(this.talao)
		                 .append(" lin:").append(this.linha)
		                 .append(" ref:").append(this.referencia)
		                 .append(" cab:").append(this.cabedal)
		                 .append(" cor:").append(this.cor)
		                 .append(" qtd:").append(this.pares).toString();
		                 
	}

	private boolean abreCodigoTalaoMestre(String codigoBarra) throws Exception {
		boolean retorno = true;
		try {
			this.remessa = Integer.parseInt(codigoBarra.substring(1,codigoBarra.indexOf("+")));
			this.talao = Integer.parseInt(codigoBarra.substring(codigoBarra.indexOf("+")+1, codigoBarra.length()));
			if(this.remessa == null || this.talao == null){
				retorno = false;
			}
		} catch (Exception e) {
			retorno = false;
		}
		return retorno;
	}
	
	private void verificaUltimoTalao(java.sql.Connection conexao, HttpServletRequest req)  {
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
		pstm = conexao.prepareStatement(
				new StringBuilder(" SELECT SUM(qtd_bipada) quantidade_bipada ")
						  .append("      , SUM(total_taloes) total_taloes_remessa ")
						  .append("   FROM (SELECT COUNT(tal_nro) qtd_bipada ")
						  .append("              , 0 total_taloes ")
						  .append("           FROM atelier_pre_envio ")
						  .append("          WHERE rem_nro = ").append(this.remessa)
						  .append("            AND NVL(for_codigo, NULL) = ").append(this.fornecedor)
						  .append(" 		   AND pro_numero = ").append(this.processo)
						  .append(" 		   AND emp_empresa = '01' ")
						  .append(" 		   AND fil_filial = pck_remessa.get_filial(").append(this.remessa).append(") ")
						  .append(" 		   AND status_consiste_atelier = 'C' ")
						  .append(" 		   AND status = 'E' ")
						  .append(" 	       AND consiste_atelier = 'S' ")
						  .append(" 		   AND fen_seq = (SELECT fen_seq ")
						  .append("                             FROM for_endere f ")
						  .append("                            WHERE f.fen_ativo = 'S' ")
						  .append("                              AND for_codigo = ").append(this.fornecedor)
						  .append("                              AND ROWNUM = 1) ")
						  .append("  UNION ")
						  .append(" SELECT 0 qtd_bipada ")
						  .append("      , COUNT(t.tal_nro) total_taloes ")
						  .append("   FROM talao t ")
						  .append("  WHERE t.rem_nro = ").append(this.remessa).append(") ")
						  .append(" HAVING SUM(total_taloes) > 0 ").toString());	
		
			rset = pstm.executeQuery();

			if (rset.next()) {
				int qtdBipada = rset.getInt("quantidade_bipada");
				int qtdTaloes = rset.getInt("total_taloes_remessa");
				if (qtdBipada == qtdTaloes) {
					req.getSession().setAttribute("ultimoTalaoRemessa", "O último talão da remessa " + this.remessa + " para o processo " + this.processo + " foi bipado!");
				}
			}
		} catch (Exception e) {
		} finally {
			fecharConexoes(rset, pstm);
		}
	}
	
	
	private void fecharConexoes(ResultSet rs, PreparedStatement pm) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pm != null) {
			try {
				pm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
