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
 * Last Modify Date 22/07/2020 13:40:09
 */

public class ImpressaoDuplicatasNVAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    ImpressaoDuplicatasNVActionForm f = (ImpressaoDuplicatasNVActionForm) form;
    int quantidadeClientes = 0;
    boolean processouActionForward = false;
    try {
      if ((!(f.getCli_rzao() != "")) && (!(f.getDuplicatas() != "")) && (!(f.getCli_cdgo() != "")) && (!(f.getCgc() != "") && (!(f.getNotas_fiscais() != ""))) && !(f.getGrupo() != "")) {
        throw new Exception("Um dos parâmetros obrigatórios deve ser informado!");
      }
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      Vector res_Jw_consulta_titulos = null;
      if (session.getAttribute("res_Jw_consulta_titulos") != null) {
        res_Jw_consulta_titulos = (Vector) session.getAttribute("res_Jw_consulta_titulos");
        quantidadeClientes = res_Jw_consulta_titulos.size();
      }

      if (f.getCli_rzao() != "" || quantidadeClientes > 1) {
        actionForward = new ActionForward("/adm/ImpressaoDuplicatasClientesNVForm.do?&situacao="+f.getSituacao() + "&dt_venc="+f.getDt_vencimento() + "&dt_venc_final="+f.getData_vencimento_final() + "&emp_empresa="+f.getEmp_empresa(), true);
        processouActionForward = true;
      }

      if (!(f.getCli_rzao() != "")) {
        if ((f.getReunir() + "").equals("1")) {
          actionForward = new ActionForward("/adm/ImpressaoDuplicatasNV_rForm.do?select_action="+ "&cli_cdgo="+f.getCli_cdgo() + "&dt_venc="+f.getDt_vencimento() + "&dt_venc_final="+f.getData_vencimento_final() + "&situacao="+f.getSituacao() + "&codigo="+f.getCli_cdgo() + "&nome="+f.getNome() + "&bairro="+f.getBairro() + "&cidade_uf="+f.getCidade_uf() + "&emp_empresa="+f.getEmp_empresa(), true);
          processouActionForward = true;

        } else {
          if (f.getEsc_seqn() != "" && (!processouActionForward)) {
            actionForward = new ActionForward("/adm/ImpressaoDuplicatasNV_rForm.do?select_action=&esc_seqn="+f.getEsc_seqn() + "&cli_cdgo="+f.getCli_cdgo() + "&dt_venc="+f.getDt_vencimento() + "&dt_venc_final="+f.getData_vencimento_final() + "&situacao="+f.getSituacao() + "&codigo="+f.getCodigo() + "&nome="+f.getNome() + "&bairro="+f.getBairro() + "&cidade_uf="+f.getCidade_uf() + "&emp_empresa="+f.getEmp_empresa(), true);
            processouActionForward = true;
          } else {
            if (!processouActionForward) {
              actionForward = new ActionForward("/adm/ImpressaoDuplicatasClientesNVForm.do?&situacao="+f.getSituacao() + "&dt_venc="+f.getDt_vencimento() + "&dt_venc_final="+f.getData_vencimento_final() + "&emp_empresa="+f.getEmp_empresa(), true);
            }
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
    ImpressaoDuplicatasNVActionForm f = (ImpressaoDuplicatasNVActionForm) form;
    session.removeAttribute("impressao_duplicatas_ordenar_data_vencimento");
    if ((f.getMostrar_grupo() + "").equalsIgnoreCase("S")) {
      if ((f.getCb_ordenar_data_vencimento() + "").equalsIgnoreCase("S")) {
        session.setAttribute("impressao_duplicatas_ordenar_data_vencimento","S");
      }
    }

    session.removeAttribute("somente_duplicatas");
    session.removeAttribute("somente_notas_fiscais");
    session.removeAttribute("query");

    if (f.getDt_vencimento().equals("__/__/____")) {
      f.setDt_vencimento("");
    }

    if (f.getData_vencimento_final().equals("__/__/____")) {
      f.setData_vencimento_final("");
    }

    StringBuilder sbDuplicatas = new StringBuilder();
    StringBuilder sbNotasFiscais = new StringBuilder();
    session.removeAttribute("query_duplicatas");
    session.removeAttribute("query_notas_fiscais");

    if (f.getDuplicatas() != "") {
      String[] t = f.getDuplicatas().split("[\\r\\n]+");
      for (String s :
          t) {
        if (sbDuplicatas.length() > 0) {
          sbDuplicatas.append(",");
        }
        sbDuplicatas.append("'");
        sbDuplicatas.append(s.toUpperCase().replaceAll("[^a-zA-Z0-9]", ""));
        sbDuplicatas.append("'");
      }
      session.setAttribute("query_duplicatas",sbDuplicatas.toString());


      if (((f.getCli_rzao() != "")) || ((f.getCli_cdgo() != "")) || ((f.getCgc() != ""))) {
        session.removeAttribute("somente_duplicatas");
      } else {
        session.setAttribute("somente_duplicatas","S");
      }

      parametros.append(" AND t.tit_codigo in ("+sbDuplicatas.toString() + ") ");
    }

    if (f.getNotas_fiscais() != "") {
      String notas = f.getNotas_fiscais();
      notas = notas.replaceAll("\\s+"," ");
      notas = notas.replaceAll(" ","\n");
      String[] t = notas.split("[\\r\\n]+");
      for (String s :
          t) {
        if (sbNotasFiscais.length() > 0) {
          sbNotasFiscais.append(",");
        }
        sbNotasFiscais.append(s.toUpperCase().replaceAll("[^a-zA-Z0-9]", ""));
      }

      if (((f.getCli_rzao() != "")) || ((f.getCli_cdgo() != "")) || ((f.getCgc() != "")) || ((f.getDuplicatas() != ""))) {
        session.removeAttribute("somente_notas_fiscais");
      } else {
        session.setAttribute("somente_notas_fiscais","S");
        parametros.append(" AND t.tit_codigo IN (SELECT tit_codigo FROM tit_nf WHERE nsa_numero in ("+sbNotasFiscais.toString() + ")) ");
      }

      session.setAttribute("query_notas_fiscais",sbNotasFiscais.toString());
    }

    if (f.getCgc() != null && f.getCgc() != "") {
      f.setCgc(util.text.Caracteres.retornaSomenteNumeros(f.getCgc()));
    }

    session.removeAttribute("mostrar_grupo");
    session.setAttribute("portador_filtro",f.getBanco());
    if ((f.getMostrar_grupo() != null && f.getMostrar_grupo().equalsIgnoreCase("S")) && f.getCgc() != "") {
      session.setAttribute("mostrar_grupo", f.getCgc());
    }

    session.removeAttribute("grupo_economico");
    if (!((f.getMostrar_grupo() + "").equals("null"))) {
      if (f.getGrupo() != "") {
        session.setAttribute("grupo_economico", f.getGrupo());
      }
    }
    if (f.getBanco() != null && f.getBanco() != "") {
      if (!f.getBanco().equalsIgnoreCase("T")) {
        parametros.append(" AND nvl(t.prt_codigo,null) in ('"+f.getBanco() + "') ");
      }
    }

    // Temporário até corrigir impressão duplicatas
    parametros.append(" AND ( ");
    parametros.append("       (NVL(t.prt_codigo, NULL) = '041') ");
    parametros.append("       or ");
    parametros.append("       (NVL(t.prt_codigo, NULL) = '001') ");
    parametros.append("       or ");
    parametros.append("       (NVL(t.prt_codigo, NULL) = '237') ");
    parametros.append("       or ");
    parametros.append("       (NVL(t.prt_codigo, NULL) = '104') ");
    parametros.append("       or ");
    parametros.append("       (NVL(t.prt_codigo, NULL) = '033') ");
    parametros.append("       )  ");

    if (f.getDt_vencimento() != "") {
      parametros.append(" AND tit_datvenc >= decode(to_date('").append(f.getDt_vencimento()).append("','dd/mm/yyyy'),null, tit_datvenc, to_date('").append(f.getDt_vencimento()).append("','dd/mm/yyyy'))  ");
    }

    if (f.getData_vencimento_final() != "") {
      parametros.append(" AND tit_datvenc < to_date('").append(f.getData_vencimento_final()).append("','dd/mm/yyyy') + 1 ");
    }

    if (f.getSituacao() != "") {
      parametros.append(" AND tit_status =  decode('").append(f.getSituacao()).append("','T',tit_status,decode('").append(f.getSituacao()).append("','A','A','L','L','C','C'))  ");
    }

    if (f.getCli_rzao() != "" && f.getCli_rzao() != null) {
      parametros.append(" AND a.cli_rzao like upper('").append(f.getCli_rzao()).append("')");
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
      //   parametros.append(" AND esc_situacao = 'A' ");
      util.consultas.Query qr = new util.consultas.Query();
      Integer quantidadeCli = Integer.parseInt(qr.retorna(j, "SELECT count(cli_cdgo) FROM esc WHERE esc_cgc = " + f.getCgc()));
      String cliente = null;
      String sequencial = null;
      if (quantidadeCli > 1) {
        cliente = qr.retorna(j, "select cli_cdgo FROM esc WHERE esc_cgc = " + f.getCgc() + " AND rownum = 1");
        sequencial = qr.retorna(j, "select esc_seqn FROM esc WHERE esc_cgc = " + f.getCgc() + " AND rownum = 1");
      } else {
        cliente = qr.retorna(j, "select cli_cdgo FROM esc WHERE esc_cgc = " + f.getCgc());
        sequencial = qr.retorna(j, "select esc_seqn FROM esc WHERE esc_cgc = " + f.getCgc());
      }
      f.setCli_cdgo(cliente);
      f.setEsc_seqn(sequencial);
      //if(f.getCli_cdgo().equals("")){
      //throw new Exception("CGC inválido!");
      //}
    }

    portalbr.dbobj.view.Jw_consulta_titulos table = new portalbr.dbobj.view.Jw_consulta_titulos();
    if (f.getRepresentante() != "") {
      query = new StringBuilder("");
      query.append(" SELECT /*+ all_rows */ ");
      query.append("        DISTINCT a.cli_cdgo||'-'||b.esc_seqn cliente ");
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
      query.append("      , b.esc_cgc ");
      query.append("      , b.esc_situacao ");
      query.append("      , decode(nvl(b.esc_situacao,'I'),'I','INATIVO','ATIVO') descricao_esc_situacao ");
      query.append("   FROM cli a ");
      query.append("      , esc b ");
      query.append("      , ecl c ");
      query.append("      , cliente_representante cr ");
      query.append("      , brio.cli_inf_adicionais ca ");
      query.append("      , titulos t ");
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
      query.append("    AND t.cli_codigo = a.cli_cdgo ");
      query.append("    AND NVL(T.tip_codigo, NULL) IN ('DUP', 'NTP', 'NTC', 'NTS', 'NTD') ");
      query.append("    AND nvl(t.sit_codigo_situacao_titulo,-1) not in (26,27) ");
      query.append("    AND (t.emp_empresa, t.fil_filial, t.tip_codigo, t.tit_codigo) NOT IN ");
      query.append("          (SELECT m.emp_empresa ");
      query.append("                  ,m.fil_filial ");
      query.append("                  ,m.tip_codigo ");
      query.append("                  ,m.tit_codigo ");
      query.append("              FROM mov_receber m ");
      query.append("             WHERE NVL(m.emp_empresa, NULL) = NVL(t.emp_empresa, NULL) ");
      query.append("               AND NVL(m.fil_filial, NULL) = NVL(t.fil_filial, NULL) ");
      query.append("               AND NVL(m.tip_codigo, NULL) = NVL(t.tip_codigo, NULL) ");
      query.append("               AND m.tit_codigo = NVL(t.tit_codigo, NULL) ");
      query.append("               AND NVL(m.trn_codigo, NULL) IN ('CON', 'TNC', 'FAL', 'NEG', 'PNE') ");
      query.append("               AND TRUNC(mov_data) <= TRUNC(SYSDATE) ");
      query.append("               AND NVL(m.mov_data, NULL) <= TRUNC(SYSDATE) ");
      query.append("               AND NVL(m.mov_sequencia, 0) = 0 ");
      query.append("               AND rownum = 1) ");
      query.append("       AND TRUNC(t.tit_datvenc) >= TRUNC(SYSDATE) - fct_retorna_parametro('dias_retroativos_emissao_boleto','BRNET') ");
      query.append("       AND t.tit_numbco IS NOT NULL ");
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
      query.append("      , b.esc_cgc ");
      query.append("      , b.esc_situacao ");
      query.append("      , decode(nvl(b.esc_situacao,'I'),'I','INATIVO','ATIVO') descricao_esc_situacao ");
      query.append("   FROM cli a ");
      query.append("      , esc b ");
      query.append("      , ecl c ");
      query.append("      , cliente_representante cr ");
      query.append("      , brio.rep r ");
      query.append("      , brio.cli_inf_adicionais ca ");
      query.append("      , titulos t ");
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
      query.append("    AND t.cli_codigo = a.cli_cdgo ");
      query.append("    AND NVL(T.tip_codigo, NULL) IN ('DUP', 'NTP', 'NTC', 'NTS', 'NTD') ");
      query.append("    AND nvl(t.sit_codigo_situacao_titulo,-1) not in (26,27) ");
      query.append("    AND (t.emp_empresa, t.fil_filial, t.tip_codigo, t.tit_codigo) NOT IN ");
      query.append("          (SELECT m.emp_empresa ");
      query.append("                  ,m.fil_filial ");
      query.append("                  ,m.tip_codigo ");
      query.append("                  ,m.tit_codigo ");
      query.append("              FROM mov_receber m ");
      query.append("             WHERE NVL(m.emp_empresa, NULL) = NVL(t.emp_empresa, NULL) ");
      query.append("               AND NVL(m.fil_filial, NULL) = NVL(t.fil_filial, NULL) ");
      query.append("               AND NVL(m.tip_codigo, NULL) = NVL(t.tip_codigo, NULL) ");
      query.append("               AND m.tit_codigo = NVL(t.tit_codigo, NULL) ");
      query.append("               AND NVL(m.trn_codigo, NULL) IN ('CON', 'TNC', 'FAL', 'NEG', 'PNE') ");
      query.append("               AND TRUNC(mov_data) <= TRUNC(SYSDATE) ");
      query.append("               AND NVL(m.mov_data, NULL) <= TRUNC(SYSDATE) ");
      query.append("               AND NVL(m.mov_sequencia, 0) = 0 ");
      query.append("               AND rownum = 1) ");
      query.append("       AND TRUNC(t.tit_datvenc) >= TRUNC(SYSDATE) - fct_retorna_parametro('dias_retroativos_emissao_boleto','BRNET') ");
      query.append("       AND t.tit_numbco IS NOT NULL ");
      query.append(parametros.toString());
      query.append("  ORDER BY cli_rzao ");
    }

    if ((!(f.getRegional() != "")) && (!(f.getRepresentante() != ""))) {
      query = new StringBuilder("");
      query.append(" SELECT /*+ all_rows */ ");
      query.append("        DISTINCT a.cli_cdgo||'-'||b.esc_seqn cliente ");
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
      query.append("      , b.esc_cgc ");
      query.append("      , b.esc_situacao ");
      query.append("      , decode(nvl(b.esc_situacao,'I'),'I','INATIVO','ATIVO') descricao_esc_situacao ");
      query.append("   FROM cli a ");
      query.append("      , esc b ");
      query.append("      , ecl c ");
      query.append("      , brio.cli_inf_adicionais ca ");
      if (!((f.getMostrar_grupo() + "").equals("null"))) {
        if (f.getGrupo() != "") {
          query.append("  , grupo_economico ge ");
        }
      }
      query.append("      , titulos t ");
      query.append("  WHERE b.esc_seqn            =  c.esc_seqn ");
      if (!((f.getMostrar_grupo() + "").equals("null"))) {
        if (f.getGrupo() != "") {
          query.append(" AND ge.cli_cdgo = a.cli_cdgo ");
          query.append(" AND ge.gre_grupo = " + f.getGrupo());
          query.append(" AND ge.status = 'A' ");
        }
      }
      query.append("    AND a.cli_cdgo            =  b.cli_cdgo ");
      query.append("    AND b.cli_cdgo            =  c.cli_cdgo ");
      query.append("    AND (c.ned_cdgo = 'UNI'   or c.ned_cdgo = 'COB') ");
      query.append("    AND ca.cli_cdgo         (+) = b.cli_cdgo ");
      query.append("    AND ca.esc_seqn         (+) = b.esc_seqn ");
      query.append("    AND a.cli_cdgo            >  0 ");
      query.append("    AND a.cli_cdgo            =  nvl(").append(cli.toString()).append(",a.cli_cdgo) ");
      query.append("    AND b.esc_seqn            =  nvl(").append(esc.toString()).append(",b.esc_seqn) ");
      query.append("    AND t.cli_codigo = a.cli_cdgo ");
      query.append("    AND NVL(t.tip_codigo, NULL) IN ('DUP', 'NTP', 'NTC', 'NTS', 'NTD') ");
      query.append("    AND nvl(t.sit_codigo_situacao_titulo,-1) not in (26,27) ");
      query.append("    AND (t.emp_empresa, t.fil_filial, t.tip_codigo, t.tit_codigo) NOT IN ");
      query.append("          (SELECT m.emp_empresa ");
      query.append("                  ,m.fil_filial ");
      query.append("                  ,m.tip_codigo ");
      query.append("                  ,m.tit_codigo ");
      query.append("              FROM mov_receber m ");
      query.append("             WHERE NVL(m.emp_empresa, NULL) = NVL(t.emp_empresa, NULL) ");
      query.append("               AND NVL(m.fil_filial, NULL) = NVL(t.fil_filial, NULL) ");
      query.append("               AND NVL(m.tip_codigo, NULL) = NVL(t.tip_codigo, NULL) ");
      query.append("               AND m.tit_codigo = NVL(t.tit_codigo, NULL) ");
      query.append("               AND NVL(m.trn_codigo, NULL) IN ('CON', 'TNC', 'FAL', 'NEG', 'PNE') ");
      query.append("               AND TRUNC(mov_data) <= TRUNC(SYSDATE) ");
      query.append("               AND NVL(m.mov_data, NULL) <= TRUNC(SYSDATE) ");
      query.append("               AND NVL(m.mov_sequencia, 0) = 0 ");
      query.append("               AND rownum = 1) ");
      query.append("       AND TRUNC(t.tit_datvenc) >= TRUNC(SYSDATE) - fct_retorna_parametro('dias_retroativos_emissao_boleto','BRNET') ");
      query.append("       AND t.tit_numbco IS NOT NULL ");
      query.append(parametros.toString());
      query.append("  ORDER BY cli_rzao");
    }


    if ((!(f.getCliente_mercado_externo().equals("")))) {
      query = new StringBuilder("");
      query.append(" SELECT /*+ all_rows */ ");
      query.append("        DISTINCT a.cli_cdgo||'-'||b.esc_seqn cliente ");
      query.append("      , cli_rzao razao ");
      query.append("      , ecl_bair br ");
      query.append("      , ecl_cdad||'-'||c.est_unifed cid_est ");
      query.append("      , b.esc_seqn ");
      query.append("      , a.cli_cdgo ");
      query.append("      , b.esc_cgc ");
      query.append("      , b.esc_situacao ");
      query.append("      , decode(nvl(b.esc_situacao,'I'),'I','INATIVO','ATIVO') descricao_esc_situacao ");
      query.append("   FROM cli a ");
      query.append("      , esc b ");
      query.append("      , ecl c ");
      query.append("      , brio.cli_inf_adicionais ca ");
      query.append("      , titulos t ");
      query.append("  WHERE b.esc_seqn            =  c.esc_seqn ");
      query.append("    AND a.cli_cdgo            =  b.cli_cdgo ");
      query.append("    AND b.cli_cdgo            =  c.cli_cdgo ");
      query.append("    AND ca.cli_cdgo         (+) = b.cli_cdgo ");
      query.append("    AND ca.esc_seqn         (+) = b.esc_seqn ");
      query.append("    AND (c.ned_cdgo = 'UNI'   or c.ned_cdgo = 'COB') ");
      query.append("    AND t.cli_codigo            =  " +f.getCliente_mercado_externo());
      query.append("    AND t.cli_codigo = a.cli_cdgo ");
      query.append("    AND nvl(t.tip_codigo, NULL) IN ('DUP', 'NTP', 'NTC', 'NTS', 'NTD') ");
      query.append("    AND nvl(t.sit_codigo_situacao_titulo,-1) not in (26,27) ");
      query.append("    AND (t.emp_empresa, t.fil_filial, t.tip_codigo, t.tit_codigo) NOT IN ");
      query.append("          (SELECT m.emp_empresa ");
      query.append("                  ,m.fil_filial ");
      query.append("                  ,m.tip_codigo ");
      query.append("                  ,m.tit_codigo ");
      query.append("              FROM mov_receber m ");
      query.append("             WHERE NVL(m.emp_empresa, NULL) = NVL(t.emp_empresa, NULL) ");
      query.append("               AND NVL(m.fil_filial, NULL) = NVL(t.fil_filial, NULL) ");
      query.append("               AND NVL(m.tip_codigo, NULL) = NVL(t.tip_codigo, NULL) ");
      query.append("               AND m.tit_codigo = NVL(t.tit_codigo, NULL) ");
      query.append("               AND NVL(m.trn_codigo, NULL) IN ('CON', 'TNC', 'FAL', 'NEG', 'PNE') ");
      query.append("               AND TRUNC(mov_data) <= TRUNC(SYSDATE) ");
      query.append("               AND NVL(m.mov_data, NULL) <= TRUNC(SYSDATE) ");
      query.append("               AND NVL(m.mov_sequencia, 0) = 0 ");
      query.append("               AND rownum = 1) ");
      query.append("       AND TRUNC(t.tit_datvenc) >= TRUNC(SYSDATE) - fct_retorna_parametro('dias_retroativos_emissao_boleto','BRNET') ");
      if (f.getDt_vencimento() != "") {
        query.append(" AND t.tit_datvenc >= decode(to_date('").append(f.getDt_vencimento()).append("','dd/mm/yyyy'),null,tit_datvenc,to_date('").append(f.getDt_vencimento()).append("','dd/mm/yyyy'))  ");
      }
      query.append("       AND t.tit_numbco IS NOT NULL ");
      query.append("  ORDER BY cli_rzao, b.esc_seqn ");
    }

    if ((f.getCli_cdgo() != "") && (f.getEsc_seqn() != "") && (!(f.getCli_rzao() != "")) || (f.getCli_cdgo() != "") && (!(f.getEsc_seqn() != "")) && (!(f.getCli_rzao() != "")) && ((f.getReunir() + "").equals("1"))) {

      acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
      if (usuario.mostraQuery()) {
        throw new Exception(query.toString());
      }
      res_Jw_consulta_titulos = j.select(table, query.toString(), null);
      if (f.getCgc() != null && f.getCgc() != "" && f.getCgc() != "null") {
        if (res_Jw_consulta_titulos != null && res_Jw_consulta_titulos.size() > 0) {
          Jw_consulta_titulos lista = (Jw_consulta_titulos) res_Jw_consulta_titulos.elementAt(0);
          f.setCli_cdgo(lista.getCli_cdgo() + "");
          f.setEsc_seqn(lista.getEsc_seqn() + "");
        }
      }


    } else {

      acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
      if (usuario.mostraQuery()) {
        throw new Exception(query.toString());
      }
      res_Jw_consulta_titulos = j.select(table, query.toString(), null);
    }
    session.setAttribute("res_Jw_consulta_titulos",res_Jw_consulta_titulos);

    if ((!(f.getCliente_mercado_externo().equals("")))) {
      session.setAttribute("query", query.toString());
    } else {
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
    }
    session.setAttribute("mapping.getName()", form);
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ImpressaoDuplicatasNVActionForm f = (ImpressaoDuplicatasNVActionForm) form;
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
    ImpressaoDuplicatasNVActionForm f = (ImpressaoDuplicatasNVActionForm) form;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      //-------------
      String empresa = null;
      String filial = null;
      String tip = null;
      String cliente = "";
      String cgc = "";
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
      query.append(" SELECT decode(tit_status, 'A', 'Aberto', 'L', 'Liquidado', 'Cancelado') status ");
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
      query.append("      , fct_formata_cnpj(pck_cliente.get_cnpj(t.cli_codigo, t.esc_seqn)) esc_cgc ");
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


      Vector res_Jw_consulta_duplicata = j.select(table, query.toString(), null);

      session.setAttribute("res_Jw_consulta_duplicata", res_Jw_consulta_duplicata);
      if (res_Jw_consulta_duplicata != null && res_Jw_consulta_duplicata.size() == 0) {
        throw new Exception("Título inexistente!");
      } else {

        portalbr.dbobj.view.Jw_consulta_duplicata r = (portalbr.dbobj.view.Jw_consulta_duplicata) res_Jw_consulta_duplicata.elementAt(0);
        cliente = r.getCliente() + "";
        cgc = r.getEsc_cgc() + "";
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
      sb.append("&cnpj=").append(cgc);

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
  public ActionForward perform_refresh_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ImpressaoDuplicatasNVActionForm f = (ImpressaoDuplicatasNVActionForm) form;
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

  public ActionForward perform_selectc_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ImpressaoDuplicatasNVActionForm[]_ge_grid_array = (ImpressaoDuplicatasNVActionForm[])_ge_grid.get("bl_form_Jw_consulta_titulos_1_lines");
      ImpressaoDuplicatasNVActionForm f = _ge_grid_array[0];
      try {
        selectc_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_titulos_1", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void selectc_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    DynaActionForm _ge_grid = (DynaActionForm) form;
    ImpressaoDuplicatasNVActionForm[]_ge_grid_array = (ImpressaoDuplicatasNVActionForm[])_ge_grid.get("bl_form_Jw_consulta_titulos_1_lines");
    ImpressaoDuplicatasNVActionForm f = _ge_grid_array[0];
    session.removeAttribute("query_impressao_duplicatas_cliente");
    acesso.Sessao sessao = new acesso.Sessao(session);
    if (f != null) {
      Jw_consulta_titulos table = new Jw_consulta_titulos();
      StringBuilder query = new StringBuilder();
      query.append(" SELECT DISTINCT a.cli_cdgo || '-' || b.esc_seqn cliente ");
      query.append("                ,cli_rzao razao ");
      query.append("                ,ecl_bair br ");
      query.append("                ,ecl_cdad || '-' || c.est_unifed cid_est ");
      query.append("                ,b.esc_seqn ");
      query.append("                ,a.cli_cdgo ");
      query.append("                ,b.esc_cgc ");
      query.append("   FROM cli                     a ");
      query.append("       ,esc                     b ");
      query.append("       ,ecl                     c ");
      query.append("  WHERE b.esc_seqn = c.esc_seqn ");
      query.append("    AND a.cli_cdgo = b.cli_cdgo ");
      query.append("    AND b.cli_cdgo = c.cli_cdgo ");
      query.append("    AND (c.ned_cdgo = 'UNI' OR c.ned_cdgo = 'COB') ");
      query.append("    and b.cli_cdgo = " + sessao.getChave());
      query.append("  ORDER BY cli_rzao ");
      query.append("           ,b.esc_seqn ");
      Vector res_Jw_consulta_titulos = j.select(table, query.toString(), null);
      session.setAttribute("res_Jw_consulta_titulos",res_Jw_consulta_titulos);
      if (res_Jw_consulta_titulos != null && res_Jw_consulta_titulos.size() > 0) {
        ImpressaoDuplicatasNVActionForm[]_ge_grid_array_flex = new ImpressaoDuplicatasNVActionForm[res_Jw_consulta_titulos.size()];
        org.apache.struts.config.ConfigEGenHelper.setFormPropertySize(mapping, "bl_form_Jw_consulta_titulos_1_lines", res_Jw_consulta_titulos.size());
        int _ge_pos = 0;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array_flex.length; _ge_grid_array_index++, _ge_pos++) {
          if (_ge_grid_array_index < _ge_grid_array.length) {
            f = _ge_grid_array[_ge_grid_array_index];
          } else {
            f = new ImpressaoDuplicatasNVActionForm();
            ActionServletWrapper actionServletWrapper = form.getServletWrapper();
            org.apache.struts.upload.CommonsMultipartRequestHandler commonsMultipartRequestHandler = new org.apache.struts.upload.CommonsMultipartRequestHandler();
            actionServletWrapper.setServletFor(commonsMultipartRequestHandler);
            f.setServlet(commonsMultipartRequestHandler.getServlet());
          }
          f.reset(mapping, request);
          if (res_Jw_consulta_titulos.size() > _ge_pos) {
            if (_ge_pos == 0) {
              f.setGridCheckField(true);
            }
            Jw_consulta_titulos r = (Jw_consulta_titulos) res_Jw_consulta_titulos.elementAt(_ge_pos);
            f.setCliente((r.getCliente() != null) ? r.getCliente() + "":"");
            f.setRazao((r.getRazao() != null) ? r.getRazao() + "":"");
            f.setBr((r.getBr() != null) ? r.getBr() + "":"");
            f.setCid_est((r.getCid_est() != null) ? r.getCid_est() + "":"");
            f.setEsc_seqn1((r.getEsc_seqn() != null) ? r.getEsc_seqn() + "":"");
            f.setCli_cdgo1((r.getCli_cdgo() != null) ? r.getCli_cdgo() + "":"");
            f.setCodigo_sucessor((r.getCodigo_sucessor() != null) ? r.getCodigo_sucessor() + "":"");
            f.setSequencial_sucessor((r.getSequencial_sucessor() != null) ? r.getSequencial_sucessor() + "":"");
            f.setRazao_social_sucessor((r.getRazao_social_sucessor() != null) ? r.getRazao_social_sucessor() + "":"");
            f.setCid_uf_sucessor((r.getCid_uf_sucessor() != null) ? r.getCid_uf_sucessor() + "":"");
            f.setBr_sucessor((r.getBr_sucessor() != null) ? r.getBr_sucessor() + "":"");
            f.setEsc_cgc((r.getEsc_cgc() != null) ? r.getEsc_cgc() + "":"");
          } else {
            f.reset(mapping, request);
          }
          _ge_grid_array_flex[_ge_grid_array_index] = f;
        }
        _ge_grid.set("bl_form_Jw_consulta_titulos_1_lines", _ge_grid_array_flex);
      } else {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_titulos_1", new ActionMessage("warn.norowsselected",""));
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      }
      session.setAttribute(mapping.getName(), form);
    }
  }
  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ImpressaoDuplicatasNVActionForm[]_ge_grid_array = (ImpressaoDuplicatasNVActionForm[])_ge_grid.get("bl_form_Jw_consulta_titulos_1_lines");
      ImpressaoDuplicatasNVActionForm f = _ge_grid_array[0];
      update_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/adm/ImpressaoDuplicatasNV_rForm.do?select_action=", true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_titulos_1", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void update_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    DynaActionForm _ge_grid = (DynaActionForm) form;
    session.removeAttribute("query_impressao_duplicatas_cliente");
    ImpressaoDuplicatasNVActionForm[]_ge_grid_array = (ImpressaoDuplicatasNVActionForm[])_ge_grid.get("bl_form_Jw_consulta_titulos_1_lines");
    ImpressaoDuplicatasNVActionForm f = _ge_grid_array[0];
    StringBuilder sequenciais = new StringBuilder();
    boolean marcou = false;
    String codigoCliente = null;
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      if (f.getGridCheckField()) {
        marcou = true;
        codigoCliente = f.getCli_cdgo1();
        if (sequenciais.length() == 0) {
          sequenciais.append(f.getEsc_seqn1());
        } else {
          sequenciais.append("," + f.getEsc_seqn1());
        }
      }
    }
    if (!marcou) {
      throw new Exception("Um dos clientes deve ser informado!");
    } else {
      StringBuilder query = new StringBuilder();
      query.append(" and t.esc_seqn in ("+sequenciais.toString() + ") ");
      query.append(" and cli_codigo = " + codigoCliente);
      session.setAttribute("query_impressao_duplicatas_cliente", query.toString());
    }
  }

  public ActionForward perform_marcar_todos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ImpressaoDuplicatasNVActionForm[]_ge_grid_array = (ImpressaoDuplicatasNVActionForm[])_ge_grid.get("bl_form_Jw_consulta_titulos_1_lines");
      ImpressaoDuplicatasNVActionForm f = _ge_grid_array[0];


      try {
        tg_marcar_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_titulos_1", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void tg_marcar_todos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ImpressaoDuplicatasNVActionForm[]_ge_grid_array = (ImpressaoDuplicatasNVActionForm[])_ge_grid.get("bl_form_Jw_consulta_titulos_1_lines");
      if (_ge_grid_array != null) {
        ImpressaoDuplicatasNVActionForm f = null;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
          f = _ge_grid_array[_ge_grid_array_index];
          f.setGridCheckField(true);
        }
      }
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    }
  }

  public ActionForward perform_desmarcar_todos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ImpressaoDuplicatasNVActionForm[]_ge_grid_array = (ImpressaoDuplicatasNVActionForm[])_ge_grid.get("bl_form_Jw_consulta_titulos_1_lines");
      ImpressaoDuplicatasNVActionForm f = _ge_grid_array[0];


      try {
        tg_desmarcar_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_titulos_1", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void tg_desmarcar_todos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ImpressaoDuplicatasNVActionForm[]_ge_grid_array = (ImpressaoDuplicatasNVActionForm[])_ge_grid.get("bl_form_Jw_consulta_titulos_1_lines");
      if (_ge_grid_array != null) {
        ImpressaoDuplicatasNVActionForm f = null;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
          f = _ge_grid_array[_ge_grid_array_index];
          f.setGridCheckField(false);
        }
      }
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    }
  }

}
