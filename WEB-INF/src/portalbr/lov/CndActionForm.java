package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 01/08/2016 13:09:56
 * Last Modify Date 01/08/2016 13:16:42
 */

public class CndActionForm extends org.apache.struts.action.ActionForm
{
  public String return0;
  public String cnd_cdgo;
  public String cnd_desc;
  private boolean valida = false;
  public CndActionForm() {
  }
  /**
    * RETURN0: M�todo Gets para este campo
    */
  public String getReturn0() {
    return return0;
  }
  /**
    * RETURN0: M�todo Sets p�ra este campo.
    */
  public void setReturn0(String PARAM) {
    return0 = PARAM;
  }
  /**
    * CND_CDGO: M�todo Gets para este campo
    */
  public String getCnd_cdgo() {
    return cnd_cdgo;
  }
  /**
    * CND_CDGO: M�todo Sets p�ra este campo.
    */
  public void setCnd_cdgo(String PARAM) {
    cnd_cdgo = PARAM;
  }
  /**
    * CND_DESC: M�todo Gets para este campo
    */
  public String getCnd_desc() {
    return cnd_desc;
  }
  /**
    * CND_DESC: M�todo Sets p�ra este campo.
    */
  public void setCnd_desc(String PARAM) {
    cnd_desc = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    return0 = null;
    cnd_cdgo = null;
    cnd_desc = null;
  }
  /**
    * Valida��o dos campos, retornando um ActionErrors.
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
