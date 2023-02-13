package portalbr.ind;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 02/09/2009 10:14:34
 * Last Modify Date 19/10/2021 17:42:37
 */

public class Pse0053ActionForm extends org.apache.struts.action.ActionForm
{
  public String pro_numero;
  public String pro_nome;
  public String tipo;
  public String fil_filial;
  public String fil_razsoc;
  public String dt_inicial;
  public String hora_inicial;
  public String dt_final;
  public String hora_final;
  public String fornecedor;
  public String fornecedor_desc;
  public String seq_fornec;
  public String resumo;
  private boolean valida = false;
  public Pse0053ActionForm() {
  }
  /**
    * PRO_NUMERO: Método Gets para este campo
    */
  public String getPro_numero() {
    return pro_numero;
  }
  /**
    * PRO_NUMERO: Método Sets pára este campo.
    */
  public void setPro_numero(String PARAM) {
    pro_numero = PARAM;
  }
  /**
    * PRO_NOME: Método Gets para este campo
    */
  public String getPro_nome() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (pro_numero != null && pro_numero.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Processo_fab db_object = new Processo_fab();
        String[][] select = { {"pro_nome",null} };
        Object[][] where = { {"pro_numero","=",com.egen.util.text.FormatNumber.toInteger(pro_numero)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Processo_fab) results.elementAt(0);
          pro_nome = (db_object.getPro_nome() != null) ? db_object.getPro_nome() + "":"";
        } else {
          pro_nome = "";
        }
      }
    } catch (Exception e) {
      pro_nome = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return pro_nome;
  }

  public String[][] getPro_nome_Ajax(Pse0053ActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getPro_numero() != null && PARAM.getPro_numero().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Processo_fab db_object = new Processo_fab();
        Object[][] where = { {"pro_numero","like",PARAM.getPro_numero()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Processo_fab) results.elementAt(0);
          list[0] = new String[]{"pro_nome", (db_object.getPro_nome() != null) ? db_object.getPro_nome() + "":""};
        } else {
          list[0] = new String[]{"pro_nome", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"pro_nome", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * PRO_NOME: Método Sets pára este campo.
    */
  public void setPro_nome(String PARAM) {
    pro_nome = PARAM;
  }
  /**
    * TIPO: Método Gets para este campo
    */
  public String getTipo() {
    return tipo;
  }
  /**
    * TIPO: Método Sets pára este campo.
    */
  public void setTipo(String PARAM) {
    tipo = PARAM;
  }
  Vector tipoList = new Vector(10, 1);
  public java.util.Vector getTipoList() {
    if (tipoList == null || tipoList.size() == 0) {
      tipoList.addElement("E");
      tipoLabelList.addElement("Envio");
      tipoList.addElement("R");
      tipoLabelList.addElement("Retorno");
    }
    java.util.Vector list = tipoList;
    return list;
  }
  java.util.Vector tipoLabelList = new Vector(10, 1);
  public java.util.Vector getTipoLabelList() {
    java.util.Vector list = tipoLabelList;
    return list;
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

  public String[][] getFil_razsoc_Ajax(Pse0053ActionForm PARAM) {
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
    * HORA_INICIAL: Método Gets para este campo
    */
  public String getHora_inicial() {
    return hora_inicial;
  }
  /**
    * HORA_INICIAL: Método Sets pára este campo.
    */
  public void setHora_inicial(String PARAM) {
    hora_inicial = PARAM;
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
    * HORA_FINAL: Método Gets para este campo
    */
  public String getHora_final() {
    return hora_final;
  }
  /**
    * HORA_FINAL: Método Sets pára este campo.
    */
  public void setHora_final(String PARAM) {
    hora_final = PARAM;
  }
  /**
    * FORNECEDOR: Método Gets para este campo
    */
  public String getFornecedor() {
    return fornecedor;
  }
  /**
    * FORNECEDOR: Método Sets pára este campo.
    */
  public void setFornecedor(String PARAM) {
    fornecedor = PARAM;
  }
  /**
    * FORNECEDOR_DESC: Método Gets para este campo
    */
  public String getFornecedor_desc() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (fornecedor != null && fornecedor.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Fornecedor db_object = new Fornecedor();
        String[][] select = { {"for_razsoc",null} };
        Object[][] where = { {"for_codigo","=",com.egen.util.text.FormatNumber.toInteger(fornecedor)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Fornecedor) results.elementAt(0);
          fornecedor_desc = ((db_object.getFor_razsoc() != null) ? db_object.getFor_razsoc() + "":"");
        } else {
          fornecedor_desc = "";
        }
      }
    } catch (Exception e) {
      fornecedor_desc = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return fornecedor_desc;
  }

  public String[][] getFornecedor_desc_Ajax(Pse0053ActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getFornecedor() != null && PARAM.getFornecedor().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Fornecedor db_object = new Fornecedor();
        Object[][] where = { {"for_codigo","like",PARAM.getFornecedor()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Fornecedor) results.elementAt(0);
          list[0] = new String[]{"fornecedor_desc", ((db_object.getFor_razsoc() != null) ? db_object.getFor_razsoc() + "":"")};
        } else {
          list[0] = new String[]{"fornecedor_desc", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"fornecedor_desc", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * FORNECEDOR_DESC: Método Sets pára este campo.
    */
  public void setFornecedor_desc(String PARAM) {
    fornecedor_desc = PARAM;
  }
  /**
    * SEQ_FORNEC: Método Gets para este campo
    */
  public String getSeq_fornec() {
    return seq_fornec;
  }
  /**
    * SEQ_FORNEC: Método Sets pára este campo.
    */
  public void setSeq_fornec(String PARAM) {
    seq_fornec = PARAM;
  }
  /**
    * RESUMO: Método Gets para este campo
    */
  public String getResumo() {
    return resumo;
  }
  /**
    * RESUMO: Método Sets pára este campo.
    */
  public void setResumo(String PARAM) {
    resumo = PARAM;
  }
  Vector resumoList = new Vector(10, 1);
  public java.util.Vector getResumoList() {
    if (resumoList == null || resumoList.size() == 0) {
      resumoList.addElement("N");
      resumoLabelList.addElement("Não");
      resumoList.addElement("S");
      resumoLabelList.addElement("Sim");
    }
    java.util.Vector list = resumoList;
    return list;
  }
  java.util.Vector resumoLabelList = new Vector(10, 1);
  public java.util.Vector getResumoLabelList() {
    java.util.Vector list = resumoLabelList;
    return list;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    pro_numero = null;
    pro_nome = null;
    tipo = null;
    fil_filial = null;
    fil_razsoc = null;
    dt_inicial = null;
    hora_inicial = null;
    dt_final = null;
    hora_final = null;
    fornecedor = null;
    fornecedor_desc = null;
    seq_fornec = null;
    resumo = null;
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
      if (com.egen.util.text.Validate.isNull(tipo)) {
        errors.add("tipo", new ActionMessage("error.validate.notnull","Tipo","tipo","0"));
      }
      if (com.egen.util.text.Validate.isNull(fil_filial)) {
        errors.add("fil_filial", new ActionMessage("error.validate.notnull","Filial","fil_filial","0"));
      }
      if (com.egen.util.text.Validate.isNull(dt_inicial)) {
        errors.add("dt_inicial", new ActionMessage("error.validate.notnull","Data Inicial","dt_inicial","0"));
      }
      if (!com.egen.util.text.Validate.isRegex(dt_inicial, "^([0-2][0-9]|3[0-1])\\/(0[0-9]|1[0-2])\\/[0-9]{4}$")) {
        errors.add("dt_inicial", new ActionMessage("error.validate.regex","Data Inicial","dt_inicial","0"));
      }
      if (com.egen.util.text.Validate.isNull(dt_final)) {
        errors.add("dt_final", new ActionMessage("error.validate.notnull","Data Final","dt_final","0"));
      }
      if (!com.egen.util.text.Validate.isRegex(dt_final, "^([0-2][0-9]|3[0-1])\\/(0[0-9]|1[0-2])\\/[0-9]{4}$")) {
        errors.add("dt_final", new ActionMessage("error.validate.regex","Data Final","dt_final","0"));
      }
      if (com.egen.util.text.Validate.isNull(fornecedor)) {
        errors.add("fornecedor", new ActionMessage("error.validate.notnull","Fornecedor","fornecedor","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
