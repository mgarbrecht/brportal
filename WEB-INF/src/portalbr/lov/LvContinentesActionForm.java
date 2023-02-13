package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 14/09/2018 17:15:27
 * Last Modify Date 14/09/2018 17:21:38
 */

public class LvContinentesActionForm extends org.apache.struts.action.ActionForm
{
  public String con_codigo;
  public String con_descricao;
  private boolean valida = false;
  public LvContinentesActionForm() {
  }
  /**
    * CON_CODIGO: Método Gets para este campo
    */
  public String getCon_codigo() {
    return con_codigo;
  }
  /**
    * CON_CODIGO: Método Sets pára este campo.
    */
  public void setCon_codigo(String PARAM) {
    con_codigo = PARAM;
  }
  /**
    * CON_DESCRICAO: Método Gets para este campo
    */
  public String getCon_descricao() {
    return con_descricao;
  }
  /**
    * CON_DESCRICAO: Método Sets pára este campo.
    */
  public void setCon_descricao(String PARAM) {
    con_descricao = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    con_codigo = null;
    con_descricao = null;
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
