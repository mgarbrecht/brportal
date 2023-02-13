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
 * Creation Date 20/07/2010 09:48:08
 * Last Modify Date 23/06/2015 09:01:28
 */

public class NormasVendasAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      NormasVendasActionForm f = (NormasVendasActionForm) form;
      session.removeAttribute("retrato");
      session.removeAttribute("paisagem");
      acesso.Sessao sessao = new acesso.Sessao(session);
      acesso.Usuario user = (acesso.Usuario) session.getAttribute("User");
      if (user.mostraQuery()) {
        throw new Exception("Query não disponível! Relatório utilizado: sbr0031L.rdf");
      }

      util.file.GeraPDF pdf = new util.file.GeraPDF(request);
      pdf.setRelatorio("sbr0031L.rdf");
      pdf.setParametro("P_MIX_EXPORTACAO", f.getMix_exportacao());
      pdf.setParametro("P_LINHA", f.getLin_cdgo());
      pdf.setParametro("P_PUBLICADA", f.getPublicadas());
      pdf.setParametro("P_IMPRIMIR_RESUMO_LINHA", f.getResumo_linhas());


      if (sessao.getTipoEntidadeNegocio().equals("REGIONAL DE VENDA")) {
        pdf.setParametro("P_REGIONAL", sessao.getChave());
      }
      if ((sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")) || (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO"))) {
        pdf.setParametro("P_REPRESENTANTE", sessao.getChave());
      }
      if (sessao.getTipoEntidadeNegocio().equals("CLIENTE MERCADO EXTERNO") || sessao.getTipoEntidadeNegocio().equals("CLIENTE MERCADO INTERNO")) {
        pdf.setParametro("P_CLIENTE", sessao.getChave());
      }

      /*
              if(sessao.getUsuario().equals("151563") ||
                    sessao.getUsuario().equals("151489") ||
                    sessao.getUsuario().equals("151169") ||
                    sessao.getUsuario().equals("151882") ||
                    sessao.getUsuario().equals("VANDERLEI") ||
                    sessao.getUsuario().equals("MARIBEL") ||
                    sessao.getUsuario().equals("151315") ||
                    sessao.getUsuario().equals("151643") ||
                    sessao.getUsuario().equals("151803") ||
                    sessao.getUsuario().equals("151542") ||
                    sessao.getUsuario().equals("151889") ||
                    user.isSuperUsuario()){

                  pdf.setParametro("P_MOSTRA_MODARE", "S");
                  pdf.setParametro("P_MARCA", f.getModare());
              } else {
                  pdf.setParametro("P_MOSTRA_MODARE", "N");
                  pdf.setParametro("P_MARCA", f.getCodigo_marca());
              }
          */
      pdf.setParametro("P_MOSTRA_MODARE", "S");
      pdf.setParametro("P_MARCA", f.getModare());

      String paisagem = pdf.gerarArquivo();
      session.setAttribute("paisagem", paisagem);
      //--------------------------------------------------------------------------
      actionForward = mapping.findForward("same");
    }
    catch (Exception e) {
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
      NormasVendasActionForm f = (NormasVendasActionForm) form;
      form.reset(mapping, request);
      session.removeAttribute("retrato");
      session.removeAttribute("paisagem");
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
