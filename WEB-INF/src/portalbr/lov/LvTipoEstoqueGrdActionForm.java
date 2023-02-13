package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 03/12/2009 17:33:43
 * Last Modify Date 17/01/2022 14:16:41
 */

public class LvTipoEstoqueGrdActionForm extends org.apache.struts.action.ActionForm
{
  public boolean gridCheckField;
  public String codigo;
  public String descricao;
  public String return0;
  public String opener;
  private boolean valida = false;
  public LvTipoEstoqueGrdActionForm() {
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
    * RETURN0: Method to get the field value.
    */
  public String getReturn0() {
    return return0;
  }
  /**
    * RETURN0: Method to set the field value.
    */
  public void setReturn0(String PARAM) {
    return0 = PARAM;
  }
  /**
    * OPENER: Method to get the field value.
    */
  public String getOpener() {
    return opener;
  }
  /**
    * OPENER: Method to set the field value.
    */
  public void setOpener(String PARAM) {
    opener = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    gridCheckField = false;
    codigo = null;
    descricao = null;
    return0 = null;
    opener = null;
  }
  /**
    * Validate fields and return errors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (getGridCheckField()) {
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
