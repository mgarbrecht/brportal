package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 24/11/2009 08:40:36
 * Last Modify Date 30/11/2009 10:36:55
 */

public class TipoEstoqueActionForm extends org.apache.struts.action.ActionForm
{
  public String codigo;
  public String descricao;
  public String clientes;
  public boolean gridCheckField;
  private boolean valida = false;
  public TipoEstoqueActionForm() {
  }
  /**
    * CODIGO: Method to get the field value.
    */
  public String getCodigo() {
    return codigo;
  }
  /**
    * CODIGO: Method to set the field value.
    */
  public void setCodigo(String PARAM) {
    codigo = PARAM;
  }
  /**
    * DESCRICAO: Method to get the field value.
    */
  public String getDescricao() {
    return descricao;
  }
  /**
    * DESCRICAO: Method to set the field value.
    */
  public void setDescricao(String PARAM) {
    descricao = PARAM;
  }
  /**
    * CLIENTES: Method to get the field value.
    */
  public String getClientes() {
    return clientes;
  }
  /**
    * CLIENTES: Method to set the field value.
    */
  public void setClientes(String PARAM) {
    clientes = PARAM;
  }
  /**
    * GRIDCHECKFIELD: Method to get the field value.
    */
  public boolean getGridCheckField() {
    return gridCheckField;
  }
  /**
    * GRIDCHECKFIELD: Method to set the field value.
    */
  public void setGridCheckField(boolean PARAM) {
    gridCheckField = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    codigo = null;
    descricao = null;
    clientes = null;
    gridCheckField = false;
  }
  /**
    * Validate fields and return errors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (!com.egen.util.struts.Token.isTokenValid(mapping, request)) {
      errors.add("Warning", new ActionMessage("token.error","<br>","","",""));
    }
    com.egen.util.struts.Token.saveToken(mapping, request);

    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
