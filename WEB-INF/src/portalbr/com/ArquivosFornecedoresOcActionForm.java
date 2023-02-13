package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 23/01/2014 11:05:43
 * Last Modify Date 18/08/2015 12:20:31
 */

public class ArquivosFornecedoresOcActionForm extends org.apache.struts.action.ActionForm
{
  public String forn_codigo;
  public String forn_razsoc;
  public String oco_numero;
  public String rem_nro;
  public String data_inicial;
  public String data_final;
  private boolean valida = false;
  public ArquivosFornecedoresOcActionForm() {
  }
  /**
    * FORN_CODIGO: Método Gets para este campo
    */
  public String getForn_codigo() {
    return forn_codigo;
  }
  /**
    * FORN_CODIGO: Método Sets pára este campo.
    */
  public void setForn_codigo(String PARAM) {
    forn_codigo = PARAM;
  }
  /**
    * FORN_RAZSOC: Método Gets para este campo
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

  public String[][] getForn_razsoc_Ajax(ArquivosFornecedoresOcActionForm PARAM) {
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
    * FORN_RAZSOC: Método Sets pára este campo.
    */
  public void setForn_razsoc(String PARAM) {
    forn_razsoc = PARAM;
  }
  /**
    * OCO_NUMERO: Método Gets para este campo
    */
  public String getOco_numero() {
    return oco_numero;
  }
  /**
    * OCO_NUMERO: Método Sets pára este campo.
    */
  public void setOco_numero(String PARAM) {
    oco_numero = PARAM;
  }
  /**
    * REM_NRO: Método Gets para este campo
    */
  public String getRem_nro() {
    return rem_nro;
  }
  /**
    * REM_NRO: Método Sets pára este campo.
    */
  public void setRem_nro(String PARAM) {
    rem_nro = PARAM;
  }
  /**
    * DATA_INICIAL: Método Gets para este campo
    */
  public String getData_inicial() {
    return data_inicial;
  }
  /**
    * DATA_INICIAL: Método Sets pára este campo.
    */
  public void setData_inicial(String PARAM) {
    data_inicial = PARAM;
  }
  /**
    * DATA_FINAL: Método Gets para este campo
    */
  public String getData_final() {
    return data_final;
  }
  /**
    * DATA_FINAL: Método Sets pára este campo.
    */
  public void setData_final(String PARAM) {
    data_final = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    forn_codigo = null;
    forn_razsoc = null;
    oco_numero = null;
    rem_nro = null;
    data_inicial = null;
    data_final = null;
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
