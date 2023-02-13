package portalbr.acesso;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 18/01/2006 14:38:36
 * Last Modify Date 27/08/2009 16:27:10
 */

public class ListaUsuariosEntidadesActionForm extends org.apache.struts.action.ActionForm
{
  public String usua_enne_id;
  public String enne_id;
  private boolean valida = false;
  public ListaUsuariosEntidadesActionForm() {
  }
  /**
    * USUA_ENNE_ID: Método Gets para este campo
    */
  public String getUsua_enne_id() {
    return usua_enne_id;
  }
  /**
    * USUA_ENNE_ID: Método Sets pára este campo.
    */
  public void setUsua_enne_id(String PARAM) {
    usua_enne_id = PARAM;
  }
  /**
    * ENNE_ID: Método Gets para este campo
    */
  public String getEnne_id() {
    return enne_id;
  }
  /**
    * ENNE_ID: Método Sets pára este campo.
    */
  public void setEnne_id(String PARAM) {
    enne_id = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    usua_enne_id = null;
    enne_id = null;
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
