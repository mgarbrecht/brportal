package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 20/06/2006 14:19:15
 * Last Modify Date 27/08/2009 16:50:07
 */

public class ArquivosRepresentantes_rActionForm extends org.apache.struts.action.ActionForm
{
  public String pos;
  public String lidi_id;
  public String lidi_caminho;
  public String arquivo;
  private boolean valida = false;
  public ArquivosRepresentantes_rActionForm() {
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
    * ARQUIVO: Método Gets para este campo
    */
  public String getArquivo() {
    return arquivo;
  }
  /**
    * ARQUIVO: Método Sets pára este campo.
    */
  public void setArquivo(String PARAM) {
    arquivo = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    pos = null;
    lidi_id = null;
    lidi_caminho = null;
    arquivo = null;
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
