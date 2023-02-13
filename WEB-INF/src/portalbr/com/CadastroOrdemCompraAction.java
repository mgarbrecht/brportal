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
 * Creation Date 02/04/2012 13:09:11
 * Last Modify Date 24/08/2018 14:37:27
 */

public class CadastroOrdemCompraAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      CadastroOrdemCompraActionForm f = (CadastroOrdemCompraActionForm) form;
      select_action(j, mapping, form, request, response);

      actionForward = new ActionForward("/com/CadastroOrdemCompra_rGrid.do?select_action=", true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    CadastroOrdemCompraActionForm f = (CadastroOrdemCompraActionForm) form;
    Jw_pedidos_ordem_compra table = new Jw_pedidos_ordem_compra();
    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    StringBuilder parametros = new StringBuilder();
    if (f.getCliente() != "") {
      parametros.append(" AND ped.cli_cdgo = " + f.getCliente());
    }
    if (f.getSequencial() != "") {
      parametros.append(" AND ped.esc_seqn = " + f.getSequencial());
    }
    if (f.getGrupo_economico() != "") {
      parametros.append(" AND pck_cliente.get_grupo_economico(ped.cli_cdgo) = " + f.getGrupo_economico());
    }
    if (f.getRep_cdgo() != "") {
      parametros.append(" AND ped.rep_cdgo = '"+f.getRep_cdgo() + "' ");
    }
    if (f.getPedido() != "") {
      String pedidos = f.getPedido().replaceAll("[^0-9]", " ").trim();
      pedidos = pedidos.replaceAll("\\s+", " ");
      pedidos = pedidos.replaceAll(" ", "\n");
      pedidos = pedidos.replaceAll("\\r\\n|\\r|\\n", ",");
      if ((pedidos.charAt(pedidos.length() - 1) + "").equalsIgnoreCase(",")) {
        pedidos = pedidos.substring(0, pedidos.lastIndexOf(","));
      }
      parametros.append(" AND ped.ped_nmro in ("+pedidos + ") ");
    }

    if (f.getLin_cdgo() != "") {
      parametros.append(" AND EXISTS (SELECT 1 FROM ite i WHERE i.ped_nmro = ped.ped_nmro AND i.lin_cdgo = "+f.getLin_cdgo() + ") ");
    }

    StringBuilder sb = new StringBuilder();
    sb.append(" SELECT ped.ped_nmro numero ");
    sb.append("      , ped.cli_cdgo cliente ");
    sb.append("      , ped.esc_seqn sequencial ");
    sb.append("      , pck_cliente.get_grupo_economico(ped.cli_cdgo) grupo ");
    sb.append("      , ped.ped_ped_cliente oc ");
    sb.append("      , pck_cliente.get_nome(ped.cli_cdgo) cli_rzao ");
    sb.append("     , pck_grupo_economico.get_nome(pck_cliente.get_grupo_economico(ped.cli_cdgo)) nome_grupo ");
    sb.append("     , ped.rep_cdgo ");
    sb.append("      , pck_representante.get_regional(ped.rep_cdgo) regional ");
    sb.append("   FROM ped ");
    sb.append("  WHERE ped.ped_stat NOT IN ('C', 'F') ");
    sb.append(parametros.toString());

    if (usuario.mostraQuery()) {
      throw new Exception(sb.toString());
    }

    j.setMaxRows(1);
    Vector res_Jw_pedidos_ordem_compra = j.select(table, sb.toString(), null);
    if (res_Jw_pedidos_ordem_compra != null && res_Jw_pedidos_ordem_compra.size() == 0) {
      throw new Exception("Nenhum registro encontrado!");
    }
    session.setAttribute("where", sb.toString());
    session.setAttribute("oc", f.getOrdem_compra());
    session.setAttribute(mapping.getName(), form);
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      CadastroOrdemCompraActionForm f = (CadastroOrdemCompraActionForm) form;
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
