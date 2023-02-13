package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 17/01/2022 13:50:47
 * Last Modify Date 17/01/2022 15:43:30
 */

public class LvTipoProdutoGrdActionForm extends org.apache.struts.action.ActionForm
{
  public boolean gridCheckField;
  public String descricao_grupo;
  public String codigo_grupo;
  private boolean valida = false;
  public LvTipoProdutoGrdActionForm() {
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
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    gridCheckField = false;
    descricao_grupo = null;
    codigo_grupo = null;
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
      if (com.egen.util.text.Validate.isValidate("update_action,", request)) {
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
