package portalbr.ind;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 31/08/2009 14:45:37
 * Last Modify Date 25/02/2015 15:25:24
 */

public class Pse0050ActionForm extends org.apache.struts.action.ActionForm
{
  public String tipo;
  public String fornecedor;
  public String fornecedor_desc;
  public String pro_codigo;
  public String pro_nome;
  public String codigo_barra;
  public String lido;
  public String mensagem;
  private boolean valida = false;
  public Pse0050ActionForm() {
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
    * FORNECEDOR_DESC: Method to get the field value.
    */
  public String getFornecedor_desc() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (fornecedor != null && fornecedor.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Jw_fornecedores_atelier db_object = new Jw_fornecedores_atelier();
        String[][] select = { {"usua_nome",null} };
        Object[][] where = { {"usua_usuario","like",fornecedor}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Jw_fornecedores_atelier) results.elementAt(0);
          fornecedor_desc = ((db_object.getUsua_nome() != null) ? db_object.getUsua_nome() + "":"");
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

  public String[][] getFornecedor_desc_Ajax(Pse0050ActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getFornecedor() != null && PARAM.getFornecedor().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Jw_fornecedores_atelier db_object = new Jw_fornecedores_atelier();
        Object[][] where = { {"usua_usuario","like",PARAM.getFornecedor()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Jw_fornecedores_atelier) results.elementAt(0);
          list[0] = new String[]{"fornecedor_desc", ((db_object.getUsua_nome() != null) ? db_object.getUsua_nome() + "":"")};
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
    * PRO_CODIGO: Method to get the field value.
    */
  public String getPro_codigo() {
    return pro_codigo;
  }
  /**
    * PRO_CODIGO: Method to set the field value.
    */
  public void setPro_codigo(String PARAM) {
    pro_codigo = PARAM;
  }
  /**
    * PRO_NOME: Method to get the field value.
    */
  public String getPro_nome() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (pro_codigo != null && pro_codigo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Processo_fab db_object = new Processo_fab();
        String[][] select = { {"pro_nome",null} };
        Object[][] where = { {"pro_numero","=",com.egen.util.text.FormatNumber.toInteger(pro_codigo)}, };
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

  public String[][] getPro_nome_Ajax(Pse0050ActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getPro_codigo() != null && PARAM.getPro_codigo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Processo_fab db_object = new Processo_fab();
        Object[][] where = { {"pro_numero","like",PARAM.getPro_codigo()}, };
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
    * CODIGO_BARRA: Method to get the field value.
    */
  public String getCodigo_barra() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (codigo_barra != null && codigo_barra.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cli db_object = new Cli();
        String[][] select = { {"cli_nome",null} };
        Object[][] where = { {"cla_cdgo","like",codigo_barra}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Cli) results.elementAt(0);
          lido = ((db_object.getCli_nome() != null) ? db_object.getCli_nome() + "":"");
        } else {
          lido = "";
        }
      }
    } catch (Exception e) {
      lido = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return codigo_barra;
  }

  public String[][] getCodigo_barra_Ajax(Pse0050ActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCodigo_barra() != null && PARAM.getCodigo_barra().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cli db_object = new Cli();
        Object[][] where = { {"cla_cdgo","=",com.egen.util.text.FormatDate.parseDate(PARAM.getCodigo_barra(), "dd/MM/yyyy")}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Cli) results.elementAt(0);
          list[0] = new String[]{"lido", ((db_object.getCli_nome() != null) ? db_object.getCli_nome() + "":"")};
        } else {
          list[0] = new String[]{"lido", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"lido", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * CODIGO_BARRA: Method to set the field value.
    */
  public void setCodigo_barra(String PARAM) {
    codigo_barra = PARAM;
  }
  /**
    * LIDO: Method to get the field value.
    */
  public String getLido() {
    return lido;
  }
  /**
    * LIDO: Method to set the field value.
    */
  public void setLido(String PARAM) {
    lido = PARAM;
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
    tipo = null;
    fornecedor = null;
    fornecedor_desc = null;
    pro_codigo = null;
    pro_nome = null;
    codigo_barra = null;
    lido = null;
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
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
