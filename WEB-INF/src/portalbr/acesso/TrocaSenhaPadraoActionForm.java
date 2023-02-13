package portalbr.acesso;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 28/08/2006 15:48:36
 * Last Modify Date 09/06/2021 11:40:21
 */

public class TrocaSenhaPadraoActionForm extends org.apache.struts.action.ActionForm
{
  public String usua_id;
  public String usua_usuario;
  public String usua_nome;
  public String situacao;
  public String usua_email;
  private boolean valida = false;
  public TrocaSenhaPadraoActionForm() {
  }
  /**
    * USUA_ID: Método Gets para este campo
    */
  public String getUsua_id() {
    return usua_id;
  }
  /**
    * USUA_ID: Método Sets pára este campo.
    */
  public void setUsua_id(String PARAM) {
    usua_id = PARAM;
  }
  /**
    * USUA_USUARIO: Método Gets para este campo
    */
  public String getUsua_usuario() {
    return usua_usuario;
  }
  /**
    * USUA_USUARIO: Método Sets pára este campo.
    */
  public void setUsua_usuario(String PARAM) {
    usua_usuario = PARAM;
  }
  /**
    * USUA_NOME: Método Gets para este campo
    */
  public String getUsua_nome() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (usua_usuario != null && usua_usuario.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Usuarios db_object = new Usuarios();
        String[][] select = { {"usua_nome",null}, {"usua_id",null}, {"situacao",null} };
        Object[][] where = { {"usua_usuario","like",usua_usuario}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Usuarios) results.elementAt(0);
          usua_nome = (db_object.getUsua_nome() != null) ? db_object.getUsua_nome() + "":"";
          usua_id = (db_object.getUsua_id() != null) ? db_object.getUsua_id() + "":"";
          situacao = (db_object.getSituacao() != null) ? db_object.getSituacao() + "":"";
          if (situacao.equalsIgnoreCase("A")) {
            situacao = "Ativo";
          } else {
            situacao = "Bloqueado";
          }
        } else {
          usua_nome = "";
          usua_id = "";
          situacao = "";
        }
      }
    } catch (Exception e) {
      usua_nome = "";
      usua_id = "";
      situacao = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return usua_nome;
  }

  public String[][] getUsua_nome_Ajax(TrocaSenhaPadraoActionForm PARAM) {
    String[][] list = new String[3][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getUsua_usuario() != null && PARAM.getUsua_usuario().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Usuarios db_object = new Usuarios();
        Object[][] where = { {"usua_usuario","like",PARAM.getUsua_usuario()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Usuarios) results.elementAt(0);
          list[0] = new String[]{"usua_nome", (db_object.getUsua_nome() != null) ? db_object.getUsua_nome() + "":""};
          list[1] = new String[]{"usua_id", (db_object.getUsua_id() != null) ? db_object.getUsua_id() + "":""};
          String situacao = (db_object.getSituacao() != null) ? db_object.getSituacao() + "":"";
          if (situacao.equalsIgnoreCase("A")) {
            situacao = "Ativo";
          } else {
            situacao = "Bloqueado";
          }
          list[2] = new String[]{"situacao", situacao};

        } else {
          list[0] = new String[]{"usua_nome", ""};
          list[1] = new String[]{"usua_id", ""};
          list[2] = new String[]{"situacao", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"usua_nome", ""};
      list[1] = new String[]{"usua_id", ""};
      list[2] = new String[]{"situacao", ""};
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
    * SITUACAO: Método Gets para este campo
    */
  public String getSituacao() {
    return situacao;
  }
  /**
    * SITUACAO: Método Sets pára este campo.
    */
  public void setSituacao(String PARAM) {
    situacao = PARAM;
  }
  /**
    * USUA_EMAIL: Método Gets para este campo
    */
  public String getUsua_email() {
    return usua_email;
  }
  /**
    * USUA_EMAIL: Método Sets pára este campo.
    */
  public void setUsua_email(String PARAM) {
    usua_email = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    usua_id = null;
    usua_usuario = null;
    usua_nome = null;
    situacao = null;
    usua_email = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("select_action,update_action,", request)) {
      if (com.egen.util.text.Validate.isNull(usua_usuario)) {
        errors.add("usua_usuario", new ActionMessage("error.validate.notnull","Usuário","usua_usuario","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
