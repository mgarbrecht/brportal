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
 * Creation Date 03/10/2006 17:39:40
 * Last Modify Date 24/07/2021 09:49:13
 */

public class PedidosCanceladosPeriodoAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      PedidosCanceladosPeriodoActionForm f = (PedidosCanceladosPeriodoActionForm) form;
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

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
      if (usuario.mostraQuery()) {
        throw new Exception("Query não disponível! Relatório utilizado: sbr800.rdf");
      }

      PedidosCanceladosPeriodoActionForm f = (PedidosCanceladosPeriodoActionForm) form;
      try {

        j = new com.egen.util.jdbc.JdbcUtil();

        if ((f.getDt_entrega_inicio().equals("") || f.getDt_entrega_final().equals("")) && (f.getDt_cancelamento_inicio().equals("") || f.getDt_cancelamento_final().equals("")) && (f.getDt_digitacao_inicio().equals("") || f.getDt_digitacao_final().equals(""))) {
          throw new Exception("Um dos períodos deve ser informado!");
        }
        util.consultas.Query query = new util.consultas.Query();
        if (!(f.getDt_entrega_inicio().equals("") || f.getDt_entrega_final().equals(""))) {
          String foraPeriodoEntrega = query.retorna("SELECT case when MONTHS_BETWEEN(to_date('"+f.getDt_entrega_final() + "','dd/mm/yyyy'), to_date('"+f.getDt_entrega_inicio() + "','dd/mm/yyyy'))>12 then 'S' else 'N' end data_fora_periodo FROM dual");
          if (foraPeriodoEntrega.equalsIgnoreCase("S")) {
            throw new Exception("O intervalo de entrada não pode ser maior que 1 ano!");
          }
          String invertidoPeriodoEntrega = query.retorna("SELECT case when to_date('"+f.getDt_entrega_final() + "','dd/mm/yyyy') < to_date('"+f.getDt_entrega_inicio() + "','dd/mm/yyyy') then 'S' else 'N' end periodo_invertido FROM dual");
          if (invertidoPeriodoEntrega.equalsIgnoreCase("S")) {
            throw new Exception("A data inicial não pode ser maior que a data final!");
          }
        }
        if (!(f.getDt_cancelamento_inicio().equals("") || f.getDt_cancelamento_final().equals(""))) {
          String foraPeriodoCancelamento = query.retorna("SELECT case when MONTHS_BETWEEN(to_date('"+f.getDt_cancelamento_final() + "','dd/mm/yyyy'), to_date('"+f.getDt_cancelamento_inicio() + "','dd/mm/yyyy'))>12 then 'S' else 'N' end data_fora_periodo FROM dual");
          if (foraPeriodoCancelamento .equalsIgnoreCase("S")) {
            throw new Exception("O intervalo de cancelmaneto não pode ser maior que 1 ano!");
          }
          String invertidoPeriodoCancelamento = query.retorna("SELECT case when to_date('"+f.getDt_cancelamento_final() + "','dd/mm/yyyy') < to_date('"+f.getDt_cancelamento_inicio() + "','dd/mm/yyyy') then 'S' else 'N' end periodo_invertido FROM dual");
          if (invertidoPeriodoCancelamento.equalsIgnoreCase("S")) {
            throw new Exception("A data inicial não pode ser maior que a data final!");
          }
        }
        if (!(f.getDt_digitacao_inicio().equals("") || f.getDt_digitacao_final().equals(""))) {
          String foraPeriodoDigitacao = query.retorna("SELECT case when MONTHS_BETWEEN(to_date('"+f.getDt_digitacao_final() + "','dd/mm/yyyy'), to_date('"+f.getDt_digitacao_inicio() + "','dd/mm/yyyy'))>12 then 'S' else 'N' end data_fora_periodo FROM dual");
          if (foraPeriodoDigitacao .equalsIgnoreCase("S")) {
            throw new Exception("O intervalo de digitação não pode ser maior que 1 ano!");
          }
          String invertidoPeriodoDigitacao = query.retorna("SELECT case when to_date('"+f.getDt_digitacao_final() + "','dd/mm/yyyy') < to_date('"+f.getDt_digitacao_inicio() + "','dd/mm/yyyy') then 'S' else 'N' end periodo_invertido FROM dual");
          if (invertidoPeriodoDigitacao.equalsIgnoreCase("S")) {
            throw new Exception("A data inicial não pode ser maior que a data final!");
          }
        }
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
            portalbr.dbobj.table.Rep table = new portalbr.dbobj.table.Rep();
            String[][] select = null;
            Object[][] where = { {"Codigo_regional","=", ent.getChave() + ""}, {"Rep_cdgo","like", f.getRep_cdgo()} };
            Vector res_Rep = j.select(table, select, where, null, null, null);
            if (res_Rep != null && res_Rep.size() == 0) {
              throw new Exception("O representante não pertence à filial!");
            }
          }
        }

        //--- Se o usuário tiver restrição de data ----------------------------------------------------------------------
        String diasRetroativos = "";
        com.egen.util.jdbc.JdbcUtil connection = null;
        try {
          connection = new com.egen.util.jdbc.JdbcUtil();
          portalbr.dbobj.table.Acessos_documentos_interfaces table = new portalbr.dbobj.table.Acessos_documentos_interfaces();
          String[][] select = null;
          Object[][] where = { {"Acdi_doin_id","=","121"}, {"Acdi_usua_id","=",u.getId()}, {"Acdi_dias_consulta_retroativa",">",0} };
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

        Date data = new Date();
        if ((!(diasRetroativos.equals(""))) && (!(diasRetroativos.equals("0")))) {
          if (!f.getDt_entrega_inicio().equals("")) {
            if (FormatDate.parseDate(f.getDt_entrega_inicio()).before(FormatDate.addDate(data, - Integer.parseInt(diasRetroativos)))) {
              throw new Exception("Período inválido! Data Inicial de Entrega deve ser maior ou igual a: "+ FormatDate.format(FormatDate.addDate(data, -u.getDiasConsultaRetroativa()), "dd/MM/yyyy"));
            }
          }
        }

      }
      catch (Exception e) {
      } finally {
        if (j != null) {
          j.close();
          j = null;
        }
      }

      //---------------------------------------------------------------------------------------------------------------
      util.file.GeraPDF g = new util.file.GeraPDF(request);
      g.setRelatorio("sbr800.rdf");

      if (!(f.getDt_cancelamento_inicio().equals(""))) {
        g.setParametro("DT_CANCELAMENTO_INICIO", f.getDt_cancelamento_inicio());
      }

      if (!(f.getDt_cancelamento_final().equals(""))) {
        g.setParametro("DT_CANCELAMENTO_FINAL", f.getDt_cancelamento_final());
      }

      if (!(f.getDt_entrega_inicio().equals(""))) {
        g.setParametro("DT_ENTREGA_INICIO", f.getDt_entrega_inicio());
      }

      if (!(f.getDt_entrega_final().equals(""))) {
        g.setParametro("DT_ENTREGA_FINAL", f.getDt_entrega_final());
      }

      if (!(f.getCodigo_regional().equals(""))) {
        g.setParametro("REGIONAL", f.getCodigo_regional());
      } else {
        g.setParametro("REGIONAL", "0");
      }
      if (!(f.getRep_cdgo().equals(""))) {
        g.setParametro("REPRESENT", f.getRep_cdgo());
      } else {
        g.setParametro("REPRESENT", "0");
      }
      //---- Novos ---

      if (!(f.getEspecie().equals(""))) {
        g.setParametro("P_ESPECIE", f.getEspecie());
      }

      if (!(f.getDt_digitacao_inicio().equals(""))) {
        g.setParametro("DT_DADG_INICIO", f.getDt_digitacao_inicio());
      }

      if (!(f.getDt_digitacao_final().equals(""))) {
        g.setParametro("DT_DADG_FINAL", f.getDt_digitacao_final());
      }

      if (!(f.getLin_cdgo().equals(""))) {
        g.setParametro("P_LINHA", f.getLin_cdgo());
      } else {
        g.setParametro("P_LINHA", "0");
      }

      if (!(f.getMotivo_cancelamento().equals(""))) {
        g.setParametro("P_MOTIVO_CANCELAMENTO", f.getMotivo_cancelamento());
      }
      if (!(f.getFil_filial().equals(""))) {
        g.setParametro("P_FIL_FILIAL", f.getFil_filial());
      }
      g.setParametro("P_CLI_CDGO", f.getCli_cdgo());
      g.setParametro("P_DESCONSIDERA_RECOLOCADOS", f.getDesconsidera_recolocados());
      g.setParametro("P_SOMENTE_PROGRAMADOS", f.getSomente_programados());
      g.setParametro("P_RESUMO_GRUPO_CLIENTE", f.getResumo_grupo_cliente());
      g.setParametro("P_DESCONSIDERAR_AMOSTRA", f.getDesconsiderar_amostra());
      g.setParametro("P_TIPO_PEDIDO", f.getTipo_pedido());
      g.setParametro("P_TIPO_MERCADO", f.getTipo_mercado());
      g.setParametro("P_ORIGEM_PEDIDO", f.getOrigem_pedido());
      g.gerar();
      //---------------------------------------------------------------------------------------------------------------
      if ((f.getAbre_automaticamente() + "").equals("checked")) {
        request.setAttribute("abre_automaticamente","S");
      } else {
        request.setAttribute("abre_automaticamente","N");
      }
      //-----------------------------------------------------------------------------------------
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
}
