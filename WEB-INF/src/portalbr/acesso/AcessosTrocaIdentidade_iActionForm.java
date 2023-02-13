package portalbr.acesso;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 12/12/2017 12:43:18
 * Last Modify Date 14/12/2017 11:42:52
 */

public class AcessosTrocaIdentidade_iActionForm extends org.apache.struts.action.ActionForm
{
  public String atid_usua_id;
  public String usua_nome;
  public String atid_tien_id;
  public String tien_tipo;
  private boolean valida = false;
  public AcessosTrocaIdentidade_iActionForm() {
  }
  /**
    * ATID_USUA_ID: Método Gets para este campo
    */
  public String getAtid_usua_id() {
    return atid_usua_id;
  }
  /**
    * ATID_USUA_ID: Método Sets pára este campo.
    */
  public void setAtid_usua_id(String PARAM) {
    atid_usua_id = PARAM;
  }
  /**
    * USUA_NOME: Método Gets para este campo
    */
  public String getUsua_nome() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (atid_usua_id != null && atid_usua_id.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Usuarios db_object = new Usuarios();
        String[][] select = { {"usua_nome",null} };
        Object[][] where = { {"usua_id","=",com.egen.util.text.FormatNumber.toInteger(atid_usua_id)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Usuarios) results.elementAt(0);
          usua_nome = (db_object.getUsua_nome() != null) ? db_object.getUsua_nome() + "":"";
        } else {
          usua_nome = "";
        }
      }
    } catch (Exception e) {
      usua_nome = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return usua_nome;
  }

  public String[][] getUsua_nome_Ajax(AcessosTrocaIdentidade_iActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getAtid_usua_id() != null && PARAM.getAtid_usua_id().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Usuarios db_object = new Usuarios();
        Object[][] where = { {"usua_id","like",PARAM.getAtid_usua_id()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Usuarios) results.elementAt(0);
          list[0] = new String[]{"usua_nome", (db_object.getUsua_nome() != null) ? db_object.getUsua_nome() + "":""};
        } else {
          list[0] = new String[]{"usua_nome", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"usua_nome", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * USUA_NOME: Método Sets pára este campo.
    */
  public void setUsua_nome(String PARAM) {
    usua_nome = PARAM;
  }
  /**
    * ATID_TIEN_ID: Método Gets para este campo
    */
  public String getAtid_tien_id() {
    return atid_tien_id;
  }
  /**
    * ATID_TIEN_ID: Método Sets pára este campo.
    */
  public void setAtid_tien_id(String PARAM) {
    atid_tien_id = PARAM;
  }
  /**
    * TIEN_TIPO: Método Gets para este campo
    */
  public String getTien_tipo() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (atid_tien_id != null && atid_tien_id.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Tipos_entidade_negocio db_object = new Tipos_entidade_negocio();
        String[][] select = { {"tien_tipo",null} };
        Object[][] where = { {"tien_id","=",com.egen.util.text.FormatNumber.toInteger(atid_tien_id)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Tipos_entidade_negocio) results.elementAt(0);
          tien_tipo = (db_object.getTien_tipo() != null) ? db_object.getTien_tipo() + "":"";
        } else {
          tien_tipo = "";
        }
      }
    } catch (Exception e) {
      tien_tipo = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return tien_tipo;
  }

  public String[][] getTien_tipo_Ajax(AcessosTrocaIdentidade_iActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getAtid_tien_id() != null && PARAM.getAtid_tien_id().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Tipos_entidade_negocio db_object = new Tipos_entidade_negocio();
        Object[][] where = { {"tien_id","=",com.egen.util.text.FormatNumber.toInt(PARAM.getAtid_tien_id())}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Tipos_entidade_negocio) results.elementAt(0);
          list[0] = new String[]{"tien_tipo", (db_object.getTien_tipo() != null) ? db_object.getTien_tipo() + "":""};
        } else {
          list[0] = new String[]{"tien_tipo", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"tien_tipo", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * TIEN_TIPO: Método Sets pára este campo.
    */
  public void setTien_tipo(String PARAM) {
    tien_tipo = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    atid_usua_id = null;
    usua_nome = null;
    atid_tien_id = null;
    tien_tipo = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("insert_action,", request)) {
      if (com.egen.util.text.Validate.isNull(atid_usua_id)) {
        errors.add("atid_usua_id", new ActionMessage("error.validate.notnull","Usuário","atid_usua_id","0"));
      }
      if (com.egen.util.text.Validate.isNull(atid_tien_id)) {
        errors.add("atid_tien_id", new ActionMessage("error.validate.notnull","Tipo Entidade","atid_tien_id","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
