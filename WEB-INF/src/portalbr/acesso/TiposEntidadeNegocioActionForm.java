package portalbr.acesso;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 18/01/2006 09:15:08
 * Last Modify Date 25/02/2016 11:30:46
 */

public class TiposEntidadeNegocioActionForm extends org.apache.struts.action.ActionForm
{
  public String tien_id;
  public String tien_tipo;
  public String tien_tabela;
  public String tien_campos_descr;
  public String tien_campos_chave;
  public String tien_condicional;
  private boolean valida = false;
  public TiposEntidadeNegocioActionForm() {
  }
  /**
    * TIEN_ID: M�todo Gets para este campo
    */
  public String getTien_id() {
    return tien_id;
  }
  /**
    * TIEN_ID: M�todo Sets p�ra este campo.
    */
  public void setTien_id(String PARAM) {
    tien_id = PARAM;
  }
  /**
    * TIEN_TIPO: M�todo Gets para este campo
    */
  public String getTien_tipo() {
    return tien_tipo;
  }
  /**
    * TIEN_TIPO: M�todo Sets p�ra este campo.
    */
  public void setTien_tipo(String PARAM) {
    tien_tipo = PARAM;
  }
  /**
    * TIEN_TABELA: M�todo Gets para este campo
    */
  public String getTien_tabela() {
    return tien_tabela;
  }
  /**
    * TIEN_TABELA: M�todo Sets p�ra este campo.
    */
  public void setTien_tabela(String PARAM) {
    tien_tabela = PARAM;
  }
  /**
    * TIEN_CAMPOS_DESCR: M�todo Gets para este campo
    */
  public String getTien_campos_descr() {
    return tien_campos_descr;
  }
  /**
    * TIEN_CAMPOS_DESCR: M�todo Sets p�ra este campo.
    */
  public void setTien_campos_descr(String PARAM) {
    tien_campos_descr = PARAM;
  }
  /**
    * TIEN_CAMPOS_CHAVE: M�todo Gets para este campo
    */
  public String getTien_campos_chave() {
    return tien_campos_chave;
  }
  /**
    * TIEN_CAMPOS_CHAVE: M�todo Sets p�ra este campo.
    */
  public void setTien_campos_chave(String PARAM) {
    tien_campos_chave = PARAM;
  }
  /**
    * TIEN_CONDICIONAL: M�todo Gets para este campo
    */
  public String getTien_condicional() {
    return tien_condicional;
  }
  /**
    * TIEN_CONDICIONAL: M�todo Sets p�ra este campo.
    */
  public void setTien_condicional(String PARAM) {
    tien_condicional = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    tien_id = null;
    tien_tipo = null;
    tien_tabela = null;
    tien_campos_descr = null;
    tien_campos_chave = null;
    tien_condicional = null;
  }
  /**
    * Valida��o dos campos, retornando um ActionErrors.
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
