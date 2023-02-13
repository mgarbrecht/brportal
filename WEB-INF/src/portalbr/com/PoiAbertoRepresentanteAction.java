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
 * Last Modify Date 06/09/2022 15:51:09
 */

public class PoiAbertoRepresentanteAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    String representante = "";
    String regional = "";
    String unidade = "null";
    String tipo = "POI - Aberto por Representante";
    PoiAbertoRepresentanteActionForm f = (PoiAbertoRepresentanteActionForm) form;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);

      if (f.getF_representante() != "") {
        representante = f.getF_representante();
        tipo = "POI - Aberto por Empresa de Representação";
      } else {
        representante = f.getRep_cdgo();
        if (f.getReps() != "") {
          representante = f.getReps();
        }
      }

      if (f.getF_regional() != "") {
        regional = f.getF_regional();
      } else {
        regional = f.getCodigo_regional();
      }

      if (f.getUnidade_negocio() != "") {
        unidade = f.getUnidade_negocio();
      }

      if ((representante.equals("") || (f.getF_representante() != "")) || ((!(f.getRep_cdgo().equals(""))))) {
        actionForward = new ActionForward("/com/PoiAbertoRepresentante_rForm.do?&ano="+f.getAno() + "&mes="+f.getMes() + "&mes_final="+f.getMes_final() + "&ano_final="+f.getAno_final() + "&rep_cdgo="+representante + "&codigo_regional="+regional + "&codigo_marca="+f.getCodigo_marca() + "&tipo="+tipo + "&unidade="+unidade, true);
      } else {
        actionForward = new ActionForward("/com/PoiAbertoRepresentanteRep_rForm.do?&ano="+f.getAno() + "&mes="+f.getMes() + "&mes_final="+f.getMes_final() + "&ano_final="+f.getAno_final() + "&rep_cdgo="+representante + "&codigo_regional="+regional + "&codigo_marca="+f.getCodigo_marca() + "&tipo="+tipo + "&unidade="+unidade, true);


      }

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
    PoiAbertoRepresentanteActionForm f = (PoiAbertoRepresentanteActionForm) form;
    //-----------------------------------------------------------------------------
    String representante = "";
    String marca = "";
    String regional = "null";
    StringBuilder representante_free = new StringBuilder();
    String regional_free = "null";
    String unidade = "null";

    if (f.getF_representante() != "") {
      representante_free.append(f.getF_representante());
    } else {
      representante_free.append("null");
    }

    if (f.getCodigo_marca() != "") {
      marca = " and mp.codigo_marca = "+f.getCodigo_marca();
    }

    if (f.getF_regional() != "") {
      regional_free = f.getF_regional();
    }

    if (f.getRep_cdgo() != "" && (!((f.getRep_cdgo() + "").equals("null")))) {
      representante = " and t.codigo_representante in ("+f.getRep_cdgo() + ")";
    }

    if (f.getReps() != "" && (!((f.getRep_cdgo() + "").equals("null")))) {
      representante = " and t.codigo_representante in ("+f.getReps() + ")";
    }

    if (f.getCodigo_regional() != "") {
      regional = f.getCodigo_regional();
    }
    //-----------------------------------------------------------------------------
    session.setAttribute("poi_situacao_gerente", f.getSituacao_gerente());

    portalbr.dbobj.view.Jw_poi_aberto table = new portalbr.dbobj.view.Jw_poi_aberto();

    StringBuilder query = new StringBuilder();
    query.append(" SELECT t.codigo_marca||'-'||mp.descricao_marca desc_marca ");
    query.append("      , r.codigo_regional ");
    query.append("      , r.nome_regional ");
    query.append("      , gr.codigo_gerente ");
    query.append("      , gr.nome_gerente ");
    query.append("      , gr.endereco_gerente||', '||gr.numero_gerente endereco ");
    query.append("      , gr.estado_gerente ");
    query.append("      , '' unidade_negocio ");
    query.append("      , '' unn_descri ");
    query.append("   FROM cotas_linhas_reais        t ");
    query.append("      , regionais_vendas          r ");
    query.append("      , gerentes_regionais_vendas gr ");
    query.append("      , uni_negocio               u ");
    query.append("      , marcas_produtos           mp ");
    query.append("  WHERE t.codigo_linha           = 999 ");
    query.append("    AND t.emp_empresa            = '01' ");
    query.append("    AND t.codigo_gerente         = nvl(null,t.codigo_gerente) ");
    query.append("    AND r.codigo_regional        = nvl(").append(regional).append(",r.codigo_regional) ");
    query.append("    AND r.codigo_regional        = nvl(").append(regional_free).append(",r.codigo_regional) ");
    query.append("    AND t.codigo_representante   = nvl(").append(representante_free.toString()).append(",t.codigo_representante) ");
    query.append("    AND ( ");
    query.append("          (t.mes_venda_reais  >= ").append(f.getMes()).append(" and t.ano_venda_reais >= ").append(f.getAno()).append(") ");
    query.append("          AND ");
    query.append("          (t.mes_venda_reais  <= ").append(f.getMes_final()).append(" and t.ano_venda_reais <= ").append(f.getAno_final()).append(") ");
    query.append("        ) ");
    query.append("    AND t.unidade_negocio        = nvl(").append(unidade).append(",t.unidade_negocio) ");
    query.append("    AND gr.codigo_regional       = r.codigo_regional ");
    query.append("    AND gr.codigo_gerente        = t.codigo_gerente ");
    query.append("    AND u.unn_codigo             = t.unidade_negocio ");
    query.append(f.getSituacao_gerente().equals("T") ? "" : (new StringBuilder()).append(" and  gr.situacao_gerente = '").append(f.getSituacao_gerente()).append("'").toString());
    query.append("    AND t.codigo_marca           = mp.codigo_marca ");
    query.append(representante);
    query.append(marca);
    query.append("  GROUP BY t.codigo_gerente ");
    query.append("         , '' ");
    query.append("         , r.codigo_regional ");
    query.append("         , r.nome_regional ");
    query.append("         , gr.codigo_gerente ");
    query.append("         , gr.nome_gerente ");
    query.append("         , gr.endereco_gerente ");
    query.append("         , gr.numero_gerente ");
    query.append("         , r.ender_regional ");
    query.append("         , gr.estado_gerente ");
    query.append("         , '' ");
    query.append("         , t.codigo_marca ");
    query.append("         , mp.descricao_marca ");
    query.append("  ORDER BY t.codigo_gerente ");
    query.append("         , t.codigo_marca ");
    query.append("         , r.codigo_regional");

    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");


    Vector res_Jw_poi_aberto = j.select(table, query.toString(), null);

    session.setAttribute("res_Jw_poi",res_Jw_poi_aberto);
    if (!(res_Jw_poi_aberto != null && res_Jw_poi_aberto.size() > 0)) {
      throw new Exception("Nenhum registro encontrado!");
    }

    //-----------------------------------------------------------------------------
    portalbr.dbobj.view.Jw_poi_aberto_representante table_rep = new portalbr.dbobj.view.Jw_poi_aberto_representante();
    StringBuilder query2 = new StringBuilder();
    query2.append(" SELECT rep.rep_cdgo ");
    query2.append("      , rep.rep_rzao ");
    query2.append("      , t.codigo_marca||'-'||mp.descricao_marca desc_marca ");
    query2.append("      , r.codigo_regional ");
    query2.append("      , r.nome_regional ");
    query2.append("      , gr.codigo_gerente ");
    query2.append("      , gr.nome_gerente ");
    query2.append("      , gr.endereco_gerente||', '||gr.numero_gerente endereco ");
    query2.append("      , gr.estado_gerente ");
    query2.append("   FROM cotas_linhas_reais t ");
    query2.append("      , regionais_vendas r ");
    query2.append("      , gerentes_regionais_vendas gr ");
    query2.append("      , uni_negocio u ");
    query2.append("      , marcas_produtos mp ");
    query2.append("      , rep ");
    query2.append("  WHERE t.codigo_linha           = 999 ");
    query2.append("    AND t.emp_empresa            = '01' ");
    query2.append("    AND t.codigo_gerente         = nvl(null,t.codigo_gerente) ");
    query2.append("    AND r.codigo_regional        = nvl(").append(regional).append(",r.codigo_regional) ");
    query2.append(representante);
    query2.append(marca);
    query2.append("    AND r.codigo_regional        = nvl(").append(regional_free).append(",r.codigo_regional) ");
    query2.append("    AND t.codigo_representante   = nvl(").append(representante_free.toString()).append(",t.codigo_representante) ");
    query2.append("    AND ( ");
    query2.append("          (t.mes_venda_reais  >= ").append(f.getMes()).append(" and t.ano_venda_reais >= ").append(f.getAno()).append(") ");
    query2.append("          AND ");
    query2.append("          (t.mes_venda_reais  <= ").append(f.getMes_final()).append(" and t.ano_venda_reais <= ").append(f.getAno_final()).append(") ");
    query2.append("        ) ");
    query2.append("    AND t.unidade_negocio        = nvl(").append(unidade).append(",t.unidade_negocio) ");
    query2.append("    AND gr.codigo_regional       = r.codigo_regional ");
    query2.append("    AND gr.codigo_gerente        = t.codigo_gerente ");
    query2.append("    AND u.unn_codigo             = t.unidade_negocio ");
    query2.append(f.getSituacao_gerente().equals("T") ? "" : (new StringBuilder()).append(" and  gr.situacao_gerente = '").append(f.getSituacao_gerente()).append("'").toString());
    query2.append("    AND t.codigo_marca           = mp.codigo_marca ");
    query2.append("    AND t.codigo_representante   = rep.rep_cdgo ");
    query2.append("  GROUP BY rep.rep_cdgo ");
    query2.append("         , rep.rep_rzao ");
    query2.append("         , t.codigo_gerente ");
    query2.append("         , r.codigo_regional ");
    query2.append("         , r.nome_regional ");
    query2.append("         , gr.codigo_gerente ");
    query2.append("         , gr.nome_gerente ");
    query2.append("         , gr.endereco_gerente ");
    query2.append("         , gr.numero_gerente ");
    query2.append("         , r.ender_regional ");
    query2.append("         , gr.estado_gerente ");
    query2.append("         , t.codigo_marca ");
    query2.append("         , mp.descricao_marca ");
    query2.append("  ORDER BY r.codigo_regional ");
    query2.append("         , t.codigo_gerente ");
    query2.append("         , rep.rep_cdgo ");
    query2.append("         , t.codigo_marca ");

    if (usuario.mostraQuery()) {
      throw new Exception(query2.toString());
    }

    Vector res_Jw_poi_aberto_representante = j.select(table_rep, query2.toString(), null);

    session.setAttribute("res_Jw_poi_aberto_representante",res_Jw_poi_aberto_representante);
    if (!(res_Jw_poi_aberto_representante != null && res_Jw_poi_aberto_representante.size() > 0)) {
      throw new Exception("Nenhum registro encontrado!");
    }

    //-----------------------------------------------------------------------------
    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      PoiAbertoRepresentanteActionForm f = (PoiAbertoRepresentanteActionForm) form;
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
