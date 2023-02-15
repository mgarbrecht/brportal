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
 * Creation Date 13/03/2006 15:41:20
 * Last Modify Date 14/02/2023 15:09:21
 */

public class PoiAbertoRepEntradaPedidosAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    String representante = "";
    String rep = "";
    String repErc = "";
    String regional = "";
    String unidade = "null";
    String tipo = "POI - Aberto por Representante / Entrada de Pedidos";
    String tipo_relatorio = null;
    PoiAbertoRepEntradaPedidosActionForm f = (PoiAbertoRepEntradaPedidosActionForm) form;
    try {

      acesso.Sessao se = new acesso.Sessao(session);
      String tipoEntidade = se.getTipoEntidadeNegocio();
      if (tipoEntidade.equals("REPRESENTANTE COMERCIAL") || tipoEntidade.equals("REGIONAL DE VENDA") || tipoEntidade.equals("REPRESENTANTE EXPORTACAO")) {
        java.util.Date data_atual = new java.util.Date();
        java.text.SimpleDateFormat fDataMes = new java.text.SimpleDateFormat("MM");
        java.text.SimpleDateFormat fDataAno = new java.text.SimpleDateFormat("yyyy");
        int mes = Integer.parseInt(fDataMes.format(data_atual));
        int ano = Integer.parseInt(fDataAno.format(data_atual));
        int mes_informado_inicial = Integer.parseInt(f.getMes());
        int ano_informado_inicial = Integer.parseInt(f.getAno());
        int mes_informado_final = Integer.parseInt(f.getMes_final());
        int ano_informado_final = Integer.parseInt(f.getAno_final());
      }

      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);

      if (f.getF_representante() != "") {
        representante = f.getF_representante();
        tipo = "POI - Aberto por Empresa de Representação / Entrada de Pedidos";
      } else {
        representante = f.getRep_cdgo();
      }

      if (f.getF_regional() != "") {
        regional = f.getF_regional();
      } else {
        regional = f.getCodigo_regional();
      }

      if (f.getUnidade_negocio() != "") {
        unidade = f.getUnidade_negocio();
      }

      tipo_relatorio = f.getTipo_relatorio();

      if ((representante.equals("") || (f.getF_representante() != "")) || ((!(f.getRep_cdgo().equals(""))))) {
        session.setAttribute("PoiAbertoRepEntradaPedidos_ano", f.getAno());
        session.setAttribute("PoiAbertoRepEntradaPedidos_mes", f.getMes());
        session.setAttribute("PoiAbertoRepEntradaPedidos_ano_final", f.getAno_final());
        session.setAttribute("PoiAbertoRepEntradaPedidos_mes_final", f.getMes_final());
        session.setAttribute("PoiAbertoRepEntradaPedidos_tipo", tipo);

        if (tipo_relatorio.equals("N")) {
          actionForward = new ActionForward("/com/PoiAbertoRepEntradaPedidos_rForm.jsp", true);
        } else {
          actionForward = new ActionForward("/com/PoiAbertoRepEntradaPedidosResumo_rForm.jsp", true);
        }
      }

    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_poi", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    PoiAbertoRepEntradaPedidosActionForm f = (PoiAbertoRepEntradaPedidosActionForm) form;

    StringBuilder query = new StringBuilder();
    String representante = "";
    String rep = "";
    String repErc = "";
    String representante_int = "";
    String marca_ext = "";
    String marca = "";
    String marca_int = "";
    String marca_ped = "";
    String marca_t = "";
    String regional = "null";
    String filtroSegmento = "";
    String filtroPrevistoOutros = "";
    String filtroPrevistoCalcados = "";
    StringBuilder representante_free = new StringBuilder();
    String unidade = "null";
    boolean resumoRep = true;
    boolean abrirSegmento = false;

    if ((f.getCb_representante_marca() + "").equals("1")) {
      resumoRep = false;
      session.setAttribute("resumoRepresentante", "n");
    } else {
      session.setAttribute("resumoRepresentante", "s");
    }
    if (f.getTipo_relatorio().equalsIgnoreCase("R")) {
      resumoRep = false;
    }
    if (f.getF_representante() != "") {
      representante_free.append(f.getF_representante());
    } else {
      representante_free.append("null");
    }

    if (f.getCodigo_marca() != "") {
      marca_ext = " AND nvl(codigo_marca, null) = " + f.getCodigo_marca();
      marca_int = " AND nvl(codigo_marca, null) = " + f.getCodigo_marca();
      marca_ped = " AND nvl(i.codigo_marca, null) = " + f.getCodigo_marca();
    }


    if (f.getRep_cdgo() != "" && (!((f.getRep_cdgo() + "").equals("null")))) {
      representante = " and nvl(t.codigo_representante,null) = '"+f.getRep_cdgo() + "'";
      rep = " AND t.codigo_representante = '"+f.getRep_cdgo() + "'";
      repErc = " AND t.rep_cdgo = '"+f.getRep_cdgo() + "'";
      representante_int = " and nvl(r.rep_cdgo,null) = '"+f.getRep_cdgo() + "'";
    }

    if (f.getCodigo_regional() != "") {
      regional = f.getCodigo_regional();
    }

    if (f.getAbrir_segmento() != "") {
      if (f.getAbrir_segmento().equals("S")) {
        abrirSegmento = true;
      }
    }

    if (f.getSegmento() != "T") {
      if (f.getSegmento().equals("O")) {
        filtroSegmento = " AND pck_referencia.get_grupo_posicao_fab(i.lin_cdgo, i.ref_cdgo) in (30) ";
        filtroPrevistoOutros = " AND pck_uni_negocio.get_nome(t.unn_codigo) = 'OCULOS' ";
        filtroPrevistoCalcados = " AND 1=2 ";
      } else if (f.getSegmento().equals("B")) {
        filtroSegmento = " AND pck_referencia.get_grupo_posicao_fab(i.lin_cdgo, i.ref_cdgo) in (7,17) ";
        filtroPrevistoOutros = " AND pck_uni_negocio.get_nome(t.unn_codigo) = 'BOLSAS'";
        filtroPrevistoCalcados = " AND 1=2 ";
      } else if (f.getSegmento().equals("M")) {
        filtroSegmento = " AND pck_referencia.get_grupo_posicao_fab(i.lin_cdgo, i.ref_cdgo) in (26,29) ";
        filtroPrevistoOutros = " AND pck_uni_negocio.get_nome(t.unn_codigo) = 'MEIAS' ";
        filtroPrevistoCalcados = " AND 1=2 ";
      } else if (f.getSegmento().equals("V")) {
        filtroSegmento = " AND pck_referencia.get_grupo_posicao_fab(i.lin_cdgo, i.ref_cdgo) in (18,19,31,32,33) ";
        filtroPrevistoOutros = " AND pck_uni_negocio.get_nome(t.unn_codigo) = 'VESTUARIO' ";
        filtroPrevistoCalcados = " AND 1=2 ";
      } else if (f.getSegmento().equals("C")) {
        filtroPrevistoOutros = " AND 1=2 ";
        filtroSegmento = " AND pck_referencia.get_grupo_posicao_fab(i.lin_cdgo, i.ref_cdgo) not in (7,17,18,19,30,26,29,31,32,33) ";
      }
    }

    portalbr.dbobj.view.Jw_poi_aberto_rep_entrada_pedidos table = new portalbr.dbobj.view.Jw_poi_aberto_rep_entrada_pedidos();


    query.append(" SELECT codigo_regional   ");
    query.append("      , nome_regional   ");
    query.append("      , codigo_gerente   ");
    query.append("      , nome_gerente   ");
    query.append("      , endereco   ");
    query.append("      , estado_gerente   ");
    query.append("      , codigo_marca   ");
    query.append("      ,").append(resumoRep ? "'GERAL' descricao_marca":"descricao_marca ");
    query.append("  ,codigo_representante   ");
    query.append("  ,rep_rzao   ");
    query.append("  ,preco_previsto   ");
    query.append("  ,preco_realizado   ");
    query.append("  ,dif_preco   ");
    query.append("  ,dif_preco_pos   ");
    query.append("  ,reais_previsto   ");
    query.append("  ,reais_realizado   ");
    query.append("  ,dif_reais   ");
    query.append("  ,dif_reais_pos   ");
    query.append("  ,reais_faturado   ");
    query.append("  ,reais_a_faturar   ");
    query.append("  ,pares_previsto   ");
    query.append("  ,pares_realizado   ");
    query.append("  ,dif_pares  ");
    query.append("  ,dif_pares_pos  ");
    query.append("  ,pares_faturado   ");
    query.append("  ,pares_a_faturar ");
    query.append("  ,reais_realizado_anterior ");
    query.append("  ,pares_realizado_anterior ");
    query.append("  ,ref_grupo_posicao_fab_descricao ");
    query.append("       FROM   ");
    query.append("      (SELECT rv.codigo_regional   ");
    query.append("            ,rv.nome_regional   ");
    query.append("            ,null codigo_gerente   ");
    query.append("            ,'' nome_gerente   ");
    query.append("            ,'' endereco   ");
    query.append("            ,'' estado_gerente   ");

    if (!resumoRep) {
      query.append("            ,codigo_marca   ");
      query.append("            ,pck_marcas_produtos.get_nome(codigo_marca) descricao_marca   ");
    } else {
      query.append("            ,0 codigo_marca   ");
      query.append("            ,'GERAL' descricao_marca   ");
    }
    query.append("            ,r.rep_cdgo codigo_representante   ");
    query.append("            ,r.rep_rzao   ");
    query.append("            ,realizado.preco_previsto   ");
    query.append("            ,(realizado.vlr_realizado) / DECODE((realizado.qtde_realizado), 0, 1, realizado.qtde_realizado) preco_realizado   ");
    query.append("            , case when realizado.preco_previsto >0 and realizado.vlr_realizado=0 then -100 ");
    query.append("                   when realizado.preco_previsto =0 and realizado.vlr_realizado>=0 then 0 ");
    query.append("                   else ((realizado.vlr_realizado  / DECODE(realizado.qtde_realizado, 0, 1, realizado.qtde_realizado) * 100) / realizado.preco_previsto)-100  ");
    query.append("                   end dif_preco ");
    query.append("            , case when realizado.preco_previsto >0 and realizado.vlr_realizado=0 then 0 ");
    query.append("                   when realizado.preco_previsto =0 and realizado.vlr_realizado>=0 then 100 ");
    query.append("                   else ((realizado.vlr_realizado  / DECODE(realizado.qtde_realizado, 0, 1, realizado.qtde_realizado) * 100) / realizado.preco_previsto) ");
    query.append("                   end dif_preco_pos ");
    query.append("            ,realizado.reais_previsto   ");
    query.append("            ,realizado.vlr_realizado reais_realizado   ");
    query.append("            ,realizado.vlr_realizado_anterior reais_realizado_anterior ");
    query.append("            ,case when realizado.reais_previsto >0 and realizado.vlr_realizado=0 then -100 ");
    query.append("                  when realizado.reais_previsto =0 and realizado.vlr_realizado>=0 then 0 ");
    query.append("                  else (realizado.vlr_realizado * 100) / DECODE(realizado.reais_previsto, 0, 1, realizado.reais_previsto)-100 ");
    query.append("                  end dif_reais ");
    query.append("            ,case when realizado.reais_previsto >0 and realizado.vlr_realizado=0 then 0 ");
    query.append("                  when realizado.reais_previsto =0 and realizado.vlr_realizado>=0 then 100 ");
    query.append("                  else (realizado.vlr_realizado * 100) / DECODE(realizado.reais_previsto, 0, 1, realizado.reais_previsto) ");
    query.append("                  end dif_reais_pos ");
    query.append("            ,realizado.vlr_fat reais_faturado   ");
    query.append("            ,realizado.vlr_a_fat reais_a_faturar   ");
    query.append("            ,realizado.pares_previsto pares_previsto   ");
    query.append("            ,realizado.qtde_realizado pares_realizado   ");
    query.append("            ,realizado.qtde_realizado_anterior pares_realizado_anterior ");
    query.append("            ,case when realizado.pares_previsto >0 and realizado.qtde_realizado=0 then -100 ");
    query.append("                  when realizado.pares_previsto =0 and realizado.qtde_realizado>=0 then 0 ");
    query.append("                  else (realizado.qtde_realizado * 100) / DECODE(realizado.pares_previsto, 0, 1, realizado.pares_previsto)-100 ");
    query.append("                  end dif_pares ");
    query.append("            ,case when realizado.pares_previsto >0 and realizado.qtde_realizado=0 then 0 ");
    query.append("                  when realizado.pares_previsto =0 and realizado.qtde_realizado>=0 then 100 ");
    query.append("                  else (realizado.qtde_realizado * 100) / DECODE(realizado.pares_previsto, 0, 1, realizado.pares_previsto) ");
    query.append("                  end dif_pares_pos ");
    query.append("            ,realizado.qtde_fat pares_faturado ");
    query.append("            ,realizado.qtde_a_fat pares_a_faturar ");
    query.append("            ,ref_grupo_posicao_fab_descricao ");
    query.append("        FROM rep r   ");
    query.append("            ,brio.regionais_vendas rv   ");
    query.append("            ,(SELECT distinct null codigo_gerente   ");
    query.append("                    ,rep_cdgo ");
    query.append("                    ,").append(resumoRep ? "0 codigo_marca":"codigo_marca");
    query.append("                    ,SUM(vlr_fat) over (partition by rep_cdgo, codigo_marca,ref_grupo_posicao_fab_descricao) vlr_fat   ");
    query.append("                    ,SUM(vlr_a_fat) over (partition by rep_cdgo, codigo_marca,ref_grupo_posicao_fab_descricao) vlr_a_fat   ");
    query.append("                    ,SUM(qtde_fat) over (partition by rep_cdgo, codigo_marca,ref_grupo_posicao_fab_descricao) qtde_fat   ");
    query.append("                    ,SUM(qtde_a_fat) over (partition by rep_cdgo, codigo_marca,ref_grupo_posicao_fab_descricao) qtde_a_fat   ");
    query.append("                    ,SUM(vlr_realizado) over (partition by rep_cdgo, codigo_marca,ref_grupo_posicao_fab_descricao) vlr_realizado ");
    query.append("                    ,SUM(vlr_realizado) over (partition by rep_cdgo, codigo_marca) vlr_realizado_geral ");
    query.append("                    ,SUM(qtde_realizado) over (partition by rep_cdgo, codigo_marca,ref_grupo_posicao_fab_descricao) qtde_realizado   ");
    query.append("                    ,SUM(vlr_realizado_anterior) over (partition by rep_cdgo, codigo_marca,ref_grupo_posicao_fab_descricao) vlr_realizado_anterior ");
    query.append("                    ,SUM(qtde_realizado_anterior) over (partition by rep_cdgo, codigo_marca,ref_grupo_posicao_fab_descricao) qtde_realizado_anterior ");
    query.append("                    ,SUM(preco_previsto) over (partition by rep_cdgo, codigo_marca,ref_grupo_posicao_fab_descricao) preco_previsto ");
    query.append("                    ,SUM(reais_previsto) over (partition by rep_cdgo, codigo_marca,ref_grupo_posicao_fab_descricao) reais_previsto ");
    query.append("                    ,SUM(pares_previsto) over (partition by rep_cdgo, codigo_marca,ref_grupo_posicao_fab_descricao) pares_previsto ");
    query.append("                    ,ref_grupo_posicao_fab_descricao ");
    query.append("                FROM (SELECT 'faturaro_a_faturar'   ");
    query.append("                            ,null codigo_gerente   ");
    query.append("                            ,p.rep_cdgo rep_cdgo   ");
    query.append("                            ,").append(resumoRep ? "0 codigo_marca":"rf.codigo_marca");
    query.append("                            ,SUM(DECODE(p.ped_stat, 'F', fct_valor_pedido(i.ped_nmro, i.ite_seqn), 0)) vlr_fat   ");
    query.append("                            ,SUM(DECODE(p.ped_stat, 'F', 0, fct_valor_pedido(i.ped_nmro, i.ite_seqn))) vlr_a_fat   ");
    query.append("                            ,SUM(DECODE(p.ped_stat, 'F', i.ite_qtde, 0)) qtde_fat   ");
    query.append("                            ,SUM(DECODE(p.ped_stat, 'F', 0, i.ite_qtde)) qtde_a_fat   ");
    query.append("                            ,0 vlr_realizado   ");
    query.append("                            ,0 qtde_realizado   ");
    query.append("                            ,0 vlr_realizado_anterior ");
    query.append("                            ,0 qtde_realizado_anterior ");
    query.append("                            ,0 preco_previsto   ");
    query.append("                            ,0 reais_previsto   ");
    query.append("                            ,0 pares_previsto   ");
    if (abrirSegmento) {
      query.append("                            ,case when ref_grupo_posicao_fab in (7,17) then 'BOLSAS' when ref_grupo_posicao_fab in (26,29) then 'MEIAS' when ref_grupo_posicao_fab  in (30) then 'OCULOS' when ref_grupo_posicao_fab in (18,19,31,32,33) then 'VESTUARIO' else 'CALCADOS' end ref_grupo_posicao_fab_descricao ");
    } else {
      query.append("                            ,'GERAL' ref_grupo_posicao_fab_descricao ");
    }
    query.append("                        FROM ped p   ");
    query.append("                           , ite i   ");
    query.append("                           , rep r   ");
    query.append("                           , ref rf  ");
    query.append("                       WHERE p.ped_det >= to_date('"+com.egen.util.text.FormatNumber.format(Integer.parseInt(f.getMes()), "00") + f.getAno() + "','mmrrrr')   ");
    query.append("                         AND p.ped_det < last_day(to_date('"+com.egen.util.text.FormatNumber.format(Integer.parseInt(f.getMes_final()), "00") + f.getAno_final() + "','mmrrrr')) + 1   ");
    query.append(" and pck_pedidos.to_somente_entrada(i.ped_nmro, i.ite_seqn) = pck_pedidos.get_somente_entrada(i.ped_nmro, i.ite_seqn) ");
    query.append(representante_int);
    query.append(marca_ped);
    query.append(filtroSegmento);
    query.append("                         AND r.rep_cdgo = p.rep_cdgo   ");
    if (!regional.equalsIgnoreCase("null")) {
      query.append("                         AND r.codigo_regional = " + regional);
    }
    query.append("                         AND p.ped_nmro = i.ped_nmro   ");
    query.append("                         AND rf.lin_cdgo = i.lin_cdgo ");
    query.append("                         AND rf.ref_cdgo = i.ref_cdgo ");
    query.append("                       GROUP BY p.rep_cdgo ");
    if (!resumoRep) {
      query.append("                           , rf.codigo_marca ");
    }
    query.append("                              , rf.ref_grupo_posicao_fab ");
    query.append("                      UNION ALL   ");
    query.append("                      SELECT 'realizado'   ");
    query.append("                            ,null codigo_gerente   ");
    query.append("                            ,p.rep_cdgo rep_cdgo   ");
    query.append("                            ,").append(resumoRep ? "0 codigo_marca":"rf.codigo_marca");
    query.append("                            ,0 vlr_fat   ");
    query.append("                            ,0 vlr_a_fat   ");
    query.append("                            ,0 qtde_fat   ");
    query.append("                            ,0 qtde_a_fat   ");
    query.append("                            ,SUM(fct_valor_pedido(i.ped_nmro, i.ite_seqn)) vlr_realizado   ");
    query.append("                            ,SUM(i.ite_qtde) qtde_realizado   ");
    query.append("                            ,0 vlr_realizado_anterior ");
    query.append("                            ,0 qtde_realizado_anterior ");
    query.append("                            ,0 preco_previsto   ");
    query.append("                            ,0 reais_previsto   ");
    query.append("                            ,0 pares_previsto   ");
    if (abrirSegmento) {
      query.append("                            ,case when ref_grupo_posicao_fab in (7,17) then 'BOLSAS' when ref_grupo_posicao_fab in (26,29) then 'MEIAS' when ref_grupo_posicao_fab  in (30) then 'OCULOS' when ref_grupo_posicao_fab in (18,19,31,32,33) then 'VESTUARIO' else 'CALCADOS' end ref_grupo_posicao_fab_descricao ");
    } else {
      query.append("                            ,'GERAL' ref_grupo_posicao_fab_descricao ");
    }
    query.append("                        FROM ped p   ");
    query.append("                            ,ite i   ");
    query.append("                            ,rep r   ");
    query.append("                            ,ref rf   ");
    query.append("                       WHERE p.ped_dadg >= to_date('"+com.egen.util.text.FormatNumber.format(Integer.parseInt(f.getMes()), "00") + f.getAno() + "','mmrrrr')   ");
    query.append("                         AND p.ped_dadg < last_day(to_date('"+com.egen.util.text.FormatNumber.format(Integer.parseInt(f.getMes_final()), "00") + f.getAno_final() + "','mmrrrr')) + 1   ");
    query.append("                         AND p.ped_nmro = i.ped_nmro   ");
    query.append(" and pck_pedidos.to_somente_entrada(i.ped_nmro, i.ite_seqn) = pck_pedidos.get_somente_entrada(i.ped_nmro, i.ite_seqn) ");
    query.append(representante_int);
    query.append(marca_ped);
    query.append(filtroSegmento);
    if (!regional.equalsIgnoreCase("null")) {
      query.append("                         AND r.codigo_regional = " + regional);
    }
    query.append("                         AND rf.lin_cdgo = i.lin_cdgo ");
    query.append("                         AND rf.ref_cdgo = i.ref_cdgo ");
    query.append("                         AND r.rep_cdgo = p.rep_cdgo   ");
    query.append("                       GROUP BY p.rep_cdgo ");
    if (!resumoRep) {
      query.append("                            ,rf.codigo_marca ");
    }
    query.append("                               ,rf.ref_grupo_posicao_fab ");
    query.append("       UNION ALL ");
    query.append("                        SELECT 'realizado_anterior' ");
    query.append("                              ,NULL codigo_gerente ");
    query.append("                              ,p.rep_cdgo rep_cdgo ");
    query.append("                              ,").append(resumoRep ? "0 codigo_marca":"rf.codigo_marca");
    query.append("                              ,0 vlr_fat ");
    query.append("                              ,0 vlr_a_fat ");
    query.append("                              ,0 qtde_fat ");
    query.append("                              ,0 qtde_a_fat ");
    query.append("                              ,0 vlr_realizado ");
    query.append("                              ,0 qtde_realizado ");
    query.append("                              ,SUM(fct_valor_pedido(i.ped_nmro, i.ite_seqn)) vlr_realizado_anterior ");
    query.append("                              ,SUM(i.ite_qtde) qtde_realizado_anterior ");
    query.append("                              ,0 preco_previsto ");
    query.append("                              ,0 reais_previsto ");
    query.append("                              ,0 pares_previsto ");
    if (abrirSegmento) {
      query.append("                           ,case when ref_grupo_posicao_fab in (7,17) then 'BOLSAS' when ref_grupo_posicao_fab in (26,29) then 'MEIAS' when ref_grupo_posicao_fab  in (30) then 'OCULOS' when ref_grupo_posicao_fab in (18,19,31,32,33) then 'VESTUARIO' else 'CALCADOS' end ref_grupo_posicao_fab_descricao ");
    } else {
      query.append("                              ,'GERAL' ref_grupo_posicao_fab_descricao ");
    }
    query.append("                          FROM ped p ");
    query.append("                              ,ite i ");
    query.append("                              ,rep r ");
    query.append("                              ,ref rf ");
    query.append("                       WHERE p.ped_dadg >= to_date('"+com.egen.util.text.FormatNumber.format(Integer.parseInt(f.getMes()), "00") + (Integer.parseInt(f.getAno()) - 1) + "','mmrrrr')   ");
    query.append("                         AND p.ped_dadg < last_day(to_date('"+com.egen.util.text.FormatNumber.format(Integer.parseInt(f.getMes_final()), "00") + (Integer.parseInt(f.getAno_final()) - 1) + "','mmrrrr')) + 1   ");
    query.append("                           AND p.ped_nmro = i.ped_nmro ");
    query.append("                           AND pck_pedidos.to_somente_entrada(i.ped_nmro, i.ite_seqn) = ");
    query.append("                               pck_pedidos.get_somente_entrada(i.ped_nmro, i.ite_seqn) ");
    query.append(representante_int);
    query.append(marca_ped);
    query.append(filtroSegmento);
    if (!regional.equalsIgnoreCase("null")) {
      query.append("                         AND r.codigo_regional = " + regional);
    }
    query.append("                           AND r.rep_cdgo = p.rep_cdgo ");
    query.append("                           AND rf.lin_cdgo = i.lin_cdgo ");
    query.append("                           AND rf.ref_cdgo = i.ref_cdgo ");
    query.append("                         GROUP BY p.rep_cdgo ");
    if (!resumoRep) {
      query.append("                             , rf.codigo_marca ");
    }
    query.append("                                , rf.ref_grupo_posicao_fab ");
    query.append("                      UNION ALL ");
    query.append("                      SELECT 'previsto'   ");
    query.append("                            ,null codigo_gerente   ");
    query.append("                            ,t.codigo_representante rep_cdgo   ");
    query.append("                            ,").append(resumoRep ? "0 codigo_marca":"t.codigo_marca");
    query.append("                            ,0 vlr_fat   ");
    query.append("                            ,0 vlr_a_fat   ");
    query.append("                            ,0 qtde_fat   ");
    query.append("                            ,0 qtde_a_fat   ");
    query.append("                            ,0 vlr_realizado   ");
    query.append("                            ,0 qtde_realizado   ");
    query.append("                              ,0 vlr_realizado_anterior ");
    query.append("                              ,0 qtde_realizado_anterior ");
    query.append("                            ,CASE   ");
    query.append("                               WHEN TO_DATE(LPAD(t.mes_venda_reais, 2, 0) || t.ano_venda_reais, 'MMRRRR') BETWEEN TO_DATE('"+f.getMes() + "/"+f.getAno() + "', 'MM/RRRR') AND TO_DATE('"+f.getMes_final() + "/"+f.getAno_final() + "', 'MM/RRRR') THEN   ");
    query.append("                                SUM(t.total_reais_previsto) / DECODE(SUM(t.total_pares_previsto), 0, 1, SUM(t.total_pares_previsto))   ");
    query.append("                               ELSE   ");
    query.append("                                0   ");
    query.append("                             END preco_previsto   ");
    query.append("                            ,CASE   ");
    query.append("                               WHEN TO_DATE(LPAD(t.mes_venda_reais, 2, 0) || t.ano_venda_reais, 'MMRRRR') BETWEEN TO_DATE('"+f.getMes() + "/"+f.getAno() + "', 'MM/RRRR') AND TO_DATE('"+f.getMes_final() + "/"+f.getAno_final() + "', 'MM/RRRR') THEN   ");
    query.append("                                SUM(t.total_reais_previsto)   ");
    query.append("                               ELSE   ");
    query.append("                                0   ");
    query.append("                             END reais_previsto   ");
    query.append("                            ,CASE   ");
    query.append("                               WHEN TO_DATE(LPAD(t.mes_venda_reais, 2, 0) || t.ano_venda_reais, 'MMRRRR') BETWEEN TO_DATE('"+f.getMes() + "/"+f.getAno() + "', 'MM/RRRR') AND TO_DATE('"+f.getMes_final() + "/"+f.getAno_final() + "', 'MM/RRRR') THEN   ");
    query.append("                                SUM(t.total_pares_previsto)   ");
    query.append("                               ELSE   ");
    query.append("                                0   ");
    query.append("                             END pares_previsto ");
    if (abrirSegmento) {
      query.append("                           , 'CALCADOS' ref_grupo_posicao_fab_descricao ");
    } else {
      query.append("                           , 'GERAL' ref_grupo_posicao_fab_descricao ");
    }
    query.append("                        FROM cotas_linhas_reais_entrada t ");
    query.append("                       WHERE 1=1 ");
    query.append(filtroPrevistoCalcados);
    query.append(rep);
    query.append(marca_int);
    query.append("                       GROUP BY t.codigo_representante ");
    if (!resumoRep) {
      query.append("                            ,t.codigo_marca ");
    }
    query.append("                               ,LPAD(t.mes_venda_reais, 2, 0) || t.ano_venda_reais ");
    query.append("                      UNION ALL ");
    query.append("                      SELECT 'previsto' ");
    query.append("                            ,null codigo_gerente ");
    query.append("                            ,t.rep_cdgo ");
    query.append("                            ,").append(resumoRep ? "0 codigo_marca":"t.codigo_marca");
    query.append("                            ,0 vlr_fat ");
    query.append("                            ,0 vlr_a_fat ");
    query.append("                            ,0 qtde_fat ");
    query.append("                            ,0 qtde_a_fat ");
    query.append("                            ,0 vlr_realizado ");
    query.append("                            ,0 qtde_realizado ");
    query.append("                            ,0 vlr_realizado_anterior ");
    query.append("                            ,0 qtde_realizado_anterior ");
    query.append("                            ,CASE ");
    query.append("                               WHEN TO_DATE(LPAD(t.mes_venda_reais, 2, 0) || t.ano_venda_reais, 'MMRRRR') BETWEEN TO_DATE('"+f.getMes() + "/"+f.getAno() + "', 'MM/RRRR') AND TO_DATE('"+f.getMes_final() + "/"+f.getAno_final() + "', 'MM/RRRR') THEN   ");
    query.append("                                SUM(t.total_reais_previsto) / DECODE(SUM(t.total_pares_previsto), 0, 1, SUM(t.total_pares_previsto))   ");
    query.append("                               ELSE ");
    query.append("                                0 ");
    query.append("                             END preco_previsto ");
    query.append("                            ,CASE   ");
    query.append("                               WHEN TO_DATE(LPAD(t.mes_venda_reais, 2, 0) || t.ano_venda_reais, 'MMRRRR') BETWEEN TO_DATE('"+f.getMes() + "/"+f.getAno() + "', 'MM/RRRR') AND TO_DATE('"+f.getMes_final() + "/"+f.getAno_final() + "', 'MM/RRRR') THEN   ");
    query.append("                                SUM(t.total_reais_previsto)   ");
    query.append("                               ELSE ");
    query.append("                                0 ");
    query.append("                             END reais_previsto ");
    query.append("                            ,CASE ");
    query.append("                               WHEN TO_DATE(LPAD(t.mes_venda_reais, 2, 0) || t.ano_venda_reais, 'MMRRRR') BETWEEN TO_DATE('"+f.getMes() + "/"+f.getAno() + "', 'MM/RRRR') AND TO_DATE('"+f.getMes_final() + "/"+f.getAno_final() + "', 'MM/RRRR') THEN   ");
    query.append("                                SUM(t.total_pares_previsto) ");
    query.append("                               ELSE ");
    query.append("                                0 ");
    query.append("                             END pares_previsto ");
    if (abrirSegmento) {
      query.append("                           , pck_uni_negocio.get_nome(t.unn_codigo) ref_grupo_posicao_fab_descricao ");
    } else {
      query.append("                           , 'GERAL' ref_grupo_posicao_fab_descricao ");
    }
    query.append("                        FROM erc_orcamento_marca t ");
    query.append("                       WHERE 1=1 ");
    query.append("                         AND pck_uni_negocio.get_nome(t.unn_codigo) not in ('INJECAO DIRETA','ADMINISTRACAO CENTRAL') ");
    query.append(filtroPrevistoOutros);
    query.append(repErc);
    query.append(marca_int);
    query.append("                       GROUP BY t.rep_cdgo");
    if (!resumoRep) {
      query.append("                           , t.codigo_marca ");
    }
    query.append("                              , t.unn_codigo ");
    query.append("                              , LPAD(t.mes_venda_reais, 2, 0) || t.ano_venda_reais) qry ");
    //query.append("               GROUP BY rep_cdgo ");
    //if(!resumoRep) {
    //   query.append("                   , codigo_marca ");
    //}
    //query.append("                      , ref_grupo_posicao_fab_descricao ");
    query.append(" ) realizado ");

    query.append("       WHERE r.rep_cdgo = realizado.rep_cdgo ");
    if (!regional.equalsIgnoreCase("null")) {
      query.append("                         AND r.codigo_regional = " + regional);
    }
    query.append(representante_int);
    query.append(marca);
    //query.append(marca_ext );
    query.append("         AND r.codigo_regional = rv.codigo_regional   ");
    query.append("         AND (realizado.vlr_realizado_geral > 0 OR realizado.reais_previsto > 0))   ");
    query.append("       ORDER BY codigo_regional ");
    if (!resumoRep) {
      query.append("              , codigo_marca ");
    }
    query.append("              , ref_grupo_posicao_fab_descricao ");
    query.append("              , codigo_representante ");

    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      throw new Exception(query.toString());
    }


    if (false) {
      throw new Exception(query.toString());
    }

    Vector res_Jw_poi_aberto_rep_entrada_pedidos = j.select(table, query.toString(), null);

    session.setAttribute("res_Jw_poi_aberto_rep_entrada_pedidos",res_Jw_poi_aberto_rep_entrada_pedidos);
    if (!(res_Jw_poi_aberto_rep_entrada_pedidos != null && res_Jw_poi_aberto_rep_entrada_pedidos.size() > 0)) {
      throw new Exception("Nenhum registro encontrado!");
    }

    session.setAttribute("mapping.getName()", form);
  }













  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      PoiAbertoRepEntradaPedidosActionForm f = (PoiAbertoRepEntradaPedidosActionForm) form;
      session.removeAttribute("res_Jw_poi");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_poi", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_refresh_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      PoiAbertoRepEntradaPedidosActionForm f = (PoiAbertoRepEntradaPedidosActionForm) form;
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_poi", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
