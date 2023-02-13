package portalbr.lov;

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
 * Creation Date 14/08/2017 09:24:37
 * Last Modify Date 16/08/2017 15:17:21
 */

public class LvConsumoComposicaoMaterialAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      LvConsumoComposicaoMaterialActionForm f = (LvConsumoComposicaoMaterialActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consumo_composicao_material", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    acesso.Sessao sessao = new acesso.Sessao(session);
    LvConsumoComposicaoMaterialActionForm f = (LvConsumoComposicaoMaterialActionForm) form;
    Jw_consumo_composicao_material table = new Jw_consumo_composicao_material();
    StringBuilder sb = new StringBuilder();
    sb.append(" SELECT /*+ all_rows */ ");
    sb.append("        DISTINCT ");
    sb.append("        cc.mat_nro ");
    sb.append("      , die.descricao ");
    sb.append("      , 0 ies_codigo ");
    sb.append("      , 0 cor_cdgo ");
    sb.append("   FROM componente_composicao cc ");
    sb.append("      , dom_item_estoque      die ");
    sb.append("  WHERE cc.mat_nro = die.codigo ");
    if (f.getIes_codigo() != "") {
      sb.append(" AND cc.ies_codigo = " + f.getIes_codigo());
    }
    if (sessao.getTipoEntidadeNegocio().equals("FORNECEDOR")) {
      sb.append(" AND EXISTS (SELECT 1 ");
      sb.append("              FROM dom_item_fornecedor dif ");
      sb.append("             WHERE dif.for_codigo = " + sessao.getChave());
      sb.append("               AND dif.ies_codigo = die.codigo) ");
    }
    if (f.getCodigo() != "") {
      sb.append(" AND cc.mat_nro = " + f.getCodigo());
    }
    if (f.getDescricao() != "") {
      sb.append(" AND die.descricao like ('"+f.getDescricao().toUpperCase() + "') ");
    }
    sb.append("  ORDER BY cc.mat_nro ");
    Vector res_Jw_consumo_composicao_material = j.select(table, sb.toString(), null);
    session.setAttribute("res_Jw_consumo_composicao_material",res_Jw_consumo_composicao_material);
    if (res_Jw_consumo_composicao_material == null || res_Jw_consumo_composicao_material.size() == 0) {
      throw new Exception("Nenhum registro encontrado!");
    }
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      LvConsumoComposicaoMaterialActionForm f = (LvConsumoComposicaoMaterialActionForm) form;
      session.removeAttribute("res_Jw_consumo_composicao_material");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consumo_composicao_material", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
