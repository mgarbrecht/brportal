package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 30/11/2007 05:31:44
 * Last Modify Date 22/01/2018 14:15:28
 */

public class Sbr0377ActionForm extends org.apache.struts.action.ActionForm
{
  public String tipo_relatorio;
  public String emp_empresa;
  public String emp_razsoc;
  public String data_inicial;
  public String data_final;
  public String ck_pedidos_programados;
  public String fil_filial;
  public String fil_razsoc;
  public String filiais;
  public String linhas;
  public String lin_cdgo;
  public String lin_nome;
  public String abre_automaticamente;
  public String mensagem;
  private boolean valida = false;
  public Sbr0377ActionForm() {
  }
  /**
    * TIPO_RELATORIO: Method to get the field value.
    */
  public String getTipo_relatorio() {
    return tipo_relatorio;
  }
  /**
    * TIPO_RELATORIO: Method to set the field value.
    */
  public void setTipo_relatorio(String PARAM) {
    tipo_relatorio = PARAM;
  }
  Vector tipo_relatorioList = new Vector(10, 1);
  public java.util.Vector getTipo_relatorioList() {
    if (tipo_relatorioList == null || tipo_relatorioList.size() == 0) {
      tipo_relatorioList.addElement("m");
      tipo_relatorioLabelList.addElement("Por Material");
      tipo_relatorioList.addElement("f");
      tipo_relatorioLabelList.addElement("Por Filial");
    }
    java.util.Vector list = tipo_relatorioList;
    return list;
  }
  java.util.Vector tipo_relatorioLabelList = new Vector(10, 1);
  public java.util.Vector getTipo_relatorioLabelList() {
    java.util.Vector list = tipo_relatorioLabelList;
    return list;
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
        String[][] select = {{"emp_razsoc",null}};
        Object[][] where = { {"emp_empresa","like",emp_empresa} };
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

  public String[][] getEmp_razsoc_Ajax(Sbr0377ActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getEmp_empresa() != null && PARAM.getEmp_empresa().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Empresa db_object = new Empresa();
        Object[][] where = { {"emp_empresa","like",PARAM.getEmp_empresa()} };
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
    * DATA_INICIAL: Method to get the field value.
    */
  public String getData_inicial() {
    return data_inicial;
  }
  /**
    * DATA_INICIAL: Method to set the field value.
    */
  public void setData_inicial(String PARAM) {
    data_inicial = PARAM;
  }
  /**
    * DATA_FINAL: Method to get the field value.
    */
  public String getData_final() {
    return data_final;
  }
  /**
    * DATA_FINAL: Method to set the field value.
    */
  public void setData_final(String PARAM) {
    data_final = PARAM;
  }
  /**
    * CK_PEDIDOS_PROGRAMADOS: Method to get the field value.
    */
  public String getCk_pedidos_programados() {
    return ck_pedidos_programados;
  }
  /**
    * CK_PEDIDOS_PROGRAMADOS: Method to set the field value.
    */
  public void setCk_pedidos_programados(String PARAM) {
    ck_pedidos_programados = PARAM;
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
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (emp_empresa != null && emp_empresa.length() > 0 && fil_filial != null && fil_filial.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Filial db_object = new Filial();
        String[][] select = {{"fil_razsoc",null}};
        Object[][] where = { {"emp_empresa","like",emp_empresa}, {"fil_filial","like",fil_filial} };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Filial) results.elementAt(0);
          fil_razsoc = (db_object.getFil_razsoc() != null) ? db_object.getFil_razsoc() + "":"";
        } else {
          fil_razsoc = "";
        }
      }
    } catch (Exception e) {
      fil_razsoc = "";
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return fil_razsoc;
  }

  public String[][] getFil_razsoc_Ajax(Sbr0377ActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getEmp_empresa() != null && PARAM.getEmp_empresa().length() > 0 && PARAM.getFil_filial() != null && PARAM.getFil_filial().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Filial db_object = new Filial();
        Object[][] where = { {"emp_empresa","like",PARAM.getEmp_empresa()}, {"fil_filial","like",PARAM.getFil_filial()} };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Filial) results.elementAt(0);
          list[0] = new String[]{"fil_razsoc", (db_object.getFil_razsoc() != null) ? db_object.getFil_razsoc() + "":""};
        } else {
          list[0] = new String[]{"fil_razsoc", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"fil_razsoc", ""};
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return list;
  }
  /**
    * FIL_RAZSOC: Method to set the field value.
    */
  public void setFil_razsoc(String PARAM) {
    fil_razsoc = PARAM;
  }
  /**
    * FILIAIS: Method to get the field value.
    */
  public String getFiliais() {
    return filiais;
  }
  /**
    * FILIAIS: Method to set the field value.
    */
  public void setFiliais(String PARAM) {
    filiais = PARAM;
  }
  /**
    * LINHAS: Method to get the field value.
    */
  public String getLinhas() {
    return linhas;
  }
  /**
    * LINHAS: Method to set the field value.
    */
  public void setLinhas(String PARAM) {
    linhas = PARAM;
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
        String[][] select = {{"lin_nome",null}};
        Object[][] where = { {"lin_cdgo","=",com.egen.util.text.FormatNumber.toInt(lin_cdgo)} };
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
        j = null;
      }
    }
    return lin_nome;
  }

  public String[][] getLin_nome_Ajax(Sbr0377ActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getLin_cdgo() != null && PARAM.getLin_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Lin db_object = new Lin();
        Object[][] where = { {"lin_cdgo","like",PARAM.getLin_cdgo()} };
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
        j = null;
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
    tipo_relatorio = null;
    emp_empresa = null;
    emp_razsoc = null;
    data_inicial = null;
    data_final = null;
    ck_pedidos_programados = null;
    fil_filial = null;
    fil_razsoc = null;
    filiais = null;
    linhas = null;
    lin_cdgo = null;
    lin_nome = null;
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
      if (com.egen.util.text.Validate.isNull(emp_empresa)) {
        errors.add("emp_empresa", new ActionMessage("error.validate.notnull","Empresa","emp_empresa","0"));
      }
      if (com.egen.util.text.Validate.isNull(data_inicial)) {
        errors.add("data_inicial", new ActionMessage("error.validate.notnull","Data Inicial","data_inicial","0"));
      }
      if (!com.egen.util.text.Validate.isDate(data_inicial)) {
        errors.add("data_inicial", new ActionMessage("error.validate.date","Data Inicial","data_inicial","0"));
      }
      if (com.egen.util.text.Validate.isNull(data_final)) {
        errors.add("data_final", new ActionMessage("error.validate.notnull","Data Final","data_final","0"));
      }
      if (!com.egen.util.text.Validate.isDate(data_final)) {
        errors.add("data_final", new ActionMessage("error.validate.date","Data Final","data_final","0"));
      }
      if (com.egen.util.text.Validate.isNull(lin_cdgo)) {
        errors.add("lin_cdgo", new ActionMessage("error.validate.notnull","Linha","lin_cdgo","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
