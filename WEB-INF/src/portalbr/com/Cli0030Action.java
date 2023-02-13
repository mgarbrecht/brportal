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
 * Creation Date 09/08/2017 14:56:43
 * Last Modify Date 03/02/2021 13:43:28
 */

public class Cli0030Action extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      Cli0030ActionForm f = (Cli0030ActionForm) form;
      util.file.GeraPDF g = new util.file.GeraPDF(request);
      String relatorio = "CLI0030.rdf";
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

      g.setParametro("P_PERIODO_INICIAL", f.getPed_dadg_ini());
      g.setParametro("P_PERIODO_FINAL", f.getPed_dadg_fim());

      if (!((codigo_regional + "").equals(""))) {
        g.setParametro("P_CODIGO_REGIONAL", codigo_regional);
      } else {
        g.setParametro("P_CODIGO_REGIONAL", f.getCodigo_regional());
      }

      if (!((codigo_representante + "").equals(""))) {
        g.setParametro("P_REP_CDGO", codigo_representante);
      } else {
        g.setParametro("P_REP_CDGO", f.getRep_cdgo());
      }

      g.setParametro("P_REG", f.getReg_cdgo());
      g.setParametro("P_ESTADO", f.getEstado());
      g.setParametro("P_MUNICIPIO", f.getMunicipio());

      if ((f.getAdimplente() + "").equals("S")) {
        g.setParametro("P_ADIMPLENTE", "S");
      } else {
        g.setParametro("P_ADIMPLENTE", "N");
      }

      if ((f.getCb_nao_abrir_municipios() + "").equals("1")) {
        g.setParametro("P_ABRE_MUNICIPIO", "N");
      } else {
        g.setParametro("P_ABRE_MUNICIPIO", "S");
      }

      if ((f.getAgrupamento() + "").equals("G")) {
        g.setParametro("P_TIPO_AGRUPAMENTO_CLI_GRUPO", "GRE_CODIGO");
      } else {
        g.setParametro("P_TIPO_AGRUPAMENTO_CLI_GRUPO", "CLI_CDGO");
      }

      if (f.getClientes() != "") {
        String listaClientes = f.getClientes().replaceAll("\\r\\n|\\r|\\n", ",") + ",";
        if ((listaClientes.charAt(listaClientes.length() - 1) + "").equalsIgnoreCase(",")) {
          listaClientes = listaClientes.substring(0, listaClientes.lastIndexOf(","));
          g.setParametro("P_LISTA_CLIENTES", listaClientes);
        }
      }


      if (f.getGrupos() != "") {
        String listaGrupos = f.getGrupos().replaceAll("\\r\\n|\\r|\\n", ",") + ",";
        if ((listaGrupos.charAt(listaGrupos.length() - 1) + "").equalsIgnoreCase(",")) {
          listaGrupos = listaGrupos.substring(0, listaGrupos.lastIndexOf(","));
          g.setParametro("P_LISTA_GRUPOS", listaGrupos);
        }
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
      Cli0030ActionForm f = (Cli0030ActionForm) form;
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
      Cli0030ActionForm f = (Cli0030ActionForm) form;
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
