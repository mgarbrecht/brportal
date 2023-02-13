package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 12/05/2006 14:39:23
 * Last Modify Date 26/02/2008 12:37:58
 */

public class Sbr060ActionForm extends org.apache.struts.action.ActionForm
{
  public String regional;
  public String nome_regional;
  public String pf_ped_dadg_ini;
  public String pf_ped_dadg_fim;
  public String pf_1;
  public String pf_tipo_mercado;
  public String pf_marca_ini;
  public String descricao_marca;
  public String pf_marca_fim;
  public String descricao_marca1;
  public String pf_qtd_linhas;
  public String pf_2;
  public String reg;
  public String abre_automaticamente;
  public String mensagem;
  private boolean valida = false;
  public Sbr060ActionForm() {
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
    * NOME_REGIONAL: Método Gets para este campo
    */
  public String getNome_regional() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (regional != null && regional.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Regionais_vendas db_object = new Regionais_vendas();
        String[][] select = { {"nome_regional",null} };
        Object[][] where = { {"codigo_regional","=",com.egen.util.text.FormatNumber.toInt(regional)}, };
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

  public String[][] getNome_regional_Ajax(Sbr060ActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getRegional() != null && PARAM.getRegional().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Regionais_vendas db_object = new Regionais_vendas();
        Object[][] where = { {"codigo_regional","like",PARAM.getRegional()}, };
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
    * PF_PED_DADG_INI: Método Gets para este campo
    */
  public String getPf_ped_dadg_ini() {
    return pf_ped_dadg_ini;
  }
  /**
    * PF_PED_DADG_INI: Método Sets pára este campo.
    */
  public void setPf_ped_dadg_ini(String PARAM) {
    pf_ped_dadg_ini = PARAM;
  }
  /**
    * PF_PED_DADG_FIM: Método Gets para este campo
    */
  public String getPf_ped_dadg_fim() {
    return pf_ped_dadg_fim;
  }
  /**
    * PF_PED_DADG_FIM: Método Sets pára este campo.
    */
  public void setPf_ped_dadg_fim(String PARAM) {
    pf_ped_dadg_fim = PARAM;
  }
  /**
    * PF_1: Método Gets para este campo
    */
  public String getPf_1() {
    return pf_1;
  }
  /**
    * PF_1: Método Sets pára este campo.
    */
  public void setPf_1(String PARAM) {
    pf_1 = PARAM;
  }
  Vector pf_1List = new Vector(10, 1);
  public java.util.Vector getPf_1List() {
    if (pf_1List == null || pf_1List.size() == 0) {
      pf_1List.addElement("000");
      pf_1LabelList.addElement("Todas");
      pf_1List.addElement("01");
      pf_1LabelList.addElement("01 - Manufaturados");
      pf_1List.addElement("02");
      pf_1LabelList.addElement("02 - Expandidos");
      pf_1List.addElement("03");
      pf_1LabelList.addElement("03 - Injeção direta");
    }
    java.util.Vector list = pf_1List;
    return list;
  }
  java.util.Vector pf_1LabelList = new Vector(10, 1);
  public java.util.Vector getPf_1LabelList() {
    java.util.Vector list = pf_1LabelList;
    return list;
  }
  /**
    * PF_TIPO_MERCADO: Método Gets para este campo
    */
  public String getPf_tipo_mercado() {
    return pf_tipo_mercado;
  }
  /**
    * PF_TIPO_MERCADO: Método Sets pára este campo.
    */
  public void setPf_tipo_mercado(String PARAM) {
    pf_tipo_mercado = PARAM;
  }
  Vector pf_tipo_mercadoList = new Vector(10, 1);
  public java.util.Vector getPf_tipo_mercadoList() {
    if (pf_tipo_mercadoList == null || pf_tipo_mercadoList.size() == 0) {
      pf_tipo_mercadoList.addElement("MI");
      pf_tipo_mercadoLabelList.addElement("MI");
      pf_tipo_mercadoList.addElement("ME");
      pf_tipo_mercadoLabelList.addElement("ME");
      pf_tipo_mercadoList.addElement("Todos");
      pf_tipo_mercadoLabelList.addElement("Todos");
    }
    java.util.Vector list = pf_tipo_mercadoList;
    return list;
  }
  java.util.Vector pf_tipo_mercadoLabelList = new Vector(10, 1);
  public java.util.Vector getPf_tipo_mercadoLabelList() {
    java.util.Vector list = pf_tipo_mercadoLabelList;
    return list;
  }
  /**
    * PF_MARCA_INI: Método Gets para este campo
    */
  public String getPf_marca_ini() {
    return pf_marca_ini;
  }
  /**
    * PF_MARCA_INI: Método Sets pára este campo.
    */
  public void setPf_marca_ini(String PARAM) {
    pf_marca_ini = PARAM;
  }
  /**
    * DESCRICAO_MARCA: Método Gets para este campo
    */
  public String getDescricao_marca() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (pf_marca_ini != null && pf_marca_ini.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Marcas_produtos db_object = new Marcas_produtos();
        String[][] select = { {"descricao_marca",null} };
        Object[][] where = { {"codigo_marca","=",com.egen.util.text.FormatNumber.toInt(pf_marca_ini)}, };
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

  public String[][] getDescricao_marca_Ajax(Sbr060ActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getPf_marca_ini() != null && PARAM.getPf_marca_ini().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Marcas_produtos db_object = new Marcas_produtos();
        Object[][] where = { {"codigo_marca","like",PARAM.getPf_marca_ini()}, };
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
    * PF_MARCA_FIM: Método Gets para este campo
    */
  public String getPf_marca_fim() {
    return pf_marca_fim;
  }
  /**
    * PF_MARCA_FIM: Método Sets pára este campo.
    */
  public void setPf_marca_fim(String PARAM) {
    pf_marca_fim = PARAM;
  }
  /**
    * DESCRICAO_MARCA1: Método Gets para este campo
    */
  public String getDescricao_marca1() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (pf_marca_fim != null && pf_marca_fim.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Marcas_produtos db_object = new Marcas_produtos();
        String[][] select = { {"descricao_marca",null} };
        Object[][] where = { {"codigo_marca","=",com.egen.util.text.FormatNumber.toInt(pf_marca_fim)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Marcas_produtos) results.elementAt(0);
          descricao_marca1 = ((db_object.getDescricao_marca() != null) ? db_object.getDescricao_marca() + "":"");
        } else {
          descricao_marca1 = "";
        }
      }
    } catch (Exception e) {
      descricao_marca1 = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return descricao_marca1;
  }

  public String[][] getDescricao_marca1_Ajax(Sbr060ActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getPf_marca_fim() != null && PARAM.getPf_marca_fim().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Marcas_produtos db_object = new Marcas_produtos();
        Object[][] where = { {"codigo_marca","like",PARAM.getPf_marca_fim()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Marcas_produtos) results.elementAt(0);
          list[0] = new String[]{"descricao_marca1", ((db_object.getDescricao_marca() != null) ? db_object.getDescricao_marca() + "":"")};
        } else {
          list[0] = new String[]{"descricao_marca1", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"descricao_marca1", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * DESCRICAO_MARCA1: Método Sets pára este campo.
    */
  public void setDescricao_marca1(String PARAM) {
    descricao_marca1 = PARAM;
  }
  /**
    * PF_QTD_LINHAS: Método Gets para este campo
    */
  public String getPf_qtd_linhas() {
    return pf_qtd_linhas;
  }
  /**
    * PF_QTD_LINHAS: Método Sets pára este campo.
    */
  public void setPf_qtd_linhas(String PARAM) {
    pf_qtd_linhas = PARAM;
  }
  /**
    * PF_2: Método Gets para este campo
    */
  public String getPf_2() {
    return pf_2;
  }
  /**
    * PF_2: Método Sets pára este campo.
    */
  public void setPf_2(String PARAM) {
    pf_2 = PARAM;
  }
  Vector pf_2List = new Vector(10, 1);
  public java.util.Vector getPf_2List() {
    if (pf_2List == null || pf_2List.size() == 0) {
      pf_2List.addElement("S");
      pf_2LabelList.addElement("Sim");
      pf_2List.addElement("N");
      pf_2LabelList.addElement("Não");
    }
    java.util.Vector list = pf_2List;
    return list;
  }
  java.util.Vector pf_2LabelList = new Vector(10, 1);
  public java.util.Vector getPf_2LabelList() {
    java.util.Vector list = pf_2LabelList;
    return list;
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
    * ABRE_AUTOMATICAMENTE: Método Gets para este campo
    */
  public String getAbre_automaticamente() {
    return abre_automaticamente;
  }
  /**
    * ABRE_AUTOMATICAMENTE: Método Sets pára este campo.
    */
  public void setAbre_automaticamente(String PARAM) {
    abre_automaticamente = PARAM;
  }
  /**
    * MENSAGEM: Método Gets para este campo
    */
  public String getMensagem() {
    return mensagem;
  }
  /**
    * MENSAGEM: Método Sets pára este campo.
    */
  public void setMensagem(String PARAM) {
    mensagem = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    regional = null;
    nome_regional = null;
    pf_ped_dadg_ini = null;
    pf_ped_dadg_fim = null;
    pf_1 = null;
    pf_tipo_mercado = null;
    pf_marca_ini = null;
    descricao_marca = null;
    pf_marca_fim = null;
    descricao_marca1 = null;
    pf_qtd_linhas = null;
    pf_2 = null;
    reg = null;
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
      if ((com.egen.util.text.Validate.isNull(regional))&&(com.egen.util.text.Validate.isNull(reg))) {
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.validate.notnull","Regional","regional","0"));
      }
      if (com.egen.util.text.Validate.isNull(pf_ped_dadg_ini)) {
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.validate.notnull","Data Inicial","pf_ped_dadg_ini","0"));
      }
      if (!com.egen.util.text.Validate.isDate(pf_ped_dadg_ini)) {
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.validate.date","Data Inicial","pf_ped_dadg_ini","0"));
      }
      if (com.egen.util.text.Validate.isNull(pf_ped_dadg_fim)) {
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.validate.notnull","Data Final","pf_ped_dadg_fim","0"));
      }
      if (!com.egen.util.text.Validate.isDate(pf_ped_dadg_fim)) {
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.validate.date","Data Final","pf_ped_dadg_fim","0"));
      }
      if (com.egen.util.text.Validate.isNull(pf_marca_ini)) {
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.validate.notnull","Marca Inicial","pf_marca_ini","0"));
      }
      if (!com.egen.util.text.Validate.isNumber(pf_marca_ini)) {
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.validate.number","Marca Inicial","pf_marca_ini","0"));
      }
      if (com.egen.util.text.Validate.isNull(pf_marca_fim)) {
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.validate.notnull","Marca Final","pf_marca_fim","0"));
      }
      if (!com.egen.util.text.Validate.isNumber(pf_marca_fim)) {
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.validate.number","Marca Final","pf_marca_fim","0"));
      }
      if (com.egen.util.text.Validate.isNull(pf_qtd_linhas)) {
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.validate.notnull","Quantidade de linhas mais vendidas","pf_qtd_linhas","0"));
      }
      if (!com.egen.util.text.Validate.isNumber(pf_qtd_linhas)) {
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.validate.number","Quantidade de linhas mais vendidas","pf_qtd_linhas","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}

