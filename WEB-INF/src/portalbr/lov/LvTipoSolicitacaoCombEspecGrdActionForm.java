package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 14/08/2019 15:46:10
 * Last Modify Date 14/08/2019 17:01:45
 */

public class LvTipoSolicitacaoCombEspecGrdActionForm extends org.apache.struts.action.ActionForm
{
  public boolean gridCheckField;
  public String codigo_tipo;
  public String descricao_tipo;
  private boolean valida = false;
  public LvTipoSolicitacaoCombEspecGrdActionForm() {
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
    * CODIGO_TIPO: Método Gets para este campo
    */
  public String getCodigo_tipo() {
    return codigo_tipo;
  }
  /**
    * CODIGO_TIPO: Método Sets pára este campo.
    */
  public void setCodigo_tipo(String PARAM) {
    codigo_tipo = PARAM;
  }
  /**
    * DESCRICAO_TIPO: Método Gets para este campo
    */
  public String getDescricao_tipo() {
    return descricao_tipo;
  }
  /**
    * DESCRICAO_TIPO: Método Sets pára este campo.
    */
  public void setDescricao_tipo(String PARAM) {
    descricao_tipo = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    gridCheckField = false;
    codigo_tipo = null;
    descricao_tipo = null;
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
