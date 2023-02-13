package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 07/06/2006 13:40:06
 * Last Modify Date 22/06/2015 15:28:34
 */

public class GruposAtivosActionForm extends org.apache.struts.action.ActionForm
{
  public String cod_marca;
  public String cod_regional;
  public String cod_rep;
  public String grupo;
  private boolean valida = false;
  public GruposAtivosActionForm() {
  }
  /**
    * COD_MARCA: M�todo Gets para este campo
    */
  public String getCod_marca() {
    return cod_marca;
  }
  /**
    * COD_MARCA: M�todo Sets p�ra este campo.
    */
  public void setCod_marca(String PARAM) {
    cod_marca = PARAM;
  }
  /**
    * COD_REGIONAL: M�todo Gets para este campo
    */
  public String getCod_regional() {
    return cod_regional;
  }
  /**
    * COD_REGIONAL: M�todo Sets p�ra este campo.
    */
  public void setCod_regional(String PARAM) {
    cod_regional = PARAM;
  }
  /**
    * COD_REP: M�todo Gets para este campo
    */
  public String getCod_rep() {
    return cod_rep;
  }
  /**
    * COD_REP: M�todo Sets p�ra este campo.
    */
  public void setCod_rep(String PARAM) {
    cod_rep = PARAM;
  }
  /**
    * GRUPO: M�todo Gets para este campo
    */
  public String getGrupo() {
    return grupo;
  }
  /**
    * GRUPO: M�todo Sets p�ra este campo.
    */
  public void setGrupo(String PARAM) {
    grupo = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    cod_marca = null;
    cod_regional = null;
    cod_rep = null;
    grupo = null;
  }
  /**
    * Valida��o dos campos, retornando um ActionErrors.
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
