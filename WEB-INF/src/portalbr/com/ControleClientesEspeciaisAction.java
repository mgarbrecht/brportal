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
 * Creation Date 25/05/2011 11:44:52
 * Last Modify Date 20/03/2023 17:52:36
 */

public class ControleClientesEspeciaisAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ControleClientesEspeciaisActionForm f = (ControleClientesEspeciaisActionForm) form;
      select_action(j, mapping, form, request, response);
      if (session.getAttribute("amostra") != null) {
        actionForward = new ActionForward("/com/ControleClientesEspeciaisAmostra_mGrid.do?select_action=",true);
      } else {
        actionForward = new ActionForward("/com/ControleClientesEspeciais_mGrid.do?select_action=",true);
      }
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Controle_clientes_especiais_vw", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    ControleClientesEspeciaisActionForm f = (ControleClientesEspeciaisActionForm) form;
    boolean validouParametros = false;
    boolean consultaCorte = false;
    boolean consultaMultiplosPedidos = false;
    boolean consultaMultiplasNotas = false;
    boolean consultaRomaneio = true;
    if ((f.getCb_romaneio() + "").equals("1")) {
      consultaRomaneio = true;
    }
    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    session.removeAttribute("somente_consulta");
    session.removeAttribute("mostrar_filiais_producao");
    session.removeAttribute("gerar_planilha");
    session.removeAttribute("gerar_planilha_subtotal");
    session.removeAttribute("marcar_gerar_requisicao");
    if (f.getPed_nmro().indexOf(",") != -1) {
      consultaMultiplosPedidos = true;
    }
    if (f.getNf_numero().indexOf(",") != -1) {
      consultaMultiplasNotas = true;
    }
    if (f.getGerar_planilha().equals("S")) {
      session.setAttribute("gerar_planilha", f.getGerar_planilha());
    }
    if (f.getGerar_planilha_subtotal().equals("S")) {
      session.setAttribute("gerar_planilha_subtotal", f.getGerar_planilha_subtotal());
    }
    if (f.getMostrar_filiais_producao().equals("S")) {
      session.setAttribute("mostrar_filiais_producao", f.getMostrar_filiais_producao());
    }
    if (f.getSomente_consulta().equals("S")) {
      session.setAttribute("somente_consulta", f.getSomente_consulta());
    }
    if (f.getDt_ent_inicial() != "" && f.getDt_ent_final() != "") {
      com.beirario.brportal.util.DateUtil dateUtil = new com.beirario.brportal.util.DateUtil();
      if (dateUtil.diferencaMeses(f.getDt_ent_inicial(), f.getDt_ent_final()) > 24) {
        throw new Exception("O período não pode ser superior a 24 meses");
      }
    }
    if (f.getDt_nf_inicial() != "" && f.getDt_nf_final() != "") {
      com.beirario.brportal.util.DateUtil dateUtil = new com.beirario.brportal.util.DateUtil();
      if (dateUtil.diferencaMeses(f.getDt_nf_inicial(), f.getDt_nf_final()) > 24) {
        throw new Exception("O período não pode ser superior a 24 meses");
      }
    }
    if (f.getDt_inicial() != "" && f.getDt_final() != "") {
      com.beirario.brportal.util.DateUtil dateUtil = new com.beirario.brportal.util.DateUtil();
      if (dateUtil.diferencaMeses(f.getDt_inicial(), f.getDt_final()) > 24) {
        throw new Exception("O período não pode ser superior a 24 meses");
      }
    }
    if (f.getDt_corte_inicial() != "" && f.getDt_corte_final() != "") {
      if (f.getFil_filial().equals("")) {
        throw new Exception("A filial é obrigatória ao informar período de corte!");
      }
      com.beirario.brportal.util.DateUtil dateUtil = new com.beirario.brportal.util.DateUtil();
      if (dateUtil.diferencaMeses(f.getDt_corte_inicial(), f.getDt_corte_final()) > 1) {
        throw new Exception("O período de corte não pode ser superior a 1 mês");
      }
      validouParametros = true;
    }
    StringBuilder parametros = new StringBuilder();

    StringBuilder sbPed = new StringBuilder();
    boolean restringeTipoMercado = false;
    boolean filtraDataAgendamento = false;
    String transportadora = null;

    if (f.getTra_cdgo() != "") {
      transportadora = f.getTra_cdgo();
    }


    // TIPO DE PEDIDO = TODOS
    if (f.getTipo_pedido().equalsIgnoreCase("T")) {

      if (f.getTipo_mercado().equalsIgnoreCase("T")) {
        restringeTipoMercado = false;
      }
      if (f.getTipo_mercado().equalsIgnoreCase("MI")) {
        restringeTipoMercado = true;
        sbPed.append("      ,(SELECT * FROM ped p ");
        sbPed.append("         WHERE ped_tipo <> 'EX') ped ");
      }

      if (f.getTipo_mercado().equalsIgnoreCase("ME")) {
        restringeTipoMercado = true;
        sbPed.append("      ,(SELECT * FROM ped p ");
        sbPed.append("         WHERE ped_tipo = 'EX') ped ");
      }
    }




    // TIPO DE PEDIDO = PG
    if (f.getTipo_pedido().equalsIgnoreCase("PG")) {

      if (f.getTipo_mercado().equalsIgnoreCase("T")) {
        restringeTipoMercado = true;
        sbPed.append("      ,(SELECT * FROM ped p ");
        sbPed.append("         WHERE ((p.ped_tipo = 'PG') ");
        sbPed.append("             OR (p.ped_tipo = 'EX' AND NOT EXISTS (SELECT 1 ");
        sbPed.append("                                                     FROM ped_inf_adicionais pi ");
        sbPed.append("                                                    WHERE pi.ped_nmro = p.ped_nmro ");
        sbPed.append("                                                      AND pi.pedido_origem IN ('COMPRA RAPIDA', 'ESTRATEGICO'))))  ) ped     ");
      }
      if (f.getTipo_mercado().equalsIgnoreCase("MI")) {
        restringeTipoMercado = true;
        sbPed.append("      ,(SELECT * FROM ped p ");
        sbPed.append("         WHERE ped_tipo = 'PG') ped ");
      }

      if (f.getTipo_mercado().equalsIgnoreCase("ME")) {
        restringeTipoMercado = true;
        sbPed.append("      ,(SELECT * FROM ped p ");
        sbPed.append("         WHERE ((p.ped_tipo = 'EX' AND NOT EXISTS (SELECT 1 ");
        sbPed.append("                                                     FROM ped_inf_adicionais pi ");
        sbPed.append("                                                    WHERE pi.ped_nmro = p.ped_nmro ");
        sbPed.append("                                                      AND pi.pedido_origem IN ('COMPRA RAPIDA', 'ESTRATEGICO'))))  ) ped     ");
      }
    }




    // TIPO DE PEDIDO = PP
    if (f.getTipo_pedido().equalsIgnoreCase("PP")) {

      if (f.getTipo_mercado().equalsIgnoreCase("T")) {
        restringeTipoMercado = true;
        sbPed.append("      ,(SELECT * FROM ped p ");
        sbPed.append("         WHERE ((p.ped_tipo = 'PP') ");
        sbPed.append("             OR (p.ped_tipo = 'EX' AND EXISTS (SELECT 1 ");
        sbPed.append("                                                 FROM ped_inf_adicionais pi ");
        sbPed.append("                                                WHERE pi.ped_nmro = p.ped_nmro ");
        sbPed.append("                                                  AND pi.pedido_origem IN ('COMPRA RAPIDA', 'ESTRATEGICO'))))  ) ped     ");
      }
      if (f.getTipo_mercado().equalsIgnoreCase("MI")) {
        restringeTipoMercado = true;
        sbPed.append("      ,(SELECT * FROM ped p ");
        sbPed.append("         WHERE ped_tipo = 'PP') ped ");
      }

      if (f.getTipo_mercado().equalsIgnoreCase("ME")) {
        restringeTipoMercado = true;
        sbPed.append("      ,(SELECT * FROM ped p ");
        sbPed.append("         WHERE ((p.ped_tipo = 'EX' AND EXISTS (SELECT 1 ");
        sbPed.append("                                                 FROM ped_inf_adicionais pi ");
        sbPed.append("                                                WHERE pi.ped_nmro = p.ped_nmro ");
        sbPed.append("                                                  AND pi.pedido_origem IN ('COMPRA RAPIDA', 'ESTRATEGICO'))))  ) ped     ");
      }
    }



    // TIPO DE PEDIDO = EX
    if (f.getTipo_pedido().equalsIgnoreCase("EX")) {

      if (f.getTipo_mercado().equalsIgnoreCase("T")) {
        restringeTipoMercado = true;
        sbPed.append("      ,(SELECT * ");
        sbPed.append("          FROM ped ");
        sbPed.append("         WHERE ped_tipo = 'EX') ped ");
      }
      if (f.getTipo_mercado().equalsIgnoreCase("MI")) {
        restringeTipoMercado = true;
        sbPed.append("      ,(SELECT * ");
        sbPed.append("          FROM ped ");
        sbPed.append("         WHERE ped_tipo = 'EX' ");
        sbPed.append("           AND ped_tipo <> 'EX') ped ");
      }

      if (f.getTipo_mercado().equalsIgnoreCase("ME")) {
        restringeTipoMercado = true;
        sbPed.append("      ,(SELECT * ");
        sbPed.append("          FROM ped ");
        sbPed.append("         WHERE ped_tipo = 'EX' ) ped ");
      }
    }



    if ((!f.getAno_fatura().equals("")) || (!f.getNumero_fatura().equals(""))) {
      if ((!f.getAno_fatura().equals("")) && f.getNumero_fatura().equals("") || (!f.getNumero_fatura().equals("")) && f.getAno_fatura().equals("")) {
        throw new Exception("O ano e o número da fatura devem ser informados!");
      }
      validouParametros = true;
      parametros.append(" AND ite.empresa_fatura_proforma = '01' ");
      parametros.append(" AND ite.ano_fatura_proforma = ").append(f.getAno_fatura());
      parametros.append(" AND ite.numero_fatura_proforma = ").append(f.getNumero_fatura());
    }



    if (!f.getPed_nmro().equals("")) {
      validouParametros = true;
    }

    if (!validouParametros) {
      if (!f.getPed_ped_cliente().equals("")) {
        validouParametros = true;
      }
    }

    if (!validouParametros) {
      if (!f.getRemessa().equals("")) {
        validouParametros = true;
      }
    }

    if (!validouParametros) {
      if (!f.getNf_numero().equals("")) {
        validouParametros = true;
      }
    }

    if (!validouParametros) {
      if ((f.getDt_inicial().equals("") && f.getDt_final().equals("")) && (f.getDt_nf_inicial().equals("") && f.getDt_nf_final().equals("")) && (f.getDt_corte_inicial().equals("") && f.getDt_corte_final().equals("")) && (f.getDt_emiss_ini().equals("") && f.getDt_emiss_fim().equals("")) && (f.getDt_ent_inicial().equals("") && f.getDt_ent_final().equals(""))) {
        throw new Exception("Data Emissão, Data digitação, Data NF ou data Ent. deve ser informados!");
      }
    }



    if (!validouParametros) {
      if (f.getRep_cdgo().equals("") && session.getAttribute("consulta_pedidos_status_situacoes") == null && session.getAttribute("listaEspecies") == null && session.getAttribute("listaSituacoes") == null && f.getPed_stat().equals("") && f.getNf_numero().equals("") && f.getCli_cdgo().equals("") && f.getTra_cdgo().equals("") && f.getCodigo_regional().equals("") && f.getGre_grupo().equals("") && f.getDt_agend_inicial().equals("") && f.getDt_agend_final().equals("") && f.getPed_nmro().equals("") && f.getPed_ped_cliente().equals("") && (f.getCb_somente_etiqueta() == null) && (f.getPossui_dados() == null)) {
        throw new Exception("Um dos campos com <img src='../img/opcional.gif'> deve ser informado!");
      }
    }

    Controle_clientes_especiais_vw table = new Controle_clientes_especiais_vw();

    if (f.getCb_somente_etiqueta() != null) {
      f.setPed_stat("X");
    }

    if (f.getDt_agend_inicial() != "") {
      filtraDataAgendamento = true;
      parametros.append(" AND pi.dt_agendamento >= to_date('"+f.getDt_agend_inicial() + "', 'dd/mm/yyyy') ");
    }

    if (f.getDt_agend_final() != "") {
      filtraDataAgendamento = true;
      parametros.append(" AND pi.dt_agendamento <= to_date('"+f.getDt_agend_final() + "', 'dd/mm/yyyy') ");
    }


    if (f.getRemessa() != "") {
      String remessas = f.getRemessa().replaceAll("[^0-9]", " ").trim();
      remessas = remessas.replaceAll("\\s+", " ");
      remessas = remessas.replaceAll(" ", "\n");
      remessas = remessas.replaceAll("\\r\\n|\\r|\\n", ",");
      if ((remessas.charAt(remessas.length() - 1) + "").equalsIgnoreCase(",")) {
        remessas = remessas.substring(0, remessas.lastIndexOf(","));
      }
      parametros.append("   AND ped.ped_nmro IN (SELECT fct_get_pedido_origem(rp.ped_nmro) FROM rem_ped rp WHERE rp.rem_nro in ("+ remessas + ")) ");
    }

    if (f.getRep_cdgo() != "") {
      parametros.append(" AND ped.rep_cdgo = '"+f.getRep_cdgo() + "' ");
    }

    if (f.getCli_cdgo() != "") {
      if (filtraDataAgendamento) {
        parametros.append(" AND ped.cli_cdgo = " + f.getCli_cdgo());
      } else {
        parametros.append(" AND ped.cli_cdgo = " + f.getCli_cdgo());
      }
    }

    if (f.getPed_nmro() != "") {
      consultaMultiplosPedidos = true;
      String pedidos = f.getPed_nmro().replaceAll("[^0-9]", " ").trim();
      pedidos = pedidos.replaceAll("\\s+", " ");
      pedidos = pedidos.replaceAll(" ", "\n");
      pedidos = pedidos.replaceAll("\\r\\n|\\r|\\n", ",");

      if ((pedidos.charAt(pedidos.length() - 1) + "").equalsIgnoreCase(",")) {
        pedidos = pedidos.substring(0, pedidos.lastIndexOf(","));
      }

      parametros.append(" AND ped.ped_nmro in (" + pedidos + ")");
    }

    if (f.getCodigo_regional() != "") {
      parametros.append(" AND rep.codigo_regional = " + f.getCodigo_regional());
    }

    if (f.getPed_ped_cliente() != "") {
      String pedidosCliente = "'" + f.getPed_ped_cliente().replaceAll("\\r\\n|\\r|\\n|,", "','");
      if ((pedidosCliente.charAt(pedidosCliente.length() - 1) + "").equalsIgnoreCase(",")) {
        pedidosCliente = pedidosCliente.substring(0, pedidosCliente.lastIndexOf(","));
      }
      pedidosCliente = pedidosCliente + "'";
      StringBuilder pedCliente = new StringBuilder();
      StringBuilder tmpDelete = new StringBuilder();
      util.consultas.Query qry = new util.consultas.Query();


      tmpDelete.append(" DELETE tmp_generic_table_brportal tgt ");
      tmpDelete.append(" WHERE tgt.varchar_column1 = 'PED_PED_CLIENTE' ");
      tmpDelete.append(" AND tgt.varchar_column2 = '" + usuario.getUsuario() + "' ");

      pedCliente.append(" INSERT INTO tmp_generic_table_brportal ");
      pedCliente.append(" (varchar_column1 ");
      pedCliente.append(" ,varchar_column2 ");
      pedCliente.append(" ,varchar_column3) ");
      pedCliente.append(" SELECT ");
      pedCliente.append(" 'PED_PED_CLIENTE' ");
      pedCliente.append(" ,'" + usuario.getUsuario() + "' ");
      pedCliente.append(" ,ped.ped_ped_cliente ");
      pedCliente.append(" FROM ped ");
      pedCliente.append(" WHERE ped.ped_ped_cliente IN (" + pedidosCliente + ") ");

      qry.execute(tmpDelete.toString());
      qry.execute(pedCliente.toString());

      parametros.append("   AND tgt.varchar_column3 = ped.ped_ped_cliente ");
      parametros.append("   AND tgt.varchar_column1 = 'PED_PED_CLIENTE' ");
      parametros.append("   AND tgt.varchar_column2 = '" + usuario.getUsuario() + "' ");

    }

    if (f.getFil_filial() != "") {
      parametros.append(" AND fct_retorna_fil_producao(ite.ped_nmro,  (select min(ite_seqn) from ite i where i.ped_nmro = ite.ped_nmro)) = '"+f.getFil_filial() + "'");
    }

    if (f.getLocal_estoque() != "") {
      parametros.append(" AND ped.les_codigo in (").append(f.getLocal_estoque()).append(") ");
    }

    if (f.getCodigo_marca() != "") {
      parametros.append(" AND pck_referencia.get_marca(ite.lin_cdgo, ite.ref_cdgo) in (").append(f.getCodigo_marca()).append(") ");
    }


    if (f.getPed_stat().equals("X")) {
      parametros.append(" AND ped.ped_stat not in ('C','F') ");
    } else if (f.getPed_stat() != "") {
      parametros.append(" AND ped.ped_stat in ("+f.getPed_stat() + ") ");
    }

    if (f.getLinha() != "") {
      parametros.append(" AND ite.lin_cdgo = " + f.getLinha());
    }

    if (f.getReferencia() != "") {
      parametros.append(" AND ite.ref_cdgo = " + f.getReferencia());
    }


    if (f.getDt_inicial() != "") {
      parametros.append(" AND ped.ped_dadg >= to_date('"+f.getDt_inicial() + "', 'dd/mm/yyyy') ");
    }

    if (f.getDt_final() != "") {
      parametros.append(" AND ped.ped_dadg < to_date('"+f.getDt_final() + "', 'dd/mm/yyyy')+1 ");
    }

    if (f.getDt_emiss_ini() != "") {
      parametros.append(" AND ped.ped_daem >= to_date('"+f.getDt_emiss_ini() + "', 'dd/mm/yyyy') ");
    }

    if (f.getDt_emiss_fim() != "") {
      parametros.append(" AND ped.ped_daem <= to_date('"+f.getDt_emiss_fim() + "', 'dd/mm/yyyy') ");
    }


    if (f.getDt_ent_inicial() != "") {
      parametros.append(" AND ped.ped_det >= to_date('"+f.getDt_ent_inicial() + "', 'dd/mm/yyyy') ");
    }

    if (f.getDt_ent_final() != "") {
      parametros.append(" AND ped.ped_det <= to_date('"+f.getDt_ent_final() + "', 'dd/mm/yyyy') ");
    }




    if (f.getDt_nf_inicial() != "") {
      parametros.append("    AND EXISTS (SELECT 1 ");
      parametros.append("           FROM notas_fiscais_saida_ped_venda np ");
      parametros.append("              , nf_saida n ");
      parametros.append("          WHERE np.ped_nmro = ped.ped_nmro ");
      parametros.append("            AND n.nfs_dtemis >= TO_DATE('"+f.getDt_nf_inicial() + "', 'dd/mm/yyyy') ");
      parametros.append("            AND n.nfs_dtemis <= TO_DATE('"+f.getDt_nf_final() + "', 'dd/mm/yyyy') ");
      parametros.append("            AND n.emp_empresa = np.emp_empresa ");
      parametros.append("            AND n.stat_codigo = 4 ");
      parametros.append("            AND n.fil_filial = np.fil_filial ");
      parametros.append("            AND n.nfs_nmro = np.nfs_nmro ");
      parametros.append("            AND n.nfs_serie = np.nfs_serie ) ");
    }




    if ((f.getCb_etiquetas_pendentes() + "").equals("S")) {
      parametros.append(" AND etiquetas IS NULL ");
    }

    if ((f.getCb_etiquetas_pendentes_industrial() + "").equals("S")) {
      parametros.append(" AND pi.dt_rec_etiqueta_filial IS NULL ");
    }

    if ((f.getCb_somente_amostra() + "").equals("S")) {
      parametros.append(" and ped_especie_pedido = 'A' AND ped.cli_cdgo <> 40000 ");
    }

    if (f.getPossui_dados() != null) {
      parametros.append(" AND decode(nvl(pi.ped_nmro,0),0,'N','S') = 'S' ");
    }

    if (f.getCb_possui_carimbo() != null) {
      parametros.append(" AND decode(NVL(cia.possui_carimbo,'N'),'N','N','S') = 'S' ");
    }

    if (f.getCb_somente_etiqueta() != null) {
      parametros.append(" AND decode(NVL(cia.somente_etiqueta,'N'),'N','N','S') = 'S' ");
    }

    if (f.getAtacado() != null) {
      if (f.getAtacado().equalsIgnoreCase("S")) {
        parametros.append(" AND cli.cla_cdgo = 'ATA' ");
      }
      if (f.getAtacado().equalsIgnoreCase("N")) {
        parametros.append(" AND cli.cla_cdgo <> 'ATA' ");
      }
    }


    if (f.getDt_corte_inicial() != "" && f.getDt_corte_final() != "") {
      parametros.append(" AND EXISTS (SELECT 1 ");
      parametros.append("               FROM rem_ped rp ");
      parametros.append("                  , remessa r ");
      parametros.append("              WHERE rp.ped_nmro = ped.ped_nmro ");
      parametros.append("                AND rp.rem_nro = r.rem_nro ");
      parametros.append("                AND r.rem_inicio >= to_date('"+f.getDt_corte_inicial() + "', 'dd/mm/yyyy') ");
      parametros.append("                AND r.rem_inicio <= to_date('"+f.getDt_corte_final() + "', 'dd/mm/yyyy')) ");
      parametros.append(" AND to_number(ite.ite_situ) > 3 ");
      consultaCorte = true;
    }

    if (transportadora != null) {
      parametros.append(" AND ped.tra_cdgo = " + transportadora);
    }

    if (f.getEsc_seqn() != "") {
      parametros.append(" AND ped.esc_seqn = " + f.getEsc_seqn());
    }

    if (f.getCb_empenhado_completo() != null) {
      parametros.append(" AND pck_pedidos.get_todoempenhado(ped.ped_nmro) = 'S' ");
    }

    //--- Situações do Pedido ---
    if (session.getAttribute("listaSituacoes") != null) {
      java.util.Vector listaSituacoes = (java.util.Vector) session.getAttribute("listaSituacoes");
      if (listaSituacoes.size() > 0) {
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < listaSituacoes.size(); x++) {
          if (sb.length() > 0) {
            sb.append(",");
          }
          sb.append((listaSituacoes.elementAt(x) + "").substring(0, listaSituacoes.toString().indexOf("-") - 1));
        }
        parametros.append(" AND ite.ite_situ IN ("+sb.toString() + ") ");
      }
    }
    //---------------------------


    //--- Status/Situações do Pedido ---
    if (session.getAttribute("consulta_pedidos_status_situacoes") != null) {
      StringBuilder sb = new StringBuilder();
      sb.append((String) session.getAttribute("consulta_pedidos_status_situacoes"));
      parametros.append(" AND ped.ped_stat||ite.ite_situ IN ("+sb.toString() + ") ");
    }
    //---------------------------



    if (session.getAttribute("especies") != null) {
      String especies = (String) session.getAttribute("especies");
      if (!especies.equals("")) {
        parametros.append(" AND ((ped.ped_especie_pedido) IN ("+especies + ")  ");
        parametros.append("                                          OR (INSTR('"+especies.replace("'", "") + "', 'AC') > 0   ");
        parametros.append("                                          AND ped.ped_especie_pedido = 'A' ");
        parametros.append("                                          AND ped.cli_cdgo != 40000 ");
        parametros.append("                                          AND (NOT EXISTS (SELECT NULL ");
        parametros.append("                                                   FROM esc ");
        parametros.append("                                                       ,erp ");
        parametros.append("                                                  WHERE esc.cli_cdgo = ped.cli_cdgo ");
        parametros.append("                                                    AND esc.esc_seqn = ped.esc_seqn ");
        parametros.append("                                                    AND esc.esc_cgc != 0 ");
        parametros.append("                                                    AND SUBSTR(erp.erp_cgc, 1, 8) = SUBSTR(esc.esc_cgc, 1, 8)) AND ");
        parametros.append("                                               NOT EXISTS (SELECT NULL ");
        parametros.append("                                                             FROM embarque_pedidos ep ");
        parametros.append("                                                            WHERE ep.ped_nmro = ped.ped_nmro) AND ");
        parametros.append("                                               NOT EXISTS (SELECT NULL ");
        parametros.append("                                                             FROM embarque_pedidos ep ");
        parametros.append("                                                            WHERE ep.ped_nmro_novo = ped.ped_nmro) AND ");
        parametros.append("                                               NOT EXISTS (SELECT NULL ");
        parametros.append("                                                             FROM ped pedc ");
        parametros.append("                                                            WHERE pedc.ped_ped_cliente = TO_CHAR(ped.ped_nmro))))) ");
      } else {
        parametros.append("     AND (ped.ped_especie_pedido IN ('-1')) ");
      }
    }

    parametros.append(" ) qry ");




    if ((f.getCb_subtotal_grupo_economico() + "").equals("S")) {
      parametros.append(" ORDER BY grupo_economico, dt_fatur, filial_prd, fil_filial_fat, dt_digit, dt_fatur_filial ");
    } else {

      if (f.getOrdem().equals("f")) {
        parametros.append(" ORDER BY filial_prd, fil_filial_fat, dt_digit, dt_fatur, dt_fatur_filial ");
      }
      if (f.getOrdem().equals("d")) {
        parametros.append(" ORDER BY dt_fatur, filial_prd, fil_filial_fat, dt_digit, dt_fatur_filial ");
      }
      if (f.getOrdem().equals("o")) {
        parametros.append(" ORDER BY oc, dt_fatur, filial_prd, fil_filial_fat, dt_digit, dt_fatur_filial ");
      }
      if (f.getOrdem().equals("sa")) {
        //  parametros.append(" ORDER BY to_date(regexp_substr(agendamento_cdgo, '\\d{2}/\\d{2}/\\d{4}'), 'dd/mm/yyyy') , dt_fatur, filial_prd, fil_filial_fat, dt_digit, dt_fatur_filial ");
        parametros.append(" ORDER BY agendamento_cdgo, dt_fatur, filial_prd, fil_filial_fat, dt_digit, dt_fatur_filial ");
      }
      if (f.getOrdem().equals("c")) {
        parametros.append(" ORDER BY cli_cdgo, dt_fatur, filial_prd, fil_filial_fat, dt_digit, dt_fatur_filial ");
      }
      if (f.getOrdem().equals("g")) {
        parametros.append(" ORDER BY grupo_economico, dt_fatur, filial_prd, fil_filial_fat, dt_digit, dt_fatur_filial ");
      }
      if (f.getOrdem().equals("a")) {
        parametros.append(" ORDER BY data_efetiva, dt_fatur, filial_prd, fil_filial_fat, dt_digit, dt_fatur_filial ");
      }

    }


    StringBuilder sb = new StringBuilder();

    if (f.getGerar_planilha_subtotal().equals("S")) {
      sb.append(" select codigo_regional, nome_regional, grupo_economico, grupo_descricao, sum(prs) prs from ( ");
    }


    sb.append(" SELECT /*+ all_rows */ ped_nmro ");
    sb.append("      , ped_boni ");
    sb.append("      , ped_boni2 ");
    sb.append("      , ped_desc ");
    sb.append("      , cnd_cdgo ");
    sb.append("      , oc ");
    sb.append("      , REPLACE(rowtocol('select distinct fct_mask_modelo(ite.lin_cdgo,ite.ref_cdgo)||(select ''#''||substr(ite_descricao,1,30)||''#'' from ite it where it.lin_cdgo = ite.lin_cdgo and it.ref_cdgo = ite.ref_cdgo and it.ped_nmro = ite.ped_nmro and  rownum = 1) from ite where ped_nmro = ' || qry.ped_nmro || ' order by 1'), ',', ' - ') modelos ");
    sb.append("      , etiquetas ");
    sb.append("      , obse_adicionais ");
    sb.append("      , pck_pedidos.get_pares(qry.ped_nmro) prs ");
    sb.append("      , CASE WHEN qry.ped_especie_pedido = 'C' THEN ");
    sb.append("            (REPLACE(rowtocol('select fct_retorna_remessas_recol('||qry.ped_nmro||') from dual '), ',', ' , ')) ");
    sb.append("           ELSE (REPLACE(rowtocol('select distinct nvl(rem_nro, fct_retorna_remessa(fct_get_pedido_origem(ped_nmro),1 )) from rem_ped where ped_nmro = fct_get_pedido_origem(' || qry.ped_nmro || ')'), ',', ' , ')) END remessa ");
    if (session.getAttribute("mostrar_filiais_producao") != null) {
      sb.append("   , replace(rowtocol('SELECT distinct fct_retorna_fil_producao(ped_nmro, ite_seqn) FROM ite WHERE ped_nmro = ' || qry.ped_nmro),',','#') filial_prd ");
    } else {
      sb.append("   , replace(rowtocol('SELECT distinct fct_retorna_fil_producao(ped_nmro, ite_seqn) FROM ite WHERE ped_nmro = ' || qry.ped_nmro ||' AND rownum = 1'),',','#') filial_prd ");
    }
    sb.append("      , fil_filial_fat ");
    sb.append("      , dt_emiss ");
    sb.append("      , dt_digit ");
    sb.append("      , dt_fatur ");
    sb.append("      , dt_fatur_filial ");
    sb.append("      , (SELECT rowtocol('SELECT distinct pck_marcas_produtos.get_nome(pck_referencia.get_marca(ite.lin_cdgo, ite.ref_cdgo)) FROM ite WHERE ite.ped_nmro = ' || qry.ped_nmro) FROM dual) marca ");
    sb.append("      , carimbo ");
    sb.append("      , rotulos ");
    sb.append("      , (SELECT rowtocol('SELECT ped_amostra FROM ped_amostra_geradas WHERE ped_nmro = ' || qry.ped_nmro) FROM dual) ped_amostra ");
    sb.append("      , dt_envio_amostras ");
    sb.append("      , agendamento_cdgo ");
    sb.append("      , data_efetiva ");
    sb.append("      , codigo_regional ");
    sb.append("      , pck_regionais_vendas.get_nome(qry.codigo_regional) nome_regional ");
    sb.append("      , rep_cdgo ");
    sb.append("      , cli_cdgo ");
    sb.append("      , codigo_marca ");
    sb.append("      , ped_stat ");
    sb.append("      , existe ");
    sb.append("      , hora ");
    sb.append("      , senha ");
    sb.append("      ,(SELECT to_date((to_char(nfs_dtemis, 'dd/mm/yyyy') || ' ' || ");
    sb.append("               to_char(nfs.data_cad, 'hh24:mi:ss')), 'dd/mm/yyyy hh24:mi:ss') dt_emissao ");
    sb.append("          FROM nf_saida                      nf ");
    sb.append("             , notas_fiscais_saida_ped_venda nfs ");
    sb.append("         WHERE nf.ped_nmro = qry.ped_nmro ");
    sb.append("           AND nfs.nfs_nmro = nf.nfs_nmro ");
    sb.append("           AND nfs.fil_filial = nf.fil_filial ");
    sb.append("           AND nfs.emp_empresa = nf.emp_empresa ");
    sb.append("           AND nfs.nfs_serie = nf.nfs_serie ");
    sb.append("           AND nfs.ped_nmro = nf.ped_nmro ");
    sb.append("           AND NVL(nf.stat_codigo, NULL) = 4 ");
    sb.append("           AND ROWNUM = 1) dt_emissao ");
    sb.append("      , (SELECT fil_filial FROM nf_saida nf WHERE nf.ped_nmro = qry.ped_nmro AND NVL(nf.stat_codigo, NULL) = 4 AND ROWNUM = 1) filial ");
    sb.append("      , (SELECT nf.nfs_nmro || '-' || nf.nfs_serie FROM nf_saida nf WHERE nf.ped_nmro = qry.ped_nmro AND NVL(nf.stat_codigo, NULL) = 4 AND ROWNUM = 1) notafiscal ");
    sb.append("      , NVL((SELECT nfs_qtdvol FROM nf_saida nf WHERE nf.ped_nmro = qry.ped_nmro AND NVL(nf.stat_codigo, NULL) = 4 AND ROWNUM = 1), (select fct_calcula_volumes_new(qry.ped_nmro) from dual)) volumes ");
    sb.append("      , rep_rzao ");
    sb.append("      , esc_seqn ");
    sb.append("      , fct_valor_pedido(qry.ped_nmro) valor_pedido ");
    sb.append("      , cli_rzao ");
    if ((f.getCb_subtotal_grupo_economico() + "").equals("S") || f.getGerar_planilha_subtotal().equalsIgnoreCase("S")) {
      sb.append("      , nvl(pck_cliente.get_grupo_economico(qry.cli_cdgo), qry.cli_cdgo) grupo_economico ");
      sb.append("      , nvl(pck_grupo_economico.get_nome(pck_cliente.get_grupo_economico(qry.cli_cdgo)), qry.cli_rzao) grupo_descricao ");
    } else {
      sb.append("      , nvl(pck_cliente.get_grupo_economico(qry.cli_cdgo),9999999999) grupo_economico ");
      sb.append("      , pck_grupo_economico.get_nome(pck_cliente.get_grupo_economico(qry.cli_cdgo)) grupo_descricao ");
    }
    sb.append("      , dt_inspecao ");
    sb.append("      , dt_entrega_etiqueta ");
    sb.append("      , (SELECT MIN(NVL(rem_fim, ped_det)) ");
    sb.append("           FROM (SELECT re.rem_fim rem_fim, NULL ped_det, ped_nmro ");
    sb.append("                   FROM remessa re, rem_ped rp ");
    sb.append("                  WHERE re.rem_nro = rp.rem_nro ");
    sb.append("                  UNION ");
    sb.append("                 SELECT NULL rem_fim, ped_det,ped_nmro FROM ped) ");
    sb.append("           WHERE ped_nmro = qry.ped_nmro) dt_montagem ");
    sb.append("       , dados_cadastrados ");
    sb.append("       , possui_carimbo ");
    sb.append("       , somente_etiqueta ");
    sb.append("       , qry.ped_stat || (SELECT MIN(ite_situ) FROM ite i WHERE i.ped_nmro = qry.ped_nmro) situacao ");
    sb.append("       , cabide ");
    sb.append("       , amostra ");
    sb.append("       , DECODE(fct_combinacao_especial(qry.ped_nmro), 'E', 'Comb. Especial', 'NORMAL') tipo_amostra ");
    sb.append("       , (SELECT rowtocol('SELECT ped_nmro FROM ped_amostra_geradas WHERE ped_amostra = ' || qry.ped_nmro) FROM dual) pedido_prod ");
    sb.append("       , dt_ent_amostra_comercial ");
    sb.append("       , dt_ent_amostra_pcp ");
    sb.append("       , encarte ");
    sb.append("       , portao ");
    sb.append("       , cd_entrega ");
    sb.append("       , brio.fct_prazo_entrega_cliente(qry.ped_nmro) data_entrega_cliente ");
    sb.append("       , ped_amostra_brinde ");
    sb.append("       , ped_tipo ");
    sb.append("       , dt_rec_etiqueta_filial ");
    sb.append("       , prioridade_embarque ");
    sb.append("       , atacado ");
    sb.append("       , alerta ");
    sb.append("       , ped_especie_pedido ");
    sb.append("       , ped_obse ");
    sb.append("       , nro_normativa_cliente ");
    sb.append("       , pck_normativas.get_nome(qry.nro_normativa_cliente) descricao_normativa_cliente ");
    sb.append("       , (SELECT NVL(rowtocol(' SELECT DISTINCT cod_min_fabr FROM remessa WHERE rem_nro IN ( SELECT DISTINCT NVL(rp.rem_nro, fct_retorna_remessa(fct_get_pedido_origem(ped_nmro), 1)) FROM rem_ped rp WHERE rp.ped_nmro = fct_get_pedido_origem(' || qry.ped_nmro || ') )'), '') FROM dual) min_fabr ");
    sb.append("       , bloqueio_49 ");
    sb.append("       , preco_pdv ");
    sb.append("       , loja ");
    sb.append("       , pck_cliente.get_cidade(qry.cli_cdgo, qry.esc_seqn) || ' - ' || pck_cliente.get_uf(qry.cli_cdgo, qry.esc_seqn) cidade ");
    sb.append("       , ped_invoice ");
    sb.append("       , (SELECT fretes.fct_retorna_ultima_ocorrencia(nf.emp_empresa, nf.fil_filial, nf.nfs_nmro, nf.nfs_serie) FROM nf_saida nf WHERE nf.ped_nmro = qry.ped_nmro AND NVL(nf.stat_codigo, NULL) = 4 AND ROWNUM = 1) ocorrencia ");
    sb.append("       , DECODE(qry.ped_stat, 'T', pck_pedidos.get_data_ultima_situacao(qry.ped_nmro, pck_situacoes_pedidos.get_situacao_bloqueio), '') data_bloqueio ");
    sb.append("       , data_prevista_desbloqueio ");
    sb.append("       , dt_solicitacao_alarme ");
    sb.append("       , dt_rec_alarme_pcp ");
    sb.append("       , dt_rec_alarme_filial ");
    sb.append("       , nfe_numero ");
    sb.append("       , wbrio.fct_retorna_alt_ped_inf_add(ped_nmro) existe_log_ped_inf_add ");
    sb.append("       , nvl((select 'Sim' from ite_distribuicao_cliente i where i.ped_nmro = qry.ped_nmro and rownum = 1),'Não') distribuicao ");
    sb.append("       , livro ");
    sb.append("       , ref_cliente_por_pedido ");
    sb.append("       , tra_cdgo ");
    sb.append("       , tra_rzao ");
    sb.append("       , dt_corte ");
    sb.append("       , bloqueado_credito ");
    sb.append("       , certificado_origem ");
    sb.append("       , gerar_requisicao ");
    sb.append("       , les_codigo ");
    sb.append("       , rowtocol('select distinct tes_codigo from ite where ped_nmro = ' || ped_nmro) tes_codigo ");
    sb.append("       , data_etiquetagem ");
    sb.append("       , to_char(fct_liberado_faturar_brportal(ped_nmro)) liberado_faturar ");
    sb.append("       , decode(qry.ped_stat,'A', 'Liber.Prod', 'B', 'Em Análise', 'C', 'Cancelado', 'F', 'Faturado', 'L', 'Liberado', 'P', 'Em Análise', 'PF','Parc.Fat', 'T', 'Bloq.Com') descricao_situacao ");
    sb.append("       , pck_embalagens.get_nome(ped_forma_embalagem) descricao_embalagem ");
    sb.append("       , pck_cliente.get_cnpj(cli_cdgo, esc_seqn) cnpj ");
    sb.append("       , numero_romaneio ");
    sb.append("       , data_finalizacao_romaneio ");
    sb.append("       , modelo_alarme ");
    sb.append("       , replace(rowtocol('select distinct ''Grade: ''||gde_cdgo||'' / Corrugado: ''|| codigo_corrugado||''-''||pck_corrugados.get_nome(codigo_corrugado) from ite i where i.ped_nmro = '||ped_nmro),',','<br>') grades_corrugados ");
    sb.append("       , pck_local_estoque.get_filial(les_codigo) filial_local_estoque ");
    sb.append("       , case when (select nvl(cli_exige_pc, 'N') ");
    sb.append("                      from cli cc ");
    sb.append("                     where cc.cli_cdgo = qry.cli_cdgo) = 'N' then 'dotGrey' ");
    sb.append("              else (case when regexp_replace(qry.oc, '[^0-9]', '') is null then 'dotRed' else 'dotGreen' end) end bloqueio_oc ");
    sb.append("       , (select distinct case when exige = 'S' then ");
    sb.append("                   (case when sum(qtd_caixas) over (partition by ped_nmro) > 0 then 'dotGreen' else 'dotRed' end ) ");
    sb.append("                  else ");
    sb.append("                   'dotGrey' ");
    sb.append("               end distribuicao ");
    sb.append("  from (select pe.ped_nmro, ");
    sb.append("(select distribuicao_loja ");
    sb.append("                          from cli_monta_remessa ");
    sb.append("                         where cli_cdgo = pe.cli_cdgo ");
    sb.append("                           and esc_seqn = pe.esc_seqn) exige ");
    sb.append(",             idc.qtd_caixas qtd_caixas ");
    sb.append("          from ped pe, ite_distribuicao_cliente idc ");
    sb.append("         where pe.ped_nmro = idc.ped_nmro (+) ");
    sb.append("           and pe.ped_nmro = qry.ped_nmro ");
    sb.append("           )) bloqueio_distribuicao ");

    sb.append("       , cli_situ bloqueio_cliente ");
    sb.append("       , nvl((select case when exige_sku = 'N' then 'dotGrey' ");
    sb.append("                      when (sku is null and exige_sku = 'S') then 'dotRed' ");
    sb.append("                      when (sku is not null and exige_sku = 'S') then 'dotGreen' end status ");
    sb.append("      from (SELECT fct_descricao_produto(p.cli_cdgo, p.esc_seqn, i.lin_cdgo, i.ref_cdgo, i.cab_cdgo, i.cor_cdgo, q.qtp_nume, 'E', i.ped_nmro, i.ite_seqn, pia.cod_tipo_compra) sku  ");
    sb.append("                 , NVL(cia.exige_sku, 'N') exige_sku ");
    sb.append("              FROM ped p  ");
    sb.append("                 , ite i  ");
    sb.append("                 , qtd_prg q  ");
    sb.append("                 , compromete_pedido cp  ");
    sb.append("                 , ped_inf_adicionais pia  ");
    sb.append("                 , cli_inf_adicionais cia  ");
    sb.append("             WHERE p.ped_nmro = i.ped_nmro  ");
    sb.append("               AND i.ped_nmro = q.ped_nmro  ");
    sb.append("               AND i.ite_seqn = q.ite_seqn  ");
    sb.append("               AND i.ped_nmro = cp.ped_nmro  ");
    sb.append("               AND i.ite_seqn = cp.ite_seqn  ");
    sb.append("               AND p.ped_nmro = pia.ped_nmro  ");
    sb.append("               AND p.cli_cdgo = cia.cli_cdgo  ");
    sb.append("               AND p.esc_seqn = cia.esc_seqn ");
    sb.append("               and p.ped_nmro = qry.ped_nmro ");
    sb.append("               and rownum = 1)),'dotGrey') bloqueio_sku ");
    sb.append("       , 'BC' bloqueio_credito ");
    sb.append("       , case when (select 1 ");
    sb.append("                    from estabelecimentos_venda_ordem evo ");
    sb.append("                   where qry.cli_cdgo = evo.cli_cdgo_origem ");
    sb.append("                     and qry.esc_seqn = evo.esc_seqn_origem ");
    sb.append("                     and NVL(evo.suframa, 'N') = 'S' ");
    sb.append("                     and evo.status = 'A' ");
    sb.append("                     and NVL(evo.vigencia_final, SYSDATE) >= SYSDATE) is null then 'dotGrey' ");
    sb.append("   else (case when qry.tra_cdgo_internar is not null then 'dotRed' else 'dotGreen' end) end bloqueio_suframa ");
    sb.append("    , case when (select 1 from cli_respeita_tranca_fat_vw v where v.cli_cdgo = qry.cli_Cdgo) is null then 'dotRed' else 'dotGreen' end bloqueio_antecipacao ");

    sb.append(" FROM ( ");

    if (f.getDt_nf_inicial() != "" || consultaCorte || consultaMultiplosPedidos) {
      sb.append(" SELECT /*+ index(p PK_PED) */ DISTINCT ped.ped_nmro ");
    } else {
      sb.append(" SELECT DISTINCT ped.ped_nmro ");
    }
    sb.append("      , ped.ped_boni ");
    sb.append("      , ped.ped_boni2 ");
    sb.append("      , ped.ped_desc ");
    sb.append("      , ped.tra_cdgo_internar ");
    sb.append("      , ped.cnd_cdgo || ' - ' || (SELECT cnd_desc FROM cnd WHERE cnd_cdgo = ped.cnd_cdgo) cnd_cdgo ");
    sb.append("      , ped.liv_codigo || ' - ' || pck_livro.get_nome(ped.liv_codigo) livro ");
    sb.append("      , ped.ped_ped_cliente oc ");
    sb.append("      , pi.etiquetas ");
    sb.append("      , pi.obse_adicionais ");
    sb.append("      , pi.fil_filial_fat ");
    sb.append("      , ped.ped_daem dt_emiss ");
    sb.append("      , ped.ped_dadg dt_digit ");
    sb.append("      , ped.ped_det dt_fatur ");
    sb.append("      , pi.dt_fatur_filial ");
    sb.append("      , pi.carimbo ");
    sb.append("      , pi.rotulos ");
    sb.append("      , pi.dt_envio_amostras ");
    sb.append("      , pi.agendamento_cdgo ");
    sb.append("      , pi.dt_agendamento data_efetiva ");
    sb.append("      , rep.codigo_regional ");
    sb.append("      , rep.rep_cdgo ");
    sb.append("      , ped.cli_cdgo ");
    sb.append("      , null codigo_marca ");
    sb.append("      , ped.ped_stat ");
    sb.append("      , decode(pi.ped_nmro,NULL,'N','S') existe ");
    sb.append("      , pi.horario_entrega hora ");
    sb.append("      , pi.senha_entrega senha ");
    sb.append("      , rep.rep_rzao ");
    sb.append("      , ped.esc_seqn ");
    sb.append("      , cli.cli_rzao ");
    sb.append("      , pi.dt_inspecao ");
    sb.append("      , pi.dt_entrega_etiqueta ");
    sb.append("      , decode(nvl(pi.ped_nmro,0),0,'N','S') dados_cadastrados ");
    sb.append("      , decode(NVL(cia.possui_carimbo,'N'),'N','N','S') possui_carimbo ");
    sb.append("      , decode(NVL(cia.somente_etiqueta,'N'),'N','N','S') somente_etiqueta ");
    sb.append("      , pi.cabide ");
    sb.append("      , CASE WHEN (ped_especie_pedido = 'A') THEN 'S' END amostra ");
    sb.append("      , pi.dt_ent_amostra_comercial ");
    sb.append("      , pi.dt_ent_amostra_pcp ");
    sb.append("      , pi.encarte ");
    sb.append("      , pi.portao ");
    sb.append("      , pi.cd_entrega ");
    sb.append("      , ped.ped_amostra_brinde ");
    sb.append("      , ped.ped_tipo ");
    sb.append("      , pi.dt_rec_etiqueta_filial ");
    sb.append("      , pi.prioridade_embarque ");
    sb.append("      , decode(cli.cla_cdgo,'ATA','Sim','Não') atacado ");
    sb.append("      , case when nvl(pi.ped_brinde_mkt, 'N') = 'S' then '1' else (decode(nvl(cia.somente_etiqueta,'N'),'S',(CASE ");
    sb.append("          WHEN (ped_stat = 'F' OR dt_rec_etiqueta_filial IS NOT NULL) THEN ");
    sb.append("           '1' ");
    sb.append("          WHEN (ped_stat <> 'F' AND dt_rec_etiqueta_filial IS NULL AND ((TRUNC(ped.ped_det) - TRUNC(SYSDATE)) <= 5)) THEN ");
    sb.append("           '3' ");
    sb.append("          ELSE ");
    sb.append("           '2' ");
    sb.append("        END),'0')) end alerta ");
    sb.append("      , ped.ped_especie_pedido ");
    sb.append("      , ped.ped_obse ");
    sb.append("      , cmr.nro_normativa_cliente ");
    sb.append("      , CASE WHEN NVL(ped.ped_usuario_liber_credito, NULL) IS NULL THEN ");
    sb.append("          CASE WHEN (SELECT 'S' ");
    sb.append("                    FROM cli_bloqueio ");
    sb.append("                   WHERE blo_codigo_bloqueio = 49 ");
    sb.append("                     AND status = 'A' ");
    sb.append("                     AND cli_Cdgo = ped.cli_cdgo) = 'S' THEN ");
    sb.append("             'S' ELSE 'N' END ");
    sb.append("         ELSE ");
    sb.append("          'N' ");
    sb.append("       END bloqueio_49 ");
    sb.append("      ,(SELECT NVL((SELECT 'N' FROM dual WHERE EXISTS (SELECT 1 FROM ite i WHERE i.ped_nmro = ped.ped_nmro AND NVL(i.ite_preco_venda,0) = 0)), 'S') preco FROM dual) preco_pdv ");
    sb.append("      , cia.loja ");
    sb.append("      , ped_invoice ");
    sb.append("      , decode(ped.ped_stat, 'T', pi.data_prevista_desbloqueio,'') data_prevista_desbloqueio ");
    sb.append("      , pi.dt_solicitacao_alarme ");
    sb.append("      , pi.dt_rec_alarme_pcp ");
    sb.append("      , pi.dt_rec_alarme_filial ");
    sb.append("      , pi.nfe_numero ");
    sb.append("      , nvl(cia.ref_cliente_por_pedido,'N') ref_cliente_por_pedido ");
    sb.append("      , tra.tra_cdgo ");
    sb.append("      , tra.tra_rzao ");
    sb.append("      , pck_remessa.get_inicio(fct_retorna_remessa(fct_get_pedido_origem(ped.ped_nmro), 1)) dt_corte ");
    sb.append("      , CASE WHEN NVL(ped.ped_usuario_liber_credito, NULL) IS NULL THEN CASE WHEN ped_stat = 'P' THEN 'S' ELSE (CASE WHEN (SELECT 'S' ");
    sb.append("                 FROM cli_bloqueio ");
    sb.append("                WHERE blo_codigo_bloqueio IN (48, 50) ");
    sb.append("                  AND status = 'A' ");
    sb.append("                  AND rownum = 1 ");
    sb.append("                  AND cli_Cdgo = ped.cli_cdgo) = 'S' THEN 'S' ELSE 'N' END) END ELSE 'N' END bloqueado_credito ");
    sb.append("      , ob.texto certificado_origem ");
    sb.append("      , nvl(pi.gerar_requisicao, 'N') gerar_requisicao ");
    sb.append("      , ped.les_codigo ");
    sb.append("      , pi.data_etiquetagem ");
    sb.append("      , ped.ped_forma_embalagem ");
    sb.append("      , cli.cli_situ ");

    if (consultaRomaneio) {
      sb.append("   , nr.numero_romaneio ");
      sb.append("   , nr.data_finalizacao_romaneio ");
    } else {
      sb.append("   , null numero_romaneio ");
      sb.append("   , null data_finalizacao_romaneio ");
    }
    sb.append("      , pi.modelo_alarme ");
    sb.append("   FROM brio.ped_inf_adicionais pi ");
    sb.append("      , ite ");

    if (!restringeTipoMercado) {
      sb.append("   , ped ");
    } else {
      sb.append(sbPed.toString());
    }
    sb.append("      , brio.agendamento_clientes ac ");
    sb.append("      , cli_monta_remessa cmr ");
    sb.append("      , rep ");
    sb.append("      , tra ");

    if (consultaRomaneio) {
      sb.append("   , (SELECT nfsp.ped_nmro ");
      sb.append("           , re.numero numero_romaneio ");
      sb.append("           , to_char(re.data_finalizacao, 'dd/mm/yyyy hh24:mi:ss') data_finalizacao_romaneio ");
      sb.append("        FROM notas_fiscais_saida_ped_venda nfsp ");
      sb.append("           , romaneios_embarque            re ");
      sb.append("           , nf_saida                      n ");
      sb.append("       WHERE n.nro_romaneio_embarque = re.numero ");
      sb.append("         AND nfsp.emp_empresa = n.emp_empresa ");
      sb.append("         AND nfsp.fil_filial = n.fil_filial ");
      sb.append("         AND nfsp.nfs_nmro = n.nfs_nmro ");
      sb.append("         AND nfsp.nfs_serie = n.nfs_serie) nr ");
    }

    sb.append("      , cli ");
    sb.append("      , brio.cli_inf_adicionais cia ");
    sb.append("      , fat.observacoes_nat_oper_pedido ob ");

    if (f.getPed_ped_cliente() != "") {
      sb.append("      , tmp_generic_table_brportal tgt ");
    }

    if (f.getGre_grupo() != "") {
      sb.append("    , grupo_economico ge ");
    }

    sb.append("  WHERE rep.rep_cdgo = ped.rep_cdgo ");

    if (f.getDistribuicao().equalsIgnoreCase("N")) {
      sb.append(" AND NOT EXISTS (select 1 from ite_distribuicao_cliente idc where idc.ped_nmro = ped.ped_nmro) ");
    }
    if (f.getDistribuicao().equalsIgnoreCase("S")) {
      sb.append(" AND EXISTS (select 1 from ite_distribuicao_cliente idc where idc.ped_nmro = ped.ped_nmro) ");
    }

    sb.append("    AND cli.cli_cdgo = ped.cli_cdgo ");
    sb.append("    AND tra.tra_cdgo = ped.tra_cdgo ");
    sb.append("    AND cmr.cli_cdgo (+) = ped.cli_cdgo ");
    sb.append("    AND cmr.esc_seqn (+) = ped.esc_seqn ");

    if (filtraDataAgendamento) {
      sb.append("    AND pi.ped_nmro = ped.ped_nmro ");
    } else {
      sb.append("    AND pi.ped_nmro (+) = ped.ped_nmro ");
    }

    sb.append("    AND ac.id_agendamento (+) = pi.agendamento_cdgo ");
    sb.append("    AND ite.ped_nmro = ped.ped_nmro ");

    if (f.getGre_grupo() != "") {
      sb.append("  AND ge.gre_grupo = " + f.getGre_grupo());
      sb.append("  AND cli.cli_cdgo = ge.cli_cdgo ");
      sb.append("  AND ge.status = 'A' ");
    }

    if (f.getTipo_produto() != "") {
      sb.append("  AND pck_referencia.get_grupo_posicao_fab(ite.lin_cdgo, ite.ref_cdgo) in (").append(f.getTipo_produto()).append(")");
    }

    if (f.getNro_normativa() != "") {
      sb.append(" AND cmr.nro_normativa_cliente = " + f.getNro_normativa());
    }

    if (f.getNf_numero() != "") {
      consultaMultiplasNotas = true;
      String notas = f.getNf_numero().replaceAll("[^0-9]", " ").trim();
      notas = notas.replaceAll("\\s+", " ");
      notas = notas.replaceAll(" ", "\n");
      notas = notas.replaceAll("\\r\\n|\\r|\\n", ",");

      if ((notas.charAt(notas.length() - 1) + "").equalsIgnoreCase(",")) {
        notas = notas.substring(0, notas.lastIndexOf(","));
      }

      sb.append(" AND EXISTS(SELECT NULL FROM nf_saida nf WHERE nf.ped_nmro = ped.ped_nmro AND nf.nfs_nmro IN (" + notas + ")");
      if (!f.getNf_serie().equals("")) {

        sb.append(" AND nf.nfs_serie = '").append(f.getNf_serie()).append("'");
      }
      sb.append(" AND ROWNUM = 1) ");

    }

    if (consultaRomaneio) {
      sb.append(" AND ped.ped_nmro = nr.ped_nmro(+) ");
    }
    sb.append("    AND cia.cli_cdgo (+) = ped.cli_cdgo ");
    sb.append("    AND cia.esc_seqn (+) = ped.esc_seqn ");
    sb.append("    AND ob.ped_nmro  (+) = ped.ped_nmro ");
    sb.append("    AND ob.obs_cdgo(+) = 512 ");
    sb.append(parametros.toString());

    if (f.getGerar_planilha_subtotal().equals("S")) {
      sb.append(" ) group by codigo_regional, nome_regional, grupo_economico, grupo_descricao order by prs desc ");
    }


    //------------------------------------------
    if (usuario.mostraQuery()) {
      throw new Exception(sb.toString());
    }
    if (false) {
      throw new Exception(sb.toString());
    }
    //------------------------------------------

    session.setAttribute("where", sb.toString());


    //----- CheckBox -------
    session.removeAttribute("amostra");
    //----------------------
    session.removeAttribute("cb_bloqueado_credito");
    session.removeAttribute("cb_bloqueio_49");
    session.removeAttribute("cb_bloqueio_uf");
    session.removeAttribute("cb_tipo_estoque");
    session.removeAttribute("cb_local_estoque");
    session.removeAttribute("cb_data_etiquetagem");
    session.removeAttribute("cb_gerar_requisicao");
    session.removeAttribute("cb_alerta_etiqueta");
    session.removeAttribute("cb_distribuicao");
    session.removeAttribute("cb_nota_fiscal_alarme");
    session.removeAttribute("cb_dt_recebimento_alarme_filial");
    session.removeAttribute("cb_dt_recebimento_alarme");
    session.removeAttribute("cb_dt_solicitacao_alarme");
    session.removeAttribute("cb_data_prevista_desbloqueio");
    session.removeAttribute("cb_data_bloqueio");
    session.removeAttribute("cb_obs_pedido");
    session.removeAttribute("cb_normativa_cliente");
    session.removeAttribute("cb_loja");
    session.removeAttribute("cb_cidade");
    session.removeAttribute("cb_razao_social");
    session.removeAttribute("cb_seq");
    session.removeAttribute("cb_emiss");
    session.removeAttribute("cb_mini_fabrica");
    session.removeAttribute("cb_valor");
    session.removeAttribute("cb_invoice");
    session.removeAttribute("cb_desc_pont");
    session.removeAttribute("cb_desc_prom");
    session.removeAttribute("cb_desc_com");
    session.removeAttribute("cb_cnd_cdgo");
    session.removeAttribute("cb_livro");
    session.removeAttribute("cb_tra_cdgo");
    session.removeAttribute("cb_especie");
    session.removeAttribute("cb_regional");
    session.removeAttribute("cb_grupo_economico");
    session.removeAttribute("cb_cliente");
    session.removeAttribute("cb_representante");
    session.removeAttribute("cb_pedido");
    session.removeAttribute("cb_situacao");
    session.removeAttribute("cb_tipo_pedido");
    session.removeAttribute("cb_oc");
    session.removeAttribute("cb_linha");
    session.removeAttribute("cb_etiquetas");
    session.removeAttribute("cb_dt_entrega_etiqueta");
    session.removeAttribute("cb_dt_rec_etiqueta_filial");
    session.removeAttribute("cb_obs");
    session.removeAttribute("cb_pares");
    session.removeAttribute("cb_rem");
    session.removeAttribute("cb_fl_prod");
    session.removeAttribute("cb_fl_fat");
    session.removeAttribute("cb_digit");
    session.removeAttribute("cb_dt_montagem");
    session.removeAttribute("cb_dt_corte");
    session.removeAttribute("cb_fat_cli");
    session.removeAttribute("cb_fat_br");
    session.removeAttribute("cb_marca");
    session.removeAttribute("cb_cabide");
    session.removeAttribute("cb_carimbo");
    session.removeAttribute("cb_rotulos");
    session.removeAttribute("cb_ped_amostra");
    session.removeAttribute("cb_dt_envio");
    session.removeAttribute("cb_agenda");
    session.removeAttribute("cb_dezena");
    session.removeAttribute("cb_dia");
    session.removeAttribute("cb_dt_efetiva");
    session.removeAttribute("cb_hora");
    session.removeAttribute("cb_senha");
    session.removeAttribute("cb_portao_entrega");
    session.removeAttribute("cb_cd_entrega");
    session.removeAttribute("cb_emissao");
    session.removeAttribute("cb_filial");
    session.removeAttribute("cb_nf");
    session.removeAttribute("cb_volumes");
    session.removeAttribute("cb_dt_inspecao");
    session.removeAttribute("cb_dt_entrega");
    session.removeAttribute("cb_amostra_brinde");
    session.removeAttribute("cb_encarte");
    session.removeAttribute("cb_prioridade_embarque");
    session.removeAttribute("cb_atacado");
    session.removeAttribute("cb_dt_ultima_ocorrencia");
    session.removeAttribute("subtotal_grupo_economico");
    session.removeAttribute("cb_descricao_item");
    session.removeAttribute("cb_descricao_embalagem");
    session.removeAttribute("cb_cnpj");
    session.removeAttribute("cb_romaneio");
    session.removeAttribute("cb_grade_corrugado");
    session.removeAttribute("preco_pdv");
    //----------------------
    if ((f.getCb_descricao_embalagem() + "").equals("1")) {
      session.setAttribute("cb_descricao_embalagem", true);
    }
    if ((f.getCb_cnpj() + "").equals("1")) {
      session.setAttribute("cb_cnpj", true);
    }
    if ((f.getCb_descricao_item() + "").equals("1")) {
      session.setAttribute("cb_descricao_item", true);
    }
    if ((f.getPreco_pdv() + "").equals("1")) {
      session.setAttribute("preco_pdv", true);
    }
    if ((f.getCb_alerta_etiqueta() + "").equals("1")) {
      session.setAttribute("cb_alerta_etiqueta", true);
    }
    if ((f.getCb_bloqueado_credito() + "").equals("1")) {
      session.setAttribute("cb_bloqueado_credito", true);
    }
    if ((f.getCb_bloqueio_49() + "").equals("1")) {
      session.setAttribute("cb_bloqueio_49", true);
    }
    if ((f.getCb_bloqueio_uf() + "").equals("1")) {
      session.setAttribute("cb_bloqueio_uf", true);
    }
    if ((f.getCb_tipo_estoque() + "").equals("1")) {
      session.setAttribute("cb_tipo_estoque", true);
    }
    if ((f.getCb_local_estoque() + "").equals("1")) {
      session.setAttribute("cb_local_estoque", true);
    }
    if ((f.getCb_data_etiquetagem() + "").equals("1")) {
      session.setAttribute("cb_data_etiquetagem", true);
    }
    if ((f.getCb_gerar_requisicao() + "").equals("1")) {
      session.setAttribute("cb_gerar_requisicao", true);
    }
    if ((f.getCb_distribuicao() + "").equals("1")) {
      session.setAttribute("cb_distribuicao", true);
    }
    if ((f.getCb_nota_fiscal_alarme() + "").equals("1")) {
      session.setAttribute("cb_nota_fiscal_alarme", true);
    }
    if ((f.getCb_dt_recebimento_alarme_filial() + "").equals("1")) {
      session.setAttribute("cb_dt_recebimento_alarme_filial", true);
    }
    if ((f.getCb_dt_recebimento_alarme() + "").equals("1")) {
      session.setAttribute("cb_dt_recebimento_alarme", true);
    }
    if ((f.getCb_dt_solicitacao_alarme() + "").equals("1")) {
      session.setAttribute("cb_dt_solicitacao_alarme", true);
    }
    if ((f.getCb_data_prevista_desbloqueio() + "").equals("1")) {
      session.setAttribute("cb_data_prevista_desbloqueio", true);
    }
    if ((f.getCb_data_bloqueio() + "").equals("1")) {
      session.setAttribute("cb_data_bloqueio", true);
    }
    if ((f.getCb_obs_pedido() + "").equals("1")) {
      session.setAttribute("cb_obs_pedido", true);
    }
    if ((f.getCb_normativa_cliente() + "").equals("1")) {
      session.setAttribute("cb_normativa_cliente", true);
    }
    if ((f.getCb_loja() + "").equals("1")) {
      session.setAttribute("cb_loja", true);
    }
    if ((f.getCb_cidade() + "").equals("1")) {
      session.setAttribute("cb_cidade", true);
    }
    if ((f.getCb_razao_social() + "").equals("1")) {
      session.setAttribute("cb_razao_social", true);
    }
    if ((f.getCb_seq() + "").equals("1")) {
      session.setAttribute("cb_seq", true);
    }
    if ((f.getCb_emiss() + "").equals("1")) {
      session.setAttribute("cb_emiss", true);
    }
    if ((f.getCb_mini_fabrica() + "").equals("1")) {
      session.setAttribute("cb_mini_fabrica", true);
    }
    if ((f.getCb_valor() + "").equals("1")) {
      session.setAttribute("cb_valor", true);
    }
    if ((f.getCb_invoice() + "").equals("1")) {
      session.setAttribute("cb_invoice", true);
    }
    if ((f.getCb_desc_pont() + "").equals("1")) {
      session.setAttribute("cb_desc_pont", true);
    }
    if ((f.getCb_desc_prom() + "").equals("1")) {
      session.setAttribute("cb_desc_prom", true);
    }
    if ((f.getCb_desc_com() + "").equals("1")) {
      session.setAttribute("cb_desc_com", true);
    }
    if ((f.getCb_cnd_cdgo() + "").equals("1")) {
      session.setAttribute("cb_cnd_cdgo", true);
    }
    if ((f.getCb_livro() + "").equals("1")) {
      session.setAttribute("cb_livro", true);
    }
    if ((f.getCb_tra_cdgo() + "").equals("1")) {
      session.setAttribute("cb_tra_cdgo", true);
    }
    if ((f.getCb_especie() + "").equals("1")) {
      session.setAttribute("cb_especie", true);
    }
    if ((f.getCb_dt_ultima_ocorrencia() + "").equals("1")) {
      session.setAttribute("cb_dt_ultima_ocorrencia", true);
    }
    if ((f.getCb_regional() + "").equals("1")) {
      session.setAttribute("cb_regional", true);
    }
    if ((f.getCb_grupo_economico() + "").equals("1")) {
      session.setAttribute("cb_grupo_economico", true);
    }
    if ((f.getCb_cliente() + "").equals("1")) {
      session.setAttribute("cb_cliente", true);
    }
    if ((f.getCb_representante() + "").equals("1")) {
      session.setAttribute("cb_representante", true);
    }
    if ((f.getCb_pedido() + "").equals("1")) {
      session.setAttribute("cb_pedido", true);
    }
    if ((f.getCb_situacao() + "").equals("1")) {
      session.setAttribute("cb_situacao", true);
    }
    if ((f.getCb_tipo_pedido() + "").equals("1")) {
      session.setAttribute("cb_tipo_pedido", true);
    }
    if ((f.getCb_oc() + "").equals("1")) {
      session.setAttribute("cb_oc", true);
    }
    if ((f.getCb_linha() + "").equals("1")) {
      session.setAttribute("cb_linha", true);
    }
    if ((f.getCb_etiquetas() + "").equals("1")) {
      session.setAttribute("cb_etiquetas", true);
    }
    if ((f.getCb_dt_entrega_etiqueta() + "").equals("1")) {
      session.setAttribute("cb_dt_entrega_etiqueta", true);
    }
    if ((f.getCb_dt_rec_etiqueta_filial() + "").equals("1")) {
      session.setAttribute("cb_dt_rec_etiqueta_filial", true);
    }
    if ((f.getCb_obs() + "").equals("1")) {
      session.setAttribute("cb_obs", true);
    }
    if ((f.getCb_pares() + "").equals("1")) {
      session.setAttribute("cb_pares", true);
    }
    if ((f.getCb_rem() + "").equals("1")) {
      session.setAttribute("cb_rem", true);
    }
    if ((f.getCb_fl_prod() + "").equals("1")) {
      session.setAttribute("cb_fl_prod", true);
    }
    if ((f.getCb_fl_fat() + "").equals("1")) {
      session.setAttribute("cb_fl_fat", true);
    }
    if ((f.getCb_digit() + "").equals("1")) {
      session.setAttribute("cb_digit", true);
    }
    if ((f.getCb_dt_montagem() + "").equals("1")) {
      session.setAttribute("cb_dt_montagem", true);
    }
    if ((f.getCb_dt_corte() + "").equals("1")) {
      session.setAttribute("cb_dt_corte", true);
    }
    if ((f.getCb_fat_cli() + "").equals("1")) {
      session.setAttribute("cb_fat_cli", true);
    }
    if ((f.getCb_fat_br() + "").equals("1")) {
      session.setAttribute("cb_fat_br", true);
    }
    if ((f.getCb_marca() + "").equals("1")) {
      session.setAttribute("cb_marca", true);
    }
    if ((f.getCb_cabide() + "").equals("1")) {
      session.setAttribute("cb_cabide", true);
    }
    if ((f.getCb_carimbo() + "").equals("1")) {
      session.setAttribute("cb_carimbo", true);
    }
    if ((f.getCb_rotulos() + "").equals("1")) {
      session.setAttribute("cb_rotulos", true);
    }
    if ((f.getCb_ped_amostra() + "").equals("1")) {
      session.setAttribute("cb_ped_amostra", true);
    }
    if ((f.getCb_dt_envio() + "").equals("1")) {
      session.setAttribute("cb_dt_envio", true);
    }
    if ((f.getCb_agenda() + "").equals("1")) {
      session.setAttribute("cb_agenda", true);
    }
    if ((f.getCb_dezena() + "").equals("1")) {
      session.setAttribute("cb_dezena", true);
    }
    if ((f.getCb_dia() + "").equals("1")) {
      session.setAttribute("cb_dia", true);
    }
    if ((f.getCb_dt_efetiva() + "").equals("1")) {
      session.setAttribute("cb_dt_efetiva", true);
    }
    if ((f.getCb_hora() + "").equals("1")) {
      session.setAttribute("cb_hora", true);
    }
    if ((f.getCb_senha() + "").equals("1")) {
      session.setAttribute("cb_senha", true);
    }
    if ((f.getCb_portao_entrega() + "").equals("1")) {
      session.setAttribute("cb_portao_entrega", true);
    }
    if ((f.getCb_cd_entrega() + "").equals("1")) {
      session.setAttribute("cb_cd_entrega", true);
    }
    if ((f.getCb_emissao() + "").equals("1")) {
      session.setAttribute("cb_emissao", true);
    }
    if ((f.getCb_filial() + "").equals("1")) {
      session.setAttribute("cb_filial", true);
    }
    if ((f.getCb_nf() + "").equals("1")) {
      session.setAttribute("cb_nf", true);
    }
    if ((f.getCb_volumes() + "").equals("1")) {
      session.setAttribute("cb_volumes", true);
    }
    if ((f.getCb_dt_inspecao() + "").equals("1")) {
      session.setAttribute("cb_dt_inspecao", true);
    }
    if ((f.getCb_dt_entrega() + "").equals("1")) {
      session.setAttribute("cb_dt_entrega", true);
    }
    if ((f.getCb_amostra_brinde() + "").equals("1")) {
      session.setAttribute("cb_amostra_brinde", true);
    }
    if ((f.getCb_encarte() + "").equals("1")) {
      session.setAttribute("cb_encarte", true);
    }
    if ((f.getCb_prioridade_embarque() + "").equals("1")) {
      session.setAttribute("cb_prioridade_embarque", true);
    }
    if ((f.getCb_atacado() + "").equals("1")) {
      session.setAttribute("cb_atacado", true);
    }
    if ((f.getCb_romaneio() + "").equals("1")) {
      session.setAttribute("cb_romaneio", true);
    }
    if ((f.getCb_grade_corrugado() + "").equals("1")) {
      session.setAttribute("cb_grade_corrugado", true);
    }

    //----------------------
    if ((f.getCb_somente_amostra() + "").equals("S")) {
      session.setAttribute("amostra", true);
    }
    //----------------------
    if ((f.getCb_subtotal_grupo_economico() + "").equals("S")) {
      session.setAttribute("subtotal_grupo_economico", true);
    }
    session.setAttribute("mapping.getName()", form);

  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ControleClientesEspeciaisActionForm f = (ControleClientesEspeciaisActionForm) form;
      tg_resetfull_action(mapping, form, request, response);
      session.removeAttribute("res_Controle_clientes_especiais_vw");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      session.setAttribute("possui_dados","0");
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Controle_clientes_especiais_vw", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
  private void tg_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      ControleClientesEspeciaisActionForm f = (ControleClientesEspeciaisActionForm) form;
      session.removeAttribute("listaSituacoes");
      session.removeAttribute("listaEspecies");
      session.removeAttribute("tipos_pedidos_selecionados_vetor");
      session.removeAttribute("tipos_pedidos_selecionados_codigos");
      session.removeAttribute("tipos_produtos_selecionados_vetor");
      session.removeAttribute("tipos_produtos_selecionados_codigos");
      session.removeAttribute("est102_marcas_selecionadas_vetor");
      session.removeAttribute("est102_marcas_selecionadas_codigos");
      session.removeAttribute("res_status_pedido");
      session.removeAttribute("especies");
      session.removeAttribute("gerar_planilha");
      session.removeAttribute("gerar_planilha_subtotal");
      session.removeAttribute("somente_consulta");
      session.removeAttribute("mostrar_filiais_producao");
      session.removeAttribute("consulta_pedidos_status_pedido");
      session.removeAttribute("res_status_situacoes");
      session.removeAttribute("consulta_pedidos_status_situacoes");
      session.removeAttribute("where");
      session.removeAttribute("selecionou_locais");
      session.removeAttribute("locais_selecionados");
      session.removeAttribute("codigos_locais_selecionados");
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    } finally {
    }
  }
  public ActionForward perform_refresh_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ControleClientesEspeciaisActionForm f = (ControleClientesEspeciaisActionForm) form;
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Controle_clientes_especiais_vw", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
