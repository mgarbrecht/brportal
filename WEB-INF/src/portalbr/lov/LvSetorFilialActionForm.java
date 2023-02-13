package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 23/05/2014 10:37:40
 * Last Modify Date 23/05/2014 10:44:12
 */

public class LvSetorFilialActionForm extends org.apache.struts.action.ActionForm
{
  public String fil_filial;
  public String set_cdgo;
  public String set_nome;
  private boolean valida = false;
  public LvSetorFilialActionForm() {
  }
  /**
    * FIL_FILIAL: Método Gets para este campo
    */
  public String getFil_filial() {
    return fil_filial;
  }
  /**
    * FIL_FILIAL: Método Sets pára este campo.
    */
  public void setFil_filial(String PARAM) {
    fil_filial = PARAM;
  }
  /**
    * SET_CDGO: Método Gets para este campo
    */
  public String getSet_cdgo() {
    return set_cdgo;
  }
  /**
    * SET_CDGO: Método Sets pára este campo.
    */
  public void setSet_cdgo(String PARAM) {
    set_cdgo = PARAM;
  }
  /**
    * SET_NOME: Método Gets para este campo
    */
  public String getSet_nome() {
    return set_nome;
  }
  /**
    * SET_NOME: Método Sets pára este campo.
    */
  public void setSet_nome(String PARAM) {
    set_nome = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    fil_filial = null;
    set_cdgo = null;
    set_nome = null;
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
