package portalbr.acesso;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 08/02/2006 13:22:33
 * Last Modify Date 29/10/2010 07:47:33
 */

public class ItemNavegacaoActionForm extends org.apache.struts.action.ActionForm
{
  public String itme_id;
  public String itme_nome;
  public String itme_texto;
  public String itme_comando;
  public String itme_menu_id;
  public String menu_nome;
  public String itme_doin_id;
  public String doin_nome;
  private boolean valida = false;
  public ItemNavegacaoActionForm() {
  }
  /**
    * ITME_ID: Método Gets para este campo
    */
  public String getItme_id() {
    return itme_id;
  }
  /**
    * ITME_ID: Método Sets pára este campo.
    */
  public void setItme_id(String PARAM) {
    itme_id = PARAM;
  }
  /**
    * ITME_NOME: Método Gets para este campo
    */
  public String getItme_nome() {
    return itme_nome;
  }
  /**
    * ITME_NOME: Método Sets pára este campo.
    */
  public void setItme_nome(String PARAM) {
    itme_nome = PARAM;
  }
  /**
    * ITME_TEXTO: Método Gets para este campo
    */
  public String getItme_texto() {
    return itme_texto;
  }
  /**
    * ITME_TEXTO: Método Sets pára este campo.
    */
  public void setItme_texto(String PARAM) {
    itme_texto = PARAM;
  }
  /**
    * ITME_COMANDO: Método Gets para este campo
    */
  public String getItme_comando() {
    return itme_comando;
  }
  /**
    * ITME_COMANDO: Método Sets pára este campo.
    */
  public void setItme_comando(String PARAM) {
    itme_comando = PARAM;
  }
  /**
    * ITME_MENU_ID: Método Gets para este campo
    */
  public String getItme_menu_id() {
    return itme_menu_id;
  }
  /**
    * ITME_MENU_ID: Método Sets pára este campo.
    */
  public void setItme_menu_id(String PARAM) {
    itme_menu_id = PARAM;
  }
  /**
    * MENU_NOME: Método Gets para este campo
    */
  public String getMenu_nome() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (itme_menu_id != null && itme_menu_id.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Menus db_object = new Menus();
        String[][] select = {{"menu_nome",null}};
        Object[][] where = { {"menu_id","=",com.egen.util.text.FormatNumber.toInteger(itme_menu_id)} };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Menus) results.elementAt(0);
          menu_nome = (db_object.getMenu_nome() != null) ? db_object.getMenu_nome() + "":"";
        } else {
          menu_nome = "";
        }
      }
    } catch (Exception e) {
      menu_nome = "";
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return menu_nome;
  }

  public String[][] getMenu_nome_Ajax(ItemNavegacaoActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getItme_menu_id() != null && PARAM.getItme_menu_id().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Menus db_object = new Menus();
        Object[][] where = { {"menu_id","=",com.egen.util.text.FormatNumber.toInteger(PARAM.getItme_menu_id())} };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Menus) results.elementAt(0);
          list[0] = new String[]{"menu_nome", (db_object.getMenu_nome() != null) ? db_object.getMenu_nome() + "":""};
        } else {
          list[0] = new String[]{"menu_nome", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"menu_nome", ""};
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return list;
  }
  /**
    * MENU_NOME: Método Sets pára este campo.
    */
  public void setMenu_nome(String PARAM) {
    menu_nome = PARAM;
  }
  /**
    * ITME_DOIN_ID: Método Gets para este campo
    */
  public String getItme_doin_id() {
    return itme_doin_id;
  }
  /**
    * ITME_DOIN_ID: Método Sets pára este campo.
    */
  public void setItme_doin_id(String PARAM) {
    itme_doin_id = PARAM;
  }
  /**
    * DOIN_NOME: Método Gets para este campo
    */
  public String getDoin_nome() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (itme_doin_id != null && itme_doin_id.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Documentos_interfaces db_object = new Documentos_interfaces();
        String[][] select = {{"doin_nome",null}};
        Object[][] where = { {"doin_id","=",com.egen.util.text.FormatNumber.toInteger(itme_doin_id)} };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Documentos_interfaces) results.elementAt(0);
          doin_nome = (db_object.getDoin_nome() != null) ? db_object.getDoin_nome() + "":"";
        } else {
          doin_nome = "";
        }
      }
    } catch (Exception e) {
      doin_nome = "";
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return doin_nome;
  }

  public String[][] getDoin_nome_Ajax(ItemNavegacaoActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getItme_doin_id() != null && PARAM.getItme_doin_id().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Documentos_interfaces db_object = new Documentos_interfaces();
        Object[][] where = { {"doin_id","like",PARAM.getItme_doin_id()} };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Documentos_interfaces) results.elementAt(0);
          list[0] = new String[]{"doin_nome", (db_object.getDoin_nome() != null) ? db_object.getDoin_nome() + "":""};
        } else {
          list[0] = new String[]{"doin_nome", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"doin_nome", ""};
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return list;
  }
  /**
    * DOIN_NOME: Método Sets pára este campo.
    */
  public void setDoin_nome(String PARAM) {
    doin_nome = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    itme_id = null;
    itme_nome = null;
    itme_texto = null;
    itme_comando = null;
    itme_menu_id = null;
    menu_nome = null;
    itme_doin_id = null;
    doin_nome = null;
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
      if (!com.egen.util.text.Validate.isRegex(itme_menu_id, "^[0-9]*$")) {
        errors.add("itme_menu_id", new ActionMessage("error.validate.regex","Menu","itme_menu_id","1"));
      }
      if (!com.egen.util.text.Validate.isRegex(itme_doin_id, "^[0-9]*$")) {
        errors.add("itme_doin_id", new ActionMessage("error.validate.regex","Documento/<br>Interface","itme_doin_id","1"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
