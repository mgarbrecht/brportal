package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 09/08/2017 14:56:43
 * Last Modify Date 03/02/2021 13:43:28
 */

public class Cli0030ActionForm extends org.apache.struts.action.ActionForm
{
  public String ped_dadg_ini;
  public String ped_dadg_fim;
  public String codigo_regional;
  public String nome_regional;
  public String rep_cdgo;
  public String rep_rzao;
  public String reg_cdgo;
  public String reg_nome;
  public String estado;
  public String estado_descricao;
  public String municipio;
  public String clientes;
  public String grupos;
  public String adimplente;
  public String agrupamento;
  public String codigo_municipio;
  public String codigo_ibge;
  public String cb_nao_abrir_municipios;
  private boolean valida = false;
  public Cli0030ActionForm() {
  }
  /**
    * PED_DADG_INI: Method to get the field value.
    */
  public String getPed_dadg_ini() {
    return ped_dadg_ini;
  }
  /**
    * PED_DADG_INI: Method to set the field value.
    */
  public void setPed_dadg_ini(String PARAM) {
    ped_dadg_ini = PARAM;
  }
  /**
    * PED_DADG_FIM: Method to get the field value.
    */
  public String getPed_dadg_fim() {
    return ped_dadg_fim;
  }
  /**
    * PED_DADG_FIM: Method to set the field value.
    */
  public void setPed_dadg_fim(String PARAM) {
    ped_dadg_fim = PARAM;
  }
  /**
    * CODIGO_REGIONAL: Method to get the field value.
    */
  public String getCodigo_regional() {
    return codigo_regional;
  }
  /**
    * CODIGO_REGIONAL: Method to set the field value.
    */
  public void setCodigo_regional(String PARAM) {
    codigo_regional = PARAM;
  }
  /**
    * NOME_REGIONAL: Method to get the field value.
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

  public String[][] getNome_regional_Ajax(Cli0030ActionForm PARAM) {
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
    * NOME_REGIONAL: Method to set the field value.
    */
  public void setNome_regional(String PARAM) {
    nome_regional = PARAM;
  }
  /**
    * REP_CDGO: Method to get the field value.
    */
  public String getRep_cdgo() {
    return rep_cdgo;
  }
  /**
    * REP_CDGO: Method to set the field value.
    */
  public void setRep_cdgo(String PARAM) {
    rep_cdgo = PARAM;
  }
  /**
    * REP_RZAO: Method to get the field value.
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

  public String[][] getRep_rzao_Ajax(Cli0030ActionForm PARAM) {
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
    * REP_RZAO: Method to set the field value.
    */
  public void setRep_rzao(String PARAM) {
    rep_rzao = PARAM;
  }
  /**
    * REG_CDGO: Method to get the field value.
    */
  public String getReg_cdgo() {
    return reg_cdgo;
  }
  /**
    * REG_CDGO: Method to set the field value.
    */
  public void setReg_cdgo(String PARAM) {
    reg_cdgo = PARAM;
  }
  /**
    * REG_NOME: Method to get the field value.
    */
  public String getReg_nome() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (reg_cdgo != null && reg_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Reg db_object = new Reg();
        String[][] select = { {"reg_nome",null} };
        Object[][] where = { {"reg_cdgo","like",reg_cdgo}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Reg) results.elementAt(0);
          reg_nome = (db_object.getReg_nome() != null) ? db_object.getReg_nome() + "":"";
        } else {
          reg_nome = "";
        }
      }
    } catch (Exception e) {
      reg_nome = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return reg_nome;
  }

  public String[][] getReg_nome_Ajax(Cli0030ActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getReg_cdgo() != null && PARAM.getReg_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Reg db_object = new Reg();
        Object[][] where = { {"reg_cdgo","like",PARAM.getReg_cdgo()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Reg) results.elementAt(0);
          list[0] = new String[]{"reg_nome", (db_object.getReg_nome() != null) ? db_object.getReg_nome() + "":""};
        } else {
          list[0] = new String[]{"reg_nome", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"reg_nome", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * REG_NOME: Method to set the field value.
    */
  public void setReg_nome(String PARAM) {
    reg_nome = PARAM;
  }
  /**
    * ESTADO: Method to get the field value.
    */
  public String getEstado() {
    return estado;
  }
  /**
    * ESTADO: Method to set the field value.
    */
  public void setEstado(String PARAM) {
    estado = PARAM;
  }
  /**
    * ESTADO_DESCRICAO: Method to get the field value.
    */
  public String getEstado_descricao() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (estado != null && estado.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Estados db_object = new Estados();
        String[][] select = { {"est_descri",null} };
        Object[][] where = { {"est_unifed","like",estado}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Estados) results.elementAt(0);
          estado_descricao = ((db_object.getEst_descri() != null) ? db_object.getEst_descri() + "":"");
        } else {
          estado_descricao = "";
        }
      }
    } catch (Exception e) {
      estado_descricao = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return estado_descricao;
  }

  public String[][] getEstado_descricao_Ajax(Cli0030ActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getEstado() != null && PARAM.getEstado().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Estados db_object = new Estados();
        Object[][] where = { {"est_unifed","like",PARAM.getEstado()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Estados) results.elementAt(0);
          list[0] = new String[]{"estado_descricao", ((db_object.getEst_descri() != null) ? db_object.getEst_descri() + "":"")};
        } else {
          list[0] = new String[]{"estado_descricao", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"estado_descricao", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * ESTADO_DESCRICAO: Method to set the field value.
    */
  public void setEstado_descricao(String PARAM) {
    estado_descricao = PARAM;
  }
  /**
    * MUNICIPIO: Method to get the field value.
    */
  public String getMunicipio() {
    return municipio;
  }
  /**
    * MUNICIPIO: Method to set the field value.
    */
  public void setMunicipio(String PARAM) {
    municipio = PARAM;
  }
  /**
    * CLIENTES: Method to get the field value.
    */
  public String getClientes() {
    return clientes;
  }
  /**
    * CLIENTES: Method to set the field value.
    */
  public void setClientes(String PARAM) {
    clientes = PARAM;
  }
  /**
    * GRUPOS: Method to get the field value.
    */
  public String getGrupos() {
    return grupos;
  }
  /**
    * GRUPOS: Method to set the field value.
    */
  public void setGrupos(String PARAM) {
    grupos = PARAM;
  }
  /**
    * ADIMPLENTE: Method to get the field value.
    */
  public String getAdimplente() {
    return adimplente;
  }
  /**
    * ADIMPLENTE: Method to set the field value.
    */
  public void setAdimplente(String PARAM) {
    adimplente = PARAM;
  }
  /**
    * AGRUPAMENTO: Method to get the field value.
    */
  public String getAgrupamento() {
    return agrupamento;
  }
  /**
    * AGRUPAMENTO: Method to set the field value.
    */
  public void setAgrupamento(String PARAM) {
    agrupamento = PARAM;
  }
  /**
    * CODIGO_MUNICIPIO: Method to get the field value.
    */
  public String getCodigo_municipio() {
    return codigo_municipio;
  }
  /**
    * CODIGO_MUNICIPIO: Method to set the field value.
    */
  public void setCodigo_municipio(String PARAM) {
    codigo_municipio = PARAM;
  }
  /**
    * CODIGO_IBGE: Method to get the field value.
    */
  public String getCodigo_ibge() {
    return codigo_ibge;
  }
  /**
    * CODIGO_IBGE: Method to set the field value.
    */
  public void setCodigo_ibge(String PARAM) {
    codigo_ibge = PARAM;
  }
  /**
    * CB_NAO_ABRIR_MUNICIPIOS: Method to get the field value.
    */
  public String getCb_nao_abrir_municipios() {
    return cb_nao_abrir_municipios;
  }
  /**
    * CB_NAO_ABRIR_MUNICIPIOS: Method to set the field value.
    */
  public void setCb_nao_abrir_municipios(String PARAM) {
    cb_nao_abrir_municipios = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    ped_dadg_ini = null;
    ped_dadg_fim = null;
    codigo_regional = null;
    nome_regional = null;
    rep_cdgo = null;
    rep_rzao = null;
    reg_cdgo = null;
    reg_nome = null;
    estado = null;
    estado_descricao = null;
    municipio = null;
    clientes = null;
    grupos = null;
    adimplente = null;
    agrupamento = null;
    codigo_municipio = null;
    codigo_ibge = null;
    cb_nao_abrir_municipios = null;
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
      if (com.egen.util.text.Validate.isNull(ped_dadg_ini)) {
        errors.add("ped_dadg_ini", new ActionMessage("error.validate.notnull","Data Digitação Inicial","ped_dadg_ini","0"));
      }
      if (com.egen.util.text.Validate.isNull(ped_dadg_fim)) {
        errors.add("ped_dadg_fim", new ActionMessage("error.validate.notnull","Data Digitação Final","ped_dadg_fim","0"));
      }
      if (estado != null && estado.length() > 0) {
        this.setEstado(estado.toUpperCase());
      }
      if (municipio != null && municipio.length() > 0) {
        this.setMunicipio(municipio.toUpperCase());
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
