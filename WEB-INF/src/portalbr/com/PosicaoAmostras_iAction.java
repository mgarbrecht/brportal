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
 * Creation Date 31/01/2011 07:55:53
 * Last Modify Date 16/07/2019 09:26:56
 */

public class PosicaoAmostras_iAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      PosicaoAmostras_iActionForm f = (PosicaoAmostras_iActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ped_amostra_situacoes_estagios", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    PosicaoAmostras_iActionForm f = (PosicaoAmostras_iActionForm) form;
    Ped_amostra_situacoes_estagios table = new Ped_amostra_situacoes_estagios();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"ped_nmro","=", com.egen.util.text.FormatNumber.toInt(f.getPed_nmro())} };
    Vector res_Ped_amostra_situacoes_estagios = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Ped_amostra_situacoes_estagios",res_Ped_amostra_situacoes_estagios);
    if (res_Ped_amostra_situacoes_estagios != null && res_Ped_amostra_situacoes_estagios.size() > 0) {
      Ped_amostra_situacoes_estagios r = (Ped_amostra_situacoes_estagios) res_Ped_amostra_situacoes_estagios.elementAt(0);
      f.setPed_nmro(r.getPed_nmro() + "");
      f.setId_situacao(r.getId_situacao() + "");
      f.setObservacao((r.getObservacao() != null) ? r.getObservacao() + "":"");
    }
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      PosicaoAmostras_iActionForm f = (PosicaoAmostras_iActionForm) form;
      try {
        insert_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ped_amostra_situacoes_estagios", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    PosicaoAmostras_iActionForm f = (PosicaoAmostras_iActionForm) form;
    util.consultas.Query query = new util.consultas.Query();
    //---- Verifica se já está inserido na tabela ------------------------
    acesso.Sessao sessao = new acesso.Sessao(session);
    String existe = query.retorna(j, "SELECT 1 FROM brio.ped_amostra_situacoes_estagios WHERE ped_nmro = "+f.getPed_nmro());
    if (existe.equals("1")) {
      query.execute(j, "UPDATE brio.ped_amostra_situacoes_estagios SET observacao = '"+f.getObservacao() + "' WHERE ped_nmro = "+f.getPed_nmro());
    } else {
      query.execute(j, "insert INTO brio.ped_amostra_situacoes_estagios VALUES ((SELECT nvl(max(id_situacao)+1,1) FROM brio.PED_AMOSTRA_SITUACOES_ESTAGIOS),"+f.getPed_nmro() + ",2,'"+f.getObservacao() + "','"+sessao.getUsuario() + "',SYSDATE, null)");
    }
    //--------------------------------------------------------------------
    Ped_amostra_rep_vw table = new Ped_amostra_rep_vw();
    String[][] select = null;
    Object[][] where = { {"ped_nmro","=", com.egen.util.text.FormatNumber.toInteger(f.getPed_nmro())}};
    Vector res_Ped_amostra_rep_vw_c = j.select(table, select, where, null, null, null);
    if (res_Ped_amostra_rep_vw_c != null && res_Ped_amostra_rep_vw_c.size() > 0) {
      Ped_amostra_rep_vw r = (Ped_amostra_rep_vw) res_Ped_amostra_rep_vw_c.elementAt(0);
      util.email.EmailUtil email = new util.email.EmailUtil();
      util.consultas.Parametros parametros = new util.consultas.Parametros();
      email.inicializa();
      String emailDestinatario = null;
      String[] emails = parametros.retornaParametro("email_posicao_entrega_amostras").split(";");
      int contador = 1;
      List < String > listaEmails = new ArrayList();
      for (String e :
          emails) {
        if (contador == 1) {
          emailDestinatario = e;
        } else {
          listaEmails.add(e);
        }
        contador++;
      }
      email.setEmailDestinatario(emailDestinatario);
      if (listaEmails != null && !listaEmails.isEmpty()) {
        email.setListaCC(listaEmails);
      }

      email.setAssunto("BRPortal - Posicao de entrega de amostras - Nova observacao: pedido: "+f.getPed_nmro());
      StringBuilder sb = new StringBuilder();
      sb.append("<table border=\"1\">");
      sb.append("   <tr> ");
      sb.append("      <td> ");
      sb.append("         Nota Fiscal ");
      sb.append("      </td> ");
      sb.append("      <td> ");
      sb.append("         Pedido ");
      sb.append("      </td> ");
      sb.append("      <td> ");
      sb.append("         Linha");
      sb.append("      </td> ");
      sb.append("      <td> ");
      sb.append("         Representante ");
      sb.append("      </td> ");
      sb.append("      <td> ");
      sb.append("         Regional ");
      sb.append("      </td> ");
      sb.append("      <td> ");
      sb.append("         Cliente ");
      sb.append("      </td> ");
      sb.append("      <td> ");
      sb.append("         Transportadora ");
      sb.append("      </td> ");
      sb.append("      <td> ");
      sb.append("         Consig. ");
      sb.append("      </td> ");
      sb.append("      <td> ");
      sb.append("         Observacao ");
      sb.append("      </td> ");
      sb.append("   </tr> ");
      sb.append("   <tr> ");
      sb.append("      <td> ");
      sb.append((r.getNfs_nmro() != null) ? r.getNfs_nmro() + "":"");
      sb.append("      </td> ");
      sb.append("      <td> ");
      sb.append((r.getPed_nmro() != null) ? r.getPed_nmro() + "":"");
      sb.append("      </td> ");
      sb.append("      <td> ");
      sb.append(r.getLin_cdgo() + " - "+ r.getTipo_produto());
      sb.append("      </td> ");
      sb.append("      <td> ");
      sb.append(r.getRep());
      sb.append("      </td> ");
      sb.append("      <td> ");
      sb.append(r.getRegional());
      sb.append("      </td> ");
      sb.append("      <td> ");
      sb.append(r.getCliente());
      sb.append("      </td> ");
      sb.append("      <td> ");
      sb.append(r.getTra());
      sb.append("      </td> ");
      sb.append("      <td> ");
      sb.append(r.getConsig());
      sb.append("      </td> ");
      sb.append("      <td> ");
      sb.append(f.getObservacao());
      sb.append("      </td> ");
      sb.append("   </tr> ");
      sb.append("</table>");
      email.adicionaLinha(sb.toString());
      email.enviarEmail();

    }
    //--------------------------------------------------------------------
    java.util.Vector res_Ped_amostra_rep_vw = (java.util.Vector) session.getAttribute("res_Ped_amostra_rep_vw");
    if (res_Ped_amostra_rep_vw != null && res_Ped_amostra_rep_vw.size() > 0) {
      portalbr.dbobj.table.Ped_amostra_rep_vw t_ped_amostra_rep_vw = (portalbr.dbobj.table.Ped_amostra_rep_vw) res_Ped_amostra_rep_vw.elementAt(Integer.parseInt(f.getPosicao()));
      t_ped_amostra_rep_vw.setObservacao(f.getObservacao());
      session.setAttribute("fechar","s");
    }
    //--------------------------------------------------------------------
    session.setAttribute(mapping.getName(), form);
  }
  public ActionForward perform_select1_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      PosicaoAmostras_iActionForm f = (PosicaoAmostras_iActionForm) form;
      try {
        select1_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ped_amostra_situacoes_estagios", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void select1_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    PosicaoAmostras_iActionForm f = (PosicaoAmostras_iActionForm) form;
    Ped_amostra_rep_vw table = new Ped_amostra_rep_vw();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"ped_nmro","=", com.egen.util.text.FormatNumber.toInteger(f.getPed_nmro())}, {"id_situacao","=", com.egen.util.text.FormatNumber.toInteger(f.getId_situacao())}, {"observacao","like", f.getObservacao()}, };
    Vector res_Ped_amostra_rep_vw = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Ped_amostra_rep_vw",res_Ped_amostra_rep_vw);
    if (res_Ped_amostra_rep_vw != null && res_Ped_amostra_rep_vw.size() > 0) {
      Ped_amostra_rep_vw r = (Ped_amostra_rep_vw) res_Ped_amostra_rep_vw.elementAt(0);
      f.setPed_nmro((r.getPed_nmro() != null) ? r.getPed_nmro() + "":"");
      f.setId_situacao((r.getId_situacao() != null) ? r.getId_situacao() + "":"");
      f.setObservacao((r.getObservacao() != null) ? r.getObservacao() + "":"");
      f.setPosicao("0");
      session.setAttribute("posicao", "0");
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ped_amostra_situacoes_estagios", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute(mapping.getName(), form);
  }

}
