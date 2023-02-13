package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 28/05/2014 13:59:07
 * Last Modify Date 28/05/2014 15:22:34
 */

public class LvSetorMRActionForm extends org.apache.struts.action.ActionForm
{
  public boolean gridCheckField;
  public String set_cdgo;
  public String set_nome;
  public String return0;
  private boolean valida = false;
  public LvSetorMRActionForm() {
  }
  /**
    * GRIDCHECKFIELD: Método Gets para este campo
    */
  public boolean getGridCheckField() {
    return gridCheckField;
  }
  /**
    * GRIDCHECKFIELD: Método Sets pára este campo.
    */
  public void setGridCheckField(boolean PARAM) {
    gridCheckField = PARAM;
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
    * RETURN0: Método Gets para este campo
    */
  public String getReturn0() {
    return return0;
  }
  /**
    * RETURN0: Método Sets pára este campo.
    */
  public void setReturn0(String PARAM) {
    return0 = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    gridCheckField = false;
    set_cdgo = null;
    set_nome = null;
    return0 = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (getGridCheckField()) {
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
