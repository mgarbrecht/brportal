package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 30/01/2006 11:28:43
 * Last Modify Date 16/11/2009 11:16:13
 */

public class Cidades_ativasActionForm extends org.apache.struts.action.ActionForm
{
  public String codigo_regional;
  public String cidade;
  public String rep_cdgo;
  public String chamador;
  public String codigo_marca;
  private boolean valida = false;
  public Cidades_ativasActionForm() {
  }
  /**
    * CODIGO_REGIONAL: Método Gets para este campo
    */
  public String getCodigo_regional() {
    return codigo_regional;
  }
  /**
    * CODIGO_REGIONAL: Método Sets pára este campo.
    */
  public void setCodigo_regional(String PARAM) {
    codigo_regional = PARAM;
  }
  /**
    * CIDADE: Método Gets para este campo
    */
  public String getCidade() {
    return cidade;
  }
  /**
    * CIDADE: Método Sets pára este campo.
    */
  public void setCidade(String PARAM) {
    cidade = PARAM;
  }
  /**
    * REP_CDGO: Método Gets para este campo
    */
  public String getRep_cdgo() {
    return rep_cdgo;
  }
  /**
    * REP_CDGO: Método Sets pára este campo.
    */
  public void setRep_cdgo(String PARAM) {
    rep_cdgo = PARAM;
  }
  /**
    * CHAMADOR: Método Gets para este campo
    */
  public String getChamador() {
    return chamador;
  }
  /**
    * CHAMADOR: Método Sets pára este campo.
    */
  public void setChamador(String PARAM) {
    chamador = PARAM;
  }
  /**
    * CODIGO_MARCA: Método Gets para este campo
    */
  public String getCodigo_marca() {
    return codigo_marca;
  }
  /**
    * CODIGO_MARCA: Método Sets pára este campo.
    */
  public void setCodigo_marca(String PARAM) {
    codigo_marca = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    codigo_regional = null;
    cidade = null;
    rep_cdgo = null;
    chamador = null;
    codigo_marca = null;
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
