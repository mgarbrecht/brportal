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
 * Creation Date 12/05/2006 14:39:23
 * Last Modify Date 14/02/2018 09:48:43
 */

public class Sbr061Action extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      Sbr061ActionForm f = (Sbr061ActionForm) form;
      acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
      if (usuario.mostraQuery()) {
        throw new Exception("Query não disponível! Relatório utilizado: sbr061.rdf");
      }
      //--------------------------------------------------------------------------
      util.file.GeraPDF g = new util.file.GeraPDF(request);
      g.setRelatorio("sbr061.rdf");
      g.setParametro("P_TIPO_MERCADO", f.getPf_tipo_mercado());
      g.setParametro("P_QTD_LINHAS", f.getPf_qtd_linhas());
      g.setParametro("P_PED_DADG_INI", f.getPf_ped_dadg_ini());
      g.setParametro("P_PED_DADG_FIM", f.getPf_ped_dadg_fim());
      g.setParametro("P_MARCA_INI", f.getPf_marca_ini());
      g.setParametro("P_MARCA_FIM", f.getPf_marca_fim());
      g.setParametro("UNID_NEGOCIO", f.getPf_1()); // Unidade de Negócio
      g.setParametro("P_ATIVO", f.getPf_2()); // Somente linhas MIX
      if (f.getReg().equals("")) {
        if (f.getRep().equals("")) {
          g.setParametro("P_REGIONAL", f.getRegional());
        } else {
          //-----------------------------------------------------------------------------------
          com.egen.util.jdbc.JdbcUtil j = null;
          try {
            j = new com.egen.util.jdbc.JdbcUtil();
            portalbr.dbobj.view.Jw_reg_rep_cli table = new portalbr.dbobj.view.Jw_reg_rep_cli();
            StringBuilder query = new StringBuilder();
            query.append(" SELECT rv.codigo_regional ");
            query.append("      , r.rep_cdgo ");
            query.append("      , c.cli_cdgo ");
            query.append("   FROM cli                     c ");
            query.append("      , rep                     r ");
            query.append("      , regionais_vendas        rv ");
            query.append("      , cliente_representante   cr ");
            query.append("  WHERE r.codigo_regional       = r.codigo_regional ");
            query.append("    AND r.rep_cdgo              = cr.codigo_representante ");
            query.append("    AND rv.codigo_regional      = r.codigo_regional ");
            query.append("    AND c.cli_cdgo              = cr.codigo_cliente ");
            query.append("    AND cr.codigo_representante = '").append(f.getRep()).append("'");
            Vector res_Jw_reg_rep_cli = j.select(table, query.toString(), null);

            if (res_Jw_reg_rep_cli != null && res_Jw_reg_rep_cli.size() > 0) {
              portalbr.dbobj.view.Jw_reg_rep_cli r = (portalbr.dbobj.view.Jw_reg_rep_cli) res_Jw_reg_rep_cli.elementAt(0);
              g.setParametro("P_REGIONAL", r.getCodigo_regional());
            }

          }
          finally {
            if (j != null) {
              j.close();
              j = null;
            }
          }

          //------------------------------------------------------------------------------------
        }
      }
      else {
        g.setParametro("P_REGIONAL", f.getReg());
      }
      if (f.getRep().equals("")) {
        g.setParametro("P_REP_CDGO", f.getRep_cdgo());
      } else {
        g.setParametro("P_REP_CDGO", f.getRep());
      }
      g.gerar();
      //------------------------------------------------------------------------------------
      if ((f.getAbre_automaticamente() + "").equals("checked")) {
        request.setAttribute("abre_automaticamente","S");
      } else {
        request.setAttribute("abre_automaticamente","N");
      }
      actionForward = mapping.findForward("same");
    }
    catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }


  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      Sbr061ActionForm f = (Sbr061ActionForm) form;
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
