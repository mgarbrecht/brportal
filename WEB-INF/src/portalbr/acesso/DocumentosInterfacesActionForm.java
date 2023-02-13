package portalbr.acesso;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 07/02/2006 09:03:44
 * Last Modify Date 29/07/2014 11:47:47
 */

public class DocumentosInterfacesActionForm extends org.apache.struts.action.ActionForm
{
  public String doin_id;
  public String doin_nome;
  public String doin_descricao;
  private boolean valida = false;
  public DocumentosInterfacesActionForm() {
  }
  /**
    * DOIN_ID: Método Gets para este campo
    */
  public String getDoin_id() {
    return doin_id;
  }
  /**
    * DOIN_ID: Método Sets pára este campo.
    */
  public void setDoin_id(String PARAM) {
    doin_id = PARAM;
  }
  /**
    * DOIN_NOME: Método Gets para este campo
    */
  public String getDoin_nome() {
    return doin_nome;
  }
  /**
    * DOIN_NOME: Método Sets pára este campo.
    */
  public void setDoin_nome(String PARAM) {
    doin_nome = PARAM;
  }
  /**
    * DOIN_DESCRICAO: Método Gets para este campo
    */
  public String getDoin_descricao() {
    return doin_descricao;
  }
  /**
    * DOIN_DESCRICAO: Método Sets pára este campo.
    */
  public void setDoin_descricao(String PARAM) {
    doin_descricao = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    doin_id = null;
    doin_nome = null;
    doin_descricao = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
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
