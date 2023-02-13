package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 11/07/2017 11:18:59
 * Last Modify Date 22/08/2017 11:55:27
 */

public class RegistroExportacaoActionForm extends org.apache.struts.action.ActionForm
{
  public String emp_empresa;
  public String emp_razsoc;
  public String fil_filial;
  public String fil_razsoc;
  public String codigo_pessoa;
  public String nome_pessoa;
  public String ano_fatura;
  public String numero_fatura;
  public String nro_drawback;
  public String data_averbacao_inicial;
  public String data_averbacao_final;
  public String data_re_inicial;
  public String data_re_final;
  public String gerar_planilha;
  private boolean valida = false;
  public RegistroExportacaoActionForm() {
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

  public String[][] getEmp_razsoc_Ajax(RegistroExportacaoActionForm PARAM) {
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
      if (fil_filial != null && fil_filial.length() > 0 && emp_empresa != null && emp_empresa.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Filial db_object = new Filial();
        String[][] select = { {"fil_razsoc",null} };
        Object[][] where = { {"fil_filial","like",fil_filial}, {"emp_empresa","like",emp_empresa}, };
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

  public String[][] getFil_razsoc_Ajax(RegistroExportacaoActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getFil_filial() != null && PARAM.getFil_filial().length() > 0) {
        if (PARAM.getEmp_empresa().equals("")) {
          PARAM.setEmp_empresa(null);
        }
        j = new com.egen.util.jdbc.JdbcUtil();
        Filial db_object = new Filial();
        Object[][] where = { {"fil_filial","like",PARAM.getFil_filial()}, {"emp_empresa","like",PARAM.getEmp_empresa()}, };
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
    * CODIGO_PESSOA: Método Gets para este campo
    */
  public String getCodigo_pessoa() {
    return codigo_pessoa;
  }
  /**
    * CODIGO_PESSOA: Método Sets pára este campo.
    */
  public void setCodigo_pessoa(String PARAM) {
    codigo_pessoa = PARAM;
  }
  /**
    * NOME_PESSOA: Método Gets para este campo
    */
  public String getNome_pessoa() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (codigo_pessoa != null && codigo_pessoa.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Jw_despachante db_object = new Jw_despachante();
        String[][] select = { {"nome_pessoa",null} };
        Object[][] where = { {"codigo_pessoa","=",com.egen.util.text.FormatNumber.toInteger(codigo_pessoa)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Jw_despachante) results.elementAt(0);
          nome_pessoa = (db_object.getNome_pessoa() != null) ? db_object.getNome_pessoa() + "":"";
        } else {
          nome_pessoa = "";
        }
      }
    } catch (Exception e) {
      nome_pessoa = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return nome_pessoa;
  }

  public String[][] getNome_pessoa_Ajax(RegistroExportacaoActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCodigo_pessoa() != null && PARAM.getCodigo_pessoa().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Jw_despachante db_object = new Jw_despachante();
        Object[][] where = { {"codigo_pessoa","like",PARAM.getCodigo_pessoa()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Jw_despachante) results.elementAt(0);
          list[0] = new String[]{"nome_pessoa", (db_object.getNome_pessoa() != null) ? db_object.getNome_pessoa() + "":""};
        } else {
          list[0] = new String[]{"nome_pessoa", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"nome_pessoa", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * NOME_PESSOA: Método Sets pára este campo.
    */
  public void setNome_pessoa(String PARAM) {
    nome_pessoa = PARAM;
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
    * NRO_DRAWBACK: Método Gets para este campo
    */
  public String getNro_drawback() {
    return nro_drawback;
  }
  /**
    * NRO_DRAWBACK: Método Sets pára este campo.
    */
  public void setNro_drawback(String PARAM) {
    nro_drawback = PARAM;
  }
  /**
    * DATA_AVERBACAO_INICIAL: Método Gets para este campo
    */
  public String getData_averbacao_inicial() {
    return data_averbacao_inicial;
  }
  /**
    * DATA_AVERBACAO_INICIAL: Método Sets pára este campo.
    */
  public void setData_averbacao_inicial(String PARAM) {
    data_averbacao_inicial = PARAM;
  }
  /**
    * DATA_AVERBACAO_FINAL: Método Gets para este campo
    */
  public String getData_averbacao_final() {
    return data_averbacao_final;
  }
  /**
    * DATA_AVERBACAO_FINAL: Método Sets pára este campo.
    */
  public void setData_averbacao_final(String PARAM) {
    data_averbacao_final = PARAM;
  }
  /**
    * DATA_RE_INICIAL: Método Gets para este campo
    */
  public String getData_re_inicial() {
    return data_re_inicial;
  }
  /**
    * DATA_RE_INICIAL: Método Sets pára este campo.
    */
  public void setData_re_inicial(String PARAM) {
    data_re_inicial = PARAM;
  }
  /**
    * DATA_RE_FINAL: Método Gets para este campo
    */
  public String getData_re_final() {
    return data_re_final;
  }
  /**
    * DATA_RE_FINAL: Método Sets pára este campo.
    */
  public void setData_re_final(String PARAM) {
    data_re_final = PARAM;
  }
  /**
    * GERAR_PLANILHA: Método Gets para este campo
    */
  public String getGerar_planilha() {
    return gerar_planilha;
  }
  /**
    * GERAR_PLANILHA: Método Sets pára este campo.
    */
  public void setGerar_planilha(String PARAM) {
    gerar_planilha = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    emp_empresa = null;
    emp_razsoc = null;
    fil_filial = null;
    fil_razsoc = null;
    codigo_pessoa = null;
    nome_pessoa = null;
    ano_fatura = null;
    numero_fatura = null;
    nro_drawback = null;
    data_averbacao_inicial = null;
    data_averbacao_final = null;
    data_re_inicial = null;
    data_re_final = null;
    gerar_planilha = null;
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
