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
 * Creation Date 25/01/2007 15:12:11
 * Last Modify Date 22/08/2022 18:20:30
 */

public class RankingVendasAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    java.sql.PreparedStatement pstm = null;
    java.sql.ResultSet rset = null;
    try {
      boolean erro = false;
      String dt_inicial = null;
      RankingVendasActionForm f = (RankingVendasActionForm) form;
      acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
      if (usuario.mostraQuery()) {
        throw new Exception("Query não disponível! Relatório utilizado: sbr0438.rdf");
      }
      util.consultas.Parametros parametros = new util.consultas.Parametros();
      try {
        j = new com.egen.util.jdbc.JdbcUtil();
        pstm = j.getConn().prepareStatement(" select case when to_date(?,'dd/mm/yyyy')   >=  to_date(lpad(to_number(to_char(sysdate,'ddmmyyyy'))-1,8,0),'dd/mm/yyyy') then 1 else 0 end valida, to_char(to_date(lpad(to_number(to_char(sysdate,'ddmmyyyy'))-1,8,0),'dd/mm/yyyy'),'dd/mm/yyyy') from dual ");
        pstm.setString(1, f.getDt_inicio());
        rset = pstm.executeQuery();
        if (rset.next()) {
          if (rset.getString(1).equals("0")) {
            erro = true;
            dt_inicial = rset.getString(2);
          }
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
      //----------------------------------------------------------------
      if (erro) {
        throw new Exception("Data inicial inválida! A data inicial deve ser maior que : "+dt_inicial + " (12 meses retroativos) ");
      } else {
        util.file.GeraPDF g = new util.file.GeraPDF(request);
        g.setRelatorio("sbr0438.rdf");
        g.setParametro("P_DATA_INI", f.getDt_inicio());
        g.setParametro("P_DATA_FIM", f.getDt_fim());
        if (!f.getDias_semana().equals("")) {
          g.setParametro("P_DIAS_SEMANA", f.getDias_semana());
        }
        if (!f.getCodigo_marca().equals("")) {
          g.setParametro("P_MARCA", f.getCodigo_marca());
        }
        if (!f.getUnn_codigo().equals("")) {
          g.setParametro("P_NEGOCIO", f.getUnn_codigo());
        }
        g.setParametro("P_TIPO_RELATORIO", f.getTipo());
        g.setParametro("P_PATH_IMAGEM", parametros.retornaParametro("diretorio_imagens_report"));
        g.gerar();
        //----------------------------------------------------------------
        if ((f.getAbre_automaticamente() + "").equals("checked")) {
          request.setAttribute("abre_automaticamente","S");
        } else {
          request.setAttribute("abre_automaticamente","N");
        }
        actionForward = mapping.findForward("same");
      }
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
      RankingVendasActionForm f = (RankingVendasActionForm) form;
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

}
