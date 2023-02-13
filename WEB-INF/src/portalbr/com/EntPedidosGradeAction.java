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
 * Creation Date 28/09/2010 08:20:43
 * Last Modify Date 02/04/2013 15:11:10
 */

public class EntPedidosGradeAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      EntPedidosGradeActionForm f = (EntPedidosGradeActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Qtd", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    EntPedidosGradeActionForm f = (EntPedidosGradeActionForm) form;
    util.consultas.Query query = new util.consultas.Query();
    session.setAttribute("atualiza", f.getAtualiza());
    acesso.Sessao se = new acesso.Sessao(session);
    String cliente = "";
    if (se.getTipoEntidadeNegocio().equals("CLIENTE MERCADO EXTERNO")) {
      cliente = se.getChave();
    }

    session.setAttribute("tamanho_grade","0");
    session.setAttribute("indice", f.getIndice());
    acesso.Sessao sessao = new acesso.Sessao(session);
    String quantidade_pares_grade = null;
    Vector res_Qtd = null;
    Qtd table = new Qtd();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"gde_cdgo","=", com.egen.util.text.FormatNumber.toInteger(f.getGde_cdgo())}, {"qtd_nume","like", f.getQtd_nume()}, {"qtd_pars","=", com.egen.util.text.FormatNumber.toInteger(f.getQtd_pars())}, };
    session.setAttribute("grade", f.getGde_cdgo());
    session.setAttribute("numero_item_grade", f.getNumero_item());
    quantidade_pares_grade = query.retorna(j, " SELECT SUM(qtd_pars) pares from qtd WHERE gde_cdgo = "+f.getGde_cdgo());

    //-- Se for grade 99 e já tiver sido inserida, traz os dados anteriores ----------
    String inserido = "";
    inserido = query.retorna(j, "SELECT 's' FROM emula_grades_itens_proformas g, emula_itens_faturas_proformas i WHERE i.numero_pedido = g.numero_pedido AND i.numero_item = g.numero_item    AND i.codigo_grade = 99 AND i.numero_pedido = "+(String) session.getAttribute("numero_pedido") + " and i.numero_item = "+f.getNumero_item() + " and rownum = 1");
    String lin_ref_antiga = query.retorna(j, "SELECT codigo_linha||codigo_referencia FROM emula_itens_faturas_proformas where numero_pedido = "+(String) session.getAttribute("numero_pedido") + " and numero_item = "+f.getNumero_item());
    if ((!(lin_ref_antiga.equals(f.getLin_cdgo() + f.getRef_cdgo()))) && (inserido.equals("s"))) {
      query.execute(j, "DELETE wbrio.tmp_generic_table_brportal WHERE varchar_column1 = '"+sessao.getUsuario() + "' AND varchar_column2 = '"+(String) session.getAttribute("numero_pedido") + "' AND varchar_column3 = '"+f.getNumero_item() + "'");
      inserido = "";
    }
    //--------------------------------------------------------------------------------

    //-- Se não existir na temporária ------------------------------------------------
    String existe = "";
    existe = query.retorna("select 1 from tmp_generic_table_brportal where varchar_column1 = '"+sessao.getUsuario() + "' and varchar_column2 = '"+(String) session.getAttribute("numero_pedido") + "' and varchar_column3 = '"+f.getNumero_item() + "'");
    if (f.getGde_cdgo().equals("99") && existe.equals("")) {
      if (inserido.equals("")) {
        StringBuilder sb = new StringBuilder();
        query.execute(j, "delete wbrio.tmp_generic_table_brportal where varchar_column1 = '"+sessao.getUsuario() + "' and varchar_column2 = '"+(String) session.getAttribute("numero_pedido") + "' and varchar_column3 = '"+f.getNumero_item() + "'");
        sb.append(" INSERT INTO wbrio.tmp_generic_table_brportal (varchar_column1,varchar_column2,varchar_column3,varchar_column4,varchar_column5,varchar_column9,varchar_column10) ");
        sb.append(" SELECT distinct '"+sessao.getUsuario() + "','"+(String) session.getAttribute("numero_pedido") + "','"+f.getNumero_item() + "', q.qtd_nume, 0 qtd_pars, '"+f.getLin_cdgo() + "', '"+f.getRef_cdgo() + "' from ref_gde r, qtd q where r.lin_cdgo = "+f.getLin_cdgo() + " and r.ref_cdgo = "+f.getRef_cdgo() + " and q.gde_cdgo = r.gde_cdgo  order by q.qtd_nume ");
        query.execute(j, sb.toString());
      } else {
        StringBuilder sb = new StringBuilder();
        sb.append(" INSERT INTO wbrio.tmp_generic_table_brportal (varchar_column1,varchar_column2,varchar_column3,varchar_column4,varchar_column5,varchar_column9,varchar_column10) ");
        sb.append(" SELECT '"+sessao.getUsuario() + "','"+(String) session.getAttribute("numero_pedido") + "','"+f.getNumero_item() + "',q.numeracao_par,q.quantidade_pares, '"+f.getLin_cdgo() + "', '"+f.getRef_cdgo() + "' FROM emula_grades_itens_proformas q WHERE q.numero_pedido = "+(String) session.getAttribute("numero_pedido") + " and q.numero_item = "+f.getNumero_item());
        query.execute(j, sb.toString());
      }
    }
    //--------------------------------------------------------------------------------
    if (f.getGde_cdgo().equals("99")) {
      StringBuilder sb = new StringBuilder();

      //   if(inserido.equals("")){
      sb.append(" SELECT 99 gde_cdgo ");
      sb.append("      , varchar_column4 qtd_nume ");
      sb.append("      , varchar_column5 qtd_pars ");
      sb.append("   FROM wbrio.tmp_generic_table_brportal  ");
      sb.append("  WHERE varchar_column1 = '"+sessao.getUsuario() + "' ");
      sb.append("    AND varchar_column2 = '"+(String) session.getAttribute("numero_pedido") + "' ");
      sb.append("    AND varchar_column3 = '"+f.getNumero_item() + "' ");
      sb.append("  ORDER by 2 ");

      res_Qtd = j.select(table, sb.toString(), null);
    } else {
      res_Qtd = j.select(table, select, where, groupby, having, order);
    }


    //--------------------------------------------------------------------------------
    session.setAttribute("res_Qtd",res_Qtd);
    if (res_Qtd != null && res_Qtd.size() > 0) {
      session.setAttribute("tamanho_grade", res_Qtd.size() + "");
      try {
        Qtd r = (Qtd) res_Qtd.elementAt(0);
        f.setTam1(r.getQtd_nume() + "");
        f.setPar1(r.getQtd_pars() + "");
        if (!cliente.equals("")) {
          f.setTamex1(query.retorna(j, "SELECT nuco_num_cont FROM esc es, paises p, estados e, Numeracao_Continentes n WHERE p.codigo = e.pais_codigo AND n.nuco_con_codigo = p.con_codigo AND es.est_unifed = e.est_unifed  AND es.cli_cdgo = "+cliente + " AND es.esc_seqn = 1 AND n.nuco_num_brasil = '"+r.getQtd_nume() + "'"));
        }
      } catch (Exception e) {}

      try {
        Qtd r = (Qtd) res_Qtd.elementAt(1);
        f.setTam2(r.getQtd_nume() + "");
        f.setPar2(r.getQtd_pars() + "");
        if (!cliente.equals("")) {
          f.setTamex2(query.retorna(j, "SELECT nuco_num_cont FROM esc es, paises p, estados e, Numeracao_Continentes n WHERE p.codigo = e.pais_codigo AND n.nuco_con_codigo = p.con_codigo AND es.est_unifed = e.est_unifed  AND es.cli_cdgo = "+cliente + " AND es.esc_seqn = 1 AND n.nuco_num_brasil = '"+r.getQtd_nume() + "'"));
        }
      } catch (Exception e) {}

      try {
        Qtd r = (Qtd) res_Qtd.elementAt(2);
        f.setTam3(r.getQtd_nume() + "");
        f.setPar3(r.getQtd_pars() + "");
        if (!cliente.equals("")) {
          f.setTamex3(query.retorna(j, "SELECT nuco_num_cont FROM esc es, paises p, estados e, Numeracao_Continentes n WHERE p.codigo = e.pais_codigo AND n.nuco_con_codigo = p.con_codigo AND es.est_unifed = e.est_unifed  AND es.cli_cdgo = "+cliente + " AND es.esc_seqn = 1 AND n.nuco_num_brasil = '"+r.getQtd_nume() + "'"));
        }
      } catch (Exception e) {}

      try {
        Qtd r = (Qtd) res_Qtd.elementAt(3);
        f.setTam4(r.getQtd_nume() + "");
        f.setPar4(r.getQtd_pars() + "");
        if (!cliente.equals("")) {
          f.setTamex4(query.retorna(j, "SELECT nuco_num_cont FROM esc es, paises p, estados e, Numeracao_Continentes n WHERE p.codigo = e.pais_codigo AND n.nuco_con_codigo = p.con_codigo AND es.est_unifed = e.est_unifed  AND es.cli_cdgo = "+cliente + " AND es.esc_seqn = 1 AND n.nuco_num_brasil = '"+r.getQtd_nume() + "'"));
        }
      } catch (Exception e) {}

      try {
        Qtd r = (Qtd) res_Qtd.elementAt(4);
        f.setTam5(r.getQtd_nume() + "");
        f.setPar5(r.getQtd_pars() + "");
        if (!cliente.equals("")) {
          f.setTamex5(query.retorna(j, "SELECT nuco_num_cont FROM esc es, paises p, estados e, Numeracao_Continentes n WHERE p.codigo = e.pais_codigo AND n.nuco_con_codigo = p.con_codigo AND es.est_unifed = e.est_unifed  AND es.cli_cdgo = "+cliente + " AND es.esc_seqn = 1 AND n.nuco_num_brasil = '"+r.getQtd_nume() + "'"));
        }
      } catch (Exception e) {}

      try {
        Qtd r = (Qtd) res_Qtd.elementAt(5);
        f.setTam6(r.getQtd_nume() + "");
        f.setPar6(r.getQtd_pars() + "");
        if (!cliente.equals("")) {
          f.setTamex6(query.retorna(j, "SELECT nuco_num_cont FROM esc es, paises p, estados e, Numeracao_Continentes n WHERE p.codigo = e.pais_codigo AND n.nuco_con_codigo = p.con_codigo AND es.est_unifed = e.est_unifed  AND es.cli_cdgo = "+cliente + " AND es.esc_seqn = 1 AND n.nuco_num_brasil = '"+r.getQtd_nume() + "'"));
        }
      } catch (Exception e) {}

      try {
        Qtd r = (Qtd) res_Qtd.elementAt(6);
        f.setTam7(r.getQtd_nume() + "");
        f.setPar7(r.getQtd_pars() + "");
        if (!cliente.equals("")) {
          f.setTamex7(query.retorna(j, "SELECT nuco_num_cont FROM esc es, paises p, estados e, Numeracao_Continentes n WHERE p.codigo = e.pais_codigo AND n.nuco_con_codigo = p.con_codigo AND es.est_unifed = e.est_unifed  AND es.cli_cdgo = "+cliente + " AND es.esc_seqn = 1 AND n.nuco_num_brasil = '"+r.getQtd_nume() + "'"));
        }
      } catch (Exception e) {}

      try {
        Qtd r = (Qtd) res_Qtd.elementAt(7);
        f.setTam8(r.getQtd_nume() + "");
        f.setPar8(r.getQtd_pars() + "");
        if (!cliente.equals("")) {
          f.setTamex8(query.retorna(j, "SELECT nuco_num_cont FROM esc es, paises p, estados e, Numeracao_Continentes n WHERE p.codigo = e.pais_codigo AND n.nuco_con_codigo = p.con_codigo AND es.est_unifed = e.est_unifed  AND es.cli_cdgo = "+cliente + " AND es.esc_seqn = 1 AND n.nuco_num_brasil = '"+r.getQtd_nume() + "'"));
        }
      } catch (Exception e) {}

      try {
        Qtd r = (Qtd) res_Qtd.elementAt(8);
        f.setTam9(r.getQtd_nume() + "");
        f.setPar9(r.getQtd_pars() + "");
        if (!cliente.equals("")) {
          f.setTamex9(query.retorna(j, "SELECT nuco_num_cont FROM esc es, paises p, estados e, Numeracao_Continentes n WHERE p.codigo = e.pais_codigo AND n.nuco_con_codigo = p.con_codigo AND es.est_unifed = e.est_unifed  AND es.cli_cdgo = "+cliente + " AND es.esc_seqn = 1 AND n.nuco_num_brasil = '"+r.getQtd_nume() + "'"));
        }
      } catch (Exception e) {}

      try {
        Qtd r = (Qtd) res_Qtd.elementAt(9);
        f.setTam10(r.getQtd_nume() + "");
        f.setPar10(r.getQtd_pars() + "");
        if (!cliente.equals("")) {
          f.setTamex10(query.retorna(j, "SELECT nuco_num_cont FROM esc es, paises p, estados e, Numeracao_Continentes n WHERE p.codigo = e.pais_codigo AND n.nuco_con_codigo = p.con_codigo AND es.est_unifed = e.est_unifed  AND es.cli_cdgo = "+cliente + " AND es.esc_seqn = 1 AND n.nuco_num_brasil = '"+r.getQtd_nume() + "'"));
        }
      } catch (Exception e) {}

      try {
        Qtd r = (Qtd) res_Qtd.elementAt(10);
        f.setTam11(r.getQtd_nume() + "");
        f.setPar11(r.getQtd_pars() + "");
        if (!cliente.equals("")) {
          f.setTamex11(query.retorna(j, "SELECT nuco_num_cont FROM esc es, paises p, estados e, Numeracao_Continentes n WHERE p.codigo = e.pais_codigo AND n.nuco_con_codigo = p.con_codigo AND es.est_unifed = e.est_unifed  AND es.cli_cdgo = "+cliente + " AND es.esc_seqn = 1 AND n.nuco_num_brasil = '"+r.getQtd_nume() + "'"));
        }
      } catch (Exception e) {}

      try {
        Qtd r = (Qtd) res_Qtd.elementAt(11);
        f.setTam12(r.getQtd_nume() + "");
        f.setPar12(r.getQtd_pars() + "");
        if (!cliente.equals("")) {
          f.setTamex12(query.retorna(j, "SELECT nuco_num_cont FROM esc es, paises p, estados e, Numeracao_Continentes n WHERE p.codigo = e.pais_codigo AND n.nuco_con_codigo = p.con_codigo AND es.est_unifed = e.est_unifed  AND es.cli_cdgo = "+cliente + " AND es.esc_seqn = 1 AND n.nuco_num_brasil = '"+r.getQtd_nume() + "'"));
        }
      } catch (Exception e) {}

      try {
        Qtd r = (Qtd) res_Qtd.elementAt(12);
        f.setTam13(r.getQtd_nume() + "");
        f.setPar13(r.getQtd_pars() + "");
        if (!cliente.equals("")) {
          f.setTamex13(query.retorna(j, "SELECT nuco_num_cont FROM esc es, paises p, estados e, Numeracao_Continentes n WHERE p.codigo = e.pais_codigo AND n.nuco_con_codigo = p.con_codigo AND es.est_unifed = e.est_unifed  AND es.cli_cdgo = "+cliente + " AND es.esc_seqn = 1 AND n.nuco_num_brasil = '"+r.getQtd_nume() + "'"));
        }
      } catch (Exception e) {}

      try {
        Qtd r = (Qtd) res_Qtd.elementAt(13);
        f.setTam14(r.getQtd_nume() + "");
        f.setPar14(r.getQtd_pars() + "");
        if (!cliente.equals("")) {
          f.setTamex14(query.retorna(j, "SELECT nuco_num_cont FROM esc es, paises p, estados e, Numeracao_Continentes n WHERE p.codigo = e.pais_codigo AND n.nuco_con_codigo = p.con_codigo AND es.est_unifed = e.est_unifed  AND es.cli_cdgo = "+cliente + " AND es.esc_seqn = 1 AND n.nuco_num_brasil = '"+r.getQtd_nume() + "'"));
        }
      } catch (Exception e) {}

      try {
        Qtd r = (Qtd) res_Qtd.elementAt(14);
        f.setTam15(r.getQtd_nume() + "");
        f.setPar15(r.getQtd_pars() + "");
        if (!cliente.equals("")) {
          f.setTamex15(query.retorna(j, "SELECT nuco_num_cont FROM esc es, paises p, estados e, Numeracao_Continentes n WHERE p.codigo = e.pais_codigo AND n.nuco_con_codigo = p.con_codigo AND es.est_unifed = e.est_unifed  AND es.cli_cdgo = "+cliente + " AND es.esc_seqn = 1 AND n.nuco_num_brasil = '"+r.getQtd_nume() + "'"));
        }
      } catch (Exception e) {}

      try {
        Qtd r = (Qtd) res_Qtd.elementAt(15);
        f.setTam16(r.getQtd_nume() + "");
        f.setPar16(r.getQtd_pars() + "");
        if (!cliente.equals("")) {
          f.setTamex16(query.retorna(j, "SELECT nuco_num_cont FROM esc es, paises p, estados e, Numeracao_Continentes n WHERE p.codigo = e.pais_codigo AND n.nuco_con_codigo = p.con_codigo AND es.est_unifed = e.est_unifed  AND es.cli_cdgo = "+cliente + " AND es.esc_seqn = 1 AND n.nuco_num_brasil = '"+r.getQtd_nume() + "'"));
        }
      } catch (Exception e) {}

      try {
        Qtd r = (Qtd) res_Qtd.elementAt(16);
        f.setTam17(r.getQtd_nume() + "");
        f.setPar17(r.getQtd_pars() + "");
        if (!cliente.equals("")) {
          f.setTamex17(query.retorna(j, "SELECT nuco_num_cont FROM esc es, paises p, estados e, Numeracao_Continentes n WHERE p.codigo = e.pais_codigo AND n.nuco_con_codigo = p.con_codigo AND es.est_unifed = e.est_unifed  AND es.cli_cdgo = "+cliente + " AND es.esc_seqn = 1 AND n.nuco_num_brasil = '"+r.getQtd_nume() + "'"));
        }
      } catch (Exception e) {}

      try {
        Qtd r = (Qtd) res_Qtd.elementAt(17);
        f.setTam18(r.getQtd_nume() + "");
        f.setPar18(r.getQtd_pars() + "");
        if (!cliente.equals("")) {
          f.setTamex18(query.retorna(j, "SELECT nuco_num_cont FROM esc es, paises p, estados e, Numeracao_Continentes n WHERE p.codigo = e.pais_codigo AND n.nuco_con_codigo = p.con_codigo AND es.est_unifed = e.est_unifed  AND es.cli_cdgo = "+cliente + " AND es.esc_seqn = 1 AND n.nuco_num_brasil = '"+r.getQtd_nume() + "'"));
        }
      } catch (Exception e) {}

      try {
        Qtd r = (Qtd) res_Qtd.elementAt(18);
        f.setTam19(r.getQtd_nume() + "");
        f.setPar19(r.getQtd_pars() + "");
        if (!cliente.equals("")) {
          f.setTamex19(query.retorna(j, "SELECT nuco_num_cont FROM esc es, paises p, estados e, Numeracao_Continentes n WHERE p.codigo = e.pais_codigo AND n.nuco_con_codigo = p.con_codigo AND es.est_unifed = e.est_unifed  AND es.cli_cdgo = "+cliente + " AND es.esc_seqn = 1 AND n.nuco_num_brasil = '"+r.getQtd_nume() + "'"));
        }
      } catch (Exception e) {}

      try {
        Qtd r = (Qtd) res_Qtd.elementAt(19);
        f.setTam20(r.getQtd_nume() + "");
        f.setPar20(r.getQtd_pars() + "");
        if (!cliente.equals("")) {
          f.setTamex20(query.retorna(j, "SELECT nuco_num_cont FROM esc es, paises p, estados e, Numeracao_Continentes n WHERE p.codigo = e.pais_codigo AND n.nuco_con_codigo = p.con_codigo AND es.est_unifed = e.est_unifed  AND es.cli_cdgo = "+cliente + " AND es.esc_seqn = 1 AND n.nuco_num_brasil = '"+r.getQtd_nume() + "'"));
        }
      } catch (Exception e) {}


      f.setTotal(quantidade_pares_grade);


    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Qtd", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute(mapping.getName(), form);
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      EntPedidosGradeActionForm f = (EntPedidosGradeActionForm) form;
      session.removeAttribute("res_Qtd");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Qtd", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      EntPedidosGradeActionForm f = (EntPedidosGradeActionForm) form;
      acesso.Sessao sessao = new acesso.Sessao(session);
      util.consultas.Query query = new util.consultas.Query();
      if (((String) session.getAttribute("grade")).equals("99")) {
        if (!f.getTam1().equals("undefined")) {
          query.execute(j, "UPDATE wbrio.tmp_generic_table_brportal SET varchar_column5 = '"+f.getPar1() + "' WHERE varchar_column1 = '"+sessao.getUsuario() + "' AND varchar_column2 = '"+(String) session.getAttribute("numero_pedido") + "' AND varchar_column3 = '"+(String) session.getAttribute("numero_item_grade") + "' AND varchar_column4 = '"+f.getTam1() + "'");
        }
        if (!f.getTam2().equals("undefined")) {
          query.execute(j, "UPDATE wbrio.tmp_generic_table_brportal SET varchar_column5 = '"+f.getPar2() + "' WHERE varchar_column1 = '"+sessao.getUsuario() + "' AND varchar_column2 = '"+(String) session.getAttribute("numero_pedido") + "' AND varchar_column3 = '"+(String) session.getAttribute("numero_item_grade") + "' AND varchar_column4 = '"+f.getTam2() + "'");
        }
        if (!f.getTam3().equals("undefined")) {
          query.execute(j, "UPDATE wbrio.tmp_generic_table_brportal SET varchar_column5 = '"+f.getPar3() + "' WHERE varchar_column1 = '"+sessao.getUsuario() + "' AND varchar_column2 = '"+(String) session.getAttribute("numero_pedido") + "' AND varchar_column3 = '"+(String) session.getAttribute("numero_item_grade") + "' AND varchar_column4 = '"+f.getTam3() + "'");
        }
        if (!f.getTam4().equals("undefined")) {
          query.execute(j, "UPDATE wbrio.tmp_generic_table_brportal SET varchar_column5 = '"+f.getPar4() + "' WHERE varchar_column1 = '"+sessao.getUsuario() + "' AND varchar_column2 = '"+(String) session.getAttribute("numero_pedido") + "' AND varchar_column3 = '"+(String) session.getAttribute("numero_item_grade") + "' AND varchar_column4 = '"+f.getTam4() + "'");
        }
        if (!f.getTam5().equals("undefined")) {
          query.execute(j, "UPDATE wbrio.tmp_generic_table_brportal SET varchar_column5 = '"+f.getPar5() + "' WHERE varchar_column1 = '"+sessao.getUsuario() + "' AND varchar_column2 = '"+(String) session.getAttribute("numero_pedido") + "' AND varchar_column3 = '"+(String) session.getAttribute("numero_item_grade") + "' AND varchar_column4 = '"+f.getTam5() + "'");
        }
        if (!f.getTam6().equals("undefined")) {
          query.execute(j, "UPDATE wbrio.tmp_generic_table_brportal SET varchar_column5 = '"+f.getPar6() + "' WHERE varchar_column1 = '"+sessao.getUsuario() + "' AND varchar_column2 = '"+(String) session.getAttribute("numero_pedido") + "' AND varchar_column3 = '"+(String) session.getAttribute("numero_item_grade") + "' AND varchar_column4 = '"+f.getTam6() + "'");
        }
        if (!f.getTam7().equals("undefined")) {
          query.execute(j, "UPDATE wbrio.tmp_generic_table_brportal SET varchar_column5 = '"+f.getPar7() + "' WHERE varchar_column1 = '"+sessao.getUsuario() + "' AND varchar_column2 = '"+(String) session.getAttribute("numero_pedido") + "' AND varchar_column3 = '"+(String) session.getAttribute("numero_item_grade") + "' AND varchar_column4 = '"+f.getTam7() + "'");
        }
        if (!f.getTam8().equals("undefined")) {
          query.execute(j, "UPDATE wbrio.tmp_generic_table_brportal SET varchar_column5 = '"+f.getPar8() + "' WHERE varchar_column1 = '"+sessao.getUsuario() + "' AND varchar_column2 = '"+(String) session.getAttribute("numero_pedido") + "' AND varchar_column3 = '"+(String) session.getAttribute("numero_item_grade") + "' AND varchar_column4 = '"+f.getTam8() + "'");
        }
        if (!f.getTam9().equals("undefined")) {
          query.execute(j, "UPDATE wbrio.tmp_generic_table_brportal SET varchar_column5 = '"+f.getPar9() + "' WHERE varchar_column1 = '"+sessao.getUsuario() + "' AND varchar_column2 = '"+(String) session.getAttribute("numero_pedido") + "' AND varchar_column3 = '"+(String) session.getAttribute("numero_item_grade") + "' AND varchar_column4 = '"+f.getTam9() + "'");
        }
        if (!f.getTam10().equals("undefined")) {
          query.execute(j, "UPDATE wbrio.tmp_generic_table_brportal SET varchar_column5 = '"+f.getPar10() + "' WHERE varchar_column1 = '"+sessao.getUsuario() + "' AND varchar_column2 = '"+(String) session.getAttribute("numero_pedido") + "' AND varchar_column3 = '"+(String) session.getAttribute("numero_item_grade") + "' AND varchar_column4 = '"+f.getTam10() + "'");
        }
        if (!f.getTam11().equals("undefined")) {
          query.execute(j, "UPDATE wbrio.tmp_generic_table_brportal SET varchar_column5 = '"+f.getPar11() + "' WHERE varchar_column1 = '"+sessao.getUsuario() + "' AND varchar_column2 = '"+(String) session.getAttribute("numero_pedido") + "' AND varchar_column3 = '"+(String) session.getAttribute("numero_item_grade") + "' AND varchar_column4 = '"+f.getTam11() + "'");
        }
        if (!f.getTam12().equals("undefined")) {
          query.execute(j, "UPDATE wbrio.tmp_generic_table_brportal SET varchar_column5 = '"+f.getPar12() + "' WHERE varchar_column1 = '"+sessao.getUsuario() + "' AND varchar_column2 = '"+(String) session.getAttribute("numero_pedido") + "' AND varchar_column3 = '"+(String) session.getAttribute("numero_item_grade") + "' AND varchar_column4 = '"+f.getTam12() + "'");
        }
        if (!f.getTam13().equals("undefined")) {
          query.execute(j, "UPDATE wbrio.tmp_generic_table_brportal SET varchar_column5 = '"+f.getPar13() + "' WHERE varchar_column1 = '"+sessao.getUsuario() + "' AND varchar_column2 = '"+(String) session.getAttribute("numero_pedido") + "' AND varchar_column3 = '"+(String) session.getAttribute("numero_item_grade") + "' AND varchar_column4 = '"+f.getTam13() + "'");
        }
        if (!f.getTam14().equals("undefined")) {
          query.execute(j, "UPDATE wbrio.tmp_generic_table_brportal SET varchar_column5 = '"+f.getPar14() + "' WHERE varchar_column1 = '"+sessao.getUsuario() + "' AND varchar_column2 = '"+(String) session.getAttribute("numero_pedido") + "' AND varchar_column3 = '"+(String) session.getAttribute("numero_item_grade") + "' AND varchar_column4 = '"+f.getTam14() + "'");
        }
        if (!f.getTam15().equals("undefined")) {
          query.execute(j, "UPDATE wbrio.tmp_generic_table_brportal SET varchar_column5 = '"+f.getPar15() + "' WHERE varchar_column1 = '"+sessao.getUsuario() + "' AND varchar_column2 = '"+(String) session.getAttribute("numero_pedido") + "' AND varchar_column3 = '"+(String) session.getAttribute("numero_item_grade") + "' AND varchar_column4 = '"+f.getTam15() + "'");
        }
        if (!f.getTam16().equals("undefined")) {
          query.execute(j, "UPDATE wbrio.tmp_generic_table_brportal SET varchar_column5 = '"+f.getPar16() + "' WHERE varchar_column1 = '"+sessao.getUsuario() + "' AND varchar_column2 = '"+(String) session.getAttribute("numero_pedido") + "' AND varchar_column3 = '"+(String) session.getAttribute("numero_item_grade") + "' AND varchar_column4 = '"+f.getTam16() + "'");
        }
        if (!f.getTam17().equals("undefined")) {
          query.execute(j, "UPDATE wbrio.tmp_generic_table_brportal SET varchar_column5 = '"+f.getPar17() + "' WHERE varchar_column1 = '"+sessao.getUsuario() + "' AND varchar_column2 = '"+(String) session.getAttribute("numero_pedido") + "' AND varchar_column3 = '"+(String) session.getAttribute("numero_item_grade") + "' AND varchar_column4 = '"+f.getTam17() + "'");
        }
        if (!f.getTam18().equals("undefined")) {
          query.execute(j, "UPDATE wbrio.tmp_generic_table_brportal SET varchar_column5 = '"+f.getPar18() + "' WHERE varchar_column1 = '"+sessao.getUsuario() + "' AND varchar_column2 = '"+(String) session.getAttribute("numero_pedido") + "' AND varchar_column3 = '"+(String) session.getAttribute("numero_item_grade") + "' AND varchar_column4 = '"+f.getTam18() + "'");
        }
        if (!f.getTam19().equals("undefined")) {
          query.execute(j, "UPDATE wbrio.tmp_generic_table_brportal SET varchar_column5 = '"+f.getPar19() + "' WHERE varchar_column1 = '"+sessao.getUsuario() + "' AND varchar_column2 = '"+(String) session.getAttribute("numero_pedido") + "' AND varchar_column3 = '"+(String) session.getAttribute("numero_item_grade") + "' AND varchar_column4 = '"+f.getTam19() + "'");
        }
        if (!f.getTam20().equals("undefined")) {
          query.execute(j, "UPDATE wbrio.tmp_generic_table_brportal SET varchar_column5 = '"+f.getPar20() + "' WHERE varchar_column1 = '"+sessao.getUsuario() + "' AND varchar_column2 = '"+(String) session.getAttribute("numero_pedido") + "' AND varchar_column3 = '"+(String) session.getAttribute("numero_item_grade") + "' AND varchar_column4 = '"+f.getTam20() + "'");
        }
      }


      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Qtd", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  public ActionForward perform_resetfull1_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    java.sql.PreparedStatement pstm = null;
    java.sql.ResultSet rset = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      EntPedidosGradeActionForm f = (EntPedidosGradeActionForm) form;
      util.consultas.Query query = new util.consultas.Query();
      acesso.Sessao sessao = new acesso.Sessao(session);

      StringBuilder sb = new StringBuilder();
      sb.append(" SELECT tam,qtd FROM (SELECT TO_CHAR(g.numero_pedido) numero_pedido ");
      sb.append("               ,g.numero_item ");
      sb.append("               ,numeracao_par tam ");
      sb.append("               ,TO_CHAR(quantidade_pares) qtd ");
      sb.append("           FROM emula_grades_itens_proformas g ");
      sb.append("         UNION ");
      sb.append("         SELECT varchar_column2 numero_pedido ");
      sb.append("               ,TO_NUMBER(varchar_column3) numero_item ");
      sb.append("               ,varchar_column4 tam ");
      sb.append("               ,varchar_column5 qtd ");
      sb.append("           FROM tmp_generic_table_brportal tmp ");
      sb.append("          WHERE varchar_column1 = '"+sessao.getUsuario() + "' ");
      sb.append("            AND varchar_column3 NOt IN ('C','I') ");
      sb.append("            AND varchar_column2 = '"+(String) session.getAttribute("numero_pedido") + "') ");
      sb.append("  WHERE numero_pedido = '"+(String) session.getAttribute("numero_pedido") + "' AND numero_item =  (SELECT * FROM ( ");
      sb.append(" SELECT to_number(max(numero_item)) numero_item FROM ( ");
      sb.append(" SELECT i.numero_item ");
      sb.append("   FROM emula_grades_itens_proformas g ");
      sb.append("       ,emula_itens_faturas_proformas i ");
      sb.append("  WHERE g.numero_pedido = i.numero_pedido ");
      sb.append("    AND i.codigo_grade = 99 ");
      sb.append("    AND g.numero_pedido = "+(String) session.getAttribute("numero_pedido"));
      sb.append("    AND g.numero_item = i.numero_item ");
      sb.append("    AND g.numero_item <> "+f.getNumero_item());
      sb.append(" UNION ");
      sb.append(" SELECT to_number(varchar_column3) ");
      sb.append("   FROM tmp_generic_table_brportal tmp ");
      sb.append("  WHERE tmp.varchar_column1 = '"+sessao.getUsuario() + "' ");
      sb.append("    AND varchar_column2 = '"+(String) session.getAttribute("numero_pedido") + "' ");
      sb.append("    AND varchar_column3 <> '"+f.getNumero_item() + "' ))) ");


      pstm = j.getConn().prepareStatement(sb.toString());
      rset = pstm.executeQuery();
      while (rset.next()) {
        query.execute(j, "UPDATE tmp_generic_table_brportal SET varchar_column4 = '"+rset.getString("tam") + "' , varchar_column5 = '"+rset.getString("qtd") + "' WHERE varchar_column1 = '"+sessao.getUsuario() + "' AND varchar_column2= '"+(String) session.getAttribute("numero_pedido") + "' AND varchar_column3='"+f.getNumero_item() + "' AND varchar_column4 = '"+rset.getString("tam") + "' ");
      }

      if (rset != null) {
        rset.close();
      }
      if (pstm != null) {
        pstm.close();
      }

      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Qtd", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
