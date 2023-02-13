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
 * Creation Date 26/03/2010 07:14:28
 * Last Modify Date 19/01/2015 09:35:45
 */

public class ClientesNaoAtendidosAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ClientesNaoAtendidosActionForm f = (ClientesNaoAtendidosActionForm) form;
      select_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/com/ClientesNaoAtendidos_rForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_clientes_nao_atendidos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    Jw_consulta_clientes_nao_atendidos table = new Jw_consulta_clientes_nao_atendidos();
    ClientesNaoAtendidosActionForm f = (ClientesNaoAtendidosActionForm) form;
    StringBuilder query = new StringBuilder();
    Vector res_Jw_consulta_clientes_nao_atendidos = null;
    String regional = "";
    String representante = "";
    String rep_situ = "";
    String cli_rep_situ = "";

    try {

      if (f.getData_ini() == "") {
        throw new Exception("Data inicial inválida!");
      }

      if (f.getData_fim() == "") {
        throw new Exception("Data final inválida!");
      }

      if (f.getReg_cdgo() == "" && f.getRep_cdgo() == "") {
        throw new Exception("Um dos campos com <img src=\"../img/opcional.gif\"></img> deve ser preenchido!");
      }

      if (f.getReg_cdgo() != "") {
        regional = "    AND nvl(rep.codigo_regional,null) IN (" + f.getReg_cdgo() + ") ";
      }

      if (f.getRep_cdgo() != "") {
        representante = "    AND nvl(rep.rep_cdgo,null) IN (" + f.getRep_cdgo() + ") ";
      }

      if (f.getRep_situ() != "") {
        rep_situ = "    AND nvl(rep.rep_situ,null) = "+f.getRep_situ();
      }

      if (f.getCli_rep_situ() != "") {
        cli_rep_situ = "    AND nvl(clr.situacao,null) = "+f.getCli_rep_situ();
      }

      query.append(" SELECT DISTINCT qry.cli_cdgo ");
      query.append("                ,esc_seqn ");
      query.append("                ,cli_nome ");
      query.append("                ,cli_rzao ");
      query.append("                ,fct_formata_cnpj(cnpj) cnpj ");
      query.append("                ,cidade ");
      query.append("                ,uf ");
      query.append("                ,endereco ");

      query.append("               ,(SELECT MAX(data) ");
      query.append("                   FROM (SELECT MAX(data_ultima_compra) data ");
      query.append("                               ,cli_cdgo ");
      query.append("                               ,esc_seqn ");
      query.append("                           FROM (SELECT rp.data_dig data_ultima_compra ");
      query.append("                                       ,rp.cli_cdgo ");
      query.append("                                       ,rp.esc_seqn ");
      query.append("                                   FROM resumo_ped rp ");
      query.append("                                  WHERE (rp.data_dig < TO_DATE('"+ f.getData_ini() + "', 'dd/MM/yyyy') OR rp.data_dig > TO_DATE('"+ f.getData_fim() + "', 'dd/MM/yyyy') + 1) ");
      if (f.getReg_cdgo() != "") {
        query.append("                                 AND rp.codigo_regional IN (" + f.getReg_cdgo() + ")  ");
      }
      if (f.getRep_cdgo() != "") {
        query.append("                                 AND rp.rep_cdgo IN (" + f.getRep_cdgo() + ")  ");
      }
      query.append("                                 UNION ALL ");
      query.append("                                 SELECT rp.data_dig data_ultima_compra ");
      query.append("                                       ,rp.cli_cdgo ");
      query.append("                                       ,rp.esc_seqn ");
      query.append("                                   FROM resumo_pedidos rp ");
      query.append("                                  WHERE (rp.data_dig < TO_DATE('"+ f.getData_ini() + "', 'dd/MM/yyyy') OR rp.data_dig > TO_DATE('"+ f.getData_fim() + "', 'dd/MM/yyyy') + 1) ");
      if (f.getReg_cdgo() != "") {
        query.append("                          AND rp.codigo_regional IN (" + f.getReg_cdgo() + ")  ");
      }
      if (f.getRep_cdgo() != "") {
        query.append("                          AND rp.rep_cdgo IN (" + f.getRep_cdgo() + ")  ");
      }
      query.append("                          ) GROUP BY cli_cdgo ");
      query.append("                                  ,esc_seqn) ");
      query.append("                  WHERE cli_cdgo = qry.cli_cdgo ");
      query.append("                    AND esc_seqn = qry.esc_seqn) cli_dult ");

      query.append("                ,pc.limite_credito ");
      query.append("                ,(SELECT TO_CHAR(ffs_ddd2, '0000') || '-' || ffs_nmro2 ");
      query.append("                    FROM fax_fon2 f ");
      query.append("                   WHERE f.cli_cdgo = cli_cdgo ");
      query.append("                     AND f.esc_seqn = esc_seqn ");
      query.append("                     AND ROWNUM = 1) fone ");
      query.append("                ,esc_email ");
      query.append("                ,decode(ge.gre_grupo,NULL,'', (gre_grupo || ' - ' || gre_descricao )) grupo_economico ");
      query.append("   FROM (SELECT cli.cli_cdgo ");
      query.append("               ,e.esc_seqn ");
      query.append("               ,cli.cli_nome ");
      query.append("               ,cli.cli_rzao ");
      query.append("               ,e.esc_cgc cnpj ");
      query.append("               ,ecl.ecl_cdad cidade ");
      query.append("               ,ecl.est_unifed uf ");
      query.append("               ,UPPER('Rua ' || ecl_nome || ', Nº ' || ecl_nmro || ', bairro ' || ecl_bair) endereco ");
      query.append("               ,e.esc_email ");
      query.append("           FROM cliente_representante clr ");
      query.append("               ,cli ");
      query.append("               ,representante_marca rm ");
      query.append("               ,parametros_cliente par ");
      query.append("               ,esc e ");
      query.append("               ,ecl ");
      query.append("               ,rep ");
      query.append("               ,seg ");
      query.append("          WHERE clr.codigo_representante = rep.rep_cdgo ");
      query.append("            AND e.cli_cdgo = cli.cli_cdgo ");
      query.append("            AND clr.codigo_sequencial = e.esc_seqn ");
      query.append("            AND ecl.cli_cdgo = e.cli_cdgo ");
      query.append("            AND ecl.esc_seqn = e.esc_seqn ");
      query.append("            AND cli.cli_cdgo = clr.codigo_cliente ");
      query.append("            AND rm.codigo_representante = rep.rep_cdgo ");
      query.append("            AND NVL(cli.cli_situ, NULL) = 'A' ");
      query.append("            AND cli.seg_cdgo NOT IN (9, 153) ");
      query.append("            AND cli.seg_cdgo = seg.seg_cdgo ");
      query.append("            AND par.cli_cdgo = cli.cli_cdgo ");
      query.append(regional);
      query.append(representante);
      query.append(rep_situ);
      query.append(cli_rep_situ);
      query.append("            AND limite_credito > 0 ");
      query.append("         MINUS (SELECT cli_cdgo ");
      query.append("                     ,esc_seqn ");
      query.append("                     ,cli_nome ");
      query.append("                     ,cli_rzao ");
      query.append("                     ,cnpj ");
      query.append("                     ,cidade ");
      query.append("                     ,uf ");
      query.append("                     ,endereco ");
      query.append("                     ,esc_email ");
      query.append("                 FROM (SELECT cli.cli_cdgo ");
      query.append("                             ,e.esc_seqn ");
      query.append("                             ,cli.cli_nome ");
      query.append("                             ,cli.cli_rzao ");
      query.append("                             ,e.esc_cgc cnpj ");
      query.append("                             ,ecl.ecl_cdad cidade ");
      query.append("                             ,ecl.est_unifed uf ");
      query.append("                             ,UPPER('Rua ' || ecl_nome || ', Nº ' || ecl_nmro || ', bairro ' || ecl_bair) endereco ");
      query.append("                             ,e.esc_email ");
      query.append("                         FROM resumo_ped res ");
      query.append("                             ,cli ");
      query.append("                             ,rep ");
      query.append("                             ,cliente_representante clr ");
      query.append("                             ,representante_marca rm ");
      query.append("                             ,esc e ");
      query.append("                             ,ecl ");
      query.append("                        WHERE res.data_dig >= TO_DATE('"+ f.getData_ini() + "', 'dd/MM/yyyy') ");
      query.append("                          AND res.data_dig < TO_DATE('"+ f.getData_fim() + "', 'dd/MM/yyyy') + 1 ");
      query.append("                          AND e.cli_cdgo = cli.cli_cdgo ");
      query.append("                          AND res.esc_seqn = e.esc_seqn ");
      query.append("                          AND ecl.cli_cdgo = e.cli_cdgo ");
      query.append("                          AND ecl.esc_seqn = e.esc_seqn ");
      query.append("                          AND clr.codigo_sequencial = e.esc_seqn ");
      query.append("                          AND cli.cli_cdgo = res.cli_cdgo ");
      query.append("                          AND rep.rep_cdgo = res.rep_cdgo ");
      query.append("                          AND clr.codigo_representante = rep.rep_cdgo ");
      query.append("                          AND cli.cli_cdgo = clr.codigo_cliente ");
      query.append("                          AND res.esc_seqn = clr.codigo_sequencial ");
      query.append("                          AND rm.marca_produto = res.codigo_marca ");
      query.append("                          AND rm.codigo_representante = rep.rep_cdgo ");
      query.append("                          AND cli.seg_cdgo NOT IN (9, 153) ");
      query.append(regional);
      query.append(representante);
      query.append(rep_situ);
      query.append(cli_rep_situ);
      query.append("                       UNION ALL ");
      query.append("                       SELECT cli.cli_cdgo ");
      query.append("                             ,e.esc_seqn ");
      query.append("                             ,cli.cli_nome ");
      query.append("                             ,cli.cli_rzao ");
      query.append("                             ,e.esc_cgc cnpj ");
      query.append("                             ,ecl.ecl_cdad cidade ");
      query.append("                             ,ecl.est_unifed uf ");
      query.append("                             ,UPPER('Rua ' || ecl_nome || ', Nº ' || ecl_nmro || ', bairro ' || ecl_bair) endereco ");
      query.append("                             ,e.esc_email ");
      query.append("                         FROM resumo_pedidos res ");
      query.append("                             ,cli ");
      query.append("                             ,rep ");
      query.append("                             ,cliente_representante clr ");
      query.append("                             ,representante_marca rm ");
      query.append("                             ,esc e ");
      query.append("                             ,ecl ");
      query.append("                        WHERE res.data_dig >= TO_DATE('"+ f.getData_ini() + "', 'dd/MM/yyyy') ");
      query.append("                          AND res.data_dig < TO_DATE('"+ f.getData_fim() + "', 'dd/MM/yyyy') + 1 ");
      query.append("                          AND e.cli_cdgo = cli.cli_cdgo ");
      query.append("                          AND res.esc_seqn = e.esc_seqn ");
      query.append("                          AND ecl.cli_cdgo = e.cli_cdgo ");
      query.append("                          AND ecl.esc_seqn = e.esc_seqn ");
      query.append("                          AND clr.codigo_sequencial = e.esc_seqn ");
      query.append("                          AND cli.cli_cdgo = res.cli_cdgo ");
      query.append("                          AND rep.rep_cdgo = res.rep_cdgo ");
      query.append("                          AND res.esc_seqn = clr.codigo_sequencial ");
      query.append("                          AND clr.codigo_representante = rep.rep_cdgo ");
      query.append("                          AND cli.cli_cdgo = clr.codigo_cliente ");
      query.append("                          AND rm.codigo_representante = rep.rep_cdgo ");
      query.append("                          AND rm.marca_produto = res.codigo_marca ");
      query.append("                          AND cli.seg_cdgo NOT IN (9, 153) ");
      query.append(regional);
      query.append(representante);
      query.append(rep_situ);
      query.append(cli_rep_situ);
      query.append(")) ");
      query.append("          ORDER BY 1) qry ");
      query.append("    , parametros_cliente pc ");
      query.append("    ,(SELECT * FROM grupo_economico WHERE NVL(status, NULL) = 'A') ge ");
      query.append(" WHERE qry.cli_cdgo = pc.cli_cdgo(+) ");
      query.append("    AND qry.cli_cdgo = ge.cli_cdgo(+) ");

      acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
      if (usuario.mostraQuery()) {
        throw new Exception(query.toString());
      }


      res_Jw_consulta_clientes_nao_atendidos = j.select(table, query.toString(), null);
      String cli_codigo = null;

      portalbr.dbobj.table.Ped table_ped = new portalbr.dbobj.table.Ped();
      for (int i = 0; i < res_Jw_consulta_clientes_nao_atendidos.size(); i++) {
        portalbr.dbobj.view.Jw_consulta_clientes_nao_atendidos r = (portalbr.dbobj.view.Jw_consulta_clientes_nao_atendidos) res_Jw_consulta_clientes_nao_atendidos.elementAt(i);
        if (r.getCli_dult() == null) {
          cli_codigo = r.getCli_cdgo() + "";
          StringBuilder sb2 = new StringBuilder();
          sb2.append(" select  max(p.ped_dadg) ped_dadg ");
          sb2.append("   from  ped p ");
          sb2.append("  where  (p.ped_dadg         <  to_date('"+ f.getData_ini() + "','dd/MM/yyyy') or ");
          sb2.append("         p.ped_dadg         >  to_date('"+ f.getData_fim() + "','dd/MM/yyyy')+1) ");
          sb2.append("    and  nvl(p.ped_stat, 'X')          <> 'C' ");
          sb2.append("    and  nvl(p.ped_tipo, 'XX')         in ('EX', 'PG', 'PP') ");
          sb2.append("    and  nvl(p.ped_especie_pedido,'x') in ('F', 'N', 'M', 'P', 'X') ");
          sb2.append("    and  nvl(p.ped_substituicao, 'N')  <> 'S' ");
          sb2.append("    and  p.cli_cdgo                    =  ").append(r.getCli_cdgo());

          Vector res_Ped = j.select(table_ped, sb2.toString(), null);

          if (res_Ped != null && res_Ped.size() > 0) {
            portalbr.dbobj.table.Ped r_ped = (portalbr.dbobj.table.Ped) res_Ped.elementAt(0);
            r.setCli_dult(r_ped.getPed_dadg());
          }
        }
        //-----------------------------------------------------------------------------------------------------------------
      }

    }
    finally {
    }

    session.setAttribute("res_Jw_consulta_clientes_nao_atendidos",res_Jw_consulta_clientes_nao_atendidos);
    if (res_Jw_consulta_clientes_nao_atendidos != null && res_Jw_consulta_clientes_nao_atendidos.size() > 0) {
      Jw_consulta_clientes_nao_atendidos r = (Jw_consulta_clientes_nao_atendidos) res_Jw_consulta_clientes_nao_atendidos.elementAt(0);
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_clientes_nao_atendidos", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute(mapping.getName(), form);
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ClientesNaoAtendidosActionForm f = (ClientesNaoAtendidosActionForm) form;
      session.removeAttribute("res_Jw_consulta_clientes_nao_atendidos");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_clientes_nao_atendidos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
