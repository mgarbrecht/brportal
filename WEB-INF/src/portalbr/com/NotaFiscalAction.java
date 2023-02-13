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
 * Creation Date 10/03/2006 09:42:00
 * Last Modify Date 02/10/2019 10:46:58
 */

public class NotaFiscalAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //-------------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 10/03/2006
    // Objetivo          : Executa uma consulta na view portalbr.dbobj.view.Jw_consulta_nf
    //-------------------------------------------------------------------------------------------
    // Data de Alteração :
    // Descrição         :
    //-------------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_nf", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    NotaFiscalActionForm f = (NotaFiscalActionForm) form;
    //----------------------------------------------------------
    String codigo_regional = "null";
    String codigo_representante = "null";
    String codigo_analista = "";
    String tipo = "";
    String cliente = "null";
    acesso.Usuario u = new acesso.Usuario();
    u = (acesso.Usuario) session.getAttribute("User");
    acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
    acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();
    if (!(u.getEntidadeNegocio() == null)) {
      ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
      tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
      tipo = tipoent.getTipo() + "";
      if (tipo.equals("REGIONAL DE VENDA")) {
        codigo_regional = ent.getChave() + "";
      }
      if ((tipo.equals("REPRESENTANTE COMERCIAL")) || (tipo.equals("REPRESENTANTE EXPORTACAO"))) {
        codigo_representante = ent.getChave() + "";
      }
      if (tipo.equals("ANALISTA REGIONAL")) {
        codigo_analista = ent.getChave() + "";
      }
      if (tipo.equals("CLIENTE MERCADO EXTERNO")) {
        cliente = ent.getChave() + "";
      }
      if (tipo.equals("CLIENTE MERCADO INTERNO")) {
        cliente = ent.getChave() + "";
      }
    }

    if (tipo.equals("ANALISTA REGIONAL")) {
      com.egen.util.jdbc.JdbcUtil ja = null;
      try {
        ja = new com.egen.util.jdbc.JdbcUtil();
        portalbr.dbobj.view.Jw_regional_analista tablea = new portalbr.dbobj.view.Jw_regional_analista();
        String[][] select = null;
        Object[][] where = { {"codigo_gerente","=",codigo_analista} };
        Vector res_Jw_regional_analista = ja.select(tablea, select, where, null, null, null);
        if (res_Jw_regional_analista != null && res_Jw_regional_analista.size() > 0) {
          portalbr.dbobj.view.Jw_regional_analista r = (portalbr.dbobj.view.Jw_regional_analista) res_Jw_regional_analista.elementAt(0);
          codigo_regional = r.getCodigo_regional();
        }
      }
      finally {
        if (ja != null) {
          ja.close();
          ja = null;
        }
      }
    }
    //----------------------------------------------------------

    portalbr.dbobj.view.Jw_consulta_nf table = new portalbr.dbobj.view.Jw_consulta_nf();
    StringBuilder query = new StringBuilder();
    query.append(" SELECT nfs_nmro||' - '||nfs_serie nmro_serie ");
    query.append("      , nf.emp_empresa||' - '||emp.emp_razsoc empresa ");
    query.append("      , nf.fil_filial||' - '||fil.fil_razsoc filial ");
    query.append("      , nf.cli_cdgo||'-'||nf.esc_seqn||' - '||cli.cli_rzao cliente ");
    query.append("      , stat_codigo||' - '||s.descricao status ");
    query.append("      , nfs_dtemis data_emissao ");
    query.append("      , nvl(nfs_vltot,0) valor_total ");
    query.append("      , ped_nmro requisicao ");
    query.append("      , nf.rep_cdgo||' - '||r.rep_rzao rep ");
    query.append("      , nvl(nfs_comissao_representante,0) comissao ");
    query.append("      , nf.tra_cdgo||' - '||tra.tra_rzao transportadora ");
    query.append("      , nvl(nfs_percentual_bonificacao,0) bonif1 ");
    query.append("      , nvl(nfs_percentual_bonificacao2,0) bonif2 ");
    query.append("      , nvl(nfs_descon,0) desc_pont ");
    query.append("      , nvl(nfs_pesbru,0) peso_bruto ");
    query.append("      , nvl(nfs_pesliq,0) peso_liq ");
    query.append("      , nfs_cons cs           ");
    query.append("      , cons.tra_rzao cons_desc ");
    query.append("      , prt_codigo            ");
    query.append("      , nfs_serie             ");
    query.append("      , nfs_icms              ");
    query.append("      , nfs_valicm            ");
    query.append("      , nfs_qtdvol            ");
    query.append("      , nf.chave_nfe          ");
    query.append("      , nf.natoper_codigo     ");
    query.append("      , pck_natureza_operacao.get_nome(nf.natoper_codigo) descricao_natureza_operacao ");
    query.append("   FROM nf_saida nf           ");
    query.append("      , empresas emp          ");
    query.append("      , filial fil            ");
    query.append("      , cli cli               ");
    query.append("      , status s              ");
    query.append("      , rep r                 ");
    query.append("      , tra                   ");
    query.append("      , tra cons              ");
    query.append("  WHERE nf.emp_empresa    = '").append(f.getEmp_empresa()).append("' ");
    query.append("    AND nf.fil_filial     = '").append(f.getFil_filial()).append("' ");
    query.append("    AND nfs_nmro          = ").append(f.getNf_nmro());
    query.append("    AND nfs_serie         = '").append(f.getNf_serie()).append("' ");
    query.append("    AND emp.emp_empresa   = nf.emp_empresa ");
    query.append("    AND fil.fil_filial    = nf.fil_filial ");
    query.append("    AND cli.cli_cdgo      = nf.cli_cdgo ");
    query.append("    AND nf.stat_codigo    = s.codigo ");
    query.append("    AND r.rep_cdgo    (+) = nf.rep_cdgo ");
    query.append("    AND tra.tra_cdgo      = nf.tra_cdgo ");
    query.append("    AND nf.nfs_cons  = cons.tra_cdgo (+) ");

    if (cliente.equals("null")) {
      query.append("    AND nf.cli_cdgo       = nvl("+ cliente + ", nf.cli_cdgo) ");
    } else {
      query.append("    AND ((pck_cliente.get_grupo_economico(nf.cli_cdgo) = pck_cliente.get_grupo_economico("+cliente + ")) OR (nf.cli_cdgo = "+cliente + ")) ");
    }
    if (!codigo_representante.equals("null")) {
      query.append("    AND r.rep_cdgo        = nvl("+ codigo_representante + ", r.rep_cdgo) ");
    }
    if (!codigo_regional.equals("null")) {
      query.append("    AND r.codigo_regional = nvl("+ codigo_regional + ", r.codigo_regional) ");
    }


    if (false) {
      throw new Exception(query.toString());
    }

    Vector res_Jw_consulta_nf = j.select(table, query.toString(), null);


    session.setAttribute("res_Jw_consulta_nf",res_Jw_consulta_nf);
    if (res_Jw_consulta_nf != null && res_Jw_consulta_nf.size() > 0) {
      portalbr.dbobj.view.Jw_consulta_nf r = (portalbr.dbobj.view.Jw_consulta_nf) res_Jw_consulta_nf.elementAt(0);
      f.setNmro_serie((r.getNmro_serie() != null) ? r.getNmro_serie() + "":"");
      f.setEmpresa((r.getEmpresa() != null) ? r.getEmpresa() + "":"");
      f.setFilial((r.getFilial() != null) ? r.getFilial() + "":"");
      f.setCliente((r.getCliente() != null) ? r.getCliente() + "":"");
      f.setStatus((r.getStatus() != null) ? r.getStatus() + "":"");
      f.setData_emissao(com.egen.util.text.FormatDate.format(r.getData_emissao(), "dd/MM/yyyy"));
      f.setValor_total((r.getValor_total() != null) ? r.getValor_total() + "":"");
      f.setValor_total("R$ "+com.egen.util.text.FormatNumber.format(Double.parseDouble(r.getValor_total()), "##,##0.00"));
      f.setRequisicao(com.egen.util.text.FormatNumber.format(r.getRequisicao(), "0"));
      f.setRep((r.getRep() != null) ? r.getRep() + "":"");
      f.setComissao(com.egen.util.text.FormatNumber.format(Double.parseDouble(r.getComissao()), "##,##0.00") + " %");
      f.setTransportadora((r.getTransportadora() != null) ? r.getTransportadora() + "":"");
      f.setBonif1(com.egen.util.text.FormatNumber.format(Double.parseDouble(r.getBonif1()), "##,##0.00") + " %");
      f.setBonif2(com.egen.util.text.FormatNumber.format(Double.parseDouble(r.getBonif2()), "##,##0.00") + " %");
      f.setDesc_pont(com.egen.util.text.FormatNumber.format(Double.parseDouble(r.getDesc_pont()), "##,##0.00") + " %");
      f.setPeso_bruto(com.egen.util.text.FormatNumber.format(r.getPeso_bruto(), "##,##0.00") + " Kg");
      f.setPeso_liq(com.egen.util.text.FormatNumber.format(r.getPeso_liq(), "##,##0.00") + " Kg");
      if (r.getCs() != null) {
        f.setCons_desc(r.getCs() + " - " + r.getCons_desc());
      }
      f.setPrt_codigo((r.getPrt_codigo() != null) ? r.getPrt_codigo() + "":"");
      f.setNfs_serie((r.getNfs_serie() != null) ? r.getNfs_serie() + "":"");
      f.setNfs_icms(com.egen.util.text.FormatNumber.format(r.getNfs_icms(), "##,##0.00") + " %");
      f.setNfs_valicm("R$ "+com.egen.util.text.FormatNumber.format(r.getNfs_valicm(), "##,##0.00"));
      f.setNfs_qtdvol((r.getNfs_qtdvol() != null) ? r.getNfs_qtdvol() + "":"");
      f.setChave_nfe((r.getChave_nfe() != null) ? r.getChave_nfe() + "":"");
      f.setNatoper_codigo((r.getNatoper_codigo() != null) ? r.getNatoper_codigo() + " - " + r.getDescricao_natureza_operacao() : "");

    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_nf", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute(mapping.getName(), form);
  }
}
