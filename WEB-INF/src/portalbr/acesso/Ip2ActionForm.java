package portalbr.acesso;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 21/05/2009 12:46:02
 * Last Modify Date 08/07/2009 12:50:18
 */

public class Ip2ActionForm extends org.apache.struts.action.ActionForm
{
  public String ip;
  private boolean valida = false;
  public Ip2ActionForm() {
  }
  /**
    * IP: Método Gets para este campo
    */
  public String getIp() {
    return ip;
  }
  /**
    * IP: Método Sets pára este campo.
    */
  public void setIp(String PARAM) {
    ip = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    ip = null;
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
