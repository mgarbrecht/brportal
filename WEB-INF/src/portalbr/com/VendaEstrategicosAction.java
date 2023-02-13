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
 * Creation Date 17/09/2014 08:49:14
 * Last Modify Date 22/06/2015 17:01:59
 */

public class VendaEstrategicosAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      acesso.Sessao sessao = new acesso.Sessao(session);
      VendaEstrategicosActionForm f = (VendaEstrategicosActionForm) form;
      String mostrarPreco = null;
      String imprimeImagens = null;
      boolean painel = false;
      //----------------------------------------------------------
      if ((f.getCb_painel() + "").equals("checked")) {
        painel = true;
      }
      //----------------------------------------------------------
      if ((f.getCb_preco() + "").equals("checked")) {
        mostrarPreco = "S";
      } else {
        mostrarPreco = "N";
      }
      //----------------------------------------------------------
      if ((f.getCb_img_prod() + "").equals("checked")) {
        imprimeImagens = "S";
      } else {
        imprimeImagens = "N";
      }
      //----------------------------------------------------------

      util.file.GeraPDF g = new util.file.GeraPDF(request);
      if (painel) {
        g.setRelatorio("VendaEstrategicosSimplificado.jasper");
      } else {
        g.setRelatorio("VendaEstrategicos.jasper");
      }
      g.setParametro("P_CODIGO_MARCA", new java.math.BigDecimal(f.getMarca_cdgo()));
      if (f.getGrade() != "" && painel) {
        g.setParametro("P_GDE_CDGO", new java.math.BigDecimal(f.getGrade()));
      }
      if (f.getLin_cdgo() != "") {
        g.setParametro("P_LIN_CDGO", new java.math.BigDecimal(f.getLin_cdgo()));
      }
      if (f.getRef_cdgo() != "") {
        g.setParametro("P_REF_CDGO", new java.math.BigDecimal(f.getRef_cdgo()));
      }
      if (f.getCab_cdgo() != "") {
        g.setParametro("P_CAB_CDGO", new java.math.BigDecimal(f.getCab_cdgo()));
      }
      if (f.getCor_cdgo() != "") {
        g.setParametro("P_COR_CDGO", new java.math.BigDecimal(f.getCab_cdgo()));
      }
      if (!painel) {
        g.setParametro("P_IMPRIMIR_IMAGENS", imprimeImagens);
        g.setParametro("P_MOSTRAR_PRECO", mostrarPreco);
      }
      g.setParametro("P_MIX", f.getMix());
      if (f.getQtde_ini() != "") {
        g.setParametro("P_QTDE_INICIAL", new java.math.BigDecimal(f.getQtde_ini()));
      }
      if (f.getQtde_fim() != "") {
        g.setParametro("P_QTDE_FINAL", new java.math.BigDecimal(f.getQtde_fim()));
      }



      /*
          if((sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")) || (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO"))){
             g.setParametro("P_REP_CDGO", sessao.getChave());
          }
          if(sessao.getTipoEntidadeNegocio().equals("ANALISTA REGIONAL")){
             g.setParametro("P_CODIGO_ANALISTA", sessao.getChave());
          }
          if(sessao.getTipoEntidadeNegocio().equals("REGIONAL DE VENDA")){
             g.setParametro("P_CODIGO_REGIONAL", sessao.getChave());
          }
          */

      g.gerar();
      //--------------------------------------------------------------------------
      request.setAttribute("abre_automaticamente","N");
      //----------------------------------------------------------
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
  private void select_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    VendaEstrategicosActionForm f = (VendaEstrategicosActionForm) form;
    session.setAttribute(mapping.getName(), form);
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      VendaEstrategicosActionForm f = (VendaEstrategicosActionForm) form;
      form.reset(mapping, request);
      session.removeAttribute("tipos_estoque");
      session.removeAttribute("tipos_produtos");
      session.removeAttribute("cod_produto");
      session.removeAttribute("codigos_estoque");
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
  public ActionForward perform_refresh_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      VendaEstrategicosActionForm f = (VendaEstrategicosActionForm) form;
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
