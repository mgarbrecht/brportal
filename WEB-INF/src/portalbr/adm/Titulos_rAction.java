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
 * Creation Date 21/03/2006 08:52:01
 * Last Modify Date 20/05/2020 14:36:43
 */

public class Titulos_rAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_titulos_registros", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    Titulos_rActionForm f = (Titulos_rActionForm) form;
    String esc = "null";
    String situacao = "null";
    String data_vencimento = "null";
    String emp_empresa = "null";
    util.consultas.Query q = new util.consultas.Query();

    if (f.getEsc_seqn() != "") {
      esc = f.getEsc_seqn();
    }

    if ((f.getDt_venc() + "").equals("null") || (f.getDt_venc() + "").equals("")) {
      data_vencimento = "null";
    } else {
      data_vencimento = "'"+f.getDt_venc() + "'";
    }

    if (f.getEmp_empresa() != "" && !(f.getEmp_empresa() + "").equals("null")) {
      emp_empresa = "'"+f.getEmp_empresa() + "'";
    }

    if (f.getSituacao() != "" && !(f.getSituacao() + "").equals("null")) {
      situacao = "'"+f.getSituacao() + "'";
    } else {
      situacao = "'T'";
    }

    //------ tabelas ------------------------------
    portalbr.dbobj.table.Dual table_dual = new portalbr.dbobj.table.Dual();
    //------ variaveis ----------------------------
    String w_tit_dsante = "0";
    String w_tit_dspont = "0";
    String w_tit_vljuro = "0";
    double w_tit_vldesc = 0;
    double w_saldo = 0;
    double w_liq = 0;
    double w_saldo_tot = 0;
    double w_valor_tot = 0;
    double taxa = 0;

    //--- Sysdate ---
    String sysdate = q.retorna(j, "SELECT to_char(trunc(SYSDATE),'dd/mm/yyyy') FROM dual");
    //---------------

    //--- Taxa ---
    taxa = Double.parseDouble(q.retorna(j, "select taxa_juros from taxas_juros WHERE rownum = 1"));
    //------------

    String codigo_regional = "null";
    String codigo_representante = "null";
    String tipo = "";

    String multiplosTitulos = null;
    if (session.getAttribute("consulta_titulos_multiplos_registros") != null) {
      multiplosTitulos = (String) session.getAttribute("consulta_titulos_multiplos_registros");
      session.removeAttribute("consulta_titulos_multiplos_registros");
      request.setAttribute("esconderCabecalho", true);
    }

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
        codigo_representante = "'"+ent.getChave() + "'";
      }
      if ((tipo.equals("CLIENTE MERCADO INTERNO")) || (tipo.equals("CLIENTE MERCADO EXTERNO"))) {
        f.setCli_cdgo(ent.getChave());
      }
    }

    StringBuilder query = new StringBuilder();
    query.append(" SELECT /*+ all_rows */ ");
    query.append("        trunc(tit_datvenc) + 3 tit_datven3 ");
    query.append("      , tit_codigo ");
    query.append("      , tit_numbco ");
    query.append("      , decode(tit_status,'A','Aberto','C','Cancelado','L','Liquidado') tit_status ");
    query.append("      , tip_codigo ");
    query.append("      , tit_datvenc ");
    query.append("      , tit_datrec ");
    query.append("      , tit_datemi ");
    query.append("      , tit_dspont ");
    query.append("      , tit_dsante ");
    query.append("      , tit_valor ");
    query.append("      , tit_vlrec ");
    query.append("      , p.prt_codigo ");
    query.append("      , p.prt_descri ");
    query.append("      , t.emp_empresa ");
    query.append("      , fil_filial ");
    query.append("      , sit.descricao_situacao_do_titulo desc_sit ");
    query.append("      ,(SELECT DECODE(mr.trn_codigo, 'NCC', 'NCC', ' ') ");
    query.append("          FROM mov_receber mr ");
    query.append("         WHERE mr.emp_empresa = t.emp_empresa ");
    query.append("         AND mr.fil_filial = t.fil_filial ");
    query.append("         AND mr.tip_codigo = t.tip_codigo ");
    query.append("         AND mr.tit_codigo = t.tit_codigo ");
    query.append("           AND NVL(trn_codigo, NULL) = 'NCC' ");
    query.append("           AND ROWNUM = 1) ncc ");
    query.append("      , '' nota ");
    query.append("      , '' serie ");
    query.append("      , '' taxa_juro ");
    query.append("      , '' trn_codigo ");
    query.append("      , null mov_data ");
    query.append("      , null datvenc ");
    query.append("      , 'N' cobjur ");
    query.append("      , NVL((SELECT mov_valor ");
    query.append("               FROM mov_receber mr ");
    query.append("              WHERE mr.emp_empresa = t.emp_empresa ");
    query.append("                AND mr.fil_filial = t.fil_filial ");
    query.append("                AND mr.tip_codigo = t.tip_codigo ");
    query.append("                AND mr.trn_codigo = 'NCC' ");
    query.append("                AND tit_codigo = t.tit_codigo ");
    query.append("                AND rownum = 1), '0' ) tit_abatim ");
    query.append("      , (SELECT mov_valor ");
    query.append("           FROM mov_receber mv ");
    query.append("          WHERE mv.emp_empresa = t.emp_empresa ");
    query.append("            AND fil_filial = t.fil_filial ");
    query.append("            AND tip_codigo = t.tip_codigo ");
    query.append("            AND trn_codigo = 'PRO' ");
    query.append("            AND tit_codigo = t.tit_codigo ");
    query.append("            AND ROWNUM = 1) vnc_cartor ");
    query.append("      , '' dif ");
    query.append("      , t.rep_codigo ");
    query.append("      , trunc(SYSDATE) data_atual ");
    query.append("      , '' w_liq ");
    query.append("      , '' w_saldo_tot ");
    query.append("      , '' w_valor_tot ");
    query.append("      , '' pedido ");
    query.append("      , brio.fct_retorna_vendor(t.cac_sequencia) vendor ");
    query.append("      , fct_formata_cnpj(e.esc_cgc) cnpj ");
    query.append("      , e.esc_cgc cnpj_sem_formato ");
    query.append("      , c.cli_rzao ");
    query.append("   FROM titulos t ");
    query.append("      , situacoes_dos_titulos sit ");
    query.append("      , portadores p ");
    query.append("      , regionais_vendas reg ");
    query.append("      , rep r ");
    query.append("      , esc e ");
    query.append("      , cli c ");
    query.append("  WHERE t.emp_empresa                   = nvl("+emp_empresa + ", t.emp_empresa) ");
    query.append("    AND e.cli_cdgo = t.cli_codigo ");
    query.append("    and c.cli_cdgo = e.cli_cdgo ");
    query.append("    AND e.esc_seqn = t.esc_seqn ");
    query.append("    AND p.prt_codigo                 (+) = t.prt_codigo ");
    query.append("    AND nvl(T.tip_codigo,null)      in ('DUP','NTP','NTC','NTS','NTD') ");
    if (multiplosTitulos != null) {
      query.append(" AND t.tit_codigo in ('" + multiplosTitulos.replace(",", "','") + "') ");
    }
    if ((f.getCli_cdgo() + "") != "" && !(f.getCli_cdgo() + "").equals("null")) {
      query.append(" AND cli_codigo                       = ").append(f.getCli_cdgo());
    }
    query.append("    AND t.esc_seqn            =  nvl(").append(esc).append(",t.esc_seqn) ");
    query.append("    AND tit_datvenc                     >= decode(to_date(").append(data_vencimento).append(",'dd/mm/yyyy'),null,tit_datvenc,to_date(").append(data_vencimento).append(",'dd/mm/yyyy')) ");
    query.append("    AND tit_status                 =  decode(").append(situacao).append(",'T',tit_status,decode(").append(situacao).append(",'A','A','L','L','C','C')) ");
    query.append("    AND t.sit_codigo_situacao_titulo     = sit.codigo_situacao_titulo ");
    query.append("    AND (t.emp_empresa, t.fil_filial, t.tip_codigo , t.tit_codigo) ");
    query.append("    NOT IN (SELECT m.emp_empresa ");
    query.append("                 , m.fil_filial ");
    query.append("                 , m.tip_codigo ");
    query.append("                 , m.tit_codigo ");
    query.append("              FROM mov_receber m ");
    query.append("             WHERE nvl(m.emp_empresa,null) = nvl(t.emp_empresa,null) ");
    query.append("               AND nvl(m.fil_filial,null)  = nvl(t.fil_filial,null) ");
    query.append("               AND nvl(m.tip_codigo,null)  = nvl(t.tip_codigo,null) ");
    query.append("               AND m.tit_codigo            = nvl(t.tit_codigo,null) ");
    query.append("               AND nvl(m.trn_codigo,null)  in ('CON','TNC','FAL','NEG','PNE') ");
    query.append("               AND trunc(mov_data)        <= trunc(sysdate) ");
    query.append("               AND nvl(m.mov_data,null)   <= trunc(sysdate) ");
    query.append("               AND nvl(m.mov_sequencia,0)  = 0 ");
    query.append("               AND rownum = 1 ) ");
    query.append("    AND t.rep_codigo        = r.rep_cdgo ");
    query.append("    AND r.codigo_regional   = reg.codigo_regional ");
    query.append("    AND t.rep_codigo        = nvl(").append(codigo_representante).append(",t.rep_codigo) ");
    query.append("    AND reg.codigo_regional = nvl(").append(codigo_regional).append(",reg.codigo_regional) ");
    query.append("  ORDER BY tit_datvenc ");
    query.append("         , tit_status ");

    if (false) {
      throw new Exception(query.toString());
    }

    portalbr.dbobj.view.Jw_t_titulos_lista table = new portalbr.dbobj.view.Jw_t_titulos_lista();
    Vector res_Jw_t_titulos_lista = j.select(table, query.toString(), null);

    session.setAttribute("res_Jw_t_titulos_lista",res_Jw_t_titulos_lista);

    if (res_Jw_t_titulos_lista != null && res_Jw_t_titulos_lista.size() > 0) {
      for (int x = 0; x < res_Jw_t_titulos_lista.size(); x++) {
        portalbr.dbobj.view.Jw_t_titulos_lista r = (portalbr.dbobj.view.Jw_t_titulos_lista) res_Jw_t_titulos_lista.elementAt(x);
        //------------- verifica nota credito -----------
        //portalbr.dbobj.view.Jw_t_verifica_nota_credito table_verifica_nota_credito = new portalbr.dbobj.view.Jw_t_verifica_nota_credito();
        //StringBuilder query1 = new StringBuilder();
        //query1.append(" SELECT decode(trn_codigo,'NCC','NCC',' ') ncc ");
        //query1.append("   FROM mov_receber ");
        //query1.append("  WHERE tit_codigo = '").append((r.getTit_codigo()+"")).append("' ");
        //query1.append("    AND nvl(trn_codigo,null) = 'NCC' ");

        //Vector res_Jw_t_verifica_nota_credito = j.select(table_verifica_nota_credito, query1.toString(), null);

        //if (res_Jw_t_verifica_nota_credito != null && res_Jw_t_verifica_nota_credito.size() > 0) {
        //  portalbr.dbobj.view.Jw_t_verifica_nota_credito r2 = (portalbr.dbobj.view.Jw_t_verifica_nota_credito) res_Jw_t_verifica_nota_credito.elementAt(0);
        //  r.setNcc(r2.getNcc()+"");
        //}
        //----------- nota titulo ----------------------

        portalbr.dbobj.view.Jw_t_nota_titulo table_nota_titulo = new portalbr.dbobj.view.Jw_t_nota_titulo();
        StringBuilder query2 = new StringBuilder();
        if (!r.getTip_codigo().equalsIgnoreCase("NTS")) {
          query2.append(" SELECT /*+ all_rows */ ");
          query2.append("        nf.nsa_numero                   nota    ");
          query2.append("      , nf.nsa_serie                    serie   ");
          query2.append("      , nf.fil_filial                   filial  ");
          query2.append("      , nfs.ped_nmro                            ");
          query2.append("      , nvl(p.ped_nmro,0)               pedido  ");
          query2.append("   FROM tit_nf                          nf      ");
          query2.append("      , notas_fiscais_saida_ped_venda   nfs     ");
          query2.append("      , ped                             p       ");
          query2.append("  WHERE nf.emp_empresa = nfs.emp_empresa        ");
          query2.append("    AND nf.fil_filial  = nfs.fil_filial         ");
          query2.append("    AND nfs.nfs_nmro   = nf.nsa_numero          ");
          query2.append("    AND nfs.nfs_serie  = nf.nsa_serie           ");
          query2.append("    AND p.ped_nmro (+) = nfs.ped_nmro           ");
          query2.append("    AND nf.emp_empresa = '").append(r.getEmp_empresa()).append("' ");
          query2.append("    AND nf.fil_filial  = '").append(r.getFil_filial()).append("' ");
          query2.append("    AND nf.tip_codigo  = '").append(r.getTip_codigo()).append("' ");
          query2.append("    AND nf.tit_codigo  = '").append(r.getTit_codigo()).append("' ");
        } else {
          query2.append(" SELECT /*+ all_rows */ ");
          query2.append("        t.nsa_numero nota ");
          query2.append("      , t.nsa_serie  serie ");
          query2.append("      , n.fil_filial filial ");
          query2.append("      , n.ped_nmro ");
          query2.append("      , 0 pedido ");
          query2.append("      , fct_formata_cnpj(e.esc_cgc) esc_cgc ");
          query2.append("      , c.cli_rzao ");
          query2.append("   FROM cli      c ");
          query2.append("      , esc      e ");
          query2.append("      , nf_saida n ");
          query2.append("      , tit_nf   t ");
          query2.append(" WHERE t.tit_codigo = '").append(r.getTit_codigo()).append("' ");
          query2.append("   AND t.fil_filial  = '").append(r.getFil_filial()).append("' ");
          query2.append("   AND t.tip_codigo = 'NTS' ");
          query2.append("   AND n.nfs_nmro = t.nsa_numero ");
          query2.append("   AND n.fil_filial = t.fil_filial ");
          query2.append("   AND n.emp_empresa = t.emp_empresa ");
          query2.append("   AND e.cli_cdgo = n.cli_cdgo ");
          query2.append("   AND e.esc_seqn = n.esc_seqn ");
          query2.append("   AND c.cli_cdgo = e. cli_cdgo ");
        }


        Vector res_Jw_t_nota_titulo = j.select(table_nota_titulo, query2.toString(), null);

        if (res_Jw_t_nota_titulo != null && res_Jw_t_nota_titulo.size() > 0) {
          portalbr.dbobj.view.Jw_t_nota_titulo r3 = (portalbr.dbobj.view.Jw_t_nota_titulo) res_Jw_t_nota_titulo.elementAt(0);
          r.setNota(r3.getNota() + "");
          r.setSerie(r3.getSerie() + "");
          r.setPed_nmro(r3.getPed_nmro() + "");
          r.setPedido(r3.getPedido() + "");
          if (r.getTip_codigo().equalsIgnoreCase("NTS")) {
            r.setCnpj(r3.getEsc_cgc());
            r.setCli_rzao(r3.getCli_rzao());
          }
        }


        if ((r.getTit_status() + "").equals("Aberto")) {

          //--------- taxa juro --------------------
          r.setTaxa_juro(taxa);
          //----------------------------------------

          //---------- busca dis -------------------
          portalbr.dbobj.view.Jw_t_busca_dis table_busca_dis = new portalbr.dbobj.view.Jw_t_busca_dis();
          StringBuilder query3 = new StringBuilder();
          query3.append(" SELECT /*+ all_rows */ ");
          query3.append("        mov_data     dat ");
          query3.append("      , trn_codigo   trn ");
          query3.append("   FROM mov_receber  ");
          query3.append("  WHERE emp_empresa = '").append(r.getEmp_empresa()).append("' ");
          query3.append("    AND fil_filial  = '").append(r.getFil_filial()).append("' ");
          query3.append("    AND tip_codigo  = '").append(r.getTip_codigo()).append("' ");
          query3.append("    AND tit_codigo  = '").append(r.getTit_codigo()).append("' ");
          query3.append("    AND trn_codigo  = 'DIS' ");
          query3.append("    AND nvl(mov_sequencia,0)=0 ");
          query3.append("    AND rownum = 1 ");

          Vector res_Jw_t_busca_dis = j.select(table_busca_dis, query3.toString(), null);

          if (res_Jw_t_busca_dis != null && res_Jw_t_busca_dis.size() > 0) {
            portalbr.dbobj.view.Jw_t_busca_dis r5 = (portalbr.dbobj.view.Jw_t_busca_dis) res_Jw_t_busca_dis.elementAt(0);
            r.setMov_data(r5.getDat());
            r.setTrn_codigo(r5.getTrn() + "");
          } else {

            // -------- Transação ------
            portalbr.dbobj.view.Jw_t_transacao table_transacao = new portalbr.dbobj.view.Jw_t_transacao();
            StringBuilder query4 = new StringBuilder();
            query4.append(" SELECT /*+ all_rows */ ");
            query4.append("        trn_codigo trn ");
            query4.append("      , mov_data dat ");
            query4.append("   FROM mov_receber ");
            query4.append("  WHERE emp_empresa = '").append(r.getEmp_empresa()).append("' ");
            query4.append("    AND fil_filial  = '").append(r.getFil_filial()).append("' ");
            query4.append("    AND tip_codigo  = '").append(r.getTip_codigo()).append("' ");
            query4.append("    AND tit_codigo  = '").append(r.getTit_codigo()).append("' ");
            query4.append("  ORDER BY mov_data ");

            Vector res_Jw_t_transacao = j.select(table_transacao, query4.toString(), null);

            if (res_Jw_t_transacao != null && res_Jw_t_transacao.size() > 0) {
              portalbr.dbobj.view.Jw_t_transacao r6 = (portalbr.dbobj.view.Jw_t_transacao) res_Jw_t_transacao.elementAt(0);
              r.setMov_data(r6.getDat());
              r.setTrn_codigo(r6.getTrn() + "");
            }
          }

          //------- venc orig ----------
          portalbr.dbobj.view.Jw_t_venc_orig table_venc_orig = new portalbr.dbobj.view.Jw_t_venc_orig();
          StringBuilder query5 = new StringBuilder();
          query5.append(" SELECT /*+ all_rows */ ");
          query5.append("        mov_datvenc  md ");
          query5.append("      , mov_cobjur   mc ");
          query5.append("      , mov_condes   mo ");
          query5.append("   FROM mov_receber ");
          query5.append("  WHERE emp_empresa = '").append(r.getEmp_empresa()).append("' ");
          query5.append("    AND fil_filial  = '").append(r.getFil_filial()).append("' ");
          query5.append("    AND tip_codigo  = '").append(r.getTip_codigo()).append("' ");
          query5.append("    AND tit_codigo  = '").append(r.getTit_codigo()).append("' ");
          query5.append("    AND trn_codigo  = 'VCT' ");

          Vector res_Jw_t_venc_orig = j.select(table_venc_orig, query5.toString(), null);

          if (res_Jw_t_venc_orig != null && res_Jw_t_venc_orig.size() > 0) {
            portalbr.dbobj.view.Jw_t_venc_orig r7 = (portalbr.dbobj.view.Jw_t_venc_orig) res_Jw_t_venc_orig.elementAt(0);
            r.setDatvenc(r7.getMd());
            r.setCobjur(r7.getMc() + "");
            r.setCondes(r7.getMo() + "");


          }
          //----------------------------
          if ((r.getCobjur() + "").equals("N")) {
            r.setDatvenc(r.getTit_datvenc());
          }
          //---------------- proc ncc --------------------
          //portalbr.dbobj.view.Jw_t_proc_ncc table_proc_ncc = new portalbr.dbobj.view.Jw_t_proc_ncc();
          //StringBuilder query6 = new StringBuilder();
          //query6.append(" SELECT /*+ all_rows */ ");
          //query6.append("        mov_valor mv ");
          //query6.append("   FROM mov_receber ");
          //query6.append("  WHERE nvl(emp_empresa,null) = '").append(r.getEmp_empresa()).append("' ");
          //query6.append("    AND nvl(fil_filial,null)  = '").append(r.getFil_filial()).append("' ");
          //query6.append("    AND nvl(tip_codigo,null)  = '").append(r.getTip_codigo()).append("' ");
          //query6.append("    AND nvl(trn_codigo,null)  = 'NCC' ");
          //query6.append("    AND tit_codigo            = '").append(r.getTit_codigo()).append("' ");

          //Vector res_Jw_t_proc_ncc = j.select(table_proc_ncc, query6.toString(), null);

          //if (res_Jw_t_proc_ncc != null && res_Jw_t_proc_ncc.size() > 0) {
          //  portalbr.dbobj.view.Jw_t_proc_ncc r8 = (portalbr.dbobj.view.Jw_t_proc_ncc) res_Jw_t_proc_ncc.elementAt(0);
          //  r.setTit_abatim(r8.getMv()+"");
          //}


          //----------- desp_pro -------------
          //portalbr.dbobj.view.Jw_t_desp_pro table_desp_pro = new portalbr.dbobj.view.Jw_t_desp_pro();
          //StringBuilder query7 = new StringBuilder();
          //query7.append(" SELECT mov_valor mv ");
          //query7.append("   FROM mov_receber ");
          //query7.append("  WHERE nvl(emp_empresa,null) = '").append(r.getEmp_empresa()).append("' ");
          //query7.append("    AND nvl(fil_filial,null)  = '").append(r.getFil_filial()).append("' ");
          //query7.append("    AND nvl(tip_codigo,null)  = '").append(r.getTip_codigo()).append("' ");
          //query7.append("    AND nvl(trn_codigo,null)  = 'PRO' ");
          //query7.append("    AND tit_codigo            = '").append(r.getTit_codigo()).append("' ");

          //Vector res_Jw_t_desp_pro = j.select(table_desp_pro, query7.toString(),null);
          //if (res_Jw_t_desp_pro != null && res_Jw_t_desp_pro.size() > 0) {
          //  portalbr.dbobj.view.Jw_t_desp_pro r9 = (portalbr.dbobj.view.Jw_t_desp_pro) res_Jw_t_desp_pro.elementAt(0);
          //  r.setVnc_cartor(r9.getMv()+"");
          //}


          //--- Dif ---
          r.setDif(q.retorna(j, "SELECT ''||abs(trunc(to_date("+data_vencimento + ",'dd/mm/yyyy') - trunc(sysdate))) from dual"));
          //-----------

          Date d1 = FormatDate.parse(sysdate);
          Date d2 = FormatDate.parse(com.egen.util.text.FormatDate.format(r.getDatvenc(), "dd/MM/yyyy"));
          Date d3 = FormatDate.parse(com.egen.util.text.FormatDate.format(r.getTit_datven3(), "dd/MM/yyyy"));

          if (d1.before(d2)) {
            w_tit_dsante = q.retorna(j, "SELECT round(((nvl(" + r.getTit_dsante() + ",0) / 100) * (nvl("+r.getTit_valor() + ",0)) *  nvl("+r.getDif() + ",0)),2) FROM dual");
            w_tit_dspont = q.retorna(j, "SELECT round((nvl("+r.getTit_dspont() + ",0) / 100) * nvl("+r.getTit_valor() + ",0),2) FROM dual");
          }

          if ((!d1.after(d2)) && (!d1.before(d2))) {
            w_tit_dspont = q.retorna(j, "SELECT round((nvl("+r.getTit_dspont() + ",0) / 100) * nvl("+r.getTit_valor() + ",0),2) FROM dual ");
            w_tit_dsante = "0";
          }

          if (d1.after(d3)) {
            w_tit_dspont = "0";
            w_tit_dsante = "0";
            w_tit_vljuro = q.retorna(j, "SELECT round((nvl("+r.getTit_valor() + ",0) -  nvl("+r.getTit_abatim() + ",0)) * ("+taxa + "/100 / 30) *  nvl("+r.getDif() + ",0),2) FROM dual");
          }
          w_tit_vldesc = Double.parseDouble(w_tit_dspont + "") + Double.parseDouble(w_tit_dsante + "");
        }
        // ---status aberto --------------------------------------------------------------------

        if ((r.getTit_status() + "").equals("Liquidado")) {
          w_saldo = r.getTit_vlrec();
          w_liq += w_saldo;
        } else {
          w_saldo = r.getTit_valor();
        }


        if ((!((r.getTrn_codigo() + "").equals("DIS"))) || (r.getTrn_codigo() + "").equals("null")) {

          if ((!(r.getTit_status().equals("Cancelado"))) && (!(r.getTit_status().equals("Liquidado")))) {
            w_saldo = r.getTit_valor() - r.getTit_vlrec() - w_tit_vldesc - Double.parseDouble(r.getTit_abatim() + "");
            w_saldo_tot += w_saldo;
            r.setTit_vlrec(w_saldo);
          }
        }

        w_valor_tot += r.getTit_valor();

      }


      portalbr.dbobj.view.Jw_t_titulos_lista r = (portalbr.dbobj.view.Jw_t_titulos_lista) res_Jw_t_titulos_lista.elementAt(0);
      r.setW_liq(com.egen.util.text.FormatNumber.format(w_liq, "##,##0.00"));
      r.setW_saldo_tot(com.egen.util.text.FormatNumber.format(w_saldo_tot, "##,##0.00"));
      r.setW_valor_tot(com.egen.util.text.FormatNumber.format(w_valor_tot, "##,##0.00"));

    }


    if (!(res_Jw_t_titulos_lista != null && res_Jw_t_titulos_lista.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_t_titulos_lista", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute("mapping.getName()", form);
  }
  public ActionForward perform_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      acesso.Sessao sessao = new acesso.Sessao(session);
      j = new com.egen.util.jdbc.JdbcUtil();
      Titulos_rActionForm f = (Titulos_rActionForm) form;
      util.consultas.Parametros parametros = new util.consultas.Parametros();
      String executa = parametros.retornaParametro("executa_gravacao_movimento_2a_via");
      //  if(executa.equalsIgnoreCase("S")){
      if (false) {
        java.sql.CallableStatement call = null;
        try {
          call = j.getConn().prepareCall("{ call pck_ctr_gera_trn_tit.prc_ctr_ins_mov_tit(?,?,?,?,'OBS',sysdate,to_date(?,'dd/mm/yyyy'),?,?,'N',null,?,null,null,null,null,null,sysdate,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,0,null,null,null,null,null,null,?)  }");
          call.registerOutParameter(9, java.sql.Types.VARCHAR);
          call.setString(1, f.getEmp_empresa1());
          call.setString(2, f.getFil_filial());
          call.setString(3, f.getTip_codigo());
          call.setString(4, f.getTit_codigo());
          call.setString(5, f.getTit_datvenc());
          call.setDouble(6, com.egen.util.text.FormatNumber.toDouble(f.getValor()));
          call.setString(7, "BRCONREC");
          call.setString(8, f.getPrt_codigo());
          call.execute();
          String result = call.getString(9);
        } catch (Exception e) {
          e.printStackTrace(System.out);
        } finally {
          call.close();
        }

        util.consultas.Query query = new util.consultas.Query();
        StringBuilder sb = new StringBuilder();
        sb.append(" select sequencia ");
        sb.append("   from mov_receber ");
        sb.append("  where emp_empresa = '"+f.getEmp_empresa1() + "' ");
        sb.append("    and fil_filial  = '"+f.getFil_filial() + "' ");
        sb.append("    and tip_codigo  = '"+f.getTip_codigo() + "' ");
        sb.append("    and tit_codigo  = '"+f.getTit_codigo() + "' ");
        sb.append("    and mov_data    = trunc(sysdate) ");
        int sequencia = Integer.parseInt(query.retorna(sb.toString()));

        StringBuilder sbc = new StringBuilder();
        sbc.append(" SELECT cli_codigo ");
        sbc.append("   FROM titulos ");
        sbc.append("  where emp_empresa = '"+f.getEmp_empresa1() + "' ");
        sbc.append("    and fil_filial  = '"+f.getFil_filial() + "' ");
        sbc.append("    and tip_codigo  = '"+f.getTip_codigo() + "' ");
        sbc.append("    and tit_codigo  = '"+f.getTit_codigo() + "' ");
        int cli_cdgo = Integer.parseInt(query.retorna(sbc.toString()));

        StringBuilder sbs = new StringBuilder();
        sbs.append(" SELECT esc_seqn");
        sbs.append("   FROM titulos ");
        sbs.append("  where emp_empresa = '"+f.getEmp_empresa1() + "' ");
        sbs.append("    and fil_filial  = '"+f.getFil_filial() + "' ");
        sbs.append("    and tip_codigo  = '"+f.getTip_codigo() + "' ");
        sbs.append("    and tit_codigo  = '"+f.getTit_codigo() + "' ");
        int esc_seqn = Integer.parseInt(query.retorna(sbs.toString()));

        StringBuilder sbd = new StringBuilder();
        sbd.append(" SELECT 'Gerado via link BRPortal / ' || DECODE(t.tien_tipo, NULL, '', ('Tipo: ' || t.tien_tipo || ' (' || e.enne_descricao || ')')) || ' / Usuário: ' || u.usua_usuario || ' / Código: ' || e.enne_chave ");
        sbd.append("   FROM wbrio.tipos_entidade_negocio t ");
        sbd.append("       ,wbrio.entidades_negocio e ");
        sbd.append("       ,wbrio.usuarios u ");
        sbd.append("  WHERE t.tien_id(+) = e.enne_tien_id ");
        sbd.append("    AND e.enne_id(+) = u.usua_enne_id ");
        sbd.append("    AND u.usua_usuario = '"+sessao.getUsuario() + "' ");
        String descricao = query.retorna(sbd.toString());

        java.sql.CallableStatement call2 = null;
        try {
          call2 = j.getConn().prepareCall("{ call pck_ctr_gera_trn_tit.prc_ctr_ins_observa(?,?,?,?,'OBS',sysdate,?,?,?,?,?,54,?) }");
          call2.registerOutParameter(10, java.sql.Types.VARCHAR);
          call2.setString(1, f.getEmp_empresa1());
          call2.setString(2, f.getFil_filial());
          call2.setString(3, f.getTip_codigo());
          call2.setString(4, f.getTit_codigo());
          call2.setInt(5, sequencia);
          call2.setInt(6, cli_cdgo);
          call2.setInt(7, esc_seqn);
          call2.setDouble(8, com.egen.util.text.FormatNumber.toDouble(f.getValor()));
          call2.setString(9, descricao);
          call2.execute();
          String result2 = call2.getString(10);
        } catch (Exception e) {
          e.printStackTrace(System.out);
        } finally {
          call2.close();
        }

      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      e.printStackTrace(System.out);
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_titulos_registros", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
}
