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
 * Creation Date 14/06/2007 13:40:06
 * Last Modify Date 11/02/2019 10:14:10
 */

public class BaixaArquivosTransportadorasAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_resetfull1_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      BaixaArquivosTransportadorasActionForm f = (BaixaArquivosTransportadorasActionForm) form;
      session.removeAttribute("res_Jw_arquivos_edi");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_arquivos_edi", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      BaixaArquivosTransportadorasActionForm f = (BaixaArquivosTransportadorasActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = new ActionForward("/com/BaixaArquivosTransportadoras_rForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_arquivos_edi", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return actionForward;
  }
  private void select_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    BaixaArquivosTransportadorasActionForm f = (BaixaArquivosTransportadorasActionForm) form;
    Jw_arquivos_edi table = new Jw_arquivos_edi();
    String transportadora = "";
    acesso.Sessao se = new acesso.Sessao(session);
    transportadora = f.getCodigo();
    String tipo = se.getTipoEntidadeNegocio();
    if (tipo.equals("TRANSPORTADORA")) {
      transportadora = se.getChave();
    }

    if (transportadora.equals("")) {
      throw new Exception("Informe a Transportadora.");
    }

    if (f.getData_envio() != "") {
      session.setAttribute("data_envio_embarque_romaneio", f.getData_envio());
    } else {
      session.setAttribute("data_envio_embarque_romaneio", "");
    }
    StringBuilder sb = new StringBuilder();
    sb.append(" SELECT tra_cdgo codigo ");
    sb.append("      , tra_nome nome ");
    sb.append("      , replace(srvweb,'/arquivos/transportadoras/','/home/loja_brportal/arquivos/transportadoras/') caminho ");
    sb.append("      , srvweb caminho_link ");
    sb.append("   FROM arquivos_edi ");
    sb.append("  WHERE tra_cdgo = nvl("+transportadora + ",tra_cdgo)");

    Vector res_Jw_arquivos_edi = j.select(table, sb.toString(), null);

    session.setAttribute("res_Jw_arquivos_edi",res_Jw_arquivos_edi);
    if (res_Jw_arquivos_edi != null && res_Jw_arquivos_edi.size() > 0) {
      Jw_arquivos_edi r = (Jw_arquivos_edi) res_Jw_arquivos_edi.elementAt(0);
      f.setCodigo(r.getCodigo() + "");
      f.setNome((r.getNome() != null) ? r.getNome() + "":"");
      f.setCaminho((r.getCaminho() != null) ? r.getCaminho() + "":"");
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_arquivos_edi", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      BaixaArquivosTransportadorasActionForm f = (BaixaArquivosTransportadorasActionForm) form;
      session.removeAttribute("res_Jw_arquivos_edi");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_arquivos_edi", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
