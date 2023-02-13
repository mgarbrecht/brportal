package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 06/02/2012 12:01:23
 * Last Modify Date 05/11/2020 12:19:32
 */

public class SolicitacaoCombinacaoEspecial_gActionForm extends org.apache.struts.action.ActionForm
{
  public String pares;
  public String numeracao;
  public String lin_cdgo;
  public String lin_cdgo1;
  private boolean valida = false;
  public SolicitacaoCombinacaoEspecial_gActionForm() {
  }
  /**
    * PARES: Método Gets para este campo
    */
  public String getPares() {
    return pares;
  }
  /**
    * PARES: Método Sets pára este campo.
    */
  public void setPares(String PARAM) {
    pares = PARAM;
  }
  /**
    * NUMERACAO: Método Gets para este campo
    */
  public String getNumeracao() {
    return numeracao;
  }
  /**
    * NUMERACAO: Método Sets pára este campo.
    */
  public void setNumeracao(String PARAM) {
    numeracao = PARAM;
  }
  /**
    * LIN_CDGO: Método Gets para este campo
    */
  public String getLin_cdgo() {
    return lin_cdgo;
  }
  /**
    * LIN_CDGO: Método Sets pára este campo.
    */
  public void setLin_cdgo(String PARAM) {
    lin_cdgo = PARAM;
  }
  /**
    * LIN_CDGO1: Método Gets para este campo
    */
  public String getLin_cdgo1() {
    return lin_cdgo1;
  }
  /**
    * LIN_CDGO1: Método Sets pára este campo.
    */
  public void setLin_cdgo1(String PARAM) {
    lin_cdgo1 = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    pares = null;
    numeracao = null;
    lin_cdgo = null;
    lin_cdgo1 = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("insert_action,", request)) {
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
