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
 * Creation Date 09/08/2013 09:04:27
 * Last Modify Date 22/06/2015 12:58:47
 */

public class AbastecimentoMateriaisAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      AbastecimentoMateriaisActionForm f = (AbastecimentoMateriaisActionForm) form;
      select_action(j, mapping, form, request, response);
      //  actionForward = new ActionForward("/ind/AbastecimentoMateriais_mGrid.do?select_action=",true);
      actionForward = new ActionForward("/ind/AbastecimentoMateriais_rForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_abastecimento_materiais", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    AbastecimentoMateriaisActionForm f = (AbastecimentoMateriaisActionForm) form;
    Jw_abastecimento_materiais table = new Jw_abastecimento_materiais();
    String filial = null;
    String ies_codigo = null;
    String cor_cdgo = null;
    String grupo_material = null;
    if (f.getFil_filial() != "") {
      filial = "'"+f.getFil_filial() + "'";
    }
    if (f.getIes_codigo() != "") {
      ies_codigo = " AND ifo.ies_codigo = " + f.getIes_codigo();
    } else {
      ies_codigo = "";
    }
    if (f.getCor_cdgo() != "") {
      cor_cdgo = " AND nvl(ifo.cor_cdgo,NULL) = " + f.getCor_cdgo();
    } else {
      cor_cdgo = "";
    }
    if (f.getGpo_mater_cdgo() != "") {
      grupo_material = f.getGpo_mater_cdgo();
    } else {
      grupo_material = "null";
    }

    StringBuilder sb = new StringBuilder();
    sb.append(" SELECT fornecedor_codigo ");
    sb.append("      , fen_seq ");
    sb.append("      , codigo ");
    sb.append("      , descricao ");
    sb.append("      , unm_codigo ");
    sb.append("      , cor_cdgo ");
    sb.append("      , cor_desc ");
    sb.append("      , NVL(SUM(saldo), 0) + saldo_estoque_17_19_1_1 + saldo_estoque_17_19_17_1 saldo ");
    sb.append("   FROM (SELECT tpr.for_codigo fornecedor_codigo ");
    sb.append("              , tpr.fen_seq ");
    sb.append("              , i.codigo ");
    sb.append("              , i.descricao ");
    sb.append("              , i.unm_codigo ");
    sb.append("              , s.cor_cdgo ");
    sb.append("              , c.cor_desc ");
    sb.append("              , s.sdo_req saldo ");
    sb.append("              , fct_saldo_reposicao(s.fil_filial, i.codigo, s.cor_cdgo, s.tai_codigo, 1) repos ");
    sb.append("              , fct_saldo_estoque_atual('01', '17', '01', i.codigo, s.cor_cdgo, s.tai_codigo, 19, 1, 1) saldo_estoque_17_19_1_1 ");
    sb.append("              , fct_saldo_estoque_atual('01', '17', '01', i.codigo, s.cor_cdgo, s.tai_codigo, 19, 17, 1) saldo_estoque_17_19_17_1 ");
    sb.append("           FROM req_sdo_abastecimento s ");
    sb.append("              , filial f ");
    sb.append("              , cor c ");
    sb.append("              , dom_item_estoque i ");
    sb.append("              , dom_tabela_preco tpr ");
    sb.append("              , for_endere fe ");
    sb.append("              , dom_item_fornecedor ifo ");
    sb.append("              , est.dom_grupo_material_x_poi dgmp ");
    sb.append("          WHERE s.emp_empresa = '01' ");
    sb.append("            AND dgmp.gpo_cdgo_poi = NVL(i.gpo_codigo, NULL) ");
    sb.append("            AND s.ies_codigo = i.codigo ");
    sb.append("            AND s.cor_cdgo = c.cor_cdgo ");
    sb.append("            AND s.emp_empresa = f.emp_empresa ");
    sb.append("            AND s.fil_filial = f.fil_filial ");
    sb.append("            AND tpr.ies_codigo = s.ies_codigo ");
    sb.append("            AND tpr.cor_cdgo = s.cor_cdgo ");
    sb.append("            AND tpr.tai_codigo = s.tai_codigo ");
    sb.append("            AND tpr.emp_empresa = s.emp_empresa ");
    sb.append("            AND tpr.fil_filial = s.fil_filial ");
    sb.append("            AND tpr.unn_codigo = f.unn_codigo ");
    sb.append("            AND NVL(tpr.data_liberacao_diretor, NULL) >= TRUNC(SYSDATE) ");
    sb.append("            AND NVL(tpr.status, NULL) = 'A' ");
    sb.append("            AND tpr.for_codigo = ").append(f.getFornecedor());
    sb.append("            AND s.fil_filial = nvl(").append(filial).append(", s.fil_filial)  ");
    sb.append("            AND tpr.data_geracao = (SELECT MAX(tab.data_geracao) ");
    sb.append("                                      FROM dom_tabela_preco tab ");
    sb.append("                                     WHERE tab.ies_codigo = tpr.ies_codigo ");
    sb.append("                                       AND tab.cor_cdgo = tpr.cor_cdgo ");
    sb.append("                                       AND tab.tai_codigo = tpr.tai_codigo ");
    sb.append("                                       AND tab.emp_empresa = tpr.emp_empresa ");
    sb.append("                                       AND tab.fil_filial = tpr.fil_filial ");
    sb.append("                                       AND tab.status = 'A') ");
    sb.append("            AND ifo.for_codigo = tpr.for_codigo ");
    sb.append("            AND ifo.fen_seq = tpr.fen_seq ");
    sb.append("            AND ifo.ies_codigo = tpr.ies_codigo ");
    sb.append("            AND ifo.cor_cdgo = tpr.cor_cdgo ");
    sb.append("            AND ifo.tai_codigo = tpr.tai_codigo ");
    sb.append("            AND ifo.emp_empresa = NVL(tpr.emp_empresa, NULL) ");
    sb.append("            AND ifo.fil_filial = NVL(tpr.fil_filial, NULL) ");
    sb.append("            AND ifo.unn_codigo = NVL(tpr.unn_codigo, NULL) ");
    sb.append("            AND fe.for_codigo = ifo.for_codigo ");
    sb.append("            AND fe.fen_seq = ifo.fen_seq ");
    sb.append(ies_codigo);
    sb.append(cor_cdgo);
    sb.append("            AND i.gpo_codigo = nvl("+grupo_material + ", i.gpo_codigo)  ");
    sb.append("            AND fe.fen_ativo = 'S') ");
    sb.append("   GROUP BY fornecedor_codigo ");
    sb.append("          , fen_seq ");
    sb.append("          , codigo ");
    sb.append("          , descricao ");
    sb.append("          , unm_codigo ");
    sb.append("          , cor_cdgo ");
    sb.append("          , cor_desc ");
    sb.append("          , saldo_estoque_17_19_1_1 ");
    sb.append("          , saldo_estoque_17_19_17_1 ");

    if (f.getTipo().equals("falta")) {
      sb.append(" having sum(saldo) < 0 ");
      session.setAttribute("parametro1", "falta");
    } else {
      session.setAttribute("parametro1", "sobra");
      sb.append(" having sum(saldo) > 0 ");
    }

    sb.append(" order by codigo, cor_cdgo ");

    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      throw new Exception(sb.toString());
    }

    session.setAttribute("where", sb.toString());
    Vector res_Jw_abastecimento_materiais = j.select(table, sb.toString(), null);
    session.setAttribute("res_Jw_abastecimento_materiais",res_Jw_abastecimento_materiais);


    session.setAttribute(mapping.getName(), form);
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      AbastecimentoMateriaisActionForm f = (AbastecimentoMateriaisActionForm) form;
      session.removeAttribute("res_Jw_abastecimento_materiais");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_abastecimento_materiais", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
