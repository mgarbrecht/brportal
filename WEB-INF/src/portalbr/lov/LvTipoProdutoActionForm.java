package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 13/11/2009 09:02:48
 * Last Modify Date 12/05/2010 14:45:32
 */

public class LvTipoProdutoActionForm extends org.apache.struts.action.ActionForm
{
  public String codigo_grupo;
  public String descricao_grupo;
  private boolean valida = false;
  public LvTipoProdutoActionForm() {
  }
  /**
    * CODIGO_GRUPO: Método Gets para este campo
    */
  public String getCodigo_grupo() {
    return codigo_grupo;
  }
  /**
    * CODIGO_GRUPO: Método Sets pára este campo.
    */
  public void setCodigo_grupo(String PARAM) {
    codigo_grupo = PARAM;
  }
  /**
    * DESCRICAO_GRUPO: Método Gets para este campo
    */
  public String getDescricao_grupo() {
    return descricao_grupo;
  }
  /**
    * DESCRICAO_GRUPO: Método Sets pára este campo.
    */
  public void setDescricao_grupo(String PARAM) {
    descricao_grupo = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    codigo_grupo = null;
    descricao_grupo = null;
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
