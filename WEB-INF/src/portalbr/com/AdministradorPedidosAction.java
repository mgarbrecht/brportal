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
 * Creation Date 13/04/2006 17:36:21
 * Last Modify Date 09/09/2022 11:42:50
 */

public class AdministradorPedidosAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //--------------------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 13/04/2006
    // Objetivo          : Executa uma consulta na view portalbr.dbobj.view.Jw_web_poi, redirecionando
    //                     para a tela de relatório:
    //                     /com/AdministradorPedidos_rForm.jsp
    //--------------------------------------------------------------------------------------------------
    // Data de Alteração :
    // Descrição         :
    //--------------------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      AdministradorPedidosActionForm f = (AdministradorPedidosActionForm) form;
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);

      if ((f.getTipo() + "").equalsIgnoreCase("A")) {
        if (f.getSomente_disponivel().equals("N")) {
          actionForward = new ActionForward("/com/AdministradorPedidos_rForm.jsp",true);
        } else {
          actionForward = new ActionForward("/com/AdministradorPedidos_rsForm.jsp",true);
        }
      } else {
        actionForward = new ActionForward("/com/AdministradorPedidos_rsiForm.jsp",true);
      }
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_web_poi", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    acesso.Sessao sessao = new acesso.Sessao(session);
    String[] t = null;
    AdministradorPedidosActionForm f = (AdministradorPedidosActionForm) form;
    if ((f.getTipo() + "").equalsIgnoreCase("A")) {
      if (f.getDt_inicial().equals("") && f.getDt_final().equals("")) {
        throw new Exception("Um dos campos com <img src='../img/opcional.gif' border='0'/> deve ser informado!");
      }
    } else {
      if ((f.getDt_inicial().equals("") && !f.getDt_final().equals("")) || (!f.getDt_inicial().equals("") && f.getDt_final().equals(""))) {
        throw new Exception("A data inicial e final devem ser informadas!");
      }
    }
    String linha = "null";
    StringBuilder marca = new StringBuilder();
    String referencia = "null";
    String dataInicial = "null";
    String dataFinal = "null";
    String disponibilidade = "";
    boolean informouPeriodo = false;
    if (f.getLin_cdgo() != "") {
      linha = f.getLin_cdgo();
    }
    //---------------------------------------------------------------------
    if (f.getCodigo_marca() != "") {
      marca.append(" AND t.lin_codigo IN ");
      marca.append("      ( SELECT DISTINCT ");
      marca.append("               r.lin_cdgo linha ");
      marca.append("          FROM ref r ");
      marca.append("         WHERE r.codigo_marca = nvl(").append(f.getCodigo_marca()).append(",r.codigo_marca) ");
      marca.append("           AND r.ref_status   = 'A' ) ");

    } else {
      marca.append(" AND t.lin_codigo = NVL(").append(linha).append(", t.lin_codigo) ");
    }
    //---------------------------------------------------------------------

    if (f.getRef_cdgo() != "") {
      referencia = f.getRef_cdgo();
    }

    if (f.getDisponibilidade().equals("f")) {
      disponibilidade = " having ( sum( capacidade_pares ) - sum( venda_pares ) ) <= 0 ";
    }
    if (f.getDisponibilidade().equals("s")) {
      disponibilidade = " having ( sum( capacidade_pares ) - sum( venda_pares ) ) > 0  ";
    }
    //-------------------------------------------
    if (f.getDt_inicial() != "") {
      if (f.getDt_inicial().length() < 4) {
        throw new Exception("A Data Inicial deve possuir 4 caracteres!");
      } else {
        dataInicial = "'"+ f.getDt_inicial() + "'";
        informouPeriodo = true;
      }
    }

    if (f.getDt_final() != "") {
      if (f.getDt_final().length() < 4) {
        throw new Exception("A Data Final deve possuir 4 caracteres!");
      } else {
        dataFinal = "'"+f.getDt_final() + "'";
        informouPeriodo = true;
      }
    }



    portalbr.dbobj.view.Jw_web_poi table = new portalbr.dbobj.view.Jw_web_poi();
    portalbr.dbobj.view.Jw_web_poi_filtro tables = new portalbr.dbobj.view.Jw_web_poi_filtro();
    portalbr.dbobj.view.Jw_administrador_pedidos_sintetico tablesin = new portalbr.dbobj.view.Jw_administrador_pedidos_sintetico();


    Vector res_Jw_web_poi_filtro = new Vector();
    Vector res_Jw_web_poi = new Vector();
    Vector res_Jw_administrador_pedidos_sintetico = new Vector();


    StringBuilder query = new StringBuilder();
    query.append(" SELECT t.lin_codigo || DECODE(t.ref_codigo, 0, NULL, '.') || DECODE(t.ref_codigo, 0, NULL, t.ref_codigo) lin_ref ");
    query.append("      , t.lin_codigo linha ");
    query.append("      , DECODE(t.ref_codigo, 0, '', t.ref_codigo) ref_codigo ");
    query.append("      , l.lin_nome ");
    query.append("      , mes || SUBSTR(cs.ano, 3, 4) mes_ano_venda ");
    query.append("      , 0 total_pares_venda ");
    query.append("      , SUM(capacidade_pares) capacidade ");
    query.append("      , SUM(venda_pares) vendas ");
    query.append("      , SUM(capacidade_pares) - SUM(venda_pares) disponivel ");
    query.append("      , fnc_pares_retidos_credito(TO_DATE(mes || cs.ano, 'mmyyyy'), TRUNC(LAST_DAY(TO_DATE(mes || cs.ano, 'mmyyyy'))), t.lin_codigo) pares_ret_credito ");
    query.append("      , t.periodo ");
    query.append("      , data_inicial ");
    query.append("      , data_final ");
    query.append("   FROM toneis t ");
    query.append("      , lin l ");
    query.append("      , (SELECT DISTINCT ");
    query.append("                cod_empresa ");
    query.append("              , cod_filial ");
    query.append("              , periodo ");
    query.append("              , extract(YEAR FROM data) ano ");
    query.append("              , LPAD(extract(MONTH FROM data), 2, 0) mes ");
    query.append("              , MIN(DATA) data_inicial ");
    query.append("              , MAX(data) data_final ");
    query.append("           FROM calendarios_semanal ");
    query.append("          WHERE data BETWEEN NVL(TO_DATE("+dataInicial + ", 'mmrr'), data) AND NVL(LAST_DAY(TO_DATE("+dataFinal + ", 'mmrr')), data) ");
    query.append("          GROUP BY cod_empresa ");
    query.append("                 , cod_filial ");
    query.append("                 , periodo ");
    query.append("                 , EXTRACT(YEAR FROM DATA) ");
    query.append("                 , LPAD(EXTRACT(MONTH FROM data), 2, 0)) cs ");
    query.append("  WHERE cs.cod_empresa     = t.cod_empresa ");
    query.append("    AND cs.cod_filial      = t.cod_filial ");
    query.append("    AND cs.periodo         = t.periodo ");
    query.append("    AND t.ano              = cs.ano ");
    query.append("    AND t.lin_codigo       = l.lin_cdgo ");
    query.append("    AND exists (select 1 from ref_cor rc where rc.lin_cdgo = t.lin_codigo and rc.rfc_status = 'A') ");
    query.append("    AND t.ref_codigo       = nvl(").append(referencia).append(", t.ref_codigo) ");
    query.append("    AND t.lin_codigo       = nvl(").append(linha).append(", t.lin_codigo) ");
    query.append(marca.toString());
    query.append(disponibilidade);
    query.append("  GROUP BY cs.ano ");
    query.append("         , cs.mes ");
    query.append("         , t.lin_codigo ");
    query.append("         , t.ref_codigo ");
    query.append("         , l.lin_nome ");
    query.append("         , t.periodo ");
    query.append("         , cs.data_inicial ");
    query.append("         , cs.data_final ");
    query.append("  ORDER BY cs.ano ");
    query.append("         , cs.mes ");
    query.append("         , t.lin_codigo ");
    query.append("         , t.ref_codigo ");
    query.append("         , l.lin_nome ");
    query.append("         , t.periodo ");

    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      if ((f.getTipo() + "").equalsIgnoreCase("A")) {
        throw new Exception(query.toString());
      }
    }


    if ((f.getTipo() + "").equalsIgnoreCase("A")) {
      if (f.getSomente_disponivel().equals("N")) {
        res_Jw_web_poi = j.select(table, query.toString(), null);
        session.setAttribute("res_Jw_web_poi",res_Jw_web_poi);
        if (!(res_Jw_web_poi != null && res_Jw_web_poi.size() > 0)) {
          throw new Exception("Nenhum registro encontrado!");
        }
      }
    }



    StringBuilder querys = new StringBuilder();
    querys.append(" SELECT t.lin_codigo || DECODE(t.ref_codigo, 0, NULL, '.') || DECODE(t.ref_codigo, 0, NULL, t.ref_codigo) lin_ref ");
    querys.append("      , t.lin_codigo linha ");
    querys.append("      , DECODE(t.ref_codigo, 0, '', t.ref_codigo) ref_codigo ");
    querys.append("      , l.lin_nome ");
    querys.append("      , cs.mes ");
    querys.append("      , cs.ano ");
    querys.append("      , COUNT(DISTINCT t.periodo) periodos ");
    querys.append("   FROM toneis t ");
    querys.append("      , lin l ");
    querys.append("      , (SELECT DISTINCT cod_empresa ");
    querys.append("                       , cod_filial ");
    querys.append("                       , periodo ");
    querys.append("                       , EXTRACT(YEAR FROM data) ano ");
    querys.append("                       , EXTRACT(MONTH FROM DATA) mes ");
    querys.append("                       , MIN(data) data_inicial ");
    querys.append("                       , MAX(data) data_final ");
    querys.append("           FROM calendarios_semanal ");
    querys.append("          WHERE data BETWEEN NVL(TO_DATE("+dataInicial + ", 'mmrr'), data) AND NVL(LAST_DAY(TO_DATE("+dataFinal + ", 'mmrr')), data) ");
    querys.append("          GROUP BY cod_empresa ");
    querys.append("                 , cod_filial ");
    querys.append("                 , periodo ");
    querys.append("                 , EXTRACT(YEAR FROM data) ");
    querys.append("                 , EXTRACT(MONTH FROM data)) cs ");
    querys.append("  WHERE cs.cod_empresa = t.cod_empresa ");
    querys.append("    AND cs.cod_filial = t.cod_filial ");
    querys.append("    AND cs.periodo = t.periodo ");
    querys.append("    AND exists (select 1 from ref_cor rc where rc.lin_cdgo = t.lin_codigo and rc.rfc_status = 'A') ");
    querys.append("    AND t.ano = cs.ano ");
    querys.append("    AND t.lin_codigo = l.lin_cdgo ");
    querys.append(marca.toString());
    querys.append(disponibilidade);
    querys.append("  GROUP BY cs.ano ");
    querys.append("         , cs.mes ");
    querys.append("         , t.lin_codigo ");
    querys.append("         , t.ref_codigo ");
    querys.append("         , l.lin_nome ");
    querys.append("  ORDER BY cs.ano ");
    querys.append("         , cs.mes ");
    querys.append("         , t.lin_codigo ");
    querys.append("         , t.ref_codigo ");
    querys.append("         , l.lin_nome ");

    if ((f.getTipo() + "").equalsIgnoreCase("A")) {
      if (f.getSomente_disponivel().equals("S")) {
        res_Jw_web_poi_filtro = j.select(tables, querys.toString(), null);

        session.setAttribute("res_Jw_web_poi_filtro",res_Jw_web_poi_filtro);
        if (!(res_Jw_web_poi_filtro != null && res_Jw_web_poi_filtro.size() > 0)) {
          throw new Exception("Nenhum registro encontrado!");
        }
      }
    }

    if ((f.getTipo() + "").equalsIgnoreCase("S")) {
      StringBuilder querysin = new StringBuilder();
      querysin.append(" SELECT lin_cdgo ");
      querysin.append("      , lin_nome ");
      querysin.append("      , min(data_inicial) data_inicial ");
      querysin.append("   FROM (SELECT t.lin_codigo lin_cdgo ");
      querysin.append("              , l.lin_nome ");
      querysin.append("              , min(data_inicial) data_inicial ");
      querysin.append("           FROM toneis t ");
      querysin.append("              , lin l ");
      querysin.append("              , (SELECT DISTINCT cod_empresa ");
      querysin.append("                      , cod_filial ");
      querysin.append("                      , periodo ");
      querysin.append("                      , extract(YEAR FROM data) ano ");
      querysin.append("                      , LPAD(extract(MONTH FROM data), 2, 0) mes ");
      querysin.append("                      , MIN(DATA) data_inicial ");
      querysin.append("                      , MAX(data) data_final ");
      querysin.append("                   FROM calendarios_semanal ");
      if (informouPeriodo) {
        querysin.append("                  WHERE data BETWEEN NVL(TO_DATE("+dataInicial + ", 'mmrr'), data) AND NVL(LAST_DAY(TO_DATE("+dataFinal + ", 'mmrr')), data) ");
      } else {
        querysin.append("                  WHERE data > sysdate -1 ");
      }
      querysin.append("                  GROUP BY cod_empresa ");
      querysin.append("                      , cod_filial ");
      querysin.append("                      , periodo ");
      querysin.append("                      , EXTRACT(YEAR FROM DATA) ");
      querysin.append("                      , LPAD(EXTRACT(MONTH FROM data), 2, 0)) cs ");
      querysin.append("          WHERE cs.cod_empresa = t.cod_empresa ");
      querysin.append("            AND cs.cod_filial = t.cod_filial ");
      querysin.append("            AND cs.periodo = t.periodo ");
      querysin.append("            AND t.ano = cs.ano ");

      //---------------------------------------------------------------------

      if (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL") || sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO")) {
        querysin.append("            AND t.lin_codigo IN (SELECT DISTINCT ");
        querysin.append("                                        r.lin_cdgo linha  ");
        querysin.append("                                   FROM ref r ");
        querysin.append("                                      , representante_marca rm ");
        querysin.append("                                  WHERE r.codigo_marca = rm.marca_produto ");
        querysin.append("                                    AND rm.situacao = 'A' ");
        querysin.append("                                    AND rm.codigo_representante = '").append(sessao.getChave()).append("' ");
        querysin.append("                                    AND r.ref_status   = 'A' ) ");
      }

      querysin.append("            AND t.lin_codigo = l.lin_cdgo ");
      querysin.append(marca.toString());
      querysin.append("         HAVING (SUM(capacidade_pares) - SUM(venda_pares)) > 0 ");
      querysin.append("          GROUP BY t.lin_codigo ");
      querysin.append("                 , l.lin_nome ");
      querysin.append("                 , cs.data_inicial ");
      querysin.append("         ) ");
      querysin.append("     GROUP BY lin_cdgo ");
      querysin.append("            , lin_nome ");
      querysin.append("     ORDER BY data_inicial ");
      querysin.append("            , lin_cdgo ");

      res_Jw_administrador_pedidos_sintetico = j.select(tablesin, querysin.toString(), null);
      if (usuario.mostraQuery()) {
        if ((f.getTipo() + "").equalsIgnoreCase("S")) {
          throw new Exception(querysin.toString());
        }
      }
      session.setAttribute("res_Jw_administrador_pedidos_sintetico",res_Jw_administrador_pedidos_sintetico);
      if (!(res_Jw_administrador_pedidos_sintetico != null && res_Jw_administrador_pedidos_sintetico.size() > 0)) {
        throw new Exception("Nenhum registro encontrado!");
      }
    }

    ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
    if (errors == null) {
      errors = new ActionErrors();
    }
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_web_poi", new ActionMessage("warn.norowsselected",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);

    session.setAttribute("mapping.getName()", form);
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      AdministradorPedidosActionForm f = (AdministradorPedidosActionForm) form;
      session.removeAttribute("res_Jw_web_poi");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_web_poi", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_refresh_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      AdministradorPedidosActionForm f = (AdministradorPedidosActionForm) form;
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_web_poi", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
