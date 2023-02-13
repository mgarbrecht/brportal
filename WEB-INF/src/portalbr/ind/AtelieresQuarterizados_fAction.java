package portalbr.ind;

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
 * Creation Date 02/09/2009 10:14:34
 * Last Modify Date 10/02/2015 13:19:45
 */

public class AtelieresQuarterizados_fAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      AtelieresQuarterizados_fActionForm f = (AtelieresQuarterizados_fActionForm) form;
      select_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/ind/AtelieresQuarterizados_frForm.jsp", false);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    AtelieresQuarterizados_fActionForm f = (AtelieresQuarterizados_fActionForm) form;
    Jw_relatorio_atelier_pre_envio_quarterizado table = new Jw_relatorio_atelier_pre_envio_quarterizado();
    StringBuilder parametros = new StringBuilder();

    if (f.getPro_numero() != "") {
      parametros.append(" AND ape.pro_numero = " + f.getPro_numero());
    }

    if (f.getTipo() != "") {
      parametros.append(" AND ape.status = '"+f.getTipo() + "' ");
    }


    if (f.getTipo().equalsIgnoreCase("E")) {
      if (f.getHora_inicial() != "") {
        parametros.append(" AND ape.data_envio >= to_date('"+f.getDt_inicial() + " "+f.getHora_inicial() + "','dd/mm/yyyy hh24:mi') ");
      } else {
        parametros.append(" AND ape.data_envio >= to_date('"+f.getDt_inicial() + "','dd/mm/yyyy') ");
      }
      if (f.getHora_final() != "") {
        parametros.append(" AND ape.data_envio < to_date('"+f.getDt_final() + " "+f.getHora_final() + "','dd/mm/yyyy hh24:mi') + 1 ");
      } else {
        parametros.append(" AND ape.data_envio < to_date('"+f.getDt_final() + "','dd/mm/yyyy') + 1 ");
      }
    } else {
      if (f.getHora_inicial() != "") {
        parametros.append(" AND ape.data_retorno >= to_date('"+f.getDt_inicial() + " "+f.getHora_inicial() + "','dd/mm/yyyy hh24:mi') ");
      } else {
        parametros.append(" AND ape.data_retorno >= to_date('"+f.getDt_inicial() + "','dd/mm/yyyy') ");
      }
      if (f.getHora_final() != "") {
        parametros.append(" AND ape.data_retorno < to_date('"+f.getDt_final() + " "+f.getHora_final() + "','dd/mm/yyyy hh24:mi') + 1 ");
      } else {
        parametros.append(" AND ape.data_retorno < to_date('"+f.getDt_final() + "','dd/mm/yyyy') + 1 ");
      }
    }

    if (f.getFornecedor() != "") {
      parametros.append(" AND ape.for_codigo_quarterizado = " + f.getFornecedor());
    }

    if (f.getSeq() != "") {
      parametros.append(" AND ape.fen_seq_quarterizado = " + f.getSeq());
    }

    acesso.Sessao sessao = new acesso.Sessao(session);
    if (sessao.getTipoEntidadeNegocio().equals("ATELIER")) {
      parametros.append(" AND ape.for_codigo = ").append(sessao.getChave());
    }




    StringBuilder sb = new StringBuilder();
    sb.append(" SELECT ape.for_codigo fornecedor_codigo  ");
    sb.append("       ,ape.for_codigo_quarterizado fornecedor_codigo_quarterizado ");
    sb.append("       ,ape.fen_seq_quarterizado ");
    sb.append("       ,f.for_razsoc fornecedor_razsoc ");
    sb.append("       ,ape.pro_numero ");
    sb.append("       ,p.pro_nome ");
    sb.append("       ,ape.data_envio ");
    sb.append("       ,ape.data_retorno ");
    sb.append("       ,ape.rem_nro ");
    sb.append("       ,ape.tal_nro ");
    sb.append("       ,ape.status ");
    sb.append("       ,DECODE(ape.status, 'E', 'Envio', 'R', 'Retorno', 'Envio') status_descricao ");
    sb.append("       ,ape.usuario_inclusao ");
    sb.append("       ,ape.usuario_alteracao ");
    sb.append("       ,CASE ");
    sb.append("          WHEN data_envio > NVL(data_retorno, '01-jan-1970') THEN ");
    sb.append("           data_envio ");
    sb.append("          ELSE ");
    sb.append("           data_retorno ");
    sb.append("        END data_ordenacao ");
    sb.append("       ,t.tal_pares ");
    sb.append("       ,t.tal_parbom ");
    sb.append("       ,t.tal_parrej ");
    sb.append("       ,r.lin_cdgo ");
    sb.append("       ,t.ref_cdgo ");
    sb.append("       ,t.cab_cdgo ");
    sb.append("       ,cab.cab_desc ");
    sb.append("       ,t.cor_cdgo ");
    sb.append("       ,c.cor_desc ");
    sb.append("       ,(SELECT DISTINCT tlf_fim FROM talao_fase tf WHERE rem_nro = r.rem_nro AND tal_nro = t.tal_nro AND r.fil_filial = tf.fil_filial AND set_cdgo = 'CORTE') data_corte ");
    sb.append("       ,(SELECT DISTINCT tlf_fim FROM talao_fase tf WHERE rem_nro = r.rem_nro AND tal_nro = t.tal_nro AND r.fil_filial = tf.fil_filial AND set_cdgo = 'COST') data_cost ");
    sb.append("       ,(SELECT DISTINCT tlf_fim FROM talao_fase tf WHERE rem_nro = r.rem_nro AND tal_nro = t.tal_nro AND r.fil_filial = tf.fil_filial AND set_cdgo = 'MONT') data_mont ");
    sb.append("   FROM cpr.atelier_pre_envio_quarterizado ape ");
    sb.append("       ,talao t ");
    sb.append("       ,remessa r ");
    sb.append("       ,for_endere_quarterizado f ");
    sb.append("       ,processo_fab p ");
    sb.append("       ,cor c ");
    sb.append("       ,cabedal cab ");
    sb.append("  WHERE ape.for_codigo = f.for_codigo ");
    sb.append("    AND t.rem_nro = ape.rem_nro ");
    sb.append("    AND t.tal_nro = ape.tal_nro ");
    sb.append("    AND t.rem_nro = r.rem_nro ");
    sb.append("    AND c.cor_cdgo = t.cor_cdgo ");
    sb.append("    AND cab.cab_cdgo = t.cab_cdgo ");
    sb.append("    AND ape.for_codigo_quarterizado = f.for_codigo_quarterizado ");
    sb.append("    AND ape.fen_seq_quarterizado = f.fen_seq_quarterizado ");
    sb.append("    AND ape.pro_numero = p.pro_numero ");
    sb.append(parametros.toString());
    sb.append("  ORDER BY ape.for_codigo, ape.for_codigo_quarterizado, ape.fen_seq_quarterizado, ape.pro_numero, data_ordenacao DESC ");


    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      throw new Exception(sb.toString());
    }



    Vector res_Jw_relatorio_atelier_pre_envio_quarterizado = j.select(table, sb.toString(), null);
    session.setAttribute("res_Jw_relatorio_atelier_pre_envio_quarterizado", res_Jw_relatorio_atelier_pre_envio_quarterizado);
    if (res_Jw_relatorio_atelier_pre_envio_quarterizado != null && res_Jw_relatorio_atelier_pre_envio_quarterizado.size() > 0) {
    } else {
      throw new Exception("Nenhum registro encontrado!");
    }
    session.setAttribute(mapping.getName(), form);
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      AtelieresQuarterizados_fActionForm f = (AtelieresQuarterizados_fActionForm) form;
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
