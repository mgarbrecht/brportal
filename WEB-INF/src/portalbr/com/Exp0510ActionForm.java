package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 25/08/2010 10:28:39
 * Last Modify Date 25/09/2019 20:12:39
 */

public class Exp0510ActionForm extends org.apache.struts.action.ActionForm
{
  public String emp_empresa;
  public String emp_razsoc;
  public String ano_fatura;
  public String nr_fatura;
  public String abrir_numeracao;
  public String amostra;
  public String mostrar_comprimento_interno;
  private boolean valida = false;
  public Exp0510ActionForm() {
  }
  /**
    * EMP_EMPRESA: Method to get the field value.
    */
  public String getEmp_empresa() {
    return emp_empresa;
  }
  /**
    * EMP_EMPRESA: Method to set the field value.
    */
  public void setEmp_empresa(String PARAM) {
    emp_empresa = PARAM;
  }
  /**
    * EMP_RAZSOC: Method to get the field value.
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

  public String[][] getEmp_razsoc_Ajax(Exp0510ActionForm PARAM) {
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
    * EMP_RAZSOC: Method to set the field value.
    */
  public void setEmp_razsoc(String PARAM) {
    emp_razsoc = PARAM;
  }
  /**
    * ANO_FATURA: Method to get the field value.
    */
  public String getAno_fatura() {
    return ano_fatura;
  }
  /**
    * ANO_FATURA: Method to set the field value.
    */
  public void setAno_fatura(String PARAM) {
    ano_fatura = PARAM;
  }
  /**
    * NR_FATURA: Method to get the field value.
    */
  public String getNr_fatura() {
    return nr_fatura;
  }
  /**
    * NR_FATURA: Method to set the field value.
    */
  public void setNr_fatura(String PARAM) {
    nr_fatura = PARAM;
  }
  /**
    * ABRIR_NUMERACAO: Method to get the field value.
    */
  public String getAbrir_numeracao() {
    return abrir_numeracao;
  }
  /**
    * ABRIR_NUMERACAO: Method to set the field value.
    */
  public void setAbrir_numeracao(String PARAM) {
    abrir_numeracao = PARAM;
  }
  Vector abrir_numeracaoList = new Vector(10, 1);
  public java.util.Vector getAbrir_numeracaoList() {
    if (abrir_numeracaoList == null || abrir_numeracaoList.size() == 0) {
      abrir_numeracaoList.addElement("N");
      abrir_numeracaoLabelList.addElement("Não");
      abrir_numeracaoList.addElement("S");
      abrir_numeracaoLabelList.addElement("Sim");
    }
    java.util.Vector list = abrir_numeracaoList;
    return list;
  }
  java.util.Vector abrir_numeracaoLabelList = new Vector(10, 1);
  public java.util.Vector getAbrir_numeracaoLabelList() {
    java.util.Vector list = abrir_numeracaoLabelList;
    return list;
  }
  /**
    * AMOSTRA: Method to get the field value.
    */
  public String getAmostra() {
    return amostra;
  }
  /**
    * AMOSTRA: Method to set the field value.
    */
  public void setAmostra(String PARAM) {
    amostra = PARAM;
  }
  Vector amostraList = new Vector(10, 1);
  public java.util.Vector getAmostraList() {
    if (amostraList == null || amostraList.size() == 0) {
      amostraList.addElement("N");
      amostraLabelList.addElement("Não");
      amostraList.addElement("S");
      amostraLabelList.addElement("Sim");
    }
    java.util.Vector list = amostraList;
    return list;
  }
  java.util.Vector amostraLabelList = new Vector(10, 1);
  public java.util.Vector getAmostraLabelList() {
    java.util.Vector list = amostraLabelList;
    return list;
  }
  /**
    * MOSTRAR_COMPRIMENTO_INTERNO: Method to get the field value.
    */
  public String getMostrar_comprimento_interno() {
    return mostrar_comprimento_interno;
  }
  /**
    * MOSTRAR_COMPRIMENTO_INTERNO: Method to set the field value.
    */
  public void setMostrar_comprimento_interno(String PARAM) {
    mostrar_comprimento_interno = PARAM;
  }
  Vector mostrar_comprimento_internoList = new Vector(10, 1);
  public java.util.Vector getMostrar_comprimento_internoList() {
    if (mostrar_comprimento_internoList == null || mostrar_comprimento_internoList.size() == 0) {
      mostrar_comprimento_internoList.addElement("N");
      mostrar_comprimento_internoLabelList.addElement("Não");
      mostrar_comprimento_internoList.addElement("S");
      mostrar_comprimento_internoLabelList.addElement("Sim");
    }
    java.util.Vector list = mostrar_comprimento_internoList;
    return list;
  }
  java.util.Vector mostrar_comprimento_internoLabelList = new Vector(10, 1);
  public java.util.Vector getMostrar_comprimento_internoLabelList() {
    java.util.Vector list = mostrar_comprimento_internoLabelList;
    return list;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    emp_empresa = null;
    emp_razsoc = null;
    ano_fatura = null;
    nr_fatura = null;
    abrir_numeracao = null;
    amostra = null;
    mostrar_comprimento_interno = null;
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
