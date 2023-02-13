package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 27/03/2006 15:53:57
 * Last Modify Date 16/09/2009 15:58:51
 */

public class Titulos_ndActionForm extends org.apache.struts.action.ActionForm
{
  public String emp_empresa;
  public String fil_filial;
  public String tip_codigo;
  public String tit_datvenc;
  public String tit_valor;
  public String w_dias;
  public String titulo;
  public String dt_calculo;
  public String juros;
  public String w_protesto;
  public String total;
  private boolean valida = false;
  public Titulos_ndActionForm() {
  }
  /**
    * EMP_EMPRESA: Método Gets para este campo
    */
  public String getEmp_empresa() {
    return emp_empresa;
  }
  /**
    * EMP_EMPRESA: Método Sets pára este campo.
    */
  public void setEmp_empresa(String PARAM) {
    emp_empresa = PARAM;
  }
  /**
    * FIL_FILIAL: Método Gets para este campo
    */
  public String getFil_filial() {
    return fil_filial;
  }
  /**
    * FIL_FILIAL: Método Sets pára este campo.
    */
  public void setFil_filial(String PARAM) {
    fil_filial = PARAM;
  }
  /**
    * TIP_CODIGO: Método Gets para este campo
    */
  public String getTip_codigo() {
    return tip_codigo;
  }
  /**
    * TIP_CODIGO: Método Sets pára este campo.
    */
  public void setTip_codigo(String PARAM) {
    tip_codigo = PARAM;
  }
  /**
    * TIT_DATVENC: Método Gets para este campo
    */
  public String getTit_datvenc() {
    return tit_datvenc;
  }
  /**
    * TIT_DATVENC: Método Sets pára este campo.
    */
  public void setTit_datvenc(String PARAM) {
    tit_datvenc = PARAM;
  }
  /**
    * TIT_VALOR: Método Gets para este campo
    */
  public String getTit_valor() {
    return tit_valor;
  }
  /**
    * TIT_VALOR: Método Sets pára este campo.
    */
  public void setTit_valor(String PARAM) {
    tit_valor = PARAM;
  }
  /**
    * W_DIAS: Método Gets para este campo
    */
  public String getW_dias() {
    return w_dias;
  }
  /**
    * W_DIAS: Método Sets pára este campo.
    */
  public void setW_dias(String PARAM) {
    w_dias = PARAM;
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
    * W_PROTESTO: Método Gets para este campo
    */
  public String getW_protesto() {
    return w_protesto;
  }
  /**
    * W_PROTESTO: Método Sets pára este campo.
    */
  public void setW_protesto(String PARAM) {
    w_protesto = PARAM;
  }
  /**
    * TOTAL: Método Gets para este campo
    */
  public String getTotal() {
    return total;
  }
  /**
    * TOTAL: Método Sets pára este campo.
    */
  public void setTotal(String PARAM) {
    total = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    emp_empresa = null;
    fil_filial = null;
    tip_codigo = null;
    tit_datvenc = null;
    tit_valor = null;
    w_dias = null;
    titulo = null;
    dt_calculo = null;
    juros = null;
    w_protesto = null;
    total = null;
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
