package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 19/03/2015 10:57:35
 * Last Modify Date 19/03/2015 11:52:40
 */

public class LvGrupoMaterialGrdActionForm extends org.apache.struts.action.ActionForm
{
  public boolean gridCheckField;
  public String gpo_mater_cdgo;
  public String gpo_mater_desc;
  public String return0;
  private boolean valida = false;
  public LvGrupoMaterialGrdActionForm() {
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
    * GPO_MATER_CDGO: Método Gets para este campo
    */
  public String getGpo_mater_cdgo() {
    return gpo_mater_cdgo;
  }
  /**
    * GPO_MATER_CDGO: Método Sets pára este campo.
    */
  public void setGpo_mater_cdgo(String PARAM) {
    gpo_mater_cdgo = PARAM;
  }
  /**
    * GPO_MATER_DESC: Método Gets para este campo
    */
  public String getGpo_mater_desc() {
    return gpo_mater_desc;
  }
  /**
    * GPO_MATER_DESC: Método Sets pára este campo.
    */
  public void setGpo_mater_desc(String PARAM) {
    gpo_mater_desc = PARAM;
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
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    gridCheckField = false;
    gpo_mater_cdgo = null;
    gpo_mater_desc = null;
    return0 = null;
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
