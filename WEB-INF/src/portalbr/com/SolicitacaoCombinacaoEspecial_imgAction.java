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
 * Creation Date 10/06/2015 12:51:14
 * Last Modify Date 05/11/2020 12:19:19
 */

public class SolicitacaoCombinacaoEspecial_imgAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      SolicitacaoCombinacaoEspecial_imgActionForm f = (SolicitacaoCombinacaoEspecial_imgActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ref_combinacao_especial_img", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    SolicitacaoCombinacaoEspecial_imgActionForm f = (SolicitacaoCombinacaoEspecial_imgActionForm) form;
    Ref_combinacao_especial_img table = new Ref_combinacao_especial_img();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"id_solicitacao","=", com.egen.util.text.FormatNumber.toInteger(f.getId_solicitacao())}, {"id_imagem","=", com.egen.util.text.FormatNumber.toInteger(f.getId_imagem())}, {"descricao_imagem","like", f.getDescricao_imagem()} };
    Vector res_Ref_combinacao_especial_img = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Ref_combinacao_especial_img",res_Ref_combinacao_especial_img);
    if (res_Ref_combinacao_especial_img != null && res_Ref_combinacao_especial_img.size() > 0) {
      Ref_combinacao_especial_img r = (Ref_combinacao_especial_img) res_Ref_combinacao_especial_img.elementAt(0);
      f.setId_solicitacao((r.getId_solicitacao() != null) ? r.getId_solicitacao() + "":"");
      f.setId_imagem((r.getId_imagem() != null) ? r.getId_imagem() + "":"");
      f.setImagem((r.getImagem() != null) ? r.getImagem() + "":"");
      f.setDescricao_imagem((r.getDescricao_imagem() != null) ? r.getDescricao_imagem() + "":"");
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ref_combinacao_especial_img", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute(mapping.getName(), form);
  }

}
