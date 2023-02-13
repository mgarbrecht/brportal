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
 * Creation Date 03/02/2012 11:28:50
 * Last Modify Date 24/11/2022 11:49:12
 */

public class SolicitacaoCombinacaoEspecial_aAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      SolicitacaoCombinacaoEspecial_aActionForm f = (SolicitacaoCombinacaoEspecial_aActionForm) form;
      select_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ref_combinacao_especial", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    session.removeAttribute("v_numeracao");
    util.consultas.Query query = new util.consultas.Query();
    SolicitacaoCombinacaoEspecial_aActionForm f = (SolicitacaoCombinacaoEspecial_aActionForm) form;
    util.consultas.DiasUteis diasUteis = new util.consultas.DiasUteis();
    String dataAtual5dias = diasUteis.buscar(5);
    String dataAtual10dias = diasUteis.buscar(10);
    String dataAtual24horas = query.retorna("SELECT to_char(SYSDATE+1,'dd/mm/yyyy hh24:mi:ss') FROM dual");

    Ref_combinacao_especial table = new Ref_combinacao_especial();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"id_solicitacao","=", com.egen.util.text.FormatNumber.toInteger(f.getId_solicitacao())}};
    Vector res_Ref_combinacao_especial = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Ref_combinacao_especial",res_Ref_combinacao_especial);
    if (res_Ref_combinacao_especial != null && res_Ref_combinacao_especial.size() > 0) {
      Ref_combinacao_especial r = (Ref_combinacao_especial) res_Ref_combinacao_especial.elementAt(0);
      f.setId_solicitacao((r.getId_solicitacao() != null) ? r.getId_solicitacao() + "":"");
      f.setData_solicitacao(com.egen.util.text.FormatDate.format(r.getData_solicitacao(), "dd/MM/yyyy HH:mm:ss"));
      f.setData_entrega_amostra(com.egen.util.text.FormatDate.format(r.getData_entrega_amostra(), "dd/MM/yyyy"));
      f.setUsuario_solicitacao((r.getUsuario_solicitacao() != null) ? r.getUsuario_solicitacao() + "":"");
      f.setCodigo_marca((r.getCodigo_marca() != null) ? r.getCodigo_marca() + "":"");
      f.setRep_cdgo((r.getRep_cdgo() != null) ? r.getRep_cdgo() + "":"");
      f.setTipo_solicitacao((r.getTipo_solicitacao_comb_especial() != null) ? r.getTipo_solicitacao_comb_especial() + "":"");
      f.setSubtipo_solicitacao_comb_espec((r.getSubtipo_solicitacao_comb_espec() != null) ? r.getSubtipo_solicitacao_comb_espec() + "":"");
      f.setLin_cdgo((r.getLin_cdgo() != null) ? r.getLin_cdgo() + "":"");
      f.setRef_cdgo((r.getRef_cdgo() != null) ? r.getRef_cdgo() + "":"");
      f.setCab_cdgo((r.getCab_cdgo() != null) ? r.getCab_cdgo() + "":"");
      f.setCor_cdgo((r.getCor_cdgo() != null) ? r.getCor_cdgo() + "":"");
      f.setObservacao((r.getObservacao() != null) ? r.getObservacao() + "":"");
      f.setMaterial((r.getMaterial() != null) ? r.getMaterial() + "":"");
      f.setMaterial_cor1((r.getMaterial_cor1() != null) ? r.getMaterial_cor1() + "":"");
      f.setMaterial_cor2((r.getMaterial_cor2() != null) ? r.getMaterial_cor2() + "":"");
      f.setMaterial_cor3((r.getMaterial_cor3() != null) ? r.getMaterial_cor3() + "":"");
      f.setMaterial_cor4((r.getMaterial_cor4() != null) ? r.getMaterial_cor4() + "":"");
      f.setMaterial_cor5((r.getMaterial_cor5() != null) ? r.getMaterial_cor5() + "":"");
      f.setMaterial_cor6((r.getMaterial_cor6() != null) ? r.getMaterial_cor6() + "":"");
      f.setMaterial_cor7((r.getMaterial_cor7() != null) ? r.getMaterial_cor7() + "":"");
      f.setMaterial_cor8((r.getMaterial_cor8() != null) ? r.getMaterial_cor8() + "":"");
      f.setMaterial_cor9((r.getMaterial_cor9() != null) ? r.getMaterial_cor9() + "":"");
      f.setMaterial_cor10((r.getMaterial_cor10() != null) ? r.getMaterial_cor10() + "":"");
      f.setBiqueira_debrum((r.getBiqueira_debrum() != null) ? r.getBiqueira_debrum() + "":"");
      f.setCapa_palmilha((r.getCapa_palmilha() != null) ? r.getCapa_palmilha() + "":"");
      f.setCacharel((r.getCacharel() != null) ? r.getCacharel() + "":"");
      f.setForro((r.getForro() != null) ? r.getForro() + "":"");
      f.setMetais((r.getMetais() != null) ? r.getMetais() + "":"");
      f.setTaloneira((r.getTaloneira() != null) ? r.getTaloneira() + "":"");
      f.setSalto((r.getSalto() != null) ? r.getSalto() + "":"");
      f.setEnfeite((r.getEnfeite() != null) ? r.getEnfeite() + "":"");
      f.setCarimbo_etiqueta((r.getCarimbo_etiqueta() != null) ? r.getCarimbo_etiqueta() + "":"");
      f.setCli_cdgo((r.getCli_cdgo() != null) ? r.getCli_cdgo() + "":"");
      f.setGre_grupo((r.getGre_grupo() != null) ? r.getGre_grupo() + "":"");
      f.setCepa((r.getCepa() != null) ? r.getCepa() + "":"");
      f.setSola((r.getSola() != null) ? r.getSola() + "":"");
      f.setPrs_negociacao((r.getPrs_negociacao() != null) ? com.egen.util.text.FormatNumber.format(r.getPrs_negociacao(), "0") : "");
      f.setPares_linha((r.getPares_linha() != null) ? com.egen.util.text.FormatNumber.format(r.getPares_linha(), "0") : "");
      f.setPares_alteracao((r.getPares_alteracao() != null) ? com.egen.util.text.FormatNumber.format(r.getPares_alteracao(), "0") : "");
      f.setPreco_liguido((r.getPreco_liguido() != null) ? com.egen.util.text.FormatNumber.format(r.getPreco_liguido(), "##,##0.00") : "");
      f.setValor_fabricacao((r.getValor_fabricacao() != null) ? com.egen.util.text.FormatNumber.format(r.getValor_fabricacao(), "##,##0.000") : "");
      f.setPreco_vendor((r.getPreco_vendor() != null) ? com.egen.util.text.FormatNumber.format(r.getPreco_vendor(), "##,##0.00") : "");
      f.setLl_alteracao_solicitada((r.getLl_alteracao_solicitada() != null) ? com.egen.util.text.FormatNumber.format(r.getLl_alteracao_solicitada(), "##,##0.00") : "");
      f.setSituacao_solicitacao((r.getSituacao_solicitacao() != null) ? r.getSituacao_solicitacao() + "":"");
      f.setData_aceite(com.egen.util.text.FormatDate.format(r.getData_aceite(), "dd/MM/yyyy HH:mm:ss"));
      f.setData_aprovacao(com.egen.util.text.FormatDate.format(r.getData_aprovacao(), "dd/MM/yyyy HH:mm:ss"));
      f.setUsuario_aceite((r.getUsuario_aceite() != null) ? r.getUsuario_aceite() + "":"");
      f.setAtacador((r.getAtacador() != null) ? r.getAtacador() + "":"");
      f.setPedido((r.getPed_nmro() != null) ? r.getPed_nmro() + "":"");
      f.setItem((r.getIte_seqn() != null) ? r.getIte_seqn() + "":"");
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ref_combinacao_especial", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }

    //--- Select Imagem ---
    Ref_combinacao_especial_img table_img = new Ref_combinacao_especial_img();
    String[][] select_img = null;
    Object[][] where_img = {{"id_solicitacao","=", com.egen.util.text.FormatNumber.toInteger(f.getId_solicitacao())}};
    Vector res_Ref_combinacao_especial_img = j.select(table_img, select_img, where_img, null, null, null);
    session.setAttribute("res_Ref_combinacao_especial_img",res_Ref_combinacao_especial_img);
    if (res_Ref_combinacao_especial_img != null && res_Ref_combinacao_especial_img.size() > 0) {
      Ref_combinacao_especial_img r_img = (Ref_combinacao_especial_img) res_Ref_combinacao_especial_img.elementAt(0);
      f.setImagem_produto((r_img.getImagem() != null) ? r_img.getImagem() + "":"");
    }


    //--- Select Grade ---
    Ref_comb_especial_grade table_grade = new Ref_comb_especial_grade();
    String[][] select1 = null;
    Object[][] where1 = { {"id_solicitacao","=", com.egen.util.text.FormatNumber.toInteger(f.getId_solicitacao())}};
    Vector res_Ref_comb_especial_grade = j.select(table_grade, select1, where1, null, null, null);
    java.util.Vector v = new java.util.Vector();
    int i_bl_report_Ref_comb_especial_grade = 0;
    while (i_bl_report_Ref_comb_especial_grade < res_Ref_comb_especial_grade.size()) {
      portalbr.dbobj.table.Ref_comb_especial_grade t_ref_comb_especial_grade = (portalbr.dbobj.table.Ref_comb_especial_grade) res_Ref_comb_especial_grade.elementAt(i_bl_report_Ref_comb_especial_grade);
      v.add(t_ref_comb_especial_grade.getNumeracao() + "#"+t_ref_comb_especial_grade.getQtp_pars());
      i_bl_report_Ref_comb_especial_grade++;
    }
    if (i_bl_report_Ref_comb_especial_grade > 0) {
      session.setAttribute("v_numeracao", v);
    }
    //--------------------

    session.setAttribute(mapping.getName(), form);
  }
  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      SolicitacaoCombinacaoEspecial_aActionForm f = (SolicitacaoCombinacaoEspecial_aActionForm) form;
      try {
        tg_update_action_1(mapping, form, request, response);
        update_action(j, mapping, form, request, response);
        tg_update_action(mapping, form, request, response);

      }
      finally {
      }
      actionForward = new ActionForward("/com/SolicitacaoCombinacaoEspecialForm.do?select2_action=",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ref_combinacao_especial", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void update_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    SolicitacaoCombinacaoEspecial_aActionForm f = (SolicitacaoCombinacaoEspecial_aActionForm) form;
    util.consultas.Query query = new util.consultas.Query();
    util.consultas.Parametros parametros = new util.consultas.Parametros();

    if (f.getArquivo() != null && f.getArquivo().toString() != null && f.getArquivo().toString().length() > 0) {
      String realPath2bl_form = parametros.retornaParametro("diretorio_arquivos_solicitacao_especial");
      realPath2bl_form = realPath2bl_form + java.io.File.separator;
      org.apache.struts.upload.FormFile inputfile2bl_form = f.getArquivo();
      if (inputfile2bl_form.getFileSize() > 512000) {
        throw new Exception("O arquivo de imagem ultrapassou o tamanho máximo de 500kb!");
      }
    }

    Ref_combinacao_especial table = new Ref_combinacao_especial();
    Vector sets = new Vector(10, 2);

    table.setId_solicitacao(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getId_solicitacao()));
    if (f.getId_solicitacao() != null) {
      sets.addElement("id_solicitacao");
    }
    table.setData_solicitacao(com.egen.util.text.FormatDate.parseTimestamp(f.getData_solicitacao(), "dd/MM/yyyy HH:mm:ss"));
    if (f.getData_solicitacao() != null) {
      sets.addElement("data_solicitacao");
    }
    table.setData_entrega_amostra(com.egen.util.text.FormatDate.parseTimestamp(f.getData_entrega_amostra(), "dd/MM/yyyy"));
    if (f.getData_entrega_amostra() != null) {
      sets.addElement("data_entrega_amostra");
    }
    table.setUsuario_solicitacao(f.getUsuario_solicitacao());
    if (f.getUsuario_solicitacao() != null) {
      sets.addElement("usuario_solicitacao");
    }

    table.setCodigo_marca(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCodigo_marca()));
    if (f.getCodigo_marca() != null) {
      sets.addElement("codigo_marca");
    }

    table.setTipo_solicitacao_comb_especial(f.getTipo_solicitacao());
    if (f.getTipo_solicitacao() != null) {
      sets.addElement("tipo_solicitacao_comb_especial");
    }

    table.setSubtipo_solicitacao_comb_espec(f.getSubtipo_solicitacao_comb_espec());
    if (f.getSubtipo_solicitacao_comb_espec() != null) {
      sets.addElement("subtipo_solicitacao_comb_espec");
    }

    table.setLin_cdgo(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getLin_cdgo()));
    if (f.getLin_cdgo() != null) {
      sets.addElement("lin_cdgo");
    }
    table.setRef_cdgo(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getRef_cdgo()));
    if (f.getRef_cdgo() != null) {
      sets.addElement("ref_cdgo");
    }
    table.setCab_cdgo(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCab_cdgo()));
    if (f.getCab_cdgo() != null) {
      sets.addElement("cab_cdgo");
    }

    table.setRep_cdgo(f.getRep_cdgo());
    if (f.getRep_cdgo() != null) {
      sets.addElement("rep_cdgo");
    }


    table.setCor_cdgo(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCor_cdgo()));
    if (f.getCor_cdgo() != null) {
      sets.addElement("cor_cdgo");
    }
    table.setObservacao(f.getObservacao());
    if (f.getObservacao() != null) {
      sets.addElement("observacao");
    }
    table.setMaterial_cor1(f.getMaterial_cor1());
    if (f.getMaterial_cor1() != null) {
      sets.addElement("material_cor1");
    }
    table.setMaterial_cor2(f.getMaterial_cor2());
    if (f.getMaterial_cor2() != null) {
      sets.addElement("material_cor2");
    }
    table.setMaterial_cor3(f.getMaterial_cor3());
    if (f.getMaterial_cor3() != null) {
      sets.addElement("material_cor3");
    }
    table.setMaterial_cor4(f.getMaterial_cor4());
    if (f.getMaterial_cor4() != null) {
      sets.addElement("material_cor4");
    }
    table.setMaterial_cor5(f.getMaterial_cor5());
    if (f.getMaterial_cor5() != null) {
      sets.addElement("material_cor5");
    }
    table.setMaterial_cor6(f.getMaterial_cor6());
    if (f.getMaterial_cor6() != null) {
      sets.addElement("material_cor6");
    }
    table.setMaterial_cor7(f.getMaterial_cor7());
    if (f.getMaterial_cor7() != null) {
      sets.addElement("material_cor7");
    }
    table.setMaterial_cor8(f.getMaterial_cor8());
    if (f.getMaterial_cor8() != null) {
      sets.addElement("material_cor8");
    }
    table.setMaterial_cor9(f.getMaterial_cor9());
    if (f.getMaterial_cor9() != null) {
      sets.addElement("material_cor9");
    }
    table.setMaterial_cor10(f.getMaterial_cor10());
    if (f.getMaterial_cor10() != null) {
      sets.addElement("material_cor10");
    }
    table.setBiqueira_debrum(f.getBiqueira_debrum());
    if (f.getBiqueira_debrum() != null) {
      sets.addElement("biqueira_debrum");
    }
    table.setCapa_palmilha(f.getCapa_palmilha());
    if (f.getCapa_palmilha() != null) {
      sets.addElement("capa_palmilha");
    }
    table.setCacharel(f.getCacharel());
    if (f.getCacharel() != null) {
      sets.addElement("cacharel");
    }
    table.setForro(f.getForro());
    if (f.getForro() != null) {
      sets.addElement("forro");
    }
    table.setMetais(f.getMetais());
    if (f.getMetais() != null) {
      sets.addElement("metais");
    }
    table.setTaloneira(f.getTaloneira());
    if (f.getTaloneira() != null) {
      sets.addElement("taloneira");
    }
    table.setSalto(f.getSalto());
    if (f.getSalto() != null) {
      sets.addElement("salto");
    }

    table.setCepa(f.getCepa());
    if (f.getCepa() != null) {
      sets.addElement("cepa");
    }
    table.setSola(f.getSola());
    if (f.getSola() != null) {
      sets.addElement("sola");
    }
    table.setEnfeite(f.getEnfeite());
    if (f.getEnfeite() != null) {
      sets.addElement("enfeite");
    }
    table.setCarimbo_etiqueta(f.getCarimbo_etiqueta());
    if (f.getCarimbo_etiqueta() != null) {
      sets.addElement("carimbo_etiqueta");
    }
    table.setCli_cdgo(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCli_cdgo()));
    if (f.getCli_cdgo() != null) {
      sets.addElement("cli_cdgo");
    }
    table.setGre_grupo(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getGre_grupo()));
    if (f.getGre_grupo() != null) {
      sets.addElement("gre_grupo");
    }
    table.setPrs_negociacao(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getPrs_negociacao()));
    if (f.getPrs_negociacao() != null) {
      sets.addElement("prs_negociacao");
    }
    table.setPares_linha(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getPares_linha()));
    if (f.getPares_linha() != null) {
      sets.addElement("pares_linha");
    }
    table.setPares_alteracao(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getPares_alteracao()));
    if (f.getPares_alteracao() != null) {
      sets.addElement("pares_alteracao");
    }
    table.setPreco_liguido(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getPreco_liguido()));
    if (f.getPreco_liguido() != null) {
      sets.addElement("preco_liguido");
    }
    table.setValor_fabricacao(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getValor_fabricacao()));
    if (f.getValor_fabricacao() != null) {
      sets.addElement("valor_fabricacao");
    }
    table.setPreco_vendor(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getPreco_vendor()));
    if (f.getPreco_vendor() != null) {
      sets.addElement("preco_vendor");
    }
    table.setLl_alteracao_solicitada(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getLl_alteracao_solicitada()));
    if (f.getLl_alteracao_solicitada() != null) {
      sets.addElement("ll_alteracao_solicitada");
    }
    table.setSituacao_solicitacao(f.getSituacao_solicitacao());
    if (f.getSituacao_solicitacao() != null) {
      sets.addElement("situacao_solicitacao");
    }
    table.setData_aceite(com.egen.util.text.FormatDate.parseDate(f.getData_aceite(), "dd/MM/yyyy HH:mm:ss"));
    if (f.getData_aceite() != null) {
      sets.addElement("data_aceite");
    }
    table.setUsuario_aceite(f.getUsuario_aceite());
    if (f.getUsuario_aceite() != null) {
      sets.addElement("usuario_aceite");
    }
    table.setMaterial(f.getMaterial());
    if (f.getMaterial() != null) {
      sets.addElement("material");
    }
    table.setPed_nmro(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getPedido()));
    if (f.getPedido() != null) {
      sets.addElement("ped_nmro");
    }
    table.setIte_seqn(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getItem()));
    if (f.getItem() != null) {
      sets.addElement("ite_seqn");
    }
    table.setAtacador(f.getAtacador());
    if (f.getAtacador() != null) {
      sets.addElement("atacador");
    }

    acesso.Sessao sessao = new acesso.Sessao(session);
    table.setUsuario_alteracao(sessao.getUsuario());
    sets.addElement("usuario_alteracao");

    String dataAtual = null;
    String situacaoAnterior = query.retorna(j, "SELECT r.situacao_solicitacao FROM brio.ref_combinacao_especial r WHERE id_solicitacao = " + f.getId_solicitacao());
    if (f.getSituacao_solicitacao().equalsIgnoreCase("A")) {
      if (!situacaoAnterior.equalsIgnoreCase("A")) {
        dataAtual = query.retorna(j, "select to_char(sysdate,'dd/mm/yyyy hh24:mi:ss') from dual");
        f.setData_aprovacao(dataAtual);
      }
    }

    table.setData_aprovacao(com.egen.util.text.FormatDate.parseTimestamp(f.getData_aprovacao(), "dd/MM/yyyy HH:mm:ss"));
    if (f.getData_aprovacao() != null) {
      sets.addElement("data_aprovacao");
    }

    if (sets != null && sets.size() > 0) {
      String[] set = new String[sets.size()];
      for (int i = 0; i < sets.size(); i++) {
        set[i] = (String) sets.elementAt(i);
      }
      //----------------------
      if (f.getArquivo() != null && f.getArquivo().toString() != null && f.getArquivo().toString().length() > 0) {
        String arquivo = query.retorna(j, "SELECT nvl(imagem,'') FROM brio.ref_combinacao_especial_img WHERE id_solicitacao = " + f.getId_solicitacao());
        if (!arquivo.equals("")) {
          java.io.File file = new java.io.File(parametros.retornaParametro("diretorio_arquivos_solicitacao_especial") + arquivo);
          file.delete();
          String realPath2bl_form = parametros.retornaParametro("diretorio_arquivos_solicitacao_especial");
          try {
            java.io.File fileArquivo = new java.io.File(realPath2bl_form + util.text.Caracteres.removerAcentos(arquivo));
            util.amazon.S3Amazon s3Amazon = new util.amazon.S3Amazon("medias.calcadosbeirario.com.br");
            s3Amazon.apagarImagem("solicitacao_combinacao_especial", fileArquivo);
          } catch (Exception e) {
            e.printStackTrace();
          }
          query.execute(j, "DELETE brio.ref_combinacao_especial_img WHERE id_imagem=1 AND id_solicitacao = "+ f.getId_solicitacao());
        }
      }
      //----------------------
      int updated = j.update(table, set);


      if (updated == 0) {
        ActionErrors errors = new ActionErrors();
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ref_combinacao_especial", new ActionMessage("warn.norowsupdated",": " + updated));
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      } else {

        util.consultas.com.SolicitacaoCombinacaoEspecial s = new util.consultas.com.SolicitacaoCombinacaoEspecial();
        s.enviarEmail(form, request, f.getId_solicitacao(), f.getSituacao_solicitacao());

        Vector res_Ref_combinacao_especial = (Vector) session.getAttribute("res_Ref_combinacao_especial");
        if (res_Ref_combinacao_especial != null) {
          res_Ref_combinacao_especial.setElementAt(table, 0);
          Ref_combinacao_especial r = (Ref_combinacao_especial) res_Ref_combinacao_especial.elementAt(0);
          f.setId_solicitacao((r.getId_solicitacao() != null) ? r.getId_solicitacao() + "":"");
          f.setData_solicitacao(com.egen.util.text.FormatDate.format(r.getData_solicitacao(), "dd/MM/yyyy"));
          f.setData_entrega_amostra(com.egen.util.text.FormatDate.format(r.getData_entrega_amostra(), "dd/MM/yyyy"));
          f.setUsuario_solicitacao((r.getUsuario_solicitacao() != null) ? r.getUsuario_solicitacao() + "":"");
          f.setCodigo_marca((r.getCodigo_marca() != null) ? r.getCodigo_marca() + "":"");
          f.setTipo_solicitacao((r.getTipo_solicitacao_comb_especial() != null) ? r.getTipo_solicitacao_comb_especial() + "":"");
          f.setSubtipo_solicitacao_comb_espec((r.getSubtipo_solicitacao_comb_espec() != null) ? r.getSubtipo_solicitacao_comb_espec() + "":"");
          f.setLin_cdgo((r.getLin_cdgo() != null) ? r.getLin_cdgo() + "":"");
          f.setRef_cdgo((r.getRef_cdgo() != null) ? r.getRef_cdgo() + "":"");
          f.setCab_cdgo((r.getCab_cdgo() != null) ? r.getCab_cdgo() + "":"");
          f.setCor_cdgo((r.getCor_cdgo() != null) ? r.getCor_cdgo() + "":"");
          f.setObservacao((r.getObservacao() != null) ? r.getObservacao() + "":"");
          f.setMaterial_cor1((r.getMaterial_cor1() != null) ? r.getMaterial_cor1() + "":"");
          f.setMaterial_cor2((r.getMaterial_cor2() != null) ? r.getMaterial_cor2() + "":"");
          f.setMaterial_cor3((r.getMaterial_cor3() != null) ? r.getMaterial_cor3() + "":"");
          f.setMaterial_cor4((r.getMaterial_cor4() != null) ? r.getMaterial_cor4() + "":"");
          f.setMaterial_cor5((r.getMaterial_cor5() != null) ? r.getMaterial_cor5() + "":"");
          f.setMaterial_cor6((r.getMaterial_cor6() != null) ? r.getMaterial_cor6() + "":"");
          f.setMaterial_cor7((r.getMaterial_cor7() != null) ? r.getMaterial_cor7() + "":"");
          f.setMaterial_cor8((r.getMaterial_cor8() != null) ? r.getMaterial_cor8() + "":"");
          f.setMaterial_cor9((r.getMaterial_cor9() != null) ? r.getMaterial_cor9() + "":"");
          f.setMaterial_cor10((r.getMaterial_cor10() != null) ? r.getMaterial_cor10() + "":"");
          f.setBiqueira_debrum((r.getBiqueira_debrum() != null) ? r.getBiqueira_debrum() + "":"");
          f.setCapa_palmilha((r.getCapa_palmilha() != null) ? r.getCapa_palmilha() + "":"");
          f.setCacharel((r.getCacharel() != null) ? r.getCacharel() + "":"");
          f.setForro((r.getForro() != null) ? r.getForro() + "":"");
          f.setMetais((r.getMetais() != null) ? r.getMetais() + "":"");
          f.setTaloneira((r.getTaloneira() != null) ? r.getTaloneira() + "":"");
          f.setSalto((r.getSalto() != null) ? r.getSalto() + "":"");
          f.setCepa((r.getCepa() != null) ? r.getCepa() + "":"");
          f.setCepa((r.getSola() != null) ? r.getSola() + "":"");
          f.setEnfeite((r.getEnfeite() != null) ? r.getEnfeite() + "":"");
          f.setCarimbo_etiqueta((r.getCarimbo_etiqueta() != null) ? r.getCarimbo_etiqueta() + "":"");
          f.setGre_grupo((r.getGre_grupo() != null) ? r.getGre_grupo() + "":"");
          f.setCli_cdgo((r.getCli_cdgo() != null) ? r.getCli_cdgo() + "":"");
          f.setRep_cdgo((r.getRep_cdgo() != null) ? r.getRep_cdgo() + "":"");
          f.setPrs_negociacao((r.getPrs_negociacao() != null) ? com.egen.util.text.FormatNumber.format(r.getPrs_negociacao(), "0") : "");
          f.setPares_linha((r.getPares_linha() != null) ? com.egen.util.text.FormatNumber.format(r.getPares_linha(), "0") : "");
          f.setPares_alteracao((r.getPares_alteracao() != null) ? com.egen.util.text.FormatNumber.format(r.getPares_alteracao(), "0") : "");
          f.setPreco_liguido((r.getPreco_liguido() != null) ? com.egen.util.text.FormatNumber.format(r.getPreco_liguido(), "##,##0.00") : "");
          f.setValor_fabricacao((r.getValor_fabricacao() != null) ? com.egen.util.text.FormatNumber.format(r.getValor_fabricacao(), "##,##0.000") : "");
          f.setLl_alteracao_solicitada((r.getLl_alteracao_solicitada() != null) ? com.egen.util.text.FormatNumber.format(r.getLl_alteracao_solicitada(), "##,##0.00") : "");
          f.setSituacao_solicitacao((r.getSituacao_solicitacao() != null) ? r.getSituacao_solicitacao() + "":"");
          f.setData_aceite(com.egen.util.text.FormatDate.format(r.getData_aceite(), "dd/MM/yyyy HH:mm:ss"));
          f.setUsuario_aceite((r.getUsuario_aceite() != null) ? r.getUsuario_aceite() + "":"");
          f.setMaterial((r.getMaterial() != null) ? r.getMaterial() + "":"");
          f.setData_aprovacao(com.egen.util.text.FormatDate.format(r.getData_aprovacao(), "dd/MM/yyyy HH:mm:ss"));
          f.setAtacador((r.getAtacador() != null) ? r.getAtacador() + "":"");
          f.setPedido((r.getPed_nmro() != null) ? r.getPed_nmro() + "":"");
          f.setItem((r.getIte_seqn() != null) ? r.getIte_seqn() + "":"");
        }
      }
    }
    //--- Atualiza Grade ---
    Ref_comb_especial_grade t_grade = new Ref_comb_especial_grade();
    query.execute(j, "DELETE brio.ref_comb_especial_grade where id_solicitacao = "+ f.getId_solicitacao());

    if (session.getAttribute("v_numeracao") != null) {
      for (Object a:
          ((Vector) session.getAttribute("v_numeracao")).toArray()) {
        String[] s = ((String) a).split("#");
        Object[][] name_value = { {"id_solicitacao",com.egen.util.text.FormatNumber.toInteger(f.getId_solicitacao())}, {"numeracao", s[0]}, {"qtp_pars", Integer.parseInt(s[1])} };
        j.insert(t_grade, name_value);
      }
    }


    //----------------------
    //--- Upload Nova Imagem --------------------------
    if (f.getArquivo() != null && f.getArquivo().toString() != null && f.getArquivo().toString().length() > 0) {
      String realPath2bl_form = parametros.retornaParametro("diretorio_arquivos_solicitacao_especial");
      realPath2bl_form = realPath2bl_form + java.io.File.separator;
      org.apache.struts.upload.FormFile inputfile2bl_form = f.getArquivo();
      java.io.InputStream stream2bl_form = inputfile2bl_form.getInputStream();
      java.io.OutputStream bos2bl_form = new java.io.FileOutputStream(realPath2bl_form + "S"+f.getId_solicitacao() + "_"+util.text.Caracteres.removerAcentos(inputfile2bl_form.getFileName()));
      int bytesRead2bl_form = 0;
      byte[] buffer2bl_form = new byte[8192];
      while ((bytesRead2bl_form = stream2bl_form.read(buffer2bl_form, 0, 8192)) != -1) {
        bos2bl_form.write(buffer2bl_form, 0, bytesRead2bl_form);
      }
      bos2bl_form.close();
      stream2bl_form.close();
      try {
        java.io.File arquivo = new java.io.File(realPath2bl_form + "S"+f.getId_solicitacao() + "_"+util.text.Caracteres.removerAcentos(inputfile2bl_form.getFileName()));
        util.amazon.S3Amazon s3Amazon = new util.amazon.S3Amazon("medias.calcadosbeirario.com.br");
        s3Amazon.carregarImagem("solicitacao_combinacao_especial", arquivo);
      } catch (Exception e) {
        e.printStackTrace();
      }
      query.execute(j, "DELETE brio.ref_combinacao_especial_img WHERE id_imagem = 1 AND id_solicitacao = "+ f.getId_solicitacao());
      query.execute(j, "INSERT INTO brio.ref_combinacao_especial_img VALUES ("+f.getId_solicitacao() + ",1,"+"'S"+util.text.Caracteres.removerAcentos(f.getId_solicitacao() + "_"+f.getArquivo()) + "',null) ");
    }
    //-------------------------------------------------
    session.setAttribute(mapping.getName(), form);
  }
  private void tg_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ref_combinacao_especial", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

  private void tg_update_action_1(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      SolicitacaoCombinacaoEspecial_aActionForm f = (SolicitacaoCombinacaoEspecial_aActionForm) form;
      session.setAttribute(mapping.getName(), form);

      if ((f.getTipo_solicitacao() + "").equals("3")) {
        if (f.getRef_cdgo().equals("")) {
          throw new Exception("A referência deve ser informada!");
        }
      }

      if (f.getCli_cdgo().equals("") && f.getGre_grupo().equals("")) {
        throw new Exception("Um dos campos com <img src='../img/opcional.gif'> deve ser informado!");
      }

      util.consultas.Query query = new util.consultas.Query();
      StringBuilder sb = new StringBuilder();

      //    if(f.getTipo_solicitacao().equals("5")) {
      StringBuilder sbc = new StringBuilder();
      sbc.append(" SELECT distinct 'S' existe ");
      sbc.append("   FROM ref_cor ");
      sbc.append("  WHERE lin_cdgo = " + f.getLin_cdgo());
      if (!f.getRef_cdgo().equals("")) {
        sbc.append("    AND ref_cdgo = nvl("+f.getRef_cdgo() + ", ref_cdgo) ");
      }
      if (!f.getCab_cdgo().equals("")) {
        sbc.append("    AND cab_cdgo = nvl("+f.getCab_cdgo() + ", cab_cdgo) ");
      }
      if (!f.getCor_cdgo().equals("")) {
        sbc.append("    AND cor_cdgo = nvl("+f.getCor_cdgo() + ", cor_cdgo) ");
      }

      String existeCombinacao = query.retorna(sbc.toString());

      if (!(existeCombinacao + "").equals("S")) {
        throw new Exception("Combinação linha/referência/cabedal/cor inválida!");
      }
      // }

      if (f.getTipo_solicitacao().equals("5") || f.getTipo_solicitacao().equals("2") || f.getTipo_solicitacao().equals("3")) {

        acesso.Sessao sessao = new acesso.Sessao(session);
        acesso.Usuario user = (acesso.Usuario) session.getAttribute("User");
        if (f.getPrs_negociacao().equals("")) {
          throw new Exception("Pares negociação deve ser informado!");
        }
        if (f.getPares_linha().equals("")) {
          throw new Exception("Pares linha deve ser informado!");
        }
        if (f.getPares_alteracao().equals("")) {
          throw new Exception("Pares solicitados deve ser informado!");
        }
        if (f.getPreco_liguido().equals("")) {
          throw new Exception("Preço líquido deve ser informado!");
        }
        if (f.getValor_fabricacao().equals("")) {
          throw new Exception("CTF deve ser informado!");
        }
        if (f.getPreco_vendor().equals("")) {
          throw new Exception("Preço vendor deve ser informado!");
        }
        if (sessao.getTipoEntidadeNegocio().equals("AREAS") || user.isSuperUsuario()) {
          if (f.getLl_alteracao_solicitada().equals("")) {
            throw new Exception("LL Alteração Solicitada deve ser informado!");
          }
        }



      }


      if (f.getTipo_solicitacao().equals("5")) {
        if (f.getLin_cdgo() != "" && f.getRef_cdgo() != "" && f.getCab_cdgo() != "" && f.getCor_cdgo() != "") {
          StringBuilder sbq = new StringBuilder();
          sbq.append(" SELECT case when nvl(sum(1),0) = 1 then 'M' else 'F' end mix ");
          sbq.append("   FROM ref_cor rc ");
          sbq.append("  WHERE lin_cdgo = " + f.getLin_cdgo());
          sbq.append("    AND ref_cdgo = " + f.getRef_cdgo());
          sbq.append("    AND cab_cdgo = " + f.getCab_cdgo());
          sbq.append("    AND cor_cdgo = " + f.getCor_cdgo());
          sbq.append("    AND fct_mix_produto(rc.lin_cdgo, rc.ref_cdgo) = 'M' ");
          sbq.append("    AND fct_mix_cabedal(rc.lin_cdgo,rc.ref_cdgo,rc.cab_cdgo) = 'M' ");
          sbq.append("    AND fct_mix_cor(rc.lin_cdgo, rc.ref_cdgo, rc.cab_cdgo, rc.cor_cdgo) = 'M' ");
          String mix = query.retorna(sbq.toString());
          if (mix.equalsIgnoreCase("M")) {
            throw new Exception("Não é possível solicitar combinações especiais tipo FORA MIX para produtos que estejam no MIX!");
          }
        }
      }

      sb.append("  SELECT 1 ");
      sb.append("  FROM dual ");
      sb.append("  WHERE EXISTS ");
      sb.append("  (SELECT * ");
      sb.append("  FROM ped p ");
      sb.append("  WHERE p.ped_nmro = " +f.getPedido());
      sb.append("  AND p.rep_cdgo = " +f.getRep_cdgo());
      sb.append("  AND p.ped_stat NOT IN ('F', 'C', 'L') ");
      sb.append("  AND EXTRACT(YEAR from p.ped_dadg) = EXTRACT(YEAR from sysdate)) ");

      if (sb.toString().equalsIgnoreCase("")) {
        throw new Exception("Para o numero do pedido ser valido ele deve ser deste ano, o representante deve ser o "+f.getRep_cdgo() + " e seu status não pode ser 'F','C', 'L' ");
      }
    }
    catch (Exception e) {
      throw e;
    } finally {
    }
  }

  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      SolicitacaoCombinacaoEspecial_aActionForm f = (SolicitacaoCombinacaoEspecial_aActionForm) form;


      actionForward = new ActionForward("/com/SolicitacaoCombinacaoEspecialForm.do?select2_action=",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ref_combinacao_especial", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    try {
      SolicitacaoCombinacaoEspecial_aActionForm f = (SolicitacaoCombinacaoEspecial_aActionForm) form;
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ref_combinacao_especial", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_relatorio_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      SolicitacaoCombinacaoEspecial_aActionForm f = (SolicitacaoCombinacaoEspecial_aActionForm) form;
      //--------------------------------------------------------------------------
      util.file.GeraPDF g = new util.file.GeraPDF(request);
      g.setRelatorio("SolicitacaoEspecial.jasper");
      g.setParametro("P_ID_SOLICITACAO", Integer.parseInt(f.getId_solicitacao()));
      g.gerar();
      request.setAttribute("abre_automaticamente","N");
      //--------------------------------------------------------------------------
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      e.printStackTrace(System.err);
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ref_combinacao_especial", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  public ActionForward perform_duplicar_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      SolicitacaoCombinacaoEspecial_aActionForm f = (SolicitacaoCombinacaoEspecial_aActionForm) form;
      duplicar_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ref_combinacao_especial", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void duplicar_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    SolicitacaoCombinacaoEspecial_aActionForm f = (SolicitacaoCombinacaoEspecial_aActionForm) form;
    acesso.Sessao sessao = new acesso.Sessao(session);
    util.consultas.Query query = new util.consultas.Query();
    util.consultas.DiasUteis diasUteis = new util.consultas.DiasUteis();
    String dataAtual = query.retorna("SELECT to_char(SYSDATE,'dd/mm/yyyy hh24:mi:ss') FROM dual");
    String dataAtual5dias = diasUteis.buscar(5);
    String dataAtual10dias = diasUteis.buscar(10);
    String dataAtual24horas = query.retorna("SELECT to_char(SYSDATE+1,'dd/mm/yyyy hh24:mi:ss') FROM dual");

    Ref_combinacao_especial table = new Ref_combinacao_especial();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"id_solicitacao","=", com.egen.util.text.FormatNumber.toInteger(f.getId_solicitacao())}};
    Vector res_Ref_combinacao_especial = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Ref_combinacao_especial",res_Ref_combinacao_especial);
    if (res_Ref_combinacao_especial != null && res_Ref_combinacao_especial.size() > 0) {
      Ref_combinacao_especial r = (Ref_combinacao_especial) res_Ref_combinacao_especial.elementAt(0);
      f.setId_solicitacao((r.getId_solicitacao() != null) ? r.getId_solicitacao() + "":"");
      f.setData_solicitacao(com.egen.util.text.FormatDate.format((com.egen.util.text.FormatDate.parseDate(dataAtual , "dd/MM/yyyy HH:mm:ss")), "dd/MM/yyyy HH:mm:ss"));
      f.setUsuario_solicitacao(sessao.getUsuario());
      f.setCodigo_marca((r.getCodigo_marca() != null) ? r.getCodigo_marca() + "":"");
      f.setRep_cdgo((r.getRep_cdgo() != null) ? r.getRep_cdgo() + "":"");

      f.setTipo_solicitacao((r.getTipo_solicitacao_comb_especial() != null) ? r.getTipo_solicitacao_comb_especial() + "":"");
      f.setSubtipo_solicitacao_comb_espec((r.getSubtipo_solicitacao_comb_espec() != null) ? r.getSubtipo_solicitacao_comb_espec() + "":"");
      f.setLin_cdgo((r.getLin_cdgo() != null) ? r.getLin_cdgo() + "":"");
      f.setRef_cdgo((r.getRef_cdgo() != null) ? r.getRef_cdgo() + "":"");
      f.setCab_cdgo((r.getCab_cdgo() != null) ? r.getCab_cdgo() + "":"");
      f.setCor_cdgo((r.getCor_cdgo() != null) ? r.getCor_cdgo() + "":"");
      f.setObservacao((r.getObservacao() != null) ? r.getObservacao() + "":"");
      f.setMaterial_cor1((r.getMaterial_cor1() != null) ? r.getMaterial_cor1() + "":"");
      f.setMaterial_cor2((r.getMaterial_cor2() != null) ? r.getMaterial_cor2() + "":"");
      f.setMaterial_cor3((r.getMaterial_cor3() != null) ? r.getMaterial_cor3() + "":"");
      f.setMaterial_cor4((r.getMaterial_cor4() != null) ? r.getMaterial_cor4() + "":"");
      f.setBiqueira_debrum((r.getBiqueira_debrum() != null) ? r.getBiqueira_debrum() + "":"");
      f.setCapa_palmilha((r.getCapa_palmilha() != null) ? r.getCapa_palmilha() + "":"");
      f.setCacharel((r.getCacharel() != null) ? r.getCacharel() + "":"");
      f.setForro((r.getForro() != null) ? r.getForro() + "":"");
      f.setMetais((r.getMetais() != null) ? r.getMetais() + "":"");
      f.setTaloneira((r.getTaloneira() != null) ? r.getTaloneira() + "":"");
      f.setSalto((r.getSalto() != null) ? r.getSalto() + "":"");
      f.setEnfeite((r.getEnfeite() != null) ? r.getEnfeite() + "":"");
      f.setCarimbo_etiqueta((r.getCarimbo_etiqueta() != null) ? r.getCarimbo_etiqueta() + "":"");
      f.setCli_cdgo((r.getCli_cdgo() != null) ? r.getCli_cdgo() + "":"");
      f.setGre_grupo((r.getGre_grupo() != null) ? r.getGre_grupo() + "":"");
      f.setPrs_negociacao((r.getPrs_negociacao() != null) ? com.egen.util.text.FormatNumber.format(r.getPrs_negociacao(), "0") : "");
      f.setPares_linha((r.getPares_linha() != null) ? com.egen.util.text.FormatNumber.format(r.getPares_linha(), "0") : "");
      f.setPares_alteracao((r.getPares_alteracao() != null) ? com.egen.util.text.FormatNumber.format(r.getPares_alteracao(), "0") : "");
      f.setPreco_liguido((r.getPreco_liguido() != null) ? com.egen.util.text.FormatNumber.format(r.getPreco_liguido(), "##,##0.00") : "");
      f.setValor_fabricacao((r.getValor_fabricacao() != null) ? com.egen.util.text.FormatNumber.format(r.getValor_fabricacao(), "##,##0.000") : "");
      f.setLl_alteracao_solicitada((r.getLl_alteracao_solicitada() != null) ? com.egen.util.text.FormatNumber.format(r.getLl_alteracao_solicitada(), "##,##0.00") : "");
      f.setSituacao_solicitacao("P");
      f.setData_aceite(com.egen.util.text.FormatDate.format(r.getData_aceite(), "dd/MM/yyyy HH:mm:ss"));
      f.setUsuario_aceite((r.getUsuario_aceite() != null) ? r.getUsuario_aceite() + "":"");
      f.setCepa((r.getCepa() != null) ? r.getCepa() + "" : "");
      f.setSola((r.getSola() != null) ? r.getSola() + "" : "");
      f.setAtacador((r.getAtacador() != null) ? r.getAtacador() + "":"");
      f.setPedido((r.getPed_nmro() != null) ? r.getPed_nmro() + "":"");
      f.setItem((r.getIte_seqn() != null) ? r.getIte_seqn() + "":"");
      //--- Select Imagem ---
      Ref_combinacao_especial_img table_img = new Ref_combinacao_especial_img();
      String[][] select_img = null;
      Object[][] where_img = {{"id_solicitacao","=", com.egen.util.text.FormatNumber.toInteger(f.getId_solicitacao())}};
      Vector res_Ref_combinacao_especial_img = j.select(table_img, select_img, where_img, null, null, null);
      session.setAttribute("res_Ref_combinacao_especial_img",res_Ref_combinacao_especial_img);
      if (res_Ref_combinacao_especial_img != null && res_Ref_combinacao_especial_img.size() > 0) {
        Ref_combinacao_especial_img r_img = (Ref_combinacao_especial_img) res_Ref_combinacao_especial_img.elementAt(0);
        f.setImagem_produto((r_img.getImagem() != null) ? r_img.getImagem() + "":"");
      }

    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ref_combinacao_especial", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }

    //--- Select Grade ---
    Ref_comb_especial_grade table_grade = new Ref_comb_especial_grade();
    String[][] select1 = null;
    Object[][] where1 = { {"id_solicitacao","=", com.egen.util.text.FormatNumber.toInteger(f.getId_solicitacao())}};
    Vector res_Ref_comb_especial_grade = j.select(table_grade, select1, where1, null, null, null);
    java.util.Vector v = new java.util.Vector();
    int i_bl_report_Ref_comb_especial_grade = 0;
    while (i_bl_report_Ref_comb_especial_grade < res_Ref_comb_especial_grade.size()) {
      portalbr.dbobj.table.Ref_comb_especial_grade t_ref_comb_especial_grade = (portalbr.dbobj.table.Ref_comb_especial_grade) res_Ref_comb_especial_grade.elementAt(i_bl_report_Ref_comb_especial_grade);
      v.add(t_ref_comb_especial_grade.getNumeracao() + "#"+t_ref_comb_especial_grade.getQtp_pars());
      i_bl_report_Ref_comb_especial_grade++;
    }
    session.setAttribute("v_numeracao", v);
    //--------------------


    //--- Duplica Solicitação ---
    table = new Ref_combinacao_especial();
    f.setId_solicitacao(query.retorna("SELECT brio.seq_ref_comb_espec.nextval FROM dual"));
    request.setAttribute("solicitacao", f.getId_solicitacao());
    table.setId_solicitacao(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getId_solicitacao()));
    table.setData_solicitacao(com.egen.util.text.FormatDate.parseTimestamp(f.getData_solicitacao(), "dd/MM/yyyy HH:mm:ss"));
    //table.setUsuario_solicitacao(f.getUsuario_solicitacao());
    table.setUsuario_solicitacao(sessao.getUsuario());
    table.setCodigo_marca(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCodigo_marca()));
    table.setTipo_solicitacao_comb_especial(f.getTipo_solicitacao());
    table.setSubtipo_solicitacao_comb_espec(f.getSubtipo_solicitacao_comb_espec());
    table.setLin_cdgo(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getLin_cdgo()));
    table.setRef_cdgo(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getRef_cdgo()));
    table.setCab_cdgo(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCab_cdgo()));
    table.setCor_cdgo(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCor_cdgo()));
    table.setObservacao(f.getObservacao());
    table.setMaterial_cor1(f.getMaterial_cor1());
    table.setMaterial_cor2(f.getMaterial_cor2());
    table.setMaterial_cor3(f.getMaterial_cor3());
    table.setMaterial_cor4(f.getMaterial_cor4());
    table.setBiqueira_debrum(f.getBiqueira_debrum());
    table.setCapa_palmilha(f.getCapa_palmilha());
    table.setCacharel(f.getCacharel());
    table.setForro(f.getForro());
    table.setMetais(f.getMetais());
    table.setTaloneira(f.getTaloneira());
    table.setSalto(f.getSalto());
    table.setRep_cdgo(f.getRep_cdgo());
    table.setEnfeite(f.getEnfeite());
    table.setCarimbo_etiqueta(f.getCarimbo_etiqueta());
    table.setCli_cdgo(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCli_cdgo()));
    table.setGre_grupo(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getGre_grupo()));
    table.setPrs_negociacao(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getPrs_negociacao()));
    table.setPares_linha(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getPares_linha()));
    table.setPares_alteracao(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getPares_alteracao()));
    table.setPreco_liguido(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getPreco_liguido()));
    table.setValor_fabricacao(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getValor_fabricacao()));
    table.setLl_alteracao_solicitada(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getLl_alteracao_solicitada()));
    table.setSituacao_solicitacao("P");
    table.setData_aceite(com.egen.util.text.FormatDate.parseDate(f.getData_aceite(), "dd/MM/yyyy HH:mm:ss"));
    table.setUsuario_aceite(f.getUsuario_aceite());
    table.setCepa(f.getCepa());
    table.setSola(f.getSola());
    table.setPed_nmro(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getPedido()));
    table.setIte_seqn(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getItem()));
    table.setAtacador(f.getAtacador());
    j.insert(table);

    if (f.getTipo_solicitacao().equals("1")) {
      //--- Insere Grade ---
      Ref_comb_especial_grade t_grade = new Ref_comb_especial_grade();
      for (Object a:
          ((Vector) session.getAttribute("v_numeracao")).toArray()) {
        String[] s = ((String) a).split("#");
        Object[][] name_value = { {"id_solicitacao",com.egen.util.text.FormatNumber.toInteger(f.getId_solicitacao())}, {"numeracao", s[0]}, {"qtp_pars", Integer.parseInt(s[1])} };
        j.insert(t_grade, name_value);
      }
      session.removeAttribute("v_numeracao");
    }


    table_grade = new Ref_comb_especial_grade();
    String[][] select2 = null;
    Object[][] where2 = { {"id_solicitacao","=", com.egen.util.text.FormatNumber.toInteger(f.getId_solicitacao())}};
    Vector res_Ref_comb_especial_grade2 = j.select(table_grade, select2, where2, null, null, null);
    java.util.Vector v2 = new java.util.Vector();
    int i_bl_report_Ref_comb_especial_grade2 = 0;
    while (i_bl_report_Ref_comb_especial_grade2 < res_Ref_comb_especial_grade2.size()) {
      portalbr.dbobj.table.Ref_comb_especial_grade t_ref_comb_especial_grade2 = (portalbr.dbobj.table.Ref_comb_especial_grade) res_Ref_comb_especial_grade2.elementAt(i_bl_report_Ref_comb_especial_grade2);
      v2.add(t_ref_comb_especial_grade2.getNumeracao() + "#"+t_ref_comb_especial_grade2.getQtp_pars());
      i_bl_report_Ref_comb_especial_grade2++;
    }
    session.setAttribute("v_numeracao", v2);
    //--------------------

    session.setAttribute(mapping.getName(), form);
  }
  public ActionForward perform_delete_grade_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      SolicitacaoCombinacaoEspecial_aActionForm f = (SolicitacaoCombinacaoEspecial_aActionForm) form;
      session.removeAttribute("v_numeracao");
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ref_combinacao_especial", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
