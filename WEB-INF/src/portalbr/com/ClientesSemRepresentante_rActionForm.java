package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 10/08/2006 15:19:53
 * Last Modify Date 26/08/2009 16:29:40
 */

public class ClientesSemRepresentante_rActionForm extends org.apache.struts.action.ActionForm
{
  public String estado;
  private boolean valida = false;
  public ClientesSemRepresentante_rActionForm() {
  }
  /**
    * ESTADO: Método Gets para este campo
    */
  public String getEstado() {
    return estado;
  }
  /**
    * ESTADO: Método Sets pára este campo.
    */
  public void setEstado(String PARAM) {
    estado = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    estado = null;
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
