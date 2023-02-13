package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 04/06/2019 08:21:46
 * Last Modify Date 04/06/2019 09:34:19
 */

public class LvTipoPedidoGrdActionForm extends org.apache.struts.action.ActionForm
{
  public boolean gridCheckField;
  public String return0;
  public String tipo_pedido;
  public String descricao_tipo_pedido;
  private boolean valida = false;
  public LvTipoPedidoGrdActionForm() {
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
    * TIPO_PEDIDO: Método Gets para este campo
    */
  public String getTipo_pedido() {
    return tipo_pedido;
  }
  /**
    * TIPO_PEDIDO: Método Sets pára este campo.
    */
  public void setTipo_pedido(String PARAM) {
    tipo_pedido = PARAM;
  }
  /**
    * DESCRICAO_TIPO_PEDIDO: Método Gets para este campo
    */
  public String getDescricao_tipo_pedido() {
    return descricao_tipo_pedido;
  }
  /**
    * DESCRICAO_TIPO_PEDIDO: Método Sets pára este campo.
    */
  public void setDescricao_tipo_pedido(String PARAM) {
    descricao_tipo_pedido = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    gridCheckField = false;
    return0 = null;
    tipo_pedido = null;
    descricao_tipo_pedido = null;
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
