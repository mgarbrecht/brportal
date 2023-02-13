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
 * Last Modify Date 28/11/2013 15:56:04
 */

public class MunicipiosPrazos_aaAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      MunicipiosPrazos_aaActionForm f = (MunicipiosPrazos_aaActionForm) form;
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
    MunicipiosPrazos_aaActionForm f = (MunicipiosPrazos_aaActionForm) form;
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
      MunicipiosPrazos_aaActionForm f = (MunicipiosPrazos_aaActionForm) form;
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
  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      MunicipiosPrazos_aaActionForm f = (MunicipiosPrazos_aaActionForm) form;
      try {
        tg_update_action_1(mapping, form, request, response);
        update_action(j, mapping, form, request, response);
        tg_update_action(mapping, form, request, response);
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
  private void update_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    MunicipiosPrazos_aaActionForm f = (MunicipiosPrazos_aaActionForm) form;
    Municipios_prazos table = new Municipios_prazos();
    Vector sets = new Vector(10, 2);
    table.setId(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getId()));
    if (f.getId() != null) {
      sets.addElement("id");
    }
    table.setCodigo(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCodigo()));
    if (f.getCodigo() != null) {
      sets.addElement("codigo");
    }
    table.setCodigo_ibge(f.getCodigo_ibge());
    if (f.getCodigo_ibge() != null) {
      sets.addElement("codigo_ibge");
    }
    table.setEst_unifed(f.getEst_unifed());
    if (f.getEst_unifed() != null) {
      sets.addElement("est_unifed");
    }
    table.setDescricao(f.getDescricao());
    if (f.getDescricao() != null) {
      sets.addElement("descricao");
    }
    table.setPrazo_entrega(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getPrazo_entrega()));
    if (f.getPrazo_entrega() != null) {
      sets.addElement("prazo_entrega");
    }
    table.setSigla_transportadora(f.getSigla_transportadora());
    if (f.getSigla_transportadora() != null) {
      sets.addElement("sigla_transportadora");
    }
    table.setSegunda(((f.getSegunda() != null && f.getSegunda().length() > 0) ? ("S") : ("N")));
    sets.addElement("segunda");
    table.setTerca(((f.getTerca() != null && f.getTerca().length() > 0) ? ("S") : ("N")));
    sets.addElement("terca");
    table.setQuarda(((f.getQuarda() != null && f.getQuarda().length() > 0) ? ("S") : ("N")));
    sets.addElement("quarda");
    table.setQuinta(((f.getQuinta() != null && f.getQuinta().length() > 0) ? ("S") : ("N")));
    sets.addElement("quinta");
    table.setSexta(((f.getSexta() != null && f.getSexta().length() > 0) ? ("S") : ("N")));
    sets.addElement("sexta");
    table.setSabado(((f.getSabado() != null && f.getSabado().length() > 0) ? ("S") : ("N")));
    sets.addElement("sabado");
    table.setDomingo(((f.getDomingo() != null && f.getDomingo().length() > 0) ? ("S") : ("N")));
    sets.addElement("domingo");
    table.setDthr_inclusao(com.egen.util.text.FormatDate.parseTimestamp(f.getDthr_inclusao(), "dd/MM/yyyy HH:mm:ss"));
    if (f.getDthr_inclusao() != null) {
      sets.addElement("dthr_inclusao");
    }
    table.setUsuario_inclusao(f.getUsuario_inclusao());
    if (f.getUsuario_inclusao() != null) {
      sets.addElement("usuario_inclusao");
    }
    table.setDthr_alteracao(com.egen.util.text.FormatDate.parseTimestamp(f.getDthr_alteracao(), "dd/MM/yyyy HH:mm:ss"));
    if (f.getDthr_alteracao() != null) {
      sets.addElement("dthr_alteracao");
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
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Municipios_prazos", new ActionMessage("warn.norowsupdated",": " + updated));
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      } else {
        Vector res_Municipios_prazos = (Vector) session.getAttribute("res_Municipios_prazos");
        if (res_Municipios_prazos != null) {
          res_Municipios_prazos.setElementAt(table, 0);
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
        }
      }
    }
    session.setAttribute(mapping.getName(), form);
  }
  private void tg_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Municipios_prazos", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }
  private void tg_update_action_1(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      MunicipiosPrazos_aaActionForm f = (MunicipiosPrazos_aaActionForm) form;
      acesso.Sessao sessao = new acesso.Sessao(session);
      java.text.SimpleDateFormat fData = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
      f.setDthr_alteracao(fData.format(new java.util.Date()));
      f.setUsuario_alteracao(sessao.getUsuario());
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
      MunicipiosPrazos_aaActionForm f = (MunicipiosPrazos_aaActionForm) form;
      try {
        delete_action(j, mapping, form, request, response);
        tg_delete_action(mapping, form, request, response);
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
  private void delete_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    MunicipiosPrazos_aaActionForm f = (MunicipiosPrazos_aaActionForm) form;
    Municipios_prazos table = new Municipios_prazos();
    table.setId(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getId()));
    /*  table.setCodigo(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCodigo()));
          table.setCodigo_ibge(f.getCodigo_ibge());
          table.setDescricao(f.getDescricao());
          table.setEst_unifed(f.getEst_unifed());
          table.setPrazo_entrega(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getPrazo_entrega()));
          table.setSigla_transportadora(f.getSigla_transportadora());
          table.setSegunda(((f.getSegunda() != null && f.getSegunda().length() > 0) ? ("S") : ("N")));
          table.setTerca(((f.getTerca() != null && f.getTerca().length() > 0) ? ("S") : ("N")));
          table.setQuarda(((f.getQuarda() != null && f.getQuarda().length() > 0) ? ("S") : ("N")));
          table.setQuinta(((f.getQuinta() != null && f.getQuinta().length() > 0) ? ("S") : ("N")));
          table.setSexta(((f.getSexta() != null && f.getSexta().length() > 0) ? ("S") : ("N")));
          table.setSabado(((f.getSabado() != null && f.getSabado().length() > 0) ? ("S") : ("N")));
          table.setDomingo(((f.getDomingo() != null && f.getDomingo().length() > 0) ? ("S") : ("N")));
          table.setDthr_inclusao(com.egen.util.text.FormatDate.parseTimestamp(f.getDthr_inclusao(), "dd/MM/yyyy HH:mm:ss"));
          table.setUsuario_inclusao(f.getUsuario_inclusao());
          table.setDthr_alteracao(com.egen.util.text.FormatDate.parseTimestamp(f.getDthr_alteracao(), "dd/MM/yyyy HH:mm:ss"));
          table.setUsuario_alteracao(f.getUsuario_alteracao());
        */
    j.delete(table);
    Vector res_Municipios_prazos = (Vector) session.getAttribute("res_Municipios_prazos");
    if (res_Municipios_prazos != null && res_Municipios_prazos.size() > 0) {
      res_Municipios_prazos.removeElementAt(0);
      if (res_Municipios_prazos.size() > 0) {
        Municipios_prazos r = (Municipios_prazos) res_Municipios_prazos.elementAt(0);
        f.setId((r.getId() != null) ? com.egen.util.text.FormatNumber.format(r.getId(), "0") : "");
        f.setCodigo((r.getCodigo() != null) ? r.getCodigo() + "":"");
        f.setCodigo_ibge((r.getCodigo_ibge() != null) ? r.getCodigo_ibge() + "":"");
        f.setDescricao((r.getDescricao() != null) ? r.getDescricao() + "":"");
        f.setEst_unifed((r.getEst_unifed() != null) ? r.getEst_unifed() + "":"");
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
        f.reset(mapping, request);
      }
    } else {
      f.reset(mapping, request);
    }
    session.setAttribute(mapping.getName(), form);
  }
  private void tg_delete_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Municipios_prazos", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      MunicipiosPrazos_aaActionForm f = (MunicipiosPrazos_aaActionForm) form;
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
      MunicipiosPrazos_aaActionForm f = (MunicipiosPrazos_aaActionForm) form;


      actionForward = new ActionForward("/com/MunicipiosPrazos_raForm.jsp",true);
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
