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
 * Creation Date 18/08/2015 07:41:41
 * Last Modify Date 14/10/2022 15:58:28
 */

public class DownloadImagensAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DownloadImagensActionForm f = (DownloadImagensActionForm) form;
      select_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/com/DownloadImagens_rGrid.do?select_action=", true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_cat_produtos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    DownloadImagensActionForm f = (DownloadImagensActionForm) form;
    boolean consultaPedidos = false;
    boolean consultaLotes = false;
    boolean consultaGrupo = false;
    boolean informouDatas = false;
    boolean isDespachante = false;
    String anoFatura = null;
    String numeroFatura = null;
    String despachante = "";
    String representante = null;
    session.removeAttribute("download_imagens_tamanho_imagem");
    acesso.Sessao sessao = new acesso.Sessao(session);
    String faturaAmostra = "N";
    util.consultas.Query query = new util.consultas.Query();
    if (sessao.getTipoEntidadeNegocio().equals("DESPACHANTE")) {
      despachante = sessao.getChave();
      isDespachante = true;
    }
    if (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL") || sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO")) {
      representante = sessao.getChave();
    }

    session.setAttribute("download_imagens_tamanho_imagem", f.getTamanho_imagens());
    StringBuilder sbQuery = new StringBuilder();
    StringBuilder sbParametros = new StringBuilder();
    if (f.getDt_inicial().equals("__/__/____")) {
      f.setDt_inicial("");
    }
    if (f.getDt_final().equals("__/__/____")) {
      f.setDt_final("");
    }
    if (f.getLin_cdgo().equals("") && f.getOc().equals("") && f.getLotes().equals("") && f.getInvoice().equals("") && f.getPedido().equals("") && f.getCli_cdgo().equals("") && f.getGre_grupo().equals("") && f.getDt_inicial().equals("") && f.getDt_final().equals("") && f.getMarca().equals("")) {
      throw new Exception("Um dos campos com <img src='../img/opcional.gif' border='0'/> deve ser informado!");
    }


    if (f.getLin_cdgo().equals("") && f.getOc().equals("") && f.getInvoice().equals("") && f.getPedido().equals("") && f.getGre_grupo().equals("") && f.getCli_cdgo().equals("")) {
      if (f.getDt_inicial() != "" && f.getDt_final() != "") {
        throw new Exception("O cliente ou o grupo econômico deve ser informado!");
      }
    }

    if (representante != null) {
      consultaPedidos = true;
      sbParametros.append(" AND p.rep_cdgo = '"+representante + "' ");
    }


    if (f.getGre_grupo() != "" && f.getCli_cdgo().equals("")) {
      consultaPedidos = true;
      consultaGrupo = true;
      sbParametros.append(" AND ge.gre_grupo = " + f.getGre_grupo());
      sbParametros.append(" AND ge.status = 'A' ");
      sbParametros.append(" AND ge.cli_cdgo = p.cli_cdgo ");
      if (f.getDt_inicial() != "") {
        informouDatas = true;
        sbParametros.append(" AND p.ped_dadg >= to_date('"+f.getDt_inicial() + "', 'dd/mm/yyyy') ");
      }
      if (f.getDt_final() != "") {
        informouDatas = true;
        sbParametros.append(" AND p.ped_dadg < to_date('"+f.getDt_final() + "', 'dd/mm/yyyy') + 1 ");
      }

    }

    if (f.getCli_cdgo() != "") {
      consultaPedidos = true;
      if (f.getDt_inicial() != "") {
        informouDatas = true;
        sbParametros.append(" AND p.ped_dadg >= to_date('"+f.getDt_inicial() + "', 'dd/mm/yyyy') ");
      }
      if (f.getDt_final() != "") {
        informouDatas = true;
        sbParametros.append(" AND p.ped_dadg < to_date('"+f.getDt_final() + "', 'dd/mm/yyyy') + 1 ");
      }
      if (informouDatas) {
        sbParametros.append(" AND nvl(p.cli_cdgo,null) = " + f.getCli_cdgo());
      } else {
        sbParametros.append(" AND p.cli_cdgo = " + f.getCli_cdgo());
      }
    }

    if (f.getMarca() != "") {
      if (consultaPedidos) {
        sbParametros.append(" AND nvl(mp.codigo_marca,null) = " + f.getMarca());
      } else {
        sbParametros.append(" AND mp.codigo_marca = " + f.getMarca());
      }
    }

    if (f.getLin_cdgo() != "") {
      if (consultaPedidos) {
        sbParametros.append(" AND nvl(rc.lin_cdgo,null) = " + f.getLin_cdgo());
      } else {
        sbParametros.append(" AND rc.lin_cdgo = " + f.getLin_cdgo());
      }
    }

    if (f.getRef_cdgo() != "") {
      if (consultaPedidos) {
        sbParametros.append(" AND nvl(rc.ref_cdgo,null) = " + f.getRef_cdgo());
      } else {
        sbParametros.append(" AND rc.ref_cdgo = " + f.getRef_cdgo());
      }
    }

    if (f.getCab_cdgo() != "") {
      if (consultaPedidos) {
        sbParametros.append(" AND nvl(rc.cab_cdgo,null) = " + f.getCab_cdgo());
      } else {
        sbParametros.append(" AND rc.cab_cdgo = " + f.getCab_cdgo());
      }
    }

    if (f.getCor_cdgo() != "") {
      if (consultaPedidos) {
        sbParametros.append(" AND nvl(rc.cor_cdgo,null) = " + f.getCor_cdgo());
      } else {
        sbParametros.append(" AND rc.cor_cdgo = " + f.getCor_cdgo());
      }
    }

    if (f.getLotes() != "") {
      String lotes = f.getLotes().replaceAll("[^0-9]", " ").trim();
      lotes = lotes.replaceAll("\\s+", " ");
      lotes = lotes.replaceAll(" ", "\n");
      lotes = lotes.replaceAll("\\r\\n|\\r|\\n", ",");
      if ((lotes.charAt(lotes.length() - 1) + "").equalsIgnoreCase(",")) {
        lotes = lotes.substring(0, lotes.lastIndexOf(","));
      }
      sbParametros.append(" AND lei.id_lote in (" + lotes + ")");
      consultaLotes = true;
    }

    if (f.getPedido() != "") {
      String pedidos = f.getPedido().replaceAll("[^0-9]", " ").trim();
      pedidos = pedidos.replaceAll("\\s+", " ");
      pedidos = pedidos.replaceAll(" ", "\n");
      pedidos = pedidos.replaceAll("\\r\\n|\\r|\\n", ",");
      if ((pedidos.charAt(pedidos.length() - 1) + "").equalsIgnoreCase(",")) {
        pedidos = pedidos.substring(0, pedidos.lastIndexOf(","));
      }
      sbParametros.append(" AND p.ped_nmro in (" + pedidos + ")");
      consultaPedidos = true;
    }

    if (f.getInvoice() != "") {
      String[] fatura = f.getInvoice().split("/");
      try {
        numeroFatura = fatura[0];
        anoFatura = fatura[1];
        StringBuilder sbf = new StringBuilder();
        sbf.append(" SELECT especie_fatura ");
        sbf.append("   FROM faturas_proformas fp ");
        sbf.append("  WHERE fp.empresa_fatura_proforma = '01' ");
        sbf.append("    AND fp.ano_fatura_proforma = " + anoFatura);
        sbf.append("    AND fp.numero_fatura_proforma = " + numeroFatura);
        faturaAmostra = query.retorna(j, sbf.toString());
      } catch (Exception e) {
      }
      sbParametros.append(" AND p.ped_invoice = '" + f.getInvoice().toUpperCase() + "'");
      consultaPedidos = true;
    }

    if (f.getOc() != "") {
      sbParametros.append(" AND p.ped_ped_cliente = '" + f.getOc().toUpperCase() + "'");
      consultaPedidos = true;
    }

    if (consultaPedidos) {
      if (session.getAttribute("consulta_pedidos_status_pedido") != null) {
        String situacaos = (String) session.getAttribute("consulta_pedidos_status_pedido");
        sbParametros.append(" AND (p.ped_nmro <0 ");
        if (situacaos.indexOf("A") != -1) {
          sbParametros.append(" OR (p.ped_stat = 'A' or (p.ped_stat = 'L' and i.ite_situ = '5')) ");
        }
        if (situacaos.indexOf("F") != -1) {
          sbParametros.append(" OR (p.ped_stat in ('F')) ");
        }
        if (situacaos.indexOf("B") != -1) {
          sbParametros.append(" OR (p.ped_stat in ('P','B','T')) ");
        }
        if (situacaos.indexOf("C") != -1) {
          sbParametros.append(" OR (p.ped_stat in ('C')) ");
        }
        sbParametros.append(" ) ");
      }

      if (session.getAttribute("consulta_pedidos_situacao_pedido") != null) {
        sbParametros.append(" AND nvl(i.ite_situ,null) in ("+(String) session.getAttribute("consulta_pedidos_situacao_pedido") + ") ");
      }
    }

    sbQuery.append(" SELECT DISTINCT ");
    sbQuery.append("        mp.codigo_marca marca ");
    sbQuery.append("      , rc.lin_cdgo linha ");
    sbQuery.append("      , rc.ref_cdgo referencia ");
    if (f.getTamanho_imagens().equals("N")) {
      sbQuery.append("      , null cabedal ");
      sbQuery.append("      , null cor ");
    } else {
      sbQuery.append("      , rc.cab_cdgo cabedal ");
      sbQuery.append("      , rc.cor_cdgo cor ");
    }
    if (f.getTamanho_imagens().equals("N")) {
      sbQuery.append("      , replace(cpa.url, 'https://s3-sa-east-1.amazonaws.com/imagens.catalogobeirario.com.br/angulos_produtos/','') imagem ");
    } else {
      sbQuery.append("      , replace(REPLACE(fct_retorna_fit_imagem_comp(rc.lin_cdgo, rc.ref_cdgo, rc.cab_cdgo, rc.cor_cdgo), 'jpg', 'gif'),'default.gif','default.jpg') imagem ");
    }
    sbQuery.append("      , '' venda_exportacao  ");
    sbQuery.append("      , '' categoria_produto  ");
    sbQuery.append("      , '' descricao_categoria_produto  ");
    sbQuery.append("      , '' tipo  ");
    sbQuery.append("      , '' descricao_tipo  ");
    sbQuery.append("      , '' descricao_produto ");
    if (f.getTamanho_imagens().equals("N")) {
      sbQuery.append("      , null descricao_cabedal ");
      sbQuery.append("      , null descricao_cor ");
    } else {
      sbQuery.append("      , ca.cab_desc descricao_cabedal ");
      sbQuery.append("      , co.cor_desc descricao_cor ");
    }
    if (f.getTamanho_imagens().equals("N")) {
      sbQuery.append("   , cpa.sequencial sequencial_angulo ");
    } else {
      sbQuery.append("   , null sequencial_angulo ");
    }
    sbQuery.append("  FROM ref_cor         rc ");
    if (f.getTamanho_imagens().equals("N")) {
      sbQuery.append("   , catalogo_objetos.cat_produtos_angulos_vw cpa ");
    }
    sbQuery.append("     , ref             r ");
    sbQuery.append("     , cabedal         ca ");
    sbQuery.append("     , cor             co ");
    sbQuery.append("     , marcas_produtos mp ");
    if (consultaPedidos && !isDespachante) {
      sbQuery.append("  , ite i ");
      sbQuery.append("  , ped p ");
    }
    if (consultaLotes) {
      sbQuery.append("  , lote_estrategico_item lei ");
    }
    if (isDespachante) {
      sbQuery.append("  , ite i ");
      sbQuery.append("  , ped p ");
      sbQuery.append("  , faturas_proformas fp ");
    }
    if (consultaGrupo) {
      sbQuery.append("  , grupo_economico ge ");
    }
    sbQuery.append(" WHERE r.lin_cdgo = rc.lin_cdgo ");
    sbQuery.append("    AND r.ref_cdgo = rc.ref_cdgo ");
    sbQuery.append("    AND ca.cab_cdgo = rc.cab_cdgo ");
    sbQuery.append("    AND mp.codigo_marca = r.codigo_marca ");
    sbQuery.append("    AND co.cor_cdgo = rc.cor_cdgo ");

    if (consultaLotes) {
      sbQuery.append("    AND lei.lin_cdgo = rc.lin_cdgo  ");
      sbQuery.append("    AND lei.ref_cdgo = rc.ref_cdgo ");
      sbQuery.append("    AND lei.cab_cdgo = rc.cab_cdgo ");
      sbQuery.append("    AND lei.cor_cdgo = rc.cor_cdgo ");
    }

    if (f.getTamanho_imagens().equals("N")) {
      sbQuery.append(" AND cpa.linha = r.lin_cdgo ");
      sbQuery.append(" AND cpa.referencia = r.ref_cdgo ");
      //   sbQuery.append(" AND cpa.cabedal = ca.cab_cdgo ");
      //   sbQuery.append(" AND cpa.cor = co.cor_cdgo ");
    }
    sbQuery.append("    AND fct_retorna_fit_imagem_comp(rc.lin_cdgo, rc.ref_cdgo, rc.cab_cdgo, rc.cor_cdgo) <> 'default.jpg' ");
    if (consultaPedidos && !isDespachante) {
      sbQuery.append("    AND p.ped_nmro = i.ped_nmro ");
      sbQuery.append("    AND i.lin_cdgo = rc.lin_cdgo  ");
      sbQuery.append("    AND i.ref_cdgo = rc.ref_cdgo ");
      sbQuery.append("    AND i.cab_cdgo = rc.cab_cdgo ");
      sbQuery.append("    AND i.cor_cdgo = rc.cor_cdgo ");
    }
    if (isDespachante) {
      sbQuery.append("    AND p.ped_nmro = i.ped_nmro ");
      sbQuery.append("    AND i.lin_cdgo = rc.lin_cdgo");
      sbQuery.append("    AND i.ref_cdgo = rc.ref_cdgo");
      sbQuery.append("    AND i.cab_cdgo = rc.cab_cdgo");
      sbQuery.append("    AND i.cor_cdgo = rc.cor_cdgo");
      sbQuery.append("    AND fp.codigo_pessoa_despachante = " + despachante);
      sbQuery.append("    AND i.empresa_fatura_proforma = fp.empresa_fatura_proforma ");
      sbQuery.append("    AND i.ano_fatura_proforma = fp.ano_fatura_proforma ");
      sbQuery.append("    AND i.numero_fatura_proforma = fp.numero_fatura_proforma ");
      sbQuery.append("    AND p.ped_invoice = LPAD(fp.numero_fatura_proforma, 4, 0) || '/' || fp.ano_fatura_proforma ");
    }
    sbQuery.append(sbParametros.toString());
    sbQuery.append(" ORDER BY marca, linha, referencia, cabedal, cor, sequencial_angulo ");


    if (faturaAmostra.equalsIgnoreCase("A")) {
      sbQuery = new StringBuilder();
      sbQuery.append(" SELECT fct_marca_produto(ifp.codigo_linha, ifp.codigo_referencia) marca ");
      sbQuery.append("      , ifp.codigo_linha linha ");
      sbQuery.append("      , ifp.codigo_referencia referencia ");
      sbQuery.append("      , ifp.codigo_cabedal cabedal ");
      sbQuery.append("      , ifp.codigo_cor cor ");
      sbQuery.append("      , REPLACE(fct_retorna_fit_imagem_comp(ifp.codigo_linha, ifp.codigo_referencia, ifp.codigo_cabedal, ifp.codigo_cor), 'jpg', 'gif') imagem ");
      sbQuery.append("      , '' venda_exportacao ");
      sbQuery.append("      , '' categoria_produto ");
      sbQuery.append("      , '' descricao_categoria_produto ");
      sbQuery.append("      , '' tipo ");
      sbQuery.append("      , '' descricao_tipo ");
      sbQuery.append("      , '' descricao_produto ");
      sbQuery.append("      , pck_cabedal.get_nome(ifp.codigo_cabedal) descricao_cabedal ");
      sbQuery.append("      , pck_cor.get_nome(ifp.codigo_cor) descricao_cor ");
      sbQuery.append("   FROM itens_faturas_proformas ifp ");
      sbQuery.append("      , faturas_proformas fp ");
      sbQuery.append("  WHERE fp.empresa_fatura_proforma = ifp.empresa_fatura_proforma ");
      sbQuery.append("    AND fp.ano_fatura_proforma = ifp.ano_fatura_proforma ");
      sbQuery.append("    AND fp.numero_fatura_proforma = ifp.numero_fatura_proforma ");
      sbQuery.append("    AND fp.empresa_fatura_proforma = '01' ");
      sbQuery.append("    AND fp.ano_fatura_proforma = " + anoFatura);
      sbQuery.append("    AND fp.numero_fatura_proforma = " + numeroFatura);
      if (representante != null) {
        sbQuery.append(" AND fp.codigo_representante = '"+representante + "' ");
      }
      sbQuery.append("    AND fct_retorna_fit_imagem_comp(ifp.codigo_linha, ifp.codigo_referencia, ifp.codigo_cabedal, ifp.codigo_cor) <> 'default.jpg' ");
      sbQuery.append("  ORDER BY marca ");
      sbQuery.append("         , linha ");
      sbQuery.append("         , referencia ");
      sbQuery.append("         , cabedal ");
      sbQuery.append("         , cor ");
    }

    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      throw new Exception(sbQuery.toString());
    }

    session.setAttribute("where", sbQuery.toString());
    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      DownloadImagensActionForm f = (DownloadImagensActionForm) form;
      session.removeAttribute("res_Jw_cat_produtos");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      tg_resetfull_action(mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_cat_produtos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
  private void tg_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      DownloadImagensActionForm f = (DownloadImagensActionForm) form;
      session.removeAttribute("download_imagens_tamanho_imagem");
      session.removeAttribute("consulta_pedidos_situacao_pedido");
      session.removeAttribute("consulta_pedidos_status_pedido");
      session.removeAttribute("res_status_pedido");
      session.removeAttribute("res_situacao_pedido");
      session.removeAttribute("listaImagens");
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    } finally {
    }
  }

  public ActionForward perform_refresh_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      DownloadImagensActionForm f = (DownloadImagensActionForm) form;
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_cat_produtos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_limpar_status_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      DownloadImagensActionForm f = (DownloadImagensActionForm) form;
      session.removeAttribute("consulta_pedidos_status_pedido");
      session.removeAttribute("res_status_pedido");
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_cat_produtos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
  public ActionForward perform_limpar_situacao_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      DownloadImagensActionForm f = (DownloadImagensActionForm) form;
      session.removeAttribute("consulta_pedidos_situacao_pedido");
      session.removeAttribute("res_situacao_pedido");
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_cat_produtos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }

}
