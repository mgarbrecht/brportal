package portalbr.acesso;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 07/02/2006 13:49:02
 * Last Modify Date 29/10/2010 07:49:51
 */

public class NavegacaoActionForm extends org.apache.struts.action.ActionForm
{
  public String menu_id;
  public String menu_nome;
  public String menu_texto;
  public String menu_pai_menu_id;
  public String menu_nome_pai;
  public String pos;
  private boolean valida = false;
  public NavegacaoActionForm() {
  }
  /**
    * MENU_ID: Método Gets para este campo
    */
  public String getMenu_id() {
    return menu_id;
  }
  /**
    * MENU_ID: Método Sets pára este campo.
    */
  public void setMenu_id(String PARAM) {
    menu_id = PARAM;
  }
  /**
    * MENU_NOME: Método Gets para este campo
    */
  public String getMenu_nome() {
    return menu_nome;
  }
  /**
    * MENU_NOME: Método Sets pára este campo.
    */
  public void setMenu_nome(String PARAM) {
    menu_nome = PARAM;
  }
  /**
    * MENU_TEXTO: Método Gets para este campo
    */
  public String getMenu_texto() {
    return menu_texto;
  }
  /**
    * MENU_TEXTO: Método Sets pára este campo.
    */
  public void setMenu_texto(String PARAM) {
    menu_texto = PARAM;
  }
  /**
    * MENU_PAI_MENU_ID: Método Gets para este campo
    */
  public String getMenu_pai_menu_id() {
    return menu_pai_menu_id;
  }
  /**
    * MENU_PAI_MENU_ID: Método Sets pára este campo.
    */
  public void setMenu_pai_menu_id(String PARAM) {
    menu_pai_menu_id = PARAM;
  }
  /**
    * MENU_NOME_PAI: Método Gets para este campo
    */
  public String getMenu_nome_pai() {
    String fieldRelationValue = "";
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (menu_pai_menu_id != null && menu_pai_menu_id.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        portalbr.dbobj.table.Menus db_object = new portalbr.dbobj.table.Menus();
        Object[][] where = { {"menu_id","=",com.egen.util.text.FormatNumber.toInteger(menu_pai_menu_id)} };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (portalbr.dbobj.table.Menus) results.elementAt(0);
          menu_nome_pai = db_object.getMenu_nome();
        }
      }
    } catch (Exception e) {
      fieldRelationValue = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    //menu_nome_pai = fieldRelationValue;
    return menu_nome_pai;
  }
  /**
    * MENU_NOME_PAI: Método Sets pára este campo.
    */
  public void setMenu_nome_pai(String PARAM) {
    menu_nome_pai = PARAM;
  }
  /**
    * POS: Método Gets para este campo
    */
  public String getPos() {
    return pos;
  }
  /**
    * POS: Método Sets pára este campo.
    */
  public void setPos(String PARAM) {
    pos = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    menu_id = null;
    menu_nome = null;
    menu_texto = null;
    menu_pai_menu_id = null;
    menu_nome_pai = null;
    pos = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("insert_action,update_action,delete_action,", request)) {
      if (!com.egen.util.text.Validate.isRegex(menu_pai_menu_id, "^[0-9]*$")) {
        errors.add("menu_pai_menu_id", new ActionMessage("error.validate.regex","Pai","menu_pai_menu_id","1"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
