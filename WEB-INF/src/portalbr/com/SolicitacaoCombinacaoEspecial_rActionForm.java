package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 03/02/2012 15:14:29
 * Last Modify Date 08/10/2020 15:52:22
 */

public class SolicitacaoCombinacaoEspecial_rActionForm extends org.apache.struts.action.ActionForm
{
  public boolean gridCheckField;
  public String id_solicitacao;
  public String data_solicitacao;
  public String nome_marca;
  public String regional;
  public String material;
  public String lin_cdgo;
  public String ref_cdgo;
  public String cab_cdgo;
  public String cor_cdgo;
  public String cliente_grupo_economico;
  public String pares_alteracao;
  public String pares_vendidos;
  public String situacao_solicitacao;
  public String situacao_solicitacao_desc;
  public String data_aprovacao;
  public String preco_liguido;
  public String ll_alteracao_solicitada;
  public String tipo_solicitacao_comb_especial;
  public String desc_solicitacao_comb_especial;
  public String subtipo_solicitacao_comb_espec;
  public String desc_subtipo_comb_espec;
  public String data_manipulacao;
  public String imagem;
  public String situacao_solicitacao1;
  private boolean valida = false;
  public SolicitacaoCombinacaoEspecial_rActionForm() {
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
    * ID_SOLICITACAO: Método Gets para este campo
    */
  public String getId_solicitacao() {
    return id_solicitacao;
  }
  /**
    * ID_SOLICITACAO: Método Sets pára este campo.
    */
  public void setId_solicitacao(String PARAM) {
    id_solicitacao = PARAM;
  }
  /**
    * DATA_SOLICITACAO: Método Gets para este campo
    */
  public String getData_solicitacao() {
    return data_solicitacao;
  }
  /**
    * DATA_SOLICITACAO: Método Sets pára este campo.
    */
  public void setData_solicitacao(String PARAM) {
    data_solicitacao = PARAM;
  }
  /**
    * NOME_MARCA: Método Gets para este campo
    */
  public String getNome_marca() {
    return nome_marca;
  }
  /**
    * NOME_MARCA: Método Sets pára este campo.
    */
  public void setNome_marca(String PARAM) {
    nome_marca = PARAM;
  }
  /**
    * REGIONAL: Método Gets para este campo
    */
  public String getRegional() {
    return regional;
  }
  /**
    * REGIONAL: Método Sets pára este campo.
    */
  public void setRegional(String PARAM) {
    regional = PARAM;
  }
  /**
    * MATERIAL: Método Gets para este campo
    */
  public String getMaterial() {
    return material;
  }
  /**
    * MATERIAL: Método Sets pára este campo.
    */
  public void setMaterial(String PARAM) {
    material = PARAM;
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
  /**
    * CAB_CDGO: Método Gets para este campo
    */
  public String getCab_cdgo() {
    return cab_cdgo;
  }
  /**
    * CAB_CDGO: Método Sets pára este campo.
    */
  public void setCab_cdgo(String PARAM) {
    cab_cdgo = PARAM;
  }
  /**
    * COR_CDGO: Método Gets para este campo
    */
  public String getCor_cdgo() {
    return cor_cdgo;
  }
  /**
    * COR_CDGO: Método Sets pára este campo.
    */
  public void setCor_cdgo(String PARAM) {
    cor_cdgo = PARAM;
  }
  /**
    * CLIENTE_GRUPO_ECONOMICO: Método Gets para este campo
    */
  public String getCliente_grupo_economico() {
    return cliente_grupo_economico.replace('\'', ' ');
  }
  /**
    * CLIENTE_GRUPO_ECONOMICO: Método Sets pára este campo.
    */
  public void setCliente_grupo_economico(String PARAM) {
    cliente_grupo_economico = PARAM;
  }
  /**
    * PARES_ALTERACAO: Método Gets para este campo
    */
  public String getPares_alteracao() {
    return pares_alteracao;
  }
  /**
    * PARES_ALTERACAO: Método Sets pára este campo.
    */
  public void setPares_alteracao(String PARAM) {
    pares_alteracao = PARAM;
  }
  /**
    * PARES_VENDIDOS: Método Gets para este campo
    */
  public String getPares_vendidos() {
    return pares_vendidos;
  }
  /**
    * PARES_VENDIDOS: Método Sets pára este campo.
    */
  public void setPares_vendidos(String PARAM) {
    pares_vendidos = PARAM;
  }
  /**
    * SITUACAO_SOLICITACAO: Método Gets para este campo
    */
  public String getSituacao_solicitacao() {
    return situacao_solicitacao;
  }
  /**
    * SITUACAO_SOLICITACAO: Método Sets pára este campo.
    */
  public void setSituacao_solicitacao(String PARAM) {
    situacao_solicitacao = PARAM;
  }
  /**
    * SITUACAO_SOLICITACAO_DESC: Método Gets para este campo
    */
  public String getSituacao_solicitacao_desc() {
    return situacao_solicitacao_desc;
  }
  /**
    * SITUACAO_SOLICITACAO_DESC: Método Sets pára este campo.
    */
  public void setSituacao_solicitacao_desc(String PARAM) {
    situacao_solicitacao_desc = PARAM;
  }
  /**
    * DATA_APROVACAO: Método Gets para este campo
    */
  public String getData_aprovacao() {
    return data_aprovacao;
  }
  /**
    * DATA_APROVACAO: Método Sets pára este campo.
    */
  public void setData_aprovacao(String PARAM) {
    data_aprovacao = PARAM;
  }
  /**
    * PRECO_LIGUIDO: Método Gets para este campo
    */
  public String getPreco_liguido() {
    return preco_liguido;
  }
  /**
    * PRECO_LIGUIDO: Método Sets pára este campo.
    */
  public void setPreco_liguido(String PARAM) {
    preco_liguido = PARAM;
  }
  /**
    * LL_ALTERACAO_SOLICITADA: Método Gets para este campo
    */
  public String getLl_alteracao_solicitada() {
    return ll_alteracao_solicitada;
  }
  /**
    * LL_ALTERACAO_SOLICITADA: Método Sets pára este campo.
    */
  public void setLl_alteracao_solicitada(String PARAM) {
    ll_alteracao_solicitada = PARAM;
  }
  /**
    * TIPO_SOLICITACAO_COMB_ESPECIAL: Método Gets para este campo
    */
  public String getTipo_solicitacao_comb_especial() {
    return tipo_solicitacao_comb_especial;
  }
  /**
    * TIPO_SOLICITACAO_COMB_ESPECIAL: Método Sets pára este campo.
    */
  public void setTipo_solicitacao_comb_especial(String PARAM) {
    tipo_solicitacao_comb_especial = PARAM;
  }
  /**
    * DESC_SOLICITACAO_COMB_ESPECIAL: Método Gets para este campo
    */
  public String getDesc_solicitacao_comb_especial() {
    return desc_solicitacao_comb_especial;
  }
  /**
    * DESC_SOLICITACAO_COMB_ESPECIAL: Método Sets pára este campo.
    */
  public void setDesc_solicitacao_comb_especial(String PARAM) {
    desc_solicitacao_comb_especial = PARAM;
  }
  /**
    * SUBTIPO_SOLICITACAO_COMB_ESPEC: Método Gets para este campo
    */
  public String getSubtipo_solicitacao_comb_espec() {
    return subtipo_solicitacao_comb_espec;
  }
  /**
    * SUBTIPO_SOLICITACAO_COMB_ESPEC: Método Sets pára este campo.
    */
  public void setSubtipo_solicitacao_comb_espec(String PARAM) {
    subtipo_solicitacao_comb_espec = PARAM;
  }
  /**
    * DESC_SUBTIPO_COMB_ESPEC: Método Gets para este campo
    */
  public String getDesc_subtipo_comb_espec() {
    return desc_subtipo_comb_espec;
  }
  /**
    * DESC_SUBTIPO_COMB_ESPEC: Método Sets pára este campo.
    */
  public void setDesc_subtipo_comb_espec(String PARAM) {
    desc_subtipo_comb_espec = PARAM;
  }
  /**
    * DATA_MANIPULACAO: Método Gets para este campo
    */
  public String getData_manipulacao() {
    return data_manipulacao;
  }
  /**
    * DATA_MANIPULACAO: Método Sets pára este campo.
    */
  public void setData_manipulacao(String PARAM) {
    data_manipulacao = PARAM;
  }
  /**
    * IMAGEM: Método Gets para este campo
    */
  public String getImagem() {
    return imagem;
  }
  /**
    * IMAGEM: Método Sets pára este campo.
    */
  public void setImagem(String PARAM) {
    imagem = PARAM;
  }
  /**
    * SITUACAO_SOLICITACAO1: Método Gets para este campo
    */
  public String getSituacao_solicitacao1() {
    return situacao_solicitacao1;
  }
  /**
    * SITUACAO_SOLICITACAO1: Método Sets pára este campo.
    */
  public void setSituacao_solicitacao1(String PARAM) {
    situacao_solicitacao1 = PARAM;
  }
  private Vector situacao_solicitacao1List = new Vector(10, 10);
  public void setSituacao_solicitacao1List(java.util.Vector VECTOR) {
    situacao_solicitacao1List = VECTOR;
  }
  public java.util.Vector getSituacao_solicitacao1List() {
    if (situacao_solicitacao1List == null || situacao_solicitacao1List.size() == 0) {
      situacao_solicitacao1List = new Vector(10, 10);
      situacao_solicitacao1LabelList = new Vector(10, 10);
      situacao_solicitacao1List.addElement("");
      java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
      situacao_solicitacao1LabelList.addElement(bundle.getString("jsp.pleaseselect"));
      com.egen.util.jdbc.JdbcUtil j = null;
      try {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cg_ref_codes db_object = new Cg_ref_codes();
        String[][] select = {{"rv_low_value", null},{"rv_meaning", null}};
        Object[][] where = {{"rv_domain","=","SITUACAO_SOLICITACAO_COMB_ESPEC"}};
        String[] order = {"rv_high_value","rv_low_value"};
        String[] groupby = null;
        String[] having = null;
        Vector results = j.select(db_object, select, where, groupby, having, order);
        for (int i = 0; i < results.size(); i++) {
          db_object = (Cg_ref_codes) results.elementAt(i);
          situacao_solicitacao1List.addElement(""+db_object.getRv_low_value());
          situacao_solicitacao1LabelList.addElement(""+db_object.getRv_meaning());
        }
      } catch (Exception e) {
        com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "SolicitacaoCombinacaoEspecial_r.", e);
      } finally {
        if (j != null) {
          j.close();
        }
      }
    }
    return situacao_solicitacao1List;
  }
  private java.util.Vector situacao_solicitacao1LabelList = new Vector(10, 10);
  public void setSituacao_solicitacao1LabelList(java.util.Vector VECTOR) {
    situacao_solicitacao1LabelList = VECTOR;
  }
  public java.util.Vector getSituacao_solicitacao1LabelList() {
    return situacao_solicitacao1LabelList;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    gridCheckField = false;
    id_solicitacao = null;
    data_solicitacao = null;
    nome_marca = null;
    regional = null;
    material = null;
    lin_cdgo = null;
    ref_cdgo = null;
    cab_cdgo = null;
    cor_cdgo = null;
    cliente_grupo_economico = null;
    pares_alteracao = null;
    pares_vendidos = null;
    situacao_solicitacao = null;
    situacao_solicitacao_desc = null;
    data_aprovacao = null;
    preco_liguido = null;
    ll_alteracao_solicitada = null;
    tipo_solicitacao_comb_especial = null;
    desc_solicitacao_comb_especial = null;
    subtipo_solicitacao_comb_espec = null;
    desc_subtipo_comb_espec = null;
    data_manipulacao = null;
    imagem = null;
    situacao_solicitacao1 = null;
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
      if (com.egen.util.text.Validate.isValidate("update_action,select_action,", request)) {
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
