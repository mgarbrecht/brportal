package portalbr.ind;

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
 * Creation Date 31/08/2009 14:45:37
 * Last Modify Date 02/03/2015 17:10:16
 */

public class AtelieresQuarterizados_cAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_processa_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      AtelieresQuarterizados_cActionForm f = (AtelieresQuarterizados_cActionForm) form;
      j = new com.egen.util.jdbc.JdbcUtil();
      acesso.Sessao sessao = new acesso.Sessao(session);
      if (f.getFo_codigo().equals("")) {
        throw new Exception("O atelier deve ser informado!");
      }
      util.consultas.Query query = new util.consultas.Query();
      java.util.Vector < String > v_atelier = null;
      Integer remessa = null;
      Integer talao = null;
      boolean retorno = true;
      try {
        remessa = Integer.parseInt(f.getCodigo_barra().substring(1, f.getCodigo_barra().indexOf("+")));
        talao = Integer.parseInt(f.getCodigo_barra().substring(f.getCodigo_barra().indexOf("+") + 1, f.getCodigo_barra().length()));
        if (remessa == null || talao == null) {
          retorno = false;
        }
      } catch (Exception e) {
        retorno = false;
      }
      boolean existeTalaoRemessa = query.retorna(j, "SELECT 'S' FROM talao WHERE tal_nro = "+talao + " AND rem_nro = " + remessa).equalsIgnoreCase("S");
      boolean existeFornecedor = query.retorna(j, "SELECT 'S' FROM for_endere_quarterizado WHERE for_codigo = "+f.getFo_codigo() + " AND for_codigo_quarterizado = "+f.getFornecedor() + " AND fen_seq_quarterizado = " + f.getSeq()).equalsIgnoreCase("S");
      if (!existeTalaoRemessa) {
        throw new Exception("Talão/Remessa inexistente!");
      }
      if (!existeFornecedor) {
        throw new Exception("Fornecedor quarterizado inexistete!");
      }
      StringBuilder sbi = new StringBuilder();
      if (f.getTipo().equalsIgnoreCase("E")) {
        sbi.append(" INSERT INTO cpr.atelier_pre_envio_quarterizado VALUES ");
        sbi.append("     (" + f.getFo_codigo());
        sbi.append("     ," + f.getFornecedor());
        sbi.append("     ," + f.getSeq());
        sbi.append("     ," + f.getPro_codigo());
        sbi.append("     ,SYSDATE ");
        sbi.append("     ,NULL ");
        sbi.append("     ," + remessa);
        sbi.append("     ," + talao);
        sbi.append("     ,'E' ");
        sbi.append("     ,'"+f.getUsuario() + "' ");
        sbi.append("     ,NULL) ");
      } else {
        sbi.append(" UPDATE cpr.atelier_pre_envio_quarterizado ");
        sbi.append("    SET data_retorno = SYSDATE ");
        sbi.append("      , usuario_alteracao = '"+sessao.getUsuario() + "' ");
        sbi.append("      , status = 'R' ");
        sbi.append("  WHERE for_codigo = " + f.getFo_codigo());
        sbi.append("    AND for_codigo_quarterizado = " + f.getFornecedor());
        sbi.append("    AND fen_seq_quarterizado = " + f.getSeq());
        sbi.append("    AND pro_numero = " + f.getPro_codigo());
        sbi.append("    AND rem_nro = " + remessa);
        sbi.append("    AND tal_nro = " + talao);
      }
      query.execute(j, sbi.toString());
      f.setCodigo_barra("");
      request.setAttribute("codigobarra","lido");
      //---------------------------------------------------------
      if (false) {
      } else {
        if (session.getAttribute("v_atelier") == null) {
          session.setAttribute("atelier_cor","c");
          v_atelier = new java.util.Vector < String > ();
        } else {
          if (((String) session.getAttribute("atelier_cor")).equals("c")) {
            session.setAttribute("atelier_cor","b");
          } else {
            session.setAttribute("atelier_cor","c");
          }
          v_atelier = (java.util.Vector) session.getAttribute("v_atelier");
        }
        session.setAttribute("v_atelier", v_atelier);
      }
      //---------------------------------------------------------
      actionForward = mapping.findForward("same");
    }
    catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      AtelieresQuarterizados_cActionForm f = (AtelieresQuarterizados_cActionForm) form;
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

  public ActionForward perform_resetfull_talao_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      session.removeAttribute("v_atelier");
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

  public ActionForward perform_resetfull2_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      AtelieresQuarterizados_cActionForm f = (AtelieresQuarterizados_cActionForm) form;
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      session.removeAttribute("v_atelier");
      session.removeAttribute("atelier_cor");
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

  public ActionForward perform_delete_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      AtelieresQuarterizados_cActionForm f = (AtelieresQuarterizados_cActionForm) form;
      delete_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void delete_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    AtelieresQuarterizados_cActionForm f = (AtelieresQuarterizados_cActionForm) form;
    Atelier_pre_envio_quarterizado table = new Atelier_pre_envio_quarterizado();
    table.setFor_codigo(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getFornecedor_codigo()));
    table.setFor_codigo_quarterizado(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getFornecedor_codigo_quarterizado()));
    table.setFen_seq_quarterizado(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getFen_seq_quarterizado()));
    table.setPro_numero(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getPro_numero()));
    table.setRem_nro(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getRem_nro()));
    table.setTal_nro(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getTal_nro()));
    j.delete(table);
    session.setAttribute(mapping.getName(), form);
  }


}
