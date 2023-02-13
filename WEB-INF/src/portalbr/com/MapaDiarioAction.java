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
 * Creation Date 26/05/2010 08:51:56
 * Last Modify Date 02/04/2013 17:23:50
 */

public class MapaDiarioAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      util.consultas.Parametros parametros = new util.consultas.Parametros();
      MapaDiarioActionForm f = (MapaDiarioActionForm) form;
      String retorno = "";
      util.file.ArquivosMapaDiario arquivos = new util.file.ArquivosMapaDiario();
      if (f.getCodigo_regional() != "") {
        int regional = Integer.parseInt(f.getCodigo_regional());
        retorno = arquivos.copiar(regional, f.getData());
      } else {
        retorno = arquivos.copiar(f.getData());
      }
      if ((retorno + "").equals("null")) {
        throw new Exception("Informação indisponível!");
      }
      if ((f.getAbre_automaticamente() + "").equals("checked")) {
        request.setAttribute("abre_automaticamente","S");
      } else {
        request.setAttribute("abre_automaticamente","N");
      }
      request.setAttribute("arquivo", parametros.retornaParametro("diretorio_link_pdf") + retorno);
      request.setAttribute("arquivo_docs", "http://brportal.beirario.com.br:8080/brportal/temp/" + retorno);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      MapaDiarioActionForm f = (MapaDiarioActionForm) form;
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
