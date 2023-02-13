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
 * Creation Date 18/11/2013 10:53:57
 * Last Modify Date 20/11/2013 12:11:14
 */

public class MunicipiosPrazos_acAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      MunicipiosPrazos_acActionForm f = (MunicipiosPrazos_acActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
        tg_select_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Municipios_prazos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    MunicipiosPrazos_acActionForm f = (MunicipiosPrazos_acActionForm) form;
    Municipios_prazos table = new Municipios_prazos();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"id","=", com.egen.util.text.FormatNumber.toInteger(f.getId())}, {"codigo","=", com.egen.util.text.FormatNumber.toInteger(f.getCodigo())}, {"codigo_ibge","like", f.getCodigo_ibge()}, {"est_unifed","like", f.getEst_unifed()}, {"descricao","like", f.getDescricao()}, {"prazo_entrega","=", com.egen.util.text.FormatNumber.toInteger(f.getPrazo_entrega())}, {"sigla_transportadora","like", f.getSigla_transportadora()}, {"dthr_inclusao","=", com.egen.util.text.FormatDate.parseTimestamp(f.getDthr_inclusao(), "dd/MM/yyyy HH:mm:ss")}, {"usuario_inclusao","like", f.getUsuario_inclusao()}, {"dthr_alteracao","=", com.egen.util.text.FormatDate.parseTimestamp(f.getDthr_alteracao(), "dd/MM/yyyy HH:mm:ss")}, {"usuario_alteracao","like", f.getUsuario_alteracao()} };
    Vector res_Municipios_prazos = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Municipios_prazos",res_Municipios_prazos);
    if (res_Municipios_prazos != null && res_Municipios_prazos.size() > 0) {
      Municipios_prazos r = (Municipios_prazos) res_Municipios_prazos.elementAt(0);
      f.setId((r.getId() != null) ? com.egen.util.text.FormatNumber.format(r.getId(), "0") : "");
      f.setCodigo((r.getCodigo() != null) ? r.getCodigo() + "":"");
      f.setCodigo_ibge((r.getCodigo_ibge() != null) ? r.getCodigo_ibge() + "":"");
      f.setEst_unifed((r.getEst_unifed() != null) ? r.getEst_unifed() + "":"");
      f.setDescricao((r.getDescricao() != null) ? r.getDescricao() + "":"");
      f.setPrazo_entrega((r.getPrazo_entrega() != null) ? com.egen.util.text.FormatNumber.format(r.getPrazo_entrega(), "0") : "");
      f.setSigla_transportadora((r.getSigla_transportadora() != null) ? r.getSigla_transportadora() + "":"");
      f.setSegunda((r.getSegunda() != null) ? r.getSegunda() + "":"");
      f.setTerca((r.getTerca() != null) ? r.getTerca() + "":"");
      f.setQuarda((r.getQuarda() != null) ? r.getQuarda() + "":"");
      f.setQuinta((r.getQuinta() != null) ? r.getQuinta() + "":"");
      f.setSexta((r.getSexta() != null) ? r.getSexta() + "":"");
      f.setSabado((r.getSabado() != null) ? r.getSabado() + "":"");
      f.setDomingo((r.getDomingo() != null) ? r.getDomingo() + "":"");
      f.setDthr_inclusao(com.egen.util.text.FormatDate.format(r.getDthr_inclusao(), "dd/MM/yyyy HH:mm:ss"));
      f.setUsuario_inclusao((r.getUsuario_inclusao() != null) ? r.getUsuario_inclusao() + "":"");
      f.setDthr_alteracao(com.egen.util.text.FormatDate.format(r.getDthr_alteracao(), "dd/MM/yyyy HH:mm:ss"));
      f.setUsuario_alteracao((r.getUsuario_alteracao() != null) ? r.getUsuario_alteracao() + "":"");
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Municipios_prazos", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute(mapping.getName(), form);
  }
  private void tg_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      MunicipiosPrazos_acActionForm f = (MunicipiosPrazos_acActionForm) form;
      if (!f.getCodigo().equals("")) {
        if (!f.getCodigo().equals("99999")) {
          util.consultas.Query query = new util.consultas.Query();
          String retorno = query.retorna("SELECT descricao FROM municipios WHERE codigo = " + f.getCodigo());
          f.setDescricao_municipio(retorno);
        }
      }
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    } finally {
    }
  }
  public ActionForward perform_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      MunicipiosPrazos_acActionForm f = (MunicipiosPrazos_acActionForm) form;
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
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Municipios_prazos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    MunicipiosPrazos_acActionForm f = (MunicipiosPrazos_acActionForm) form;
    Municipios_prazos table = new Municipios_prazos();
    Object[][] name_value = { {"id",com.egen.util.text.FormatNumber.toInteger(f.getId())}, {"codigo",com.egen.util.text.FormatNumber.toInteger(f.getCodigo())}, {"codigo_ibge",f.getCodigo_ibge()}, {"est_unifed",f.getEst_unifed()}, {"descricao",f.getDescricao()}, {"prazo_entrega",com.egen.util.text.FormatNumber.toInteger(f.getPrazo_entrega())}, {"sigla_transportadora",f.getSigla_transportadora()}, {"segunda",((f.getSegunda() != null && f.getSegunda().length() > 0) ? ("S") : ("N"))}, {"terca",((f.getTerca() != null && f.getTerca().length() > 0) ? ("S") : ("N"))}, {"quarda",((f.getQuarda() != null && f.getQuarda().length() > 0) ? ("S") : ("N"))}, {"quinta",((f.getQuinta() != null && f.getQuinta().length() > 0) ? ("S") : ("N"))}, {"sexta",((f.getSexta() != null && f.getSexta().length() > 0) ? ("S") : ("N"))}, {"sabado",((f.getSabado() != null && f.getSabado().length() > 0) ? ("S") : ("N"))}, {"domingo",((f.getDomingo() != null && f.getDomingo().length() > 0) ? ("S") : ("N"))}, {"dthr_inclusao",com.egen.util.text.FormatDate.parseTimestamp(f.getDthr_inclusao(), "dd/MM/yyyy HH:mm:ss")}, {"usuario_inclusao",f.getUsuario_inclusao()}, {"dthr_alteracao",com.egen.util.text.FormatDate.parseTimestamp(f.getDthr_alteracao(), "dd/MM/yyyy HH:mm:ss")}, {"usuario_alteracao",f.getUsuario_alteracao()}, };
    j.insert(table, name_value);
    Vector res_Municipios_prazos = (Vector) session.getAttribute("res_Municipios_prazos");
    if (res_Municipios_prazos != null && table != null) {
      res_Municipios_prazos.addElement(table);
      session.setAttribute("res_Municipios_prazos", res_Municipios_prazos);
    }
    form.reset(mapping, request);
    session.setAttribute(mapping.getName(), form);
  }
  private void tg_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      acesso.Sessao sessao = new acesso.Sessao(session);
      MunicipiosPrazos_acActionForm f = (MunicipiosPrazos_acActionForm) form;
      java.text.SimpleDateFormat fData = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
      f.setDthr_inclusao(fData.format(new java.util.Date()));
      f.setUsuario_inclusao(sessao.getUsuario());
      f.setDescricao(f.getDescricao().toUpperCase());
      util.consultas.Sequence sequence = new util.consultas.Sequence();
      f.setId(sequence.nextValue("brio.municipios_prazos","id") + "");
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    } finally {
    }
  }
  private void tg_insert_action_1(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Municipios_prazos", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      MunicipiosPrazos_acActionForm f = (MunicipiosPrazos_acActionForm) form;
      session.removeAttribute("res_Municipios_prazos");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Municipios_prazos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      MunicipiosPrazos_acActionForm f = (MunicipiosPrazos_acActionForm) form;


      actionForward = new ActionForward("/com/MunicipiosPrazos_aForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Municipios_prazos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
