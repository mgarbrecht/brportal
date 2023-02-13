package portalbr.ind;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 09/08/2013 09:04:27
 * Last Modify Date 22/06/2015 12:58:47
 */

public class AbastecimentoMateriaisActionForm extends org.apache.struts.action.ActionForm
{
  public String fornecedor;
  public String fdesc;
  public String ies_codigo;
  public String item_desc;
  public String cor_cdgo;
  public String cor_desc;
  public String fil_filial;
  public String fil_razsoc;
  public String gpo_mater_cdgo;
  public String gpo_mater_desc;
  public String tipo;
  public String dt_entrega;
  private boolean valida = false;
  public AbastecimentoMateriaisActionForm() {
  }
  /**
    * FORNECEDOR: Method to get the field value.
    */
  public String getFornecedor() {
    return fornecedor;
  }
  /**
    * FORNECEDOR: Method to set the field value.
    */
  public void setFornecedor(String PARAM) {
    fornecedor = PARAM;
  }
  /**
    * FDESC: Method to get the field value.
    */
  public String getFdesc() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (fornecedor != null && fornecedor.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Fornecedor db_object = new Fornecedor();
        String[][] select = { {"for_razsoc",null} };
        Object[][] where = { {"for_codigo","=",com.egen.util.text.FormatNumber.toInteger(fornecedor)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Fornecedor) results.elementAt(0);
          fdesc = ((db_object.getFor_razsoc() != null) ? db_object.getFor_razsoc() + "":"");
        } else {
          fdesc = "";
        }
      }
    } catch (Exception e) {
      fdesc = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return fdesc;
  }

  public String[][] getFdesc_Ajax(AbastecimentoMateriaisActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getFornecedor() != null && PARAM.getFornecedor().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Fornecedor db_object = new Fornecedor();
        Object[][] where = { {"for_codigo","like",PARAM.getFornecedor()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Fornecedor) results.elementAt(0);
          list[0] = new String[]{"fdesc", ((db_object.getFor_razsoc() != null) ? db_object.getFor_razsoc() + "":"")};
        } else {
          list[0] = new String[]{"fdesc", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"fdesc", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * FDESC: Method to set the field value.
    */
  public void setFdesc(String PARAM) {
    fdesc = PARAM;
  }
  /**
    * IES_CODIGO: Method to get the field value.
    */
  public String getIes_codigo() {
    return ies_codigo;
  }
  /**
    * IES_CODIGO: Method to set the field value.
    */
  public void setIes_codigo(String PARAM) {
    ies_codigo = PARAM;
  }
  /**
    * ITEM_DESC: Method to get the field value.
    */
  public String getItem_desc() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (ies_codigo != null && ies_codigo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Dom_item_estoque db_object = new Dom_item_estoque();
        String[][] select = { {"descricao",null} };
        Object[][] where = { {"codigo","=",com.egen.util.text.FormatNumber.toInt(ies_codigo)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Dom_item_estoque) results.elementAt(0);
          item_desc = ((db_object.getDescricao() != null) ? db_object.getDescricao() + "":"");
        } else {
          item_desc = "";
        }
      }
    } catch (Exception e) {
      item_desc = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return item_desc;
  }

  public String[][] getItem_desc_Ajax(AbastecimentoMateriaisActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getIes_codigo() != null && PARAM.getIes_codigo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Dom_item_estoque db_object = new Dom_item_estoque();
        Object[][] where = { {"codigo","=",com.egen.util.text.FormatNumber.toDouble(PARAM.getIes_codigo())}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Dom_item_estoque) results.elementAt(0);
          list[0] = new String[]{"item_desc", ((db_object.getDescricao() != null) ? db_object.getDescricao() + "":"")};
        } else {
          list[0] = new String[]{"item_desc", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"item_desc", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * ITEM_DESC: Method to set the field value.
    */
  public void setItem_desc(String PARAM) {
    item_desc = PARAM;
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

  public String[][] getCor_desc_Ajax(AbastecimentoMateriaisActionForm PARAM) {
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
    return fil_razsoc;
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

  public String[][] getGpo_mater_desc_Ajax(AbastecimentoMateriaisActionForm PARAM) {
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
  /**
    * DT_ENTREGA: Method to get the field value.
    */
  public String getDt_entrega() {
    return dt_entrega;
  }
  /**
    * DT_ENTREGA: Method to set the field value.
    */
  public void setDt_entrega(String PARAM) {
    dt_entrega = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    fornecedor = null;
    fdesc = null;
    ies_codigo = null;
    item_desc = null;
    cor_cdgo = null;
    cor_desc = null;
    fil_filial = null;
    fil_razsoc = null;
    gpo_mater_cdgo = null;
    gpo_mater_desc = null;
    tipo = null;
    dt_entrega = null;
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
      if (com.egen.util.text.Validate.isNull(fornecedor)) {
        errors.add("fornecedor", new ActionMessage("error.validate.notnull","Fornecedor","fornecedor","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
