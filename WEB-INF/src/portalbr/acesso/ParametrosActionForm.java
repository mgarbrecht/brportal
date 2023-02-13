package portalbr.acesso;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 01/04/2008 07:30:01
 * Last Modify Date 01/08/2014 12:33:00
 */

public class ParametrosActionForm extends org.apache.struts.action.ActionForm
{
  public boolean gridCheckField;
  public String nome1;
  public String valor1;
  public String par_sist_codigo;
  public String pos1;
  private boolean valida = false;
  public ParametrosActionForm() {
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
    * NOME1: Method to get the field value.
    */
  public String getNome1() {
    return nome1;
  }
  /**
    * NOME1: Method to set the field value.
    */
  public void setNome1(String PARAM) {
    nome1 = PARAM;
  }
  /**
    * VALOR1: Method to get the field value.
    */
  public String getValor1() {
    return valor1;
  }
  /**
    * VALOR1: Method to set the field value.
    */
  public void setValor1(String PARAM) {
    valor1 = PARAM;
  }
  /**
    * PAR_SIST_CODIGO: Method to get the field value.
    */
  public String getPar_sist_codigo() {
    return par_sist_codigo;
  }
  /**
    * PAR_SIST_CODIGO: Method to set the field value.
    */
  public void setPar_sist_codigo(String PARAM) {
    par_sist_codigo = PARAM;
  }
  /**
    * POS1: Method to get the field value.
    */
  public String getPos1() {
    return pos1;
  }
  /**
    * POS1: Method to set the field value.
    */
  public void setPos1(String PARAM) {
    pos1 = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    gridCheckField = false;
    nome1 = null;
    valor1 = null;
    par_sist_codigo = null;
    pos1 = null;
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
      if (com.egen.util.text.Validate.isValidate("insert1_action,update1_action,", request)) {
        if (com.egen.util.text.Validate.isNull(nome1)) {
          errors.add("nome1", new ActionMessage("error.validate.notnull","Nome","nome1","0"));
        }
        if (com.egen.util.text.Validate.isNull(valor1)) {
          errors.add("valor1", new ActionMessage("error.validate.notnull","Valor","valor1","0"));
        }
        if (com.egen.util.text.Validate.isNull(par_sist_codigo)) {
          errors.add("par_sist_codigo", new ActionMessage("error.validate.notnull","Par_sist_codigo","par_sist_codigo","0"));
        }
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
