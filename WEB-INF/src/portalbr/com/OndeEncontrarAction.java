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
 * Creation Date 29/04/2010 14:22:39
 * Last Modify Date 07/01/2015 11:26:06
 */

public class OndeEncontrarAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      OndeEncontrarActionForm f = (OndeEncontrarActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_onde_encontrar_site", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    OndeEncontrarActionForm f = (OndeEncontrarActionForm) form;
    String where_cli = "";
    String where_marca = "";
    String where_unifed = "";

    if (f.getMarca_cdgo() == "" && f.getCli_cdgo() == "" && f.getEst_unifed() == "") {
      throw new Exception("Um dos campos com <img src='../img/opcional.gif' border='0'> deve ser preenchido! ");
    }

    if (f.getMarca_cdgo() != "" && f.getMarca_cdgo() != null) {
      where_marca = "    AND mp.codigo_marca = "+f.getMarca_cdgo();
    }
    if (f.getCli_cdgo() != "" && f.getCli_cdgo() != null) {
      where_cli = "    AND c.cli_cdgo  = "+f.getCli_cdgo();
    }
    if (f.getEst_unifed() != "" && f.getEst_unifed() != null) {
      where_unifed = "    AND ed.est_unifed LIKE ('" + f.getEst_unifed().toUpperCase() + "')";
    }


    StringBuilder query = new StringBuilder();

    query.append("  SELECT DISTINCT ");
    query.append("         r.codigo_marca ");
    query.append("       , mp.descricao_marca ");
    query.append("       , p.cli_cdgo ");
    query.append("       , p.esc_seqn ");
    query.append("       , c.cli_nome cliente ");
    query.append("       , c.cli_rzao ");
    query.append("       , ed.est_unifed estado ");
    query.append("       , ed.ecl_cdad cidade ");
    query.append("       , ed.ecl_bair bairro ");
    query.append("       , ed.ecl_nome logradouro ");
    query.append("       , ed.ecl_nmro || DECODE(ed.ecl_cpto, NULL, NULL, ' - ') || ed.ecl_cpto nro ");
    query.append("       , ed.ecl_cep cep ");
    query.append("       , REPLACE(rowtocol('SELECT  ''' || '(' || '''  || ffs_ddd2 || ''' || ') - ' || '''|| ffs_nmro2 ");
    query.append("                             FROM fax_fon2 ");
    query.append("                            WHERE ned_cdgo = ' || '''' || ed.ned_cdgo || '''' || ' ");
    query.append("                              AND esc_seqn = ' || ed.esc_seqn || ' ");
    query.append("                              AND cli_cdgo = ' || ed.cli_cdgo),',',' '||CHR(10)||' ') fone ");
    query.append("    FROM ite i  ");
    query.append("       , ped p  ");
    query.append("       , ecl ed ");
    query.append("       , esc e  ");
    query.append("       , cli c  ");
    query.append("       , ref r  ");
    query.append("       , marcas_produtos mp ");
    query.append("   WHERE ed.ned_cdgo IN ('UNI', 'ENT')   ");
    query.append("     AND ed.esc_seqn = e.esc_seqn   ");
    query.append("     AND ed.cli_cdgo = e.cli_cdgo   ");
    query.append("     AND c.cli_cdgo  = e.cli_cdgo   ");
    query.append("     AND e.esc_seqn  = p.esc_seqn   ");
    query.append("     AND e.cli_cdgo  = p.cli_cdgo   ");
    query.append(where_cli);
    query.append(where_unifed);
    query.append(where_marca);
    query.append("     AND mp.codigo_marca = i.codigo_marca   ");
    query.append("     AND r.ref_cdgo      = i.ref_cdgo   ");
    query.append("     AND r.lin_cdgo      = i.lin_cdgo   ");
    query.append("     AND i.ped_nmro      = p.ped_nmro   ");
    query.append("     AND p.ped_stat      = 'F'   ");
    query.append("     AND NVL(p.ped_data_faturamento, TRUNC(SYSDATE)) BETWEEN TRUNC(SYSDATE) - 180 AND TRUNC(SYSDATE) - 15   ");
    query.append("     AND c.seg_cdgo NOT IN(806,311,1,4,811,802,803,809,810,812,814,9,153,813,804) ");
    query.append("   ORDER BY r.codigo_marca   ");
    query.append("          , ed.est_unifed   ");
    query.append("          , cidade   ");
    query.append("          , c.cli_nome   ");


    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      throw new Exception(query.toString());
    }


    //  Jw_onde_encontrar_site table = new Jw_onde_encontrar_site();

    //  Vector res_Jw_onde_encontrar_site = j.select( table
    //                                              , query.toString()
    //                                              , null);
    //  session.setAttribute("res_Jw_onde_encontrar_site",res_Jw_onde_encontrar_site);

    String arquivo = "";
    //----------------------------------------------------------
    util.consultas.com.OndeEncontrar onde = new util.consultas.com.OndeEncontrar();
    arquivo = onde.geraExcel(query.toString());

    if (arquivo.equals("")) {
      throw new Exception("Nenhum registro encontrado!");
    }
    request.setAttribute("abre_automaticamente","N");
    request.setAttribute("arquivo", arquivo);
    session.setAttribute("gera_excel","s");
    //----------------------------------------------------------


    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      OndeEncontrarActionForm f = (OndeEncontrarActionForm) form;
      session.removeAttribute("res_Jw_onde_encontrar_site");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_onde_encontrar_site", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
