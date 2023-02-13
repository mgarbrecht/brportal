package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 14/07/2006 17:26:26
 * Last Modify Date 24/09/2020 12:26:33
 */

public class Sbr436ActionForm extends org.apache.struts.action.ActionForm
{
  public String dia_inicial;
  public String codigo_regional;
  public String nome_regional;
  public String situacaoERC;
  public String rep_cdgo;
  public String rep_rzao;
  public String codigo_marca;
  public String unn_codigo;
  public String unn_descri;
  public String tipo;
  public String tipo_diario_semanal;
  public String venda;
  public String resumo;
  public String tipo_pedido;
  public String ind_aberto_fechado;
  public String cli_antigos;
  public String cb_marca_rep;
  public String abre_unidade;
  public String abre_automaticamente;
  public String mensagem1;
  private boolean valida = false;
  public Sbr436ActionForm() {
  }
  /**
    * DIA_INICIAL: Method to get the field value.
    */
  public String getDia_inicial() {
    return dia_inicial;
  }
  /**
    * DIA_INICIAL: Method to set the field value.
    */
  public void setDia_inicial(String PARAM) {
    dia_inicial = PARAM;
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
    * NOME_REGIONAL: Method to get the field value.
    */
  public String getNome_regional() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (codigo_regional != null && codigo_regional.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Regionais_vendas db_object = new Regionais_vendas();
        String[][] select = {{"nome_regional",null}};
        Object[][] where = { {"codigo_regional","=",com.egen.util.text.FormatNumber.toInt(codigo_regional)} };
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

  public String[][] getNome_regional_Ajax(Sbr436ActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCodigo_regional() != null && PARAM.getCodigo_regional().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Regionais_vendas db_object = new Regionais_vendas();
        Object[][] where = { {"codigo_regional","like",PARAM.getCodigo_regional()} };
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
    * SITUACAOERC: Method to get the field value.
    */
  public String getSituacaoERC() {
    return situacaoERC;
  }
  /**
    * SITUACAOERC: Method to set the field value.
    */
  public void setSituacaoERC(String PARAM) {
    situacaoERC = PARAM;
  }
  Vector situacaoERCList = new Vector(10, 1);
  public java.util.Vector getSituacaoERCList() {
    if (situacaoERCList == null || situacaoERCList.size() == 0) {
      situacaoERCList.addElement("t");
      situacaoERCLabelList.addElement("Todos");
      situacaoERCList.addElement("a");
      situacaoERCLabelList.addElement("Ativos");
      situacaoERCList.addElement("i");
      situacaoERCLabelList.addElement("Inativos");
    }
    java.util.Vector list = situacaoERCList;
    return list;
  }
  java.util.Vector situacaoERCLabelList = new Vector(10, 1);
  public java.util.Vector getSituacaoERCLabelList() {
    java.util.Vector list = situacaoERCLabelList;
    return list;
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
    * REP_RZAO: Method to get the field value.
    */
  public String getRep_rzao() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (rep_cdgo != null && rep_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Rep db_object = new Rep();
        String[][] select = {{"rep_rzao",null}};
        Object[][] where = { {"rep_cdgo","like",rep_cdgo} };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Rep) results.elementAt(0);
          rep_rzao = (db_object.getRep_rzao() != null) ? db_object.getRep_rzao() + "":"";
        } else {
          rep_rzao = "";
        }
      }
    } catch (Exception e) {
      rep_rzao = "";
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return rep_rzao;
  }

  public String[][] getRep_rzao_Ajax(Sbr436ActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getRep_cdgo() != null && PARAM.getRep_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Rep db_object = new Rep();
        Object[][] where = { {"rep_cdgo","like",PARAM.getRep_cdgo()} };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Rep) results.elementAt(0);
          list[0] = new String[]{"rep_rzao", (db_object.getRep_rzao() != null) ? db_object.getRep_rzao() + "":""};
        } else {
          list[0] = new String[]{"rep_rzao", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"rep_rzao", ""};
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return list;
  }
  /**
    * REP_RZAO: Method to set the field value.
    */
  public void setRep_rzao(String PARAM) {
    rep_rzao = PARAM;
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
  Vector codigo_marcaList = new Vector(10, 1);
  public java.util.Vector getCodigo_marcaList() {
    if (codigo_marcaList == null || codigo_marcaList.size() == 0) {
      codigo_marcaList.addElement("");
      codigo_marcaLabelList.addElement("TODAS");
      codigo_marcaList.addElement("3");
      codigo_marcaLabelList.addElement("BEIRA RIO");
      codigo_marcaList.addElement("9");
      codigo_marcaLabelList.addElement("MODARE");
      codigo_marcaList.addElement("18");
      codigo_marcaLabelList.addElement("BRSPORT");
      codigo_marcaList.addElement("16");
      codigo_marcaLabelList.addElement("MOLECA");
      codigo_marcaList.addElement("17");
      codigo_marcaLabelList.addElement("MOLEKINHA");
      codigo_marcaList.addElement("19");
      codigo_marcaLabelList.addElement("MOLEKINHO");
      codigo_marcaList.addElement("16,17");
      codigo_marcaLabelList.addElement("MOLECA + MOLEKINHA");
      codigo_marcaList.addElement("20");
      codigo_marcaLabelList.addElement("ACTVITTA");
    }
    java.util.Vector list = codigo_marcaList;
    return list;
  }
  java.util.Vector codigo_marcaLabelList = new Vector(10, 1);
  public java.util.Vector getCodigo_marcaLabelList() {
    java.util.Vector list = codigo_marcaLabelList;
    return list;
  }
  /**
    * UNN_CODIGO: Method to get the field value.
    */
  public String getUnn_codigo() {
    return unn_codigo;
  }
  /**
    * UNN_CODIGO: Method to set the field value.
    */
  public void setUnn_codigo(String PARAM) {
    unn_codigo = PARAM;
  }
  /**
    * UNN_DESCRI: Method to get the field value.
    */
  public String getUnn_descri() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (unn_codigo != null && unn_codigo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Uni_negocio db_object = new Uni_negocio();
        String[][] select = { {"unn_descri",null} };
        Object[][] where = { {"unn_codigo","like",unn_codigo}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Uni_negocio) results.elementAt(0);
          unn_descri = (db_object.getUnn_descri() != null) ? db_object.getUnn_descri() + "":"";
        } else {
          unn_descri = "";
        }
      }
    } catch (Exception e) {
      unn_descri = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return unn_descri;
  }

  public String[][] getUnn_descri_Ajax(Sbr436ActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getUnn_codigo() != null && PARAM.getUnn_codigo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Uni_negocio db_object = new Uni_negocio();
        Object[][] where = { {"unn_codigo","like",PARAM.getUnn_codigo()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Uni_negocio) results.elementAt(0);
          list[0] = new String[]{"unn_descri", (db_object.getUnn_descri() != null) ? db_object.getUnn_descri() + "":""};
        } else {
          list[0] = new String[]{"unn_descri", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"unn_descri", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * UNN_DESCRI: Method to set the field value.
    */
  public void setUnn_descri(String PARAM) {
    unn_descri = PARAM;
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
  Vector tipoList = new Vector(10, 1);
  public java.util.Vector getTipoList() {
    if (tipoList == null || tipoList.size() == 0) {
      tipoList.addElement("m");
      tipoLabelList.addElement("Marca");
      tipoList.addElement("r");
      tipoLabelList.addElement("Regional");
    }
    java.util.Vector list = tipoList;
    return list;
  }
  java.util.Vector tipoLabelList = new Vector(10, 1);
  public java.util.Vector getTipoLabelList() {
    java.util.Vector list = tipoLabelList;
    return list;
  }
  /**
    * TIPO_DIARIO_SEMANAL: Method to get the field value.
    */
  public String getTipo_diario_semanal() {
    return tipo_diario_semanal;
  }
  /**
    * TIPO_DIARIO_SEMANAL: Method to set the field value.
    */
  public void setTipo_diario_semanal(String PARAM) {
    tipo_diario_semanal = PARAM;
  }
  Vector tipo_diario_semanalList = new Vector(10, 1);
  public java.util.Vector getTipo_diario_semanalList() {
    if (tipo_diario_semanalList == null || tipo_diario_semanalList.size() == 0) {
      tipo_diario_semanalList.addElement("D");
      tipo_diario_semanalLabelList.addElement("Diário");
      tipo_diario_semanalList.addElement("S");
      tipo_diario_semanalLabelList.addElement("Semanal");
    }
    java.util.Vector list = tipo_diario_semanalList;
    return list;
  }
  java.util.Vector tipo_diario_semanalLabelList = new Vector(10, 1);
  public java.util.Vector getTipo_diario_semanalLabelList() {
    java.util.Vector list = tipo_diario_semanalLabelList;
    return list;
  }
  /**
    * VENDA: Method to get the field value.
    */
  public String getVenda() {
    return venda;
  }
  /**
    * VENDA: Method to set the field value.
    */
  public void setVenda(String PARAM) {
    venda = PARAM;
  }
  Vector vendaList = new Vector(10, 1);
  public java.util.Vector getVendaList() {
    if (vendaList == null || vendaList.size() == 0) {
      vendaList.addElement("a");
      vendaLabelList.addElement("Ambos");
      vendaList.addElement("cv");
      vendaLabelList.addElement("Com Venda");
      vendaList.addElement("sv");
      vendaLabelList.addElement("Sem Venda");
    }
    java.util.Vector list = vendaList;
    return list;
  }
  java.util.Vector vendaLabelList = new Vector(10, 1);
  public java.util.Vector getVendaLabelList() {
    java.util.Vector list = vendaLabelList;
    return list;
  }
  /**
    * RESUMO: Method to get the field value.
    */
  public String getResumo() {
    return resumo;
  }
  /**
    * RESUMO: Method to set the field value.
    */
  public void setResumo(String PARAM) {
    resumo = PARAM;
  }
  /**
    * TIPO_PEDIDO: Method to get the field value.
    */
  public String getTipo_pedido() {
    return tipo_pedido;
  }
  /**
    * TIPO_PEDIDO: Method to set the field value.
    */
  public void setTipo_pedido(String PARAM) {
    tipo_pedido = PARAM;
  }
  Vector tipo_pedidoList = new Vector(10, 1);
  public java.util.Vector getTipo_pedidoList() {
    if (tipo_pedidoList == null || tipo_pedidoList.size() == 0) {
      tipo_pedidoList.addElement("T");
      tipo_pedidoLabelList.addElement("Todos");
      tipo_pedidoList.addElement("pp");
      tipo_pedidoLabelList.addElement("PP");
      tipo_pedidoList.addElement("pg");
      tipo_pedidoLabelList.addElement("PG");
    }
    java.util.Vector list = tipo_pedidoList;
    return list;
  }
  java.util.Vector tipo_pedidoLabelList = new Vector(10, 1);
  public java.util.Vector getTipo_pedidoLabelList() {
    java.util.Vector list = tipo_pedidoLabelList;
    return list;
  }
  /**
    * IND_ABERTO_FECHADO: Method to get the field value.
    */
  public String getInd_aberto_fechado() {
    return ind_aberto_fechado;
  }
  /**
    * IND_ABERTO_FECHADO: Method to set the field value.
    */
  public void setInd_aberto_fechado(String PARAM) {
    ind_aberto_fechado = PARAM;
  }
  Vector ind_aberto_fechadoList = new Vector(10, 1);
  public java.util.Vector getInd_aberto_fechadoList() {
    if (ind_aberto_fechadoList == null || ind_aberto_fechadoList.size() == 0) {
      ind_aberto_fechadoList.addElement("");
      ind_aberto_fechadoLabelList.addElement("Todos");
      ind_aberto_fechadoList.addElement("@M@");
      ind_aberto_fechadoLabelList.addElement("Manufaturados");
      ind_aberto_fechadoList.addElement("@E@R@");
      ind_aberto_fechadoLabelList.addElement("Injetados");
    }
    java.util.Vector list = ind_aberto_fechadoList;
    return list;
  }
  java.util.Vector ind_aberto_fechadoLabelList = new Vector(10, 1);
  public java.util.Vector getInd_aberto_fechadoLabelList() {
    java.util.Vector list = ind_aberto_fechadoLabelList;
    return list;
  }
  /**
    * CLI_ANTIGOS: Method to get the field value.
    */
  public String getCli_antigos() {
    return cli_antigos;
  }
  /**
    * CLI_ANTIGOS: Method to set the field value.
    */
  public void setCli_antigos(String PARAM) {
    cli_antigos = PARAM;
  }
  /**
    * CB_MARCA_REP: Method to get the field value.
    */
  public String getCb_marca_rep() {
    return cb_marca_rep;
  }
  /**
    * CB_MARCA_REP: Method to set the field value.
    */
  public void setCb_marca_rep(String PARAM) {
    cb_marca_rep = PARAM;
  }
  /**
    * ABRE_UNIDADE: Method to get the field value.
    */
  public String getAbre_unidade() {
    return abre_unidade;
  }
  /**
    * ABRE_UNIDADE: Method to set the field value.
    */
  public void setAbre_unidade(String PARAM) {
    abre_unidade = PARAM;
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
    * MENSAGEM1: Method to get the field value.
    */
  public String getMensagem1() {
    return mensagem1;
  }
  /**
    * MENSAGEM1: Method to set the field value.
    */
  public void setMensagem1(String PARAM) {
    mensagem1 = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    dia_inicial = null;
    codigo_regional = null;
    nome_regional = null;
    situacaoERC = null;
    rep_cdgo = null;
    rep_rzao = null;
    codigo_marca = null;
    unn_codigo = null;
    unn_descri = null;
    tipo = null;
    tipo_diario_semanal = null;
    venda = null;
    resumo = null;
    tipo_pedido = null;
    ind_aberto_fechado = null;
    cli_antigos = null;
    cb_marca_rep = null;
    abre_unidade = null;
    abre_automaticamente = null;
    mensagem1 = null;
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
      if (com.egen.util.text.Validate.isNull(dia_inicial)) {
        errors.add("dia_inicial", new ActionMessage("error.validate.notnull","Dia Inicial","dia_inicial","0"));
      }
      if (!com.egen.util.text.Validate.isDate(dia_inicial)) {
        errors.add("dia_inicial", new ActionMessage("error.validate.date","Dia Inicial","dia_inicial","0"));
      }
      if (!com.egen.util.text.Validate.isNumber(codigo_regional)) {
        errors.add("codigo_regional", new ActionMessage("error.validate.number","Regional","codigo_regional","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
