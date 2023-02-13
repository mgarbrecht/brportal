package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 25/08/2010 10:28:39
 * Last Modify Date 25/08/2010 15:38:06
 */

public class Exp0505ActionForm extends org.apache.struts.action.ActionForm
{
  public String emp_empresa;
  public String emp_razsoc;
  public String ano_fatura;
  public String nr_fatura;
  private boolean valida = false;
  public Exp0505ActionForm() {
  }
  /**
    * EMP_EMPRESA: Método Gets para este campo
    */
  public String getEmp_empresa() {
    return emp_empresa;
  }
  /**
    * EMP_EMPRESA: Método Sets pára este campo.
    */
  public void setEmp_empresa(String PARAM) {
    emp_empresa = PARAM;
  }
  /**
    * EMP_RAZSOC: Método Gets para este campo
    */
  public String getEmp_razsoc() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (emp_empresa != null && emp_empresa.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Empresa db_object = new Empresa();
        String[][] select = { {"emp_razsoc",null} };
        Object[][] where = { {"emp_empresa","like",emp_empresa}, };
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
      }
    }
    return emp_razsoc;
  }

  public String[][] getEmp_razsoc_Ajax(Exp0505ActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getEmp_empresa() != null && PARAM.getEmp_empresa().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Empresa db_object = new Empresa();
        Object[][] where = { {"emp_empresa","like",PARAM.getEmp_empresa()}, };
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
      }
    }
    return list;
  }
  /**
    * EMP_RAZSOC: Método Sets pára este campo.
    */
  public void setEmp_razsoc(String PARAM) {
    emp_razsoc = PARAM;
  }
  /**
    * ANO_FATURA: Método Gets para este campo
    */
  public String getAno_fatura() {
    return ano_fatura;
  }
  /**
    * ANO_FATURA: Método Sets pára este campo.
    */
  public void setAno_fatura(String PARAM) {
    ano_fatura = PARAM;
  }
  /**
    * NR_FATURA: Método Gets para este campo
    */
  public String getNr_fatura() {
    return nr_fatura;
  }
  /**
    * NR_FATURA: Método Sets pára este campo.
    */
  public void setNr_fatura(String PARAM) {
    nr_fatura = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    emp_empresa = null;
    emp_razsoc = null;
    ano_fatura = null;
    nr_fatura = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("select_action,", request)) {
      if (com.egen.util.text.Validate.isNull(emp_empresa)) {
        errors.add("emp_empresa", new ActionMessage("error.validate.notnull","Empresa","emp_empresa","0"));
      }
      if (com.egen.util.text.Validate.isNull(ano_fatura)) {
        errors.add("ano_fatura", new ActionMessage("error.validate.notnull","Ano da Fatura","ano_fatura","0"));
      }
      if (!com.egen.util.text.Validate.isNumber(ano_fatura)) {
        errors.add("ano_fatura", new ActionMessage("error.validate.number","Ano da Fatura","ano_fatura","0"));
      }
      if (com.egen.util.text.Validate.isNull(nr_fatura)) {
        errors.add("nr_fatura", new ActionMessage("error.validate.notnull","Nr. da Fatura","nr_fatura","0"));
      }
      if (!com.egen.util.text.Validate.isNumber(nr_fatura)) {
        errors.add("nr_fatura", new ActionMessage("error.validate.number","Nr. da Fatura","nr_fatura","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
