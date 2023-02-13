package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 17/04/2006 12:00:30
 * Last Modify Date 22/06/2015 16:58:30
 */

public class PlusProdutosDadosActionForm extends org.apache.struts.action.ActionForm
{
  public String referencia;
  public String lin_cdgo;
  public String ref_cdgo;
  public String descricao;
  public String status;
  public String dt_inicial;
  public String dt_final;
  private boolean valida = false;
  public PlusProdutosDadosActionForm() {
  }
  /**
    * REFERENCIA: Método Gets para este campo
    */
  public String getReferencia() {
    return referencia;
  }
  /**
    * REFERENCIA: Método Sets pára este campo.
    */
  public void setReferencia(String PARAM) {
    referencia = PARAM;
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
    * REF_CDGO: Método Gets para este campo
    */
  public String getRef_cdgo() {
    return ref_cdgo;
  }
  /**
    * REF_CDGO: Método Sets pára este campo.
    */
  public void setRef_cdgo(String PARAM) {
    ref_cdgo = PARAM;
  }
  /**
    * DESCRICAO: Método Gets para este campo
    */
  public String getDescricao() {
    return descricao;
  }
  /**
    * DESCRICAO: Método Sets pára este campo.
    */
  public void setDescricao(String PARAM) {
    descricao = PARAM;
  }
  /**
    * STATUS: Método Gets para este campo
    */
  public String getStatus() {
    return status;
  }
  /**
    * STATUS: Método Sets pára este campo.
    */
  public void setStatus(String PARAM) {
    status = PARAM;
  }
  /**
    * DT_INICIAL: Método Gets para este campo
    */
  public String getDt_inicial() {
    return dt_inicial;
  }
  /**
    * DT_INICIAL: Método Sets pára este campo.
    */
  public void setDt_inicial(String PARAM) {
    dt_inicial = PARAM;
  }
  /**
    * DT_FINAL: Método Gets para este campo
    */
  public String getDt_final() {
    return dt_final;
  }
  /**
    * DT_FINAL: Método Sets pára este campo.
    */
  public void setDt_final(String PARAM) {
    dt_final = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    referencia = null;
    lin_cdgo = null;
    ref_cdgo = null;
    descricao = null;
    status = null;
    dt_inicial = null;
    dt_final = null;
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
