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
 * Creation Date 03/08/2010 08:27:56
 * Last Modify Date 22/06/2015 14:31:11
 */

public class MaioresClientesLimiteCreditoAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    acesso.Sessao sessao = new acesso.Sessao(session);
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      MaioresClientesLimiteCreditoActionForm f = (MaioresClientesLimiteCreditoActionForm) form;
      select_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/adm/MaioresClientesLimiteCredito_rForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_maiores_clientes_limite_credito", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        try {
          util.consultas.Query query = new util.consultas.Query();
          query.execute("DELETE tmp_generic_table_brportal where varchar_column3 = '"+sessao.getUsuario() + "' and varchar_column4 = 'mclc'");
        } catch (Exception e) {}
        j.close();
      }
    }
    return actionForward;
  }
  private void select_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    MaioresClientesLimiteCreditoActionForm f = (MaioresClientesLimiteCreditoActionForm) form;
    Jw_maiores_clientes_limite_credito table = new Jw_maiores_clientes_limite_credito();
    boolean trocaCli = false;
    boolean filtraCidades = false;
    String qcliente = "";
    String qgrupo = "";
    StringBuilder sbcli = new StringBuilder();
    StringBuilder cidades = new StringBuilder();
    cidades.append("");
    util.consultas.Query query = new util.consultas.Query();

    acesso.Sessao sessao = new acesso.Sessao(session);



    sbcli.append(" FROM (SELECT DISTINCT c.* ");
    sbcli.append("    FROM cli c ");
    sbcli.append("       , ecl l ");
    sbcli.append("       , rep r ");
    sbcli.append("       , cliente_representante cr ");
    sbcli.append("   WHERE c.cli_cdgo = l.cli_cdgo ");
    sbcli.append("     AND cr.codigo_cliente = c.cli_cdgo ");
    sbcli.append("     AND cr.codigo_sequencial = l.esc_seqn ");



    if (f.getCodigo_cidade1() != "") {

      if (cidades.toString().equals("")) {
        cidades.append("'" + f.getDescricao_cidade1() + "'");
      } else {
        cidades.append(",'" + f.getDescricao_cidade1() + "'");
      }
      trocaCli = true;
      filtraCidades = true;
    }

    if (f.getCodigo_cidade2() != "") {
      if (cidades.toString().equals("")) {
        cidades.append("'" + f.getDescricao_cidade2() + "'");
      } else {
        cidades.append(",'" + f.getDescricao_cidade2() + "'");
      }
      trocaCli = true;
      filtraCidades = true;
    }

    if (f.getCodigo_cidade3() != "") {
      if (cidades.toString().equals("")) {
        cidades.append("'" + f.getDescricao_cidade3() + "'");
      } else {
        cidades.append(",'" + f.getDescricao_cidade3() + "'");
      }
      trocaCli = true;
      filtraCidades = true;
    }

    if (f.getCodigo_cidade4() != "") {
      if (cidades.toString().equals("")) {
        cidades.append("'" + f.getDescricao_cidade4() + "'");
      } else {
        cidades.append(",'" + f.getDescricao_cidade4() + "'");
      }
      trocaCli = true;
      filtraCidades = true;
    }

    if (f.getCodigo_cidade5() != "") {
      if (cidades.toString().equals("")) {
        cidades.append("'" + f.getDescricao_cidade5() + "'");
      } else {
        cidades.append(",'" + f.getDescricao_cidade5() + "'");
      }
      trocaCli = true;
      filtraCidades = true;
    }

    if (filtraCidades) {
      sbcli.append("  AND l.ecl_cdad in ("+cidades.toString() + ") ");
    }



    if (f.getCodigo_regional() != "") {
      sbcli.append("  AND r.codigo_regional = " + f.getCodigo_regional());
      trocaCli = true;
    }

    if (f.getRep_cdgo() != "") {
      sbcli.append("  AND r.rep_cdgo = '"+f.getRep_cdgo() + "' ");
      trocaCli = true;
    }

    sbcli.append("     AND cr.codigo_representante = r.rep_cdgo ");
    sbcli.append("     AND l.ned_cdgo IN ('COB', 'UNI')) c ");

    if ((f.getGre_grupo() != "") && (f.getCli_cdgo().equals(""))) {
      qgrupo = " and g.gre_grupo = " + f.getGre_grupo();
      qcliente = " and c.cli_cdgo = -1";
    }
    if ((f.getCli_cdgo() != "") && (f.getGre_grupo().equals(""))) {
      qcliente = " and c.cli_cdgo = " + f.getCli_cdgo();
      qgrupo = " and g.gre_grupo = -1";
    }
    if ((f.getCli_cdgo() != "") && (f.getGre_grupo() != "")) {
      qcliente = " and c.cli_cdgo = " + f.getCli_cdgo();
      qgrupo = " and g.gre_grupo = " + f.getGre_grupo();
    }
    StringBuilder sb = new StringBuilder();

    sb.append(" SELECT codigo ");
    sb.append("      , razao ");
    sb.append("      , tipo ");
    sb.append("      , limite ");
    sb.append("      , pedidos_producao ");
    sb.append("      , saldo ");
    sb.append("      , p_qtd_vencer ");
    sb.append("      , p_vlr_vencer ");
    sb.append("      , p_qtd_vencido ");
    sb.append("      , p_vlr_vencido ");
    sb.append("      , percentual_pontualidade ");
    sb.append("      , pedidos_nao_liberados ");
    sb.append("   FROM (SELECT g.gre_grupo codigo ");
    sb.append("              , g.gre_descricao razao ");
    sb.append("              , 'Grupo' tipo ");
    sb.append("              , SUM(c.cli_valor_credito_analista) limite ");
    sb.append("              , 0.00 pedidos_producao ");
    sb.append("              , 0.00 saldo ");
    sb.append("              , 0.00 p_qtd_vencer ");
    sb.append("              , 0.00 p_vlr_vencer ");
    sb.append("              , 0.00 p_qtd_vencido ");
    sb.append("              , 0.00 p_vlr_vencido ");
    sb.append("              , 0.00 percentual_pontualidade ");
    sb.append("              , 0.00 pedidos_nao_liberados ");

    if (trocaCli) {
      sb.append(sbcli.toString());
    } else {
      sb.append("           FROM cli c ");
    }

    sb.append("              , grupo_economico g ");
    sb.append("          WHERE g.cli_cdgo = c.cli_cdgo ");
    sb.append("            AND NVL(c.cli_situ, NULL) = 'A' ");
    sb.append("            AND nvl(g.status,NULL) = 'A' ");
    sb.append("            AND c.cli_tipo_mercado = NVL("+f.getTipo_mercado() + ", c.cli_tipo_mercado) ");
    sb.append(qgrupo);
    sb.append("         HAVING SUM(c.cli_valor_credito_analista) > 0 ");
    sb.append("          GROUP BY g.gre_grupo ");
    sb.append("                 , g.gre_descricao ");
    sb.append("         UNION ");
    sb.append("         SELECT c.cli_cdgo codigo ");
    sb.append("              , c.cli_rzao razao ");
    sb.append("              , 'Cliente' tipo ");
    sb.append("              , c.cli_valor_credito_analista limite ");
    sb.append("              , 0.00 pedidos_producao ");
    sb.append("              , 0.00 saldo ");
    sb.append("              , 0.00 p_qtd_vencer ");
    sb.append("              , 0.00 p_vlr_vencer ");
    sb.append("              , 0.00 p_qtd_vencido ");
    sb.append("              , 0.00 p_vlr_vencido ");
    sb.append("              , 0.00 percentual_pontualidade ");
    sb.append("              , 0.00 pedidos_nao_liberados ");

    if (trocaCli) {
      sb.append(sbcli.toString());
    } else {
      sb.append("           FROM cli c ");
    }


    sb.append("          WHERE NVL(c.cli_situ, NULL) = 'A' ");
    sb.append("            AND c.cli_cdgo <> 40000 ");
    sb.append("            AND c.cli_tipo_mercado = NVL("+f.getTipo_mercado() + ", c.cli_tipo_mercado) ");
    sb.append("            AND c.cli_valor_credito_analista > 0 ");
    sb.append(qcliente);
    if (qcliente.equals("")) {
      sb.append("          AND NOT EXISTS (SELECT 1 ");
      sb.append("                            FROM grupo_economico g ");
      sb.append("                           WHERE g.cli_cdgo = c.cli_cdgo ");
      sb.append("                             AND nvl(g.status,NULL) = 'A' ) ");
    }
    sb.append("          ORDER BY limite DESC) l ");
    sb.append("  WHERE ROWNUM <= "+f.getQuantidade());

    if (false) {
      throw new Exception(sb.toString());
    }

    Vector res_Jw_maiores_clientes_limite_credito = j.select(table, sb.toString(), null);

    // --------------------
    for (int x = 0; x < res_Jw_maiores_clientes_limite_credito.size(); x++) {
      portalbr.dbobj.view.Jw_maiores_clientes_limite_credito r = (portalbr.dbobj.view.Jw_maiores_clientes_limite_credito) res_Jw_maiores_clientes_limite_credito.elementAt(x);
      portalbr.dbobj.procedure.Prc_maiores_cli_limite_credito proc = new portalbr.dbobj.procedure.Prc_maiores_cli_limite_credito();

      if (r.getTipo().equals("Cliente")) {
        proc.setP_cli_cdgo(r.getCodigo() + "");
      } else {
        proc.setP_gre_grupo(r.getCodigo() + "");
      }
      if (!(f.getTipo_mercado().equals("null"))) {
        proc.setP_tipo_mercado(f.getTipo_mercado().replace("'",""));
      }
      proc.setP_meses(Integer.parseInt(f.getMeses()));
      proc = (portalbr.dbobj.procedure.Prc_maiores_cli_limite_credito) j.execute(proc);
      if (proc != null) {
        r.setPedidos_producao(proc.getP_vlr_ped_abe_lib());
        r.setSaldo(proc.getP_saldo());
        r.setLimite(proc.getP_limite());
        r.setPercentual_pontualidade(proc.getP_percentual_pontualidade());
        r.setP_qtd_vencer(proc.getP_qtd_vencer());
        r.setP_vlr_vencer(proc.getP_vlr_vencer());
        r.setP_qtd_vencido(proc.getP_qtd_vencido());
        r.setP_vlr_vencido(proc.getP_vlr_vencido());
        r.setPedidos_nao_liberados(proc.getP_vlr_ped_abe_nlib());
      }

      if (f.getOrdenacao().equals("s")) {
        query.execute("INSERT INTO tmp_generic_table_brportal (number_column1,varchar_column1,varchar_column2,varchar_column3,varchar_column4,number_column2,number_column3,number_column4,number_column5,number_column6,number_column7,number_column8,number_column9) VALUES ("+r.getCodigo() + ",'"+r.getRazao() + "','"+r.getTipo() + "','"+sessao.getUsuario() + "','mclc',"+r.getLimite() + ","+r.getPedidos_producao() + ","+r.getSaldo() + ","+r.getP_qtd_vencer() + ","+r.getP_vlr_vencer() + ","+r.getP_qtd_vencido() + ","+r.getP_vlr_vencido() + ","+r.getPercentual_pontualidade() + ")");
      }

    }
    //-------------------------------------------
    if (f.getOrdenacao().equals("s")) {
      java.util.Vector res_Tmp_generic_table_brportal = null;
      try {
        portalbr.dbobj.table.Tmp_generic_table_brportal t_tmp_generic_table_brportal = new portalbr.dbobj.table.Tmp_generic_table_brportal();
        String[][] select = {{"number_column1",null},{"number_column2",null},{"number_column3",null},{"number_column4",null},{"number_column5",null},{"varchar_column1",null},{"varchar_column2",null},{"varchar_column3",null},{"varchar_column4",null},{"varchar_column5",null},{"date_column1",null},{"date_column2",null},{"date_column3",null},{"date_column4",null},{"date_column5",null},{"number_column6",null},{"number_column7",null},{"number_column8",null},{"number_column9",null},{"number_column10",null},{"varchar_column6",null},{"number_column11",null},{"number_column12",null},{"number_column13",null},{"number_column14",null},{"number_column15",null},{"number_column16",null},{"varchar_column7",null},{"varchar_column8",null},{"varchar_column9",null},{"varchar_column10",null},{"number_column17",null},{"number_column18",null},{"number_column19",null},{"number_column20",null},{"number_column21",null},{"number_column22",null},{"number_column23",null},{"number_column24",null},{"number_column25",null},{"date_column6",null},{"date_column7",null},{"date_column8",null},{"date_column9",null},{"date_column10",null},};
        String[][] where = {{"varchar_column4","=","mclc"}};
        String[] order = {"number_column4 desc"};
        res_Tmp_generic_table_brportal = j.select(t_tmp_generic_table_brportal, select, where, null, null, order);
      } catch (Exception e) {
      }
      //-------------------------------------------
      for (int x = 0; x < res_Jw_maiores_clientes_limite_credito.size(); x++) {
        portalbr.dbobj.view.Jw_maiores_clientes_limite_credito r = (portalbr.dbobj.view.Jw_maiores_clientes_limite_credito) res_Jw_maiores_clientes_limite_credito.elementAt(x);
        portalbr.dbobj.table.Tmp_generic_table_brportal tmp = (portalbr.dbobj.table.Tmp_generic_table_brportal) res_Tmp_generic_table_brportal.elementAt(x);
        r.setCodigo(((Double) tmp.getNumber_column1()).intValue());
        r.setRazao(tmp.getVarchar_column1());
        r.setTipo(tmp.getVarchar_column2());
        r.setLimite(tmp.getNumber_column2());
        r.setPedidos_producao(tmp.getNumber_column3());
        r.setSaldo(tmp.getNumber_column4());
        r.setP_qtd_vencer(tmp.getNumber_column5());
        r.setP_vlr_vencer(tmp.getNumber_column6());
        r.setP_qtd_vencido(tmp.getNumber_column7());
        r.setP_vlr_vencido(tmp.getNumber_column8());
        r.setPercentual_pontualidade(tmp.getNumber_column9());
      }
    }

    //-------------------------------------------
    session.setAttribute("res_Jw_maiores_clientes_limite_credito",res_Jw_maiores_clientes_limite_credito);
    if (!(res_Jw_maiores_clientes_limite_credito != null && res_Jw_maiores_clientes_limite_credito.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_maiores_clientes_limite_credito", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute("mapping.getName()", form);
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      MaioresClientesLimiteCreditoActionForm f = (MaioresClientesLimiteCreditoActionForm) form;
      session.removeAttribute("res_Jw_maiores_clientes_limite_credito");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_maiores_clientes_limite_credito", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
