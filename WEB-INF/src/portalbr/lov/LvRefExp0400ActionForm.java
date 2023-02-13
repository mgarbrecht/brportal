package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 10/09/2010 12:07:22
 * Last Modify Date 08/09/2011 17:10:27
 */

public class LvRefExp0400ActionForm extends org.apache.struts.action.ActionForm
{
  public String lin_cdgo;
  public String ref_cdgo;
  public String ref_descricao_exportacao;
  private boolean valida = false;
  public LvRefExp0400ActionForm() {
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
    * REF_DESCRICAO_EXPORTACAO: Method to get the field value.
    */
  public String getRef_descricao_exportacao() {
    return ref_descricao_exportacao;
  }
  /**
    * REF_DESCRICAO_EXPORTACAO: Method to set the field value.
    */
  public void setRef_descricao_exportacao(String PARAM) {
    ref_descricao_exportacao = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    lin_cdgo = null;
    ref_cdgo = null;
    ref_descricao_exportacao = null;
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
