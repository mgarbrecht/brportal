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
 * Creation Date 18/10/2006 15:09:56
 * Last Modify Date 24/07/2021 11:08:35
 */

public class ComparativoVendasAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {

      ComparativoVendasActionForm f = (ComparativoVendasActionForm) form;
      if (f.getP_clientes().equals("") && f.getP_grupos().equals("")) {
        throw new Exception("Ao menos um cliente e/ou grupo deve ser informado!");
      }
      //---- testa se existem números no campo clientes/grupos ---
      int cont_cli = 0;
      for (int y = 0; y < f.getP_clientes().length(); y++) {
        if (!(f.getP_clientes().charAt(y) + "").equals(",")) {
          cont_cli++;
        }
      }
      if (cont_cli == 0 && f.getP_clientes() != "") {
        throw new Exception("Parâmetro inválido para clientes!");
      }

      int cont_gru = 0;
      for (int y = 0; y < f.getP_grupos().length(); y++) {
        if (!(f.getP_grupos().charAt(y) + "").equals(",")) {
          cont_gru++;
        }
      }
      if (cont_gru == 0 && f.getP_grupos() != "") {
        throw new Exception("Parâmetro inválido para grupos!");
      }
      //------------------ VERIFICA O TIPO DE USUARIO ----------------------------
      StringBuilder parametro_query_cliente = new StringBuilder();
      String tipo = "";
      acesso.Usuario u = new acesso.Usuario();
      u = (acesso.Usuario) session.getAttribute("User");
      acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
      acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();

      if (!(u.getEntidadeNegocio() == null)) {
        ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
        tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
        tipo = tipoent.getTipo() + "";
        if (tipo.equals("REGIONAL DE VENDA")) {
          parametro_query_cliente.append(" and r.codigo_regional = ").append(ent.getChave());
        }
        if ((tipo.equals("REPRESENTANTE COMERCIAL")) || (tipo.equals("REPRESENTANTE EXPORTACAO"))) {
          parametro_query_cliente.append(" and r.rep_cdgo = ").append(ent.getChave());
        }
      }
      //--------------------------------------------------------------------------
      j = new com.egen.util.jdbc.JdbcUtil();
      try {
        if (cont_cli > 0) {
          portalbr.dbobj.table.Cli table = new portalbr.dbobj.table.Cli();
          Vector res_Cli = new Vector();
          String[] v_clientes = f.getP_clientes().split(",");
          for (int x = 0; x < v_clientes.length; x++) {
            StringBuilder sb = new StringBuilder();
            sb.append(" SELECT DISTINCT ");
            sb.append("        c.cli_cdgo ");
            sb.append("   FROM cli c ");
            sb.append("      , cliente_representante cr ");
            sb.append("      , rep r ");
            sb.append("  WHERE c.cli_cdgo              = cr.codigo_cliente ");
            sb.append("    AND cr.codigo_representante = r.rep_cdgo ");
            sb.append("    AND c.cli_situ              = 'A' ");
            sb.append("    AND c.cli_cdgo              = ").append(v_clientes[x]);
            sb.append(parametro_query_cliente.toString());

            res_Cli = j.select(table, sb.toString(), null);

            if (res_Cli != null && res_Cli.size() == 0) {
              throw new Exception("Cliente inválido! : "+v_clientes[x]);
            }
          }
        }

        if (cont_gru > 0) {
          portalbr.dbobj.table.Grupo_economico table_grupos = new portalbr.dbobj.table.Grupo_economico();
          Vector res_Grupos = new Vector();
          String[] v_grupos = f.getP_grupos().split(",");
          for (int x = 0; x < v_grupos.length; x++) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" SELECT * ");
            sb2.append("   FROM grupos_economico ");
            sb2.append("  WHERE codigo = ").append(v_grupos[x]);

            res_Grupos = j.select(table_grupos, sb2.toString(), null);
            if (res_Grupos != null && res_Grupos.size() == 0) {
              throw new Exception("Grupo inválido! : "+v_grupos[x]);
            }
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
      util.file.GeraPDF g = new util.file.GeraPDF(request);
      g.setRelatorio("sbr075.rdf");
      g.setParametro("DATA_INI", f.getDt_inicial());
      g.setParametro("DATA_FIM", f.getDt_final());
      if (f.getP_clientes() != "") {
        g.setParametro("P_CLIENTES", f.getP_clientes());
      }
      if (f.getP_grupos() != "") {
        g.setParametro("P_GRUPOS", f.getP_grupos());
      }
      g.setParametro("P_ABRE_POR_CABEDAL", "N");
      if (f.getCodigo_marca().equals("")) {
      } else {
        g.setParametro("P_MARCA", f.getCodigo_marca());
      }
      acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
      if (usuario.mostraQuery()) {
        throw new Exception("Query não disponível! Relatório utilizado: sbr075.rdf");
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
      ComparativoVendasActionForm f = (ComparativoVendasActionForm) form;
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
