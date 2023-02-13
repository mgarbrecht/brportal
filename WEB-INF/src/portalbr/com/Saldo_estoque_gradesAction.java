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
 * Creation Date 23/02/2006 14:44:49
 * Last Modify Date 03/12/2020 12:04:30
 */

public class Saldo_estoque_gradesAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //-------------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 23/02/2006
    // Objetivo          : Executa um consulta na java view:
    //                     portalbr.dbobj.view.Jw_saldo_estoque_cores
    //-------------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_saldo_estoque_cores", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    Saldo_estoque_gradesActionForm f = (Saldo_estoque_gradesActionForm) form;
    util.consultas.Query queryUtil = new util.consultas.Query();
    String ignorarGrade99 = "N";
    portalbr.dbobj.view.Jw_saldo_estoque_cores table = new portalbr.dbobj.view.Jw_saldo_estoque_cores();
    String tiposEstoque = (String) session.getAttribute("codigos_estoque") == null ? (queryUtil.retorna("select rowtocol('SELECT codigo FROM dom_tipo_estoque WHERE codigo IN (SELECT to_number(valor) FROM wbrio.parametros WHERE par_sist_codigo = ''BRNET'' AND nome = ''saldo_estoque_grade_tipo_estoque'')') from dual")) : (String) session.getAttribute("codigos_estoque");
    if (tiposEstoque.equals("")) {
      throw new Exception("Um tipo de estoque deve ser selecionado!");
    }
    if ((f.getCb_ignorar_grade_99() + "").equals("1")) {
      ignorarGrade99 = "S";
    } else {
      ignorarGrade99 = "N";
    }


    StringBuilder query = new StringBuilder();

    query.append(" SELECT /*+ all_rows */ ");
    query.append("        DISTINCT ");
    query.append("        i.cab_cdgo ");
    query.append("      , ca.cab_desc ");
    query.append("      , i.ref_cdgo ");
    query.append("      , l.cor_cdgo ");
    query.append("      , c.cor_desc ");
    query.append("      , i.lin_cdgo ");
    query.append("   FROM dom_local_item_estoque_gre l ");
    query.append("      , dom_item_estoque           i ");
    query.append("      , cor                        c ");
    query.append("      , cabedal                    ca ");
    query.append("  WHERE l.ies_codigo               = i.codigo ");
    query.append("    AND c.cor_cdgo                 = l.cor_cdgo ");
    query.append("    AND ca.cab_cdgo                = i.cab_cdgo ");
    query.append("    AND i.lin_cdgo                 = ").append(f.getLin_cdgo());
    query.append("    AND i.ref_cdgo                 = nvl(").append((f.getRef_cdgo().equals("") ? "null":f.getRef_cdgo() + "")).append(", i.ref_cdgo) ");
    query.append("    AND i.cab_cdgo                 = nvl(").append((f.getCab_cdgo().equals("") ? "null":f.getCab_cdgo() + "")).append(", i.cab_cdgo) ");
    query.append("    AND l.tco_codigo               = nvl(").append(f.getComp()).append(", l.tco_codigo) ");
    query.append("    AND l.tes_codigo               in ("+tiposEstoque + ") ");
    query.append("    AND nvl(i.tipo, null)          = 'A' ");
    query.append("    AND (NVL('").append(f.getMix()).append("', 'T') = 'T' OR fct_mix_produto(i.lin_cdgo, i.ref_cdgo) = '").append(f.getMix()).append("') ");
    query.append("    AND l.qtde_atual               > 0 ");
    if (ignorarGrade99.equals("S")) {
      query.append("    AND l.gde_cdgo <> 99 ");
    }
    Vector res_Jw_saldo_estoque_cores = j.select(table, query.toString(), null);

    session.setAttribute("attr_mix",f.getMix());
    session.setAttribute("attr_ignorar_grade_99", ignorarGrade99);
    session.setAttribute("res_Jw_saldo_estoque_cores",res_Jw_saldo_estoque_cores);
    if (!(res_Jw_saldo_estoque_cores != null && res_Jw_saldo_estoque_cores.size() > 0)) {
      throw new Exception("Produto não possui Estoque!");
    }
    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      Saldo_estoque_gradesActionForm f = (Saldo_estoque_gradesActionForm) form;
      session.removeAttribute("res_Jw_saldo_estoque_cores");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      tg_resetfull_action(mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_saldo_estoque_cores", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
  private void tg_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      Saldo_estoque_gradesActionForm f = (Saldo_estoque_gradesActionForm) form;
      com.egen.util.jdbc.JdbcUtil j = null;
      java.util.Vector v = new java.util.Vector();
      try {
        j = new com.egen.util.jdbc.JdbcUtil();
        Jw_saldo_estoque_grade_tipo_estoque table = new Jw_saldo_estoque_grade_tipo_estoque();
        String[][] select = null;
        Object[][] where = null;
        Vector res_Jw_saldo_estoque_grade_tipo_estoque = j.select(table, select, where, null, null, null);
        session.setAttribute("res_Jw_saldo_estoque_grade_tipo_estoque",res_Jw_saldo_estoque_grade_tipo_estoque);
        if (res_Jw_saldo_estoque_grade_tipo_estoque != null && res_Jw_saldo_estoque_grade_tipo_estoque.size() > 0) {
          int contador = 0;
          while (contador < res_Jw_saldo_estoque_grade_tipo_estoque.size()) {
            Jw_saldo_estoque_grade_tipo_estoque r = (Jw_saldo_estoque_grade_tipo_estoque) res_Jw_saldo_estoque_grade_tipo_estoque.elementAt(contador);
            v.add(r.getCodigo() + "-"+r.getDescricao());
            contador++;
          }
        }
        session.setAttribute("tipos_estoque", v);
      }
      finally {
        if (j != null) {
          j.close();
          j = null;
        }
      }
      session.setAttribute("tipos_estoque", v);
      util.consultas.Query query = new util.consultas.Query();
      session.setAttribute("codigos_estoque", query.retorna("select rowtocol('SELECT codigo FROM dom_tipo_estoque WHERE codigo IN (SELECT to_number(valor) FROM wbrio.parametros WHERE par_sist_codigo = ''BRNET'' AND nome = ''saldo_estoque_grade_tipo_estoque'')') from dual"));
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    } finally {
    }
  }



  public ActionForward perform_refresh_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      Saldo_estoque_gradesActionForm f = (Saldo_estoque_gradesActionForm) form;
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_saldo_estoque_cores", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
