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
 * Creation Date 24/09/2015 11:08:07
 * Last Modify Date 07/07/2022 17:32:11
 */

public class Sbr0101Action extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      Sbr0101ActionForm f = (Sbr0101ActionForm) form;
      util.consultas.Query query = new util.consultas.Query();
      StringBuilder sb = new StringBuilder();
      String v_data_inicial_atual = null;
      String v_data_final_atual = null;
      String v_data_inicial_anterior = null;
      String v_data_final_anterior = null;
      String v_data_inicio_anterior = null;
      try {
        sb.append(" SELECT to_char(TRUNC(to_date('"+f.getPeriodo() + "', 'mm/yyyy'), 'MM'),'dd/mm/yyyy') || '#' ||  ");
        sb.append("        to_char(LAST_DAY(TO_DATE(to_date('"+f.getPeriodo() + "', 'mm/yyyy'))),'dd/mm/yyyy') || '#' ||  ");
        sb.append("        to_char(TO_DATE(TO_CHAR(TRUNC(to_date('"+f.getPeriodo() + "', 'mm/yyyy'), 'MM'), 'DD/MM') || '/' ||  ");
        sb.append("                TO_CHAR(TO_CHAR(to_date('"+f.getPeriodo() + "', 'mm/yyyy'), 'RRRR') - 1), 'DD/MM/RRRR'),'dd/mm/yyyy') || '#' ||  ");
        sb.append("        to_char(LAST_DAY(TO_DATE(TO_CHAR(TO_DATE(to_date('"+f.getPeriodo() + "', 'mm/yyyy')), 'DD/MM') || '/' ||  ");
        sb.append("                         TO_CHAR(TO_CHAR(to_date('"+f.getPeriodo() + "', 'mm/yyyy'), 'RRRR') - 1), 'DD/MM/RRRR')),'dd/mm/yyyy') || '#' ||  ");
        sb.append("        to_char(TRUNC(TO_DATE(TO_CHAR(TRUNC(to_date('"+f.getPeriodo() + "', 'mm/yyyy'), 'MM'), 'DD/MM') || '/' ||  ");
        sb.append("                      TO_CHAR(TO_CHAR(to_date('"+f.getPeriodo() + "', 'mm/yyyy'), 'RRRR') - 1), 'DD/MM/RRRR'), 'RRRR'),'dd/mm/yyyy') ");
        sb.append("   FROM dual ");
        String[] datas = query.retorna(j, sb.toString()).split("#");
        v_data_inicial_atual = datas[0];
        v_data_final_atual = datas[1];
        v_data_inicial_anterior = datas[2];
        v_data_final_anterior = datas[3];
        v_data_inicio_anterior = datas[4];

        //--------------------------------------------------------------------------
        if (f.getPais() != "") {
          String pais = query.retorna(j, "select 's' from paises where descricao = upper('"+f.getPais() + "')");
          if (!pais.equalsIgnoreCase("s")) {
            throw new Exception("País inexistente!");
          }
        }

      } catch (Exception e) {
      } finally {
        if (j != null) {
          j.close();
        }
      }

      util.file.GeraPDF g = new util.file.GeraPDF(request);
      String relatorio = "";
      if (f.getAbertura().equalsIgnoreCase("REP")) {
        relatorio = "sbr0101_a.rdf";
      } else {
        relatorio = "sbr0101.rdf";
      }
      if (f.getTipo_mercado().equalsIgnoreCase("ME_VENDA")) {
        relatorio = "sbr0101_b.rdf";
      }
      g.setRelatorio(relatorio);
      acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
      if (usuario.mostraQuery()) {
        throw new Exception("Query não disponível! Relatório utilizado: " + relatorio);
      }
      g.setParametro("P_DATA_INICIAL_ATUAL", v_data_inicial_atual);
      g.setParametro("P_DATA_FINAL_ATUAL", v_data_final_atual);
      g.setParametro("P_DATA_INICIAL_ANTERIOR", v_data_inicial_anterior);
      g.setParametro("P_DATA_FINAL_ANTERIOR", v_data_final_anterior);
      g.setParametro("P_TIPO_RELATORIO", f.getTipo_mercado());
      if (!f.getTipo_mercado().equalsIgnoreCase("ME_VENDA")) {
        g.setParametro("P_TIPO_ABERTURA", f.getAbertura());
      }
      g.setParametro("P_REP_CDGO", f.getRep_cdgo());
      g.setParametro("P_REG_CDGO", f.getCodigo_regional());
      g.setParametro("P_SOMENTE_PP", f.getCb_somente_pp() != null ? "S":"N");
      g.setParametro("P_ABRE_MARCA", f.getAbre_marca());
      g.setParametro("P_AGRUPADO", "N");
      g.setParametro("SOMENTE_MES", "N");


      if (f.getTipo_mercado().equalsIgnoreCase("ME_VENDA")) {
        g.setParametro("P_DATA_INICIAL", v_data_inicio_anterior);
        g.setParametro("P_DATA_FINAL", v_data_final_atual);
        g.setParametro("P_TIPO_ABERTURA", "A");
        g.setParametro("P_CODIGO_REPRESENTANTE", f.getRep_cdgo());
        g.setParametro("P_CLI_CDGO", f.getCli_cdgo());
        if (f.getPais() != "") {
          g.setParametro("P_PAIS", (f.getPais().toUpperCase().replaceAll(" ", "_")));
        } else {
          g.setParametro("P_PAIS", f.getPais().toUpperCase());
        }
        g.setParametro("P_VISAO", f.getVisao());
      }
      g.gerar();

      //------------------------------------------------------------------------------------
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Dual", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      Sbr0101ActionForm f = (Sbr0101ActionForm) form;
      session.removeAttribute("res_Dual");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Dual", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      Sbr0101ActionForm f = (Sbr0101ActionForm) form;
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Dual", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
