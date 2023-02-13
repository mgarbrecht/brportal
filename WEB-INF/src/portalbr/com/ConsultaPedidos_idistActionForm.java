package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 08/01/2016 12:02:01
 * Last Modify Date 25/11/2016 11:07:07
 */

public class ConsultaPedidos_idistActionForm extends org.apache.struts.action.ActionForm
{
  public String ped_nmro;
  public String item;
  public String quantidade_pares;
  public String grade;
  public String codigo_corrugado;
  public String qt_par_corrug;
  public String total_caixas;
  public String descricao_corrugado;
  public String qtde_caixas_distribuidas;
  public String index;
  public String loja;
  public String caixas;
  private boolean valida = false;
  public ConsultaPedidos_idistActionForm() {
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
    * ITEM: Método Gets para este campo
    */
  public String getItem() {
    return item;
  }
  /**
    * ITEM: Método Sets pára este campo.
    */
  public void setItem(String PARAM) {
    item = PARAM;
  }
  /**
    * QUANTIDADE_PARES: Método Gets para este campo
    */
  public String getQuantidade_pares() {
    return quantidade_pares;
  }
  /**
    * QUANTIDADE_PARES: Método Sets pára este campo.
    */
  public void setQuantidade_pares(String PARAM) {
    quantidade_pares = PARAM;
  }
  /**
    * GRADE: Método Gets para este campo
    */
  public String getGrade() {
    return grade;
  }
  /**
    * GRADE: Método Sets pára este campo.
    */
  public void setGrade(String PARAM) {
    grade = PARAM;
  }
  /**
    * CODIGO_CORRUGADO: Método Gets para este campo
    */
  public String getCodigo_corrugado() {
    return codigo_corrugado;
  }
  /**
    * CODIGO_CORRUGADO: Método Sets pára este campo.
    */
  public void setCodigo_corrugado(String PARAM) {
    codigo_corrugado = PARAM;
  }
  /**
    * QT_PAR_CORRUG: Método Gets para este campo
    */
  public String getQt_par_corrug() {
    return qt_par_corrug;
  }
  /**
    * QT_PAR_CORRUG: Método Sets pára este campo.
    */
  public void setQt_par_corrug(String PARAM) {
    qt_par_corrug = PARAM;
  }
  /**
    * TOTAL_CAIXAS: Método Gets para este campo
    */
  public String getTotal_caixas() {
    return total_caixas;
  }
  /**
    * TOTAL_CAIXAS: Método Sets pára este campo.
    */
  public void setTotal_caixas(String PARAM) {
    total_caixas = PARAM;
  }
  /**
    * DESCRICAO_CORRUGADO: Método Gets para este campo
    */
  public String getDescricao_corrugado() {
    return descricao_corrugado;
  }
  /**
    * DESCRICAO_CORRUGADO: Método Sets pára este campo.
    */
  public void setDescricao_corrugado(String PARAM) {
    descricao_corrugado = PARAM;
  }
  /**
    * QTDE_CAIXAS_DISTRIBUIDAS: Método Gets para este campo
    */
  public String getQtde_caixas_distribuidas() {
    return qtde_caixas_distribuidas;
  }
  /**
    * QTDE_CAIXAS_DISTRIBUIDAS: Método Sets pára este campo.
    */
  public void setQtde_caixas_distribuidas(String PARAM) {
    qtde_caixas_distribuidas = PARAM;
  }
  /**
    * INDEX: Método Gets para este campo
    */
  public String getIndex() {
    return index;
  }
  /**
    * INDEX: Método Sets pára este campo.
    */
  public void setIndex(String PARAM) {
    index = PARAM;
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
    * CAIXAS: Método Gets para este campo
    */
  public String getCaixas() {
    return caixas;
  }
  /**
    * CAIXAS: Método Sets pára este campo.
    */
  public void setCaixas(String PARAM) {
    caixas = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    ped_nmro = null;
    item = null;
    quantidade_pares = null;
    grade = null;
    codigo_corrugado = null;
    qt_par_corrug = null;
    total_caixas = null;
    descricao_corrugado = null;
    qtde_caixas_distribuidas = null;
    index = null;
    loja = null;
    caixas = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("adicionar_item_action,", request)) {
      if (com.egen.util.text.Validate.isNull(loja)) {
        errors.add("loja", new ActionMessage("error.validate.notnull","Loja","loja","0"));
      }
      if (com.egen.util.text.Validate.isNull(caixas)) {
        errors.add("caixas", new ActionMessage("error.validate.notnull","Caixas","caixas","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
