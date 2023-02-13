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
 * Creation Date 11/08/2017 14:36:32
 * Last Modify Date 17/08/2017 10:07:06
 */

public class ConsumoComposicaoItemAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ConsumoComposicaoItemActionForm f = (ConsumoComposicaoItemActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = new ActionForward("/ind/ConsumoComposicaoItem_rForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consumo_composicao_item", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    ConsumoComposicaoItemActionForm f = (ConsumoComposicaoItemActionForm) form;
    Jw_consumo_composicao_item table = new Jw_consumo_composicao_item();
    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    acesso.Sessao sessao = new acesso.Sessao(session);

    StringBuilder sb = new StringBuilder();
    StringBuilder parametros = new StringBuilder();
    if (f.getCodigo() != "") {
      parametros.append(" AND die.codigo = " + f.getCodigo());
    }
    if (f.getCor_cdgo() != "") {
      parametros.append(" AND c.cor_cdgo = " + f.getCor_cdgo());
    }
    if (sessao.getTipoEntidadeNegocio().equals("FORNECEDOR")) {
      parametros.append(" AND EXISTS (SELECT 1 ");
      parametros.append("              FROM dom_item_fornecedor dif ");
      parametros.append("             WHERE dif.for_codigo = " + sessao.getChave());
      parametros.append("               AND dif.ies_codigo = die.codigo) ");
    }
    sb.append(" SELECT /*+ all_rows */ ");
    sb.append("        die.codigo ");
    sb.append("      , die.descricao ");
    sb.append("      , c.cor_cdgo ");
    sb.append("      , c.cor_desc ");
    sb.append("      , cc.cod_peca ");
    sb.append("      , pck_pecas.get_nome(cc.cod_peca) descricao_peca ");
    sb.append("      , cc.mat_nro material ");
    sb.append("      , pck_item_estoque.get_nome(cc.mat_nro) descricao_material ");
    sb.append("      , pck_item_estoque.get_unm_codigo(cc.mat_nro) unm_codigo ");
    sb.append("      , cc.cor_mater ");
    sb.append("      , pck_cor.get_nome(cc.cor_mater) descricao_cor_material ");
    sb.append("      , cc.set_cdgo ");
    sb.append("      , com_consum ");
    sb.append("      , com_espess ");
    sb.append("      , cc.dimensao_placa ");
    sb.append("      , cc.mao_de_obra ");
    sb.append("      , DECODE(NVL(com_compra, 'N'), 'S', 'SIM', 'NÃO') oc ");
    sb.append("      , DECODE(NVL(com_gerarm, 'N'), 'S', 'SIM', 'NÃO') rm ");
    sb.append("      , DECODE(com_destin, 'I', 'USO INTERNO', 'F', 'USO OUTRA FILIAL', 'T', 'USO TERCEIROS') destino_mat ");
    sb.append("      , com_compra ");
    sb.append("      , com_gerarm ");
    sb.append("      , com_destin ");
    sb.append("   FROM dom_item_estoque      die ");
    sb.append("      , dom_item_cor          dic ");
    sb.append("      , cor                   c ");
    sb.append("      , componente_composicao cc ");
    sb.append("  WHERE dic.ies_codigo = die.codigo ");
    sb.append("    AND cc.ies_codigo = dic.ies_codigo ");
    sb.append("    AND c.cor_cdgo = dic.cor_cdgo ");
    sb.append("    AND cc.cor_cdgo = dic.cor_cdgo ");
    sb.append(parametros.toString());
    sb.append("  ORDER BY die.codigo ");
    sb.append("         , c.cor_cdgo ");
    sb.append("         , cc.cod_peca ");

    if (usuario.mostraQuery()) {
      throw new Exception(sb.toString());
    }

    Vector res_Jw_consumo_composicao_item = j.select(table, sb.toString(), null);
    session.setAttribute("res_Jw_consumo_composicao_item",res_Jw_consumo_composicao_item);
    if (!(res_Jw_consumo_composicao_item != null && res_Jw_consumo_composicao_item.size() > 0)) {
      throw new Exception("Nenhum registro encontrado!");
    }
    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ConsumoComposicaoItemActionForm f = (ConsumoComposicaoItemActionForm) form;
      session.removeAttribute("res_Jw_consumo_composicao_item");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consumo_composicao_item", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
