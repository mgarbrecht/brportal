package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 13/03/2006 15:42:45
 * Last Modify Date 02/02/2022 17:18:35
 */

public class PoiAbertoRepresentante_rActionForm extends org.apache.struts.action.ActionForm
{
  public String ano;
  public String mes;
  public String rep_cdgo;
  public String codigo_regional;
  public String rep_rzao;
  public String flag;
  public String tipo;
  public String situacao_gerente;
  public String ano_final;
  public String mes_final;
  public String codigo_marca;
  private boolean valida = false;
  public PoiAbertoRepresentante_rActionForm() {
  }
  /**
    * ANO: Method to get the field value.
    */
  public String getAno() {
    return ano;
  }
  /**
    * ANO: Method to set the field value.
    */
  public void setAno(String PARAM) {
    ano = PARAM;
  }
  /**
    * MES: Method to get the field value.
    */
  public String getMes() {
    return mes;
  }
  /**
    * MES: Method to set the field value.
    */
  public void setMes(String PARAM) {
    mes = PARAM;
  }
  /**
    * REP_CDGO: Method to get the field value.
    */
  public String getRep_cdgo() {
    return rep_cdgo;
  }
  /**
    * REP_CDGO: Method to set the field value.
    */
  public void setRep_cdgo(String PARAM) {
    rep_cdgo = PARAM;
  }
  /**
    * CODIGO_REGIONAL: Method to get the field value.
    */
  public String getCodigo_regional() {
    return codigo_regional;
  }
  /**
    * CODIGO_REGIONAL: Method to set the field value.
    */
  public void setCodigo_regional(String PARAM) {
    codigo_regional = PARAM;
  }
  /**
    * REP_RZAO: Method to get the field value.
    */
  public String getRep_rzao() {
    return rep_rzao;
  }
  /**
    * REP_RZAO: Method to set the field value.
    */
  public void setRep_rzao(String PARAM) {
    rep_rzao = PARAM;
  }
  /**
    * FLAG: Method to get the field value.
    */
  public String getFlag() {
    return flag;
  }
  /**
    * FLAG: Method to set the field value.
    */
  public void setFlag(String PARAM) {
    flag = PARAM;
  }
  /**
    * TIPO: Method to get the field value.
    */
  public String getTipo() {
    return tipo;
  }
  /**
    * TIPO: Method to set the field value.
    */
  public void setTipo(String PARAM) {
    tipo = PARAM;
  }
  /**
    * SITUACAO_GERENTE: Method to get the field value.
    */
  public String getSituacao_gerente() {
    return situacao_gerente;
  }
  /**
    * SITUACAO_GERENTE: Method to set the field value.
    */
  public void setSituacao_gerente(String PARAM) {
    situacao_gerente = PARAM;
  }
  /**
    * ANO_FINAL: Method to get the field value.
    */
  public String getAno_final() {
    return ano_final;
  }
  /**
    * ANO_FINAL: Method to set the field value.
    */
  public void setAno_final(String PARAM) {
    ano_final = PARAM;
  }
  /**
    * MES_FINAL: Method to get the field value.
    */
  public String getMes_final() {
    return mes_final;
  }
  /**
    * MES_FINAL: Method to set the field value.
    */
  public void setMes_final(String PARAM) {
    mes_final = PARAM;
  }
  /**
    * CODIGO_MARCA: Method to get the field value.
    */
  public String getCodigo_marca() {
    return codigo_marca;
  }
  /**
    * CODIGO_MARCA: Method to set the field value.
    */
  public void setCodigo_marca(String PARAM) {
    codigo_marca = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    ano = null;
    mes = null;
    rep_cdgo = null;
    codigo_regional = null;
    rep_rzao = null;
    flag = null;
    tipo = null;
    situacao_gerente = null;
    ano_final = null;
    mes_final = null;
    codigo_marca = null;
  }
  /**
    * Validate fields and return errors.
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
