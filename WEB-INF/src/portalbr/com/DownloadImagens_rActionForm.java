package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 18/08/2015 08:15:41
 * Last Modify Date 23/09/2020 09:49:30
 */

public class DownloadImagens_rActionForm extends org.apache.struts.action.ActionForm
{
  public boolean gridCheckField;
  public String marca;
  public String linha;
  public String referencia;
  public String cabedal;
  public String cor;
  public String imagem;
  public String venda_exportacao;
  public String categoria_produto;
  public String descricao_categoria_produto;
  public String tipo;
  public String descricao_tipo;
  public String descricao_produto;
  public String descricao_cabedal;
  public String descricao_cor;
  public String sequencial_angulo;
  private boolean valida = false;
  public DownloadImagens_rActionForm() {
  }
  /**
    * GRIDCHECKFIELD: Method to get the field value.
    */
  public boolean getGridCheckField() {
    return gridCheckField;
  }
  /**
    * GRIDCHECKFIELD: Method to set the field value.
    */
  public void setGridCheckField(boolean PARAM) {
    gridCheckField = PARAM;
  }
  /**
    * MARCA: Method to get the field value.
    */
  public String getMarca() {
    return marca;
  }
  /**
    * MARCA: Method to set the field value.
    */
  public void setMarca(String PARAM) {
    marca = PARAM;
  }
  /**
    * LINHA: Method to get the field value.
    */
  public String getLinha() {
    return linha;
  }
  /**
    * LINHA: Method to set the field value.
    */
  public void setLinha(String PARAM) {
    linha = PARAM;
  }
  /**
    * REFERENCIA: Method to get the field value.
    */
  public String getReferencia() {
    return referencia;
  }
  /**
    * REFERENCIA: Method to set the field value.
    */
  public void setReferencia(String PARAM) {
    referencia = PARAM;
  }
  /**
    * CABEDAL: Method to get the field value.
    */
  public String getCabedal() {
    return cabedal;
  }
  /**
    * CABEDAL: Method to set the field value.
    */
  public void setCabedal(String PARAM) {
    cabedal = PARAM;
  }
  /**
    * COR: Method to get the field value.
    */
  public String getCor() {
    return cor;
  }
  /**
    * COR: Method to set the field value.
    */
  public void setCor(String PARAM) {
    cor = PARAM;
  }
  /**
    * IMAGEM: Method to get the field value.
    */
  public String getImagem() {
    return imagem;
  }
  /**
    * IMAGEM: Method to set the field value.
    */
  public void setImagem(String PARAM) {
    imagem = PARAM;
  }
  /**
    * VENDA_EXPORTACAO: Method to get the field value.
    */
  public String getVenda_exportacao() {
    return venda_exportacao;
  }
  /**
    * VENDA_EXPORTACAO: Method to set the field value.
    */
  public void setVenda_exportacao(String PARAM) {
    venda_exportacao = PARAM;
  }
  /**
    * CATEGORIA_PRODUTO: Method to get the field value.
    */
  public String getCategoria_produto() {
    return categoria_produto;
  }
  /**
    * CATEGORIA_PRODUTO: Method to set the field value.
    */
  public void setCategoria_produto(String PARAM) {
    categoria_produto = PARAM;
  }
  /**
    * DESCRICAO_CATEGORIA_PRODUTO: Method to get the field value.
    */
  public String getDescricao_categoria_produto() {
    return descricao_categoria_produto;
  }
  /**
    * DESCRICAO_CATEGORIA_PRODUTO: Method to set the field value.
    */
  public void setDescricao_categoria_produto(String PARAM) {
    descricao_categoria_produto = PARAM;
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
    * DESCRICAO_TIPO: Method to get the field value.
    */
  public String getDescricao_tipo() {
    return descricao_tipo;
  }
  /**
    * DESCRICAO_TIPO: Method to set the field value.
    */
  public void setDescricao_tipo(String PARAM) {
    descricao_tipo = PARAM;
  }
  /**
    * DESCRICAO_PRODUTO: Method to get the field value.
    */
  public String getDescricao_produto() {
    return descricao_produto;
  }
  /**
    * DESCRICAO_PRODUTO: Method to set the field value.
    */
  public void setDescricao_produto(String PARAM) {
    descricao_produto = PARAM;
  }
  /**
    * DESCRICAO_CABEDAL: Method to get the field value.
    */
  public String getDescricao_cabedal() {
    return descricao_cabedal;
  }
  /**
    * DESCRICAO_CABEDAL: Method to set the field value.
    */
  public void setDescricao_cabedal(String PARAM) {
    descricao_cabedal = PARAM;
  }
  /**
    * DESCRICAO_COR: Method to get the field value.
    */
  public String getDescricao_cor() {
    return descricao_cor;
  }
  /**
    * DESCRICAO_COR: Method to set the field value.
    */
  public void setDescricao_cor(String PARAM) {
    descricao_cor = PARAM;
  }
  /**
    * SEQUENCIAL_ANGULO: Method to get the field value.
    */
  public String getSequencial_angulo() {
    return sequencial_angulo;
  }
  /**
    * SEQUENCIAL_ANGULO: Method to set the field value.
    */
  public void setSequencial_angulo(String PARAM) {
    sequencial_angulo = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    gridCheckField = false;
    marca = null;
    linha = null;
    referencia = null;
    cabedal = null;
    cor = null;
    imagem = null;
    venda_exportacao = null;
    categoria_produto = null;
    descricao_categoria_produto = null;
    tipo = null;
    descricao_tipo = null;
    descricao_produto = null;
    descricao_cabedal = null;
    descricao_cor = null;
    sequencial_angulo = null;
  }
  /**
    * Validate fields and return errors.
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
