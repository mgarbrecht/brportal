package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 30/09/2015 15:38:18
 * Last Modify Date 21/09/2021 13:59:32
 */

public class NecessidadeInsumosActionForm extends org.apache.struts.action.ActionForm
{
  public String forn_codigo;
  public String forn_razsoc;
  public String fil_filial;
  public String fil_razsoc;
  public String gpo_mater_cdgo;
  public String gpo_mater_desc;
  public String codigo_material;
  public String descricao_material;
  public String cor_cdgo;
  public String cor_desc;
  public String numero;
  public String data_inicial;
  public String data_final;
  public String somente_primeiro_nivel;
  private boolean valida = false;
  public NecessidadeInsumosActionForm() {
  }
  /**
    * FORN_CODIGO: Method to get the field value.
    */
  public String getForn_codigo() {
    return forn_codigo;
  }
  /**
    * FORN_CODIGO: Method to set the field value.
    */
  public void setForn_codigo(String PARAM) {
    forn_codigo = PARAM;
  }
  /**
    * FORN_RAZSOC: Method to get the field value.
    */
  public String getForn_razsoc() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (forn_codigo != null && forn_codigo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Fornecedor db_object = new Fornecedor();
        String[][] select = { {"for_razsoc",null} };
        Object[][] where = { {"for_codigo","=",com.egen.util.text.FormatNumber.toInteger(forn_codigo)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Fornecedor) results.elementAt(0);
          forn_razsoc = ((db_object.getFor_razsoc() != null) ? db_object.getFor_razsoc() + "":"");
        } else {
          forn_razsoc = "";
        }
      }
    } catch (Exception e) {
      forn_razsoc = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return forn_razsoc;
  }

  public String[][] getForn_razsoc_Ajax(NecessidadeInsumosActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getForn_codigo() != null && PARAM.getForn_codigo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Fornecedor db_object = new Fornecedor();
        Object[][] where = { {"for_codigo","like",PARAM.getForn_codigo()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Fornecedor) results.elementAt(0);
          list[0] = new String[]{"forn_razsoc", ((db_object.getFor_razsoc() != null) ? db_object.getFor_razsoc() + "":"")};
        } else {
          list[0] = new String[]{"forn_razsoc", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"forn_razsoc", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * FORN_RAZSOC: Method to set the field value.
    */
  public void setForn_razsoc(String PARAM) {
    forn_razsoc = PARAM;
  }
  /**
    * FIL_FILIAL: Method to get the field value.
    */
  public String getFil_filial() {
    return fil_filial;
  }
  /**
    * FIL_FILIAL: Method to set the field value.
    */
  public void setFil_filial(String PARAM) {
    fil_filial = PARAM;
  }
  /**
    * FIL_RAZSOC: Method to get the field value.
    */
  public String getFil_razsoc() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (fil_filial != null && fil_filial.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Filial db_object = new Filial();
        String[][] select = { {"fil_razsoc",null} };
        Object[][] where = { {"fil_filial","like",fil_filial}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Filial) results.elementAt(0);
          fil_razsoc = (db_object.getFil_razsoc() != null) ? db_object.getFil_razsoc() + "":"";
        } else {
          fil_razsoc = "";
        }
      }
    } catch (Exception e) {
      fil_razsoc = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return fil_razsoc;
  }

  public String[][] getFil_razsoc_Ajax(NecessidadeInsumosActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getFil_filial() != null && PARAM.getFil_filial().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Filial db_object = new Filial();
        Object[][] where = { {"fil_filial","like",PARAM.getFil_filial()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Filial) results.elementAt(0);
          list[0] = new String[]{"fil_razsoc", (db_object.getFil_razsoc() != null) ? db_object.getFil_razsoc() + "":""};
        } else {
          list[0] = new String[]{"fil_razsoc", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"fil_razsoc", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * FIL_RAZSOC: Method to set the field value.
    */
  public void setFil_razsoc(String PARAM) {
    fil_razsoc = PARAM;
  }
  /**
    * GPO_MATER_CDGO: Method to get the field value.
    */
  public String getGpo_mater_cdgo() {
    return gpo_mater_cdgo;
  }
  /**
    * GPO_MATER_CDGO: Method to set the field value.
    */
  public void setGpo_mater_cdgo(String PARAM) {
    gpo_mater_cdgo = PARAM;
  }
  /**
    * GPO_MATER_DESC: Method to get the field value.
    */
  public String getGpo_mater_desc() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (gpo_mater_cdgo != null && gpo_mater_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Dom_grupo_material db_object = new Dom_grupo_material();
        String[][] select = { {"gpo_mater_desc",null} };
        Object[][] where = { {"gpo_mater_cdgo","=",com.egen.util.text.FormatNumber.toInteger(gpo_mater_cdgo)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Dom_grupo_material) results.elementAt(0);
          gpo_mater_desc = (db_object.getGpo_mater_desc() != null) ? db_object.getGpo_mater_desc() + "":"";
        } else {
          gpo_mater_desc = "";
        }
      }
    } catch (Exception e) {
      gpo_mater_desc = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return gpo_mater_desc;
  }

  public String[][] getGpo_mater_desc_Ajax(NecessidadeInsumosActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getGpo_mater_cdgo() != null && PARAM.getGpo_mater_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Dom_grupo_material db_object = new Dom_grupo_material();
        Object[][] where = { {"gpo_mater_cdgo","like",PARAM.getGpo_mater_cdgo()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Dom_grupo_material) results.elementAt(0);
          list[0] = new String[]{"gpo_mater_desc", (db_object.getGpo_mater_desc() != null) ? db_object.getGpo_mater_desc() + "":""};
        } else {
          list[0] = new String[]{"gpo_mater_desc", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"gpo_mater_desc", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * GPO_MATER_DESC: Method to set the field value.
    */
  public void setGpo_mater_desc(String PARAM) {
    gpo_mater_desc = PARAM;
  }
  /**
    * CODIGO_MATERIAL: Method to get the field value.
    */
  public String getCodigo_material() {
    return codigo_material;
  }
  /**
    * CODIGO_MATERIAL: Method to set the field value.
    */
  public void setCodigo_material(String PARAM) {
    codigo_material = PARAM;
  }
  /**
    * DESCRICAO_MATERIAL: Method to get the field value.
    */
  public String getDescricao_material() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (codigo_material != null && codigo_material.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Dom_item_estoque db_object = new Dom_item_estoque();
        String[][] select = { {"descricao",null} };
        Object[][] where = { {"codigo","=",com.egen.util.text.FormatNumber.toInt(codigo_material)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Dom_item_estoque) results.elementAt(0);
          descricao_material = ((db_object.getDescricao() != null) ? db_object.getDescricao() + "":"");
        } else {
          descricao_material = "";
        }
      }
    } catch (Exception e) {
      descricao_material = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return descricao_material;
  }

  public String[][] getDescricao_material_Ajax(NecessidadeInsumosActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCodigo_material() != null && PARAM.getCodigo_material().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Dom_item_estoque db_object = new Dom_item_estoque();
        Object[][] where = { {"codigo","=",com.egen.util.text.FormatNumber.toDouble(PARAM.getCodigo_material())}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Dom_item_estoque) results.elementAt(0);
          list[0] = new String[]{"descricao_material", ((db_object.getDescricao() != null) ? db_object.getDescricao() + "":"")};
        } else {
          list[0] = new String[]{"descricao_material", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"descricao_material", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * DESCRICAO_MATERIAL: Method to set the field value.
    */
  public void setDescricao_material(String PARAM) {
    descricao_material = PARAM;
  }
  /**
    * COR_CDGO: Method to get the field value.
    */
  public String getCor_cdgo() {
    return cor_cdgo;
  }
  /**
    * COR_CDGO: Method to set the field value.
    */
  public void setCor_cdgo(String PARAM) {
    cor_cdgo = PARAM;
  }
  /**
    * COR_DESC: Method to get the field value.
    */
  public String getCor_desc() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (cor_cdgo != null && cor_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cor db_object = new Cor();
        String[][] select = { {"cor_desc",null} };
        Object[][] where = { {"cor_cdgo","=",com.egen.util.text.FormatNumber.toInt(cor_cdgo)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Cor) results.elementAt(0);
          cor_desc = (db_object.getCor_desc() != null) ? db_object.getCor_desc() + "":"";
        } else {
          cor_desc = "";
        }
      }
    } catch (Exception e) {
      cor_desc = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return cor_desc;
  }

  public String[][] getCor_desc_Ajax(NecessidadeInsumosActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCor_cdgo() != null && PARAM.getCor_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cor db_object = new Cor();
        Object[][] where = { {"cor_cdgo","like",PARAM.getCor_cdgo()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Cor) results.elementAt(0);
          list[0] = new String[]{"cor_desc", (db_object.getCor_desc() != null) ? db_object.getCor_desc() + "":""};
        } else {
          list[0] = new String[]{"cor_desc", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"cor_desc", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * COR_DESC: Method to set the field value.
    */
  public void setCor_desc(String PARAM) {
    cor_desc = PARAM;
  }
  /**
    * NUMERO: Method to get the field value.
    */
  public String getNumero() {
    return numero;
  }
  /**
    * NUMERO: Method to set the field value.
    */
  public void setNumero(String PARAM) {
    numero = PARAM;
  }
  /**
    * DATA_INICIAL: Method to get the field value.
    */
  public String getData_inicial() {
    return data_inicial;
  }
  /**
    * DATA_INICIAL: Method to set the field value.
    */
  public void setData_inicial(String PARAM) {
    data_inicial = PARAM;
  }
  /**
    * DATA_FINAL: Method to get the field value.
    */
  public String getData_final() {
    return data_final;
  }
  /**
    * DATA_FINAL: Method to set the field value.
    */
  public void setData_final(String PARAM) {
    data_final = PARAM;
  }
  /**
    * SOMENTE_PRIMEIRO_NIVEL: Method to get the field value.
    */
  public String getSomente_primeiro_nivel() {
    return somente_primeiro_nivel;
  }
  /**
    * SOMENTE_PRIMEIRO_NIVEL: Method to set the field value.
    */
  public void setSomente_primeiro_nivel(String PARAM) {
    somente_primeiro_nivel = PARAM;
  }
  Vector somente_primeiro_nivelList = new Vector(10, 1);
  public java.util.Vector getSomente_primeiro_nivelList() {
    if (somente_primeiro_nivelList == null || somente_primeiro_nivelList.size() == 0) {
      somente_primeiro_nivelList.addElement("N");
      somente_primeiro_nivelLabelList.addElement("Não");
      somente_primeiro_nivelList.addElement("S");
      somente_primeiro_nivelLabelList.addElement("Sim");
    }
    java.util.Vector list = somente_primeiro_nivelList;
    return list;
  }
  java.util.Vector somente_primeiro_nivelLabelList = new Vector(10, 1);
  public java.util.Vector getSomente_primeiro_nivelLabelList() {
    java.util.Vector list = somente_primeiro_nivelLabelList;
    return list;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    forn_codigo = null;
    forn_razsoc = null;
    fil_filial = null;
    fil_razsoc = null;
    gpo_mater_cdgo = null;
    gpo_mater_desc = null;
    codigo_material = null;
    descricao_material = null;
    cor_cdgo = null;
    cor_desc = null;
    numero = null;
    data_inicial = null;
    data_final = null;
    somente_primeiro_nivel = null;
  }
  /**
    * Validate fields and return errors.
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
