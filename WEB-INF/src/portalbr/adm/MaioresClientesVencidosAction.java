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
 * Creation Date 10/04/2006 09:57:51
 * Last Modify Date 19/02/2020 09:37:47
 */

public class MaioresClientesVencidosAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //---------------------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 10/04/2006
    //---------------------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      //-----------------------------------------------------------------------------
      MaioresClientesVencidosActionForm f = (MaioresClientesVencidosActionForm) form;
      String regional = "";
      if (f.getCodigo_regional() != null && f.getCodigo_regional().length() > 0) {
        portalbr.dbobj.table.Regionais_vendas db_object = new portalbr.dbobj.table.Regionais_vendas();
        Object[][] where = { {"codigo_regional","=",com.egen.util.text.FormatNumber.toInt(f.getCodigo_regional())} };
        java.util.Vector results = j.select(db_object, where, null);
        if (results != null && results.size() > 0) {
          db_object = (portalbr.dbobj.table.Regionais_vendas) results.elementAt(0);
          regional = (db_object.getNome_regional() != null) ? db_object.getNome_regional() + "":"";
        }
      }

      String representante = "";
      if (f.getRep_cdgo() != null && f.getRep_cdgo().length() > 0) {
        portalbr.dbobj.table.Rep db_object = new portalbr.dbobj.table.Rep();
        Object[][] where = { {"rep_cdgo","like",f.getRep_cdgo()} };
        java.util.Vector results = j.select(db_object, where, null);
        if (results != null && results.size() > 0) {
          db_object = (portalbr.dbobj.table.Rep) results.elementAt(0);
          representante = (db_object.getRep_rzao() != null) ? db_object.getRep_rzao() + "":"";
        }
      }



      if (f.getRep() != null && f.getRep().length() > 0) {
        portalbr.dbobj.table.Rep db_object = new portalbr.dbobj.table.Rep();
        Object[][] where = { {"rep_cdgo","like",f.getRep()} };
        java.util.Vector results = j.select(db_object, where, null);
        if (results != null && results.size() > 0) {
          db_object = (portalbr.dbobj.table.Rep) results.elementAt(0);
          representante = (db_object.getRep_rzao() != null) ? db_object.getRep_rzao() + "":"";
        }
      }

      StringBuilder consulta = new StringBuilder();
      consulta = new StringBuilder("Consulta dos "+f.getQuantidade() + " Maiores Clientes Vencidos");
      if (f.getQuantidade().equals("1")) {
        consulta = new StringBuilder(("Consulta do Maior Cliente Vencido"));
      }
      if (f.getCodigo_regional() != "") {
        consulta = new StringBuilder(("Consulta dos ") + f.getQuantidade() + " Maiores Clientes Vencidos da Regional "+regional);
        if (f.getQuantidade().equals("1")) {
          consulta = new StringBuilder("Consulta do Maior Cliente Vencido da Regional "+regional);
        }
      }
      if (f.getRep_cdgo() != "" || f.getRep() != "") {
        consulta = new StringBuilder("Consulta dos "+f.getQuantidade() + " Maiores Clientes Vencidos do Representante "+representante);
        if (f.getQuantidade().equals("1")) {
          consulta = new StringBuilder("Consulta do Maior Cliente Vencido do Representante "+representante);
        }
      }
      //-----------------------------------------------------------------------------
      actionForward = new ActionForward("/adm/MaioresClientesVencidos_rForm.do?&consulta="+consulta, true);
    }
    catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_maiores_clientes_vencidos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    MaioresClientesVencidosActionForm f = (MaioresClientesVencidosActionForm) form;
    portalbr.dbobj.view.Jw_maiores_clientes_vencidos table = new portalbr.dbobj.view.Jw_maiores_clientes_vencidos();
    util.consultas.adm.MaioresClientesVencidos m = new util.consultas.adm.MaioresClientesVencidos();
    String dias = "null";
    String regional = "";
    String representante = "";
    //--- se o usuário logado for administrador ---
    if ((f.getRep().equals("")) && (f.getReg().equals(""))) {
      if ((!(f.getCodigo_regional().equals("")))) {
        regional = " AND wtv.codigo_regional = " + f.getCodigo_regional();
      }

      if ((!(f.getRep_cdgo().equals("")))) {
        representante = " AND wtv.rep_cdgo = '"+f.getRep_cdgo() + "'";
      }
    }
    //------- Se o usuário logado for regional -----------
    if ((!(f.getReg().equals("")))) {
      regional = " AND wtv.codigo_regional = " + f.getReg();
      if ((!(f.getRep_cdgo().equals("")))) {
        representante = " AND wtv.rep_cdgo = '"+f.getRep_cdgo() + "'";
      }
    }
    //-------Se o usuário logado for representante --------
    if ((!(f.getRep().equals("")))) {
      representante = " AND wtv.rep_cdgo = '"+f.getRep() + "'";
    }
    //-----------------------------------------------------
    if (f.getDias_vencidos() != "") {
      dias = f.getDias_vencidos();
    }

    StringBuilder query = new StringBuilder();
    query.append(" SELECT wtv.codigo_regional, ");
    query.append("        pck_cliente.get_grupo_economico(codigo_cliente)|| ' - ' || pck_grupo_economico.get_nome(pck_cliente.get_grupo_economico(codigo_cliente)) grupo_economico, ");
    query.append("        wtv.codigo_cliente codigo, ");
    query.append("        wtv.sequencial, ");
    query.append("        replace(rowtocol('SELECT ''(''||ffs_ddd2||'') ''||ffs_nmro2 FROM fax_fon2 WHERE cli_cdgo = '||codigo_cliente||' AND esc_seqn = decode (1,null,esc_seqn,1) AND ned_cdgo in (''COB'',''UNI'') '),',','<br>') fone, ");
    query.append("        cli.cli_rzao cliente, ");
    query.append("        substr(ecl.ecl_cdad, 1, 30) || '-' || ecl.est_unifed ecl_cdad, ");
    query.append("        max(wtv.dias) dias, ");
    query.append("        sum(wtv.valor) valor, ");
    query.append("        '' observacao ");
    query.append("   FROM (SELECT t.cli_codigo codigo_cliente, ");
    query.append("                t.esc_seqn sequencial, ");
    query.append("                t.rep_codigo rep_cdgo, ");
    query.append("                t.rev_codigo_regional codigo_regional, ");
    query.append("                lpad(round(round(((trunc(sysdate)) - min(trunc(t.tit_datvenc))))), 5, ' ') dias, ");
    query.append("                sum(fnc_ctr_saldo_negociacao(t.emp_empresa, ");
    query.append("                                             t.fil_filial, ");
    query.append("                                             t.tip_codigo, ");
    query.append("                                             t.tit_codigo, ");
    query.append("                                             t.sit_codigo_situacao_titulo, ");
    query.append("                                             t.tit_vlpcp, ");
    query.append("                                             t.tit_vldeb)) valor ");
    query.append("           FROM titulos t ");
    query.append("          WHERE tit_status = 'A' ");
    //query.append("            AND nvl(t.sit_codigo_situacao_titulo,null) <> 3 ");
    query.append("            AND t.sit_codigo_situacao_titulo IN (2, 21, 24, 27) ");
    query.append("            AND NOT EXISTS ");
    query.append("               (SELECT 1 ");
    query.append("                  FROM cli c ");
    query.append("                 WHERE c.cli_cdgo = t.cli_codigo ");
    query.append("                   AND NVL(c.seg_cdgo,NULL) = 9) ");
    query.append("            AND nvl(t.tip_codigo, null) IN (SELECT tit_gru.tip_codigo ");
    query.append("                                              FROM tipos_de_titulo_por_grupo tit_gru ");
    query.append("                                             WHERE tit_gru.gtt_codigo_grupo_tipo_titulo = 4) ");
    query.append("                                               AND t.tit_datvenc                        < TRUNC(SYSDATE - ").append(dias).append(") ");
    query.append("                                               AND t.tipo_de_mercado                    = 'MI' ");
    query.append("                                               AND (t.emp_empresa, t.fil_filial, ");
    query.append("                                                    t.tip_codigo, t.tit_codigo) NOT IN ");
    query.append("                                                    (SELECT m.emp_empresa, ");
    query.append("                                                            m.fil_filial, ");
    query.append("                                                            m.tip_codigo, ");
    query.append("                                                            m.tit_codigo ");
    query.append("                                                       FROM mov_receber m ");
    query.append("                                                      WHERE m.emp_empresa = t.emp_empresa ");
    query.append("                                                        AND m.fil_filial  = t.fil_filial ");
    query.append("                                                        AND m.tip_codigo  = t.tip_codigo ");
    query.append("                                                        AND m.tit_codigo  = t.tit_codigo ");
    query.append("                                                        AND m.trn_codigo IN (SELECT trn_gru.trn_codigo ");
    query.append("                                                                               FROM transacoes_por_grupo trn_gru ");
    query.append("                                                                              WHERE trn_gru.grt_codigo_grupo_transacao = 15 ");
    query.append("                                                                                AND data_inicial <= SYSDATE ");
    query.append("                                                                                AND NVL(data_final, SYSDATE) >= SYSDATE) ");
    query.append("                                                                                AND NVL(m.mov_sequencia, 0) = 0 ");
    query.append("                                                                                AND m.mov_data <= TRUNC(SYSDATE - ").append(dias).append(") ");
    query.append("                                                                                AND ROWNUM = 1) ");
    query.append("          GROUP BY ");
    query.append("                t.cli_codigo, ");
    query.append("                t.esc_seqn, ");
    query.append("                t.rep_codigo, ");
    query.append("                t.rev_codigo_regional ");
    query.append("  UNION ");
    query.append("  SELECT c.cli_cdgo codigo_cliente, ");
    query.append("         seq.sequencial sequencial, ");
    query.append("         r.rep_cdgo, ");
    query.append("         r.codigo_regional, ");
    query.append("         lpad(trunc(((sysdate ) - min(c.data_de_deposito))), 5, ' ') dias, ");
    query.append("         sum(c.valor_do_cheque - nvl(c.valor_recebido, 0)) valor ");
    query.append("    FROM brconrec.cheques c, ");
    query.append("         cli, ");
    query.append("         rep r, ");
    query.append("         gerentes_regionais_vendas g, ");
    query.append("         (SELECT min(ecl.esc_seqn) sequencial, ");
    query.append("                 ecl.cli_cdgo ");
    query.append("            FROM ecl ecl ");
    query.append("           WHERE ecl.ned_cdgo IN ('UNI','COB') ");
    query.append("           GROUP BY ");
    query.append("                 ecl.cli_cdgo ) seq ");
    query.append("   WHERE c.sit_codigo_situacao_titulo    IN ('4') ");
    query.append("     AND seq.cli_cdgo                    = cli.cli_cdgo ");
    query.append("     AND nvl(c.tip_codigo, null)         IN ('CH1', 'CH2') ");
    query.append("     AND r.rep_cdgo                      = c.rep_cdgo ");
    query.append("     AND g.codigo_gerente                = r.rep_gerente_antigo ");
    query.append("     AND cli.cli_cdgo                    = c.cli_cdgo ");
    query.append("     AND nvl(cli.cli_tipo_mercado, 'MI') = 'MI' ");
    query.append("     AND c.data_de_deposito              < trunc(sysdate - ").append(dias).append(") ");
    query.append("           AND NOT EXISTS ");
    query.append("               (SELECT 1 ");
    query.append("                FROM cli l ");
    query.append("                WHERE l.cli_cdgo = c.cli_cdgo ");
    query.append("                  AND NVL(l.seg_cdgo,NULL) = 9) ");
    query.append("     AND (c.emp_empresa, c.fil_filial, c.tip_codigo, ");
    query.append("          c.cli_cdgo, c.prt_codigo_banco, c.age_codigo, c.numero_do_cheque) NOT IN ");
    query.append("         (SELECT m.emp_empresa, ");
    query.append("                 m.fil_filial, ");
    query.append("                 m.tip_codigo, ");
    query.append("                 m.cli_cdgo, ");
    query.append("                 m.prt_codigo_banco, ");
    query.append("                 m.age_codigo, ");
    query.append("                 m.che_numero_do_cheque ");
    query.append("            FROM movimentos_cheque m ");
    query.append("           WHERE m.emp_empresa          = c.emp_empresa ");
    query.append("             AND m.fil_filial           = c.fil_filial ");
    query.append("             AND m.tip_codigo           = c.tip_codigo ");
    query.append("             AND m.cli_cdgo             = c.cli_cdgo ");
    query.append("             AND m.prt_codigo_banco     = c.prt_codigo_banco ");
    query.append("             AND m.age_codigo           = c.age_codigo ");
    query.append("             AND m.che_numero_do_cheque = c.numero_do_cheque ");
    query.append("             AND m.trn_codigo           IN (SELECT trn_gru.trn_codigo ");
    query.append("                                              FROM transacoes_por_grupo trn_gru ");
    query.append("                                             WHERE trn_gru.grt_codigo_grupo_transacao = 15 ");
    query.append("                                               AND data_inicial             <= sysdate ");
    query.append("                                               AND nvl(data_final, sysdate) >= sysdate) ");
    query.append("             AND m.data_do_movimento <= trunc(sysdate) ");
    query.append("             AND nvl(m.moc_sequencia, 0) = 0 ");
    query.append("             AND rownum = 1) ");
    query.append(" GROUP BY ");
    query.append("       c.cli_cdgo, ");
    query.append("       seq.sequencial, ");
    query.append("    r.rep_cdgo, ");
    query.append("     r.codigo_regional ");
    query.append(" UNION ");
    query.append(" SELECT che.cli_cdgo codigo_cliente, ");
    query.append("        seq.sequencial sequencial, ");
    query.append("        che.rep_cdgo, ");
    query.append("        rep.codigo_regional, ");
    query.append("        lpad(round(((sysdate + 1) - min(che.data_de_deposito))), 5, ' ') dias, ");
    query.append("            (sum(mov.valor_principal) - sum(nvl(che.che_vlpcp, 0)) -  ");
    query.append("             sum(nvl(che.che_VLDEB, 0))) valor ");
    query.append("   FROM brconrec.cheques che, ");
    query.append("        rep rep, ");
    query.append("        movimentos_cheque mov, ");
    query.append("         (SELECT min(ecl.esc_seqn) sequencial, ");
    query.append("                 ecl.cli_cdgo ");
    query.append("            FROM ecl ecl ");
    query.append("           WHERE ecl.ned_cdgo IN ('UNI','COB') ");
    query.append("           GROUP BY ecl.cli_cdgo ) seq ");
    query.append("  WHERE che.emp_empresa      = mov.emp_empresa ");
    query.append("    AND mov.cli_cdgo         = seq.cli_cdgo ");
    query.append("    AND che.fil_filial       = mov.fil_filial ");
    query.append("    AND che.tip_codigo       = mov.tip_codigo ");
    query.append("    AND che.cli_cdgo         = mov.cli_cdgo ");
    query.append("    AND che.prt_codigo_banco = mov.prt_codigo_banco ");
    query.append("    AND che.age_codigo       = mov.age_codigo ");
    query.append("    AND che.numero_do_cheque = mov.che_numero_do_cheque ");
    query.append("    AND rep.rep_cdgo         = che.rep_cdgo ");
    //    query.append("    AND che.emp_empresa      = 'xx' ");
    query.append("    AND che.sit_codigo_situacao_titulo = '7' ");
    query.append("    AND che.data_de_deposito < trunc(sysdate - ").append(dias).append(") ");
    query.append("    AND mov.trn_codigo       = 'CLD' ");
    query.append("    AND trunc(mov.data_do_movimento) >= to_date('01/01/2000', 'DD/MM/YYYY') ");
    query.append("           AND NOT EXISTS ");
    query.append("               (SELECT 1 ");
    query.append("                FROM cli l ");
    query.append("                WHERE l.cli_cdgo = che.cli_cdgo ");
    query.append("                  AND NVL(l.seg_cdgo,NULL) = 9) ");
    query.append("    AND NOT EXISTS ");
    query.append("            (SELECT '1' ");
    query.append("               FROM movimentos_cheque m ");
    query.append("              WHERE m.emp_empresa          = che.emp_empresa ");
    query.append("                AND m.fil_filial           = che.fil_filial ");
    query.append("                AND m.tip_codigo           = che.tip_codigo ");
    query.append("                AND m.cli_cdgo             = che.cli_cdgo ");
    query.append("                AND m.prt_codigo_banco     = che.prt_codigo_banco ");
    query.append("                AND m.age_codigo           = che.age_codigo ");
    query.append("                AND m.che_numero_do_cheque = che.numero_do_cheque ");
    query.append("                AND m.trn_codigo IN (SELECT trn_gru.trn_codigo ");
    query.append("                                       FROM transacoes_por_grupo trn_gru ");
    query.append("                                      WHERE trn_gru.grt_codigo_grupo_transacao = 15 ");
    query.append("                                        AND data_inicial                      <= sysdate");
    query.append("                                        AND nvl(data_final, sysdate)          >= sysdate) ");
    query.append("                AND m.data_do_movimento <= trunc(sysdate) ");
    query.append("                AND nvl(m.moc_sequencia, 0) = 0 ");
    query.append("                AND rownum = 1) ");
    query.append("  GROUP BY ");
    query.append("        che.cli_cdgo, ");
    query.append("        che.che_vlpcp, ");
    query.append("        che.che_vldeb, ");
    query.append("        seq.sequencial, ");
    query.append("        che.rep_cdgo, ");
    query.append("       rep.codigo_regional ) wtv, ");
    query.append("        cli cli, ");
    query.append("        ecl ecl ");
    query.append("  WHERE wtv.codigo_cliente = ecl.cli_cdgo ");
    query.append("    AND wtv.sequencial     = decode(ecl.esc_seqn, 0, 1, ecl.esc_seqn) ");
    query.append("    AND ecl.cli_cdgo       = cli.cli_cdgo ");
    query.append(representante);
    query.append(regional);
    query.append("    AND ecl.ned_cdgo       IN ('UNI', 'COB') ");
    query.append("  GROUP BY wtv.codigo_regional,");
    query.append("           wtv.codigo_cliente, ");
    query.append("           wtv.sequencial, ");
    query.append("           cli.cli_rzao, ");
    query.append("           ecl.ecl_cdad, ");
    query.append("           ecl.est_unifed ");
    query.append("  ORDER BY valor DESC ");



    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      throw new Exception(query.toString());
    }


    if (false) {
      throw new Exception(query.toString());
    }

    Vector res_Jw_maiores_clientes_vencidos = j.select(table, query.toString(), null);


    if (f.getQuantidade() != "") {
      if (Integer.parseInt(f.getQuantidade()) <= res_Jw_maiores_clientes_vencidos.size()) {
        res_Jw_maiores_clientes_vencidos.setSize(Integer.parseInt(f.getQuantidade()));
      }
    }
    session.setAttribute("res_Jw_maiores_clientes_vencidos",res_Jw_maiores_clientes_vencidos);
    if (!(res_Jw_maiores_clientes_vencidos != null && res_Jw_maiores_clientes_vencidos.size() > 0)) {
      throw new Exception("Nenhum registro encontrado!");
    }


    StringBuilder fone = new StringBuilder();
    fone.setLength(0);
    if (res_Jw_maiores_clientes_vencidos != null && res_Jw_maiores_clientes_vencidos.size() > 0) {
      for (int x = 0; x < res_Jw_maiores_clientes_vencidos.size(); x++) {
        portalbr.dbobj.view.Jw_maiores_clientes_vencidos r = (portalbr.dbobj.view.Jw_maiores_clientes_vencidos) res_Jw_maiores_clientes_vencidos.elementAt(x);
        //-----------------------------------------------------
        if (f.getAcumular_pendencia()) {
          r.setValor(m.getValor(r.getCodigo(), r.getSequencial(), dias));
        }
        //-----------------------------------------------------
      }
    }
    session.setAttribute("mapping.getName()", form);
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      MaioresClientesVencidosActionForm f = (MaioresClientesVencidosActionForm) form;
      session.removeAttribute("res_Jw_maiores_clientes_vencidos");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_maiores_clientes_vencidos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
