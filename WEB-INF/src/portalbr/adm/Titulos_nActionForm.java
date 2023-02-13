package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 27/03/2006 14:19:12
 * Last Modify Date 25/06/2009 12:25:33
 */

public class Titulos_nActionForm extends org.apache.struts.action.ActionForm
{
  public String dt_calculo;
  public String juros;
  public String titulo;
  private boolean valida = false;
  public Titulos_nActionForm() {
  }
  /**
    * DT_CALCULO: Método Gets para este campo
    */
  public String getDt_calculo() {
    return dt_calculo;
  }
  /**
    * DT_CALCULO: Método Sets pára este campo.
    */
  public void setDt_calculo(String PARAM) {
    dt_calculo = PARAM;
  }
  /**
    * JUROS: Método Gets para este campo
    */
  public String getJuros() {
    return juros;
  }
  /**
    * JUROS: Método Sets pára este campo.
    */
  public void setJuros(String PARAM) {
    juros = PARAM;
  }
  /**
    * TITULO: Método Gets para este campo
    */
  public String getTitulo() {
    return titulo;
  }
  /**
    * TITULO: Método Sets pára este campo.
    */
  public void setTitulo(String PARAM) {
    titulo = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    dt_calculo = null;
    juros = null;
    titulo = null;
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
