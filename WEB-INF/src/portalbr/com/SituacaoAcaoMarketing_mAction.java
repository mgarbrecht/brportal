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
 * Creation Date 07/12/2010 05:51:52
 * Last Modify Date 03/04/2013 13:09:55
 */

public class SituacaoAcaoMarketing_mAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_pos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      try {
        String _pos_field_name = "pos";
        String _lines_name = "bl_form_Acao_marketing_estagios_lines";
        String action = null;
        int pos = com.egen.util.struts.AbstractActionHelper.getDynamicPosition(action, _pos_field_name, _lines_name, form, request);
        pos_action(pos, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Acao_marketing_estagios", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
  private void pos_action(int _ge_pos, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    DynaActionForm _ge_grid = (DynaActionForm) form;
    SituacaoAcaoMarketing_mActionForm[]_ge_grid_array = (SituacaoAcaoMarketing_mActionForm[])_ge_grid.get("bl_form_Acao_marketing_estagios_lines");
    SituacaoAcaoMarketing_mActionForm f = _ge_grid_array[0];
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++, _ge_pos++) {
      f = _ge_grid_array[_ge_grid_array_index];
      Vector res_Acao_marketing_estagios = (Vector) session.getAttribute("res_Acao_marketing_estagios");
      if (res_Acao_marketing_estagios != null && _ge_pos < res_Acao_marketing_estagios.size()) {
        Acao_marketing_estagios r = (Acao_marketing_estagios) res_Acao_marketing_estagios.elementAt(_ge_pos);
        f.setEstagio_cdgo((r.getEstagio_cdgo() != null) ? r.getEstagio_cdgo() + "":"");
        f.setDescricao((r.getDescricao() != null) ? r.getDescricao() + "":"");
        f.setOrdem((r.getOrdem() != null) ? com.egen.util.text.FormatNumber.format(r.getOrdem(), "0") : "");
        f.setPos("" + _ge_pos);
        f.setBanco("S");
      } else {
        f.reset(mapping, request);
      }
      _ge_grid_array[_ge_grid_array_index] = f;
      session.setAttribute("pos", "" + _ge_pos);
      session.setAttribute(mapping.getName(), form);
    }
  }

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      SituacaoAcaoMarketing_mActionForm[]_ge_grid_array = (SituacaoAcaoMarketing_mActionForm[])_ge_grid.get("bl_form_Acao_marketing_estagios_lines");
      SituacaoAcaoMarketing_mActionForm f = _ge_grid_array[0];
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Acao_marketing_estagios", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    SituacaoAcaoMarketing_mActionForm[]_ge_grid_array = (SituacaoAcaoMarketing_mActionForm[])_ge_grid.get("bl_form_Acao_marketing_estagios_lines");
    SituacaoAcaoMarketing_mActionForm f = _ge_grid_array[0];
    if (f != null) {
      Acao_marketing_estagios table = new Acao_marketing_estagios();
      String[][] select = null;
      String[] order = null;
      String[] groupby = null;
      String[] having = null;
      Object[][] where = { {"estagio_cdgo","=", com.egen.util.text.FormatNumber.toInteger(f.getEstagio_cdgo())}, {"descricao","like", f.getDescricao().toUpperCase()}, {"ordem","=", com.egen.util.text.FormatNumber.toInteger(f.getOrdem())}, };
      Vector res_Acao_marketing_estagios = j.select(table, select, where, groupby, having, order);
      session.setAttribute("res_Acao_marketing_estagios",res_Acao_marketing_estagios);
      if (res_Acao_marketing_estagios != null && res_Acao_marketing_estagios.size() > 0) {
        int _ge_pos = 0;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++, _ge_pos++) {
          f = _ge_grid_array[_ge_grid_array_index];
          f.reset(mapping, request);
          if (res_Acao_marketing_estagios.size() > _ge_pos) {
            Acao_marketing_estagios r = (Acao_marketing_estagios) res_Acao_marketing_estagios.elementAt(_ge_pos);
            f.setEstagio_cdgo((r.getEstagio_cdgo() != null) ? r.getEstagio_cdgo() + "":"");
            f.setDescricao((r.getDescricao() != null) ? r.getDescricao() + "":"");
            f.setOrdem((r.getOrdem() != null) ? com.egen.util.text.FormatNumber.format(r.getOrdem(), "0") : "");
            f.setPos("" + _ge_pos);
            f.setBanco("S");
          }
          _ge_grid_array[_ge_grid_array_index] = f;
        }
        session.setAttribute("pos", "" + _ge_pos);
      } else {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Acao_marketing_estagios", new ActionMessage("warn.norowsselected",""));
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      }
      session.setAttribute(mapping.getName(), form);
    }
  }

  public ActionForward perform_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      SituacaoAcaoMarketing_mActionForm[]_ge_grid_array = (SituacaoAcaoMarketing_mActionForm[])_ge_grid.get("bl_form_Acao_marketing_estagios_lines");
      SituacaoAcaoMarketing_mActionForm f = _ge_grid_array[0];
      try {
        insert_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Acao_marketing_estagios", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    DynaActionForm _ge_grid = (DynaActionForm) form;
    util.consultas.Query query = new util.consultas.Query();
    SituacaoAcaoMarketing_mActionForm[]_ge_grid_array = (SituacaoAcaoMarketing_mActionForm[])_ge_grid.get("bl_form_Acao_marketing_estagios_lines");
    SituacaoAcaoMarketing_mActionForm f = _ge_grid_array[0];
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      if (f.getAlterado().equalsIgnoreCase("s") && (!(f.getBanco().equalsIgnoreCase("s")))) {
        if (f.getDescricao().equals("") || f.getOrdem().equals("")) {
          throw new Exception("Todos os campos obrigatórios devem ser informados!");
        }
        String existe_ordem = query.retorna(j, "SELECT 's' from brio.acao_marketing_estagios WHERE ordem = "+f.getOrdem());
        if (existe_ordem.equals("s")) {
          throw new Exception("Ordem já existente!");
        }
        Acao_marketing_estagios table = new Acao_marketing_estagios();
        Object[][] name_value = { {"estagio_cdgo",com.egen.util.text.FormatNumber.toInteger(query.retorna(j, "SELECT MAX(nvl(estagio_cdgo,0))+1 from brio.acao_marketing_estagios"))}, {"descricao",f.getDescricao().toUpperCase()}, {"ordem",com.egen.util.text.FormatNumber.toInteger(f.getOrdem())} };
        j.insert(table, name_value);
        f.setBanco("S");
        Vector res_Acao_marketing_estagios = (Vector) session.getAttribute("res_Acao_marketing_estagios");
        if (res_Acao_marketing_estagios != null && table != null) {
          res_Acao_marketing_estagios.addElement(table);
          session.setAttribute("res_Acao_marketing_estagios", res_Acao_marketing_estagios);
        }
      }
    }
  }

  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      SituacaoAcaoMarketing_mActionForm[]_ge_grid_array = (SituacaoAcaoMarketing_mActionForm[])_ge_grid.get("bl_form_Acao_marketing_estagios_lines");
      SituacaoAcaoMarketing_mActionForm f = _ge_grid_array[0];
      try {
        update_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Acao_marketing_estagios", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    util.consultas.Query query = new util.consultas.Query();
    SituacaoAcaoMarketing_mActionForm[]_ge_grid_array = (SituacaoAcaoMarketing_mActionForm[])_ge_grid.get("bl_form_Acao_marketing_estagios_lines");
    SituacaoAcaoMarketing_mActionForm f = _ge_grid_array[0];
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      if (f.getAlterado().equalsIgnoreCase("s") && (f.getBanco().equalsIgnoreCase("s"))) {
        if (f.getDescricao().equals("") || f.getOrdem().equals("")) {
          throw new Exception("Todos os campos obrigatórios devem ser informados!");
        }
        String existe_ordem = query.retorna(j, "SELECT 's' from brio.acao_marketing_estagios WHERE ordem = "+f.getOrdem() + " AND estagio_cdgo <> "+f.getEstagio_cdgo());
        if (existe_ordem.equals("s")) {
          throw new Exception("Ordem já existente!");
        }
        Acao_marketing_estagios table = new Acao_marketing_estagios();
        Vector sets = new Vector(10, 2);
        table.setEstagio_cdgo(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getEstagio_cdgo()));
        if (f.getEstagio_cdgo() != null) {
          sets.addElement("estagio_cdgo");
        }
        table.setDescricao(f.getDescricao().toUpperCase());
        if (f.getDescricao() != null) {
          sets.addElement("descricao");
        }
        table.setOrdem(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getOrdem()));
        if (f.getOrdem() != null) {
          sets.addElement("ordem");
        }
        if (sets != null && sets.size() > 0) {
          String[] set = new String[sets.size()];
          for (int i = 0; i < sets.size(); i++) {
            set[i] = (String) sets.elementAt(i);
          }
          int updated = j.update(table, set);
          String _pos_field_name = "pos";
          String _lines_name = "bl_form_Acao_marketing_estagios_lines";
          String action = null;
          int _ge_pos = com.egen.util.struts.AbstractActionHelper.getDynamicPosition(action, _pos_field_name, _lines_name, f, request);
          if (updated == 0) {
            ActionErrors errors = new ActionErrors();
            errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Acao_marketing_estagios", new ActionMessage("warn.norowsupdated",": " + updated));
            request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
          } else {
            Vector res_Acao_marketing_estagios = (Vector) session.getAttribute("res_Acao_marketing_estagios");
            if (res_Acao_marketing_estagios != null) {
              res_Acao_marketing_estagios.setElementAt(table, _ge_pos);
              Acao_marketing_estagios r = (Acao_marketing_estagios) res_Acao_marketing_estagios.elementAt(_ge_pos);
              f.setEstagio_cdgo((r.getEstagio_cdgo() != null) ? r.getEstagio_cdgo() + "":"");
              f.setDescricao((r.getDescricao() != null) ? r.getDescricao() + "":"");
              f.setOrdem((r.getOrdem() != null) ? com.egen.util.text.FormatNumber.format(r.getOrdem(), "0") : "");
            }
          }
        }
        session.setAttribute(mapping.getName(), form);
      }
    }
  }
  public ActionForward perform_delete_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      SituacaoAcaoMarketing_mActionForm[]_ge_grid_array = (SituacaoAcaoMarketing_mActionForm[])_ge_grid.get("bl_form_Acao_marketing_estagios_lines");
      SituacaoAcaoMarketing_mActionForm f = _ge_grid_array[0];
      try {
        delete_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Acao_marketing_estagios", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    DynaActionForm _ge_grid = (DynaActionForm) form;
    SituacaoAcaoMarketing_mActionForm[]_ge_grid_array = (SituacaoAcaoMarketing_mActionForm[])_ge_grid.get("bl_form_Acao_marketing_estagios_lines");
    SituacaoAcaoMarketing_mActionForm f = _ge_grid_array[0];
    int _ge_pos = 0;
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      int pos = 0;
      try {
        pos = (new Integer(f.getPos())).intValue();
      } catch (Exception e) {}
      if (_ge_grid_array_index == 0) {
        _ge_pos = pos;
      }
      if (true) {
        Acao_marketing_estagios table = new Acao_marketing_estagios();
        table.setEstagio_cdgo(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getEstagio_cdgo()));
        table.setDescricao(f.getDescricao());
        table.setOrdem(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getOrdem()));
        j.delete(table);
        Vector res_Acao_marketing_estagios = (Vector) session.getAttribute("res_Acao_marketing_estagios");
        if (res_Acao_marketing_estagios != null && res_Acao_marketing_estagios.size() > pos) {
          if (pos == res_Acao_marketing_estagios.size()) {
            pos--;
          }
          res_Acao_marketing_estagios.removeElementAt(pos);
          if (res_Acao_marketing_estagios.size() > pos) {
            Acao_marketing_estagios r = (Acao_marketing_estagios) res_Acao_marketing_estagios.elementAt(pos);
            f.setEstagio_cdgo((r.getEstagio_cdgo() != null) ? r.getEstagio_cdgo() + "":"");
            f.setDescricao((r.getDescricao() != null) ? r.getDescricao() + "":"");
            f.setOrdem((r.getOrdem() != null) ? com.egen.util.text.FormatNumber.format(r.getOrdem(), "0") : "");
            f.setPos("" + pos);
          } else {
            f.reset(mapping, request);
          }
        } else {
          f.reset(mapping, request);
        }
        session.setAttribute(mapping.getName(), form);
      }
    }
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      DynaActionForm _ge_grid = (DynaActionForm) form;
      SituacaoAcaoMarketing_mActionForm[]_ge_grid_array = (SituacaoAcaoMarketing_mActionForm[])_ge_grid.get("bl_form_Acao_marketing_estagios_lines");
      SituacaoAcaoMarketing_mActionForm f = _ge_grid_array[0];
      session.removeAttribute("res_Acao_marketing_estagios");
      com.egen.util.struts.AbstractActionHelper.resetForm("bl_form_Acao_marketing_estagios_lines", mapping, form, request);
      session.setAttribute(mapping.getName(), form);
      session.setAttribute("pos","0");
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Acao_marketing_estagios", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
