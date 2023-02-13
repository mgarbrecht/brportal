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
 * Creation Date 18/11/2013 10:25:28
 * Last Modify Date 08/01/2015 08:30:59
 */

public class MunicipiosPrazos_aAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      MunicipiosPrazos_aActionForm f = (MunicipiosPrazos_aActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = new ActionForward("/com/MunicipiosPrazos_raForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_prazos_municipios", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return actionForward;
  }
  private void select_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    MunicipiosPrazos_aActionForm f = (MunicipiosPrazos_aActionForm) form;
    Jw_prazos_municipios table = new Jw_prazos_municipios();
    String codigoMunicipios = null;
    util.consultas.Query query = new util.consultas.Query();
    if (f.getCep_inicial() != "" || f.getCep_final() != "") {
      if (f.getCep_inicial().equals("")) {
        f.setCep_inicial(f.getCep_final());
      }
      if (f.getCep_final().equals("")) {
        f.setCep_final(f.getCep_inicial());
      }
      codigoMunicipios = query.retorna(j, "SELECT rowtocol('SELECT distinct m.codigo FROM ecl l, municipios m WHERE to_number(l.ecl_cep) BETWEEN "+f.getCep_inicial() + " AND "+f.getCep_final() + " AND m.descricao = l.ecl_cdad') FROM dual ");

    }
    if (f.getCodigo() != "") {
      codigoMunicipios = f.getCodigo();
    }

    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"est_unifed","like", f.getEst_unifed()}, {"codigo","in", codigoMunicipios}, {"descricao","like", f.getDescricao().toUpperCase()}, {"distrito","like", f.getDistrito().toUpperCase()}, {"codigo_ibge","like", f.getCodigo_ibge()} };
    Vector res_Jw_prazos_municipios = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Jw_prazos_municipios",res_Jw_prazos_municipios);
    if (!(res_Jw_prazos_municipios != null && res_Jw_prazos_municipios.size() > 0)) {
      throw new Exception("Nenhum registro encontrado.");
    }
    session.setAttribute("mapping.getName()", form);
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      MunicipiosPrazos_aActionForm f = (MunicipiosPrazos_aActionForm) form;
      session.removeAttribute("res_Jw_prazos_municipios");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_prazos_municipios", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_cadastrar_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      MunicipiosPrazos_aActionForm f = (MunicipiosPrazos_aActionForm) form;


      actionForward = new ActionForward("/com/MunicipiosPrazos_acForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_prazos_municipios", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return actionForward;
  }
}
