package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 24/09/2015 11:08:07
 * Last Modify Date 07/07/2022 17:32:11
 */

public class Sbr0101ActionForm extends org.apache.struts.action.ActionForm
{
  public String periodo;
  public String abertura;
  public String tipo_mercado;
  public String codigo_regional;
  public String nome_regional;
  public String rep_cdgo;
  public String rep_rzao;
  public String cli_cdgo;
  public String cli_rzao;
  public String pais;
  public String abre_marca;
  public String cb_somente_pp;
  public String objetivo;
  public String visao;
  private boolean valida = false;
  public Sbr0101ActionForm() {
  }
  /**
    * PERIODO: Método Gets para este campo
    */
  public String getPeriodo() {
    return periodo;
  }
  /**
    * PERIODO: Método Sets pára este campo.
    */
  public void setPeriodo(String PARAM) {
    periodo = PARAM;
  }
  /**
    * ABERTURA: Método Gets para este campo
    */
  public String getAbertura() {
    return abertura;
  }
  /**
    * ABERTURA: Método Sets pára este campo.
    */
  public void setAbertura(String PARAM) {
    abertura = PARAM;
  }
  Vector aberturaList = new Vector(10, 1);
  public java.util.Vector getAberturaList() {
    if (aberturaList == null || aberturaList.size() == 0) {
      aberturaList.addElement("REG");
      aberturaLabelList.addElement("Regional");
      aberturaList.addElement("REP");
      aberturaLabelList.addElement("ERCs");
    }
    java.util.Vector list = aberturaList;
    return list;
  }
  java.util.Vector aberturaLabelList = new Vector(10, 1);
  public java.util.Vector getAberturaLabelList() {
    java.util.Vector list = aberturaLabelList;
    return list;
  }
  /**
    * TIPO_MERCADO: Método Gets para este campo
    */
  public String getTipo_mercado() {
    return tipo_mercado;
  }
  /**
    * TIPO_MERCADO: Método Sets pára este campo.
    */
  public void setTipo_mercado(String PARAM) {
    tipo_mercado = PARAM;
  }
  /**
    * CODIGO_REGIONAL: Método Gets para este campo
    */
  public String getCodigo_regional() {
    return codigo_regional;
  }
  /**
    * CODIGO_REGIONAL: Método Sets pára este campo.
    */
  public void setCodigo_regional(String PARAM) {
    codigo_regional = PARAM;
  }
  /**
    * NOME_REGIONAL: Método Gets para este campo
    */
  public String getNome_regional() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (codigo_regional != null && codigo_regional.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Regionais_vendas db_object = new Regionais_vendas();
        String[][] select = { {"nome_regional",null} };
        Object[][] where = { {"codigo_regional","=",com.egen.util.text.FormatNumber.toInt(codigo_regional)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Regionais_vendas) results.elementAt(0);
          nome_regional = (db_object.getNome_regional() != null) ? db_object.getNome_regional() + "":"";
        } else {
          nome_regional = "";
        }
      }
    } catch (Exception e) {
      nome_regional = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return nome_regional;
  }

  public String[][] getNome_regional_Ajax(Sbr0101ActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCodigo_regional() != null && PARAM.getCodigo_regional().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Regionais_vendas db_object = new Regionais_vendas();
        Object[][] where = { {"codigo_regional","like",PARAM.getCodigo_regional()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Regionais_vendas) results.elementAt(0);
          list[0] = new String[]{"nome_regional", (db_object.getNome_regional() != null) ? db_object.getNome_regional() + "":""};
        } else {
          list[0] = new String[]{"nome_regional", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"nome_regional", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * NOME_REGIONAL: Método Sets pára este campo.
    */
  public void setNome_regional(String PARAM) {
    nome_regional = PARAM;
  }
  /**
    * REP_CDGO: Método Gets para este campo
    */
  public String getRep_cdgo() {
    return rep_cdgo;
  }
  /**
    * REP_CDGO: Método Sets pára este campo.
    */
  public void setRep_cdgo(String PARAM) {
    rep_cdgo = PARAM;
  }
  /**
    * REP_RZAO: Método Gets para este campo
    */
  public String getRep_rzao() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (rep_cdgo != null && rep_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Rep db_object = new Rep();
        String[][] select = { {"rep_rzao",null} };
        Object[][] where = { {"rep_cdgo","like",rep_cdgo}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Rep) results.elementAt(0);
          rep_rzao = (db_object.getRep_rzao() != null) ? db_object.getRep_rzao() + "":"";
        } else {
          rep_rzao = "";
        }
      }
    } catch (Exception e) {
      rep_rzao = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return rep_rzao;
  }

  public String[][] getRep_rzao_Ajax(Sbr0101ActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getRep_cdgo() != null && PARAM.getRep_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Rep db_object = new Rep();
        Object[][] where = { {"rep_cdgo","like",PARAM.getRep_cdgo()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Rep) results.elementAt(0);
          list[0] = new String[]{"rep_rzao", (db_object.getRep_rzao() != null) ? db_object.getRep_rzao() + "":""};
        } else {
          list[0] = new String[]{"rep_rzao", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"rep_rzao", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * REP_RZAO: Método Sets pára este campo.
    */
  public void setRep_rzao(String PARAM) {
    rep_rzao = PARAM;
  }
  /**
    * CLI_CDGO: Método Gets para este campo
    */
  public String getCli_cdgo() {
    return cli_cdgo;
  }
  /**
    * CLI_CDGO: Método Sets pára este campo.
    */
  public void setCli_cdgo(String PARAM) {
    cli_cdgo = PARAM;
  }
  /**
    * CLI_RZAO: Método Gets para este campo
    */
  public String getCli_rzao() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (cli_cdgo != null && cli_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cli db_object = new Cli();
        String[][] select = { {"cli_rzao",null} };
        Object[][] where = { {"cli_cdgo","=",com.egen.util.text.FormatNumber.toInt(cli_cdgo)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Cli) results.elementAt(0);
          cli_rzao = (db_object.getCli_rzao() != null) ? db_object.getCli_rzao() + "":"";
        } else {
          cli_rzao = "";
        }
      }
    } catch (Exception e) {
      cli_rzao = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return cli_rzao;
  }

  public String[][] getCli_rzao_Ajax(Sbr0101ActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCli_cdgo() != null && PARAM.getCli_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cli db_object = new Cli();
        Object[][] where = { {"cli_cdgo","=", PARAM.getCli_cdgo()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Cli) results.elementAt(0);
          list[0] = new String[]{"cli_rzao", (db_object.getCli_rzao() != null) ? db_object.getCli_rzao() + "":""};
        } else {
          list[0] = new String[]{"cli_rzao", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"cli_rzao", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * CLI_RZAO: Método Sets pára este campo.
    */
  public void setCli_rzao(String PARAM) {
    cli_rzao = PARAM;
  }
  /**
    * PAIS: Método Gets para este campo
    */
  public String getPais() {
    return pais;
  }
  /**
    * PAIS: Método Sets pára este campo.
    */
  public void setPais(String PARAM) {
    pais = PARAM;
  }
  /**
    * ABRE_MARCA: Método Gets para este campo
    */
  public String getAbre_marca() {
    return abre_marca;
  }
  /**
    * ABRE_MARCA: Método Sets pára este campo.
    */
  public void setAbre_marca(String PARAM) {
    abre_marca = PARAM;
  }
  Vector abre_marcaList = new Vector(10, 1);
  public java.util.Vector getAbre_marcaList() {
    if (abre_marcaList == null || abre_marcaList.size() == 0) {
      abre_marcaList.addElement("S");
      abre_marcaLabelList.addElement("Somente quebra por Marcas");
      abre_marcaList.addElement("N");
      abre_marcaLabelList.addElement("Sem quebra por Marcas");
      abre_marcaList.addElement("T");
      abre_marcaLabelList.addElement("Ambos");
    }
    java.util.Vector list = abre_marcaList;
    return list;
  }
  java.util.Vector abre_marcaLabelList = new Vector(10, 1);
  public java.util.Vector getAbre_marcaLabelList() {
    java.util.Vector list = abre_marcaLabelList;
    return list;
  }
  /**
    * CB_SOMENTE_PP: Método Gets para este campo
    */
  public String getCb_somente_pp() {
    return cb_somente_pp;
  }
  /**
    * CB_SOMENTE_PP: Método Sets pára este campo.
    */
  public void setCb_somente_pp(String PARAM) {
    cb_somente_pp = PARAM;
  }
  /**
    * OBJETIVO: Método Gets para este campo
    */
  public String getObjetivo() {
    return objetivo;
  }
  /**
    * OBJETIVO: Método Sets pára este campo.
    */
  public void setObjetivo(String PARAM) {
    objetivo = PARAM;
  }
  /**
    * VISAO: Método Gets para este campo
    */
  public String getVisao() {
    return visao;
  }
  /**
    * VISAO: Método Sets pára este campo.
    */
  public void setVisao(String PARAM) {
    visao = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    periodo = null;
    abertura = null;
    tipo_mercado = null;
    codigo_regional = null;
    nome_regional = null;
    rep_cdgo = null;
    rep_rzao = null;
    cli_cdgo = null;
    cli_rzao = null;
    pais = null;
    abre_marca = null;
    cb_somente_pp = null;
    objetivo = null;
    visao = null;
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
      if (com.egen.util.text.Validate.isNull(periodo)) {
        errors.add("periodo", new ActionMessage("error.validate.notnull","Período","periodo","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
