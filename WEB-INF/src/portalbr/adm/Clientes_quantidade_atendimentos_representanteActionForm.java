package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 21/12/2005 11:33:20
 * Last Modify Date 10/12/2020 18:52:18
 */

public class Clientes_quantidade_atendimentos_representanteActionForm extends org.apache.struts.action.ActionForm
{
  public String dt_inicial;
  public String dt_final;
  public String codigo_representante;
  public String codigo_marca;
  public String lin_cdgo;
  private boolean valida = false;
  public Clientes_quantidade_atendimentos_representanteActionForm() {
  }
  /**
    * DT_INICIAL: Método Gets para este campo
    */
  public String getDt_inicial() {
    return dt_inicial;
  }
  /**
    * DT_INICIAL: Método Sets pára este campo.
    */
  public void setDt_inicial(String PARAM) {
    dt_inicial = PARAM;
  }
  /**
    * DT_FINAL: Método Gets para este campo
    */
  public String getDt_final() {
    return dt_final;
  }
  /**
    * DT_FINAL: Método Sets pára este campo.
    */
  public void setDt_final(String PARAM) {
    dt_final = PARAM;
  }
  /**
    * CODIGO_REPRESENTANTE: Método Gets para este campo
    */
  public String getCodigo_representante() {
    return codigo_representante;
  }
  /**
    * CODIGO_REPRESENTANTE: Método Sets pára este campo.
    */
  public void setCodigo_representante(String PARAM) {
    codigo_representante = PARAM;
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
    * LIN_CDGO: Método Gets para este campo
    */
  public String getLin_cdgo() {
    return lin_cdgo;
  }
  /**
    * LIN_CDGO: Método Sets pára este campo.
    */
  public void setLin_cdgo(String PARAM) {
    lin_cdgo = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    dt_inicial = null;
    dt_final = null;
    codigo_representante = null;
    codigo_marca = null;
    lin_cdgo = null;
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
