package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 17/03/2006 14:57:56
 * Last Modify Date 01/08/2019 16:00:11
 */

public class ConsultaNotaFiscal_rActionForm extends org.apache.struts.action.ActionForm
{
  public String par;
  public String grupo_economico;
  public String conhecimento;
  public String arquivo;
  private boolean valida = false;
  public ConsultaNotaFiscal_rActionForm() {
  }
  /**
    * PAR: Método Gets para este campo
    */
  public String getPar() {
    return par;
  }
  /**
    * PAR: Método Sets pára este campo.
    */
  public void setPar(String PARAM) {
    par = PARAM;
  }
  /**
    * GRUPO_ECONOMICO: Método Gets para este campo
    */
  public String getGrupo_economico() {
    return grupo_economico;
  }
  /**
    * GRUPO_ECONOMICO: Método Sets pára este campo.
    */
  public void setGrupo_economico(String PARAM) {
    grupo_economico = PARAM;
  }
  /**
    * CONHECIMENTO: Método Gets para este campo
    */
  public String getConhecimento() {
    return conhecimento;
  }
  /**
    * CONHECIMENTO: Método Sets pára este campo.
    */
  public void setConhecimento(String PARAM) {
    conhecimento = PARAM;
  }
  /**
    * ARQUIVO: Método Gets para este campo
    */
  public String getArquivo() {
    return arquivo;
  }
  /**
    * ARQUIVO: Método Sets pára este campo.
    */
  public void setArquivo(String PARAM) {
    arquivo = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    par = null;
    grupo_economico = null;
    conhecimento = null;
    arquivo = null;
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
