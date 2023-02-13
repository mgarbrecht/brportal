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
 * Creation Date 22/03/2006 09:57:01
 * Last Modify Date 05/10/2021 15:35:52
 */

public class ClientesAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;

    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      try {
        ClientesActionForm f = (ClientesActionForm) form;
        if (((f.getReg() != "") && (f.getRepresentante() != "")) || ((f.getRegional() != "") && (f.getRepresentante() != ""))) {
          tg_select_action(mapping, form, request, response);
        }
        select_action(j, mapping, form, request, response);
      }
      finally {
      }

      String codigo_regional = "";
      String codigo_representante = "";
      String tipo = "";
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
      }


      ClientesActionForm f = (ClientesActionForm) form;
      String cidade = "Todas";
      String cidadef = f.getEcl_cdad() + "";
      String nome_fantasia = f.getCli_nome() + "";
      String representante = "Todos";
      String regional = "Todas";
      String nome_regional = "";
      String nome_representante = "";
      String regional_consulta = "";
      String grupo_descricao = "Todos";
      String representante_consulta = "";

      if ((!(codigo_regional.equals("")))) {
        regional_consulta = codigo_regional;
        regional = codigo_regional + "-";
        representante = "null";
      } else {
        regional_consulta = f.getRegional();
        regional = "";
        if ((!((f.getRegional() + "").equals(""))) && (!((f.getRegional() + "").equals("null")))) {
          regional = f.getRegional() + "-";
        }
      }
      if ((!(codigo_representante.equals("")))) {
        representante_consulta = codigo_representante;
        representante = codigo_representante + "-";
        regional = "null";
      } else {
        representante_consulta = f.getRepresentante();
        representante = "";
        if ((!((f.getRepresentante() + "").equals(""))) && (!((f.getRepresentante() + "").equals("null")))) {
          representante = f.getRepresentante() + "-";
        }
      }

      //---------------------busca o nome do representante e da regional----------------------------------
      if ((!((regional_consulta + "").equals(""))) && (!((regional_consulta + "").equals("null")))) {
        portalbr.dbobj.table.Regionais_vendas db_object = new portalbr.dbobj.table.Regionais_vendas();
        Object[][] where = { {"codigo_regional","=", regional_consulta} };
        java.util.Vector results = j.select(db_object, where, null);
        if (results != null && results.size() > 0) {
          db_object = (portalbr.dbobj.table.Regionais_vendas) results.elementAt(0);
          nome_regional = (db_object.getNome_regional() != null) ? db_object.getNome_regional() + "":"";
        }
      }

      if ((!(representante_consulta.equals("")))) {
        portalbr.dbobj.table.Rep db_object = new portalbr.dbobj.table.Rep();
        Object[][] where = { {"rep_cdgo","like",representante_consulta} };
        java.util.Vector results = j.select(db_object, where, null);
        if (results != null && results.size() > 0) {
          db_object = (portalbr.dbobj.table.Rep) results.elementAt(0);
          nome_representante = (db_object.getRep_rzao() != null) ? db_object.getRep_rzao() + "":"";
        }
      }

      if (f.getGre_grupo() != "") {
        portalbr.dbobj.table.Grupo_economico db_object = new portalbr.dbobj.table.Grupo_economico();
        Object[][] where = { {"gre_grupo","like",f.getGre_grupo()} };
        java.util.Vector results = j.select(db_object, where, null);
        if (results != null && results.size() > 0) {
          db_object = (portalbr.dbobj.table.Grupo_economico) results.elementAt(0);
          grupo_descricao = f.getGre_grupo() + "-"+ ((db_object.getGre_descricao() != null) ? db_object.getGre_descricao() + "":"");
        }
      }


      //-------------------------------------------------------------------------------------------
      if ((!(f.getEcl_cdad().equals("")))) {
        cidade = cidadef.replace("%","|");
      };
      if ((!(f.getCli_nome().equals("")))) {
        nome_fantasia = nome_fantasia.replace("%","|");
      };
      actionForward = new ActionForward("/adm/Clientes_rForm.do?&ecl_cdad="+cidade + "&representante="+representante + nome_representante + "&p1="+regional + nome_regional + "&grupo="+grupo_descricao + "&nome_fantasia="+nome_fantasia, true);


      if (f.getTipo_arquivo().equalsIgnoreCase("pdf") || f.getTipo_arquivo().equalsIgnoreCase("xls")) {
        actionForward = mapping.findForward("same");
      }


      if ((!(f.getEcl_cdad().equals("")))) {
        cidade = cidadef.replace("%","|");
      };
    }
    catch (Exception e) {
      e.printStackTrace(System.err);
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    StringBuilder parametros = new StringBuilder();
    String regional = "null";
    String representante = "null";
    String situacao_cliente_representante = "null";
    String situacao_cliente_representante_row = "null";
    String situacao = "null";
    String grupo = "";
    String pagamento = "";
    String situacao_grupo = "";
    ClientesActionForm f = (ClientesActionForm) form;
    if ((f.getReg() + "").equals("") && (f.getRep() + "").equals("")) {
      if (f.getEcl_cdad().equals("") && f.getRepresentante().equals("") && f.getRegional().equals("") && f.getTra_consig().equals("") && f.getGre_grupo().equals("") && f.getEst_unifed().equals("") && f.getCli_nome().equals("")) {
        throw new Exception("Um dos par&#257;metros de pesquisa deve ser informado!");
      }
    }

    portalbr.dbobj.view.Jw_clientes table = new portalbr.dbobj.view.Jw_clientes();

    if (!(f.getSituacao_cliente_representante().equals("null"))) {
      situacao_cliente_representante = "'"+f.getSituacao_cliente_representante() + "'";
      situacao_cliente_representante_row = "''"+f.getSituacao_cliente_representante() + "''";
    }

    if (!(f.getSituacao().equals("null"))) {
      situacao = "'"+f.getSituacao() + "'";
    }

    if (f.getRepresentante() != "") {
      representante = f.getRepresentante();
    }

    if (f.getRep() != "") {
      representante = f.getRep();
    }

    if (f.getRegional() != "") {
      regional = f.getRegional();
    }

    if (f.getReg() != "") {
      regional = f.getReg();
    }

    if (f.getEcl_cdad() != "") {
      parametros.append(" and l.ecl_cdad like upper('"+f.getEcl_cdad() + "') ");
    }

    if (f.getTra_consig() != "") {
      parametros.append(" and nvl(esc.tra_consig,null) = " + f.getTra_consig());
    }

    if (f.getCli_nome() != "") {
      parametros.append(" and c.cli_nome like upper('"+f.getCli_nome() + "') ");
    }

    if (f.getEst_unifed() != "") {
      parametros.append(" and l.est_unifed like upper('"+f.getEst_unifed() + "') ");
    }

    if (f.getOrdenacao().equals("C")) {
      parametros.append(" order by l.ecl_cdad, c.cli_rzao ");
    }

    if (f.getOrdenacao().equals("R")) {
      parametros.append(" order by c.cli_rzao ");
    }

    if (f.getOrdenacao().equals("E")) {
      parametros.append(" order by l.est_unifed, l.ecl_cdad, c.cli_rzao ");
    }

    if (f.getOrdenacao().equals("G")) {
      parametros.append(" order by grupo, l.ecl_cdad, c.cli_rzao ");
    }

    if (f.getGre_grupo() != "") {
      grupo = " AND  gre.gre_grupo = nvl("+f.getGre_grupo() + ",gre.gre_grupo) ";
    }

    //  if(f.getGre_grupo().equals("") || f.getGre_grupo()==null){
    //      situacao_grupo = " or gre.status = 'I' ";
    //  }

    if (f.getGre_grupo().equals("") || f.getGre_grupo() == null) {
      situacao_grupo = " or gre.status = 'I' ";
    }

    if (f.getPagamento().equals("V")) {
      pagamento = " AND p.classificacao = 'C' ";
    }

    if (f.getPagamento().equals("N")) {
      pagamento = " AND p.classificacao is null ";
    }

    StringBuilder query = new StringBuilder();
    query.append(" SELECT /*+ all_rows */ DISTINCT ");
    query.append("        0 qt_contatos ");
    query.append("      , 0 qt_telefones ");
    query.append("      , c.cli_cdgo || '-' || esc.esc_seqn codigo ");
    query.append("      , c.cli_rzao ");
    query.append("      , c.cli_nome ");
    query.append("      , (l.ecl_nome || ', ' || l.ecl_nmro || ' ' || l.ecl_cpto) endereco ");

    if (f.getTipo_arquivo().equalsIgnoreCase("pdf")) {
      query.append("   , (SELECT REPLACE(rowtocol('SELECT TO_CHAR(ffs_ddd2, ''0000'') || '' - '' || ffs_nmro2 fone FROM fax_fon2 WHERE cli_cdgo = '||c.cli_cdgo||'  AND esc_seqn = '||esc.esc_seqn||'  AND ned_cdgo = '''||l.ned_cdgo||'''  AND cli_cdgo > 0'), ',', CHR(10)) FROM dual ) fone ");
    } else {
      query.append("   , replace(rowtocol('SELECT ''(''||ffs_ddd2||'') ''||ffs_nmro2 FROM fax_fon2 WHERE cli_cdgo = '||c.cli_cdgo||'  AND esc_seqn = '||esc.esc_seqn||'  AND ned_cdgo = '''||l.ned_cdgo||''' '),',','<br>') fones ");
    }

    query.append("      , l.ecl_cdad || '-' || l.est_unifed uf ");
    query.append("      , l.ecl_bair bairro ");
    query.append("      , fct_formata_cnpj(esc.esc_cgc) CNPJ ");
    query.append("      , esc.esc_inse inscr ");
    query.append("      , substr(l.ecl_cep, 1, 5) || '-' || substr(l.ecl_cep, 6, 8) cep ");
    query.append("      , c.cli_valor_credito_analista credito ");
    query.append("      , esc.esc_email email ");
    query.append("      , decode(esc.esc_situacao, 'A', 'Ativo', 'I', 'Inativo') situacao ");
    query.append("      , s.seg_desc segmento ");

    if (f.getGre_grupo() != "") {
      query.append("      , decode(gre.status,'A',gre.gre_descricao,'') grupo ");
    } else {
      query.append("      , NVL((SELECT gre_descricao              ");
      query.append("               FROM grupo_economico            ");
      query.append("             WHERE cli_cdgo = c.cli_cdgo       ");
      query.append("               AND status = 'A'), NULL) grupo  ");
    }

    if (f.getTipo_arquivo().equalsIgnoreCase("pdf")) {
      query.append(", (SELECT REPLACE(rowtocol('SELECT pec_nome || decode(pec_email, null, null, chr(10)||pec_email) FROM pec WHERE cli_cdgo = '||c.cli_cdgo||'  AND esc_seqn = '||esc.esc_seqn||'  AND ned_cdgo = '''||l.ned_cdgo||'''  AND cli_cdgo > 0'), ',', CHR(10)) FROM dual ) contatos ");
    } else if (f.getTipo_arquivo().equalsIgnoreCase("xls")) {
      query.append(", (SELECT REPLACE(rowtocol('SELECT pec_nome || decode(pec_email, null, null, chr(10)||pec_email) FROM pec WHERE cli_cdgo = '||c.cli_cdgo||'  AND esc_seqn = '||esc.esc_seqn||'  AND ned_cdgo = '''||l.ned_cdgo||'''  AND cli_cdgo > 0'), ',', ',') FROM dual ) contatos ");
    } else {
      query.append(", (SELECT REPLACE(rowtocol('SELECT pec_nome || decode(pec_email, null, null, ''<br><font color=\"red\">''||pec_email||''</font>'') FROM pec WHERE cli_cdgo = '||c.cli_cdgo||'  AND esc_seqn = '||esc.esc_seqn||'  AND ned_cdgo = '''||l.ned_cdgo||'''  AND cli_cdgo > 0'), ',', '<br>') FROM dual ) contatos ");
    }
    query.append("      , l.ned_cdgo ");
    query.append("      , l.ecl_cdad ");
    query.append("      , l.est_unifed ");
    query.append("      , c.cli_cdgo ");
    query.append("      , esc.esc_seqn ");
    query.append("      , decode(nvl(p.classificacao,'@'),'C','Vendor','Normal')  classificacao ");
    if (f.getMostrar_representantes()) {
      session.setAttribute("mostrar_representantes","s");
      query.append("      , replace((rowtocol('select codigo_representante||'' - ''||pck_representante.get_razao_social(codigo_representante) from cliente_representante crep where codigo_sequencial = '||esc.esc_seqn||' and crep.situacao  = nvl(").append(situacao_cliente_representante_row).append(",crep.situacao) and codigo_cliente = '||c.cli_cdgo)),',','<br>') representantes ");
    } else {
      session.setAttribute("mostrar_representantes","n");
      query.append("      , '' representantes ");
    }
    query.append("      , ecl_cxpo ");
    query.append("      , ecl_zona ");
    query.append("      , esc.tra_consig ");
    query.append("      , pck_transportadora.get_nome(esc.tra_consig) consignatario ");
    query.append("      , esc.tra_cdgo ");
    query.append("      , pck_transportadora.get_nome(esc.tra_cdgo) tra_nome ");
    //  query.append("      , catalogo_objetos.pck_cat_clientes.existe_pendencia(c.cli_cdgo, esc.esc_seqn) pendencia ");

    query.append("  ,( SELECT   (SUM(DECODE(SIGN((TRUNC(SYSDATE) - tit.tit_datvenc) - (21)), -1, ABS(fnc_ctr_saldo_negociacao(tit.emp_empresa, tit.fil_filial, tit.tip_codigo, tit.tit_codigo, tit.sit_codigo_situacao_titulo, tit.tit_vlpcp, tit.tit_vldeb)), 0))) - (SUM(DECODE(SIGN((TRUNC(SYSDATE) - tit.tit_datvenc) - (1)), -1, ABS(fnc_ctr_saldo_negociacao(tit.emp_empresa, tit.fil_filial, tit.tip_codigo, tit.tit_codigo, tit.sit_codigo_situacao_titulo, tit.tit_vlpcp, tit.tit_vldeb)), 0)))  ");
    query.append("            + (SUM(DECODE(SIGN((TRUNC(SYSDATE) - tit.tit_datvenc) - (10000)), -1, ABS(fnc_ctr_saldo_negociacao(tit.emp_empresa, tit.fil_filial, tit.tip_codigo, tit.tit_codigo, tit.sit_codigo_situacao_titulo, tit.tit_vlpcp, tit.tit_vldeb)), 0))) - (SUM(DECODE(SIGN((TRUNC(SYSDATE) - tit.tit_datvenc) - (21)), -1, ABS(fnc_ctr_saldo_negociacao(tit.emp_empresa, tit.fil_filial, tit.tip_codigo, tit.tit_codigo, tit.sit_codigo_situacao_titulo, tit.tit_vlpcp, tit.tit_vldeb)), 0))) pendencia ");
    query.append("        FROM titulos tit ");
    query.append("       WHERE tit.tit_status = 'A' ");
    query.append("         AND tit.cli_codigo = c.cli_cdgo");
    query.append("         AND tit.cac_sequencia <> 92 ");
    query.append("         AND NOT EXISTS (SELECT '1' ");
    query.append("                FROM situacoes_titulos_por_grupo sit ");
    query.append("               WHERE sit.sit_codigo_situacao_titulo = tit.sit_codigo_situacao_titulo ");
    query.append("                 AND sit.gst_cod_grupo_sit_titulo = 1 ");
    query.append("                 AND sit.data_inicial <= SYSDATE AND NVL(sit.data_final, SYSDATE) >= SYSDATE) ");
    query.append("         AND EXISTS (SELECT '1' ");
    query.append("                FROM tipos_de_titulo_por_grupo tip ");
    query.append("               WHERE tip.tip_codigo = tit.tip_codigo ");
    query.append("                 AND tip.gtt_codigo_grupo_tipo_titulo = 4 ");
    query.append("                 AND tip.data_inicial <= SYSDATE AND NVL(tip.data_final, SYSDATE) >= SYSDATE)) pendencia ");
    query.append("      , fnc_ctr_saldo_limite(c.cli_cdgo, '01') saldo_disponivel ");
    query.append("      , to_char(nvl(ult.data_ultima_compra_nota, ult_r.data_ultima_compra_resumo),'mm/yyyy') data_ultima_compra ");
    query.append("      , nvl(ult.valor_ultima_compra_nota, ult_r.valor_ultima_compra_resumo) valor_ultima_compra ");
    query.append("   FROM cliente_representante r ");
    query.append("      , ecl l ");
    query.append("      , esc ");
    query.append("      , cli c ");

    query.append("      , (select cli_cdgo, ");
    query.append("               max(data_ultima_compra_nota) data_ultima_compra_nota, ");
    query.append("               max(valor_ultima_compra_nota) valor_ultima_compra_nota ");
    query.append("          from (select cli_cdgo, ");
    query.append("                       LAST_DAY(ADD_MONTHS(nfs.nfs_dtemis, -1)) + 1 data_ultima_compra_nota, ");
    query.append("                       NVL(SUM(nfs.nfs_vltot), 0) valor_ultima_compra_nota ");
    query.append("                  FROM nf_saida nfs, naturezas_operacoes nat ");
    query.append("                 WHERE NVL(nfs.natoper_codigo, NULL) = nat.codigo ");
    query.append("                   AND NVL(nfs.stat_codigo, NULL) > 1 ");
    query.append("                   AND NVL(nat.integracao_contas_receber, NULL) = 'S' ");
    query.append("                   AND NVL(nfs.nfs_dtemis, NULL) BETWEEN ");
    query.append("                       LAST_DAY(ADD_MONTHS(TRUNC(SYSDATE), -1)) + 1 AND ");
    query.append("                       TRUNC(SYSDATE) ");
    query.append("                 GROUP BY cli_cdgo, ");
    query.append("                          LAST_DAY(ADD_MONTHS(nfs.nfs_dtemis, -1)) + 1 ");
    query.append("               ) ");
    query.append("         group by cli_Cdgo) ult ");
    query.append(",(select  cli_cdgo, max(data_ultima_compra_resumo) data_ultima_compra_resumo, ");
    query.append("               max(valor_ultima_compra_resumo) valor_ultima_compra_resumo from (SELECT cli_cdgo, ");
    query.append("                       res.data_mes data_ultima_compra_resumo, ");
    query.append("                       NVL(SUM(res.valores_faturados), 0) valor_ultima_compra_resumo ");
    query.append("                  FROM resumos_financeiro res ");
    query.append("                   where nvl(res.data_mes,null) = (select max(data_mes) from resumos_financeiro r where r.cli_cdgo = res.cli_cdgo) ");
    query.append("                 GROUP BY cli_cdgo, res.data_mes ");
    query.append(") group by cli_cdgo) ult_r ");

    query.append("      , seg s ");
    query.append("      , parametros_cobranca_cliente p ");

    if (f.getGre_grupo() != "") {
      query.append("      , grupo_economico gre ");
    }
    query.append("      , rep re ");
    query.append("  WHERE s.seg_cdgo             = c.seg_cdgo ");
    query.append("    AND r.codigo_cliente       = c.cli_cdgo ");
    query.append("    AND r.codigo_cliente       = l.cli_cdgo ");
    query.append("    AND r.codigo_sequencial    = l.esc_seqn ");
    query.append("    AND c.cli_cdgo             = ult.cli_cdgo(+) ");
    query.append("    AND c.cli_cdgo             = ult_r.cli_cdgo (+) ");
    query.append("    AND p.cli_cdgo         (+) = l.cli_cdgo ");
    query.append("    AND p.esc_seqn         (+) = l.esc_seqn ");
    query.append("    AND p.cli_cdgo         (+) > 0 ");
    query.append("    AND re.rep_cdgo            = r.codigo_representante ");
    query.append("    AND l.esc_seqn             = esc.esc_seqn  ");
    query.append("    AND c.cli_cdgo             = esc.cli_cdgo ");

    if (f.getSomente_email() != null && f.getSomente_email().equals("S")) {
      query.append("    AND esc.esc_email is not null");
    }

    if (f.getSomente_email() != null && f.getSomente_email().equals("N")) {
      query.append("    AND esc.esc_email is null");
    }

    if (f.getGre_grupo() != "") {
      query.append("    AND gre.cli_cdgo       (+) = c.cli_cdgo ");
      query.append("    AND ( gre.status is null or gre.status = 'A' ").append(situacao_grupo).append(") ");
      query.append(grupo);
    }

    query.append("    AND l.ned_cdgo             in ('UNI', 'ENT') ");
    query.append("    AND c.cli_situ             = nvl(").append(situacao).append(",c.cli_situ) ");
    query.append("    AND esc.esc_situacao       = nvl(").append(situacao).append(",esc.esc_situacao) ");
    query.append("    AND r.situacao             = nvl(").append(situacao_cliente_representante).append(",r.situacao) ");
    query.append("    AND re.codigo_regional     = nvl(").append(regional).append(",re.codigo_regional)  ");

    if (representante != "null" && representante != "") {
      query.append("    AND r.codigo_representante in (").append(representante).append(") ");
    }

    if (f.getExcluir_segmentos() != "") {
      query.append("    AND s.seg_cdgo NOT IN ("+f.getExcluir_segmentos() + ") ");
    }


    query.append(pagamento);
    query.append(parametros.toString());

    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      throw new Exception(query.toString());
    }


    if (false) {
      throw new Exception(query.toString());
    }

    Vector res_Jw_clientes = null;



    if (f.getTipo_arquivo().equalsIgnoreCase("pdf")) {
      //-----------------------------------------------------------------
      util.file.GeraPDF g = new util.file.GeraPDF(request);
      g.setRelatorio("ListagemClientes.jasper");
      g.setParametro("P_QUERY", query.toString());
      if (representante != "null" && representante != "") {
        g.setParametro("P_REPRESENTANTES", representante);
      }
      g.gerar();
      request.setAttribute("abre_automaticamente","N");
      //-----------------------------------------------------------------
    } else {
      res_Jw_clientes = j.select(table, query.toString(), null);
      /*
           portalbr.dbobj.procedure.Prc_ctr_pedidos_limi proc = new portalbr.dbobj.procedure.Prc_ctr_pedidos_limi();
           for(int x=0; x<res_Jw_clientes.size(); x++){
              portalbr.dbobj.view.Jw_clientes r = (portalbr.dbobj.view.Jw_clientes) res_Jw_clientes.elementAt(x);
              proc.setP_cli(r.getCli_cdgo());
              proc.setP_emp_empresa("01");
              proc = (portalbr.dbobj.procedure.Prc_ctr_pedidos_limi) j.execute(proc);
              if (proc != null) {
                 r.setSaldo_disponivel(proc.getP_saldo());
              }
           }
         */

    }



    if (f.getTipo_arquivo().equalsIgnoreCase("xls")) {
      util.consultas.adm.ListagemClientes listagemClientes = new util.consultas.adm.ListagemClientes();
      String arquivo = listagemClientes.geraExcel(res_Jw_clientes);
      request.setAttribute("arquivo_xls", arquivo);
    }

    session.setAttribute("res_Jw_clientes",res_Jw_clientes);

    if ((res_Jw_clientes != null && res_Jw_clientes.size() == 0)) {
      throw new Exception("Nenhum registro encontrado!");
    }
    session.setAttribute("mapping.getName()", form);
  }
  private void tg_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ClientesActionForm f = (ClientesActionForm) form;
      if ((f.getRegional() != "") && (f.getReg().equals(""))) {
        f.setReg(f.getRegional());
      }
      portalbr.dbobj.table.Rep table = new portalbr.dbobj.table.Rep();
      String[][] select = null;
      Object[][] where = { {"Rep_cdgo","in", f.getRepresentante()}, {"Codigo_regional","=", f.getReg()} };

      Vector res_Rep = j.select(table, select, where, null, null, null);
      session.setAttribute(mapping.getName(), form);
      if (res_Rep != null && res_Rep.size() == 0) {
        throw new Exception("O Representante não pertence à filial!");
      }
    } catch (Exception e) {
      throw e;
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ClientesActionForm f = (ClientesActionForm) form;
      session.removeAttribute("res_Jw_clientes");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
