package portalbr.ind;

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
 * Creation Date 21/05/2012 14:54:32
 * Last Modify Date 03/08/2022 10:27:20
 */

public class DadosTecnicosProdutosAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DadosTecnicosProdutosActionForm f = (DadosTecnicosProdutosActionForm) form;
      select_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/ind/DadosTecnicosProdutos_rForm.jsp", true);
      if (session.getAttribute("gera_excel") != null) {
        session.removeAttribute("gera_excel");
        actionForward = mapping.findForward("same");
      }
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_dados_tecnicos_produtos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    DadosTecnicosProdutosActionForm f = (DadosTecnicosProdutosActionForm) form;
    if ((f.getPedidos() + "").equals("null")) {
      f.setPedidos("");
    }
    if ((f.getOcs() + "").equals("null")) {
      f.setOcs("");
    }

    StringBuilder parametros = new StringBuilder();
    String representante = null;
    boolean exibirTamanhosPedidos = false;
    if (f.getCb_tamanhos_pedidos() != null && f.getCb_tamanhos_pedidos().equals("1")) {
      if (!f.getPedidos().equals("")) {
        exibirTamanhosPedidos = true;
      }
    }

    session.removeAttribute("tipo_relatorio_dados_tecnicos_fatura");
    session.removeAttribute("mostrar_pedido_item");
    session.removeAttribute("gera_excel");
    boolean tipoProduto = false;
    boolean tipoPedido = false;
    boolean consultaFaturas = false;
    boolean consultaPedidos = false;
    boolean consultaPeriodo = false;
    boolean consultaPorPedidos = false;
    boolean consultaPorOcs = false;
    boolean perfilCliente = false;
    String perfilClienteCodigo = "";

    acesso.Sessao sessao = new acesso.Sessao(session);
    if (sessao.getTipoEntidadeNegocio().equals("CLIENTE MERCADO INTERNO") || sessao.getTipoEntidadeNegocio().equals("CLIENTE MERCADO EXTERNO")) {
      perfilCliente = true;
      perfilClienteCodigo = sessao.getChave();
    }
    if (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL") || sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO")) {
      representante = sessao.getChave();
    }

    if (f.getTipo_relatorio().equalsIgnoreCase("produto") || f.getTipo_relatorio().equalsIgnoreCase("fatura") || f.getTipo_relatorio().equalsIgnoreCase("catalogo")) {
      tipoProduto = true;
    }

    if (tipoProduto) {
      if (!f.getPedidos().equals("")) {
        session.setAttribute("mostrar_pedido_item","S");
      }
    }

    if (f.getTipo_relatorio().equalsIgnoreCase("pedido")) {
      consultaPedidos = true;
    }

    if (f.getTipo_relatorio().equalsIgnoreCase("fatura")) {
      session.setAttribute("tipo_relatorio_dados_tecnicos_fatura","F");
      consultaFaturas = true;
    }

    if (!f.getPedidos().equals("")) {
      consultaPorPedidos = true;
      consultaPedidos = true;
    }

    if (!(f.getOcs() + "").equals("")) {
      if (!(f.getOcs() + "").equals("null")) {
        consultaPorOcs = true;
        consultaPedidos = true;
      }
    }

    if (!(consultaPorPedidos) && !(consultaPorOcs)) {
      if ((!((f.getGre_grupo() + "").equals(""))) || (!((f.getCli_cdgo() + "").equals(""))) || f.getTipo_relatorio().equals("pedido")) {
        if ((f.getPed_dadg_inicial() + "").equals("") || (f.getPed_dadg_final() + "").equals("")) {
          throw new Exception("O período deve ser informado!");
        }
      }
      if (!consultaFaturas) {

        if (f.getGre_grupo().equals("") && f.getCli_cdgo().equals("") && f.getLin_cdgo().equals("") && f.getRef_cdgo().equals("") && f.getCab_cdgo().equals("") && f.getCor_cdgo().equals("") && f.getPedidos().equals("") && f.getMarca().equals("") && f.getTipo().equals("")) {
          throw new Exception("Um dos campos com <img src='../img/opcional.gif' border='0'/> deve ser informado!");
        }
      } else {
        if (f.getAno_fatura().equals("") || f.getNumero_fatura().equals("")) {
          throw new Exception("O número e o ano da fatura devem ser informados!");
        }
      }


      if ((!f.getPedidos().equals("")) || (!f.getOcs().equals("")) || (!f.getPed_dadg_inicial().equals("")) || (!f.getPed_dadg_final().equals("")) || f.getTipo_relatorio().equalsIgnoreCase("pedido")) {
        consultaPedidos = true;
      }

      if (consultaPedidos) {
        if (f.getPed_dadg_inicial().equals("") && (!f.getPed_dadg_final().equals(""))) {
          throw new Exception("O período deve ser informado!");
        }
        if (f.getPed_dadg_final().equals("") && (!f.getPed_dadg_inicial().equals(""))) {
          throw new Exception("O período deve ser informado!");
        }
        if ((!f.getPed_dadg_inicial().equals("")) && (!f.getPed_dadg_final().equals(""))) {
          consultaPeriodo = true;
        }
      }


      if (!f.getMarca().equals("")) {
        parametros.append(" AND mp.codigo_marca = " + f.getMarca());
      }
      if (!f.getTipo().equals("")) {
        parametros.append(" AND r.ref_grupo_posicao_fab = " + f.getTipo());
      }
      if (!f.getLin_cdgo().equals("")) {
        parametros.append(" AND rg.lin_cdgo = " + f.getLin_cdgo());
      }
      if (!f.getRef_cdgo().equals("")) {
        parametros.append(" AND rg.ref_cdgo = " + f.getRef_cdgo());
      }
      if (!f.getCab_cdgo().equals("")) {
        parametros.append(" AND rc.cab_cdgo = " + f.getCab_cdgo());
      }
      if (!f.getCor_cdgo().equals("")) {
        parametros.append(" AND rc.cor_cdgo = " + f.getCor_cdgo());
      }
      if (!f.getGre_grupo().equals("")) {
        parametros.append(" AND pck_cliente.get_grupo_economico(p.cli_cdgo) = " + f.getGre_grupo());
      }
      if (!f.getCli_cdgo().equals("")) {
        parametros.append(" AND nvl(p.cli_cdgo, null) = " + f.getCli_cdgo());
      }
      if (!f.getTipo().equals("")) {
        parametros.append(" AND r.ref_grupo_posicao_fab = " + f.getTipo());
      }
    }

    Jw_dados_tecnicos_produtos table = new Jw_dados_tecnicos_produtos();
    StringBuilder sb = new StringBuilder();

    if (consultaPorPedidos) {
      sb.append(" SELECT  /*+ index( p PK_PED ) */ DISTINCT ");
    } else if (consultaPedidos && consultaPeriodo) {
      sb.append(" SELECT ");
    } else if (consultaPorOcs) {
      sb.append(" SELECT /*+ all_rows*/ DISTINCT ");
    } else {
      sb.append(" SELECT /*+ index( rg PK_REF_GDE ) */ DISTINCT ");
    }
    sb.append("        ped_nmro ");
    sb.append("       ,pck_pedidos.get_ped_ped_cliente(ped_nmro) ped_ped_cliente ");
    sb.append("       ,lin_cdgo ");
    sb.append("       ,ref_cdgo ");
    sb.append("       ,cab_cdgo ");
    sb.append("       ,pck_cabedal.get_nome(cab_cdgo) cab_desc ");
    sb.append("       ,cor_cdgo ");
    sb.append("       ,descricao_cor ");
    if (f.getTipo_relatorio().equalsIgnoreCase("produto")) {
      sb.append(" ,(SELECT SUM(q.pares) pares ");
      sb.append("          FROM (SELECT ped.ped_nmro, ");
      sb.append("                       ite.ite_seqn item_nmro, ");
      sb.append("                       ite.lin_cdgo, ");
      sb.append("                       ite.ref_cdgo, ");
      sb.append("                       ite.cab_cdgo, ");
      sb.append("                       ite.cor_cdgo, ");
      sb.append("                       ite.gde_cdgo grade, ");
      sb.append("                       q.qtp_nume produto_tamanho, ");
      sb.append("                       (ite.ite_qtde / SUM(q.qtp_pars) ");
      sb.append("                        OVER(PARTITION BY q.ped_nmro, q.ite_seqn) * ");
      sb.append("                        q.qtp_pars) pares ");
      sb.append("                  FROM qtd_prg q, ite, ped ");
      sb.append("                 WHERE ped.ped_nmro = ite.ped_nmro ");
      sb.append("                   AND ite.ped_nmro = q.ped_nmro ");
      sb.append("                   AND ite.ite_seqn = q.ite_seqn ");
      sb.append("                   AND ped.ped_nmro = qry.ped_nmro) q ");
      sb.append("         WHERE q.produto_tamanho = qry.qtp_nume ");
      sb.append("          and q.lin_cdgo = qry.lin_cdgo ");
      sb.append("          and q.ref_cdgo = qry.ref_cdgo ");
      sb.append("          and q.cab_cdgo = qry.cab_cdgo ");
      sb.append("          and q.cor_cdgo = qry.cor_cdgo) qtp_pars ");
      sb.append("    ,ite_prco ");
    }

    if (tipoProduto || consultaFaturas) {
      sb.append("    ,desc_produto ");
      sb.append("    ,qtp_nume ");
      sb.append("    ,(SELECT ditc.id ");
      sb.append("        FROM dom_item_tamanho_cor_id ditc ");
      sb.append("       WHERE ditc.ies_codigo = codigo ");
      sb.append("         AND ditc.cor_cdgo = qry.cor_cdgo ");
      sb.append("         AND ditc.tai_codigo = TO_CHAR(qtd_nume)) id_produto ");
      sb.append("    ,marca ");
      sb.append("    ,marca_descricao ");
      sb.append("    ,filial ");
      sb.append("    ,decode(fil_filial_fat,null,cnpj,pck_filial.get_cnpj(fil_filial_fat)) cnpj ");
      sb.append("    ,brio.fct_retorna_cod_barra(lin_cdgo, ref_cdgo, cab_cdgo, cor_cdgo, qtd_nume) ean13 ");
      sb.append("    ,(select codigo_barra_dum14 from ref_bar where lin_cdgo = qry.lin_cdgo and ref_cdgo = qry.ref_cdgo and cab_cdgo = qry.cab_cdgo and cor_cdgo = qry.cor_cdgo and rfb_numero = '0' and rownum = 1) dun14 ");
      sb.append("    ,pck_item_estoque.get_classificacao_fiscal(codigo) classificacao_fiscal ");
      sb.append("    ,(SELECT comprimento || ' x ' || largura || ' x ' || altura ");
      sb.append("        FROM peso_corrugados pso ");
      sb.append("       WHERE lin_cdgo = qry.lin_cdgo ");
      sb.append("         AND ref_cdgo = qry.ref_cdgo ");
      sb.append("         AND codigo_corrug = (SELECT MIN(codigo_corrug) ");
      sb.append("                                FROM peso_corrugados pco ");
      sb.append("                               WHERE pco.lin_cdgo = pso.lin_cdgo ");
      sb.append("                                 AND pco.ref_cdgo = pso.ref_cdgo ");
      sb.append("                                 AND pco.ativo = 'A')) comp_larg_alt_embalagem ");
      sb.append("    ,peso_embalamgem ");
      sb.append("    ,peso_sapato ");
      sb.append("    ,ra_fornecedor ");
      sb.append("    ,razao_social ");
      sb.append("    ,ref_fechamento_sapato ");
      sb.append("    ,ref_tipo_salto ");
      sb.append("    ,ref_bota_possui_elastico ");

    } else {
      sb.append("    ,null desc_produto ");
      sb.append("    ,null qtp_nume ");
      sb.append("    ,null  id_produto ");
      sb.append("    ,null marca ");
      sb.append("    ,null marca_descricao ");
      sb.append("    ,null filial ");
      sb.append("    ,null cnpj ");
      sb.append("    ,null ean13 ");
      sb.append("    ,null dun14 ");
      sb.append("    ,null classificacao_fiscal ");
      sb.append("    ,null comp_larg_alt_embalagem ");
      sb.append("    ,null peso_embalamgem ");
      sb.append("    ,null peso_sapato ");
      sb.append("    ,null ra_fornecedor ");
      sb.append("    ,null razao_social ");
      sb.append("    ,null ref_fechamento_sapato ");
      sb.append("    ,null ref_tipo_salto ");
      sb.append("    ,null ref_bota_possui_elastico ");
    }
    sb.append("    ,ref_tip_mat_cdgo_palmilha ");
    sb.append("    ,(SELECT descricao ");
    sb.append("        FROM tipo_material ");
    sb.append("       WHERE codigo = qry.ref_tip_mat_cdgo_palmilha) tip_mat_palmilha_descricao ");

    if (tipoProduto || consultaFaturas) {
      sb.append("    ,ref_tip_mat_cdgo_entresola ");
      sb.append("    ,(SELECT descricao ");
      sb.append("        FROM tipo_material ");
      sb.append("       WHERE codigo = qry.ref_tip_mat_cdgo_entresola) tip_mat_entresola_descricao ");
      sb.append("    ,ref_tip_mat_cdgo_salto ");
      sb.append("                       ,(SELECT descricao ");
      sb.append("                           FROM tipo_material ");
      sb.append("                          WHERE codigo = qry.ref_tip_mat_cdgo_salto) tip_mat_salto_descricao ");
      sb.append("    ,ref_tip_mat_cdgo_meiapata ");
      sb.append("                       ,(SELECT descricao ");
      sb.append("                           FROM tipo_material ");
      sb.append("                          WHERE codigo = qry.ref_tip_mat_cdgo_meiapata) tip_mat_meiapata_descricao ");
      sb.append("   ,(SELECT to_char(die.comprimento, '999D0000') || ");
      sb.append("                                ' x ' || to_char(die.largura, '999D000000') || ");
      sb.append("                                ' x ' || to_char(die.altura, '999D0000') ");
      sb.append("                           FROM dom_item_estoque die ");
      sb.append("                          WHERE die.codigo = ");
      sb.append("                                (SELECT DISTINCT mat_nro ");
      sb.append("                                   FROM componente ");
      sb.append("                                  WHERE lin_cdgo = qry.lin_Cdgo ");
      sb.append("                                    AND ref_cdgo = qry.ref_Cdgo ");
      sb.append("                                    AND cod_peca IN (100, 150) ");
      sb.append("                                    AND ROWNUM = 1)) ref_dimensao_cx_individual ");
      sb.append("                       ,(SELECT descricao ");
      sb.append("                           FROM tipo_material ");
      sb.append("                          WHERE codigo = qry.ref_dimensao_cx_individual) dimensao_caixa_descricao ");
      sb.append("    ,observacao ");
      sb.append("    ,ref_largura_interna_pe ");
      sb.append("    ,ref_compr_interno_pe ");
      sb.append("    ,ref_altura_sapato ");
      sb.append("    ,ref_largura_ext_sapato ");
      sb.append("    ,ref_compr_ext_sapato ");
      sb.append("    ,ref_altura_salto ");
      sb.append("    ,ref_altura_meiapata ");
      sb.append("    ,ref_altura_canobota ");
      sb.append("    ,ref_diametro_boca_bota ");
      sb.append("    ,grupo_posicao_fabrica ");

    } else {
      sb.append("    ,null ref_tip_mat_cdgo_entresola ");
      sb.append("    ,null tip_mat_entresola_descricao ");
      sb.append("    ,null ref_tip_mat_cdgo_salto ");
      sb.append("    ,null tip_mat_salto_descricao ");
      sb.append("    ,null ref_tip_mat_cdgo_meiapata ");
      sb.append("    ,null tip_mat_meiapata_descricao ");
      sb.append("    ,null ref_dimensao_cx_individual ");
      sb.append("    ,null dimensao_caixa_descricao ");
      sb.append("    ,null observacao ");
      sb.append("    ,null ref_largura_interna_pe ");
      sb.append("    ,null ref_compr_interno_pe ");
      sb.append("    ,null ref_altura_sapato ");
      sb.append("    ,null ref_largura_ext_sapato ");
      sb.append("    ,null ref_compr_ext_sapato ");
      sb.append("    ,null ref_altura_salto ");
      sb.append("    ,null ref_altura_meiapata ");
      sb.append("    ,null ref_altura_canobota ");
      sb.append("    ,null ref_diametro_boca_bota ");
      sb.append("    ,null grupo_posicao_fabrica ");
    }
    sb.append("                       ,(SELECT c.tip_mat_cdgo || ' - ' || t.descricao ");
    sb.append("                           FROM cabedal       c ");
    sb.append("                               ,tipo_material t ");
    sb.append("                          WHERE c.tip_mat_cdgo = t.codigo ");
    sb.append("                            AND c.cab_cdgo = qry.cab_cdgo) tipo_material_predominante ");
    sb.append("                       ,(SELECT t.descricao ");
    sb.append("                           FROM tipo_material t ");
    sb.append("                          WHERE t.codigo = qry.sol_codigo) tipo_material_solado ");
    sb.append("                       ,(SELECT UPPER(rv_meaning) ");
    sb.append("                           FROM cg_ref_codes cgr ");
    sb.append("                          WHERE rv_domain LIKE '%CLASSIFICACAO_NCM%' ");
    sb.append("                            AND rv_abbreviation = qry.tipo_material_forro) tipo_material_forro ");
    if (tipoProduto || consultaFaturas) {
      sb.append("    ,ref_perc_cabedal ");
      sb.append("    ,ref_perc_solado ");
      sb.append("                       ,(SELECT x.codigo_controle_fci ");
      sb.append("                           FROM rdo.dom_item_estoque_cst_imp_calc x ");
      sb.append("                          WHERE est.fct_ies_codigo_nativo(fct_ies_codigo(qry.lin_cdgo, qry.ref_cdgo, qry.cab_cdgo), qry.cor_cdgo, qry.qtd_nume) = ");
      sb.append("                                x.id_item ");
      sb.append("                            AND (x.fil_filial = ");
      sb.append("                                 fnc_retorna_filial_lin_ref(qry.lin_cdgo, qry.ref_cdgo) OR ");
      sb.append("                                 x.fil_filial = '20') ");
      sb.append("                            AND codigo_controle_fci IS NOT NULL ");
      sb.append("                            AND ROWNUM = 1) fci ");
      sb.append("                       ,DECODE((SELECT x.codigo_controle_fci ");
      sb.append("                                 FROM rdo.dom_item_estoque_cst_imp_calc x ");
      sb.append("                                WHERE est.fct_ies_codigo_nativo(fct_ies_codigo(qry.lin_cdgo, qry.ref_cdgo, qry.cab_cdgo), qry.cor_cdgo, qry.qtd_nume) = ");
      sb.append("                                      x.id_item ");
      sb.append("                                  AND (x.fil_filial = ");
      sb.append("                                       fnc_retorna_filial_lin_ref(qry.lin_cdgo, qry.ref_cdgo) OR ");
      sb.append("                                       x.fil_filial = '20') ");
      sb.append("                                  AND codigo_controle_fci IS NOT NULL ");
      sb.append("                                  AND ROWNUM = 1), NULL, '000', '500') cst ");
    } else {
      sb.append("    ,null ref_perc_cabedal ");
      sb.append("    ,null ref_perc_solado ");
      sb.append("    ,null fci ");
      sb.append("    ,null cst ");
    }

    sb.append("   ,(SELECT UPPER(tipo_material.rv_meaning) ");
    sb.append("                           FROM ficha_tec f ");
    sb.append("                               ,(SELECT crc.* ");
    sb.append("                                   FROM cg_ref_codes crc ");
    sb.append("                                  WHERE crc.rv_domain = 'CLASSIFICACAO_NCM') tipo_material ");
    sb.append("                          WHERE f.lin_cdgo = qry.lin_cdgo ");
    sb.append("                            AND f.ref_cdgo = qry.ref_cdgo ");
    sb.append("                            AND f.cab_cdgo = qry.cab_cdgo ");
    sb.append("                            AND f.cor_cdgo = 0 ");
    sb.append("                            AND tipo_material.rv_low_value = ");
    sb.append("                                f.tipo_material_palmilha ");
    sb.append("                            AND NVL(f.fit_status, NULL) = 'A' ");
    sb.append("                            AND ROWNUM = 1) tipo_material_palmilha ");
    if (consultaPedidos) {
      sb.append("                       ,NVL((SELECT 'S' tem_etiqueta ");
      sb.append("                              FROM ped_inf_adicionais pfa ");
      sb.append("                             WHERE pfa.ped_nmro = qry.ped_nmro ");
      sb.append("                               AND pfa.etiquetas IS NOT NULL), 'N') tem_etiqueta ");
    } else {
      sb.append("               ,'N' tem_etiqueta ");
    }
    sb.append("       ,mix_produtos ");
    sb.append("       ,numero_exterior ");
    sb.append("    ,pck_parametros_sugestao_pdv.get_sugestao_pdv(qry.lin_cdgo, qry.ref_cdgo, qry.cab_cdgo) preco_pdv ");
    sb.append("                       ,(SELECT comprimento ");
    sb.append("                           FROM peso_corrugados pso ");
    sb.append("                          WHERE lin_cdgo = qry.lin_cdgo ");
    sb.append("                            AND ref_cdgo = qry.ref_cdgo ");
    sb.append("                            AND codigo_corrug = ");
    sb.append("                                (SELECT MIN(codigo_corrug) ");
    sb.append("                                   FROM peso_corrugados pco ");
    sb.append("                                  WHERE pco.lin_cdgo = pso.lin_cdgo ");
    sb.append("                                    AND pco.ref_cdgo = pso.ref_cdgo ");
    sb.append("                                    AND pco.ativo = 'A')) comprimento_embalagem ");
    sb.append("                       ,(SELECT largura ");
    sb.append("                           FROM peso_corrugados pso ");
    sb.append("                          WHERE lin_cdgo = qry.lin_cdgo ");
    sb.append("                            AND ref_cdgo = qry.ref_cdgo ");
    sb.append("                            AND codigo_corrug = ");
    sb.append("                                (SELECT MIN(codigo_corrug) ");
    sb.append("                                   FROM peso_corrugados pco ");
    sb.append("                                  WHERE pco.lin_cdgo = pso.lin_cdgo ");
    sb.append("                                    AND pco.ref_cdgo = pso.ref_cdgo ");
    sb.append("                                    AND pco.ativo = 'A')) largura_embalagem ");
    sb.append("                       ,(SELECT altura ");
    sb.append("                           FROM peso_corrugados pso ");
    sb.append("                          WHERE lin_cdgo = qry.lin_cdgo ");
    sb.append("                            AND ref_cdgo = qry.ref_cdgo ");
    sb.append("                            AND codigo_corrug = ");
    sb.append("                                (SELECT MIN(codigo_corrug) ");
    sb.append("                                   FROM peso_corrugados pco ");
    sb.append("                                  WHERE pco.lin_cdgo = pso.lin_cdgo ");
    sb.append("                                    AND pco.ref_cdgo = pso.ref_cdgo ");
    sb.append("                                    AND pco.ativo = 'A')) altura_embalagem ");
    sb.append("                       ,(SELECT to_char(die.comprimento, '999D0000') ");
    sb.append("                           FROM dom_item_estoque die ");
    sb.append("                          WHERE die.codigo = ");
    sb.append("                                (SELECT DISTINCT mat_nro ");
    sb.append("                                   FROM componente ");
    sb.append("                                  WHERE lin_cdgo = qry.lin_Cdgo ");
    sb.append("                                    AND ref_cdgo = qry.ref_Cdgo ");
    sb.append("                                    AND cod_peca IN (100, 150) ");
    sb.append("                                    AND ROWNUM = 1)) comprimento_caixa ");
    sb.append("                       ,(SELECT to_char(die.largura, '999D00000') ");
    sb.append("                           FROM dom_item_estoque die ");
    sb.append("                          WHERE die.codigo = ");
    sb.append("                                (SELECT DISTINCT mat_nro ");
    sb.append("                                   FROM componente ");
    sb.append("                                  WHERE lin_cdgo = qry.lin_Cdgo ");
    sb.append("                                    AND ref_cdgo = qry.ref_Cdgo ");
    sb.append("                                    AND cod_peca IN (100, 150) ");
    sb.append("                                    AND ROWNUM = 1)) largura_caixa ");
    sb.append("                       ,(SELECT to_char(die.altura, '999D0000') ");
    sb.append("                           FROM dom_item_estoque die ");
    sb.append("                          WHERE die.codigo = ");
    sb.append("                                (SELECT DISTINCT mat_nro ");
    sb.append("                                   FROM componente ");
    sb.append("                                  WHERE lin_cdgo = qry.lin_Cdgo ");
    sb.append("                                    AND ref_cdgo = qry.ref_Cdgo ");
    sb.append("                                    AND cod_peca IN (100, 150) ");
    sb.append("                                    AND ROWNUM = 1)) altura_caixa ");
    sb.append("                        ,altura_alca ");
    sb.append("                        ,altura_bolsa ");
    sb.append("                        ,bolso_interno ");
    sb.append("                        ,fechamento_bolsa ");
    sb.append("                        ,largura_bolsa ");
    sb.append("                        ,peso_bolsa ");
    sb.append("                        ,profundidade_bolsa ");
    sb.append("                        ,quantidade_bolsos ");
    sb.append("                        ,regulagem ");
    sb.append("                        ,tipo_alca ");
    sb.append("                        ,fil_filial_fat ");
    if (f.getTipo_relatorio().equalsIgnoreCase("produto") && consultaPorPedidos) {
      sb.append("                        ,ite_seqn ");
    } else {
      sb.append("                        ,null ite_seqn ");
    }
    sb.append("   FROM (SELECT DISTINCT rg.lin_cdgo ");
    if (consultaPedidos) {
      sb.append("                     ,p.ped_nmro ");
      sb.append("                     ,pck_pedidos.get_ped_ped_cliente(p.ped_nmro) ped_ped_cliente ");
    } else {
      sb.append("                     ,NULL ped_nmro ");
      sb.append("                     ,NULL ped_ped_cliente ");
    }
    sb.append("                        ,rg.ref_cdgo ");
    sb.append("                        ,rc.cab_cdgo ");
    sb.append("                        ,rc.cor_cdgo ");
    sb.append("                        ,q.qtd_nume ");
    if (f.getTipo_relatorio().equalsIgnoreCase("produto")) {
      sb.append("                        ,i.ite_prco ");
    }

    sb.append("                        ,die.codigo ");
    sb.append("                        ,co.cor_desc descricao_cor ");
    sb.append("                        ,die.descricao || ' ' || co.cor_desc || ' ' || q.qtd_nume desc_produto ");
    sb.append("                        ,q.qtd_nume qtp_nume ");
    sb.append("                        ,mp.codigo_marca marca ");
    sb.append("                        ,mp.descricao_marca marca_descricao ");
    sb.append("                        ,fl.cod_filial filial ");
    sb.append("                        ,f.fil_cgc cnpj ");
    sb.append("                        ,pso.peso_embalagem + pso.peso_sapato + pso.peso_adicional peso_embalamgem ");
    sb.append("                        ,pso.peso_sapato peso_sapato ");
    sb.append("                        ,TO_CHAR(rc.lin_cdgo) || '-' || TO_CHAR(rc.ref_cdgo) ra_fornecedor ");
    sb.append("                        ,f.fil_razsoc razao_social ");
    sb.append("                        ,ria.ref_fechamento_sapato ");
    sb.append("                        ,ria.ref_tipo_salto ");

    sb.append("                        ,to_char(ria.altura_alca) altura_alca ");
    sb.append("                        ,to_char(ria.altura_bolsa) altura_bolsa ");
    sb.append("                        ,to_char(ria.bolso_interno) bolso_interno ");
    sb.append("                        ,to_char(ria.tipo_fechamento) fechamento_bolsa ");
    sb.append("                        ,to_char(ria.largura_bolsa) largura_bolsa ");
    sb.append("                        ,to_char(ria.peso_bolsa) peso_bolsa ");
    sb.append("                        ,to_char(ria.profundidade_bolsa) profundidade_bolsa ");
    sb.append("                        ,to_char(ria.qtd_bolsos) quantidade_bolsos ");
    sb.append("                        ,to_char(ria.regulagem) regulagem ");
    sb.append("                        ,to_char(ria.tipo_alca) tipo_alca ");

    sb.append("                        ,ria.ref_bota_possui_elastico ");
    sb.append("                        ,ria.ref_tip_mat_cdgo_palmilha ");
    sb.append("                        ,ria.ref_tip_mat_cdgo_entresola ");
    sb.append("                        ,ria.ref_tip_mat_cdgo_salto ");
    sb.append("                        ,ria.ref_tip_mat_cdgo_meiapata ");
    sb.append("                        ,ria.observacao ");
    sb.append("                        ,rian.ref_largura_interna_pe ");
    sb.append("                        ,rian.ref_compr_interno_pe ");
    sb.append("                        ,rian.ref_altura_sapato ");
    sb.append("                        ,rian.ref_largura_ext_sapato ");
    sb.append("                        ,rian.ref_compr_ext_sapato ");
    sb.append("                        ,rian.ref_altura_salto ");
    sb.append("                        ,rian.ref_altura_meiapata ");
    sb.append("                        ,rian.ref_altura_canobota ");
    sb.append("                        ,rian.ref_diametro_boca_bota ");
    sb.append("                        ,gpf.descricao_grupo grupo_posicao_fabrica ");
    sb.append("                        ,ria.ref_perc_cabedal ");
    sb.append("                        ,ria.ref_perc_solado ");
    sb.append("       ,decode(fct_mix_produto(r.lin_cdgo, r.ref_cdgo),'M','Sim','F','Não','Não') mix_produtos ");
    if (consultaFaturas) {
      sb.append("       ,fct_numero_exterior(fp.codigo_cliente, fp.estabelecimento_cliente, q.qtd_nume) numero_exterior ");
    } else {
      sb.append("       ,'' numero_exterior ");
    }

    sb.append(", ria.ref_dimensao_cx_individual ");
    sb.append(", r.sol_codigo ");
    sb.append(", ft.tipo_material_forro ");

    if (consultaFaturas || consultaPedidos || f.getTipo_relatorio().equalsIgnoreCase("produto")) {

      sb.append("   , pia.fil_filial_fat ");
    } else {
      sb.append("   ,'' fil_filial_fat ");
    }

    if (consultaPedidos || f.getTipo_relatorio().equalsIgnoreCase("produto")) {
      sb.append("   , i.ite_seqn ");
    } else {
      sb.append("   , null ite_seqn ");
    }


    sb.append("           FROM ref_gde rg ");
    sb.append("               ,ref_cor rc ");
    sb.append("               ,dom_item_estoque die ");


    if (f.getTipo_relatorio().equalsIgnoreCase("catalogo")) {
      sb.append("            ,cat_produtos_table cp ");
    }

    sb.append("               ,ref r ");
    sb.append("               ,qtd q ");
    sb.append("               ,ref_inf_adicionais ria ");
    sb.append("               ,ref_inf_adicionais_num rian ");
    sb.append("               ,ficha_tec ft ");

    if (consultaFaturas) {
      sb.append("            ,qtd_prg qp ");
      sb.append("            ,ped p ");
      sb.append("            ,ped_inf_adicionais pia ");
      sb.append("            ,ite i ");
      sb.append("            ,faturas_proformas fp ");
      sb.append("            ,itens_faturas_proformas ifp ");
    }


    if (consultaPedidos || f.getTipo_relatorio().equalsIgnoreCase("produto")) {
      sb.append("            ,ped p ");
      sb.append("            ,ped_inf_adicionais pia ");
      sb.append("            ,ite i ");
      if (exibirTamanhosPedidos || f.getTipo_relatorio().equalsIgnoreCase("produto")) {
        sb.append("         ,qtd_prg qp ");
      }
    }

    if (representante != null) {
      sb.append("            ,representante_marca rm ");
    }
    sb.append("               ,peso_numeros pso ");
    sb.append("               ,ficha_embalagem fe ");
    sb.append("               ,grupo_posicao_fabrica gpf ");
    sb.append("               ,filial_linhas fl ");
    sb.append("               ,filial f ");
    sb.append("               ,cor co ");
    sb.append("               ,marcas_produtos mp ");
    sb.append("          WHERE r.lin_cdgo = rc.lin_cdgo ");
    sb.append("            AND r.ref_cdgo = rc.ref_cdgo ");
    sb.append("            AND die.lin_cdgo = r.lin_cdgo ");
    sb.append("            AND die.ref_cdgo = r.ref_cdgo ");


    if (consultaFaturas) {
      sb.append("            AND p.ped_nmro = i.ped_nmro ");
      sb.append("            AND p.ped_nmro = pia.ped_nmro (+) ");
      sb.append("            AND i.lin_cdgo = rc.lin_cdgo ");
      sb.append("            AND i.ref_cdgo = rc.ref_cdgo ");
      sb.append("            AND i.cab_cdgo = rc.cab_cdgo ");
      sb.append("            AND i.cor_cdgo = rc.cor_cdgo ");
      sb.append("            AND qp.ped_nmro = i.ped_nmro ");
      sb.append("            AND qp.ite_seqn = i.ite_seqn ");
      sb.append("            AND qp.qtp_nume = q.qtd_nume ");
      sb.append("            AND fp.empresa_fatura_proforma = i.empresa_fatura_proforma ");
      sb.append("            AND fp.ano_fatura_proforma = i.ano_fatura_proforma ");
      sb.append("            AND fp.numero_fatura_proforma = i.numero_fatura_proforma ");
      //   sb.append("            AND p.ped_stat <> 'C' ");
      sb.append("            AND i.numero_fatura_proforma = " + f.getNumero_fatura());
      sb.append("            AND i.ano_fatura_proforma = " + f.getAno_fatura());
      sb.append("            AND i.empresa_fatura_proforma = '01' ");
      sb.append("            AND ifp.empresa_fatura_proforma = fp.empresa_fatura_proforma ");
      sb.append("            AND ifp.ano_fatura_proforma = fp.ano_fatura_proforma ");
      sb.append("            AND ifp.numero_fatura_proforma = fp.numero_fatura_proforma ");
      sb.append("            AND ifp.codigo_linha = rc.lin_cdgo ");
      sb.append("            AND ifp.codigo_referencia = rc.ref_cdgo ");
      sb.append("            AND ifp.codigo_cabedal = rc.cab_cdgo ");
      sb.append("            AND ifp.codigo_cor = rc.cor_cdgo ");
      sb.append("            AND nvl(ifp.item_cancelado,null) = 'N' ");
    }

    if (consultaPedidos || f.getTipo_relatorio().equalsIgnoreCase("produto")) {
      if (exibirTamanhosPedidos || f.getTipo_relatorio().equalsIgnoreCase("produto")) {
        sb.append("      AND qp.ped_nmro = i.ped_nmro ");
        sb.append("      AND qp.ite_seqn = i.ite_seqn ");
        //        sb.append("       AND q.gde_cdgo = i.gde_cdgo ");
        if (exibirTamanhosPedidos) {
          sb.append("      AND qp.qtp_nume = q.qtd_nume ");
        }
      }
      sb.append("         AND p.ped_nmro = i.ped_nmro ");
      sb.append("         AND p.ped_nmro = pia.ped_nmro (+) ");
      sb.append("         AND i.lin_cdgo = rc.lin_cdgo ");
      sb.append("         AND i.ref_cdgo = rc.ref_cdgo ");
      sb.append("         AND i.cab_cdgo = rc.cab_cdgo ");
      sb.append("         AND i.cor_cdgo = rc.cor_cdgo ");
      //   sb.append("         AND NVL(p.ped_stat, NULL) <> 'C' ");
      if (consultaPeriodo) {

        sb.append("         AND p.ped_dadg BETWEEN to_date('"+f.getPed_dadg_inicial() + "','dd/mm/yyyy') and to_date('"+f.getPed_dadg_final() + "','dd/mm/yyyy') ");
      }
      if (consultaPorPedidos) {
        String pedidos = f.getPedidos().replaceAll("[^0-9]", " ").trim();
        pedidos = pedidos.replaceAll("\\s+", " ");
        pedidos = pedidos.replaceAll(" ", "\n");
        pedidos = pedidos.replaceAll("\\r\\n|\\r|\\n", ",");
        if ((pedidos.charAt(pedidos.length() - 1) + "").equalsIgnoreCase(",")) {
          pedidos = pedidos.substring(0, pedidos.lastIndexOf(","));
        }
        sb.append("         AND p.ped_nmro in ("+pedidos + ") ");
      }
      if (consultaPorOcs) {
        String ocs = f.getOcs().replaceAll("[^0-9]", " ").trim();
        ocs = ocs.replaceAll("\\s+", " ");
        ocs = ocs.replaceAll(" ", "\n");
        ocs = ocs.replaceAll("\\r\\n|\\r|\\n", ",");
        if ((ocs.charAt(ocs.length() - 1) + "").equalsIgnoreCase(",")) {
          ocs = ocs.substring(0, ocs.lastIndexOf(","));
        }
        ocs = ocs.replaceAll(",", "','");
        sb.append("         AND p.ped_ped_cliente in ('"+ocs + "') ");
      }
      if (perfilCliente) {
        sb.append("  and nvl(p.cli_cdgo,null) = " + perfilClienteCodigo);
      }
    }
    if (representante != null) {
      sb.append("         AND rm.situacao = 'A' ");
      sb.append("         AND mp.codigo_marca = rm.marca_produto ");
      sb.append("         AND rm.codigo_representante = '"+representante + "' ");
    }
    sb.append("            AND die.cab_cdgo = rc.cab_cdgo ");
    sb.append("            AND rg.lin_cdgo = rc.lin_cdgo ");
    sb.append("            AND rg.ref_cdgo = rc.ref_cdgo ");
    sb.append("            AND rg.gde_cdgo = q.gde_cdgo ");
    sb.append("            AND mp.codigo_marca = r.codigo_marca ");
    sb.append("            AND gpf.codigo_grupo = r.ref_grupo_posicao_fab ");
    sb.append("            AND ft.lin_cdgo(+) = rc.lin_cdgo ");
    sb.append("            AND ft.ref_cdgo(+) = rc.ref_cdgo ");
    sb.append("            AND ft.cab_cdgo(+) = rc.cab_cdgo ");
    sb.append("            AND pso.lin_cdgo = rc.lin_cdgo ");
    sb.append("            AND pso.ref_cdgo = rc.ref_cdgo ");
    sb.append("            AND fe.lin_cdgo (+) = rc.lin_cdgo ");
    sb.append("            AND fe.ref_cdgo (+) = rc.ref_cdgo ");
    sb.append("            AND ria.lin_cdgo(+) = rc.lin_cdgo ");
    sb.append("            AND ria.ref_cdgo(+) = rc.ref_cdgo ");
    sb.append("            AND rian.lin_cdgo(+) = pso.lin_cdgo ");
    sb.append("            AND rian.ref_cdgo(+) = pso.ref_cdgo ");
    sb.append("            AND rian.rfn_numero(+) = pso.numero ");
    sb.append("            AND NVL(pso.codigo_embalagem, NULL) = 1 ");
    //  sb.append("          AND NVL(pso.codigo_embalagem, NULL) = nvl(fe.codigo, 1) ");
    //  sb.append("            AND i.codigo_corrugado = NVL(fe.codigo, 1) ");

    sb.append("            AND pso.numero = q.qtd_nume ");
    sb.append("            AND co.cor_cdgo = rc.cor_cdgo ");
    sb.append("            AND fl.lin_codigo = die.lin_cdgo ");
    sb.append("            AND fl.ref_codigo = DECODE(indicador, 1, 0, die.ref_cdgo) ");
    sb.append("            AND fl.ativa = 'S' ");
    sb.append("            AND f.emp_empresa = fl.cod_empresa ");
    sb.append("            AND f.fil_filial = fl.cod_filial ");
    sb.append(parametros.toString());

    if (f.getTipo_relatorio().equalsIgnoreCase("catalogo")) {
      sb.append("         AND cp.linha = die.lin_cdgo ");
      sb.append("         AND cp.referencia = die.ref_cdgo ");
      sb.append("         AND cp.cabedal = die.cab_cdgo ");
      sb.append("         AND cp.cor = co.cor_cdgo ");
      sb.append("         AND cp.status = 'A' ");
    }

    if (!f.getMix_produtos().equals("T")) {
      sb.append("         AND fct_mix_produto(r.lin_Cdgo, r.ref_cdgo) = '").append(f.getMix_produtos()).append("' ");
    }
    sb.append("         ) qry ");
    sb.append("  ORDER BY ped_nmro ");
    sb.append("         , lin_cdgo ");
    sb.append("         , ref_cdgo ");
    sb.append("         , cab_cdgo ");
    sb.append("         , cor_cdgo ");
    sb.append("         , qtp_nume ");

    session.removeAttribute("dados_tecnicos_produtos_consulta_por_pedido");
    if (f.getTipo_relatorio().equalsIgnoreCase("pedido")) {
      session.setAttribute("dados_tecnicos_produtos_consulta_por_pedido","S");
    }

    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      throw new Exception(sb.toString());
    }
    String arquivo = "";
    if (f.getGerar_planilha() != null) {
      session.setAttribute("gera_excel","S");
      util.consultas.ind.DadosTecnicosProdutos dadosTecnicos = new util.consultas.ind.DadosTecnicosProdutos ();
      if (tipoProduto || consultaFaturas) {
        arquivo = dadosTecnicos.geraExcelProduto(sb.toString(), "F");
      } else {
        arquivo = dadosTecnicos.geraExcelPedido(sb.toString());
      }
      if (arquivo.equals("")) {
        throw new Exception("Nenhum registro encontrado!");
      }
      request.setAttribute("abre_automaticamente","N");
      request.setAttribute("arquivo", arquivo);
      session.setAttribute("gera_excel","s");
    } else {
      Vector res_Jw_dados_tecnicos_produtos = j.select(table, sb.toString(), null);
      session.setAttribute("res_Jw_dados_tecnicos_produtos",res_Jw_dados_tecnicos_produtos);
      if (!(res_Jw_dados_tecnicos_produtos != null && res_Jw_dados_tecnicos_produtos.size() > 0)) {
        throw new Exception("Nenhum registro encontrado!");
      }
    }
    session.setAttribute("mapping.getName()", form);
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      DadosTecnicosProdutosActionForm f = (DadosTecnicosProdutosActionForm) form;
      session.removeAttribute("res_Jw_dados_tecnicos_produtos");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_dados_tecnicos_produtos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      DadosTecnicosProdutosActionForm f = (DadosTecnicosProdutosActionForm) form;
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_dados_tecnicos_produtos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
