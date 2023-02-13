package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 03/05/2006 09:47:41
 * Last Modify Date 13/01/2016 14:44:36
 */

public class CodigoBarraUnico_rActionForm extends org.apache.struts.action.ActionForm
{
  public String consulta;
  private boolean valida = false;
  public CodigoBarraUnico_rActionForm() {
  }
  /**
    * CONSULTA: Método Gets para este campo
    */
  public String getConsulta() {
    return consulta;
  }
  /**
    * CONSULTA: Método Sets pára este campo.
    */
  public void setConsulta(String PARAM) {
    consulta = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    consulta = null;
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
