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
 * Creation Date 22/12/2010 14:30:00
 * Last Modify Date 24/07/2021 09:54:33
 */

public class EtiquetasNormasAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      EtiquetasNormasActionForm f = (EtiquetasNormasActionForm) form;
      select_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_nv_norma", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    EtiquetasNormasActionForm f = (EtiquetasNormasActionForm) form;
    acesso.Sessao sessao = new acesso.Sessao(session);
    util.consultas.Query query = new util.consultas.Query();
    //---------- Limpa Temporária -----------------
    StringBuilder sd = new StringBuilder();
    sd.append(" DELETE wbrio.tmp_generic_table_brportal ");
    sd.append("  WHERE varchar_column1 = '"+sessao.getUsuario() + "' ");
    sd.append("    AND varchar_column2 = 'ETIQUETAS NORMAS'");
    query.execute(j, sd.toString());
    //---------------------------------------------

    Jw_nv_norma table = new Jw_nv_norma();
    StringBuilder sb = new StringBuilder();
    StringBuilder parametros = new StringBuilder();

    if (f.getCodigo_marca() != "") {
      parametros.append(" AND n.codigo_marca in ("+f.getCodigo_marca() + ")");
    }
    if (f.getLin_cdgo() != "") {
      parametros.append(" AND n.lin_cdgo in ("+f.getLin_cdgo() + ")");
    }

    sb.append(" SELECT n.id_norma_venda ");
    sb.append("      , n.codigo_marca ");
    sb.append("      , pck_marcas_produtos.get_nome(n.codigo_marca) descricao_marca ");
    sb.append("      , n.submarca_cdgo ");
    sb.append("      , n.lin_cdgo ");
    sb.append("      , i.item_id ");
    sb.append("      , replace(i.descr_item,CHR(10),'<br>') desc_item ");
    sb.append("      , m.id_material ");
    sb.append("      , pck_cabedal.get_nome(m.id_material) || ' - ' || m.id_material material ");
    sb.append("   FROM nv_norma_venda           n ");
    sb.append("      , nv_item_norma_venda      i ");
    sb.append("      , nv_materiais_norma_venda m ");
    sb.append("  WHERE n.id_norma_venda = i.id_norma_venda ");
    sb.append("    AND m.id_norma_venda = i.id_norma_venda ");
    sb.append("    AND m.item_id = i.item_id   ");
    sb.append(parametros.toString());
    sb.append("    AND exists ( SELECT 1 ");
    sb.append("                   FROM nv_linha_materiais_publicada p ");
    sb.append("                  WHERE p.id_norma_venda = i.id_norma_venda ");
    sb.append("                    AND p.item_id        = i.item_id ");
    sb.append("                    AND p.id_material    = m.id_material ) ");
    sb.append("  ORDER BY n.id_norma_venda ");
    sb.append("         , i.item_id ");
    sb.append("         , id_material ");

    Vector res_Jw_nv_norma = j.select(table, sb.toString(), null);
    session.setAttribute("res_Jw_nv_norma",res_Jw_nv_norma);
    if (!(res_Jw_nv_norma != null && res_Jw_nv_norma.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_nv_norma", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute("mapping.getName()", form);
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      EtiquetasNormasActionForm f = (EtiquetasNormasActionForm) form;
      acesso.Sessao sessao = new acesso.Sessao(session);
      util.consultas.Query query = new util.consultas.Query();
      //---------- Limpa Temporária -----------------
      StringBuilder sd = new StringBuilder();
      sd.append(" DELETE wbrio.tmp_generic_table_brportal ");
      sd.append("  WHERE varchar_column1 = '"+sessao.getUsuario() + "' ");
      sd.append("    AND varchar_column2 = 'ETIQUETAS NORMAS'");
      query.execute(sd.toString());
      //---------------------------------------------
      session.removeAttribute("inseriu_item_norma");
      session.removeAttribute("res_Jw_nv_norma");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_nv_norma", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
  public ActionForward perform_insert_item_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      util.consultas.Query query = new util.consultas.Query();
      acesso.Sessao sessao = new acesso.Sessao(session);
      j = new com.egen.util.jdbc.JdbcUtil();
      EtiquetasNormasActionForm f = (EtiquetasNormasActionForm) form;
      StringBuilder se = new StringBuilder();
      se.append(" SELECT 's' ");
      se.append("   FROM wbrio.tmp_generic_table_brportal ");
      se.append("  WHERE varchar_column1 = '"+sessao.getUsuario() + "' ");
      se.append("    AND varchar_column2 = 'ETIQUETAS NORMAS'");
      se.append("    AND varchar_column3 = 'I' ");
      se.append("    AND varchar_column4 = '"+f.getInsert_norma() + "' ");
      se.append("    AND varchar_column5 = '"+f.getInsert_item() + "' ");
      se.append("    AND varchar_column6 = '"+f.getInsert_linha() + "' ");
      se.append("    AND varchar_column7 = '"+f.getInsert_referencia() + "' ");
      se.append("    AND varchar_column8 = '"+f.getInsert_cabedal() + "' ");
      se.append("    AND ROWNUM = 1 ");
      String existe = query.retorna(j, se.toString());

      if (!existe.equals("s")) {
        StringBuilder sb = new StringBuilder();
        sb.append(" INSERT INTO wbrio.tmp_generic_table_brportal ");
        sb.append("    ( varchar_column1 ");
        sb.append("    , varchar_column2 ");
        sb.append("    , varchar_column3 ");
        sb.append("    , varchar_column4 ");
        sb.append("    , varchar_column5 ");
        sb.append("    , varchar_column6 ");
        sb.append("    , varchar_column7 ");
        sb.append("    , varchar_column8 ) ");
        sb.append("  VALUES ");
        sb.append("    ( '"+sessao.getUsuario() + "' ");
        sb.append("    , 'ETIQUETAS NORMAS' ");
        sb.append("    , 'I' ");
        sb.append("    , '"+f.getInsert_norma() + "' ");
        sb.append("    , '"+f.getInsert_item() + "' ");
        sb.append("    , '"+f.getInsert_linha() + "' ");
        sb.append("    , '"+f.getInsert_referencia() + "' ");
        sb.append("    , '"+f.getInsert_cabedal() + "' ) ");

        query.execute(j, sb.toString());

      }

      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_nv_norma", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  public ActionForward perform_insert_cor_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      util.consultas.Query query = new util.consultas.Query();
      acesso.Sessao sessao = new acesso.Sessao(session);
      j = new com.egen.util.jdbc.JdbcUtil();
      EtiquetasNormasActionForm f = (EtiquetasNormasActionForm) form;
      StringBuilder se = new StringBuilder();
      se.append(" SELECT 's' ");
      se.append("   FROM wbrio.tmp_generic_table_brportal ");
      se.append("  WHERE varchar_column1 = '"+sessao.getUsuario() + "' ");
      se.append("    AND varchar_column2 = 'ETIQUETAS NORMAS'");
      se.append("    AND varchar_column3 = 'C' ");
      se.append("    AND varchar_column4 = '"+f.getInsert_norma() + "' ");
      se.append("    AND varchar_column5 = '"+f.getInsert_item() + "' ");
      se.append("    AND varchar_column6 = '"+f.getInsert_linha() + "' ");
      se.append("    AND varchar_column7 = '"+f.getInsert_referencia() + "' ");
      se.append("    AND varchar_column8 = '"+f.getInsert_cabedal() + "' ");
      se.append("    AND varchar_column9 = '"+f.getInsert_cor() + "' ");
      se.append("    AND ROWNUM = 1 ");
      String existe = query.retorna(j, se.toString());

      if (!existe.equals("s")) {
        StringBuilder sb = new StringBuilder();
        sb.append(" INSERT INTO wbrio.tmp_generic_table_brportal ");
        sb.append("    ( varchar_column1 ");
        sb.append("    , varchar_column2 ");
        sb.append("    , varchar_column3 ");
        sb.append("    , varchar_column4 ");
        sb.append("    , varchar_column5 ");
        sb.append("    , varchar_column6 ");
        sb.append("    , varchar_column7 ");
        sb.append("    , varchar_column8 ");
        sb.append("    , varchar_column9 ) ");
        sb.append("  VALUES ");
        sb.append("    ( '"+sessao.getUsuario() + "' ");
        sb.append("    , 'ETIQUETAS NORMAS' ");
        sb.append("    , 'C' ");
        sb.append("    , '"+f.getInsert_norma() + "' ");
        sb.append("    , '"+f.getInsert_item() + "' ");
        sb.append("    , '"+f.getInsert_linha() + "' ");
        sb.append("    , '"+f.getInsert_referencia() + "' ");
        sb.append("    , '"+f.getInsert_cabedal() + "' ");
        sb.append("    , '"+f.getInsert_cor() + "' ) ");
        query.execute(j, sb.toString());
      }

      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_nv_norma", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  public ActionForward perform_delete_item_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      util.consultas.Query query = new util.consultas.Query();
      j = new com.egen.util.jdbc.JdbcUtil();
      EtiquetasNormasActionForm f = (EtiquetasNormasActionForm) form;
      acesso.Sessao sessao = new acesso.Sessao(session);
      StringBuilder sd = new StringBuilder();
      sd.append(" DELETE wbrio.tmp_generic_table_brportal ");
      sd.append("  WHERE varchar_column1 = '"+sessao.getUsuario() + "' ");
      sd.append("    AND varchar_column2 = 'ETIQUETAS NORMAS'");
      sd.append("    AND varchar_column3 = 'I' ");
      sd.append("    AND varchar_column4 = '"+f.getInsert_norma() + "' ");
      sd.append("    AND varchar_column5 = '"+f.getInsert_item() + "' ");
      sd.append("    AND varchar_column6 = '"+f.getInsert_linha() + "' ");
      sd.append("    AND varchar_column7 = '"+f.getInsert_referencia() + "' ");
      sd.append("    AND varchar_column8 = '"+f.getInsert_cabedal() + "' ");
      query.execute(j, sd.toString());
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_nv_norma", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  public ActionForward perform_delete_cor_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      util.consultas.Query query = new util.consultas.Query();
      j = new com.egen.util.jdbc.JdbcUtil();
      EtiquetasNormasActionForm f = (EtiquetasNormasActionForm) form;
      acesso.Sessao sessao = new acesso.Sessao(session);
      StringBuilder sd = new StringBuilder();
      sd.append(" DELETE wbrio.tmp_generic_table_brportal ");
      sd.append("  WHERE varchar_column1 = '"+sessao.getUsuario() + "' ");
      sd.append("    AND varchar_column2 = 'ETIQUETAS NORMAS'");
      sd.append("    AND varchar_column3 = 'C' ");
      sd.append("    AND varchar_column4 = '"+f.getInsert_norma() + "' ");
      sd.append("    AND varchar_column5 = '"+f.getInsert_item() + "' ");
      sd.append("    AND varchar_column6 = '"+f.getInsert_linha() + "' ");
      sd.append("    AND varchar_column7 = '"+f.getInsert_referencia() + "' ");
      sd.append("    AND varchar_column8 = '"+f.getInsert_cabedal() + "' ");
      sd.append("    AND varchar_column9 = '"+f.getInsert_cor() + "' ");
      query.execute(j, sd.toString());
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_nv_norma", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  public ActionForward perform_pdf_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      util.consultas.Query query = new util.consultas.Query();
      EtiquetasNormasActionForm f = (EtiquetasNormasActionForm) form;
      acesso.Sessao sessao = new acesso.Sessao(session);
      String selecionado = query.retorna("SELECT 1 FROM tmp_generic_table_brportal WHERE varchar_column1 = '"+sessao.getUsuario() + "' AND varchar_column2 = 'ETIQUETAS NORMAS' AND ROWNUM = 1");
      if (selecionado.equals("") || selecionado == null) {
        throw new Exception("Nenhum item marcado para a geração das etiquetas!");
      }
      //--------------------------------------------------------------------
      util.file.GeraPDF g = new util.file.GeraPDF(request);
      g.setRelatorio("etiqueta_normas.rdf");
      g.setParametro("p_imagem","/opt/tomcat/webapps/brportal/img/logo_login.jpg");
      g.setParametro("p_usuario",sessao.getUsuario());
      g.gerar();
      request.setAttribute("abre_automaticamente","N");
      //--------------------------------------------------------------------
      actionForward = mapping.findForward("same");
    }
    catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_nv_norma", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
}
