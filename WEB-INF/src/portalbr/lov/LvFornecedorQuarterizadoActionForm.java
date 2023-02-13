package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 14/01/2015 12:29:10
 * Last Modify Date 09/02/2015 10:39:45
 */

public class LvFornecedorQuarterizadoActionForm extends org.apache.struts.action.ActionForm
{
  public String return0;
  public String fo_codigo;
  public String fo_codigo_quarterizado;
  public String fen_seq_quarterizado;
  public String fo_razsoc;
  public String fen_cgc_quarterizado;
  private boolean valida = false;
  public LvFornecedorQuarterizadoActionForm() {
  }
  /**
    * RETURN0: Method to get the field value.
    */
  public String getReturn0() {
    return return0;
  }
  /**
    * RETURN0: Method to set the field value.
    */
  public void setReturn0(String PARAM) {
    return0 = PARAM;
  }
  /**
    * FO_CODIGO: Method to get the field value.
    */
  public String getFo_codigo() {
    return fo_codigo;
  }
  /**
    * FO_CODIGO: Method to set the field value.
    */
  public void setFo_codigo(String PARAM) {
    fo_codigo = PARAM;
  }
  /**
    * FO_CODIGO_QUARTERIZADO: Method to get the field value.
    */
  public String getFo_codigo_quarterizado() {
    return fo_codigo_quarterizado;
  }
  /**
    * FO_CODIGO_QUARTERIZADO: Method to set the field value.
    */
  public void setFo_codigo_quarterizado(String PARAM) {
    fo_codigo_quarterizado = PARAM;
  }
  /**
    * FEN_SEQ_QUARTERIZADO: Method to get the field value.
    */
  public String getFen_seq_quarterizado() {
    return fen_seq_quarterizado;
  }
  /**
    * FEN_SEQ_QUARTERIZADO: Method to set the field value.
    */
  public void setFen_seq_quarterizado(String PARAM) {
    fen_seq_quarterizado = PARAM;
  }
  /**
    * FO_RAZSOC: Method to get the field value.
    */
  public String getFo_razsoc() {
    return fo_razsoc;
  }
  /**
    * FO_RAZSOC: Method to set the field value.
    */
  public void setFo_razsoc(String PARAM) {
    fo_razsoc = PARAM;
  }
  /**
    * FEN_CGC_QUARTERIZADO: Method to get the field value.
    */
  public String getFen_cgc_quarterizado() {
    return fen_cgc_quarterizado;
  }
  /**
    * FEN_CGC_QUARTERIZADO: Method to set the field value.
    */
  public void setFen_cgc_quarterizado(String PARAM) {
    fen_cgc_quarterizado = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    return0 = null;
    fo_codigo = null;
    fo_codigo_quarterizado = null;
    fen_seq_quarterizado = null;
    fo_razsoc = null;
    fen_cgc_quarterizado = null;
  }
  /**
    * Validate fields and return errors.
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
