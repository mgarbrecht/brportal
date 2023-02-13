package portalbr.acesso;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 20/10/2010 13:38:31
 * Last Modify Date 01/11/2011 08:37:51
 */

public class TesteFiltroActionForm extends org.apache.struts.action.ActionForm
{
  public String query;
  private boolean valida = false;
  public TesteFiltroActionForm() {
  }
  /**
    * QUERY: Method to get the field value.
    */
  public String getQuery() {
    return query;
  }
  /**
    * QUERY: Method to set the field value.
    */
  public void setQuery(String PARAM) {
    query = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    query = null;
  }
  /**
    * Validate fields and return errors.
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
