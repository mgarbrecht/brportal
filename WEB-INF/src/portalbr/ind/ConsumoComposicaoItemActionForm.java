package portalbr.ind;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 11/08/2017 14:36:32
 * Last Modify Date 17/08/2017 10:07:06
 */

public class ConsumoComposicaoItemActionForm extends org.apache.struts.action.ActionForm
{
  public String codigo;
  public String descricao;
  public String cor_cdgo;
  public String cor_desc;
  public String material;
  public String descricao_material;
  private boolean valida = false;
  public ConsumoComposicaoItemActionForm() {
  }
  /**
    * CODIGO: Método Gets para este campo
    */
  public String getCodigo() {
    return codigo;
  }
  /**
    * CODIGO: Método Sets pára este campo.
    */
  public void setCodigo(String PARAM) {
    codigo = PARAM;
  }
  /**
    * DESCRICAO: Método Gets para este campo
    */
  public String getDescricao() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (codigo != null && codigo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Dom_item_estoque db_object = new Dom_item_estoque();
        String[][] select = { {"descricao",null} };
        Object[][] where = { {"codigo","=",com.egen.util.text.FormatNumber.toInt(codigo)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Dom_item_estoque) results.elementAt(0);
          descricao = (db_object.getDescricao() != null) ? db_object.getDescricao() + "":"";
        } else {
          descricao = "";
        }
      }
    } catch (Exception e) {
      descricao = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return descricao;
  }

  public String[][] getDescricao_Ajax(ConsumoComposicaoItemActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCodigo() != null && PARAM.getCodigo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Dom_item_estoque db_object = new Dom_item_estoque();
        Object[][] where = { {"codigo","=",com.egen.util.text.FormatNumber.toDouble(PARAM.getCodigo())}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Dom_item_estoque) results.elementAt(0);
          list[0] = new String[]{"descricao", (db_object.getDescricao() != null) ? db_object.getDescricao() + "":""};
        } else {
          list[0] = new String[]{"descricao", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"descricao", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * DESCRICAO: Método Sets pára este campo.
    */
  public void setDescricao(String PARAM) {
    descricao = PARAM;
  }
  /**
    * COR_CDGO: Método Gets para este campo
    */
  public String getCor_cdgo() {
    return cor_cdgo;
  }
  /**
    * COR_CDGO: Método Sets pára este campo.
    */
  public void setCor_cdgo(String PARAM) {
    cor_cdgo = PARAM;
  }
  /**
    * COR_DESC: Método Gets para este campo
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

  public String[][] getCor_desc_Ajax(ConsumoComposicaoItemActionForm PARAM) {
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
    * COR_DESC: Método Sets pára este campo.
    */
  public void setCor_desc(String PARAM) {
    cor_desc = PARAM;
  }
  /**
    * MATERIAL: Método Gets para este campo
    */
  public String getMaterial() {
    return material;
  }
  /**
    * MATERIAL: Método Sets pára este campo.
    */
  public void setMaterial(String PARAM) {
    material = PARAM;
  }
  /**
    * DESCRICAO_MATERIAL: Método Gets para este campo
    */
  public String getDescricao_material() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (material != null && material.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Dom_item_estoque db_object = new Dom_item_estoque();
        String[][] select = { {"descricao",null} };
        Object[][] where = { {"codigo","=",com.egen.util.text.FormatNumber.toInt(material)}, };
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

  public String[][] getDescricao_material_Ajax(ConsumoComposicaoItemActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getMaterial() != null && PARAM.getMaterial().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Dom_item_estoque db_object = new Dom_item_estoque();
        Object[][] where = { {"codigo","=",com.egen.util.text.FormatNumber.toDouble(PARAM.getMaterial())}, };
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
    * DESCRICAO_MATERIAL: Método Sets pára este campo.
    */
  public void setDescricao_material(String PARAM) {
    descricao_material = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    codigo = null;
    descricao = null;
    cor_cdgo = null;
    cor_desc = null;
    material = null;
    descricao_material = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
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
