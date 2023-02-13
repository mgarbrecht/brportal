package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 21/09/2011 15:06:21
 * Last Modify Date 12/01/2016 10:43:13
 */

public class ConsultaPedidos_idActionForm extends org.apache.struts.action.ActionForm
{
  public String codigo_corrugado;
  public String codigo_embalagem;
  public String lin_cdgo;
  public String ref_cdgo;
  private boolean valida = false;
  public ConsultaPedidos_idActionForm() {
  }
  /**
    * CODIGO_CORRUGADO: Método Gets para este campo
    */
  public String getCodigo_corrugado() {
    return codigo_corrugado;
  }
  /**
    * CODIGO_CORRUGADO: Método Sets pára este campo.
    */
  public void setCodigo_corrugado(String PARAM) {
    codigo_corrugado = PARAM;
  }
  /**
    * CODIGO_EMBALAGEM: Método Gets para este campo
    */
  public String getCodigo_embalagem() {
    return codigo_embalagem;
  }
  /**
    * CODIGO_EMBALAGEM: Método Sets pára este campo.
    */
  public void setCodigo_embalagem(String PARAM) {
    codigo_embalagem = PARAM;
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
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    codigo_corrugado = null;
    codigo_embalagem = null;
    lin_cdgo = null;
    ref_cdgo = null;
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
