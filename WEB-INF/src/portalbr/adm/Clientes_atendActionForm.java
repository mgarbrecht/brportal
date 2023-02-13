package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 04/09/2006 09:03:24
 * Last Modify Date 10/12/2020 16:44:00
 */

public class Clientes_atendActionForm extends org.apache.struts.action.ActionForm
{
  public String rep_cdgo;
  public String codigo_regional;
  public String codigo_marca;
  public String segmento;
  public String limite;
  public String atendimentos;
  private boolean valida = false;
  public Clientes_atendActionForm() {
  }
  /**
    * REP_CDGO: Method to get the field value.
    */
  public String getRep_cdgo() {
    return rep_cdgo;
  }
  /**
    * REP_CDGO: Method to set the field value.
    */
  public void setRep_cdgo(String PARAM) {
    rep_cdgo = PARAM;
  }
  /**
    * CODIGO_REGIONAL: Method to get the field value.
    */
  public String getCodigo_regional() {
    return codigo_regional;
  }
  /**
    * CODIGO_REGIONAL: Method to set the field value.
    */
  public void setCodigo_regional(String PARAM) {
    codigo_regional = PARAM;
  }
  /**
    * CODIGO_MARCA: Method to get the field value.
    */
  public String getCodigo_marca() {
    return codigo_marca;
  }
  /**
    * CODIGO_MARCA: Method to set the field value.
    */
  public void setCodigo_marca(String PARAM) {
    codigo_marca = PARAM;
  }
  /**
    * SEGMENTO: Method to get the field value.
    */
  public String getSegmento() {
    return segmento;
  }
  /**
    * SEGMENTO: Method to set the field value.
    */
  public void setSegmento(String PARAM) {
    segmento = PARAM;
  }
  /**
    * LIMITE: Method to get the field value.
    */
  public String getLimite() {
    return limite;
  }
  /**
    * LIMITE: Method to set the field value.
    */
  public void setLimite(String PARAM) {
    limite = PARAM;
  }
  /**
    * ATENDIMENTOS: Method to get the field value.
    */
  public String getAtendimentos() {
    return atendimentos;
  }
  /**
    * ATENDIMENTOS: Method to set the field value.
    */
  public void setAtendimentos(String PARAM) {
    atendimentos = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    rep_cdgo = null;
    codigo_regional = null;
    codigo_marca = null;
    segmento = null;
    limite = null;
    atendimentos = null;
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
