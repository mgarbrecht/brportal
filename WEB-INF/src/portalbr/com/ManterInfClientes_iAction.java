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
 * Creation Date 14/12/2011 10:40:13
 * Last Modify Date 15/12/2011 09:52:11
 */

public class ManterInfClientes_iAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ManterInfClientes_iActionForm f = (ManterInfClientes_iActionForm) form;
      try {
        insert_action(j, mapping, form, request, response);
        tg_insert_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Cli_inf_adicionais", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void insert_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    ManterInfClientes_iActionForm f = (ManterInfClientes_iActionForm) form;

    if (f.getCli_cdgo().equals("") && f.getGre_grupo().equals("")) {
      throw new Exception("Cliente ou Grupo deve ser informado!");
    }

    Cli_inf_adicionais table = new Cli_inf_adicionais();
    java.sql.PreparedStatement pstm = null;
    java.sql.ResultSet rset = null;
    StringBuilder query = new StringBuilder();

    // --- Se for cadastro único (cliente + sequencial) -------
    if (f.getCli_cdgo() != "" && f.getEsc_seqn() != "") {
      Object[][] name_value = { {"cli_cdgo",com.egen.util.text.FormatNumber.toInteger(f.getCli_cdgo())}, {"esc_seqn",com.egen.util.text.FormatNumber.toInteger(f.getEsc_seqn())}, {"somente_etiqueta",f.getSomente_etiqueta()} };
      j.insert(table, name_value);
      Vector res_Cli_inf_adicionais = (Vector) session.getAttribute("res_Cli_inf_adicionais");
      if (res_Cli_inf_adicionais != null && table != null) {
        res_Cli_inf_adicionais.addElement(table);
        session.setAttribute("res_Cli_inf_adicionais", res_Cli_inf_adicionais);
      }
    } else {
      // --------------------------------------------------------

      if (f.getCli_cdgo() != "" && f.getGre_grupo() != "") {
        throw new Exception("Cliente ou Grupo deve ser informado!");
      }

      query.append(" SELECT c.cli_cdgo ");
      query.append("      , e.esc_seqn ");
      query.append("   FROM (SELECT * FROM grupo_economico WHERE status = 'A') ge ");
      query.append("      , esc e ");
      query.append("      , cli c ");
      query.append("  WHERE c.cli_cdgo     = e.cli_cdgo ");
      query.append("    AND e.cli_cdgo     = ge.cli_cdgo (+) ");
      if (f.getGre_grupo() != "") {
        query.append(" AND ge.gre_grupo   = " + f.getGre_grupo());
      }
      if (f.getCli_cdgo() != "") {
        query.append(" AND c.cli_cdgo     = " + f.getCli_cdgo());
      }
      query.append("    AND e.esc_situacao = 'A' ");
      query.append("    AND c.cli_situ     = 'A' ");
      query.append("    AND NOT EXISTS (SELECT 1 ");
      query.append("                      FROM cli_inf_adicionais cia ");
      query.append("                     WHERE cia.cli_cdgo = ge.cli_cdgo ");
      query.append("                       AND cia.esc_seqn = e.esc_seqn) ");

      try {
        pstm = j.getConn().prepareStatement(query.toString());
        rset = pstm.executeQuery();
        while (rset.next()) {
          Object[][] name_value = { {"cli_cdgo",com.egen.util.text.FormatNumber.toInteger(rset.getString("cli_cdgo"))}, {"esc_seqn",com.egen.util.text.FormatNumber.toInteger(rset.getString("esc_seqn"))}, {"somente_etiqueta",f.getSomente_etiqueta()} };
          j.insert(table, name_value);
        }
      }
      finally {
        if (rset != null) {
          rset.close();
        }
        if (pstm != null) {
          pstm.close();
        }
      }

    }



    form.reset(mapping, request);
    session.setAttribute(mapping.getName(), form);
  }
  private void tg_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Cli_inf_adicionais", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ManterInfClientes_iActionForm f = (ManterInfClientes_iActionForm) form;
      session.removeAttribute("res_Cli_inf_adicionais");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Cli_inf_adicionais", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ManterInfClientes_iActionForm f = (ManterInfClientes_iActionForm) form;


      actionForward = new ActionForward("/com/ManterInfClientesForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Cli_inf_adicionais", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
