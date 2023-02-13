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
 * Creation Date 29/08/2017 10:45:00
 * Last Modify Date 01/09/2017 11:25:57
 */

public class ImagensPedidoAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ImagensPedidoActionForm f = (ImagensPedidoActionForm) form;
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
    ImagensPedidoActionForm f = (ImagensPedidoActionForm) form;
    java.sql.PreparedStatement pstm = null;
    java.sql.ResultSet rset = null;
    List < String > listaImagens = new ArrayList();
    try {
      StringBuilder sbParametros = new StringBuilder();
      if ((f.getPedido() != null && f.getPedido() != "") && (f.getChave() != null && f.getChave() != "")) {
        sbParametros.append(" AND ped_nmro = " + f.getPedido());
        sbParametros.append(" AND wbrio.fct_retorna_chave_sha256(ped_nmro) = '"+f.getChave() + "'");
      } else {
        sbParametros.append(" AND 1=2 ");
      }
      StringBuilder sb = new StringBuilder();
      sb.append(" SELECT ped_nmro ");
      sb.append("      , imagem ");
      sb.append("   FROM (SELECT i.ped_nmro ");
      sb.append("              , REPLACE(fct_retorna_fit_imagem(i.lin_cdgo, i.ref_cdgo, i.cab_cdgo, i.cor_cdgo), '.gif', '.jpg') imagem ");
      sb.append("           FROM ite i) ");
      sb.append("  WHERE imagem <> 'default.jpg' ");
      sb.append(sbParametros.toString());
      pstm = j.getConn().prepareStatement(sb.toString());
      rset = pstm.executeQuery();
      while (rset.next()) {
        listaImagens.add(rset.getString("imagem"));
      }
      session.setAttribute("listaImagens", listaImagens);
      util.consultas.com.DownloadImagens downloadImagens = new util.consultas.com.DownloadImagens();
      String arquivo = downloadImagens.processar(request);
      if (arquivo != null) {
        request.setAttribute("arquivo", arquivo);
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    } finally {
      if (rset != null) {
        try {
          rset.close();
        } catch (java.sql.SQLException e) {
          e.printStackTrace();
        }
      }
      if (pstm != null) {
        try {
          pstm.close();
        } catch (java.sql.SQLException e) {
          e.printStackTrace();
        }
      }
    }
    session.setAttribute(mapping.getName(), form);
  }
}
