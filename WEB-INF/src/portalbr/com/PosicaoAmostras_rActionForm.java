package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 05/01/2011 05:22:37
 * Last Modify Date 02/04/2013 15:43:23
 */

public class PosicaoAmostras_rActionForm extends org.apache.struts.action.ActionForm
{
  public String ped_nmro;
  public String estagio;
  public String indice;
  private boolean valida = false;
  public PosicaoAmostras_rActionForm() {
  }
  /**
    * PED_NMRO: Método Gets para este campo
    */
  public String getPed_nmro() {
    return ped_nmro;
  }
  /**
    * PED_NMRO: Método Sets pára este campo.
    */
  public void setPed_nmro(String PARAM) {
    ped_nmro = PARAM;
  }
  /**
    * ESTAGIO: Método Gets para este campo
    */
  public String getEstagio() {
    return estagio;
  }
  /**
    * ESTAGIO: Método Sets pára este campo.
    */
  public void setEstagio(String PARAM) {
    estagio = PARAM;
  }
  /**
    * INDICE: Método Gets para este campo
    */
  public String getIndice() {
    return indice;
  }
  /**
    * INDICE: Método Sets pára este campo.
    */
  public void setIndice(String PARAM) {
    indice = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    ped_nmro = null;
    estagio = null;
    indice = null;
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
