package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 24/08/2017 10:30:43
 * Last Modify Date 03/02/2021 13:43:21
 */

public class Cli0027ActionForm extends org.apache.struts.action.ActionForm
{
  public String ped_dadg_ini;
  public String ped_dadg_fim;
  public String codigo_marca;
  public String nome_marca;
  public String codigo_regional;
  public String nome_regional;
  public String rep_cdgo;
  public String rep_rzao;
  public String categoria;
  public String rep_situ;
  public String abrirCategoria;
  public String abrirModelo;
  private boolean valida = false;
  public Cli0027ActionForm() {
  }
  /**
    * PED_DADG_INI: Method to get the field value.
    */
  public String getPed_dadg_ini() {
    return ped_dadg_ini;
  }
  /**
    * PED_DADG_INI: Method to set the field value.
    */
  public void setPed_dadg_ini(String PARAM) {
    ped_dadg_ini = PARAM;
  }
  /**
    * PED_DADG_FIM: Method to get the field value.
    */
  public String getPed_dadg_fim() {
    return ped_dadg_fim;
  }
  /**
    * PED_DADG_FIM: Method to set the field value.
    */
  public void setPed_dadg_fim(String PARAM) {
    ped_dadg_fim = PARAM;
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
    * NOME_MARCA: Method to get the field value.
    */
  public String getNome_marca() {
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
          nome_marca = ((db_object.getDescricao_marca() != null) ? db_object.getDescricao_marca() + "":"");
        } else {
          nome_marca = "";
        }
      }
    } catch (Exception e) {
      nome_marca = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return nome_marca;
  }

  public String[][] getNome_marca_Ajax(Cli0027ActionForm PARAM) {
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
          list[0] = new String[]{"nome_marca", ((db_object.getDescricao_marca() != null) ? db_object.getDescricao_marca() + "":"")};
        } else {
          list[0] = new String[]{"nome_marca", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"nome_marca", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * NOME_MARCA: Method to set the field value.
    */
  public void setNome_marca(String PARAM) {
    nome_marca = PARAM;
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
        String[][] select = { {"nome_regional",null} };
        Object[][] where = { {"codigo_regional","=",com.egen.util.text.FormatNumber.toInt(codigo_regional)}, };
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

  public String[][] getNome_regional_Ajax(Cli0027ActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCodigo_regional() != null && PARAM.getCodigo_regional().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Regionais_vendas db_object = new Regionais_vendas();
        Object[][] where = { {"codigo_regional","like",PARAM.getCodigo_regional()}, };
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
    * NOME_REGIONAL: Method to set the field value.
    */
  public void setNome_regional(String PARAM) {
    nome_regional = PARAM;
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

  public String[][] getRep_rzao_Ajax(Cli0027ActionForm PARAM) {
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
    * REP_RZAO: Method to set the field value.
    */
  public void setRep_rzao(String PARAM) {
    rep_rzao = PARAM;
  }
  /**
    * CATEGORIA: Method to get the field value.
    */
  public String getCategoria() {
    return categoria;
  }
  /**
    * CATEGORIA: Method to set the field value.
    */
  public void setCategoria(String PARAM) {
    categoria = PARAM;
  }
  private Vector categoriaList = new Vector(10, 10);
  public void setCategoriaList(java.util.Vector VECTOR) {
    categoriaList = VECTOR;
  }
  public java.util.Vector getCategoriaList() {
    categoriaList = new Vector(10, 10);
    categoriaLabelList = new Vector(10, 10);
    categoriaList.addElement("");
    java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
    categoriaLabelList.addElement(bundle.getString("jsp.pleaseselect"));
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      Cg_ref_codes db_object = new Cg_ref_codes();
      String[][] select = {{"rv_low_value", null},{"rv_meaning", null}};
      Object[][] where = {{"rv_domain","=","IND_ABERTO_FECHADO"},{"rv_low_value","<>","#"}};
      String[] order = {"rv_meaning"};
      String[] groupby = null;
      String[] having = null;
      Vector results = j.select(db_object, select, where, groupby, having, order);
      for (int i = 0; i < results.size(); i++) {
        db_object = (Cg_ref_codes) results.elementAt(i);
        categoriaList.addElement(""+db_object.getRv_low_value());
        categoriaLabelList.addElement(""+db_object.getRv_meaning());
      }
    } catch (Exception e) {
      com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "Cli0027.", e);
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return categoriaList;
  }
  private java.util.Vector categoriaLabelList = new Vector(10, 10);
  public void setCategoriaLabelList(java.util.Vector VECTOR) {
    categoriaLabelList = VECTOR;
  }
  public java.util.Vector getCategoriaLabelList() {
    return categoriaLabelList;
  }
  /**
    * REP_SITU: Method to get the field value.
    */
  public String getRep_situ() {
    return rep_situ;
  }
  /**
    * REP_SITU: Method to set the field value.
    */
  public void setRep_situ(String PARAM) {
    rep_situ = PARAM;
  }
  Vector rep_situList = new Vector(10, 1);
  public java.util.Vector getRep_situList() {
    if (rep_situList == null || rep_situList.size() == 0) {
      rep_situList.addElement("T");
      rep_situLabelList.addElement("Todas");
      rep_situList.addElement("A");
      rep_situLabelList.addElement("Ativo");
      rep_situList.addElement("I");
      rep_situLabelList.addElement("Inativo");
    }
    java.util.Vector list = rep_situList;
    return list;
  }
  java.util.Vector rep_situLabelList = new Vector(10, 1);
  public java.util.Vector getRep_situLabelList() {
    java.util.Vector list = rep_situLabelList;
    return list;
  }
  /**
    * ABRIRCATEGORIA: Method to get the field value.
    */
  public String getAbrirCategoria() {
    return abrirCategoria;
  }
  /**
    * ABRIRCATEGORIA: Method to set the field value.
    */
  public void setAbrirCategoria(String PARAM) {
    abrirCategoria = PARAM;
  }
  /**
    * ABRIRMODELO: Method to get the field value.
    */
  public String getAbrirModelo() {
    return abrirModelo;
  }
  /**
    * ABRIRMODELO: Method to set the field value.
    */
  public void setAbrirModelo(String PARAM) {
    abrirModelo = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    ped_dadg_ini = null;
    ped_dadg_fim = null;
    codigo_marca = null;
    nome_marca = null;
    codigo_regional = null;
    nome_regional = null;
    rep_cdgo = null;
    rep_rzao = null;
    categoria = null;
    rep_situ = null;
    abrirCategoria = null;
    abrirModelo = null;
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
      if (com.egen.util.text.Validate.isNull(ped_dadg_ini)) {
        errors.add("ped_dadg_ini", new ActionMessage("error.validate.notnull","Data Digitação Inicial","ped_dadg_ini","0"));
      }
      if (com.egen.util.text.Validate.isNull(ped_dadg_fim)) {
        errors.add("ped_dadg_fim", new ActionMessage("error.validate.notnull","Data Digitação Final","ped_dadg_fim","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
