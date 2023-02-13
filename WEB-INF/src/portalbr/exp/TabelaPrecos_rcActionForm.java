package portalbr.exp;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 02/04/2012 15:34:44
 * Last Modify Date 23/08/2012 14:42:54
 */

public class TabelaPrecos_rcActionForm extends org.apache.struts.action.ActionForm
{
  public String lin_cdgo;
  public String ref_cdgo;
  public boolean gridCheckField;
  public String codigo_marca1;
  public String descricao_marca1;
  public String lin_cdgo1;
  public String ref_cdgo1;
  public String modelo;
  public String pos;
  private boolean valida = false;
  public TabelaPrecos_rcActionForm() {
  }
  /**
    * LIN_CDGO: Method to get the field value.
    */
  public String getLin_cdgo() {
    return lin_cdgo;
  }
  /**
    * LIN_CDGO: Method to set the field value.
    */
  public void setLin_cdgo(String PARAM) {
    lin_cdgo = PARAM;
  }
  /**
    * REF_CDGO: Method to get the field value.
    */
  public String getRef_cdgo() {
    return ref_cdgo;
  }
  /**
    * REF_CDGO: Method to set the field value.
    */
  public void setRef_cdgo(String PARAM) {
    ref_cdgo = PARAM;
  }
  /**
    * GRIDCHECKFIELD: Method to get the field value.
    */
  public boolean getGridCheckField() {
    return gridCheckField;
  }
  /**
    * GRIDCHECKFIELD: Method to set the field value.
    */
  public void setGridCheckField(boolean PARAM) {
    gridCheckField = PARAM;
  }
  /**
    * CODIGO_MARCA1: Method to get the field value.
    */
  public String getCodigo_marca1() {
    return codigo_marca1;
  }
  /**
    * CODIGO_MARCA1: Method to set the field value.
    */
  public void setCodigo_marca1(String PARAM) {
    codigo_marca1 = PARAM;
  }
  /**
    * DESCRICAO_MARCA1: Method to get the field value.
    */
  public String getDescricao_marca1() {
    return descricao_marca1;
  }
  /**
    * DESCRICAO_MARCA1: Method to set the field value.
    */
  public void setDescricao_marca1(String PARAM) {
    descricao_marca1 = PARAM;
  }
  /**
    * LIN_CDGO1: Method to get the field value.
    */
  public String getLin_cdgo1() {
    return lin_cdgo1;
  }
  /**
    * LIN_CDGO1: Method to set the field value.
    */
  public void setLin_cdgo1(String PARAM) {
    lin_cdgo1 = PARAM;
  }
  /**
    * REF_CDGO1: Method to get the field value.
    */
  public String getRef_cdgo1() {
    return ref_cdgo1;
  }
  /**
    * REF_CDGO1: Method to set the field value.
    */
  public void setRef_cdgo1(String PARAM) {
    ref_cdgo1 = PARAM;
  }
  /**
    * MODELO: Method to get the field value.
    */
  public String getModelo() {
    return modelo;
  }
  /**
    * MODELO: Method to set the field value.
    */
  public void setModelo(String PARAM) {
    modelo = PARAM;
  }
  /**
    * POS: Method to get the field value.
    */
  public String getPos() {
    return pos;
  }
  /**
    * POS: Method to set the field value.
    */
  public void setPos(String PARAM) {
    pos = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    lin_cdgo = null;
    ref_cdgo = null;
    gridCheckField = false;
    codigo_marca1 = null;
    descricao_marca1 = null;
    lin_cdgo1 = null;
    ref_cdgo1 = null;
    modelo = null;
    pos = null;
  }
  /**
    * Validate fields and return errors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("select1_action,", request)) {
    }
    if (getGridCheckField()) {
      if (com.egen.util.text.Validate.isValidate("select_action,", request)) {
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
