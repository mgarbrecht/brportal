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
 * Creation Date 21/03/2006 08:52:01
 * Last Modify Date 04/02/2022 11:03:19
 */

public class ImpressaoDuplicatasNV_rAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select1_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ImpressaoDuplicatasNV_rActionForm[]_ge_grid_array = (ImpressaoDuplicatasNV_rActionForm[])_ge_grid.get("bl_form_Jw_t_titulos_lista_lines");
      ImpressaoDuplicatasNV_rActionForm f = _ge_grid_array[0];
      try {
        select1_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_t_titulos_lista", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    ImpressaoDuplicatasNV_rActionForm[]_ge_grid_array = (ImpressaoDuplicatasNV_rActionForm[])_ge_grid.get("bl_form_Jw_t_titulos_lista_lines");
    ImpressaoDuplicatasNV_rActionForm f = _ge_grid_array[0];
    if (f != null) {
      Jw_t_titulos_lista table = new Jw_t_titulos_lista();
      Vector res_Jw_t_titulos_lista = (java.util.Vector) session.getAttribute("res_Jw_t_titulos_lista");
      session.setAttribute("res_Jw_t_titulos_lista",res_Jw_t_titulos_lista);

      if (res_Jw_t_titulos_lista != null && res_Jw_t_titulos_lista.size() > 0) {

        ImpressaoDuplicatasNV_rActionForm[]_ge_grid_array_flex = new ImpressaoDuplicatasNV_rActionForm[res_Jw_t_titulos_lista.size()];
        org.apache.struts.config.ConfigEGenHelper.setFormPropertySize(mapping, "bl_form_Jw_t_titulos_lista_lines", res_Jw_t_titulos_lista.size());
        int _ge_pos = 0;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array_flex.length; _ge_grid_array_index++, _ge_pos++) {
          if (_ge_grid_array_index < _ge_grid_array.length) {
            f = _ge_grid_array[_ge_grid_array_index];
          } else {
            f = new ImpressaoDuplicatasNV_rActionForm();
            ActionServletWrapper actionServletWrapper = form.getServletWrapper();
            org.apache.struts.upload.CommonsMultipartRequestHandler commonsMultipartRequestHandler = new org.apache.struts.upload.CommonsMultipartRequestHandler();
            actionServletWrapper.setServletFor(commonsMultipartRequestHandler);
            f.setServlet(commonsMultipartRequestHandler.getServlet());
          }
          f.reset(mapping, request);
          if (res_Jw_t_titulos_lista.size() > _ge_pos) {
            Jw_t_titulos_lista r = (Jw_t_titulos_lista) res_Jw_t_titulos_lista.elementAt(_ge_pos);
            f.setTit_codigo1((r.getTit_codigo() != null) ? r.getTit_codigo() + "":"");
            f.setTip_codigo1((r.getTip_codigo() != null) ? r.getTip_codigo() + "":"");
            f.setTit_datvenc1(com.egen.util.text.FormatDate.format(r.getTit_datvenc()));
            f.setTit_valor(r.getTit_valor() + "");
            f.setPrt_codigo1((r.getPrt_codigo() != null) ? r.getPrt_codigo() + "":"");
            f.setEmp_empresa2((r.getEmp_empresa() != null) ? r.getEmp_empresa() + "":"");
            f.setFil_filial1((r.getFil_filial() != null) ? r.getFil_filial() + "":"");
          } else {
            f.reset(mapping, request);
          }
          _ge_grid_array_flex[_ge_grid_array_index] = f;
        }
        _ge_grid.set("bl_form_Jw_t_titulos_lista_lines", _ge_grid_array_flex);
      } else {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_t_titulos_lista", new ActionMessage("warn.norowsselected",""));
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      }
      session.setAttribute(mapping.getName(), form);
    }
  }
  public ActionForward perform_back1_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ImpressaoDuplicatasNV_rActionForm[]_ge_grid_array = (ImpressaoDuplicatasNV_rActionForm[])_ge_grid.get("bl_form_Jw_t_titulos_lista_lines");
      ImpressaoDuplicatasNV_rActionForm f = _ge_grid_array[0];


      actionForward = new ActionForward("/adm/ImpressaoDuplicatasNVForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_t_titulos_lista", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ImpressaoDuplicatasNV_rActionForm[]_ge_grid_array = (ImpressaoDuplicatasNV_rActionForm[])_ge_grid.get("bl_form_Jw_t_titulos_lista_lines");
      ImpressaoDuplicatasNV_rActionForm f = _ge_grid_array[0];
      update_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      e.printStackTrace(System.err);
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_t_titulos_lista", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    DynaActionForm _ge_grid = (DynaActionForm) form;
    acesso.Sessao sessao = new acesso.Sessao(session);
    ImpressaoDuplicatasNV_rActionForm[]_ge_grid_array = (ImpressaoDuplicatasNV_rActionForm[])_ge_grid.get("bl_form_Jw_t_titulos_lista_lines");
    ImpressaoDuplicatasNV_rActionForm f = _ge_grid_array[0];
    StringBuilder sbParametros = new StringBuilder();
    String portador = null;
    util.boleto.GeracaoLog geracao = new util.boleto.GeracaoLog();
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      if (f.getGridCheckField()) {
        if (portador == null) {
          portador = f.getPrt_codigo1() + "";
        }
        if (!portador.equalsIgnoreCase(f.getPrt_codigo1() + "")) {
          request.setAttribute("erro","s");
          throw new Exception("Não é possível gerar duplicatas de mais de um portador ao mesmo tempo!");
        }
      }
    }

    portador = null;
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      if (f.getGridCheckField()) {
        if (portador == null) {
          portador = f.getPrt_codigo1() + "";
        }
        if (!portador.equalsIgnoreCase(f.getPrt_codigo1() + "")) {
          request.setAttribute("erro","s");
          throw new Exception("Não é possível gerar duplicatas de mais de um portador ao mesmo tempo!");
        }

        geracao.gerar(request, f.getEmp_empresa2(), f.getFil_filial1(), f.getTip_codigo1(), f.getTit_codigo1(), f.getTit_datvenc1(), f.getPrt_codigo1(), f.getTit_valor());

        if (sbParametros.length() == 0) {
          sbParametros.append(" ((f.tit_codigo = '"+f.getTit_codigo1() + "' AND nvl(f.emp_empresa,NULL) = '"+f.getEmp_empresa2() + "' AND   f.tip_codigo = '"+f.getTip_codigo1() + "' AND f.fil_filial = '"+f.getFil_filial1() + "') ");
        } else {
          sbParametros.append(" OR (f.tit_codigo = '"+f.getTit_codigo1() + "' AND nvl(f.emp_empresa,NULL) = '"+f.getEmp_empresa2() + "' AND   f.tip_codigo = '"+f.getTip_codigo1() + "' AND f.fil_filial = '"+f.getFil_filial1() + "') ");
        }
        session.setAttribute(mapping.getName(), form);
      }
    }

    if (sbParametros.length() > 0) {
      sbParametros.append(")");
    }

    if (portador == null) {
      throw new Exception("Nenhuma duplicata selecionada!");
    }

    util.file.GeraPDF g = new util.file.GeraPDF(request);
    if (portador.equalsIgnoreCase("001")) {
      g.setRelatorio("BoletoBB.jasper");
    } else if (portador.equalsIgnoreCase("237")) {
      g.setRelatorio("BoletoBradesco.jasper");
    } else if (portador.equalsIgnoreCase("041")) {
      g.setRelatorio("BoletoBanrisul.jasper");
    } else if (portador.equalsIgnoreCase("104")) {
      g.setRelatorio("BoletoCaixa.jasper");
    } else {
      g.setRelatorio("BoletoSantander.jasper");
    }
    g.setParametro("P_WHERE", sbParametros.toString());
    g.gerar();
    request.setAttribute("abre_automaticamente","N");
  }
  public ActionForward perform_marcar_todos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ImpressaoDuplicatasNV_rActionForm[]_ge_grid_array = (ImpressaoDuplicatasNV_rActionForm[])_ge_grid.get("bl_form_Jw_t_titulos_lista_lines");
      ImpressaoDuplicatasNV_rActionForm f = _ge_grid_array[0];


      try {
        tg_marcar_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_t_titulos_lista", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void tg_marcar_todos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ImpressaoDuplicatasNV_rActionForm[]_ge_grid_array = (ImpressaoDuplicatasNV_rActionForm[])_ge_grid.get("bl_form_Jw_t_titulos_lista_lines");
      if (_ge_grid_array != null) {
        ImpressaoDuplicatasNV_rActionForm f = null;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
          f = _ge_grid_array[_ge_grid_array_index];
          f.setGridCheckField(true);
        }
      }
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    }
  }

  public ActionForward perform_desmarcar_todos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ImpressaoDuplicatasNV_rActionForm[]_ge_grid_array = (ImpressaoDuplicatasNV_rActionForm[])_ge_grid.get("bl_form_Jw_t_titulos_lista_lines");
      ImpressaoDuplicatasNV_rActionForm f = _ge_grid_array[0];


      try {
        tg_desmarcar_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_t_titulos_lista", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void tg_desmarcar_todos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ImpressaoDuplicatasNV_rActionForm[]_ge_grid_array = (ImpressaoDuplicatasNV_rActionForm[])_ge_grid.get("bl_form_Jw_t_titulos_lista_lines");
      if (_ge_grid_array != null) {
        ImpressaoDuplicatasNV_rActionForm f = null;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
          f = _ge_grid_array[_ge_grid_array_index];
          f.setGridCheckField(false);
        }
      }
    } catch (Exception e) {
      throw e;
    }
  }


  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/adm/ImpressaoDuplicatasNV_rGrid.do?select1_action=", true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_titulos_registros", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    ImpressaoDuplicatasNV_rActionForm f = (ImpressaoDuplicatasNV_rActionForm) form;
    String esc = "null";
    String situacao = "null";
    String data_vencimento = "null";
    String data_vencimento_final = "null";
    String emp_empresa = "null";
    util.consultas.Query q = new util.consultas.Query();
    acesso.Sessao sessao = new acesso.Sessao(session);
    util.boleto.CodigoBarra codigoBarraBB = new util.boleto.CodigoBarra();
    util.boleto.CodigoBarraBanrisul codigoBarraBanrisul = new util.boleto.CodigoBarraBanrisul();
    util.boleto.CodigoBarraBradesco codigoBarraBradesco = new util.boleto.CodigoBarraBradesco();
    util.boleto.CodigoBarraSantander codigoBarraSantander = new util.boleto.CodigoBarraSantander();
    util.boleto.CodigoBarraCaixa codigoBarraCaixa = new util.boleto.CodigoBarraCaixa();
    boolean liberaBanrisul = true;

    if (sessao.getUsuario().equalsIgnoreCase("ADMIN") || sessao.getUsuario().equalsIgnoreCase("151231")) {
      liberaBanrisul = true;
    }

    if (session.getAttribute("query_impressao_duplicatas_cliente") == null) {

      if (f.getEsc_seqn() != "") {
        esc = f.getEsc_seqn();
      }

      if (f.getDt_venc().equals("null") || f.getDt_venc().equals("")) {
        data_vencimento = "null";
      } else {
        data_vencimento = "'"+f.getDt_venc() + "'";
      }

      if (f.getDt_venc_final().equals("null") || f.getDt_venc_final().equals("")) {
        data_vencimento_final = "null";
      } else {
        data_vencimento_final = "'"+f.getDt_venc_final() + "'";
      }

      if (f.getEmp_empresa() != "") {
        emp_empresa = "'"+f.getEmp_empresa() + "'";
      }

      if (f.getSituacao() != "") {
        situacao = "'"+f.getSituacao() + "'";
      }

    } else {
      situacao = "'A'";
    }


    //------ tabelas ------------------------------
    portalbr.dbobj.table.Dual table_dual = new portalbr.dbobj.table.Dual();
    //------ variaveis ----------------------------
    String w_tit_dsante = "0";
    String w_tit_dspont = "0";
    String w_tit_vljuro = "0";
    double w_tit_vldesc = 0;
    double w_saldo = 0;
    double w_liq = 0;
    double w_saldo_tot = 0;
    double w_valor_tot = 0;
    double taxa = 0;
    String portador = null;
    if (session.getAttribute("portador_filtro") != null) {
      portador = (String) session.getAttribute("portador_filtro");
    }

    //--- Sysdate ---
    String sysdate = q.retorna(j, "SELECT to_char(trunc(SYSDATE),'dd/mm/yyyy') FROM dual");
    //---------------

    //--- Taxa ---
    taxa = Double.parseDouble(q.retorna(j, "select taxa_juros from taxas_juros WHERE rownum = 1"));
    //------------

    String codigo_regional = "null";
    String codigo_representante = "null";
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
        codigo_representante = "'"+ent.getChave() + "'";
      }
    }

    StringBuilder query = new StringBuilder();
    query.append(" SELECT /*+ all_rows */ ");
    query.append("        trunc(tit_datvenc) + 3 tit_datven3 ");
    query.append("      , tit_codigo ");
    query.append("      , tit_numbco ");
    query.append("      , decode(tit_status,'A','Aberto','C','Cancelado','L','Liquidado') tit_status ");
    query.append("      , tip_codigo ");
    query.append("      , tit_datvenc ");
    query.append("      , tit_datrec ");
    query.append("      , tit_datemi ");
    query.append("      , tit_dspont ");
    query.append("      , tit_dsante ");
    query.append("      , tit_valor ");
    query.append("      , tit_vlrec ");
    query.append("      , p.prt_codigo ");
    query.append("      , p.prt_descri ");
    query.append("      , t.emp_empresa ");
    query.append("      , fil_filial ");
    query.append("      , sit.descricao_situacao_do_titulo desc_sit ");
    query.append("      , '' ncc ");
    query.append("      , '' nota ");
    query.append("      , '' serie ");
    query.append("      , '' taxa_juro ");
    query.append("      , '' trn_codigo ");
    query.append("      , null mov_data ");
    query.append("      , null datvenc ");
    query.append("      , 'N' cobjur ");
    query.append("      , '0' tit_abatim ");
    query.append("      , '' vnc_cartor ");
    query.append("      , '' dif ");
    query.append("      , t.rep_codigo ");
    query.append("      , trunc(SYSDATE) data_atual ");
    query.append("      , '' w_liq ");
    query.append("      , '' w_saldo_tot ");
    query.append("      , '' w_valor_tot ");
    query.append("      , '' pedido ");
    query.append("      , brio.fct_retorna_vendor(t.cac_sequencia) vendor ");
    query.append("      , fct_formata_cnpj(e.esc_cgc) cnpj ");
    query.append("      , e.esc_cgc cnpj_sem_formato ");
    query.append("      , t.cli_codigo ");
    query.append("      , t.esc_seqn ");
    query.append("      , c.cli_rzao ");
    query.append("      , t.cac_sequencia ");
    //  query.append("      , CASE WHEN t.prt_codigo = '033' then (SELECT SUBSTR(REPLACE(REPLACE(brconrec.fct_ctr_gera_linha_dig_033(codigo_barras), '.', ''), ' ', ''), 1, 9) || '.' || ");
    //  query.append("               SUBSTR(REPLACE(REPLACE(brconrec.fct_ctr_gera_linha_dig_033(codigo_barras), '.', ''), ' ', ''), 10, 1) || ' ' || ");
    //  query.append("               SUBSTR(REPLACE(REPLACE(brconrec.fct_ctr_gera_linha_dig_033(codigo_barras), '.', ''), ' ', ''), 11, 10) || '.' || ");
    //  query.append("               SUBSTR(REPLACE(REPLACE(brconrec.fct_ctr_gera_linha_dig_033(codigo_barras), '.', ''), ' ', ''), 21, 1) || ' ' || ");
    //  query.append("               SUBSTR(REPLACE(REPLACE(brconrec.fct_ctr_gera_linha_dig_033(codigo_barras), '.', ''), ' ', ''), 22, 10) || '.' || ");
    //  query.append("               SUBSTR(REPLACE(REPLACE(brconrec.fct_ctr_gera_linha_dig_033(codigo_barras), '.', ''), ' ', ''), 32, 1) || ' ' || ");
    //  query.append("               SUBSTR(REPLACE(REPLACE(brconrec.fct_ctr_gera_linha_dig_033(codigo_barras), '.', ''), ' ', ''), 33, 1) || ' ' || ");
    //  query.append("               SUBSTR(REPLACE(REPLACE(brconrec.fct_ctr_gera_linha_dig_033(codigo_barras), '.', ''), ' ', ''), 34, 15) ");
    //  query.append("          FROM (SELECT brconrec.fct_ctr_cod_barra_sant_033(t.emp_empresa, t.fil_filial, t.tip_codigo, t.tit_codigo) codigo_barras ");
    //  query.append("                  FROM dual)) when t.prt_codigo = '001' then (brconrec.fct_ctr_gera_linha_digitavel(brconrec.fct_ctr_codigo_barra_bb(t.emp_empresa, t.fil_filial, t.tip_codigo, t.tit_codigo, t.cac_sequencia, t.tit_datemi, t.tit_numbco))) else null end linha_digitavel ");
    query.append("      , null linha_digitavel ");
    query.append("   FROM titulos t ");
    query.append("      , situacoes_dos_titulos sit ");
    query.append("      , portadores p ");
    query.append("      , cli c ");
    if (session.getAttribute("mostrar_grupo") != null || session.getAttribute("grupo_economico") != null) {
      query.append("   , grupo_economico ge ");
    }
    query.append("      , regionais_vendas reg ");
    query.append("      , rep r ");
    query.append("      , esc e ");
    query.append("  WHERE t.emp_empresa                   = nvl("+emp_empresa + ", t.emp_empresa) ");

    if (session.getAttribute("query_duplicatas") != null) {
      query.append(" AND t.tit_codigo in ("+(String) session.getAttribute("query_duplicatas") + ") ");
    }

    if (session.getAttribute("query_notas_fiscais") != null) {
      query.append(" AND t.tit_codigo IN (SELECT tit_codigo FROM tit_nf WHERE nsa_numero in ("+(String) session.getAttribute("query_notas_fiscais") + ")) ");
    }

    query.append("    AND e.cli_cdgo = t.cli_codigo ");
    query.append("    AND t.cli_codigo = c.cli_cdgo ");
    query.append("    AND e.esc_seqn = t.esc_seqn ");
    query.append("    AND p.prt_codigo                 (+) = t.prt_codigo ");
    query.append("    AND nvl(T.tip_codigo,null)      in ('DUP','NTP','NTC','NTS','NTD') ");
    query.append("    AND nvl(t.sit_codigo_situacao_titulo,-1) not in (26,27) ");
    if (session.getAttribute("mostrar_grupo") != null || session.getAttribute("grupo_economico") != null) {
      query.append("   AND ge.status = 'A' ");
      if (session.getAttribute("grupo_economico") != null) {
        query.append("   AND ge.cli_cdgo = c.cli_cdgo ");
        query.append("   AND ge.gre_grupo = "+(String) session.getAttribute("grupo_economico"));
      } else {
        query.append("   AND ge.cli_cdgo = t.cli_codigo ");
        query.append("   AND ge.gre_grupo = (SELECT pck_cliente.get_grupo_economico(e.cli_cdgo) ");
        query.append("                         FROM esc e ");
        query.append("                        WHERE esc_Cgc = " + (String) session.getAttribute("mostrar_grupo") + ") ");
      }
    } else {
      if (session.getAttribute("query_impressao_duplicatas_cliente") == null) {
        if (f.getCli_cdgo() != null && f.getCli_cdgo() != "") {
          query.append("    AND cli_codigo                       = ").append(f.getCli_cdgo());
          query.append("    AND t.esc_seqn            =  nvl(").append(esc).append(",t.esc_seqn) ");
        }
      } else {
        query.append(((String) session.getAttribute("query_impressao_duplicatas_cliente")));
      }
    }
    query.append("    AND tit_datvenc                     >= decode(to_date(").append(data_vencimento).append(",'dd/mm/yyyy'),null,tit_datvenc,to_date(").append(data_vencimento).append(",'dd/mm/yyyy')) ");
    if (!data_vencimento_final.equalsIgnoreCase("null")) {
      query.append("    AND tit_datvenc                     < to_date(").append(data_vencimento_final).append(",'dd/mm/yyyy') + 1 ");
    }
    query.append("    AND tit_status                 =  decode(").append(situacao).append(",'T',tit_status,decode(").append(situacao).append(",'A','A','L','L','C','C')) ");
    query.append("    AND t.sit_codigo_situacao_titulo     = sit.codigo_situacao_titulo ");
    query.append("    AND (t.emp_empresa, t.fil_filial, t.tip_codigo , t.tit_codigo) ");
    query.append("    NOT IN (SELECT m.emp_empresa ");
    query.append("                 , m.fil_filial ");
    query.append("                 , m.tip_codigo ");
    query.append("                 , m.tit_codigo ");
    query.append("              FROM mov_receber m ");
    query.append("             WHERE nvl(m.emp_empresa,null) = nvl(t.emp_empresa,null) ");
    query.append("               AND nvl(m.fil_filial,null)  = nvl(t.fil_filial,null) ");
    query.append("               AND nvl(m.tip_codigo,null)  = nvl(t.tip_codigo,null) ");
    query.append("               AND m.tit_codigo            = nvl(t.tit_codigo,null) ");
    query.append("               AND nvl(m.trn_codigo,null)  in ('CON','TNC','FAL','NEG','PNE') ");
    query.append("               AND trunc(mov_data)        <= trunc(sysdate) ");
    query.append("               AND nvl(m.mov_data,null)   <= trunc(sysdate) ");
    query.append("               AND nvl(m.mov_sequencia,0)  = 0 ");
    query.append("               AND rownum = 1 ) ");
    query.append("    AND t.rep_codigo        = r.rep_cdgo ");
    query.append("    AND r.codigo_regional   = reg.codigo_regional ");
    query.append("    AND t.rep_codigo        = nvl(").append(codigo_representante).append(",t.rep_codigo) ");
    query.append("    AND reg.codigo_regional = nvl(").append(codigo_regional).append(",reg.codigo_regional) ");

    if ((portador != null && portador.equalsIgnoreCase("T")) || portador == null) {

      if (liberaBanrisul) {
        query.append("    AND NVL(t.prt_codigo, NULL) in ('001','033','237','041','104') ");
      } else {
        query.append("    AND NVL(t.prt_codigo, NULL) in ('001','033','237','104') ");
      }
    } else {
      query.append("    AND nvl(t.prt_codigo,null) = '"+portador + "' ");

    }

    // Temporário até atualizar a geração dos boletos
    query.append(" AND ( ");
    query.append("       (NVL(t.prt_codigo, NULL) = '041') ");
    query.append("       or ");
    query.append("       (NVL(t.prt_codigo, NULL) = '001') ");
    query.append("       or ");
    query.append("       (NVL(t.prt_codigo, NULL) = '237') ");
    query.append("       or ");
    query.append("       (NVL(t.prt_codigo, NULL) = '104') ");
    query.append("       or ");
    query.append("       (NVL(t.prt_codigo, NULL) = '033') ");
    query.append("       )  ");


    query.append("    AND trunc(t.tit_datvenc) >= trunc(sysdate) - fct_retorna_parametro('dias_retroativos_emissao_boleto','BRNET') ");
    query.append("    AND t.tit_numbco is not null ");
    if (session.getAttribute("mostrar_grupo") != null || session.getAttribute("grupo_economico") != null) {
      if (session.getAttribute("impressao_duplicatas_ordenar_data_vencimento") != null) {
        query.append(" ORDER BY tit_datvenc, tit_status, c.cli_cdgo, esc_seqn");
      } else {
        query.append(" ORDER BY c.cli_cdgo, esc_seqn, tit_datvenc, tit_status");
      }
    } else {
      query.append("  ORDER BY tit_datvenc, tit_status ");
    }
    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      throw new Exception(query.toString());
    }

    portalbr.dbobj.view.Jw_t_titulos_lista table = new portalbr.dbobj.view.Jw_t_titulos_lista();
    Vector res_Jw_t_titulos_lista = j.select(table, query.toString(), null);


    session.setAttribute("res_Jw_t_titulos_lista",res_Jw_t_titulos_lista);

    if (res_Jw_t_titulos_lista != null && res_Jw_t_titulos_lista.size() > 0) {
      for (int x = 0; x < res_Jw_t_titulos_lista.size(); x++) {
        portalbr.dbobj.view.Jw_t_titulos_lista r = (portalbr.dbobj.view.Jw_t_titulos_lista) res_Jw_t_titulos_lista.elementAt(x);
        if (r.getLinha_digitavel() == null) {
          if (r.getPrt_codigo().equals("001")) {
            r.setLinha_digitavel(codigoBarraBB.getLinhaDigitavelByTitulo(j, r.getTit_codigo()));
          }
          if (r.getPrt_codigo().equals("041")) {
            r.setLinha_digitavel(codigoBarraBanrisul.getLinhaDigitavel(j, r.getEmp_empresa(), r.getFil_filial(), r.getTip_codigo(), r.getTit_codigo()));
          }
          if (r.getPrt_codigo().equals("033")) {
            r.setLinha_digitavel(codigoBarraSantander.getLinhaDigitavelByTitulo(j, r.getTit_codigo()));
          }
          if (r.getPrt_codigo().equals("237")) {
            r.setLinha_digitavel(codigoBarraBradesco.getLinhaDigitavelByTitulo(j, r.getTit_codigo()));
          }
          if (r.getPrt_codigo().equals("104")) {
            r.setLinha_digitavel(codigoBarraCaixa.getLinhaDigitavelByTitulo(j, r.getTit_codigo()));
          }
        }

        //------------- verifica nota credito -----------
        portalbr.dbobj.view.Jw_t_verifica_nota_credito table_verifica_nota_credito = new portalbr.dbobj.view.Jw_t_verifica_nota_credito();
        StringBuilder query1 = new StringBuilder();
        query1.append(" SELECT /*+ all_rows */ ");
        query1.append("        decode(trn_codigo,'NCC','NCC',' ') ncc ");
        query1.append("   FROM mov_receber ");
        query1.append("  WHERE tit_codigo = '").append((r.getTit_codigo() + "")).append("' ");
        query1.append("    AND nvl(trn_codigo,null) = 'NCC' ");

        Vector res_Jw_t_verifica_nota_credito = j.select(table_verifica_nota_credito, query1.toString(), null);

        if (res_Jw_t_verifica_nota_credito != null && res_Jw_t_verifica_nota_credito.size() > 0) {
          portalbr.dbobj.view.Jw_t_verifica_nota_credito r2 = (portalbr.dbobj.view.Jw_t_verifica_nota_credito) res_Jw_t_verifica_nota_credito.elementAt(0);
          r.setNcc(r2.getNcc() + "");

        }

        //----------- nota titulo ----------------------

        portalbr.dbobj.view.Jw_t_nota_titulo table_nota_titulo = new portalbr.dbobj.view.Jw_t_nota_titulo();
        StringBuilder query2 = new StringBuilder();
        query2.append(" SELECT /*+ all_rows */                         ");
        query2.append("        nf.nsa_numero                   nota    ");
        query2.append("      , nf.nsa_serie                    serie   ");
        query2.append("      , nf.fil_filial                   filial  ");
        //query2.append("      , nfs.ped_nmro                            ");
        //query2.append("      , nvl(p.ped_nmro,0)               pedido  ");
        query2.append("   FROM tit_nf                          nf      ");
        //query2.append("      , notas_fiscais_saida_ped_venda   nfs     ");
        //query2.append("      , ped                             p       ");
        query2.append("  WHERE 1=1                                     ");
        //query2.append("    AND nf.emp_empresa = nfs.emp_empresa        ");
        //query2.append("    AND nf.fil_filial  = nfs.fil_filial         ");
        //query2.append("    AND nfs.nfs_nmro   = nf.nsa_numero          ");
        //query2.append("    AND nfs.nfs_serie  = nf.nsa_serie           ");
        //query2.append("    AND p.ped_nmro (+) = nfs.ped_nmro           ");
        query2.append("    AND nf.emp_empresa = '").append(r.getEmp_empresa()).append("' ");
        query2.append("    AND nf.fil_filial  = '").append(r.getFil_filial()).append("'  ");
        query2.append("    AND nf.tip_codigo  = '").append(r.getTip_codigo()).append("'  ");
        query2.append("    AND nf.tit_codigo  = '").append(r.getTit_codigo()).append("'  ");

        Vector res_Jw_t_nota_titulo = j.select(table_nota_titulo, query2.toString(), null);

        if (res_Jw_t_nota_titulo != null && res_Jw_t_nota_titulo.size() > 0) {
          portalbr.dbobj.view.Jw_t_nota_titulo r3 = (portalbr.dbobj.view.Jw_t_nota_titulo) res_Jw_t_nota_titulo.elementAt(0);
          r.setNota(r3.getNota() + "");
          r.setSerie(r3.getSerie() + "");
          //  r.setPed_nmro(r3.getPed_nmro()+"");
          //  r.setPedido(r3.getPedido()+"");
        }

        if ((r.getTit_status() + "").equals("Aberto")) {

          //--------- taxa juro --------------------
          r.setTaxa_juro(taxa);
          //----------------------------------------

          //---------- busca dis -------------------
          portalbr.dbobj.view.Jw_t_busca_dis table_busca_dis = new portalbr.dbobj.view.Jw_t_busca_dis();
          StringBuilder query3 = new StringBuilder();
          query3.append(" SELECT /*+ all_rows */ ");
          query3.append("        mov_data     dat ");
          query3.append("      , trn_codigo   trn ");
          query3.append("   FROM mov_receber  ");
          query3.append("  WHERE emp_empresa = '").append(r.getEmp_empresa()).append("' ");
          query3.append("    AND fil_filial  = '").append(r.getFil_filial()).append("' ");
          query3.append("    AND tip_codigo  = '").append(r.getTip_codigo()).append("' ");
          query3.append("    AND tit_codigo  = '").append(r.getTit_codigo()).append("' ");
          query3.append("    AND trn_codigo  = 'DIS' ");
          query3.append("    AND nvl(mov_sequencia,0)=0 ");
          query3.append("    AND rownum = 1 ");

          //Vector res_Jw_t_busca_dis = j.select(table_busca_dis, query3.toString(), null);
          Vector res_Jw_t_busca_dis = null;

          if (res_Jw_t_busca_dis != null && res_Jw_t_busca_dis.size() > 0) {
            portalbr.dbobj.view.Jw_t_busca_dis r5 = (portalbr.dbobj.view.Jw_t_busca_dis) res_Jw_t_busca_dis.elementAt(0);
            r.setMov_data(r5.getDat());
            r.setTrn_codigo(r5.getTrn() + "");
          } else {

            // -------- Transação ------
            portalbr.dbobj.view.Jw_t_transacao table_transacao = new portalbr.dbobj.view.Jw_t_transacao();
            StringBuilder query4 = new StringBuilder();
            query4.append(" SELECT /*+ all_rows */ ");
            query4.append("        trn_codigo trn ");
            query4.append("      , mov_data dat ");
            query4.append("   FROM mov_receber ");
            query4.append("  WHERE emp_empresa = '").append(r.getEmp_empresa()).append("' ");
            query4.append("    AND fil_filial  = '").append(r.getFil_filial()).append("' ");
            query4.append("    AND tip_codigo  = '").append(r.getTip_codigo()).append("' ");
            query4.append("    AND tit_codigo  = '").append(r.getTit_codigo()).append("' ");
            query4.append("  ORDER BY mov_data ");

            //Vector res_Jw_t_transacao = j.select(table_transacao, query4.toString(),  null);
            Vector res_Jw_t_transacao = null;

            if (res_Jw_t_transacao != null && res_Jw_t_transacao.size() > 0) {
              portalbr.dbobj.view.Jw_t_transacao r6 = (portalbr.dbobj.view.Jw_t_transacao) res_Jw_t_transacao.elementAt(0);
              r.setMov_data(r6.getDat());
              r.setTrn_codigo(r6.getTrn() + "");
            }
          }

          //------- venc orig ----------
          portalbr.dbobj.view.Jw_t_venc_orig table_venc_orig = new portalbr.dbobj.view.Jw_t_venc_orig();
          StringBuilder query5 = new StringBuilder();
          query5.append(" SELECT /*+ all_rows */ ");
          query5.append("        mov_datvenc  md ");
          query5.append("      , mov_cobjur   mc ");
          query5.append("      , mov_condes   mo ");
          query5.append("   FROM mov_receber ");
          query5.append("  WHERE emp_empresa = '").append(r.getEmp_empresa()).append("' ");
          query5.append("    AND fil_filial  = '").append(r.getFil_filial()).append("' ");
          query5.append("    AND tip_codigo  = '").append(r.getTip_codigo()).append("' ");
          query5.append("    AND tit_codigo  = '").append(r.getTit_codigo()).append("' ");
          query5.append("    AND trn_codigo  = 'VCT' ");

          //Vector res_Jw_t_venc_orig = j.select(table_venc_orig, query5.toString(), null);
          Vector res_Jw_t_venc_orig = null;

          if (res_Jw_t_venc_orig != null && res_Jw_t_venc_orig.size() > 0) {
            portalbr.dbobj.view.Jw_t_venc_orig r7 = (portalbr.dbobj.view.Jw_t_venc_orig) res_Jw_t_venc_orig.elementAt(0);
            r.setDatvenc(r7.getMd());
            r.setCobjur(r7.getMc() + "");
            r.setCondes(r7.getMo() + "");


          }
          //----------------------------
          if ((r.getCobjur() + "").equals("N")) {
            r.setDatvenc(r.getTit_datvenc());
          }
          //---------------- proc ncc --------------------
          portalbr.dbobj.view.Jw_t_proc_ncc table_proc_ncc = new portalbr.dbobj.view.Jw_t_proc_ncc();
          StringBuilder query6 = new StringBuilder();
          query6.append(" SELECT /*+ all_rows */ ");
          query6.append("        mov_valor mv ");
          query6.append("   FROM mov_receber ");
          query6.append("  WHERE emp_empresa = '").append(r.getEmp_empresa()).append("' ");
          query6.append("    AND fil_filial  = '").append(r.getFil_filial()).append("' ");
          query6.append("    AND tip_codigo  = '").append(r.getTip_codigo()).append("' ");
          query6.append("    AND trn_codigo  = 'NCC' ");
          query6.append("    AND tit_codigo            = '").append(r.getTit_codigo()).append("' ");

          //Vector res_Jw_t_proc_ncc = j.select(table_proc_ncc, query6.toString(), null);
          Vector res_Jw_t_proc_ncc = null;

          if (res_Jw_t_proc_ncc != null && res_Jw_t_proc_ncc.size() > 0) {
            portalbr.dbobj.view.Jw_t_proc_ncc r8 = (portalbr.dbobj.view.Jw_t_proc_ncc) res_Jw_t_proc_ncc.elementAt(0);
            r.setTit_abatim(r8.getMv() + "");
          }


          //----------- desp_pro -------------
          portalbr.dbobj.view.Jw_t_desp_pro table_desp_pro = new portalbr.dbobj.view.Jw_t_desp_pro();
          StringBuilder query7 = new StringBuilder();
          query7.append(" SELECT /*+ all_rows */ ");
          query7.append("        mov_valor mv ");
          query7.append("   FROM mov_receber ");
          query7.append("  WHERE emp_empresa = '").append(r.getEmp_empresa()).append("' ");
          query7.append("    AND fil_filial  = '").append(r.getFil_filial()).append("' ");
          query7.append("    AND tip_codigo  = '").append(r.getTip_codigo()).append("' ");
          query7.append("    AND trn_codigo  = 'PRO' ");
          query7.append("    AND tit_codigo            = '").append(r.getTit_codigo()).append("' ");

          //Vector res_Jw_t_desp_pro = j.select(table_desp_pro, query7.toString(), null);
          Vector res_Jw_t_desp_pro = null;
          if (res_Jw_t_desp_pro != null && res_Jw_t_desp_pro.size() > 0) {
            portalbr.dbobj.view.Jw_t_desp_pro r9 = (portalbr.dbobj.view.Jw_t_desp_pro) res_Jw_t_desp_pro.elementAt(0);
            r.setVnc_cartor(r9.getMv() + "");
          }


          //--- Dif ---
          r.setDif(q.retorna(j, "SELECT ''||abs(trunc(to_date("+data_vencimento + ",'dd/mm/yyyy') - trunc(sysdate))) from dual"));
          //-----------

          Date d1 = FormatDate.parse(sysdate);
          Date d2 = FormatDate.parse(com.egen.util.text.FormatDate.format(r.getDatvenc(), "dd/MM/yyyy"));
          Date d3 = FormatDate.parse(com.egen.util.text.FormatDate.format(r.getTit_datven3(), "dd/MM/yyyy"));

          if (d1.before(d2)) {
            w_tit_dsante = q.retorna(j, "SELECT round(((nvl(" + r.getTit_dsante() + ",0) / 100) * (nvl("+r.getTit_valor() + ",0)) *  nvl("+r.getDif() + ",0)),2) FROM dual");
            w_tit_dspont = q.retorna(j, "SELECT round((nvl("+r.getTit_dspont() + ",0) / 100) * nvl("+r.getTit_valor() + ",0),2) FROM dual");
          }

          if ((!d1.after(d2)) && (!d1.before(d2))) {
            w_tit_dspont = q.retorna(j, "SELECT round((nvl("+r.getTit_dspont() + ",0) / 100) * nvl("+r.getTit_valor() + ",0),2) FROM dual ");
            w_tit_dsante = "0";
          }

          if (d1.after(d3)) {
            w_tit_dspont = "0";
            w_tit_dsante = "0";
            w_tit_vljuro = q.retorna(j, "SELECT round((nvl("+r.getTit_valor() + ",0) -  nvl("+r.getTit_abatim() + ",0)) * ("+taxa + "/100 / 30) *  nvl("+r.getDif() + ",0),2) FROM dual");
          }
          w_tit_vldesc = Double.parseDouble(w_tit_dspont + "") + Double.parseDouble(w_tit_dsante + "");
        }
        // ---status aberto --------------------------------------------------------------------

        if ((r.getTit_status() + "").equals("Liquidado")) {
          w_saldo = r.getTit_vlrec();
          w_liq += w_saldo;
        } else {
          w_saldo = r.getTit_valor();
        }


        if ((!((r.getTrn_codigo() + "").equals("DIS"))) || (r.getTrn_codigo() + "").equals("null")) {

          if ((!(r.getTit_status().equals("Cancelado"))) && (!(r.getTit_status().equals("Liquidado")))) {
            w_saldo = r.getTit_valor() - r.getTit_vlrec() - w_tit_vldesc - Double.parseDouble(r.getTit_abatim() + "");
            w_saldo_tot += w_saldo;
            r.setTit_vlrec(w_saldo);
          }
        }

        w_valor_tot += r.getTit_valor();

      }


      portalbr.dbobj.view.Jw_t_titulos_lista r = (portalbr.dbobj.view.Jw_t_titulos_lista) res_Jw_t_titulos_lista.elementAt(0);
      r.setW_liq(com.egen.util.text.FormatNumber.format(w_liq, "##,##0.00"));
      r.setW_saldo_tot(com.egen.util.text.FormatNumber.format(w_saldo_tot, "##,##0.00"));
      r.setW_valor_tot(com.egen.util.text.FormatNumber.format(w_valor_tot, "##,##0.00"));

    }


    if (!(res_Jw_t_titulos_lista != null && res_Jw_t_titulos_lista.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_t_titulos_lista", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute("mapping.getName()", form);
  }


  public String retornaCNPJ (String cli_cdgo, String esc_seqn) throws Exception {
    StringBuilder CNPJ = new StringBuilder();
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      portalbr.dbobj.view.Endereco table = new portalbr.dbobj.view.Endereco();
      StringBuilder query = new StringBuilder();

      query.append(" SELECT DISTINCT '' cli_cdgo      ");
      query.append("                ,'' esc_seqn      ");
      query.append("                ,'' ecl_cdad      ");
      query.append("                ,fct_formata_cnpj(esc.esc_cgc) cnpj ");
      query.append("                ,'' endereco      ");
      query.append(" from esc                         ");
      query.append(" where cli_cdgo =      " + cli_cdgo);
      query.append("   and esc_situacao = 'A' ");
      query.append("   and esc_seqn =      " + esc_seqn);

      Vector < ?> res_cnpj = j.select(table, query.toString(), null);

      if (res_cnpj != null && res_cnpj.size() > 0) {
        portalbr.dbobj.view.Endereco r = (portalbr.dbobj.view.Endereco) res_cnpj.elementAt(0);
        r = (portalbr.dbobj.view.Endereco) res_cnpj.elementAt(0);
        CNPJ.append(r.getCnpj());
      }
    }
    finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return CNPJ.toString();
  }
}
