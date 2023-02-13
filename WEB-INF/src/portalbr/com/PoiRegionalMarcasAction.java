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
 * Last Modify Date 06/09/2022 15:48:40
 */

public class PoiRegionalMarcasAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    String representante = "";
    String regional = "";
    PoiRegionalMarcasActionForm f = (PoiRegionalMarcasActionForm) form;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      if (f.getF_representante() != "") {
        representante = f.getF_representante();
      } else {
        representante = f.getRep_cdgo();
      }

      if (f.getF_regional() != "") {
        regional = f.getF_regional();
      } else {
        regional = f.getCodigo_regional();
      }
      actionForward = new ActionForward("/com/PoiRegionalMarcas_rForm.do?&ano="+f.getAno() + "&mes="+f.getMes() + "&ano_final="+f.getAno_final() + "&mes_final="+f.getMes_final() + "&rep_cdgo="+representante + "&codigo_regional="+regional + "&flag=1"+ "&tipo=POI - Regional por Marcas"+ "&marca="+f.getCodigo_marca() + "&agrupa_regionais="+f.getAgrupa_regionais(), true);

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
    PoiRegionalMarcasActionForm f = (PoiRegionalMarcasActionForm) form;

    //-----------------------------------------------------------------------------
    String representante = "null";
    String regional = "null";
    String marca = "null";
    String representante_free = "null";
    String regional_free = "null";
    String unidade = "null";

    if (f.getF_representante() != "") {
      representante_free = f.getF_representante();
    }
    if (f.getF_regional() != "") {
      regional_free = f.getF_regional();
    }

    if (f.getRep_cdgo() != "") {
      representante = f.getRep_cdgo();
    }

    if (f.getCodigo_marca() != "") {
      marca = f.getCodigo_marca();
    }

    if (f.getCodigo_regional() != "" && f.getF_representante().equals("")) {
      regional = f.getCodigo_regional() + "";
    }

    if (f.getUnidade_negocio() != "") {
      unidade = f.getUnidade_negocio();
    }

    //-----------------------------------------------------------------------------

    acesso.Usuario u = new acesso.Usuario();
    u = (acesso.Usuario) session.getAttribute("User");
    acesso.Sessao se = new acesso.Sessao(session);

    if (!u.isSuperUsuario()) {
      if ((!(se.getTipoEntidadeNegocio().equals("AREAS"))) && (f.getCodigo_regional() == "")) {
        throw new Exception("Informe a Regional!");
      }
    }

    if (regional.equals("null") && regional_free.equals("null")) {
      if (f.getAgrupa_regionais().equals("S")) {
        regional = "0";
      }
    }

    if (!(regional.equals("null"))) {
      if (!(regional.equals("0"))) {
        f.setAgrupa_regionais("N");
      }
    }
    if (!(regional_free.equals("null"))) {
      f.setAgrupa_regionais("N");
    }


    portalbr.dbobj.view.Jw_poi table = new portalbr.dbobj.view.Jw_poi();

    StringBuilder query = new StringBuilder();
    query.append(" SELECT r.codigo_regional ");
    query.append("      , r.nome_regional ");
    query.append("      , gr.codigo_gerente ");
    query.append("      , gr.nome_gerente ");
    query.append("      , gr.endereco_gerente||', '||gr.numero_gerente endereco ");
    query.append("      , gr.estado_gerente ");
    query.append("      , '' unidade_negocio ");
    query.append("      , '' unn_descri ");
    query.append("   FROM cotas_linhas_reais t ");
    query.append("      , regionais_vendas r ");
    query.append("      , gerentes_regionais_vendas gr ");
    query.append("      , uni_negocio u ");
    query.append("  WHERE t.codigo_linha           = 999 ");
    query.append("    AND t.emp_empresa            = '01' ");
    query.append("    AND r.codigo_regional        = nvl(").append(regional).append(",r.codigo_regional) ");
    query.append("    AND t.codigo_representante   = nvl(").append(representante).append(",t.codigo_representante) ");
    query.append("    AND r.codigo_regional        = nvl(").append(regional_free).append(",r.codigo_regional) ");
    query.append("    AND t.codigo_representante   = nvl(").append(representante_free).append(",t.codigo_representante) ");
    query.append("    AND ( ");
    query.append("          (t.mes_venda_reais  >= ").append(f.getMes()).append(" and t.ano_venda_reais >= ").append(f.getAno()).append(") ");
    query.append("          and ");
    query.append("          (t.mes_venda_reais  <= ").append(f.getMes_final()).append(" and t.ano_venda_reais <= ").append(f.getAno_final()).append(") ");
    query.append("        ) ");
    query.append("    AND t.unidade_negocio        = nvl(").append(unidade).append(",t.unidade_negocio) ");
    query.append("    AND t.codigo_marca           = nvl(").append(marca).append(", t.codigo_marca) ");
    query.append("    AND gr.codigo_regional       = r.codigo_regional ");
    query.append("    AND gr.codigo_gerente        = t.codigo_gerente ");
    query.append(((!f.getSituacao_gerente().equals("T")) ? " and gr.situacao_gerente  = '" + f.getSituacao_gerente() + "'":""));
    query.append("    AND u.unn_codigo             = t.unidade_negocio ");
    query.append("  GROUP BY r.codigo_regional ");
    query.append("         , r.nome_regional ");
    query.append("         , gr.codigo_gerente ");
    query.append("         , gr.nome_gerente ");
    query.append("         , gr.endereco_gerente ");
    query.append("         , gr.numero_gerente ");
    query.append("         , r.ender_regional ");
    query.append("         , gr.estado_gerente ");

    if (regional.equals("0")) {
      query.append("  UNION ALL ");
      query.append(" SELECT 0 codigo_regional ");
      query.append("      , 'TODAS' nome_regional ");
      query.append("      , null codigo_gerente ");
      query.append("      , '' nome_gerente ");
      query.append("      , ''  endereco ");
      query.append("      , '' estado_gerente ");
      query.append("      , '' unidade_negocio ");
      query.append("      , '' unn_descri ");
      query.append("   FROM dual ");
    }

    query.append("  ORDER BY codigo_gerente ");
    query.append("         , codigo_regional ");


    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      throw new Exception(query.toString());
    }

    Vector res_Jw_poi = j.select(table, query.toString(), null);

    /* Add situacao_gerente no filtro e retirado do relatorio.
       Alterada Ordenação primeiro por codigo_gerente
         Anterior: "order by t.unidade_negocio,r.codigo_regional"

    */

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
      PoiRegionalMarcasActionForm f = (PoiRegionalMarcasActionForm) form;
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
