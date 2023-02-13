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
 * Creation Date 17/01/2006 16:38:16
 * Last Modify Date 27/08/2009 16:25:53
 */

public class ListaEntidadesNegocioAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //---------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 17/01/2006
    // Objetivo          : Redireciona para a tela de filtro de Entidades de Negócio:
    //                     /acesso/EntidadesNegocioForm.jsp
    //----------------------------------------------------------------------------------------
    // Data de Alteração :
    // Descrição         :
    //----------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      actionForward = new ActionForward("/acesso/EntidadesNegocioForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
  public ActionForward perform_gerar_usuarios_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ListaEntidadesNegocioActionForm f = (ListaEntidadesNegocioActionForm) form;
      java.util.Vector res_Entidades_negocio = (java.util.Vector) session.getAttribute("res_Entidades_negocio");
      //-----------------------------------------------------------------------------------------
      portalbr.dbobj.view.Jw_ent_neg_usuarios t_entidades_negocio = new portalbr.dbobj.view.Jw_ent_neg_usuarios();
      String nome = "";
      if (res_Entidades_negocio != null && res_Entidades_negocio.size() > 0) {
        for (int q = 0; q < res_Entidades_negocio.size(); q++) {
          t_entidades_negocio = (portalbr.dbobj.view.Jw_ent_neg_usuarios) res_Entidades_negocio.elementAt(q);
          acesso.UsuarioAPI usuario = new acesso.UsuarioAPI(j.getConn());
          acesso.EntidadeNegocioAPI enne = new acesso.EntidadeNegocioAPI(j.getConn());
          enne.select(Integer.parseInt(t_entidades_negocio.getEnne_id() + ""));
          usuario.setEntidadeNegocio((acesso.EntidadeNegocio) enne);
          nome = t_entidades_negocio.getEnne_descricao();
          nome = nome.replace("'","");
          if (nome.length() > 40) {
            nome = nome.substring(0, 40);
          }
          usuario.setNome(t_entidades_negocio.getEnne_descricao());
          usuario.setUsuario(t_entidades_negocio.getEnne_chave());
          usuario.setSenha("beirario".getBytes());
          usuario.setSuperUsuario(false);
          usuario.insert();
        }
      }
      //-----------------------------------------------------------------------------------------

      actionForward = mapping.findForward("same");
    }
    catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
}
