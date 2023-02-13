package portalbr.ind;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 02/09/2009 10:14:34
 * Last Modify Date 10/02/2015 13:19:45
 */

public class AtelieresQuarterizados_fActionForm extends org.apache.struts.action.ActionForm
{
  public String atelier;
  public String pro_numero;
  public String pro_nome;
  public String tipo;
  public String dt_inicial;
  public String hora_inicial;
  public String dt_final;
  public String hora_final;
  public String fornecedor;
  public String seq;
  public String fornecedor_desc;
  private boolean valida = false;
  public AtelieresQuarterizados_fActionForm() {
  }
  /**
    * ATELIER: Method to get the field value.
    */
  public String getAtelier() {
    return atelier;
  }
  /**
    * ATELIER: Method to set the field value.
    */
  public void setAtelier(String PARAM) {
    atelier = PARAM;
  }
  /**
    * PRO_NUMERO: Method to get the field value.
    */
  public String getPro_numero() {
    return pro_numero;
  }
  /**
    * PRO_NUMERO: Method to set the field value.
    */
  public void setPro_numero(String PARAM) {
    pro_numero = PARAM;
  }
  /**
    * PRO_NOME: Method to get the field value.
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

  public String[][] getPro_nome_Ajax(AtelieresQuarterizados_fActionForm PARAM) {
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
    * PRO_NOME: Method to set the field value.
    */
  public void setPro_nome(String PARAM) {
    pro_nome = PARAM;
  }
  /**
    * TIPO: Method to get the field value.
    */
  public String getTipo() {
    return tipo;
  }
  /**
    * TIPO: Method to set the field value.
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
    * HORA_INICIAL: Method to get the field value.
    */
  public String getHora_inicial() {
    return hora_inicial;
  }
  /**
    * HORA_INICIAL: Method to set the field value.
    */
  public void setHora_inicial(String PARAM) {
    hora_inicial = PARAM;
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
    * HORA_FINAL: Method to get the field value.
    */
  public String getHora_final() {
    return hora_final;
  }
  /**
    * HORA_FINAL: Method to set the field value.
    */
  public void setHora_final(String PARAM) {
    hora_final = PARAM;
  }
  /**
    * FORNECEDOR: Method to get the field value.
    */
  public String getFornecedor() {
    return fornecedor;
  }
  /**
    * FORNECEDOR: Method to set the field value.
    */
  public void setFornecedor(String PARAM) {
    fornecedor = PARAM;
  }
  /**
    * SEQ: Method to get the field value.
    */
  public String getSeq() {
    return seq;
  }
  /**
    * SEQ: Method to set the field value.
    */
  public void setSeq(String PARAM) {
    seq = PARAM;
  }
  /**
    * FORNECEDOR_DESC: Method to get the field value.
    */
  public String getFornecedor_desc() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (fornecedor != null && fornecedor.length() > 0 && seq != null && seq.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        For_endere_quarterizado db_object = new For_endere_quarterizado();
        String[][] select = { {"for_razsoc",null} };
        Object[][] where = { {"for_codigo","=",com.egen.util.text.FormatNumber.toInteger(atelier)}, {"for_codigo_quarterizado","=",com.egen.util.text.FormatNumber.toInteger(fornecedor)}, {"fen_seq_quarterizado","=",com.egen.util.text.FormatNumber.toInteger(seq)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (For_endere_quarterizado) results.elementAt(0);
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

  public String[][] getFornecedor_desc_Ajax(AtelieresQuarterizados_fActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getFornecedor() != null && PARAM.getFornecedor().length() > 0 && PARAM.getSeq() != null && PARAM.getSeq().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        For_endere_quarterizado db_object = new For_endere_quarterizado();
        Object[][] where = { {"for_codigo","like",PARAM.getAtelier()}, {"for_codigo_quarterizado","like",PARAM.getFornecedor()}, {"fen_seq_quarterizado","like",PARAM.getSeq()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (For_endere_quarterizado) results.elementAt(0);
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
    * FORNECEDOR_DESC: Method to set the field value.
    */
  public void setFornecedor_desc(String PARAM) {
    fornecedor_desc = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    atelier = null;
    pro_numero = null;
    pro_nome = null;
    tipo = null;
    dt_inicial = null;
    hora_inicial = null;
    dt_final = null;
    hora_final = null;
    fornecedor = null;
    seq = null;
    fornecedor_desc = null;
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
      if (com.egen.util.text.Validate.isNull(tipo)) {
        errors.add("tipo", new ActionMessage("error.validate.notnull","Tipo","tipo","0"));
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
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
