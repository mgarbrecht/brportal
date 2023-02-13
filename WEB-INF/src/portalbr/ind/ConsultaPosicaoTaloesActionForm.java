package portalbr.ind;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 25/08/2015 09:23:58
 * Last Modify Date 03/09/2018 12:12:09
 */

public class ConsultaPosicaoTaloesActionForm extends org.apache.struts.action.ActionForm
{
  public String fil_filial;
  public String fil_razsoc;
  public String remessa;
  public String forn_codigo;
  public String fornecedor;
  public String fen_seq;
  public String talao;
  public String processo;
  public String pro_nome;
  public String oc;
  public String lin_cdgo;
  public String dt_envio_inicial;
  public String dt_envio_final;
  private boolean valida = false;
  public ConsultaPosicaoTaloesActionForm() {
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

  public String[][] getFil_razsoc_Ajax(ConsultaPosicaoTaloesActionForm PARAM) {
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
    * REMESSA: Método Gets para este campo
    */
  public String getRemessa() {
    return remessa;
  }
  /**
    * REMESSA: Método Sets pára este campo.
    */
  public void setRemessa(String PARAM) {
    remessa = PARAM;
  }
  /**
    * FORN_CODIGO: Método Gets para este campo
    */
  public String getForn_codigo() {
    return forn_codigo;
  }
  /**
    * FORN_CODIGO: Método Sets pára este campo.
    */
  public void setForn_codigo(String PARAM) {
    forn_codigo = PARAM;
  }
  /**
    * FORNECEDOR: Método Gets para este campo
    */
  public String getFornecedor() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (forn_codigo != null && forn_codigo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Fornecedor db_object = new Fornecedor();
        String[][] select = { {"for_razsoc",null} };
        Object[][] where = { {"for_codigo","=",com.egen.util.text.FormatNumber.toInteger(forn_codigo)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Fornecedor) results.elementAt(0);
          fornecedor = ((db_object.getFor_razsoc() != null) ? db_object.getFor_razsoc() + "":"");
        } else {
          fornecedor = "";
        }
      }
    } catch (Exception e) {
      fornecedor = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return fornecedor;
  }

  public String[][] getFornecedor_Ajax(ConsultaPosicaoTaloesActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getForn_codigo() != null && PARAM.getForn_codigo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Fornecedor db_object = new Fornecedor();
        Object[][] where = { {"for_codigo","like",PARAM.getForn_codigo()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Fornecedor) results.elementAt(0);
          list[0] = new String[]{"fornecedor", ((db_object.getFor_razsoc() != null) ? db_object.getFor_razsoc() + "":"")};
        } else {
          list[0] = new String[]{"fornecedor", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"fornecedor", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * FORNECEDOR: Método Sets pára este campo.
    */
  public void setFornecedor(String PARAM) {
    fornecedor = PARAM;
  }
  /**
    * FEN_SEQ: Método Gets para este campo
    */
  public String getFen_seq() {
    return fen_seq;
  }
  /**
    * FEN_SEQ: Método Sets pára este campo.
    */
  public void setFen_seq(String PARAM) {
    fen_seq = PARAM;
  }
  /**
    * TALAO: Método Gets para este campo
    */
  public String getTalao() {
    return talao;
  }
  /**
    * TALAO: Método Sets pára este campo.
    */
  public void setTalao(String PARAM) {
    talao = PARAM;
  }
  /**
    * PROCESSO: Método Gets para este campo
    */
  public String getProcesso() {
    return processo;
  }
  /**
    * PROCESSO: Método Sets pára este campo.
    */
  public void setProcesso(String PARAM) {
    processo = PARAM;
  }
  /**
    * PRO_NOME: Método Gets para este campo
    */
  public String getPro_nome() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (processo != null && processo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Processo_fab db_object = new Processo_fab();
        String[][] select = { {"pro_nome",null} };
        Object[][] where = { {"pro_numero","=",com.egen.util.text.FormatNumber.toInteger(processo)}, };
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

  public String[][] getPro_nome_Ajax(ConsultaPosicaoTaloesActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getProcesso() != null && PARAM.getProcesso().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Processo_fab db_object = new Processo_fab();
        Object[][] where = { {"pro_numero","like",PARAM.getProcesso()}, };
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
    * OC: Método Gets para este campo
    */
  public String getOc() {
    return oc;
  }
  /**
    * OC: Método Sets pára este campo.
    */
  public void setOc(String PARAM) {
    oc = PARAM;
  }
  /**
    * LIN_CDGO: Método Gets para este campo
    */
  public String getLin_cdgo() {
    return lin_cdgo;
  }
  /**
    * LIN_CDGO: Método Sets pára este campo.
    */
  public void setLin_cdgo(String PARAM) {
    lin_cdgo = PARAM;
  }
  /**
    * DT_ENVIO_INICIAL: Método Gets para este campo
    */
  public String getDt_envio_inicial() {
    return dt_envio_inicial;
  }
  /**
    * DT_ENVIO_INICIAL: Método Sets pára este campo.
    */
  public void setDt_envio_inicial(String PARAM) {
    dt_envio_inicial = PARAM;
  }
  /**
    * DT_ENVIO_FINAL: Método Gets para este campo
    */
  public String getDt_envio_final() {
    return dt_envio_final;
  }
  /**
    * DT_ENVIO_FINAL: Método Sets pára este campo.
    */
  public void setDt_envio_final(String PARAM) {
    dt_envio_final = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    fil_filial = null;
    fil_razsoc = null;
    remessa = null;
    forn_codigo = null;
    fornecedor = null;
    fen_seq = null;
    talao = null;
    processo = null;
    pro_nome = null;
    oc = null;
    lin_cdgo = null;
    dt_envio_inicial = null;
    dt_envio_final = null;
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
