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
 * Creation Date 11/05/2015 11:06:01
 * Last Modify Date 23/06/2015 10:40:58
 */

public class ImportacaoCSVCliRefGdeAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_blank_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ImportacaoCSVCliRefGdeActionForm f = (ImportacaoCSVCliRefGdeActionForm) form;
      String filialFaturamento = f.getFilialFat();
      String ordemCompra = f.getOrdemCompra();
      String caminhoArquivo = "";
      if (f.getArquivo() != null && f.getArquivo().toString() != null && f.getArquivo().toString().length() > 0) {
        util.consultas.Parametros parametros = new util.consultas.Parametros();
        String realPath2bl_form = parametros.retornaParametro("diretorio_arquivos_temporarios");
        realPath2bl_form = realPath2bl_form + java.io.File.separator;
        org.apache.struts.upload.FormFile inputfile2bl_form = f.getArquivo();
        java.io.InputStream stream2bl_form = inputfile2bl_form.getInputStream();
        caminhoArquivo = realPath2bl_form + inputfile2bl_form.getFileName();
        java.io.OutputStream bos2bl_form = new java.io.FileOutputStream(caminhoArquivo);
        int bytesRead2bl_form = 0;
        byte[] buffer2bl_form = new byte[8192];
        while ((bytesRead2bl_form = stream2bl_form.read(buffer2bl_form, 0, 8192)) != -1) {
          bos2bl_form.write(buffer2bl_form, 0, bytesRead2bl_form);
        }
        bos2bl_form.close();
        stream2bl_form.close();
      }

      com.beirario.leitor.Leitor.ler(new com.beirario.excel.ArquivoExcel(caminhoArquivo), filialFaturamento, ordemCompra);

      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception", "Importação concluída."));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", "");

      actionForward = mapping.findForward("same");

    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
