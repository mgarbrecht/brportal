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
 * Creation Date 01/04/2011 09:52:19
 * Last Modify Date 10/01/2020 11:08:21
 */

public class PedidosIndenizadosDescontos_fAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      PedidosIndenizadosDescontos_fActionForm f = (PedidosIndenizadosDescontos_fActionForm) form;
      //    util.consultas.Query query = new util.consultas.Query();
      //    int dias = Integer.parseInt(query.retorna("SELECT to_date('"+f.getData_final()+"','dd/mm/yyyy')-to_date('"+f.getData_inicial()+"','dd/mm/yyyy') FROM dual"));
      //    if(dias>31){
      //       throw new Exception("O período não pode ser maior do que 31 dias!");
      //    }


      StringBuilder sb = new StringBuilder();
      sb.append("");

      if (!f.getStatus().equals("")) {
        sb.append(" AND nvl(ped.ped_stat,NULL) = '"+f.getStatus() + "' ");
      }

      if (!f.getCodigo_regional().equals("")) {
        sb.append(" AND rv.codigo_regional = nvl("+f.getCodigo_regional() + ", rv.codigo_regional)");
      }

      if (!f.getRep_cdgo().equals("")) {
        sb.append(" AND r.rep_cdgo = nvl('"+f.getRep_cdgo() + "', r.rep_cdgo)");
      }

      if (!f.getPed_nmro().equals("")) {
        sb.append(" AND ped.ped_nmro = nvl("+f.getPed_nmro() + ", ped.ped_nmro)");
      }

      if (!f.getMarcas().equals("")) {
        sb.append(" AND EXISTS (SELECT 1 ");
        sb.append("               FROM ite i ");
        sb.append("              WHERE i.ped_nmro = ped.ped_nmro ");
        sb.append("                AND fct_marca_produto(i.lin_cdgo,i.ref_cdgo) = "+f.getMarcas() + ") ");
      }

      if (!f.getCli_cdgo().equals("")) {
        sb.append(" AND c.cli_cdgo = "+f.getCli_cdgo());
      }

      if (!f.getGre_grupo().equals("")) {
        sb.append(" AND NVL(pck_cliente.get_grupo_economico(ped.cli_cdgo), NULL) = " + f.getGre_grupo());
      }




      if (!f.getSituacao().equals("")) {
        sb.append(" AND nvl(pd.situacao,'N') = NVL('"+f.getSituacao() + "',pd.situacao) ");
      }

      if (!f.getData_inicial().equals("")) {
        sb.append(" AND ped.ped_dadg >= to_date('"+f.getData_inicial() + "','dd/mm/yyyy') ");
      }

      if (!f.getData_final().equals("")) {
        sb.append(" AND ped.ped_dadg < to_date('"+f.getData_final() + "','dd/mm/yyyy')+1 ");
      }

      if ((f.getCb_faturados() + "").equals("checked")) {
        sb.append(" AND nvl(ped.ped_stat,null) = 'F' ");
      }

      sb.append(" AND ped.ped_amostra_brinde IS NULL ");

      sb.append("AND EXISTS (SELECT 1 ");
      sb.append("FROM ite i ");
      sb.append("WHERE i.ped_nmro = ped.ped_nmro ");
      sb.append("AND i.lin_cdgo = NVL("+(f.getLin_cdgo().equals("") ? null : f.getLin_cdgo()) + ", i.lin_cdgo) ");
      sb.append("AND i.ref_cdgo = NVL("+(f.getRef_cdgo().equals("") ? null : f.getRef_cdgo()) + ", i.ref_cdgo) ");
      sb.append("AND i.cab_cdgo = NVL("+(f.getCab_cdgo().equals("") ? null : f.getCab_cdgo()) + ", i.cab_cdgo)) ");

      session.setAttribute("query", sb.toString());

      actionForward = mapping.findForward("same");
      actionForward = new ActionForward("/com/PedidosIndenizadosDescontosGrid.do?select_action=",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Parametros", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      PedidosIndenizadosDescontos_fActionForm f = (PedidosIndenizadosDescontos_fActionForm) form;
      session.removeAttribute("res_Parametros");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Parametros", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_blank_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      PedidosIndenizadosDescontos_fActionForm f = (PedidosIndenizadosDescontos_fActionForm) form;
      if (true) {
        throw new Exception("Nenhum registro encontrado!");
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Parametros", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
}
