package portalbr.ind;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 22/08/2013 13:49:04
 * Last Modify Date 23/08/2013 11:06:24
 */

public class AbastecimentoMateriais_aActionForm extends org.apache.struts.action.ActionForm
{
  public String id;
  public String ies_codigo;
  public String cor_cdgo;
  public String tai_codigo;
  public String cod_min_fabr;
  public String fen_seq;
  public String quantidade_transito;
  public String quantidade_produzida;
  public String quantidade_atraso;
  public String data_entrega;
  public String sdo_req;
  public String data_atualizacao;
  public String fornecedor_codigo;
  private boolean valida = false;
  public AbastecimentoMateriais_aActionForm() {
  }
  /**
    * ID: Method to get the field value.
    */
  public String getId() {
    return id;
  }
  /**
    * ID: Method to set the field value.
    */
  public void setId(String PARAM) {
    id = PARAM;
  }
  /**
    * IES_CODIGO: Method to get the field value.
    */
  public String getIes_codigo() {
    return ies_codigo;
  }
  /**
    * IES_CODIGO: Method to set the field value.
    */
  public void setIes_codigo(String PARAM) {
    ies_codigo = PARAM;
  }
  /**
    * COR_CDGO: Method to get the field value.
    */
  public String getCor_cdgo() {
    return cor_cdgo;
  }
  /**
    * COR_CDGO: Method to set the field value.
    */
  public void setCor_cdgo(String PARAM) {
    cor_cdgo = PARAM;
  }
  /**
    * TAI_CODIGO: Method to get the field value.
    */
  public String getTai_codigo() {
    return tai_codigo;
  }
  /**
    * TAI_CODIGO: Method to set the field value.
    */
  public void setTai_codigo(String PARAM) {
    tai_codigo = PARAM;
  }
  /**
    * COD_MIN_FABR: Method to get the field value.
    */
  public String getCod_min_fabr() {
    return cod_min_fabr;
  }
  /**
    * COD_MIN_FABR: Method to set the field value.
    */
  public void setCod_min_fabr(String PARAM) {
    cod_min_fabr = PARAM;
  }
  /**
    * FEN_SEQ: Method to get the field value.
    */
  public String getFen_seq() {
    return fen_seq;
  }
  /**
    * FEN_SEQ: Method to set the field value.
    */
  public void setFen_seq(String PARAM) {
    fen_seq = PARAM;
  }
  /**
    * QUANTIDADE_TRANSITO: Method to get the field value.
    */
  public String getQuantidade_transito() {
    return quantidade_transito;
  }
  /**
    * QUANTIDADE_TRANSITO: Method to set the field value.
    */
  public void setQuantidade_transito(String PARAM) {
    quantidade_transito = PARAM;
  }
  /**
    * QUANTIDADE_PRODUZIDA: Method to get the field value.
    */
  public String getQuantidade_produzida() {
    return quantidade_produzida;
  }
  /**
    * QUANTIDADE_PRODUZIDA: Method to set the field value.
    */
  public void setQuantidade_produzida(String PARAM) {
    quantidade_produzida = PARAM;
  }
  /**
    * QUANTIDADE_ATRASO: Method to get the field value.
    */
  public String getQuantidade_atraso() {
    return quantidade_atraso;
  }
  /**
    * QUANTIDADE_ATRASO: Method to set the field value.
    */
  public void setQuantidade_atraso(String PARAM) {
    quantidade_atraso = PARAM;
  }
  /**
    * DATA_ENTREGA: Method to get the field value.
    */
  public String getData_entrega() {
    return data_entrega;
  }
  /**
    * DATA_ENTREGA: Method to set the field value.
    */
  public void setData_entrega(String PARAM) {
    data_entrega = PARAM;
  }
  /**
    * SDO_REQ: Method to get the field value.
    */
  public String getSdo_req() {
    return sdo_req;
  }
  /**
    * SDO_REQ: Method to set the field value.
    */
  public void setSdo_req(String PARAM) {
    sdo_req = PARAM;
  }
  /**
    * DATA_ATUALIZACAO: Method to get the field value.
    */
  public String getData_atualizacao() {
    return data_atualizacao;
  }
  /**
    * DATA_ATUALIZACAO: Method to set the field value.
    */
  public void setData_atualizacao(String PARAM) {
    data_atualizacao = PARAM;
  }
  /**
    * FORNECEDOR_CODIGO: Method to get the field value.
    */
  public String getFornecedor_codigo() {
    return fornecedor_codigo;
  }
  /**
    * FORNECEDOR_CODIGO: Method to set the field value.
    */
  public void setFornecedor_codigo(String PARAM) {
    fornecedor_codigo = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    id = null;
    ies_codigo = null;
    cor_cdgo = null;
    tai_codigo = null;
    cod_min_fabr = null;
    fen_seq = null;
    quantidade_transito = null;
    quantidade_produzida = null;
    quantidade_atraso = null;
    data_entrega = null;
    sdo_req = null;
    data_atualizacao = null;
    fornecedor_codigo = null;
  }
  /**
    * Validate fields and return errors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("insert_action,update_action,", request)) {
      if (com.egen.util.text.Validate.isNull(quantidade_atraso)) {
        errors.add("quantidade_atraso", new ActionMessage("error.validate.notnull","Qtde. Atraso","quantidade_atraso","0"));
      }
      if (com.egen.util.text.Validate.isNull(data_entrega)) {
        errors.add("data_entrega", new ActionMessage("error.validate.notnull","Dt. Entrega","data_entrega","0"));
      }
      if (!com.egen.util.text.Validate.isDate(data_atualizacao)) {
        errors.add("data_atualizacao", new ActionMessage("error.validate.date","Data_atualizacao","data_atualizacao","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
