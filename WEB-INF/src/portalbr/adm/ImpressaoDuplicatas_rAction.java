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
 * Last Modify Date 07/07/2014 14:21:12
 */

public class ImpressaoDuplicatas_rAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select1_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ImpressaoDuplicatas_rActionForm[]_ge_grid_array = (ImpressaoDuplicatas_rActionForm[])_ge_grid.get("bl_form_Jw_t_titulos_lista_lines");
      ImpressaoDuplicatas_rActionForm f = _ge_grid_array[0];
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
    ImpressaoDuplicatas_rActionForm[]_ge_grid_array = (ImpressaoDuplicatas_rActionForm[])_ge_grid.get("bl_form_Jw_t_titulos_lista_lines");
    ImpressaoDuplicatas_rActionForm f = _ge_grid_array[0];
    if (f != null) {
      Jw_t_titulos_lista table = new Jw_t_titulos_lista();
      String[][] select = null;
      String[] order = null;
      String[] groupby = null;
      String[] having = null;
      Object[][] where = { {"tit_datven3","=", com.egen.util.text.FormatDate.parseDate(f.getTit_datven3(), "null")}, {"tit_codigo","like", f.getTit_codigo1()}, {"tit_numbco","like", f.getTit_numbco()}, {"tit_status","like", f.getTit_status()}, {"tip_codigo","like", f.getTip_codigo1()}, {"tit_datvenc","=", com.egen.util.text.FormatDate.parseDate(f.getTit_datvenc1(), "null")}, {"tit_datrec","=", com.egen.util.text.FormatDate.parseDate(f.getTit_datrec(), "null")}, {"tit_datemi","=", com.egen.util.text.FormatDate.parseDate(f.getTit_datemi(), "null")}, {"tit_dspont","=", com.egen.util.text.FormatNumber.toDouble(f.getTit_dspont())}, {"tit_dsante","=", com.egen.util.text.FormatNumber.toDouble(f.getTit_dsante())}, {"tit_valor","=", com.egen.util.text.FormatNumber.toDouble(f.getTit_valor())}, {"tit_vlrec","=", com.egen.util.text.FormatNumber.toDouble(f.getTit_vlrec())}, {"prt_codigo","like", f.getPrt_codigo1()}, {"prt_descri","like", f.getPrt_descri()}, {"emp_empresa","like", f.getEmp_empresa2()}, {"fil_filial","like", f.getFil_filial1()}, {"desc_sit","like", f.getDesc_sit()}, {"ncc","like", f.getNcc()}, {"nota","like", f.getNota()}, {"serie","like", f.getSerie()}, {"taxa_juro","=", com.egen.util.text.FormatNumber.toDouble(f.getTaxa_juro())}, {"trn_codigo","like", f.getTrn_codigo()}, {"mov_data","=", com.egen.util.text.FormatDate.parse(f.getMov_data(), "null")}, {"datvenc","=", com.egen.util.text.FormatDate.parse(f.getDatvenc(), "null")}, {"cobjur","like", f.getCobjur()}, {"tit_abatim","like", f.getTit_abatim()}, {"vnc_cartor","like", f.getVnc_cartor()}, {"dif","like", f.getDif()}, {"condes","like", f.getCondes()}, {"rep_codigo","like", f.getRep_codigo()}, {"data_atual","=", com.egen.util.text.FormatDate.parseDate(f.getData_atual(), "null")}, {"ped_nmro","like", f.getPed_nmro()}, {"w_liq","like", f.getW_liq1()}, {"w_saldo_tot","like", f.getW_saldo_tot1()}, {"w_valor_tot","like", f.getW_valor_tot1()}, {"pedido","like", f.getPedido()}, {"vendor","like", f.getVendor()}, {"cnpj","like", f.getCnpj()}, {"cnpj_sem_formato","like", f.getCnpj_sem_formato()} };
      Vector res_Jw_t_titulos_lista = (java.util.Vector) session.getAttribute("res_Jw_t_titulos_lista"); //j.select(table, select, where, groupby, having, order);
      session.setAttribute("res_Jw_t_titulos_lista",res_Jw_t_titulos_lista);
      if (res_Jw_t_titulos_lista != null && res_Jw_t_titulos_lista.size() > 0) {

        ImpressaoDuplicatas_rActionForm[]_ge_grid_array_flex = new ImpressaoDuplicatas_rActionForm[res_Jw_t_titulos_lista.size()];
        org.apache.struts.config.ConfigEGenHelper.setFormPropertySize(mapping, "bl_form_Jw_t_titulos_lista_lines", res_Jw_t_titulos_lista.size());
        int _ge_pos = 0;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array_flex.length; _ge_grid_array_index++, _ge_pos++) {
          if (_ge_grid_array_index < _ge_grid_array.length) {
            f = _ge_grid_array[_ge_grid_array_index];
          } else {
            f = new ImpressaoDuplicatas_rActionForm();
            ActionServletWrapper actionServletWrapper = form.getServletWrapper();
            org.apache.struts.upload.CommonsMultipartRequestHandler commonsMultipartRequestHandler = new org.apache.struts.upload.CommonsMultipartRequestHandler();
            actionServletWrapper.setServletFor(commonsMultipartRequestHandler);
            f.setServlet(commonsMultipartRequestHandler.getServlet());
          }
          f.reset(mapping, request);
          if (res_Jw_t_titulos_lista.size() > _ge_pos) {
            Jw_t_titulos_lista r = (Jw_t_titulos_lista) res_Jw_t_titulos_lista.elementAt(_ge_pos);
            f.setTit_datven3(com.egen.util.text.FormatDate.format(r.getTit_datven3()));
            f.setTit_codigo1((r.getTit_codigo() != null) ? r.getTit_codigo() + "":"");
            f.setTit_numbco((r.getTit_numbco() != null) ? r.getTit_numbco() + "":"");
            f.setTit_status((r.getTit_status() != null) ? r.getTit_status() + "":"");
            f.setTip_codigo1((r.getTip_codigo() != null) ? r.getTip_codigo() + "":"");
            f.setTit_datvenc1(com.egen.util.text.FormatDate.format(r.getTit_datvenc()));
            f.setTit_datrec(com.egen.util.text.FormatDate.format(r.getTit_datrec()));
            f.setTit_datemi(com.egen.util.text.FormatDate.format(r.getTit_datemi()));
            f.setTit_dspont(r.getTit_dspont() + "");
            f.setTit_dsante(r.getTit_dsante() + "");
            f.setTit_valor(r.getTit_valor() + "");
            f.setTit_vlrec(r.getTit_vlrec() + "");
            f.setPrt_codigo1((r.getPrt_codigo() != null) ? r.getPrt_codigo() + "":"");
            f.setPrt_descri((r.getPrt_descri() != null) ? r.getPrt_descri() + "":"");
            f.setEmp_empresa2((r.getEmp_empresa() != null) ? r.getEmp_empresa() + "":"");
            f.setFil_filial1((r.getFil_filial() != null) ? r.getFil_filial() + "":"");
            f.setDesc_sit((r.getDesc_sit() != null) ? r.getDesc_sit() + "":"");
            f.setNcc((r.getNcc() != null) ? r.getNcc() + "":"");
            f.setNota((r.getNota() != null) ? r.getNota() + "":"");
            f.setSerie((r.getSerie() != null) ? r.getSerie() + "":"");
            f.setTaxa_juro(r.getTaxa_juro() + "");
            f.setTrn_codigo((r.getTrn_codigo() != null) ? r.getTrn_codigo() + "":"");
            f.setMov_data(com.egen.util.text.FormatDate.format(r.getMov_data()));
            f.setDatvenc(com.egen.util.text.FormatDate.format(r.getDatvenc()));
            f.setCobjur((r.getCobjur() != null) ? r.getCobjur() + "":"");
            f.setTit_abatim((r.getTit_abatim() != null) ? r.getTit_abatim() + "":"");
            f.setVnc_cartor((r.getVnc_cartor() != null) ? r.getVnc_cartor() + "":"");
            f.setDif((r.getDif() != null) ? r.getDif() + "":"");
            f.setCondes((r.getCondes() != null) ? r.getCondes() + "":"");
            f.setRep_codigo((r.getRep_codigo() != null) ? r.getRep_codigo() + "":"");
            f.setData_atual(com.egen.util.text.FormatDate.format(r.getData_atual()));
            f.setPed_nmro((r.getPed_nmro() != null) ? r.getPed_nmro() + "":"");
            f.setW_liq1((r.getW_liq() != null) ? r.getW_liq() + "":"");
            f.setW_saldo_tot1((r.getW_saldo_tot() != null) ? r.getW_saldo_tot() + "":"");
            f.setW_valor_tot1((r.getW_valor_tot() != null) ? r.getW_valor_tot() + "":"");
            f.setPedido((r.getPedido() != null) ? r.getPedido() + "":"");
            f.setVendor((r.getVendor() != null) ? r.getVendor() + "":"");
            f.setCnpj((r.getCnpj() != null) ? r.getCnpj() + "":"");
            f.setCnpj_sem_formato((r.getCnpj_sem_formato() != null) ? r.getCnpj_sem_formato() + "":"");
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
      ImpressaoDuplicatas_rActionForm[]_ge_grid_array = (ImpressaoDuplicatas_rActionForm[])_ge_grid.get("bl_form_Jw_t_titulos_lista_lines");
      ImpressaoDuplicatas_rActionForm f = _ge_grid_array[0];


      actionForward = new ActionForward("/adm/ImpressaoDuplicatasForm.jsp",true);
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
      ImpressaoDuplicatas_rActionForm[]_ge_grid_array = (ImpressaoDuplicatas_rActionForm[])_ge_grid.get("bl_form_Jw_t_titulos_lista_lines");
      ImpressaoDuplicatas_rActionForm f = _ge_grid_array[0];
      update_action(j, mapping, form, request, response);
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
  private void update_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    DynaActionForm _ge_grid = (DynaActionForm) form;
    acesso.Sessao sessao = new acesso.Sessao(session);
    ImpressaoDuplicatas_rActionForm[]_ge_grid_array = (ImpressaoDuplicatas_rActionForm[])_ge_grid.get("bl_form_Jw_t_titulos_lista_lines");
    ImpressaoDuplicatas_rActionForm f = _ge_grid_array[0];
    StringBuilder sbParametros = new StringBuilder();
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      if (f.getGridCheckField()) {


        java.sql.CallableStatement call = null;
        try {
          call = j.getConn().prepareCall("{ call pck_ctr_gera_trn_tit.prc_ctr_ins_mov_tit(?,?,?,?,'OBS',sysdate,to_date(?,'dd/mm/yyyy'),?,?,'N',null,?,null,null,null,null,null,sysdate,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,0,null,null,null,null,null,null,?)  }");
          call.registerOutParameter(9, java.sql.Types.VARCHAR);
          call.setString(1, f.getEmp_empresa2());
          call.setString(2, f.getFil_filial1());
          call.setString(3, f.getTip_codigo1());
          call.setString(4, f.getTit_codigo1());
          call.setString(5, f.getTit_datvenc1());
          call.setDouble(6, com.egen.util.text.FormatNumber.toDouble(f.getTit_valor()));
          call.setString(7, "BRCONREC");
          call.setString(8, f.getPrt_codigo());
          call.execute();
          String result = call.getString(9);
        } catch (Exception e) {
          e.printStackTrace(System.out);
        } finally {
          call.close();
        }

        util.consultas.Query query = new util.consultas.Query();
        StringBuilder sb = new StringBuilder();
        sb.append(" select sequencia ");
        sb.append("   from mov_receber ");
        sb.append("  where emp_empresa = '"+f.getEmp_empresa2() + "' ");
        sb.append("    and fil_filial  = '"+f.getFil_filial1() + "' ");
        sb.append("    and tip_codigo  = '"+f.getTip_codigo1() + "' ");
        sb.append("    and tit_codigo  = '"+f.getTit_codigo1() + "' ");
        sb.append("    and mov_data    = trunc(sysdate) ");
        int sequencia = Integer.parseInt(query.retorna(sb.toString()));

        StringBuilder sbc = new StringBuilder();
        sbc.append(" SELECT cli_codigo ");
        sbc.append("   FROM titulos ");
        sbc.append("  where emp_empresa = '"+f.getEmp_empresa2() + "' ");
        sbc.append("    and fil_filial  = '"+f.getFil_filial1() + "' ");
        sbc.append("    and tip_codigo  = '"+f.getTip_codigo1() + "' ");
        sbc.append("    and tit_codigo  = '"+f.getTit_codigo1() + "' ");
        int cli_cdgo = Integer.parseInt(query.retorna(sbc.toString()));

        StringBuilder sbs = new StringBuilder();
        sbs.append(" SELECT esc_seqn");
        sbs.append("   FROM titulos ");
        sbs.append("  where emp_empresa = '"+f.getEmp_empresa2() + "' ");
        sbs.append("    and fil_filial  = '"+f.getFil_filial1() + "' ");
        sbs.append("    and tip_codigo  = '"+f.getTip_codigo1() + "' ");
        sbs.append("    and tit_codigo  = '"+f.getTit_codigo1() + "' ");
        int esc_seqn = Integer.parseInt(query.retorna(sbs.toString()));

        StringBuilder sbd = new StringBuilder();
        sbd.append(" SELECT 'Impressao duplicatas BRPortal / ' || DECODE(t.tien_tipo, NULL, '', ('Tipo: ' || t.tien_tipo || ' (' || e.enne_descricao || ')')) || ' / Usuário: ' || u.usua_usuario || ' / Código: ' || e.enne_chave ");
        sbd.append("   FROM wbrio.tipos_entidade_negocio t ");
        sbd.append("       ,wbrio.entidades_negocio e ");
        sbd.append("       ,wbrio.usuarios u ");
        sbd.append("  WHERE t.tien_id(+) = e.enne_tien_id ");
        sbd.append("    AND e.enne_id(+) = u.usua_enne_id ");
        sbd.append("    AND u.usua_usuario = '"+sessao.getUsuario() + "' ");
        String descricao = query.retorna(sbd.toString());

        java.sql.CallableStatement call2 = null;
        try {
          call2 = j.getConn().prepareCall("{ call pck_ctr_gera_trn_tit.prc_ctr_ins_observa(?,?,?,?,'OBS',sysdate,?,?,?,?,?,54,?) }");
          call2.registerOutParameter(10, java.sql.Types.VARCHAR);
          call2.setString(1, f.getEmp_empresa2());
          call2.setString(2, f.getFil_filial1());
          call2.setString(3, f.getTip_codigo1());
          call2.setString(4, f.getTit_codigo1());
          call2.setInt(5, sequencia);
          call2.setInt(6, cli_cdgo);
          call2.setInt(7, esc_seqn);
          call2.setDouble(8, com.egen.util.text.FormatNumber.toDouble(f.getTit_valor()));
          call2.setString(9, descricao);
          call2.execute();
          String result2 = call2.getString(10);
        } catch (Exception e) {
          e.printStackTrace(System.out);
        } finally {
          call2.close();
        }

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

    util.file.GeraPDF g = new util.file.GeraPDF(request);
    g.setRelatorio("BoletoBB.jasper");
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
      ImpressaoDuplicatas_rActionForm[]_ge_grid_array = (ImpressaoDuplicatas_rActionForm[])_ge_grid.get("bl_form_Jw_t_titulos_lista_lines");
      ImpressaoDuplicatas_rActionForm f = _ge_grid_array[0];


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
      ImpressaoDuplicatas_rActionForm[]_ge_grid_array = (ImpressaoDuplicatas_rActionForm[])_ge_grid.get("bl_form_Jw_t_titulos_lista_lines");
      if (_ge_grid_array != null) {
        ImpressaoDuplicatas_rActionForm f = null;
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
      ImpressaoDuplicatas_rActionForm[]_ge_grid_array = (ImpressaoDuplicatas_rActionForm[])_ge_grid.get("bl_form_Jw_t_titulos_lista_lines");
      ImpressaoDuplicatas_rActionForm f = _ge_grid_array[0];


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
      ImpressaoDuplicatas_rActionForm[]_ge_grid_array = (ImpressaoDuplicatas_rActionForm[])_ge_grid.get("bl_form_Jw_t_titulos_lista_lines");
      if (_ge_grid_array != null) {
        ImpressaoDuplicatas_rActionForm f = null;
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
      actionForward = new ActionForward("/adm/ImpressaoDuplicatas_rGrid.do?select1_action=", true);
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
    ImpressaoDuplicatas_rActionForm f = (ImpressaoDuplicatas_rActionForm) form;
    String esc = "null";
    String situacao = "null";
    String data_vencimento = "null";
    String emp_empresa = "null";
    util.consultas.Query q = new util.consultas.Query();

    if (f.getEsc_seqn() != "") {
      esc = f.getEsc_seqn();
    }

    if (f.getDt_venc().equals("null") || f.getDt_venc().equals("")) {
      data_vencimento = "null";
    } else {
      data_vencimento = "'"+f.getDt_venc() + "'";
    }

    if (f.getEmp_empresa() != "") {
      emp_empresa = "'"+f.getEmp_empresa() + "'";
    }

    if (f.getSituacao() != "") {
      situacao = "'"+f.getSituacao() + "'";
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
    query.append(" SELECT trunc(tit_datvenc) + 3 tit_datven3 ");
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
    //---------------------
    query.append("      , fct_formata_cnpj(e.esc_cgc) cnpj ");
    query.append("      , e.esc_cgc cnpj_sem_formato ");
    //---------------------
    query.append("   FROM titulos t ");
    query.append("      , situacoes_dos_titulos sit ");
    query.append("      , portadores p ");
    query.append("      , regionais_vendas reg ");
    query.append("      , rep r ");
    query.append("      , esc e ");
    query.append("  WHERE t.emp_empresa                   = nvl("+emp_empresa + ", t.emp_empresa) ");
    //---------------------
    query.append("    AND e.cli_cdgo = t.cli_codigo ");
    query.append("    AND e.esc_seqn = t.esc_seqn ");
    //---------------------
    query.append("    AND p.prt_codigo                 (+) = t.prt_codigo ");
    query.append("    AND nvl(T.tip_codigo,null)      in ('DUP','NTP','NTC','NTS','NTD') ");
    query.append("    AND cli_codigo                       = ").append(f.getCli_cdgo());
    query.append("    AND t.esc_seqn            =  nvl(").append(esc).append(",t.esc_seqn) ");
    query.append("    AND tit_datvenc                     >= decode(to_date(").append(data_vencimento).append(",'dd/mm/yyyy'),null,tit_datvenc,to_date(").append(data_vencimento).append(",'dd/mm/yyyy')) ");
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
    query.append("    AND nvl(t.prt_codigo,null) = '001' ");
    query.append("    AND trunc(t.tit_datvenc) >= trunc(sysdate)-4 ");
    query.append("    AND t.tit_numbco is not null ");
    query.append("  ORDER BY tit_datvenc ");
    query.append("         , tit_status ");

    if (false) {
      throw new Exception(query.toString());
    }

    portalbr.dbobj.view.Jw_t_titulos_lista table = new portalbr.dbobj.view.Jw_t_titulos_lista();
    Vector res_Jw_t_titulos_lista = j.select(table, query.toString(), null);


    session.setAttribute("res_Jw_t_titulos_lista",res_Jw_t_titulos_lista);
    //xxx  session.setAttribute("cnpj_do_cliente",retornaCNPJ(f.getCli_cdgo(),esc.toString()));

    if (res_Jw_t_titulos_lista != null && res_Jw_t_titulos_lista.size() > 0) {
      for (int x = 0; x < res_Jw_t_titulos_lista.size(); x++) {
        portalbr.dbobj.view.Jw_t_titulos_lista r = (portalbr.dbobj.view.Jw_t_titulos_lista) res_Jw_t_titulos_lista.elementAt(x);
        //------------- verifica nota credito -----------
        portalbr.dbobj.view.Jw_t_verifica_nota_credito table_verifica_nota_credito = new portalbr.dbobj.view.Jw_t_verifica_nota_credito();
        StringBuilder query1 = new StringBuilder();
        query1.append(" SELECT decode(trn_codigo,'NCC','NCC',' ') ncc ");
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
        query2.append(" SELECT nf.nsa_numero                   nota    ");
        query2.append("      , nf.nsa_serie                    serie   ");
        query2.append("      , nf.fil_filial                   filial  ");
        query2.append("      , nfs.ped_nmro                            ");
        query2.append("      , nvl(p.ped_nmro,0)               pedido  ");
        query2.append("   FROM tit_nf                          nf      ");
        query2.append("      , notas_fiscais_saida_ped_venda   nfs     ");
        query2.append("      , ped                             p       ");
        query2.append("  WHERE nf.emp_empresa = nfs.emp_empresa        ");
        query2.append("    AND nf.fil_filial  = nfs.fil_filial         ");
        query2.append("    AND nfs.nfs_nmro   = nf.nsa_numero          ");
        query2.append("    AND nfs.nfs_serie  = nf.nsa_serie           ");
        query2.append("    AND p.ped_nmro (+) = nfs.ped_nmro           ");
        query2.append("    AND nf.emp_empresa = '").append(r.getEmp_empresa()).append("' ");
        query2.append("    AND nf.fil_filial  = '").append(r.getFil_filial()).append("'  ");
        query2.append("    AND nf.tip_codigo  = '").append(r.getTip_codigo()).append("'  ");
        query2.append("    AND nf.tit_codigo  = '").append(r.getTit_codigo()).append("'  ");

        Vector res_Jw_t_nota_titulo = j.select(table_nota_titulo, query2.toString(), null);

        if (res_Jw_t_nota_titulo != null && res_Jw_t_nota_titulo.size() > 0) {
          portalbr.dbobj.view.Jw_t_nota_titulo r3 = (portalbr.dbobj.view.Jw_t_nota_titulo) res_Jw_t_nota_titulo.elementAt(0);
          r.setNota(r3.getNota() + "");
          r.setSerie(r3.getSerie() + "");
          r.setPed_nmro(r3.getPed_nmro() + "");
          r.setPedido(r3.getPedido() + "");
        }


        if ((r.getTit_status() + "").equals("Aberto")) {

          //--------- taxa juro --------------------
          r.setTaxa_juro(taxa);
          //----------------------------------------

          //---------- busca dis -------------------
          portalbr.dbobj.view.Jw_t_busca_dis table_busca_dis = new portalbr.dbobj.view.Jw_t_busca_dis();
          StringBuilder query3 = new StringBuilder();
          query3.append(" SELECT mov_data     dat ");
          query3.append("      , trn_codigo   trn ");
          query3.append("   FROM mov_receber  ");
          query3.append("  WHERE emp_empresa = '").append(r.getEmp_empresa()).append("' ");
          query3.append("    AND fil_filial  = '").append(r.getFil_filial()).append("' ");
          query3.append("    AND tip_codigo  = '").append(r.getTip_codigo()).append("' ");
          query3.append("    AND tit_codigo  = '").append(r.getTit_codigo()).append("' ");
          query3.append("    AND trn_codigo  = 'DIS' ");
          query3.append("    AND nvl(mov_sequencia,0)=0 ");
          query3.append("    AND rownum = 1 ");

          Vector res_Jw_t_busca_dis = j.select(table_busca_dis, query3.toString(), null);

          if (res_Jw_t_busca_dis != null && res_Jw_t_busca_dis.size() > 0) {
            portalbr.dbobj.view.Jw_t_busca_dis r5 = (portalbr.dbobj.view.Jw_t_busca_dis) res_Jw_t_busca_dis.elementAt(0);
            r.setMov_data(r5.getDat());
            r.setTrn_codigo(r5.getTrn() + "");
          } else {

            // -------- Transação ------
            portalbr.dbobj.view.Jw_t_transacao table_transacao = new portalbr.dbobj.view.Jw_t_transacao();
            StringBuilder query4 = new StringBuilder();
            query4.append(" SELECT trn_codigo trn ");
            query4.append("      , mov_data dat ");
            query4.append("   FROM mov_receber ");
            query4.append("  WHERE emp_empresa = '").append(r.getEmp_empresa()).append("' ");
            query4.append("    AND fil_filial  = '").append(r.getFil_filial()).append("' ");
            query4.append("    AND tip_codigo  = '").append(r.getTip_codigo()).append("' ");
            query4.append("    AND tit_codigo  = '").append(r.getTit_codigo()).append("' ");
            query4.append("  ORDER BY mov_data ");

            Vector res_Jw_t_transacao = j.select(table_transacao, query4.toString(), null);

            if (res_Jw_t_transacao != null && res_Jw_t_transacao.size() > 0) {
              portalbr.dbobj.view.Jw_t_transacao r6 = (portalbr.dbobj.view.Jw_t_transacao) res_Jw_t_transacao.elementAt(0);
              r.setMov_data(r6.getDat());
              r.setTrn_codigo(r6.getTrn() + "");
            }
          }

          //------- venc orig ----------
          portalbr.dbobj.view.Jw_t_venc_orig table_venc_orig = new portalbr.dbobj.view.Jw_t_venc_orig();
          StringBuilder query5 = new StringBuilder();
          query5.append(" SELECT mov_datvenc  md ");
          query5.append("      , mov_cobjur   mc ");
          query5.append("      , mov_condes   mo ");
          query5.append("   FROM mov_receber ");
          query5.append("  WHERE emp_empresa = '").append(r.getEmp_empresa()).append("' ");
          query5.append("    AND fil_filial  = '").append(r.getFil_filial()).append("' ");
          query5.append("    AND tip_codigo  = '").append(r.getTip_codigo()).append("' ");
          query5.append("    AND tit_codigo  = '").append(r.getTit_codigo()).append("' ");
          query5.append("    AND trn_codigo  = 'VCT' ");

          Vector res_Jw_t_venc_orig = j.select(table_venc_orig, query5.toString(), null);

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
          query6.append(" SELECT mov_valor mv ");
          query6.append("   FROM mov_receber ");
          query6.append("  WHERE nvl(emp_empresa,null) = '").append(r.getEmp_empresa()).append("' ");
          query6.append("    AND nvl(fil_filial,null)  = '").append(r.getFil_filial()).append("' ");
          query6.append("    AND nvl(tip_codigo,null)  = '").append(r.getTip_codigo()).append("' ");
          query6.append("    AND nvl(trn_codigo,null)  = 'NCC' ");
          query6.append("    AND tit_codigo            = '").append(r.getTit_codigo()).append("' ");

          Vector res_Jw_t_proc_ncc = j.select(table_proc_ncc, query6.toString(), null);

          if (res_Jw_t_proc_ncc != null && res_Jw_t_proc_ncc.size() > 0) {
            portalbr.dbobj.view.Jw_t_proc_ncc r8 = (portalbr.dbobj.view.Jw_t_proc_ncc) res_Jw_t_proc_ncc.elementAt(0);
            r.setTit_abatim(r8.getMv() + "");
          }


          //----------- desp_pro -------------
          portalbr.dbobj.view.Jw_t_desp_pro table_desp_pro = new portalbr.dbobj.view.Jw_t_desp_pro();
          StringBuilder query7 = new StringBuilder();
          query7.append(" SELECT mov_valor mv ");
          query7.append("   FROM mov_receber ");
          query7.append("  WHERE nvl(emp_empresa,null) = '").append(r.getEmp_empresa()).append("' ");
          query7.append("    AND nvl(fil_filial,null)  = '").append(r.getFil_filial()).append("' ");
          query7.append("    AND nvl(tip_codigo,null)  = '").append(r.getTip_codigo()).append("' ");
          query7.append("    AND nvl(trn_codigo,null)  = 'PRO' ");
          query7.append("    AND tit_codigo            = '").append(r.getTit_codigo()).append("' ");

          Vector res_Jw_t_desp_pro = j.select(table_desp_pro, query7.toString(), null);
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
