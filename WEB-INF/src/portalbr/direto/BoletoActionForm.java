package portalbr.direto;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 08/06/2015 17:30:00
 * Last Modify Date 29/03/2016 13:25:31
 */

public class BoletoActionForm extends org.apache.struts.action.ActionForm
{
  public String chave;
  public String prt_codigo;
  private boolean valida = false;
  public BoletoActionForm() {
  }
  /**
    * CHAVE: Método Gets para este campo
    */
  public String getChave() {
    return chave;
  }
  /**
    * CHAVE: Método Sets pára este campo.
    */
  public void setChave(String PARAM) {
    chave = PARAM;
  }
  /**
    * PRT_CODIGO: Método Gets para este campo
    */
  public String getPrt_codigo() {
    return prt_codigo;
  }
  /**
    * PRT_CODIGO: Método Sets pára este campo.
    */
  public void setPrt_codigo(String PARAM) {
    prt_codigo = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    chave = null;
    prt_codigo = null;
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
