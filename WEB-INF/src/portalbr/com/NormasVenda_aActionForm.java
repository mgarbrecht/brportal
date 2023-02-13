package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 20/06/2006 14:36:26
 * Last Modify Date 27/08/2009 17:05:16
 */

import org.apache.struts.upload.FormFile;

public class NormasVenda_aActionForm extends org.apache.struts.action.ActionForm
{
  public String lidi_marca;
  public String descricao_marca;
  public String lidi_id;
  public String lidi_titulo;
  public String lidi_caminho;
  public String lidi_descricao;
  public String pos;
  public FormFile arquivo;
  private boolean valida = false;
  public NormasVenda_aActionForm() {
  }
  /**
    * LIDI_MARCA: Method to get the field value.
    */
  public String getLidi_marca() {
    return lidi_marca;
  }
  /**
    * LIDI_MARCA: Method to set the field value.
    */
  public void setLidi_marca(String PARAM) {
    lidi_marca = PARAM;
  }
  /**
    * DESCRICAO_MARCA: Method to get the field value.
    */
  public String getDescricao_marca() {
    String fieldRelationValue = "";
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (lidi_marca != null && lidi_marca.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        portalbr.dbobj.table.Marcas_produtos db_object = new portalbr.dbobj.table.Marcas_produtos();
        Object[][] where = { {"codigo_marca","=",com.egen.util.text.FormatNumber.toInt(lidi_marca)} };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (portalbr.dbobj.table.Marcas_produtos) results.elementAt(0);
          fieldRelationValue = (db_object.getDescricao_marca() != null) ? db_object.getDescricao_marca() + "":"";
        }
      }
    } catch (Exception e) {
      fieldRelationValue = "";
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    descricao_marca = fieldRelationValue;
    return descricao_marca;
  }
  /**
    * DESCRICAO_MARCA: Method to set the field value.
    */
  public void setDescricao_marca(String PARAM) {
    descricao_marca = PARAM;
  }
  /**
    * LIDI_ID: Method to get the field value.
    */
  public String getLidi_id() {
    return lidi_id;
  }
  /**
    * LIDI_ID: Method to set the field value.
    */
  public void setLidi_id(String PARAM) {
    lidi_id = PARAM;
  }
  /**
    * LIDI_TITULO: Method to get the field value.
    */
  public String getLidi_titulo() {
    return lidi_titulo;
  }
  /**
    * LIDI_TITULO: Method to set the field value.
    */
  public void setLidi_titulo(String PARAM) {
    lidi_titulo = PARAM;
  }
  /**
    * LIDI_CAMINHO: Method to get the field value.
    */
  public String getLidi_caminho() {
    return lidi_caminho;
  }
  /**
    * LIDI_CAMINHO: Method to set the field value.
    */
  public void setLidi_caminho(String PARAM) {
    lidi_caminho = PARAM;
  }
  /**
    * LIDI_DESCRICAO: Method to get the field value.
    */
  public String getLidi_descricao() {
    return lidi_descricao;
  }
  /**
    * LIDI_DESCRICAO: Method to set the field value.
    */
  public void setLidi_descricao(String PARAM) {
    lidi_descricao = PARAM;
  }
  /**
    * POS: Method to get the field value.
    */
  public String getPos() {
    return pos;
  }
  /**
    * POS: Method to set the field value.
    */
  public void setPos(String PARAM) {
    pos = PARAM;
  }
  /**
    * ARQUIVO: Method to get the field value.
    */
  public FormFile getArquivo() {
    return arquivo;
  }
  /**
    * ARQUIVO: Method to set the field value.
    */
  public void setArquivo(FormFile PARAM) {
    arquivo = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    lidi_marca = null;
    descricao_marca = null;
    lidi_id = null;
    lidi_titulo = null;
    lidi_caminho = null;
    lidi_descricao = null;
    pos = null;
    arquivo = null;
  }
  /**
    * Validate fields and return errors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("update_action,", request)) {
      if (com.egen.util.text.Validate.isNull(lidi_marca)) {
        errors.add("lidi_marca", new ActionMessage("error.validate.notnull","Marca","lidi_marca","0"));
      }
      if (com.egen.util.text.Validate.isNull(lidi_titulo)) {
        errors.add("lidi_titulo", new ActionMessage("error.validate.notnull","Título","lidi_titulo","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
