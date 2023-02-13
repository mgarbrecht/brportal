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
 * Last Modify Date 16/11/2009 11:14:19
 */

public class GruposAtendidosAction extends com.egen.util.struts.AbstractAction {

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
    GruposAtendidosActionForm f = (GruposAtendidosActionForm) form;
    StringBuilder parametros = new StringBuilder();
    portalbr.dbobj.view.Jw_grupos_ativos table = new portalbr.dbobj.view.Jw_grupos_ativos();
    if ((!((f.getCod_marca() + "").equals("null")))) {
      parametros.append(" and res.codigo_marca = ").append(f.getCod_marca());
    }
    if ((!((f.getCod_regional() + "").equals("null")))) {
      parametros.append(" and res.codigo_regional = ").append(f.getCod_regional());
    }
    if ((!((f.getCod_rep() + "").equals("null")))) {
      parametros.append(" and res.rep_cdgo = ").append(f.getCod_rep());
    }

    StringBuilder query = new StringBuilder();
    query.append(" SELECT DISTINCT ");
    query.append("        gre_grupo ");
    query.append("      , gre_descricao ");
    query.append("   FROM ( ");
    query.append(" SELECT gre.gre_grupo ");
    query.append("      , gre.gre_descricao ");
    query.append("   FROM resumo_ped res ");
    query.append("      , cli ");
    query.append("      , rep ");
    query.append("      , cliente_representante clr ");
    query.append("      , representante_marca rm ");
    query.append("      , grupo_economico gre ");
    query.append("  WHERE res.data_dig             >= to_date('").append(session.getAttribute("dt_inicial")).append("','dd/MM/yyyy') ");
    query.append("    AND res.data_dig             <  to_date('").append(session.getAttribute("dt_final")).append("','dd/MM/yyyy')+1 ");
    query.append("    AND gre.cli_cdgo             =  cli.cli_cdgo");
    query.append("    AND cli.cli_cdgo             =  res.cli_cdgo ");
    query.append("    AND rep.rep_cdgo             =  res.rep_cdgo ");
    query.append("    AND res.esc_seqn             =  clr.codigo_sequencial ");
    query.append("    AND rm.marca_produto         =  res.codigo_marca ");
    query.append("    AND clr.codigo_representante =  rep.rep_cdgo ");
    query.append("    AND cli.cli_cdgo             =  clr.codigo_cliente ");
    query.append("    AND rm.codigo_representante  =  rep.rep_cdgo ");
    query.append("    AND cli.cli_situ             =  nvl('A',cli.cli_situ) ");
    query.append("    AND cli.seg_cdgo             NOT IN (9,153) ");
    query.append("    AND res.codigo_marca         =  nvl(").append(session.getAttribute("codigo_marca")).append(",res.codigo_marca) ");
    query.append("    AND rep.codigo_regional      =  nvl(").append(session.getAttribute("codigo_regional")).append(",rep.codigo_regional) ");
    query.append("    AND rep.rep_situ             =  nvl(").append(session.getAttribute("situacao_representante")).append(",rep.rep_situ) ");
    query.append("    AND clr.situacao             =  nvl(").append(session.getAttribute("situacao_cliente_representante")).append(",clr.situacao) ");
    query.append("    AND rm.situacao              =  nvl(").append(session.getAttribute("situacao_representante_marca")).append(",rm.situacao) ");
    query.append(parametros.toString());
    query.append("  UNION ALL ");
    query.append(" SELECT gre.gre_grupo ");
    query.append("      , gre.gre_descricao ");
    query.append("   FROM resumo_pedidos res ");
    query.append("      , cli ");
    query.append("      , rep ");
    query.append("      , cliente_representante clr ");
    query.append("      , representante_marca rm ");
    query.append("      , grupo_economico gre ");
    query.append("  WHERE res.data_dig             >= to_date('").append(session.getAttribute("dt_inicial")).append("','dd/MM/yyyy') ");
    query.append("    AND res.data_dig             <  to_date('").append(session.getAttribute("dt_final")).append("','dd/MM/yyyy')+1 ");
    query.append("    AND gre.cli_cdgo             =  cli.cli_cdgo ");
    query.append("    AND cli.cli_cdgo             =  res.cli_cdgo ");
    query.append("    AND rep.rep_cdgo             =  res.rep_cdgo ");
    query.append("    AND res.esc_seqn             =  clr.codigo_sequencial ");
    query.append("    AND rm.marca_produto         =  res.codigo_marca ");
    query.append("    AND clr.codigo_representante =  rep.rep_cdgo ");
    query.append("    AND cli.cli_cdgo             =  clr.codigo_cliente ");
    query.append("    AND rm.codigo_representante  =  rep.rep_cdgo ");
    query.append("    AND cli.cli_situ             =  nvl('A',cli.cli_situ) ");
    query.append("    AND cli.seg_cdgo             NOT IN (9,153) ");
    query.append("    AND res.codigo_marca         =  nvl(").append(session.getAttribute("codigo_marca")).append(",res.codigo_marca) ");
    query.append("    AND rep.codigo_regional      =  nvl(").append(session.getAttribute("codigo_regional")).append(",rep.codigo_regional) ");
    query.append("    AND rep.rep_situ             =  nvl(").append(session.getAttribute("situacao_representante")).append(",rep.rep_situ) ");
    query.append("    AND clr.situacao             =  nvl(").append(session.getAttribute("situacao_cliente_representante")).append(",clr.situacao) ");
    query.append("    AND rm.situacao              =  nvl(").append(session.getAttribute("situacao_representante_marca")).append(",rm.situacao) ");
    query.append(parametros.toString());
    query.append(" ) ");

    Vector res_Jw_grupos_ativos = j.select(table, query.toString(), null);

    session.setAttribute("res_Jw_grupos_ativos",res_Jw_grupos_ativos);

    if (!(res_Jw_grupos_ativos != null && res_Jw_grupos_ativos.size() > 0)) {
      throw new Exception("Nenhum registro encontrado!");
    }
    session.setAttribute("mapping.getName()", form);
  }

}
