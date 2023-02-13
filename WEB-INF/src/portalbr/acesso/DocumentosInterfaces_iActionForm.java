package portalbr.acesso;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 07/02/2006 09:19:22
 * Last Modify Date 27/08/2009 16:21:26
 */

public class DocumentosInterfaces_iActionForm extends org.apache.struts.action.ActionForm
{
  public String doin_id;
  public String doin_nome;
  public String doin_descricao;
  private boolean valida = false;
  public DocumentosInterfaces_iActionForm() {
  }
  /**
    * DOIN_ID: Method to get the field value.
    */
  public String getDoin_id() {
    return doin_id;
  }
  /**
    * DOIN_ID: Method to set the field value.
    */
  public void setDoin_id(String PARAM) {
    doin_id = PARAM;
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
    doin_id = null;
    doin_nome = null;
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
    if (com.egen.util.text.Validate.isValidate("insert_action,", request)) {
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
