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
 * Creation Date 17/03/2006 11:59:36
 * Last Modify Date 09/02/2023 10:58:31
 */

public class ConsultaNotaFiscalAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ConsultaNotaFiscalActionForm f = (ConsultaNotaFiscalActionForm) form;
      String grupo_economico = "";
      boolean informouFatura = false;
      boolean liberaFatura = false;
      acesso.Sessao sessao = new acesso.Sessao(session);

      if (sessao.getTipoEntidadeNegocio().equals("DESPACHANTE") || sessao.getTipoEntidadeNegocio().equals("TRANSPORTADORA") || sessao.getTipoEntidadeNegocio().equals("AREAS") || sessao.isSuperUsuario()) {
        liberaFatura = true;
      }

      if (f.getAno_fatura() != "" && f.getNumero_fatura() != "") {
        informouFatura = true;
      }
      if (false) {
        if (((!(f.getAno_fatura() != "")) || (!(f.getNumero_fatura() != ""))) && ((!(f.getDt_inicial() != "")) || (!(f.getDt_final() != "")))) {
          throw new Exception("A fatura ou um período devem ser informados!");
        }
      } else {
        if ((((!(f.getAno_fatura() != "")) || (!(f.getNumero_fatura() != ""))) && ((!(f.getDt_inicial() != "")) || (!(f.getDt_final() != "")))) && (!(f.getNfs_nmro() != "")) && (!(f.getFil_filial() != "")) && (!(f.getCodigo_regional() != "")) && (!(f.getRep_cdgo() != "")) && (!(f.getCli_cdgo() != "")) && (!(f.getGre_grupo() != "")) && (!(f.getTra_cdgo() != "")) && (!(f.getNfs_cons() != "")) && (!(f.getNro_romaneio() != ""))) {
          throw new Exception("Um dos campos com <img src='../img/opcional.gif' border='0'/> deve ser informado!");
        }

        if (!informouFatura) {
          if ((!(f.getNfs_nmro() != "")) && (!(f.getCli_cdgo() != "")) && (!(f.getGre_grupo() != "")) && ((f.getTra_cdgo() != ""))) {
            if ((f.getDt_inicial() == "") || (f.getDt_final() == "")) {
              throw new Exception("Data inicial e Data Final devem ser informadas!");
            }
          }
        }

        if (!informouFatura) {
          if ((f.getCodigo_regional() != "") || (f.getRep_cdgo() != "")) {
            if ((!(f.getNfs_nmro() != "")) && (!(f.getCli_cdgo() != "")) && (!(f.getGre_grupo() != "")) && (!(f.getTra_cdgo() != "")) && (!(f.getNro_romaneio() != ""))) {
              if ((f.getDt_inicial() == "") || (f.getDt_final() == "")) {
                throw new Exception("Data inicial e Data Final devem ser informadas!");
              }
            }
          }
        }

        if (!informouFatura) {
          if (f.getNfs_nmro().equals("") && f.getNro_romaneio().equals("")) {
            if ((f.getDt_inicial() == "") || (f.getDt_final() == "")) {
              throw new Exception("Data inicial e Data Final devem ser informadas!");
            }
          }
        }

      }

      select_action(j, mapping, form, request, response);
      if (!(f.getNfs_nmro() != "")) {
        if (f.getGre_grupo() != "") {
          grupo_economico = f.getGre_grupo() + " - "+f.getGre_descricao();
        }
        actionForward = new ActionForward("/com/ConsultaNotaFiscal_rForm.do?&par=0&grupo_economico="+grupo_economico, true);
      } else {
        actionForward = new ActionForward("/com/ConsultaNotaFiscal_rForm.do?&par=1",true);
      }

      if (session.getAttribute("gera_excel") != null) {
        session.removeAttribute("gera_excel");
        actionForward = mapping.findForward("same");
      }
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    ConsultaNotaFiscalActionForm f = (ConsultaNotaFiscalActionForm) form;
    portalbr.dbobj.view.Jw_consulta_notas_fiscais table = new portalbr.dbobj.view.Jw_consulta_notas_fiscais();
    String data_inicial = "null";
    String data_final = "null";
    String filial = "null";
    String esc = "null";
    String data = "";
    String transportadora = "";
    String romaneio = "";
    String parametro_dias_retroativos = "";
    String despachante = null;
    boolean informouFatura = false;
    String parametrosDespesas = "";
    boolean liberaFatura = false;
    acesso.Sessao sessao = new acesso.Sessao(session);

    if (f.getAno_fatura() != "" && f.getNumero_fatura() != "") {
      informouFatura = true;
    }

    if (sessao.getTipoEntidadeNegocio().equals("DESPACHANTE") || sessao.getTipoEntidadeNegocio().equals("TRANSPORTADORA") || sessao.getTipoEntidadeNegocio().equals("AREAS") || sessao.isSuperUsuario()) {
      liberaFatura = true;
    }

    StringBuilder parametros = new StringBuilder();
    acesso.Usuario u = new acesso.Usuario();
    u = (acesso.Usuario) session.getAttribute("User");

    //--- Se o usuário tiver restrição de data ----------------------------------------------------------------------
    String diasRetroativos = "";
    com.egen.util.jdbc.JdbcUtil connection = null;
    try {
      connection = new com.egen.util.jdbc.JdbcUtil();
      portalbr.dbobj.table.Acessos_documentos_interfaces table_acessos = new portalbr.dbobj.table.Acessos_documentos_interfaces();
      String[][] select = null;
      Object[][] where = { {"Acdi_doin_id","=","72"}, {"Acdi_usua_id","=",u.getId()}, {"Acdi_dias_consulta_retroativa",">",0} };
      Vector res_Acessos_documentos_interfaces = connection.select(table_acessos, select, where, null, null, null);
      if (res_Acessos_documentos_interfaces != null && res_Acessos_documentos_interfaces.size() > 0) {
        portalbr.dbobj.table.Acessos_documentos_interfaces r = (portalbr.dbobj.table.Acessos_documentos_interfaces) res_Acessos_documentos_interfaces.elementAt(0);
        diasRetroativos = r.getAcdi_dias_consulta_retroativa() + "";
      } else {
        if (u.getDiasConsultaRetroativa() != null && u.getDiasConsultaRetroativa() > 0) {
          diasRetroativos = u.getDiasConsultaRetroativa() + "";
        }
      }
    } catch (Exception e) {
      throw e;
    } finally {
      if (connection != null) {
        connection.close();
        connection = null;
      }
    }

    if ((!(diasRetroativos.equals(""))) && (!(diasRetroativos.equals("0")))) {
      parametro_dias_retroativos = " and trunc(n.nfs_dtemis) >= trunc(sysdate)-"+diasRetroativos;
    }



    if ((liberaFatura && informouFatura)) {
      if (sessao.getTipoEntidadeNegocio().equals("DESPACHANTE")) {
        despachante = sessao.getChave();
      }
      if (f.getAno_fatura() != "" && f.getNumero_fatura() != "") {
        util.consultas.Query query = new util.consultas.Query();
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT 'S' ");
        sb.append("   FROM faturas_proformas fp ");
        sb.append("  WHERE fp.empresa_fatura_proforma = '01' ");
        sb.append("    AND fp.ano_fatura_proforma = "+f.getAno_fatura());
        sb.append("    AND fp.numero_fatura_proforma = "+f.getNumero_fatura());
        if (sessao.getTipoEntidadeNegocio().equals("TRANSPORTADORA")) {
          sb.append(" AND fp.codigo_transportadora = " + sessao.getChave());
        }
        if (sessao.getTipoEntidadeNegocio().equals("DESPACHANTE")) {
          sb.append("    AND fp.codigo_pessoa_despachante = " + despachante);
        }
        String existe = query.retorna(j, sb.toString());
        if (!existe.equalsIgnoreCase("S")) {
          throw new Exception("Fatura inexistente!");
        }
      }
    }


    //--- Monta os parâmetros para a query -----------------------------------------------------------
    //--- Se o usuário logado for regional -----------
    if ((!(f.getReg().equals("")))) {
      parametros.append(" and r.codigo_regional = nvl(").append(f.getReg()).append(",r.codigo_regional) ");
    }
    //--- Se o usuário logado for representante --------
    if ((!(f.getRep().equals("")))) {
      parametros.append(" and r.rep_cdgo = ").append(f.getRep());
    }
    //-----------------------------------------------------
    if ((!(f.getCodigo_regional().equals("")))) {
      parametros.append(" and r.codigo_regional = nvl(").append(f.getCodigo_regional()).append(",r.codigo_regional) ");
    }
    if ((!(f.getRep_cdgo().equals("")))) {
      parametros.append(" and r.rep_cdgo = ").append(f.getRep_cdgo());
    }

    if (!f.getSigla_transportadora().equals("")) {
      parametros.append(" AND EXISTS (SELECT 1 ");
      parametros.append("               FROM transportadoras_municipios tm ");
      parametros.append("              WHERE m.codigo = tm.cod_municipio ");
      parametros.append("                AND m.est_unifed = tm.unifed ");
      parametros.append("                AND n.tra_cdgo = tm.cod_transportadora ");
      parametros.append("                AND tm.sigla_filial_transp = '"+f.getSigla_transportadora().toUpperCase() + "' ");
      parametros.append("             ) ");
    }


    if (f.getDt_inicial() != "") {
      data_inicial = "'"+f.getDt_inicial() + "'";
    }
    if (f.getDt_final() != "") {
      data_final = "'"+f.getDt_final() + "'";
    }
    if (f.getFil_filial() != "") {
      filial = "'"+f.getFil_filial() + "'";
    }
    if (f.getEsc_seqn() != "") {
      esc = f.getEsc_seqn();
    }
    if (f.getNfs_nmro() != "") {
      parametros.append(" and  n.nfs_nmro = ").append(f.getNfs_nmro());
    }
    if (f.getCli_cdgo() != "") {
      parametros.append(" and  n.cli_cdgo = ").append(f.getCli_cdgo());
    }
    if (f.getCodigo_marca() != "") {
      parametros.append(" and fct_marca_produto(nfi.lin_cdgo, nfi.ref_cdgo) = ").append(f.getCodigo_marca());
    }

    if (f.getAno_fatura() != "") {
      parametros.append(" AND fp.ano_fatura_proforma = ").append(f.getAno_fatura());
    }

    if (f.getNumero_fatura() != "") {
      parametros.append(" AND fp.numero_fatura_proforma = ").append(f.getNumero_fatura());
    }

    //add por david cardoso
    if (f.getDt_inicial() != "") {
      data = " AND nfs_dtemis >= to_date(" + data_inicial + ", 'dd/mm/yyyy') ";
    }
    if (f.getDt_final() != "") {
      if (data.equals("")) {
        data = " AND nfs_dtemis <= to_date(" + data_final + ", 'dd/mm/yyyy') ";
      } else {
        data = data + " AND nfs_dtemis <= to_date(" + data_final + ", 'dd/mm/yyyy') ";
      }
    }
    if (f.getTra_cdgo() != "") {
      String tipo = sessao.getTipoEntidadeNegocio();
      if (tipo.equals("TRANSPORTADORA")) {
        util.consultas.Query query = new util.consultas.Query();
        String csg = query.retorna("SELECT t.tra_trans_consig from tra t where t.tra_cdgo = " + sessao.getChave());
        if (csg.equalsIgnoreCase("S")) {
          transportadora = " AND ((n.nfs_cons = NVL("+f.getTra_cdgo() + ", n.nfs_cons) OR p.ped_cons = NVL("+f.getTra_cdgo() + ", p.ped_cons)) OR NVL(n.tra_cdgo, NULL) = "+f.getTra_cdgo() + ") ";
        } else {
          if (sessao.getChave().equalsIgnoreCase("950")) {
            transportadora = " AND (NVL(n.tra_cdgo,null) = " + f.getTra_cdgo() + " or n.cli_cdgo = 46938)";

          } else {
            transportadora = " AND NVL(n.tra_cdgo,null) = " + f.getTra_cdgo();
          }
        }
      } else {
        transportadora = " AND NVL(n.tra_cdgo,null) = " + f.getTra_cdgo();
      }
      session.setAttribute("descricao_transportadora",f.getDesc_tra());
    } else {
      session.setAttribute("descricao_transportadora","");
    }

    if (f.getNro_romaneio() != "") {
      romaneio = " AND n.nro_romaneio_embarque = " + f.getNro_romaneio();
    }

    if (f.getNfs_cons() != "") {
      parametros.append("   AND (n.nfs_cons = NVL("+f.getNfs_cons() + ", n.nfs_cons) OR p.ped_cons = NVL("+f.getNfs_cons() + ", p.ped_cons)) ");
    }

    StringBuilder grupo = new StringBuilder();
    if (f.getGre_grupo() != "") {
      java.sql.PreparedStatement pstm_oracle = null;
      java.sql.ResultSet rset = null;
      try {
        int contador = 1;
        connection = new com.egen.util.jdbc.JdbcUtil();
        pstm_oracle = connection.getConn().prepareStatement(new StringBuilder(" SELECT g.cli_cdgo ").append("      , g.gre_descricao ").append("   FROM grupo_economico g ").append("      , cli c ").append("  WHERE c.cli_cdgo = g.cli_cdgo ").append("    AND c.cli_situ = 'A' ").append("    AND g.status = 'A' ").append("    AND gre_grupo = ").append(f.getGre_grupo()).toString());
        rset = pstm_oracle.executeQuery();
        while (rset.next()) {
          if (contador == 1) {
            f.setGre_descricao(rset.getString(2));
            grupo.append(" and a.cli_cdgo in (").append(rset.getString(1));
          } else {
            grupo.append(",").append(rset.getString(1));
          }
          contador ++;
        }
        if (contador > 1) {
          grupo.append(")");
        }

      } catch (Exception e) {
        throw e;
      } finally {
        if (rset != null) {
          rset.close();
        }
        if (pstm_oracle != null) {
          pstm_oracle.close();
        }
        if (connection != null) {
          connection.close();
          connection = null;
        }
      }
    }

    StringBuilder sbOcorrencias = new StringBuilder();
    StringBuilder sbTo = new StringBuilder();
    if (session.getAttribute("listaTipoOcorrencias") != null) {
      java.util.List < String > tipoOcorrencias = (java.util.List < String >) session.getAttribute("listaTipoOcorrencias");
      for (String s :
          tipoOcorrencias) {
        if (sbTo.length() == 0) {
          sbTo.append(s);
        } else {
          sbTo.append(","+s);
        }
      }
      sbOcorrencias.append(" AND EXISTS ( SELECT 1 ");
      sbOcorrencias.append("                FROM fretes.conhecimentos_frt_ocorrencias cfo ");
      sbOcorrencias.append("               WHERE cfo.emp_empresa = n.emp_empresa ");
      sbOcorrencias.append("                 AND cfo.filial = n.fil_filial ");
      sbOcorrencias.append("                 AND cfo.nfs_nmro = n.nfs_nmro ");
      sbOcorrencias.append("                 AND cfo.nfs_serie = n.nfs_serie ");
      sbOcorrencias.append("                 AND cfo.mot_codigo IN ("+sbTo.toString() + ")  ) ");
    }


    StringBuilder query = new StringBuilder();
    if (despachante != null) {
      //query.append(" SELECT /*+ all_rows */ nota ");
      query.append(" SELECT /*+ rule */ nota ");
      query.append("       ,emp_empresa ");
      query.append("       ,fil_filial ");
      query.append("       ,cc ");
      query.append("       ,ecl_cdad ");
      query.append("       ,est_unifed ");
      query.append("       ,linha ");
      query.append("       ,nfs_dtemis ");
      query.append("       ,nfs_nmro ");
      query.append("       ,nfs_serie ");
      query.append("       ,nfs_valicm ");
      query.append("       ,nfs_qtdvol ");
      query.append("       ,qtde_de_notas ");
      query.append("       ,nfs_vltot ");
      query.append("       ,sigla_trans ");
      query.append("       ,nro_romaneio_embarque ");
      query.append("       ,finalizacao_romaneio ");
      query.append("       ,nfs_total_pares ");
      query.append("       ,conhecimentos ");
      query.append("       ,placa_veiculo ");
      query.append("       ,cubagem ");
      query.append("       ,cons ");
      query.append("       ,conhecimento ");
      query.append("       ,ped_nmro ");
      query.append("       ,chave_nfe ");
      query.append("       ,taxa_dolar ");
      query.append("       ,nfs_pesbru ");
      query.append("       ,nfs_pesliq ");
      query.append("       ,linha_cdgo ");
      query.append("       ,ref_cdgo ");
      if (f.getGera_excel().equalsIgnoreCase("id")) {
        query.append("       ,cab_cdgo ");
        query.append("       ,cor_cdgo ");
        query.append("       ,tamanho ");
        query.append("       ,id ");
        query.append("       ,nfi_descricao ");
        query.append("       ,ncm ");
        if (true) {
          query.append("    ,total_pares ");
          query.append("    ,fct_retorna_vlr_item_fp_by_nf(emp_empresa, fil_filial, nfs_nmro, nfs_serie, nfi_seqitem) nfi_vlunit ");
          query.append("    ,cfop ");
          query.append("    ,nfi_seqitem ");
          query.append("    ,qtrib ");
        } else {
          query.append("       ,(SELECT SUM(nif.total_pares) total_pares ");
          query.append("           FROM nf_item             nfi ");
          query.append("               ,numeracoes_itens_nf nif ");
          query.append("          WHERE nfi.emp_empresa = nif.emp_empresa ");
          query.append("            AND nfi.fil_filial = nif.fil_filial ");
          query.append("            AND nfi.nfs_serie = nif.nfs_serie ");
          query.append("            AND nfi.nfs_nmro = nif.nfs_nmro ");
          query.append("            AND nif.nfi_seqitem = nfi.nfi_seqitem ");
          query.append("            AND nfi.emp_empresa = nf.emp_empresa ");
          query.append("            AND nfi.fil_filial = nf.fil_filial ");
          query.append("            AND nfi.nfs_nmro = nf.nfs_nmro ");
          query.append("            AND nfi.nfs_serie = nf.nfs_serie ");
          query.append("            AND nfi.lin_cdgo = nf.linha_cdgo ");
          query.append("            AND nfi.ref_cdgo = nf.ref_cdgo ");
          query.append("            AND nfi.cab_cdgo = nf.cab_cdgo ");
          query.append("            AND nfi.cor_cdgo = nf.cor_cdgo ");
          query.append("            AND nif.numero = nf.tamanho) total_pares ");
          query.append("       ,nfi_vlunit ");
        }
      }
      query.append("   FROM ( ");
    }


    query.append(" SELECT /*+ all_rows */ DISTINCT n.nfs_nmro || ' - ' || n.nfs_serie nota ");
    if (f.getGera_excel().equalsIgnoreCase("id")) {
      query.append("   , nfi.nfi_seqitem ");
    }
    query.append("      , n.emp_empresa ");
    query.append("      , n.fil_filial ");
    query.append("      , n.cli_cdgo || ' - ' || cliente.cli_rzao cc ");
    query.append("      , cliente.ecl_cdad ");
    query.append("      , cliente.est_unifed ");
    query.append("      , nfi.lin_cdgo||' - '||gpf.descricao_grupo linha ");
    query.append("      , n.nfs_dtemis ");
    query.append("      , n.nfs_nmro ");
    query.append("      , n.nfs_serie ");
    query.append("      , n.nfs_valicm ");
    query.append("      , (SELECT CASE ");
    query.append("                 WHEN volume_nota IS NULL THEN ");
    query.append("                  (SELECT SUM(nn.nfs_qtdvol) ");
    query.append("                     FROM nf_saida                   nn ");
    query.append("                        , notas_fiscais_saida_requis nfr ");
    query.append("                    WHERE nn.emp_empresa = nfr.emp_empresa ");
    query.append("                      AND nn.fil_filial = nfr.fil_filial ");
    query.append("                      AND nn.nfs_nmro = nfr.nfs_nmro ");
    query.append("                      AND nn.nfs_serie = nfr.nfs_serie ");
    query.append("                      AND nn.emp_empresa = n.emp_empresa ");
    query.append("                      AND nn.fil_filial = n.fil_filial ");
    query.append("                      AND nn.nfs_nmro = n.nfs_nmro ");
    query.append("                      AND nn.nfs_serie = n.nfs_serie) ");
    query.append("                 ELSE ");
    query.append("                  volume_nota ");
    query.append("                 END nota ");
    query.append("            FROM (SELECT SUM(DECODE(pp.ped_especie_pedido, 'A', nn.nfs_qtdvol, (NVL(DECODE(fct_calcula_volumes_new(pp.ped_nmro), 0, fct_calcula_volumes_ped(pp.ped_nmro), fct_calcula_volumes_new(pp.ped_nmro)), 0)))) volume_nota ");
    query.append("                    FROM nf_saida                      nn ");
    query.append("                       , notas_fiscais_saida_ped_venda nfp ");
    query.append("                       , ped                           pp ");
    query.append("                   WHERE nn.emp_empresa = nfp.emp_empresa ");
    query.append("                     AND nn.fil_filial = nfp.fil_filial ");
    query.append("                     AND nn.nfs_nmro = nfp.nfs_nmro ");
    query.append("                     AND nn.nfs_serie = nfp.nfs_serie ");
    query.append("                     AND pp.ped_nmro = nfp.ped_nmro ");
    query.append("                     AND nn.emp_empresa = n.emp_empresa ");
    query.append("                     AND nn.fil_filial = n.fil_filial ");
    query.append("                     AND nn.nfs_nmro = n.nfs_nmro ");
    query.append("                     AND nn.nfs_serie = n.nfs_serie ");
    query.append("                  )) nfs_qtdvol ");
    query.append("      , COUNT(n.nfs_nmro) OVER(PARTITION BY n.nro_romaneio_embarque) qtde_de_notas ");
    query.append("      , n.nfs_vltot ");
    if (despachante != null) {
      query.append("   , '' sigla_trans ");
    } else {
      query.append("   , case when m.codigo is not null and m.est_unifed is not null and n.tra_cdgo is not null then ((SELECT rowtocol('(SELECT DISTINCT tm.sigla_filial_transp ");
      query.append("                   FROM transportadoras_municipios tm ");
      query.append("                  WHERE '||m.codigo||' = tm.cod_municipio ");
      query.append("                    AND '''||m.est_unifed||''' = tm.unifed ");
      query.append("                    AND '''||n.tra_cdgo||''' = tm.cod_transportadora )') FROM dual)) end sigla_trans ");
    }
    query.append("      , n.nro_romaneio_embarque ");
    query.append("      , re.data_finalizacao finalizacao_romaneio ");
    if (despachante != null) {
      query.append("   , (select sum(nfii.nfi_qtde) from nf_item nfii where nfii.nfs_nmro = n.nfs_nmro and nfii.emp_empresa = n.emp_empresa and nfii.fil_filial = n.fil_filial and nfii.nfs_serie = n.nfs_serie and nfii.lin_cdgo = nfi.lin_cdgo and nfii.ref_cdgo = nfi.ref_cdgo) nfs_total_pares ");
    } else {
      query.append("   , n.nfs_total_pares  ");
    }

    query.append("      , NVL((SELECT NVL(cf.numero,0) || '#' || NVL(cf.peso,0) || '#' || NVL(brio.fct_rateio_frete(n.emp_empresa, n.fil_filial, n.nfs_nmro, n.nfs_serie),0)   ");
    query.append("               FROM conhecimentos_fretes cf   ");
    query.append("                  , nf_saida_conhecimentos_fretes s   ");
    query.append("              WHERE s.confrt_numero = cf.numero   ");
    query.append("                AND s.confrt_fen_for_codigo = cf.fen_for_codigo   ");
    query.append("                AND s.confrt_fen_seq = cf.fen_seq   ");
    query.append("                AND s.confrt_data_cad = cf.data_cad   ");
    query.append("                AND s.confrt_serie = cf.serie ");
    query.append("                AND s.confrt_tipo_nota = cf.tipo_nota  ");
    query.append("                AND cf.peso IS NOT NULL ");
    query.append("                AND s.nfs_nmro = n.nfs_nmro   ");
    query.append("                AND s.nfs_serie = n.nfs_serie   ");
    query.append("                AND s.nfs_fil_filial = n.fil_filial ");
    query.append("                AND rownum=1),'-'||'#'||nvl(n.nfs_pesbru,0)||'#'||nvl(n.nfs_frete_faturamento,0)) conhecimentos ");
    query.append("      , n.placa_veiculo ");
    if (despachante != null) {
      query.append("   , 0.0 cubagem ");
    } else {
      query.append("   , 0.0 cubagem ");
      //     query.append("      , fct_peso_cubagem_nota(n.emp_empresa, n.fil_filial, n.nfs_nmro, n.nfs_serie) cubagem ");
    }
    query.append("      , decode(n.nfs_cons,null,'', (n.nfs_cons || ' - ' || t.tra_rzao)) cons ");
    if (despachante != null) {
      query.append("   , '' conhecimento ");
    } else {
      query.append("      , fretes.fct_retorna_ultima_ocorrencia(n.emp_empresa,n.fil_filial,n.nfs_nmro,n.nfs_serie) ocorrencia  ");
    }
    query.append("      , rowtocol('SELECT x.ped_nmro FROM notas_fiscais_saida_ped_venda x WHERE x.emp_empresa = ''' || n.emp_empresa || ''' AND x.fil_filial = ''' || n.fil_filial || ''' AND x.nfs_serie = ''' || n.nfs_serie || ''' AND x.nfs_nmro = ' || n.nfs_nmro) ped_nmro ");
    query.append("      , n.chave_nfe ");
    if (despachante != null) {
      query.append("   , (SELECT cot_vlreal FROM cotacoes WHERE moe_codigo = fp.codigo_moeda AND cot_data = TRUNC(nfs_dtemis)) taxa_dolar ");
    } else {
      query.append("   , -1 taxa_dolar ");
    }
    query.append("      , n.nfs_pesbru ");
    query.append("      , n.nfs_pesliq ");
    query.append("      , nfi.lin_cdgo linha_cdgo ");
    query.append("      , nfi.ref_cdgo ref_cdgo ");

    if (f.getGera_excel().equalsIgnoreCase("id")) {
      query.append("   , nfi.cab_cdgo ");
      query.append("   , nfi.cor_cdgo ");
      query.append("   , ni.numero tamanho ");
      query.append("   , fct_ies_codigo_nativo(nfi.itest_codigo, ni.cor_cdgo, ni.numero) id ");
      query.append("   , nfi.nfi_descricao || nfi.complemento nfi_descricao ");
      //   query.append("   , NVL(pck_item_estoque.get_classificacao_fiscal(brio.fct_ies_codigo(nfi.lin_cdgo, nfi.ref_cdgo, nfi.cab_cdgo)), ' ') ncm ");
      query.append("   , (SELECT codigo_ncm FROM ipi WHERE ipi_codred = nfi.ipi_codred) ncm ");
      query.append("   , ni.total_pares ");
      query.append("   , (SELECT ifp.preco_unitario ");
      query.append("        FROM itens_faturas_proformas ifp ");
      query.append("       WHERE ifp.empresa_fatura_proforma = fp.empresa_fatura_proforma ");
      query.append("         AND ifp.ano_fatura_proforma = fp.ano_fatura_proforma ");
      query.append("         AND ifp.numero_fatura_proforma = fp.numero_fatura_proforma ");
      query.append("         AND ifp.codigo_linha = nfi.lin_cdgo ");
      query.append("         AND ifp.codigo_referencia = nfi.ref_cdgo ");
      query.append("         AND ifp.codigo_cabedal = nfi.cab_cdgo ");
      query.append("         AND nvl(ifp.item_cancelado,'N') = 'N' ");
      query.append("         AND ifp.codigo_cor = nfi.cor_cdgo ");
      query.append("         AND rownum = 1) nfi_vlunit ");
      query.append("   , nfi.cfop ");
      query.append("   , brfat.fct_get_qtrib(n.emp_empresa, n.fil_filial, n.nfs_nmro, n.nfs_serie, nfi.nfi_seqitem) qtrib ");
    }

    query.append("      , pck_filial.get_cnpj(n.fil_filial,n.emp_empresa) fil_cgc ");
    query.append("      , n.tra_cdgo ");
    query.append("      , fct_retorna_fil_producao(p.ped_nmro, 1) fil_prod ");
    query.append("   FROM nf_item nfi ");
    query.append("      , nf_saida n ");
    if (despachante != null || (liberaFatura && informouFatura)) {
      query.append("   , ite i ");
      query.append("   , faturas_proformas fp ");
    }
    if (f.getGera_excel().equalsIgnoreCase("id")) {
      query.append("   , numeracoes_itens_nf ni ");
    }
    query.append("      , ped p ");
    query.append("      , rep r ");
    query.append("      , tra t ");
    query.append("      , grupo_posicao_fabrica gpf ");
    query.append("      , romaneios_embarque re ");
    query.append("      , municipios m ");
    query.append("      , (SELECT a.cli_cdgo cli_cdgo_cliente ");
    query.append("              , a.cli_rzao    ");
    query.append("              , c.est_unifed  ");
    query.append("              , ecl_cdad      ");
    query.append("              , b.esc_seqn    ");
    query.append("              , b.cli_cdgo    ");
    query.append("           FROM cli a         ");
    query.append("              , esc b         ");
    query.append("              , ecl c         ");
    query.append("          WHERE b.esc_seqn  = c.esc_seqn ");
    query.append("            AND a.cli_cdgo  = b.cli_cdgo ");
    query.append("            AND b.cli_cdgo  = c.cli_cdgo ");

    if (f.getEst_unifed() != "") {
      query.append("         AND nvl(c.est_unifed, null) = '"+f.getEst_unifed().toUpperCase() + "' ");
    }

    query.append("            AND (c.ned_cdgo = 'UNI' or c.ned_cdgo = 'ENT') ");
    query.append("            ").append(grupo.toString()).append(") cliente ");
    query.append("  WHERE nfi.nfs_nmro    = n.nfs_nmro ");
    if (despachante != null || (liberaFatura && informouFatura)) {
      if (sessao.getTipoEntidadeNegocio().equals("TRANSPORTADORA")) {
        query.append("         AND fp.codigo_transportadora = " + sessao.getChave());
      }
      if (sessao.getTipoEntidadeNegocio().equals("DESPACHANTE")) {
        query.append("         AND fp.codigo_pessoa_despachante = " + despachante);
      }
      query.append("         AND i.ped_nmro = p.ped_nmro ");
      query.append("         AND fp.empresa_fatura_proforma = '01' ");
      query.append("         AND i.empresa_fatura_proforma = fp.empresa_fatura_proforma ");
      query.append("         AND i.ano_fatura_proforma = fp.ano_fatura_proforma ");
      query.append("         AND i.numero_fatura_proforma = fp.numero_fatura_proforma ");
      query.append("         AND p.ped_invoice = LPAD(fp.numero_fatura_proforma, 4, 0) || '/' || fp.ano_fatura_proforma ");
      query.append("         AND p.ped_nmro = n.ped_nmro ");
    } else {
      query.append("    AND p.ped_nmro (+) = n.ped_nmro ");
    }


    if (f.getDesconsidera_notas_entrada().equalsIgnoreCase("S")) {
      query.append(" AND NOT EXISTS (SELECT NULL ");
      query.append("                   FROM devolucoes_mercadorias d ");
      query.append("                  WHERE d.nfs_numero = n.nfs_nmro ");
      query.append("                    AND d.nfs_serie = n.nfs_serie ");
      query.append("                    AND d.nfs_fil_filial = n.fil_filial ");
      query.append("                    AND d.nfs_emp_empresa = n.emp_empresa) ");
    }

    if (f.getRomaneio().equalsIgnoreCase("S")) {
      query.append(" AND  EXISTS (SELECT DISTINCT re.situacao ");
      query.append("                FROM romaneios_embarque re ");
      query.append("               WHERE re.numero = n.nro_romaneio_embarque ");
      query.append("                 AND re.situacao = 'A') ");
    }

    if (f.getRomaneio().equalsIgnoreCase("N")) {
      query.append(" AND n.nro_romaneio_embarque IS NULL ");
    }

    if (f.getGera_excel().equalsIgnoreCase("id")) {
      query.append("   AND ni.emp_empresa = n.emp_empresa ");
      query.append("   AND ni.fil_filial = n.fil_filial ");
      query.append("   AND ni.nfs_nmro = n.nfs_nmro ");
      query.append("   AND ni.nfs_serie = n.nfs_serie ");
      query.append("   AND ni.nfi_seqitem = nfi.nfi_seqitem ");
    }

    query.append(transportadora);
    query.append("    AND cliente.ecl_cdad = m.descricao(+)     ");
    query.append("    AND cliente.est_unifed = m.est_unifed(+)  ");
    query.append("    AND n.nro_romaneio_embarque = re.numero (+)   ");
    query.append("    AND r.rep_cdgo   (+) = n.rep_cdgo          ");
    query.append("    AND fct_tipo_produto(nfi.lin_cdgo, nfi.ref_cdgo) = gpf.codigo_grupo(+) ");
    if (despachante == null) {
      if (!f.getGera_excel().equalsIgnoreCase("id")) {
        query.append("    AND nfi.nfi_seqitem = 1                   ");
      }
    }

    if (f.getEmp_empresa() != "") {
      query.append("    AND nvl(n.emp_empresa, null) = '"+f.getEmp_empresa() + "' ");
    }

    if ((f.getCb_notas_fretes() + "").equals("checked")) {
      query.append("    AND nvl(n.natoper_codigo,NULL) IN (1,28,29,276,359) ");
      query.append("    AND nvl(n.ped_especie_pedido,'R') <> 'R' ");
    }

    if ((f.getCb_notas_remessa() + "").equals("checked")) {
      query.append("    AND nvl(n.natoper_codigo,NULL) IN (505) ");
    }


    if ((f.getCb_amostra() + "").equals("checked")) {
      query.append("  AND p.ped_especie_pedido  = 'A' ");
    }

    if ((f.getCb_brindes() + "").equals("checked")) {
      query.append("    AND n.natoper_codigo = 18 ");
    }

    if ((f.getCb_sem_ocorrencia_entrega() + "").equals("checked")) {
      query.append(" AND NOT EXISTS (SELECT 1 ");
      query.append("                   FROM fretes.conhecimentos_frt_ocorrencias cfo ");
      query.append("                  WHERE cfo.emp_empresa = n.emp_empresa ");
      query.append("                    AND cfo.filial = n.fil_filial ");
      query.append("                    AND cfo.nfs_nmro = n.nfs_nmro ");
      query.append("                    AND cfo.nfs_serie = n.nfs_serie ");
      query.append("                    AND cfo.mot_codigo = 1) ");
    }

    if ((f.getCb_notas_em_devolucao() + "").equals("checked")) {
      query.append(" AND EXISTS (SELECT 1 ");
      query.append("               FROM devolucoes_mercadorias dm ");
      query.append("              WHERE dm.nfs_emp_empresa = n.emp_empresa ");
      query.append("                AND dm.nfs_fil_filial = n.fil_filial ");
      query.append("                AND dm.nfs_numero = n.nfs_nmro ");
      query.append("                AND dm.nfs_serie = n.nfs_serie) ");
    }

    query.append("    AND nfi.emp_empresa = n.emp_empresa       ");
    query.append("    AND nfi.fil_filial  = n.fil_filial        ");
    query.append("    AND nfi.nfs_serie   = n.nfs_serie         ");

    query.append(parametros.toString());
    query.append("    AND n.esc_seqn = decode(").append(esc).append(", null, n.esc_seqn, ").append(esc).append(")  ");

    query.append(data);

    query.append("    AND nvl(n.stat_codigo, null) <> 1  ");
    query.append("    AND n.fil_filial             = nvl(").append(filial).append(",n.fil_filial) ");
    query.append("    AND cliente.cli_cdgo_cliente = n.cli_cdgo ");
    query.append("    AND cliente.esc_seqn         = n.esc_seqn ");
    query.append("    AND t.tra_cdgo (+) = n.nfs_cons  ");

    if (session.getAttribute("especies") != null) {
      String especie = (String) session.getAttribute("especies");
      if (!especie.equalsIgnoreCase("")) {
        query.append("  AND NVL(p.ped_especie_pedido, NULL) IN ("+especie + ")  ");
      }
    }

    query.append(romaneio);
    query.append(parametro_dias_retroativos);
    query.append(sbOcorrencias.toString());
    if (despachante != null) {

      if (!f.getGera_excel().equalsIgnoreCase("id")) {
        query.append("  ORDER BY nfs_dtemis, n.nfs_nmro, n.fil_filial, n.nfs_serie, nfi.lin_cdgo, nfi.ref_cdgo ) nf ");
      } else {
        query.append("  ORDER BY nfs_dtemis, n.nfs_nmro, n.fil_filial, n.nfs_serie, nfi.lin_cdgo, nfi.ref_cdgo, nfi_seqitem ) nf ");
      }

    } else if (f.getGera_excel().equalsIgnoreCase("id")) {
      query.append("  ORDER BY nfs_dtemis, n.nfs_nmro , n.nfs_serie, nfi_seqitem ");
    } else {
      query.append("  ORDER BY nfs_dtemis ");
    }

    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");

    if (f.getGera_excel().equalsIgnoreCase("nf")) {
      query = new StringBuilder();
      query.append(" SELECT  ");
      query.append("        DISTINCT n.nfs_nmro nota ");
      query.append("               , n.nfs_serie serie ");
      query.append("               , nfi.lin_cdgo linha_cdgo ");
      query.append("               , nfi.ref_cdgo ref_cdgo ");
      query.append("               , nfi.cab_cdgo ");
      query.append("               , nfi.cor_cdgo ");
      query.append("               , (SELECT MIN(ni.numero) ");
      query.append("                    FROM numeracoes_itens_nf ni ");
      query.append("                   WHERE ni.emp_empresa = n.emp_empresa ");
      query.append("                     AND ni.fil_filial = n.fil_filial ");
      query.append("                     AND ni.nfs_nmro = n.nfs_nmro ");
      query.append("                     AND ni.nfs_serie = n.nfs_serie ");
      query.append("                     AND ni.nfi_seqitem = nfi.nfi_seqitem) tamanho ");
      query.append("               , fct_ies_codigo_nativo(nfi.itest_codigo, nfi.cor_cdgo, (SELECT MIN(ni.numero) ");
      query.append("                                           FROM numeracoes_itens_nf ni ");
      query.append("                                          WHERE ni.emp_empresa = n.emp_empresa ");
      query.append("                                            AND ni.fil_filial = n.fil_filial ");
      query.append("                                            AND ni.nfs_nmro = n.nfs_nmro ");
      query.append("                                            AND ni.nfs_serie = n.nfs_serie ");
      query.append("                                            AND ni.nfi_seqitem = nfi.nfi_seqitem)) ID ");
      query.append("               , to_char(n.nfs_dtemis, 'dd/mm/yyyy') nfs_dtemis ");
      query.append("               , (SELECT CASE ");
      query.append("                           WHEN volume_nota IS NULL THEN ");
      query.append("                            (SELECT SUM(nn.nfs_qtdvol) ");
      query.append("                               FROM nf_saida                   nn ");
      query.append("                                   ,notas_fiscais_saida_requis nfr ");
      query.append("                              WHERE nn.emp_empresa = nfr.emp_empresa ");
      query.append("                                AND nn.fil_filial = nfr.fil_filial ");
      query.append("                                AND nn.nfs_nmro = nfr.nfs_nmro ");
      query.append("                                AND nn.nfs_serie = nfr.nfs_serie ");
      query.append("                                AND nn.emp_empresa = n.emp_empresa ");
      query.append("                                AND nn.fil_filial = n.fil_filial ");
      query.append("                                AND nn.nfs_nmro = n.nfs_nmro ");
      query.append("                                AND nn.nfs_serie = n.nfs_serie) ");
      query.append("                           ELSE ");
      query.append("                            volume_nota ");
      query.append("                         END nota ");
      query.append("                    FROM (SELECT SUM(DECODE(pp.ped_especie_pedido, 'A', nn.nfs_qtdvol, (NVL(DECODE(fct_calcula_volumes_new(pp.ped_nmro), 0, fct_calcula_volumes_ped(pp.ped_nmro), fct_calcula_volumes_new(pp.ped_nmro)), 0)))) volume_nota ");
      query.append("                            FROM nf_saida                      nn ");
      query.append("                               , notas_fiscais_saida_ped_venda nfp ");
      query.append("                               , ped                           pp ");
      query.append("                           WHERE nn.emp_empresa = nfp.emp_empresa ");
      query.append("                             AND nn.fil_filial = nfp.fil_filial ");
      query.append("                             AND nn.nfs_nmro = nfp.nfs_nmro ");
      query.append("                             AND nn.nfs_serie = nfp.nfs_serie ");
      query.append("                             AND pp.ped_nmro = nfp.ped_nmro ");
      query.append("                             AND nn.emp_empresa = n.emp_empresa ");
      query.append("                             AND nn.fil_filial = n.fil_filial ");
      query.append("                             AND nn.nfs_nmro = n.nfs_nmro ");
      query.append("                             AND nn.nfs_serie = n.nfs_serie)) nfs_qtdvol ");
      query.append("               , n.nfs_vltot ");
      query.append("               , n.nfs_vltot valorliq ");
      query.append("               , n.nfs_total_pares ");
      query.append("               , -1 taxa_dolar ");
      query.append("               , n.chave_nfe ");
      query.append("               , (SELECT codigo_ncm ");
      query.append("                    FROM ipi ");
      query.append("                   WHERE ipi_codred = nfi.ipi_codred) ncm ");
      query.append("               , nfi.nfi_descricao || nfi.complemento nfi_descricao ");
      query.append("               , (SELECT ifp.preco_unitario ");
      query.append("                    FROM itens_faturas_proformas ifp ");
      query.append("                   WHERE ifp.empresa_fatura_proforma = fp.empresa_fatura_proforma ");
      query.append("                     AND ifp.ano_fatura_proforma = fp.ano_fatura_proforma ");
      query.append("                     AND ifp.numero_fatura_proforma = fp.numero_fatura_proforma ");
      query.append("                     AND ifp.codigo_linha = nfi.lin_cdgo ");
      query.append("                     AND ifp.codigo_referencia = nfi.ref_cdgo ");
      query.append("                     AND ifp.codigo_cabedal = nfi.cab_cdgo ");
      query.append("                     AND NVL(ifp.item_cancelado, 'N') = 'N' ");
      query.append("                     AND ifp.codigo_cor = nfi.cor_cdgo ");
      query.append("                     AND ROWNUM = 1) nfi_vlunit ");
      query.append("               , nfi.nfi_qtde total_pares ");
      query.append("               , n.nfs_pesliq ");
      query.append("               , n.nfs_pesbru ");
      query.append("               , nfi.cfop ");
      query.append("               , nfi.nfi_seqitem ");
      query.append("   FROM nf_item           nfi ");
      query.append("      , nf_saida          n ");
      query.append("      , ite               i ");
      query.append("      , faturas_proformas fp ");
      query.append("      , ped               p ");
      query.append("      , rep               r ");
      query.append("  WHERE nfi.nfs_nmro = n.nfs_nmro ");
      query.append("    AND i.ped_nmro = p.ped_nmro ");
      query.append("    AND fp.empresa_fatura_proforma = '01' ");
      query.append("    AND i.empresa_fatura_proforma = fp.empresa_fatura_proforma ");
      query.append("    AND i.ano_fatura_proforma = fp.ano_fatura_proforma ");
      query.append("    AND i.numero_fatura_proforma = fp.numero_fatura_proforma ");
      query.append("    AND p.ped_invoice = LPAD(fp.numero_fatura_proforma, 4, 0) || '/' || fp.ano_fatura_proforma ");
      query.append("    AND p.ped_nmro = n.ped_nmro ");
      query.append("    AND r.rep_cdgo = p.rep_cdgo ");
      query.append("    AND nfi.emp_empresa = n.emp_empresa ");
      query.append("    AND nfi.fil_filial = n.fil_filial ");
      query.append("    AND nfi.nfs_serie = n.nfs_serie ");
      if (f.getFil_filial() != "") {
        query.append(" AND n.fil_filial = '").append(f.getFil_filial()).append("' ");
      }
      query.append("    AND n.esc_seqn = decode(").append(esc).append(", null, n.esc_seqn, ").append(esc).append(")  ");
      query.append("    AND n.esc_seqn = DECODE(NULL, NULL, n.esc_seqn, NULL) ");
      query.append("    AND NVL(n.stat_codigo, NULL) <> 1 ");
      query.append("    AND n.fil_filial = NVL(NULL, n.fil_filial) ");
      query.append(parametros.toString());
      query.append(transportadora);
      query.append(data);
      query.append("  ORDER BY nfs_dtemis ");
      query.append("         , n.nfs_nmro ");
      query.append("         , n.nfs_serie ");
      query.append("         , nfi_seqitem ");
    }


    if (usuario.mostraQuery()) {
      throw new Exception(query.toString());
    }

    String arquivo = "";
    if (f.getGera_excel() != "" && (!f.getGera_excel().equalsIgnoreCase("N"))) {
      util.consultas.com.NotasFiscais notaFiscal = new util.consultas.com.NotasFiscais();
      parametrosDespesas = " and dfp.ano_fatura_proforma = "+f.getAno_fatura() + " AND dfp.numero_fatura_proforma = " + f.getNumero_fatura() + " ";
      arquivo = notaFiscal.geraExcel(query.toString(), f.getGera_excel(), parametrosDespesas);
      if (arquivo.equals("")) {
        throw new Exception("Nenhum registro encontrado!");
      }
      request.setAttribute("abre_automaticamente","N");
      request.setAttribute("arquivo", arquivo);
      session.setAttribute("gera_excel","s");
    } else {
      Vector res_Jw_consulta_notas_fiscais = j.select(table, query.toString(), null);
      request.setAttribute("abre_automaticamente","N");
      session.setAttribute("res_Jw_consulta_notas_fiscais",res_Jw_consulta_notas_fiscais);
      if (!(res_Jw_consulta_notas_fiscais != null && res_Jw_consulta_notas_fiscais.size() > 0)) {
        throw new Exception("Nenhum registro encontrado!");
      }
    }
    session.setAttribute("mapping.getName()", form);
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ConsultaNotaFiscalActionForm f = (ConsultaNotaFiscalActionForm) form;
      tg_resetfull_action(mapping, form, request, response);
      session.removeAttribute("res_Jw_consulta_notas_fiscais");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
  private void tg_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      ConsultaNotaFiscalActionForm f = (ConsultaNotaFiscalActionForm) form;
      session.removeAttribute("listaTipoOcorrenciasDescricao");
      session.removeAttribute("listaTipoOcorrencias");
      session.removeAttribute("listaEspecies");
      session.removeAttribute("especies");
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
      ConsultaNotaFiscalActionForm f = (ConsultaNotaFiscalActionForm) form;
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
