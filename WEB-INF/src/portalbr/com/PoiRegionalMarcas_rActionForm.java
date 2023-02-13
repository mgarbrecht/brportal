package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 13/03/2006 15:42:45
 * Last Modify Date 18/11/2015 11:18:44
 */

public class PoiRegionalMarcas_rActionForm extends org.apache.struts.action.ActionForm
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
  public String marca;
  public String agrupa_regionais;
  private boolean valida = false;
  public PoiRegionalMarcas_rActionForm() {
  }
  /**
    * ANO: Método Gets para este campo
    */
  public String getAno() {
    return ano;
  }
  /**
    * ANO: Método Sets pára este campo.
    */
  public void setAno(String PARAM) {
    ano = PARAM;
  }
  /**
    * MES: Método Gets para este campo
    */
  public String getMes() {
    return mes;
  }
  /**
    * MES: Método Sets pára este campo.
    */
  public void setMes(String PARAM) {
    mes = PARAM;
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
    * REP_RZAO: Método Gets para este campo
    */
  public String getRep_rzao() {
    return rep_rzao;
  }
  /**
    * REP_RZAO: Método Sets pára este campo.
    */
  public void setRep_rzao(String PARAM) {
    rep_rzao = PARAM;
  }
  /**
    * FLAG: Método Gets para este campo
    */
  public String getFlag() {
    return flag;
  }
  /**
    * FLAG: Método Sets pára este campo.
    */
  public void setFlag(String PARAM) {
    flag = PARAM;
  }
  /**
    * TIPO: Método Gets para este campo
    */
  public String getTipo() {
    return tipo;
  }
  /**
    * TIPO: Método Sets pára este campo.
    */
  public void setTipo(String PARAM) {
    tipo = PARAM;
  }
  /**
    * SITUACAO_GERENTE: Método Gets para este campo
    */
  public String getSituacao_gerente() {
    return situacao_gerente;
  }
  /**
    * SITUACAO_GERENTE: Método Sets pára este campo.
    */
  public void setSituacao_gerente(String PARAM) {
    situacao_gerente = PARAM;
  }
  /**
    * ANO_FINAL: Método Gets para este campo
    */
  public String getAno_final() {
    return ano_final;
  }
  /**
    * ANO_FINAL: Método Sets pára este campo.
    */
  public void setAno_final(String PARAM) {
    ano_final = PARAM;
  }
  /**
    * MES_FINAL: Método Gets para este campo
    */
  public String getMes_final() {
    return mes_final;
  }
  /**
    * MES_FINAL: Método Sets pára este campo.
    */
  public void setMes_final(String PARAM) {
    mes_final = PARAM;
  }
  /**
    * MARCA: Método Gets para este campo
    */
  public String getMarca() {
    return marca;
  }
  /**
    * MARCA: Método Sets pára este campo.
    */
  public void setMarca(String PARAM) {
    marca = PARAM;
  }
  /**
    * AGRUPA_REGIONAIS: Método Gets para este campo
    */
  public String getAgrupa_regionais() {
    return agrupa_regionais;
  }
  /**
    * AGRUPA_REGIONAIS: Método Sets pára este campo.
    */
  public void setAgrupa_regionais(String PARAM) {
    agrupa_regionais = PARAM;
  }
  /**
    * Limpar todos os campos.
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
    marca = null;
    agrupa_regionais = null;
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
