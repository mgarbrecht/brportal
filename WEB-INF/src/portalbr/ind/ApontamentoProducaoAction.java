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
 * Creation Date 23/05/2014 10:16:38
 * Last Modify Date 26/02/2018 09:24:54
 */

public class ApontamentoProducaoAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_execute_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ApontamentoProducaoActionForm f = (ApontamentoProducaoActionForm) form;
      execute_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Prc_processa_cod_barra", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void execute_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    ApontamentoProducaoActionForm f = (ApontamentoProducaoActionForm) form;
    f.setP_mensagem("");
    request.setAttribute("codigobarra",f.getP_codigo_barra());
    acesso.Sessao sessao = new acesso.Sessao(session);
    boolean processar = true;
    if (f.getSetor() != "") {
      Setor tableSetor = new Setor();
      String[][] selectSetor = null;
      Object[][] whereSetor = { {"set_cdgo","like", f.getSetor()} };
      Vector res_Setor = j.select(tableSetor, selectSetor, whereSetor, null, null, null);
      if (res_Setor == null || res_Setor.size() == 0) {
        request.setAttribute("mensagem","erro");
        f.setP_mensagem("Setor inexistente!");
        processar = false;
      }
    }
    if (processar) {
      Apont_prod table = new Apont_prod();
      Prc_processa_cod_barra r = new Prc_processa_cod_barra();
      r.setP_codigo_barra(f.getP_codigo_barra());
      r.setP_usuario(sessao.getUsuario());
      if (f.getSetor() != "") {
        r.setP_setor(f.getSetor());
      }
      r = (Prc_processa_cod_barra) j.execute(r);
      if (r != null) {
        if (r.getP_mensagem() != null) {
          request.setAttribute("mensagem", "erro");
        }
        f.setP_rem_nro((r.getP_rem_nro() != null) ? r.getP_rem_nro() + "":"");
        f.setP_tal_nro((r.getP_tal_nro() != null) ? r.getP_tal_nro() + "":"");
        f.setP_set_cdgo((r.getP_set_cdgo() != null) ? r.getP_set_cdgo() + "":"");
        f.setP_mensagem((r.getP_mensagem() != null) ? r.getP_mensagem() + "":"");
        f.setP_codigo_barra("");
        //------------------------------------------
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT ap.rem_nro ");
        sb.append("      , ap.tal_nro ");
        sb.append("      , ap.set_cdgo ");
        sb.append("      , ap.app_seq ");
        sb.append("      , ap.app_minfab ");
        sb.append("      , ap.app_data ");
        sb.append("      , ap.app_parbom ");
        sb.append("      , ap.app_parrej ");
        sb.append("      , ap.app_tempo ");
        sb.append("      , ap.app_observ ");
        sb.append("      , ap.app_observ1 ");
        sb.append("      , ap.usuario_inclusao ");
        sb.append("      , ap.dtrh_corrente ");
        sb.append("   FROM apont_prod ap ");
        sb.append("  WHERE ap.rem_nro = ").append(f.getP_rem_nro());
        sb.append("    AND ap.tal_nro = ").append(f.getP_tal_nro());
        sb.append("    AND ap.set_cdgo = '"+f.getP_set_cdgo() + "' ");
        sb.append("    AND exists (SELECT m.mfa_codigo ");
        sb.append("                  FROM wbrio.tipos_entidade_negocio t ");
        sb.append("                     , wbrio.entidades_negocio en ");
        sb.append("                     , wbrio.usuarios u ");
        sb.append("                     , dom_mini_fab_filial m ");
        sb.append("                 WHERE t.tien_id = en.enne_tien_id ");
        sb.append("                   AND u.usua_enne_id = en.enne_id ");
        sb.append("                   AND t.tien_id = 8065 ");
        sb.append("                   AND m.mfa_codigo = ap.app_minfab ");
        sb.append("                   AND u.usua_usuario = '"+sessao.getUsuario() + "' ");
        sb.append("                   AND en.enne_chave = m.for_codigo) ");
        sb.append("    AND ROWNUM = 1 ");
        Vector resultado = j.select(table, sb.toString(), null);

        if (resultado != null && resultado.size() > 0) {
          Apont_prod registro = (Apont_prod) resultado.elementAt(0);
          Vector res_Apont;
          if (session.getAttribute("res_Apont_prod") != null) {
            res_Apont = (java.util.Vector) session.getAttribute("res_Apont_prod");
          } else {
            res_Apont = new Vector();
          }
          boolean existe = false;
          for (Object obj :
              res_Apont) {
            Apont_prod ap = (Apont_prod) obj;
            if ((ap.getRem_nro() + "-"+ap.getTal_nro() + "-"+ap.getSet_cdgo()).equals((f.getP_rem_nro() + "-"+f.getP_tal_nro() + "-"+f.getP_set_cdgo()))) {
              existe = true;
            }
          }
          if (!existe) {
            res_Apont.add(registro);
          }
          session.setAttribute("res_Apont_prod",res_Apont);
        }
        //------------------------------------------
      }
    }
    session.setAttribute(mapping.getName(), form);
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ApontamentoProducaoActionForm f = (ApontamentoProducaoActionForm) form;
      session.removeAttribute("res_Prc_processa_cod_barra");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      tg_resetfull_action(mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Prc_processa_cod_barra", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
  private void tg_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      ApontamentoProducaoActionForm f = (ApontamentoProducaoActionForm) form;
      session.removeAttribute("res_Apont_prod");
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    } finally {
    }
  }

  public ActionForward perform_delete_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ApontamentoProducaoActionForm f = (ApontamentoProducaoActionForm) form;
      Prc_apaga_talao_fase r = new Prc_apaga_talao_fase();
      r.setP_rem_nro(com.egen.util.text.FormatNumber.parseDouble(f.getP_rem_nro_apagar()));
      r.setP_tal_nro(com.egen.util.text.FormatNumber.parseDouble(f.getP_tal_nro_apagar()));
      r.setP_set_cdgo(f.getP_set_cdgo_apagar());
      r.setP_app_seq(com.egen.util.text.FormatNumber.parseDouble(f.getP_app_seq_apagar()));
      r.setP_app_observ1(f.getP_app_observ1_apagar());
      //  r = (Prc_apaga_talao_fase) j.execute(r);
      if (r != null) {
        f.setP_rem_nro_apagar(com.egen.util.text.FormatNumber.format(r.getP_rem_nro(), "##,##0.00"));
        f.setP_tal_nro_apagar(com.egen.util.text.FormatNumber.format(r.getP_tal_nro(), "##,##0.00"));
        f.setP_set_cdgo_apagar((r.getP_set_cdgo() != null) ? r.getP_set_cdgo() + "":"");
        f.setP_app_seq_apagar(com.egen.util.text.FormatNumber.format(r.getP_app_seq(), "##,##0.00"));
        f.setP_app_observ1_apagar((r.getP_app_observ1() != null) ? r.getP_app_observ1() + "":"");
      }
      //------------------------------------------
      Vector res_Apont_prod = (Vector) session.getAttribute("res_Apont_prod");
      if (res_Apont_prod != null && res_Apont_prod.size() > 0) {
        res_Apont_prod.removeElementAt(Integer.parseInt(f.getIndex()));
      }
      session.setAttribute("res_Apont_prod",res_Apont_prod);
      //------------------------------------------
      actionForward = mapping.findForward("same");
    }
    catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Prc_processa_cod_barra", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
