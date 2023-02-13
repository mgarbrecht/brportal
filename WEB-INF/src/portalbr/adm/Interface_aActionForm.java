package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 07/04/2010 10:03:19
 * Last Modify Date 29/04/2010 14:09:17
 */

public class Interface_aActionForm extends org.apache.struts.action.ActionForm
{
  public String inte_id;
  public String inte_nome;
  public String inte_descricao;
  private boolean valida = false;
  public Interface_aActionForm() {
  }
  /**
    * INTE_ID: Método Gets para este campo
    */
  public String getInte_id() {
    return inte_id;
  }
  /**
    * INTE_ID: Método Sets pára este campo.
    */
  public void setInte_id(String PARAM) {
    inte_id = PARAM;
  }
  /**
    * INTE_NOME: Método Gets para este campo
    */
  public String getInte_nome() {
    return inte_nome;
  }
  /**
    * INTE_NOME: Método Sets pára este campo.
    */
  public void setInte_nome(String PARAM) {
    inte_nome = PARAM;
  }
  /**
    * INTE_DESCRICAO: Método Gets para este campo
    */
  public String getInte_descricao() {
    return inte_descricao;
  }
  /**
    * INTE_DESCRICAO: Método Sets pára este campo.
    */
  public void setInte_descricao(String PARAM) {
    inte_descricao = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    inte_id = null;
    inte_nome = null;
    inte_descricao = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("update_action,delete_action,", request)) {
      if (com.egen.util.text.Validate.isNull(inte_nome)) {
        errors.add("inte_nome", new ActionMessage("error.validate.notnull","Interface","inte_nome","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
