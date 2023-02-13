package util.consultas.com;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import com.egen.util.struts.DynaActionForm;
import portalbr.com.NecessidadeInsumos_rActionForm;
import util.consultas.Query;

public class NecessidadeInsumos {

	public void gerar(ActionForm form, HttpServletRequest req) throws Exception {
		req.removeAttribute("arquivo");
		DynaActionForm _ge_grid = (DynaActionForm) form;
		boolean informou = false;
		com.egen.util.jdbc.JdbcUtil j = null;
		java.sql.PreparedStatement pstm = null;
		java.sql.ResultSet rset = null;
		java.sql.CallableStatement call = null;
		StringBuilder sbOrdens = new StringBuilder();
		String parametroFornecedor = "Não informado";
		String parametroFilial = "Não informada";
		String parametroPeriodo = "Não informado";
		String parametroGrupoMaterial = null;
		String parametroMaterial = null;
		String parametroCor = null;
		try {
			j = new com.egen.util.jdbc.JdbcUtil();
			Query query = new Query();
			if(req.getSession().getAttribute("parametro_necessidade_insumos_grupo_material")!=null){
				parametroGrupoMaterial = (String)req.getSession().getAttribute("parametro_necessidade_insumos_grupo_material");
			}
			if(req.getSession().getAttribute("parametro_necessidade_insumos_material")!=null){
				parametroMaterial = (String)req.getSession().getAttribute("parametro_necessidade_insumos_material");
			}
			if(req.getSession().getAttribute("parametro_necessidade_insumos_cor")!=null){
				parametroCor = (String)req.getSession().getAttribute("parametro_necessidade_insumos_cor");
			}			
			if(req.getSession().getAttribute("parametro_necessidade_insumos_fornecedor")!=null){
				parametroFornecedor = query.retorna(j, "select for_codigo||' - '||for_razsoc fornecedor from fornecedor where for_codigo = " + (String)req.getSession().getAttribute("parametro_necessidade_insumos_fornecedor"));
			}
			if(req.getSession().getAttribute("parametro_necessidade_insumos_filial")!=null){
				parametroFilial = (String)req.getSession().getAttribute("parametro_necessidade_insumos_filial");
			}
			if(req.getSession().getAttribute("parametro_necessidade_insumos_data_inicial")!=null
					&& req.getSession().getAttribute("parametro_necessidade_insumos_data_final")!=null){
				parametroPeriodo = (String)req.getSession().getAttribute("parametro_necessidade_insumos_data_inicial") + " a " + req.getSession().getAttribute("parametro_necessidade_insumos_data_final");
			}
			NecessidadeInsumos_rActionForm[] _ge_grid_array = (NecessidadeInsumos_rActionForm[]) _ge_grid.get("bl_form_Jw_dom_ordem_compra_lines");
			NecessidadeInsumos_rActionForm f = _ge_grid_array[0];
			for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
				f = _ge_grid_array[_ge_grid_array_index];
				if (f.getGridCheckField()) {
					informou = true;
				}
			}
			if (!informou) {
				throw new Exception("Selecione uma ordem de compra!");
			}
			StringBuilder sb = new StringBuilder();
			try {
				sb.append("BEGIN ");
				for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
					f = _ge_grid_array[_ge_grid_array_index];
					if (f.getGridCheckField()) {
						sb.append("wbrio.pck_interface_compra_edi.add_ordem(").append(f.getNumero()).append("); ");
						if(sbOrdens.length()>0){
							sbOrdens.append(", ");
						}
						sbOrdens.append(f.getNumero());
					}
				}
				if(((String)req.getSession().getAttribute("necessidade_insumos_primeiro_nivel")).equalsIgnoreCase("S")){
					sb.append("wbrio.pck_interface_compra_edi.gera_consumo_materiais_nivel1(); ");					
				} else {
					sb.append("wbrio.pck_interface_compra_edi.gera_consumo_materiais(); ");					
				}
				sb.append("END;");
				call = j.getConn().prepareCall(sb.toString());
				call.execute();
				util.file.GeraPDF g = new util.file.GeraPDF(req);
				g.setRelatorio("NecessidadeInsumos.jasper");
				g.setParametro("P_ORDENS", sbOrdens.toString());
				g.setParametro("P_FILIAL", parametroFilial);
				g.setParametro("P_FORNECEDOR", parametroFornecedor);
				g.setParametro("P_PERIODO", parametroPeriodo);
				g.setParametro("P_GRUPO_MATERIAL", parametroGrupoMaterial);
				g.setParametro("P_MATERIAL", parametroMaterial);
				g.setParametro("P_COR", parametroCor);
				g.gerar(j.getConn());
			} catch (SQLException sqle) {
				throw new Exception(getErro(sqle));
			}
		} finally {
			if (rset != null) {
				rset.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			if (j != null) {
				j.close();
				j = null;
			}
		}
	}


	private String getErro(SQLException sqle) {
		return sqle.getMessage().substring(0, sqle.getMessage().indexOf("\n")).replace("ORA-20100: ", "");
	}
}
