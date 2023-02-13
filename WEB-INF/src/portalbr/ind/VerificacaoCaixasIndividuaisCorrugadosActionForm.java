package portalbr.ind;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 29/04/2015 09:28:47
 * Last Modify Date 07/05/2015 10:52:57
 */

public class VerificacaoCaixasIndividuaisCorrugadosActionForm extends org.apache.struts.action.ActionForm
{
  public String rotulo;
  public String mensagem;
  private boolean valida = false;
  public VerificacaoCaixasIndividuaisCorrugadosActionForm() {
  }
  /**
    * ROTULO: Método Gets para este campo
    */
  public String getRotulo() {
    return rotulo;
  }
  /**
    * ROTULO: Método Sets pára este campo.
    */
  public void setRotulo(String PARAM) {
    rotulo = PARAM;
  }
  /**
    * MENSAGEM: Método Gets para este campo
    */
  public String getMensagem() {
    return mensagem;
  }
  /**
    * MENSAGEM: Método Sets pára este campo.
    */
  public void setMensagem(String PARAM) {
    mensagem = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    rotulo = null;
    mensagem = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
