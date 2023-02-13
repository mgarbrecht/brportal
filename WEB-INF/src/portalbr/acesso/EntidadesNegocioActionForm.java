package portalbr.acesso;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 17/01/2006 15:53:56
 * Last Modify Date 07/12/2009 15:20:53
 */

public class EntidadesNegocioActionForm extends org.apache.struts.action.ActionForm
{
  public String enne_descricao;
  public String enne_tien_id;
  public String tien_tipo;
  public String enne_chave;
  private boolean valida = false;
  public EntidadesNegocioActionForm() {
  }
  /**
    * ENNE_DESCRICAO: Método Gets para este campo
    */
  public String getEnne_descricao() {
    return enne_descricao;
  }
  /**
    * ENNE_DESCRICAO: Método Sets pára este campo.
    */
  public void setEnne_descricao(String PARAM) {
    enne_descricao = PARAM;
  }
  /**
    * ENNE_TIEN_ID: Método Gets para este campo
    */
  public String getEnne_tien_id() {
    return enne_tien_id;
  }
  /**
    * ENNE_TIEN_ID: Método Sets pára este campo.
    */
  public void setEnne_tien_id(String PARAM) {
    enne_tien_id = PARAM;
  }
  /**
    * TIEN_TIPO: Método Gets para este campo
    */
  public String getTien_tipo() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (enne_tien_id != null && enne_tien_id.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Tipos_entidade_negocio db_object = new Tipos_entidade_negocio();
        String[][] select = {{"tien_tipo",null}};
        Object[][] where = { {"tien_id","=",com.egen.util.text.FormatNumber.toInteger(enne_tien_id)} };
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
        j = null;
      }
    }
    return tien_tipo;
  }

  public String[][] getTien_tipo_Ajax(EntidadesNegocioActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getEnne_tien_id() != null && PARAM.getEnne_tien_id().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Tipos_entidade_negocio db_object = new Tipos_entidade_negocio();
        Object[][] where = { {"tien_id","like",PARAM.getEnne_tien_id()} };
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
        j = null;
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
    * ENNE_CHAVE: Método Gets para este campo
    */
  public String getEnne_chave() {
    return enne_chave;
  }
  /**
    * ENNE_CHAVE: Método Sets pára este campo.
    */
  public void setEnne_chave(String PARAM) {
    enne_chave = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    enne_descricao = null;
    enne_tien_id = null;
    tien_tipo = null;
    enne_chave = null;
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
      if (!com.egen.util.text.Validate.isRegex(enne_tien_id, "^[0-9]*$")) {
        errors.add("enne_tien_id", new ActionMessage("error.validate.regex","Tipo","enne_tien_id","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
