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
 * Creation Date 05/01/2011 05:22:37
 * Last Modify Date 02/04/2013 15:43:23
 */

public class PosicaoAmostras_rAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      PosicaoAmostras_rActionForm f = (PosicaoAmostras_rActionForm) form;


      actionForward = new ActionForward("/com/PosicaoAmostrasForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Peso_corrugados", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  public ActionForward perform_check_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      PosicaoAmostras_rActionForm f = (PosicaoAmostras_rActionForm) form;
      util.consultas.Query query = new util.consultas.Query();
      acesso.Sessao sessao = new acesso.Sessao(session);
      //---- Verifica se já está inserido na tabela ------------------------
      String existe = query.retorna(j, "SELECT 1 FROM brio.ped_amostra_situacoes_estagios WHERE ped_nmro = "+f.getPed_nmro());
      if (existe.equals("1")) {
        query.execute(j, "UPDATE brio.ped_amostra_situacoes_estagios SET estagio = 1 WHERE ped_nmro = "+f.getPed_nmro());
      } else {
        query.execute(j, "insert INTO brio.ped_amostra_situacoes_estagios VALUES ((SELECT nvl(max(id_situacao)+1,1) FROM brio.PED_AMOSTRA_SITUACOES_ESTAGIOS),"+f.getPed_nmro() + ",1,null,'"+sessao.getUsuario() + "',SYSDATE,null)");
      }
      //--------------------------------------------------------------------
      java.util.Vector res_Ped_amostra_rep_vw = (java.util.Vector) session.getAttribute("res_Ped_amostra_rep_vw");
      portalbr.dbobj.table.Ped_amostra_rep_vw r = (portalbr.dbobj.table.Ped_amostra_rep_vw) res_Ped_amostra_rep_vw.elementAt(Integer.parseInt(f.getIndice()));
      r.setEstagios_marcados("1");
      //--------------------------------------------------------------------
      actionForward = mapping.findForward("same");
    }
    catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Peso_corrugados", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  public ActionForward perform_uncheck_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      util.consultas.Query query = new util.consultas.Query();
      PosicaoAmostras_rActionForm f = (PosicaoAmostras_rActionForm) form;
      acesso.Sessao sessao = new acesso.Sessao(session);
      //---- Verifica se já está inserido na tabela ------------------------
      String existe = query.retorna(j, "SELECT 1 FROM brio.ped_amostra_situacoes_estagios WHERE ped_nmro = "+f.getPed_nmro());
      if (existe.equals("1")) {
        query.execute(j, "UPDATE brio.ped_amostra_situacoes_estagios SET estagio = 2 WHERE ped_nmro = "+f.getPed_nmro());
      } else {
        query.execute(j, "insert INTO brio.ped_amostra_situacoes_estagios VALUES ((SELECT nvl(max(id_situacao)+1,1) FROM brio.PED_AMOSTRA_SITUACOES_ESTAGIOS),"+f.getPed_nmro() + ",2,null,'"+sessao.getUsuario() + "',SYSDATE)");
      }
      //--------------------------------------------------------------------
      java.util.Vector res_Ped_amostra_rep_vw = (java.util.Vector) session.getAttribute("res_Ped_amostra_rep_vw");
      portalbr.dbobj.table.Ped_amostra_rep_vw r = (portalbr.dbobj.table.Ped_amostra_rep_vw) res_Ped_amostra_rep_vw.elementAt(Integer.parseInt(f.getIndice()));
      r.setEstagios_marcados("");
      //--------------------------------------------------------------------
      actionForward = mapping.findForward("same");
    }
    catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Peso_corrugados", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
