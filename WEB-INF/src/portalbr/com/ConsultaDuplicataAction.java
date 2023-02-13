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
 * Creation Date 10/03/2006 14:18:56
 * Last Modify Date 01/08/2019 15:11:48
 */

public class ConsultaDuplicataAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //-------------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 10/03/2006
    // Objetivo          : Executa uma consulta na view portalbr.dbobj.view.Jw_consulta_duplicata,
    //                     populando os campos na tela.
    //--------------------------------------------------------------------------------------------
    // Data de Alteração :
    // Descrição         :
    //--------------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_duplicata", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    ConsultaDuplicataActionForm f = (ConsultaDuplicataActionForm) form;
    //----------------------------------------------------------
    String codigo_regional = "null";
    String codigo_representante = "null";
    String codigo_analista = "";
    String tipo = "";
    String cliente = "null";
    String tit_numbco = "";
    String link = "";
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


    portalbr.dbobj.view.Jw_consulta_duplicata table = new portalbr.dbobj.view.Jw_consulta_duplicata();

    StringBuilder query = new StringBuilder();
    query.append(" SELECT decode(tit_status, 'A', 'Aberto', 'L', 'Liquidado', 'Cancelado') status ");
    query.append("      , tit_datemi dt_emissao ");
    query.append("      , tit_datvenc dt_venc ");
    query.append("      , t.cli_codigo cli_cdgo ");
    query.append("      , t.esc_seqn esc_seqn ");
    query.append("      , t.cli_codigo ||'-'||t.esc_seqn||' - '||cli_rzao cliente_desc ");
    query.append("      , tit_datrec dt_pagamento ");
    query.append("      , t.tit_dt_emissao_triplicata triplic");
    query.append("      , t.tit_dt_emissao_anuencia anuencia ");
    query.append("      , t.tit_dt_emissao_ins_protesto ins_prot ");
    query.append("      , t.cac_sequencia ||' - '||t.prt_codigo||' - '||c.descricao carteira ");
    query.append("      , prt_descri banc ");
    query.append("      , tit_agecob agencia_cobranca ");
    query.append("      , tit_ageced agencia_cedente ");
    query.append("      , tit_numbco nr_banco ");
    query.append("      , tit_dspont desc_pontualidade ");
    query.append("      , tit_dsante desc_antecipacao ");
    query.append("      , tit_vljuro juros ");
    query.append("      , tit_vlcor correcao ");
    query.append("      , tit_vlrec valor_receb ");
    query.append("      , tit_abatim valor_abatim ");
    query.append("      , tit_vldesc desconto ");
    query.append("      , 0 cartorio ");
    query.append("      , 0 desban ");
    query.append("      , fnc_ctr_saldo_titulo(t.emp_empresa ");
    query.append("                            ,t.fil_filial ");
    query.append("                            ,t.tip_codigo ");
    query.append("                            ,t.tit_codigo ");
    query.append("                            ,t.sit_codigo_situacao_titulo ");
    query.append("                            ,t.tit_vlpcp ");
    query.append("                            ,t.tit_vldeb) saldo ");
    query.append("      , t.emp_empresa || ' - ' ||pck_empresa.get_nome(t.emp_empresa) empresa ");
    query.append("      , t.fil_filial filial ");
    query.append("      , t.tip_codigo tip_codigo ");
    query.append("      , t.tit_codigo titulo ");
    query.append("      , t.rep_codigo rep_codigo ");
    query.append("      , t.tit_dt_receb_protesto rec_prot ");
    query.append("      , tit_valor valor ");
    query.append("      , t.valor_titulo_vencimento - t.tit_valor encargos ");
    query.append("      , t.valor_titulo_vencimento valor_vendor ");
    query.append("      , p.prt_codigo ");
    query.append("      , brio.fct_retorna_vendor(t.cac_sequencia) vendor ");
    query.append("   FROM titulos             t ");
    query.append("      , carteiras_cobranca  c ");
    query.append("      , portadores          p ");
    query.append("      , rep                 r ");
    query.append("      , cli                   ");
    query.append("  WHERE c.sequencia  (+) =  t.cac_sequencia ");
    query.append("    AND p.prt_codigo (+) =  t.prt_codigo ");
    query.append("    AND cli_cdgo         =  t.cli_codigo ");
    query.append("    AND r.rep_cdgo   (+) =  t.rep_codigo ");
    query.append("    AND t.tit_codigo     =  '").append(f.getTitulo()).append("'");
    query.append("    AND t.emp_empresa    = nvl('").append(f.getEmp_empresa()).append("',t.emp_empresa) ");
    query.append("    AND t.fil_filial     = nvl('").append(f.getFil_filial()).append("',t.fil_filial) ");
    query.append("    AND t.tip_codigo     = nvl('").append(f.getTip()).append("', t.tip_codigo) ");

    if (cliente.equals("null")) {
      query.append("    AND t.cli_codigo      = nvl("+ cliente + ", t.cli_codigo) ");
    } else {
      query.append("    AND ((pck_cliente.get_grupo_economico(t.cli_codigo) = pck_cliente.get_grupo_economico("+cliente + ")) OR (t.cli_codigo = "+cliente + ")) ");
    }

    query.append("    AND r.rep_cdgo        = nvl("+ codigo_representante + ", r.rep_cdgo) ");
    query.append("    AND r.codigo_regional = nvl("+ codigo_regional + ", r.codigo_regional) ");

    if (false) {
      throw new Exception(query.toString());
    }

    Vector res_Jw_consulta_duplicata = j.select(table, query.toString(), null);

    session.setAttribute("res_Jw_consulta_duplicata",res_Jw_consulta_duplicata);
    if (res_Jw_consulta_duplicata != null && res_Jw_consulta_duplicata.size() > 0) {
      portalbr.dbobj.view.Jw_consulta_duplicata r = (portalbr.dbobj.view.Jw_consulta_duplicata) res_Jw_consulta_duplicata.elementAt(0);
      f.setStatus((r.getStatus() != null) ? r.getStatus() + "":"");
      f.setDt_emissao(com.egen.util.text.FormatDate.format(r.getDt_emissao(), "dd/MM/yyyy"));
      f.setDt_venc(com.egen.util.text.FormatDate.format(r.getDt_venc(), "dd/MM/yyyy"));
      f.setCli_cdgo(r.getCli_cdgo() + "");
      f.setEsc_seqn(r.getEsc_seqn() + "");
      f.setDt_pagamento(com.egen.util.text.FormatDate.format(r.getDt_pagamento(), "dd/MM/yyyy"));
      f.setTriplic(com.egen.util.text.FormatDate.format(r.getTriplic()));
      f.setAnuencia(com.egen.util.text.FormatDate.format(r.getAnuencia(), "dd/MM/yyyy"));
      f.setIns_prot(com.egen.util.text.FormatDate.format(r.getIns_prot()));
      f.setNr_banco((r.getNr_banco() != null) ? r.getNr_banco() + "":"");
      f.setDesc_pontualidade(com.egen.util.text.FormatNumber.format(r.getDesc_pontualidade(), "##,##0.00") + " %");
      f.setDesc_antecipacao(com.egen.util.text.FormatNumber.format(r.getDesc_antecipacao(), "##,##0.00") + " %");
      f.setJuros("R$ "+com.egen.util.text.FormatNumber.format(r.getJuros(), "##,##0.00"));
      f.setValor_receb("R$ "+com.egen.util.text.FormatNumber.format(r.getValor_receb(), "##,##0.00"));
      f.setValor_abatim("R$ "+com.egen.util.text.FormatNumber.format(r.getValor_abatim(), "##,##0.00"));
      f.setDesconto("R$ "+com.egen.util.text.FormatNumber.format(r.getDesconto(), "##,##0.00"));
      f.setCartorio("R$ "+com.egen.util.text.FormatNumber.format(r.getCartorio(), "##,##0.00"));
      f.setDesban("R$ "+com.egen.util.text.FormatNumber.format(r.getDesban(), "##,##0.00"));
      f.setSaldo("R$ "+com.egen.util.text.FormatNumber.format(r.getSaldo(), "##,##0.00"));
      f.setEmpresa((r.getEmpresa() != null) ? r.getEmpresa() + "":"");
      f.setFilial((r.getFilial() != null) ? r.getFilial() + "":"");
      f.setTip_codigo((r.getTip_codigo() != null) ? r.getTip_codigo() + "":"");
      f.setTitulo((r.getTitulo() != null) ? r.getTitulo() + "":"");
      f.setRep_codigo((r.getRep_codigo() != null) ? r.getRep_codigo() + "":"");
      f.setRec_prot(com.egen.util.text.FormatDate.format(r.getRec_prot()));
      f.setValor("R$ "+com.egen.util.text.FormatNumber.format(r.getValor(), "##,##0.00"));
      f.setEncargos("R$ "+com.egen.util.text.FormatNumber.format(r.getEncargos(), "##,##0.00"));
      f.setValor_vendor("R$ "+com.egen.util.text.FormatNumber.format(r.getValor_vendor(), "##,##0.00"));
      f.setCliente(r.getCliente_desc());
      f.setCarteira(r.getCarteira());
      f.setTitulo((r.getTitulo() != null) ? r.getTitulo() + "":"");
      tit_numbco = ((r.getNr_banco() != null) ? r.getNr_banco() + "":"");

      if ((r.getPrt_codigo() + "").equals("237")) {
        // ----- BANCO BRADESCO S.A. -----
        link = "http://www.bradesco.com.br/html/content/prodserv/boleto_CPF.shtm";
        if (r.getVendor().equals("N")) {
          tit_numbco = tit_numbco.substring(0, tit_numbco.equals("") ? 0 : tit_numbco.length() - 1);
        }
      } else if ((r.getPrt_codigo() + "").equals("001")) {
        // ----- BANCO DO BRASIL S/A -----
        tit_numbco = tit_numbco.substring(0, tit_numbco.equals("") ? 0 : tit_numbco.length() - 1);
        link = "http://www21.bb.com.br/portalbb/boletoCobranca/HC21,2,10343.bbx";
      } else if ((r.getPrt_codigo() + "").equals("041")) {
        // ----- BANRISUL -----
        link = "https://www.banrisul.com.br/bbl/link/bblp44phw.asp?CodCedente=0290047883022&Valor=&SeuNumero=&DiaVcto=&MesVcto=&AnoVcto=&NomeSacado=&Endereco=&Cidade=&UF=&CEP=&Instrucoes=&SegundaVia=1&NossoNumero="+tit_numbco + "&Matricula=";
      } else if ((r.getPrt_codigo() + "").equals("033")) {
        // ----- BANCO SANTANDER SA -----
        tit_numbco = tit_numbco.substring(0, tit_numbco.equals("") ? 0 : tit_numbco.length() - 1);
        link = "http://www.santander.com.br/portal/gsb/script/templates/GCMRequest.do?page=2048&entryID=472";
      } else {
        tit_numbco = tit_numbco.substring(0, tit_numbco.equals("") ? 0 : tit_numbco.length() - 1);
        link = "";
      }
      f.setLink(link);
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_duplicata", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute(mapping.getName(), form);
  }
}
