package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 03/09/2014 15:35:48
 * Last Modify Date 01/03/2023 17:43:45
 */

public class EntradaAtualPedidosActionForm extends org.apache.struts.action.ActionForm
{
  public String dia_anterior;
  public String dia_atual;
  public String mes;
  public String tipo;
  public String marca_cliente;
  public String marca_grupo;
  public String semana_atual;
  public String marca_regional;
  public String mercado;
  public String representantes_vendas;
  public String estilos;
  public String unidade;
  public String tipo_produto;
  public String regional_cliente;
  public String marca_select;
  public String representantes_vendas_segmentos;
  private boolean valida = false;
  public EntradaAtualPedidosActionForm() {
  }
  /**
    * DIA_ANTERIOR: M�todo Gets para este campo
    */
  public String getDia_anterior() {
    return dia_anterior;
  }
  /**
    * DIA_ANTERIOR: M�todo Sets p�ra este campo.
    */
  public void setDia_anterior(String PARAM) {
    dia_anterior = PARAM;
  }
  /**
    * DIA_ATUAL: M�todo Gets para este campo
    */
  public String getDia_atual() {
    return dia_atual;
  }
  /**
    * DIA_ATUAL: M�todo Sets p�ra este campo.
    */
  public void setDia_atual(String PARAM) {
    dia_atual = PARAM;
  }
  /**
    * MES: M�todo Gets para este campo
    */
  public String getMes() {
    return mes;
  }
  /**
    * MES: M�todo Sets p�ra este campo.
    */
  public void setMes(String PARAM) {
    mes = PARAM;
  }
  /**
    * TIPO: M�todo Gets para este campo
    */
  public String getTipo() {
    return tipo;
  }
  /**
    * TIPO: M�todo Sets p�ra este campo.
    */
  public void setTipo(String PARAM) {
    tipo = PARAM;
  }
  /**
    * MARCA_CLIENTE: M�todo Gets para este campo
    */
  public String getMarca_cliente() {
    return marca_cliente;
  }
  /**
    * MARCA_CLIENTE: M�todo Sets p�ra este campo.
    */
  public void setMarca_cliente(String PARAM) {
    marca_cliente = PARAM;
  }
  /**
    * MARCA_GRUPO: M�todo Gets para este campo
    */
  public String getMarca_grupo() {
    return marca_grupo;
  }
  /**
    * MARCA_GRUPO: M�todo Sets p�ra este campo.
    */
  public void setMarca_grupo(String PARAM) {
    marca_grupo = PARAM;
  }
  /**
    * SEMANA_ATUAL: M�todo Gets para este campo
    */
  public String getSemana_atual() {
    return semana_atual;
  }
  /**
    * SEMANA_ATUAL: M�todo Sets p�ra este campo.
    */
  public void setSemana_atual(String PARAM) {
    semana_atual = PARAM;
  }
  /**
    * MARCA_REGIONAL: M�todo Gets para este campo
    */
  public String getMarca_regional() {
    return marca_regional;
  }
  /**
    * MARCA_REGIONAL: M�todo Sets p�ra este campo.
    */
  public void setMarca_regional(String PARAM) {
    marca_regional = PARAM;
  }
  /**
    * MERCADO: M�todo Gets para este campo
    */
  public String getMercado() {
    return mercado;
  }
  /**
    * MERCADO: M�todo Sets p�ra este campo.
    */
  public void setMercado(String PARAM) {
    mercado = PARAM;
  }
  /**
    * REPRESENTANTES_VENDAS: M�todo Gets para este campo
    */
  public String getRepresentantes_vendas() {
    return representantes_vendas;
  }
  /**
    * REPRESENTANTES_VENDAS: M�todo Sets p�ra este campo.
    */
  public void setRepresentantes_vendas(String PARAM) {
    representantes_vendas = PARAM;
  }
  /**
    * ESTILOS: M�todo Gets para este campo
    */
  public String getEstilos() {
    return estilos;
  }
  /**
    * ESTILOS: M�todo Sets p�ra este campo.
    */
  public void setEstilos(String PARAM) {
    estilos = PARAM;
  }
  private Vector estilosList = new Vector(10, 10);
  public void setEstilosList(java.util.Vector VECTOR) {
    estilosList = VECTOR;
  }
  public java.util.Vector getEstilosList() {
    if (estilosList == null || estilosList.size() == 0) {
      estilosList = new Vector(10, 10);
      estilosLabelList = new Vector(10, 10);
      estilosList.addElement("");
      java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
      estilosLabelList.addElement(bundle.getString("jsp.pleaseselect"));
      com.egen.util.jdbc.JdbcUtil j = null;
      try {
        j = new com.egen.util.jdbc.JdbcUtil();
        Jw_entrada_atual_pedidos_filtro_estilos db_object = new Jw_entrada_atual_pedidos_filtro_estilos();
        String[][] select = {{"id_tipo_estilos", null},{"descricao_estilos", null}};
        Object[][] where = null;
        String[] order = {"descricao_estilos"};
        String[] groupby = null;
        String[] having = null;
        Vector results = j.select(db_object, select, where, groupby, having, order);
        for (int i = 0; i < results.size(); i++) {
          db_object = (Jw_entrada_atual_pedidos_filtro_estilos) results.elementAt(i);
          estilosList.addElement(""+db_object.getId_tipo_estilos());
          estilosLabelList.addElement(""+db_object.getDescricao_estilos());
        }
      } catch (Exception e) {
        com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "EntradaAtualPedidos.", e);
      } finally {
        if (j != null) {
          j.close();
        }
      }
    }
    return estilosList;
  }
  private java.util.Vector estilosLabelList = new Vector(10, 10);
  public void setEstilosLabelList(java.util.Vector VECTOR) {
    estilosLabelList = VECTOR;
  }
  public java.util.Vector getEstilosLabelList() {
    return estilosLabelList;
  }
  /**
    * UNIDADE: M�todo Gets para este campo
    */
  public String getUnidade() {
    return unidade;
  }
  /**
    * UNIDADE: M�todo Sets p�ra este campo.
    */
  public void setUnidade(String PARAM) {
    unidade = PARAM;
  }
  /**
    * TIPO_PRODUTO: M�todo Gets para este campo
    */
  public String getTipo_produto() {
    return tipo_produto;
  }
  /**
    * TIPO_PRODUTO: M�todo Sets p�ra este campo.
    */
  public void setTipo_produto(String PARAM) {
    tipo_produto = PARAM;
  }
  /**
    * REGIONAL_CLIENTE: M�todo Gets para este campo
    */
  public String getRegional_cliente() {
    return regional_cliente;
  }
  /**
    * REGIONAL_CLIENTE: M�todo Sets p�ra este campo.
    */
  public void setRegional_cliente(String PARAM) {
    regional_cliente = PARAM;
  }
  /**
    * MARCA_SELECT: M�todo Gets para este campo
    */
  public String getMarca_select() {
    return marca_select;
  }
  /**
    * MARCA_SELECT: M�todo Sets p�ra este campo.
    */
  public void setMarca_select(String PARAM) {
    marca_select = PARAM;
  }
  /**
    * REPRESENTANTES_VENDAS_SEGMENTOS: M�todo Gets para este campo
    */
  public String getRepresentantes_vendas_segmentos() {
    return representantes_vendas_segmentos;
  }
  /**
    * REPRESENTANTES_VENDAS_SEGMENTOS: M�todo Sets p�ra este campo.
    */
  public void setRepresentantes_vendas_segmentos(String PARAM) {
    representantes_vendas_segmentos = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    dia_anterior = null;
    dia_atual = null;
    mes = null;
    tipo = null;
    marca_cliente = null;
    marca_grupo = null;
    semana_atual = null;
    marca_regional = null;
    mercado = null;
    representantes_vendas = null;
    estilos = null;
    unidade = null;
    tipo_produto = null;
    regional_cliente = null;
    marca_select = null;
    representantes_vendas_segmentos = null;
  }
  /**
    * Valida��o dos campos, retornando um ActionErrors.
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
