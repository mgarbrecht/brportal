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
 * Creation Date 17/04/2006 12:00:30
 * Last Modify Date 22/06/2015 16:58:30
 */

public class PlusProdutosDadosAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_cabedal_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      PlusProdutosDadosActionForm f = (PlusProdutosDadosActionForm) form;
      actionForward = new ActionForward("/com/PlusProdutosDados_cForm.do?select_action=&lin_cdgo="+f.getLin_cdgo() + "&ref_cdgo="+f.getRef_cdgo(), true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_linha_ref", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
  public ActionForward perform_vendas_encerradas_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_linha_ref", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
  public ActionForward perform_select1_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select1_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/com/AdministradorPedidos_rForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_linha_ref", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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

  private void select1_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    PlusProdutosDadosActionForm f = (PlusProdutosDadosActionForm) form;
    String linha = "null";
    String marca = "null";
    String referencia = "null";

    if (f.getLin_cdgo() != "") {
      linha = f.getLin_cdgo();
    }
    if (f.getRef_cdgo() != "") {
      referencia = f.getRef_cdgo();
    }
    //  if(f.getDisponibilidade().equals("f")){
    //     disponibilidade = " having   ( sum( capacidade_pares ) - sum( venda_pares ) ) <= 0 ";
    // }
    // if(f.getDisponibilidade().equals("s")){
    //     disponibilidade = " having   ( sum( capacidade_pares ) - sum( venda_pares ) ) > 0  ";
    // }
    //-------------------------------------------
    if (f.getDt_inicial() != "") {
      if (f.getDt_inicial().length() < 4) {
        throw new Exception("A Data Inicial deve possuir 4 caracteres!");
      }
    }
    if (f.getDt_final() != "") {
      if (f.getDt_final().length() < 4) {
        throw new Exception("A Data Final deve possuir 4 caracteres!");
      }
    }
    if ((f.getDt_inicial().equals("")) || (f.getDt_final().equals(""))) {
      java.util.Date data = new java.util.Date();
      java.text.SimpleDateFormat fData = new java.text.SimpleDateFormat("MMyy");
      String data_atual = fData.format(data);
      f.setDt_inicial(data_atual);
      f.setDt_final(data_atual);
    }
    String dataif = "";
    String dataff = "";
    String datas = "";
    dataif = f.getDt_inicial().substring(0, 2) + "20"+f.getDt_inicial().substring(2, 4);
    dataff = f.getDt_final().substring(0, 2) + "20"+f.getDt_final().substring(2, 4);
    if (Integer.parseInt(dataif.substring(2, 6)) == Integer.parseInt(dataff.substring(2, 6))) {
      for (int x = Integer.parseInt(dataif.substring(0, 2)); x <= Integer.parseInt(dataff.substring(0, 2)); x++) {
        datas += x + dataff.substring(4, 6) + ",";
      }
    } else {
      for (int x = Integer.parseInt(dataif.substring(0, 2)); x <= 12 ; x++) {
        datas += x + f.getDt_inicial().substring(2, 4) + ",";
      }
      for (int y = Integer.parseInt(dataif.substring(2, 6)) + 1 ; y <= Integer.parseInt(dataff.substring(2, 6)) - 1 ; y++) {
        for (int x = 1 ; x <= 12 ; x++) {
          datas += x + (y + "").substring(2, 4) + ",";
        }
      }
      for (int x = 1 ; x <= Integer.parseInt(dataff.substring(0, 2)); x++) {
        datas += x + f.getDt_final().substring(2, 4) + ",";
      }
    }

    portalbr.dbobj.view.Jw_web_poi table = new portalbr.dbobj.view.Jw_web_poi();
    Vector res_Jw_web_poi = new Vector();
    Vector res_Jw_web_poi2 = new Vector();
    String[] t = datas.split(",");
    for (int x = 0; x < t.length ; x++) {
      //-------------------------------------------
      StringBuilder sb = new StringBuilder();
      sb.append(" select t.lin_codigo||decode(t.ref_codigo,0,null,'.')||decode(t.ref_codigo,0,null,t.ref_codigo) lin_ref , ");
      sb.append("   t.lin_codigo linha, decode(t.ref_codigo,0,'',t.ref_codigo) ref_codigo, l.lin_nome,lpad(p.mes_ano_venda,4,0) mes_ano_venda, p.total_pares_venda , ");
      sb.append("   sum(capacidade_pares) capacidade, sum(venda_pares) vendas,  ");
      sb.append("   sum(capacidade_pares) - sum(venda_pares) disponivel, ");
      sb.append("   fnc_pares_retidos_credito( to_date(lpad('"+t[x] + "',4,0),'mm/yy'), ");
      sb.append("        trunc(last_day(to_date(lpad('"+t[x] + "',4,0),'mm/yy'))), t.lin_codigo ) pares_ret_credito  ");
      sb.append(" from toneis t,lin l, previsao_linha_venda p ");
      sb.append(" where  t.ano         =  '20'||SUBSTR(lpad('"+t[x] + "',4,0),3,6) ");
      sb.append("   and  NVL(p.mes_ano_venda,NULL)  = lpad('"+t[x] + "',4,0) ");
      sb.append("   and t.cod_empresa     =  '01' ");
      sb.append("   and t.lin_codigo      =  p.codigo_linha ");
      sb.append("   and t.ref_codigo      =  nvl(p.codigo_refer,0) ");
      sb.append("   and t.lin_codigo      =  l.lin_cdgo ");
      sb.append("   and t.lin_codigo      =  nvl("+f.getLin_cdgo() + ",t.lin_codigo) ");
      sb.append("   and t.ref_codigo      =  nvl("+f.getRef_cdgo() + ",t.ref_codigo) ");
      sb.append("    AND t.lin_codigo IN ");
      sb.append(" (   select distinct lin_cdgo linha ");
      sb.append("       from  ref, previsao_linha_venda t ");
      sb.append("          where  codigo_marca         = nvl(null,codigo_marca) ");
      sb.append("           and   codigo_linha         = lin_cdgo ");
      sb.append("           and   mes_ano_venda        = lpad('"+t[x] + "',4,0) ");
      sb.append("           and   lin_cdgo             = nvl(NULL,lin_cdgo) ");
      sb.append("           and   ref_cdgo             = nvl(NULL,ref_cdgo) ");
      sb.append("           and   ref_status           = 'A' ) ");
      sb.append("   and t.periodo   in  (select distinct periodo  from calendarios_semanal ");
      sb.append("                                          where NVL(cod_empresa, NULL)  = '01' ");
      sb.append("                                            and data >= to_date(lpad('"+t[x] + "',4,0),'mm/yy') ");
      sb.append("                                            and data <= trunc(last_day(to_date(lpad('"+t[x] + "',4,0),'mm/yy')))) ");
      sb.append(" group by t.lin_codigo, t.ref_codigo, l.lin_nome, ");
      sb.append("      p.mes_ano_venda, p.total_pares_venda,  ");
      sb.append("      fnc_pares_retidos_credito( to_date(lpad('"+t[x] + "',4,0),'mm/yy'), ");
      sb.append("            trunc(last_day(to_date(lpad('"+t[x] + "',4,0),'mm/yy'))), t.lin_codigo ) ");
      sb.append(" order by t.lin_codigo, rpad(p.mes_ano_venda,4,'0') ");

      res_Jw_web_poi2 = j.select(table, sb.toString(), null);


      //------------------

      for (int a = 0; a < res_Jw_web_poi2.size(); a++) {
        portalbr.dbobj.view.Jw_web_poi r = (portalbr.dbobj.view.Jw_web_poi) res_Jw_web_poi2.elementAt(a);
        res_Jw_web_poi.addElement(r);

      }

    }
    //------------------

    session.setAttribute("res_Jw_web_poi",res_Jw_web_poi);
    if (!(res_Jw_web_poi != null && res_Jw_web_poi.size() > 0)) {
      throw new Exception("Nenhum registro encontrado!");
    }
    ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
    if (errors == null) {
      errors = new ActionErrors();
    }
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_web_poi", new ActionMessage("warn.norowsselected",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);

    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_linha_ref", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    PlusProdutosDadosActionForm f = (PlusProdutosDadosActionForm) form;
    portalbr.dbobj.view.Jw_linha_ref table = new portalbr.dbobj.view.Jw_linha_ref();
    String[][] select = null;
    Object[][] where = { {"Referencia","like", f.getReferencia()}, {"Lin_cdgo","like", f.getLin_cdgo()}, {"Ref_cdgo","like", f.getRef_cdgo()}, {"Descricao","like", f.getDescricao()}, {"Status","like", f.getStatus()} };
    Vector res_Jw_linha_ref = j.select(table, select, where, null, null, null);
    session.setAttribute("res_Jw_linha_ref",res_Jw_linha_ref);
    if (res_Jw_linha_ref != null && res_Jw_linha_ref.size() > 0) {
      portalbr.dbobj.view.Jw_linha_ref r = (portalbr.dbobj.view.Jw_linha_ref) res_Jw_linha_ref.elementAt(0);
      f.setReferencia((r.getReferencia() != null) ? r.getReferencia() + "":"");
      f.setLin_cdgo((r.getLin_cdgo() != null) ? r.getLin_cdgo() + "":"");
      f.setRef_cdgo((r.getRef_cdgo() != null) ? r.getRef_cdgo() + "":"");
      f.setDescricao((r.getDescricao() != null) ? r.getDescricao() + "":"");
      f.setStatus((r.getStatus() != null) ? r.getStatus() + "":"");
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_linha_ref", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute(mapping.getName(), form);
  }

}
