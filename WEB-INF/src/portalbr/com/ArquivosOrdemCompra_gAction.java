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
 * Creation Date 21/08/2015 09:23:57
 * Last Modify Date 18/07/2022 16:24:26
 */

public class ArquivosOrdemCompra_gAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ArquivosOrdemCompra_gActionForm f = (ArquivosOrdemCompra_gActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_arquivos_ordem_compra", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    ArquivosOrdemCompra_gActionForm f = (ArquivosOrdemCompra_gActionForm) form;
    Jw_arquivos_ordem_compra table = new Jw_arquivos_ordem_compra();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"interface_arq_compra_id","=", com.egen.util.text.FormatNumber.toInteger(f.getInterface_arq_compra_id())}, };
    Vector res_Jw_arquivos_ordem_compra = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Jw_arquivos_ordem_compra",res_Jw_arquivos_ordem_compra);
    if (res_Jw_arquivos_ordem_compra != null && res_Jw_arquivos_ordem_compra.size() > 0) {
      Jw_arquivos_ordem_compra r = (Jw_arquivos_ordem_compra) res_Jw_arquivos_ordem_compra.elementAt(0);
      f.setInterface_arq_compra_id((r.getInterface_arq_compra_id() != null) ? r.getInterface_arq_compra_id() + "":"");
      f.setOco_numero((r.getOco_numero() != null) ? r.getOco_numero() + "":"");
      f.setForn_codigo((r.getForn_codigo() != null) ? r.getForn_codigo() + "":"");
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_arquivos_ordem_compra", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      util.consultas.Query query = new util.consultas.Query();
      j = new com.egen.util.jdbc.JdbcUtil();
      util.consultas.Query queryUtil = new util.consultas.Query();
      boolean registraAlteracao = false;
      acesso.Sessao sessao = new acesso.Sessao(session);
      if (sessao.isFornecedorAtelier()) {
        registraAlteracao = true;
      }
      ArquivosOrdemCompra_gActionForm f = (ArquivosOrdemCompra_gActionForm) form;
      if (f.getTipo().equalsIgnoreCase("a")) {
        util.consultas.com.InterfaceArqCompra interfaceArqCompra = new util.consultas.com.InterfaceArqCompra();
        interfaceArqCompra.gerarOC(f.getOco_numero(), f.getForn_codigo(), f.getArquivo(), request);
      } else if (f.getTipo().equalsIgnoreCase("v")) {
        if (registraAlteracao) {
          queryUtil.execute("INSERT into edi.interface_arq_compra_oc_log values ("+((String) session.getAttribute("interface_arq_compra_id")) + ", "+(String) session.getAttribute("oco_numero") + ",'V', sysdate, '"+sessao.getUsuario() + "')");
        }
      } else if (f.getTipo().equalsIgnoreCase("l")) {
        if (session.getAttribute("listagemParametros") != null) {
          java.util.List < String > listagemParametros = (java.util.List < String >) session.getAttribute("listagemParametros");
          for (String parametros :
              listagemParametros) {
            String[] param = parametros.split("#");
            if (registraAlteracao) {
              queryUtil.execute("INSERT into edi.interface_arq_compra_oc_log values ("+param[0] + ", "+param[1] + ",'V', sysdate, '"+sessao.getUsuario() + "')");
            }
          }
        }
      } else {
        util.file.GeraPDF g = new util.file.GeraPDF(request);
        if (f.getTipo().equalsIgnoreCase("g")) {
          g.setRelatorio("OrdemCompra.jasper");
        } else if (f.getTipo().equalsIgnoreCase("r")) {
          g.setRelatorio("OrdemCompraRemessa.jasper");
        }
        StringBuilder sbParametros = new StringBuilder();
        sbParametros.append(" i.interface_arq_compra_id = " + f.getInterface_arq_compra_id());
        sbParametros.append(" AND i.oco_numero = " + f.getOco_numero());
        if (sessao.isFornecedorAtelier()) {
          sbParametros.append(" AND nvl(fo.for_codigo,null) = " + sessao.getChave() + " ");
        }
        g.setParametro("P_QUERY", sbParametros.toString());
        g.gerar();
        if (registraAlteracao) {
          String existe = queryUtil.retorna("SELECT 's' FROM edi.interface_arq_compra_oc_log WHERE interface_arq_compra_id = "+f.getInterface_arq_compra_id() + " AND oco_numero  = "+f.getOco_numero() + " AND situacao = 'G'");
          if (existe.equalsIgnoreCase("s")) {
            queryUtil.execute("UPDATE edi.interface_arq_compra_oc_log SET data_transacao = sysdate, usuario = '"+sessao.getUsuario() + "' WHERE interface_arq_compra_id = "+f.getInterface_arq_compra_id() + " AND oco_numero = "+f.getOco_numero() + " AND situacao = 'G'");
          } else {
            queryUtil.execute("INSERT into edi.interface_arq_compra_oc_log values ("+f.getInterface_arq_compra_id() + ", "+f.getOco_numero() + ",'G', sysdate, '"+sessao.getUsuario() + "')");
          }
        }
        session.setAttribute("oco_numero", f.getOco_numero());
        session.setAttribute("interface_arq_compra_id", f.getInterface_arq_compra_id());
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      e.printStackTrace();
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_arquivos_ordem_compra", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
}
