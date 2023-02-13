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
 * Creation Date 25/08/2015 09:23:58
 * Last Modify Date 03/09/2018 12:12:09
 */

public class ConsultaPosicaoTaloesAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ConsultaPosicaoTaloesActionForm f = (ConsultaPosicaoTaloesActionForm) form;
      select_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/ind/ConsultaPosicaoTaloes_rForm.jsp", true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_posicao_taloes", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    ConsultaPosicaoTaloesActionForm f = (ConsultaPosicaoTaloesActionForm) form;
    Jw_consulta_posicao_taloes table = new Jw_consulta_posicao_taloes();
    boolean informouDatas = false;
    boolean parametrosValidos = false;

    StringBuilder sbParametros = new StringBuilder();
    if (f.getFil_filial() != "") {
      sbParametros.append(" AND o.fil_filial = '"+f.getFil_filial() + "' ");
    }
    if (f.getForn_codigo() != "") {
      sbParametros.append(" AND r.For_Codigo = " + f.getForn_codigo());
    }
    if (f.getRemessa() != "") {
      parametrosValidos = true;
      sbParametros.append(" AND r.AROC_Rem_Nro = " + f.getRemessa());
    }
    if (f.getOc() != "") {
      parametrosValidos = true;
      sbParametros.append(" AND r.AROC_OCO_Numero = " + f.getOc());
    }
    if (f.getTalao() != "") {
      sbParametros.append(" AND r.Tal_Nro = " + f.getTalao());
    }
    if (f.getLin_cdgo() != "") {
      sbParametros.append(" AND m.lin_cdgo = " + f.getLin_cdgo());
    }

    if (f.getDt_envio_inicial() != "" && f.getDt_envio_final() != "") {
      parametrosValidos = true;
      util.consultas.Query query = new util.consultas.Query();
      String foraPeriodo = query.retorna(j, "SELECT case when MONTHS_BETWEEN(to_date('"+f.getDt_envio_final() + "','dd/mm/yyyy'), to_date('"+f.getDt_envio_inicial() + "','dd/mm/yyyy'))>6 then 'S' else 'N' end data_fora_periodo FROM dual");
      if (foraPeriodo.equalsIgnoreCase("S")) {
        throw new Exception("O intervalo de datas não pode ser maior que 6 meses!");
      }
    }
    if (f.getDt_envio_inicial() != "") {
      sbParametros.append(" AND r.data_envio >= to_date('"+f.getDt_envio_inicial() + "','dd/mm/yyyy') ");
    }
    if (f.getDt_envio_final() != "") {
      sbParametros.append(" AND r.data_envio <= to_date('"+f.getDt_envio_final() + "','dd/mm/yyyy') ");
    }

    if (!parametrosValidos) {
      throw new Exception("Um dos campos com <img src='../img/opcional.gif' border='0'/> deve ser informado!");
    }

    StringBuilder sb = new StringBuilder();
    sb.append(" SELECT r.AROC_Rem_Nro remessa ");
    sb.append("        ,r.Tal_Nro talao ");
    sb.append("        ,r.For_Codigo forn_codigo ");
    sb.append("        ,TO_CHAR(r.For_Codigo) || ' - ' || f.For_RazSoc fornecedor ");
    sb.append("        ,r.Pro_Numero processo ");
    sb.append("        ,r.Status ");
    sb.append("        ,DECODE(r.Tal_Tipo_Talao, NULL, t.Tal_Pares, c.Tal_Pares) pares ");
    sb.append("        ,r.Data_Envio dt_envio ");
    sb.append("        ,r.Data_Recebimento dt_retorno ");
    sb.append("        ,r.AROC_OCO_Numero oc ");
    sb.append("        ,s.Rv_Meaning situacao_oc ");
    sb.append("        ,r.atualiza_controle_producao ");
    sb.append("        ,m.lin_cdgo ");
    sb.append("        ,t.ref_cdgo ");
    sb.append("        ,t.cab_cdgo ");
    sb.append("        ,t.cor_cdgo ");
    sb.append("        ,o.fil_filial ");
    sb.append("        ,(SELECT DISTINCT inf.numero_nota_fiscal || '/' || inf.serie_nota_fiscal nota_fiscal ");
    sb.append("          FROM atelier_rem_tal_interface_nf artin ");
    sb.append("              ,interface_item_nota_fiscal   iinf ");
    sb.append("              ,interface_nota_fiscal        inf ");
    sb.append("         WHERE artin.rem_nro = r.AROC_Rem_Nro ");
    sb.append("           AND artin.tal_nro = r.Tal_Nro ");
    sb.append("           AND iinf.oco_numero = r.AROC_OCO_Numero ");
    sb.append("           AND iinf.id_nota_fiscal = artin.id_nota_fiscal ");
    sb.append("           AND inf.id_nota_fiscal = iinf.id_nota_fiscal ");
    sb.append("           AND NVL(inf.integrar_rdo, NULL) = 'S') nota_fiscal ");
    sb.append("        ,o.fen_seq ");
    sb.append("    FROM Talao_Celula          c ");
    sb.append("        ,Talao                 t ");
    sb.append("        ,Remessa               m ");
    sb.append("        ,Lotes                 l ");
    sb.append("        ,Fornecedor            f ");
    sb.append("        ,Compras_Ref_Codes     s ");
    sb.append("        ,Dom_Ordem_Compra      o ");
    sb.append("        ,Atelier_Rem_Taloes_OC r ");
    sb.append("   WHERE t.Rem_Nro(+) = r.AROC_Rem_Nro ");
    sb.append("     AND t.Tal_Nro(+) = r.Tal_Nro ");
    sb.append("     AND c.Rem_Nro(+) = r.AROC_Rem_Nro ");
    sb.append("     AND c.Tal_Nro(+) = r.Tal_Nro ");
    sb.append("     AND l.Lote_Nro(+) = r.AROC_Rem_Nro ");
    sb.append("     AND m.Rem_Nro(+) = r.AROC_Rem_Nro ");
    sb.append("     AND f.For_Codigo = r.For_Codigo ");
    sb.append("     AND s.rv_Low_Value = o.Situacao ");
    sb.append("     AND s.rv_Domain = 'DMN_SITUACAO' ");
    sb.append("     AND o.Numero = r.AROC_OCO_Numero ");

    if (f.getFen_seq() != "") {
      sb.append("  AND o.fen_seq = " + f.getFen_seq());
    }


    sb.append(sbParametros.toString());

    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      throw new Exception(sb.toString());
    }

    Vector res_Jw_consulta_posicao_taloes = j.select(table, sb.toString(), null);
    session.setAttribute("res_Jw_consulta_posicao_taloes",res_Jw_consulta_posicao_taloes);
    if (!(res_Jw_consulta_posicao_taloes != null && res_Jw_consulta_posicao_taloes.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_posicao_taloes", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      throw new Exception("Nenhum registro encontrado!");
    }
    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ConsultaPosicaoTaloesActionForm f = (ConsultaPosicaoTaloesActionForm) form;
      session.removeAttribute("res_Jw_consulta_posicao_taloes");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_posicao_taloes", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
