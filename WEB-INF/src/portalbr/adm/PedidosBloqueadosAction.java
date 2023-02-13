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
 * Creation Date 07/04/2006 09:28:36
 * Last Modify Date 18/12/2014 09:51:35
 */

public class PedidosBloqueadosAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //---------------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 07/04/2006
    // Objetivo          : Executa uma consulta na view portalbr.dbobj.view.Jw_pedidos_bloqueados,
    //                     redirecionando para a tela de relatório:
    //                     /adm/PedidosBloqueados_rForm.jsp
    //---------------------------------------------------------------------------------------------
    // Data de Alteração :
    // Descrição         :
    //---------------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      StringBuilder dti = new StringBuilder();
      StringBuilder dtf = new StringBuilder();
      j = new com.egen.util.jdbc.JdbcUtil();
      PedidosBloqueadosActionForm f = (PedidosBloqueadosActionForm) form;
      select_action(j, mapping, form, request, response);

      if (((f.getDt_inicial() + "").equals("")) || ((f.getDt_inicial() + "").equals("null"))) {
        dti.append("01/01/2000");
      } else {
        dti.append(f.getDt_inicial());
      }

      if (((f.getDt_final() + "").equals("")) || ((f.getDt_final() + "").equals("null"))) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.add(java.util.Calendar.YEAR, 1);
        java.text.SimpleDateFormat fData = new java.text.SimpleDateFormat("dd/MM/yyyy");
        dtf.append(fData.format(c.getTime()));
      } else {
        dtf.append(f.getDt_final());
      }
      session.setAttribute("parametro1",dti.toString());
      session.setAttribute("parametro2",dtf.toString());
      actionForward = new ActionForward("/adm/PedidosBloqueados_rForm.do?dt_inicial="+dti.toString() + "&dt_final="+dtf.toString(), true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_pedidos_bloqueados", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    PedidosBloqueadosActionForm f = (PedidosBloqueadosActionForm) form;
    StringBuilder parametros = new StringBuilder();
    String data_inicial = "null";
    String data_final = "null";
    String codigo_regional = "";
    String codigo_representante = "";
    String tipo = "";
    String parametro_dias_retroativos = "";
    acesso.Usuario u = new acesso.Usuario();
    u = (acesso.Usuario) session.getAttribute("User");
    acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
    acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();
    if (!(u.getEntidadeNegocio() == null)) {
      ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
      tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
      tipo = tipoent.getTipo() + "";
      if (tipo.equals("REGIONAL DE VENDA")) {
        codigo_regional = ent.getChave() + "";
      }
      if ((tipo.equals("REPRESENTANTE COMERCIAL")) || (tipo.equals("REPRESENTANTE EXPORTACAO"))) {
        codigo_representante = ent.getChave() + "";
      }
    }

    //--- Se o usuário tiver restrição de data ----------------------------------------------------------------------
    String diasRetroativos = "";
    com.egen.util.jdbc.JdbcUtil connection = null;
    try {
      connection = new com.egen.util.jdbc.JdbcUtil();
      portalbr.dbobj.table.Acessos_documentos_interfaces table = new portalbr.dbobj.table.Acessos_documentos_interfaces();
      String[][] select = null;
      Object[][] where = { {"Acdi_doin_id","=","79"}, {"Acdi_usua_id","=",u.getId()}, {"Acdi_dias_consulta_retroativa",">",0} };
      Vector res_Acessos_documentos_interfaces = connection.select(table, select, where, null, null, null);
      if (res_Acessos_documentos_interfaces != null && res_Acessos_documentos_interfaces.size() > 0) {
        portalbr.dbobj.table.Acessos_documentos_interfaces r = (portalbr.dbobj.table.Acessos_documentos_interfaces) res_Acessos_documentos_interfaces.elementAt(0);
        diasRetroativos = r.getAcdi_dias_consulta_retroativa() + "";
      } else {
        if (u.getDiasConsultaRetroativa() != null && u.getDiasConsultaRetroativa() > 0) {
          diasRetroativos = u.getDiasConsultaRetroativa() + "";
        }
      }
    } catch (Exception e) {
      throw e;
    } finally {
      if (connection != null) {
        connection.close();
        connection = null;
      }
    }

    if ((!(diasRetroativos.equals(""))) && (!(diasRetroativos.equals("0")))) {
      parametro_dias_retroativos = " AND trunc(p.ped_dadg) > trunc(sysdate-"+diasRetroativos + ") ";
    }

    //----------------------------------------------------------
    if (f.getCodigo_regional() != "") {
      if ((!((f.getCodigo_regional() + "").equals("null")))) {
        parametros.append(" AND r.codigo_regional = ").append(f.getCodigo_regional());
      }
    }
    //--- se o usuário logado for administrador --------------
    if ((codigo_representante.equals("")) && (codigo_regional.equals(""))) {
      if ((!(codigo_regional.equals("")))) {
        parametros.append(" AND  r.codigo_regional = ").append(codigo_regional);
      }
    }

    //------- Se o usuário logado for regional ---------------
    if ((!(codigo_regional.equals("")))) {
      parametros.append(" AND r.codigo_regional = ").append(codigo_regional);
    }

    //-------Se o usuário logado for representante -----------
    if ((!(codigo_representante.equals("")))) {
      parametros.append(" AND r.rep_cdgo  = ").append(codigo_representante);
    }

    //--------------------------------------------------------

    portalbr.dbobj.view.Jw_pedidos_bloqueados table = new portalbr.dbobj.view.Jw_pedidos_bloqueados();
    if ((f.getDt_inicial() + "") != "" && (!((f.getDt_inicial() + "").equals("null")))) {
      data_inicial = " to_date('"+f.getDt_inicial() + "','dd/mm/yyyy')";
    }

    if ((f.getDt_final() + "") != "" && (!((f.getDt_final() + "").equals("null")))) {
      data_final = " to_date('"+f.getDt_final() + "','dd/mm/yyyy')";
    }

    StringBuilder query = new StringBuilder();
    query.append(" SELECT r.rep_cdgo ");
    query.append("      , r.rep_cdgo||' - '||r.rep_rzao representante ");
    query.append("      , p.ped_det entrega ");
    query.append("      , to_char(p.ped_dadg,'dd/mm/yyyy') digitacao ");
    query.append("      , p.cli_cdgo ");
    query.append("      , c.cli_rzao ");
    query.append("      , p.ped_nmro ");
    query.append("      , decode(p.ped_tipo,'PG','Programado','EX','Exportação','PP','Ped. Pronto') tipo ");
    query.append("      , p.ped_nped ");
    query.append("      , to_char(add_months(sysdate,12),'dd/mm/yyyy') dt_final ");
    query.append("   FROM ped p ");
    query.append("      , cli c ");
    query.append("      , rep r ");
    query.append("  WHERE p.cli_cdgo         =  c.cli_cdgo ");
    query.append("    AND r.rep_cdgo         =  p.rep_cdgo ");
    query.append("    AND p.ped_stat         =  'P' ");
    query.append("    AND p.emp_empresa      =  '01' ");
    query.append("    AND p.ped_det          >= nvl(").append(data_inicial).append(",TO_DATE('01/01/2000', 'dd/mm/yyyy')) ");
    query.append("    AND p.ped_det          <= nvl(").append(data_final).append(",(add_months(sysdate,12))) ");
    query.append(parametros.toString());
    query.append(parametro_dias_retroativos);
    query.append("  ORDER BY to_number(r.rep_cdgo) ");
    query.append("         , p.cli_cdgo ");
    query.append("         , p.ped_nmro ");


    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      throw new Exception(query.toString());
    }

    Vector res_Jw_pedidos_bloqueados = j.select(table, query.toString(), null);

    session.setAttribute("res_Jw_pedidos_bloqueados",res_Jw_pedidos_bloqueados);
    if (!(res_Jw_pedidos_bloqueados != null && res_Jw_pedidos_bloqueados.size() > 0)) {
      throw new Exception("Nenhum registro encontrado!");
    }
    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      PedidosBloqueadosActionForm f = (PedidosBloqueadosActionForm) form;
      session.removeAttribute("res_Jw_pedidos_bloqueados");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_pedidos_bloqueados", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
