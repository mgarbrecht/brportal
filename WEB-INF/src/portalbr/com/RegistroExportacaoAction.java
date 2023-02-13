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
 * Creation Date 11/07/2017 11:18:59
 * Last Modify Date 22/08/2017 11:55:27
 */

public class RegistroExportacaoAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      RegistroExportacaoActionForm f = (RegistroExportacaoActionForm) form;
      select_action(j, mapping, form, request, response);
      if (f.getGerar_planilha() == null || f.getGerar_planilha().equalsIgnoreCase("0")) {
        actionForward = new ActionForward("/com/RegistroExportacao_rForm.jsp",true);
      } else {
        actionForward = new ActionForward("/com/RegistroExportacaoForm.jsp",true);
      }
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_registros_exportacao", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    RegistroExportacaoActionForm f = (RegistroExportacaoActionForm) form;
    boolean validaFatura = false;
    boolean validaPeriodo = false;
    boolean validaPeriodoRE = false;
    boolean validaDrawback = false;
    String filial = "null";
    String despachante = "null";
    if (f.getCodigo_pessoa() != "") {
      despachante = f.getCodigo_pessoa();
    }
    if (f.getFil_filial() != "") {
      filial = "'"+f.getFil_filial() + "'";
    }
    if (f.getEmp_empresa() != "" && f.getAno_fatura() != "" && f.getNumero_fatura() != "") {
      validaFatura = true;
    }
    if (f.getData_averbacao_inicial() != "" && f.getData_averbacao_final() != "") {
      validaPeriodo = true;
    }
    if (f.getData_re_inicial() != "" && f.getData_re_final() != "") {
      validaPeriodoRE = true;
    }
    if (f.getNro_drawback() != "") {
      validaDrawback = true;
    }
    if (!validaFatura && !validaPeriodo && !validaPeriodoRE && !validaDrawback) {
      throw new Exception("A fatura (empresa, ano e número), o Nro. Drawback, o período averbação ou o período RE devem ser informados!");
    }
    Jw_registros_exportacao table = new Jw_registros_exportacao();
    StringBuilder sb = new StringBuilder();
    sb.append(" SELECT numero_re ");
    sb.append("      , data_embarque ");
    sb.append("      , data_averbacao ");
    sb.append("      , emp_empresa ");
    sb.append("      , ano_fatura ");
    sb.append("      , numero_fatura ");
    sb.append("      , ncm ");
    sb.append("      , pares ");
    sb.append("      , perc_comissao ");
    sb.append("      , fob ");
    sb.append("      , valor_comissao ");
    sb.append("      , fob_liquido ");
    sb.append("      , nome_despachante ");
    sb.append("      , valor_unitario ");
    sb.append("      , dde ");
    sb.append("      , produto ");
    if (f.getGerar_planilha() == null || f.getGerar_planilha().equalsIgnoreCase("0")) {
      sb.append("   , replace(descricao_produto,chr(10),'<br />') descricao_produto ");
    } else {
      sb.append("   , replace(descricao_produto,chr(10),(chr(13)||chr(10))) descricao_produto ");
    }
    sb.append("      , numero_drawback ");
    sb.append("      , initcap(componente) componente ");
    sb.append("      , consumo ");
    sb.append("      , fil_filial ");
    sb.append("   FROM TABLE(brio.pck_averbacao_faturas.get_( ");

    if (validaFatura) {
      sb.append("                                              '"+ f.getEmp_empresa() + "' ");
      sb.append("                                             ," + f.getAno_fatura());
      sb.append("                                             ," + f.getNumero_fatura());
    } else {
      sb.append("                                              null ");
      sb.append("                                             ,null ");
      sb.append("                                             ,null ");
    }
    if (validaPeriodo) {
      sb.append("                                             ,to_date('"+f.getData_averbacao_inicial() + "', 'dd/mm/yyyy HH24MI') ");
      sb.append("                                             ,to_date('"+f.getData_averbacao_final() + "', 'dd/mm/yyyy HH24MI') ");
    } else {
      sb.append("                                             ,null ");
      sb.append("                                             ,null ");
    }
    if (validaPeriodoRE) {
      sb.append("                                             ,to_date('"+f.getData_re_inicial() + "', 'dd/mm/yyyy HH24MI') ");
      sb.append("                                             ,to_date('"+f.getData_re_final() + "', 'dd/mm/yyyy HH24MI') ");
    } else {
      sb.append("                                             ,null ");
      sb.append("                                             ,null ");
    }
    if (validaDrawback) {
      sb.append("                                             ," + f.getNro_drawback());
    } else {
      sb.append("                                             ,null ");
    }
    sb.append("                                                ," + filial);
    sb.append("                                                ," + despachante);
    sb.append("                                         )) ");
    sb.append("  ORDER BY numero_re ");
    sb.append("         ,componente ");

    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");

    if (usuario.mostraQuery()) {
      throw new Exception(sb.toString());
    }

    Vector res_Jw_registros_exportacao = j.select(table, sb.toString(), null);
    util.consultas.com.RegistroExportacao registroExportacao2 = new util.consultas.com.RegistroExportacao();
    List < util.consultas.com.RegistroExportacao.Registro > listaRegistroExportacao = registroExportacao2.geraDados(res_Jw_registros_exportacao);
    session.setAttribute("res_Jw_registros_exportacao", listaRegistroExportacao);
    session.removeAttribute("arquivo");
    if (res_Jw_registros_exportacao != null && res_Jw_registros_exportacao.size() > 0) {
      Jw_registros_exportacao r = (Jw_registros_exportacao) res_Jw_registros_exportacao.elementAt(0);
      if (f.getGerar_planilha() == null || f.getGerar_planilha().equalsIgnoreCase("0")) {
      } else {
        util.consultas.com.RegistroExportacao registroExportacao = new util.consultas.com.RegistroExportacao();
        String arquivo = registroExportacao.geraExcel(res_Jw_registros_exportacao);
        session.setAttribute("arquivo", arquivo);
      }
    } else {
      throw new Exception("Nenhum registro encontrado!");
    }
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      RegistroExportacaoActionForm f = (RegistroExportacaoActionForm) form;
      session.removeAttribute("res_Jw_registros_exportacao");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_registros_exportacao", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
