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
 * Creation Date 13/04/2006 14:23:12
 * Last Modify Date 19/10/2012 13:03:13
 */

public class AdministradorPedidos_dAction extends com.egen.util.struts.AbstractAction {

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
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_web_poi_detalhes", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    AdministradorPedidos_dActionForm f = (AdministradorPedidos_dActionForm) form;
    portalbr.dbobj.view.Jw_web_poi_detalhes table = new portalbr.dbobj.view.Jw_web_poi_detalhes();
    f.setLin_cdgo(f.getLinha());
    if (!(f.getRef_cdgo().equals("null"))) {
      f.setLin_cdgo(f.getLinha() + "."+f.getRef_cdgo());
    }

    StringBuilder query = new StringBuilder();
    query.append(" SELECT l.lin_nome ");
    query.append("      , t.cod_filial fil ");
    query.append("      , substr(min(to_char(t.periodo,'099')||to_char(c.data,'DD/MM/YYYY')),02,03) pe ");
    query.append("      , substr(min(to_char(t.periodo,'099')||to_char(c.data,'DD/MM/YYYY')),05,10) dt ");
    query.append("      , max(to_char(c.data,'DD/MM/YYYY')) dtf ");
    query.append("      , max(t.capacidade_pares) capacidade ");
    query.append("      , max(t.venda_pares) vendido ");
    query.append("      , decode(t.situacao,'F','Fechado','Aberto') situacao ");
    query.append("      , fnc_pares_retidos_credito( to_date( substr(min(to_char(t.periodo,'099')||to_char(c.data,'DD/MM/YYYY')),05,10),'dd/mm/yyyy' ), to_date( max(to_char(c.data,'DD/MM/YYYY')),'dd/mm/yyyy' ), ").append(f.getLinha()).append(" ) bloq ");
    query.append("   FROM calendarios_semanal c ");
    query.append("      , lin l ");
    query.append("      , toneis t ");
    query.append("  WHERE t.ano           =  to_number(to_char(c.data,'yyyy')) ");
    query.append("    AND t.periodo       =  c.periodo ");
    query.append("    AND trunc(c.data)   >= trunc(to_date('").append(f.getDt()).append("','dd/mm/yyyy'),'mm') ");
    query.append("    AND trunc(c.data)   <= trunc(last_day(to_date('").append(f.getDt()).append("','dd/mm/yyyy'))) ");
    query.append("    AND t.cod_empresa   =  '01' ");
    query.append("    AND c.cod_empresa   =  '01' ");
    query.append("    AND t.cod_filial    =  c.cod_filial ");
    query.append("    AND t.lin_codigo    =  l.lin_cdgo ");
    query.append("    AND t.lin_codigo    =  ").append(f.getLinha());
    query.append("    AND t.lin_codigo    >  0 ");
    query.append("    AND t.ref_codigo    =  decode(").append(f.getRef_cdgo()).append(",null,t.ref_codigo,").append(f.getRef_cdgo()).append(")  ");
    query.append("  GROUP BY l.lin_nome ");
    query.append("         , t.cod_filial ");
    query.append("         , t.periodo ");
    query.append("         , t.situacao ");
    query.append("  ORDER BY t.cod_filial ");
    query.append("         , t.periodo ");

    Vector res_Jw_web_poi_detalhes = j.select(table, query.toString(), null);

    session.setAttribute("res_Jw_web_poi_detalhes",res_Jw_web_poi_detalhes);
    if (res_Jw_web_poi_detalhes != null && res_Jw_web_poi_detalhes.size() > 0) {
      portalbr.dbobj.view.Jw_web_poi_detalhes r = (portalbr.dbobj.view.Jw_web_poi_detalhes) res_Jw_web_poi_detalhes.elementAt(0);
      f.setLin_nome((r.getLin_nome() != null) ? r.getLin_nome() + "":"");
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_web_poi_detalhes", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute(mapping.getName(), form);
  }

}
