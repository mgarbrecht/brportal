package portalbr.ind;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 27/05/2014 09:25:51
 * Last Modify Date 30/06/2020 15:48:50
 */

public class ConsultaApontamentoProducaoActionForm extends org.apache.struts.action.ActionForm
{
  public String data_inicial;
  public String hora_inicial;
  public String data_final;
  public String hora_final;
  public String fil_filial;
  public String fil_razsoc;
  public String codigo_marca;
  public String descricao_marca;
  public String codigo_mini_fabrica;
  public String descricao_mini_fabrica;
  public String remessa;
  public String setor;
  public String abrir_remessa;
  public String tipo;
  private boolean valida = false;
  public ConsultaApontamentoProducaoActionForm() {
  }
  /**
    * DATA_INICIAL: Método Gets para este campo
    */
  public String getData_inicial() {
    return data_inicial;
  }
  /**
    * DATA_INICIAL: Método Sets pára este campo.
    */
  public void setData_inicial(String PARAM) {
    data_inicial = PARAM;
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
    * DATA_FINAL: Método Gets para este campo
    */
  public String getData_final() {
    return data_final;
  }
  /**
    * DATA_FINAL: Método Sets pára este campo.
    */
  public void setData_final(String PARAM) {
    data_final = PARAM;
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

  public String[][] getFil_razsoc_Ajax(ConsultaApontamentoProducaoActionForm PARAM) {
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
    * CODIGO_MARCA: Método Gets para este campo
    */
  public String getCodigo_marca() {
    return codigo_marca;
  }
  /**
    * CODIGO_MARCA: Método Sets pára este campo.
    */
  public void setCodigo_marca(String PARAM) {
    codigo_marca = PARAM;
  }
  /**
    * DESCRICAO_MARCA: Método Gets para este campo
    */
  public String getDescricao_marca() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (codigo_marca != null && codigo_marca.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Marcas_produtos db_object = new Marcas_produtos();
        String[][] select = { {"descricao_marca",null} };
        Object[][] where = { {"codigo_marca","=",com.egen.util.text.FormatNumber.toInt(codigo_marca)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Marcas_produtos) results.elementAt(0);
          descricao_marca = (db_object.getDescricao_marca() != null) ? db_object.getDescricao_marca() + "":"";
        } else {
          descricao_marca = "";
        }
      }
    } catch (Exception e) {
      descricao_marca = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return descricao_marca;
  }

  public String[][] getDescricao_marca_Ajax(ConsultaApontamentoProducaoActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCodigo_marca() != null && PARAM.getCodigo_marca().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Marcas_produtos db_object = new Marcas_produtos();
        Object[][] where = { {"codigo_marca","like",PARAM.getCodigo_marca()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Marcas_produtos) results.elementAt(0);
          list[0] = new String[]{"descricao_marca", (db_object.getDescricao_marca() != null) ? db_object.getDescricao_marca() + "":""};
        } else {
          list[0] = new String[]{"descricao_marca", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"descricao_marca", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * DESCRICAO_MARCA: Método Sets pára este campo.
    */
  public void setDescricao_marca(String PARAM) {
    descricao_marca = PARAM;
  }
  /**
    * CODIGO_MINI_FABRICA: Método Gets para este campo
    */
  public String getCodigo_mini_fabrica() {
    return codigo_mini_fabrica;
  }
  /**
    * CODIGO_MINI_FABRICA: Método Sets pára este campo.
    */
  public void setCodigo_mini_fabrica(String PARAM) {
    codigo_mini_fabrica = PARAM;
  }
  /**
    * DESCRICAO_MINI_FABRICA: Método Gets para este campo
    */
  public String getDescricao_mini_fabrica() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (codigo_mini_fabrica != null && codigo_mini_fabrica.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Dom_mini_fabrica db_object = new Dom_mini_fabrica();
        String[][] select = { {"descricao",null} };
        Object[][] where = { {"codigo","=",com.egen.util.text.FormatNumber.toInteger(codigo_mini_fabrica)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Dom_mini_fabrica) results.elementAt(0);
          descricao_mini_fabrica = ((db_object.getDescricao() != null) ? db_object.getDescricao() + "":"");
        } else {
          descricao_mini_fabrica = "";
        }
      }
    } catch (Exception e) {
      descricao_mini_fabrica = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return descricao_mini_fabrica;
  }

  public String[][] getDescricao_mini_fabrica_Ajax(ConsultaApontamentoProducaoActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCodigo_mini_fabrica() != null && PARAM.getCodigo_mini_fabrica().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Dom_mini_fabrica db_object = new Dom_mini_fabrica();
        Object[][] where = { {"codigo","like",PARAM.getCodigo_mini_fabrica()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Dom_mini_fabrica) results.elementAt(0);
          list[0] = new String[]{"descricao_mini_fabrica", ((db_object.getDescricao() != null) ? db_object.getDescricao() + "":"")};
        } else {
          list[0] = new String[]{"descricao_mini_fabrica", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"descricao_mini_fabrica", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * DESCRICAO_MINI_FABRICA: Método Sets pára este campo.
    */
  public void setDescricao_mini_fabrica(String PARAM) {
    descricao_mini_fabrica = PARAM;
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
    * SETOR: Método Gets para este campo
    */
  public String getSetor() {
    return setor;
  }
  /**
    * SETOR: Método Sets pára este campo.
    */
  public void setSetor(String PARAM) {
    setor = PARAM;
  }
  /**
    * ABRIR_REMESSA: Método Gets para este campo
    */
  public String getAbrir_remessa() {
    return abrir_remessa;
  }
  /**
    * ABRIR_REMESSA: Método Sets pára este campo.
    */
  public void setAbrir_remessa(String PARAM) {
    abrir_remessa = PARAM;
  }
  Vector abrir_remessaList = new Vector(10, 1);
  public java.util.Vector getAbrir_remessaList() {
    if (abrir_remessaList == null || abrir_remessaList.size() == 0) {
      abrir_remessaList.addElement("N");
      abrir_remessaLabelList.addElement("Referência");
      abrir_remessaList.addElement("S");
      abrir_remessaLabelList.addElement("Remessa/Talão");
      abrir_remessaList.addElement("R");
      abrir_remessaLabelList.addElement("Remessa");
      abrir_remessaList.addElement("M");
      abrir_remessaLabelList.addElement("Modelo");
    }
    java.util.Vector list = abrir_remessaList;
    return list;
  }
  java.util.Vector abrir_remessaLabelList = new Vector(10, 1);
  public java.util.Vector getAbrir_remessaLabelList() {
    java.util.Vector list = abrir_remessaLabelList;
    return list;
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
      tipoList.addElement("xls");
      tipoLabelList.addElement("XLS");
      tipoList.addElement("Pdf");
      tipoLabelList.addElement("PDF");
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
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    data_inicial = null;
    hora_inicial = null;
    data_final = null;
    hora_final = null;
    fil_filial = null;
    fil_razsoc = null;
    codigo_marca = null;
    descricao_marca = null;
    codigo_mini_fabrica = null;
    descricao_mini_fabrica = null;
    remessa = null;
    setor = null;
    abrir_remessa = null;
    tipo = null;
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
