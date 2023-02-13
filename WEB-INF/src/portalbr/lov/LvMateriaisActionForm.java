package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 20/01/2016 07:46:47
 * Last Modify Date 20/01/2016 12:31:32
 */

public class LvMateriaisActionForm extends org.apache.struts.action.ActionForm
{
  public boolean gridCheckField;
  public String ies_codigo;
  public String ies_descricao;
  public String return0;
  public String forn_codigo;
  public String fil_filial;
  public String oco_numero;
  public String rem_nro;
  public String data_compra_inicial;
  public String data_compra_final;
  public String situacao;
  private boolean valida = false;
  public LvMateriaisActionForm() {
  }
  /**
    * GRIDCHECKFIELD: Método Gets para este campo
    */
  public boolean getGridCheckField() {
    return gridCheckField;
  }
  /**
    * GRIDCHECKFIELD: Método Sets pára este campo.
    */
  public void setGridCheckField(boolean PARAM) {
    gridCheckField = PARAM;
  }
  /**
    * IES_CODIGO: Método Gets para este campo
    */
  public String getIes_codigo() {
    return ies_codigo;
  }
  /**
    * IES_CODIGO: Método Sets pára este campo.
    */
  public void setIes_codigo(String PARAM) {
    ies_codigo = PARAM;
  }
  /**
    * IES_DESCRICAO: Método Gets para este campo
    */
  public String getIes_descricao() {
    return ies_descricao;
  }
  /**
    * IES_DESCRICAO: Método Sets pára este campo.
    */
  public void setIes_descricao(String PARAM) {
    ies_descricao = PARAM;
  }
  /**
    * RETURN0: Método Gets para este campo
    */
  public String getReturn0() {
    return return0;
  }
  /**
    * RETURN0: Método Sets pára este campo.
    */
  public void setReturn0(String PARAM) {
    return0 = PARAM;
  }
  /**
    * FORN_CODIGO: Método Gets para este campo
    */
  public String getForn_codigo() {
    return forn_codigo;
  }
  /**
    * FORN_CODIGO: Método Sets pára este campo.
    */
  public void setForn_codigo(String PARAM) {
    forn_codigo = PARAM;
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
    * OCO_NUMERO: Método Gets para este campo
    */
  public String getOco_numero() {
    return oco_numero;
  }
  /**
    * OCO_NUMERO: Método Sets pára este campo.
    */
  public void setOco_numero(String PARAM) {
    oco_numero = PARAM;
  }
  /**
    * REM_NRO: Método Gets para este campo
    */
  public String getRem_nro() {
    return rem_nro;
  }
  /**
    * REM_NRO: Método Sets pára este campo.
    */
  public void setRem_nro(String PARAM) {
    rem_nro = PARAM;
  }
  /**
    * DATA_COMPRA_INICIAL: Método Gets para este campo
    */
  public String getData_compra_inicial() {
    return data_compra_inicial;
  }
  /**
    * DATA_COMPRA_INICIAL: Método Sets pára este campo.
    */
  public void setData_compra_inicial(String PARAM) {
    data_compra_inicial = PARAM;
  }
  /**
    * DATA_COMPRA_FINAL: Método Gets para este campo
    */
  public String getData_compra_final() {
    return data_compra_final;
  }
  /**
    * DATA_COMPRA_FINAL: Método Sets pára este campo.
    */
  public void setData_compra_final(String PARAM) {
    data_compra_final = PARAM;
  }
  /**
    * SITUACAO: Método Gets para este campo
    */
  public String getSituacao() {
    return situacao;
  }
  /**
    * SITUACAO: Método Sets pára este campo.
    */
  public void setSituacao(String PARAM) {
    situacao = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    gridCheckField = false;
    ies_codigo = null;
    ies_descricao = null;
    return0 = null;
    forn_codigo = null;
    fil_filial = null;
    oco_numero = null;
    rem_nro = null;
    data_compra_inicial = null;
    data_compra_final = null;
    situacao = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (getGridCheckField()) {
      if (com.egen.util.text.Validate.isValidate("update_action,", request)) {
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
