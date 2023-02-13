package portalbr.direto;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 08/06/2015 17:30:00
 * Last Modify Date 05/12/2019 15:00:39
 */

public class RelatoriosActionForm extends org.apache.struts.action.ActionForm
{
  public String codigo_relatorio;
  public String p1;
  private boolean valida = false;
  public RelatoriosActionForm() {
  }
  /**
    * CODIGO_RELATORIO: Método Gets para este campo
    */
  public String getCodigo_relatorio() {
    return codigo_relatorio;
  }
  /**
    * CODIGO_RELATORIO: Método Sets pára este campo.
    */
  public void setCodigo_relatorio(String PARAM) {
    codigo_relatorio = PARAM;
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
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    codigo_relatorio = null;
    p1 = null;
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
