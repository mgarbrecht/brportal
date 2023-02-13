package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 28/07/2015 11:36:46
 * Last Modify Date 15/05/2017 15:05:50
 */

public class FichaMarcaActionForm extends org.apache.struts.action.ActionForm
{
  public String marca;
  public String regional;
  public String data_inicial;
  public String data_final;
  public String tipo_mercado;
  public String qtd_maiores_clientes;
  public String qtd_desempenho_representante;
  public String qtd_modelos_mais_vendidos;
  private boolean valida = false;
  public FichaMarcaActionForm() {
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
  private Vector marcaList = new Vector(10, 10);
  public void setMarcaList(java.util.Vector VECTOR) {
    marcaList = VECTOR;
  }
  public java.util.Vector getMarcaList() {
    if (marcaList == null || marcaList.size() == 0) {
      marcaList = new Vector(10, 10);
      marcaLabelList = new Vector(10, 10);
      marcaList.addElement("");
      java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
      marcaLabelList.addElement(bundle.getString("jsp.pleaseselect"));
      com.egen.util.jdbc.JdbcUtil j = null;
      try {
        j = new com.egen.util.jdbc.JdbcUtil();
        Jw_marcas db_object = new Jw_marcas();
        String[][] select = {{"codigo_marca", null},{"descricao_marca", null}};
        Object[][] where = null;
        String[] order = {"descricao_marca"};
        String[] groupby = null;
        String[] having = null;
        Vector results = j.select(db_object, select, where, groupby, having, order);
        for (int i = 0; i < results.size(); i++) {
          db_object = (Jw_marcas) results.elementAt(i);
          marcaList.addElement(""+db_object.getCodigo_marca());
          marcaLabelList.addElement(""+db_object.getDescricao_marca());
        }
      } catch (Exception e) {
        com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "FichaMarca.", e);
      } finally {
        if (j != null) {
          j.close();
        }
      }
    }
    return marcaList;
  }
  private java.util.Vector marcaLabelList = new Vector(10, 10);
  public void setMarcaLabelList(java.util.Vector VECTOR) {
    marcaLabelList = VECTOR;
  }
  public java.util.Vector getMarcaLabelList() {
    return marcaLabelList;
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
  private Vector regionalList = new Vector(10, 10);
  public void setRegionalList(java.util.Vector VECTOR) {
    regionalList = VECTOR;
  }
  public java.util.Vector getRegionalList() {
    if (regionalList == null || regionalList.size() == 0) {
      regionalList = new Vector(10, 10);
      regionalLabelList = new Vector(10, 10);
      regionalList.addElement("");
      java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
      regionalLabelList.addElement(bundle.getString("jsp.pleaseselect"));
      com.egen.util.jdbc.JdbcUtil j = null;
      try {
        j = new com.egen.util.jdbc.JdbcUtil();
        Regionais_vendas db_object = new Regionais_vendas();
        String[][] select = {{"codigo_regional", null},{"nome_regional", null}};
        Object[][] where = null;
        String[] order = {"nome_regional"};
        String[] groupby = null;
        String[] having = null;
        Vector results = j.select(db_object, select, where, groupby, having, order);
        for (int i = 0; i < results.size(); i++) {
          db_object = (Regionais_vendas) results.elementAt(i);
          regionalList.addElement(""+db_object.getCodigo_regional());
          regionalLabelList.addElement(""+db_object.getNome_regional());
        }
      } catch (Exception e) {
        com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "FichaMarca.", e);
      } finally {
        if (j != null) {
          j.close();
        }
      }
    }
    return regionalList;
  }
  private java.util.Vector regionalLabelList = new Vector(10, 10);
  public void setRegionalLabelList(java.util.Vector VECTOR) {
    regionalLabelList = VECTOR;
  }
  public java.util.Vector getRegionalLabelList() {
    return regionalLabelList;
  }
  /**
    * DATA_INICIAL: Método Gets para este campo
    */
  public String getData_inicial() {
    return data_inicial;
  }
  /**
    * DATA_INICIAL: Método Sets pára este campo.
    */
  public void setData_inicial(String PARAM) {
    data_inicial = PARAM;
  }
  /**
    * DATA_FINAL: Método Gets para este campo
    */
  public String getData_final() {
    return data_final;
  }
  /**
    * DATA_FINAL: Método Sets pára este campo.
    */
  public void setData_final(String PARAM) {
    data_final = PARAM;
  }
  /**
    * TIPO_MERCADO: Método Gets para este campo
    */
  public String getTipo_mercado() {
    return tipo_mercado;
  }
  /**
    * TIPO_MERCADO: Método Sets pára este campo.
    */
  public void setTipo_mercado(String PARAM) {
    tipo_mercado = PARAM;
  }
  Vector tipo_mercadoList = new Vector(10, 1);
  public java.util.Vector getTipo_mercadoList() {
    if (tipo_mercadoList == null || tipo_mercadoList.size() == 0) {
      tipo_mercadoList.addElement("T");
      tipo_mercadoLabelList.addElement("Todos");
      tipo_mercadoList.addElement("MI");
      tipo_mercadoLabelList.addElement("Mercado Interno");
      tipo_mercadoList.addElement("EX");
      tipo_mercadoLabelList.addElement("Mercado Externo");
    }
    java.util.Vector list = tipo_mercadoList;
    return list;
  }
  java.util.Vector tipo_mercadoLabelList = new Vector(10, 1);
  public java.util.Vector getTipo_mercadoLabelList() {
    java.util.Vector list = tipo_mercadoLabelList;
    return list;
  }
  /**
    * QTD_MAIORES_CLIENTES: Método Gets para este campo
    */
  public String getQtd_maiores_clientes() {
    return qtd_maiores_clientes;
  }
  /**
    * QTD_MAIORES_CLIENTES: Método Sets pára este campo.
    */
  public void setQtd_maiores_clientes(String PARAM) {
    qtd_maiores_clientes = PARAM;
  }
  /**
    * QTD_DESEMPENHO_REPRESENTANTE: Método Gets para este campo
    */
  public String getQtd_desempenho_representante() {
    return qtd_desempenho_representante;
  }
  /**
    * QTD_DESEMPENHO_REPRESENTANTE: Método Sets pára este campo.
    */
  public void setQtd_desempenho_representante(String PARAM) {
    qtd_desempenho_representante = PARAM;
  }
  /**
    * QTD_MODELOS_MAIS_VENDIDOS: Método Gets para este campo
    */
  public String getQtd_modelos_mais_vendidos() {
    return qtd_modelos_mais_vendidos;
  }
  /**
    * QTD_MODELOS_MAIS_VENDIDOS: Método Sets pára este campo.
    */
  public void setQtd_modelos_mais_vendidos(String PARAM) {
    qtd_modelos_mais_vendidos = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    marca = null;
    regional = null;
    data_inicial = null;
    data_final = null;
    tipo_mercado = null;
    qtd_maiores_clientes = null;
    qtd_desempenho_representante = null;
    qtd_modelos_mais_vendidos = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("select_action,", request)) {
      if (com.egen.util.text.Validate.isNull(marca)) {
        errors.add("marca", new ActionMessage("error.validate.notnull","Marca","marca","0"));
      }
      if (com.egen.util.text.Validate.isNull(data_inicial)) {
        errors.add("data_inicial", new ActionMessage("error.validate.notnull","Data Inicial","data_inicial","0"));
      }
      if (com.egen.util.text.Validate.isNull(data_final)) {
        errors.add("data_final", new ActionMessage("error.validate.notnull","Data Final","data_final","0"));
      }
      if (com.egen.util.text.Validate.isNull(qtd_maiores_clientes)) {
        errors.add("qtd_maiores_clientes", new ActionMessage("error.validate.notnull","Qtd. Maiores Clientes","qtd_maiores_clientes","0"));
      }
      if (com.egen.util.text.Validate.isNull(qtd_desempenho_representante)) {
        errors.add("qtd_desempenho_representante", new ActionMessage("error.validate.notnull","Qtd. Desemp. Representante","qtd_desempenho_representante","0"));
      }
      if (com.egen.util.text.Validate.isNull(qtd_modelos_mais_vendidos)) {
        errors.add("qtd_modelos_mais_vendidos", new ActionMessage("error.validate.notnull","Qtd. Modelos Mais Vendidos","qtd_modelos_mais_vendidos","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
