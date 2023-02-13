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
 * Creation Date 25/05/2011 14:08:30
 * Last Modify Date 16/09/2022 16:11:51
 */

public class ControleClientesEspeciais_mAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ControleClientesEspeciais_mActionForm[]_ge_grid_array = (ControleClientesEspeciais_mActionForm[])_ge_grid.get("bl_form_Controle_clientes_especiais_vw_lines");
      ControleClientesEspeciais_mActionForm f = _ge_grid_array[0];
      select_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
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
    DynaActionForm _ge_grid = (DynaActionForm) form;
    ControleClientesEspeciais_mActionForm[]_ge_grid_array = (ControleClientesEspeciais_mActionForm[])_ge_grid.get("bl_form_Controle_clientes_especiais_vw_lines");
    ControleClientesEspeciais_mActionForm f = _ge_grid_array[0];
    if (f != null) {
      Controle_clientes_especiais_vw table = new Controle_clientes_especiais_vw();
      String where = (String) session.getAttribute("where");
      Vector res_Controle_clientes_especiais_vw = j.select(table, where, null);
      session.setAttribute("res_Controle_clientes_especiais_vw",res_Controle_clientes_especiais_vw);
      util.consultas.com.ControleClientesEspeciais c = new util.consultas.com.ControleClientesEspeciais();
      String arquivo = "";
      if (session.getAttribute("gerar_planilha") != null) {
        arquivo = c.geraExcel(request);
      }
      if (session.getAttribute("gerar_planilha_subtotal") != null) {
        arquivo = c.geraExcelSubtotal(request);
      }
      if (arquivo != "") {
        session.setAttribute("arquivo", arquivo);
      }
      if (res_Controle_clientes_especiais_vw != null && res_Controle_clientes_especiais_vw.size() > 0) {
        ControleClientesEspeciais_mActionForm[]_ge_grid_array_flex = new ControleClientesEspeciais_mActionForm[res_Controle_clientes_especiais_vw.size()];
        org.apache.struts.config.ConfigEGenHelper.setFormPropertySize(mapping, "bl_form_Controle_clientes_especiais_vw_lines", res_Controle_clientes_especiais_vw.size());
        int _ge_pos = 0;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array_flex.length; _ge_grid_array_index++, _ge_pos++) {
          if (_ge_grid_array_index < _ge_grid_array.length) {
            f = _ge_grid_array[_ge_grid_array_index];
          } else {
            f = new ControleClientesEspeciais_mActionForm();
            ActionServletWrapper actionServletWrapper = form.getServletWrapper();
            org.apache.struts.upload.CommonsMultipartRequestHandler commonsMultipartRequestHandler = new org.apache.struts.upload.CommonsMultipartRequestHandler();
            actionServletWrapper.setServletFor(commonsMultipartRequestHandler);
            f.setServlet(commonsMultipartRequestHandler.getServlet());
          }
          f.reset(mapping, request);
          if (res_Controle_clientes_especiais_vw.size() > _ge_pos) {
            Controle_clientes_especiais_vw r = (Controle_clientes_especiais_vw) res_Controle_clientes_especiais_vw.elementAt(_ge_pos);
            f.setPed_nmro((r.getPed_nmro() != null) ? r.getPed_nmro() + "":"");
            f.setTra_cdgo((r.getTra_cdgo() != null) ? r.getTra_cdgo() + "":"");
            f.setTra_rzao((r.getTra_rzao() != null) ? r.getTra_rzao() + "":"");
            f.setOc((r.getOc() != null) ? r.getOc() + "":"");


            String[] n = r.getModelos().split("#");
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            int contador = 0;
            for (String s :
                n) {
              if (contador % 2 != 0) {
                if (sb.length() > 0) {
                  sb.append(" - ");
                }
                sb.append(s);
              } else {
                sb2.append(s);
              }
              contador++;
            }
            r.setModelos(sb2.toString());
            r.setDescricao_modelos(sb.toString());


            f.setModelos((r.getModelos() != null) ? r.getModelos() + "":"");
            f.setDescricao_modelos((r.getDescricao_modelos() != null) ? r.getDescricao_modelos() + "":"");
            f.setEtiquetas((r.getEtiquetas() != null) ? r.getEtiquetas() + "":"");
            f.setDt_entrega_etiqueta(com.egen.util.text.FormatDate.format(r.getDt_entrega_etiqueta(), "dd/MM/yyyy"));
            f.setObse_adicionais((r.getObse_adicionais() != null) ? r.getObse_adicionais() + "":"");
            f.setCertificado_origem((r.getCertificado_origem() != null) ? r.getCertificado_origem() + "":"");
            f.setPrs((r.getPrs() != null) ? r.getPrs() + "":"");
            f.setRemessa((r.getRemessa() != null) ? r.getRemessa() + "":"");
            f.setFilial_prd((r.getFilial_prd() != null) ? r.getFilial_prd() + "":"");
            f.setFil_filial_fat((r.getFil_filial_fat() != null) ? r.getFil_filial_fat() + "":"");
            f.setDt_digit(com.egen.util.text.FormatDate.format(r.getDt_digit(), "dd/MM/yyyy"));
            f.setDt_fatur(com.egen.util.text.FormatDate.format(r.getDt_fatur(), "dd/MM/yyyy"));
            f.setDt_fatur_filial(com.egen.util.text.FormatDate.format(r.getDt_fatur_filial(), "dd/MM/yyyy"));
            f.setMarca((r.getMarca() != null) ? r.getMarca() + "":"");
            f.setCarimbo((r.getCarimbo() != null) ? r.getCarimbo() + "":"");
            f.setRotulos((r.getRotulos() != null) ? r.getRotulos() + "":"");
            f.setPed_amostra((r.getPed_amostra() != null) ? r.getPed_amostra() + "":"");
            f.setDt_envio_amostras(com.egen.util.text.FormatDate.format(r.getDt_envio_amostras(), "dd/MM/yyyy"));
            f.setAgendamento_cdgo((r.getAgendamento_cdgo() != null) ? r.getAgendamento_cdgo() + "":"");
            f.setData_efetiva(com.egen.util.text.FormatDate.format(r.getData_efetiva(), "dd/MM/yyyy"));
            f.setDt_corte(com.egen.util.text.FormatDate.format(r.getDt_corte(), "dd/MM/yyyy"));
            f.setCodigo_regional((r.getCodigo_regional() != null) ? r.getCodigo_regional() + "":"");
            f.setRep_cdgo((r.getRep_cdgo() != null) ? r.getRep_cdgo() + "":"");
            f.setCli_cdgo((r.getCli_cdgo() != null) ? r.getCli_cdgo() + "":"");
            f.setCodigo_marca((r.getCodigo_marca() != null) ? r.getCodigo_marca() + "":"");
            f.setPed_stat((r.getPed_stat() != null) ? r.getPed_stat() + "":"");
            f.setHora((r.getHora() != null) ? r.getHora() + "":"");
            f.setCnpj((r.getCnpj() != null) ? r.getCnpj() + "":"");
            f.setSenha((r.getSenha() != null) ? r.getSenha() + "":"");
            f.setDt_emissao(com.egen.util.text.FormatDate.format(r.getDt_emissao(), "dd/MM/yyyy HH:mm:ss"));
            f.setFilial((r.getFilial() != null) ? r.getFilial() + "":"");
            f.setNotafiscal((r.getNotafiscal() != null) ? r.getNotafiscal() + "":"");
            f.setVolumes((r.getVolumes() != null) ? r.getVolumes() + "":"");
            f.setModelo_alarme((r.getModelo_alarme() != null) ? r.getModelo_alarme() + "":"");
            f.setFilial_local_estoque((r.getFilial_local_estoque() != null) ? r.getFilial_local_estoque() + "":"");
            f.setGrades_corrugados((r.getGrades_corrugados() != null) ? r.getGrades_corrugados() + "":"");
            f.setDt_inspecao(com.egen.util.text.FormatDate.format(r.getDt_inspecao(), "dd/MM/yyyy"));
            f.setDt_montagem(com.egen.util.text.FormatDate.format(r.getDt_montagem(), "dd/MM/yyyy"));
            f.setGrupo_economico((r.getGrupo_economico() != null) ? r.getGrupo_economico() + "":"");
            f.setCli_rzao((r.getCli_rzao() != null) ? r.getCli_rzao() + "":"");
            f.setSituacao((r.getSituacao() != null) ? r.getSituacao() + "":"");
            f.setDescricao_situacao((r.getDescricao_situacao() != null) ? r.getDescricao_situacao() + "":"");
            f.setCabide((r.getCabide() != null) ? r.getCabide() + "":"");
            f.setAmostra((r.getAmostra() != null) ? r.getAmostra() + "":"");
            f.setTipo_amostra((r.getTipo_amostra() != null) ? r.getTipo_amostra() + "":"");
            f.setPedido_prod((r.getPedido_prod() != null) ? r.getPedido_prod() + "":"");
            f.setEncarte((r.getEncarte() != null) ? r.getEncarte() + "":"");
            f.setDt_ent_amostra_comercial(com.egen.util.text.FormatDate.format(r.getDt_ent_amostra_comercial(), "dd/MM/yyyy"));
            f.setDt_ent_amostra_pcp(com.egen.util.text.FormatDate.format(r.getDt_ent_amostra_pcp(), "dd/MM/yyyy"));
            f.setPortao((r.getPortao() != null) ? r.getPortao() + "":"");
            f.setCd_entrega((r.getCd_entrega() != null) ? r.getCd_entrega() + "":"");
            f.setData_entrega_cliente(com.egen.util.text.FormatDate.format(r.getData_entrega_cliente(), "dd/MM/yyyy"));
            f.setPed_amostra_brinde((r.getPed_amostra_brinde() != null) ? r.getPed_amostra_brinde() + "":"");
            f.setEsc_seqn((r.getEsc_seqn() != null) ? r.getEsc_seqn() + "":"");
            f.setNome_regional((r.getNome_regional() != null) ? r.getNome_regional() + "":"");
            f.setRep_rzao((r.getRep_rzao() != null) ? r.getRep_rzao() + "":"");
            f.setPed_tipo((r.getPed_tipo() != null) ? r.getPed_tipo() + "":"");
            f.setDt_rec_etiqueta_filial(com.egen.util.text.FormatDate.format(r.getDt_rec_etiqueta_filial(), "dd/MM/yyyy"));
            f.setData_etiquetagem(com.egen.util.text.FormatDate.format(r.getData_etiquetagem(), "dd/MM/yyyy"));
            f.setEncarte1((r.getEncarte() != null) ? r.getEncarte() + "":"");
            f.setPrioridade_embarque((new Boolean(r.getPrioridade_embarque() + "")).booleanValue());
            f.setAtacado((r.getAtacado() != null) ? r.getAtacado() + "":"");
            f.setAlerta((r.getAlerta() != null) ? r.getAlerta() + "":"");
            f.setDescricao_embalagem((r.getDescricao_embalagem() != null) ? r.getDescricao_embalagem() + "":"");
            f.setPed_especie_pedido((r.getPed_especie_pedido() != null) ? r.getPed_especie_pedido() + "":"");
            f.setPed_obse((r.getPed_obse() != null) ? r.getPed_obse() + "":"");
            f.setCertificado_origem((r.getCertificado_origem() != null) ? r.getCertificado_origem() + "":"");
            f.setDt_emiss(com.egen.util.text.FormatDate.format(r.getDt_emiss(), "dd/MM/yyyy"));
            f.setNro_normativa_cliente((r.getNro_normativa_cliente() != null) ? r.getNro_normativa_cliente() + "":"");
            f.setDescricao_normativa_cliente((r.getDescricao_normativa_cliente() != null) ? r.getDescricao_normativa_cliente() + "":"");
            f.setMin_fabr((r.getMin_fabr() != null) ? r.getMin_fabr() + "":"");
            f.setBloqueio_49((r.getBloqueio_49() != null) ? r.getBloqueio_49() + "":"");
            f.setPreco_pdv((r.getPreco_pdv() != null) ? r.getPreco_pdv() + "":"");
            f.setLoja((r.getLoja() != null) ? r.getLoja() + "":"");
            f.setCli_cdgo((r.getCli_cdgo() != null) ? r.getCli_cdgo() + "" :"");
            f.setEsc_seqn((r.getEsc_seqn() != null) ? r.getEsc_seqn() + "" :"");
            f.setNumero_romaneio((r.getNumero_romaneio() != null) ? r.getNumero_romaneio() + "" :"");
            f.setData_finalizacao_romaneio((r.getData_finalizacao_romaneio() != null) ? r.getData_finalizacao_romaneio() + "" :"");
            f.setBanco(r.getExiste());
            f.setLiberado_faturar(r.getLiberado_faturar() + "");
            f.setValor_pedido(r.getValor_pedido() + "");
            f.setData_entrega_cliente(com.egen.util.text.FormatDate.format(r.getData_entrega_cliente(), "dd/MM/yyyy") + "");
            f.setDt_rec_etiqueta_filial(com.egen.util.text.FormatDate.format(r.getDt_rec_etiqueta_filial(), "dd/MM/yyyy") + "");
            f.setDt_solicitacao_alarme(com.egen.util.text.FormatDate.format(r.getDt_solicitacao_alarme(), "dd/MM/yyyy"));
            f.setDt_rec_alarme_pcp(com.egen.util.text.FormatDate.format(r.getDt_rec_alarme_pcp(), "dd/MM/yyyy"));
            f.setDt_rec_alarme_filial(com.egen.util.text.FormatDate.format(r.getDt_rec_alarme_filial(), "dd/MM/yyyy"));
            f.setNfe_numero((r.getNfe_numero() != null) ? r.getNfe_numero() + "":"");
            if (r.getPrioridade_embarque() != null && r.getPrioridade_embarque().equals("S")) {
              f.setPrioridade_embarque(true);
            }
            f.setGerar_requisicao((r.getGerar_requisicao() != null) ? r.getGerar_requisicao() + "":"N");

          } else {
            f.reset(mapping, request);
          }
          _ge_grid_array_flex[_ge_grid_array_index] = f;
        }
        _ge_grid.set("bl_form_Controle_clientes_especiais_vw_lines", _ge_grid_array_flex);
      } else {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Controle_clientes_especiais_vw", new ActionMessage("warn.norowsselected",""));
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      }
      session.setAttribute(mapping.getName(), form);
    }
  }

  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ControleClientesEspeciais_mActionForm[]_ge_grid_array = (ControleClientesEspeciais_mActionForm[])_ge_grid.get("bl_form_Controle_clientes_especiais_vw_lines");
      ControleClientesEspeciais_mActionForm f = _ge_grid_array[0];
      try {
        update_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = new ActionForward("/com/ControleClientesEspeciais_mGrid.do?select_action=", true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Controle_clientes_especiais_vw", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
      e.printStackTrace(System.err);
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return actionForward;
  }
  private void update_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    DynaActionForm _ge_grid = (DynaActionForm) form;
    ControleClientesEspeciais_mActionForm[]_ge_grid_array = (ControleClientesEspeciais_mActionForm[])_ge_grid.get("bl_form_Controle_clientes_especiais_vw_lines");
    ControleClientesEspeciais_mActionForm f = _ge_grid_array[0];
    util.consultas.Query query = new util.consultas.Query();
    acesso.Sessao sessao = new acesso.Sessao(session);
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      if (f.getData_efetiva() != null && (!f.getData_efetiva().equals(""))) {
        f.setPrioridade_embarque(false);
      }
      if (f.getAlterado().equals("S")) {
        // ----- Insert ---------------------------------------------
        if (f.getBanco().equals("N")) {
          Ped_inf_adicionais table = new Ped_inf_adicionais();
          Object[][] name_value = { {"ped_nmro",com.egen.util.text.FormatNumber.toInteger(f.getPed_nmro())}, {"etiquetas",f.getEtiquetas()}, {"obse_adicionais",f.getObse_adicionais()}, {"emp_empresa","01"}, {"fil_filial_fat",f.getFil_filial_fat()}, {"dt_fatur_filial",com.egen.util.text.FormatDate.parseDate(f.getDt_fatur_filial(), "dd/MM/yyyy")}, {"carimbo",f.getCarimbo()}, {"rotulos",f.getRotulos()}, {"dt_envio_amostras",com.egen.util.text.FormatDate.parseDate(f.getDt_envio_amostras(), "dd/MM/yyyy")}, {"dt_agendamento",com.egen.util.text.FormatDate.parseDate(f.getData_efetiva(), "dd/MM/yyyy")}, {"agendamento_cdgo", f.getAgendamento_cdgo()}, {"horario_entrega",f.getHora()}, {"senha_entrega",f.getSenha()}, {"dt_inspecao",com.egen.util.text.FormatDate.parseDate(f.getDt_inspecao(), "dd/MM/yyyy")}, {"dt_entrega_etiqueta",com.egen.util.text.FormatDate.parseDate(f.getDt_entrega_etiqueta(), "dd/MM/yyyy")}, {"data_etiquetagem",com.egen.util.text.FormatDate.parseDate(f.getData_etiquetagem(), "dd/MM/yyyy")}, {"dt_rec_etiqueta_filial",com.egen.util.text.FormatDate.parseDate(f.getDt_rec_etiqueta_filial(), "dd/MM/yyyy")}, {"cabide",f.getCabide()}, {"portao",f.getPortao()}, {"cd_entrega",f.getCd_entrega()}, {"encarte",f.getEncarte()}, {"prioridade_embarque",f.getPrioridade_embarque() == true ? "S":"N"}, {"dt_solicitacao_alarme",f.getDt_solicitacao_alarme()}, {"dt_rec_alarme_pcp",f.getDt_rec_alarme_pcp()}, {"dt_rec_alarme_filial",f.getDt_rec_alarme_filial()}, {"nfe_numero",f.getNfe_numero()}, {"gerar_requisicao", (f.getGerar_requisicao() != null ? f.getGerar_requisicao() : "N")}, };
          j.insert(table, name_value);
        }

        //------------Insert na obs ------------
        if (f.getCertificado_origem() != null && f.getCertificado_origem() != "") {
          String existe = query.retorna(j, "SELECT 1 FROM fat.observacoes_nat_oper_pedido ob where ob.ped_nmro = "+f.getPed_nmro());
          if (existe.equals("1")) {
            query.execute(j, "UPDATE fat.observacoes_nat_oper_pedido ob SET ob.texto = '"+f.getCertificado_origem() + "' where ob.ped_nmro = "+f.getPed_nmro());
          } else {
            Observacoes_nat_oper_pedido obs = new Observacoes_nat_oper_pedido();
            Object[][] name_value2 = { {"data_faturamento",com.egen.util.text.FormatDate.parseTimestamp(f.getDt_fatur().toString() + " 00:00:00", "dd/MM/yyyy HH:mm:ss")}, {"numero",57}, {"natoper_codigo",1}, {"ped_nmro",com.egen.util.text.FormatNumber.toInteger(f.getPed_nmro())}, {"data_cad",com.egen.util.text.FormatDate.parseTimestamp(f.getDt_emiss().toString() + " 00:00:00", "dd/MM/yyyy HH:mm:ss")}, {"usuario_cad",sessao.getUsuario()}, {"texto",f.getCertificado_origem()}, {"obs_cdgo",512}, };
            j.insert(obs, name_value2);

          }
        }


        // ----- Update ---------------------------------------------
        if (f.getBanco().equals("S")) {

          Ped_inf_adicionais table = new Ped_inf_adicionais();
          Vector sets = new Vector(10, 2);
          table.setPed_nmro(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getPed_nmro()));
          if (f.getPed_nmro() != null) {
            sets.addElement("ped_nmro");
          }
          table.setEtiquetas(f.getEtiquetas());
          if (f.getEtiquetas() != null) {
            sets.addElement("etiquetas");
          }
          table.setObse_adicionais(f.getObse_adicionais());
          if (f.getObse_adicionais() != null) {
            sets.addElement("obse_adicionais");
          }
          table.setEmp_empresa("01");
          sets.addElement("emp_empresa");
          table.setFil_filial_fat(f.getFil_filial_fat());
          if (f.getFil_filial_fat() != null) {
            sets.addElement("fil_filial_fat");
          }
          table.setDt_fatur_filial(com.egen.util.text.FormatDate.parseDate(f.getDt_fatur_filial(), "dd/MM/yyyy"));
          if (f.getDt_fatur_filial() != null) {
            sets.addElement("dt_fatur_filial");
          }

          table.setDt_rec_etiqueta_filial(com.egen.util.text.FormatDate.parseDate(f.getDt_rec_etiqueta_filial(), "dd/MM/yyyy"));
          if (f.getDt_rec_etiqueta_filial() != null) {
            sets.addElement("dt_rec_etiqueta_filial");
          }

          table.setData_etiquetagem(com.egen.util.text.FormatDate.parseDate(f.getData_etiquetagem(), "dd/MM/yyyy"));
          if (f.getData_etiquetagem() != null) {
            sets.addElement("data_etiquetagem");
          }

          table.setDt_inspecao(com.egen.util.text.FormatDate.parseDate(f.getDt_inspecao(), "dd/MM/yyyy"));
          if (f.getDt_inspecao() != null) {
            sets.addElement("dt_inspecao");
          }
          table.setDt_entrega_etiqueta(com.egen.util.text.FormatDate.parseDate(f.getDt_entrega_etiqueta(), "dd/MM/yyyy"));
          if (f.getDt_entrega_etiqueta() != null) {
            sets.addElement("dt_entrega_etiqueta");
          }
          table.setCarimbo(f.getCarimbo());
          if (f.getCarimbo() != null) {
            sets.addElement("carimbo");
          }
          table.setRotulos(f.getRotulos());
          if (f.getRotulos() != null) {
            sets.addElement("rotulos");
          }
          table.setDt_envio_amostras(com.egen.util.text.FormatDate.parseDate(f.getDt_envio_amostras(), "dd/MM/yyyy"));
          if (f.getDt_envio_amostras() != null) {
            sets.addElement("dt_envio_amostras");
          }
          table.setDt_agendamento(com.egen.util.text.FormatDate.parseDate(f.getData_efetiva(), "dd/MM/yyyy"));
          if (f.getData_efetiva() != null) {
            sets.addElement("dt_agendamento");
          }
          table.setAgendamento_cdgo(f.getAgendamento_cdgo());
          if (f.getAgendamento_cdgo() != null) {
            sets.addElement("agendamento_cdgo");
          }
          table.setHorario_entrega(f.getHora());
          if (f.getHora() != null) {
            sets.addElement("horario_entrega");
          }
          table.setSenha_entrega(f.getSenha());
          if (f.getSenha() != null) {
            sets.addElement("senha_entrega");
          }
          table.setCabide(f.getCabide());
          if (f.getCabide() != null) {
            sets.addElement("cabide");
          }
          table.setPortao(f.getPortao());
          if (f.getPortao() != null) {
            sets.addElement("portao");
          }

          table.setModelo_alarme(f.getModelo_alarme());
          if (f.getModelo_alarme() != null) {
            sets.addElement("modelo_alarme");
          }

          table.setCd_entrega(f.getCd_entrega());
          if (f.getCd_entrega() != null) {
            sets.addElement("cd_entrega");
          }
          table.setEncarte(f.getEncarte());
          if (f.getEncarte() != null) {
            sets.addElement("encarte");
          }
          if (f.getPrioridade_embarque()) {
            table.setPrioridade_embarque("S");
          } else {
            table.setPrioridade_embarque("N");
          }
          sets.addElement("prioridade_embarque");


          if (f.getGerar_requisicao() != null) {
            table.setGerar_requisicao("S");
          } else {
            table.setGerar_requisicao("N");
          }
          sets.addElement("gerar_requisicao");


          table.setDt_solicitacao_alarme(com.egen.util.text.FormatDate.parseDate(f.getDt_solicitacao_alarme(), "dd/MM/yyyy"));
          if (f.getDt_solicitacao_alarme() != null) {
            sets.addElement("dt_solicitacao_alarme");
          }
          table.setDt_rec_alarme_pcp(com.egen.util.text.FormatDate.parseDate(f.getDt_rec_alarme_pcp(), "dd/MM/yyyy"));
          if (f.getDt_rec_alarme_pcp() != null) {
            sets.addElement("dt_rec_alarme_pcp");
          }
          table.setDt_rec_alarme_filial(com.egen.util.text.FormatDate.parseDate(f.getDt_rec_alarme_filial(), "dd/MM/yyyy"));
          if (f.getDt_rec_alarme_filial() != null) {
            sets.addElement("dt_rec_alarme_filial");
          }
          table.setNfe_numero(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getNfe_numero()));
          if (f.getNfe_numero() != null) {
            sets.addElement("nfe_numero");
          }

          if (sets != null && sets.size() > 0) {
            String[] set = new String[sets.size()];
            for (int i = 0; i < sets.size(); i++) {
              set[i] = (String) sets.elementAt(i);
            }
            int updated = j.update(table, set);
          }
        }
        // ----------------------------------------------------------
      }
    }
  }
  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ControleClientesEspeciais_mActionForm[]_ge_grid_array = (ControleClientesEspeciais_mActionForm[])_ge_grid.get("bl_form_Controle_clientes_especiais_vw_lines");
      ControleClientesEspeciais_mActionForm f = _ge_grid_array[0];


      actionForward = new ActionForward("/com/ControleClientesEspeciaisForm.jsp",true);
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
  public ActionForward perform_refresh_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ControleClientesEspeciais_mActionForm[]_ge_grid_array = (ControleClientesEspeciais_mActionForm[])_ge_grid.get("bl_form_Controle_clientes_especiais_vw_lines");
      ControleClientesEspeciais_mActionForm f = _ge_grid_array[0];
      refresh_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
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
  private void refresh_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    DynaActionForm _ge_grid = (DynaActionForm) form;
    ControleClientesEspeciais_mActionForm[]_ge_grid_array = (ControleClientesEspeciais_mActionForm[])_ge_grid.get("bl_form_Controle_clientes_especiais_vw_lines");
    ControleClientesEspeciais_mActionForm f = _ge_grid_array[0];
    boolean bloqueiaDataEfetiva = false;
    boolean bloqueiaEtiquetas = false;
    boolean bloqueiaObseAdicionais = false;
    boolean bloqueiaAgendamentoCdgo = false;
    boolean bloqueiaHora = false;
    boolean bloqueiaSenha = false;
    boolean bloqueiaCertificadoOrigem = false;
    boolean bloqueiaDtInspecao = false;
    boolean bloqueiaFilFilialFat = false;
    util.bloqueio.BloqueioUtil bloqueio = new util.bloqueio.BloqueioUtil(186, request);
    util.consultas.com.ControleClientesEspeciais controleClientesEspeciais = new util.consultas.com.ControleClientesEspeciais();
    java.util.List < String > listaDesconsiderarBloqueioFilialFat = controleClientesEspeciais.retornaDesconsiderarBloqueioFilialFat();
    if (bloqueio.tipoBloqueio("DATA_EFETIVA").equals("D")) {
      bloqueiaDataEfetiva = true;
    }
    if (bloqueio.tipoBloqueio("ETIQUETAS").equals("D")) {
      bloqueiaEtiquetas = true;
    }
    if (bloqueio.tipoBloqueio("OBSE_ADICIONAIS").equals("D")) {
      bloqueiaObseAdicionais = true;
    }
    if (bloqueio.tipoBloqueio("AGENDAMENTO_CDGO").equals("D")) {
      bloqueiaAgendamentoCdgo = true;
    }
    if (bloqueio.tipoBloqueio("HORA").equals("D")) {
      bloqueiaHora = true;
    }
    if (bloqueio.tipoBloqueio("SENHA").equals("D")) {
      bloqueiaSenha = true;
    }
    if (bloqueio.tipoBloqueio("CERTIFICADO_ORIGEM").equals("D")) {
      bloqueiaCertificadoOrigem = true;
    }
    if (bloqueio.tipoBloqueio("DT_INSPECAO").equals("D")) {
      bloqueiaDtInspecao = true;
    }
    if (bloqueio.tipoBloqueio("FIL_FILIAL_FAT").equals("D")) {
      bloqueiaFilFilialFat = true;
    }

    String dataSessao = (String) session.getAttribute("controle_clientes_especiais_lote_data_agendamento");
    String filialFaturamento = (String) session.getAttribute("controle_clientes_especiais_lote_filial_faturamento");
    String etiquetaSessao = (String) session.getAttribute("controle_clientes_especiais_lote_etiqueta");
    String observacaoSessao = (String) session.getAttribute("controle_clientes_especiais_lote_observacao");
    String semanaAgendamentoSessao = (String) session.getAttribute("controle_clientes_especiais_lote_semana_agendamento");
    String modeloAlarmeSessao = (String) session.getAttribute("controle_clientes_especiais_lote_modelo_alarme");
    String horaSessao = (String) session.getAttribute("controle_clientes_especiais_lote_hora");
    String senhaSessao = (String) session.getAttribute("controle_clientes_especiais_lote_senha");
    String certificadoOrigem = (String) session.getAttribute("controle_clientes_especiais_lote_certificado_origem");
    String dataSolicitacaoAlarme = (String) session.getAttribute("controle_clientes_especiais_lote_data_solicitacao_alarme");
    String dataInspecao = (String) session.getAttribute("controle_clientes_especiais_lote_data_inspecao");

    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      if (true) {
        Controle_clientes_especiais_vw table = new Controle_clientes_especiais_vw();
        Vector sets = new Vector(10, 2);
        table.setPed_nmro(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getPed_nmro()));
        table.setPed_boni(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getPed_boni()));
        table.setPed_boni2(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getPed_boni2()));
        table.setPed_desc(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getPed_desc()));
        table.setOc(f.getOc());
        table.setModelos(f.getModelos());
        table.setEtiquetas(f.getEtiquetas());
        table.setDt_entrega_etiqueta(com.egen.util.text.FormatDate.parseDate(f.getDt_entrega_etiqueta(), "dd/MM/yyyy"));
        table.setObse_adicionais(f.getObse_adicionais());
        table.setPrs(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getPrs()));
        table.setRemessa(f.getRemessa());
        table.setFilial_prd(f.getFilial_prd());
        table.setFil_filial_fat(f.getFil_filial_fat());
        table.setDt_digit(com.egen.util.text.FormatDate.parseDate(f.getDt_digit(), "dd/MM/yyyy"));
        table.setDt_fatur(com.egen.util.text.FormatDate.parseDate(f.getDt_fatur(), "dd/MM/yyyy"));
        table.setDt_fatur_filial(com.egen.util.text.FormatDate.parseDate(f.getDt_fatur_filial(), "dd/MM/yyyy"));
        table.setMarca(f.getMarca());
        table.setCarimbo(f.getCarimbo());
        table.setRotulos(f.getRotulos());
        table.setPed_amostra(f.getPed_amostra());
        table.setDt_envio_amostras(com.egen.util.text.FormatDate.parseDate(f.getDt_envio_amostras(), "dd/MM/yyyy"));
        table.setAgendamento_cdgo(f.getAgendamento_cdgo());
        table.setData_efetiva(com.egen.util.text.FormatDate.parseDate(f.getData_efetiva(), "dd/MM/yyyy"));
        table.setCodigo_regional(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCodigo_regional()));
        table.setRep_cdgo(f.getRep_cdgo());
        table.setCli_cdgo(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCli_cdgo()));
        table.setCodigo_marca(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCodigo_marca()));
        table.setPed_stat(f.getPed_stat());
        table.setHora(f.getHora());
        table.setSenha(f.getSenha());
        table.setDt_emissao(com.egen.util.text.FormatDate.parseTimestamp(f.getDt_emissao(), "dd/MM/yyyy HH:mm:ss"));
        table.setFilial(f.getFilial());
        table.setNotafiscal(f.getNotafiscal());
        table.setVolumes(f.getVolumes());
        table.setDt_inspecao(com.egen.util.text.FormatDate.parseDate(f.getDt_inspecao(), "dd/MM/yyyy"));
        table.setDt_montagem(com.egen.util.text.FormatDate.parseDate(f.getDt_montagem(), "dd/MM/yyyy"));
        table.setGrupo_economico(f.getGrupo_economico());
        table.setCli_rzao(f.getCli_rzao());
        table.setSituacao(f.getSituacao());
        table.setCabide(f.getCabide());
        table.setAmostra(f.getAmostra());
        table.setTipo_amostra(f.getTipo_amostra());
        table.setPedido_prod(f.getPedido_prod());
        table.setEncarte(f.getEncarte());
        table.setDt_ent_amostra_comercial(com.egen.util.text.FormatDate.parseDate(f.getDt_ent_amostra_comercial(), "dd/MM/yyyy"));
        table.setDt_ent_amostra_pcp(com.egen.util.text.FormatDate.parseDate(f.getDt_ent_amostra_pcp(), "dd/MM/yyyy"));
        table.setPortao(f.getPortao());
        table.setCd_entrega(f.getCd_entrega());
        table.setData_entrega_cliente(com.egen.util.text.FormatDate.parseDate(f.getData_entrega_cliente(), "dd/MM/yyyy"));
        table.setPed_amostra_brinde(f.getPed_amostra_brinde());
        table.setEsc_seqn(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getEsc_seqn()));
        table.setNome_regional(f.getNome_regional());
        table.setRep_rzao(f.getRep_rzao());
        table.setPed_tipo(f.getPed_tipo());
        table.setDt_rec_etiqueta_filial(com.egen.util.text.FormatDate.parseDate(f.getDt_rec_etiqueta_filial(), "dd/MM/yyyy"));
        table.setEncarte(f.getEncarte1());
        table.setPrioridade_embarque(f.getPrioridade_embarque() + "");
        table.setAtacado(f.getAtacado());
        table.setAlerta(f.getAlerta());
        table.setPed_especie_pedido(f.getPed_especie_pedido());
        table.setPed_obse(f.getPed_obse());
        table.setDt_emiss(com.egen.util.text.FormatDate.parseDate(f.getDt_emiss(), "dd/MM/yyyy"));
        table.setNro_normativa_cliente(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getNro_normativa_cliente()));
        table.setDescricao_normativa_cliente(f.getDescricao_normativa_cliente());
        table.setMin_fabr(f.getMin_fabr());
        table.setBloqueio_49(f.getBloqueio_49());
        table.setLoja(f.getLoja());
        table.setCidade(f.getCidade());
        table.setPed_invoice(f.getPed_invoice());
        table.setOcorrencia(f.getOcorrencia());
        table.setData_bloqueio(com.egen.util.text.FormatDate.parseDate(f.getData_bloqueio(), "dd/MM/yyyy"));
        table.setData_prevista_desbloqueio(com.egen.util.text.FormatDate.parseDate(f.getData_prevista_desbloqueio(), "dd/MM/yyyy"));
        table.setDt_solicitacao_alarme(com.egen.util.text.FormatDate.parseDate(f.getDt_solicitacao_alarme(), "dd/MM/yyyy"));
        table.setDt_rec_alarme_pcp(com.egen.util.text.FormatDate.parseDate(f.getDt_rec_alarme_pcp(), "dd/MM/yyyy"));
        table.setDt_rec_alarme_filial(com.egen.util.text.FormatDate.parseDate(f.getDt_rec_alarme_filial(), "dd/MM/yyyy"));
        table.setNfe_numero(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getNfe_numero()));
        table.setValor_pedido(com.egen.util.text.FormatNumber.parseDouble(f.getValor_pedido()));
        table.setDistribuicao(f.getDistribuicao());
        table.setRef_cliente_por_pedido(f.getRef_cliente_por_pedido() + "");

        //---------------------------------------------------------------

        if (session.getAttribute("controle_clientes_especiais_lote_data_agendamento") != null) {
          if ((!bloqueio.pertenceFilial(table.getFilial_prd())) || ((table.getCli_cdgo() + "").equals("6743") && (table.getEsc_seqn() + "").equals("75") && (table.getSituacao().indexOf("F") != -1 || table.getSituacao().indexOf("L") != -1 || table.getSituacao().indexOf("C") != -1)) || bloqueiaDataEfetiva || table.getSituacao().indexOf("F") == 0 || table.getSituacao().indexOf("L") == 0 || table.getSituacao().indexOf("C") == 0 || (table.getPrioridade_embarque() != null && table.getPrioridade_embarque().equals("S"))) {
          } else {
            //if(f.getData_efetiva().equals("")){
            f.setData_efetiva(dataSessao);
            f.setAlterado("S");
            //}
          }
        }

        if (session.getAttribute("controle_clientes_especiais_lote_etiqueta") != null) {
          if ((!bloqueio.pertenceFilial(table.getFilial_prd())) || bloqueiaEtiquetas || table.getSituacao().indexOf("F") != -1 || table.getSituacao().indexOf("L") != -1 || table.getSituacao().indexOf("C") != -1) {
          } else {
            //if(f.getEtiquetas().equals("")){
            f.setEtiquetas(etiquetaSessao);
            f.setAlterado("S");
            //}
          }
        }

        if (session.getAttribute("controle_clientes_especiais_lote_observacao") != null) {
          if ((!bloqueio.pertenceFilial(table.getFilial_prd())) || bloqueiaObseAdicionais) {
          } else {
            //if(f.getObse_adicionais().equals("")){
            f.setObse_adicionais(observacaoSessao);
            f.setAlterado("S");
            //}
          }
        }

        if (session.getAttribute("controle_clientes_especiais_lote_semana_agendamento") != null) {
          if ((!bloqueio.pertenceFilial(table.getFilial_prd())) || bloqueiaAgendamentoCdgo) {
          } else {
            //if(f.getAgendamento_cdgo().equals("")){
            f.setAgendamento_cdgo(semanaAgendamentoSessao);
            f.setAlterado("S");
            //}
          }
        }

        if (session.getAttribute("controle_clientes_especiais_lote_modelo_alarme") != null) {
          //         if((!bloqueio.pertenceFilial(table.getFilial_prd())) || bloqueiaAgendamentoCdgo) {
          //       } else {
          f.setModelo_alarme(modeloAlarmeSessao);
          f.setAlterado("S");
          //       }
        }

        if (session.getAttribute("controle_clientes_especiais_lote_hora") != null) {
          if ((!bloqueio.pertenceFilial(table.getFilial_prd())) || bloqueiaHora) {
          } else {
            //if(f.getHora().equals("")){
            f.setHora(horaSessao);
            f.setAlterado("S");
            //}
          }
        }

        if (session.getAttribute("controle_clientes_especiais_lote_senha") != null) {
          if ((!bloqueio.pertenceFilial(table.getFilial_prd())) || bloqueiaSenha) {
          } else {
            //if(f.getSenha().equals("")){
            f.setSenha(senhaSessao);
            f.setAlterado("S");
            //}
          }
        }

        if (session.getAttribute("controle_clientes_especiais_lote_certificado_origem") != null) {
          if ((!bloqueio.pertenceFilial(table.getFilial_prd())) || bloqueiaCertificadoOrigem) {
          } else {
            //if(f.getSenha().equals("")){
            f.setCertificado_origem(certificadoOrigem);
            f.setAlterado("S");
            //}
          }
        }
        //--------------------------------------------------------------
        if (session.getAttribute("controle_clientes_especiais_lote_data_inspecao") != null) {
          if ((!bloqueio.pertenceFilial(table.getFilial_prd())) || bloqueiaDtInspecao || table.getSituacao().indexOf("F") != -1 || table.getSituacao().indexOf("L") != -1 || table.getSituacao().indexOf("C") != -1) {
          } else {
            f.setDt_inspecao(dataInspecao);
            f.setAlterado("S");
          }
        }
        //--------------------------------------------------------------
        if (session.getAttribute("controle_clientes_especiais_lote_data_solicitacao_alarme") != null) {
          if ((!bloqueio.pertenceFilial(table.getFilial_prd())) || bloqueiaEtiquetas || table.getSituacao().indexOf("F") != -1 || table.getSituacao().indexOf("L") != -1 || table.getSituacao().indexOf("C") != -1) {
          } else {
            f.setDt_solicitacao_alarme(dataSolicitacaoAlarme);
            f.setAlterado("S");
          }
        }
        //--------------------------------------------------------------
        if (session.getAttribute("controle_clientes_especiais_lote_filial_faturamento") != null) {
          if ((!bloqueio.pertenceFilial(table.getFilial_prd())) || bloqueiaFilFilialFat || table.getSituacao().indexOf("F") != -1 || table.getSituacao().indexOf("L") != -1 || table.getSituacao().indexOf("C") != -1) {
          } else {
            if ((table.getRef_cliente_por_pedido().equalsIgnoreCase("N")) && (!listaDesconsiderarBloqueioFilialFat.contains((table.getCli_cdgo() + "")))) {
            } else {
              f.setFil_filial_fat(filialFaturamento);
              f.setAlterado("S");
            }
          }
        }
        //---------------------------------------------------------------
        session.setAttribute(mapping.getName(), form);
      }
    }
    session.removeAttribute("marcar_gerar_requisicao_aplicar");
    session.removeAttribute("controle_clientes_especiais_lote_data_agendamento");
    session.removeAttribute("controle_clientes_especiais_lote_etiqueta");
    session.removeAttribute("controle_clientes_especiais_lote_observacao");
    session.removeAttribute("controle_clientes_especiais_lote_semana_agendamento");
    session.removeAttribute("controle_clientes_especiais_lote_hora");
    session.removeAttribute("controle_clientes_especiais_lote_senha");
    session.removeAttribute("controle_clientes_especiais_lote_data_solicitacao_alarme");
    session.removeAttribute("controle_clientes_especiais_lote_modelo_alarme");
    session.removeAttribute("controle_clientes_especiais_lote_data_inspecao");
    session.removeAttribute("controle_clientes_especiais_lote_filial_faturamento");
  }
  public ActionForward perform_marcar_desmarcar_gerar_requisicao_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ControleClientesEspeciais_mActionForm[]_ge_grid_array = (ControleClientesEspeciais_mActionForm[])_ge_grid.get("bl_form_Controle_clientes_especiais_vw_lines");
      ControleClientesEspeciais_mActionForm f = _ge_grid_array[0];
      try {
        marcar_desmarcar_gerar_requisicao_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
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
  private void marcar_desmarcar_gerar_requisicao_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    DynaActionForm _ge_grid = (DynaActionForm) form;
    ControleClientesEspeciais_mActionForm[]_ge_grid_array = (ControleClientesEspeciais_mActionForm[])_ge_grid.get("bl_form_Controle_clientes_especiais_vw_lines");
    ControleClientesEspeciais_mActionForm f = _ge_grid_array[0];
    boolean gerar = false;
    if (session.getAttribute("marcar_gerar_requisicao") == null) {
      session.setAttribute("marcar_gerar_requisicao", true);
    } else {
      gerar = (Boolean) session.getAttribute("marcar_gerar_requisicao");
      session.setAttribute("marcar_gerar_requisicao", !gerar);
    }
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      if (true) {
        f.setAlterado("S");
        if (gerar) {
          f.setGerar_requisicao("S");
        } else {
          f.setGerar_requisicao("N");
        }
        session.setAttribute(mapping.getName(), form);
      }
    }
  }

  public ActionForward perform_select1_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ControleClientesEspeciais_mActionForm[]_ge_grid_array = (ControleClientesEspeciais_mActionForm[])_ge_grid.get("bl_form_Controle_clientes_especiais_vw_lines");
      ControleClientesEspeciais_mActionForm f = _ge_grid_array[0];
      try {
        select1_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
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
  private void select1_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    DynaActionForm _ge_grid = (DynaActionForm) form;
    ControleClientesEspeciais_mActionForm[]_ge_grid_array = (ControleClientesEspeciais_mActionForm[])_ge_grid.get("bl_form_Controle_clientes_especiais_vw_lines");
    ControleClientesEspeciais_mActionForm f = _ge_grid_array[0];
    if (f != null) {
      Controle_clientes_especiais_vw table = new Controle_clientes_especiais_vw();
      String[][] select = null;
      String[] order = null;
      String[] groupby = null;
      String[] having = null;
      Object[][] where = { {"ped_nmro","=", com.egen.util.text.FormatNumber.toInteger(f.getPed_nmro())}, {"ped_boni","=", com.egen.util.text.FormatNumber.toDouble(f.getPed_boni())}, {"ped_boni2","=", com.egen.util.text.FormatNumber.toDouble(f.getPed_boni2())}, {"ped_desc","=", com.egen.util.text.FormatNumber.toDouble(f.getPed_desc())}, {"cnd_cdgo","like", f.getCnd_cdgo()}, {"oc","like", f.getOc()}, {"modelos","like", f.getModelos()}, {"etiquetas","like", f.getEtiquetas()}, {"dt_entrega_etiqueta","=", com.egen.util.text.FormatDate.parseDate(f.getDt_entrega_etiqueta(), "dd/MM/yyyy")}, {"obse_adicionais","like", f.getObse_adicionais()}, {"prs","=", com.egen.util.text.FormatNumber.toInteger(f.getPrs())}, {"remessa","like", f.getRemessa()}, {"filial_prd","like", f.getFilial_prd()}, {"fil_filial_fat","like", f.getFil_filial_fat()}, {"dt_digit","=", com.egen.util.text.FormatDate.parseDate(f.getDt_digit(), "dd/MM/yyyy")}, {"dt_fatur","=", com.egen.util.text.FormatDate.parseDate(f.getDt_fatur(), "dd/MM/yyyy")}, {"dt_fatur_filial","=", com.egen.util.text.FormatDate.parseDate(f.getDt_fatur_filial(), "dd/MM/yyyy")}, {"marca","like", f.getMarca()}, {"carimbo","like", f.getCarimbo()}, {"rotulos","like", f.getRotulos()}, {"ped_amostra","like", f.getPed_amostra()}, {"dt_envio_amostras","=", com.egen.util.text.FormatDate.parseDate(f.getDt_envio_amostras(), "dd/MM/yyyy")}, {"agendamento_cdgo","like", f.getAgendamento_cdgo()}, {"data_efetiva","=", com.egen.util.text.FormatDate.parseDate(f.getData_efetiva(), "dd/MM/yyyy")}, {"codigo_regional","=", com.egen.util.text.FormatNumber.toInteger(f.getCodigo_regional())}, {"rep_cdgo","like", f.getRep_cdgo()}, {"cli_cdgo","=", com.egen.util.text.FormatNumber.toInteger(f.getCli_cdgo())}, {"codigo_marca","=", com.egen.util.text.FormatNumber.toInteger(f.getCodigo_marca())}, {"ped_stat","like", f.getPed_stat()}, {"hora","like", f.getHora()}, {"senha","like", f.getSenha()}, {"dt_emissao","=", com.egen.util.text.FormatDate.parseTimestamp(f.getDt_emissao(), "dd/MM/yyyy")}, {"filial","like", f.getFilial()}, {"notafiscal","like", f.getNotafiscal()}, {"volumes","like", f.getVolumes()}, {"dt_inspecao","=", com.egen.util.text.FormatDate.parseDate(f.getDt_inspecao(), "dd/MM/yyyy")}, {"dt_montagem","=", com.egen.util.text.FormatDate.parseDate(f.getDt_montagem(), "dd/MM/yyyy")}, {"grupo_economico","like", f.getGrupo_economico()}, {"cli_rzao","like", f.getCli_rzao()}, {"situacao","like", f.getSituacao()}, {"cabide","like", f.getCabide()}, {"portao","like", f.getPortao()}, {"cd_entrega","like", f.getCd_entrega()}, {"data_entrega_cliente","=", com.egen.util.text.FormatDate.parseDate(f.getData_entrega_cliente(), "dd/MM/yyyy")}, {"ped_amostra_brinde","like", f.getPed_amostra_brinde()}, {"esc_seqn","=", com.egen.util.text.FormatNumber.toInteger(f.getEsc_seqn())}, {"nome_regional","like", f.getNome_regional()}, {"rep_rzao","like", f.getRep_rzao()}, {"ped_tipo","like", f.getPed_tipo()}, {"dt_rec_etiqueta_filial","=", com.egen.util.text.FormatDate.parseDate(f.getDt_rec_etiqueta_filial(), "dd/MM/yyyy")}, {"encarte","like", f.getEncarte1()}, {"prioridade_embarque","like", f.getPrioridade_embarque() + ""}, {"atacado","like", f.getAtacado()}, {"alerta","like", f.getAlerta()}, {"ped_especie_pedido","like", f.getPed_especie_pedido()}, {"ped_obse","like", f.getPed_obse()}, {"dt_emiss","=", com.egen.util.text.FormatDate.parseDate(f.getDt_emiss(), "dd/MM/yyyy")}, {"nro_normativa_cliente","=", com.egen.util.text.FormatNumber.toInteger(f.getNro_normativa_cliente())}, {"descricao_normativa_cliente","like", f.getDescricao_normativa_cliente()}, {"min_fabr","like", f.getMin_fabr()}, {"bloqueio_49","like", f.getBloqueio_49()}, {"loja","like", f.getLoja()}, {"cidade","like", f.getCidade()}, {"ped_invoice","like", f.getPed_invoice()}, {"ocorrencia","like", f.getOcorrencia()}, {"data_bloqueio","=", com.egen.util.text.FormatDate.parseDate(f.getData_bloqueio(), "dd/MM/yyyy")}, {"data_prevista_desbloqueio","=", com.egen.util.text.FormatDate.parseDate(f.getData_prevista_desbloqueio(), "dd/MM/yyyy")}, {"dt_solicitacao_alarme","=", com.egen.util.text.FormatDate.parseDate(f.getDt_solicitacao_alarme(), "dd/MM/yyyy")}, {"dt_rec_alarme_pcp","=", com.egen.util.text.FormatDate.parseDate(f.getDt_rec_alarme_pcp(), "dd/MM/yyyy")}, {"dt_rec_alarme_filial","=", com.egen.util.text.FormatDate.parseDate(f.getDt_rec_alarme_filial(), "dd/MM/yyyy")}, {"nfe_numero","=", com.egen.util.text.FormatNumber.toInteger(f.getNfe_numero())}, {"valor_pedido","=", com.egen.util.text.FormatNumber.toDouble(f.getValor_pedido())}, {"distribuicao","like", f.getDistribuicao()}, {"livro","like", f.getLivro()}, {"ref_cliente_por_pedido","like", f.getRef_cliente_por_pedido()}, {"tra_cdgo","=", com.egen.util.text.FormatNumber.toInteger(f.getTra_cdgo())}, {"tra_rzao","like", f.getTra_rzao()}, {"dt_corte","=", com.egen.util.text.FormatDate.parseDate(f.getDt_corte(), "dd/MM/yyyy")}, {"preco_pdv","like", f.getPreco_pdv()}, {"certificado_origem","like", f.getCertificado_origem()}, {"gerar_requisicao","like", ((f.getGerar_requisicao() != null && f.getGerar_requisicao().length() > 0) ? ("S") : ("N"))}, {"tes_codigo","like", f.getTes_codigo()}, {"les_codigo","=", com.egen.util.text.FormatNumber.toInteger(f.getLes_codigo())}, {"data_etiquetagem","=", com.egen.util.text.FormatDate.parseDate(f.getData_etiquetagem(), "dd/MM/yyyy")}, {"descricao_situacao","like", f.getDescricao_situacao()}, {"descricao_embalagem","like", f.getDescricao_embalagem()}, {"cnpj","like", f.getCnpj()}, {"numero_romaneio","like", f.getNumero_romaneio()}, {"data_finalizacao_romaneio","like", f.getData_finalizacao_romaneio()}, {"modelo_alarme","like", f.getModelo_alarme()}, {"grades_corrugados","like", f.getGrades_corrugados()}, {"filial_local_estoque","like", f.getFilial_local_estoque()}, };
      Vector res_Controle_clientes_especiais_vw = j.select(table, select, where, groupby, having, order);
      session.setAttribute("res_Controle_clientes_especiais_vw",res_Controle_clientes_especiais_vw);
      if (res_Controle_clientes_especiais_vw != null && res_Controle_clientes_especiais_vw.size() > 0) {
        int _ge_pos = 0;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++, _ge_pos++) {
          f = _ge_grid_array[_ge_grid_array_index];
          f.reset(mapping, request);
          if (res_Controle_clientes_especiais_vw.size() > _ge_pos) {
            Controle_clientes_especiais_vw r = (Controle_clientes_especiais_vw) res_Controle_clientes_especiais_vw.elementAt(_ge_pos);
            f.setPed_nmro((r.getPed_nmro() != null) ? r.getPed_nmro() + "":"");
            f.setPed_boni((r.getPed_boni() != null) ? com.egen.util.text.FormatNumber.format(r.getPed_boni(), "##,##0.00") : "");
            f.setPed_boni2((r.getPed_boni2() != null) ? com.egen.util.text.FormatNumber.format(r.getPed_boni2(), "##,##0.00") : "");
            f.setPed_desc((r.getPed_desc() != null) ? com.egen.util.text.FormatNumber.format(r.getPed_desc(), "##,##0.00") : "");
            f.setCnd_cdgo((r.getCnd_cdgo() != null) ? r.getCnd_cdgo() + "":"");
            f.setOc((r.getOc() != null) ? r.getOc() + "":"");
            f.setModelos((r.getModelos() != null) ? r.getModelos() + "":"");
            f.setEtiquetas((r.getEtiquetas() != null) ? r.getEtiquetas() + "":"");
            f.setDt_entrega_etiqueta(com.egen.util.text.FormatDate.format(r.getDt_entrega_etiqueta(), "dd/MM/yyyy"));
            f.setObse_adicionais((r.getObse_adicionais() != null) ? r.getObse_adicionais() + "":"");
            f.setPrs((r.getPrs() != null) ? r.getPrs() + "":"");
            f.setRemessa((r.getRemessa() != null) ? r.getRemessa() + "":"");
            f.setFilial_prd((r.getFilial_prd() != null) ? r.getFilial_prd() + "":"");
            f.setFil_filial_fat((r.getFil_filial_fat() != null) ? r.getFil_filial_fat() + "":"");
            f.setDt_digit(com.egen.util.text.FormatDate.format(r.getDt_digit(), "dd/MM/yyyy"));
            f.setDt_fatur(com.egen.util.text.FormatDate.format(r.getDt_fatur(), "dd/MM/yyyy"));
            f.setDt_fatur_filial(com.egen.util.text.FormatDate.format(r.getDt_fatur_filial(), "dd/MM/yyyy"));
            f.setMarca((r.getMarca() != null) ? r.getMarca() + "":"");
            f.setCarimbo((r.getCarimbo() != null) ? r.getCarimbo() + "":"");
            f.setRotulos((r.getRotulos() != null) ? r.getRotulos() + "":"");
            f.setPed_amostra((r.getPed_amostra() != null) ? r.getPed_amostra() + "":"");
            f.setDt_envio_amostras(com.egen.util.text.FormatDate.format(r.getDt_envio_amostras(), "dd/MM/yyyy"));
            f.setAgendamento_cdgo((r.getAgendamento_cdgo() != null) ? r.getAgendamento_cdgo() + "":"");
            f.setData_efetiva(com.egen.util.text.FormatDate.format(r.getData_efetiva(), "dd/MM/yyyy"));
            f.setCodigo_regional((r.getCodigo_regional() != null) ? r.getCodigo_regional() + "":"");
            f.setRep_cdgo((r.getRep_cdgo() != null) ? r.getRep_cdgo() + "":"");
            f.setCli_cdgo((r.getCli_cdgo() != null) ? r.getCli_cdgo() + "":"");
            f.setCodigo_marca((r.getCodigo_marca() != null) ? r.getCodigo_marca() + "":"");
            f.setPed_stat((r.getPed_stat() != null) ? r.getPed_stat() + "":"");
            f.setHora((r.getHora() != null) ? r.getHora() + "":"");
            f.setSenha((r.getSenha() != null) ? r.getSenha() + "":"");
            f.setDt_emissao(com.egen.util.text.FormatDate.format(r.getDt_emissao(), "dd/MM/yyyy"));
            f.setFilial((r.getFilial() != null) ? r.getFilial() + "":"");
            f.setNotafiscal((r.getNotafiscal() != null) ? r.getNotafiscal() + "":"");
            f.setVolumes((r.getVolumes() != null) ? r.getVolumes() + "":"");
            f.setDt_inspecao(com.egen.util.text.FormatDate.format(r.getDt_inspecao(), "dd/MM/yyyy"));
            f.setDt_montagem(com.egen.util.text.FormatDate.format(r.getDt_montagem(), "dd/MM/yyyy"));
            f.setGrupo_economico((r.getGrupo_economico() != null) ? r.getGrupo_economico() + "":"");
            f.setCli_rzao((r.getCli_rzao() != null) ? r.getCli_rzao() + "":"");
            f.setSituacao((r.getSituacao() != null) ? r.getSituacao() + "":"");
            f.setCabide((r.getCabide() != null) ? r.getCabide() + "":"");
            f.setAmostra((r.getAmostra() != null) ? r.getAmostra() + "":"");
            f.setTipo_amostra((r.getTipo_amostra() != null) ? r.getTipo_amostra() + "":"");
            f.setPedido_prod((r.getPedido_prod() != null) ? r.getPedido_prod() + "":"");
            f.setEncarte((r.getEncarte() != null) ? r.getEncarte() + "":"");
            f.setDt_ent_amostra_comercial(com.egen.util.text.FormatDate.format(r.getDt_ent_amostra_comercial(), "dd/MM/yyyy"));
            f.setDt_ent_amostra_pcp(com.egen.util.text.FormatDate.format(r.getDt_ent_amostra_pcp(), "dd/MM/yyyy"));
            f.setPortao((r.getPortao() != null) ? r.getPortao() + "":"");
            f.setCd_entrega((r.getCd_entrega() != null) ? r.getCd_entrega() + "":"");
            f.setData_entrega_cliente(com.egen.util.text.FormatDate.format(r.getData_entrega_cliente(), "dd/MM/yyyy"));
            f.setPed_amostra_brinde((r.getPed_amostra_brinde() != null) ? r.getPed_amostra_brinde() + "":"");
            f.setEsc_seqn((r.getEsc_seqn() != null) ? r.getEsc_seqn() + "":"");
            f.setNome_regional((r.getNome_regional() != null) ? r.getNome_regional() + "":"");
            f.setRep_rzao((r.getRep_rzao() != null) ? r.getRep_rzao() + "":"");
            f.setPed_tipo((r.getPed_tipo() != null) ? r.getPed_tipo() + "":"");
            f.setDt_rec_etiqueta_filial(com.egen.util.text.FormatDate.format(r.getDt_rec_etiqueta_filial(), "dd/MM/yyyy"));
            f.setEncarte1((r.getEncarte() != null) ? r.getEncarte() + "":"");
            f.setPrioridade_embarque((new Boolean(r.getPrioridade_embarque() + "")).booleanValue());
            f.setAtacado((r.getAtacado() != null) ? r.getAtacado() + "":"");
            f.setAlerta((r.getAlerta() != null) ? r.getAlerta() + "":"");
            f.setPed_especie_pedido((r.getPed_especie_pedido() != null) ? r.getPed_especie_pedido() + "":"");
            f.setPed_obse((r.getPed_obse() != null) ? r.getPed_obse() + "":"");
            f.setDt_emiss(com.egen.util.text.FormatDate.format(r.getDt_emiss(), "dd/MM/yyyy"));
            f.setNro_normativa_cliente((r.getNro_normativa_cliente() != null) ? r.getNro_normativa_cliente() + "":"");
            f.setDescricao_normativa_cliente((r.getDescricao_normativa_cliente() != null) ? r.getDescricao_normativa_cliente() + "":"");
            f.setMin_fabr((r.getMin_fabr() != null) ? r.getMin_fabr() + "":"");
            f.setBloqueio_49((r.getBloqueio_49() != null) ? r.getBloqueio_49() + "":"");
            f.setLoja((r.getLoja() != null) ? r.getLoja() + "":"");
            f.setCidade((r.getCidade() != null) ? r.getCidade() + "":"");
            f.setPed_invoice((r.getPed_invoice() != null) ? r.getPed_invoice() + "":"");
            f.setOcorrencia((r.getOcorrencia() != null) ? r.getOcorrencia() + "":"");
            f.setData_bloqueio(com.egen.util.text.FormatDate.format(r.getData_bloqueio(), "dd/MM/yyyy"));
            f.setData_prevista_desbloqueio(com.egen.util.text.FormatDate.format(r.getData_prevista_desbloqueio(), "dd/MM/yyyy"));
            f.setDt_solicitacao_alarme(com.egen.util.text.FormatDate.format(r.getDt_solicitacao_alarme(), "dd/MM/yyyy"));
            f.setDt_rec_alarme_pcp(com.egen.util.text.FormatDate.format(r.getDt_rec_alarme_pcp(), "dd/MM/yyyy"));
            f.setDt_rec_alarme_filial(com.egen.util.text.FormatDate.format(r.getDt_rec_alarme_filial(), "dd/MM/yyyy"));
            f.setNfe_numero((r.getNfe_numero() != null) ? r.getNfe_numero() + "":"");
            f.setValor_pedido(r.getValor_pedido() + "");
            f.setDistribuicao((r.getDistribuicao() != null) ? r.getDistribuicao() + "":"");
            f.setLivro((r.getLivro() != null) ? r.getLivro() + "":"");
            f.setRef_cliente_por_pedido((r.getRef_cliente_por_pedido() != null) ? r.getRef_cliente_por_pedido() + "":"");
            f.setTra_cdgo((r.getTra_cdgo() != null) ? r.getTra_cdgo() + "":"");
            f.setTra_rzao((r.getTra_rzao() != null) ? r.getTra_rzao() + "":"");
            f.setDt_corte(com.egen.util.text.FormatDate.format(r.getDt_corte(), "dd/MM/yyyy"));
            f.setPreco_pdv((r.getPreco_pdv() != null) ? r.getPreco_pdv() + "":"");
            f.setCertificado_origem((r.getCertificado_origem() != null) ? r.getCertificado_origem() + "":"");
            f.setGerar_requisicao((r.getGerar_requisicao() != null) ? r.getGerar_requisicao() + "":"");
            f.setTes_codigo((r.getTes_codigo() != null) ? r.getTes_codigo() + "":"");
            f.setLes_codigo((r.getLes_codigo() != null) ? r.getLes_codigo() + "":"");
            f.setData_etiquetagem(com.egen.util.text.FormatDate.format(r.getData_etiquetagem(), "dd/MM/yyyy"));
            f.setDescricao_modelos((r.getDescricao_modelos() != null) ? r.getDescricao_modelos() + "":"");
            f.setLiberado_faturar((r.getLiberado_faturar() != null) ? r.getLiberado_faturar() + "":"");
            f.setDescricao_situacao((r.getDescricao_situacao() != null) ? r.getDescricao_situacao() + "":"");
            f.setDescricao_embalagem((r.getDescricao_embalagem() != null) ? r.getDescricao_embalagem() + "":"");
            f.setCnpj((r.getCnpj() != null) ? r.getCnpj() + "":"");
            f.setNumero_romaneio((r.getNumero_romaneio() != null) ? r.getNumero_romaneio() + "":"");
            f.setData_finalizacao_romaneio((r.getData_finalizacao_romaneio() != null) ? r.getData_finalizacao_romaneio() + "":"");
            f.setModelo_alarme((r.getModelo_alarme() != null) ? r.getModelo_alarme() + "":"");
            f.setGrades_corrugados((r.getGrades_corrugados() != null) ? r.getGrades_corrugados() + "":"");
            f.setFilial_local_estoque((r.getFilial_local_estoque() != null) ? r.getFilial_local_estoque() + "":"");
            f.setBloqueio_oc((r.getBloqueio_oc() != null) ? r.getBloqueio_oc() + "":"");
            f.setBloqueio_distribuicao((r.getBloqueio_distribuicao() != null) ? r.getBloqueio_distribuicao() + "":"");
            f.setBloqueio_cliente((r.getBloqueio_cliente() != null) ? r.getBloqueio_cliente() + "":"");
            f.setBloqueio_sku((r.getBloqueio_sku() != null) ? r.getBloqueio_sku() + "":"");
            f.setBloqueio_credito((r.getBloqueio_credito() != null) ? r.getBloqueio_credito() + "":"");
            f.setBloqueio_suframa((r.getBloqueio_suframa() != null) ? r.getBloqueio_suframa() + "":"");
          }
          _ge_grid_array[_ge_grid_array_index] = f;
        }
      } else {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Controle_clientes_especiais_vw", new ActionMessage("warn.norowsselected",""));
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      }
      session.setAttribute(mapping.getName(), form);
    }
  }

}
