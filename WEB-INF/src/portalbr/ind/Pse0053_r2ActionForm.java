package portalbr.ind;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 23/07/2013 14:19:14
 * Last Modify Date 19/10/2021 17:54:21
 */

public class Pse0053_r2ActionForm extends org.apache.struts.action.ActionForm
{
  public String tipo;
  public String filial;
  public String dt_inicial;
  public String dt_final;
  private boolean valida = false;
  public Pse0053_r2ActionForm() {
  }
  /**
    * TIPO: M�todo Gets para este campo
    */
  public String getTipo() {
    return tipo;
  }
  /**
    * TIPO: M�todo Sets p�ra este campo.
    */
  public void setTipo(String PARAM) {
    tipo = PARAM;
  }
  /**
    * FILIAL: M�todo Gets para este campo
    */
  public String getFilial() {
    return filial;
  }
  /**
    * FILIAL: M�todo Sets p�ra este campo.
    */
  public void setFilial(String PARAM) {
    filial = PARAM;
  }
  /**
    * DT_INICIAL: M�todo Gets para este campo
    */
  public String getDt_inicial() {
    return dt_inicial;
  }
  /**
    * DT_INICIAL: M�todo Sets p�ra este campo.
    */
  public void setDt_inicial(String PARAM) {
    dt_inicial = PARAM;
  }
  /**
    * DT_FINAL: M�todo Gets para este campo
    */
  public String getDt_final() {
    return dt_final;
  }
  /**
    * DT_FINAL: M�todo Sets p�ra este campo.
    */
  public void setDt_final(String PARAM) {
    dt_final = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    tipo = null;
    filial = null;
    dt_inicial = null;
    dt_final = null;
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
