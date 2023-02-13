package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 18/10/2006 15:09:56
 * Last Modify Date 24/07/2021 11:08:35
 */

public class ComparativoVendasActionForm extends org.apache.struts.action.ActionForm
{
  public String dt_inicial;
  public String dt_final;
  public String codigo_marca;
  public String descricao_marca;
  public String p_clientes;
  public String p_grupos;
  public String abre_automaticamente;
  public String mensagem;
  private boolean valida = false;
  public ComparativoVendasActionForm() {
  }
  /**
    * DT_INICIAL: Method to get the field value.
    */
  public String getDt_inicial() {
    return dt_inicial;
  }
  /**
    * DT_INICIAL: Method to set the field value.
    */
  public void setDt_inicial(String PARAM) {
    dt_inicial = PARAM;
  }
  /**
    * DT_FINAL: Method to get the field value.
    */
  public String getDt_final() {
    return dt_final;
  }
  /**
    * DT_FINAL: Method to set the field value.
    */
  public void setDt_final(String PARAM) {
    dt_final = PARAM;
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
        String[][] select = {{"descricao_marca",null}};
        Object[][] where = { {"codigo_marca","=",com.egen.util.text.FormatNumber.toInt(codigo_marca)} };
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
        j = null;
      }
    }
    return descricao_marca;
  }

  public String[][] getDescricao_marca_Ajax(ComparativoVendasActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCodigo_marca() != null && PARAM.getCodigo_marca().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Marcas_produtos db_object = new Marcas_produtos();
        Object[][] where = { {"codigo_marca","like",PARAM.getCodigo_marca()} };
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
        j = null;
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
    * P_CLIENTES: Method to get the field value.
    */
  public String getP_clientes() {
    return p_clientes;
  }
  /**
    * P_CLIENTES: Method to set the field value.
    */
  public void setP_clientes(String PARAM) {
    p_clientes = PARAM;
  }
  /**
    * P_GRUPOS: Method to get the field value.
    */
  public String getP_grupos() {
    return p_grupos;
  }
  /**
    * P_GRUPOS: Method to set the field value.
    */
  public void setP_grupos(String PARAM) {
    p_grupos = PARAM;
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
    * MENSAGEM: Method to get the field value.
    */
  public String getMensagem() {
    return mensagem;
  }
  /**
    * MENSAGEM: Method to set the field value.
    */
  public void setMensagem(String PARAM) {
    mensagem = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    dt_inicial = null;
    dt_final = null;
    codigo_marca = null;
    descricao_marca = null;
    p_clientes = null;
    p_grupos = null;
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
      if (com.egen.util.text.Validate.isNull(dt_inicial)) {
        errors.add("dt_inicial", new ActionMessage("error.validate.notnull","Data Inicial","dt_inicial","0"));
      }
      if (!com.egen.util.text.Validate.isDate(dt_inicial)) {
        errors.add("dt_inicial", new ActionMessage("error.validate.date","Data Inicial","dt_inicial","0"));
      }
      if (com.egen.util.text.Validate.isNull(dt_final)) {
        errors.add("dt_final", new ActionMessage("error.validate.notnull","Data Final","dt_final","0"));
      }
      if (!com.egen.util.text.Validate.isDate(dt_final)) {
        errors.add("dt_final", new ActionMessage("error.validate.date","Data Final","dt_final","0"));
      }
      if (!com.egen.util.text.Validate.isNumber(codigo_marca)) {
        errors.add("codigo_marca", new ActionMessage("error.validate.number","Marca","codigo_marca","0"));
      }
      if (!com.egen.util.text.Validate.isNull(p_clientes)) {
        if (!com.egen.util.text.Validate.isRegex(p_clientes, "^[0-9,]*$")) {
          errors.add("p_clientes", new ActionMessage("error.validate.regex","Clientes","p_clientes","0"));
        }
      }
      if (!com.egen.util.text.Validate.isNull(p_grupos)) {
        if (!com.egen.util.text.Validate.isRegex(p_grupos, "^[0-9,]*$")) {
          errors.add("p_grupos", new ActionMessage("error.validate.regex","Grupos","p_grupos","0"));
        }
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
