package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 19/08/2015 15:21:08
 * Last Modify Date 18/07/2022 16:42:11
 */

public class ArquivosOrdemCompraActionForm extends org.apache.struts.action.ActionForm
{
  public String forn_codigo;
  public String forn_razsoc;
  public String fil_filial;
  public String fil_razsoc;
  public String lin_cdgo;
  public String lin_nome;
  public String gpo_mater_cdgo;
  public String gpo_mater_desc;
  public String oco_numero;
  public String rem_nro;
  public String dt_inicial;
  public String dt_final;
  public String dt_entrega_inicial;
  public String dt_entrega_final;
  public String situacao;
  public String cb_somente_amostra;
  private boolean valida = false;
  public ArquivosOrdemCompraActionForm() {
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
    * FORN_RAZSOC: Método Gets para este campo
    */
  public String getForn_razsoc() {
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
          forn_razsoc = ((db_object.getFor_razsoc() != null) ? db_object.getFor_razsoc() + "":"");
        } else {
          forn_razsoc = "";
        }
      }
    } catch (Exception e) {
      forn_razsoc = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return forn_razsoc;
  }

  public String[][] getForn_razsoc_Ajax(ArquivosOrdemCompraActionForm PARAM) {
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
          list[0] = new String[]{"forn_razsoc", ((db_object.getFor_razsoc() != null) ? db_object.getFor_razsoc() + "":"")};
        } else {
          list[0] = new String[]{"forn_razsoc", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"forn_razsoc", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * FORN_RAZSOC: Método Sets pára este campo.
    */
  public void setForn_razsoc(String PARAM) {
    forn_razsoc = PARAM;
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

  public String[][] getFil_razsoc_Ajax(ArquivosOrdemCompraActionForm PARAM) {
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
    * LIN_NOME: Método Gets para este campo
    */
  public String getLin_nome() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (lin_cdgo != null && lin_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Lin db_object = new Lin();
        String[][] select = { {"lin_nome",null} };
        Object[][] where = { {"lin_cdgo","=",com.egen.util.text.FormatNumber.toInt(lin_cdgo)}, };
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
      }
    }
    return lin_nome;
  }

  public String[][] getLin_nome_Ajax(ArquivosOrdemCompraActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getLin_cdgo() != null && PARAM.getLin_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Lin db_object = new Lin();
        Object[][] where = { {"lin_cdgo","like",PARAM.getLin_cdgo()}, };
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
      }
    }
    return list;
  }
  /**
    * LIN_NOME: Método Sets pára este campo.
    */
  public void setLin_nome(String PARAM) {
    lin_nome = PARAM;
  }
  /**
    * GPO_MATER_CDGO: Método Gets para este campo
    */
  public String getGpo_mater_cdgo() {
    return gpo_mater_cdgo;
  }
  /**
    * GPO_MATER_CDGO: Método Sets pára este campo.
    */
  public void setGpo_mater_cdgo(String PARAM) {
    gpo_mater_cdgo = PARAM;
  }
  /**
    * GPO_MATER_DESC: Método Gets para este campo
    */
  public String getGpo_mater_desc() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (gpo_mater_cdgo != null && gpo_mater_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Dom_grupo_material db_object = new Dom_grupo_material();
        String[][] select = { {"gpo_mater_desc",null} };
        Object[][] where = { {"gpo_mater_cdgo","=",com.egen.util.text.FormatNumber.toInteger(gpo_mater_cdgo)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Dom_grupo_material) results.elementAt(0);
          gpo_mater_desc = (db_object.getGpo_mater_desc() != null) ? db_object.getGpo_mater_desc() + "":"";
        } else {
          gpo_mater_desc = "";
        }
      }
    } catch (Exception e) {
      gpo_mater_desc = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return gpo_mater_desc;
  }

  public String[][] getGpo_mater_desc_Ajax(ArquivosOrdemCompraActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getGpo_mater_cdgo() != null && PARAM.getGpo_mater_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Dom_grupo_material db_object = new Dom_grupo_material();
        Object[][] where = { {"gpo_mater_cdgo","like",PARAM.getGpo_mater_cdgo()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Dom_grupo_material) results.elementAt(0);
          list[0] = new String[]{"gpo_mater_desc", (db_object.getGpo_mater_desc() != null) ? db_object.getGpo_mater_desc() + "":""};
        } else {
          list[0] = new String[]{"gpo_mater_desc", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"gpo_mater_desc", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * GPO_MATER_DESC: Método Sets pára este campo.
    */
  public void setGpo_mater_desc(String PARAM) {
    gpo_mater_desc = PARAM;
  }
  /**
    * OCO_NUMERO: Método Gets para este campo
    */
  public String getOco_numero() {
    return oco_numero;
  }
  /**
    * OCO_NUMERO: Método Sets pára este campo.
    */
  public void setOco_numero(String PARAM) {
    oco_numero = PARAM;
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
    * DT_ENTREGA_INICIAL: Método Gets para este campo
    */
  public String getDt_entrega_inicial() {
    return dt_entrega_inicial;
  }
  /**
    * DT_ENTREGA_INICIAL: Método Sets pára este campo.
    */
  public void setDt_entrega_inicial(String PARAM) {
    dt_entrega_inicial = PARAM;
  }
  /**
    * DT_ENTREGA_FINAL: Método Gets para este campo
    */
  public String getDt_entrega_final() {
    return dt_entrega_final;
  }
  /**
    * DT_ENTREGA_FINAL: Método Sets pára este campo.
    */
  public void setDt_entrega_final(String PARAM) {
    dt_entrega_final = PARAM;
  }
  /**
    * SITUACAO: Método Gets para este campo
    */
  public String getSituacao() {
    return situacao;
  }
  /**
    * SITUACAO: Método Sets pára este campo.
    */
  public void setSituacao(String PARAM) {
    situacao = PARAM;
  }
  Vector situacaoList = new Vector(10, 1);
  public java.util.Vector getSituacaoList() {
    if (situacaoList == null || situacaoList.size() == 0) {
      situacaoList.addElement("");
      situacaoLabelList.addElement("Todas");
      situacaoList.addElement("C");
      situacaoLabelList.addElement("Consultado");
      situacaoList.addElement("G");
      situacaoLabelList.addElement("Gerado");
      situacaoList.addElement("V");
      situacaoLabelList.addElement("Visualizado");
      situacaoList.addElement("P");
      situacaoLabelList.addElement("Publicado");
      situacaoList.addElement("NV");
      situacaoLabelList.addElement("Não Visualizado");
    }
    java.util.Vector list = situacaoList;
    return list;
  }
  java.util.Vector situacaoLabelList = new Vector(10, 1);
  public java.util.Vector getSituacaoLabelList() {
    java.util.Vector list = situacaoLabelList;
    return list;
  }
  /**
    * CB_SOMENTE_AMOSTRA: Método Gets para este campo
    */
  public String getCb_somente_amostra() {
    return cb_somente_amostra;
  }
  /**
    * CB_SOMENTE_AMOSTRA: Método Sets pára este campo.
    */
  public void setCb_somente_amostra(String PARAM) {
    cb_somente_amostra = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    forn_codigo = null;
    forn_razsoc = null;
    fil_filial = null;
    fil_razsoc = null;
    lin_cdgo = null;
    lin_nome = null;
    gpo_mater_cdgo = null;
    gpo_mater_desc = null;
    oco_numero = null;
    rem_nro = null;
    dt_inicial = null;
    dt_final = null;
    dt_entrega_inicial = null;
    dt_entrega_final = null;
    situacao = null;
    cb_somente_amostra = null;
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
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
