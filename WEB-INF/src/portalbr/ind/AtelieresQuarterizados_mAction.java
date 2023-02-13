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
 * Creation Date 13/01/2015 11:04:53
 * Last Modify Date 23/01/2015 14:34:51
 */

public class AtelieresQuarterizados_mAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      AtelieresQuarterizados_mActionForm f = (AtelieresQuarterizados_mActionForm) form;
      try {
        tg_insert_action(mapping, form, request, response);
        insert_action(j, mapping, form, request, response);
        tg_insert_action_1(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_For_endere_quarterizado", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void insert_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    AtelieresQuarterizados_mActionForm f = (AtelieresQuarterizados_mActionForm) form;
    For_endere_quarterizado table = new For_endere_quarterizado();
    Object[][] name_value = { {"for_codigo",com.egen.util.text.FormatNumber.toInteger(f.getFo_codigo())}, {"for_codigo_quarterizado",com.egen.util.text.FormatNumber.toInteger(f.getFo_codigo_quarterizado())}, {"fen_seq_quarterizado",com.egen.util.text.FormatNumber.toInteger(f.getFen_seq_quarterizado())}, {"for_razsoc",f.getFo_razsoc()}, {"for_fant",f.getFo_fant()}, {"fen_cgc_quarterizado",com.egen.util.text.FormatNumber.toDouble(f.getFen_cgc_quarterizado())}, {"fen_cep_quarterizado",com.egen.util.text.FormatNumber.toInteger(f.getFen_cep_quarterizado())}, {"fen_cidade_quarterizado",f.getFen_cidade_quarterizado()}, {"est_unifed_quarterizado",f.getEst_unifed_quarterizado()}, {"fen_rua_quarterizado",f.getFen_rua_quarterizado()}, {"fen_nro_quarterizado",f.getFen_nro_quarterizado()}, {"fen_compto_quarterizado",f.getFen_compto_quarterizado()}, {"fen_bairro_quarterizado",f.getFen_bairro_quarterizado()}, {"fen_insmun_quarterizado",f.getFen_insmun_quarterizado()}, {"fen_insest_quarterizado",f.getFen_insest_quarterizado()}, {"fen_ativo_quarterizado",f.getFen_ativo_quarterizado()}, {"fen_email_quarterizado",f.getFen_email_quarterizado()}, {"fen_gln_quarterizado",f.getFen_gln_quarterizado()}, {"tipo_log_quarterizado",f.getTipo_log_quarterizado()}, {"fen_observacao_quarterizado",f.getFen_observacao_quarterizado()}, {"dthr_inclusao",com.egen.util.text.FormatDate.parseTimestamp(f.getDthr_inclusao(), "dd/MM/yyyy HH:mm:ss")}, {"dthr_alteracao",com.egen.util.text.FormatDate.parseTimestamp(f.getDthr_alteracao(), "dd/MM/yyyy HH:mm:ss")}, {"usuario_inclusao",f.getUsuario_inclusao()}, {"usuario_alteracao",f.getUsuario_alteracao()}, };
    j.insert(table, name_value);
    Vector res_For_endere_quarterizado2 = (Vector) session.getAttribute("res_For_endere_quarterizado2");
    if (res_For_endere_quarterizado2 != null && table != null) {
      res_For_endere_quarterizado2.addElement(table);
      session.setAttribute("res_For_endere_quarterizado2", res_For_endere_quarterizado2);
    }
    form.reset(mapping, request);
    session.setAttribute(mapping.getName(), form);
  }
  private void tg_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      AtelieresQuarterizados_mActionForm f = (AtelieresQuarterizados_mActionForm) form;
      acesso.Sessao sessao = new acesso.Sessao(session);
      util.consultas.Query query = new util.consultas.Query();
      f.setDthr_inclusao(query.retorna("SELECT to_char(SYSDATE,'dd/mm/yyyy hh24:mi:ss') DATA FROM dual"));
      f.setUsuario_inclusao(sessao.getUsuario());
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    } finally {
    }
  }
  private void tg_insert_action_1(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_For_endere_quarterizado", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      AtelieresQuarterizados_mActionForm f = (AtelieresQuarterizados_mActionForm) form;
      try {
        tg_update_action(mapping, form, request, response);
        update_action(j, mapping, form, request, response);
        tg_update_action_1(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_For_endere_quarterizado", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    AtelieresQuarterizados_mActionForm f = (AtelieresQuarterizados_mActionForm) form;
    For_endere_quarterizado table = new For_endere_quarterizado();
    Vector sets = new Vector(10, 2);
    table.setFor_codigo(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getFo_codigo()));
    if (f.getFo_codigo() != null) {
      sets.addElement("for_codigo");
    }
    table.setFor_codigo_quarterizado(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getFo_codigo_quarterizado()));
    if (f.getFo_codigo_quarterizado() != null) {
      sets.addElement("for_codigo_quarterizado");
    }
    table.setFen_seq_quarterizado(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getFen_seq_quarterizado()));
    if (f.getFen_seq_quarterizado() != null) {
      sets.addElement("fen_seq_quarterizado");
    }
    table.setFor_razsoc(f.getFo_razsoc());
    if (f.getFo_razsoc() != null) {
      sets.addElement("for_razsoc");
    }
    table.setFor_fant(f.getFo_fant());
    if (f.getFo_fant() != null) {
      sets.addElement("for_fant");
    }
    table.setFen_cgc_quarterizado(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getFen_cgc_quarterizado()));
    if (f.getFen_cgc_quarterizado() != null) {
      sets.addElement("fen_cgc_quarterizado");
    }
    table.setFen_cep_quarterizado(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getFen_cep_quarterizado()));
    if (f.getFen_cep_quarterizado() != null) {
      sets.addElement("fen_cep_quarterizado");
    }
    table.setFen_cidade_quarterizado(f.getFen_cidade_quarterizado());
    if (f.getFen_cidade_quarterizado() != null) {
      sets.addElement("fen_cidade_quarterizado");
    }
    table.setEst_unifed_quarterizado(f.getEst_unifed_quarterizado());
    if (f.getEst_unifed_quarterizado() != null) {
      sets.addElement("est_unifed_quarterizado");
    }
    table.setFen_rua_quarterizado(f.getFen_rua_quarterizado());
    if (f.getFen_rua_quarterizado() != null) {
      sets.addElement("fen_rua_quarterizado");
    }
    table.setFen_nro_quarterizado(f.getFen_nro_quarterizado());
    if (f.getFen_nro_quarterizado() != null) {
      sets.addElement("fen_nro_quarterizado");
    }
    table.setFen_compto_quarterizado(f.getFen_compto_quarterizado());
    if (f.getFen_compto_quarterizado() != null) {
      sets.addElement("fen_compto_quarterizado");
    }
    table.setFen_bairro_quarterizado(f.getFen_bairro_quarterizado());
    if (f.getFen_bairro_quarterizado() != null) {
      sets.addElement("fen_bairro_quarterizado");
    }
    table.setFen_insmun_quarterizado(f.getFen_insmun_quarterizado());
    if (f.getFen_insmun_quarterizado() != null) {
      sets.addElement("fen_insmun_quarterizado");
    }
    table.setFen_insest_quarterizado(f.getFen_insest_quarterizado());
    if (f.getFen_insest_quarterizado() != null) {
      sets.addElement("fen_insest_quarterizado");
    }
    table.setFen_ativo_quarterizado(f.getFen_ativo_quarterizado());
    if (f.getFen_ativo_quarterizado() != null) {
      sets.addElement("fen_ativo_quarterizado");
    }
    table.setFen_email_quarterizado(f.getFen_email_quarterizado());
    if (f.getFen_email_quarterizado() != null) {
      sets.addElement("fen_email_quarterizado");
    }
    table.setFen_gln_quarterizado(f.getFen_gln_quarterizado());
    if (f.getFen_gln_quarterizado() != null) {
      sets.addElement("fen_gln_quarterizado");
    }
    table.setTipo_log_quarterizado(f.getTipo_log_quarterizado());
    if (f.getTipo_log_quarterizado() != null) {
      sets.addElement("tipo_log_quarterizado");
    }
    table.setFen_observacao_quarterizado(f.getFen_observacao_quarterizado());
    if (f.getFen_observacao_quarterizado() != null) {
      sets.addElement("fen_observacao_quarterizado");
    }
    table.setDthr_inclusao(com.egen.util.text.FormatDate.parseTimestamp(f.getDthr_inclusao(), "dd/MM/yyyy HH:mm:ss"));
    if (f.getDthr_inclusao() != null) {
      sets.addElement("dthr_inclusao");
    }
    table.setDthr_alteracao(com.egen.util.text.FormatDate.parseTimestamp(f.getDthr_alteracao(), "dd/MM/yyyy HH:mm:ss"));
    if (f.getDthr_alteracao() != null) {
      sets.addElement("dthr_alteracao");
    }
    table.setUsuario_inclusao(f.getUsuario_inclusao());
    if (f.getUsuario_inclusao() != null) {
      sets.addElement("usuario_inclusao");
    }
    table.setUsuario_alteracao(f.getUsuario_alteracao());
    if (f.getUsuario_alteracao() != null) {
      sets.addElement("usuario_alteracao");
    }
    if (sets != null && sets.size() > 0) {
      String[] set = new String[sets.size()];
      for (int i = 0; i < sets.size(); i++) {
        set[i] = (String) sets.elementAt(i);
      }
      int updated = j.update(table, set);
      if (updated == 0) {
        ActionErrors errors = new ActionErrors();
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_For_endere_quarterizado", new ActionMessage("warn.norowsupdated",": " + updated));
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      } else {
        Vector res_For_endere_quarterizado2 = (Vector) session.getAttribute("res_For_endere_quarterizado2");
        if (res_For_endere_quarterizado2 != null) {
          res_For_endere_quarterizado2.setElementAt(table, 0);
          For_endere_quarterizado r = (For_endere_quarterizado) res_For_endere_quarterizado2.elementAt(0);
          f.setFo_codigo((r.getFor_codigo() != null) ? r.getFor_codigo() + "":"");
          f.setFo_codigo_quarterizado((r.getFor_codigo_quarterizado() != null) ? r.getFor_codigo_quarterizado() + "":"");
          f.setFen_seq_quarterizado((r.getFen_seq_quarterizado() != null) ? r.getFen_seq_quarterizado() + "":"");
          f.setFo_razsoc((r.getFor_razsoc() != null) ? r.getFor_razsoc() + "":"");
          f.setFo_fant((r.getFor_fant() != null) ? r.getFor_fant() + "":"");
          f.setFen_cgc_quarterizado((r.getFen_cgc_quarterizado() != null) ? com.egen.util.text.FormatNumber.format(r.getFen_cgc_quarterizado(), "0") : "");
          f.setFen_cep_quarterizado((r.getFen_cep_quarterizado() != null) ? r.getFen_cep_quarterizado() + "":"");
          f.setFen_cidade_quarterizado((r.getFen_cidade_quarterizado() != null) ? r.getFen_cidade_quarterizado() + "":"");
          f.setEst_unifed_quarterizado((r.getEst_unifed_quarterizado() != null) ? r.getEst_unifed_quarterizado() + "":"");
          f.setFen_rua_quarterizado((r.getFen_rua_quarterizado() != null) ? r.getFen_rua_quarterizado() + "":"");
          f.setFen_nro_quarterizado((r.getFen_nro_quarterizado() != null) ? r.getFen_nro_quarterizado() + "":"");
          f.setFen_compto_quarterizado((r.getFen_compto_quarterizado() != null) ? r.getFen_compto_quarterizado() + "":"");
          f.setFen_bairro_quarterizado((r.getFen_bairro_quarterizado() != null) ? r.getFen_bairro_quarterizado() + "":"");
          f.setFen_insmun_quarterizado((r.getFen_insmun_quarterizado() != null) ? r.getFen_insmun_quarterizado() + "":"");
          f.setFen_insest_quarterizado((r.getFen_insest_quarterizado() != null) ? r.getFen_insest_quarterizado() + "":"");
          f.setFen_ativo_quarterizado((r.getFen_ativo_quarterizado() != null) ? r.getFen_ativo_quarterizado() + "":"");
          f.setFen_email_quarterizado((r.getFen_email_quarterizado() != null) ? r.getFen_email_quarterizado() + "":"");
          f.setFen_gln_quarterizado((r.getFen_gln_quarterizado() != null) ? r.getFen_gln_quarterizado() + "":"");
          f.setTipo_log_quarterizado((r.getTipo_log_quarterizado() != null) ? r.getTipo_log_quarterizado() + "":"");
          f.setFen_observacao_quarterizado((r.getFen_observacao_quarterizado() != null) ? r.getFen_observacao_quarterizado() + "":"");
          f.setDthr_inclusao(com.egen.util.text.FormatDate.format(r.getDthr_inclusao(), "dd/MM/yyyy HH:mm:ss"));
          f.setDthr_alteracao(com.egen.util.text.FormatDate.format(r.getDthr_alteracao(), "dd/MM/yyyy HH:mm:ss"));
          f.setUsuario_inclusao((r.getUsuario_inclusao() != null) ? r.getUsuario_inclusao() + "":"");
          f.setUsuario_alteracao((r.getUsuario_alteracao() != null) ? r.getUsuario_alteracao() + "":"");
        }
      }
    }
    session.setAttribute(mapping.getName(), form);
  }
  private void tg_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      AtelieresQuarterizados_mActionForm f = (AtelieresQuarterizados_mActionForm) form;
      acesso.Sessao sessao = new acesso.Sessao(session);
      util.consultas.Query query = new util.consultas.Query();
      f.setDthr_alteracao(query.retorna("SELECT to_char(SYSDATE,'dd/mm/yyyy hh24:mi:ss') DATA FROM dual"));
      f.setUsuario_alteracao(sessao.getUsuario());
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    } finally {
    }
  }

  private void tg_update_action_1(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_For_endere_quarterizado", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

  public ActionForward perform_delete_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      AtelieresQuarterizados_mActionForm f = (AtelieresQuarterizados_mActionForm) form;
      try {
        delete_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_For_endere_quarterizado", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    AtelieresQuarterizados_mActionForm f = (AtelieresQuarterizados_mActionForm) form;
    For_endere_quarterizado table = new For_endere_quarterizado();
    table.setFor_codigo(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getFo_codigo()));
    table.setFor_codigo_quarterizado(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getFo_codigo_quarterizado()));
    table.setFen_seq_quarterizado(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getFen_seq_quarterizado()));
    table.setFor_razsoc(f.getFo_razsoc());
    table.setFor_fant(f.getFo_fant());
    table.setFen_cgc_quarterizado(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getFen_cgc_quarterizado()));
    table.setFen_cep_quarterizado(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getFen_cep_quarterizado()));
    table.setFen_cidade_quarterizado(f.getFen_cidade_quarterizado());
    table.setEst_unifed_quarterizado(f.getEst_unifed_quarterizado());
    table.setFen_rua_quarterizado(f.getFen_rua_quarterizado());
    table.setFen_nro_quarterizado(f.getFen_nro_quarterizado());
    table.setFen_compto_quarterizado(f.getFen_compto_quarterizado());
    table.setFen_bairro_quarterizado(f.getFen_bairro_quarterizado());
    table.setFen_insmun_quarterizado(f.getFen_insmun_quarterizado());
    table.setFen_insest_quarterizado(f.getFen_insest_quarterizado());
    table.setFen_ativo_quarterizado(f.getFen_ativo_quarterizado());
    table.setFen_email_quarterizado(f.getFen_email_quarterizado());
    table.setFen_gln_quarterizado(f.getFen_gln_quarterizado());
    table.setTipo_log_quarterizado(f.getTipo_log_quarterizado());
    table.setFen_observacao_quarterizado(f.getFen_observacao_quarterizado());
    table.setDthr_inclusao(com.egen.util.text.FormatDate.parseTimestamp(f.getDthr_inclusao(), "dd/MM/yyyy HH:mm:ss"));
    table.setDthr_alteracao(com.egen.util.text.FormatDate.parseTimestamp(f.getDthr_alteracao(), "dd/MM/yyyy HH:mm:ss"));
    table.setUsuario_inclusao(f.getUsuario_inclusao());
    table.setUsuario_alteracao(f.getUsuario_alteracao());
    j.delete(table);
    Vector res_For_endere_quarterizado2 = (Vector) session.getAttribute("res_For_endere_quarterizado2");
    if (res_For_endere_quarterizado2 != null && res_For_endere_quarterizado2.size() > 0) {
      res_For_endere_quarterizado2.removeElementAt(0);
      if (res_For_endere_quarterizado2.size() > 0) {
        For_endere_quarterizado r = (For_endere_quarterizado) res_For_endere_quarterizado2.elementAt(0);
        f.setFo_codigo((r.getFor_codigo() != null) ? r.getFor_codigo() + "":"");
        f.setFo_codigo_quarterizado((r.getFor_codigo_quarterizado() != null) ? r.getFor_codigo_quarterizado() + "":"");
        f.setFen_seq_quarterizado((r.getFen_seq_quarterizado() != null) ? r.getFen_seq_quarterizado() + "":"");
        f.setFo_razsoc((r.getFor_razsoc() != null) ? r.getFor_razsoc() + "":"");
        f.setFo_fant((r.getFor_fant() != null) ? r.getFor_fant() + "":"");
        f.setFen_cgc_quarterizado((r.getFen_cgc_quarterizado() != null) ? com.egen.util.text.FormatNumber.format(r.getFen_cgc_quarterizado(), "0") : "");
        f.setFen_cep_quarterizado((r.getFen_cep_quarterizado() != null) ? r.getFen_cep_quarterizado() + "":"");
        f.setFen_cidade_quarterizado((r.getFen_cidade_quarterizado() != null) ? r.getFen_cidade_quarterizado() + "":"");
        f.setEst_unifed_quarterizado((r.getEst_unifed_quarterizado() != null) ? r.getEst_unifed_quarterizado() + "":"");
        f.setFen_rua_quarterizado((r.getFen_rua_quarterizado() != null) ? r.getFen_rua_quarterizado() + "":"");
        f.setFen_nro_quarterizado((r.getFen_nro_quarterizado() != null) ? r.getFen_nro_quarterizado() + "":"");
        f.setFen_compto_quarterizado((r.getFen_compto_quarterizado() != null) ? r.getFen_compto_quarterizado() + "":"");
        f.setFen_bairro_quarterizado((r.getFen_bairro_quarterizado() != null) ? r.getFen_bairro_quarterizado() + "":"");
        f.setFen_insmun_quarterizado((r.getFen_insmun_quarterizado() != null) ? r.getFen_insmun_quarterizado() + "":"");
        f.setFen_insest_quarterizado((r.getFen_insest_quarterizado() != null) ? r.getFen_insest_quarterizado() + "":"");
        f.setFen_ativo_quarterizado((r.getFen_ativo_quarterizado() != null) ? r.getFen_ativo_quarterizado() + "":"");
        f.setFen_email_quarterizado((r.getFen_email_quarterizado() != null) ? r.getFen_email_quarterizado() + "":"");
        f.setFen_gln_quarterizado((r.getFen_gln_quarterizado() != null) ? r.getFen_gln_quarterizado() + "":"");
        f.setTipo_log_quarterizado((r.getTipo_log_quarterizado() != null) ? r.getTipo_log_quarterizado() + "":"");
        f.setFen_observacao_quarterizado((r.getFen_observacao_quarterizado() != null) ? r.getFen_observacao_quarterizado() + "":"");
        f.setDthr_inclusao(com.egen.util.text.FormatDate.format(r.getDthr_inclusao(), "dd/MM/yyyy HH:mm:ss"));
        f.setDthr_alteracao(com.egen.util.text.FormatDate.format(r.getDthr_alteracao(), "dd/MM/yyyy HH:mm:ss"));
        f.setUsuario_inclusao((r.getUsuario_inclusao() != null) ? r.getUsuario_inclusao() + "":"");
        f.setUsuario_alteracao((r.getUsuario_alteracao() != null) ? r.getUsuario_alteracao() + "":"");
      } else {
        f.reset(mapping, request);
      }
    } else {
      f.reset(mapping, request);
    }
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      AtelieresQuarterizados_mActionForm f = (AtelieresQuarterizados_mActionForm) form;
      session.removeAttribute("res_For_endere_quarterizado2");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_For_endere_quarterizado", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      AtelieresQuarterizados_mActionForm f = (AtelieresQuarterizados_mActionForm) form;
      actionForward = new ActionForward((String) session.getAttribute("atelieres_quarterizados_back"), false);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_For_endere_quarterizado", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      AtelieresQuarterizados_mActionForm f = (AtelieresQuarterizados_mActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_For_endere_quarterizado", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    AtelieresQuarterizados_mActionForm f = (AtelieresQuarterizados_mActionForm) form;
    For_endere_quarterizado table = new For_endere_quarterizado();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"for_codigo","=", com.egen.util.text.FormatNumber.toInteger(f.getFo_codigo())}, {"for_codigo_quarterizado","=", com.egen.util.text.FormatNumber.toInteger(f.getFo_codigo_quarterizado())}, {"fen_seq_quarterizado","=", com.egen.util.text.FormatNumber.toInteger(f.getFen_seq_quarterizado())}, {"for_razsoc","like", f.getFo_razsoc()}, {"for_fant","like", f.getFo_fant()}, {"fen_cgc_quarterizado","=", com.egen.util.text.FormatNumber.toDouble(f.getFen_cgc_quarterizado())}, {"fen_cep_quarterizado","=", com.egen.util.text.FormatNumber.toInteger(f.getFen_cep_quarterizado())}, {"fen_cidade_quarterizado","like", f.getFen_cidade_quarterizado()}, {"est_unifed_quarterizado","like", f.getEst_unifed_quarterizado()}, {"fen_rua_quarterizado","like", f.getFen_rua_quarterizado()}, {"fen_nro_quarterizado","like", f.getFen_nro_quarterizado()}, {"fen_compto_quarterizado","like", f.getFen_compto_quarterizado()}, {"fen_bairro_quarterizado","like", f.getFen_bairro_quarterizado()}, {"fen_insmun_quarterizado","like", f.getFen_insmun_quarterizado()}, {"fen_insest_quarterizado","like", f.getFen_insest_quarterizado()}, {"fen_ativo_quarterizado","like", f.getFen_ativo_quarterizado()}, {"fen_email_quarterizado","like", f.getFen_email_quarterizado()}, {"fen_gln_quarterizado","like", f.getFen_gln_quarterizado()}, {"tipo_log_quarterizado","like", f.getTipo_log_quarterizado()}, {"fen_observacao_quarterizado","like", f.getFen_observacao_quarterizado()}, {"dthr_inclusao","=", com.egen.util.text.FormatDate.parseTimestamp(f.getDthr_inclusao(), "dd/MM/yyyy HH:mm:ss")}, {"dthr_alteracao","=", com.egen.util.text.FormatDate.parseTimestamp(f.getDthr_alteracao(), "dd/MM/yyyy HH:mm:ss")}, {"usuario_inclusao","like", f.getUsuario_inclusao()}, {"usuario_alteracao","like", f.getUsuario_alteracao()}, };
    Vector res_For_endere_quarterizado2 = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_For_endere_quarterizado2",res_For_endere_quarterizado2);
    if (res_For_endere_quarterizado2 != null && res_For_endere_quarterizado2.size() > 0) {
      For_endere_quarterizado r = (For_endere_quarterizado) res_For_endere_quarterizado2.elementAt(0);
      f.setFo_codigo((r.getFor_codigo() != null) ? r.getFor_codigo() + "":"");
      f.setFo_codigo_quarterizado((r.getFor_codigo_quarterizado() != null) ? r.getFor_codigo_quarterizado() + "":"");
      f.setFen_seq_quarterizado((r.getFen_seq_quarterizado() != null) ? r.getFen_seq_quarterizado() + "":"");
      f.setFo_razsoc((r.getFor_razsoc() != null) ? r.getFor_razsoc() + "":"");
      f.setFo_fant((r.getFor_fant() != null) ? r.getFor_fant() + "":"");
      f.setFen_cgc_quarterizado((r.getFen_cgc_quarterizado() != null) ? com.egen.util.text.FormatNumber.format(r.getFen_cgc_quarterizado(), "0") : "");
      f.setFen_cep_quarterizado((r.getFen_cep_quarterizado() != null) ? r.getFen_cep_quarterizado() + "":"");
      f.setFen_cidade_quarterizado((r.getFen_cidade_quarterizado() != null) ? r.getFen_cidade_quarterizado() + "":"");
      f.setEst_unifed_quarterizado((r.getEst_unifed_quarterizado() != null) ? r.getEst_unifed_quarterizado() + "":"");
      f.setFen_rua_quarterizado((r.getFen_rua_quarterizado() != null) ? r.getFen_rua_quarterizado() + "":"");
      f.setFen_nro_quarterizado((r.getFen_nro_quarterizado() != null) ? r.getFen_nro_quarterizado() + "":"");
      f.setFen_compto_quarterizado((r.getFen_compto_quarterizado() != null) ? r.getFen_compto_quarterizado() + "":"");
      f.setFen_bairro_quarterizado((r.getFen_bairro_quarterizado() != null) ? r.getFen_bairro_quarterizado() + "":"");
      f.setFen_insmun_quarterizado((r.getFen_insmun_quarterizado() != null) ? r.getFen_insmun_quarterizado() + "":"");
      f.setFen_insest_quarterizado((r.getFen_insest_quarterizado() != null) ? r.getFen_insest_quarterizado() + "":"");
      f.setFen_ativo_quarterizado((r.getFen_ativo_quarterizado() != null) ? r.getFen_ativo_quarterizado() + "":"");
      f.setFen_email_quarterizado((r.getFen_email_quarterizado() != null) ? r.getFen_email_quarterizado() + "":"");
      f.setFen_gln_quarterizado((r.getFen_gln_quarterizado() != null) ? r.getFen_gln_quarterizado() + "":"");
      f.setTipo_log_quarterizado((r.getTipo_log_quarterizado() != null) ? r.getTipo_log_quarterizado() + "":"");
      f.setFen_observacao_quarterizado((r.getFen_observacao_quarterizado() != null) ? r.getFen_observacao_quarterizado() + "":"");
      f.setDthr_inclusao(com.egen.util.text.FormatDate.format(r.getDthr_inclusao(), "dd/MM/yyyy HH:mm:ss"));
      f.setDthr_alteracao(com.egen.util.text.FormatDate.format(r.getDthr_alteracao(), "dd/MM/yyyy HH:mm:ss"));
      f.setUsuario_inclusao((r.getUsuario_inclusao() != null) ? r.getUsuario_inclusao() + "":"");
      f.setUsuario_alteracao((r.getUsuario_alteracao() != null) ? r.getUsuario_alteracao() + "":"");
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_For_endere_quarterizado", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute(mapping.getName(), form);
  }

}
