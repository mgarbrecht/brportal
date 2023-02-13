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
 * Creation Date 14/07/2006 17:26:26
 * Last Modify Date 24/09/2020 12:26:33
 */

public class Sbr436Action extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      Sbr436ActionForm f = (Sbr436ActionForm) form;
      //--------------------------------------------------------------------------
      String relatorio = null;
      String codigo_regional = "";
      String codigo_representante = "";
      String codigo_analista = "";
      String tipo = "";
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
        if (tipo.equals("ANALISTA REGIONAL")) {
          codigo_analista = ent.getChave() + "";
        }
      }
      if (tipo.equals("ANALISTA REGIONAL")) {
        com.egen.util.jdbc.JdbcUtil j = null;
        try {
          j = new com.egen.util.jdbc.JdbcUtil();
          portalbr.dbobj.view.Jw_regional_analista table = new portalbr.dbobj.view.Jw_regional_analista();
          String[][] select = null;
          Object[][] where = { {"codigo_gerente","=",codigo_analista} };
          Vector res_Jw_regional_analista = j.select(table, select, where, null, null, null);
          if (res_Jw_regional_analista != null && res_Jw_regional_analista.size() > 0) {
            portalbr.dbobj.view.Jw_regional_analista r = (portalbr.dbobj.view.Jw_regional_analista) res_Jw_regional_analista.elementAt(0);
            codigo_regional = r.getCodigo_regional();
          }
        }
        finally {
          if (j != null) {
            j.close();
            j = null;
          }
        }
      }
      Runtime run = Runtime.getRuntime();
      StringBuilder parametros = new StringBuilder();
      // ------- verifica a data  ---------------------------
      java.text.SimpleDateFormat fData = new java.text.SimpleDateFormat("E");
      java.util.Date data_atual = new Date();
      String data_seg = "";
      String dia = "";
      int marca_rep = 0;
      java.util.Date data_alterada = null;
      int x = 0;
      String data_informada = f.getDia_inicial();

      while ((!dia.equals("Seg")) && (!dia.equals("Mon"))) {
        data_atual = com.egen.util.text.FormatDate.parseTimestamp(data_informada, "dd/MM/yyyy");
        data_seg = com.egen.util.text.FormatDate.format(FormatDate.addDate(data_atual, -x), "dd/MM/yyyy");
        data_alterada = com.egen.util.text.FormatDate.parseTimestamp(data_seg, "dd/MM/yyyy");
        dia = fData.format(data_alterada);
        x++;
      }
      f.setDia_inicial(data_seg);

      //--- Se o usuário tiver restrição de data ----------------------------------------------------------------------
      String diasRetroativos = "";
      com.egen.util.jdbc.JdbcUtil connection = null;
      try {
        connection = new com.egen.util.jdbc.JdbcUtil();
        portalbr.dbobj.table.Acessos_documentos_interfaces table = new portalbr.dbobj.table.Acessos_documentos_interfaces();
        String[][] select = null;
        Object[][] where = { {"Acdi_doin_id","=","114"}, {"Acdi_usua_id","=",u.getId()}, {"Acdi_dias_consulta_retroativa",">",0} };
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
        if (FormatDate.parseDate(f.getDia_inicial()).before(FormatDate.addDate(new Date(), -Integer.parseInt(diasRetroativos)))) {
          throw new Exception("Período inválido! Dia Inicial deve ser maior ou igual a: "+ FormatDate.format(FormatDate.addDate(new Date(), -Integer.parseInt(diasRetroativos)), "dd/MM/yyyy"));
        }
      }
      //---------------------------------------------------------------------------------------------------------------
      util.file.GeraPDF g = new util.file.GeraPDF(request);
      if ((f.getCli_antigos() + "").equals("S")) {
        relatorio = "sbr436_03.rdf";
      } else {
        relatorio = "sbr436.rdf";
      }


      acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
      if (usuario.mostraQuery()) {
        throw new Exception("Query não disponível! Relatório utilizado: " + relatorio);
      }

      g.setRelatorio(relatorio);

      g.setParametro("P_DATA", data_seg);
      if (f.getCodigo_marca() != "") {
        g.setParametro("P_MARCA", f.getCodigo_marca());
      }
      if ((!(codigo_regional.equals("")))) {
        g.setParametro("P_REGIAO", codigo_regional);
      } else {
        if ((!((f.getCodigo_regional() + "").equals("null"))) && f.getCodigo_regional() != "") {
          g.setParametro("P_REGIAO", f.getCodigo_regional());
        }
      }
      if (codigo_representante.equals("")) {
        if (f.getRep_cdgo() != "") {
          g.setParametro("P_REPRESENTANTE", f.getRep_cdgo());
        }
      } else {
        g.setParametro("P_REPRESENTANTE", codigo_representante);
      }
      if (f.getTipo().equals("m")) {
        g.setParametro("P_TIPO", "1");
      } else {
        g.setParametro("P_TIPO", "2");
      }
      if (f.getUnn_codigo() != "") {
        g.setParametro("P_UNIDADE", f.getUnn_codigo());
      }
      g.setParametro("P_DIARIO_SEMANAL", f.getTipo_diario_semanal());

      if ((f.getAbre_unidade() + "").equals("S")) {
        g.setParametro("P_ABRE_UNIDADE", "S");
      } else {
        g.setParametro("P_ABRE_UNIDADE", "N");
      }

      if ((f.getResumo() + "").equals("checked")) {
        g.setParametro("P_RESUMO","SIM");
      } else {
        g.setParametro("P_RESUMO","NAO");
      }
      if ((f.getCb_marca_rep() + "").equals("checked")) {
        g.setParametro("P_ABRE_MARCA_REP", "1");
      } else {
        g.setParametro("P_ABRE_MARCA_REP", "0");
      }
      g.setParametro("P_VENDA", f.getVenda());
      g.setParametro("P_TIPO_PEDIDO", f.getTipo_pedido());
      g.setParametro("P_DATA_INF", data_informada);
      g.setParametro("P_IND_ABERTO_FECHADO", f.getInd_aberto_fechado());
      g.setParametro("P_SITUACAO_ERC", f.getSituacaoERC());
      g.setUsuarioSenha("loja/loja");
      g.gerar();


      //---------------------------------------------------------------------------------------------------------------


      if ((f.getAbre_automaticamente() + "").equals("checked")) {
        request.setAttribute("abre_automaticamente","S");
      } else {
        request.setAttribute("abre_automaticamente","N");
      }

      actionForward = mapping.findForward("same");
    }
    catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }


  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      Sbr436ActionForm f = (Sbr436ActionForm) form;
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_refresh_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      Sbr436ActionForm f = (Sbr436ActionForm) form;
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
