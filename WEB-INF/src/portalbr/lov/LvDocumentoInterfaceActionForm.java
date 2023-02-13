package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 09/02/2006 10:32:26
 * Last Modify Date 21/09/2009 08:12:12
 */

public class LvDocumentoInterfaceActionForm extends org.apache.struts.action.ActionForm
{
  public String doin_nome;
  public String return0;
  public String doin_descricao;
  private boolean valida = false;
  public LvDocumentoInterfaceActionForm() {
  }
  /**
    * DOIN_NOME: Method to get the field value.
    */
  public String getDoin_nome() {
    return doin_nome;
  }
  /**
    * DOIN_NOME: Method to set the field value.
    */
  public void setDoin_nome(String PARAM) {
    doin_nome = PARAM;
  }
  /**
    * RETURN0: Method to get the field value.
    */
  public String getReturn0() {
    return return0;
  }
  /**
    * RETURN0: Method to set the field value.
    */
  public void setReturn0(String PARAM) {
    return0 = PARAM;
  }
  /**
    * DOIN_DESCRICAO: Method to get the field value.
    */
  public String getDoin_descricao() {
    return doin_descricao;
  }
  /**
    * DOIN_DESCRICAO: Method to set the field value.
    */
  public void setDoin_descricao(String PARAM) {
    doin_descricao = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    doin_nome = null;
    return0 = null;
    doin_descricao = null;
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
