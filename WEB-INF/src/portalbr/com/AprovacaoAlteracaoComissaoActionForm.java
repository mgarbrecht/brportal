package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 09/01/2012 17:16:15
 * Last Modify Date 02/04/2013 13:51:51
 */

public class AprovacaoAlteracaoComissaoActionForm extends org.apache.struts.action.ActionForm
{
  public String id_solicitacao;
  private boolean valida = false;
  public AprovacaoAlteracaoComissaoActionForm() {
  }
  /**
    * ID_SOLICITACAO: Método Gets para este campo
    */
  public String getId_solicitacao() {
    return id_solicitacao;
  }
  /**
    * ID_SOLICITACAO: Método Sets pára este campo.
    */
  public void setId_solicitacao(String PARAM) {
    id_solicitacao = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    id_solicitacao = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (!com.egen.util.struts.Token.isTokenValid(mapping, request)) {
      errors.add("Warning", new ActionMessage("token.error","<br>","","",""));
    }
    com.egen.util.struts.Token.saveToken(mapping, request);

    if (com.egen.util.text.Validate.isValidate("aprovar_action,recusar_action,", request)) {
      if (com.egen.util.text.Validate.isNull(id_solicitacao)) {
        errors.add("id_solicitacao", new ActionMessage("error.validate.notnull","Id_solicitacao","id_solicitacao","1"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
