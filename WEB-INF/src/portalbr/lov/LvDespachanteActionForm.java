package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 22/08/2017 11:15:15
 * Last Modify Date 22/08/2017 11:29:36
 */

public class LvDespachanteActionForm extends org.apache.struts.action.ActionForm
{
  public String codigo_pessoa;
  public String nome_pessoa;
  private boolean valida = false;
  public LvDespachanteActionForm() {
  }
  /**
    * CODIGO_PESSOA: Método Gets para este campo
    */
  public String getCodigo_pessoa() {
    return codigo_pessoa;
  }
  /**
    * CODIGO_PESSOA: Método Sets pára este campo.
    */
  public void setCodigo_pessoa(String PARAM) {
    codigo_pessoa = PARAM;
  }
  /**
    * NOME_PESSOA: Método Gets para este campo
    */
  public String getNome_pessoa() {
    return nome_pessoa;
  }
  /**
    * NOME_PESSOA: Método Sets pára este campo.
    */
  public void setNome_pessoa(String PARAM) {
    nome_pessoa = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    codigo_pessoa = null;
    nome_pessoa = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
