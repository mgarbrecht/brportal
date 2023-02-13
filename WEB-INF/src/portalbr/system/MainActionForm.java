package portalbr.system;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 23/11/2004 09:12:38
 * Last Modify Date 20/12/2016 15:11:17
 */

public class MainActionForm extends org.apache.struts.action.ActionForm
{
  public String teste1;
  public String language;
  private boolean valida = false;
  public MainActionForm() {
  }
  /**
    * TESTE1: Método Gets para este campo
    */
  public String getTeste1() {
    return teste1;
  }
  /**
    * TESTE1: Método Sets pára este campo.
    */
  public void setTeste1(String PARAM) {
    teste1 = PARAM;
  }
  /**
    * LANGUAGE: Método Gets para este campo
    */
  public String getLanguage() {
    return language;
  }
  /**
    * LANGUAGE: Método Sets pára este campo.
    */
  public void setLanguage(String PARAM) {
    language = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    teste1 = null;
    language = null;
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
      request.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
