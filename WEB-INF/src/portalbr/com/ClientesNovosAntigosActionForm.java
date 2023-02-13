package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 08/05/2009 07:02:11
 * Last Modify Date 22/06/2015 13:22:44
 */

public class ClientesNovosAntigosActionForm extends org.apache.struts.action.ActionForm
{
  public String p_dt_inicial;
  public String p_dt_final;
  public String codigo_marca;
  public String descricao_marca;
  public String reg;
  public String nome_regional;
  public String rep_cdgo;
  public String rep_rzao;
  public String clientes;
  public String cb_quebra_regional;
  public String cb_somente_resumo;
  public String cb_resumo_geral;
  public String cb_resumo_marca;
  public String cb_resumo_regional;
  public String cb_resumo_representante;
  private boolean valida = false;
  public ClientesNovosAntigosActionForm() {
  }
  /**
    * P_DT_INICIAL: Método Gets para este campo
    */
  public String getP_dt_inicial() {
    return p_dt_inicial;
  }
  /**
    * P_DT_INICIAL: Método Sets pára este campo.
    */
  public void setP_dt_inicial(String PARAM) {
    p_dt_inicial = PARAM;
  }
  /**
    * P_DT_FINAL: Método Gets para este campo
    */
  public String getP_dt_final() {
    return p_dt_final;
  }
  /**
    * P_DT_FINAL: Método Sets pára este campo.
    */
  public void setP_dt_final(String PARAM) {
    p_dt_final = PARAM;
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
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (codigo_marca != null && codigo_marca.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Marcas_produtos db_object = new Marcas_produtos();
        String[][] select = { {"descricao_marca",null} };
        Object[][] where = { {"codigo_marca","=",com.egen.util.text.FormatNumber.toInt(codigo_marca)}, };
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
      }
    }
    return descricao_marca;
  }

  public String[][] getDescricao_marca_Ajax(ClientesNovosAntigosActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCodigo_marca() != null && PARAM.getCodigo_marca().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Marcas_produtos db_object = new Marcas_produtos();
        Object[][] where = { {"codigo_marca","like",PARAM.getCodigo_marca()}, };
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
      }
    }
    return list;
  }
  /**
    * DESCRICAO_MARCA: Método Sets pára este campo.
    */
  public void setDescricao_marca(String PARAM) {
    descricao_marca = PARAM;
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
    * NOME_REGIONAL: Método Gets para este campo
    */
  public String getNome_regional() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (reg != null && reg.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Regionais_vendas db_object = new Regionais_vendas();
        String[][] select = { {"nome_regional",null} };
        Object[][] where = { {"codigo_regional","=",com.egen.util.text.FormatNumber.toInt(reg)}, };
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
      }
    }
    return nome_regional;
  }

  public String[][] getNome_regional_Ajax(ClientesNovosAntigosActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getReg() != null && PARAM.getReg().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Regionais_vendas db_object = new Regionais_vendas();
        Object[][] where = { {"codigo_regional","like",PARAM.getReg()}, };
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
      }
    }
    return list;
  }
  /**
    * NOME_REGIONAL: Método Sets pára este campo.
    */
  public void setNome_regional(String PARAM) {
    nome_regional = PARAM;
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
    * REP_RZAO: Método Gets para este campo
    */
  public String getRep_rzao() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (rep_cdgo != null && rep_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Rep db_object = new Rep();
        String[][] select = { {"rep_rzao",null} };
        Object[][] where = { {"rep_cdgo","like",rep_cdgo}, };
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
      }
    }
    return rep_rzao;
  }

  public String[][] getRep_rzao_Ajax(ClientesNovosAntigosActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getRep_cdgo() != null && PARAM.getRep_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Rep db_object = new Rep();
        Object[][] where = { {"rep_cdgo","like",PARAM.getRep_cdgo()}, };
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
      }
    }
    return list;
  }
  /**
    * REP_RZAO: Método Sets pára este campo.
    */
  public void setRep_rzao(String PARAM) {
    rep_rzao = PARAM;
  }
  /**
    * CLIENTES: Método Gets para este campo
    */
  public String getClientes() {
    return clientes;
  }
  /**
    * CLIENTES: Método Sets pára este campo.
    */
  public void setClientes(String PARAM) {
    clientes = PARAM;
  }
  Vector clientesList = new Vector(10, 1);
  public java.util.Vector getClientesList() {
    if (clientesList == null || clientesList.size() == 0) {
      clientesList.addElement("");
      clientesLabelList.addElement("Todos");
      clientesList.addElement("Antigos");
      clientesLabelList.addElement("Antigos");
      clientesList.addElement("Novos");
      clientesLabelList.addElement("Novos");
      clientesList.addElement("Reativados");
      clientesLabelList.addElement("Reativados");
    }
    java.util.Vector list = clientesList;
    return list;
  }
  java.util.Vector clientesLabelList = new Vector(10, 1);
  public java.util.Vector getClientesLabelList() {
    java.util.Vector list = clientesLabelList;
    return list;
  }
  /**
    * CB_QUEBRA_REGIONAL: Método Gets para este campo
    */
  public String getCb_quebra_regional() {
    return cb_quebra_regional;
  }
  /**
    * CB_QUEBRA_REGIONAL: Método Sets pára este campo.
    */
  public void setCb_quebra_regional(String PARAM) {
    cb_quebra_regional = PARAM;
  }
  /**
    * CB_SOMENTE_RESUMO: Método Gets para este campo
    */
  public String getCb_somente_resumo() {
    return cb_somente_resumo;
  }
  /**
    * CB_SOMENTE_RESUMO: Método Sets pára este campo.
    */
  public void setCb_somente_resumo(String PARAM) {
    cb_somente_resumo = PARAM;
  }
  /**
    * CB_RESUMO_GERAL: Método Gets para este campo
    */
  public String getCb_resumo_geral() {
    return cb_resumo_geral;
  }
  /**
    * CB_RESUMO_GERAL: Método Sets pára este campo.
    */
  public void setCb_resumo_geral(String PARAM) {
    cb_resumo_geral = PARAM;
  }
  /**
    * CB_RESUMO_MARCA: Método Gets para este campo
    */
  public String getCb_resumo_marca() {
    return cb_resumo_marca;
  }
  /**
    * CB_RESUMO_MARCA: Método Sets pára este campo.
    */
  public void setCb_resumo_marca(String PARAM) {
    cb_resumo_marca = PARAM;
  }
  /**
    * CB_RESUMO_REGIONAL: Método Gets para este campo
    */
  public String getCb_resumo_regional() {
    return cb_resumo_regional;
  }
  /**
    * CB_RESUMO_REGIONAL: Método Sets pára este campo.
    */
  public void setCb_resumo_regional(String PARAM) {
    cb_resumo_regional = PARAM;
  }
  /**
    * CB_RESUMO_REPRESENTANTE: Método Gets para este campo
    */
  public String getCb_resumo_representante() {
    return cb_resumo_representante;
  }
  /**
    * CB_RESUMO_REPRESENTANTE: Método Sets pára este campo.
    */
  public void setCb_resumo_representante(String PARAM) {
    cb_resumo_representante = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    p_dt_inicial = null;
    p_dt_final = null;
    codigo_marca = null;
    descricao_marca = null;
    reg = null;
    nome_regional = null;
    rep_cdgo = null;
    rep_rzao = null;
    clientes = null;
    cb_quebra_regional = null;
    cb_somente_resumo = null;
    cb_resumo_geral = null;
    cb_resumo_marca = null;
    cb_resumo_regional = null;
    cb_resumo_representante = null;
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
      if (com.egen.util.text.Validate.isNull(p_dt_inicial)) {
        errors.add("p_dt_inicial", new ActionMessage("error.validate.notnull","Data Inicial","p_dt_inicial","0"));
      }
      if (!com.egen.util.text.Validate.isRegex(p_dt_inicial, "^([0-2][0-9]|3[0-1])\\/(0[0-9]|1[0-2])\\/[0-9]{4}$")) {
        errors.add("p_dt_inicial", new ActionMessage("error.validate.regex","Data Inicial","p_dt_inicial","0"));
      }
      if (com.egen.util.text.Validate.isNull(p_dt_final)) {
        errors.add("p_dt_final", new ActionMessage("error.validate.notnull","Data Final","p_dt_final","0"));
      }
      if (!com.egen.util.text.Validate.isRegex(p_dt_final, "^([0-2][0-9]|3[0-1])\\/(0[0-9]|1[0-2])\\/[0-9]{4}$")) {
        errors.add("p_dt_final", new ActionMessage("error.validate.regex","Data Final","p_dt_final","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
