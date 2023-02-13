package portalbr.acesso;

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
 * Creation Date 18/01/2006 10:12:09
 * Last Modify Date 08/10/2009 09:24:05
 */

public class TiposEntidadeNegocio_aAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //-------------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 18/01/2006
    // Objetivo          : Atualiza um registro da tabela tipos_entidades_negocio, redirecionando
    //                     para a lista com os tipos de entidade de negócio:
    //                     /acesso/ListaTiposEntidadeNegocioForm.jsp
    //-------------------------------------------------------------------------------------------
    // Data de Alteração :
    // Descrição         :
    //-------------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      update_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/acesso/ListaTiposEntidadeNegocioForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Tipos_entidade_negocio", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void update_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    TiposEntidadeNegocio_aActionForm f = (TiposEntidadeNegocio_aActionForm) form;
    portalbr.dbobj.table.Tipos_entidade_negocio table = new portalbr.dbobj.table.Tipos_entidade_negocio();
    table.setTien_id(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getTien_id()));
    table.setTien_tipo(f.getTien_tipo().toUpperCase());
    table.setTien_tabela(f.getTien_tabela());
    table.setTien_campos_descr(f.getTien_campos_descr());
    table.setTien_campos_chave(f.getTien_campos_chave());
    table.setTien_condicional(f.getTien_condicional());
    table.setTien_dias_consulta_retroativa(Integer.parseInt(f.getTien_dias_consulta_retroativa()));
    //-------------------------------------------------------------------------
    acesso.TipoEntidadeNegocioAPI tipoentidade = new acesso.TipoEntidadeNegocioAPI(j.getConn());
    tipoentidade.select(Integer.parseInt(f.getTien_id()));
    tipoentidade.setTipo(f.getTien_tipo());
    tipoentidade.setTabela(f.getTien_tabela());
    tipoentidade.setCamposDescricao(f.getTien_campos_descr());
    tipoentidade.setCamposChave(f.getTien_campos_chave());
    tipoentidade.setCondicao(f.getTien_condicional());
    tipoentidade.setDiasConsultaRetroativa(Integer.parseInt(f.getTien_dias_consulta_retroativa()));
    tipoentidade.update();
    //-------------------------------------------------------------------------
    Vector res_Tipos_entidade_negocio = (Vector) session.getAttribute("res_Tipos_entidade_negocio");
    if (res_Tipos_entidade_negocio != null) {
      res_Tipos_entidade_negocio.setElementAt(table, Integer.parseInt(f.getPos()));
    }
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_delete_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //-------------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 18/01/2006
    // Objetivo          : Exclui um registro da tabela tipos_entidades_negocio, redirecionando
    //                     para a lista com os tipos de entidade de negócio:
    //                     /acesso/ListaTiposEntidadeNegocioForm.jsp
    //-------------------------------------------------------------------------------------------
    // Data de Alteração :
    // Descrição         :
    //-------------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      delete_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/acesso/ListaTiposEntidadeNegocioForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Tipos_entidade_negocio", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void delete_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    TiposEntidadeNegocio_aActionForm f = (TiposEntidadeNegocio_aActionForm) form;
    //----------------------------------------------------------------------------------------------
    acesso.TipoEntidadeNegocioAPI tipoentidade = new acesso.TipoEntidadeNegocioAPI(j.getConn());
    tipoentidade.select(Integer.parseInt(f.getTien_id()));
    tipoentidade.delete();
    //----------------------------------------------------------------------------------------------
    Vector res_Tipos_entidade_negocio = (Vector) session.getAttribute("res_Tipos_entidade_negocio");
    if (res_Tipos_entidade_negocio != null && res_Tipos_entidade_negocio.size() > 0) {
      res_Tipos_entidade_negocio.removeElementAt(Integer.parseInt(f.getPos()));
    }
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_atualiza_entidades_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      TiposEntidadeNegocio_aActionForm f = (TiposEntidadeNegocio_aActionForm) form;
      //--------------------------------------------------------------------------------------------------
      acesso.EntidadeNegocioAPI entidade = new acesso.EntidadeNegocioAPI(j.getConn());
      acesso.TipoEntidadeNegocioAPI tipoentidade = new acesso.TipoEntidadeNegocioAPI(j.getConn());
      tipoentidade.select(Integer.parseInt(f.getTien_id()));
      entidade.atualiza(tipoentidade);
      //--------------------------------------------------------------------------------------------------
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Tipos_entidade_negocio", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
      }
      j = null;
    }
    return actionForward;
  }
  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      actionForward = new ActionForward("/acesso/ListaTiposEntidadeNegocioForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Tipos_entidade_negocio", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
}
