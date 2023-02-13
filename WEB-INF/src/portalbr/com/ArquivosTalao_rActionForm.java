package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 02/09/2015 11:16:00
 * Last Modify Date 19/07/2022 10:09:23
 */

public class ArquivosTalao_rActionForm extends org.apache.struts.action.ActionForm
{
  public boolean gridCheckField;
  public String forn_codigo;
  public String interface_arq_compra_id;
  public String oco_numero;
  public String fil_filial;
  public String arquivo_edi;
  public String descricao_situacao;
  public String forn_razsoc;
  public String rem_nro;
  public String data_compra;
  public String lin_cdgo;
  public String lin_nome;
  private boolean valida = false;
  public ArquivosTalao_rActionForm() {
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
    * INTERFACE_ARQ_COMPRA_ID: Método Gets para este campo
    */
  public String getInterface_arq_compra_id() {
    return interface_arq_compra_id;
  }
  /**
    * INTERFACE_ARQ_COMPRA_ID: Método Sets pára este campo.
    */
  public void setInterface_arq_compra_id(String PARAM) {
    interface_arq_compra_id = PARAM;
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
    * ARQUIVO_EDI: Método Gets para este campo
    */
  public String getArquivo_edi() {
    return arquivo_edi;
  }
  /**
    * ARQUIVO_EDI: Método Sets pára este campo.
    */
  public void setArquivo_edi(String PARAM) {
    arquivo_edi = PARAM;
  }
  /**
    * DESCRICAO_SITUACAO: Método Gets para este campo
    */
  public String getDescricao_situacao() {
    return descricao_situacao;
  }
  /**
    * DESCRICAO_SITUACAO: Método Sets pára este campo.
    */
  public void setDescricao_situacao(String PARAM) {
    descricao_situacao = PARAM;
  }
  /**
    * FORN_RAZSOC: Método Gets para este campo
    */
  public String getForn_razsoc() {
    return forn_razsoc;
  }
  /**
    * FORN_RAZSOC: Método Sets pára este campo.
    */
  public void setForn_razsoc(String PARAM) {
    forn_razsoc = PARAM;
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
    * DATA_COMPRA: Método Gets para este campo
    */
  public String getData_compra() {
    return data_compra;
  }
  /**
    * DATA_COMPRA: Método Sets pára este campo.
    */
  public void setData_compra(String PARAM) {
    data_compra = PARAM;
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
    * LIN_NOME: Método Gets para este campo
    */
  public String getLin_nome() {
    return lin_nome;
  }
  /**
    * LIN_NOME: Método Sets pára este campo.
    */
  public void setLin_nome(String PARAM) {
    lin_nome = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    gridCheckField = false;
    forn_codigo = null;
    interface_arq_compra_id = null;
    oco_numero = null;
    fil_filial = null;
    arquivo_edi = null;
    descricao_situacao = null;
    forn_razsoc = null;
    rem_nro = null;
    data_compra = null;
    lin_cdgo = null;
    lin_nome = null;
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
      if (com.egen.util.text.Validate.isValidate("update_action,update1_action,", request)) {
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
