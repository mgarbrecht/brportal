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
 * Creation Date 08/06/2015 16:03:13
 * Last Modify Date 22/06/2015 13:35:10
 */

public class DiarioCombinacaoEspecialAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DiarioCombinacaoEspecialActionForm f = (DiarioCombinacaoEspecialActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = new ActionForward("/com/DiarioCombinacaoEspecial_rForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_combinacao_especial", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    DiarioCombinacaoEspecialActionForm f = (DiarioCombinacaoEspecialActionForm) form;
    Jw_ref_combinacao_especial table = new Jw_ref_combinacao_especial();
    StringBuilder sb = new StringBuilder();

    sb.append("  SELECT rce.id_solicitacao ");
    sb.append("       , rce.usuario_solicitacao ");
    sb.append("       , rce.data_solicitacao ");
    sb.append("       , rce.codigo_marca ");
    sb.append("       , pck_marcas_produtos.get_nome(rce.codigo_marca) nome_marca ");
    sb.append("       , rce.nova_combinacao ");
    sb.append("       , rce.alteracao_modelo ");
    sb.append("       , rce.amostra ");
    sb.append("       , rce.data_entrega_prevista ");
    sb.append("       , rce.data_entrega_solicitada ");
    sb.append("       , rce.data_entrega_amostra ");
    sb.append("       , rce.lin_cdgo ");
    sb.append("       , pck_linha.get_nome(rce.lin_cdgo) lin_nome ");
    sb.append("       , rce.ref_cdgo ");
    sb.append("       , pck_referencia.get_nome(rce.lin_cdgo, rce.ref_cdgo) ref_desc ");
    sb.append("       , rce.cab_cdgo ");
    sb.append("       , pck_cabedal.get_nome(rce.cab_cdgo) cab_desc ");
    sb.append("       , rce.cor_cdgo ");
    sb.append("       , pck_cor.get_nome(rce.cor_cdgo) cor_desc ");
    sb.append("       , rce.observacao ");
    sb.append("       , rce.material_cor1 ");
    sb.append("       , rce.material_cor2 ");
    sb.append("       , rce.material_cor3 ");
    sb.append("       , rce.biqueira_debrum ");
    sb.append("       , rce.capa_palmilha ");
    sb.append("       , rce.cacharel ");
    sb.append("       , rce.forro ");
    sb.append("       , rce.metais ");
    sb.append("       , rce.taloneira ");
    sb.append("       , rce.salto ");
    sb.append("       , rce.enfeite ");
    sb.append("       , rce.carimbo_etiqueta ");
    sb.append("       , rce.cli_cdgo ");
    sb.append("       , pck_cliente.get_nome(rce.cli_cdgo) cli_rzao ");
    sb.append("       , rce.gre_grupo ");
    sb.append("       , pck_grupo_economico.get_nome(rce.gre_grupo) gre_descricao  ");
    sb.append("       , rce.prs_negociacao ");
    sb.append("       , rce.pares_linha ");
    sb.append("       , rce.pares_alteracao ");
    sb.append("       , rce.preco_liguido ");
    sb.append("       , rce.ll_alteracao_solicitada ");
    sb.append("       , rce.situacao_solicitacao ");
    sb.append("       , decode(rce.situacao_solicitacao, 'A','Aprovada','P','Pendente','R','Reprovada','E','Em Aprovação','') situacao_solicitacao_desc ");
    sb.append("       , rce.data_aceite ");
    sb.append("       , rce.usuario_aceite ");
    sb.append("       , rce.imagem_produto ");
    sb.append("       , decode(rce.gre_grupo,null,(rce.cli_cdgo||' - '||pck_cliente.get_nome(rce.cli_cdgo) ),rce.gre_grupo || ' - ' || pck_grupo_economico.get_nome(rce.gre_grupo) || ' (<small>' || replace(rowtocol('SELECT cli_Cdgo FROM grupo_economico ge WHERE ge.gre_grupo = '||rce.gre_grupo||' AND status = ''A'''),',',', ') || '</small>)') cliente_grupo_economico    ");
    sb.append("       , rce.desenvolvimento ");
    sb.append("       , rce.data_desenvolvimento ");
    sb.append("       , rce.fora_mix ");
    sb.append("       , rce.data_fora_mix ");
    sb.append("       , rce.manipulacao ");
    sb.append("       , rce.data_manipulacao ");
    sb.append("       , rce.modelo_exclusivo ");
    sb.append("       , rce.tipo_solicitacao_comb_especial ");
    sb.append("       , cgr.rv_meaning desc_solicitacao_comb_especial ");
    sb.append("       , rce.descricao ");
    sb.append("       , rce.valor_fabricacao ");
    sb.append("       , rce.valor_pdv ");
    sb.append("       , rce.ll_0 ");
    sb.append("       , rce.ll_1 ");
    sb.append("       , rce.ll_2 ");
    sb.append("       , rce.ll_3 ");
    sb.append("       , rce.preco_vendor ");
    sb.append("    FROM brio.ref_combinacao_especial rce ");
    sb.append("       , cg_ref_codes                 cgr ");
    sb.append("  WHERE cgr.rv_domain(+) = 'TIPO_SOLICITACAO_COMB_ESPECIAL' ");
    sb.append("    AND cgr.rv_low_value(+) = rce.tipo_solicitacao_comb_especial ");

    if (f.getId_solicitacao() != "") {
      sb.append(" AND id_solicitacao = " + f.getId_solicitacao());
    }
    if (f.getCli_cdgo() != "") {
      sb.append(" AND cli_cdgo = " + f.getCli_cdgo());
    }
    if (f.getCodigo_marca() != "") {
      sb.append(" AND codigo_marca = " + f.getCodigo_marca());
    }
    if (f.getLin_cdgo() != "") {
      sb.append(" AND rce.lin_cdgo = " + f.getLin_cdgo());
    }
    if (f.getGre_grupo() != "") {
      sb.append(" AND gre_grupo = " + f.getGre_grupo());
    }
    if (f.getData_solicitacao() != "") {
      sb.append(" AND trunc(data_solicitacao) >= to_date('"+f.getData_solicitacao() + "','dd/mm/yyyy') ");
    }
    if (f.getData_solicitacao_final() != "") {
      sb.append(" AND trunc(data_solicitacao) <= to_date('"+f.getData_solicitacao_final() + "','dd/mm/yyyy') ");
    }
    if (f.getSituacao_solicitacao() != "") {
      sb.append(" AND situacao_solicitacao = '" + f.getSituacao_solicitacao() + "'");
    }

    if (f.getTipo_solicitacao() != "") {
      sb.append(" AND tipo_solicitacao_comb_especial = '"+f.getTipo_solicitacao() + "' ");
    }

    sb.append("   ORDER BY id_solicitacao DESC ");

    session.setAttribute("where", sb.toString());


    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      throw new Exception(sb.toString());
    }

    Vector res_Jw_ref_combinacao_especial = j.select(table, sb.toString(), null);
    session.setAttribute("res_Jw_ref_combinacao_especial",res_Jw_ref_combinacao_especial);
    if (!(res_Jw_ref_combinacao_especial != null && res_Jw_ref_combinacao_especial.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_combinacao_especial", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      if (true) {
        throw new Exception("Nenhum registro encontrado!");
      }
    }
    session.setAttribute("mapping.getName()", form);
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      DiarioCombinacaoEspecialActionForm f = (DiarioCombinacaoEspecialActionForm) form;
      session.removeAttribute("res_Jw_ref_combinacao_especial");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_combinacao_especial", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DiarioCombinacaoEspecialActionForm f = (DiarioCombinacaoEspecialActionForm) form;


      actionForward = new ActionForward("/com/DiarioCombinacaoEspecial_iForm.do?resetfull_action=",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_combinacao_especial", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  public ActionForward perform_select2_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DiarioCombinacaoEspecialActionForm f = (DiarioCombinacaoEspecialActionForm) form;
      select2_action(j, mapping, form, request, response);
      if (session.getAttribute("where") != null) {
        actionForward = new ActionForward("/com/DiarioCombinacaoEspecial_rForm.jsp", true);
      } else {
        actionForward = new ActionForward("/com/DiarioCombinacaoEspecialForm.jsp", true);
      }
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_combinacao_especial", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void select2_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    DiarioCombinacaoEspecialActionForm f = (DiarioCombinacaoEspecialActionForm) form;
    if (session.getAttribute("where") != null) {
      Jw_ref_combinacao_especial table = new Jw_ref_combinacao_especial();
      Vector res_Jw_ref_combinacao_especial = j.select(table, (String) session.getAttribute("where"), null);
      session.setAttribute("res_Jw_ref_combinacao_especial",res_Jw_ref_combinacao_especial);
      if (res_Jw_ref_combinacao_especial != null && res_Jw_ref_combinacao_especial.size() > 0) {
        Jw_ref_combinacao_especial r = (Jw_ref_combinacao_especial) res_Jw_ref_combinacao_especial.elementAt(0);
      } else {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_combinacao_especial", new ActionMessage("warn.norowsselected",""));
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      }
    }
    session.setAttribute(mapping.getName(), form);
  }
  public ActionForward perform_gerar_relatorio_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      DiarioCombinacaoEspecialActionForm f = (DiarioCombinacaoEspecialActionForm) form;
      StringBuilder sb = new StringBuilder();
      acesso.Sessao sessao = new acesso.Sessao(session);
      //--------------------------------------------------------------------------
      util.file.GeraPDF g = new util.file.GeraPDF(request);
      g.setRelatorio("DiarioCombinacaoEspecialListagem.jasper");
      if (f.getId_solicitacao() != "") {
        sb.append(" AND id_solicitacao = " + f.getId_solicitacao());
      }
      if (f.getCli_cdgo() != "") {
        sb.append(" AND cli_cdgo = " + f.getCli_cdgo());
      }
      if (f.getCodigo_marca() != "") {
        sb.append(" AND codigo_marca = " + f.getCodigo_marca());
      }
      if (f.getGre_grupo() != "") {
        sb.append(" AND gre_grupo = " + f.getGre_grupo());
      }
      if (f.getData_solicitacao() != "") {
        sb.append(" AND trunc(data_solicitacao) >= to_date('"+f.getData_solicitacao() + "','dd/mm/yyyy') ");
      }
      if (f.getData_solicitacao_final() != "") {
        sb.append(" AND trunc(data_solicitacao) <= to_date('"+f.getData_solicitacao_final() + "','dd/mm/yyyy') ");
      }
      if (f.getSituacao_solicitacao() != "") {
        sb.append(" AND situacao_solicitacao = '" + f.getSituacao_solicitacao() + "'");
      }
      if (f.getTipo_solicitacao() != "") {
        sb.append(" AND tipo_solicitacao_comb_especial = '" + f.getTipo_solicitacao() + "'");
      }

      g.setParametro("P_QUERY", sb.toString());

      g.gerar();
      //--------------------------------------------------------------------------

      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_combinacao_especial", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
}
