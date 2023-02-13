package portalbr.adm;

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
 * Creation Date 07/06/2006 13:40:06
 * Last Modify Date 22/06/2015 15:28:34
 */

public class GruposAtivosAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //-------------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 07/06/2006
    // Objetivo          : Executa uma consulta na javaview:
    //                     portalbr.dbobj.view.Jw_grupos_ativos
    //-------------------------------------------------------------------------------------------
    // Data de Alteração :
    // Descrição         :
    //-------------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_grupos_ativos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    GruposAtivosActionForm f = (GruposAtivosActionForm) form;
    StringBuilder parametros = new StringBuilder();
    portalbr.dbobj.view.Jw_grupos_ativos table = new portalbr.dbobj.view.Jw_grupos_ativos();
    if ((!((f.getCod_marca() + "").equals("null")))) {
      parametros.append(" and mapr.codigo_marca = ").append(f.getCod_marca());
    }
    if ((!((f.getCod_regional() + "").equals("null")))) {
      parametros.append(" and reve.codigo_regional = ").append(f.getCod_regional());
    }
    if ((!((f.getCod_rep() + "").equals("null")))) {
      parametros.append(" and repr.rep_cdgo = ").append(f.getCod_rep());
    }

    StringBuilder query = new StringBuilder();
    query.append(" SELECT DISTINCT ");
    query.append("        grec.gre_grupo ");
    query.append("      , grec.gre_descricao ");
    query.append("   FROM cliente_representante     clre ");
    query.append("      , grupo_economico           grec ");
    query.append("      , representante_marca       rema ");
    query.append("      , rep                       repr ");
    query.append("      , regionais_vendas          reve ");
    query.append("      , marcas_produtos           mapr ");
    query.append("  WHERE clre.codigo_representante = repr.rep_cdgo ");
    query.append("    AND repr.rep_situ             = nvl(").append(session.getAttribute("situacao_representante")).append(",repr.rep_situ) ");
    query.append("    AND clre.situacao             = nvl(").append(session.getAttribute("situacao_cliente_representante")).append(",clre.situacao) ");
    query.append("    AND rema.situacao             = nvl(").append(session.getAttribute("situacao_representante_marca")).append(",rema.situacao) ");
    query.append("    AND grec.cli_cdgo             = clre.codigo_cliente ");
    query.append("    AND rema.codigo_representante = repr.rep_cdgo ");
    query.append("    AND reve.codigo_regional      = repr.codigo_regional ");
    query.append("    AND mapr.codigo_marca         = rema.marca_produto ");
    query.append("    AND mapr.codigo_marca         = nvl(").append(session.getAttribute("codigo_marca")).append(",mapr.codigo_marca) ");
    query.append("    AND reve.codigo_regional      = nvl(").append(session.getAttribute("codigo_regional")).append(",reve.codigo_regional) ");
    query.append(parametros.toString());

    Vector res_Jw_grupos_ativos = j.select(table, query.toString(), null);

    session.setAttribute("res_Jw_grupos_ativos",res_Jw_grupos_ativos);
    if (!(res_Jw_grupos_ativos != null && res_Jw_grupos_ativos.size() > 0)) {
      throw new Exception("Nenhum registro encontrado!");
    }
    session.setAttribute("mapping.getName()", form);
  }

}
