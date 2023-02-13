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
 * Creation Date 07/03/2006 15:03:23
 * Last Modify Date 22/06/2015 13:28:42
 */

public class ConsultaPedidosClientesAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //-------------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 11/05/2006
    // Objetivo          : Executa uma consulta na view portalbr.dbobj.view.Jw_consulta_pedidos,
    //                     redirecionando após a consulta para a tela de relatório com os pedidos
    //                     do cliente.
    //                     /com/ConsultaPedidos_pForm.jsp
    //-------------------------------------------------------------------------------------------
    // Data de Alteração :
    // Descrição         :
    //-------------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ConsultaPedidosClientesActionForm f = (ConsultaPedidosClientesActionForm) form;
      select_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/com/ConsultaPedidos_pForm.do?select_action=&cod="+f.getCli_cdgo() + "&situacao="+f.getSituacao() + "&dt_entrega="+f.getDt_entrega() + "&codigo="+f.getCodigo() + "&razao_social="+f.getRazao_social() + "&cid_uf="+f.getCid_uf() + "&cliente=s",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_pedidos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    String representante = "null";
    String regional = "null";
    ConsultaPedidosClientesActionForm f = (ConsultaPedidosClientesActionForm) form;
    portalbr.dbobj.view.Jw_consulta_pedidos table = new portalbr.dbobj.view.Jw_consulta_pedidos();
    StringBuilder query = new StringBuilder();
    if (f.getCli_cdgo() != "") {
      query.append(" SELECT DISTINCT ");
      query.append("        a.cli_cdgo || '-' || b.esc_seqn codigo ");
      query.append("      , cli_rzao razao_social ");
      query.append("      , ecl_cdad || ' - ' || c.est_unifed cid_uf ");
      query.append("      , c.est_unifed eunifed ");
      query.append("      , ecl_cdad ecidad ");
      query.append("      , b.esc_seqn seqn ");
      query.append("      , b.cli_cdgo cod ");
      query.append("   FROM brio.cli a ");
      query.append("      , brio.esc b ");
      query.append("      , brio.ecl c ");
      query.append("      , regionais_vendas rv ");
      query.append("      , cliente_representante cr ");
      query.append("      , rep r ");
      query.append("  WHERE b.esc_seqn = c.esc_seqn ");
      query.append("    AND a.cli_cdgo = b.cli_cdgo ");
      query.append("    AND b.cli_cdgo = c.cli_cdgo ");
      query.append("    AND a.cli_cdgo = cr.codigo_cliente ");
      query.append("    AND b.esc_seqn = cr.codigo_sequencial ");
      query.append("    AND r.rep_cdgo = cr.codigo_representante ");
      query.append("    AND rv.codigo_regional = r.codigo_regional");
      query.append("    AND (c.ned_cdgo = 'UNI' or  c.ned_cdgo = 'ENT') ");
      query.append("    AND a.cli_cdgo = ").append(f.getCli_cdgo());
      query.append("  ORDER BY cli_rzao ");

    }

    Vector res_Jw_consulta_pedidos = j.select(table, query.toString(), null);
    session.setAttribute("res_Jw_consulta_pedidos",res_Jw_consulta_pedidos);
    if (!(res_Jw_consulta_pedidos != null && res_Jw_consulta_pedidos.size() > 0)) {
      throw new Exception("Nenhum registro encontrado!");
    }
    //--------------------------------------------------------------------------------------
    portalbr.dbobj.view.Jw_consulta_pedidos t_jw_consulta_pedidos = new portalbr.dbobj.view.Jw_consulta_pedidos();
    t_jw_consulta_pedidos = (portalbr.dbobj.view.Jw_consulta_pedidos) res_Jw_consulta_pedidos.elementAt(0);
    String codigo = t_jw_consulta_pedidos.getCodigo() == null ? "":t_jw_consulta_pedidos.getCodigo();
    String razao_social = t_jw_consulta_pedidos.getRazao_social() == null ? "":t_jw_consulta_pedidos.getRazao_social();
    String cid_uf = t_jw_consulta_pedidos.getCid_uf() == null ? "":t_jw_consulta_pedidos.getCid_uf();
    f.setCodigo(codigo);
    f.setRazao_social(razao_social);
    f.setCid_uf(cid_uf);
    //--------------------------------------------------------------------------------------
    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ConsultaPedidosClientesActionForm f = (ConsultaPedidosClientesActionForm) form;
      session.removeAttribute("res_Jw_consulta_pedidos");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_pedidos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
