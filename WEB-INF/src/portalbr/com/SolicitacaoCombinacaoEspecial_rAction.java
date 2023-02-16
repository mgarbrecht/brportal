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
 * Creation Date 03/02/2012 15:14:29
 * Last Modify Date 06/10/2020 17:25:25
 */

public class SolicitacaoCombinacaoEspecial_rAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_marca_todos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      SolicitacaoCombinacaoEspecial_rActionForm[]_ge_grid_array = (SolicitacaoCombinacaoEspecial_rActionForm[])_ge_grid.get("bl_form_Jw_ref_combinacao_especial_lines");
      SolicitacaoCombinacaoEspecial_rActionForm f = _ge_grid_array[0];


      try {
        tg_marca_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_combinacao_especial", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void tg_marca_todos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      DynaActionForm _ge_grid = (DynaActionForm) form;
      SolicitacaoCombinacaoEspecial_rActionForm[]_ge_grid_array = (SolicitacaoCombinacaoEspecial_rActionForm[])_ge_grid.get("bl_form_Jw_ref_combinacao_especial_lines");
      if (_ge_grid_array != null) {
        SolicitacaoCombinacaoEspecial_rActionForm f = null;
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

  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      SolicitacaoCombinacaoEspecial_rActionForm[]_ge_grid_array = (SolicitacaoCombinacaoEspecial_rActionForm[])_ge_grid.get("bl_form_Jw_ref_combinacao_especial_lines");
      SolicitacaoCombinacaoEspecial_rActionForm f = _ge_grid_array[0];
      try {
        update_action(j, mapping, form, request, response);
      }
      finally {
      }

      Jw_ref_combinacao_especial table = new Jw_ref_combinacao_especial();
      Vector res_Jw_ref_combinacao_especial = j.select(table, (String) session.getAttribute("where"), null);
      session.setAttribute("res_Jw_ref_combinacao_especial",res_Jw_ref_combinacao_especial);
      actionForward = new ActionForward("/com/SolicitacaoCombinacaoEspecial_rGrid.do?select_action=",true);

    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_combinacao_especial", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    StringBuilder sb = new StringBuilder();
    java.sql.CallableStatement call = null;
    SolicitacaoCombinacaoEspecial_rActionForm[]_ge_grid_array = (SolicitacaoCombinacaoEspecial_rActionForm[])_ge_grid.get("bl_form_Jw_ref_combinacao_especial_lines");
    SolicitacaoCombinacaoEspecial_rActionForm f = _ge_grid_array[0];
    String situacao = (String) session.getAttribute("situacao");
    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (f != null) {
      boolean adicionou = false;
      util.consultas.Query queryUtil = new util.consultas.Query();
      sb.append("BEGIN");
      sb.append("  pck_ref_combinacao_especial.inicializa_email_solicitacao();");
      for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
        f = _ge_grid_array[_ge_grid_array_index];
        if (f.getGridCheckField()) {
          queryUtil.execute("UPDATE REF_COMBINACAO_ESPECIAL SET SITUACAO_SOLICITACAO = '" + session.getAttribute("situacao") + "' WHERE ID_SOLICITACAO = " + f.getId_solicitacao());
          if (f.getSituacao_solicitacao().equals("I") && f.getTipo_solicitacao_comb_especial().equals("5")) {
            sb.append("  pck_ref_combinacao_especial.add_item_email_solicitacao(").append(f.getId_solicitacao()).append(");");
            adicionou = true;
          }
        }
      }
      sb.append("  pck_ref_combinacao_especial.envia_email_solicitacao('").append(usuario.getUsuario()).append("','").append(situacao).append("');");
      sb.append("END;");
      if (adicionou) {
        call = j.getConn().prepareCall(sb.toString());
        call.execute();
        call.close();
      }
      util.consultas.com.SolicitacaoCombinacaoEspecial s = new util.consultas.com.SolicitacaoCombinacaoEspecial();
      s.enviarEmail(form, request, null, null);
    }
  }



  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      DynaActionForm _ge_grid = (DynaActionForm) form;
      SolicitacaoCombinacaoEspecial_rActionForm[]_ge_grid_array = (SolicitacaoCombinacaoEspecial_rActionForm[])_ge_grid.get("bl_form_Jw_ref_combinacao_especial_lines");
      SolicitacaoCombinacaoEspecial_rActionForm f = _ge_grid_array[0];
      session.removeAttribute("res_Jw_ref_combinacao_especial");
      com.egen.util.struts.AbstractActionHelper.resetForm("bl_form_Jw_ref_combinacao_especial_lines", mapping, form, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_combinacao_especial", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      SolicitacaoCombinacaoEspecial_rActionForm[]_ge_grid_array = (SolicitacaoCombinacaoEspecial_rActionForm[])_ge_grid.get("bl_form_Jw_ref_combinacao_especial_lines");
      SolicitacaoCombinacaoEspecial_rActionForm f = _ge_grid_array[0];
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_combinacao_especial", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    SolicitacaoCombinacaoEspecial_rActionForm[]_ge_grid_array = (SolicitacaoCombinacaoEspecial_rActionForm[])_ge_grid.get("bl_form_Jw_ref_combinacao_especial_lines");
    SolicitacaoCombinacaoEspecial_rActionForm f = _ge_grid_array[0];
    if (f != null) {
      Jw_ref_combinacao_especial table = new Jw_ref_combinacao_especial();

      Vector res_Jw_ref_combinacao_especial = (java.util.Vector) session.getAttribute("res_Jw_ref_combinacao_especial");
      session.setAttribute("res_Jw_ref_combinacao_especial",res_Jw_ref_combinacao_especial);
      if (res_Jw_ref_combinacao_especial != null && res_Jw_ref_combinacao_especial.size() > 0) {
        SolicitacaoCombinacaoEspecial_rActionForm[]_ge_grid_array_flex = new SolicitacaoCombinacaoEspecial_rActionForm[res_Jw_ref_combinacao_especial.size()];
        org.apache.struts.config.ConfigEGenHelper.setFormPropertySize(mapping, "bl_form_Jw_ref_combinacao_especial_lines", res_Jw_ref_combinacao_especial.size());
        int _ge_pos = 0;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array_flex.length; _ge_grid_array_index++, _ge_pos++) {
          if (_ge_grid_array_index < _ge_grid_array.length) {
            f = _ge_grid_array[_ge_grid_array_index];
          } else {
            f = new SolicitacaoCombinacaoEspecial_rActionForm();
            ActionServletWrapper actionServletWrapper = form.getServletWrapper();
            org.apache.struts.upload.CommonsMultipartRequestHandler commonsMultipartRequestHandler = new org.apache.struts.upload.CommonsMultipartRequestHandler();
            actionServletWrapper.setServletFor(commonsMultipartRequestHandler);
            f.setServlet(commonsMultipartRequestHandler.getServlet());
          }
          f.reset(mapping, request);
          if (res_Jw_ref_combinacao_especial.size() > _ge_pos) {
            Jw_ref_combinacao_especial r = (Jw_ref_combinacao_especial) res_Jw_ref_combinacao_especial.elementAt(_ge_pos);
            f.setId_solicitacao((r.getId_solicitacao() != null) ? r.getId_solicitacao() + "":"");
            f.setImagem((r.getImagem() != null) ? r.getImagem() + "":"");
            f.setData_solicitacao(com.egen.util.text.FormatDate.format(r.getData_solicitacao(), "dd/MM/yyyy HH:mm:ss"));
            f.setNome_marca((r.getNome_marca() != null) ? r.getNome_marca() + "":"");
            f.setRegional((r.getRegional() != null) ? r.getRegional() + "":"");
            f.setMaterial((r.getMaterial() != null) ? r.getMaterial() + "":"");
            f.setLin_cdgo((r.getLin_cdgo() != null) ? r.getLin_cdgo() + "":"");
            f.setRef_cdgo((r.getRef_cdgo() != null) ? r.getRef_cdgo() + "":"");
            f.setCab_cdgo((r.getCab_cdgo() != null) ? r.getCab_cdgo() + "":"");
            f.setCor_cdgo((r.getCor_cdgo() != null) ? r.getCor_cdgo() + "":"");
            f.setCliente_grupo_economico((r.getCliente_grupo_economico() != null) ? r.getCliente_grupo_economico() + "":"");
            f.setPares_alteracao((r.getPares_alteracao() != null) ? r.getPares_alteracao() + "":"");
            f.setPares_vendidos((r.getPares_vendidos() != null) ? r.getPares_vendidos() + "":"");
            f.setSituacao_solicitacao((r.getSituacao_solicitacao() != null) ? r.getSituacao_solicitacao() + "":"");
            f.setSituacao_solicitacao_desc((r.getSituacao_solicitacao_desc() != null) ? r.getSituacao_solicitacao_desc() + "":"");
            f.setData_aprovacao(com.egen.util.text.FormatDate.format(r.getData_aprovacao(), "dd/MM/yyyy HH:mm:ss"));
            f.setPreco_liguido((r.getPreco_liguido() != null) ? r.getPreco_liguido() + "":"");
            f.setLl_alteracao_solicitada((r.getLl_alteracao_solicitada() != null) ? r.getLl_alteracao_solicitada() + "":"");
            f.setTipo_solicitacao_comb_especial((r.getTipo_solicitacao_comb_especial() != null) ? r.getTipo_solicitacao_comb_especial() + "":"");
            f.setDesc_solicitacao_comb_especial((r.getDesc_solicitacao_comb_especial() != null) ? r.getDesc_solicitacao_comb_especial() + "":"");
            f.setSubtipo_solicitacao_comb_espec((r.getSubtipo_solicitacao_comb_espec() != null) ? r.getSubtipo_solicitacao_comb_espec() + "":"");
            f.setDesc_subtipo_comb_espec((r.getDesc_subtipo_comb_espec() != null) ? r.getDesc_subtipo_comb_espec() + "":"");
          } else {
            f.reset(mapping, request);
          }
          _ge_grid_array_flex[_ge_grid_array_index] = f;
        }
        _ge_grid.set("bl_form_Jw_ref_combinacao_especial_lines", _ge_grid_array_flex);
      } else {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_combinacao_especial", new ActionMessage("warn.norowsselected",""));
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      }
      session.setAttribute(mapping.getName(), form);
    }
  }

  public ActionForward perform_desmarcar_todos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      SolicitacaoCombinacaoEspecial_rActionForm[]_ge_grid_array = (SolicitacaoCombinacaoEspecial_rActionForm[])_ge_grid.get("bl_form_Jw_ref_combinacao_especial_lines");
      SolicitacaoCombinacaoEspecial_rActionForm f = _ge_grid_array[0];


      try {
        tg_desmarcar_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_combinacao_especial", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      SolicitacaoCombinacaoEspecial_rActionForm[]_ge_grid_array = (SolicitacaoCombinacaoEspecial_rActionForm[])_ge_grid.get("bl_form_Jw_ref_combinacao_especial_lines");
      if (_ge_grid_array != null) {
        SolicitacaoCombinacaoEspecial_rActionForm f = null;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
          f = _ge_grid_array[_ge_grid_array_index];
          f.setGridCheckField(false);
        }
      }
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    }
  }

  public ActionForward perform_gerar_relatorio_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    DynaActionForm _ge_grid = (DynaActionForm) form;
    SolicitacaoCombinacaoEspecial_rActionForm[]_ge_grid_array = (SolicitacaoCombinacaoEspecial_rActionForm[])_ge_grid.get("bl_form_Jw_ref_combinacao_especial_lines");
    SolicitacaoCombinacaoEspecial_rActionForm f = _ge_grid_array[0];
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    String p_lista_ids = null;

    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];

      if (f.getGridCheckField()) {
        if (p_lista_ids != null) {
          p_lista_ids = p_lista_ids + "," + f.getId_solicitacao();
        } else {
          p_lista_ids = f.getId_solicitacao();
        }
      }
    }
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      //--------------------------------------------------------------------------
      util.file.GeraPDF g = new util.file.GeraPDF(request);
      g.setRelatorio("SolicitacaoEspecial.jasper");
      g.setParametro("P_ID_SOLICITACAO", p_lista_ids);
      g.gerar();
      request.setAttribute("abre_automaticamente","N");
      //--------------------------------------------------------------------------
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      e.printStackTrace(System.err);
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_combinacao_especial", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      SolicitacaoCombinacaoEspecial_rActionForm f = (SolicitacaoCombinacaoEspecial_rActionForm) form;


      actionForward = new ActionForward("/com/SolicitacaoCombinacaoEspecialForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  public ActionForward perform_sessao_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;

    try {
      SolicitacaoCombinacaoEspecial_rActionForm f = (SolicitacaoCombinacaoEspecial_rActionForm) form;
      session.setAttribute("situacao", f.getSituacao_solicitacao1());


      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {

    }
    return actionForward;
  }
}
