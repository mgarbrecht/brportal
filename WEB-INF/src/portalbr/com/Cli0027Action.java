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
 * Creation Date 24/08/2017 10:30:43
 * Last Modify Date 03/02/2021 13:43:21
 */

public class Cli0027Action extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      Cli0027ActionForm f = (Cli0027ActionForm) form;
      util.file.GeraPDF g = new util.file.GeraPDF(request);
      String relatorio = "CLI0027.rdf";
      g.setRelatorio(relatorio);
      acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
      acesso.Sessao se = new acesso.Sessao(session);
      String tipo = se.getTipoEntidadeNegocio();
      String codigo_analista = "";
      String codigo_regional = "";
      String codigo_representante = "";

      if (usuario.mostraQuery()) {
        throw new Exception("Query não disponível! Relatório utilizado: " + relatorio);
      }

      if (tipo.equals("REGIONAL DE VENDA")) {
        codigo_regional = se.getChave();
      }

      if (tipo.equals("ANALISTA REGIONAL")) {
        codigo_analista = se.getChave();
        com.egen.util.jdbc.JdbcUtil j = null;
        try {
          j = new com.egen.util.jdbc.JdbcUtil();
          portalbr.dbobj.view.Jw_regional_analista table = new portalbr.dbobj.view.Jw_regional_analista();
          String[][] select = null;
          Object[][] where = {{"codigo_gerente","=",codigo_analista}};
          Vector res_Jw_regional_analista = j.select(table, select, where, null, null, null);
          if (res_Jw_regional_analista != null && res_Jw_regional_analista.size() > 0) {
            portalbr.dbobj.view.Jw_regional_analista r = (portalbr.dbobj.view.Jw_regional_analista) res_Jw_regional_analista.elementAt(0);
            codigo_regional = r.getCodigo_regional();
          }
        }
        finally {
          if (j != null) {
            j.close();
            j = null;
          }
        }
      }

      if ((tipo.equals("REPRESENTANTE COMERCIAL")) || (tipo.equals("REPRESENTANTE EXPORTACAO"))) {
        codigo_representante = se.getChave();
        com.egen.util.jdbc.JdbcUtil j = null;
        try {
          j = new com.egen.util.jdbc.JdbcUtil();
          portalbr.dbobj.table.Rep table = new portalbr.dbobj.table.Rep();
          String[][] select = null;
          Object[][] where = {{"rep_cdgo","=",codigo_representante}};
          Vector res_Rep = j.select(table, select, where, null, null, null);
          if (res_Rep != null && res_Rep.size() > 0) {
            portalbr.dbobj.table.Rep r = (portalbr.dbobj.table.Rep) res_Rep.elementAt(0);
            codigo_regional = r.getCodigo_regional() + "";
          }
        }
        finally {
          if (j != null) {
            j.close();
            j = null;
          }
        }
      }

      g.setParametro("P_PERIODO_INI", f.getPed_dadg_ini());
      g.setParametro("P_PERIODO_FIM", f.getPed_dadg_fim());

      if (!((codigo_regional + "").equals(""))) {
        g.setParametro("P_CODIGO_REGIONAL", codigo_regional);
      } else {
        if (!((f.getCodigo_regional() + "").equals(""))) {
          g.setParametro("P_CODIGO_REGIONAL", f.getCodigo_regional());
        }
      }

      if (!((codigo_representante + "").equals(""))) {
        g.setParametro("P_REP_CDGO", codigo_representante);
      } else {
        if (!((f.getRep_cdgo() + "").equals(""))) {
          g.setParametro("P_REP_CDGO", f.getRep_cdgo());
        }
      }

      if (!((f.getCategoria() + "").equals(""))) {
        g.setParametro("P_CATEGORIA", f.getCategoria());
      }

      if (!((f.getCodigo_marca() + "").equals(""))) {
        g.setParametro("P_CODIGO_MARCA", f.getCodigo_marca());
      }

      if (!((f.getRep_situ() + "").equals(""))) {
        g.setParametro("P_SITUACAO_REP", f.getRep_situ());
      }

      if ((f.getAbrirCategoria() + "").equals("S")) {
        g.setParametro("P_ABRIR_POR_CATEGORIA", "S");
      } else {
        g.setParametro("P_ABRIR_POR_CATEGORIA", "N");
      }

      if ((f.getAbrirModelo() + "").equals("S")) {
        g.setParametro("P_ABRIR_POR_MODELO", "S");
      } else {
        g.setParametro("P_ABRIR_POR_MODELO", "N");
      }

      g.gerar();


      //------------------------------------------------------------------------------------
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

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      Cli0027ActionForm f = (Cli0027ActionForm) form;
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

  public ActionForward perform_refresh_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      Cli0027ActionForm f = (Cli0027ActionForm) form;
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
