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
 * Creation Date 09/03/2006 17:21:27
 * Last Modify Date 10/12/2009 17:32:25
 */

public class PedidosSituacoesAction extends com.egen.util.struts.AbstractAction {

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
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_situacoes_pedido", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    PedidosSituacoesActionForm f = (PedidosSituacoesActionForm) form;
    portalbr.dbobj.view.Jw_situacoes_pedido table = new portalbr.dbobj.view.Jw_situacoes_pedido();
    StringBuilder query = new StringBuilder();
    query.append(" SELECT to_char(a.dt_cad_situacao,'dd/mm/yyyy') dt ");
    query.append("      , to_char(a.dt_cad_situacao,'hh24:mi') hora ");
    query.append("      , a.usuario_situacao nome ");
    query.append("      , c.descricao_situacao descricao ");
    query.append("      , a.observ_situacao obs_sit");
    query.append("      , a.observ_liberacao obs_lib ");
    query.append("   FROM situacoes_pedidos  a ");
    query.append("      , dom_usuario        b ");
    query.append("      , tipos_situacoes    c ");
    query.append("  WHERE a.ts_codigo_situacao =  c.codigo_situacao ");
    query.append("    AND a.usuario_situacao   =  b.cod_usuario(+) ");
    query.append("    AND a.ped_nmro           =  ").append(f.getPedido_beira_rio());
    query.append("    AND a.ped_nmro           >  0 ");
    query.append("  ORDER BY a.dt_cad_situacao ");

    Vector res_Jw_situacoes_pedido = j.select(table, query.toString(), null);
    session.setAttribute("res_Jw_situacoes_pedido",res_Jw_situacoes_pedido);
    if (!(res_Jw_situacoes_pedido != null && res_Jw_situacoes_pedido.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_situacoes_pedido", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute("mapping.getName()", form);
  }

}
