package portalbr.direto;

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
 * Creation Date 16/04/2013 16:40:16
 * Last Modify Date 21/02/2017 13:49:00
 */

public class RankingProdutosAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      RankingProdutosActionForm f = (RankingProdutosActionForm) form;
      select_action(j, mapping, form, request, response);
      if (request.getAttribute("arquivo") == null) {
        actionForward = new ActionForward(((String) request.getAttribute("arquivo")), true);
      } else {
        actionForward = new ActionForward(((String) request.getAttribute("arquivo")), true);
      }
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    RankingProdutosActionForm f = (RankingProdutosActionForm) form;
    util.consultas.Query query = new util.consultas.Query();
    util.consultas.Parametros parametros = new util.consultas.Parametros();
    String usuario = (f.getRep_cdgo() + "").toUpperCase().replace("BRREP", "");
    String mostra = query.retorna("SELECT decode(tipo_usuario,6,'S',9,'S',10,'N','S'),tipo_usuario FROM cat_usuarios WHERE codigo_usuario = UPPER('"+usuario + "')");
    mostra = "S";
    util.file.GeraPDF g = new util.file.GeraPDF(request);
    g.setRelatorio("RankingProdutos.jasper");
    g.setParametro("P_DIRETORIO_IMAGEM_LOGOS", "/opt/tomcat/webapps/brportal/img/");
    g.setParametro("P_DIRETORIO_IMAGEM", "/opt/tomcat/webapps/brportal/imagens/pequenas/");
    if (mostra.equalsIgnoreCase("S")) {
      g.setParametro("P_CODIGO_MARCA", f.getCodigo_marca());
    } else {
      g.setParametro("P_CODIGO_MARCA", "0");
    }
    if (f.getCodigo_regional() != null) {
      if (f.getCodigo_regional() != "") {
        g.setParametro("P_CODIGO_REGIONAL", Integer.parseInt(f.getCodigo_regional()));
      }
    }
    g.gerarDireto(util.rand.Palavra.geraPalavra());
    acesso.UsuarioAPI usuarioAPI = new acesso.UsuarioAPI(j.getConn());
    usuarioAPI.atualizaUltimoAcesso(usuario.toUpperCase());
    session.setAttribute(mapping.getName(), form);
  }
}
