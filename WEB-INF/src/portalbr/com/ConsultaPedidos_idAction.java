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
 * Creation Date 21/09/2011 15:06:21
 * Last Modify Date 12/01/2016 10:43:13
 */

public class ConsultaPedidos_idAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ConsultaPedidos_idActionForm f = (ConsultaPedidos_idActionForm) form;
      select_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_pedidos_detalhes_peso_corrugados", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    ConsultaPedidos_idActionForm f = (ConsultaPedidos_idActionForm) form;
    {
      Jw_consulta_pedidos_detalhes_peso_corrugados table = new Jw_consulta_pedidos_detalhes_peso_corrugados();
      String[][] select = null;
      Object[][] where = { {"codigo","=", com.egen.util.text.FormatNumber.toInteger(f.getCodigo_corrugado())}, {"lin_cdgo","=", com.egen.util.text.FormatNumber.toInteger(f.getLin_cdgo())}, {"ref_cdgo","=", com.egen.util.text.FormatNumber.toInteger(f.getRef_cdgo())} };
      Vector res_Jw_consulta_pedidos_detalhes_peso_corrugados = j.select(table, select, where, null, null, null);
      session.setAttribute("res_Jw_consulta_pedidos_detalhes_peso_corrugados",res_Jw_consulta_pedidos_detalhes_peso_corrugados);
    }
    //--------------------------------------------------------
    { Jw_consulta_pedidos_detalhes_peso_numeros table = new Jw_consulta_pedidos_detalhes_peso_numeros();
        String[][] select = null;
        Object[][] where = { {"codigo_embalagem","=", com.egen.util.text.FormatNumber.toInteger(f.getCodigo_embalagem())}, {"lin_cdgo","=", com.egen.util.text.FormatNumber.toInteger(f.getLin_cdgo())}, {"ref_cdgo","=", com.egen.util.text.FormatNumber.toInteger(f.getRef_cdgo())} };
        Vector res_Jw_consulta_pedidos_detalhes_peso_numeros = j.select(table, select, where, null, null, null);
        session.setAttribute("res_Jw_consulta_pedidos_detalhes_peso_numeros",res_Jw_consulta_pedidos_detalhes_peso_numeros);
    } //--------------------------------------------------------
    { Jw_consulta_pedidos_detalhes_item_estoque table = new Jw_consulta_pedidos_detalhes_item_estoque();
        String[][] select = null;
        Object[][] where = { {"codigo_embalagem","=", com.egen.util.text.FormatNumber.toInteger(f.getCodigo_embalagem())}, {"lin_cdgo","=", com.egen.util.text.FormatNumber.toInteger(f.getLin_cdgo())}, {"ref_cdgo","=", com.egen.util.text.FormatNumber.toInteger(f.getRef_cdgo())} };
        Vector res_Jw_consulta_pedidos_detalhes_item_estoque = j.select(table, select, where, null, null, null);
        session.setAttribute("res_Jw_consulta_pedidos_detalhes_item_estoque",res_Jw_consulta_pedidos_detalhes_item_estoque);
    } //--------------------------------------------------------
    session.setAttribute(mapping.getName(), form);
  }

}
