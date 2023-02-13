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
 * Creation Date 02/09/2015 11:16:57
 * Last Modify Date 19/07/2022 10:09:15
 */

public class ArquivosTalao_gAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ArquivosTalao_gActionForm f = (ArquivosTalao_gActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_arquivos_talao", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    ArquivosTalao_gActionForm f = (ArquivosTalao_gActionForm) form;
    Jw_arquivos_talao table = new Jw_arquivos_talao();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"interface_arq_compra_id","=", com.egen.util.text.FormatNumber.toInteger(f.getInterface_arq_compra_id())}, };
    Vector res_Jw_arquivos_talao = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Jw_arquivos_talao",res_Jw_arquivos_talao);
    if (res_Jw_arquivos_talao != null && res_Jw_arquivos_talao.size() > 0) {
      Jw_arquivos_talao r = (Jw_arquivos_talao) res_Jw_arquivos_talao.elementAt(0);
      f.setInterface_arq_compra_id((r.getInterface_arq_compra_id() != null) ? r.getInterface_arq_compra_id() + "":"");
      f.setRem_nro((r.getRem_nro() != null) ? r.getRem_nro() + "":"");
      f.setOco_numero((r.getOco_numero() != null) ? r.getOco_numero() + "":"");
      f.setForn_codigo((r.getForn_codigo() != null) ? r.getForn_codigo() + "":"");
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_arquivos_talao", new ActionMessage("warn.norowsselected",""));
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
      ArquivosTalao_gActionForm f = (ArquivosTalao_gActionForm) form;
      boolean registraAlteracao = false;
      acesso.Sessao sessao = new acesso.Sessao(session);
      if (sessao.isFornecedorAtelier()) {
        registraAlteracao = true;
      }
      if (f.getTipo().equalsIgnoreCase("a")) {
        util.consultas.com.InterfaceArqCompra interfaceArqCompra = new util.consultas.com.InterfaceArqCompra();
        interfaceArqCompra.gerarTalao(f.getForn_codigo(), f.getOco_numero(), f.getArquivo(), request);
      } else if (f.getTipo().equalsIgnoreCase("v")) {
        if (registraAlteracao) {
          query.execute("INSERT INTO edi.interface_arq_compra_tal_log VALUES ("+((String) session.getAttribute("interface_arq_compra_id")) + ", " + (String) session.getAttribute("rem_nro") + ", "+(String) session.getAttribute("oco_numero") + ", 'V', sysdate, '"+sessao.getUsuario() + "')");
        }
      } else if (f.getTipo().equalsIgnoreCase("l")) {
        if (session.getAttribute("listagemParametros") != null) {
          java.util.List < String > listagemParametros = (java.util.List < String >) session.getAttribute("listagemParametros");
          for (String parametros :
              listagemParametros) {
            String[] param = parametros.split("#");
            if (registraAlteracao) {
              query.execute("INSERT INTO edi.interface_arq_compra_tal_log VALUES ("+param[0] + ", "+param[2] + ", "+param[1] + ", 'V', sysdate, '"+sessao.getUsuario() + "')");
            }
          }
        }
      } else {
        util.file.GeraPDF g = new util.file.GeraPDF(request);
        String materiais = "";
        if (session.getAttribute("codigo_materiais") != null) {
          materiais = " AND itm.cod_peca IN ("+(String) session.getAttribute("codigo_materiais") + ") ";
        }
        String espacamento = (String) session.getAttribute("arquivos_talao_filtro_espacamento") + "";
        if (espacamento.equalsIgnoreCase("3")) {
          g.setRelatorio("Talao3mm.jasper");
        } else {
          g.setRelatorio("Talao.jasper");
        }

        StringBuilder sbParametros = new StringBuilder();
        sbParametros.append(" AND it.rem_nro = " + f.getRem_nro());
        sbParametros.append(" AND it.oco_numero = " + f.getOco_numero());
        sbParametros.append(materiais);
        g.setParametro("P_QUERY", sbParametros.toString());
        g.setParametro("P_ORDER", (String) session.getAttribute("arquivos_talao_ordenacao"));
        g.gerar();
        if (registraAlteracao) {
          String existe = query.retorna("SELECT 's' FROM edi.interface_arq_compra_tal_log WHERE interface_arq_compra_id = "+f.getInterface_arq_compra_id() + " AND rem_nro = "+f.getRem_nro() + " and oco_numero = "+f.getOco_numero() + " AND situacao = 'G'");
          if (existe.equalsIgnoreCase("s")) {
            query.execute("UPDATE edi.interface_arq_compra_tal_log SET data_transacao = SYSDATE, usuario = '"+sessao.getUsuario() + "' WHERE interface_arq_compra_id = "+f.getInterface_arq_compra_id() + " AND rem_nro = "+f.getRem_nro() + " AND oco_numero = "+f.getOco_numero() + " AND situacao = 'G'");
          } else {
            query.execute("INSERT INTO edi.interface_arq_compra_tal_log VALUES ("+f.getInterface_arq_compra_id() + ", "+f.getRem_nro() + ", "+f.getOco_numero() + ", 'G', sysdate, '"+sessao.getUsuario() + "')");
          }
        }
        session.setAttribute("oco_numero", f.getOco_numero());
        session.setAttribute("rem_nro", f.getRem_nro());
        session.setAttribute("interface_arq_compra_id", f.getInterface_arq_compra_id());
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      e.printStackTrace(System.err);
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_arquivos_talao", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
