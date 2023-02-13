package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 14/08/2019 15:46:10
 * Last Modify Date 14/08/2019 16:24:08
 */

public class LvSituacaoSolicitacaoCombEspecGrdActionForm extends org.apache.struts.action.ActionForm
{
  public boolean gridCheckField;
  public String codigo_situacao;
  public String descricao_situacao;
  private boolean valida = false;
  public LvSituacaoSolicitacaoCombEspecGrdActionForm() {
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
    * CODIGO_SITUACAO: Method to get the field value.
    */
  public String getCodigo_situacao() {
    return codigo_situacao;
  }
  /**
    * CODIGO_SITUACAO: Method to set the field value.
    */
  public void setCodigo_situacao(String PARAM) {
    codigo_situacao = PARAM;
  }
  /**
    * DESCRICAO_SITUACAO: Method to get the field value.
    */
  public String getDescricao_situacao() {
    return descricao_situacao;
  }
  /**
    * DESCRICAO_SITUACAO: Method to set the field value.
    */
  public void setDescricao_situacao(String PARAM) {
    descricao_situacao = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    gridCheckField = false;
    codigo_situacao = null;
    descricao_situacao = null;
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
      if (com.egen.util.text.Validate.isValidate("update_action,", request)) {
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
