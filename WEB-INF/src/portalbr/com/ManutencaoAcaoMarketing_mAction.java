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
 * Creation Date 24/11/2010 06:26:08
 * Last Modify Date 02/04/2013 15:24:37
 */

public class ManutencaoAcaoMarketing_mAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ManutencaoAcaoMarketing_mActionForm f = (ManutencaoAcaoMarketing_mActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      if (((String) session.getAttribute("mostra")).equals("n")) {
        actionForward = mapping.findForward("same");
      } else {
        actionForward = new ActionForward("/com/ManutencaoAcaoMarketing_mGrid.do?select1_action=",true);
      }
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acao_marketing", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    ManutencaoAcaoMarketing_mActionForm f = (ManutencaoAcaoMarketing_mActionForm) form;
    if ((f.getAcoes().equals("")) && (f.getAcao_inicial().equals("") || f.getAcao_final().equals(""))) {
      throw new Exception("Um dos parâmetros deve ser informado!");
    }
    Jw_acao_marketing table = new Jw_acao_marketing();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"acao",">=",f.getAcao_inicial()}, {"acao","<=",f.getAcao_final()}, {"acao","in",f.getAcoes()}, {"situacao","<>","1"} };
    session.setAttribute("where_acao_marketing", where);
    Vector res_Jw_acao_marketing = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Jw_acao_marketing",res_Jw_acao_marketing);
    session.setAttribute("mostra","n");
    if (res_Jw_acao_marketing != null && res_Jw_acao_marketing.size() > 0) {
      session.setAttribute("mostra","s");
      Jw_acao_marketing r = (Jw_acao_marketing) res_Jw_acao_marketing.elementAt(0);
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acao_marketing", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ManutencaoAcaoMarketing_mActionForm f = (ManutencaoAcaoMarketing_mActionForm) form;
      session.removeAttribute("res_Jw_acao_marketing");
      session.removeAttribute("mostra");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acao_marketing", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_resetfull_ok_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ManutencaoAcaoMarketing_mActionForm f = (ManutencaoAcaoMarketing_mActionForm) form;
      session.removeAttribute("res_Jw_acao_marketing");
      form.reset(mapping, request);
      session.removeAttribute("ok");
      session.removeAttribute("mostra");
      session.setAttribute(mapping.getName(), form);
      tg_resetfull_ok_action(mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acao_marketing", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
  private void tg_resetfull_ok_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acao_marketing", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

  public ActionForward perform_select1_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ManutencaoAcaoMarketing_mActionForm[]_ge_grid_array = (ManutencaoAcaoMarketing_mActionForm[])_ge_grid.get("bl_form_Jw_acao_marketing_1_lines");
      ManutencaoAcaoMarketing_mActionForm f = _ge_grid_array[0];
      try {
        select1_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acao_marketing_1", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    ManutencaoAcaoMarketing_mActionForm[]_ge_grid_array = (ManutencaoAcaoMarketing_mActionForm[])_ge_grid.get("bl_form_Jw_acao_marketing_1_lines");
    ManutencaoAcaoMarketing_mActionForm f = _ge_grid_array[0];
    util.consultas.Query query = new util.consultas.Query();
    if (f != null) {
      Jw_acao_marketing table = new Jw_acao_marketing();
      String[][] select = null;
      String[] order = null;
      String[] groupby = null;
      String[] having = null;
      Object[][] where = (Object[][]) session.getAttribute("where_acao_marketing");
      Vector res_Jw_acao_marketing = j.select(table, select, where, groupby, having, order);
      session.setAttribute("res_Jw_acao_marketing",res_Jw_acao_marketing);
      if (res_Jw_acao_marketing != null && res_Jw_acao_marketing.size() > 0) {
        ManutencaoAcaoMarketing_mActionForm[]_ge_grid_array_flex = new ManutencaoAcaoMarketing_mActionForm[res_Jw_acao_marketing.size()];
        org.apache.struts.config.ConfigEGenHelper.setFormPropertySize(mapping, "bl_form_Jw_acao_marketing_1_lines", res_Jw_acao_marketing.size());
        int _ge_pos = 0;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array_flex.length; _ge_grid_array_index++, _ge_pos++) {
          if (_ge_grid_array_index < _ge_grid_array.length) {
            f = _ge_grid_array[_ge_grid_array_index];
          } else {
            f = new ManutencaoAcaoMarketing_mActionForm();
            ActionServletWrapper actionServletWrapper = form.getServletWrapper();
            org.apache.struts.upload.CommonsMultipartRequestHandler commonsMultipartRequestHandler = new org.apache.struts.upload.CommonsMultipartRequestHandler();
            actionServletWrapper.setServletFor(commonsMultipartRequestHandler);
            f.setServlet(commonsMultipartRequestHandler.getServlet());
          }
          f.reset(mapping, request);
          if (res_Jw_acao_marketing.size() > _ge_pos) {
            Jw_acao_marketing r = (Jw_acao_marketing) res_Jw_acao_marketing.elementAt(_ge_pos);
            f.setData_entrega(com.egen.util.text.FormatDate.format(r.getData_entrega()));
            f.setData_entrada(com.egen.util.text.FormatDate.format(r.getData_entrada()));
            f.setAcao(r.getAcao() + "");
            f.setDesc_material((r.getDesc_material() != null) ? r.getDesc_material() + "":"");
            f.setSituacao(query.retorna(j, "SELECT descricao FROM acao_marketing_situacoes WHERE codigo = "+r.getSituacao()));
            f.setObservacao((r.getObservacao() != null) ? r.getObservacao() + "":"");
            f.setCracha_usuario(r.getCracha_usuario() + "");
            f.setNome_regional((r.getNome_regional() != null) ? r.getNome_regional() + "":"");
            f.setEmail((r.getEmail() != null) ? r.getEmail() + "":"");
            f.setDescricao_marca((r.getDescricao_marca() != null) ? r.getDescricao_marca() + "":"");
          } else {
            f.reset(mapping, request);
          }
          _ge_grid_array_flex[_ge_grid_array_index] = f;
        }
        _ge_grid.set("bl_form_Jw_acao_marketing_1_lines", _ge_grid_array_flex);
      } else {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acao_marketing_1", new ActionMessage("warn.norowsselected",""));
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      }
      session.setAttribute(mapping.getName(), form);
    }
  }
  public ActionForward perform_marcar_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ManutencaoAcaoMarketing_mActionForm[]_ge_grid_array = (ManutencaoAcaoMarketing_mActionForm[])_ge_grid.get("bl_form_Jw_acao_marketing_1_lines");
      ManutencaoAcaoMarketing_mActionForm f = _ge_grid_array[0];
      marcar_action(mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acao_marketing_1", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
  private void marcar_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    DynaActionForm _ge_grid = (DynaActionForm) form;
    ManutencaoAcaoMarketing_mActionForm[]_ge_grid_array = (ManutencaoAcaoMarketing_mActionForm[])_ge_grid.get("bl_form_Jw_acao_marketing_1_lines");
    ManutencaoAcaoMarketing_mActionForm f = _ge_grid_array[0];
    int _ge_pos = 0;
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      f.setGridCheckField(true);
    }
  }
  public ActionForward perform_desmarcar_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ManutencaoAcaoMarketing_mActionForm[]_ge_grid_array = (ManutencaoAcaoMarketing_mActionForm[])_ge_grid.get("bl_form_Jw_acao_marketing_1_lines");
      ManutencaoAcaoMarketing_mActionForm f = _ge_grid_array[0];
      desmarcar_action(mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acao_marketing_1", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
  private void desmarcar_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    DynaActionForm _ge_grid = (DynaActionForm) form;
    ManutencaoAcaoMarketing_mActionForm[]_ge_grid_array = (ManutencaoAcaoMarketing_mActionForm[])_ge_grid.get("bl_form_Jw_acao_marketing_1_lines");
    ManutencaoAcaoMarketing_mActionForm f = _ge_grid_array[0];
    int _ge_pos = 0;
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      f.setGridCheckField(false);
    }
  }
  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      ManutencaoAcaoMarketing_mActionForm[]_ge_grid_array = (ManutencaoAcaoMarketing_mActionForm[])_ge_grid.get("bl_form_Jw_acao_marketing_1_lines");
      ManutencaoAcaoMarketing_mActionForm f = _ge_grid_array[0];
      try {
        update_action(j, mapping, form, request, response);
      }
      finally {
      }

      if (((String) session.getAttribute("ok") + "").equals("s")) {
        actionForward = new ActionForward("/com/ManutencaoAcaoMarketing_mForm.do?resetfull_ok_action=",true);
      } else {
        actionForward = mapping.findForward("same");
      }
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acao_marketing_1", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    util.consultas.Query query = new util.consultas.Query();
    DynaActionForm _ge_grid = (DynaActionForm) form;
    ManutencaoAcaoMarketing_mActionForm[]_ge_grid_array = (ManutencaoAcaoMarketing_mActionForm[])_ge_grid.get("bl_form_Jw_acao_marketing_1_lines");
    ManutencaoAcaoMarketing_mActionForm f = _ge_grid_array[0];
    acesso.Sessao se = new acesso.Sessao(session);
    String chave = null;
    String tipo = se.getTipoEntidadeNegocio();
    if (tipo.equals("AREAS")) {
      chave = se.getUsuario();
    }
    String descricaoSituacaoNova = query.retorna("SELECT descricao FROM acao_marketing_situacoes WHERE codigo = 10");
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      if (f.getGridCheckField()) {
        //---- Cadastra novo evento ---------------------
        java.sql.PreparedStatement pstm = null;
        java.sql.ResultSet rset = null;
        try {
          StringBuilder sb = new StringBuilder();
          sb.append("INSERT INTO acao_marketing_eventos ");
          sb.append(" VALUES ( "+f.getAcao());
          sb.append("        , (SELECT nvl(MAX(seq_evento),0) + 1 FROM acao_marketing_eventos WHERE seq_acao_mkt = "+f.getAcao() + ") ");
          sb.append("        , '"+f.getEmail() + "'  ");
          sb.append("        , 'Alterado o status de "+f.getSituacao() + " para "+descricaoSituacaoNova + " pela criação' ");
          sb.append("        , trunc(SYSDATE) ");
          sb.append("        , USER ");
          sb.append("        , NULL, NULL, NULL, NULL, "+chave + ") ");
          pstm = j.getConn().prepareStatement(sb.toString());
          pstm.executeUpdate();
        }
        finally {
          if (pstm != null) {
            pstm.close();
          }
        }
        //---- Troca o Status ----------------------------
        Prc_troca_status_acao_mkt rs = new Prc_troca_status_acao_mkt();
        rs.setP_acao_mkt(com.egen.util.text.FormatNumber.parseInt(f.getAcao()));
        rs.setP_status("10");
        rs = (Prc_troca_status_acao_mkt) j.execute(rs);
        session.setAttribute("ok","s");
        //------------------------------------------------
      }
    }
  }
}
