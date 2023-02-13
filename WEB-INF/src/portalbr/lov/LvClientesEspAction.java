package portalbr.lov;

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
 * Creation Date 10/11/2006 16:23:23
 * Last Modify Date 04/04/2013 08:12:56
 */

public class LvClientesEspAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Cliesp_clientes", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    LvClientesEspActionForm f = (LvClientesEspActionForm) form;
    //-----------------------------------------------------------
    String tipo = "";
    StringBuilder parametros = new StringBuilder();
    String codigo_regional = "";
    String codigo_representante = "";
    acesso.Usuario u = new acesso.Usuario();
    u = (acesso.Usuario) session.getAttribute("User");
    acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
    acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();

    if (!(u.getEntidadeNegocio() == null)) {
      ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
      tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
      tipo = tipoent.getTipo() + "";
      if (tipo.equals("REGIONAL DE VENDA")) {
        parametros.append(" and c.codigo_regional = ").append(ent.getChave());
      }
      if ((tipo.equals("REPRESENTANTE COMERCIAL")) || (tipo.equals("REPRESENTANTE EXPORTACAO"))) {
        parametros.append(" and cr.codigo_representante = '").append(ent.getChave()).append("' and cr.situacao='A' ");
      }
    }

    //-----------------------------------------------------------
    if (f.getCodigo() != "") {
      parametros.append(" and codigo = ").append(f.getCodigo());
    }
    if (f.getCliente() != "") {
      parametros.append(" and upper(cliente) like ('").append(f.getCliente().toUpperCase()).append("') ");
    }

    if (f.getRep_cdgo() != "") {
      parametros.append(" and cr.codigo_representante = '").append(f.getRep_cdgo()).append("'");
    } else {

      if (f.getCodigo_regional() != "") {
        parametros.append(" and c.codigo_regional = ").append(f.getCodigo_regional());
      }
    }

    portalbr.dbobj.table.Cliesp_clientes table = new portalbr.dbobj.table.Cliesp_clientes();
    StringBuilder query = new StringBuilder();
    query.append(" select distinct ");
    query.append("        codigo ");
    query.append("      , cliente ");
    query.append("      , tipo_cliente ");
    query.append("      , c.codigo_regional ");
    query.append("   from cliesp_clientes c ");
    query.append("      , cliente_representante cr ");
    query.append("  where c.codigo = cr.codigo_cliente (+) ");
    query.append(parametros.toString());
    query.append("  order by cliente ");

    Vector res_Cliesp_clientes = j.select(table, query.toString(), null);


    session.setAttribute("res_Cliesp_clientes",res_Cliesp_clientes);
    if (res_Cliesp_clientes == null || res_Cliesp_clientes.size() == 0) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Cliesp_clientes", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      LvClientesEspActionForm f = (LvClientesEspActionForm) form;
      session.removeAttribute("res_Cliesp_clientes");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Cliesp_clientes", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
