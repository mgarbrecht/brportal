package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 20/11/2007 05:49:58
 * Last Modify Date 02/12/2009 10:17:05
 */

public class LvLinhaRefActionForm extends org.apache.struts.action.ActionForm
{
  public String lin_cdgo;
  public String return0;
  public String lin_nome;
  public String codigo_marca;
  private boolean valida = false;
  public LvLinhaRefActionForm() {
  }
  /**
    * LIN_CDGO: M�todo Gets para este campo
    */
  public String getLin_cdgo() {
    return lin_cdgo;
  }
  /**
    * LIN_CDGO: M�todo Sets p�ra este campo.
    */
  public void setLin_cdgo(String PARAM) {
    lin_cdgo = PARAM;
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
    * LIN_NOME: M�todo Gets para este campo
    */
  public String getLin_nome() {
    return lin_nome;
  }
  /**
    * LIN_NOME: M�todo Sets p�ra este campo.
    */
  public void setLin_nome(String PARAM) {
    lin_nome = PARAM;
  }
  /**
    * CODIGO_MARCA: M�todo Gets para este campo
    */
  public String getCodigo_marca() {
    return codigo_marca;
  }
  /**
    * CODIGO_MARCA: M�todo Sets p�ra este campo.
    */
  public void setCodigo_marca(String PARAM) {
    codigo_marca = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    lin_cdgo = null;
    return0 = null;
    lin_nome = null;
    codigo_marca = null;
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
