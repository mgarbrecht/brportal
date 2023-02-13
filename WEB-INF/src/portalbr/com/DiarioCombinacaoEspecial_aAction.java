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
 * Creation Date 08/06/2015 15:55:50
 * Last Modify Date 19/06/2015 10:02:42
 */

public class DiarioCombinacaoEspecial_aAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DiarioCombinacaoEspecial_aActionForm f = (DiarioCombinacaoEspecial_aActionForm) form;
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
    util.consultas.Query query = new util.consultas.Query();
    DiarioCombinacaoEspecial_aActionForm f = (DiarioCombinacaoEspecial_aActionForm) form;
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
      f.setUsuario_solicitacao((r.getUsuario_solicitacao() != null) ? r.getUsuario_solicitacao() + "":"");
      f.setCodigo_marca((r.getCodigo_marca() != null) ? r.getCodigo_marca() + "":"");
      f.setRep_cdgo((r.getRep_cdgo() != null) ? r.getRep_cdgo() + "":"");
      f.setTipo_solicitacao((r.getTipo_solicitacao_comb_especial() != null) ? r.getTipo_solicitacao_comb_especial() + "":"");

      f.setLin_cdgo((r.getLin_cdgo() != null) ? r.getLin_cdgo() + "":"");
      f.setRef_cdgo((r.getRef_cdgo() != null) ? r.getRef_cdgo() + "":"");
      f.setCab_cdgo((r.getCab_cdgo() != null) ? r.getCab_cdgo() + "":"");
      f.setCor_cdgo((r.getCor_cdgo() != null) ? r.getCor_cdgo() + "":"");
      f.setDescricao((r.getDescricao() != null) ? r.getDescricao() + "":"");
      f.setObservacao((r.getObservacao() != null) ? r.getObservacao() + "":"");
      f.setMaterial_cor1((r.getMaterial_cor1() != null) ? r.getMaterial_cor1() + "":"");
      f.setMaterial_cor2((r.getMaterial_cor2() != null) ? r.getMaterial_cor2() + "":"");
      f.setMaterial_cor3((r.getMaterial_cor3() != null) ? r.getMaterial_cor3() + "":"");
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
      f.setValor_fabricacao((r.getValor_fabricacao() != null) ? com.egen.util.text.FormatNumber.format(r.getValor_fabricacao(), "##,##0.00") : "");
      f.setLl_alteracao_solicitada((r.getLl_alteracao_solicitada() != null) ? com.egen.util.text.FormatNumber.format(r.getLl_alteracao_solicitada(), "##,##0.00") : "");
      f.setData_aceite(com.egen.util.text.FormatDate.format(r.getData_aceite(), "dd/MM/yyyy HH:mm:ss"));
      f.setUsuario_aceite((r.getUsuario_aceite() != null) ? r.getUsuario_aceite() + "":"");
      f.setValor_pdv((r.getValor_pdv() != null) ? com.egen.util.text.FormatNumber.format(r.getValor_pdv(), "##,##0.00") : "");
      f.setLl_0((r.getLl_0() != null) ? com.egen.util.text.FormatNumber.format(r.getLl_0(), "##,##0.00") : "");
      f.setLl_1((r.getLl_1() != null) ? com.egen.util.text.FormatNumber.format(r.getLl_1(), "##,##0.00") : "");
      f.setLl_2((r.getLl_2() != null) ? com.egen.util.text.FormatNumber.format(r.getLl_2(), "##,##0.00") : "");
      f.setLl_3((r.getLl_3() != null) ? com.egen.util.text.FormatNumber.format(r.getLl_3(), "##,##0.00") : "");
      f.setPreco_vendor((r.getPreco_vendor() != null) ? com.egen.util.text.FormatNumber.format(r.getPreco_vendor(), "##,##0.00") : "");
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

    session.setAttribute(mapping.getName(), form);
  }
  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DiarioCombinacaoEspecial_aActionForm f = (DiarioCombinacaoEspecial_aActionForm) form;
      try {
        tg_update_action_1(mapping, form, request, response);
        update_action(j, mapping, form, request, response);
        tg_update_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = new ActionForward("/com/DiarioCombinacaoEspecialForm.do?select2_action=",true);
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
    DiarioCombinacaoEspecial_aActionForm f = (DiarioCombinacaoEspecial_aActionForm) form;
    util.consultas.Query query = new util.consultas.Query();
    util.consultas.Parametros parametros = new util.consultas.Parametros();

    /*
    if (f.getArquivo() != null && f.getArquivo().toString() != null && f.getArquivo().toString().length() > 0) {
       String realPath2bl_form = parametros.retornaParametro("diretorio_arquivos_diario_combinacao_especial");
       realPath2bl_form = realPath2bl_form + java.io.File.separator;
       org.apache.struts.upload.FormFile inputfile2bl_form = f.getArquivo();
       if(inputfile2bl_form.getFileSize() > 512000){
          throw new Exception("O arquivo de imagem ultrapassou o tamanho máximo de 500kb!");
       }
  }
    */


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
    table.setDescricao(f.getDescricao());
    if (f.getDescricao() != null) {
      sets.addElement("descricao");
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
    table.setValor_pdv(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getValor_pdv()));
    if (f.getValor_pdv() != null) {
      sets.addElement("valor_pdv");
    }
    table.setLl_0(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getLl_0()));
    if (f.getLl_0() != null) {
      sets.addElement("ll_0");
    }
    table.setLl_1(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getLl_1()));
    if (f.getLl_1() != null) {
      sets.addElement("ll_1");
    }
    table.setLl_2(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getLl_2()));
    if (f.getLl_2() != null) {
      sets.addElement("ll_2");
    }
    table.setLl_3(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getLl_3()));
    if (f.getLl_3() != null) {
      sets.addElement("ll_3");
    }
    table.setPreco_vendor(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getPreco_vendor()));
    if (f.getPreco_vendor() != null) {
      sets.addElement("preco_vendor");
    }
    table.setLl_alteracao_solicitada(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getLl_alteracao_solicitada()));
    if (f.getLl_alteracao_solicitada() != null) {
      sets.addElement("ll_alteracao_solicitada");
    }
    table.setData_aceite(com.egen.util.text.FormatDate.parseDate(f.getData_aceite(), "dd/MM/yyyy HH:mm:ss"));
    if (f.getData_aceite() != null) {
      sets.addElement("data_aceite");
    }
    table.setUsuario_aceite(f.getUsuario_aceite());
    if (f.getUsuario_aceite() != null) {
      sets.addElement("usuario_aceite");
    }

    if (sets != null && sets.size() > 0) {
      String[] set = new String[sets.size()];
      for (int i = 0; i < sets.size(); i++) {
        set[i] = (String) sets.elementAt(i);
      }

      int updated = j.update(table, set);
      if (updated == 0) {
        ActionErrors errors = new ActionErrors();
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ref_combinacao_especial", new ActionMessage("warn.norowsupdated",": " + updated));
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      } else {
        Vector res_Ref_combinacao_especial = (Vector) session.getAttribute("res_Ref_combinacao_especial");
        if (res_Ref_combinacao_especial != null) {
          res_Ref_combinacao_especial.setElementAt(table, 0);
          Ref_combinacao_especial r = (Ref_combinacao_especial) res_Ref_combinacao_especial.elementAt(0);
          f.setId_solicitacao((r.getId_solicitacao() != null) ? r.getId_solicitacao() + "":"");
          f.setData_solicitacao(com.egen.util.text.FormatDate.format(r.getData_solicitacao(), "dd/MM/yyyy"));
          f.setUsuario_solicitacao((r.getUsuario_solicitacao() != null) ? r.getUsuario_solicitacao() + "":"");
          f.setCodigo_marca((r.getCodigo_marca() != null) ? r.getCodigo_marca() + "":"");
          f.setTipo_solicitacao((r.getTipo_solicitacao_comb_especial() != null) ? r.getTipo_solicitacao_comb_especial() + "":"");
          f.setLin_cdgo((r.getLin_cdgo() != null) ? r.getLin_cdgo() + "":"");
          f.setRef_cdgo((r.getRef_cdgo() != null) ? r.getRef_cdgo() + "":"");
          f.setCab_cdgo((r.getCab_cdgo() != null) ? r.getCab_cdgo() + "":"");
          f.setCor_cdgo((r.getCor_cdgo() != null) ? r.getCor_cdgo() + "":"");
          f.setDescricao((r.getDescricao() != null) ? r.getDescricao() + "":"");
          f.setObservacao((r.getObservacao() != null) ? r.getObservacao() + "":"");
          f.setMaterial_cor1((r.getMaterial_cor1() != null) ? r.getMaterial_cor1() + "":"");
          f.setMaterial_cor2((r.getMaterial_cor2() != null) ? r.getMaterial_cor2() + "":"");
          f.setMaterial_cor3((r.getMaterial_cor3() != null) ? r.getMaterial_cor3() + "":"");
          f.setBiqueira_debrum((r.getBiqueira_debrum() != null) ? r.getBiqueira_debrum() + "":"");
          f.setCapa_palmilha((r.getCapa_palmilha() != null) ? r.getCapa_palmilha() + "":"");
          f.setCacharel((r.getCacharel() != null) ? r.getCacharel() + "":"");
          f.setForro((r.getForro() != null) ? r.getForro() + "":"");
          f.setTipo_solicitacao((r.getTipo_solicitacao_comb_especial() != null) ? r.getTipo_solicitacao_comb_especial() + "":"");
          f.setMetais((r.getMetais() != null) ? r.getMetais() + "":"");
          f.setTaloneira((r.getTaloneira() != null) ? r.getTaloneira() + "":"");
          f.setSalto((r.getSalto() != null) ? r.getSalto() + "":"");
          f.setEnfeite((r.getEnfeite() != null) ? r.getEnfeite() + "":"");
          f.setCarimbo_etiqueta((r.getCarimbo_etiqueta() != null) ? r.getCarimbo_etiqueta() + "":"");
          f.setGre_grupo((r.getGre_grupo() != null) ? r.getGre_grupo() + "":"");
          f.setCli_cdgo((r.getCli_cdgo() != null) ? r.getCli_cdgo() + "":"");
          f.setRep_cdgo((r.getRep_cdgo() != null) ? r.getRep_cdgo() + "":"");
          f.setPrs_negociacao((r.getPrs_negociacao() != null) ? com.egen.util.text.FormatNumber.format(r.getPrs_negociacao(), "0") : "");
          f.setPares_linha((r.getPares_linha() != null) ? com.egen.util.text.FormatNumber.format(r.getPares_linha(), "0") : "");
          f.setPares_alteracao((r.getPares_alteracao() != null) ? com.egen.util.text.FormatNumber.format(r.getPares_alteracao(), "0") : "");
          f.setPreco_liguido((r.getPreco_liguido() != null) ? com.egen.util.text.FormatNumber.format(r.getPreco_liguido(), "##,##0.00") : "");
          f.setValor_fabricacao((r.getValor_fabricacao() != null) ? com.egen.util.text.FormatNumber.format(r.getValor_fabricacao(), "##,##0.00") : "");
          f.setLl_alteracao_solicitada((r.getLl_alteracao_solicitada() != null) ? com.egen.util.text.FormatNumber.format(r.getLl_alteracao_solicitada(), "##,##0.00") : "");
          f.setData_aceite(com.egen.util.text.FormatDate.format(r.getData_aceite(), "dd/MM/yyyy HH:mm:ss"));
          f.setUsuario_aceite((r.getUsuario_aceite() != null) ? r.getUsuario_aceite() + "":"");
          f.setValor_pdv((r.getValor_pdv() != null) ? com.egen.util.text.FormatNumber.format(r.getValor_pdv(), "##,##0.00") : "");
          f.setLl_0((r.getLl_0() != null) ? com.egen.util.text.FormatNumber.format(r.getLl_0(), "##,##0.00") : "");
          f.setLl_1((r.getLl_1() != null) ? com.egen.util.text.FormatNumber.format(r.getLl_1(), "##,##0.00") : "");
          f.setLl_2((r.getLl_2() != null) ? com.egen.util.text.FormatNumber.format(r.getLl_2(), "##,##0.00") : "");
          f.setLl_3((r.getLl_3() != null) ? com.egen.util.text.FormatNumber.format(r.getLl_3(), "##,##0.00") : "");
          f.setPreco_vendor((r.getPreco_vendor() != null) ? com.egen.util.text.FormatNumber.format(r.getPreco_vendor(), "##,##0.00") : "");
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
      DiarioCombinacaoEspecial_aActionForm f = (DiarioCombinacaoEspecial_aActionForm) form;
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    } finally {
    }
  }

  public ActionForward perform_delete_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DiarioCombinacaoEspecial_aActionForm f = (DiarioCombinacaoEspecial_aActionForm) form;
      try {
        delete_action(j, mapping, form, request, response);
        tg_delete_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = new ActionForward("/com/DiarioCombinacaoEspecialForm.do?select2_action=",true);
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
  private void delete_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    DiarioCombinacaoEspecial_aActionForm f = (DiarioCombinacaoEspecial_aActionForm) form;
    util.consultas.Query query = new util.consultas.Query();
    query.execute(j, "DELETE brio.ref_comb_especial_grade where id_solicitacao = "+ f.getId_solicitacao());
    session.removeAttribute("v_numeracao");
    util.consultas.Parametros parametros = new util.consultas.Parametros();

    Ref_combinacao_especial table = new Ref_combinacao_especial();
    table.setId_solicitacao(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getId_solicitacao()));
    table.setData_solicitacao(com.egen.util.text.FormatDate.parseTimestamp(f.getData_solicitacao(), "dd/MM/yyyy HH:mm:ss"));
    table.setUsuario_solicitacao(f.getUsuario_solicitacao());
    table.setTipo_solicitacao_comb_especial(f.getTipo_solicitacao());
    table.setCodigo_marca(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCodigo_marca()));
    table.setLin_cdgo(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getLin_cdgo()));
    table.setRef_cdgo(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getRef_cdgo()));
    table.setCab_cdgo(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCab_cdgo()));
    table.setCor_cdgo(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCor_cdgo()));
    table.setDescricao(f.getDescricao());
    table.setObservacao(f.getObservacao());
    table.setMaterial_cor1(f.getMaterial_cor1());
    table.setMaterial_cor2(f.getMaterial_cor2());
    table.setMaterial_cor3(f.getMaterial_cor3());
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
    table.setData_aceite(com.egen.util.text.FormatDate.parseDate(f.getData_aceite(), "dd/MM/yyyy HH:mm:ss"));
    table.setUsuario_aceite(f.getUsuario_aceite());
    table.setValor_pdv(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getValor_pdv()));
    table.setLl_0(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getLl_0()));
    table.setLl_1(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getLl_1()));
    table.setLl_2(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getLl_2()));
    table.setLl_3(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getLl_3()));
    table.setPreco_vendor(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getPreco_vendor()));

    //--- Exclui Imagem ---
    portalbr.dbobj.table.Ref_combinacao_especial_img t_ref_combinacao_especial_img = new portalbr.dbobj.table.Ref_combinacao_especial_img();
    String[][] select = null;
    Object[][] where = null;
    where = new Object[][]{{"id_solicitacao","=", f.getId_solicitacao()}};
    Vector res_Ref_combinacao_especial_img = j.select(t_ref_combinacao_especial_img, select, where, null, null, null);
    int countImg = 0;
    if (res_Ref_combinacao_especial_img != null && res_Ref_combinacao_especial_img.size() > 0) {
      while (countImg < res_Ref_combinacao_especial_img.size()) {
        portalbr.dbobj.table.Ref_combinacao_especial_img t_img = (portalbr.dbobj.table.Ref_combinacao_especial_img) res_Ref_combinacao_especial_img.elementAt(countImg++);
        java.io.File file = new java.io.File(parametros.retornaParametro("diretorio_arquivos_diario_combinacao_especial") + t_img.getImagem());
        file.delete();
      }
    }
    query.execute(j, "DELETE brio.ref_combinacao_especial_img WHERE id_solicitacao = "+ f.getId_solicitacao());
    j.delete(table);

    //---------------------
    Vector res_Ref_combinacao_especial = (Vector) session.getAttribute("res_Ref_combinacao_especial");
    if (res_Ref_combinacao_especial != null && res_Ref_combinacao_especial.size() > 0) {
      res_Ref_combinacao_especial.removeElementAt(0);
      if (res_Ref_combinacao_especial.size() > 0) {
        Ref_combinacao_especial r = (Ref_combinacao_especial) res_Ref_combinacao_especial.elementAt(0);
        f.setId_solicitacao((r.getId_solicitacao() != null) ? r.getId_solicitacao() + "":"");
        f.setData_solicitacao(com.egen.util.text.FormatDate.format(r.getData_solicitacao(), "dd/MM/yyyy HH:mm:ss"));
        f.setUsuario_solicitacao((r.getUsuario_solicitacao() != null) ? r.getUsuario_solicitacao() + "":"");
        f.setCodigo_marca((r.getCodigo_marca() != null) ? r.getCodigo_marca() + "":"");
        f.setTipo_solicitacao((r.getTipo_solicitacao_comb_especial() != null) ? r.getTipo_solicitacao_comb_especial() + "":"");
        f.setLin_cdgo((r.getLin_cdgo() != null) ? r.getLin_cdgo() + "":"");
        f.setRef_cdgo((r.getRef_cdgo() != null) ? r.getRef_cdgo() + "":"");
        f.setCab_cdgo((r.getCab_cdgo() != null) ? r.getCab_cdgo() + "":"");
        f.setCor_cdgo((r.getCor_cdgo() != null) ? r.getCor_cdgo() + "":"");
        f.setDescricao((r.getDescricao() != null) ? r.getDescricao() + "":"");
        f.setObservacao((r.getObservacao() != null) ? r.getObservacao() + "":"");
        f.setMaterial_cor1((r.getMaterial_cor1() != null) ? r.getMaterial_cor1() + "":"");
        f.setMaterial_cor2((r.getMaterial_cor2() != null) ? r.getMaterial_cor2() + "":"");
        f.setMaterial_cor3((r.getMaterial_cor3() != null) ? r.getMaterial_cor3() + "":"");
        f.setBiqueira_debrum((r.getBiqueira_debrum() != null) ? r.getBiqueira_debrum() + "":"");
        f.setCapa_palmilha((r.getCapa_palmilha() != null) ? r.getCapa_palmilha() + "":"");
        f.setCacharel((r.getCacharel() != null) ? r.getCacharel() + "":"");
        f.setForro((r.getForro() != null) ? r.getForro() + "":"");
        f.setRep_cdgo((r.getRep_cdgo() != null) ? r.getRep_cdgo() + "":"");
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
        f.setValor_fabricacao((r.getValor_fabricacao() != null) ? com.egen.util.text.FormatNumber.format(r.getValor_fabricacao(), "##,##0.00") : "");
        f.setLl_alteracao_solicitada((r.getLl_alteracao_solicitada() != null) ? com.egen.util.text.FormatNumber.format(r.getLl_alteracao_solicitada(), "##,##0.00") : "");
        f.setData_aceite(com.egen.util.text.FormatDate.format(r.getData_aceite(), "dd/MM/yyyy HH:mm:ss"));
        f.setUsuario_aceite((r.getUsuario_aceite() != null) ? r.getUsuario_aceite() + "":"");
        f.setValor_pdv((r.getValor_pdv() != null) ? com.egen.util.text.FormatNumber.format(r.getValor_pdv(), "##,##0.00") : "");
        f.setLl_0((r.getLl_0() != null) ? com.egen.util.text.FormatNumber.format(r.getLl_0(), "##,##0.00") : "");
        f.setLl_1((r.getLl_1() != null) ? com.egen.util.text.FormatNumber.format(r.getLl_1(), "##,##0.00") : "");
        f.setLl_2((r.getLl_2() != null) ? com.egen.util.text.FormatNumber.format(r.getLl_2(), "##,##0.00") : "");
        f.setLl_3((r.getLl_3() != null) ? com.egen.util.text.FormatNumber.format(r.getLl_3(), "##,##0.00") : "");
        f.setPreco_vendor((r.getPreco_vendor() != null) ? com.egen.util.text.FormatNumber.format(r.getPreco_vendor(), "##,##0.00") : "");
      } else {
        f.reset(mapping, request);
      }
    } else {
      f.reset(mapping, request);
    }
    session.setAttribute(mapping.getName(), form);
  }
  private void tg_delete_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ref_combinacao_especial", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DiarioCombinacaoEspecial_aActionForm f = (DiarioCombinacaoEspecial_aActionForm) form;


      actionForward = new ActionForward("/com/DiarioCombinacaoEspecialForm.do?select2_action=",true);
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
      DiarioCombinacaoEspecial_aActionForm f = (DiarioCombinacaoEspecial_aActionForm) form;
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
      DiarioCombinacaoEspecial_aActionForm f = (DiarioCombinacaoEspecial_aActionForm) form;
      //--------------------------------------------------------------------------
      util.file.GeraPDF g = new util.file.GeraPDF(request);
      g.setRelatorio("DiarioCombinacaoEspecial.jasper");
      g.setParametro("P_ID_SOLICITACAO", Integer.parseInt(f.getId_solicitacao()));
      g.gerar();
      request.setAttribute("abre_automaticamente","N");
      //--------------------------------------------------------------------------
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
  public ActionForward perform_duplicar_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DiarioCombinacaoEspecial_aActionForm f = (DiarioCombinacaoEspecial_aActionForm) form;
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
    DiarioCombinacaoEspecial_aActionForm f = (DiarioCombinacaoEspecial_aActionForm) form;
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
      f.setUsuario_solicitacao((r.getUsuario_solicitacao() != null) ? r.getUsuario_solicitacao() + "":"");
      f.setCodigo_marca((r.getCodigo_marca() != null) ? r.getCodigo_marca() + "":"");
      f.setRep_cdgo((r.getRep_cdgo() != null) ? r.getRep_cdgo() + "":"");

      f.setTipo_solicitacao((r.getTipo_solicitacao_comb_especial() != null) ? r.getTipo_solicitacao_comb_especial() + "":"");
      f.setLin_cdgo((r.getLin_cdgo() != null) ? r.getLin_cdgo() + "":"");
      f.setRef_cdgo((r.getRef_cdgo() != null) ? r.getRef_cdgo() + "":"");
      f.setCab_cdgo((r.getCab_cdgo() != null) ? r.getCab_cdgo() + "":"");
      f.setCor_cdgo((r.getCor_cdgo() != null) ? r.getCor_cdgo() + "":"");
      f.setObservacao((r.getObservacao() != null) ? r.getObservacao() + "":"");
      f.setMaterial_cor1((r.getMaterial_cor1() != null) ? r.getMaterial_cor1() + "":"");
      f.setMaterial_cor2((r.getMaterial_cor2() != null) ? r.getMaterial_cor2() + "":"");
      f.setMaterial_cor3((r.getMaterial_cor3() != null) ? r.getMaterial_cor3() + "":"");
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
      f.setValor_fabricacao((r.getValor_fabricacao() != null) ? com.egen.util.text.FormatNumber.format(r.getValor_fabricacao(), "##,##0.00") : "");
      f.setLl_alteracao_solicitada((r.getLl_alteracao_solicitada() != null) ? com.egen.util.text.FormatNumber.format(r.getLl_alteracao_solicitada(), "##,##0.00") : "");
      f.setData_aceite(com.egen.util.text.FormatDate.format(r.getData_aceite(), "dd/MM/yyyy HH:mm:ss"));
      f.setUsuario_aceite((r.getUsuario_aceite() != null) ? r.getUsuario_aceite() + "":"");
      f.setImagem_produto((r.getImagem_produto() != null) ? r.getImagem_produto() + "":"");
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
    table.setUsuario_solicitacao(f.getUsuario_solicitacao());
    table.setCodigo_marca(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCodigo_marca()));
    table.setTipo_solicitacao_comb_especial(f.getTipo_solicitacao());
    table.setLin_cdgo(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getLin_cdgo()));
    table.setRef_cdgo(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getRef_cdgo()));
    table.setCab_cdgo(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCab_cdgo()));
    table.setCor_cdgo(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCor_cdgo()));
    table.setObservacao(f.getObservacao());
    table.setMaterial_cor1(f.getMaterial_cor1());
    table.setMaterial_cor2(f.getMaterial_cor2());
    table.setMaterial_cor3(f.getMaterial_cor3());
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
    table.setData_aceite(com.egen.util.text.FormatDate.parseDate(f.getData_aceite(), "dd/MM/yyyy HH:mm:ss"));
    table.setUsuario_aceite(f.getUsuario_aceite());
    table.setImagem_produto(null);
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
      DiarioCombinacaoEspecial_aActionForm f = (DiarioCombinacaoEspecial_aActionForm) form;
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

  public ActionForward perform_delete_imagem_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DiarioCombinacaoEspecial_aActionForm f = (DiarioCombinacaoEspecial_aActionForm) form;
      util.consultas.Parametros parametros = new util.consultas.Parametros();
      util.consultas.Query query = new util.consultas.Query();
      String arquivo = query.retorna(j, "SELECT imagem FROM brio.ref_combinacao_especial_img WHERE id_imagem = "+ f.getId_imagem() + " AND id_solicitacao = " + f.getId_solicitacao());
      if (!arquivo.equals("")) {
        java.io.File file = new java.io.File(parametros.retornaParametro("diretorio_arquivos_diario_combinacao_especial") + arquivo);
        file.delete();
        query.execute(j, "DELETE brio.ref_combinacao_especial_img WHERE id_imagem = "+ f.getId_imagem() + " AND id_solicitacao = "+ f.getId_solicitacao());
      }



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
        f.setUsuario_solicitacao((r.getUsuario_solicitacao() != null) ? r.getUsuario_solicitacao() + "":"");
        f.setCodigo_marca((r.getCodigo_marca() != null) ? r.getCodigo_marca() + "":"");
        f.setRep_cdgo((r.getRep_cdgo() != null) ? r.getRep_cdgo() + "":"");
        f.setTipo_solicitacao((r.getTipo_solicitacao_comb_especial() != null) ? r.getTipo_solicitacao_comb_especial() + "":"");

        f.setLin_cdgo((r.getLin_cdgo() != null) ? r.getLin_cdgo() + "":"");
        f.setRef_cdgo((r.getRef_cdgo() != null) ? r.getRef_cdgo() + "":"");
        f.setCab_cdgo((r.getCab_cdgo() != null) ? r.getCab_cdgo() + "":"");
        f.setCor_cdgo((r.getCor_cdgo() != null) ? r.getCor_cdgo() + "":"");
        f.setDescricao((r.getDescricao() != null) ? r.getDescricao() + "":"");
        f.setObservacao((r.getObservacao() != null) ? r.getObservacao() + "":"");
        f.setMaterial_cor1((r.getMaterial_cor1() != null) ? r.getMaterial_cor1() + "":"");
        f.setMaterial_cor2((r.getMaterial_cor2() != null) ? r.getMaterial_cor2() + "":"");
        f.setMaterial_cor3((r.getMaterial_cor3() != null) ? r.getMaterial_cor3() + "":"");
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
        f.setValor_fabricacao((r.getValor_fabricacao() != null) ? com.egen.util.text.FormatNumber.format(r.getValor_fabricacao(), "##,##0.00") : "");
        f.setLl_alteracao_solicitada((r.getLl_alteracao_solicitada() != null) ? com.egen.util.text.FormatNumber.format(r.getLl_alteracao_solicitada(), "##,##0.00") : "");
        f.setData_aceite(com.egen.util.text.FormatDate.format(r.getData_aceite(), "dd/MM/yyyy HH:mm:ss"));
        f.setUsuario_aceite((r.getUsuario_aceite() != null) ? r.getUsuario_aceite() + "":"");
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



      actionForward = mapping.findForward("same");
    }
    catch (Exception e) {
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
}
