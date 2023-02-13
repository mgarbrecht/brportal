package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 07/02/2006 11:17:06
 * Last Modify Date 24/09/2009 10:03:51
 */

public class LvNavegacaoActionForm extends org.apache.struts.action.ActionForm
{
  public String menu_id;
  public String menu_nome;
  public String menu_texto;
  public String menu_pai_menu_id;
  private boolean valida = false;
  public LvNavegacaoActionForm() {
  }
  /**
    * MENU_ID: Method to get the field value.
    */
  public String getMenu_id() {
    return menu_id;
  }
  /**
    * MENU_ID: Method to set the field value.
    */
  public void setMenu_id(String PARAM) {
    menu_id = PARAM;
  }
  /**
    * MENU_NOME: Method to get the field value.
    */
  public String getMenu_nome() {
    return menu_nome;
  }
  /**
    * MENU_NOME: Method to set the field value.
    */
  public void setMenu_nome(String PARAM) {
    menu_nome = PARAM;
  }
  /**
    * MENU_TEXTO: Method to get the field value.
    */
  public String getMenu_texto() {
    return menu_texto;
  }
  /**
    * MENU_TEXTO: Method to set the field value.
    */
  public void setMenu_texto(String PARAM) {
    menu_texto = PARAM;
  }
  /**
    * MENU_PAI_MENU_ID: Method to get the field value.
    */
  public String getMenu_pai_menu_id() {
    return menu_pai_menu_id;
  }
  /**
    * MENU_PAI_MENU_ID: Method to set the field value.
    */
  public void setMenu_pai_menu_id(String PARAM) {
    menu_pai_menu_id = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    menu_id = null;
    menu_nome = null;
    menu_texto = null;
    menu_pai_menu_id = null;
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
