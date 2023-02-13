package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 09/12/2005 14:55:19
 * Last Modify Date 10/12/2020 14:12:57
 */

public class Clientes_atendidosActionForm extends org.apache.struts.action.ActionForm
{
  public String dt_inicial;
  public String dt_final;
  public String codigo_regional;
  public String nome_regional;
  public String codigo_marca;
  public String descricao_marca;
  public String lin_cdgo;
  public String lin_nome;
  public String ordenacao;
  public String check_rep;
  public String situacao_representante;
  public String situacao_cliente_representante;
  public String situacao_representante_marca;
  public String check_mar;
  public String check_reg;
  public String reg;
  public String representante;
  public String cb_consulta_clientes;
  public String cb_consulta_grupos;
  public String cb_consulta_cidades;
  public String cb_consulta_segmentos;
  public String cb_consulta_regionais;
  public String cb_saldo_limite_credito;
  public String cb_abrir_meses;
  private boolean valida = false;
  public Clientes_atendidosActionForm() {
  }
  /**
    * DT_INICIAL: Método Gets para este campo
    */
  public String getDt_inicial() {
    return dt_inicial;
  }
  /**
    * DT_INICIAL: Método Sets pára este campo.
    */
  public void setDt_inicial(String PARAM) {
    dt_inicial = PARAM;
  }
  /**
    * DT_FINAL: Método Gets para este campo
    */
  public String getDt_final() {
    return dt_final;
  }
  /**
    * DT_FINAL: Método Sets pára este campo.
    */
  public void setDt_final(String PARAM) {
    dt_final = PARAM;
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
    * NOME_REGIONAL: Método Gets para este campo
    */
  public String getNome_regional() {
    String fieldRelationValue = "";
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (codigo_regional != null && codigo_regional.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        portalbr.dbobj.table.Regionais_vendas db_object = new portalbr.dbobj.table.Regionais_vendas();
        Object[][] where = { {"codigo_regional","=",com.egen.util.text.FormatNumber.toInt(codigo_regional)} };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (portalbr.dbobj.table.Regionais_vendas) results.elementAt(0);
          fieldRelationValue = (db_object.getNome_regional() != null) ? db_object.getNome_regional() + "":"";
        }
      }
    } catch (Exception e) {
      fieldRelationValue = "";
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    nome_regional = fieldRelationValue;
    return nome_regional;
  }
  /**
    * NOME_REGIONAL: Método Sets pára este campo.
    */
  public void setNome_regional(String PARAM) {
    nome_regional = PARAM;
  }
  /**
    * CODIGO_MARCA: Método Gets para este campo
    */
  public String getCodigo_marca() {
    return codigo_marca;
  }
  /**
    * CODIGO_MARCA: Método Sets pára este campo.
    */
  public void setCodigo_marca(String PARAM) {
    codigo_marca = PARAM;
  }
  /**
    * DESCRICAO_MARCA: Método Gets para este campo
    */
  public String getDescricao_marca() {
    String fieldRelationValue = "";
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (codigo_marca != null && codigo_marca.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        portalbr.dbobj.table.Marcas_produtos db_object = new portalbr.dbobj.table.Marcas_produtos();
        Object[][] where = { {"codigo_marca","=",com.egen.util.text.FormatNumber.toInt(codigo_marca)} };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (portalbr.dbobj.table.Marcas_produtos) results.elementAt(0);
          fieldRelationValue = (db_object.getDescricao_marca() != null) ? db_object.getDescricao_marca() + "":"";
        }
      }
    } catch (Exception e) {
      fieldRelationValue = "";
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    descricao_marca = fieldRelationValue;
    return descricao_marca;
  }
  /**
    * DESCRICAO_MARCA: Método Sets pára este campo.
    */
  public void setDescricao_marca(String PARAM) {
    descricao_marca = PARAM;
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
    String fieldRelationValue = "";
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (lin_cdgo != null && lin_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        portalbr.dbobj.table.Lin db_object = new portalbr.dbobj.table.Lin();
        Object[][] where = { {"lin_cdgo","=",com.egen.util.text.FormatNumber.toInt(lin_cdgo)} };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (portalbr.dbobj.table.Lin) results.elementAt(0);
          fieldRelationValue = (db_object.getLin_nome() != null) ? db_object.getLin_nome() + "":"";
        }
      }
    } catch (Exception e) {
      fieldRelationValue = "";
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    lin_nome = fieldRelationValue;
    return lin_nome;
  }
  /**
    * LIN_NOME: Método Sets pára este campo.
    */
  public void setLin_nome(String PARAM) {
    lin_nome = PARAM;
  }
  /**
    * ORDENACAO: Método Gets para este campo
    */
  public String getOrdenacao() {
    return ordenacao;
  }
  /**
    * ORDENACAO: Método Sets pára este campo.
    */
  public void setOrdenacao(String PARAM) {
    ordenacao = PARAM;
  }
  Vector ordenacaoList = new Vector(10, 1);
  public java.util.Vector getOrdenacaoList() {
    if (ordenacaoList == null || ordenacaoList.size() == 0) {
      ordenacaoList.addElement("0");
      ordenacaoLabelList.addElement("---Selecione---");
      ordenacaoList.addElement("1");
      ordenacaoLabelList.addElement("Por Regional");
      ordenacaoList.addElement("2");
      ordenacaoLabelList.addElement("Por Marca");
    }
    java.util.Vector list = ordenacaoList;
    return list;
  }
  java.util.Vector ordenacaoLabelList = new Vector(10, 1);
  public java.util.Vector getOrdenacaoLabelList() {
    java.util.Vector list = ordenacaoLabelList;
    return list;
  }
  /**
    * CHECK_REP: Método Gets para este campo
    */
  public String getCheck_rep() {
    return check_rep;
  }
  /**
    * CHECK_REP: Método Sets pára este campo.
    */
  public void setCheck_rep(String PARAM) {
    check_rep = PARAM;
  }
  /**
    * SITUACAO_REPRESENTANTE: Método Gets para este campo
    */
  public String getSituacao_representante() {
    return situacao_representante;
  }
  /**
    * SITUACAO_REPRESENTANTE: Método Sets pára este campo.
    */
  public void setSituacao_representante(String PARAM) {
    situacao_representante = PARAM;
  }
  Vector situacao_representanteList = new Vector(10, 1);
  public java.util.Vector getSituacao_representanteList() {
    if (situacao_representanteList == null || situacao_representanteList.size() == 0) {
      situacao_representanteList.addElement("T");
      situacao_representanteLabelList.addElement("Todos");
      situacao_representanteList.addElement("A");
      situacao_representanteLabelList.addElement("Ativo");
      situacao_representanteList.addElement("I");
      situacao_representanteLabelList.addElement("Inativo");
    }
    java.util.Vector list = situacao_representanteList;
    return list;
  }
  java.util.Vector situacao_representanteLabelList = new Vector(10, 1);
  public java.util.Vector getSituacao_representanteLabelList() {
    java.util.Vector list = situacao_representanteLabelList;
    return list;
  }
  /**
    * SITUACAO_CLIENTE_REPRESENTANTE: Método Gets para este campo
    */
  public String getSituacao_cliente_representante() {
    return situacao_cliente_representante;
  }
  /**
    * SITUACAO_CLIENTE_REPRESENTANTE: Método Sets pára este campo.
    */
  public void setSituacao_cliente_representante(String PARAM) {
    situacao_cliente_representante = PARAM;
  }
  Vector situacao_cliente_representanteList = new Vector(10, 1);
  public java.util.Vector getSituacao_cliente_representanteList() {
    if (situacao_cliente_representanteList == null || situacao_cliente_representanteList.size() == 0) {
      situacao_cliente_representanteList.addElement("T");
      situacao_cliente_representanteLabelList.addElement("Todos");
      situacao_cliente_representanteList.addElement("A");
      situacao_cliente_representanteLabelList.addElement("Ativo");
      situacao_cliente_representanteList.addElement("I");
      situacao_cliente_representanteLabelList.addElement("Inativo");
    }
    java.util.Vector list = situacao_cliente_representanteList;
    return list;
  }
  java.util.Vector situacao_cliente_representanteLabelList = new Vector(10, 1);
  public java.util.Vector getSituacao_cliente_representanteLabelList() {
    java.util.Vector list = situacao_cliente_representanteLabelList;
    return list;
  }
  /**
    * SITUACAO_REPRESENTANTE_MARCA: Método Gets para este campo
    */
  public String getSituacao_representante_marca() {
    return situacao_representante_marca;
  }
  /**
    * SITUACAO_REPRESENTANTE_MARCA: Método Sets pára este campo.
    */
  public void setSituacao_representante_marca(String PARAM) {
    situacao_representante_marca = PARAM;
  }
  Vector situacao_representante_marcaList = new Vector(10, 1);
  public java.util.Vector getSituacao_representante_marcaList() {
    if (situacao_representante_marcaList == null || situacao_representante_marcaList.size() == 0) {
      situacao_representante_marcaList.addElement("T");
      situacao_representante_marcaLabelList.addElement("Todos");
      situacao_representante_marcaList.addElement("A");
      situacao_representante_marcaLabelList.addElement("Ativos");
      situacao_representante_marcaList.addElement("I");
      situacao_representante_marcaLabelList.addElement("Inativos");
    }
    java.util.Vector list = situacao_representante_marcaList;
    return list;
  }
  java.util.Vector situacao_representante_marcaLabelList = new Vector(10, 1);
  public java.util.Vector getSituacao_representante_marcaLabelList() {
    java.util.Vector list = situacao_representante_marcaLabelList;
    return list;
  }
  /**
    * CHECK_MAR: Método Gets para este campo
    */
  public String getCheck_mar() {
    return check_mar;
  }
  /**
    * CHECK_MAR: Método Sets pára este campo.
    */
  public void setCheck_mar(String PARAM) {
    check_mar = PARAM;
  }
  /**
    * CHECK_REG: Método Gets para este campo
    */
  public String getCheck_reg() {
    return check_reg;
  }
  /**
    * CHECK_REG: Método Sets pára este campo.
    */
  public void setCheck_reg(String PARAM) {
    check_reg = PARAM;
  }
  /**
    * REG: Método Gets para este campo
    */
  public String getReg() {
    return reg;
  }
  /**
    * REG: Método Sets pára este campo.
    */
  public void setReg(String PARAM) {
    reg = PARAM;
  }
  /**
    * REPRESENTANTE: Método Gets para este campo
    */
  public String getRepresentante() {
    return representante;
  }
  /**
    * REPRESENTANTE: Método Sets pára este campo.
    */
  public void setRepresentante(String PARAM) {
    representante = PARAM;
  }
  /**
    * CB_CONSULTA_CLIENTES: Método Gets para este campo
    */
  public String getCb_consulta_clientes() {
    return cb_consulta_clientes;
  }
  /**
    * CB_CONSULTA_CLIENTES: Método Sets pára este campo.
    */
  public void setCb_consulta_clientes(String PARAM) {
    cb_consulta_clientes = PARAM;
  }
  /**
    * CB_CONSULTA_GRUPOS: Método Gets para este campo
    */
  public String getCb_consulta_grupos() {
    return cb_consulta_grupos;
  }
  /**
    * CB_CONSULTA_GRUPOS: Método Sets pára este campo.
    */
  public void setCb_consulta_grupos(String PARAM) {
    cb_consulta_grupos = PARAM;
  }
  /**
    * CB_CONSULTA_CIDADES: Método Gets para este campo
    */
  public String getCb_consulta_cidades() {
    return cb_consulta_cidades;
  }
  /**
    * CB_CONSULTA_CIDADES: Método Sets pára este campo.
    */
  public void setCb_consulta_cidades(String PARAM) {
    cb_consulta_cidades = PARAM;
  }
  /**
    * CB_CONSULTA_SEGMENTOS: Método Gets para este campo
    */
  public String getCb_consulta_segmentos() {
    return cb_consulta_segmentos;
  }
  /**
    * CB_CONSULTA_SEGMENTOS: Método Sets pára este campo.
    */
  public void setCb_consulta_segmentos(String PARAM) {
    cb_consulta_segmentos = PARAM;
  }
  /**
    * CB_CONSULTA_REGIONAIS: Método Gets para este campo
    */
  public String getCb_consulta_regionais() {
    return cb_consulta_regionais;
  }
  /**
    * CB_CONSULTA_REGIONAIS: Método Sets pára este campo.
    */
  public void setCb_consulta_regionais(String PARAM) {
    cb_consulta_regionais = PARAM;
  }
  /**
    * CB_SALDO_LIMITE_CREDITO: Método Gets para este campo
    */
  public String getCb_saldo_limite_credito() {
    return cb_saldo_limite_credito;
  }
  /**
    * CB_SALDO_LIMITE_CREDITO: Método Sets pára este campo.
    */
  public void setCb_saldo_limite_credito(String PARAM) {
    cb_saldo_limite_credito = PARAM;
  }
  /**
    * CB_ABRIR_MESES: Método Gets para este campo
    */
  public String getCb_abrir_meses() {
    return cb_abrir_meses;
  }
  /**
    * CB_ABRIR_MESES: Método Sets pára este campo.
    */
  public void setCb_abrir_meses(String PARAM) {
    cb_abrir_meses = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    dt_inicial = null;
    dt_final = null;
    codigo_regional = null;
    nome_regional = null;
    codigo_marca = null;
    descricao_marca = null;
    lin_cdgo = null;
    lin_nome = null;
    ordenacao = null;
    check_rep = null;
    situacao_representante = null;
    situacao_cliente_representante = null;
    situacao_representante_marca = null;
    check_mar = null;
    check_reg = null;
    reg = null;
    representante = null;
    cb_consulta_clientes = null;
    cb_consulta_grupos = null;
    cb_consulta_cidades = null;
    cb_consulta_segmentos = null;
    cb_consulta_regionais = null;
    cb_saldo_limite_credito = null;
    cb_abrir_meses = null;
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
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
