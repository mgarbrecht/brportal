package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 15/05/2006 11:05:13
 * Last Modify Date 22/06/2015 14:09:31
 */

public class Sbr073ActionForm extends org.apache.struts.action.ActionForm
{
  public String dt_inicial;
  public String dt_final;
  public String regional;
  public String nome_regional;
  public String codigo_marca;
  public String descricao_marca;
  public String indicador;
  public String mercado;
  public String mix;
  public String abre_automaticamente;
  public String mensagem;
  private boolean valida = false;
  public Sbr073ActionForm() {
  }
  /**
    * DT_INICIAL: Method to get the field value.
    */
  public String getDt_inicial() {
    return dt_inicial;
  }
  /**
    * DT_INICIAL: Method to set the field value.
    */
  public void setDt_inicial(String PARAM) {
    dt_inicial = PARAM;
  }
  /**
    * DT_FINAL: Method to get the field value.
    */
  public String getDt_final() {
    return dt_final;
  }
  /**
    * DT_FINAL: Method to set the field value.
    */
  public void setDt_final(String PARAM) {
    dt_final = PARAM;
  }
  /**
    * REGIONAL: Method to get the field value.
    */
  public String getRegional() {
    return regional;
  }
  /**
    * REGIONAL: Method to set the field value.
    */
  public void setRegional(String PARAM) {
    regional = PARAM;
  }
  /**
    * NOME_REGIONAL: Method to get the field value.
    */
  public String getNome_regional() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (regional != null && regional.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Regionais_vendas db_object = new Regionais_vendas();
        String[][] select = {{"nome_regional",null}};
        Object[][] where = { {"codigo_regional","=",com.egen.util.text.FormatNumber.toInt(regional)} };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Regionais_vendas) results.elementAt(0);
          nome_regional = (db_object.getNome_regional() != null) ? db_object.getNome_regional() + "":"";
        } else {
          nome_regional = "";
        }
      }
    } catch (Exception e) {
      nome_regional = "";
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return nome_regional;
  }

  public String[][] getNome_regional_Ajax(Sbr073ActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getRegional() != null && PARAM.getRegional().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Regionais_vendas db_object = new Regionais_vendas();
        Object[][] where = { {"codigo_regional","like",PARAM.getRegional()} };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Regionais_vendas) results.elementAt(0);
          list[0] = new String[]{"nome_regional", (db_object.getNome_regional() != null) ? db_object.getNome_regional() + "":""};
        } else {
          list[0] = new String[]{"nome_regional", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"nome_regional", ""};
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return list;
  }
  /**
    * NOME_REGIONAL: Method to set the field value.
    */
  public void setNome_regional(String PARAM) {
    nome_regional = PARAM;
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
    * DESCRICAO_MARCA: Method to get the field value.
    */
  public String getDescricao_marca() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (codigo_marca != null && codigo_marca.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Marcas_produtos db_object = new Marcas_produtos();
        String[][] select = {{"descricao_marca",null}};
        Object[][] where = { {"codigo_marca","=",com.egen.util.text.FormatNumber.toInt(codigo_marca)} };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Marcas_produtos) results.elementAt(0);
          descricao_marca = (db_object.getDescricao_marca() != null) ? db_object.getDescricao_marca() + "":"";
        } else {
          descricao_marca = "";
        }
      }
    } catch (Exception e) {
      descricao_marca = "";
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return descricao_marca;
  }

  public String[][] getDescricao_marca_Ajax(Sbr073ActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCodigo_marca() != null && PARAM.getCodigo_marca().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Marcas_produtos db_object = new Marcas_produtos();
        Object[][] where = { {"codigo_marca","like",PARAM.getCodigo_marca()} };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Marcas_produtos) results.elementAt(0);
          list[0] = new String[]{"descricao_marca", (db_object.getDescricao_marca() != null) ? db_object.getDescricao_marca() + "":""};
        } else {
          list[0] = new String[]{"descricao_marca", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"descricao_marca", ""};
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return list;
  }
  /**
    * DESCRICAO_MARCA: Method to set the field value.
    */
  public void setDescricao_marca(String PARAM) {
    descricao_marca = PARAM;
  }
  /**
    * INDICADOR: Method to get the field value.
    */
  public String getIndicador() {
    return indicador;
  }
  /**
    * INDICADOR: Method to set the field value.
    */
  public void setIndicador(String PARAM) {
    indicador = PARAM;
  }
  Vector indicadorList = new Vector(10, 1);
  public java.util.Vector getIndicadorList() {
    if (indicadorList == null || indicadorList.size() == 0) {
      indicadorList.addElement("A");
      indicadorLabelList.addElement("Aberto");
      indicadorList.addElement("F");
      indicadorLabelList.addElement("Fechado");
      indicadorList.addElement("T");
      indicadorLabelList.addElement("Todos");
    }
    java.util.Vector list = indicadorList;
    return list;
  }
  java.util.Vector indicadorLabelList = new Vector(10, 1);
  public java.util.Vector getIndicadorLabelList() {
    java.util.Vector list = indicadorLabelList;
    return list;
  }
  /**
    * MERCADO: Method to get the field value.
    */
  public String getMercado() {
    return mercado;
  }
  /**
    * MERCADO: Method to set the field value.
    */
  public void setMercado(String PARAM) {
    mercado = PARAM;
  }
  Vector mercadoList = new Vector(10, 1);
  public java.util.Vector getMercadoList() {
    if (mercadoList == null || mercadoList.size() == 0) {
      mercadoList.addElement("MI");
      mercadoLabelList.addElement("Interno");
      mercadoList.addElement("ME");
      mercadoLabelList.addElement("Externo");
      mercadoList.addElement("T");
      mercadoLabelList.addElement("Todos");
    }
    java.util.Vector list = mercadoList;
    return list;
  }
  java.util.Vector mercadoLabelList = new Vector(10, 1);
  public java.util.Vector getMercadoLabelList() {
    java.util.Vector list = mercadoLabelList;
    return list;
  }
  /**
    * MIX: Method to get the field value.
    */
  public String getMix() {
    return mix;
  }
  /**
    * MIX: Method to set the field value.
    */
  public void setMix(String PARAM) {
    mix = PARAM;
  }
  Vector mixList = new Vector(10, 1);
  public java.util.Vector getMixList() {
    if (mixList == null || mixList.size() == 0) {
      mixList.addElement("T");
      mixLabelList.addElement("Todos");
      mixList.addElement("S");
      mixLabelList.addElement("Sim");
    }
    java.util.Vector list = mixList;
    return list;
  }
  java.util.Vector mixLabelList = new Vector(10, 1);
  public java.util.Vector getMixLabelList() {
    java.util.Vector list = mixLabelList;
    return list;
  }
  /**
    * ABRE_AUTOMATICAMENTE: Method to get the field value.
    */
  public String getAbre_automaticamente() {
    return abre_automaticamente;
  }
  /**
    * ABRE_AUTOMATICAMENTE: Method to set the field value.
    */
  public void setAbre_automaticamente(String PARAM) {
    abre_automaticamente = PARAM;
  }
  /**
    * MENSAGEM: Method to get the field value.
    */
  public String getMensagem() {
    return mensagem;
  }
  /**
    * MENSAGEM: Method to set the field value.
    */
  public void setMensagem(String PARAM) {
    mensagem = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    dt_inicial = null;
    dt_final = null;
    regional = null;
    nome_regional = null;
    codigo_marca = null;
    descricao_marca = null;
    indicador = null;
    mercado = null;
    mix = null;
    abre_automaticamente = null;
    mensagem = null;
  }
  /**
    * Validate fields and return errors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("select_action,", request)) {
      if (com.egen.util.text.Validate.isNull(dt_inicial)) {
        errors.add("dt_inicial", new ActionMessage("error.validate.notnull","Data Inicial","dt_inicial","0"));
      }
      if (!com.egen.util.text.Validate.isDate(dt_inicial)) {
        errors.add("dt_inicial", new ActionMessage("error.validate.date","Data Inicial","dt_inicial","0"));
      }
      if (com.egen.util.text.Validate.isNull(dt_final)) {
        errors.add("dt_final", new ActionMessage("error.validate.notnull","Data Final","dt_final","0"));
      }
      if (!com.egen.util.text.Validate.isDate(dt_final)) {
        errors.add("dt_final", new ActionMessage("error.validate.date","Data Final","dt_final","0"));
      }
      if (com.egen.util.text.Validate.isNull(regional)) {
        errors.add("regional", new ActionMessage("error.validate.notnull","Regional","regional","0"));
      }
      if (!com.egen.util.text.Validate.isNumber(regional)) {
        errors.add("regional", new ActionMessage("error.validate.number","Regional","regional","0"));
      }
      if (!com.egen.util.text.Validate.isNumber(codigo_marca)) {
        errors.add("codigo_marca", new ActionMessage("error.validate.number","Marca","codigo_marca","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
