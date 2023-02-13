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
 * Creation Date 08/03/2006 08:37:56
 * Last Modify Date 18/12/2014 08:58:28
 */

public class UltimoAcessoRepAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ultimo_acesso_rep", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    UltimoAcessoRepActionForm f = (UltimoAcessoRepActionForm) form;
    //-----------------------------
    String regional = "null";
    String tipo = "";
    String situacao = "";
    acesso.Usuario u = new acesso.Usuario();
    u = (acesso.Usuario) session.getAttribute("User");
    acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
    acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();

    if (!(u.getEntidadeNegocio() == null)) {
      ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
      tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
      tipo = tipoent.getTipo() + "";
      if (tipo.equals("REGIONAL DE VENDA")) {
        regional = ent.getChave() + "";
      } else {
        regional = "null";
      }
    }
    if ((f.getSituacao() + "").equals("null")) {
      situacao = "null";
    } else {
      situacao = "'"+f.getSituacao() + "'";
    }
    //-----------------------------
    portalbr.dbobj.view.Jw_ultimo_acesso_rep table = new portalbr.dbobj.view.Jw_ultimo_acesso_rep();
    StringBuilder query = new StringBuilder();
    query.append("  SELECT r.codigo_regional ");
    query.append("       , rv.nome_regional ");
    query.append("       , rep_cdgo codigo ");
    query.append("       , rep_rzao nome ");
    query.append("       , u.usua_dt_ultimo_acesso ");
    query.append("       , decode(r.rep_situ,'A','Ativo','I','Inativo') rep_situ ");
    query.append("    FROM brio.rep               r ");
    query.append("       , wbrio.usuarios         u ");
    query.append("       , regionais_vendas       rv ");
    query.append("       , wbrio.entidades_negocio e ");
    query.append("       , wbrio.tipos_entidade_negocio t ");
    query.append("   WHERE r.rep_cdgo             = replace(u.usua_usuario,'BRREP','') ");
    query.append("     AND r.codigo_regional      = rv.codigo_regional ");
    query.append("     AND u.usua_enne_id         = e.enne_id ");
    query.append("     AND e.enne_tien_id         = t.tien_id ");
    query.append("     AND t.tien_id              = 17 ");
    query.append("     AND rep_situ               = nvl(").append(situacao).append(",rep_situ) ");
    query.append("     AND r.codigo_regional      = nvl(").append(regional).append(",r.codigo_regional) ");
    query.append("   ORDER BY codigo_regional ");
    query.append("          , nome_regional ");
    query.append("          , usua_dt_ultimo_acesso DESC ");


    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      throw new Exception(query.toString());
    }

    Vector res_Jw_ultimo_acesso_rep = j.select(table, query.toString(), null);

    session.setAttribute("res_Jw_ultimo_acesso_rep",res_Jw_ultimo_acesso_rep);
    if (!(res_Jw_ultimo_acesso_rep != null && res_Jw_ultimo_acesso_rep.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ultimo_acesso_rep", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute("mapping.getName()", form);
  }
}
