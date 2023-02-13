package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 09/10/2006 15:00:16
 * Last Modify Date 22/06/2015 14:12:12
 */

public class QuantidadePorNCMActionForm extends org.apache.struts.action.ActionForm
{
  public String p_empresa_fatura;
  public String emp_razsoc;
  public String p_ano_fatura;
  public String p_numero_fatura;
  public String abre_automaticamente;
  public String mensagem;
  private boolean valida = false;
  public QuantidadePorNCMActionForm() {
  }
  /**
    * P_EMPRESA_FATURA: Method to get the field value.
    */
  public String getP_empresa_fatura() {
    return p_empresa_fatura;
  }
  /**
    * P_EMPRESA_FATURA: Method to set the field value.
    */
  public void setP_empresa_fatura(String PARAM) {
    p_empresa_fatura = PARAM;
  }
  /**
    * EMP_RAZSOC: Method to get the field value.
    */
  public String getEmp_razsoc() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (p_empresa_fatura != null && p_empresa_fatura.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Empresa db_object = new Empresa();
        String[][] select = {{"emp_razsoc",null}};
        Object[][] where = { {"emp_empresa","like",p_empresa_fatura} };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Empresa) results.elementAt(0);
          emp_razsoc = (db_object.getEmp_razsoc() != null) ? db_object.getEmp_razsoc() + "":"";
        } else {
          emp_razsoc = "";
        }
      }
    } catch (Exception e) {
      emp_razsoc = "";
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return emp_razsoc;
  }

  public String[][] getEmp_razsoc_Ajax(QuantidadePorNCMActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getP_empresa_fatura() != null && PARAM.getP_empresa_fatura().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Empresa db_object = new Empresa();
        Object[][] where = { {"emp_empresa","like",PARAM.getP_empresa_fatura()} };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Empresa) results.elementAt(0);
          list[0] = new String[]{"emp_razsoc", (db_object.getEmp_razsoc() != null) ? db_object.getEmp_razsoc() + "":""};
        } else {
          list[0] = new String[]{"emp_razsoc", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"emp_razsoc", ""};
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return list;
  }
  /**
    * EMP_RAZSOC: Method to set the field value.
    */
  public void setEmp_razsoc(String PARAM) {
    emp_razsoc = PARAM;
  }
  /**
    * P_ANO_FATURA: Method to get the field value.
    */
  public String getP_ano_fatura() {
    return p_ano_fatura;
  }
  /**
    * P_ANO_FATURA: Method to set the field value.
    */
  public void setP_ano_fatura(String PARAM) {
    p_ano_fatura = PARAM;
  }
  /**
    * P_NUMERO_FATURA: Method to get the field value.
    */
  public String getP_numero_fatura() {
    return p_numero_fatura;
  }
  /**
    * P_NUMERO_FATURA: Method to set the field value.
    */
  public void setP_numero_fatura(String PARAM) {
    p_numero_fatura = PARAM;
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
    p_empresa_fatura = null;
    emp_razsoc = null;
    p_ano_fatura = null;
    p_numero_fatura = null;
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
      if (com.egen.util.text.Validate.isNull(p_empresa_fatura)) {
        errors.add("p_empresa_fatura", new ActionMessage("error.validate.notnull","Empresa da Fatura","p_empresa_fatura","0"));
      }
      if (!com.egen.util.text.Validate.isNumber(p_empresa_fatura)) {
        errors.add("p_empresa_fatura", new ActionMessage("error.validate.number","Empresa da Fatura","p_empresa_fatura","0"));
      }
      if (com.egen.util.text.Validate.isNull(p_ano_fatura)) {
        errors.add("p_ano_fatura", new ActionMessage("error.validate.notnull","Ano da Fatura","p_ano_fatura","0"));
      }
      if (!com.egen.util.text.Validate.isNumber(p_ano_fatura)) {
        errors.add("p_ano_fatura", new ActionMessage("error.validate.number","Ano da Fatura","p_ano_fatura","0"));
      }
      if (!com.egen.util.text.Validate.isNumber(p_numero_fatura)) {
        errors.add("p_numero_fatura", new ActionMessage("error.validate.number","Número da Fatura","p_numero_fatura","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
