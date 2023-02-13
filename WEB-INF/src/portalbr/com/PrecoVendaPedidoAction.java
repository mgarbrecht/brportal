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
 * Creation Date 19/09/2016 17:24:12
 * Last Modify Date 21/09/2016 13:04:34
 */

public class PrecoVendaPedidoAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      PrecoVendaPedidoActionForm f = (PrecoVendaPedidoActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      //    actionForward = mapping.findForward("same");
      actionForward = new ActionForward("/com/PrecoVendaPedido_rGrid.do?select_action=", true);
    }
    catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_preco_venda_pedido", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    PrecoVendaPedidoActionForm f = (PrecoVendaPedidoActionForm) form;


    if ((!(f.getCli_cdgo() != "")) && (!(f.getPedidos() != "")) && (!(f.getPed_daem_inicial() != "")) && (!(f.getPed_daem_final() != "")) && (!(f.getPed_ped_cliente() != ""))) {
      throw new Exception("Um dos campos com <img src='../img/opcional.gif' border='0'/> deve ser informado!");
    }



    String pedidos = "";
    if (f.getPedidos() != "") {
      pedidos = f.getPedidos().replaceAll("\\r\\n|\\r|\\n", ",");
      if ((pedidos.charAt(pedidos.length() - 1) + "").equalsIgnoreCase(",")) {
        pedidos = pedidos.substring(0, pedidos.lastIndexOf(","));
      }
    }

    Jw_preco_venda_pedido table = new Jw_preco_venda_pedido();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"cli_cdgo","=", com.egen.util.text.FormatNumber.toInteger(f.getCli_cdgo())}, {"esc_seqn","=", com.egen.util.text.FormatNumber.toInt(f.getEsc_seqn())}, {"cli_rzao","like", f.getCli_rzao()}, {"ped_nmro","in", pedidos}, {"ped_ped_cliente","like", f.getPed_ped_cliente()}, {"rep_cdgo","like", f.getRep_cdgo()}, {"codigo_regional","=", com.egen.util.text.FormatNumber.toInteger(f.getCodigo_regional())}, {"ped_daem",">=", com.egen.util.text.FormatDate.parseTimestamp(f.getPed_daem_inicial(), "dd/MM/yyyy")}, {"ped_daem","<=", com.egen.util.text.FormatDate.parseTimestamp(f.getPed_daem_final(), "dd/MM/yyyy")} };

    session.setAttribute("where", where);
    //Vector res_Jw_preco_venda_pedido = j.select(table, select, where, groupby, having, order);

    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");

    if (usuario.mostraQuery()) {
      //     throw new Exception(sb.toString());
    }

    /*  session.setAttribute("res_Jw_preco_venda_pedido",res_Jw_preco_venda_pedido);
          if (res_Jw_preco_venda_pedido != null && res_Jw_preco_venda_pedido.size() > 0) {
            Jw_preco_venda_pedido r = (Jw_preco_venda_pedido) res_Jw_preco_venda_pedido.elementAt(0);
            f.setCli_cdgo((r.getCli_cdgo() != null) ? r.getCli_cdgo() + "":"");
            f.setEsc_seqn(r.getEsc_seqn() + "");
            f.setCli_rzao((r.getCli_rzao() != null) ? r.getCli_rzao() + "":"");
            f.setPed_ped_cliente((r.getPed_ped_cliente() != null) ? r.getPed_ped_cliente() + "":"");
            f.setRep_cdgo((r.getRep_cdgo() != null) ? r.getRep_cdgo() + "":"");
            f.setCodigo_regional((r.getCodigo_regional() != null) ? r.getCodigo_regional() + "":"");
          } else {
            ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
            if (errors == null) {
              errors = new ActionErrors();
            }
            errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_preco_venda_pedido", new ActionMessage("warn.norowsselected",""));
            request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
          }
        */
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      PrecoVendaPedidoActionForm f = (PrecoVendaPedidoActionForm) form;
      session.removeAttribute("res_Jw_preco_venda_pedido");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_preco_venda_pedido", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
