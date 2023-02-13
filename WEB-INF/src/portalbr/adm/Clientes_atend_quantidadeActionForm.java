package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 04/09/2006 09:03:24
 * Last Modify Date 10/12/2020 19:00:53
 */

public class Clientes_atend_quantidadeActionForm extends org.apache.struts.action.ActionForm
{
  public String rep_cdgo;
  public String codigo_regional;
  public String codigo_marca;
  public String segmento;
  public String limite;
  public String atendimentos;
  private boolean valida = false;
  public Clientes_atend_quantidadeActionForm() {
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
    * SEGMENTO: Método Gets para este campo
    */
  public String getSegmento() {
    return segmento;
  }
  /**
    * SEGMENTO: Método Sets pára este campo.
    */
  public void setSegmento(String PARAM) {
    segmento = PARAM;
  }
  /**
    * LIMITE: Método Gets para este campo
    */
  public String getLimite() {
    return limite;
  }
  /**
    * LIMITE: Método Sets pára este campo.
    */
  public void setLimite(String PARAM) {
    limite = PARAM;
  }
  /**
    * ATENDIMENTOS: Método Gets para este campo
    */
  public String getAtendimentos() {
    return atendimentos;
  }
  /**
    * ATENDIMENTOS: Método Sets pára este campo.
    */
  public void setAtendimentos(String PARAM) {
    atendimentos = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    rep_cdgo = null;
    codigo_regional = null;
    codigo_marca = null;
    segmento = null;
    limite = null;
    atendimentos = null;
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
