package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 19/03/2015 08:13:35
 * Last Modify Date 18/03/2019 08:56:52
 */

public class NecessidadeMateriaisActionForm extends org.apache.struts.action.ActionForm
{
  public String emp_empresa;
  public String emp_razsoc;
  public String ano_fatura;
  public String numero_fatura;
  public String fil_filial;
  public String fil_razsoc;
  public String dt_inicial;
  public String dt_final;
  public String importados;
  public String dt_inicial_importacao;
  public String dt_final_importacao;
  public String abrir_fatura;
  public String grupos_materiais;
  public String cb_considerar_pp;
  private boolean valida = false;
  public NecessidadeMateriaisActionForm() {
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

  public String[][] getEmp_razsoc_Ajax(NecessidadeMateriaisActionForm PARAM) {
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
    * NUMERO_FATURA: Método Gets para este campo
    */
  public String getNumero_fatura() {
    return numero_fatura;
  }
  /**
    * NUMERO_FATURA: Método Sets pára este campo.
    */
  public void setNumero_fatura(String PARAM) {
    numero_fatura = PARAM;
  }
  /**
    * FIL_FILIAL: Método Gets para este campo
    */
  public String getFil_filial() {
    return fil_filial;
  }
  /**
    * FIL_FILIAL: Método Sets pára este campo.
    */
  public void setFil_filial(String PARAM) {
    fil_filial = PARAM;
  }
  /**
    * FIL_RAZSOC: Método Gets para este campo
    */
  public String getFil_razsoc() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (fil_filial != null && fil_filial.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Filial db_object = new Filial();
        String[][] select = { {"fil_razsoc",null} };
        Object[][] where = { {"fil_filial","like",fil_filial}, };
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
      }
    }
    return fil_razsoc;
  }

  public String[][] getFil_razsoc_Ajax(NecessidadeMateriaisActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getFil_filial() != null && PARAM.getFil_filial().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Filial db_object = new Filial();
        Object[][] where = { {"fil_filial","like",PARAM.getFil_filial()}, };
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
      }
    }
    return list;
  }
  /**
    * FIL_RAZSOC: Método Sets pára este campo.
    */
  public void setFil_razsoc(String PARAM) {
    fil_razsoc = PARAM;
  }
  /**
    * DT_INICIAL: Método Gets para este campo
    */
  public String getDt_inicial() {
    return dt_inicial;
  }
  /**
    * DT_INICIAL: Método Sets pára este campo.
    */
  public void setDt_inicial(String PARAM) {
    dt_inicial = PARAM;
  }
  /**
    * DT_FINAL: Método Gets para este campo
    */
  public String getDt_final() {
    return dt_final;
  }
  /**
    * DT_FINAL: Método Sets pára este campo.
    */
  public void setDt_final(String PARAM) {
    dt_final = PARAM;
  }
  /**
    * IMPORTADOS: Método Gets para este campo
    */
  public String getImportados() {
    return importados;
  }
  /**
    * IMPORTADOS: Método Sets pára este campo.
    */
  public void setImportados(String PARAM) {
    importados = PARAM;
  }
  Vector importadosList = new Vector(10, 1);
  public java.util.Vector getImportadosList() {
    if (importadosList == null || importadosList.size() == 0) {
      importadosList.addElement("S");
      importadosLabelList.addElement("Sim");
      importadosList.addElement("N");
      importadosLabelList.addElement("Não");
    }
    java.util.Vector list = importadosList;
    return list;
  }
  java.util.Vector importadosLabelList = new Vector(10, 1);
  public java.util.Vector getImportadosLabelList() {
    java.util.Vector list = importadosLabelList;
    return list;
  }
  /**
    * DT_INICIAL_IMPORTACAO: Método Gets para este campo
    */
  public String getDt_inicial_importacao() {
    return dt_inicial_importacao;
  }
  /**
    * DT_INICIAL_IMPORTACAO: Método Sets pára este campo.
    */
  public void setDt_inicial_importacao(String PARAM) {
    dt_inicial_importacao = PARAM;
  }
  /**
    * DT_FINAL_IMPORTACAO: Método Gets para este campo
    */
  public String getDt_final_importacao() {
    return dt_final_importacao;
  }
  /**
    * DT_FINAL_IMPORTACAO: Método Sets pára este campo.
    */
  public void setDt_final_importacao(String PARAM) {
    dt_final_importacao = PARAM;
  }
  /**
    * ABRIR_FATURA: Método Gets para este campo
    */
  public String getAbrir_fatura() {
    return abrir_fatura;
  }
  /**
    * ABRIR_FATURA: Método Sets pára este campo.
    */
  public void setAbrir_fatura(String PARAM) {
    abrir_fatura = PARAM;
  }
  Vector abrir_faturaList = new Vector(10, 1);
  public java.util.Vector getAbrir_faturaList() {
    if (abrir_faturaList == null || abrir_faturaList.size() == 0) {
      abrir_faturaList.addElement("N");
      abrir_faturaLabelList.addElement("Não");
      abrir_faturaList.addElement("S");
      abrir_faturaLabelList.addElement("Sim");
    }
    java.util.Vector list = abrir_faturaList;
    return list;
  }
  java.util.Vector abrir_faturaLabelList = new Vector(10, 1);
  public java.util.Vector getAbrir_faturaLabelList() {
    java.util.Vector list = abrir_faturaLabelList;
    return list;
  }
  /**
    * GRUPOS_MATERIAIS: Método Gets para este campo
    */
  public String getGrupos_materiais() {
    return grupos_materiais;
  }
  /**
    * GRUPOS_MATERIAIS: Método Sets pára este campo.
    */
  public void setGrupos_materiais(String PARAM) {
    grupos_materiais = PARAM;
  }
  /**
    * CB_CONSIDERAR_PP: Método Gets para este campo
    */
  public String getCb_considerar_pp() {
    return cb_considerar_pp;
  }
  /**
    * CB_CONSIDERAR_PP: Método Sets pára este campo.
    */
  public void setCb_considerar_pp(String PARAM) {
    cb_considerar_pp = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    emp_empresa = null;
    emp_razsoc = null;
    ano_fatura = null;
    numero_fatura = null;
    fil_filial = null;
    fil_razsoc = null;
    dt_inicial = null;
    dt_final = null;
    importados = null;
    dt_inicial_importacao = null;
    dt_final_importacao = null;
    abrir_fatura = null;
    grupos_materiais = null;
    cb_considerar_pp = null;
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
