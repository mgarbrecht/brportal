package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 22/12/2010 14:30:00
 * Last Modify Date 24/07/2021 09:54:33
 */

public class EtiquetasNormasActionForm extends org.apache.struts.action.ActionForm
{
  public String codigo_marca;
  public String descricao_marca;
  public String lin_cdgo;
  public String lin_nome;
  public String insert_norma;
  public String insert_item;
  public String insert_linha;
  public String insert_referencia;
  public String insert_cabedal;
  public String insert_cor;
  private boolean valida = false;
  public EtiquetasNormasActionForm() {
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

  public String[][] getDescricao_marca_Ajax(EtiquetasNormasActionForm PARAM) {
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
    * DESCRICAO_MARCA: Method to set the field value.
    */
  public void setDescricao_marca(String PARAM) {
    descricao_marca = PARAM;
  }
  /**
    * LIN_CDGO: Method to get the field value.
    */
  public String getLin_cdgo() {
    return lin_cdgo;
  }
  /**
    * LIN_CDGO: Method to set the field value.
    */
  public void setLin_cdgo(String PARAM) {
    lin_cdgo = PARAM;
  }
  /**
    * LIN_NOME: Method to get the field value.
    */
  public String getLin_nome() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (lin_cdgo != null && lin_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Lin db_object = new Lin();
        String[][] select = { {"lin_nome",null} };
        Object[][] where = { {"lin_cdgo","=",com.egen.util.text.FormatNumber.toInt(lin_cdgo)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Lin) results.elementAt(0);
          lin_nome = (db_object.getLin_nome() != null) ? db_object.getLin_nome() + "":"";
        } else {
          lin_nome = "";
        }
      }
    } catch (Exception e) {
      lin_nome = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return lin_nome;
  }

  public String[][] getLin_nome_Ajax(EtiquetasNormasActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getLin_cdgo() != null && PARAM.getLin_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Lin db_object = new Lin();
        Object[][] where = { {"lin_cdgo","like",PARAM.getLin_cdgo()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Lin) results.elementAt(0);
          list[0] = new String[]{"lin_nome", (db_object.getLin_nome() != null) ? db_object.getLin_nome() + "":""};
        } else {
          list[0] = new String[]{"lin_nome", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"lin_nome", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * LIN_NOME: Method to set the field value.
    */
  public void setLin_nome(String PARAM) {
    lin_nome = PARAM;
  }
  /**
    * INSERT_NORMA: Method to get the field value.
    */
  public String getInsert_norma() {
    return insert_norma;
  }
  /**
    * INSERT_NORMA: Method to set the field value.
    */
  public void setInsert_norma(String PARAM) {
    insert_norma = PARAM;
  }
  /**
    * INSERT_ITEM: Method to get the field value.
    */
  public String getInsert_item() {
    return insert_item;
  }
  /**
    * INSERT_ITEM: Method to set the field value.
    */
  public void setInsert_item(String PARAM) {
    insert_item = PARAM;
  }
  /**
    * INSERT_LINHA: Method to get the field value.
    */
  public String getInsert_linha() {
    return insert_linha;
  }
  /**
    * INSERT_LINHA: Method to set the field value.
    */
  public void setInsert_linha(String PARAM) {
    insert_linha = PARAM;
  }
  /**
    * INSERT_REFERENCIA: Method to get the field value.
    */
  public String getInsert_referencia() {
    return insert_referencia;
  }
  /**
    * INSERT_REFERENCIA: Method to set the field value.
    */
  public void setInsert_referencia(String PARAM) {
    insert_referencia = PARAM;
  }
  /**
    * INSERT_CABEDAL: Method to get the field value.
    */
  public String getInsert_cabedal() {
    return insert_cabedal;
  }
  /**
    * INSERT_CABEDAL: Method to set the field value.
    */
  public void setInsert_cabedal(String PARAM) {
    insert_cabedal = PARAM;
  }
  /**
    * INSERT_COR: Method to get the field value.
    */
  public String getInsert_cor() {
    return insert_cor;
  }
  /**
    * INSERT_COR: Method to set the field value.
    */
  public void setInsert_cor(String PARAM) {
    insert_cor = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    codigo_marca = null;
    descricao_marca = null;
    lin_cdgo = null;
    lin_nome = null;
    insert_norma = null;
    insert_item = null;
    insert_linha = null;
    insert_referencia = null;
    insert_cabedal = null;
    insert_cor = null;
  }
  /**
    * Validate fields and return errors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("insert_item_action,insert_cor_action,delete_item_action,delete_cor_action,", request)) {
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
