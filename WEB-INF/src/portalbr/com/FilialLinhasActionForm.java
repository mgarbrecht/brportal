package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 * Creation Date 08/09/2006 15:12:36
 * Last Modify Date 12/09/2006 13:32:17
 */

public class FilialLinhasActionForm extends org.apache.struts.action.ActionForm
{
  public String lin_cdgo;
  public String lin_nome;
  public String ref_cdgo;
  public String ref_desc;
  private boolean valida = false;
  public FilialLinhasActionForm() {
  }
  /**
    * LIN_CDGO: Método Gets para este campo
    */
  public String getLin_cdgo() {
    return lin_cdgo;
  }
  /**
    * LIN_CDGO: Método Sets pára este campo.
    */
  public void setLin_cdgo(String LIN_CDGO) {
    lin_cdgo = LIN_CDGO;
  }
  /**
    * LIN_NOME: Método Gets para este campo
    */
  public String getLin_nome() {
    return lin_nome;
  }
  /**
    * LIN_NOME: Método Sets pára este campo.
    */
  public void setLin_nome(String LIN_NOME) {
    lin_nome = LIN_NOME;
  }
  /**
    * REF_CDGO: Método Gets para este campo
    */
  public String getRef_cdgo() {
    return ref_cdgo;
  }
  /**
    * REF_CDGO: Método Sets pára este campo.
    */
  public void setRef_cdgo(String REF_CDGO) {
    ref_cdgo = REF_CDGO;
  }
  /**
    * REF_DESC: Método Gets para este campo
    */
  public String getRef_desc() {
    return ref_desc;
  }
  /**
    * REF_DESC: Método Sets pára este campo.
    */
  public void setRef_desc(String REF_DESC) {
    ref_desc = REF_DESC;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    lin_cdgo = null;
    lin_nome = null;
    ref_cdgo = null;
    ref_desc = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("select_action,", request)) {
      if (!com.egen.util.text.Validate.isNumber(lin_cdgo)) {
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Filial_linhas", new ActionError("error.validate.number","Linha","lin_cdgo","0"));
      }
      if (!com.egen.util.text.Validate.isNumber(ref_cdgo)) {
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Filial_linhas", new ActionError("error.validate.number","Ref.","ref_cdgo","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
