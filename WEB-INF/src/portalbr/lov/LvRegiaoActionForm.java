package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 10/08/2017 11:53:06
 * Last Modify Date 17/04/2020 11:10:40
 */

public class LvRegiaoActionForm extends org.apache.struts.action.ActionForm
{
  public String reg_cdgo;
  public String return0;
  public String reg_nome;
  private boolean valida = false;
  public LvRegiaoActionForm() {
  }
  /**
    * REG_CDGO: Método Gets para este campo
    */
  public String getReg_cdgo() {
    return reg_cdgo;
  }
  /**
    * REG_CDGO: Método Sets pára este campo.
    */
  public void setReg_cdgo(String PARAM) {
    reg_cdgo = PARAM;
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
    * REG_NOME: Método Gets para este campo
    */
  public String getReg_nome() {
    return reg_nome;
  }
  /**
    * REG_NOME: Método Sets pára este campo.
    */
  public void setReg_nome(String PARAM) {
    reg_nome = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    reg_cdgo = null;
    return0 = null;
    reg_nome = null;
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
