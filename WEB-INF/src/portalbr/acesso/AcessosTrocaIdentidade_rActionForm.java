package portalbr.acesso;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 12/12/2017 12:43:18
 * Last Modify Date 14/12/2017 11:43:07
 */

public class AcessosTrocaIdentidade_rActionForm extends org.apache.struts.action.ActionForm
{
  public boolean gridCheckField;
  public String atid_usua_id;
  public String usua_usuario;
  public String usua_nome;
  public String atid_tien_id;
  public String tien_tipo;
  private boolean valida = false;
  public AcessosTrocaIdentidade_rActionForm() {
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
    * ATID_USUA_ID: Método Gets para este campo
    */
  public String getAtid_usua_id() {
    return atid_usua_id;
  }
  /**
    * ATID_USUA_ID: Método Sets pára este campo.
    */
  public void setAtid_usua_id(String PARAM) {
    atid_usua_id = PARAM;
  }
  /**
    * USUA_USUARIO: Método Gets para este campo
    */
  public String getUsua_usuario() {
    return usua_usuario;
  }
  /**
    * USUA_USUARIO: Método Sets pára este campo.
    */
  public void setUsua_usuario(String PARAM) {
    usua_usuario = PARAM;
  }
  /**
    * USUA_NOME: Método Gets para este campo
    */
  public String getUsua_nome() {
    return usua_nome;
  }
  /**
    * USUA_NOME: Método Sets pára este campo.
    */
  public void setUsua_nome(String PARAM) {
    usua_nome = PARAM;
  }
  /**
    * ATID_TIEN_ID: Método Gets para este campo
    */
  public String getAtid_tien_id() {
    return atid_tien_id;
  }
  /**
    * ATID_TIEN_ID: Método Sets pára este campo.
    */
  public void setAtid_tien_id(String PARAM) {
    atid_tien_id = PARAM;
  }
  /**
    * TIEN_TIPO: Método Gets para este campo
    */
  public String getTien_tipo() {
    return tien_tipo;
  }
  /**
    * TIEN_TIPO: Método Sets pára este campo.
    */
  public void setTien_tipo(String PARAM) {
    tien_tipo = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    gridCheckField = false;
    atid_usua_id = null;
    usua_usuario = null;
    usua_nome = null;
    atid_tien_id = null;
    tien_tipo = null;
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
      if (com.egen.util.text.Validate.isValidate("delete_action,", request)) {
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
