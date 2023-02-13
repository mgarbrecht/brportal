package portalbr.adm;

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
 * Creation Date 03/12/2008 04:57:31
 * Last Modify Date 07/01/2015 10:40:37
 */

public class PendenciasRegionaisAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      PendenciasRegionaisActionForm f = (PendenciasRegionaisActionForm) form;
      tg_select_action(mapping, form, request, response, j);
      select_action(j, mapping, form, request, response);
      if (f.getCb_clientes()) {
        actionForward = new ActionForward("/adm/PendenciasRegionais_rcForm.jsp",true);
      } else {
        actionForward = new ActionForward("/adm/PendenciasRegionais_rForm.jsp",true);
      }
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_pendencias_regionais", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    PendenciasRegionaisActionForm f = (PendenciasRegionaisActionForm) form;
    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    String[][] select = null;
    Object[][] where = { {"codigo_regional","=", com.egen.util.text.FormatNumber.toInt(f.getReg())}, {"rep_cdgo","=", f.getRep()}, {"rep_situ","like", f.getSituacao_rep()} };

    if (f.getCb_clientes()) {
      if (usuario.mostraQuery()) {
        throw new Exception("Query não disponível! javaview: Jw_pendencias_regionais_clientes");
      }
      Jw_pendencias_regionais_clientes table = new Jw_pendencias_regionais_clientes();
      Vector res_Jw_pendencias_regionais_clientes = j.select(table, select, where, null, null, null);
      session.setAttribute("res_Jw_pendencias_regionais_clientes",res_Jw_pendencias_regionais_clientes);
      if (!(res_Jw_pendencias_regionais_clientes != null && res_Jw_pendencias_regionais_clientes.size() > 0)) {
        throw new Exception("Nenhum registro encontrado!");
      }

    } else {
      if (usuario.mostraQuery()) {
        throw new Exception("Query não disponível! javaview: Jw_pendencias_regionais");
      }
      Jw_pendencias_regionais table = new Jw_pendencias_regionais();
      Vector res_Jw_pendencias_regionais = j.select(table, select, where, null, null, null);
      session.setAttribute("res_Jw_pendencias_regionais",res_Jw_pendencias_regionais);
      if (!(res_Jw_pendencias_regionais != null && res_Jw_pendencias_regionais.size() > 0)) {
        throw new Exception("Nenhum registro encontrado!");
      }
    }
    session.setAttribute("mapping.getName()", form);
  }
  private void tg_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, com.egen.util.jdbc.JdbcUtil j) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      PendenciasRegionaisActionForm f = (PendenciasRegionaisActionForm) form;
      String tipo = null;
      acesso.Usuario u = new acesso.Usuario();
      u = (acesso.Usuario) session.getAttribute("User");
      acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
      acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();
      if (!(u.getEntidadeNegocio() == null)) {
        ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
        tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
        tipo = tipoent.getTipo() + "";
        if (tipo.equals("REGIONAL DE VENDA")) {
          Rep table = new Rep();
          String[][] select = null;
          Object[][] where = { {"codigo_regional","=", com.egen.util.text.FormatNumber.toInt(f.getReg())}, {"rep_cdgo","=", com.egen.util.text.FormatNumber.toInt(f.getRep())} };
          Vector res_Rep = j.select(table, select, where, null, null, null);
          if (res_Rep != null && res_Rep.size() == 0) {
            throw new Exception("O representante não pertence à regional");
          }
        }
      }
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    } finally {
    }
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      PendenciasRegionaisActionForm f = (PendenciasRegionaisActionForm) form;
      session.removeAttribute("res_Jw_pendencias_regionais");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_pendencias_regionais", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
