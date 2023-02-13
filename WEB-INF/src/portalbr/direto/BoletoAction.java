package portalbr.direto;

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
 * Creation Date 08/06/2015 17:30:00
 * Last Modify Date 29/03/2016 13:25:31
 */

public class BoletoAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      BoletoActionForm f = (BoletoActionForm) form;
      select_action(j, mapping, form, request, response);
      if (request.getAttribute("arquivo") == null) {
        actionForward = new ActionForward(((String) request.getAttribute("arquivo")), true);
      } else {
        actionForward = new ActionForward(((String) request.getAttribute("arquivo")), true);
      }
    } catch (Exception e) {
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
  private void select_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    BoletoActionForm f = (BoletoActionForm) form;
    StringBuilder sbParametros = new StringBuilder();
    String parametro = f.getChave();
    String[] chaves = parametro.split(",");
    for (String chave :
        chaves) {
      String[] titulo = chave.replace("*", "!").split("!");
      if (sbParametros.length() == 0) {
        sbParametros.append(" ((f.tit_codigo = '" + titulo[2] + "' AND nvl(f.emp_empresa,NULL) = '" + titulo[0] + "' AND   f.tip_codigo = '"+ titulo[3] + "' AND f.fil_filial = '" + titulo[1] + "') ");
      } else {
        sbParametros.append(" OR (f.tit_codigo = '" + titulo[2] + "' AND nvl(f.emp_empresa,NULL) = '" + titulo[0] + "' AND   f.tip_codigo = '"+titulo[3] + "' AND f.fil_filial = '" + titulo[1] + "') ");
      }
    }
    if (sbParametros.length() > 0) {
      sbParametros.append(")");
      util.file.GeraPDF g = new util.file.GeraPDF(request);
      if (f.getPrt_codigo().equalsIgnoreCase("001")) {
        g.setRelatorio("BoletoBB.jasper");
      } else if (f.getPrt_codigo().equalsIgnoreCase("237")) {
        g.setRelatorio("BoletoBradesco.jasper");
      } else if (f.getPrt_codigo().equalsIgnoreCase("041")) {
        g.setRelatorio("BoletoBanrisul.jasper");
      } else {
        g.setRelatorio("BoletoSantander.jasper");
      }
      g.setParametro("P_WHERE", sbParametros.toString());
      g.gerarDireto(util.rand.Palavra.geraPalavra());
    }
    session.setAttribute(mapping.getName(), form);
  }
  public ActionForward perform_gerar_xml_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      BoletoActionForm f = (BoletoActionForm) form;
      StringBuilder sbParametros = new StringBuilder();
      String parametro = f.getChave();
      String[] chaves = parametro.split(",");
      for (String chave :
          chaves) {
        String[] titulo = chave.replace("*", "!").split("!");
        if (sbParametros.length() == 0) {
          sbParametros.append(" ((f.tit_codigo = '" + titulo[2] + "' AND nvl(f.emp_empresa,NULL) = '" + titulo[0] + "' AND   f.tip_codigo = '"+ titulo[3] + "' AND f.fil_filial = '" + titulo[1] + "') ");
        } else {
          sbParametros.append(" OR (f.tit_codigo = '" + titulo[2] + "' AND nvl(f.emp_empresa,NULL) = '" + titulo[0] + "' AND   f.tip_codigo = '"+titulo[3] + "' AND f.fil_filial = '" + titulo[1] + "') ");
        }
      }
      if (sbParametros.length() > 0) {
        sbParametros.append(")");
        util.boleto.GeracaoXML geracaoXml = new util.boleto.GeracaoXML(request);
        geracaoXml.gerar(f.getPrt_codigo(), sbParametros.toString());
      }
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
