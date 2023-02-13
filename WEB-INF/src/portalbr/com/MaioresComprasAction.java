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
 * Creation Date 17/04/2020 10:33:05
 * Last Modify Date 17/04/2020 12:01:05
 */

public class MaioresComprasAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      MaioresComprasActionForm f = (MaioresComprasActionForm) form;
      util.consultas.Query query = new util.consultas.Query();
      com.beirario.brportal.util.DateUtil dateUtil = new com.beirario.brportal.util.DateUtil();
      util.file.GeraPDF g = new util.file.GeraPDF(request);

      g.setRelatorio("MaioresCompras.jasper");
      g.setParametro("P_DATA_INICIAL", dateUtil.parseDate(f.getDt_inicial()));
      g.setParametro("P_DATA_FINAL", dateUtil.parseDate(f.getDt_final()));
      if (!f.getTipo_mercado().equals("T")) {
        g.setParametro("P_TIPO_MERCADO", f.getTipo_mercado());
      }
      if (f.getTipo_mercado().equalsIgnoreCase("MI")) {
        g.setParametro("P_DESCRICAO_TIPO_MERCADO", "Mercado Interno");
      } else if (f.getTipo_mercado().equalsIgnoreCase("EX")) {
        g.setParametro("P_DESCRICAO_TIPO_MERCADO", "Mercado Externo");
      } else {
        g.setParametro("P_DESCRICAO_TIPO_MERCADO", "Todos");
      }
      if (f.getCodigo_regional() != null && !f.getCodigo_regional().isEmpty()) {
        g.setParametro("P_CODIGO_REGIONAL", f.getCodigo_regional());
        g.setParametro("P_DESCRICAO_REGIONAL", query.retorna(j, "select " + f.getCodigo_regional() + "||' - '||pck_regionais_vendas.get_nome(" + f.getCodigo_regional() + ") from dual"));
      } else {
        g.setParametro("P_DESCRICAO_REGIONAL", "Todas");
      }
      if (f.getRep_cdgo() != null && !f.getRep_cdgo().isEmpty()) {
        g.setParametro("P_REP_CDGO", f.getRep_cdgo());
        g.setParametro("P_DESCRICAO_REP_CDGO", query.retorna(j, "select " + f.getRep_cdgo() + "||' - '||pck_representante.get_razao_social('" + f.getRep_cdgo() + "') from dual"));
      } else {
        g.setParametro("P_DESCRICAO_REP_CDGO", "Todos");
      }
      if (f.getReg_cdgo() != null && !f.getReg_cdgo().isEmpty()) {
        g.setParametro("P_REG_CDGO", f.getReg_cdgo());
        g.setParametro("P_DESCRICAO_REG_CDGO", query.retorna(j, "select " + f.getReg_cdgo() + "||' - '||pck_regioes.get_nome('" + f.getReg_cdgo() + "') from dual"));
      } else {
        g.setParametro("P_DESCRICAO_REG_CDGO", "Todas");
      }
      if (f.getCodigo_marca() != null && !f.getCodigo_marca().isEmpty()) {
        g.setParametro("P_CODIGO_MARCA", f.getCodigo_marca());
        g.setParametro("P_DESCRICAO_MARCA", query.retorna(j, "select " + f.getCodigo_marca() + "||' - '||pck_marcas_produtos.get_nome(" + f.getCodigo_marca() + ") from dual"));
      } else {
        g.setParametro("P_DESCRICAO_MARCA", "Todas");
      }
      g.gerar();
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Dual", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      MaioresComprasActionForm f = (MaioresComprasActionForm) form;
      session.removeAttribute("res_Dual");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Dual", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
