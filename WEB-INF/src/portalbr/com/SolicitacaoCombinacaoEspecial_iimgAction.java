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
 * Creation Date 11/06/2015 08:28:50
 * Last Modify Date 05/11/2020 12:19:23
 */

public class SolicitacaoCombinacaoEspecial_iimgAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_upload_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    SolicitacaoCombinacaoEspecial_iimgActionForm f = (SolicitacaoCombinacaoEspecial_iimgActionForm) form;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      util.consultas.Query query = new util.consultas.Query();
      util.consultas.Parametros parametros = new util.consultas.Parametros();
      if (f.getImagem() != null && f.getImagem().toString() != null && f.getImagem().toString().length() > 0) {
        String realPath2bl_form = parametros.retornaParametro("diretorio_arquivos_diario_combinacao_especial");
        realPath2bl_form = realPath2bl_form + java.io.File.separator;
        org.apache.struts.upload.FormFile inputfile2bl_form = f.getImagem();
        if (inputfile2bl_form.getFileSize() > 512000) {
          throw new Exception("O arquivo de imagem ultrapassou o tamanho máximo de 500kb!");
        }
        String idImagem = query.retorna("SELECT nvl(max(id_imagem)+1,1) from brio.ref_combinacao_especial_img WHERE id_solicitacao = " + f.getId_solicitacao());
        java.io.InputStream stream2bl_form = inputfile2bl_form.getInputStream();
        java.io.OutputStream bos2bl_form = new java.io.FileOutputStream(realPath2bl_form + "S"+f.getId_solicitacao() + "_"+idImagem + "_"+inputfile2bl_form.getFileName());
        int bytesRead2bl_form = 0;
        byte[] buffer2bl_form = new byte[8192];
        while ((bytesRead2bl_form = stream2bl_form.read(buffer2bl_form, 0, 8192)) != -1) {
          bos2bl_form.write(buffer2bl_form, 0, bytesRead2bl_form);
        }
        bos2bl_form.close();
        stream2bl_form.close();
        Ref_combinacao_especial_img table_img = new Ref_combinacao_especial_img();
        Object[][] name_value_img = { {"id_solicitacao",com.egen.util.text.FormatNumber.toInteger(f.getId_solicitacao())}, {"id_imagem",com.egen.util.text.FormatNumber.toInteger(idImagem)}, {"imagem","S"+f.getId_solicitacao() + "_"+idImagem + "_"+f.getImagem()}, {"descricao_imagem", f.getDescricao()}, };
        j.insert(table_img , name_value_img);
        tg_upload_action(mapping, form, request, response);
      } else {
        throw new Exception("O arquivo deve ser informado!");
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ref_combinacao_especial_img", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void tg_upload_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ref_combinacao_especial_img", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

}
