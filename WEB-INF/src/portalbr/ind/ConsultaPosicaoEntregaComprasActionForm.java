package portalbr.ind;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 23/04/2015 07:55:52
 * Last Modify Date 23/02/2016 11:23:36
 */

public class ConsultaPosicaoEntregaComprasActionForm extends org.apache.struts.action.ActionForm
{
  public String ies_codigo;
  public String descricao_item;
  public String dt_entrega_inicial;
  public String dt_entrega_final;
  public String data_compra_inicial;
  public String data_compra_final;
  public String grupos_materiais;
  private boolean valida = false;
  public ConsultaPosicaoEntregaComprasActionForm() {
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
    * DESCRICAO_ITEM: Method to get the field value.
    */
  public String getDescricao_item() {
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
          descricao_item = ((db_object.getDescricao() != null) ? db_object.getDescricao() + "":"");
        } else {
          descricao_item = "";
        }
      }
    } catch (Exception e) {
      descricao_item = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return descricao_item;
  }

  public String[][] getDescricao_item_Ajax(ConsultaPosicaoEntregaComprasActionForm PARAM) {
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
          list[0] = new String[]{"descricao_item", ((db_object.getDescricao() != null) ? db_object.getDescricao() + "":"")};
        } else {
          list[0] = new String[]{"descricao_item", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"descricao_item", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * DESCRICAO_ITEM: Method to set the field value.
    */
  public void setDescricao_item(String PARAM) {
    descricao_item = PARAM;
  }
  /**
    * DT_ENTREGA_INICIAL: Method to get the field value.
    */
  public String getDt_entrega_inicial() {
    return dt_entrega_inicial;
  }
  /**
    * DT_ENTREGA_INICIAL: Method to set the field value.
    */
  public void setDt_entrega_inicial(String PARAM) {
    dt_entrega_inicial = PARAM;
  }
  /**
    * DT_ENTREGA_FINAL: Method to get the field value.
    */
  public String getDt_entrega_final() {
    return dt_entrega_final;
  }
  /**
    * DT_ENTREGA_FINAL: Method to set the field value.
    */
  public void setDt_entrega_final(String PARAM) {
    dt_entrega_final = PARAM;
  }
  /**
    * DATA_COMPRA_INICIAL: Method to get the field value.
    */
  public String getData_compra_inicial() {
    return data_compra_inicial;
  }
  /**
    * DATA_COMPRA_INICIAL: Method to set the field value.
    */
  public void setData_compra_inicial(String PARAM) {
    data_compra_inicial = PARAM;
  }
  /**
    * DATA_COMPRA_FINAL: Method to get the field value.
    */
  public String getData_compra_final() {
    return data_compra_final;
  }
  /**
    * DATA_COMPRA_FINAL: Method to set the field value.
    */
  public void setData_compra_final(String PARAM) {
    data_compra_final = PARAM;
  }
  /**
    * GRUPOS_MATERIAIS: Method to get the field value.
    */
  public String getGrupos_materiais() {
    return grupos_materiais;
  }
  /**
    * GRUPOS_MATERIAIS: Method to set the field value.
    */
  public void setGrupos_materiais(String PARAM) {
    grupos_materiais = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    ies_codigo = null;
    descricao_item = null;
    dt_entrega_inicial = null;
    dt_entrega_final = null;
    data_compra_inicial = null;
    data_compra_final = null;
    grupos_materiais = null;
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
