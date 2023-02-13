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
 * Creation Date 02/09/2015 11:15:00
 * Last Modify Date 19/07/2022 10:09:11
 */

public class ArquivosTalaoAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ArquivosTalaoActionForm f = (ArquivosTalaoActionForm) form;
      select_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/com/ArquivosTalao_rGrid.do?select_action=",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_arquivos_talao", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    ArquivosTalaoActionForm f = (ArquivosTalaoActionForm) form;
    boolean informouParametro = false;
    if (f.getData_compra_inicial().equals("__/__/____")) {
      f.setData_compra_inicial("");
    }
    if (f.getData_compra_final().equals("__/__/____")) {
      f.setData_compra_final("");
    }

    session.removeAttribute("arquivos_talao_ordenacao");
    session.removeAttribute("arquivos_talao_filtro_fornecedor");
    session.removeAttribute("arquivos_talao_filtro_filial");
    session.removeAttribute("arquivos_talao_filtro_situacao");
    session.removeAttribute("arquivos_talao_filtro_ordem_compra");
    session.removeAttribute("arquivos_talao_filtro_remessa");
    session.removeAttribute("arquivos_talao_filtro_datas");
    session.removeAttribute("arquivos_talao_filtro_materiais");
    session.removeAttribute("arquivos_talao_filtro_espacamento");

    if (session.getAttribute("codigo_materiais") != null) {
      session.setAttribute("arquivos_talao_filtro_materiais", (String) session.getAttribute("codigo_materiais"));
    }

    session.setAttribute("arquivos_talao_filtro_espacamento", f.getEspacamento());

    Jw_arquivos_talao table = new Jw_arquivos_talao();
    StringBuilder sbParametros = new StringBuilder();
    if (f.getForn_codigo() != "") {
      session.setAttribute("arquivos_talao_filtro_fornecedor", f.getForn_codigo());
      sbParametros.append(" AND forn_codigo = " + f.getForn_codigo());
    }
    if (f.getFil_filial() != "") {
      session.setAttribute("arquivos_talao_filtro_filial", f.getFil_filial());
      sbParametros.append(" AND fil_filial = '"+f.getFil_filial() + "' ");
    }

    String descricaoSituacao = "";
    if (f.getSituacao().equalsIgnoreCase("T")) {
      descricaoSituacao = "Todas";
    } else if (f.getSituacao().equalsIgnoreCase("C")) {
      descricaoSituacao = "Consultado";
    } else if (f.getSituacao().equalsIgnoreCase("G")) {
      descricaoSituacao = "Gerado";
    } else if (f.getSituacao().equalsIgnoreCase("V")) {
      descricaoSituacao = "Visualizado";
    } else if (f.getSituacao().equalsIgnoreCase("P")) {
      descricaoSituacao = "Publicado";
    } else if (f.getSituacao().equalsIgnoreCase("P")) {
      descricaoSituacao = "Não Visualizado";
    }
    session.setAttribute("arquivos_talao_filtro_situacao", descricaoSituacao);

    if (!f.getSituacao().equalsIgnoreCase("T")) {
      if (f.getSituacao().equalsIgnoreCase("NV")) {
        sbParametros.append(" AND nvl(situacao,'C') <> 'V' ");
      } else {
        sbParametros.append(" AND nvl(situacao,'C') = '"+f.getSituacao() + "' ");
      }
    }
    if (f.getOco_numero() != "") {
      session.setAttribute("arquivos_talao_filtro_ordem_compra", f.getOco_numero());
      informouParametro = true;
      sbParametros.append(" AND oco_numero = " + f.getOco_numero());
    }
    if (f.getRem_nro() != "") {
      informouParametro = true;
      session.setAttribute("arquivos_talao_filtro_remessa", f.getRem_nro());
      sbParametros.append(" AND rem_nro = " + f.getRem_nro());
    }
    if (f.getData_compra_inicial() != "" && f.getData_compra_inicial() != "") {
      session.setAttribute("arquivos_talao_filtro_datas", f.getData_compra_inicial() + " a "+f.getData_compra_final());
      informouParametro = true;
      util.consultas.Query query = new util.consultas.Query();
      String foraPeriodo = query.retorna(j, "SELECT CASEH WHEN MONTHS_BETWEEN(to_date('"+f.getData_compra_final() + "','dd/mm/yyyy'), to_date('"+f.getData_compra_inicial() + "','dd/mm/yyyy'))>3 then 'S' else 'N' end data_fora_periodo FROM dual");
      if (foraPeriodo.equalsIgnoreCase("S")) {
        throw new Exception("O intervalo de entrada não pode ser maior que 3 meses!");
      }
      sbParametros.append(" AND data_compra between to_date('"+f.getData_compra_inicial() + "','dd/mm/yyyy') AND to_date('"+f.getData_compra_final() + "','dd/mm/yyyy') ");
    }
    if (f.getLin_cdgo() != "") {
      sbParametros.append(" AND lin_cdgo = " + f.getLin_cdgo());
    }

    if (!informouParametro) {
      throw new Exception("Um dos campos com <img src='../img/opcional.gif' border='0'/> deve ser informado!");
    }
    StringBuilder sb = new StringBuilder();
    sb.append(" SELECT forn_codigo ");
    sb.append("      , interface_arq_compra_id ");
    sb.append("      , oco_numero ");
    sb.append("      , rem_nro ");
    sb.append("      , fil_filial ");
    sb.append("      , arquivo_edi ");
    sb.append("      , nvl(situacao,'C') situacao ");
    sb.append("      , descricao_situacao ");
    sb.append("      , forn_razsoc ");
    sb.append("      , data_compra ");
    sb.append("      , lin_cdgo ");
    sb.append("      , lin_nome ");
    sb.append("   FROM (SELECT /*+ all_rows */ ");
    sb.append("         DISTINCT iac.for_codigo forn_codigo ");
    sb.append("               , iat.interface_arq_compra_id ");
    sb.append("               , iat.oco_numero ");
    sb.append("               , iat.rem_nro ");
    sb.append("               , iat.fil_filial ");
    sb.append("               , iac.nome_arquivo arquivo_edi ");
    sb.append("         ,(SELECT situacao ");
    sb.append("                            FROM (SELECT situacao ");
    sb.append("                                    FROM edi.interface_arq_compra_tal_log i ");
    sb.append("                                   where i.interface_arq_compra_id = iat.interface_arq_compra_id ");
    sb.append("                                     and i.oco_numero = iat.oco_numero ");
    sb.append("                                     and i.rem_nro = iat.rem_nro ");
    sb.append("                                   ORDER BY DECODE(situacao, 'P', 1, 'C', 2, 'G', 3, 'V', 4) DESC) ");
    sb.append("                           WHERE rownum = 1) situacao ");
    sb.append("               , DECODE(iat.situacao, 'P', 'Publicado', 'C', 'Consultado', 'B', 'Baixado', 'G','Gerado','V','Visualizado','') descricao_situacao ");
    sb.append("               , pck_fornecedor.get_nome(iac.for_codigo) forn_razsoc ");
    sb.append("               , iaco.data_compra ");
    sb.append("               , iat.lin_cdgo ");
    sb.append("               , iat.lin_nome ");
    sb.append("  FROM interface_arq_compra_tal iat ");
    sb.append("     , interface_arq_compra     iac ");
    sb.append("     , interface_arq_compra_oc iaco ");
    sb.append("     , dom_ordem_compra doc ");
    sb.append(" WHERE iac.interface_arq_compra_id = iat.interface_arq_compra_id ");
    sb.append("   AND iaco.oco_numero = iat.oco_numero ");
    sb.append("   AND doc.numero = iaco.oco_numero ");
    if (session.getAttribute("codigo_materiais") != null) {
      sb.append(" AND EXISTS (SELECT 1 ");
      sb.append("               FROM interface_arq_compra_tal_mat itm ");
      sb.append("              WHERE iat.interface_arq_compra_id = itm.interface_arq_compra_id ");
      sb.append("                AND itm.cod_peca IN ("+(String) session.getAttribute("codigo_materiais") + ") ");
      sb.append("                AND iat.rem_nro = itm.rem_nro ");
      sb.append("                AND iat.tal_nro = itm.tal_nro) ");
    }
    sb.append("   AND doc.situacao <> 9 ");
    sb.append("   AND iac.ativo = 'S' ");
    sb.append("   AND iac.tipo = 'T' ");
    sb.append(" ) ");
    sb.append(" WHERE 1=1 ");
    sb.append(sbParametros.toString());
    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      throw new Exception(sb.toString());
    }
    session.setAttribute("where", sb.toString());
    if (f.getOrdenacao().equals("1")) {
      StringBuilder sbo = new StringBuilder();
      sbo.append(" ORDER BY it.rem_nro ");
      sbo.append("        , it.tal_nro ");
      sbo.append("        , ies_codigo ");
      sbo.append("        , cor_cdgo ");
      session.setAttribute("arquivos_talao_ordenacao", sbo.toString());
    } else if (f.getOrdenacao().equals("2")) {
      StringBuilder sbo = new StringBuilder();
      sbo.append(" ORDER BY ies_codigo ");
      sbo.append("        , cor_cdgo ");
      sbo.append("        , it.rem_nro ");
      sbo.append("        , it.tal_nro ");
      session.setAttribute("arquivos_talao_ordenacao", sbo.toString());
    }
    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ArquivosTalaoActionForm f = (ArquivosTalaoActionForm) form;
      session.removeAttribute("res_Jw_arquivos_talao");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_arquivos_talao", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_refresh_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ArquivosTalaoActionForm f = (ArquivosTalaoActionForm) form;
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_arquivos_talao", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_limpar_materiais_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ArquivosTalaoActionForm f = (ArquivosTalaoActionForm) form;
      session.removeAttribute("materiais");
      session.removeAttribute("codigo_materiais");
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_arquivos_talao", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
}
