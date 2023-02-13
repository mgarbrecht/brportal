package portalbr.ind;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 31/08/2009 14:45:37
 * Last Modify Date 02/03/2015 17:10:16
 */

public class AtelieresQuarterizados_cActionForm extends org.apache.struts.action.ActionForm
{
  public String fo_codigo;
  public String fo_razsoc;
  public String atelier;
  public String tipo;
  public String fornecedor;
  public String seq;
  public String fornecedor_desc;
  public String pro_codigo;
  public String pro_nome;
  public String codigo_barra;
  public String lido;
  public String fornecedor_codigo;
  public String fornecedor_codigo_quarterizado;
  public String fen_seq_quarterizado;
  public String pro_numero;
  public String rem_nro;
  public String tal_nro;
  public String usuario;
  private boolean valida = false;
  public AtelieresQuarterizados_cActionForm() {
  }
  /**
    * FO_CODIGO: Método Gets para este campo
    */
  public String getFo_codigo() {
    return fo_codigo;
  }
  /**
    * FO_CODIGO: Método Sets pára este campo.
    */
  public void setFo_codigo(String PARAM) {
    fo_codigo = PARAM;
  }
  /**
    * FO_RAZSOC: Método Gets para este campo
    */
  public String getFo_razsoc() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (fo_codigo != null && fo_codigo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Atelier_vw db_object = new Atelier_vw();
        String[][] select = { {"for_razsoc",null} };
        Object[][] where = { {"for_codigo","=",com.egen.util.text.FormatNumber.toInteger(fo_codigo)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Atelier_vw) results.elementAt(0);
          fo_razsoc = ((db_object.getFor_razsoc() != null) ? db_object.getFor_razsoc() + "":"");
        } else {
          fo_razsoc = "";
        }
      }
    } catch (Exception e) {
      fo_razsoc = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return fo_razsoc;
  }

  public String[][] getFo_razsoc_Ajax(AtelieresQuarterizados_cActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getFo_codigo() != null && PARAM.getFo_codigo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Atelier_vw db_object = new Atelier_vw();
        Object[][] where = { {"for_codigo","like",PARAM.getFo_codigo()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Atelier_vw) results.elementAt(0);
          list[0] = new String[]{"fo_razsoc", ((db_object.getFor_razsoc() != null) ? db_object.getFor_razsoc() + "":"")};
        } else {
          list[0] = new String[]{"fo_razsoc", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"fo_razsoc", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * FO_RAZSOC: Método Sets pára este campo.
    */
  public void setFo_razsoc(String PARAM) {
    fo_razsoc = PARAM;
  }
  /**
    * ATELIER: Método Gets para este campo
    */
  public String getAtelier() {
    return atelier;
  }
  /**
    * ATELIER: Método Sets pára este campo.
    */
  public void setAtelier(String PARAM) {
    atelier = PARAM;
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
    * SEQ: Método Gets para este campo
    */
  public String getSeq() {
    return seq;
  }
  /**
    * SEQ: Método Sets pára este campo.
    */
  public void setSeq(String PARAM) {
    seq = PARAM;
  }
  /**
    * FORNECEDOR_DESC: Método Gets para este campo
    */
  public String getFornecedor_desc() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (fornecedor != null && fornecedor.length() > 0 && seq != null && seq.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        For_endere_quarterizado db_object = new For_endere_quarterizado();
        String[][] select = { {"for_razsoc",null} };
        Object[][] where = { {"for_codigo","=", atelier}, {"for_codigo_quarterizado","=",com.egen.util.text.FormatNumber.toInteger(fornecedor)}, {"fen_seq_quarterizado","=",com.egen.util.text.FormatNumber.toInteger(seq)}, };
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


  public String[][] getFornecedor_desc_Ajax(AtelieresQuarterizados_cActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getFornecedor() != null && PARAM.getFornecedor().length() > 0 && PARAM.getSeq() != null && PARAM.getSeq().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        For_endere_quarterizado db_object = new For_endere_quarterizado();
        Object[][] where = { {"for_codigo","like", PARAM.getAtelier()}, {"for_codigo_quarterizado","like",PARAM.getFornecedor()}, {"fen_seq_quarterizado","like",PARAM.getSeq()}, };
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
    * FORNECEDOR_DESC: Método Sets pára este campo.
    */
  public void setFornecedor_desc(String PARAM) {
    fornecedor_desc = PARAM;
  }
  /**
    * PRO_CODIGO: Método Gets para este campo
    */
  public String getPro_codigo() {
    return pro_codigo;
  }
  /**
    * PRO_CODIGO: Método Sets pára este campo.
    */
  public void setPro_codigo(String PARAM) {
    pro_codigo = PARAM;
  }
  /**
    * PRO_NOME: Método Gets para este campo
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

  public String[][] getPro_nome_Ajax(AtelieresQuarterizados_cActionForm PARAM) {
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
    * PRO_NOME: Método Sets pára este campo.
    */
  public void setPro_nome(String PARAM) {
    pro_nome = PARAM;
  }
  /**
    * CODIGO_BARRA: Método Gets para este campo
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

  public String[][] getCodigo_barra_Ajax(AtelieresQuarterizados_cActionForm PARAM) {
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
    * CODIGO_BARRA: Método Sets pára este campo.
    */
  public void setCodigo_barra(String PARAM) {
    codigo_barra = PARAM;
  }
  /**
    * LIDO: Método Gets para este campo
    */
  public String getLido() {
    return lido;
  }
  /**
    * LIDO: Método Sets pára este campo.
    */
  public void setLido(String PARAM) {
    lido = PARAM;
  }
  /**
    * FORNECEDOR_CODIGO: Método Gets para este campo
    */
  public String getFornecedor_codigo() {
    return fornecedor_codigo;
  }
  /**
    * FORNECEDOR_CODIGO: Método Sets pára este campo.
    */
  public void setFornecedor_codigo(String PARAM) {
    fornecedor_codigo = PARAM;
  }
  /**
    * FORNECEDOR_CODIGO_QUARTERIZADO: Método Gets para este campo
    */
  public String getFornecedor_codigo_quarterizado() {
    return fornecedor_codigo_quarterizado;
  }
  /**
    * FORNECEDOR_CODIGO_QUARTERIZADO: Método Sets pára este campo.
    */
  public void setFornecedor_codigo_quarterizado(String PARAM) {
    fornecedor_codigo_quarterizado = PARAM;
  }
  /**
    * FEN_SEQ_QUARTERIZADO: Método Gets para este campo
    */
  public String getFen_seq_quarterizado() {
    return fen_seq_quarterizado;
  }
  /**
    * FEN_SEQ_QUARTERIZADO: Método Sets pára este campo.
    */
  public void setFen_seq_quarterizado(String PARAM) {
    fen_seq_quarterizado = PARAM;
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
    * TAL_NRO: Método Gets para este campo
    */
  public String getTal_nro() {
    return tal_nro;
  }
  /**
    * TAL_NRO: Método Sets pára este campo.
    */
  public void setTal_nro(String PARAM) {
    tal_nro = PARAM;
  }
  /**
    * USUARIO: Método Gets para este campo
    */
  public String getUsuario() {
    return usuario;
  }
  /**
    * USUARIO: Método Sets pára este campo.
    */
  public void setUsuario(String PARAM) {
    usuario = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    fo_codigo = null;
    fo_razsoc = null;
    atelier = null;
    tipo = null;
    fornecedor = null;
    seq = null;
    fornecedor_desc = null;
    pro_codigo = null;
    pro_nome = null;
    codigo_barra = null;
    lido = null;
    fornecedor_codigo = null;
    fornecedor_codigo_quarterizado = null;
    fen_seq_quarterizado = null;
    pro_numero = null;
    rem_nro = null;
    tal_nro = null;
    usuario = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("processa_action,", request)) {
      if (com.egen.util.text.Validate.isNull(tipo)) {
        errors.add("tipo", new ActionMessage("error.validate.notnull","Tipo de Leitura","tipo","0"));
      }
      if (com.egen.util.text.Validate.isNull(fornecedor)) {
        errors.add("fornecedor", new ActionMessage("error.validate.notnull","Fornecedor/Seq.","fornecedor","0"));
      }
      if (com.egen.util.text.Validate.isNull(seq)) {
        errors.add("seq", new ActionMessage("error.validate.notnull","SEQ","seq","0"));
      }
      if (com.egen.util.text.Validate.isNull(pro_codigo)) {
        errors.add("pro_codigo", new ActionMessage("error.validate.notnull","Processo","pro_codigo","0"));
      }
      if (!com.egen.util.text.Validate.isNumber(pro_codigo)) {
        errors.add("pro_codigo", new ActionMessage("error.validate.number","Processo","pro_codigo","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
