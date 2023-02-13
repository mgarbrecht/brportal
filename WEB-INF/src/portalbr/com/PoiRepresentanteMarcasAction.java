package portalbr.com;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.egen.util.jdbc.*;
import com.egen.util.text.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 13/03/2006 15:41:20
 * Last Modify Date 04/04/2013 08:31:33
 */

public class PoiRepresentanteMarcasAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    String representante = "";
    String regional = "";
    PoiRepresentanteMarcasActionForm f = (PoiRepresentanteMarcasActionForm) form;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      if (f.getF_representante() != "") {
        representante = f.getF_representante();
      } else {
        representante = f.getRep_cdgo();
      }

      StringBuilder af = new StringBuilder();
      af.append("/com/PoiRegionalMarcas_rForm.do?&ano=").append(f.getAno());
      af.append("&mes=").append(f.getMes());
      af.append("&ano_final=").append(f.getAno_final());
      af.append("&mes_final=").append(f.getMes_final());
      af.append("&rep_cdgo=").append(representante);
      af.append("&codigo_regional=");
      af.append("&flag=3");
      af.append("&tipo=POI - Representante por Marcas");
      actionForward = new ActionForward(af.toString());


    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_poi", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return actionForward;
  }
  private void select_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    PoiRepresentanteMarcasActionForm f = (PoiRepresentanteMarcasActionForm) form;
    //-----------------------------------------------------------------------------
    String representante = "null";
    String regional = "null";
    String representante_free = "null";
    String unidade = "null";
    if (f.getF_representante() != "") {
      representante_free = f.getF_representante();
    }
    if (f.getRep_cdgo() != "") {
      representante = f.getRep_cdgo();
    }
    if (f.getF_regional() != "") {
      regional = f.getF_regional();
    }
    //-----------------------------------------------------------------------------
    portalbr.dbobj.view.Jw_poi table = new portalbr.dbobj.view.Jw_poi();
    StringBuilder query = new StringBuilder();
    query.append(" SELECT r.codigo_regional ");
    query.append("      , r.nome_regional ");
    query.append("      , gr.codigo_gerente ");
    query.append("      , gr.nome_gerente ");
    query.append("      , gr.endereco_gerente||', '||gr.numero_gerente endereco ");
    query.append("      , gr.estado_gerente ");
    query.append("      , '' ");
    query.append("      , '' ");
    query.append("   FROM cotas_linhas_reais t ");
    query.append("      , regionais_vendas r ");
    query.append("      , gerentes_regionais_vendas gr ");
    query.append("      , uni_negocio u ");
    query.append("  WHERE t.codigo_linha           = 999 ");
    query.append("    AND t.emp_empresa            = '01' ");
    query.append("    AND r.codigo_regional        = nvl(").append(regional).append(",r.codigo_regional) ");
    query.append("    AND t.codigo_representante   = nvl(").append(representante).append(",t.codigo_representante) ");
    query.append("    AND t.codigo_representante   = nvl(").append(representante_free).append(",t.codigo_representante) ");
    query.append("    AND ( ");
    query.append("          (t.mes_venda_reais  >= ").append(f.getMes()).append(" and t.ano_venda_reais >= ").append(f.getAno()).append(") ");
    query.append("          and ");
    query.append("          (t.mes_venda_reais  <= ").append(f.getMes_final()).append(" and t.ano_venda_reais <= ").append(f.getAno_final()).append(") ");
    query.append("        ) ");
    query.append("    AND t.unidade_negocio        = nvl(").append(unidade).append(",t.unidade_negocio) ");
    query.append(((!f.getSituacao_gerente().equals("T")) ? " and  gr.situacao_gerente = '"+f.getSituacao_gerente() + "'":""));
    query.append("    AND gr.codigo_regional       = r.codigo_regional ");
    query.append("    AND gr.codigo_gerente        = t.codigo_gerente ");
    query.append("    AND u.unn_codigo             = t.unidade_negocio ");
    query.append("  GROUP BY r.codigo_regional   ");
    query.append("         , r.nome_regional     ");
    query.append("         , gr.codigo_gerente   ");
    query.append("         , gr.nome_gerente     ");
    query.append("         , gr.endereco_gerente ");
    query.append("         , gr.numero_gerente   ");
    query.append("         , r.ender_regional    ");
    query.append("         , gr.estado_gerente   ");
    query.append("  ORDER BY r.codigo_regional    ");


    Vector res_Jw_poi = j.select(table, query.toString(), null);

    session.setAttribute("res_Jw_poi",res_Jw_poi);
    if (!(res_Jw_poi != null && res_Jw_poi.size() > 0)) {
      throw new Exception("Nenhum registro encontrado.");
    }
    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      PoiRepresentanteMarcasActionForm f = (PoiRepresentanteMarcasActionForm) form;
      session.removeAttribute("res_Jw_poi");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_poi", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
