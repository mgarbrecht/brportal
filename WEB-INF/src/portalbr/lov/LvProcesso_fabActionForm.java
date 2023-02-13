package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 31/08/2009 14:57:30
 * Last Modify Date 25/08/2015 09:37:32
 */

public class LvProcesso_fabActionForm extends org.apache.struts.action.ActionForm
{
  public String return0;
  public String pro_numero;
  public String pro_nome;
  private boolean valida = false;
  public LvProcesso_fabActionForm() {
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
    * PRO_NUMERO: Método Gets para este campo
    */
  public String getPro_numero() {
    return pro_numero;
  }
  /**
    * PRO_NUMERO: Método Sets pára este campo.
    */
  public void setPro_numero(String PARAM) {
    pro_numero = PARAM;
  }
  /**
    * PRO_NOME: Método Gets para este campo
    */
  public String getPro_nome() {
    return pro_nome;
  }
  /**
    * PRO_NOME: Método Sets pára este campo.
    */
  public void setPro_nome(String PARAM) {
    pro_nome = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    return0 = null;
    pro_numero = null;
    pro_nome = null;
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
