package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 11/12/2017 09:10:02
 * Last Modify Date 14/12/2017 14:11:12
 */

public class PlanilhaImportacaoCalcenterActionForm extends org.apache.struts.action.ActionForm
{
  public String pedidos;
  private boolean valida = false;
  public PlanilhaImportacaoCalcenterActionForm() {
  }
  /**
    * PEDIDOS: Método Gets para este campo
    */
  public String getPedidos() {
    return pedidos;
  }
  /**
    * PEDIDOS: Método Sets pára este campo.
    */
  public void setPedidos(String PARAM) {
    pedidos = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    pedidos = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("select_action,", request)) {
      if (com.egen.util.text.Validate.isNull(pedidos)) {
        errors.add("pedidos", new ActionMessage("error.validate.notnull","Pedidos","pedidos","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
