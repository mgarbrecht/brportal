package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 11/01/2016 15:08:16
 * Last Modify Date 22/01/2016 16:45:28
 */

public class ConsultaPedidos_idistuActionForm extends org.apache.struts.action.ActionForm
{
  public String ped_nmro;
  public String loja;
  public String distribuicao;
  private boolean valida = false;
  public ConsultaPedidos_idistuActionForm() {
  }
  /**
    * PED_NMRO: Método Gets para este campo
    */
  public String getPed_nmro() {
    return ped_nmro;
  }
  /**
    * PED_NMRO: Método Sets pára este campo.
    */
  public void setPed_nmro(String PARAM) {
    ped_nmro = PARAM;
  }
  /**
    * LOJA: Método Gets para este campo
    */
  public String getLoja() {
    return loja;
  }
  /**
    * LOJA: Método Sets pára este campo.
    */
  public void setLoja(String PARAM) {
    loja = PARAM;
  }
  /**
    * DISTRIBUICAO: Método Gets para este campo
    */
  public String getDistribuicao() {
    return distribuicao;
  }
  /**
    * DISTRIBUICAO: Método Sets pára este campo.
    */
  public void setDistribuicao(String PARAM) {
    distribuicao = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    ped_nmro = null;
    loja = null;
    distribuicao = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("update_action,", request)) {
      if (com.egen.util.text.Validate.isNull(loja)) {
        errors.add("loja", new ActionMessage("error.validate.notnull","Loja","loja","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
