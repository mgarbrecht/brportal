package portalbr.adm;

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
 * Creation Date 10/05/2012 17:39:45
 * Last Modify Date 05/11/2019 09:44:30
 */

public class ConsultaPagamentoFornecedoresAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ConsultaPagamentoFornecedoresActionForm f = (ConsultaPagamentoFornecedoresActionForm) form;
      try {
        tg_select_action(mapping, form, request, response);
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      e.printStackTrace(System.err);
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_dom_obri", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    ConsultaPagamentoFornecedoresActionForm f = (ConsultaPagamentoFornecedoresActionForm) form;
    boolean gerarPlanilha = false;
    if ((f.getGerar_planilha() + "").equals("1")) {
      gerarPlanilha = true;
    }
    session.removeAttribute("res_Jw_dom_obri");
    Jw_dom_obri table = new Jw_dom_obri();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = {{"DATA_VENCIMENTO",">=",com.egen.util.text.FormatDate.parseTimestamp(f.getData_vencimento(), "dd/MM/yyyy")}, {"DATA_VENCIMENTO","<=",com.egen.util.text.FormatDate.parseTimestamp(f.getData_vencimento_fim(), "dd/MM/yyyy")}, {"DATA_PAGAMENTO",">=",com.egen.util.text.FormatDate.parseTimestamp(f.getData_pagamento(), "dd/MM/yyyy")}, {"DATA_PAGAMENTO","<=",com.egen.util.text.FormatDate.parseTimestamp(f.getData_pagamento_fim(), "dd/MM/yyyy")}, {"FORNECEDOR","like", f.getFornecedor()}, {"STATUS","like", f.getStatus()}, {"NOTA","=", com.egen.util.text.FormatNumber.toInt(f.getNota())}, };
    if (!gerarPlanilha) {
      Vector res_Jw_dom_obri = j.select(table, select, where, groupby, having, order);
      session.setAttribute("res_Jw_dom_obri",res_Jw_dom_obri);
      if (!(res_Jw_dom_obri != null && res_Jw_dom_obri.size() > 0)) {
        request.setAttribute("mensagem", "Nota Fiscal não lançada no sistema! <br><br> Utilize os contatos que constam na pasta Manuais e Procedimentos \"Download de Arquivos\" e contate o setor fiscal da respectiva filial para providenciar o lançamento.");
      }
    } else {
      StringBuilder sb = new StringBuilder();
      if (f.getFornecedor() != "") {
        sb.append(" AND fore.for_codigo = "+f.getFornecedor());
      }
      if (f.getData_vencimento() != "") {
        sb.append(" AND dom.dt_vcto >= to_date('"+f.getData_vencimento() + "','dd/mm/yyyy') ");
      }
      if (f.getData_vencimento_fim() != "") {
        sb.append(" AND dom.dt_vcto <= to_date('"+f.getData_vencimento_fim() + "','dd/mm/yyyy') ");
      }
      if (f.getData_pagamento() != "") {
        sb.append(" AND dom.dt_pgto >= to_date('"+f.getData_pagamento() + "','dd/mm/yyyy') ");
      }
      if (f.getData_pagamento_fim() != "") {
        sb.append(" AND dom.dt_pgto <= to_date('"+f.getData_pagamento_fim() + "','dd/mm/yyyy') ");
      }
      if (f.getStatus() != "") {
        sb.append(" AND dom.cd_situ = '"+f.getStatus() + "' ");
      }
      if (f.getNota() != "") {
        sb.append(" AND dom.cd_docto = " + f.getNota());
      }
      //--------------------------------------------------------------------------
      util.file.GeraXLS g = new util.file.GeraXLS(request);
      g.setRelatorio("ConsultaPagamentoFornecedores.jasper");
      g.setParametro("P_WHERE", sb.toString());
      g.gerar();
    }
    session.setAttribute("mapping.getName()", form);
  }

  private void tg_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      ConsultaPagamentoFornecedoresActionForm f = (ConsultaPagamentoFornecedoresActionForm) form;
      acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
      if (usuario.mostraQuery()) {
        throw new Exception("Query não disponível! Javaview: Jw_dom_obri");
      }
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    } finally {
    }
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ConsultaPagamentoFornecedoresActionForm f = (ConsultaPagamentoFornecedoresActionForm) form;
      session.removeAttribute("res_Jw_dom_obri");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_dom_obri", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
