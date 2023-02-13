package portalbr.ind;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 15/01/2015 11:54:29
 * Last Modify Date 10/02/2015 14:10:34
 */

public class AtelieresQuarterizados_frActionForm extends org.apache.struts.action.ActionForm
{
  public String fornecedor_codigo_quarterizado;
  public String fen_seq_quarterizado;
  public String pro_numero;
  public String rem_nro;
  public String tal_nro;
  private boolean valida = false;
  public AtelieresQuarterizados_frActionForm() {
  }
  /**
    * FORNECEDOR_CODIGO_QUARTERIZADO: Método Gets para este campo
    */
  public String getFornecedor_codigo_quarterizado() {
    return fornecedor_codigo_quarterizado;
  }
  /**
    * FORNECEDOR_CODIGO_QUARTERIZADO: Método Sets pára este campo.
    */
  public void setFornecedor_codigo_quarterizado(String PARAM) {
    fornecedor_codigo_quarterizado = PARAM;
  }
  /**
    * FEN_SEQ_QUARTERIZADO: Método Gets para este campo
    */
  public String getFen_seq_quarterizado() {
    return fen_seq_quarterizado;
  }
  /**
    * FEN_SEQ_QUARTERIZADO: Método Sets pára este campo.
    */
  public void setFen_seq_quarterizado(String PARAM) {
    fen_seq_quarterizado = PARAM;
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
    * REM_NRO: Método Gets para este campo
    */
  public String getRem_nro() {
    return rem_nro;
  }
  /**
    * REM_NRO: Método Sets pára este campo.
    */
  public void setRem_nro(String PARAM) {
    rem_nro = PARAM;
  }
  /**
    * TAL_NRO: Método Gets para este campo
    */
  public String getTal_nro() {
    return tal_nro;
  }
  /**
    * TAL_NRO: Método Sets pára este campo.
    */
  public void setTal_nro(String PARAM) {
    tal_nro = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    fornecedor_codigo_quarterizado = null;
    fen_seq_quarterizado = null;
    pro_numero = null;
    rem_nro = null;
    tal_nro = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("delete_action,", request)) {
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
