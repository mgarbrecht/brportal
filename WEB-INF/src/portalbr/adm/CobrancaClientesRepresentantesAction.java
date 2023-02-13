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
import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * Creation Date 18/04/2006 17:02:01
 * Last Modify Date 24/07/2021 09:31:50
 */

public class CobrancaClientesRepresentantesAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_receber_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    java.sql.PreparedStatement pstm = null;
    java.sql.ResultSet rset = null;
    try {
      CobrancaClientesRepresentantesActionForm f = (CobrancaClientesRepresentantesActionForm) form;
      j = new com.egen.util.jdbc.JdbcUtil();
      String dt_ini = null;
      String dt_fin = null;
      String dt_inimm = null;
      String dt_quat = null;
      try {
        StringBuilder query = new StringBuilder();
        query.append(" SELECT max(periodo_referencia) ");
        query.append("      , last_day(max(periodo_referencia)) ");
        query.append("   FROM brcms.controles_periodos ");
        query.append("  WHERE situacao = 'F' ");
        pstm = j.getConn().prepareStatement(query.toString());
        rset = pstm.executeQuery();
        if (rset.next()) {
          dt_ini = FormatDate.format(rset.getDate(1));
          dt_fin = FormatDate.format(rset.getDate(2));
          dt_inimm = FormatDate.format(FormatDate.getFirstDayOfMonth(rset.getDate(1)), "MM/yyyy");
          dt_quat = FormatDate.format(FormatDate.getFirstDayOfMonth(FormatDate.mesAnterior(FormatDate.mesAnterior(FormatDate.mesAnterior(rset.getDate(1))))), "dd/MM/yyyy");
        }
      } catch (Exception e) {
      } finally {
        if (rset != null) {
          try {
            rset.close();
          } catch (java.sql.SQLException e) {}
        }
        if (pstm != null) {
          try {
            pstm.close();
          } catch (java.sql.SQLException e) {}

        }
        if (j != null) {
          j.close();
          j = null;
        }
      }
      Runtime run = Runtime.getRuntime();
      StringBuilder parametros = new StringBuilder();
      String codigo_representante = "";
      String tipo = "";
      String report = "";
      acesso.Usuario u = new acesso.Usuario();
      u = (acesso.Usuario) session.getAttribute("User");
      acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
      acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();
      if (!(u.getEntidadeNegocio() == null)) {
        ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
        tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
        tipo = tipoent.getTipo() + "";
        if ((tipo.equals("REPRESENTANTE COMERCIAL")) || (tipo.equals("REPRESENTANTE EXPORTACAO"))) {
          codigo_representante = ent.getChave() + "";
        }
      }
      String dt_atual = FormatDate.format(new java.util.Date(), "dd/MM/yyyy");
      util.file.GeraPDF g = new util.file.GeraPDF(request);
      //--- Adiantamento de comissão s/ faturamento - CMS5002 -----------------------------
      if (f.getArquivo().equals("CMS5002")) {
        report = "cms5002.rdf";
        g.setRelatorio(report);
        g.setParametro("P_DT_INI", dt_ini);
        g.setParametro("P_DT_FIN", dt_fin);
        g.setParametro("P_REP_INI", codigo_representante);
        g.setParametro("P_REP_FIN", codigo_representante);
      }
      //--- Comissões sobre liquidação pós-fechamento - CMS5020 ---------------------------
      if (f.getArquivo().equals("CMS5020")) {
        report = "cms5020.rdf";
        g.setRelatorio(report);
        g.setParametro("P_DT_INI", dt_ini);
        g.setParametro("P_DT_FIN", dt_fin);
        g.setParametro("P_REP_INI", codigo_representante);
        g.setParametro("P_REP_FIN", codigo_representante);
      }
      //--- Estorno de comissão indevida - CMS5005 ----------------------------------------
      if (f.getArquivo().equals("CMS5005")) {
        report = "cms5005.rdf";
        g.setRelatorio(report);
        g.setParametro("P_EMPRESA", "01");
        g.setParametro("P_DT_INI", dt_ini);
        g.setParametro("P_DT_FIN", dt_fin);
        g.setParametro("P_REP_INI", codigo_representante);
        g.setParametro("P_REP_FIN", codigo_representante);
      }
      //--- Estorno de adiant. de comissão s/ merc. devolv. - CMS5006  --------------------
      if (f.getArquivo().equals("CMS5006")) {
        report = "cms5006.rdf";
        g.setRelatorio(report);
        g.setParametro("P_EMPRESA", "01");
        g.setParametro("P_DT_INI", dt_ini);
        g.setParametro("P_DT_FIN", dt_fin);
        g.setParametro("P_REP_INI", codigo_representante);
        g.setParametro("P_REP_FIN", codigo_representante);
      }
      //--- Adiantamento de créd. refat. devoluções - CMS5007 -----------------------------
      if (f.getArquivo().equals("CMS5007")) {
        report = "cms5007.rdf";
        g.setRelatorio(report);
        g.setParametro("P_EMPRESA", "01");
        g.setParametro("P_DT_INI", dt_ini);
        g.setParametro("P_DT_FIN", dt_fin);
        g.setParametro("P_REP_INI", codigo_representante);
        g.setParametro("P_REP_FIN", codigo_representante);
      }
      //--- Estorno de adiant comissão por in - CMS5013 -----------------------------------
      if (f.getArquivo().equals("CMS5013")) {
        report = "cms5013.rdf";
        g.setRelatorio(report);
        g.setParametro("P_EMPRESA", "01");
        g.setParametro("P_DT_INI", dt_ini);
        g.setParametro("P_DT_FIN", dt_fin);
        g.setParametro("P_REP_INI", codigo_representante);
        g.setParametro("P_REP_FIN", codigo_representante);
      }
      //--- Adiantamento de comissão s/ faturamento vendor Valor - CMS5015 ----------------
      if (f.getArquivo().equals("CMS5015")) {
        report = "cms5015.rdf";
        g.setRelatorio(report);
        g.setParametro("P_DT_INI", dt_ini);
        g.setParametro("P_DT_FIN", dt_fin);
        g.setParametro("P_REP_INI", codigo_representante);
        g.setParametro("P_REP_FIN", codigo_representante);
      }
      //--- Amostras Valor - CMS5016 ------------------------------------------------------
      if (f.getArquivo().equals("CMS5016")) {
        report = "cms5016.rdf";
        g.setRelatorio(report);
        g.setParametro("P_DT_INI", dt_ini);
        g.setParametro("P_DT_FIN", dt_fin);
        g.setParametro("P_REP_INI", codigo_representante);
        g.setParametro("P_EMPRESA", "01");
      }
      //--- Demonstrativo de conta corrente - CMS0170 -------------------------------------
      if (f.getArquivo().equals("CMS0170")) {
        report = "cms0170.rdf";
        g.setRelatorio(report);
        g.setParametro("P_CODIGO_CONTA", "N");
        g.setParametro("P_PER_INI", dt_ini);
        g.setParametro("P_PER_FIM", dt_fin);
        g.setParametro("P_REP_INI", codigo_representante);
        g.setParametro("P_REP_FIM", codigo_representante);
      }
      //--- Pendências por representante - CTR5023 ----------------------------------------
      if (f.getArquivo().equals("CTR5023")) {
        report = "ctr5023.rdf";
        g.setRelatorio(report);
        g.setParametro("P_DATA_GERACAO", dt_atual);
        g.setParametro("P_NRO_DIAS", "1");
        g.setParametro("P_REP_COBRADOR", codigo_representante);
      }
      //--- Valor de IRRF e depósito - CMS0210 --------------------------------------------
      if (f.getArquivo().equals("CMS0210")) {
        report = "cms0210.rdf";
        g.setRelatorio(report);
        g.setParametro("P_PERIODO", dt_inimm);
        g.setParametro("P_REP", codigo_representante);
        g.setParametro("P_SITUACAO", "A");
        g.setParametro("P_CODIGO_CONTA", "N");
      }
      //--- Previsão Comissões s/Liquidação - CMS5011 -------------------------------------
      if (f.getArquivo().equals("CMS5011")) {
        report = "cms5011.rdf";
        g.setRelatorio(report);
        g.setParametro("P_REP_INI", codigo_representante);
        g.setParametro("P_REP_FIN", codigo_representante);
        g.setParametro("P_TIT_DT_FINAL", dt_fin);
        g.setParametro("P_TIT_DT_INICIAL", dt_quat);
        g.setParametro("P_OPCAO_DATA", "tit_datemi");
      }
      //--- Recibo - CMS5025 --------------------------------------------------------------
      if (f.getArquivo().equals("CMS5025")) {
        report = "cms5025.rdf";
        g.setRelatorio(report);
        g.setParametro("P_REP_CDGO_INI", codigo_representante);
        g.setParametro("P_REP_CDGO_FIN", codigo_representante);
        g.setParametro("P_PERIODO", dt_inimm);
      }
      //--- Comissão sobre liquidação - CMS5030 -------------------------------------------
      if (f.getArquivo().equals("CMS5030")) {
        report = "cms5030.rdf";
        g.setRelatorio(report);
        g.setParametro("P_DATA_INICIAL", dt_ini);
        g.setParametro("P_DATA_FINAL", dt_fin);
        g.setParametro("P_REP_CDGO", codigo_representante);
      }

      acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
      if (usuario.mostraQuery()) {
        throw new Exception("Query não disponível! Relatório utilizado: " + report);
      }
      g.gerar();
      //-----------------------------------------------------------------------------------
      if ((f.getAbre_automaticamente() + "").equals("checked")) {
        request.setAttribute("abre_automaticamente","S");
      } else {
        request.setAttribute("abre_automaticamente","N");
      }
      //-----------------------------------------------------------------------------------
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
  public ActionForward perform_refresh_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      CobrancaClientesRepresentantesActionForm f = (CobrancaClientesRepresentantesActionForm) form;
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
