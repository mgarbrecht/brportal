package portalbr.adm;

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
 * Creation Date 20/03/2006 14:36:08
 * Last Modify Date 25/11/2016 15:10:18
 */

public class ImpressaoDuplicatasAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    ImpressaoDuplicatasActionForm f = (ImpressaoDuplicatasActionForm) form;
    try {
      if ((!(f.getCli_rzao() != "")) && (!(f.getCli_cdgo() != "")) && (!(f.getCgc() != ""))) {
        throw new Exception("Um dos parâmetros obrigatórios deve ser informado!");
      }
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);

      if (f.getCli_rzao() != "") {
        actionForward = new ActionForward("/adm/ImpressaoDuplicatasClientesForm.do?&situacao="+f.getSituacao() + "&dt_venc="+f.getDt_vencimento() + "&emp_empresa="+f.getEmp_empresa(), true);
      }

      if (!(f.getCli_rzao() != "")) {
        if ((f.getReunir() + "").equals("1")) {
          actionForward = new ActionForward("/adm/ImpressaoDuplicatas_rForm.do?select_action=&cli_cdgo="+f.getCli_cdgo() + "&dt_venc="+f.getDt_vencimento() + "&situacao="+f.getSituacao() + "&codigo="+f.getCli_cdgo() + "&nome="+f.getNome() + "&bairro="+f.getBairro() + "&cidade_uf="+f.getCidade_uf() + "&emp_empresa="+f.getEmp_empresa(), true);

        } else {
          if (f.getEsc_seqn() != "") {
            actionForward = new ActionForward("/adm/ImpressaoDuplicatas_rForm.do?select_action=&esc_seqn="+f.getEsc_seqn() + "&cli_cdgo="+f.getCli_cdgo() + "&dt_venc="+f.getDt_vencimento() + "&situacao="+f.getSituacao() + "&codigo="+f.getCodigo() + "&nome="+f.getNome() + "&bairro="+f.getBairro() + "&cidade_uf="+f.getCidade_uf() + "&emp_empresa="+f.getEmp_empresa(), true);

          } else {
            actionForward = new ActionForward("/adm/ImpressaoDuplicatasClientesForm.do?&situacao="+f.getSituacao() + "&dt_venc="+f.getDt_vencimento() + "&emp_empresa="+f.getEmp_empresa(), true);
          }
        }
      }

    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_titulos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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


    StringBuilder query = new StringBuilder();
    StringBuilder cli = new StringBuilder();
    StringBuilder esc = new StringBuilder();
    StringBuilder parametros = new StringBuilder();
    Vector res_Jw_consulta_titulos = null;
    HttpSession session = request.getSession(true);
    ImpressaoDuplicatasActionForm f = (ImpressaoDuplicatasActionForm) form;

    if (f.getCli_rzao() != "") {
      parametros.append(" and a.cli_rzao like upper('").append(f.getCli_rzao()).append("')");
      cli.append("null");
      esc.append("null");
    } else {
      if (f.getCli_cdgo() != "") {
        cli.append(f.getCli_cdgo());
      } else {
        cli.append("null");
      }

      if (f.getEsc_seqn() != "") {
        esc.append(f.getEsc_seqn());
      } else {
        esc.append("null");
      }
    }

    if (f.getCgc() != null && f.getCgc() != "" && f.getCgc() != "null") {
      parametros.append(" AND esc_cgc = " + f.getCgc());
      util.consultas.Query qr = new util.consultas.Query();
      String cliente = qr.retorna(j, "select cli_cdgo FROM esc WHERE esc_cgc = " + f.getCgc());
      String sequencial = qr.retorna(j, "select esc_seqn FROM esc WHERE esc_cgc = " + f.getCgc());
      f.setCli_cdgo(cliente);
      f.setEsc_seqn(sequencial);
      if (f.getCli_cdgo().equals("")) {
        throw new Exception("CGC inválido!");
      }

    }



    portalbr.dbobj.view.Jw_consulta_titulos table = new portalbr.dbobj.view.Jw_consulta_titulos();
    if (f.getRepresentante() != "") {
      query = new StringBuilder("");
      query.append(" SELECT /*+ all_rows */ ");
      query.append("        a.cli_cdgo||'-'||b.esc_seqn cliente ");
      query.append("      , cli_rzao razao ");
      query.append("      , ecl_bair br ");
      query.append("      , ecl_cdad||'-'||c.est_unifed cid_est ");
      query.append("      , b.esc_seqn ");
      query.append("      , a.cli_cdgo ");
      query.append("      , ca.cli_cdgo_sucessor codigo_sucessor ");
      query.append("      , ca.esc_seqn_sucessor sequencial_sucessor ");
      query.append("      , pck_cliente.get_nome(ca.cli_cdgo_sucessor) razao_social_sucessor ");
      query.append("      , (SELECT ec.ecl_cdad || ' - ' || ec.est_unifed ");
      query.append("           FROM ecl ec ");
      query.append("          WHERE ec.cli_cdgo = ca.cli_cdgo_sucessor ");
      query.append("            AND esc_seqn = ca.esc_seqn_sucessor ");
      query.append("            AND ROWNUM = 1) cid_uf_sucessor ");
      query.append("      , (SELECT ec.ecl_bair ");
      query.append("           FROM ecl ec ");
      query.append("          WHERE ec.cli_cdgo = ca.cli_cdgo_sucessor ");
      query.append("            AND esc_seqn = ca.esc_seqn_sucessor ");
      query.append("            AND ROWNUM = 1) br_sucessor ");
      query.append("   FROM cli a ");
      query.append("      , esc b ");
      query.append("      , ecl c ");
      query.append("      , cliente_representante cr ");
      query.append("      , brio.cli_inf_adicionais ca ");
      query.append("  WHERE cr.codigo_representante = ").append(f.getRepresentante());
      query.append("    AND a.cli_cdgo              = nvl(").append(cli.toString()).append(",a.cli_cdgo) ");
      query.append("    AND b.esc_seqn              = nvl(").append(esc.toString()).append(",b.esc_seqn) ");
      query.append("    AND b.esc_seqn              = c.esc_seqn ");
      query.append("    AND a.cli_cdgo              = b.cli_cdgo ");
      query.append("    AND b.cli_cdgo              = c.cli_cdgo ");
      query.append("    AND ca.cli_cdgo         (+) = b.cli_cdgo ");
      query.append("    AND ca.esc_seqn         (+) = b.esc_seqn ");
      query.append("    AND b.cli_cdgo              = cr.codigo_cliente ");
      query.append("    AND b.esc_seqn              = cr.codigo_sequencial ");
      query.append("    AND (c.ned_cdgo             = 'UNI' or c.ned_cdgo = 'COB') ");
      query.append("    AND a.cli_cdgo              > 0 ");
      query.append(parametros.toString());
      query.append("  ORDER BY cli_rzao ");
    }

    if (f.getRegional() != "") {
      query = new StringBuilder("");
      query.append(" SELECT /*+ all_rows */ ");
      query.append("        DISTINCT ");
      query.append("        a.cli_cdgo||'-'||b.esc_seqn cliente ");
      query.append("      , cli_rzao razao  ");
      query.append("      , ecl_bair br ");
      query.append("      , ecl_cdad||'-'||c.est_unifed cid_est ");
      query.append("      , b.esc_seqn ");
      query.append("      , a.cli_cdgo ");
      query.append("      , ca.cli_cdgo_sucessor codigo_sucessor ");
      query.append("      , ca.esc_seqn_sucessor sequencial_sucessor ");
      query.append("      , pck_cliente.get_nome(ca.cli_cdgo_sucessor) razao_social_sucessor ");
      query.append("      , (SELECT ec.ecl_cdad || ' - ' || ec.est_unifed ");
      query.append("           FROM ecl ec ");
      query.append("          WHERE ec.cli_cdgo = ca.cli_cdgo_sucessor ");
      query.append("            AND esc_seqn = ca.esc_seqn_sucessor ");
      query.append("            AND ROWNUM = 1) cid_uf_sucessor ");
      query.append("      , (SELECT ec.ecl_bair ");
      query.append("           FROM ecl ec ");
      query.append("          WHERE ec.cli_cdgo = ca.cli_cdgo_sucessor ");
      query.append("            AND esc_seqn = ca.esc_seqn_sucessor ");
      query.append("            AND ROWNUM = 1) br_sucessor ");
      query.append("   FROM cli a ");
      query.append("      , esc b ");
      query.append("      , ecl c ");
      query.append("      , cliente_representante cr ");
      query.append("      , brio.rep r ");
      query.append("      , brio.cli_inf_adicionais ca ");
      query.append("  WHERE b.esc_seqn              =  c.esc_seqn ");
      query.append("    AND a.cli_cdgo              =  b.cli_cdgo ");
      query.append("    AND b.cli_cdgo              =  c.cli_cdgo ");
      query.append("    AND ca.cli_cdgo         (+) = b.cli_cdgo ");
      query.append("    AND ca.esc_seqn         (+) = b.esc_seqn ");
      query.append("    AND b.cli_cdgo              =  cr.codigo_cliente ");
      query.append("    AND b.esc_seqn              =  cr.codigo_sequencial ");
      query.append("    AND (c.ned_cdgo = 'UNI'     or c.ned_cdgo = 'COB') ");
      query.append("    AND cr.codigo_representante =  r.rep_cdgo ");
      query.append("    AND r.codigo_regional       =  ").append(f.getRegional());
      query.append("    AND a.cli_cdgo              =  nvl(").append(cli.toString()).append(",a.cli_cdgo) ");
      query.append("    AND b.esc_seqn              =  nvl(").append(esc.toString()).append(",b.esc_seqn) ");
      query.append(parametros.toString());
      query.append("  ORDER BY cli_rzao ");
    }

    if ((!(f.getRegional() != "")) && (!(f.getRepresentante() != ""))) {
      query = new StringBuilder("");
      query.append(" SELECT /*+ all_rows */ ");
      query.append("        a.cli_cdgo||'-'||b.esc_seqn cliente ");
      query.append("      , cli_rzao razao ");
      query.append("      , ecl_bair br ");
      query.append("      , ecl_cdad||'-'||c.est_unifed cid_est ");
      query.append("      , b.esc_seqn ");
      query.append("      , a.cli_cdgo ");
      query.append("      , ca.cli_cdgo_sucessor codigo_sucessor ");
      query.append("      , ca.esc_seqn_sucessor sequencial_sucessor ");
      query.append("      , pck_cliente.get_nome(ca.cli_cdgo_sucessor) razao_social_sucessor ");
      query.append("      , (SELECT ec.ecl_cdad || ' - ' || ec.est_unifed ");
      query.append("           FROM ecl ec ");
      query.append("          WHERE ec.cli_cdgo = ca.cli_cdgo_sucessor ");
      query.append("            AND esc_seqn = ca.esc_seqn_sucessor ");
      query.append("            AND ROWNUM = 1) cid_uf_sucessor ");
      query.append("      , (SELECT ec.ecl_bair ");
      query.append("           FROM ecl ec ");
      query.append("          WHERE ec.cli_cdgo = ca.cli_cdgo_sucessor ");
      query.append("            AND esc_seqn = ca.esc_seqn_sucessor ");
      query.append("            AND ROWNUM = 1) br_sucessor ");
      query.append("   FROM cli a ");
      query.append("      , esc b ");
      query.append("      , ecl c ");
      query.append("      , brio.cli_inf_adicionais ca ");
      query.append("  WHERE b.esc_seqn            =  c.esc_seqn ");
      query.append("    AND a.cli_cdgo            =  b.cli_cdgo ");
      query.append("    AND b.cli_cdgo            =  c.cli_cdgo ");
      query.append("    AND (c.ned_cdgo = 'UNI'   or c.ned_cdgo = 'COB') ");
      query.append("    AND ca.cli_cdgo         (+) = b.cli_cdgo ");
      query.append("    AND ca.esc_seqn         (+) = b.esc_seqn ");
      query.append("    AND a.cli_cdgo            >  0 ");
      query.append("    AND a.cli_cdgo            =  nvl(").append(cli.toString()).append(",a.cli_cdgo) ");
      query.append("    AND b.esc_seqn            =  nvl(").append(esc.toString()).append(",b.esc_seqn) ");
      query.append(parametros.toString());
      query.append("  ORDER BY cli_rzao");
    }

    if ((!(f.getCliente_mercado_externo().equals("")))) {
      query = new StringBuilder("");
      query.append(" SELECT /*+ all_rows */ ");
      query.append("        a.cli_cdgo||'-'||b.esc_seqn cliente ");
      query.append("      , cli_rzao razao ");
      query.append("      , ecl_bair br ");
      query.append("      , ecl_cdad||'-'||c.est_unifed cid_est ");
      query.append("      , b.esc_seqn ");
      query.append("      , a.cli_cdgo ");
      query.append("   FROM cli a ");
      query.append("      , esc b ");
      query.append("      , ecl c ");
      query.append("      , brio.cli_inf_adicionais ca ");
      query.append("  WHERE b.esc_seqn            =  c.esc_seqn ");
      query.append("    AND a.cli_cdgo            =  b.cli_cdgo ");
      query.append("    AND b.cli_cdgo            =  c.cli_cdgo ");
      query.append("    AND ca.cli_cdgo         (+) = b.cli_cdgo ");
      query.append("    AND ca.esc_seqn         (+) = b.esc_seqn ");
      query.append("    AND (c.ned_cdgo = 'UNI'   or c.ned_cdgo = 'COB') ");
      query.append("    AND a.cli_cdgo            >  0 ");
      query.append("    AND a.cli_cdgo            =  nvl(").append(f.getCliente_mercado_externo()).append(",a.cli_cdgo) ");
      query.append("    AND b.esc_seqn            =  nvl(null,b.esc_seqn) ");
      query.append("  ORDER BY cli_rzao");
    }


    if ((f.getCli_cdgo() != "") && (f.getEsc_seqn() != "") && (!(f.getCli_rzao() != "")) || (f.getCli_cdgo() != "") && (!(f.getEsc_seqn() != "")) && (!(f.getCli_rzao() != "")) && ((f.getReunir() + "").equals("1"))) {

      if (false) {
        throw new Exception(query.toString());
      }


      res_Jw_consulta_titulos = j.select(table, query.toString(), null);
    } else {
      if (false) {
        throw new Exception(query.toString());
      }
      res_Jw_consulta_titulos = j.select(table, query.toString(), null);
    }
    session.setAttribute("res_Jw_consulta_titulos",res_Jw_consulta_titulos);

    if (res_Jw_consulta_titulos != null && res_Jw_consulta_titulos.size() > 0) {
      portalbr.dbobj.view.Jw_consulta_titulos r = (portalbr.dbobj.view.Jw_consulta_titulos) res_Jw_consulta_titulos.elementAt(0);
      f.setCodigo(r.getCliente() + "");
      f.setNome(r.getRazao() + "");
      f.setBairro(r.getBr() + "");
      f.setCidade_uf(r.getCid_est() + "");
    } else {
      throw new Exception("Nenhuma duplicata encontrada!");
    }


    if (!(res_Jw_consulta_titulos != null && res_Jw_consulta_titulos.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_titulos", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute("mapping.getName()", form);
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ImpressaoDuplicatasActionForm f = (ImpressaoDuplicatasActionForm) form;
      session.removeAttribute("res_Jw_consulta_titulos");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_titulos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_select2_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //--------------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 20/03/2006
    // Objetivo          : Executa uma consulta na view portalbr.dbobj.view.Jw_consulta_duplicata
    //                     usando o código do título, caso o título exista, redireciona para a
    //                     tela de visualização de duplicatas, executando uma consulta com base no
    //                     título informado:
    //                     /com/ConsultaDuplicataForm.do?select_action=&titulo
    //--------------------------------------------------------------------------------------------
    // Data de Alteração :
    // Descrição         :
    //--------------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    ImpressaoDuplicatasActionForm f = (ImpressaoDuplicatasActionForm) form;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      //-------------
      String empresa = null;
      String filial = null;
      String tip = null;
      String cliente = "";
      String titulo = "";
      String ped_nmro = "";
      String nf = "";
      String rep = "";
      String representante = "null";
      String regional = "null";
      if (f.getRepresentante() != "") {
        representante = f.getRepresentante();
      }
      if (f.getRegional() != "") {
        regional = f.getRegional();
      }
      portalbr.dbobj.view.Jw_consulta_duplicata table = new portalbr.dbobj.view.Jw_consulta_duplicata();
      StringBuilder query = new StringBuilder();
      query.append(" SELECT /*+ all_rows */ ");
      query.append("        decode(tit_status, 'A', 'Aberto', 'L', 'Liquidado', 'Cancelado') status ");
      query.append("      , tit_datemi dt_emissao ");
      query.append("      , tit_datvenc dt_venc ");
      query.append("      , t.cli_codigo cli_cdgo ");
      query.append("      , t.esc_seqn esc_seqn ");
      query.append("      , tit_datrec dt_pagamento ");
      query.append("      , t.tit_dt_emissao_triplicata triplic ");
      query.append("      , t.tit_dt_emissao_anuencia anuencia ");
      query.append("      , t.tit_dt_emissao_ins_protesto ins_prot ");
      query.append("      , car_descri carteira ");
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
      query.append("      , trunc(nvl(tit_valor, 0) - nvl(tit_vlrec, 0) - nvl(tit_vldesc, 0) -");
      query.append("              nvl(tit_abatim, 0) + nvl(0, 0) + nvl(0, 0) +");
      query.append("              nvl(tit_vljuro, 0) + nvl(tit_vlcor, 0),");
      query.append("              2) saldo ");
      query.append("      , t.emp_empresa empresa  ");
      query.append("      , t.fil_filial filial ");
      query.append("      , t.tip_codigo tip_codigo ");
      query.append("      , t.tit_codigo titulo ");
      query.append("      , t.rep_codigo rep_codigo ");
      query.append("      , t.tit_dt_receb_protesto rec_prot ");
      query.append("      , tit_valor valor ");
      query.append("      , cli.cli_cdgo ||' - '|| nvl(cli.cli_rzao,cli.cli_nome) cliente ");
      query.append("      , nfv.ped_nmro ");
      query.append("      , tn.nsa_numero||'-'||tn.nsa_serie nf ");
      query.append("      , r.rep_cdgo||'-'||nvl(r.rep_rzao,r.rep_nome) rep ");
      query.append("   FROM titulos t ");
      query.append("      , cart_cobranca c ");
      query.append("      , portadores p ");
      query.append("      , rep r ");
      query.append("      , regionais_vendas rv ");
      query.append("      , notas_fiscais_saida_ped_venda nfv ");
      query.append("      , tit_nf tn ");
      query.append("      , cli ");
      query.append("  WHERE c.car_codigo(+)     =  t.car_codigo ");
      query.append("    AND p.prt_codigo(+)     =  t.prt_codigo ");
      query.append("    AND r.rep_cdgo          =  t.rep_codigo ");
      query.append("    AND rv.codigo_regional  =  r.codigo_regional ");
      query.append("    AND t.tit_codigo        =  upper('").append(f.getTit_codigo()).append("')");
      query.append("    AND rv.codigo_regional  =  nvl(").append(regional).append(",rv.codigo_regional) ");
      query.append("    AND r.rep_cdgo          =  nvl(").append(representante).append(",r.rep_cdgo) ");
      query.append("    AND tn.emp_empresa      =  t.emp_empresa ");
      query.append("    AND tn.fil_filial       =  t.fil_filial ");
      query.append("    AND tn.tip_codigo       =  t.tip_codigo ");
      query.append("    AND tn.tit_codigo       =  t.tit_codigo ");
      query.append("    AND cli.cli_cdgo        =  t.cli_codigo ");
      query.append("    AND nfv.nfs_nmro    (+) =  tn.nsa_numero ");
      query.append("    AND nfv.nfs_serie   (+) =  tn.nsa_serie ");
      query.append("    AND nfv.emp_empresa (+) =  tn.emp_empresa ");
      query.append("    AND nfv.fil_filial  (+) =  tn.fil_filial ");

      if (false) {
        throw new Exception(query.toString());
      }

      Vector res_Jw_consulta_duplicata = j.select(table, query.toString(), null);

      session.setAttribute("res_Jw_consulta_duplicata", res_Jw_consulta_duplicata);
      if (res_Jw_consulta_duplicata != null && res_Jw_consulta_duplicata.size() == 0) {
        throw new Exception("Título inexistente!");
      } else {

        portalbr.dbobj.view.Jw_consulta_duplicata r = (portalbr.dbobj.view.Jw_consulta_duplicata) res_Jw_consulta_duplicata.elementAt(0);
        cliente = r.getCliente() + "";
        titulo = r.getTitulo() + "";
        ped_nmro = r.getPed_nmro() + "";
        nf = r.getNf() + "";
        rep = r.getRep() + "";
        empresa = r.getEmpresa() + "";
        filial = r.getFilial() + "";
        tip = r.getTip_codigo() + "";


        if (ped_nmro.equals("null")) {
          ped_nmro = "";
        }

      }
      session.setAttribute(mapping.getName(), form);
      StringBuilder sb = new StringBuilder();

      portalbr.dbobj.view.Jw_titulos_pedidos t_titulos_pedidos = new portalbr.dbobj.view.Jw_titulos_pedidos();
      String[][] select = null;
      Object[][] where = { {"tit_codigo","like", f.getTit_codigo()}, };
      Vector res_Jw_titulos_pedidos = j.select(t_titulos_pedidos, select, where, null, null, null);
      session.setAttribute("res_Jw_titulos_pedidos",res_Jw_titulos_pedidos);
      sb.append("/com/ConsultaDuplicataForm.do?select_action=&titulo=").append(f.getTit_codigo().toUpperCase());
      sb.append("&cliente=").append(cliente);
      sb.append("&duplicata=").append(titulo);
      sb.append("&pedido=").append(ped_nmro);
      sb.append("&nf=").append(nf);
      sb.append("&rep=").append(rep);
      sb.append("&emp_empresa=").append(empresa);
      sb.append("&fil_filial=").append(filial);
      sb.append("&tip=").append(tip);

      actionForward = new ActionForward(sb.toString(), true);

    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_titulos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
}
