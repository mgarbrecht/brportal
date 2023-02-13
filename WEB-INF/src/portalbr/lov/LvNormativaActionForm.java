package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 26/09/2014 08:56:05
 * Last Modify Date 26/09/2014 09:09:50
 */

public class LvNormativaActionForm extends org.apache.struts.action.ActionForm
{
  public String return0;
  public String nro_normativa;
  public String descricao;
  private boolean valida = false;
  public LvNormativaActionForm() {
  }
  /**
    * RETURN0: M�todo Gets para este campo
    */
  public String getReturn0() {
    return return0;
  }
  /**
    * RETURN0: M�todo Sets p�ra este campo.
    */
  public void setReturn0(String PARAM) {
    return0 = PARAM;
  }
  /**
    * NRO_NORMATIVA: M�todo Gets para este campo
    */
  public String getNro_normativa() {
    return nro_normativa;
  }
  /**
    * NRO_NORMATIVA: M�todo Sets p�ra este campo.
    */
  public void setNro_normativa(String PARAM) {
    nro_normativa = PARAM;
  }
  /**
    * DESCRICAO: M�todo Gets para este campo
    */
  public String getDescricao() {
    return descricao;
  }
  /**
    * DESCRICAO: M�todo Sets p�ra este campo.
    */
  public void setDescricao(String PARAM) {
    descricao = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    return0 = null;
    nro_normativa = null;
    descricao = null;
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
