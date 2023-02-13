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
 * Creation Date 04/10/2012 12:08:13
 * Last Modify Date 01/03/2013 16:28:12
 */

public class FichaCliente_ifAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_execute_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      //  j = new com.egen.util.jdbc.JdbcUtil();
      FichaCliente_ifActionForm f = (FichaCliente_ifActionForm) form;
      util.consultas.com.FichaCliente ficha = null;
      if (session.getAttribute("cli_cdgo") != null) {
        ficha = new util.consultas.com.FichaCliente(request, "C", Integer.parseInt((String) session.getAttribute("cli_cdgo")));
      } else {
        ficha = new util.consultas.com.FichaCliente(request, "G", Integer.parseInt((String) session.getAttribute("gre_grupo")));
      }
      ficha.buscaInformacoesFinanceiras();

      f.setLimite(com.egen.util.text.FormatNumber.format(ficha.getLimite(), "##,##0.00"));
      f.setSaldo(com.egen.util.text.FormatNumber.format(ficha.getSaldo(), "##,##0.00"));
      f.setParesPedLiberados(com.egen.util.text.FormatNumber.format(ficha.getParesPedLiberados(), "##,##0"));
      f.setValorPedLiberados(com.egen.util.text.FormatNumber.format(ficha.getValorPedLiberados(), "##,##0.00"));
      f.setParesPedNaoLiberados(com.egen.util.text.FormatNumber.format(ficha.getParesPedNaoLiberados(), "##,##0"));
      f.setValorPedNaoLiberados(com.egen.util.text.FormatNumber.format(ficha.getValorPedNaoLiberados(), "##,##0.00"));

      f.setDiasVencido(com.egen.util.text.FormatNumber.format(ficha.getDiasVencido(), "##,##0"));
      f.setValorVencido(com.egen.util.text.FormatNumber.format(ficha.getValorVencido(), "##,##0.00"));

      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Fc_vendas_linha_regional_vw", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
