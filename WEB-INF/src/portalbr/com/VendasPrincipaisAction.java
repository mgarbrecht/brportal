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
 * Creation Date 06/03/2006 17:06:13
 * Last Modify Date 05/11/2015 11:05:30
 */

public class VendasPrincipaisAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //--------------------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 06/03/2006
    // Objetivo          : Executa uma consulta na java view portalbr.dbobj.view.Jw_vendas_principais,
    //                     redirecionando para a tela com a lista de vendas por clientes:
    //                     /com/VendasPrincipais_rForm.jsp
    //--------------------------------------------------------------------------------------------------
    // Data de Alteração :
    // Descrição         :
    //--------------------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    StringBuilder parametro = new StringBuilder();
    try {
      VendasPrincipaisActionForm f = (VendasPrincipaisActionForm) form;
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response, parametro);
      //--------------------------------------------------------------------------------
      // Se a consulta for por Grupo Econômico, chama a tela com a lista
      // passando o parâmetro t com o valor 'g', senão passa o parâmetro t
      // com o valor 'c'. Se o valor passado por 'g', a tela da lista
      // mostra no cabeçalho o nome do grupo econômico, senão mostra o nome do cliente.
      //--------------------------------------------------------------------------------
      if (f.getGre_grupo() != "") {
        session.setAttribute("parametro1","g");
        session.setAttribute("parametro2",f.getGre_grupo());
      } else {
        session.setAttribute("parametro1","c");
        session.setAttribute("parametro2",f.getCli_cdgo());
      }
      //--------------------------------------------------------------------------------
      actionForward = new ActionForward("/com/VendasPrincipais_rForm.jsp?"+parametro.toString(), true);
    }
    catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_vendas_principais", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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

  private void select_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, StringBuilder parametro) throws Exception {
    HttpSession session = request.getSession(true);
    VendasPrincipaisActionForm f = (VendasPrincipaisActionForm) form;
    portalbr.dbobj.view.Jw_vendas_principais table = new portalbr.dbobj.view.Jw_vendas_principais();
    StringBuilder query = new StringBuilder();
    StringBuilder parametros = new StringBuilder();

    if ((f.getGre_grupo() == "") && (f.getCli_cdgo() == "")) {
      throw new Exception("O Cliente ou o Grupo devem ser informados!");
    }

    //--- Monta os parâmetros que vão ser usados na query ----------------------------
    String codigo_regional = "";
    String codigo_representante = "";
    String tipo = "";
    acesso.Usuario u = new acesso.Usuario();
    u = (acesso.Usuario) session.getAttribute("User");
    acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
    acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();

    if (!(u.getEntidadeNegocio() == null)) {
      ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
      tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
      tipo = tipoent.getTipo() + "";
      if (tipo.equals("REGIONAL DE VENDA")) {
        codigo_regional = ent.getChave() + "";
      }
      if ((tipo.equals("REPRESENTANTE COMERCIAL")) || (tipo.equals("REPRESENTANTE EXPORTACAO"))) {
        codigo_representante = ent.getChave() + "";
      }
    }
    //------- Se o usuário logado for regional -----------
    if ((!(codigo_regional.equals("")))) {
      parametros.append(" and p.codigo_regional = ").append(codigo_regional);
    }
    //-------Se o usuário logado for representante --------
    if ((!(codigo_representante.equals("")))) {
      parametros.append(" and p.rep_cdgo = ").append(codigo_representante);
    }
    //-----------------------------------------------------

    if (f.getGre_grupo() != "") {
      parametros.append(" AND NVL(ge.gre_grupo, NULL) = " + f.getGre_grupo());
    } else {
      parametros.append(" AND nvl(ped.cli_cdgo,null) = " + f.getCli_cdgo());
    }
    if ((!(codigo_regional.equals("")))) {
      parametros.append(" AND NVL(r.codigo_regional, NULL) = " + codigo_regional);
    }
    parametros.append(" AND ped.ped_dadg >= to_date('"+f.getDt_inicial() + "', 'dd/mm/yyyy') ");
    parametros.append(" AND ped.ped_dadg < to_date('"+f.getDt_final() + "', 'dd/mm/yyyy') + 1 ");


    query = new StringBuilder();
    query.append(" SELECT descricao_marca marca ");
    query.append("      , periodo ");
    query.append("      , SUM(pck_pedidos.get_pares(ped_nmro)) pares ");
    query.append("      , SUM(fct_valor_pedido(ped_nmro)) valor ");
    query.append("   FROM (SELECT DISTINCT ped.ped_nmro ");
    query.append("                       , to_char(TRUNC(ped.ped_dadg, 'MM'), 'MM/YYYY') periodo ");
    query.append("                       , ite.codigo_marca ");
    query.append("                       , mp.descricao_marca ");
    query.append("           FROM ped ");
    query.append("              , ite ");
    query.append("              , (SELECT * ");
    query.append("                   FROM grupo_economico ge ");
    query.append("                  WHERE NVL(ge.status, NULL) = 'A') ge ");
    query.append("              , marcas_produtos mp ");
    query.append("              , rep r ");
    query.append("          WHERE ped.ped_nmro = ite.ped_nmro ");
    query.append("            AND ge.cli_cdgo(+) = ped.cli_cdgo ");
    query.append("            AND mp.codigo_marca = ite.codigo_marca ");
    query.append("            AND r.rep_cdgo = ped.rep_cdgo      ");
    query.append("            AND pck_pedidos.to_somente_entrada(ite.ped_nmro, ite.ite_seqn) = ");
    query.append("                pck_pedidos.get_somente_entrada(ite.ped_nmro, ite.ite_seqn) ");
    query.append(parametros.toString());
    query.append(" ) ");
    query.append("  GROUP BY descricao_marca ");
    query.append("          ,periodo ");


    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      throw new Exception(query.toString());
    }

    Vector res_Jw_vendas_principais = j.select(table, query.toString(), null);

    session.setAttribute("res_Jw_vendas_principais",res_Jw_vendas_principais);
    if (!(res_Jw_vendas_principais != null && res_Jw_vendas_principais.size() > 0)) {
      throw new Exception("Nenhum registro selecionado");
    }

    session.setAttribute("mapping.getName()", form);
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      VendasPrincipaisActionForm f = (VendasPrincipaisActionForm) form;
      session.removeAttribute("res_Jw_vendas_principais");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_vendas_principais", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
