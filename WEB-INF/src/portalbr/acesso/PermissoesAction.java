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
 * Creation Date 19/10/2009 10:36:24
 * Last Modify Date 15/08/2016 12:30:11
 */

public class PermissoesAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      PermissoesActionForm f = (PermissoesActionForm) form;
      select_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/acesso/Permissoes_rForm.jsp", true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_permissoes", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    PermissoesActionForm f = (PermissoesActionForm) form;
    Jw_consulta_permissoes table = new Jw_consulta_permissoes();
    StringBuilder parametro1 = new StringBuilder();
    StringBuilder parametro2 = new StringBuilder();
    StringBuilder parametro3 = new StringBuilder();
    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");

    session.removeAttribute("res_Jw_consulta_permissoes");
    session.removeAttribute("res_Jw_consulta_permissoes_documentos_interfaces");

    if (f.getTien_id().equals("") && f.getEnne_id().equals("") && f.getDoin_id().equals("") && f.getUsua_id().equals("")) {
      throw new Exception("Informe um dos parâmetros!");
    }

    if (f.getDoin_id() != "") {

      Jw_consulta_permissoes_documentos_interfaces tabled = new Jw_consulta_permissoes_documentos_interfaces();
      String[][] select = null;
      Object[][] where = { {"doin_id","=", com.egen.util.text.FormatNumber.toDouble(f.getDoin_id())} };

      if (usuario.mostraQuery()) {
        throw new Exception("Query não disponível. Javaview utilizada: Jw_consulta_permissoes_documentos_interfaces");
      }

      Vector res_Jw_consulta_permissoes_documentos_interfaces = j.select(tabled, select, where, null, null, null);
      session.setAttribute("res_Jw_consulta_permissoes_documentos_interfaces",res_Jw_consulta_permissoes_documentos_interfaces);
      if (!(res_Jw_consulta_permissoes_documentos_interfaces != null && res_Jw_consulta_permissoes_documentos_interfaces.size() > 0)) {
        throw new Exception("Nenhum registro encontrado!");
      }

    } else {

      if (f.getTien_id() != "") {
        parametro1.append(" and t.tien_id = ").append(f.getTien_id());
        parametro2.append(" and u.usua_id = -1");
        parametro3.append(" and u.usua_id = -1");
      }

      if (f.getEnne_id() != "") {
        parametro1.append(" and e.enne_id = ").append(f.getEnne_id());
        parametro2.append(" and e.enne_id = ").append(f.getEnne_id());
        parametro3.append(" and u.usua_id = -1");
      }

      if (f.getUsua_id() != "") {
        parametro1.append(" and u.usua_id = ").append(f.getUsua_id());
        parametro2.append(" and u.usua_id = ").append(f.getUsua_id());
        parametro3.append(" and u.usua_id = ").append(f.getUsua_id());
      }


      StringBuilder query = new StringBuilder();
      query.append(" select di.*, at.aten_dias_consulta_retroativa dias_consulta_retroativa ");
      query.append("   from wbrio.tipos_entidade_negocio t ");
      query.append("      , wbrio.entidades_negocio e ");
      query.append("      , wbrio.usuarios u ");
      query.append("      , wbrio.acessos_tipos_entidade_negocio at ");
      query.append("      , wbrio.documentos_interfaces di ");
      query.append("  where t.tien_id = e.enne_tien_id ");
      query.append("    and e.enne_id = u.usua_enne_id ");
      query.append("    and at.aten_tien_id = t.tien_id ");
      query.append("    and at.aten_doin_id = di.doin_id ");
      query.append(parametro1.toString());
      query.append("    and not exists (select 1 ");
      query.append("                      from wbrio.acessos_entidades_negocio ae ");
      query.append("                     where ae.acen_enne_id = e.enne_id ");
      query.append("                       and ae.acen_doin_id = at.aten_doin_id) ");
      query.append("    and not exists (select 1 ");
      query.append("                      from wbrio.acessos_usuarios au ");
      query.append("                     where au.acus_usua_id = u.usua_id ");
      query.append("                       and au.acus_doin_id = at.aten_doin_id) ");
      query.append("  UNION ");
      query.append(" select di.*, ae.acen_dias_consulta_retroativa dias_consulta_retroativa ");
      query.append("   from wbrio.entidades_negocio e ");
      query.append("      , wbrio.usuarios u ");
      query.append("      , wbrio.acessos_entidades_negocio ae ");
      query.append("      , wbrio.documentos_interfaces di ");
      query.append("  where e.enne_id = u.usua_enne_id ");
      query.append("    and ae.acen_enne_id = e.enne_id ");
      query.append("    and ae.acen_doin_id = di.doin_id ");
      query.append(parametro2.toString());
      query.append("    and not exists (select 1 ");
      query.append("                      from wbrio.acessos_usuarios au ");
      query.append("                     where au.acus_usua_id = u.usua_id ");
      query.append("                       and au.acus_doin_id = ae.acen_doin_id) ");
      query.append("  UNION ");
      query.append(" select di.*, au.acus_dias_consulta_retroativa dias_consulta_retroativa ");
      query.append("   from wbrio.usuarios u ");
      query.append("      , wbrio.acessos_usuarios au ");
      query.append("      , wbrio.documentos_interfaces di ");
      query.append("  where au.acus_usua_id = u.usua_id ");
      query.append("    and au.acus_doin_id = di.doin_id ");
      query.append(parametro3.toString());
      query.append("    and au.acus_negar_acesso = 'N' ");
      query.append("  order by 3 ");

      if (usuario.mostraQuery()) {
        throw new Exception(query.toString());
      }

      Vector res_Jw_consulta_permissoes = j.select(table, query.toString(), null);
      session.setAttribute("res_Jw_consulta_permissoes",res_Jw_consulta_permissoes);
      if (!(res_Jw_consulta_permissoes != null && res_Jw_consulta_permissoes.size() > 0)) {
        throw new Exception("Nenhum registro encontrado!");
      }

    }

    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      PermissoesActionForm f = (PermissoesActionForm) form;
      session.removeAttribute("res_Jw_consulta_permissoes");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_permissoes", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
