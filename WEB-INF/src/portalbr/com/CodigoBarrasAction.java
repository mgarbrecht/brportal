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
 * Creation Date 06/06/2016 15:30:00
 * Last Modify Date 14/03/2023 11:27:46
 */

public class CodigoBarrasAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      CodigoBarrasActionForm f = (CodigoBarrasActionForm) form;
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/com/CodigoBarras_rForm.jsp", true);
      util.consultas.com.CodigoBarrasExcel codigoBarrasExcel = new util.consultas.com.CodigoBarrasExcel();
      String arquivo = null;
      session.removeAttribute("res_Jw_cod_barra_agrupar_modelo");
      if ((f.getAgrupar_modelo() + "").equals("checked")) {
        session.setAttribute("res_Jw_cod_barra_agrupar_modelo", "S");
      }
      if ((f.getGerarImagem() + "").equals("checked")) {
        arquivo = codigoBarrasExcel.geraExcel(f.getTipo(), session);
        request.setAttribute("abre_automaticamente", "N");
        request.setAttribute("arquivo", arquivo);
        actionForward = mapping.findForward("same");
      }

    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_cod_barra", new ActionMessage("error.action.exception", com.egen.util.system.Error.getMessage(e)));
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
    CodigoBarrasActionForm f = (CodigoBarrasActionForm) form;
    boolean informouCliente = false;
    boolean informouFatura = false;
    boolean informouFaturaAmostra = false;
    boolean informouPedido = false;
    boolean informouLote = false;
    boolean trazerPares = false;
    boolean trazerPrecos = false;
    boolean organizarPorLoja = false;
    boolean organizarPorProdutoGrade = false;
    session.removeAttribute("organizarPorProdutoGrade");
    session.removeAttribute("organizarPorLoja");
    session.removeAttribute("res_Jw_cod_barra");
    session.removeAttribute("res_Jw_cod_barra_dum14");
    session.removeAttribute("res_Jw_cod_barra_sscc");
    session.removeAttribute("res_Jw_cod_barra_ambos");
    session.removeAttribute("codigo_barras_exibe_numero_exterior");
    session.removeAttribute("codigo_barras_exibe_quantidade_pares");
    session.removeAttribute("codigo_barras_exibe_precos");
    session.removeAttribute("codigo_barras_informou_pedidos");

    acesso.Sessao sessao = new acesso.Sessao(session);

    if ((f.getTrazer_pares() + "").equals("1")) {
      trazerPares = true;
    }

    if ((f.getTrazer_precos() + "").equals("1")) {
      trazerPrecos = true;
    }

    String representante = null;
    String regional = null;

    if (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL") || sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO")) {
      representante = sessao.getChave();
    }

    if (sessao.getTipoEntidadeNegocio().equals("REGIONAL DE VENDA")) {
      regional = sessao.getChave();
    }

    if (f.getAno_fatura_proforma() != "" && f.getNumero_fatura_proforma() != "") {
      informouFatura = true;
      session.setAttribute("codigo_barras_exibe_numero_exterior", "S");
    }

    if (f.getAno_fatura_amostra() != "" && f.getNumero_fatura_amostra() != "") {
      informouFaturaAmostra = true;
    }

    if (informouFatura && trazerPares) {
      session.setAttribute("codigo_barras_exibe_quantidade_pares", "S");
    }

    if (informouFatura && trazerPrecos) {
      session.setAttribute("codigo_barras_exibe_precos", "S");
    }

    if (f.getCli_cdgo() != "") {
      informouCliente = true;
      session.setAttribute("codigo_barras_exibe_numero_exterior", "S");
    }

    String parametroPedidos = "";
    String parametroPedidosi = "";
    if (f.getPedido() != "") {
      informouPedido = true;
      String pedidos = f.getPedido().replaceAll("[^0-9]", " ").trim();
      pedidos = pedidos.replaceAll("\\s+", " ");
      pedidos = pedidos.replaceAll(" ", "\n");
      pedidos = pedidos.replaceAll("\\r\\n|\\r|\\n", ",");
      if ((pedidos.charAt(pedidos.length() - 1) + "").equalsIgnoreCase(",")) {
        pedidos = pedidos.substring(0, pedidos.lastIndexOf(","));
      }
      parametroPedidos = " AND ite.ped_nmro in (" + pedidos + ") ";
      parametroPedidosi = " AND i.ped_nmro in (" + pedidos + ") ";
    }

    if (f.getLote() != "") {
      informouLote = true;
      informouPedido = false;
      informouFatura = false;
      informouFaturaAmostra = false;
    }

    if ((informouPedido || informouFatura) && f.getOrganizar_loja().equals("S")) {
      organizarPorLoja = true;
      session.setAttribute("organizarPorLoja", "S");
    }

    if (f.getOrganizar_produto_grade().equals("S")) {
      organizarPorProdutoGrade = true;
      session.setAttribute("organizarPorProdutoGrade", "S");
    }

    if (f.getTipo().equalsIgnoreCase("ean13")) {

      if (informouPedido) {
        session.setAttribute("codigo_barras_informou_pedidos", "S");
      }

      portalbr.dbobj.view.Jw_cod_barra table = new portalbr.dbobj.view.Jw_cod_barra();
      if ((!(f.getCodigo_marca() != "")) && (!(f.getEan13() != "")) && (!(f.getLin_cdgo() != "")) && (!(f.getLote() != "")) && (!(f.getPedido() != "")) && (f.getAno_fatura_proforma().equals("") || f.getNumero_fatura_proforma().equals("")) && (f.getAno_fatura_amostra().equals("") || f.getNumero_fatura_amostra().equals(""))) {
        throw new Exception("Um dos campos com <img src='../img/opcional.gif' border='0'/> deve ser informado!");
      }

      StringBuilder sbq = new StringBuilder();
      StringBuilder sbp = new StringBuilder();
      if (informouLote) {
        sbq.append("   , cabedal ");
        sbq.append("   , brio.lote_estrategico l ");
        sbq.append("   , brio.lote_estrategico_item i ");
        sbq.append("   , brio.lote_estrategico_gde g ");
        sbp.append(" AND i.lin_cdgo = ref_cor.lin_cdgo ");
        sbp.append(" AND i.ref_cdgo = ref_cor.ref_cdgo ");
        sbp.append(" AND i.cab_cdgo = ref_cor.cab_cdgo ");
        sbp.append(" AND i.cor_cdgo = ref_cor.cor_cdgo ");
        sbp.append(" AND ref_bar.rfb_numero = g.qtp_nume ");
        sbp.append(" AND l.id_lote = ").append(f.getLote());
        sbp.append(" AND l.id_lote = i.id_lote ");
        sbp.append(" AND i.id_lote = g.id_lote ");
        sbp.append(" AND i.seq_item = g.seq_item ");
      } else if (informouPedido) {
        sbq.append("   , cabedal ");
        sbq.append("   , ite ");
        sbq.append("   , ped ");
        sbq.append("   , qtd_prg ");
        if (organizarPorLoja) {
          sbq.append("   , ite_distribuicao_cliente idc ");
        }
        sbp.append(" AND ite.lin_cdgo = ref_cor.lin_cdgo ");
        sbp.append(" AND ite.ref_cdgo = ref_cor.ref_cdgo ");
        sbp.append(" AND ite.cab_cdgo = ref_cor.cab_cdgo ");
        sbp.append(" AND ite.cor_cdgo = ref_cor.cor_cdgo ");
        sbp.append(parametroPedidos);
        sbp.append(" AND ped.ped_nmro = ite.ped_nmro ");
        sbp.append(" AND qtd_prg.ped_nmro = ite.ped_nmro ");
        sbp.append(" AND qtd_prg.ite_seqn = ite.ite_seqn ");
        sbp.append(" AND ref_bar.rfb_numero = qtd_prg.qtp_nume");
        if (organizarPorLoja) {
          sbp.append(" AND ite.ped_nmro = idc.ped_nmro");
          sbp.append(" AND ite.ite_seqn = idc.ite_seqn");
        }
        if (representante != null) {
          sbp.append(" AND pck_pedidos.get_rep(ped.ped_nmro) = '").append(representante).append("' ");
        }
        if (regional != null) {
          sbp.append(" AND pck_representante.get_regional(pck_pedidos.get_rep(ped.ped_nmro)) = ").append(regional);
        }
      } else if (informouFatura) {
        sbq.append("   , cabedal ");
        sbq.append("   , grades_itens_proformas gip ");
        sbq.append("   , itens_faturas_proformas i ");
        sbq.append("   , faturas_proformas fp ");
        sbq.append("   , corrugados corrug ");
        if (organizarPorLoja) {
          sbq.append("   , itens_dist_cli_faturas_prof idcfp ");
        }
        sbp.append(" AND i.empresa_fatura_proforma = '01' ");
        sbp.append(" AND corrug.codigo = i.codigo_corrugado ");
        sbp.append(" AND i.ano_fatura_proforma = ").append(f.getAno_fatura_proforma());
        sbp.append(" AND i.numero_fatura_proforma = ").append(f.getNumero_fatura_proforma());
        sbp.append(" AND (NVL(i.item_cancelado, 'N') = 'N' OR(fp.especie_fatura = 'A' AND i.flag_gerar_nova_fatura = 'S')) ");

        if (representante != null) {
          sbp.append(" AND fp.codigo_representante = '").append(representante).append("' ");
        }
        if (regional != null) {
          sbp.append(" AND pck_representante.get_regional(fp.codigo_representante) = ").append(regional);
        }
        sbp.append(" AND fp.empresa_fatura_proforma = i.empresa_fatura_proforma ");
        sbp.append(" AND fp.ano_fatura_proforma = i.ano_fatura_proforma ");
        sbp.append(" AND fp.numero_fatura_proforma = i.numero_fatura_proforma ");
        if (organizarPorLoja) {
          sbp.append(" AND i.empresa_fatura_proforma = idcfp.empresa_fatura_proforma ");
          sbp.append(" AND i.ano_fatura_proforma = idcfp.ano_fatura_proforma ");
          sbp.append(" AND i.numero_fatura_proforma = idcfp.numero_fatura_proforma ");
          sbp.append(" AND i.numero_item = idcfp.numero_item ");
        }
        sbp.append(" AND gip.empresa_fatura_proforma = i.empresa_fatura_proforma ");
        sbp.append(" AND gip.ano_fatura_proforma = i.ano_fatura_proforma ");
        sbp.append(" AND gip.numero_fatura_proforma = i.numero_fatura_proforma ");
        sbp.append(" AND gip.numero_item = i.numero_item ");
        sbp.append(" AND gip.numeracao_par = ref_bar.rfb_numero ");
        sbp.append(" AND i.codigo_linha = ref_bar.lin_cdgo ");
        sbp.append(" AND i.codigo_referencia = ref_bar.ref_cdgo ");
        sbp.append(" AND i.codigo_cabedal = ref_bar.cab_cdgo ");
        sbp.append(" AND i.codigo_cor = ref_bar.cor_cdgo ");
      } else if (informouFaturaAmostra) {
        sbq.append("   , cabedal ");
        sbq.append("   , itens_faturas_amostras i ");
        sbq.append("   , faturas_amostras fa ");
        sbp.append(" AND i.empresa_fatura_amostra = '01' ");
        sbp.append(" AND i.ano_fatura_amostra = ").append(f.getAno_fatura_amostra());
        sbp.append(" AND i.numero_fatura_amostra = ").append(f.getNumero_fatura_amostra());
        if (representante != null) {
          sbp.append(" AND fa.codigo_representante = '").append(representante).append("' ");
        }
        if (regional != null) {
          sbp.append(" AND pck_representante.get_regional(fa.codigo_representante) = ").append(regional);
        }
        sbp.append(" AND fa.empresa_fatura_amostra = i.empresa_fatura_amostra ");
        sbp.append(" AND fa.ano_fatura_amostra = i.ano_fatura_amostra ");
        sbp.append(" AND fa.numero_fatura_amostra = i.numero_fatura_amostra ");
        sbp.append(" AND i.codigo_linha = ref_bar.lin_cdgo ");
        sbp.append(" AND i.codigo_referencia = ref_bar.ref_cdgo ");
        sbp.append(" AND i.codigo_cabedal = ref_bar.cab_cdgo ");
        sbp.append(" AND i.codigo_cor = ref_bar.cor_cdgo ");
      } else {
        sbq.append("   , cabedal ");
      }

      if (f.getCodigo_marca() != "") {
        sbp.append(" AND mp.codigo_marca = ").append(f.getCodigo_marca());
      }
      if (f.getLin_cdgo() != "") {
        sbp.append(" AND ref_cor.lin_cdgo = ").append(f.getLin_cdgo());
      }
      if (f.getCod_refer() != "") {
        sbp.append(" AND ref_cor.ref_cdgo = ").append(f.getCod_refer());
      }
      if (f.getCabedal() != "") {
        sbp.append(" AND ref_cor.cab_cdgo = ").append(f.getCabedal());
      }
      if (f.getCor() != "") {
        sbp.append(" AND ref_cor.cor_cdgo = ").append(f.getCor());
      }
      if (f.getStatus() != "") {
        sbp.append(" AND ref_status = '").append(f.getStatus()).append("'");
      }

      StringBuilder sb = new StringBuilder();
      if (informouPedido || (informouFatura && (trazerPares || trazerPrecos))) {
        sb.append(" SELECT DISTINCT fct_mask_modelo(ref_bar.lin_cdgo, ref_bar.ref_cdgo) linha_ref ");
      } else {
        sb.append(" SELECT fct_mask_modelo(ref_bar.lin_cdgo, ref_bar.ref_cdgo) linha_ref ");
      }
      sb.append("       , ref_bar.lin_cdgo cod_linha ");
      sb.append("       , ref_bar.ref_cdgo cod_refer ");
      sb.append("       , ref_bar.cab_cdgo ");
      sb.append("       , ref_bar.cor_cdgo ");

      if (informouCliente) {
        sb.append("    , cabedal.cab_cdgo || ' - ' || fct_descricao_cabedal(ref_bar.lin_cdgo, ref_bar.ref_cdgo, ref_bar.cab_cdgo, null, ").append(f.getCli_cdgo()).append(") cabedal ");
      } else if (informouFatura) {
        sb.append("    , cabedal.cab_cdgo || ' - ' || fct_descricao_cabedal(ref_bar.lin_cdgo, ref_bar.ref_cdgo, ref_bar.cab_cdgo, null, fp.codigo_cliente) cabedal ");
      } else {
        sb.append("    , cabedal.cab_cdgo || ' - ' || cabedal.cab_desc cabedal ");
      }

      if (informouCliente) {
        sb.append("    , cor.cor_cdgo || ' - ' || fct_descricao_cor(cor.cor_cdgo, null, ").append(f.getCli_cdgo()).append(") cor ");
      } else if (informouFatura) {
        sb.append("    , cor.cor_cdgo || ' - ' || fct_descricao_cor(cor.cor_cdgo, null, fp.codigo_cliente) cor ");
      } else {
        sb.append("    , cor.cor_cdgo || ' - ' || cor_desc cor ");
      }

      sb.append("       , rfb_numero grade ");
      if (informouCliente) {
        sb.append("   , fct_retorna_ean13(ref_bar.lin_cdgo, ref_bar.ref_cdgo, ref_bar.cab_cdgo, ref_bar.cor_cdgo, rfb_numero, ").append(f.getCli_cdgo()).append(") || fct_calcula_digito_cod_barra(fct_retorna_ean13(ref_bar.lin_cdgo, ref_bar.ref_cdgo, ref_bar.cab_cdgo, ref_bar.cor_cdgo, rfb_numero, ").append(f.getCli_cdgo()).append(")) cod_barra ");
      } else if (informouPedido) {
        sb.append("   , fct_retorna_ean13(ref_bar.lin_cdgo, ref_bar.ref_cdgo, ref_bar.cab_cdgo, ref_bar.cor_cdgo, rfb_numero, ped.cli_cdgo) || fct_calcula_digito_cod_barra(fct_retorna_ean13(ref_bar.lin_cdgo, ref_bar.ref_cdgo, ref_bar.cab_cdgo, ref_bar.cor_cdgo, rfb_numero, ped.cli_cdgo)) cod_barra ");
      } else {
        sb.append("   , fct_retorna_cod_barra(ref_bar.lin_cdgo, ref_bar.ref_cdgo, ref_bar.cab_cdgo, ref_bar.cor_cdgo, rfb_numero) cod_barra ");
      }
      sb.append("       , ref_status status ");
      sb.append("       , mp.codigo_marca ");
      sb.append("       , mp.descricao_marca ");
      if (informouCliente) {
        sb.append("    , fct_descricao_cor(cor.cor_cdgo, null, ").append(f.getCli_cdgo()).append(") cor_desc ");
      } else if (informouFatura) {
        sb.append("   , fct_descricao_cor(cor.cor_cdgo, null, fp.codigo_cliente) cor_desc ");
      } else {
        sb.append("   , cor.cor_desc ");
      }

      if (informouCliente) {
        sb.append("    , fct_descricao_cabedal(ref_bar.lin_cdgo, ref_bar.ref_cdgo, ref_bar.cab_cdgo, null, ").append(f.getCli_cdgo()).append(") cab_desc ");
      } else if (informouFatura) {
        sb.append("    , fct_descricao_cabedal(ref_bar.lin_cdgo, ref_bar.ref_cdgo, ref_bar.cab_cdgo, null, fp.codigo_cliente) cab_desc ");
      } else {
        sb.append("    , cabedal.cab_desc cab_desc ");
      }
      if (informouCliente) {
        sb.append("    , fct_numero_exterior(").append(f.getCli_cdgo()).append(", 1, rfb_numero, ref.codigo_marca, ref_class_segmento) grade_ext ");
      } else if (informouFatura) {
        sb.append("    , fct_numero_exterior(fp.codigo_cliente, fp.estabelecimento_cliente, rfb_numero, ref.codigo_marca, ref_class_segmento) grade_ext ");
      } else {
        sb.append("    , '' grade_ext ");
      }

      if (organizarPorLoja) {
        if (informouPedido) {
          sb.append("    , idc.cliente loja ");
        } else if (informouFatura) {
          sb.append("    , idcfp.loja_do_cliente loja ");
        }
      }
      sb.append("       , ref.ref_desc ");
      sb.append("       , REPLACE(fct_retorna_fit_imagem(ref_bar.lin_cdgo, ref_bar.ref_cdgo, ref_bar.cab_cdgo, ref_bar.cor_cdgo),'.gif','.jpg') imagem");
      if ((informouFatura && trazerPares)) {
        sb.append("    , sum ((i.quantidade_pares / corrug.qt_par_corrug) * gip.quantidade_pares) over (partition by ref_bar.lin_cdgo, ref_bar.ref_cdgo, ref_bar.cab_cdgo, ref_bar.cor_cdgo, rfb_numero) pares ");
      }

      if ((informouFatura && trazerPrecos)) {
        sb.append("    , i.preco_unitario ");
      }

      if (f.getTipo().equalsIgnoreCase("ean13") && informouPedido) {
        sb.append("     , (SELECT SUM(q.pares) pares ");
        sb.append("             FROM (SELECT pp.ped_nmro, ");
        sb.append("                          ii.ite_seqn item_nmro, ");
        sb.append("                          ii.lin_cdgo, ");
        sb.append("                          ii.ref_cdgo, ");
        sb.append("                          ii.cab_cdgo, ");
        sb.append("                          ii.cor_cdgo, ");
        sb.append("                          ii.gde_cdgo grade, ");
        sb.append("                          q2.qtp_nume produto_tamanho, ");
        sb.append("                          (ite.ite_qtde / SUM(q2.qtp_pars) ");
        sb.append("                           OVER(PARTITION BY q2.ped_nmro, q2.ite_seqn) * ");
        sb.append("                           q2.qtp_pars) pares ");
        sb.append("                     FROM qtd_prg q2, ite ii, ped pp ");
        sb.append("                    WHERE pp.ped_nmro = ii.ped_nmro ");
        sb.append("                      AND ii.ped_nmro = q2.ped_nmro ");
        sb.append("                      and pp.ped_nmro = ped.ped_nmro ");
        sb.append("                      AND ii.ite_seqn = q2.ite_seqn ");
        sb.append("                      AND pp.ped_nmro = ii.ped_nmro) q ");
        sb.append("            WHERE q.produto_tamanho = qtd_prg.qtp_nume ");
        sb.append("              and q.lin_cdgo = ite.lin_cdgo ");
        sb.append("              and q.ref_cdgo = ite.ref_cdgo ");
        sb.append("              and q.cab_cdgo = ite.cab_cdgo ");
        sb.append("              and q.cor_cdgo = ite.cor_cdgo) pares_ean13 ");
      }

      sb.append("    FROM ref_bar ");
      sb.append(sbq.toString());
      sb.append("       , cor ");
      sb.append("       , ref_cor ");
      sb.append("       , ref ");
      sb.append("       , marcas_produtos mp ");
      sb.append("   WHERE ref_bar.cab_cdgo = cabedal.cab_cdgo ");
      sb.append("     AND ref_bar.cor_cdgo = cor.cor_cdgo ");
      sb.append("     AND ref_bar.lin_cdgo = ref_cor.lin_cdgo ");
      sb.append("     AND ref_bar.ref_cdgo = ref_cor.ref_cdgo ");
      sb.append("     AND ref_bar.cab_cdgo = ref_cor.cab_cdgo ");
      sb.append("     AND ref_bar.cor_cdgo = ref_cor.cor_cdgo ");

      if (f.getEan13() != "") {
        if (f.getEan13().length() == 13) {
          sb.append(" AND NVL(ativo, NULL) IS NULL ");
          sb.append(" AND cod_ean = SUBSTR('").append(f.getEan13()).append("', 4, 4) ");
          sb.append(" AND rfb_barra = SUBSTR('").append(f.getEan13()).append("', 8, 5) ");
          sb.append(" AND ref_bar.tipo = 'I' ");
        } else if (f.getEan13().length() == 14) {
          sb.append(" AND NVL(ativo, NULL) IS NULL ");
          sb.append(" AND NVL(var_logistica, NULL) = SUBSTR('").append(f.getEan13()).append("', 1, 1) ");
          sb.append(" AND cod_ean = SUBSTR('").append(f.getEan13()).append("', 5, 4) ");
          sb.append(" AND rfb_barra = SUBSTR('").append(f.getEan13()).append("', 9, 5) ");
        } else {
          sb.append(" AND 1=2 ");
        }

      }


      sb.append("     AND ref_bar.lin_cdgo = ref.lin_cdgo ");
      sb.append("     AND ref_bar.ref_cdgo = ref.ref_cdgo ");
      sb.append("     AND ref.codigo_marca = mp.codigo_marca ");
      sb.append("     AND NVL(ref_bar.ativo, NULL) IS NULL ");
      sb.append("     AND var_logistica IS NULL ");
      sb.append(sbp.toString());

      System.out.println();

      if (organizarPorLoja) {
        if (informouPedido) {
          sb.append("  ORDER BY idc.cliente ");
          sb.append("           , ref_bar.lin_cdgo ");
          sb.append("           , ref_bar.ref_cdgo ");
          sb.append("           , ref_bar.cab_cdgo ");
          sb.append("           , ref_bar.cor_cdgo ");
          sb.append("           , rfb_numero ");
        } else if (informouFatura) {
          sb.append("  ORDER BY idcfp.loja_do_cliente ");
          sb.append("           , ref_bar.lin_cdgo ");
          sb.append("           , ref_bar.ref_cdgo ");
          sb.append("           , ref_bar.cab_cdgo ");
          sb.append("           , ref_bar.cor_cdgo ");
          sb.append("           , rfb_numero ");
        }
      } else if (organizarPorProdutoGrade) {
        sb.append("  ORDER BY ref_bar.lin_cdgo ");
        sb.append("           , ref_bar.ref_cdgo ");
        sb.append("           , ref_bar.cab_cdgo ");
        sb.append("           , ref_bar.cor_cdgo ");
        sb.append("           , TO_NUMBER(regexp_substr(rfb_numero, '[[:digit:]]+', 1, 1)) ");

      }

      acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
      if (usuario.mostraQuery()) {
        throw new Exception(sb.toString());
      }

      Vector res_Jw_cod_barra = j.select(table, sb.toString(), null);
      session.setAttribute("res_Jw_cod_barra", res_Jw_cod_barra);
      if (!(res_Jw_cod_barra != null && res_Jw_cod_barra.size() > 0)) {
        throw new Exception(java.util.ResourceBundle.getBundle("ComercialResources").getString("CodigoBarra.erro.nenhum.registro"));
      }

    } else if (f.getTipo().equalsIgnoreCase("dun14")) {

      portalbr.dbobj.view.Jw_cod_barra_dum14 table = new portalbr.dbobj.view.Jw_cod_barra_dum14();
      if (f.getPedido().equals("") && f.getLin_cdgo().equals("") && (f.getAno_fatura_proforma().equals("") || f.getNumero_fatura_proforma().equals("")) && (f.getAno_fatura_amostra().equals("") || f.getNumero_fatura_amostra().equals(""))) {
        throw new Exception("Um dos campos com <img src='../img/opcional.gif' border='0'/> deve ser informado!");
      }
      acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");

      StringBuilder sbq = new StringBuilder();
      StringBuilder sbp = new StringBuilder();
      if (informouPedido) {
        sbq.append("  , cabedal ");
        sbq.append("  , ite ");
        sbq.append("  , ped ");
        if (organizarPorLoja) {
          sbq.append("   , ite_distribuicao_cliente idc ");
        }
        sbp.append(" AND ite.lin_cdgo = ref_cor.lin_cdgo ");
        sbp.append(" AND ite.ref_cdgo = ref_cor.ref_cdgo ");
        sbp.append(" AND ite.cab_cdgo = ref_cor.cab_cdgo ");
        sbp.append(" AND ite.cor_cdgo = ref_cor.cor_cdgo ");
        sbp.append(parametroPedidos);
        sbp.append(" AND ped.ped_nmro = ite.ped_nmro ");
        if (organizarPorLoja) {
          sbp.append(" AND ite.ped_nmro = idc.ped_nmro");
          sbp.append(" AND ite.ite_seqn = idc.ite_seqn");
        }
        if (representante != null) {
          sbp.append(" AND pck_pedidos.get_rep(ped.ped_nmro) = '").append(representante).append("' ");
        }
        if (regional != null) {
          sbp.append(" AND pck_representante.get_regional(pck_pedidos.get_rep(ped.ped_nmro)) = ").append(regional);
        }

      } else if (informouFatura) {
        sbq.append("   , cabedal ");
        sbq.append("   , itens_faturas_proformas i ");
        sbq.append("   , faturas_proformas fp ");
        if (organizarPorLoja) {
          sbq.append("   , itens_dist_cli_faturas_prof idcfp ");
        }
        sbp.append(" AND i.empresa_fatura_proforma = '01' ");
        sbp.append(" AND i.ano_fatura_proforma = ").append(f.getAno_fatura_proforma());
        sbp.append(" AND i.numero_fatura_proforma = ").append(f.getNumero_fatura_proforma());
        sbp.append(" AND (NVL(i.item_cancelado, 'N') = 'N' OR(fp.especie_fatura = 'A' AND i.flag_gerar_nova_fatura = 'S')) ");
        if (representante != null) {
          sbp.append(" AND fp.codigo_representante = '").append(representante).append("' ");
        }
        if (regional != null) {
          sbp.append(" AND pck_representante.get_regional(fp.codigo_representante) = ").append(regional);
        }
        sbp.append(" AND fp.empresa_fatura_proforma = i.empresa_fatura_proforma ");
        sbp.append(" AND fp.ano_fatura_proforma = i.ano_fatura_proforma ");
        sbp.append(" AND fp.numero_fatura_proforma = i.numero_fatura_proforma ");
        if (organizarPorLoja) {
          sbp.append(" AND i.empresa_fatura_proforma = idcfp.empresa_fatura_proforma ");
          sbp.append(" AND i.ano_fatura_proforma = idcfp.ano_fatura_proforma ");
          sbp.append(" AND i.numero_fatura_proforma = idcfp.numero_fatura_proforma ");
          sbp.append(" AND i.numero_item = idcfp.numero_item ");
        }
        sbp.append(" AND i.codigo_linha = ref_bar.lin_cdgo ");
        sbp.append(" AND i.codigo_referencia = ref_bar.ref_cdgo ");
        sbp.append(" AND i.codigo_cabedal = ref_bar.cab_cdgo ");
        sbp.append(" AND i.codigo_cor = ref_bar.cor_cdgo ");
      } else if (informouFaturaAmostra) {
        sbq.append("   , cabedal ");
        sbq.append("   , itens_faturas_amostras i ");
        sbq.append("   , faturas_amostras fa ");
        sbp.append(" AND i.empresa_fatura_amostra = '01' ");
        sbp.append(" AND i.ano_fatura_amostra = ").append(f.getAno_fatura_amostra());
        sbp.append(" AND i.numero_fatura_amostra = ").append(f.getNumero_fatura_amostra());
        if (representante != null) {
          sbp.append(" AND fa.codigo_representante = '").append(representante).append("' ");
        }
        if (regional != null) {
          sbp.append(" AND pck_representante.get_regional(fa.codigo_representante) = ").append(regional);
        }
        sbp.append(" AND fa.empresa_fatura_amostra = i.empresa_fatura_amostra ");
        sbp.append(" AND fa.ano_fatura_amostra = i.ano_fatura_amostra ");
        sbp.append(" AND fa.numero_fatura_amostra = i.numero_fatura_amostra ");
        sbp.append(" AND i.codigo_linha = ref_bar.lin_cdgo ");
        sbp.append(" AND i.codigo_referencia = ref_bar.ref_cdgo ");
        sbp.append(" AND i.codigo_cabedal = ref_bar.cab_cdgo ");
        sbp.append(" AND i.codigo_cor = ref_bar.cor_cdgo ");
      } else {
        sbq.append("   , cabedal ");
      }

      if (f.getLin_cdgo() != "") {
        sbp.append(" AND ref_cor.lin_cdgo = ").append(f.getLin_cdgo());
      }
      if (f.getCod_refer() != "") {
        sbp.append(" AND ref_cor.ref_cdgo = ").append(f.getCod_refer());
      }
      if (f.getCabedal() != "") {
        sbp.append(" AND ref_cor.cab_cdgo = ").append(f.getCabedal());
      }
      if (f.getCor() != "") {
        sbp.append(" AND ref_cor.cor_cdgo = ").append(f.getCor());
      }
      if (f.getGrade() != "") {
        sbp.append(" AND ref_bar.gde_cdgo  = ").append(f.getGrade());
      }
      if (f.getStatus() != "") {
        sbp.append(" AND ref_status = '").append(f.getStatus()).append("'");
      }

      StringBuilder sb = new StringBuilder();
      sb.append(" SELECT DISTINCT fct_mask_modelo(ref_bar.lin_cdgo, ref_bar.ref_cdgo) linha_ref ");
      sb.append("      , ref_bar.lin_cdgo cod_linha ");
      sb.append("      , ref_bar.ref_cdgo cod_refer ");

      if (informouCliente) {
        sb.append("   , cabedal.cab_cdgo || ' - ' || fct_descricao_cabedal(ref_bar.lin_cdgo, ref_bar.ref_cdgo, ref_bar.cab_cdgo, null, ").append(f.getCli_cdgo()).append(") cabedal ");
      } else if (informouFatura) {
        sb.append("   , cabedal.cab_cdgo || ' - ' || fct_descricao_cabedal(ref_bar.lin_cdgo, ref_bar.ref_cdgo, ref_bar.cab_cdgo, null, fp.codigo_cliente) cabedal ");
      } else {
        sb.append("   , cabedal.cab_cdgo || ' - ' || cabedal.cab_desc cabedal ");
      }

      if (informouCliente) {
        sb.append("   , fct_descricao_cor(cor.cor_cdgo, null, ").append(f.getCli_cdgo()).append(") cor ");
      } else {
        sb.append("   , cor_desc cor ");
      }
      sb.append("      , ref_bar.gde_cdgo ");
      sb.append("      , qtde_pares qtd_pares ");
      sb.append("      , to_char(codigo_barra_dum14) cod_dum14 ");
      sb.append("      , ref_status status ");
      sb.append("      , ref_bar.cab_cdgo ");
      sb.append("      , ref_bar.cor_cdgo ");

      if (organizarPorLoja) {
        if (informouPedido) {
          sb.append("    , idc.cliente loja ");
        } else if (informouFatura) {
          sb.append("    , idcfp.loja_do_cliente loja ");
        }
      }
      sb.append("      , ref.ref_desc ");
      sb.append("      ,REPLACE(fct_retorna_fit_imagem(ref_bar.lin_cdgo, ref_bar.ref_cdgo, ref_bar.cab_cdgo, ref_bar.cor_cdgo),'.gif','.jpg') imagem");
      if ((informouFatura && trazerPrecos)) {
        sb.append("    , i.preco_unitario ");
      }
      sb.append("   FROM ref_bar ");
      sb.append(sbq.toString());
      sb.append("      , cor ");
      sb.append("      , ref_cor ");
      sb.append("      , ref ");
      sb.append("  WHERE ref_bar.cab_cdgo = cabedal.cab_cdgo ");
      sb.append("    AND ref_bar.cor_cdgo = cor.cor_cdgo ");
      sb.append("    AND ref_bar.lin_cdgo = ref_cor.lin_cdgo ");
      sb.append("    AND ref_bar.ref_cdgo = ref_cor.ref_cdgo ");
      sb.append("    AND ref_bar.cab_cdgo = ref_cor.cab_cdgo ");
      sb.append("    AND ref_bar.cor_cdgo = ref_cor.cor_cdgo ");
      sb.append("    AND ref_bar.lin_cdgo = ref.lin_cdgo ");
      sb.append("    AND ref_bar.ref_cdgo = ref.ref_cdgo ");
      sb.append("    AND NVL(ref_bar.ativo, NULL) IS NULL ");
      sb.append("    AND var_logistica IS NOT NULL ");
      sb.append("    AND ref_bar.rfb_numero = '0' ");
      sb.append(sbp.toString());

      if (organizarPorLoja) {
        if (informouPedido) {
          sb.append("  ORDER BY idc.cliente ");
          sb.append("           , ref_bar.lin_cdgo ");
          sb.append("           , ref_bar.ref_cdgo ");
          sb.append("           , ref_bar.cab_cdgo ");
          sb.append("           , ref_bar.cor_cdgo ");
        } else if (informouFatura) {
          sb.append("  ORDER BY idcfp.loja_do_cliente ");
          sb.append("           , ref_bar.lin_cdgo ");
          sb.append("           , ref_bar.ref_cdgo ");
          sb.append("           , ref_bar.cab_cdgo ");
          sb.append("           , ref_bar.cor_cdgo ");
        }
      } else if (organizarPorProdutoGrade) {
        sb.append("  ORDER BY ref_bar.lin_cdgo ");
        sb.append("           , ref_bar.ref_cdgo ");
        sb.append("           , ref_bar.cab_cdgo ");
        sb.append("           , ref_bar.cor_cdgo ");

      }

      if (usuario.mostraQuery()) {
        throw new Exception(sb.toString());
      }

      Vector res_Jw_cod_barra_dum14 = j.select(table, sb.toString(), null);
      session.setAttribute("res_Jw_cod_barra_dum14", res_Jw_cod_barra_dum14);

      if (!(res_Jw_cod_barra_dum14 != null && res_Jw_cod_barra_dum14.size() > 0)) {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        throw new Exception(java.util.ResourceBundle.getBundle("ComercialResources").getString("CodigoBarraDun14.erro.nenhum.registro"));

      }

    } else if (f.getTipo().equalsIgnoreCase("sscc")) {

      portalbr.dbobj.view.Jw_cod_barra_sscc table = new portalbr.dbobj.view.Jw_cod_barra_sscc();
      if (f.getPedido().equals("") && (f.getAno_fatura_proforma().equals("") || f.getNumero_fatura_proforma().equals(""))) {
        throw new Exception("Um dos campos com <img src='../img/opcional.gif' border='0'/> deve ser informado!");
      }
      acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");

      StringBuilder sbq = new StringBuilder();
      StringBuilder sbp = new StringBuilder();
      if (informouPedido) {
        if (organizarPorLoja) {
          sbq.append("   , ite_distribuicao_cliente idc ");
        }
        sbp.append(parametroPedidosi);
        if (organizarPorLoja) {
          sbp.append(" AND i.ped_nmro = idc.ped_nmro");
          sbp.append(" AND i.ite_seqn = idc.ite_seqn");
        }
        if (representante != null) {
          sbp.append(" AND pck_pedidos.get_rep(ped.ped_nmro) = '").append(representante).append("' ");
        }
        if (regional != null) {
          sbp.append(" AND pck_representante.get_regional(pck_pedidos.get_rep(ped.ped_nmro)) = ").append(regional);
        }
      } else if (informouFatura) {
        sbq.append("  , itens_faturas_proformas ifp ");
        sbq.append("  , faturas_proformas fp ");
        if (organizarPorLoja) {
          sbq.append("   , itens_dist_cli_faturas_prof idcfp ");
        }
        sbp.append(" AND i.empresa_fatura_proforma = ifp.empresa_fatura_proforma ");
        sbp.append(" AND i.ano_fatura_proforma = ifp.ano_fatura_proforma ");
        sbp.append(" AND i.numero_item_fatura_proforma = ifp.numero_item ");
        if (representante != null) {
          sbp.append(" AND fp.codigo_representante = '").append(representante).append("' ");
        }
        if (regional != null) {
          sbp.append(" AND pck_representante.get_regional(fp.codigo_representante) = ").append(regional);
        }
        sbp.append(" AND i.numero_fatura_proforma = ifp.numero_fatura_proforma ");
        sbp.append(" AND fp.empresa_fatura_proforma = ifp.empresa_fatura_proforma ");
        sbp.append(" AND fp.ano_fatura_proforma = ifp.ano_fatura_proforma ");
        sbp.append(" AND fp.numero_fatura_proforma = ifp.numero_fatura_proforma ");
        sbp.append(" AND (NVL(ifp.item_cancelado, 'N') = 'N' OR(fp.especie_fatura = 'A' AND ifp.flag_gerar_nova_fatura = 'S')) ");
        if (organizarPorLoja) {
          sbp.append(" AND i.empresa_fatura_proforma = idcfp.empresa_fatura_proforma ");
          sbp.append(" AND i.ano_fatura_proforma = idcfp.ano_fatura_proforma ");
          sbp.append(" AND i.numero_fatura_proforma = idcfp.numero_fatura_proforma ");
          sbp.append(" AND i.numero_item_fatura_proforma = idcfp.numero_item ");
        }
        sbp.append(" AND ifp.empresa_fatura_proforma = '01' ");
        sbp.append(" AND ifp.ano_fatura_proforma = ").append(f.getAno_fatura_proforma());
        sbp.append(" AND ifp.numero_fatura_proforma = ").append(f.getNumero_fatura_proforma());
        sbp.append(" AND (NVL(ifp.item_cancelado, 'N') = 'N' OR(fp.especie_fatura = 'A' AND ifp.flag_gerar_nova_fatura = 'S')) ");
      }

      StringBuilder sb = new StringBuilder();
      sb.append(" SELECT /*+ all_rows */ ");
      sb.append("        mp.codigo_marca ");
      sb.append("      , mp.descricao_marca ");
      sb.append("      , fct_mask_modelo(r.lin_cdgo, r.ref_cdgo) linha_ref ");
      sb.append("      , r.lin_cdgo ");
      sb.append("      , r.ref_cdgo ");
      sb.append("      , cab.cab_cdgo ");
      sb.append("      , co.cor_cdgo ");

      if (informouCliente) {
        sb.append("   , fct_descricao_cabedal(r.lin_cdgo, r.ref_cdgo, cab.cab_cdgo, null, ").append(f.getCli_cdgo()).append(") cab_desc ");
        sb.append("   , fct_descricao_cor(co.cor_cdgo, null, ").append(f.getCli_cdgo()).append(") cor_desc ");
      } else if (informouFatura) {
        sb.append("   , fct_descricao_cabedal(r.lin_cdgo, r.ref_cdgo, cab.cab_cdgo, null, fp.codigo_cliente) cab_desc ");
        sb.append("   , fct_descricao_cor(co.cor_cdgo, null, fp.codigo_cliente) cor_desc ");
      } else {
        sb.append("   , cab.cab_desc cab_desc ");
        sb.append("   , co.cor_desc ");
      }

      if (organizarPorLoja) {
        if (informouPedido) {
          sb.append("    , idc.cliente loja ");
        } else if (informouFatura) {
          sb.append("    , idcfp.loja_do_cliente loja ");
        }
      }

      sb.append("      , q.qtt_nume numero ");
      sb.append("      , q.qtt_nume_exp numero_externo ");
      sb.append("      , q.qtt_pars qtd_pares ");
      sb.append("      , DECODE(rr.tipo_geracao, 'P', 'P' || LPAD(rr.ped_nmro, 8, 0) || ");
      sb.append("                LPAD(rr.seq_rotulo_ped, 4, 0) || ");
      sb.append("                LPAD(rr.id_versao, 6, 0), 'R', 'R' || LPAD(rr.rem_nro, 8, 0) || ");
      sb.append("                LPAD(rr.seq_rotulo, 4, 0) || ");
      sb.append("                LPAD(rr.id_versao, 6, 0), 'E', 'E' || LPAD(rr.rem_nro, 8, 0) || ");
      sb.append("                LPAD(rr.seq_rotulo, 4, 0) || ");
      sb.append("                LPAD(rr.id_versao, 6, 0), 'A', 'A' || LPAD(rr.ped_nmro, 8, 0) || ");
      sb.append("                LPAD(rr.seq_rotulo_ped, 4, 0) || ");
      sb.append("                LPAD(rr.id_versao, 6, 0)) sscc ");
      sb.append("      , DECODE(ref_status, 'I', 'I', 'A', 'A', 'I') status ");
      sb.append("      , r.ref_desc ");
      sb.append("   FROM rotulos_remessa     rr ");
      sb.append("      , ite                 i ");
      sb.append("      , ped                 ped ");
      sb.append(sbq.toString());
      sb.append("      , ref                 r ");
      sb.append("      , cabedal             cab ");
      sb.append("      , cor                 co ");
      sb.append("      , marcas_produtos     mp ");
      sb.append("      , qtd_rotulos_remessa q ");
      sb.append("  WHERE rr.ped_nmro = i.ped_nmro ");
      sb.append("    AND rr.ite_seqn = i.ite_seqn ");
      sb.append("    AND i.ped_nmro = ped.ped_nmro ");
      sb.append("    AND i.lin_cdgo = r.lin_cdgo ");
      sb.append("    AND i.ref_cdgo = r.ref_cdgo ");
      sb.append("    AND i.cab_cdgo = cab.cab_cdgo ");
      sb.append(sbp.toString());
      sb.append("    AND cab.cab_cdgo = i.cab_cdgo ");
      sb.append("    AND co.cor_cdgo = i.cor_cdgo ");
      sb.append("    AND mp.codigo_marca = r.codigo_marca ");
      sb.append("    AND q.rem_nro = rr.rem_nro ");
      sb.append("    AND q.rotulo = rr.rotulo ");
      sb.append("    AND q.ped_nmro = rr.ped_nmro ");
      sb.append("    AND q.ite_seqn = rr.ite_seqn ");

      if (f.getLin_cdgo() != "") {
        sb.append(" AND r.lin_cdgo = ").append(f.getLin_cdgo());
      }
      if (f.getCod_refer() != "") {
        sb.append(" AND r.ref_cdgo = ").append(f.getCod_refer());
      }
      if (f.getCabedal() != "") {
        sb.append(" AND cab.cab_cdgo = ").append(f.getCabedal());
      }
      if (f.getCor() != "") {
        sb.append(" AND co.cor_cdgo = ").append(f.getCor());
      }
      if (f.getStatus() != "") {
        sb.append(" AND ref_status = '").append(f.getStatus()).append("'");
      }

      if (organizarPorLoja) {
        if (informouPedido) {
          sb.append("  ORDER BY idc.cliente ");
          sb.append("           , r.lin_cdgo ");
          sb.append("           , r.ref_cdgo ");
          sb.append("           , cab.cab_cdgo ");
          sb.append("           , co.cor_cdgo ");
          sb.append("           , q.qtt_nume ");
        } else if (informouFatura) {
          sb.append("  ORDER BY idcfp.loja_do_cliente ");
          sb.append("           , r.lin_cdgo ");
          sb.append("           , r.ref_cdgo ");
          sb.append("           , cab.cab_cdgo ");
          sb.append("           , co.cor_cdgo ");
          sb.append("           , q.qtt_nume ");
        }
      } else if (organizarPorProdutoGrade) {
        sb.append("  ORDER BY r.lin_cdgo ");
        sb.append("           , r.ref_cdgo ");
        sb.append("           , cab.cab_cdgo ");
        sb.append("           , co.cor_cdgo ");
        sb.append("           , TO_NUMBER(regexp_substr(q.qtt_nume, '[[:digit:]]+', 1, 1)) ");
      }

      if (usuario.mostraQuery()) {
        throw new Exception(sb.toString());
      }

      Vector res_Jw_cod_barra_sscc = j.select(table, sb.toString(), null);
      session.setAttribute("res_Jw_cod_barra_sscc", res_Jw_cod_barra_sscc);

      if (!(res_Jw_cod_barra_sscc != null && res_Jw_cod_barra_sscc.size() > 0)) {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        throw new Exception(java.util.ResourceBundle.getBundle("ComercialResources").getString("CodigoBarraDun14.erro.nenhum.registro"));
      }

    } else {
      // Ambos

      portalbr.dbobj.view.Jw_cod_barra_ambos table = new portalbr.dbobj.view.Jw_cod_barra_ambos();
      if (f.getPedido().equals("") && f.getLin_cdgo().equals("") && (f.getAno_fatura_proforma().equals("") || f.getNumero_fatura_proforma().equals("")) && (f.getAno_fatura_amostra().equals("") || f.getNumero_fatura_amostra().equals(""))) {
        throw new Exception("Um dos campos com <img src='../img/opcional.gif' border='0'/> deve ser informado!");
      }
      acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");

      StringBuilder sbq = new StringBuilder();
      StringBuilder sbp = new StringBuilder();
      if (informouPedido) {
        sbq.append("  , cabedal ");
        sbq.append("  , ite  ");
        sbq.append("  , ped ");
        if (organizarPorLoja) {
          sbq.append("   , ite_distribuicao_cliente idc ");
        }
        sbp.append(" AND ite.lin_cdgo = ref_cor.lin_cdgo ");
        sbp.append(" AND ite.ref_cdgo = ref_cor.ref_cdgo ");
        sbp.append(" AND ite.cab_cdgo = ref_cor.cab_cdgo ");
        sbp.append(" AND ite.cor_cdgo = ref_cor.cor_cdgo ");
        sbp.append(parametroPedidos);
        sbp.append(" AND ite.ped_nmro = ped.ped_nmro ");
        if (organizarPorLoja) {
          sbp.append(" AND ite.ped_nmro = idc.ped_nmro");
          sbp.append(" AND ite.ite_seqn = idc.ite_seqn");
        }
        if (representante != null) {
          sbp.append(" AND pck_pedidos.get_rep(ped.ped_nmro) = '").append(representante).append("' ");
        }
        if (regional != null) {
          sbp.append(" AND pck_representante.get_regional(pck_pedidos.get_rep(ped.ped_nmro)) = ").append(regional);
        }
      } else if (informouFatura) {
        sbq.append("   , cabedal ");
        sbq.append("   , itens_faturas_proformas i ");
        sbq.append("   , faturas_proformas fp ");
        if (organizarPorLoja) {
          sbq.append("   , itens_dist_cli_faturas_prof idcfp ");
        }
        sbp.append(" AND i.empresa_fatura_proforma = '01' ");
        sbp.append(" AND i.ano_fatura_proforma = ").append(f.getAno_fatura_proforma());
        sbp.append(" AND i.numero_fatura_proforma = ").append(f.getNumero_fatura_proforma());
        sbp.append(" AND (NVL(i.item_cancelado, 'N') = 'N' OR(fp.especie_fatura = 'A' AND i.flag_gerar_nova_fatura = 'S')) ");
        if (representante != null) {
          sbp.append(" AND fp.codigo_representante = '").append(representante).append("' ");
        }
        if (regional != null) {
          sbp.append(" AND pck_representante.get_regional(fp.codigo_representante) = ").append(regional);
        }
        sbp.append(" AND fp.empresa_fatura_proforma = i.empresa_fatura_proforma ");
        sbp.append(" AND fp.ano_fatura_proforma = i.ano_fatura_proforma ");
        sbp.append(" AND fp.numero_fatura_proforma = i.numero_fatura_proforma ");
        if (organizarPorLoja) {
          sbp.append(" AND i.empresa_fatura_proforma = idcfp.empresa_fatura_proforma ");
          sbp.append(" AND i.ano_fatura_proforma = idcfp.ano_fatura_proforma ");
          sbp.append(" AND i.numero_fatura_proforma = idcfp.numero_fatura_proforma ");
          sbp.append(" AND i.numero_item = idcfp.numero_item ");
        }
        sbp.append(" AND i.codigo_linha = ref_bar.lin_cdgo ");
        sbp.append(" AND i.codigo_referencia = ref_bar.ref_cdgo ");
        sbp.append(" AND i.codigo_cabedal = ref_bar.cab_cdgo ");
        sbp.append(" AND i.codigo_cor = ref_bar.cor_cdgo ");
      } else if (informouFaturaAmostra) {
        sbq.append("   , cabedal ");
        sbq.append("   , itens_faturas_amostras i ");
        sbq.append("   , faturas_amostras fa ");
        sbp.append(" AND i.empresa_fatura_amostra = '01' ");
        sbp.append(" AND i.ano_fatura_amostra = ").append(f.getAno_fatura_amostra());
        sbp.append(" AND i.numero_fatura_amostra = ").append(f.getNumero_fatura_amostra());
        if (representante != null) {
          sbp.append(" AND fa.codigo_representante = '").append(representante).append("' ");
        }
        if (regional != null) {
          sbp.append(" AND pck_representante.get_regional(fa.codigo_representante) = ").append(regional);
        }
        sbp.append(" AND fa.empresa_fatura_amostra = i.empresa_fatura_amostra ");
        sbp.append(" AND fa.ano_fatura_amostra = i.ano_fatura_amostra ");
        sbp.append(" AND fa.numero_fatura_amostra = i.numero_fatura_amostra ");
        sbp.append(" AND i.codigo_linha = ref_bar.lin_cdgo ");
        sbp.append(" AND i.codigo_referencia = ref_bar.ref_cdgo ");
        sbp.append(" AND i.codigo_cabedal = ref_bar.cab_cdgo ");
        sbp.append(" AND i.codigo_cor = ref_bar.cor_cdgo ");
      } else {
        sbq.append("   , cabedal ");
      }

      if (f.getLin_cdgo() != "") {
        sbp.append(" AND ref_cor.lin_cdgo = ").append(f.getLin_cdgo());
      }
      if (f.getCod_refer() != "") {
        sbp.append(" AND ref_cor.ref_cdgo = ").append(f.getCod_refer());
      }
      if (f.getCabedal() != "") {
        sbp.append(" AND ref_cor.cab_cdgo = ").append(f.getCabedal());
      }
      if (f.getCor() != "") {
        sbp.append(" AND ref_cor.cor_cdgo = ").append(f.getCor());
      }
      if (f.getGrade() != "") {
        sbp.append(" AND ref_bar.gde_cdgo  = ").append(f.getGrade());
      }
      if (f.getStatus() != "") {
        sbp.append(" AND ref_status = '").append(f.getStatus()).append("'");
      }
      StringBuilder sb = new StringBuilder();
      if (organizarPorLoja) {
        sb.append("  SELECT * FROM ( ");
      }
      sb.append("  SELECT /*+ all_rows */ ");
      sb.append("        DISTINCT mp.codigo_marca ");
      sb.append("      , mp.descricao_marca ");
      sb.append("      , fct_mask_modelo(ref_bar.lin_cdgo, ref_bar.ref_cdgo) linha_ref ");
      sb.append("      , ref_bar.lin_cdgo ");
      sb.append("      , ref_bar.ref_cdgo ");
      sb.append("      , ref_bar.cab_cdgo ");
      sb.append("      , ref_bar.cor_cdgo ");

      if (informouCliente) {
        sb.append("   , fct_descricao_cabedal(ref_bar.lin_cdgo, ref_bar.ref_cdgo, ref_bar.cab_cdgo, null, ").append(f.getCli_cdgo()).append(") cabedal ");
      } else if (informouFatura) {
        sb.append("   , fct_descricao_cabedal(ref_bar.lin_cdgo, ref_bar.ref_cdgo, ref_bar.cab_cdgo, null, fp.codigo_cliente) cabedal ");
      } else {
        sb.append("   , cabedal.cab_desc cabedal ");
      }

      sb.append("      , cor.cor_desc cor ");
      sb.append("      , rfb_numero numero ");

      if (informouCliente) {
        sb.append("  , fct_retorna_ean13(ref_bar.lin_cdgo, ref_bar.ref_cdgo, ref_bar.cab_cdgo, ref_bar.cor_cdgo, rfb_numero, ").append(f.getCli_cdgo()).append(") || fct_calcula_digito_cod_barra(fct_retorna_ean13(ref_bar.lin_cdgo, ref_bar.ref_cdgo, ref_bar.cab_cdgo, ref_bar.cor_cdgo, rfb_numero, ").append(f.getCli_cdgo()).append(")) ean13");
      } else if (informouPedido) {
        sb.append("  , fct_retorna_ean13(ref_bar.lin_cdgo, ref_bar.ref_cdgo, ref_bar.cab_cdgo, ref_bar.cor_cdgo, rfb_numero, ped.cli_cdgo) || fct_calcula_digito_cod_barra(fct_retorna_ean13(ref_bar.lin_cdgo, ref_bar.ref_cdgo, ref_bar.cab_cdgo, ref_bar.cor_cdgo, rfb_numero, ped.cli_cdgo)) ean13");
      } else {
        sb.append("  , fct_retorna_cod_barra(ref_bar.lin_cdgo, ref_bar.ref_cdgo, ref_bar.cab_cdgo, ref_bar.cor_cdgo, rfb_numero) ean13");
      }

      sb.append("      , null gde_cdgo ");
      sb.append("      , null cod_dun14 ");
      sb.append("      , null qtd_pares ");
      sb.append("      , DECODE(ref_status, 'I', 'I', 'A', 'A', 'I') status ");
      sb.append("      , null sscc ");

      if (informouCliente) {
        sb.append("    , fct_numero_exterior(").append(f.getCli_cdgo()).append(", 1, rfb_numero, ref.codigo_marca, ref_class_segmento) numero_externo ");
      } else if (informouFatura) {
        sb.append("    , fct_numero_exterior(fp.codigo_cliente, fp.estabelecimento_cliente, rfb_numero, ref.codigo_marca, ref_class_segmento) numero_externo ");
      } else {
        sb.append("    , '' numero_externo ");
      }

      if (organizarPorLoja) {
        if (informouPedido) {
          sb.append("    , idc.cliente loja ");
        } else if (informouFatura) {
          sb.append("    , idcfp.loja_do_cliente loja ");
        }
      }
      sb.append("      , ref.ref_desc ");
      sb.append("      ,REPLACE(fct_retorna_fit_imagem(ref_bar.lin_cdgo, ref_bar.ref_cdgo, ref_bar.cab_cdgo, ref_bar.cor_cdgo),'.gif','.jpg') imagem");
      if ((informouFatura && trazerPrecos)) {
        sb.append("    , i.preco_unitario ");
      }
      sb.append("   FROM ref_bar ");
      sb.append(sbq.toString());
      sb.append("      , cor ");
      sb.append("      , ref_cor ");
      sb.append("      , ref ");
      sb.append("      , marcas_produtos mp ");
      sb.append("  WHERE ref_bar.cab_cdgo = cabedal.cab_cdgo ");
      sb.append("    AND ref_bar.cor_cdgo = cor.cor_cdgo ");
      sb.append("    AND ref_bar.lin_cdgo = ref_cor.lin_cdgo ");
      sb.append("    AND ref_bar.ref_cdgo = ref_cor.ref_cdgo ");
      sb.append("    AND ref_bar.cab_cdgo = ref_cor.cab_cdgo ");
      sb.append("    AND ref_bar.cor_cdgo = ref_cor.cor_cdgo ");
      sb.append("    AND ref_bar.lin_cdgo = ref.lin_cdgo ");
      sb.append("    AND ref_bar.ref_cdgo = ref.ref_cdgo ");
      sb.append("    AND ref.codigo_marca = mp.codigo_marca ");
      sb.append("    AND NVL(ref_bar.ativo, NULL) IS NULL ");
      sb.append("    AND var_logistica IS NULL ");
      sb.append(sbp.toString());
      sb.append("  UNION ");
      sb.append(" SELECT DISTINCT mp.codigo_marca ");
      sb.append("      , mp.descricao_marca ");
      sb.append("      , fct_mask_modelo(ref_bar.lin_cdgo, ref_bar.ref_cdgo) linha_ref ");
      sb.append("      , ref_bar.lin_cdgo ");
      sb.append("      , ref_bar.ref_cdgo ");
      sb.append("      , ref_bar.cab_cdgo ");
      sb.append("      , ref_bar.cor_cdgo ");

      if (informouCliente) {
        sb.append("   , fct_descricao_cabedal(ref_bar.lin_cdgo, ref_bar.ref_cdgo, ref_bar.cab_cdgo, null, ").append(f.getCli_cdgo()).append(") cabedal ");
      } else if (informouFatura) {
        sb.append("   , fct_descricao_cabedal(ref_bar.lin_cdgo, ref_bar.ref_cdgo, ref_bar.cab_cdgo, null, fp.codigo_cliente) cabedal ");
      } else {
        sb.append("   , cabedal.cab_desc cabedal ");
      }

      sb.append("      , cor_desc cor ");
      sb.append("      , null numero ");
      sb.append("      , null ean13 ");
      sb.append("      , ref_bar.gde_cdgo ");
      sb.append("      , to_char(codigo_barra_dum14) cod_dun14 ");
      sb.append("      , qtde_pares qtd_pares ");
      sb.append("      , DECODE(ref_status, 'I', 'I', 'A', 'A', 'I') status ");
      sb.append("      , null sscc ");
      sb.append("      , null numero_externo ");

      if (organizarPorLoja) {
        if (informouPedido) {
          sb.append("    , idc.cliente loja ");
        } else if (informouFatura) {
          sb.append("    , idcfp.loja_do_cliente loja ");
        }
      }
      sb.append("      , ref.ref_desc ");
      sb.append("      ,REPLACE(fct_retorna_fit_imagem(ref_bar.lin_cdgo, ref_bar.ref_cdgo, ref_bar.cab_cdgo, ref_bar.cor_cdgo),'.gif','.jpg') imagem");
      if ((informouFatura && trazerPrecos)) {
        sb.append("    , i.preco_unitario ");
      }
      sb.append("   FROM ref_bar ");
      sb.append(sbq.toString());
      sb.append("      , cor ");
      sb.append("      , ref_cor ");
      sb.append("      , ref ");
      sb.append("      , marcas_produtos mp ");
      sb.append("  WHERE ref_bar.cab_cdgo = cabedal.cab_cdgo ");
      sb.append("    AND ref_bar.cor_cdgo = cor.cor_cdgo ");
      sb.append("    AND ref_bar.lin_cdgo = ref_cor.lin_cdgo ");
      sb.append("    AND ref_bar.ref_cdgo = ref_cor.ref_cdgo ");
      sb.append("    AND ref_bar.cab_cdgo = ref_cor.cab_cdgo ");
      sb.append("    AND ref_bar.cor_cdgo = ref_cor.cor_cdgo ");
      sb.append("    AND ref_bar.lin_cdgo = ref.lin_cdgo ");
      sb.append("    AND ref_bar.ref_cdgo = ref.ref_cdgo ");
      sb.append("    AND ref.codigo_marca = mp.codigo_marca ");
      sb.append("    AND NVL(ref_bar.ativo, NULL) IS NULL ");
      sb.append("    AND var_logistica IS NOT NULL ");
      sb.append("    AND ref_bar.rfb_numero = '0' ");
      sb.append(sbp.toString());
      sb.append(" UNION ");
      sb.append(" SELECT mp.codigo_marca ");
      sb.append("      , mp.descricao_marca ");
      sb.append("      , fct_mask_modelo(r.lin_cdgo, r.ref_cdgo) linha_ref ");
      sb.append("      , r.lin_cdgo ");
      sb.append("      , r.ref_cdgo ");
      sb.append("      , cab.cab_cdgo ");
      sb.append("      , co.cor_cdgo ");

      if (informouCliente) {
        sb.append("   , fct_descricao_cabedal(r.lin_cdgo, r.ref_cdgo, cab.cab_cdgo, null, ").append(f.getCli_cdgo()).append(") cabedal ");
      } else if (informouFatura) {
        sb.append("   , fct_descricao_cabedal(r.lin_cdgo, r.ref_cdgo, cab.cab_cdgo, null, null) cabedal ");
      } else {
        sb.append("   , cab.cab_desc cabedal ");
      }

      sb.append("      , co.cor_desc cor ");
      sb.append("      , q.qtt_nume numero ");
      sb.append("      , NULL ean13 ");
      sb.append("      , NULL gde_cdgo ");
      sb.append("      , NULL ");
      sb.append("      , q.qtt_pars qtd_pares ");
      sb.append("      , DECODE(ref_status, 'I', 'I', 'A', 'A', 'I') status ");
      sb.append("      , DECODE(rr.tipo_geracao, 'P', 'P' || LPAD(rr.ped_nmro, 8, 0) || ");
      sb.append("               LPAD(rr.seq_rotulo_ped, 4, 0) || ");
      sb.append("               LPAD(rr.id_versao, 6, 0), 'R', 'R' || LPAD(rr.rem_nro, 8, 0) || ");
      sb.append("               LPAD(rr.seq_rotulo, 4, 0) || ");
      sb.append("               LPAD(rr.id_versao, 6, 0), 'E', 'E' || LPAD(rr.rem_nro, 8, 0) || ");
      sb.append("               LPAD(rr.seq_rotulo, 4, 0) || ");
      sb.append("               LPAD(rr.id_versao, 6, 0), 'A', 'A' || LPAD(rr.ped_nmro, 8, 0) || ");
      sb.append("               LPAD(rr.seq_rotulo_ped, 4, 0) || ");
      sb.append("               LPAD(rr.id_versao, 6, 0)) sscc ");
      sb.append("      , q.qtt_nume_exp numero_externo ");
      if (organizarPorLoja) {
        sb.append("      , NULL loja ");
      }
      sb.append("      , r.ref_desc ");
      sb.append("      , REPLACE(fct_retorna_fit_imagem(r.lin_cdgo, r.ref_cdgo, cab.cab_cdgo, co.cor_cdgo),'.gif','.jpg') imagem");
      if ((informouFatura && trazerPrecos)) {
        sb.append("      , 0.0 preco_unitario ");
      }
      sb.append("   FROM rotulos_remessa     rr ");
      sb.append("      , ite                 i ");
      sb.append("      , ped                 ped ");
      sb.append("      , ref                 r ");
      sb.append("      , cabedal             cab ");
      sb.append("      , cor                 co ");
      sb.append("      , marcas_produtos     mp ");
      sb.append("      , qtd_rotulos_remessa q ");
      sb.append("  WHERE rr.ped_nmro = i.ped_nmro ");
      sb.append("    AND 1=2 ");
      sb.append("    AND rr.ite_seqn = i.ite_seqn ");
      sb.append("    AND i.lin_cdgo = r.lin_cdgo ");
      sb.append("    AND i.ref_cdgo = r.ref_cdgo ");
      sb.append("    AND i.cab_cdgo = cab.cab_cdgo ");
      sb.append("    AND i.ped_nmro = ped.ped_nmro ");
      sb.append("    AND cab.cab_cdgo = i.cab_cdgo ");
      sb.append("    AND co.cor_cdgo = i.cor_cdgo ");
      if (representante != null) {
        sb.append(" AND pck_pedidos.get_rep(ped.ped_nmro) = '").append(representante).append("' ");
      }
      if (regional != null) {
        sb.append(" AND pck_representante.get_regional(pck_pedidos.get_rep(ped.ped_nmro)) = ").append(regional);
      }
      sb.append("    AND mp.codigo_marca = r.codigo_marca ");
      sb.append("    AND q.rem_nro = rr.rem_nro ");
      sb.append("    AND q.rotulo = rr.rotulo ");
      sb.append("    AND q.ped_nmro = rr.ped_nmro ");
      sb.append("    AND q.ite_seqn = rr.ite_seqn ");
      if (organizarPorLoja) {
        sb.append(" ) ORDER BY loja ");
        sb.append(" , lin_cdgo ");
        sb.append(" , ref_cdgo ");
        sb.append(" , cab_cdgo ");
        sb.append(" , cor_cdgo ");
        sb.append(" , numero");
      }


      if (organizarPorProdutoGrade) {
        sb.append(" ) ORDER BY lin_cdgo ");
        sb.append(" , ref_cdgo ");
        sb.append(" , cab_cdgo ");
        sb.append(" , cor_cdgo ");
        sb.append(" , TO_NUMBER(regexp_substr(numero, '[[:digit:]]+', 1, 1))");
      }

      if (usuario.mostraQuery()) {
        throw new Exception(sb.toString());
      }

      Vector res_Jw_cod_barra_ambos = j.select(table, sb.toString(), null);

      session.setAttribute("res_Jw_cod_barra_ambos", res_Jw_cod_barra_ambos);
      if (!(res_Jw_cod_barra_ambos != null && res_Jw_cod_barra_ambos.size() > 0)) {
        throw new Exception(java.util.ResourceBundle.getBundle("ComercialResources").getString("CodigoBarra.erro.nenhum.registro"));
      }
    }
    session.setAttribute("mapping.getName()", form);
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      CodigoBarrasActionForm f = (CodigoBarrasActionForm) form;
      session.removeAttribute("res_Jw_cod_barra");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_cod_barra", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      CodigoBarrasActionForm f = (CodigoBarrasActionForm) form;
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_cod_barra", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
