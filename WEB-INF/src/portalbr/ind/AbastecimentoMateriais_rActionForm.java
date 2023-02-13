package portalbr.ind;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 22/08/2013 08:01:52
 * Last Modify Date 05/09/2018 09:04:51
 */

public class AbastecimentoMateriais_rActionForm extends org.apache.struts.action.ActionForm
{
  public String id;
  private boolean valida = false;
  public AbastecimentoMateriais_rActionForm() {
  }
  /**
    * ID: Método Gets para este campo
    */
  public String getId() {
    return id;
  }
  /**
    * ID: Método Sets pára este campo.
    */
  public void setId(String PARAM) {
    id = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    id = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("delete_action,", request)) {
      if (com.egen.util.text.Validate.isNull(id)) {
        errors.add("id", new ActionMessage("error.validate.notnull","Id","id","1"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
