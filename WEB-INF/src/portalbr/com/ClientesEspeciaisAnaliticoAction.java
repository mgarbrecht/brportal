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
 * Creation Date 10/11/2006 15:29:11
 * Last Modify Date 24/07/2021 10:51:56
 */

public class ClientesEspeciaisAnaliticoAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      ClientesEspeciaisAnaliticoActionForm f = (ClientesEspeciaisAnaliticoActionForm) form;
      acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
      if (usuario.mostraQuery()) {
        throw new Exception("Query não disponível! Relatório utilizado: cli0020.rdf");
      }
      //-------------------------------------------
      util.file.GeraPDF g = new util.file.GeraPDF(request);
      g.setRelatorio("cli0020.rdf");
      //-------------------------------------------
      j = new com.egen.util.jdbc.JdbcUtil();
      String codigo_regional = "0";
      String cli_cdgo = "0";
      String codigo_representante = "";
      String parametro_query = "";
      acesso.Sessao se = new acesso.Sessao(session);
      String tipo = se.getTipoEntidadeNegocio();
      acesso.Usuario us = (acesso.Usuario) session.getAttribute("User");
      if (tipo.equals("REGIONAL DE VENDA")) {
        codigo_regional = se.getChave();
        parametro_query = " and c.codigo_regional = "+codigo_regional;
      }
      if ((tipo.equals("REPRESENTANTE COMERCIAL")) || (tipo.equals("REPRESENTANTE EXPORTACAO"))) {
        codigo_representante = se.getChave();
        g.setParametro("P_REPRESENTANTE", codigo_representante);
        parametro_query = " and cr.codigo_representante = '"+codigo_representante + "' and cr.situacao = 'A' ";
      }

      //--------------------------------------------------------------------------
      if (!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")) {
        if (f.getCodigo_regional() != "") {
          codigo_regional = f.getCodigo_regional();
        }
        if (f.getReg() != "") {
          codigo_regional = f.getReg();
        }
      }

      if (f.getCli_cdgo() != "") {
        cli_cdgo = f.getCli_cdgo();
      }

      g.setParametro("P_CLIENTE", cli_cdgo);
      g.setParametro("P_REGIONAL", codigo_regional);
      //--- Verifica se o cliente pertence ao usuário --------------------------

      try {
        if (f.getCli_cdgo() != "") {
          portalbr.dbobj.table.Cliesp_clientes table = new portalbr.dbobj.table.Cliesp_clientes();
          StringBuilder query = new StringBuilder();
          query.append(" SELECT DISTINCT ");
          query.append("        codigo ");
          query.append("      , cliente ");
          query.append("      , tipo_cliente ");
          query.append("      , c.codigo_regional ");
          query.append("   FROM cliesp_clientes c ");
          query.append("      , cliente_representante cr ");
          query.append("  WHERE c.codigo = cr.codigo_cliente (+) ");
          query.append("    AND c.codigo = ").append(f.getCli_cdgo());
          query.append(parametro_query);


          Vector res_Cliesp_clientes = j.select(table, query.toString(), null);

          if (res_Cliesp_clientes == null || res_Cliesp_clientes.size() == 0) {
            throw new Exception("Cliente inválido!");
          }
        }

      } catch (Exception e) {
      } finally {
        if (j != null) {
          j.close();
          j = null;
        }
      }




      //--------------------------------------------------------------------------
      g.gerar();
      //--------------------------------------------------------------------------
      if ((f.getAbre_automaticamente() + "").equals("checked")) {
        request.setAttribute("abre_automaticamente","S");
      } else {
        request.setAttribute("abre_automaticamente","N");
      }
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
      ClientesEspeciaisAnaliticoActionForm f = (ClientesEspeciaisAnaliticoActionForm) form;
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
