package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 17/01/2006 13:42:04
 * Last Modify Date 15/09/2009 09:03:35
 */

public class LvEntidadeNegocioActionForm extends org.apache.struts.action.ActionForm
{
  public String enne_id;
  public String return0;
  public String enne_descricao;
  private boolean valida = false;
  public LvEntidadeNegocioActionForm() {
  }
  /**
    * ENNE_ID: Método Gets para este campo
    */
  public String getEnne_id() {
    return enne_id;
  }
  /**
    * ENNE_ID: Método Sets pára este campo.
    */
  public void setEnne_id(String PARAM) {
    enne_id = PARAM;
  }
  /**
    * RETURN0: Método Gets para este campo
    */
  public String getReturn0() {
    return return0;
  }
  /**
    * RETURN0: Método Sets pára este campo.
    */
  public void setReturn0(String PARAM) {
    return0 = PARAM;
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
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    enne_id = null;
    return0 = null;
    enne_descricao = null;
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
