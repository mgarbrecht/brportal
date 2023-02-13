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
 * Creation Date 04/09/2006 10:14:29
 * Last Modify Date 03/05/2018 11:30:40
 */

public class Clientes_nao_atendidosAction extends com.egen.util.struts.AbstractAction {

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
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes_nao_atendidos", new ActionMessage("error.action.exception", com.egen.util.system.Error.getMessage(e)));
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
    Clientes_nao_atendidosActionForm f = (Clientes_nao_atendidosActionForm) form;
    portalbr.dbobj.view.Jw_clientes_nao_atendidos table = new portalbr.dbobj.view.Jw_clientes_nao_atendidos();
    java.sql.ResultSet rset = null;
    java.sql.PreparedStatement pstm = null;
    Vector res_Jw_clientes_nao_atendidos = null;

    try {
      String limite = "";
      String segmento = "";
      String limite_qry = "";
      String representante = "null";
      String marca = "null";
      String regional = "null";

      if (!(f.getRep_cdgo() == null)) {
        representante = f.getRep_cdgo();
      } else {
        representante = "null";
      }
      if (!(f.getCodigo_marca() == null)) {
        marca = f.getCodigo_marca();
      } else {
        marca = "null";
      }
      if (!(f.getCodigo_regional() == null)) {
        regional = f.getCodigo_regional();
      } else {
        regional = "null";
      }

      if (!(f.getSegmento() == null)) {
        segmento = f.getSegmento();
      } else {
        segmento = "null";
      }

      if (!(f.getLimite() == null)) {
        limite = f.getLimite();
        if (limite.equals("p")) {
          limite_qry = " AND limite_credito <= 50000 ";
        }
        if (limite.equals("m")) {
          limite_qry = " AND limite_credito > 50000 and limite_credito <= 200000 ";
        }
        if (limite.equals("g")) {
          limite_qry = " AND limite_credito > 200000 ";
        }
      }

      StringBuilder query = new StringBuilder();
      query.append(" SELECT /*+ all_rows */ c.cli_cdgo ");
      query.append("       ,c.cli_nome ");
      query.append("       ,c.cli_rzao ");
      query.append("       ,'' cnpj ");
      query.append("       ,'' cidade ");
      query.append("       ,'' endereco ");
      query.append("       ,'' cli_dult ");
      if (((String) session.getAttribute("ca_consulta_saldo_limite_credito")).equalsIgnoreCase("S")) {
        query.append("   , fnc_ctr_saldo_limite(c.cli_cdgo, '01') saldo ");
      } else {
        query.append("   , 0 saldo ");
      }
      query.append("      , NVL(cli_valor_credito_analista, 0) limite_credito ");
      query.append("   FROM (  ");
      query.append(" SELECT DISTINCT ");
      query.append("        cli.cli_cdgo ");
      query.append("      , cli.cli_nome ");
      query.append("      , cli.cli_rzao ");
      query.append("   FROM rep ");
      query.append("      , cliente_representante clr ");
      query.append("      , cli ");
      query.append("      , representante_marca rm ");
      query.append("      , seg ");
      query.append("      , parametros_cliente par ");
      query.append("  WHERE clr.codigo_representante =  rep.rep_cdgo ");
      query.append("    AND cli.cli_cdgo              =  clr.codigo_cliente ");
      query.append("    AND rm.codigo_representante   =  rep.rep_cdgo ");
      query.append("    AND cli.cli_situ              =  'A' ");
      query.append("    AND cli.seg_cdgo              NOT IN (9,153) ");
      query.append("    AND cli.seg_cdgo              =  seg.seg_cdgo ");
      query.append("    AND par.cli_cdgo              =  cli.cli_cdgo ");
      query.append("    AND seg.seg_cdgo              =  nvl(").append(segmento).append(",seg.seg_cdgo) ");
      query.append("    AND rep.rep_situ              =  nvl(").append(session.getAttribute("situacao_representante")).append(",rep.rep_situ) ");
      query.append("    AND clr.situacao              =  nvl(").append(session.getAttribute("situacao_cliente_representante")).append(",clr.situacao) ");
      query.append("    AND rm.situacao               =  nvl(").append(session.getAttribute("situacao_representante_marca")).append(",rm.situacao) ");
      query.append("    AND rep.codigo_regional       =  nvl(").append(regional).append(",rep.codigo_regional) ");
      query.append("    AND rep_cdgo                  =  nvl(").append(representante).append(",rep_cdgo) ");
      query.append("    AND rm.marca_produto          =  nvl(").append(marca).append(",rm.marca_produto) ");
      query.append("    AND rm.marca_produto          =  nvl(").append(session.getAttribute("codigo_marca")).append(",rm.marca_produto) ");
      query.append("    AND rep.codigo_regional       =  nvl(").append(session.getAttribute("codigo_regional")).append(",rep.codigo_regional) ");
      query.append(limite_qry);
      query.append("  MINUS ( ");
      query.append(" SELECT cli_cdgo ");
      query.append("      , cli_nome ");
      query.append("      , cli_rzao ");
      query.append("   FROM ( ");
      query.append(" SELECT cli.cli_cdgo ");
      query.append("      , cli.cli_nome ");
      query.append("      , cli.cli_rzao ");
      query.append("   FROM resumo_ped res ");
      query.append("      , cli ");
      query.append("      , rep ");
      query.append("      , cliente_representante clr ");
      query.append("      , representante_marca rm  ");
      query.append("  WHERE res.data_dig             >= to_date('").append(session.getAttribute("dt_inicial")).append("','dd/MM/yyyy') ");
      query.append("    AND res.data_dig             <  to_date('").append(session.getAttribute("dt_final")).append("','dd/MM/yyyy')+1 ");
      query.append("    AND res.lin_cdgo             =  nvl(").append(session.getAttribute("lin_cdgo")).append(",res.lin_cdgo) ");
      query.append("    AND res.codigo_marca         =  nvl(").append(session.getAttribute("codigo_marca")).append(",res.codigo_marca) ");
      query.append("    AND res.codigo_regional      =  nvl(").append(session.getAttribute("codigo_regional")).append(",res.codigo_regional) ");
      query.append("    AND cli.cli_cdgo             =  res.cli_cdgo ");
      query.append("    AND rep.rep_cdgo             =  res.rep_cdgo ");
      query.append("    AND clr.codigo_representante =  rep.rep_cdgo ");
      query.append("    AND cli.cli_cdgo             =  clr.codigo_cliente  ");
      query.append("    AND res.esc_seqn             =  clr.codigo_sequencial ");
      query.append("    AND rm.marca_produto         =  res.codigo_marca ");
      query.append("    AND rm.codigo_representante  =  rep.rep_cdgo ");
      query.append("    AND res.codigo_marca         =  nvl(").append(marca).append(",res.codigo_marca) ");
      query.append("    AND res.codigo_regional      =  nvl(").append(regional).append(",res.codigo_regional) ");
      query.append("    AND res.rep_cdgo             =  nvl(").append(representante).append(",res.rep_cdgo ) ");
      query.append("    AND cli.cli_situ             =  nvl('A',cli.cli_situ) ");
      query.append("    AND cli.seg_cdgo             NOT IN (9,153) ");
      query.append("    AND rep.rep_situ             =  nvl(").append(session.getAttribute("situacao_representante")).append(",rep.rep_situ) ");
      query.append("    AND clr.situacao             =  nvl(").append(session.getAttribute("situacao_cliente_representante")).append(",clr.situacao) ");
      query.append("    AND rm.situacao              =  nvl(").append(session.getAttribute("situacao_representante_marca")).append(",rm.situacao) ");
      query.append("  UNION ALL ");
      query.append(" SELECT cli.cli_cdgo        ");
      query.append("      , cli.cli_nome        ");
      query.append("      , cli.cli_rzao        ");
      query.append("   FROM resumo_pedidos res  ");
      query.append("      , cli                 ");
      query.append("      , rep                 ");
      query.append("      , cliente_representante clr ");
      query.append("      , representante_marca rm  ");
      query.append("  WHERE res.data_dig             >= to_date('").append(session.getAttribute("dt_inicial")).append("','dd/MM/yyyy') ");
      query.append("    AND res.data_dig             <  to_date('").append(session.getAttribute("dt_final")).append("','dd/MM/yyyy')+1 ");
      query.append("    AND res.lin_cdgo             =  nvl(").append(session.getAttribute("lin_cdgo")).append(",res.lin_cdgo) ");
      query.append("    AND res.codigo_marca         =  nvl(").append(session.getAttribute("codigo_marca")).append(",res.codigo_marca) ");
      query.append("    AND res.codigo_regional      =  nvl(").append(session.getAttribute("codigo_regional")).append(",res.codigo_regional) ");
      query.append("    AND cli.cli_cdgo             =  res.cli_cdgo ");
      query.append("    AND rep.rep_cdgo             =  res.rep_cdgo ");
      query.append("    AND res.esc_seqn             =  clr.codigo_sequencial ");
      query.append("    AND clr.codigo_representante =  rep.rep_cdgo ");
      query.append("    AND cli.cli_cdgo             =  clr.codigo_cliente ");
      query.append("    AND rm.codigo_representante  =  rep.rep_cdgo ");
      query.append("    AND rm.marca_produto         =  res.codigo_marca ");
      query.append("    AND res.codigo_marca         =  nvl(").append(marca).append(",res.codigo_marca) ");
      query.append("    AND res.codigo_regional      =  nvl(").append(regional).append(",res.codigo_regional) ");
      query.append("    AND res.rep_cdgo             =  nvl(").append(representante).append(",res.rep_cdgo ) ");
      query.append("    AND cli.cli_situ             =  nvl('A',cli.cli_situ) ");
      query.append("    AND cli.seg_cdgo             NOT IN (9,153) ");
      query.append("    AND rep.rep_situ             =  nvl(").append(session.getAttribute("situacao_representante")).append(",rep.rep_situ) ");
      query.append("    AND clr.situacao             =  nvl(").append(session.getAttribute("situacao_cliente_representante")).append(",clr.situacao) ");
      query.append("    AND rm.situacao              =  nvl(").append(session.getAttribute("situacao_representante_marca")).append(",rm.situacao) ");
      query.append("  )  ");
      query.append("  ) ORDER  BY 1 ) cc ");
      query.append("   ,cli c ");
      query.append(" WHERE c.cli_cdgo = cc.cli_cdgo ");


      if (false) {
        throw new Exception(query.toString());
      }
      res_Jw_clientes_nao_atendidos = j.select(table, query.toString(), null);

      //------------------------------------------------------------
      StringBuilder sb = new StringBuilder();
      sb.append(" SELECT /*+ all_rows */ ");
      sb.append("  CASE ");
      sb.append("    WHEN MAX(data_ultima_compra) IS NULL THEN ");
      sb.append("     MAX((SELECT MAX(p.ped_dadg) ped_dadg ");
      sb.append("           FROM ped p ");
      sb.append("          WHERE (p.ped_dadg < to_date('").append(session.getAttribute("dt_inicial")).append("', 'dd/MM/yyyy') OR ");
      sb.append("                p.ped_dadg > to_date('").append(session.getAttribute("dt_final")).append("', 'dd/MM/yyyy') + 1) ");
      sb.append("            AND NVL(p.ped_stat, 'X') <> 'C' ");
      sb.append("            AND NVL(p.ped_tipo, 'XX') IN ('EX', 'PG', 'PP') ");
      sb.append("            AND NVL(p.ped_especie_pedido, 'x') IN ('F', 'N', 'M', 'P', 'X') ");
      sb.append("            AND NVL(p.ped_substituicao, 'N') <> 'S' ");
      sb.append("            AND p.cli_cdgo = ?)) ");
      sb.append("    ELSE ");
      sb.append("     MAX(data_ultima_compra) ");
      sb.append("  END data ");
      sb.append("   FROM (SELECT MAX(rp.data_dig) data_ultima_compra ");
      sb.append("           FROM resumo_ped rp ");
      sb.append("          WHERE rp.cli_cdgo = ? ");
      sb.append("            AND rp.codigo_marca     =  nvl(").append(session.getAttribute("codigo_marca")).append(",rp.codigo_marca) ");
      sb.append("            AND rp.codigo_regional  =  nvl(").append(session.getAttribute("codigo_regional")).append(",rp.codigo_regional) ");
      sb.append("            AND rp.lin_cdgo         =  nvl(").append(session.getAttribute("lin_cdgo")).append(",rp.lin_cdgo) ");
      sb.append("            AND rp.codigo_marca     =  nvl(").append(marca).append(",rp.codigo_marca) ");
      sb.append("            AND rp.codigo_regional  =  nvl(").append(regional).append(",rp.codigo_regional) ");
      sb.append("            AND rp.rep_cdgo         =  nvl(").append(representante).append(",rp.rep_cdgo ) ");
      sb.append("            AND (rp.data_dig        <  to_date('").append(session.getAttribute("dt_inicial")).append("','dd/MM/yyyy') or ");
      sb.append("                 rp.data_dig        >  to_date('").append(session.getAttribute("dt_final")).append("','dd/MM/yyyy')+1) ");
      sb.append("         UNION ALL ");
      sb.append("         SELECT MAX(rp.data_dig) data_ultima_compra ");
      sb.append("           FROM resumo_pedidos rp ");
      sb.append("          WHERE rp.cli_cdgo = ? ");
      sb.append("            AND rp.codigo_marca     =  nvl(").append(session.getAttribute("codigo_marca")).append(",rp.codigo_marca) ");
      sb.append("            AND rp.codigo_regional  =  nvl(").append(session.getAttribute("codigo_regional")).append(",rp.codigo_regional) ");
      sb.append("            AND rp.lin_cdgo         =  nvl(").append(session.getAttribute("lin_cdgo")).append(",rp.lin_cdgo) ");
      sb.append("            AND rp.codigo_marca     =  nvl(").append(marca).append(",rp.codigo_marca) ");
      sb.append("            AND rp.codigo_regional  =  nvl(").append(regional).append(",rp.codigo_regional) ");
      sb.append("            AND (rp.data_dig        <  to_date('").append(session.getAttribute("dt_inicial")).append("','dd/MM/yyyy') or ");
      sb.append("                 rp.data_dig        >  to_date('").append(session.getAttribute("dt_final")).append("','dd/MM/yyyy')+1) ");
      sb.append("            AND rp.rep_cdgo         =  nvl(").append(representante).append(",rp.rep_cdgo ) )");

      pstm = j.getConn().prepareStatement(sb.toString());

      String cli_codigo = null;

      util.consultas.Cidades cid = new util.consultas.Cidades(j);
      portalbr.dbobj.table.Ped table_ped = new portalbr.dbobj.table.Ped();
      for (int i = 0; i < res_Jw_clientes_nao_atendidos.size(); i++) {
        portalbr.dbobj.view.Jw_clientes_nao_atendidos r = (portalbr.dbobj.view.Jw_clientes_nao_atendidos) res_Jw_clientes_nao_atendidos.elementAt(i);
        pstm.setInt(1, Integer.parseInt(r.getCli_cdgo()));
        pstm.setInt(2, Integer.parseInt(r.getCli_cdgo()));
        pstm.setInt(3, Integer.parseInt(r.getCli_cdgo()));
        rset = pstm.executeQuery();
        while (rset.next()) {
          cli_codigo = r.getCli_cdgo() + "";
          r.setCli_dult(rset.getTimestamp(1));
          r.setCidade(cid.retornaCidades(cli_codigo));
          r.setEmail(cid.retornaEmails());
          r.setFones(cid.retornaFones());
          StringBuilder enderecos = new StringBuilder();
          StringBuilder cnpj = new StringBuilder();
          StringBuilder sbEndereco = new StringBuilder();
          portalbr.dbobj.view.Endereco tableEndereco = new portalbr.dbobj.view.Endereco();
          sbEndereco.append(" SELECT /*+ all_rows */ ");
          sbEndereco.append("        DISTINCT ecl.cli_cdgo ");
          sbEndereco.append("      , ecl.esc_seqn ");
          sbEndereco.append("      , ecl.ecl_cdad ");
          sbEndereco.append("      , esc.esc_cgc cnpj ");
          sbEndereco.append("      , ecl.ecl_nome || ',' || ecl.ecl_nmro || ', Bairro: ' || ecl.ecl_bair || ' , CEP: ' || ecl.ecl_cep endereco ");
          sbEndereco.append("   FROM ecl ");
          sbEndereco.append("      , esc ");
          sbEndereco.append("  WHERE ecl.ned_cdgo IN ('COB', 'UNI') ");
          sbEndereco.append("    AND esc.cli_cdgo(+) = ecl.cli_cdgo ");
          sbEndereco.append("    AND esc.esc_seqn(+) = ecl.esc_seqn ");
          sbEndereco.append("    AND esc.esc_situacao(+) = 'A' ");
          sbEndereco.append("    AND esc.cli_cdgo = ").append(cli_codigo);
          sbEndereco.append("  ORDER BY ecl.ecl_cdad ");
          Vector < ?> res_Enderecos = j.select(tableEndereco, sbEndereco.toString(), null);
          if (res_Enderecos != null && res_Enderecos.size() > 0) {
            portalbr.dbobj.view.Endereco rEndereco = (portalbr.dbobj.view.Endereco) res_Enderecos.elementAt(0);
            for (int x = 0; x < res_Enderecos.size(); x++) {
              rEndereco = (portalbr.dbobj.view.Endereco) res_Enderecos.elementAt(x);
              cnpj.append(((rEndereco.getCnpj() != null) ? rEndereco.getCnpj() + "<br>" : ""));
              enderecos.append((rEndereco.getEndereco() + "<br>"));
            }
          }

          r.setEndereco(enderecos.toString());
          r.setCnpj(cnpj.toString());
        }
      }
    }
    finally {
      if (rset != null) {
        rset.close();
      }
      if (pstm != null) {
        pstm.close();
      }
    }

    session.setAttribute("res_Jw_clientes_nao_atendidos", res_Jw_clientes_nao_atendidos);
    if (!(res_Jw_clientes_nao_atendidos != null && res_Jw_clientes_nao_atendidos.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes_nao_atendidos", new ActionMessage("warn.norowsselected", ""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute("mapping.getName()", form);
  }
}
