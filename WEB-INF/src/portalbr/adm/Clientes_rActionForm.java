package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 22/03/2006 10:02:35
 * Last Modify Date 05/10/2021 15:33:46
 */

public class Clientes_rActionForm extends org.apache.struts.action.ActionForm
{
  public String ecl_cdad;
  public String representante;
  public String p1;
  public String grupo;
  private boolean valida = false;
  public Clientes_rActionForm() {
  }
  /**
    * ECL_CDAD: Método Gets para este campo
    */
  public String getEcl_cdad() {
    return ecl_cdad;
  }
  /**
    * ECL_CDAD: Método Sets pára este campo.
    */
  public void setEcl_cdad(String PARAM) {
    ecl_cdad = PARAM;
  }
  /**
    * REPRESENTANTE: Método Gets para este campo
    */
  public String getRepresentante() {
    return representante;
  }
  /**
    * REPRESENTANTE: Método Sets pára este campo.
    */
  public void setRepresentante(String PARAM) {
    representante = PARAM;
  }
  /**
    * P1: Método Gets para este campo
    */
  public String getP1() {
    return p1;
  }
  /**
    * P1: Método Sets pára este campo.
    */
  public void setP1(String PARAM) {
    p1 = PARAM;
  }
  /**
    * GRUPO: Método Gets para este campo
    */
  public String getGrupo() {
    return grupo;
  }
  /**
    * GRUPO: Método Sets pára este campo.
    */
  public void setGrupo(String PARAM) {
    grupo = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    ecl_cdad = null;
    representante = null;
    p1 = null;
    grupo = null;
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
