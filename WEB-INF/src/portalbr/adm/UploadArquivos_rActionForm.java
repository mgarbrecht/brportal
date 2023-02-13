package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 06/02/2014 13:39:56
 * Last Modify Date 07/02/2014 15:39:06
 */

public class UploadArquivos_rActionForm extends org.apache.struts.action.ActionForm
{
  public String pos;
  public String lidi_caminho;
  public String lidi_id;
  private boolean valida = false;
  public UploadArquivos_rActionForm() {
  }
  /**
    * POS: Método Gets para este campo
    */
  public String getPos() {
    return pos;
  }
  /**
    * POS: Método Sets pára este campo.
    */
  public void setPos(String PARAM) {
    pos = PARAM;
  }
  /**
    * LIDI_CAMINHO: Método Gets para este campo
    */
  public String getLidi_caminho() {
    return lidi_caminho;
  }
  /**
    * LIDI_CAMINHO: Método Sets pára este campo.
    */
  public void setLidi_caminho(String PARAM) {
    lidi_caminho = PARAM;
  }
  /**
    * LIDI_ID: Método Gets para este campo
    */
  public String getLidi_id() {
    return lidi_id;
  }
  /**
    * LIDI_ID: Método Sets pára este campo.
    */
  public void setLidi_id(String PARAM) {
    lidi_id = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    pos = null;
    lidi_caminho = null;
    lidi_id = null;
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
