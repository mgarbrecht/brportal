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
 * Last Modify Date 02/04/2013 15:41:53
 */

public class PosicaoAmostras_oAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      PosicaoAmostras_oActionForm f = (PosicaoAmostras_oActionForm) form;
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
    PosicaoAmostras_oActionForm f = (PosicaoAmostras_oActionForm) form;
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
      f.setObservacao((r.getObs_atendente() != null) ? r.getObs_atendente() + "":"");
    }
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      PosicaoAmostras_oActionForm f = (PosicaoAmostras_oActionForm) form;
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
    PosicaoAmostras_oActionForm f = (PosicaoAmostras_oActionForm) form;
    util.consultas.Query query = new util.consultas.Query();
    //---- Verifica se já está inserido na tabela ------------------------
    acesso.Sessao sessao = new acesso.Sessao(session);
    String existe = query.retorna(j, "SELECT 1 FROM brio.ped_amostra_situacoes_estagios WHERE ped_nmro = "+f.getPed_nmro());
    if (existe.equals("1")) {
      query.execute(j, "UPDATE brio.ped_amostra_situacoes_estagios SET obs_atendente = '"+f.getObservacao() + "' WHERE ped_nmro = "+f.getPed_nmro());
    } else {
      query.execute(j, "insert INTO brio.ped_amostra_situacoes_estagios VALUES ((SELECT nvl(max(id_situacao)+1,1) FROM brio.PED_AMOSTRA_SITUACOES_ESTAGIOS),"+f.getPed_nmro() + ",2,null,'"+sessao.getUsuario() + "',SYSDATE,'"+f.getObservacao() + "')");
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
}
