package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 06/06/2011 14:14:09
 * Last Modify Date 15/06/2011 14:46:50
 */

public class RelatorioPedidosShowRoomActionForm extends org.apache.struts.action.ActionForm
{
  public String id_showroom;
  public String codigo_regional;
  public String nome_regional;
  public String dt_periodo_ini;
  public String dt_periodo_fim;
  private boolean valida = false;
  public RelatorioPedidosShowRoomActionForm() {
  }
  /**
    * ID_SHOWROOM: Method to get the field value.
    */
  public String getId_showroom() {
    return id_showroom;
  }
  /**
    * ID_SHOWROOM: Method to set the field value.
    */
  public void setId_showroom(String PARAM) {
    id_showroom = PARAM;
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

  public String[][] getNome_regional_Ajax(RelatorioPedidosShowRoomActionForm PARAM) {
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
    * DT_PERIODO_INI: Method to get the field value.
    */
  public String getDt_periodo_ini() {
    return dt_periodo_ini;
  }
  /**
    * DT_PERIODO_INI: Method to set the field value.
    */
  public void setDt_periodo_ini(String PARAM) {
    dt_periodo_ini = PARAM;
  }
  /**
    * DT_PERIODO_FIM: Method to get the field value.
    */
  public String getDt_periodo_fim() {
    return dt_periodo_fim;
  }
  /**
    * DT_PERIODO_FIM: Method to set the field value.
    */
  public void setDt_periodo_fim(String PARAM) {
    dt_periodo_fim = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    id_showroom = null;
    codigo_regional = null;
    nome_regional = null;
    dt_periodo_ini = null;
    dt_periodo_fim = null;
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
      if (com.egen.util.text.Validate.isNull(dt_periodo_ini)) {
        errors.add("dt_periodo_ini", new ActionMessage("error.validate.notnull","Data Inicial","dt_periodo_ini","0"));
      }
      if (com.egen.util.text.Validate.isNull(dt_periodo_fim)) {
        errors.add("dt_periodo_fim", new ActionMessage("error.validate.notnull","Data Final","dt_periodo_fim","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
