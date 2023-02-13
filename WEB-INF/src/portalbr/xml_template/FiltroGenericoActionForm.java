package portalbr.xml_template;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 25/10/2010 04:57:31
 * Last Modify Date 04/04/2013 08:09:06
 */

public class FiltroGenericoActionForm extends org.apache.struts.action.ActionForm
{
  public String number_column1;
  private boolean valida = false;
  public FiltroGenericoActionForm() {
  }
  /**
    * NUMBER_COLUMN1: Método Gets para este campo
    */
  public String getNumber_column1() {
    return number_column1;
  }
  /**
    * NUMBER_COLUMN1: Método Sets pára este campo.
    */
  public void setNumber_column1(String PARAM) {
    number_column1 = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    number_column1 = null;
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
