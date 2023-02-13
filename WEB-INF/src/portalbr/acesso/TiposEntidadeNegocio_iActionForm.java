package portalbr.acesso;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 18/01/2006 10:12:09
 * Last Modify Date 08/10/2009 09:15:46
 */

public class TiposEntidadeNegocio_iActionForm extends org.apache.struts.action.ActionForm
{
  public String tien_id;
  public String tien_tipo;
  public String tien_tabela;
  public String tien_campos_descr;
  public String tien_campos_chave;
  public String tien_condicional;
  public String tien_dias_consulta_retroativa;
  private boolean valida = false;
  public TiposEntidadeNegocio_iActionForm() {
  }
  /**
    * TIEN_ID: Method to get the field value.
    */
  public String getTien_id() {
    return tien_id;
  }
  /**
    * TIEN_ID: Method to set the field value.
    */
  public void setTien_id(String PARAM) {
    tien_id = PARAM;
  }
  /**
    * TIEN_TIPO: Method to get the field value.
    */
  public String getTien_tipo() {
    return tien_tipo;
  }
  /**
    * TIEN_TIPO: Method to set the field value.
    */
  public void setTien_tipo(String PARAM) {
    tien_tipo = PARAM;
  }
  /**
    * TIEN_TABELA: Method to get the field value.
    */
  public String getTien_tabela() {
    return tien_tabela;
  }
  /**
    * TIEN_TABELA: Method to set the field value.
    */
  public void setTien_tabela(String PARAM) {
    tien_tabela = PARAM;
  }
  /**
    * TIEN_CAMPOS_DESCR: Method to get the field value.
    */
  public String getTien_campos_descr() {
    return tien_campos_descr;
  }
  /**
    * TIEN_CAMPOS_DESCR: Method to set the field value.
    */
  public void setTien_campos_descr(String PARAM) {
    tien_campos_descr = PARAM;
  }
  /**
    * TIEN_CAMPOS_CHAVE: Method to get the field value.
    */
  public String getTien_campos_chave() {
    return tien_campos_chave;
  }
  /**
    * TIEN_CAMPOS_CHAVE: Method to set the field value.
    */
  public void setTien_campos_chave(String PARAM) {
    tien_campos_chave = PARAM;
  }
  /**
    * TIEN_CONDICIONAL: Method to get the field value.
    */
  public String getTien_condicional() {
    return tien_condicional;
  }
  /**
    * TIEN_CONDICIONAL: Method to set the field value.
    */
  public void setTien_condicional(String PARAM) {
    tien_condicional = PARAM;
  }
  /**
    * TIEN_DIAS_CONSULTA_RETROATIVA: Method to get the field value.
    */
  public String getTien_dias_consulta_retroativa() {
    return tien_dias_consulta_retroativa;
  }
  /**
    * TIEN_DIAS_CONSULTA_RETROATIVA: Method to set the field value.
    */
  public void setTien_dias_consulta_retroativa(String PARAM) {
    tien_dias_consulta_retroativa = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    tien_id = null;
    tien_tipo = null;
    tien_tabela = null;
    tien_campos_descr = null;
    tien_campos_chave = null;
    tien_condicional = null;
    tien_dias_consulta_retroativa = null;
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
      if (com.egen.util.text.Validate.isNull(tien_dias_consulta_retroativa)) {
        errors.add("tien_dias_consulta_retroativa", new ActionMessage("error.validate.notnull","Dias Consulta Retroativa","tien_dias_consulta_retroativa","0"));
      }
      if (!com.egen.util.text.Validate.isNumber(tien_dias_consulta_retroativa)) {
        errors.add("tien_dias_consulta_retroativa", new ActionMessage("error.validate.number","Dias Consulta Retroativa","tien_dias_consulta_retroativa","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
