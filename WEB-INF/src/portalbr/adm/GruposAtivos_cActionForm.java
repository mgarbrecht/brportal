package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 07/06/2006 08:55:31
 * Last Modify Date 23/05/2013 10:23:06
 */

public class GruposAtivos_cActionForm extends org.apache.struts.action.ActionForm
{
  public String gre_grupo;
  public String grupo;
  private boolean valida = false;
  public GruposAtivos_cActionForm() {
  }
  /**
    * GRE_GRUPO: Método Gets para este campo
    */
  public String getGre_grupo() {
    return gre_grupo;
  }
  /**
    * GRE_GRUPO: Método Sets pára este campo.
    */
  public void setGre_grupo(String PARAM) {
    gre_grupo = PARAM;
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
    gre_grupo = null;
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
