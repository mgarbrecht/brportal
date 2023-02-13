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
 * Creation Date 26/04/2006 17:29:53
 * Last Modify Date 22/06/2015 14:17:19
 */

public class PlusClientesAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      PlusClientesActionForm f = (PlusClientesActionForm) form;
      session.removeAttribute("res_Jw_plus_clientes");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_plus_clientes", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //----------------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 26/04/2006
    // Objetivo          : Executa uma consulta na view portalbr.dbobj.view.Jw_plus_clientes,
    //                     com base no código do cliente, redirecionando após a mesma
    //                     para a tela de relatório:
    //                     PlusClientes_dForm.jsp
    //----------------------------------------------------------------------------------------------
    // Data de Alteração : 04/08/2006
    // Descrição         : Alteração 01: Caso o cliente só possua um sequencial, cai direto
    //                     na tela com os dados, sem passar pelo relatório de clientes/sequenciais
    //----------------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      PlusClientesActionForm f = (PlusClientesActionForm) form;
      if (f.getEsc_seqn().equals("")) {
        actionForward = new ActionForward("PlusClientes_rForm.do?select_action=&cod="+f.getCli_cdgo(), true);
      } else {
        actionForward = new ActionForward("PlusClientes_dForm.do?select_action=&cli_cdgo="+f.getCli_cdgo() + "&esc_seqn="+f.getEsc_seqn(), true);
      }

      if ((String) request.getAttribute("sequencia") != "") {
        actionForward = new ActionForward("PlusClientes_dForm.do?select_action=&cli_cdgo="+f.getCli_cdgo() + "&esc_seqn="+(String) request.getAttribute("sequencia"), true);
      }

    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_plus_clientes", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    PlusClientesActionForm f = (PlusClientesActionForm) form;
    if ((f.getCli_cdgo().equals("")) && (f.getCgc().equals(""))) {
      throw new Exception("O Cliente/Seq. ou o CGC devem ser informados!");
    }

    StringBuilder parametros = new StringBuilder();
    //------- Se o usuário logado for regional -----------
    if ((!(f.getReg().equals("")))) {
      parametros.append(" AND r.codigo_regional = ").append(f.getReg());
    }

    //-------Se o usuário logado for representante --------
    if ((!(f.getRep().equals("")))) {
      parametros.append(" AND r.rep_cdgo = ").append(f.getRep());
    }

    if (f.getEsc_seqn().equals("")) {
      parametros.append(" AND e.esc_seqn > 0 ");
    } else {
      parametros.append(" AND e.esc_seqn = ").append(f.getEsc_seqn());
    }

    //-----------------------------------------------------
    portalbr.dbobj.view.Jw_plus_clientes table = new portalbr.dbobj.view.Jw_plus_clientes();
    StringBuilder query = new StringBuilder();
    query.append(" SELECT DISTINCT ");
    query.append("        c.cli_cdgo ");
    query.append("      , e.esc_seqn ");
    query.append("      , c.cli_rzao ");
    query.append("      , c.cli_nome ");
    query.append("      , decode(C.cli_situ,'A','Ativo','I','Inativo') cli_situ ");
    query.append("      , decode(s.esc_situacao,'A','Ativo','I','Inativo','F','Fechado') esc_situacao ");
    query.append("      , c.cli_dtin ");
    query.append("      , decode(c.cli_exige_pc,'S','Sim','N','Não','') cli_exige_pc ");
    query.append("      , decode(C.cli_agrupa_notas,'S','Sim','N','Não','') cli_agrupa_notas ");
    query.append("      , decode(C.cli_aceita_antecipacao,'S','Sim','N','Não','') cli_aceita_antecipacao ");
    query.append("      , brio.fct_formata_cnpj(s.esc_cgc) cgc ");
    query.append("      , s.esc_inse inscricao ");
    query.append("      , e.ecl_nome||', '||e.ecl_nmro||' - '||substr(e.ecl_cep,1,5)||'-'||substr(e.ecl_cep,6,3) ender ");
    query.append("      , e.ecl_bair||' - '||e.ecl_cdad||'/'||e.est_unifed bairro_cidade ");
    query.append("      , e.ecl_cdad||' - '||e.est_unifed cid_uf ");
    query.append("   FROM ecl                     e ");
    query.append("      , cli                     c ");
    query.append("      , esc                     s ");
    query.append("      , cliente_representante   cr ");
    query.append("      , rep                     r  ");
    query.append("  WHERE e.cli_cdgo              = s.cli_cdgo ");
    query.append("    AND cr.codigo_cliente       = c.cli_cdgo ");
    query.append("    AND r.rep_cdgo              = cr.codigo_representante ");
    query.append("    AND e.cli_cdgo              = c.cli_cdgo ");
    query.append("    AND e.esc_seqn              = s.esc_seqn ");
    query.append("    AND e.cli_cdgo              > 0 ");
    query.append(parametros.toString());
    query.append("    AND e.cli_cdgo              = ").append(f.getCli_cdgo());
    query.append("    AND (e.ned_cdgo= 'UNI'  OR e.ned_cdgo = 'ENT') ");


    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      throw new Exception(query.toString());
    }

    Vector res_Jw_plus_clientes = j.select(table, query.toString(), null);

    request.setAttribute("sequencia","");
    if (res_Jw_plus_clientes.size() == 1) {
      portalbr.dbobj.view.Jw_plus_clientes r = (portalbr.dbobj.view.Jw_plus_clientes) res_Jw_plus_clientes.elementAt(0);
      request.setAttribute("sequencia",r.getEsc_seqn() + "");
    }

    if (!(res_Jw_plus_clientes != null && res_Jw_plus_clientes.size() > 0)) {
      throw new Exception("Nenhum registro encontrado!");
    }
    session.setAttribute("mapping.getName()", form);
  }
  public ActionForward perform_select2_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //-----------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 26/04/2006
    // Objetivo          : Executa uma consulta na view portalbr.dbobj.view.Jw_plus_clientes,
    //                     com base no cgc do cliente, redirecionando após a mesma
    //                     para a tela de relatório:
    //                     PlusClientes_dForm.jsp
    //-----------------------------------------------------------------------------------------
    // Data de Alteração :
    // Descrição         :
    //-----------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select2_action(j, mapping, form, request, response);
      PlusClientesActionForm f = (PlusClientesActionForm) form;
      actionForward = new ActionForward("PlusClientes_dForm.do?select_action=&cli_cdgo="+f.getCli() + "&esc_seqn="+f.getSeq(), true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_plus_clientes", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void select2_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    PlusClientesActionForm f = (PlusClientesActionForm) form;
    StringBuilder parametros = new StringBuilder();
    portalbr.dbobj.view.Jw_clientes_cgc table2 = new portalbr.dbobj.view.Jw_clientes_cgc();

    StringBuilder queryc = new StringBuilder();
    queryc.append(" SELECT b.cli_cdgo ");
    queryc.append("      , b.esc_seqn ");
    queryc.append("   FROM esc b ");
    queryc.append("      , ecl c ");
    queryc.append("  WHERE b.esc_cgc  = ").append(f.getCgc());
    queryc.append("    AND b.esc_seqn = c.esc_seqn ");
    queryc.append("    AND b.cli_cdgo = c.cli_cdgo ");
    queryc.append("    AND (c.ned_cdgo = 'UNI' or c.ned_cdgo = 'ENT') ");
    queryc.append("    AND b.cli_cdgo > 0 ");

    Vector res_Jw_clientes_cgc = j.select(table2, queryc.toString(), null);

    if (res_Jw_clientes_cgc != null && res_Jw_clientes_cgc.size() > 0) {
      portalbr.dbobj.view.Jw_clientes_cgc r = (portalbr.dbobj.view.Jw_clientes_cgc) res_Jw_clientes_cgc.elementAt(0);
      f.setCli(r.getCli_cdgo() + "");
      f.setSeq(r.getEsc_seqn() + "");
    } else {
      throw new Exception("Cliente Inexistente!");
    }

    //------- Se o usuário logado for regional -----------
    if ((!(f.getReg().equals("")))) {
      parametros.append(" and r.codigo_regional = ").append(f.getReg());
    }
    //-------Se o usuário logado for representante --------
    if ((!(f.getRep().equals("")))) {
      parametros.append(" and r.rep_cdgo = ").append(f.getRep());
    }
    //-----------------------------------------------------

    portalbr.dbobj.view.Jw_plus_clientes table = new portalbr.dbobj.view.Jw_plus_clientes();
    StringBuilder query = new StringBuilder();
    query.append(" SELECT DISTINCT ");
    query.append("        c.cli_cdgo ");
    query.append("      , e.esc_seqn ");
    query.append("      , c.cli_rzao ");
    query.append("      , c.cli_nome ");
    query.append("      , brio.fct_formata_cnpj(s.esc_cgc) cgc ");
    query.append("      , s.esc_inse inscricao ");
    query.append("      , e.ecl_nome||', '|| e.ecl_nmro||' - '|| substr(e.ecl_cep,1,5)||'-' ");
    query.append("                             ||substr(e.ecl_cep,6,3) ender ");
    query.append("      , e.ecl_bair||' - '||e.ecl_cdad||'/'||e.est_unifed bairro_cidade ");
    query.append("      , e.ecl_cdad||' - '||e.est_unifed cid_uf ");
    query.append("   FROM cliente_representante             cr ");
    query.append("      , ecl                               e ");
    query.append("      , esc                               s ");
    query.append("      , cli                               c ");
    query.append("      , rep                               r ");
    query.append("  WHERE cr.codigo_cliente                 = c.cli_cdgo  ");
    query.append("    AND e.cli_cdgo                        = s.cli_cdgo ");
    query.append("    AND r.rep_cdgo                        = cr.codigo_representante ");
    query.append("    AND e.cli_cdgo                        = c.cli_cdgo ");
    query.append("    AND e.esc_seqn                        = s.esc_seqn ");
    query.append(parametros.toString());
    query.append("    AND e.cli_cdgo                        = ").append(f.getCli());
    query.append("    AND e.esc_seqn                        = ").append(f.getSeq());
    query.append("    AND (e.ned_cdgo = 'UNI' OR e.ned_cdgo = 'ENT') ");

    if (false) {
      throw new Exception(query.toString());
    }

    Vector res_Jw_plus_clientes = j.select(table, query.toString(), null);

    if (!(res_Jw_plus_clientes != null && res_Jw_plus_clientes.size() > 0)) {
      throw new Exception("Nenhum registro encontrado!");
    }
    session.setAttribute("mapping.getName()", form);
  }

}
