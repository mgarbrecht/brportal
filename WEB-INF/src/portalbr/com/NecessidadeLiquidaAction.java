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
 * Creation Date 04/10/2005 13:34:42
 * Last Modify Date 19/03/2021 10:03:22
 */

public class NecessidadeLiquidaAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      NecessidadeLiquidaActionForm f = (NecessidadeLiquidaActionForm) form;
      session.removeAttribute("res_NecessidadeLiquida");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_NecessidadeLiquida", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      NecessidadeLiquidaActionForm f = (NecessidadeLiquidaActionForm) form;
      actionForward = new ActionForward("/com/NecessLiquidaReport.do?tipo="+f.getTipo(), true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_NecessidadeLiquida", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    NecessidadeLiquidaActionForm f = (NecessidadeLiquidaActionForm) form;

    String fornecedor = "";
    if (f.getFor_codigo() != "") {
      fornecedor = f.getFor_codigo();
    }
    if ((f.getFor_codigo() + "").equals("null")) {
      fornecedor = f.getFornecedor();
    }
    //---------------------
    portalbr.dbobj.table.Fornecedores table_forn = new portalbr.dbobj.table.Fornecedores();
    String[][] selectf = null;
    Object[][] wheref = { {"Codigo","=", com.egen.util.text.FormatNumber.toInt(fornecedor)} };
    Vector res_Fornecedores = j.select(table_forn, selectf, wheref, null, null, null);
    session.setAttribute("res_Fornecedores",res_Fornecedores);
    if (res_Fornecedores != null && res_Fornecedores.size() == 0) {
      throw new Exception("Fornecedor inexistente!");
    }

    //---------------------
    if ((!(f.getCor_cdgo().equals("")))) {
      portalbr.dbobj.view.Corfornecedorview table_cor = new portalbr.dbobj.view.Corfornecedorview();
      Vector res_CorFornecedorView = j.select(table_cor, new StringBuilder ("select dif.cor_cdgo codigo ").append("   from dom_item_fornecedor    dif ").append("  where dif.for_codigo = ").append(fornecedor).append("    and dif.cor_cdgo   = ").append(f.getCor_cdgo()).append("    and rownum = 1 ").toString(), null);
      if (res_CorFornecedorView == null || res_CorFornecedorView.size() == 0) {
        throw new Exception("Cor invalida para o Fornecedor!");
      }
    }
    //-----------------------
    if ((!(f.getIes_codigo().equals("")))) {
      portalbr.dbobj.view.Itemfornecedorview table_item = new portalbr.dbobj.view.Itemfornecedorview();
      Vector res_ItemFornecedorView = j.select(table_item, new StringBuilder("Select dif.ies_codigo ").append("  from dom_item_fornecedor dif").append(" where dif.for_codigo = ").append(fornecedor).append("   and dif.ies_codigo = ").append(f.getIes_codigo()).append("   and rownum = 1 ").toString(), null);
      if (res_ItemFornecedorView == null || res_ItemFornecedorView.size() == 0) {
        throw new Exception("Item invalido para o Fornecedor!");
      }
    }

    //------------------------
    java.util.Date data_pedido_inicial = com.egen.util.text.FormatDate.parse(f.getPedido_inicial());
    java.util.Date data_pedido_final = com.egen.util.text.FormatDate.parse(f.getPedido_final());
    if (data_pedido_inicial.after(data_pedido_final)) {
      throw new Exception("A data final deve ser igual ou maior que a data inicial!");
    }
    java.lang.String cor = "";
    java.lang.String ies = "";
    java.lang.String tai_codigo = "";
    java.lang.String cor_cdgo = "";
    java.lang.String ies_codigo = "";

    StringBuilder parametros = new StringBuilder();
    if (f.getIes_codigo().equals("")) {
      parametros.append("");
    } else {
      parametros.append(" and ifo.ies_codigo=").append(f.getIes_codigo()).append(" ");
    }

    if (f.getCor_cdgo().equals("")) {
      parametros.append("");
    } else {
      parametros.append(" and ifo.cor_cdgo=").append(f.getCor_cdgo()).append(" ");
    }

    //--- VETOR PRINCIPAL --------------------------------------------------------------------------------------
    portalbr.dbobj.view.Necessidadeliquida table = new portalbr.dbobj.view.Necessidadeliquida();
    StringBuilder query = new StringBuilder();
    query.append(" SELECT /*+ rule */ com.fornecedor_razsoc, ");
    query.append("        com.fornecedor, ");
    query.append("        com.fen_seq, ");
    query.append("        com.ies_codigo, ");
    query.append("        com.ies_descricao, ");
    query.append("        com.unm_codigo, ");
    query.append("        com.cor_mater cor_cdgo, ");
    query.append("        com.cor_desc, ");
    query.append("        com.tai_codigo, ");
    query.append("        com.nomeclatura, ");
    query.append("        SUM(com.consumo - com.consumo_anterior) Consumo_anterior, ");
    query.append("        (SELECT sum(mmmm.consumo) / 7 FROM mv_mix_materiais_mapao mmmm WHERE mmmm.ies_codigo = com.ies_codigo AND mmmm.cor_cdgo = com.cor_mater AND mmmm.tai_codigo = com.tai_codigo AND (TRUNC((TRUNC(SYSDATE-1) - mmmm.data_digitacao - 1) / 7) + 1) = 1) entrada_retroativa, ");
    query.append("        (SELECT sum(mmmm.consumo) / 7 FROM mv_mix_materiais_mapao mmmm WHERE mmmm.ies_codigo = com.ies_codigo AND mmmm.cor_cdgo = com.cor_mater AND mmmm.tai_codigo = com.tai_codigo AND (TRUNC((TRUNC(SYSDATE-1) - mmmm.data_digitacao - 1) / 7) + 1) = 2) entrada_retroativa2, ");
    query.append("        SUM(NVL(com.qtd_estoque, 0)) Estoque, ");
    query.append("        SUM(NVL(com.qtd_compra, 0)) OC, ");
    query.append("        SUM(NVL(com.qtd_abastec, 0)) Abastec, ");
    query.append("        (SUM(NVL(com.qtd_consumo, 0) + NVL(com.qtd_reposicao, 0) - NVL(com.qtd_compra, 0) - ");
    query.append("        NVL(com.qtd_abastec, 0) -  NVL(com.qtd_estoque, 0)) * (decode(NVL(com.perc_compra, 100),0,100,NVL(com.perc_compra, 100)) / 100)) Consumo, ");
    query.append("        0 Liq_prod, ");
    query.append("        SUM(DECODE(TO_CHAR(com.Entrega, 'WW/YYYY'), TO_CHAR(SYSDATE, 'WW/YYYY'), ");
    query.append("                   NVL(com.qtd_compra, 0), 0)) OCSemana1, ");
    query.append("        SUM(DECODE(TO_CHAR(com.Entrega, 'WW/YYYY'), TO_CHAR(SYSDATE + 7, 'WW/YYYY'), ");
    query.append("                   NVL(com.qtd_compra, 0), 0)) OCSemana2, ");
    query.append("        SUM(DECODE(TO_CHAR(com.Entrega, 'WW/YYYY'), TO_CHAR(SYSDATE + 14, 'WW/YYYY'), ");
    query.append("                   NVL(com.qtd_compra, 0), 0)) OCSemana3, ");
    query.append("        SUM(DECODE(TO_CHAR(com.Entrega, 'WW/YYYY'), TO_CHAR(SYSDATE + 21, 'WW/YYYY'), ");
    query.append("                   NVL(com.qtd_compra, 0), 0)) OCSemana4, ");
    query.append("        SUM(DECODE(TO_CHAR(com.Entrega, 'MM/YYYY'), TO_CHAR(SYSDATE, 'MM/YYYY'), ");
    query.append("                   NVL(com.qtd_compra, 0), 0)) OCMes1, ");
    query.append("        SUM(DECODE(TO_CHAR(com.Entrega, 'MM/YYYY'), TO_CHAR(ADD_MONTHS(TO_DATE('01/' || ");
    query.append("                   TO_CHAR(SYSDATE, 'MM/YYYY'), 'DD/MM/YYYY'), 1),'MM/YYYY'),NVL(com.qtd_compra, 0),0)) OCMes2, ");
    query.append("        SUM(DECODE(TO_CHAR(com.Entrega, 'MM/YYYY'), TO_CHAR(ADD_MONTHS(TO_DATE('01/' || ");
    query.append("                   TO_CHAR(ADD_MONTHS(TO_DATE('01/' || TO_CHAR(SYSDATE,'MM/YYYY'),'DD/MM/YYYY'),1), ");
    query.append("                   'MM/YYYY'),'DD/MM/YYYY'),1),'MM/YYYY'),NVL(com.qtd_compra, 0),0)) OCMes3, ");
    query.append("        (SUM(DECODE(TO_CHAR(com.Entrega, 'WW/YYYY'),TO_CHAR(SYSDATE, 'WW/YYYY'),NVL(com.qtd_consumo, 0), ");
    query.append("                    0)) - SUM(DECODE(TO_CHAR(com.Entrega, 'WW/YYYY'),TO_CHAR(SYSDATE, 'WW/YYYY'), ");
    query.append("                    NVL(com.qtd_compra, 0), 0))) PedSemana1, ");
    query.append("        (SUM(DECODE(TO_CHAR(com.Entrega, 'WW/YYYY'),TO_CHAR(SYSDATE + 7, 'WW/YYYY'), ");
    query.append("                    NVL(com.qtd_consumo, 0), 0)) - SUM(DECODE(TO_CHAR(com.Entrega, 'WW/YYYY'), ");
    query.append("                    TO_CHAR(SYSDATE + 7, 'WW/YYYY'), NVL(com.qtd_compra, 0), 0))) PedSemana2, ");
    query.append("        (SUM(DECODE(TO_CHAR(com.Entrega, 'WW/YYYY'), TO_CHAR(SYSDATE + 14, 'WW/YYYY'), ");
    query.append("                    NVL(com.qtd_consumo, 0), 0)) - SUM(DECODE(TO_CHAR(com.Entrega, 'WW/YYYY'), ");
    query.append("                    TO_CHAR(SYSDATE + 14, 'WW/YYYY'), NVL(com.qtd_compra, 0), 0))) PedSemana3, ");
    query.append("        (SUM(DECODE(TO_CHAR(com.Entrega, 'WW/YYYY'), TO_CHAR(SYSDATE + 21, 'WW/YYYY'), ");
    query.append("                    NVL(com.qtd_consumo, 0), 0)) - SUM(DECODE(TO_CHAR(com.Entrega, 'WW/YYYY'), ");
    query.append("                    TO_CHAR(SYSDATE + 21, 'WW/YYYY'), NVL(com.qtd_compra, 0), 0))) PedSemana4, ");
    query.append("        (SUM(DECODE(TO_CHAR(com.Entrega, 'MM/YYYY'), TO_CHAR(SYSDATE, 'MM/YYYY'), ");
    query.append("                    NVL(com.qtd_consumo, 0), 0)) - SUM(DECODE(TO_CHAR(com.Entrega, 'MM/YYYY'), ");
    query.append("                    TO_CHAR(SYSDATE, 'MM/YYYY'), NVL(com.qtd_compra, 0), 0))) PedMes1, ");
    query.append("        (SUM(DECODE(TO_CHAR(com.Entrega, 'MM/YYYY'), TO_CHAR(ADD_MONTHS(TO_DATE('01/' || ");
    query.append("                    TO_CHAR(SYSDATE, 'MM/YYYY'), 'DD/MM/YYYY'), 1),'MM/YYYY'), NVL(com.qtd_consumo, 0), 0)) - ");
    query.append("        SUM(DECODE(TO_CHAR(com.Entrega, 'MM/YYYY'), TO_CHAR(ADD_MONTHS(TO_DATE('01/' || ");
    query.append("                    TO_CHAR(SYSDATE, 'MM/YYYY'), 'DD/MM/YYYY'),1),'MM/YYYY'), NVL(com.qtd_compra, 0),0))) PedMes2, ");
    query.append("        (SUM(DECODE(TO_CHAR(com.Entrega, 'MM/YYYY'), TO_CHAR(ADD_MONTHS(TO_DATE('01/' || ");
    query.append("                    TO_CHAR(ADD_MONTHS(TO_DATE('01/' || TO_CHAR(SYSDATE,'MM/YYYY'),'DD/MM/YYYY'), 1), ");
    query.append("                    'MM/YYYY'),'DD/MM/YYYY'),1),'MM/YYYY'), NVL(com.qtd_consumo, 0), ");
    query.append("                    0)) - SUM(DECODE(TO_CHAR(com.Entrega, 'MM/YYYY'),TO_CHAR(ADD_MONTHS(TO_DATE('01/' || ");
    query.append("                    TO_CHAR(ADD_MONTHS(TO_DATE('01/' || TO_CHAR(SYSDATE,'MM/YYYY'),'DD/MM/YYYY'), ");
    query.append("                    1),'MM/YYYY'),'DD/MM/YYYY'), 1),'MM/YYYY'),NVL(com.qtd_compra, 0),0))) PedMes3, ");
    query.append("            nvl(venda.venda_dia,0) venda_dia ");
    query.append("            ,com.perc_compra perc ");
    query.append("   FROM ( SELECT forn.for_codigo || '-' || forn.for_razsoc fornecedor_razsoc, ");
    query.append("                 forn.for_codigo fornecedor, ");
    query.append("                 ifo.fen_seq, ");
    query.append("                 ifo.ies_codigo, ");
    query.append("                 i.descricao ies_Descricao, ");
    query.append("                 i.unm_codigo, ");
    query.append("                 n.cor_mater, ");
    query.append("                 c.cor_desc, ");
    query.append("                 n.tai_codigo, ");
    query.append("                 ifo.nomeclatura, ");
    query.append("                 n.entrada, ");
    query.append("                 n.entrega, ");
    query.append("                 SUM(n.consumo) qtd_consumo, ");
    query.append("                 SUM(n.saldo_estoque) qtd_estoque, ");
    query.append("                 SUM(n.saldo_compra) qtd_compra, ");
    query.append("                 SUM(n.saldo_abast) qtd_abastec, ");
    query.append("                 SUM(0) consumo_anterior, ");
    query.append("                 SUM(NVL(n.consumo, 0) + NVL(n.saldo_reposicao,0) - NVL(n.saldo_compra, 0) - NVL(n.saldo_abast, 0)  - NVL(n.saldo_estoque, 0)) * (nvl(ifo.percentual_compra,100)/100) consumo, ");
    query.append("                 SUM(n.saldo_reposicao) qtd_reposicao, ");
    query.append("                 ifo.percentual_compra  perc_compra ");
    query.append("            FROM mv_mapa_compras     n             ");
    query.append("               , (select * from dom_item_fornecedor ifo where ifo.for_codigo  = ").append(fornecedor).append(" AND ifo.mostra_gef  = 'S') ifo ");
    query.append("               , dom_item_estoque    i             ");
    query.append("               , cor                 c             ");
    query.append("               , fornecedor          forn          ");
    query.append("           WHERE ifo.for_codigo  = forn.for_codigo ");
    query.append("             AND n.cor_mater     = c.cor_cdgo ");
    query.append("             AND i.Codigo        = n.mat_nro ");
    query.append("             AND n.mat_nro       = ifo.ies_codigo ");
    query.append("             AND n.cor_mater     = ifo.cor_cdgo ");
    query.append("             AND n.tai_codigo    = ifo.tai_codigo ");
    query.append("             AND n.fil_filial    = ifo.fil_filial ");
    query.append("             AND n.emp_empresa   = ifo.emp_empresa ");
    query.append("             AND n.entrada <= to_date('").append(f.getPedido_final()).append("','dd/mm/yyyy')  ");
    query.append(parametros.toString());
    query.append("             AND EXISTS (SELECT 1 ");
    query.append("                           FROM for_endere fe, ");
    query.append("                                dom_tabela_preco dtp ");
    query.append("                          WHERE dtp.for_codigo  = fe.for_codigo ");
    query.append("                            AND fe.fen_seq      = dtp.fen_seq ");
    query.append("                            AND dtp.for_codigo  = ifo.for_codigo ");
    query.append("                            AND dtp.fen_seq     = ifo.fen_seq ");
    query.append("                            AND dtp.ies_codigo  = n.mat_nro ");
    query.append("                            AND dtp.cor_cdgo    = n.cor_mater ");
    query.append("                            AND dtp.tai_codigo  = n.tai_codigo ");
    query.append("                            AND dtp.emp_empresa = n.emp_empresa ");
    query.append("                            AND dtp.fil_filial  = n.fil_filial ");
    query.append("                            AND fe.fen_ativo    = 'S' ");
    query.append("                            AND dtp.data_liberacao_diretor >= TRUNC(SYSDATE) ");
    query.append("                            AND dtp.status = 'A' ");
    query.append("                            AND ROWNUM = 1) ");
    query.append("                          GROUP BY ");
    query.append("                                forn.for_codigo || '-' || forn.for_razsoc, ");
    query.append("                                forn.for_codigo, ");
    query.append("                                ifo.fen_seq, ");
    query.append("                                ifo.ies_codigo, ");
    query.append("                                i.descricao, ");
    query.append("                                i.unm_codigo, ");
    query.append("                                n.cor_mater, ");
    query.append("                                c.cor_desc, ");
    query.append("                                n.tai_codigo, ");
    query.append("                                ifo.nomeclatura, ");
    query.append("                                n.entrada, ");
    query.append("                                n.entrega, ");
    query.append("                                ifo.percentual_compra");
    query.append("           UNION ALL ");
    query.append("          SELECT forn.for_codigo || '-' || forn.for_razsoc fornecedor_razsoc, ");
    query.append("                 forn.for_codigo fornecedor, ");
    query.append("                 ifo.fen_seq, ");
    query.append("                 n.ies_codigo, ");
    query.append("                 i.descricao ies_descricao, ");
    query.append("                 i.unm_codigo, ");
    query.append("                 n.cor_cdgo, ");
    query.append("                 c.cor_desc, ");
    query.append("                 n.tai_codigo, ");
    query.append("                 ifo.nomeclatura, ");
    query.append("                 n.data_entrada, ");
    query.append("                 n.data_entrega, ");
    query.append("                 SUM(0) qtd_consumo, ");
    query.append("                 SUM(0) qtd_estoque, ");
    query.append("                 SUM(0) qtd_compra, ");
    query.append("                 SUM(0) qtd_abastec, ");
    query.append("                 SUM(NVL(n.qtd_consumo, 0) + NVL(n.qtd_reposicao, 0) - NVL(n.qtd_compra, 0) - NVL(n.qtd_abastec, 0) - NVL(n.qtd_estoque, 0)) * (nvl(ifo.percentual_compra,100)/100) consumo_anterior, ");
    query.append("                 SUM(0) consumo, ");
    query.append("                 SUM(0) qtd_reposicao, ");
    query.append("                 ifo.percentual_compra perc_compra");
    query.append("            FROM necessidade_ped_com_posant n     ");
    query.append("               , (select * from dom_item_fornecedor ifo where ifo.for_codigo  = ").append(fornecedor).append(" AND ifo.mostra_gef  = 'S' ) ifo ");
    query.append("               , dom_item_estoque           i     ");
    query.append("               , cor                        c     ");
    query.append("               , fornecedor                 forn  ");
    query.append("           WHERE ifo.for_codigo =  forn.for_codigo ");
    query.append("             AND n.cor_cdgo = c.cor_cdgo ");
    query.append("             AND i.codigo        = n.ies_codigo ");
    query.append("             AND n.ies_codigo    = ifo.ies_codigo ");
    query.append("             AND n.cor_cdgo      = ifo.cor_cdgo ");
    query.append("             AND n.tai_codigo    = ifo.tai_codigo ");
    query.append("             AND n.fil_filial    = ifo.fil_filial ");
    query.append("             AND n.emp_empresa   = ifo.emp_empresa ");
    query.append("             AND n.data_entrada <= to_date('").append(f.getPedido_final()).append("','dd/mm/yyyy')  ");
    query.append(parametros);
    query.append("             AND EXISTS (SELECT 1 ");
    query.append("                           FROM for_endere fe, ");
    query.append("                                dom_tabela_preco dtp ");
    query.append("                          WHERE dtp.for_codigo = fe.for_codigo ");
    query.append("                            AND fe.fen_seq      = dtp.fen_seq ");
    query.append("                            AND dtp.for_codigo  = ifo.for_codigo ");
    query.append("                            AND dtp.fen_seq     = ifo.fen_seq ");
    query.append("                            AND dtp.ies_codigo  = n.ies_codigo ");
    query.append("                            AND dtp.cor_cdgo    = n.cor_cdgo ");
    query.append("                            AND dtp.tai_codigo  = n.tai_codigo ");
    query.append("                            AND dtp.emp_empresa = n.emp_empresa ");
    query.append("                            AND dtp.fil_filial  = n.fil_filial ");
    query.append("                            AND fe.fen_ativo    = 'S' ");
    query.append("                            AND dtp.data_liberacao_diretor >= TRUNC(SYSDATE) ");
    query.append("                            AND dtp.status = 'A' ");
    query.append("                            AND ROWNUM = 1) ");
    query.append("           GROUP BY ");
    query.append("                 forn.for_codigo || '-' || forn.for_razsoc, ");
    query.append("                 forn.for_codigo, ");
    query.append("                 ifo.fen_seq, ");
    query.append("                 n.IEs_Codigo, ");
    query.append("                 i.Descricao, ");
    query.append("                 i.UnM_Codigo, ");
    query.append("                 n.Cor_Cdgo, ");
    query.append("                 c.Cor_Desc, ");
    query.append("                 n.TaI_Codigo, ");
    query.append("                 ifo.nomeclatura, ");
    query.append("                 n.data_entrada, ");
    query.append("                 n.data_entrega, ");
    query.append("                 ifo.percentual_compra ");
    query.append("            ) com, ");
    query.append("   (SELECT SUM(n.consumo) venda_dia, ");
    query.append("        ifo.ies_codigo, ");
    query.append("        ifo.cor_cdgo, ");
    query.append("        ifo.tai_codigo, ");
    query.append("        ifo.for_codigo, ");
    query.append("        ifo.fen_seq ");
    query.append("  FROM mv_mapa_compras     n             ");
    query.append("     , (select * from dom_item_fornecedor ifo where ifo.for_codigo  = ").append(fornecedor).append(" AND ifo.mostra_gef  = 'S') ifo ");
    query.append("     , dom_item_estoque    i             ");
    query.append("     , cor                 c             ");
    query.append("     , fornecedor          forn          ");
    query.append(" WHERE ifo.for_codigo  = forn.for_codigo ");
    query.append("   AND n.cor_mater     = c.cor_Cdgo ");
    query.append("   AND i.Codigo        = n.mat_nro ");
    query.append("   AND n.mat_nro       = ifo.ies_codigo ");
    query.append("   AND n.cor_mater     = ifo.cor_cdgo ");
    query.append("   AND n.tai_codigo    = ifo.tai_codigo ");
    query.append("   AND n.fil_filial    = ifo.fil_filial ");
    query.append("   AND n.emp_empresa   = ifo.emp_empresa ");
    query.append(parametros);
    query.append("   AND n.entrada BETWEEN TRUNC(TO_DATE(to_date('").append(f.getPedido_inicial()).append("','dd/mm/yyyy') - 1)) AND TRUNC(TO_DATE(to_date('").append(f.getPedido_final()).append("','dd/mm/yyyy') - 1)) ");
    query.append("   AND EXISTS (SELECT 1 ");
    query.append("                 FROM for_endere fe, ");
    query.append("                      dom_tabela_preco dtp ");
    query.append("                WHERE dtp.for_codigo  = fe.for_codigo ");
    query.append("                  AND fe.fen_seq      = dtp.fen_seq ");
    query.append("                  AND dtp.for_codigo  = ifo.for_codigo ");
    query.append("                  AND dtp.fen_seq     = ifo.fen_seq ");
    query.append("                  AND dtp.ies_codigo  = n.mat_nro ");
    query.append("                  AND dtp.cor_cdgo    = n.cor_mater ");
    query.append("                  AND dtp.tai_codigo  = n.tai_codigo ");
    query.append("                  AND dtp.emp_empresa = n.emp_empresa ");
    query.append("                  AND dtp.fil_filial  = n.fil_filial ");
    query.append("                  AND fe.fen_ativo    = 'S' ");
    query.append("                  AND dtp.data_liberacao_diretor >= TRUNC(SYSDATE) ");
    query.append("                  AND dtp.status = 'A' ");
    query.append("                  AND ROWNUM = 1) ");
    query.append(" GROUP BY ");
    query.append("       ifo.ies_codigo, ");
    query.append("       ifo.cor_cdgo, ");
    query.append("       ifo.tai_codigo, ");
    query.append("       ifo.for_codigo, ");
    query.append("       ifo.fen_seq) venda ");
    query.append(" WHERE com.ies_codigo = venda.ies_codigo (+) ");
    query.append("   AND com.cor_mater  = venda.cor_cdgo   (+) ");
    query.append("   AND com.tai_codigo = venda.tai_codigo (+) ");
    query.append("   AND com.fornecedor = venda.for_codigo (+) ");
    query.append(" GROUP BY ");
    query.append("       com.fornecedor_razsoc, ");
    query.append("       com.fornecedor, ");
    query.append("       com.fen_seq, ");
    query.append("       com.IEs_Codigo, ");
    query.append("       com.IEs_Descricao, ");
    query.append("       com.UnM_Codigo, ");
    query.append("       com.cor_mater, ");
    query.append("       com.Cor_Desc, ");
    query.append("       com.TaI_Codigo, ");
    query.append("       com.nomeclatura, ");
    query.append("       venda.venda_dia ");
    query.append("       ,com.perc_compra ");
    query.append(" HAVING ");
    query.append(" (((SUM(NVL(com.qtd_consumo, 0) - NVL(com.qtd_compra, 0) - ");
    query.append(" NVL(com.qtd_abastec, 0) - NVL(com.qtd_estoque, 0))) > ").append(f.getNecessidade()).append(") ");
    query.append(" and((SUM(NVL(com.qtd_compra, 0)) > 0) OR (SUM(NVL(com.qtd_consumo, 0)) > 0))) ");

    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      throw new Exception(query.toString());
    }

    Vector res_NecessidadeLiquida = j.select(table, query.toString(), null);

    request.setAttribute("tipo",f.getTipo());
    session.setAttribute("res_NecessidadeLiquida",res_NecessidadeLiquida);
    int contador = 0;
    if (!(res_NecessidadeLiquida != null && res_NecessidadeLiquida.size() > 0)) {
      throw new Exception("Nenhum Registro Encontrado!");
    } else {


      Jw_necessidade_liquida_oc table_oc = new Jw_necessidade_liquida_oc();

      Vector res_Jw_necessidade_liquida_oc = null;

      for (int x = 0; x < res_NecessidadeLiquida.size(); x++) {

        portalbr.dbobj.view.Necessidadeliquida r2 = (portalbr.dbobj.view.Necessidadeliquida) res_NecessidadeLiquida.elementAt(x);

        StringBuilder sb_oc = new StringBuilder();
        sb_oc.append("SELECT /*+ all_rows */ nvl(sum(oc.compra),0) oc, ");
        sb_oc.append("       nvl(SUM(DECODE(TO_CHAR(oc.data_entrega, 'WW/YYYY'), TO_CHAR(SYSDATE, 'WW/YYYY'), ");
        sb_oc.append("       NVL(oc.compra, 0), 0)),0) OCSemana1, ");
        sb_oc.append("       nvl(SUM(DECODE(TO_CHAR(oc.data_entrega, 'WW/YYYY'), TO_CHAR(SYSDATE + 7, 'WW/YYYY'), ");
        sb_oc.append("       NVL(oc.compra, 0), 0)),0) OCSemana2, ");
        sb_oc.append("       nvl(SUM(DECODE(TO_CHAR(oc.data_entrega, 'WW/YYYY'), TO_CHAR(SYSDATE + 14, 'WW/YYYY'), ");
        sb_oc.append("       NVL(oc.compra, 0), 0)),0) OCSemana3, ");
        sb_oc.append("       nvl(SUM(DECODE(TO_CHAR(oc.data_entrega, 'WW/YYYY'), TO_CHAR(SYSDATE + 21, 'WW/YYYY'), ");
        sb_oc.append("       NVL(oc.compra, 0), 0)),0) OCSemana4, ");
        sb_oc.append("       nvl(SUM(DECODE(TO_CHAR(oc.data_entrega, 'MM/YYYY'), TO_CHAR(SYSDATE, 'MM/YYYY'), ");
        sb_oc.append("       NVL(oc.compra, 0), 0)),0) OCMes1, ");
        sb_oc.append("       nvl(SUM(DECODE(TO_CHAR(oc.data_entrega, 'MM/YYYY'), TO_CHAR(ADD_MONTHS(TO_DATE('01/' ||  ");
        sb_oc.append("       TO_CHAR(SYSDATE, 'MM/YYYY'), 'DD/MM/YYYY'), 1),'MM/YYYY'),NVL(oc.compra, 0),0)),0) OCMes2,  ");
        sb_oc.append("       nvl(SUM(DECODE(TO_CHAR(oc.data_entrega, 'MM/YYYY'), TO_CHAR(ADD_MONTHS(TO_DATE('01/' ||  ");
        sb_oc.append("       TO_CHAR(ADD_MONTHS(TO_DATE('01/' || TO_CHAR(SYSDATE,'MM/YYYY'),'DD/MM/YYYY'),1),  ");
        sb_oc.append("       'MM/YYYY'),'DD/MM/YYYY'),1),'MM/YYYY'),NVL(oc.compra, 0),0)),0) OCMes3 ");
        sb_oc.append("  FROM ( SELECT o.for_codigo ");
        sb_oc.append("              , o.fen_seq ");
        sb_oc.append("              , dio.ies_codigo ");
        sb_oc.append("              , dio.cor_cdgo ");
        sb_oc.append("              , dio.tai_codigo ");
        sb_oc.append("              , dei.data_entrega     ");
        sb_oc.append("              , SUM(nvl(dei.quant_comprada, 0) - nvl(dei.quant_recebida, 0)) compra ");
        sb_oc.append("           FROM dom_ordem_compra      o ");
        sb_oc.append("              , dom_item_ordem_compra dio ");
        sb_oc.append("              , dom_item_estoque      i ");
        sb_oc.append("              , dom_data_entrega_item dei ");
        sb_oc.append("          WHERE o.numero = dio.oco_numero ");
        sb_oc.append("            AND i.codigo = dio.ies_codigo ");
        sb_oc.append("            AND dio.oco_numero = dei.oco_numero ");
        sb_oc.append("            AND dio.sequencia  = dei.ioc_sequencia ");
        sb_oc.append("            AND o.situacao = 0 ");
        sb_oc.append("            AND o.for_codigo = ").append(r2.getFornecedor());
        sb_oc.append("            AND o.fen_seq = ").append(r2.getFen_seq());
        sb_oc.append("            AND dio.ies_codigo = ").append(r2.getIes_codigo());
        sb_oc.append("            AND dio.cor_cdgo = ").append(r2.getCor_cdgo());
        sb_oc.append("            AND dio.tai_codigo = '").append(r2.getTai_codigo()).append("' ");
        sb_oc.append("          GROUP BY o.for_codigo ");
        sb_oc.append("                 , o.fen_seq ");
        sb_oc.append("                 , dio.ies_codigo ");
        sb_oc.append("                 , dio.cor_cdgo ");
        sb_oc.append("                 , dio.tai_codigo ");
        sb_oc.append("                 , dei.data_entrega ");
        sb_oc.append("       ) oc ");

        res_Jw_necessidade_liquida_oc = j.select(table_oc, sb_oc.toString(), null);

        if (res_Jw_necessidade_liquida_oc != null && res_Jw_necessidade_liquida_oc.size() > 0) {
          Jw_necessidade_liquida_oc r3 = (Jw_necessidade_liquida_oc) res_Jw_necessidade_liquida_oc.elementAt(0);
          r2.setOc((r3.getOc() != null) ? r3.getOc() : null);
          r2.setOcsemana1((r3.getOcsemana1() != null) ? r3.getOcsemana1() : null);
          r2.setOcsemana2((r3.getOcsemana2() != null) ? r3.getOcsemana2() : null);
          r2.setOcsemana3((r3.getOcsemana3() != null) ? r3.getOcsemana3() : null);
          r2.setOcsemana4((r3.getOcsemana4() != null) ? r3.getOcsemana4() : null);
          r2.setOcmes1((r3.getOcmes1() != null) ? r3.getOcmes1() : null);
          r2.setOcmes2((r3.getOcmes2() != null) ? r3.getOcmes2() : null);
          r2.setOcmes3((r3.getOcmes3() != null) ? r3.getOcmes3() : null);
        }
      }

    }
    session.setAttribute("mapping.getName()", form);
  }
}
