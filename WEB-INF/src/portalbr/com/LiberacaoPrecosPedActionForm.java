package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 18/06/2010 14:46:45
 * Last Modify Date 21/06/2010 13:19:04
 */

public class LiberacaoPrecosPedActionForm extends org.apache.struts.action.ActionForm
{
  public String p_nmro_solicitacao;
  public String p_libera;
  private boolean valida = false;
  public LiberacaoPrecosPedActionForm() {
  }
  /**
    * P_NMRO_SOLICITACAO: Método Gets para este campo
    */
  public String getP_nmro_solicitacao() {
    return p_nmro_solicitacao;
  }
  /**
    * P_NMRO_SOLICITACAO: Método Sets pára este campo.
    */
  public void setP_nmro_solicitacao(String PARAM) {
    p_nmro_solicitacao = PARAM;
  }
  /**
    * P_LIBERA: Método Gets para este campo
    */
  public String getP_libera() {
    return p_libera;
  }
  /**
    * P_LIBERA: Método Sets pára este campo.
    */
  public void setP_libera(String PARAM) {
    p_libera = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    p_nmro_solicitacao = null;
    p_libera = null;
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
