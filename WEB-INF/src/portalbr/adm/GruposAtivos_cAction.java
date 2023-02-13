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
 * Creation Date 07/06/2006 08:55:31
 * Last Modify Date 23/05/2013 10:23:06
 */

public class GruposAtivos_cAction extends com.egen.util.struts.AbstractAction {

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
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes_por_grupo", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    StringBuilder sb = new StringBuilder();
    if (session.getAttribute("codigo_representante") != null && !((String) session.getAttribute("codigo_representante")).equals("null")) {
      sb.append(" AND repr.rep_cdgo = '"+(String) session.getAttribute("codigo_representante") + "' ");
    }
    GruposAtivos_cActionForm f = (GruposAtivos_cActionForm) form;
    portalbr.dbobj.view.Jw_clientes_por_grupo table = new portalbr.dbobj.view.Jw_clientes_por_grupo();
    StringBuilder query = new StringBuilder();
    query.append(" SELECT cli_cdgo ");
    query.append("      , cli_nome ");
    query.append("      , cli_rzao ");
    query.append("      , to_char(max(data_ultima_compra),'dd/mm/yyyy') data_ultima_compra ");
    query.append("   FROM (SELECT DISTINCT ");
    query.append("                cli.cli_cdgo ");
    query.append("              , cli.cli_nome ");
    query.append("              , cli.cli_rzao ");
    query.append("              , rp.data_dig data_ultima_compra  ");
    query.append("           FROM cliente_representante clre ");
    query.append("              , grupo_economico       grec ");
    query.append("              , representante_marca   rema ");
    query.append("              , rep                   repr ");
    query.append("              , regionais_vendas      reve ");
    query.append("              , marcas_produtos       mapr  ");
    query.append("              , cli ");
    query.append("              , resumo_ped rp  ");
    query.append("          WHERE clre.codigo_representante = repr.rep_cdgo  ");
    query.append("            AND grec.gre_grupo            = ").append(f.getGre_grupo());
    query.append("            AND grec.gre_seqn             > 0 ");
    query.append("            AND cli.cli_cdgo              = clre.codigo_cliente  ");
    query.append("            AND grec.cli_cdgo             = clre.codigo_cliente  ");
    query.append("            AND rema.codigo_representante = repr.rep_cdgo ");
    query.append("            AND reve.codigo_regional      = repr.codigo_regional ");
    query.append("            AND mapr.codigo_marca         = rema.marca_produto  ");
    query.append("            AND rp.cli_cdgo               = cli.cli_cdgo  ");
    query.append("            AND rp.rep_cdgo               = repr.rep_cdgo ");
    query.append(sb.toString());
    query.append("            AND clre.situacao             = nvl(").append(session.getAttribute("situacao_cliente_representante")).append(",clre.situacao) ");
    query.append("            AND rema.situacao             = nvl(").append(session.getAttribute("situacao_representante_marca")).append(",rema.situacao) ");
    query.append("          UNION ALL ");
    query.append("         SELECT DISTINCT ");
    query.append("                cli.cli_cdgo ");
    query.append("              , cli.cli_nome ");
    query.append("              , cli.cli_rzao  ");
    query.append("              , rp.data_dig data_ultima_compra  ");
    query.append("           FROM cliente_representante clre ");
    query.append("              , grupo_economico       grec ");
    query.append("              , representante_marca   rema ");
    query.append("              , rep                   repr ");
    query.append("              , regionais_vendas      reve ");
    query.append("              , marcas_produtos       mapr  ");
    query.append("              , cli ");
    query.append("              , resumo_pedidos rp  ");
    query.append("          WHERE clre.codigo_representante =  repr.rep_cdgo ");
    query.append("            AND reve.codigo_regional      =  repr.codigo_regional ");
    query.append("            AND mapr.codigo_marca         =  rema.marca_produto ");
    query.append("            AND rema.codigo_representante =  repr.rep_cdgo ");
    query.append("            AND cli.cli_cdgo              =  clre.codigo_cliente ");
    query.append("            AND grec.cli_cdgo             =  clre.codigo_cliente ");
    query.append("            AND grec.gre_grupo            =  ").append(f.getGre_grupo());
    query.append("            AND grec.gre_seqn             >  0 ");
    query.append(sb.toString());
    query.append("            AND clre.situacao             =  nvl(").append(session.getAttribute("situacao_cliente_representante")).append(",clre.situacao) ");
    query.append("            AND rema.situacao             =  nvl(").append(session.getAttribute("situacao_representante_marca")).append(",rema.situacao) ");
    query.append("            AND rp.rep_cdgo               =  repr.rep_cdgo ");
    query.append("            AND rp.cli_cdgo               =  cli.cli_cdgo ) ");
    query.append("  GROUP BY cli_cdgo ");
    query.append("         , cli_nome ");
    query.append("         , cli_rzao ");
    query.append("  ORDER BY cli_cdgo ");

    Vector res_Jw_clientes_por_grupo = j.select(table, query.toString(), null);

    session.setAttribute("res_Jw_clientes_por_grupo",res_Jw_clientes_por_grupo);
    if (!(res_Jw_clientes_por_grupo != null && res_Jw_clientes_por_grupo.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes_por_grupo", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute("mapping.getName()", form);
  }
}
