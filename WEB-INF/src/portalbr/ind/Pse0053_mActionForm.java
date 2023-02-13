package portalbr.ind;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 02/09/2009 15:15:13
 * Last Modify Date 15/09/2009 11:01:25
 */

public class Pse0053_mActionForm extends org.apache.struts.action.ActionForm
{
  public boolean gridCheckField;
  public String rem_nro;
  public String tal_nro;
  public String lin_cdgo;
  public String ref_cdgo;
  public String cab_cdgo;
  public String cor_cdgo;
  public String for_codigo;
  public String pro_numero;
  public String tal_pares;
  public String data_pre_envio;
  public String fen_seq;
  public String fil_filial;
  private boolean valida = false;
  public Pse0053_mActionForm() {
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
    * TAL_NRO: Método Gets para este campo
    */
  public String getTal_nro() {
    return tal_nro;
  }
  /**
    * TAL_NRO: Método Sets pára este campo.
    */
  public void setTal_nro(String PARAM) {
    tal_nro = PARAM;
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
    * REF_CDGO: Método Gets para este campo
    */
  public String getRef_cdgo() {
    return ref_cdgo;
  }
  /**
    * REF_CDGO: Método Sets pára este campo.
    */
  public void setRef_cdgo(String PARAM) {
    ref_cdgo = PARAM;
  }



  public String getCab_cdgo() {
    return cab_cdgo;
  }
  public void setCab_cdgo(String PARAM) {
    cab_cdgo = PARAM;
  }
  public String getCor_cdgo() {
    return cor_cdgo;
  }
  public void setCor_cdgo(String PARAM) {
    cor_cdgo = PARAM;
  }



  /**
    * FOR_CODIGO: Método Gets para este campo
    */
  public String getFor_codigo() {
    return for_codigo;
  }
  /**
    * FOR_CODIGO: Método Sets pára este campo.
    */
  public void setFor_codigo(String PARAM) {
    for_codigo = PARAM;
  }
  /**
    * PRO_NUMERO: Método Gets para este campo
    */
  public String getPro_numero() {
    return pro_numero;
  }
  /**
    * PRO_NUMERO: Método Sets pára este campo.
    */
  public void setPro_numero(String PARAM) {
    pro_numero = PARAM;
  }
  /**
    * TAL_PARES: Método Gets para este campo
    */
  public String getTal_pares() {
    return tal_pares;
  }
  /**
    * TAL_PARES: Método Sets pára este campo.
    */
  public void setTal_pares(String PARAM) {
    tal_pares = PARAM;
  }
  /**
    * DATA_PRE_ENVIO: Método Gets para este campo
    */
  public String getData_pre_envio() {
    return data_pre_envio;
  }
  /**
    * DATA_PRE_ENVIO: Método Sets pára este campo.
    */
  public void setData_pre_envio(String PARAM) {
    data_pre_envio = PARAM;
  }
  /**
    * FEN_SEQ: Método Gets para este campo
    */
  public String getFen_seq() {
    return fen_seq;
  }
  /**
    * FEN_SEQ: Método Sets pára este campo.
    */
  public void setFen_seq(String PARAM) {
    fen_seq = PARAM;
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
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    gridCheckField = false;
    rem_nro = null;
    tal_nro = null;
    lin_cdgo = null;
    ref_cdgo = null;
    cab_cdgo = null;
    cor_cdgo = null;
    for_codigo = null;
    pro_numero = null;
    tal_pares = null;
    data_pre_envio = null;
    fen_seq = null;
    fil_filial = null;
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
      if (com.egen.util.text.Validate.isValidate("delete_action,", request)) {
        if (!com.egen.util.text.Validate.isDate(data_pre_envio)) {
          errors.add("data_pre_envio", new ActionMessage("error.validate.date","Data Pre Envio","data_pre_envio","0"));
        }
        if (com.egen.util.text.Validate.isNull(fen_seq)) {
          errors.add("fen_seq", new ActionMessage("error.validate.notnull","Fen_seq","fen_seq","0"));
        }
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
