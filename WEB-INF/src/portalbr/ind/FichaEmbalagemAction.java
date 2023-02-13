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
 * Creation Date 23/08/2011 13:50:53
 * Last Modify Date 22/06/2015 13:07:48
 */

public class FichaEmbalagemAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      FichaEmbalagemActionForm f = (FichaEmbalagemActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = new ActionForward("/ind/FichaEmbalagem_rForm.jsp", true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ficha_embalagem", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    FichaEmbalagemActionForm f = (FichaEmbalagemActionForm) form;
    Jw_ficha_embalagem table = new Jw_ficha_embalagem();

    String parametros = "";

    acesso.Sessao sessao = new acesso.Sessao(session);

    if (sessao.getTipoEntidadeNegocio().equals("REGIONAL DE VENDA")) {
      parametros = " AND re.rep_cdgo = '"+sessao.getChave() + "' ";
    }

    if (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")) {
      parametros = " AND re.codigo_regional = "+sessao.getChave();
    }

    if (sessao.getTipoEntidadeNegocio().equals("CLIENTE MERCADO INTERNO")) {
      parametros = " AND cl.cli_cdgo = "+sessao.getChave();
    }

    StringBuilder sb = new StringBuilder();
    sb.append(" SELECT DISTINCT ");
    sb.append("        ftec.lin_cdgo ");
    sb.append("      , l.lin_nome ");
    sb.append("      , ftec.ref_cdgo ");
    sb.append("      , ft.codigo codigo_corrugado ");
    sb.append("      , c.descricao descricao_corrugado ");
    sb.append("      , ft.mat_nro ");
    sb.append("      , ies.descricao ");
    sb.append("      , pc.altura ");
    sb.append("      , pc.largura ");
    sb.append("      , pc.comprimento ");
    sb.append("      , pc.qt_par_corrug ");
    sb.append("      , comp.mat_nro cod_cx_ind ");
    sb.append("      , pck_item_estoque.get_nome(comp.mat_nro) cod_cx_ind_desc ");
    sb.append("   FROM ficha_embalagem ft ");
    sb.append("      , corrugados c ");
    sb.append("      , ficha_tec ftec ");
    sb.append("      , componente comp ");
    sb.append("      , peso_corrugados pc ");
    sb.append("      , dom_item_estoque ies ");
    sb.append("      , ref r ");
    sb.append("      , lin l ");
    sb.append("      , ref_cor rc ");
    sb.append("      , cor_compo ccmp ");
    sb.append("  WHERE l.lin_cdgo = ft.lin_cdgo ");
    sb.append("    AND NVL(l.situacao, 'A') = 'A' ");
    sb.append("    AND r.lin_cdgo = ft.lin_cdgo ");
    sb.append("    AND r.ref_cdgo = ft.ref_cdgo ");
    sb.append("    AND ies.codigo = ft.mat_nro ");
    sb.append("    AND c.codigo = ft.codigo ");
    sb.append("    AND c.ativo = 'S' ");
    sb.append("    AND fct_mix_produto(comp.lin_cdgo, comp.ref_cdgo) =  NVL("+f.getMix() + ", fct_mix_produto(comp.lin_cdgo, comp.ref_cdgo)) ");
    sb.append("    AND ftec.lin_cdgo = ft.lin_cdgo ");
    sb.append("    AND ftec.ref_cdgo = ft.ref_cdgo ");
    sb.append("    AND comp.lin_cdgo(+) = ftec.lin_cdgo ");
    sb.append("    AND comp.ref_cdgo(+) = ftec.ref_cdgo ");
    sb.append("    AND comp.cab_cdgo(+) = ftec.cab_cdgo ");
    sb.append("    AND comp.fil_filial(+) = ftec.fil_filial ");
    sb.append("    AND comp.fit_versao(+) = ftec.fit_versao ");
    sb.append("    AND comp.cod_peca(+) = 100 ");
    sb.append("    AND pc.lin_cdgo(+) = ft.lin_cdgo ");
    sb.append("    AND pc.ref_cdgo(+) = ft.ref_cdgo ");
    sb.append("    AND pc.codigo_corrug(+) = ft.codigo ");
    sb.append("    AND pc.ativo(+) = 'A' ");
    sb.append("    AND ftec.lin_cdgo = "+f.getLin_cdgo());
    sb.append("    AND ftec.ref_cdgo between "+ f.getRef_cdgo_inicial() + " and "+ f.getRef_cdgo_final() + " ");

    if (f.getCodigo_corrugado() != "") {
      sb.append(" AND ft.codigo = "+f.getCodigo_corrugado());
    }

    sb.append("    AND rc.lin_cdgo = ftec.lin_cdgo ");
    sb.append("    AND rc.ref_cdgo = ftec.ref_cdgo ");
    sb.append("    AND rc.cab_cdgo = ftec.cab_cdgo ");
    sb.append("    AND ccmp.cor_ref = rc.cor_cdgo ");
    sb.append("    AND ccmp.cab_cdgo = rc.cab_cdgo ");
    sb.append("    AND ccmp.ref_cdgo = rc.ref_cdgo ");
    sb.append("    AND ccmp.lin_cdgo = rc.lin_cdgo ");
    sb.append("    AND EXISTS (SELECT 1 ");
    sb.append("                  FROM rep re ");
    sb.append("                     , representante_marca rm ");
    sb.append("                     , cli cl ");
    sb.append("                     , cliente_representante cr ");
    sb.append("                 WHERE re.rep_cdgo = rm.codigo_representante ");
    sb.append("                   AND cr.codigo_representante = re.rep_cdgo ");
    sb.append("                   AND cr.codigo_cliente = cl.cli_cdgo ");
    sb.append("                   AND re.rep_situ = 'A' ");
    sb.append("                   AND rm.situacao = 'A' ");
    sb.append("                   AND cr.situacao = 'A' ");
    sb.append(parametros);
    sb.append("                   AND fct_marca_produto(ftec.lin_cdgo,ftec.ref_cdgo) = rm.marca_produto ) ");


    sb.append("  ORDER BY ftec.lin_cdgo ");
    sb.append("         , l.lin_nome ");
    sb.append("         , ftec.ref_cdgo ");


    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      throw new Exception(sb.toString());
    }

    Vector res_Jw_ficha_embalagem = j.select(table, sb.toString(), null);
    session.setAttribute("res_Jw_ficha_embalagem",res_Jw_ficha_embalagem);
    if (!(res_Jw_ficha_embalagem != null && res_Jw_ficha_embalagem.size() > 0)) {
      throw new Exception("Nenhum registro encontrado!");
    }
    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      FichaEmbalagemActionForm f = (FichaEmbalagemActionForm) form;
      session.removeAttribute("res_Jw_ficha_embalagem");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ficha_embalagem", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
