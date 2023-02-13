package portalbr.lov;

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
 * Creation Date 23/05/2011 08:58:45
 * Last Modify Date 23/05/2011 16:19:26
 */

public class FichatecnicaAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      FichatecnicaActionForm f = (FichatecnicaActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ficha_tec_instrutiva", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    FichatecnicaActionForm f = (FichatecnicaActionForm) form;
    Ficha_tec_instrutiva table = new Ficha_tec_instrutiva();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"id_nro","=", com.egen.util.text.FormatNumber.toDouble(f.getId_nro())}, {"data","=", com.egen.util.text.FormatDate.parseDate(f.getData(), "dd/MM/yyyy")}, {"projeto_cdgo","like", f.getProjeto_cdgo()}, {"fma_cdgo","like", f.getFma_cdgo()}, {"base","like", f.getBase()}, {"codigo_colecao","=", com.egen.util.text.FormatNumber.toInteger(f.getCodigo_colecao())}, {"gde_cdgo","=", com.egen.util.text.FormatNumber.toDouble(f.getGde_cdgo())}, {"lin_cdgo","=", com.egen.util.text.FormatNumber.toDouble(f.getLin_cdgo())}, {"projeto_desc","like", f.getProjeto_desc()}, {"forma_desc","like", f.getForma_desc()}, {"grade_desc","like", f.getGrade_desc()}, {"linha_desc","like", f.getLinha_desc()}, {"ref_cdgo","=", com.egen.util.text.FormatNumber.toDouble(f.getRef_cdgo())}, {"ref_desc","like", f.getRef_desc()}, {"padrao","like", f.getPadrao()}, {"codigo_desc","like", f.getCodigo_desc()}, {"cod_mini_fab","=", com.egen.util.text.FormatNumber.toDouble(f.getCod_mini_fab())}, {"cod_mini_fab_desc","like", f.getCod_mini_fab_desc()}, {"tecnico_resp","like", f.getTecnico_resp()}, {"tecnico_pre","like", f.getTecnico_pre()}, {"data_entrega_amostra","=", com.egen.util.text.FormatDate.parseDate(f.getData_entrega_amostra(), "dd/MM/yyyy")}, {"status","like", f.getStatus()} };
    Vector res_Ficha_tec_instrutiva = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Ficha_tec_instrutiva",res_Ficha_tec_instrutiva);
    if (res_Ficha_tec_instrutiva == null || res_Ficha_tec_instrutiva.size() == 0) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ficha_tec_instrutiva", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
  }

  public ActionForward perform_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      FichatecnicaActionForm f = (FichatecnicaActionForm) form;
      try {
        insert_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ficha_tec_instrutiva", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    FichatecnicaActionForm f = (FichatecnicaActionForm) form;
    Ficha_tec_instrutiva table = new Ficha_tec_instrutiva();
    Object[][] name_value = { {"id_nro",com.egen.util.text.FormatNumber.toDouble(f.getId_nro())}, {"data",com.egen.util.text.FormatDate.parseDate(f.getData(), "dd/MM/yyyy")}, {"projeto_cdgo",f.getProjeto_cdgo()}, {"fma_cdgo",f.getFma_cdgo()}, {"base",f.getBase()}, {"codigo_colecao",com.egen.util.text.FormatNumber.toInteger(f.getCodigo_colecao())}, {"gde_cdgo",com.egen.util.text.FormatNumber.toDouble(f.getGde_cdgo())}, {"lin_cdgo",com.egen.util.text.FormatNumber.toDouble(f.getLin_cdgo())}, {"projeto_desc",f.getProjeto_desc()}, {"forma_desc",f.getForma_desc()}, {"grade_desc",f.getGrade_desc()}, {"linha_desc",f.getLinha_desc()}, {"ref_cdgo",com.egen.util.text.FormatNumber.toDouble(f.getRef_cdgo())}, {"ref_desc",f.getRef_desc()}, {"padrao",f.getPadrao()}, {"codigo_desc",f.getCodigo_desc()}, {"cod_mini_fab",com.egen.util.text.FormatNumber.toDouble(f.getCod_mini_fab())}, {"cod_mini_fab_desc",f.getCod_mini_fab_desc()}, {"tecnico_resp",f.getTecnico_resp()}, {"tecnico_pre",f.getTecnico_pre()}, {"data_entrega_amostra",com.egen.util.text.FormatDate.parseDate(f.getData_entrega_amostra(), "dd/MM/yyyy")}, {"status",f.getStatus()}, };
    j.insert(table, name_value);
    Vector res_Ficha_tec_instrutiva = (Vector) session.getAttribute("res_Ficha_tec_instrutiva");
    if (res_Ficha_tec_instrutiva != null && table != null) {
      res_Ficha_tec_instrutiva.addElement(table);
      session.setAttribute("res_Ficha_tec_instrutiva", res_Ficha_tec_instrutiva);
    }
    form.reset(mapping, request);
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      FichatecnicaActionForm f = (FichatecnicaActionForm) form;
      try {
        update_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ficha_tec_instrutiva", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    FichatecnicaActionForm f = (FichatecnicaActionForm) form;
    Ficha_tec_instrutiva table = new Ficha_tec_instrutiva();
    Vector sets = new Vector(10, 2);
    table.setId_nro(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getId_nro()));
    if (f.getId_nro() != null) {
      sets.addElement("id_nro");
    }
    table.setData(com.egen.util.text.FormatDate.parseDate(f.getData(), "dd/MM/yyyy"));
    if (f.getData() != null) {
      sets.addElement("data");
    }
    table.setProjeto_cdgo(f.getProjeto_cdgo());
    if (f.getProjeto_cdgo() != null) {
      sets.addElement("projeto_cdgo");
    }
    table.setFma_cdgo(f.getFma_cdgo());
    if (f.getFma_cdgo() != null) {
      sets.addElement("fma_cdgo");
    }
    table.setBase(f.getBase());
    if (f.getBase() != null) {
      sets.addElement("base");
    }
    table.setCodigo_colecao(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCodigo_colecao()));
    if (f.getCodigo_colecao() != null) {
      sets.addElement("codigo_colecao");
    }
    table.setGde_cdgo(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getGde_cdgo()));
    if (f.getGde_cdgo() != null) {
      sets.addElement("gde_cdgo");
    }
    table.setLin_cdgo(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getLin_cdgo()));
    if (f.getLin_cdgo() != null) {
      sets.addElement("lin_cdgo");
    }
    table.setProjeto_desc(f.getProjeto_desc());
    if (f.getProjeto_desc() != null) {
      sets.addElement("projeto_desc");
    }
    table.setForma_desc(f.getForma_desc());
    if (f.getForma_desc() != null) {
      sets.addElement("forma_desc");
    }
    table.setGrade_desc(f.getGrade_desc());
    if (f.getGrade_desc() != null) {
      sets.addElement("grade_desc");
    }
    table.setLinha_desc(f.getLinha_desc());
    if (f.getLinha_desc() != null) {
      sets.addElement("linha_desc");
    }
    table.setRef_cdgo(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getRef_cdgo()));
    if (f.getRef_cdgo() != null) {
      sets.addElement("ref_cdgo");
    }
    table.setRef_desc(f.getRef_desc());
    if (f.getRef_desc() != null) {
      sets.addElement("ref_desc");
    }
    table.setPadrao(f.getPadrao());
    if (f.getPadrao() != null) {
      sets.addElement("padrao");
    }
    table.setCodigo_desc(f.getCodigo_desc());
    if (f.getCodigo_desc() != null) {
      sets.addElement("codigo_desc");
    }
    table.setCod_mini_fab(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getCod_mini_fab()));
    if (f.getCod_mini_fab() != null) {
      sets.addElement("cod_mini_fab");
    }
    table.setCod_mini_fab_desc(f.getCod_mini_fab_desc());
    if (f.getCod_mini_fab_desc() != null) {
      sets.addElement("cod_mini_fab_desc");
    }
    table.setTecnico_resp(f.getTecnico_resp());
    if (f.getTecnico_resp() != null) {
      sets.addElement("tecnico_resp");
    }
    table.setTecnico_pre(f.getTecnico_pre());
    if (f.getTecnico_pre() != null) {
      sets.addElement("tecnico_pre");
    }
    table.setData_entrega_amostra(com.egen.util.text.FormatDate.parseDate(f.getData_entrega_amostra(), "dd/MM/yyyy"));
    if (f.getData_entrega_amostra() != null) {
      sets.addElement("data_entrega_amostra");
    }
    table.setStatus(f.getStatus());
    if (f.getStatus() != null) {
      sets.addElement("status");
    }
    if (sets != null && sets.size() > 0) {
      String[] set = new String[sets.size()];
      for (int i = 0; i < sets.size(); i++) {
        set[i] = (String) sets.elementAt(i);
      }
      int updated = j.update(table, set);
      if (updated == 0) {
        ActionErrors errors = new ActionErrors();
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ficha_tec_instrutiva", new ActionMessage("warn.norowsupdated",": " + updated));
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      } else {
        Vector res_Ficha_tec_instrutiva = (Vector) session.getAttribute("res_Ficha_tec_instrutiva");
        if (res_Ficha_tec_instrutiva != null) {
          res_Ficha_tec_instrutiva.setElementAt(table, 0);
          Ficha_tec_instrutiva r = (Ficha_tec_instrutiva) res_Ficha_tec_instrutiva.elementAt(0);
          f.setId_nro((r.getId_nro() != null) ? com.egen.util.text.FormatNumber.format(r.getId_nro(), "0") : "");
          f.setData(com.egen.util.text.FormatDate.format(r.getData(), "dd/MM/yyyy"));
          f.setProjeto_cdgo((r.getProjeto_cdgo() != null) ? r.getProjeto_cdgo() + "":"");
          f.setFma_cdgo((r.getFma_cdgo() != null) ? r.getFma_cdgo() + "":"");
          f.setBase((r.getBase() != null) ? r.getBase() + "":"");
          f.setCodigo_colecao((r.getCodigo_colecao() != null) ? r.getCodigo_colecao() + "":"");
          f.setGde_cdgo((r.getGde_cdgo() != null) ? com.egen.util.text.FormatNumber.format(r.getGde_cdgo(), "0") : "");
          f.setLin_cdgo((r.getLin_cdgo() != null) ? com.egen.util.text.FormatNumber.format(r.getLin_cdgo(), "0") : "");
          f.setProjeto_desc((r.getProjeto_desc() != null) ? r.getProjeto_desc() + "":"");
          f.setForma_desc((r.getForma_desc() != null) ? r.getForma_desc() + "":"");
          f.setGrade_desc((r.getGrade_desc() != null) ? r.getGrade_desc() + "":"");
          f.setLinha_desc((r.getLinha_desc() != null) ? r.getLinha_desc() + "":"");
          f.setRef_cdgo((r.getRef_cdgo() != null) ? com.egen.util.text.FormatNumber.format(r.getRef_cdgo(), "0") : "");
          f.setRef_desc((r.getRef_desc() != null) ? r.getRef_desc() + "":"");
          f.setPadrao((r.getPadrao() != null) ? r.getPadrao() + "":"");
          f.setCodigo_desc((r.getCodigo_desc() != null) ? r.getCodigo_desc() + "":"");
          f.setCod_mini_fab((r.getCod_mini_fab() != null) ? com.egen.util.text.FormatNumber.format(r.getCod_mini_fab(), "0") : "");
          f.setCod_mini_fab_desc((r.getCod_mini_fab_desc() != null) ? r.getCod_mini_fab_desc() + "":"");
          f.setTecnico_resp((r.getTecnico_resp() != null) ? r.getTecnico_resp() + "":"");
          f.setTecnico_pre((r.getTecnico_pre() != null) ? r.getTecnico_pre() + "":"");
          f.setData_entrega_amostra(com.egen.util.text.FormatDate.format(r.getData_entrega_amostra(), "dd/MM/yyyy"));
          f.setStatus((r.getStatus() != null) ? r.getStatus() + "":"");
        }
      }
    }
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_delete_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      FichatecnicaActionForm f = (FichatecnicaActionForm) form;
      try {
        delete_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ficha_tec_instrutiva", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    FichatecnicaActionForm f = (FichatecnicaActionForm) form;
    Ficha_tec_instrutiva table = new Ficha_tec_instrutiva();
    table.setId_nro(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getId_nro()));
    table.setData(com.egen.util.text.FormatDate.parseDate(f.getData(), "dd/MM/yyyy"));
    table.setProjeto_cdgo(f.getProjeto_cdgo());
    table.setFma_cdgo(f.getFma_cdgo());
    table.setBase(f.getBase());
    table.setCodigo_colecao(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCodigo_colecao()));
    table.setGde_cdgo(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getGde_cdgo()));
    table.setLin_cdgo(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getLin_cdgo()));
    table.setProjeto_desc(f.getProjeto_desc());
    table.setForma_desc(f.getForma_desc());
    table.setGrade_desc(f.getGrade_desc());
    table.setLinha_desc(f.getLinha_desc());
    table.setRef_cdgo(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getRef_cdgo()));
    table.setRef_desc(f.getRef_desc());
    table.setPadrao(f.getPadrao());
    table.setCodigo_desc(f.getCodigo_desc());
    table.setCod_mini_fab(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getCod_mini_fab()));
    table.setCod_mini_fab_desc(f.getCod_mini_fab_desc());
    table.setTecnico_resp(f.getTecnico_resp());
    table.setTecnico_pre(f.getTecnico_pre());
    table.setData_entrega_amostra(com.egen.util.text.FormatDate.parseDate(f.getData_entrega_amostra(), "dd/MM/yyyy"));
    table.setStatus(f.getStatus());
    j.delete(table);
    Vector res_Ficha_tec_instrutiva = (Vector) session.getAttribute("res_Ficha_tec_instrutiva");
    if (res_Ficha_tec_instrutiva != null && res_Ficha_tec_instrutiva.size() > 0) {
      res_Ficha_tec_instrutiva.removeElementAt(0);
      if (res_Ficha_tec_instrutiva.size() > 0) {
        Ficha_tec_instrutiva r = (Ficha_tec_instrutiva) res_Ficha_tec_instrutiva.elementAt(0);
        f.setId_nro((r.getId_nro() != null) ? com.egen.util.text.FormatNumber.format(r.getId_nro(), "0") : "");
        f.setData(com.egen.util.text.FormatDate.format(r.getData(), "dd/MM/yyyy"));
        f.setProjeto_cdgo((r.getProjeto_cdgo() != null) ? r.getProjeto_cdgo() + "":"");
        f.setFma_cdgo((r.getFma_cdgo() != null) ? r.getFma_cdgo() + "":"");
        f.setBase((r.getBase() != null) ? r.getBase() + "":"");
        f.setCodigo_colecao((r.getCodigo_colecao() != null) ? r.getCodigo_colecao() + "":"");
        f.setGde_cdgo((r.getGde_cdgo() != null) ? com.egen.util.text.FormatNumber.format(r.getGde_cdgo(), "0") : "");
        f.setLin_cdgo((r.getLin_cdgo() != null) ? com.egen.util.text.FormatNumber.format(r.getLin_cdgo(), "0") : "");
        f.setProjeto_desc((r.getProjeto_desc() != null) ? r.getProjeto_desc() + "":"");
        f.setForma_desc((r.getForma_desc() != null) ? r.getForma_desc() + "":"");
        f.setGrade_desc((r.getGrade_desc() != null) ? r.getGrade_desc() + "":"");
        f.setLinha_desc((r.getLinha_desc() != null) ? r.getLinha_desc() + "":"");
        f.setRef_cdgo((r.getRef_cdgo() != null) ? com.egen.util.text.FormatNumber.format(r.getRef_cdgo(), "0") : "");
        f.setRef_desc((r.getRef_desc() != null) ? r.getRef_desc() + "":"");
        f.setPadrao((r.getPadrao() != null) ? r.getPadrao() + "":"");
        f.setCodigo_desc((r.getCodigo_desc() != null) ? r.getCodigo_desc() + "":"");
        f.setCod_mini_fab((r.getCod_mini_fab() != null) ? com.egen.util.text.FormatNumber.format(r.getCod_mini_fab(), "0") : "");
        f.setCod_mini_fab_desc((r.getCod_mini_fab_desc() != null) ? r.getCod_mini_fab_desc() + "":"");
        f.setTecnico_resp((r.getTecnico_resp() != null) ? r.getTecnico_resp() + "":"");
        f.setTecnico_pre((r.getTecnico_pre() != null) ? r.getTecnico_pre() + "":"");
        f.setData_entrega_amostra(com.egen.util.text.FormatDate.format(r.getData_entrega_amostra(), "dd/MM/yyyy"));
        f.setStatus((r.getStatus() != null) ? r.getStatus() + "":"");
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
      FichatecnicaActionForm f = (FichatecnicaActionForm) form;
      session.removeAttribute("res_Ficha_tec_instrutiva");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ficha_tec_instrutiva", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
