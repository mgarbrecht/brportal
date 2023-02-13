package portalbr.acesso;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 07/02/2006 09:59:39
 * Last Modify Date 26/05/2015 14:52:43
 */

public class DocumentosInterfaces_aActionForm extends org.apache.struts.action.ActionForm
{
  public String doin_id;
  public String doin_nome;
  public String doin_descricao;
  public String pos;
  private boolean valida = false;
  public DocumentosInterfaces_aActionForm() {
  }
  /**
    * DOIN_ID: M�todo Gets para este campo
    */
  public String getDoin_id() {
    return doin_id;
  }
  /**
    * DOIN_ID: M�todo Sets p�ra este campo.
    */
  public void setDoin_id(String PARAM) {
    doin_id = PARAM;
  }
  /**
    * DOIN_NOME: M�todo Gets para este campo
    */
  public String getDoin_nome() {
    return doin_nome;
  }
  /**
    * DOIN_NOME: M�todo Sets p�ra este campo.
    */
  public void setDoin_nome(String PARAM) {
    doin_nome = PARAM;
  }
  /**
    * DOIN_DESCRICAO: M�todo Gets para este campo
    */
  public String getDoin_descricao() {
    return doin_descricao;
  }
  /**
    * DOIN_DESCRICAO: M�todo Sets p�ra este campo.
    */
  public void setDoin_descricao(String PARAM) {
    doin_descricao = PARAM;
  }
  /**
    * POS: M�todo Gets para este campo
    */
  public String getPos() {
    return pos;
  }
  /**
    * POS: M�todo Sets p�ra este campo.
    */
  public void setPos(String PARAM) {
    pos = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    doin_id = null;
    doin_nome = null;
    doin_descricao = null;
    pos = null;
  }
  /**
    * Valida��o dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("update_action,delete_action,", request)) {
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
